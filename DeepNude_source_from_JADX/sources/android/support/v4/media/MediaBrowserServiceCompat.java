package android.support.v4.media;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.service.media.MediaBrowserService;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import android.support.v4.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy;
import android.support.v4.media.MediaSessionManager.RemoteUserInfo;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.os.ResultReceiver;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class MediaBrowserServiceCompat extends Service {
    static final boolean DEBUG = Log.isLoggable(TAG, 3);
    private static final float EPSILON = 1.0E-5f;
    public static final String KEY_MEDIA_ITEM = "media_item";
    public static final String KEY_SEARCH_RESULTS = "search_results";
    public static final int RESULT_ERROR = -1;
    static final int RESULT_FLAG_ON_LOAD_ITEM_NOT_IMPLEMENTED = 2;
    static final int RESULT_FLAG_ON_SEARCH_NOT_IMPLEMENTED = 4;
    static final int RESULT_FLAG_OPTION_NOT_HANDLED = 1;
    public static final int RESULT_OK = 0;
    public static final int RESULT_PROGRESS_UPDATE = 1;
    public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
    static final String TAG = "MBServiceCompat";
    final ArrayMap<IBinder, ConnectionRecord> mConnections = new ArrayMap();
    ConnectionRecord mCurConnection;
    final ServiceHandler mHandler = new ServiceHandler();
    private MediaBrowserServiceImpl mImpl;
    Token mSession;

    public static final class BrowserRoot {
        public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
        public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
        public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";
        @Deprecated
        public static final String EXTRA_SUGGESTION_KEYWORDS = "android.service.media.extra.SUGGESTION_KEYWORDS";
        private final Bundle mExtras;
        private final String mRootId;

        public BrowserRoot(String str, Bundle bundle) {
            if (str != null) {
                this.mRootId = str;
                this.mExtras = bundle;
                return;
            }
            throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public String getRootId() {
            return this.mRootId;
        }
    }

    private class ConnectionRecord implements DeathRecipient {
        public final RemoteUserInfo browserInfo;
        public final ServiceCallbacks callbacks;
        public final int pid;
        public final String pkg;
        public BrowserRoot root;
        public final Bundle rootHints;
        public final HashMap<String, List<Pair<IBinder, Bundle>>> subscriptions = new HashMap();
        public final int uid;

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$ConnectionRecord$1 */
        class C01271 implements Runnable {
            C01271() {
            }

            public void run() {
                ConnectionRecord connectionRecord = ConnectionRecord.this;
                MediaBrowserServiceCompat.this.mConnections.remove(connectionRecord.callbacks.asBinder());
            }
        }

        ConnectionRecord(String str, int i, int i2, Bundle bundle, ServiceCallbacks serviceCallbacks) {
            this.pkg = str;
            this.pid = i;
            this.uid = i2;
            this.browserInfo = new RemoteUserInfo(str, i, i2);
            this.rootHints = bundle;
            this.callbacks = serviceCallbacks;
        }

        public void binderDied() {
            MediaBrowserServiceCompat.this.mHandler.post(new C01271());
        }
    }

    interface MediaBrowserServiceImpl {
        Bundle getBrowserRootHints();

        RemoteUserInfo getCurrentBrowserInfo();

        void notifyChildrenChanged(RemoteUserInfo remoteUserInfo, String str, Bundle bundle);

        void notifyChildrenChanged(String str, Bundle bundle);

        IBinder onBind(Intent intent);

        void onCreate();

        void setSessionToken(Token token);
    }

    public static class Result<T> {
        private final Object mDebug;
        private boolean mDetachCalled;
        private int mFlags;
        private boolean mSendErrorCalled;
        private boolean mSendProgressUpdateCalled;
        private boolean mSendResultCalled;

        Result(Object obj) {
            this.mDebug = obj;
        }

        private void checkExtraFields(Bundle bundle) {
            if (bundle != null) {
                String str = MediaBrowserCompat.EXTRA_DOWNLOAD_PROGRESS;
                if (bundle.containsKey(str)) {
                    float f = bundle.getFloat(str);
                    if (f < -1.0E-5f || f > 1.00001f) {
                        throw new IllegalArgumentException("The value of the EXTRA_DOWNLOAD_PROGRESS field must be a float number within [0.0, 1.0].");
                    }
                }
            }
        }

        public void detach() {
            StringBuilder stringBuilder;
            if (this.mDetachCalled) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("detach() called when detach() had already been called for: ");
                stringBuilder.append(this.mDebug);
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.mSendResultCalled) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("detach() called when sendResult() had already been called for: ");
                stringBuilder.append(this.mDebug);
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.mSendErrorCalled) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("detach() called when sendError() had already been called for: ");
                stringBuilder.append(this.mDebug);
                throw new IllegalStateException(stringBuilder.toString());
            } else {
                this.mDetachCalled = true;
            }
        }

        int getFlags() {
            return this.mFlags;
        }

        boolean isDone() {
            if (!(this.mDetachCalled || this.mSendResultCalled)) {
                if (!this.mSendErrorCalled) {
                    return false;
                }
            }
            return true;
        }

        void onErrorSent(Bundle bundle) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("It is not supported to send an error for ");
            stringBuilder.append(this.mDebug);
            throw new UnsupportedOperationException(stringBuilder.toString());
        }

        void onProgressUpdateSent(Bundle bundle) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("It is not supported to send an interim update for ");
            stringBuilder.append(this.mDebug);
            throw new UnsupportedOperationException(stringBuilder.toString());
        }

        void onResultSent(T t) {
        }

        public void sendError(Bundle bundle) {
            if (this.mSendResultCalled || this.mSendErrorCalled) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("sendError() called when either sendResult() or sendError() had already been called for: ");
                stringBuilder.append(this.mDebug);
                throw new IllegalStateException(stringBuilder.toString());
            }
            this.mSendErrorCalled = true;
            onErrorSent(bundle);
        }

        public void sendProgressUpdate(Bundle bundle) {
            if (this.mSendResultCalled || this.mSendErrorCalled) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: ");
                stringBuilder.append(this.mDebug);
                throw new IllegalStateException(stringBuilder.toString());
            }
            checkExtraFields(bundle);
            this.mSendProgressUpdateCalled = true;
            onProgressUpdateSent(bundle);
        }

        public void sendResult(T t) {
            if (this.mSendResultCalled || this.mSendErrorCalled) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("sendResult() called when either sendResult() or sendError() had already been called for: ");
                stringBuilder.append(this.mDebug);
                throw new IllegalStateException(stringBuilder.toString());
            }
            this.mSendResultCalled = true;
            onResultSent(t);
        }

        void setFlags(int i) {
            this.mFlags = i;
        }
    }

    private class ServiceBinderImpl {
        ServiceBinderImpl() {
        }

        public void addSubscription(String str, IBinder iBinder, Bundle bundle, ServiceCallbacks serviceCallbacks) {
            final ServiceCallbacks serviceCallbacks2 = serviceCallbacks;
            final String str2 = str;
            final IBinder iBinder2 = iBinder;
            final Bundle bundle2 = bundle;
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                public void run() {
                    ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(serviceCallbacks2.asBinder());
                    if (connectionRecord == null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("addSubscription for callback that isn't registered id=");
                        stringBuilder.append(str2);
                        Log.w(MediaBrowserServiceCompat.TAG, stringBuilder.toString());
                        return;
                    }
                    MediaBrowserServiceCompat.this.addSubscription(str2, connectionRecord, iBinder2, bundle2);
                }
            });
        }

        public void connect(String str, int i, int i2, Bundle bundle, ServiceCallbacks serviceCallbacks) {
            if (MediaBrowserServiceCompat.this.isValidPackage(str, i2)) {
                final ServiceCallbacks serviceCallbacks2 = serviceCallbacks;
                final String str2 = str;
                final int i3 = i;
                final int i4 = i2;
                final Bundle bundle2 = bundle;
                MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                    public void run() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
                        /*
                        r9 = this;
                        r0 = r3;
                        r0 = r0.asBinder();
                        r1 = android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.this;
                        r1 = android.support.v4.media.MediaBrowserServiceCompat.this;
                        r1 = r1.mConnections;
                        r1.remove(r0);
                        r1 = new android.support.v4.media.MediaBrowserServiceCompat$ConnectionRecord;
                        r2 = android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.this;
                        r3 = android.support.v4.media.MediaBrowserServiceCompat.this;
                        r4 = r4;
                        r5 = r5;
                        r6 = r6;
                        r7 = r7;
                        r8 = r3;
                        r2 = r1;
                        r2.<init>(r4, r5, r6, r7, r8);
                        r2 = android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.this;
                        r2 = android.support.v4.media.MediaBrowserServiceCompat.this;
                        r2.mCurConnection = r1;
                        r3 = r4;
                        r4 = r6;
                        r5 = r7;
                        r2 = r2.onGetRoot(r3, r4, r5);
                        r1.root = r2;
                        r2 = android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.this;
                        r2 = android.support.v4.media.MediaBrowserServiceCompat.this;
                        r3 = 0;
                        r2.mCurConnection = r3;
                        r3 = r1.root;
                        r4 = "MBServiceCompat";
                        if (r3 != 0) goto L_0x0083;
                    L_0x0042:
                        r0 = new java.lang.StringBuilder;
                        r0.<init>();
                        r1 = "No root for client ";
                        r0.append(r1);
                        r1 = r4;
                        r0.append(r1);
                        r1 = " from service ";
                        r0.append(r1);
                        r1 = android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.C01341.class;
                        r1 = r1.getName();
                        r0.append(r1);
                        r0 = r0.toString();
                        android.util.Log.i(r4, r0);
                        r0 = r3;	 Catch:{ RemoteException -> 0x006c }
                        r0.onConnectFailed();	 Catch:{ RemoteException -> 0x006c }
                        goto L_0x00cb;
                    L_0x006c:
                        r0 = new java.lang.StringBuilder;
                        r0.<init>();
                        r1 = "Calling onConnectFailed() failed. Ignoring. pkg=";
                        r0.append(r1);
                        r1 = r4;
                        r0.append(r1);
                        r0 = r0.toString();
                        android.util.Log.w(r4, r0);
                        goto L_0x00cb;
                    L_0x0083:
                        r2 = r2.mConnections;	 Catch:{ RemoteException -> 0x00ac }
                        r2.put(r0, r1);	 Catch:{ RemoteException -> 0x00ac }
                        r2 = 0;	 Catch:{ RemoteException -> 0x00ac }
                        r0.linkToDeath(r1, r2);	 Catch:{ RemoteException -> 0x00ac }
                        r2 = android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.this;	 Catch:{ RemoteException -> 0x00ac }
                        r2 = android.support.v4.media.MediaBrowserServiceCompat.this;	 Catch:{ RemoteException -> 0x00ac }
                        r2 = r2.mSession;	 Catch:{ RemoteException -> 0x00ac }
                        if (r2 == 0) goto L_0x00cb;	 Catch:{ RemoteException -> 0x00ac }
                    L_0x0094:
                        r2 = r3;	 Catch:{ RemoteException -> 0x00ac }
                        r3 = r1.root;	 Catch:{ RemoteException -> 0x00ac }
                        r3 = r3.getRootId();	 Catch:{ RemoteException -> 0x00ac }
                        r5 = android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.this;	 Catch:{ RemoteException -> 0x00ac }
                        r5 = android.support.v4.media.MediaBrowserServiceCompat.this;	 Catch:{ RemoteException -> 0x00ac }
                        r5 = r5.mSession;	 Catch:{ RemoteException -> 0x00ac }
                        r1 = r1.root;	 Catch:{ RemoteException -> 0x00ac }
                        r1 = r1.getExtras();	 Catch:{ RemoteException -> 0x00ac }
                        r2.onConnect(r3, r5, r1);	 Catch:{ RemoteException -> 0x00ac }
                        goto L_0x00cb;
                    L_0x00ac:
                        r1 = new java.lang.StringBuilder;
                        r1.<init>();
                        r2 = "Calling onConnect() failed. Dropping client. pkg=";
                        r1.append(r2);
                        r2 = r4;
                        r1.append(r2);
                        r1 = r1.toString();
                        android.util.Log.w(r4, r1);
                        r1 = android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.this;
                        r1 = android.support.v4.media.MediaBrowserServiceCompat.this;
                        r1 = r1.mConnections;
                        r1.remove(r0);
                    L_0x00cb:
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.1.run():void");
                    }
                });
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Package/uid mismatch: uid=");
            stringBuilder.append(i2);
            stringBuilder.append(" package=");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        public void disconnect(final ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                public void run() {
                    ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.remove(serviceCallbacks.asBinder());
                    if (connectionRecord != null) {
                        connectionRecord.callbacks.asBinder().unlinkToDeath(connectionRecord, 0);
                    }
                }
            });
        }

        public void getMediaItem(final String str, final ResultReceiver resultReceiver, final ServiceCallbacks serviceCallbacks) {
            if (!TextUtils.isEmpty(str)) {
                if (resultReceiver != null) {
                    MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                        public void run() {
                            ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(serviceCallbacks.asBinder());
                            if (connectionRecord == null) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("getMediaItem for callback that isn't registered id=");
                                stringBuilder.append(str);
                                Log.w(MediaBrowserServiceCompat.TAG, stringBuilder.toString());
                                return;
                            }
                            MediaBrowserServiceCompat.this.performLoadItem(str, connectionRecord, resultReceiver);
                        }
                    });
                }
            }
        }

        public void registerCallbacks(ServiceCallbacks serviceCallbacks, String str, int i, int i2, Bundle bundle) {
            final ServiceCallbacks serviceCallbacks2 = serviceCallbacks;
            final String str2 = str;
            final int i3 = i;
            final int i4 = i2;
            final Bundle bundle2 = bundle;
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                public void run() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
                    /*
                    r9 = this;
                    r0 = r3;
                    r0 = r0.asBinder();
                    r1 = android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.this;
                    r1 = android.support.v4.media.MediaBrowserServiceCompat.this;
                    r1 = r1.mConnections;
                    r1.remove(r0);
                    r1 = new android.support.v4.media.MediaBrowserServiceCompat$ConnectionRecord;
                    r2 = android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.this;
                    r3 = android.support.v4.media.MediaBrowserServiceCompat.this;
                    r4 = r4;
                    r5 = r5;
                    r6 = r6;
                    r7 = r7;
                    r8 = r3;
                    r2 = r1;
                    r2.<init>(r4, r5, r6, r7, r8);
                    r2 = android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.this;
                    r2 = android.support.v4.media.MediaBrowserServiceCompat.this;
                    r2 = r2.mConnections;
                    r2.put(r0, r1);
                    r2 = 0;
                    r0.linkToDeath(r1, r2);	 Catch:{ RemoteException -> 0x0031 }
                    goto L_0x0038;
                L_0x0031:
                    r0 = "MBServiceCompat";
                    r1 = "IBinder is already dead.";
                    android.util.Log.w(r0, r1);
                L_0x0038:
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.6.run():void");
                }
            });
        }

        public void removeSubscription(final String str, final IBinder iBinder, final ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                public void run() {
                    ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(serviceCallbacks.asBinder());
                    String str = MediaBrowserServiceCompat.TAG;
                    if (connectionRecord == null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("removeSubscription for callback that isn't registered id=");
                        stringBuilder.append(str);
                        Log.w(str, stringBuilder.toString());
                        return;
                    }
                    if (!MediaBrowserServiceCompat.this.removeSubscription(str, connectionRecord, iBinder)) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("removeSubscription called for ");
                        stringBuilder.append(str);
                        stringBuilder.append(" which is not subscribed");
                        Log.w(str, stringBuilder.toString());
                    }
                }
            });
        }

        public void search(String str, Bundle bundle, ResultReceiver resultReceiver, ServiceCallbacks serviceCallbacks) {
            if (!TextUtils.isEmpty(str)) {
                if (resultReceiver != null) {
                    final ServiceCallbacks serviceCallbacks2 = serviceCallbacks;
                    final String str2 = str;
                    final Bundle bundle2 = bundle;
                    final ResultReceiver resultReceiver2 = resultReceiver;
                    MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                        public void run() {
                            ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(serviceCallbacks2.asBinder());
                            if (connectionRecord == null) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("search for callback that isn't registered query=");
                                stringBuilder.append(str2);
                                Log.w(MediaBrowserServiceCompat.TAG, stringBuilder.toString());
                                return;
                            }
                            MediaBrowserServiceCompat.this.performSearch(str2, bundle2, connectionRecord, resultReceiver2);
                        }
                    });
                }
            }
        }

        public void sendCustomAction(String str, Bundle bundle, ResultReceiver resultReceiver, ServiceCallbacks serviceCallbacks) {
            if (!TextUtils.isEmpty(str)) {
                if (resultReceiver != null) {
                    final ServiceCallbacks serviceCallbacks2 = serviceCallbacks;
                    final String str2 = str;
                    final Bundle bundle2 = bundle;
                    final ResultReceiver resultReceiver2 = resultReceiver;
                    MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                        public void run() {
                            ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(serviceCallbacks2.asBinder());
                            if (connectionRecord == null) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("sendCustomAction for callback that isn't registered action=");
                                stringBuilder.append(str2);
                                stringBuilder.append(", extras=");
                                stringBuilder.append(bundle2);
                                Log.w(MediaBrowserServiceCompat.TAG, stringBuilder.toString());
                                return;
                            }
                            MediaBrowserServiceCompat.this.performCustomAction(str2, bundle2, connectionRecord, resultReceiver2);
                        }
                    });
                }
            }
        }

        public void unregisterCallbacks(final ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                public void run() {
                    IBinder asBinder = serviceCallbacks.asBinder();
                    ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.remove(asBinder);
                    if (connectionRecord != null) {
                        asBinder.unlinkToDeath(connectionRecord, 0);
                    }
                }
            });
        }
    }

    private interface ServiceCallbacks {
        IBinder asBinder();

        void onConnect(String str, Token token, Bundle bundle);

        void onConnectFailed();

        void onLoadChildren(String str, List<MediaItem> list, Bundle bundle, Bundle bundle2);
    }

    private final class ServiceHandler extends Handler {
        private final ServiceBinderImpl mServiceBinderImpl = new ServiceBinderImpl();

        ServiceHandler() {
        }

        public void handleMessage(Message message) {
            Bundle data = message.getData();
            int i = message.what;
            String str = MediaBrowserProtocol.DATA_CALLBACK_TOKEN;
            String str2 = MediaBrowserProtocol.DATA_CALLING_UID;
            String str3 = MediaBrowserProtocol.DATA_CALLING_PID;
            String str4 = MediaBrowserProtocol.DATA_PACKAGE_NAME;
            String str5 = MediaBrowserProtocol.DATA_ROOT_HINTS;
            String str6 = MediaBrowserProtocol.DATA_RESULT_RECEIVER;
            String str7 = MediaBrowserProtocol.DATA_MEDIA_ITEM_ID;
            Bundle bundle;
            switch (i) {
                case 1:
                    Bundle bundle2 = data.getBundle(str5);
                    MediaSessionCompat.ensureClassLoader(bundle2);
                    this.mServiceBinderImpl.connect(data.getString(str4), data.getInt(str3), data.getInt(str2), bundle2, new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 2:
                    this.mServiceBinderImpl.disconnect(new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 3:
                    bundle = data.getBundle(MediaBrowserProtocol.DATA_OPTIONS);
                    MediaSessionCompat.ensureClassLoader(bundle);
                    this.mServiceBinderImpl.addSubscription(data.getString(str7), BundleCompat.getBinder(data, str), bundle, new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 4:
                    this.mServiceBinderImpl.removeSubscription(data.getString(str7), BundleCompat.getBinder(data, str), new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 5:
                    this.mServiceBinderImpl.getMediaItem(data.getString(str7), (ResultReceiver) data.getParcelable(str6), new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 6:
                    Bundle bundle3 = data.getBundle(str5);
                    MediaSessionCompat.ensureClassLoader(bundle3);
                    this.mServiceBinderImpl.registerCallbacks(new ServiceCallbacksCompat(message.replyTo), data.getString(str4), data.getInt(str3), data.getInt(str2), bundle3);
                    return;
                case 7:
                    this.mServiceBinderImpl.unregisterCallbacks(new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 8:
                    bundle = data.getBundle(MediaBrowserProtocol.DATA_SEARCH_EXTRAS);
                    MediaSessionCompat.ensureClassLoader(bundle);
                    this.mServiceBinderImpl.search(data.getString(MediaBrowserProtocol.DATA_SEARCH_QUERY), bundle, (ResultReceiver) data.getParcelable(str6), new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 9:
                    bundle = data.getBundle(MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS);
                    MediaSessionCompat.ensureClassLoader(bundle);
                    this.mServiceBinderImpl.sendCustomAction(data.getString(MediaBrowserProtocol.DATA_CUSTOM_ACTION), bundle, (ResultReceiver) data.getParcelable(str6), new ServiceCallbacksCompat(message.replyTo));
                    return;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unhandled message: ");
                    stringBuilder.append(message);
                    stringBuilder.append("\n  Service version: ");
                    stringBuilder.append(2);
                    stringBuilder.append("\n  Client version: ");
                    stringBuilder.append(message.arg1);
                    Log.w(MediaBrowserServiceCompat.TAG, stringBuilder.toString());
                    return;
            }
        }

        public void postOrRun(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        public boolean sendMessageAtTime(Message message, long j) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt(MediaBrowserProtocol.DATA_CALLING_UID, Binder.getCallingUid());
            data.putInt(MediaBrowserProtocol.DATA_CALLING_PID, Binder.getCallingPid());
            return super.sendMessageAtTime(message, j);
        }
    }

    class MediaBrowserServiceImplApi21 implements MediaBrowserServiceImpl, ServiceCompatProxy {
        Messenger mMessenger;
        final List<Bundle> mRootExtrasList = new ArrayList();
        Object mServiceObj;

        MediaBrowserServiceImplApi21() {
        }

        public Bundle getBrowserRootHints() {
            Bundle bundle = null;
            if (this.mMessenger == null) {
                return null;
            }
            ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.mCurConnection;
            if (connectionRecord != null) {
                Bundle bundle2 = connectionRecord.rootHints;
                if (bundle2 != null) {
                    bundle = new Bundle(bundle2);
                }
                return bundle;
            }
            throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        public RemoteUserInfo getCurrentBrowserInfo() {
            ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.mCurConnection;
            if (connectionRecord != null) {
                return connectionRecord.browserInfo;
            }
            throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        public void notifyChildrenChanged(RemoteUserInfo remoteUserInfo, String str, Bundle bundle) {
            notifyChildrenChangedForCompat(remoteUserInfo, str, bundle);
        }

        public void notifyChildrenChanged(String str, Bundle bundle) {
            notifyChildrenChangedForFramework(str, bundle);
            notifyChildrenChangedForCompat(str, bundle);
        }

        void notifyChildrenChangedForCompat(final RemoteUserInfo remoteUserInfo, final String str, final Bundle bundle) {
            MediaBrowserServiceCompat.this.mHandler.post(new Runnable() {
                public void run() {
                    for (int i = 0; i < MediaBrowserServiceCompat.this.mConnections.size(); i++) {
                        ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.valueAt(i);
                        if (connectionRecord.browserInfo.equals(remoteUserInfo)) {
                            MediaBrowserServiceImplApi21.this.notifyChildrenChangedForCompatOnHandler(connectionRecord, str, bundle);
                        }
                    }
                }
            });
        }

        void notifyChildrenChangedForCompat(final String str, final Bundle bundle) {
            MediaBrowserServiceCompat.this.mHandler.post(new Runnable() {
                public void run() {
                    for (IBinder iBinder : MediaBrowserServiceCompat.this.mConnections.keySet()) {
                        MediaBrowserServiceImplApi21.this.notifyChildrenChangedForCompatOnHandler((ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(iBinder), str, bundle);
                    }
                }
            });
        }

        void notifyChildrenChangedForCompatOnHandler(ConnectionRecord connectionRecord, String str, Bundle bundle) {
            List<Pair> list = (List) connectionRecord.subscriptions.get(str);
            if (list != null) {
                for (Pair pair : list) {
                    if (MediaBrowserCompatUtils.hasDuplicatedItems(bundle, (Bundle) pair.second)) {
                        MediaBrowserServiceCompat.this.performLoadChildren(str, connectionRecord, (Bundle) pair.second, bundle);
                    }
                }
            }
        }

        void notifyChildrenChangedForFramework(String str, Bundle bundle) {
            MediaBrowserServiceCompatApi21.notifyChildrenChanged(this.mServiceObj, str);
        }

        public IBinder onBind(Intent intent) {
            return MediaBrowserServiceCompatApi21.onBind(this.mServiceObj, intent);
        }

        public void onCreate() {
            this.mServiceObj = MediaBrowserServiceCompatApi21.createService(MediaBrowserServiceCompat.this, this);
            MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
        }

        public BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
            Bundle bundle2;
            MediaBrowserServiceCompat mediaBrowserServiceCompat;
            BrowserRoot onGetRoot;
            if (bundle != null) {
                String str2 = MediaBrowserProtocol.EXTRA_CLIENT_VERSION;
                if (bundle.getInt(str2, 0) != 0) {
                    bundle.remove(str2);
                    this.mMessenger = new Messenger(MediaBrowserServiceCompat.this.mHandler);
                    bundle2 = new Bundle();
                    bundle2.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 2);
                    BundleCompat.putBinder(bundle2, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER, this.mMessenger.getBinder());
                    Token token = MediaBrowserServiceCompat.this.mSession;
                    if (token != null) {
                        IInterface extraBinder = token.getExtraBinder();
                        BundleCompat.putBinder(bundle2, MediaBrowserProtocol.EXTRA_SESSION_BINDER, extraBinder == null ? null : extraBinder.asBinder());
                    } else {
                        this.mRootExtrasList.add(bundle2);
                    }
                    mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                    mediaBrowserServiceCompat.mCurConnection = new ConnectionRecord(str, -1, i, bundle, null);
                    onGetRoot = MediaBrowserServiceCompat.this.onGetRoot(str, i, bundle);
                    MediaBrowserServiceCompat.this.mCurConnection = null;
                    if (onGetRoot == null) {
                        return null;
                    }
                    if (bundle2 == null) {
                        bundle2 = onGetRoot.getExtras();
                    } else if (onGetRoot.getExtras() != null) {
                        bundle2.putAll(onGetRoot.getExtras());
                    }
                    return new BrowserRoot(onGetRoot.getRootId(), bundle2);
                }
            }
            bundle2 = null;
            mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.mCurConnection = new ConnectionRecord(str, -1, i, bundle, null);
            onGetRoot = MediaBrowserServiceCompat.this.onGetRoot(str, i, bundle);
            MediaBrowserServiceCompat.this.mCurConnection = null;
            if (onGetRoot == null) {
                return null;
            }
            if (bundle2 == null) {
                bundle2 = onGetRoot.getExtras();
            } else if (onGetRoot.getExtras() != null) {
                bundle2.putAll(onGetRoot.getExtras());
            }
            return new BrowserRoot(onGetRoot.getRootId(), bundle2);
        }

        public void onLoadChildren(String str, final ResultWrapper<List<Parcel>> resultWrapper) {
            MediaBrowserServiceCompat.this.onLoadChildren(str, new Result<List<MediaItem>>(str) {
                public void detach() {
                    resultWrapper.detach();
                }

                void onResultSent(List<MediaItem> list) {
                    Object arrayList;
                    if (list != null) {
                        arrayList = new ArrayList();
                        for (MediaItem mediaItem : list) {
                            Parcel obtain = Parcel.obtain();
                            mediaItem.writeToParcel(obtain, 0);
                            arrayList.add(obtain);
                        }
                    } else {
                        arrayList = null;
                    }
                    resultWrapper.sendResult(arrayList);
                }
            });
        }

        public void setSessionToken(final Token token) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                public void run() {
                    if (!MediaBrowserServiceImplApi21.this.mRootExtrasList.isEmpty()) {
                        IInterface extraBinder = token.getExtraBinder();
                        if (extraBinder != null) {
                            for (Bundle putBinder : MediaBrowserServiceImplApi21.this.mRootExtrasList) {
                                BundleCompat.putBinder(putBinder, MediaBrowserProtocol.EXTRA_SESSION_BINDER, extraBinder.asBinder());
                            }
                        }
                        MediaBrowserServiceImplApi21.this.mRootExtrasList.clear();
                    }
                    MediaBrowserServiceCompatApi21.setSessionToken(MediaBrowserServiceImplApi21.this.mServiceObj, token.getToken());
                }
            });
        }
    }

    class MediaBrowserServiceImplBase implements MediaBrowserServiceImpl {
        private Messenger mMessenger;

        MediaBrowserServiceImplBase() {
        }

        public Bundle getBrowserRootHints() {
            ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.mCurConnection;
            if (connectionRecord != null) {
                Bundle bundle = connectionRecord.rootHints;
                return bundle == null ? null : new Bundle(bundle);
            } else {
                throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            }
        }

        public RemoteUserInfo getCurrentBrowserInfo() {
            ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.mCurConnection;
            if (connectionRecord != null) {
                return connectionRecord.browserInfo;
            }
            throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        public void notifyChildrenChanged(final RemoteUserInfo remoteUserInfo, final String str, final Bundle bundle) {
            MediaBrowserServiceCompat.this.mHandler.post(new Runnable() {
                public void run() {
                    for (int i = 0; i < MediaBrowserServiceCompat.this.mConnections.size(); i++) {
                        ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.valueAt(i);
                        if (connectionRecord.browserInfo.equals(remoteUserInfo)) {
                            MediaBrowserServiceImplBase.this.notifyChildrenChangedOnHandler(connectionRecord, str, bundle);
                            return;
                        }
                    }
                }
            });
        }

        public void notifyChildrenChanged(final String str, final Bundle bundle) {
            MediaBrowserServiceCompat.this.mHandler.post(new Runnable() {
                public void run() {
                    for (IBinder iBinder : MediaBrowserServiceCompat.this.mConnections.keySet()) {
                        MediaBrowserServiceImplBase.this.notifyChildrenChangedOnHandler((ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(iBinder), str, bundle);
                    }
                }
            });
        }

        void notifyChildrenChangedOnHandler(ConnectionRecord connectionRecord, String str, Bundle bundle) {
            List<Pair> list = (List) connectionRecord.subscriptions.get(str);
            if (list != null) {
                for (Pair pair : list) {
                    if (MediaBrowserCompatUtils.hasDuplicatedItems(bundle, (Bundle) pair.second)) {
                        MediaBrowserServiceCompat.this.performLoadChildren(str, connectionRecord, (Bundle) pair.second, bundle);
                    }
                }
            }
        }

        public IBinder onBind(Intent intent) {
            return MediaBrowserServiceCompat.SERVICE_INTERFACE.equals(intent.getAction()) ? this.mMessenger.getBinder() : null;
        }

        public void onCreate() {
            this.mMessenger = new Messenger(MediaBrowserServiceCompat.this.mHandler);
        }

        public void setSessionToken(final Token token) {
            MediaBrowserServiceCompat.this.mHandler.post(new Runnable() {
                public void run() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
                    /*
                    r6 = this;
                    r0 = android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplBase.this;
                    r0 = android.support.v4.media.MediaBrowserServiceCompat.this;
                    r0 = r0.mConnections;
                    r0 = r0.values();
                    r0 = r0.iterator();
                L_0x000e:
                    r1 = r0.hasNext();
                    if (r1 == 0) goto L_0x004f;
                L_0x0014:
                    r1 = r0.next();
                    r1 = (android.support.v4.media.MediaBrowserServiceCompat.ConnectionRecord) r1;
                    r2 = r1.callbacks;	 Catch:{ RemoteException -> 0x002e }
                    r3 = r1.root;	 Catch:{ RemoteException -> 0x002e }
                    r3 = r3.getRootId();	 Catch:{ RemoteException -> 0x002e }
                    r4 = r3;	 Catch:{ RemoteException -> 0x002e }
                    r5 = r1.root;	 Catch:{ RemoteException -> 0x002e }
                    r5 = r5.getExtras();	 Catch:{ RemoteException -> 0x002e }
                    r2.onConnect(r3, r4, r5);	 Catch:{ RemoteException -> 0x002e }
                    goto L_0x000e;
                L_0x002e:
                    r2 = new java.lang.StringBuilder;
                    r2.<init>();
                    r3 = "Connection for ";
                    r2.append(r3);
                    r1 = r1.pkg;
                    r2.append(r1);
                    r1 = " is no longer valid.";
                    r2.append(r1);
                    r1 = r2.toString();
                    r2 = "MBServiceCompat";
                    android.util.Log.w(r2, r1);
                    r0.remove();
                    goto L_0x000e;
                L_0x004f:
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplBase.1.run():void");
                }
            });
        }
    }

    private static class ServiceCallbacksCompat implements ServiceCallbacks {
        final Messenger mCallbacks;

        ServiceCallbacksCompat(Messenger messenger) {
            this.mCallbacks = messenger;
        }

        private void sendRequest(int i, Bundle bundle) {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 2;
            obtain.setData(bundle);
            this.mCallbacks.send(obtain);
        }

        public IBinder asBinder() {
            return this.mCallbacks.getBinder();
        }

        public void onConnect(String str, Token token, Bundle bundle) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 2);
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            bundle2.putParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN, token);
            bundle2.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, bundle);
            sendRequest(1, bundle2);
        }

        public void onConnectFailed() {
            sendRequest(2, null);
        }

        public void onLoadChildren(String str, List<MediaItem> list, Bundle bundle, Bundle bundle2) {
            Bundle bundle3 = new Bundle();
            bundle3.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            bundle3.putBundle(MediaBrowserProtocol.DATA_OPTIONS, bundle);
            bundle3.putBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS, bundle2);
            if (list != null) {
                bundle3.putParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST, list instanceof ArrayList ? (ArrayList) list : new ArrayList(list));
            }
            sendRequest(3, bundle3);
        }
    }

    class MediaBrowserServiceImplApi23 extends MediaBrowserServiceImplApi21 implements MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        MediaBrowserServiceImplApi23() {
            super();
        }

        public void onCreate() {
            this.mServiceObj = MediaBrowserServiceCompatApi23.createService(MediaBrowserServiceCompat.this, this);
            MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
        }

        public void onLoadItem(String str, final ResultWrapper<Parcel> resultWrapper) {
            MediaBrowserServiceCompat.this.onLoadItem(str, new Result<MediaItem>(str) {
                public void detach() {
                    resultWrapper.detach();
                }

                void onResultSent(MediaItem mediaItem) {
                    ResultWrapper resultWrapper;
                    Object obj;
                    if (mediaItem == null) {
                        resultWrapper = resultWrapper;
                        obj = null;
                    } else {
                        obj = Parcel.obtain();
                        mediaItem.writeToParcel(obj, 0);
                        resultWrapper = resultWrapper;
                    }
                    resultWrapper.sendResult(obj);
                }
            });
        }
    }

    class MediaBrowserServiceImplApi26 extends MediaBrowserServiceImplApi23 implements MediaBrowserServiceCompatApi26.ServiceCompatProxy {
        MediaBrowserServiceImplApi26() {
            super();
        }

        public Bundle getBrowserRootHints() {
            ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.mCurConnection;
            if (connectionRecord == null) {
                return MediaBrowserServiceCompatApi26.getBrowserRootHints(this.mServiceObj);
            }
            Bundle bundle = connectionRecord.rootHints;
            return bundle == null ? null : new Bundle(bundle);
        }

        void notifyChildrenChangedForFramework(String str, Bundle bundle) {
            if (bundle != null) {
                MediaBrowserServiceCompatApi26.notifyChildrenChanged(this.mServiceObj, str, bundle);
            } else {
                super.notifyChildrenChangedForFramework(str, bundle);
            }
        }

        public void onCreate() {
            this.mServiceObj = MediaBrowserServiceCompatApi26.createService(MediaBrowserServiceCompat.this, this);
            MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
        }

        public void onLoadChildren(String str, final ResultWrapper resultWrapper, Bundle bundle) {
            MediaBrowserServiceCompat.this.onLoadChildren(str, new Result<List<MediaItem>>(str) {
                public void detach() {
                    resultWrapper.detach();
                }

                void onResultSent(List<MediaItem> list) {
                    List arrayList;
                    if (list != null) {
                        arrayList = new ArrayList();
                        for (MediaItem mediaItem : list) {
                            Parcel obtain = Parcel.obtain();
                            mediaItem.writeToParcel(obtain, 0);
                            arrayList.add(obtain);
                        }
                    } else {
                        arrayList = null;
                    }
                    resultWrapper.sendResult(arrayList, getFlags());
                }
            }, bundle);
        }
    }

    class MediaBrowserServiceImplApi28 extends MediaBrowserServiceImplApi26 {
        MediaBrowserServiceImplApi28() {
            super();
        }

        public RemoteUserInfo getCurrentBrowserInfo() {
            ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.mCurConnection;
            return connectionRecord != null ? connectionRecord.browserInfo : new RemoteUserInfo(((MediaBrowserService) this.mServiceObj).getCurrentBrowserInfo());
        }
    }

    void addSubscription(String str, ConnectionRecord connectionRecord, IBinder iBinder, Bundle bundle) {
        List list = (List) connectionRecord.subscriptions.get(str);
        if (list == null) {
            list = new ArrayList();
        }
        for (Pair pair : r0) {
            if (iBinder == pair.first && MediaBrowserCompatUtils.areSameOptions(bundle, (Bundle) pair.second)) {
                return;
            }
        }
        r0.add(new Pair(iBinder, bundle));
        connectionRecord.subscriptions.put(str, r0);
        performLoadChildren(str, connectionRecord, bundle, null);
        this.mCurConnection = connectionRecord;
        onSubscribe(str, bundle);
        this.mCurConnection = null;
    }

    List<MediaItem> applyOptions(List<MediaItem> list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        int i = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
        int i2 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        if (i == -1 && i2 == -1) {
            return list;
        }
        int i3 = i2 * i;
        int i4 = i3 + i2;
        if (i >= 0 && i2 >= 1) {
            if (i3 < list.size()) {
                if (i4 > list.size()) {
                    i4 = list.size();
                }
                return list.subList(i3, i4);
            }
        }
        return Collections.emptyList();
    }

    public void attachToBaseContext(Context context) {
        attachBaseContext(context);
    }

    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public final Bundle getBrowserRootHints() {
        return this.mImpl.getBrowserRootHints();
    }

    public final RemoteUserInfo getCurrentBrowserInfo() {
        return this.mImpl.getCurrentBrowserInfo();
    }

    public Token getSessionToken() {
        return this.mSession;
    }

    boolean isValidPackage(String str, int i) {
        if (str == null) {
            return false;
        }
        for (String equals : getPackageManager().getPackagesForUid(i)) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void notifyChildrenChanged(RemoteUserInfo remoteUserInfo, String str, Bundle bundle) {
        if (remoteUserInfo == null) {
            throw new IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
        } else if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        } else if (bundle != null) {
            this.mImpl.notifyChildrenChanged(remoteUserInfo, str, bundle);
        } else {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
    }

    public void notifyChildrenChanged(String str) {
        if (str != null) {
            this.mImpl.notifyChildrenChanged(str, null);
            return;
        }
        throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    }

    public void notifyChildrenChanged(String str, Bundle bundle) {
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        } else if (bundle != null) {
            this.mImpl.notifyChildrenChanged(str, bundle);
        } else {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
    }

    public IBinder onBind(Intent intent) {
        return this.mImpl.onBind(intent);
    }

    public void onCreate() {
        super.onCreate();
        int i = VERSION.SDK_INT;
        MediaBrowserServiceImpl mediaBrowserServiceImplApi28 = i >= 28 ? new MediaBrowserServiceImplApi28() : i >= 26 ? new MediaBrowserServiceImplApi26() : i >= 23 ? new MediaBrowserServiceImplApi23() : i >= 21 ? new MediaBrowserServiceImplApi21() : new MediaBrowserServiceImplBase();
        this.mImpl = mediaBrowserServiceImplApi28;
        this.mImpl.onCreate();
    }

    public void onCustomAction(String str, Bundle bundle, Result<Bundle> result) {
        result.sendError(null);
    }

    public abstract BrowserRoot onGetRoot(String str, int i, Bundle bundle);

    public abstract void onLoadChildren(String str, Result<List<MediaItem>> result);

    public void onLoadChildren(String str, Result<List<MediaItem>> result, Bundle bundle) {
        result.setFlags(1);
        onLoadChildren(str, result);
    }

    public void onLoadItem(String str, Result<MediaItem> result) {
        result.setFlags(2);
        result.sendResult(null);
    }

    public void onSearch(String str, Bundle bundle, Result<List<MediaItem>> result) {
        result.setFlags(4);
        result.sendResult(null);
    }

    public void onSubscribe(String str, Bundle bundle) {
    }

    public void onUnsubscribe(String str) {
    }

    void performCustomAction(String str, Bundle bundle, ConnectionRecord connectionRecord, final ResultReceiver resultReceiver) {
        Result c07614 = new Result<Bundle>(str) {
            void onErrorSent(Bundle bundle) {
                resultReceiver.send(-1, bundle);
            }

            void onProgressUpdateSent(Bundle bundle) {
                resultReceiver.send(1, bundle);
            }

            void onResultSent(Bundle bundle) {
                resultReceiver.send(0, bundle);
            }
        };
        this.mCurConnection = connectionRecord;
        onCustomAction(str, bundle, c07614);
        this.mCurConnection = null;
        if (!c07614.isDone()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onCustomAction must call detach() or sendResult() or sendError() before returning for action=");
            stringBuilder.append(str);
            stringBuilder.append(" extras=");
            stringBuilder.append(bundle);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    void performLoadChildren(String str, ConnectionRecord connectionRecord, Bundle bundle, Bundle bundle2) {
        final ConnectionRecord connectionRecord2 = connectionRecord;
        final String str2 = str;
        final Bundle bundle3 = bundle;
        final Bundle bundle4 = bundle2;
        Result c07581 = new Result<List<MediaItem>>(str) {
            void onResultSent(java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> r6) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
                /*
                r5 = this;
                r0 = android.support.v4.media.MediaBrowserServiceCompat.this;
                r0 = r0.mConnections;
                r1 = r3;
                r1 = r1.callbacks;
                r1 = r1.asBinder();
                r0 = r0.get(r1);
                r1 = r3;
                r2 = "MBServiceCompat";
                if (r0 == r1) goto L_0x003d;
            L_0x0016:
                r6 = android.support.v4.media.MediaBrowserServiceCompat.DEBUG;
                if (r6 == 0) goto L_0x003c;
            L_0x001a:
                r6 = new java.lang.StringBuilder;
                r6.<init>();
                r0 = "Not sending onLoadChildren result for connection that has been disconnected. pkg=";
                r6.append(r0);
                r0 = r3;
                r0 = r0.pkg;
                r6.append(r0);
                r0 = " id=";
                r6.append(r0);
                r0 = r4;
                r6.append(r0);
                r6 = r6.toString();
                android.util.Log.d(r2, r6);
            L_0x003c:
                return;
            L_0x003d:
                r0 = r5.getFlags();
                r0 = r0 & 1;
                if (r0 == 0) goto L_0x004d;
            L_0x0045:
                r0 = android.support.v4.media.MediaBrowserServiceCompat.this;
                r1 = r5;
                r6 = r0.applyOptions(r6, r1);
            L_0x004d:
                r0 = r3;	 Catch:{ RemoteException -> 0x005b }
                r0 = r0.callbacks;	 Catch:{ RemoteException -> 0x005b }
                r1 = r4;	 Catch:{ RemoteException -> 0x005b }
                r3 = r5;	 Catch:{ RemoteException -> 0x005b }
                r4 = r6;	 Catch:{ RemoteException -> 0x005b }
                r0.onLoadChildren(r1, r6, r3, r4);	 Catch:{ RemoteException -> 0x005b }
                goto L_0x007d;
            L_0x005b:
                r6 = new java.lang.StringBuilder;
                r6.<init>();
                r0 = "Calling onLoadChildren() failed for id=";
                r6.append(r0);
                r0 = r4;
                r6.append(r0);
                r0 = " package=";
                r6.append(r0);
                r0 = r3;
                r0 = r0.pkg;
                r6.append(r0);
                r6 = r6.toString();
                android.util.Log.w(r2, r6);
            L_0x007d:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserServiceCompat.1.onResultSent(java.util.List):void");
            }
        };
        this.mCurConnection = connectionRecord;
        if (bundle == null) {
            onLoadChildren(str, c07581);
        } else {
            onLoadChildren(str, c07581, bundle);
        }
        this.mCurConnection = null;
        if (!c07581.isDone()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onLoadChildren must call detach() or sendResult() before returning for package=");
            stringBuilder.append(connectionRecord.pkg);
            stringBuilder.append(" id=");
            stringBuilder.append(str);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    void performLoadItem(String str, ConnectionRecord connectionRecord, final ResultReceiver resultReceiver) {
        Result c07592 = new Result<MediaItem>(str) {
            void onResultSent(MediaItem mediaItem) {
                if ((getFlags() & 2) != 0) {
                    resultReceiver.send(-1, null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM, mediaItem);
                resultReceiver.send(0, bundle);
            }
        };
        this.mCurConnection = connectionRecord;
        onLoadItem(str, c07592);
        this.mCurConnection = null;
        if (!c07592.isDone()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onLoadItem must call detach() or sendResult() before returning for id=");
            stringBuilder.append(str);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    void performSearch(String str, Bundle bundle, ConnectionRecord connectionRecord, final ResultReceiver resultReceiver) {
        Result c07603 = new Result<List<MediaItem>>(str) {
            void onResultSent(List<MediaItem> list) {
                if ((getFlags() & 4) == 0) {
                    if (list != null) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS, (Parcelable[]) list.toArray(new MediaItem[0]));
                        resultReceiver.send(0, bundle);
                        return;
                    }
                }
                resultReceiver.send(-1, null);
            }
        };
        this.mCurConnection = connectionRecord;
        onSearch(str, bundle, c07603);
        this.mCurConnection = null;
        if (!c07603.isDone()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onSearch must call detach() or sendResult() before returning for query=");
            stringBuilder.append(str);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    boolean removeSubscription(String str, ConnectionRecord connectionRecord, IBinder iBinder) {
        boolean z = true;
        boolean z2 = false;
        if (iBinder == null) {
            try {
                if (connectionRecord.subscriptions.remove(str) == null) {
                    z = false;
                }
                this.mCurConnection = connectionRecord;
                onUnsubscribe(str);
                this.mCurConnection = null;
                return z;
            } catch (Throwable th) {
                this.mCurConnection = connectionRecord;
                onUnsubscribe(str);
                this.mCurConnection = null;
            }
        } else {
            List list = (List) connectionRecord.subscriptions.get(str);
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (iBinder == ((Pair) it.next()).first) {
                        it.remove();
                        z2 = true;
                    }
                }
                if (list.size() == 0) {
                    connectionRecord.subscriptions.remove(str);
                }
            }
            this.mCurConnection = connectionRecord;
            onUnsubscribe(str);
            this.mCurConnection = null;
            return z2;
        }
    }

    public void setSessionToken(Token token) {
        if (token == null) {
            throw new IllegalArgumentException("Session token may not be null.");
        } else if (this.mSession == null) {
            this.mSession = token;
            this.mImpl.setSessionToken(token);
        } else {
            throw new IllegalStateException("The session token has already been set.");
        }
    }
}
