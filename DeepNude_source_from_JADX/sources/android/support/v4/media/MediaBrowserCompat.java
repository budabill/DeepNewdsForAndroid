package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.os.ResultReceiver;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class MediaBrowserCompat {
    public static final String CUSTOM_ACTION_DOWNLOAD = "android.support.v4.media.action.DOWNLOAD";
    public static final String CUSTOM_ACTION_REMOVE_DOWNLOADED_FILE = "android.support.v4.media.action.REMOVE_DOWNLOADED_FILE";
    static final boolean DEBUG = Log.isLoggable(TAG, 3);
    public static final String EXTRA_DOWNLOAD_PROGRESS = "android.media.browse.extra.DOWNLOAD_PROGRESS";
    public static final String EXTRA_MEDIA_ID = "android.media.browse.extra.MEDIA_ID";
    public static final String EXTRA_PAGE = "android.media.browse.extra.PAGE";
    public static final String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";
    static final String TAG = "MediaBrowserCompat";
    private final MediaBrowserImpl mImpl;

    private static class CallbackHandler extends Handler {
        private final WeakReference<MediaBrowserServiceCallbackImpl> mCallbackImplRef;
        private WeakReference<Messenger> mCallbacksMessengerRef;

        CallbackHandler(MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl) {
            this.mCallbackImplRef = new WeakReference(mediaBrowserServiceCallbackImpl);
        }

        public void handleMessage(android.os.Message r12) {
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
            r11 = this;
            r0 = "MediaBrowserCompat";
            r1 = r11.mCallbacksMessengerRef;
            if (r1 == 0) goto L_0x00ae;
        L_0x0006:
            r1 = r1.get();
            if (r1 == 0) goto L_0x00ae;
        L_0x000c:
            r1 = r11.mCallbackImplRef;
            r1 = r1.get();
            if (r1 != 0) goto L_0x0016;
        L_0x0014:
            goto L_0x00ae;
        L_0x0016:
            r1 = r12.getData();
            android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(r1);
            r2 = r11.mCallbackImplRef;
            r2 = r2.get();
            r2 = (android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl) r2;
            r3 = r11.mCallbacksMessengerRef;
            r3 = r3.get();
            r9 = r3;
            r9 = (android.os.Messenger) r9;
            r10 = 1;
            r3 = r12.what;	 Catch:{ BadParcelableException -> 0x00a1 }
            r4 = "data_media_item_id";
            if (r3 == r10) goto L_0x0088;
        L_0x0035:
            r5 = 2;
            if (r3 == r5) goto L_0x0084;
        L_0x0038:
            r5 = 3;
            if (r3 == r5) goto L_0x0062;
        L_0x003b:
            r1 = new java.lang.StringBuilder;	 Catch:{ BadParcelableException -> 0x00a1 }
            r1.<init>();	 Catch:{ BadParcelableException -> 0x00a1 }
            r3 = "Unhandled message: ";	 Catch:{ BadParcelableException -> 0x00a1 }
            r1.append(r3);	 Catch:{ BadParcelableException -> 0x00a1 }
            r1.append(r12);	 Catch:{ BadParcelableException -> 0x00a1 }
            r3 = "\n  Client version: ";	 Catch:{ BadParcelableException -> 0x00a1 }
            r1.append(r3);	 Catch:{ BadParcelableException -> 0x00a1 }
            r1.append(r10);	 Catch:{ BadParcelableException -> 0x00a1 }
            r3 = "\n  Service version: ";	 Catch:{ BadParcelableException -> 0x00a1 }
            r1.append(r3);	 Catch:{ BadParcelableException -> 0x00a1 }
            r3 = r12.arg1;	 Catch:{ BadParcelableException -> 0x00a1 }
            r1.append(r3);	 Catch:{ BadParcelableException -> 0x00a1 }
            r1 = r1.toString();	 Catch:{ BadParcelableException -> 0x00a1 }
            android.util.Log.w(r0, r1);	 Catch:{ BadParcelableException -> 0x00a1 }
            goto L_0x00ae;	 Catch:{ BadParcelableException -> 0x00a1 }
        L_0x0062:
            r3 = "data_options";	 Catch:{ BadParcelableException -> 0x00a1 }
            r7 = r1.getBundle(r3);	 Catch:{ BadParcelableException -> 0x00a1 }
            android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(r7);	 Catch:{ BadParcelableException -> 0x00a1 }
            r3 = "data_notify_children_changed_options";	 Catch:{ BadParcelableException -> 0x00a1 }
            r8 = r1.getBundle(r3);	 Catch:{ BadParcelableException -> 0x00a1 }
            android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(r8);	 Catch:{ BadParcelableException -> 0x00a1 }
            r5 = r1.getString(r4);	 Catch:{ BadParcelableException -> 0x00a1 }
            r3 = "data_media_item_list";	 Catch:{ BadParcelableException -> 0x00a1 }
            r6 = r1.getParcelableArrayList(r3);	 Catch:{ BadParcelableException -> 0x00a1 }
            r3 = r2;	 Catch:{ BadParcelableException -> 0x00a1 }
            r4 = r9;	 Catch:{ BadParcelableException -> 0x00a1 }
            r3.onLoadChildren(r4, r5, r6, r7, r8);	 Catch:{ BadParcelableException -> 0x00a1 }
            goto L_0x00ae;	 Catch:{ BadParcelableException -> 0x00a1 }
        L_0x0084:
            r2.onConnectionFailed(r9);	 Catch:{ BadParcelableException -> 0x00a1 }
            goto L_0x00ae;	 Catch:{ BadParcelableException -> 0x00a1 }
        L_0x0088:
            r3 = "data_root_hints";	 Catch:{ BadParcelableException -> 0x00a1 }
            r3 = r1.getBundle(r3);	 Catch:{ BadParcelableException -> 0x00a1 }
            android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(r3);	 Catch:{ BadParcelableException -> 0x00a1 }
            r4 = r1.getString(r4);	 Catch:{ BadParcelableException -> 0x00a1 }
            r5 = "data_media_session_token";	 Catch:{ BadParcelableException -> 0x00a1 }
            r1 = r1.getParcelable(r5);	 Catch:{ BadParcelableException -> 0x00a1 }
            r1 = (android.support.v4.media.session.MediaSessionCompat.Token) r1;	 Catch:{ BadParcelableException -> 0x00a1 }
            r2.onServiceConnected(r9, r4, r1, r3);	 Catch:{ BadParcelableException -> 0x00a1 }
            goto L_0x00ae;
            r1 = "Could not unparcel the data.";
            android.util.Log.e(r0, r1);
            r12 = r12.what;
            if (r12 != r10) goto L_0x00ae;
        L_0x00ab:
            r2.onConnectionFailed(r9);
        L_0x00ae:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.CallbackHandler.handleMessage(android.os.Message):void");
        }

        void setCallbacksMessenger(Messenger messenger) {
            this.mCallbacksMessengerRef = new WeakReference(messenger);
        }
    }

    public static class ConnectionCallback {
        ConnectionCallbackInternal mConnectionCallbackInternal;
        final Object mConnectionCallbackObj;

        interface ConnectionCallbackInternal {
            void onConnected();

            void onConnectionFailed();

            void onConnectionSuspended();
        }

        private class StubApi21 implements ConnectionCallback {
            StubApi21() {
            }

            public void onConnected() {
                ConnectionCallbackInternal connectionCallbackInternal = ConnectionCallback.this.mConnectionCallbackInternal;
                if (connectionCallbackInternal != null) {
                    connectionCallbackInternal.onConnected();
                }
                ConnectionCallback.this.onConnected();
            }

            public void onConnectionFailed() {
                ConnectionCallbackInternal connectionCallbackInternal = ConnectionCallback.this.mConnectionCallbackInternal;
                if (connectionCallbackInternal != null) {
                    connectionCallbackInternal.onConnectionFailed();
                }
                ConnectionCallback.this.onConnectionFailed();
            }

            public void onConnectionSuspended() {
                ConnectionCallbackInternal connectionCallbackInternal = ConnectionCallback.this.mConnectionCallbackInternal;
                if (connectionCallbackInternal != null) {
                    connectionCallbackInternal.onConnectionSuspended();
                }
                ConnectionCallback.this.onConnectionSuspended();
            }
        }

        public ConnectionCallback() {
            this.mConnectionCallbackObj = VERSION.SDK_INT >= 21 ? MediaBrowserCompatApi21.createConnectionCallback(new StubApi21()) : null;
        }

        public void onConnected() {
        }

        public void onConnectionFailed() {
        }

        public void onConnectionSuspended() {
        }

        void setInternalConnectionCallback(ConnectionCallbackInternal connectionCallbackInternal) {
            this.mConnectionCallbackInternal = connectionCallbackInternal;
        }
    }

    public static abstract class CustomActionCallback {
        public void onError(String str, Bundle bundle, Bundle bundle2) {
        }

        public void onProgressUpdate(String str, Bundle bundle, Bundle bundle2) {
        }

        public void onResult(String str, Bundle bundle, Bundle bundle2) {
        }
    }

    public static abstract class ItemCallback {
        final Object mItemCallbackObj;

        private class StubApi23 implements ItemCallback {
            StubApi23() {
            }

            public void onError(String str) {
                ItemCallback.this.onError(str);
            }

            public void onItemLoaded(Parcel parcel) {
                ItemCallback itemCallback;
                MediaItem mediaItem;
                if (parcel == null) {
                    itemCallback = ItemCallback.this;
                    mediaItem = null;
                } else {
                    parcel.setDataPosition(0);
                    mediaItem = (MediaItem) MediaItem.CREATOR.createFromParcel(parcel);
                    parcel.recycle();
                    itemCallback = ItemCallback.this;
                }
                itemCallback.onItemLoaded(mediaItem);
            }
        }

        public ItemCallback() {
            this.mItemCallbackObj = VERSION.SDK_INT >= 23 ? MediaBrowserCompatApi23.createItemCallback(new StubApi23()) : null;
        }

        public void onError(String str) {
        }

        public void onItemLoaded(MediaItem mediaItem) {
        }
    }

    interface MediaBrowserImpl {
        void connect();

        void disconnect();

        Bundle getExtras();

        void getItem(String str, ItemCallback itemCallback);

        Bundle getNotifyChildrenChangedOptions();

        String getRoot();

        ComponentName getServiceComponent();

        Token getSessionToken();

        boolean isConnected();

        void search(String str, Bundle bundle, SearchCallback searchCallback);

        void sendCustomAction(String str, Bundle bundle, CustomActionCallback customActionCallback);

        void subscribe(String str, Bundle bundle, SubscriptionCallback subscriptionCallback);

        void unsubscribe(String str, SubscriptionCallback subscriptionCallback);
    }

    interface MediaBrowserServiceCallbackImpl {
        void onConnectionFailed(Messenger messenger);

        void onLoadChildren(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2);

        void onServiceConnected(Messenger messenger, String str, Token token, Bundle bundle);
    }

    public static class MediaItem implements Parcelable {
        public static final Creator<MediaItem> CREATOR = new C01261();
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;
        private final MediaDescriptionCompat mDescription;
        private final int mFlags;

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaItem$1 */
        static class C01261 implements Creator<MediaItem> {
            C01261() {
            }

            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            public MediaItem[] newArray(int i) {
                return new MediaItem[i];
            }
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface Flags {
        }

        MediaItem(Parcel parcel) {
            this.mFlags = parcel.readInt();
            this.mDescription = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public MediaItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("description cannot be null");
            } else if (TextUtils.isEmpty(mediaDescriptionCompat.getMediaId())) {
                throw new IllegalArgumentException("description must have a non-empty media id");
            } else {
                this.mFlags = i;
                this.mDescription = mediaDescriptionCompat;
            }
        }

        public static MediaItem fromMediaItem(Object obj) {
            if (obj != null) {
                if (VERSION.SDK_INT >= 21) {
                    return new MediaItem(MediaDescriptionCompat.fromMediaDescription(MediaItem.getDescription(obj)), MediaItem.getFlags(obj));
                }
            }
            return null;
        }

        public static List<MediaItem> fromMediaItemList(List<?> list) {
            if (list != null) {
                if (VERSION.SDK_INT >= 21) {
                    List<MediaItem> arrayList = new ArrayList(list.size());
                    for (Object fromMediaItem : list) {
                        arrayList.add(fromMediaItem(fromMediaItem));
                    }
                    return arrayList;
                }
            }
            return null;
        }

        public int describeContents() {
            return 0;
        }

        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public int getFlags() {
            return this.mFlags;
        }

        public String getMediaId() {
            return this.mDescription.getMediaId();
        }

        public boolean isBrowsable() {
            return (this.mFlags & 1) != 0;
        }

        public boolean isPlayable() {
            return (this.mFlags & 2) != 0;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("MediaItem{");
            stringBuilder.append("mFlags=");
            stringBuilder.append(this.mFlags);
            stringBuilder.append(", mDescription=");
            stringBuilder.append(this.mDescription);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mFlags);
            this.mDescription.writeToParcel(parcel, i);
        }
    }

    public static abstract class SearchCallback {
        public void onError(String str, Bundle bundle) {
        }

        public void onSearchResult(String str, Bundle bundle, List<MediaItem> list) {
        }
    }

    private static class ServiceBinderWrapper {
        private Messenger mMessenger;
        private Bundle mRootHints;

        public ServiceBinderWrapper(IBinder iBinder, Bundle bundle) {
            this.mMessenger = new Messenger(iBinder);
            this.mRootHints = bundle;
        }

        private void sendRequest(int i, Bundle bundle, Messenger messenger) {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            obtain.replyTo = messenger;
            this.mMessenger.send(obtain);
        }

        void addSubscription(String str, IBinder iBinder, Bundle bundle, Messenger messenger) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            BundleCompat.putBinder(bundle2, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, iBinder);
            bundle2.putBundle(MediaBrowserProtocol.DATA_OPTIONS, bundle);
            sendRequest(3, bundle2, messenger);
        }

        void connect(Context context, Messenger messenger) {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
            bundle.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.mRootHints);
            sendRequest(1, bundle, messenger);
        }

        void disconnect(Messenger messenger) {
            sendRequest(2, null, messenger);
        }

        void getMediaItem(String str, ResultReceiver resultReceiver, Messenger messenger) {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            bundle.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
            sendRequest(5, bundle, messenger);
        }

        void registerCallbackMessenger(Context context, Messenger messenger) {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
            bundle.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.mRootHints);
            sendRequest(6, bundle, messenger);
        }

        void removeSubscription(String str, IBinder iBinder, Messenger messenger) {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            BundleCompat.putBinder(bundle, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, iBinder);
            sendRequest(4, bundle, messenger);
        }

        void search(String str, Bundle bundle, ResultReceiver resultReceiver, Messenger messenger) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_SEARCH_QUERY, str);
            bundle2.putBundle(MediaBrowserProtocol.DATA_SEARCH_EXTRAS, bundle);
            bundle2.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
            sendRequest(8, bundle2, messenger);
        }

        void sendCustomAction(String str, Bundle bundle, ResultReceiver resultReceiver, Messenger messenger) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_CUSTOM_ACTION, str);
            bundle2.putBundle(MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS, bundle);
            bundle2.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
            sendRequest(9, bundle2, messenger);
        }

        void unregisterCallbackMessenger(Messenger messenger) {
            sendRequest(7, null, messenger);
        }
    }

    private static class Subscription {
        private final List<SubscriptionCallback> mCallbacks = new ArrayList();
        private final List<Bundle> mOptionsList = new ArrayList();

        public SubscriptionCallback getCallback(Bundle bundle) {
            for (int i = 0; i < this.mOptionsList.size(); i++) {
                if (MediaBrowserCompatUtils.areSameOptions((Bundle) this.mOptionsList.get(i), bundle)) {
                    return (SubscriptionCallback) this.mCallbacks.get(i);
                }
            }
            return null;
        }

        public List<SubscriptionCallback> getCallbacks() {
            return this.mCallbacks;
        }

        public List<Bundle> getOptionsList() {
            return this.mOptionsList;
        }

        public boolean isEmpty() {
            return this.mCallbacks.isEmpty();
        }

        public void putCallback(Bundle bundle, SubscriptionCallback subscriptionCallback) {
            for (int i = 0; i < this.mOptionsList.size(); i++) {
                if (MediaBrowserCompatUtils.areSameOptions((Bundle) this.mOptionsList.get(i), bundle)) {
                    this.mCallbacks.set(i, subscriptionCallback);
                    return;
                }
            }
            this.mCallbacks.add(subscriptionCallback);
            this.mOptionsList.add(bundle);
        }
    }

    public static abstract class SubscriptionCallback {
        final Object mSubscriptionCallbackObj;
        WeakReference<Subscription> mSubscriptionRef;
        final IBinder mToken = new Binder();

        private class StubApi21 implements SubscriptionCallback {
            StubApi21() {
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

            public void onChildrenLoaded(String str, List<?> list) {
                WeakReference weakReference = SubscriptionCallback.this.mSubscriptionRef;
                Subscription subscription = weakReference == null ? null : (Subscription) weakReference.get();
                if (subscription == null) {
                    SubscriptionCallback.this.onChildrenLoaded(str, MediaItem.fromMediaItemList(list));
                    return;
                }
                List fromMediaItemList = MediaItem.fromMediaItemList(list);
                List callbacks = subscription.getCallbacks();
                List optionsList = subscription.getOptionsList();
                for (int i = 0; i < callbacks.size(); i++) {
                    Bundle bundle = (Bundle) optionsList.get(i);
                    if (bundle == null) {
                        SubscriptionCallback.this.onChildrenLoaded(str, fromMediaItemList);
                    } else {
                        SubscriptionCallback.this.onChildrenLoaded(str, applyOptions(fromMediaItemList, bundle), bundle);
                    }
                }
            }

            public void onError(String str) {
                SubscriptionCallback.this.onError(str);
            }
        }

        private class StubApi26 extends StubApi21 implements SubscriptionCallback {
            StubApi26() {
                super();
            }

            public void onChildrenLoaded(String str, List<?> list, Bundle bundle) {
                SubscriptionCallback.this.onChildrenLoaded(str, MediaItem.fromMediaItemList(list), bundle);
            }

            public void onError(String str, Bundle bundle) {
                SubscriptionCallback.this.onError(str, bundle);
            }
        }

        public SubscriptionCallback() {
            int i = VERSION.SDK_INT;
            Object createSubscriptionCallback = i >= 26 ? MediaBrowserCompatApi26.createSubscriptionCallback(new StubApi26()) : i >= 21 ? MediaBrowserCompatApi21.createSubscriptionCallback(new StubApi21()) : null;
            this.mSubscriptionCallbackObj = createSubscriptionCallback;
        }

        public void onChildrenLoaded(String str, List<MediaItem> list) {
        }

        public void onChildrenLoaded(String str, List<MediaItem> list, Bundle bundle) {
        }

        public void onError(String str) {
        }

        public void onError(String str, Bundle bundle) {
        }

        void setSubscription(Subscription subscription) {
            this.mSubscriptionRef = new WeakReference(subscription);
        }
    }

    private static class CustomActionResultReceiver extends ResultReceiver {
        private final String mAction;
        private final CustomActionCallback mCallback;
        private final Bundle mExtras;

        CustomActionResultReceiver(String str, Bundle bundle, CustomActionCallback customActionCallback, Handler handler) {
            super(handler);
            this.mAction = str;
            this.mExtras = bundle;
            this.mCallback = customActionCallback;
        }

        protected void onReceiveResult(int i, Bundle bundle) {
            if (this.mCallback != null) {
                MediaSessionCompat.ensureClassLoader(bundle);
                if (i == -1) {
                    this.mCallback.onError(this.mAction, this.mExtras, bundle);
                } else if (i == 0) {
                    this.mCallback.onResult(this.mAction, this.mExtras, bundle);
                } else if (i != 1) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown result code: ");
                    stringBuilder.append(i);
                    stringBuilder.append(" (extras=");
                    stringBuilder.append(this.mExtras);
                    stringBuilder.append(", resultData=");
                    stringBuilder.append(bundle);
                    stringBuilder.append(")");
                    Log.w(MediaBrowserCompat.TAG, stringBuilder.toString());
                } else {
                    this.mCallback.onProgressUpdate(this.mAction, this.mExtras, bundle);
                }
            }
        }
    }

    private static class ItemReceiver extends ResultReceiver {
        private final ItemCallback mCallback;
        private final String mMediaId;

        ItemReceiver(String str, ItemCallback itemCallback, Handler handler) {
            super(handler);
            this.mMediaId = str;
            this.mCallback = itemCallback;
        }

        protected void onReceiveResult(int i, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            if (i == 0 && bundle != null) {
                String str = MediaBrowserServiceCompat.KEY_MEDIA_ITEM;
                if (bundle.containsKey(str)) {
                    Parcelable parcelable = bundle.getParcelable(str);
                    if (parcelable != null) {
                        if (!(parcelable instanceof MediaItem)) {
                            this.mCallback.onError(this.mMediaId);
                            return;
                        }
                    }
                    this.mCallback.onItemLoaded((MediaItem) parcelable);
                    return;
                }
            }
            this.mCallback.onError(this.mMediaId);
        }
    }

    static class MediaBrowserImplApi21 implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl, ConnectionCallbackInternal {
        protected final Object mBrowserObj;
        protected Messenger mCallbacksMessenger;
        final Context mContext;
        protected final CallbackHandler mHandler = new CallbackHandler(this);
        private Token mMediaSessionToken;
        private Bundle mNotifyChildrenChangedOptions;
        protected final Bundle mRootHints;
        protected ServiceBinderWrapper mServiceBinderWrapper;
        protected int mServiceVersion;
        private final ArrayMap<String, Subscription> mSubscriptions = new ArrayMap();

        MediaBrowserImplApi21(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            this.mContext = context;
            this.mRootHints = bundle != null ? new Bundle(bundle) : new Bundle();
            this.mRootHints.putInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 1);
            connectionCallback.setInternalConnectionCallback(this);
            this.mBrowserObj = MediaBrowserCompatApi21.createBrowser(context, componentName, connectionCallback.mConnectionCallbackObj, this.mRootHints);
        }

        public void connect() {
            MediaBrowserCompatApi21.connect(this.mBrowserObj);
        }

        public void disconnect() {
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
            r2 = this;
            r0 = r2.mServiceBinderWrapper;
            if (r0 == 0) goto L_0x0013;
        L_0x0004:
            r1 = r2.mCallbacksMessenger;
            if (r1 == 0) goto L_0x0013;
        L_0x0008:
            r0.unregisterCallbackMessenger(r1);	 Catch:{ RemoteException -> 0x000c }
            goto L_0x0013;
        L_0x000c:
            r0 = "MediaBrowserCompat";
            r1 = "Remote error unregistering client messenger.";
            android.util.Log.i(r0, r1);
        L_0x0013:
            r0 = r2.mBrowserObj;
            android.support.v4.media.MediaBrowserCompatApi21.disconnect(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.disconnect():void");
        }

        public Bundle getExtras() {
            return MediaBrowserCompatApi21.getExtras(this.mBrowserObj);
        }

        public void getItem(final java.lang.String r5, final android.support.v4.media.MediaBrowserCompat.ItemCallback r6) {
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
            r4 = this;
            r0 = android.text.TextUtils.isEmpty(r5);
            if (r0 != 0) goto L_0x0064;
        L_0x0006:
            if (r6 == 0) goto L_0x005c;
        L_0x0008:
            r0 = r4.mBrowserObj;
            r0 = android.support.v4.media.MediaBrowserCompatApi21.isConnected(r0);
            r1 = "MediaBrowserCompat";
            if (r0 != 0) goto L_0x0022;
        L_0x0012:
            r0 = "Not connected, unable to retrieve the MediaItem.";
            android.util.Log.i(r1, r0);
            r0 = r4.mHandler;
            r1 = new android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$1;
            r1.<init>(r6, r5);
        L_0x001e:
            r0.post(r1);
            return;
        L_0x0022:
            r0 = r4.mServiceBinderWrapper;
            if (r0 != 0) goto L_0x002e;
        L_0x0026:
            r0 = r4.mHandler;
            r1 = new android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$2;
            r1.<init>(r6, r5);
            goto L_0x001e;
        L_0x002e:
            r0 = new android.support.v4.media.MediaBrowserCompat$ItemReceiver;
            r2 = r4.mHandler;
            r0.<init>(r5, r6, r2);
            r2 = r4.mServiceBinderWrapper;	 Catch:{ RemoteException -> 0x003d }
            r3 = r4.mCallbacksMessenger;	 Catch:{ RemoteException -> 0x003d }
            r2.getMediaItem(r5, r0, r3);	 Catch:{ RemoteException -> 0x003d }
            goto L_0x005b;
        L_0x003d:
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r2 = "Remote error getting media item: ";
            r0.append(r2);
            r0.append(r5);
            r0 = r0.toString();
            android.util.Log.i(r1, r0);
            r0 = r4.mHandler;
            r1 = new android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$3;
            r1.<init>(r6, r5);
            r0.post(r1);
        L_0x005b:
            return;
        L_0x005c:
            r5 = new java.lang.IllegalArgumentException;
            r6 = "cb is null";
            r5.<init>(r6);
            throw r5;
        L_0x0064:
            r5 = new java.lang.IllegalArgumentException;
            r6 = "mediaId is empty";
            r5.<init>(r6);
            goto L_0x006d;
        L_0x006c:
            throw r5;
        L_0x006d:
            goto L_0x006c;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.getItem(java.lang.String, android.support.v4.media.MediaBrowserCompat$ItemCallback):void");
        }

        public Bundle getNotifyChildrenChangedOptions() {
            return this.mNotifyChildrenChangedOptions;
        }

        public String getRoot() {
            return MediaBrowserCompatApi21.getRoot(this.mBrowserObj);
        }

        public ComponentName getServiceComponent() {
            return MediaBrowserCompatApi21.getServiceComponent(this.mBrowserObj);
        }

        public Token getSessionToken() {
            if (this.mMediaSessionToken == null) {
                this.mMediaSessionToken = Token.fromToken(MediaBrowserCompatApi21.getSessionToken(this.mBrowserObj));
            }
            return this.mMediaSessionToken;
        }

        public boolean isConnected() {
            return MediaBrowserCompatApi21.isConnected(this.mBrowserObj);
        }

        public void onConnected() {
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
            r4 = this;
            r0 = r4.mBrowserObj;
            r0 = android.support.v4.media.MediaBrowserCompatApi21.getExtras(r0);
            if (r0 != 0) goto L_0x0009;
        L_0x0008:
            return;
        L_0x0009:
            r1 = 0;
            r2 = "extra_service_version";
            r1 = r0.getInt(r2, r1);
            r4.mServiceVersion = r1;
            r1 = "extra_messenger";
            r1 = android.support.v4.app.BundleCompat.getBinder(r0, r1);
            if (r1 == 0) goto L_0x0044;
        L_0x001a:
            r2 = new android.support.v4.media.MediaBrowserCompat$ServiceBinderWrapper;
            r3 = r4.mRootHints;
            r2.<init>(r1, r3);
            r4.mServiceBinderWrapper = r2;
            r1 = new android.os.Messenger;
            r2 = r4.mHandler;
            r1.<init>(r2);
            r4.mCallbacksMessenger = r1;
            r1 = r4.mHandler;
            r2 = r4.mCallbacksMessenger;
            r1.setCallbacksMessenger(r2);
            r1 = r4.mServiceBinderWrapper;	 Catch:{ RemoteException -> 0x003d }
            r2 = r4.mContext;	 Catch:{ RemoteException -> 0x003d }
            r3 = r4.mCallbacksMessenger;	 Catch:{ RemoteException -> 0x003d }
            r1.registerCallbackMessenger(r2, r3);	 Catch:{ RemoteException -> 0x003d }
            goto L_0x0044;
        L_0x003d:
            r1 = "MediaBrowserCompat";
            r2 = "Remote error registering client messenger.";
            android.util.Log.i(r1, r2);
        L_0x0044:
            r1 = "extra_session_binder";
            r0 = android.support.v4.app.BundleCompat.getBinder(r0, r1);
            r0 = android.support.v4.media.session.IMediaSession.Stub.asInterface(r0);
            if (r0 == 0) goto L_0x005c;
        L_0x0050:
            r1 = r4.mBrowserObj;
            r1 = android.support.v4.media.MediaBrowserCompatApi21.getSessionToken(r1);
            r0 = android.support.v4.media.session.MediaSessionCompat.Token.fromToken(r1, r0);
            r4.mMediaSessionToken = r0;
        L_0x005c:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.onConnected():void");
        }

        public void onConnectionFailed() {
        }

        public void onConnectionFailed(Messenger messenger) {
        }

        public void onConnectionSuspended() {
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mMediaSessionToken = null;
            this.mHandler.setCallbacksMessenger(null);
        }

        public void onLoadChildren(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            if (this.mCallbacksMessenger == messenger) {
                Subscription subscription = (Subscription) this.mSubscriptions.get(str);
                if (subscription == null) {
                    if (MediaBrowserCompat.DEBUG) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("onLoadChildren for id that isn't subscribed id=");
                        stringBuilder.append(str);
                        Log.d(MediaBrowserCompat.TAG, stringBuilder.toString());
                    }
                    return;
                }
                SubscriptionCallback callback = subscription.getCallback(bundle);
                if (callback != null) {
                    if (bundle == null) {
                        if (list == null) {
                            callback.onError(str);
                        } else {
                            this.mNotifyChildrenChangedOptions = bundle2;
                            callback.onChildrenLoaded(str, list);
                        }
                    } else if (list == null) {
                        callback.onError(str, bundle);
                    } else {
                        this.mNotifyChildrenChangedOptions = bundle2;
                        callback.onChildrenLoaded(str, list, bundle);
                    }
                    this.mNotifyChildrenChangedOptions = null;
                }
            }
        }

        public void onServiceConnected(Messenger messenger, String str, Token token, Bundle bundle) {
        }

        public void search(final String str, final Bundle bundle, final SearchCallback searchCallback) {
            if (isConnected()) {
                ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
                String str2 = MediaBrowserCompat.TAG;
                if (serviceBinderWrapper == null) {
                    Log.i(str2, "The connected service doesn't support search.");
                    this.mHandler.post(new Runnable() {
                        public void run() {
                            searchCallback.onError(str, bundle);
                        }
                    });
                    return;
                }
                try {
                    this.mServiceBinderWrapper.search(str, bundle, new SearchResultReceiver(str, bundle, searchCallback, this.mHandler), this.mCallbacksMessenger);
                } catch (Throwable e) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Remote error searching items with query: ");
                    stringBuilder.append(str);
                    Log.i(str2, stringBuilder.toString(), e);
                    this.mHandler.post(new Runnable() {
                        public void run() {
                            searchCallback.onError(str, bundle);
                        }
                    });
                }
                return;
            }
            throw new IllegalStateException("search() called while not connected");
        }

        public void sendCustomAction(final String str, final Bundle bundle, final CustomActionCallback customActionCallback) {
            if (isConnected()) {
                ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
                String str2 = MediaBrowserCompat.TAG;
                if (serviceBinderWrapper == null) {
                    Log.i(str2, "The connected service doesn't support sendCustomAction.");
                    if (customActionCallback != null) {
                        this.mHandler.post(new Runnable() {
                            public void run() {
                                customActionCallback.onError(str, bundle, null);
                            }
                        });
                    }
                }
                try {
                    this.mServiceBinderWrapper.sendCustomAction(str, bundle, new CustomActionResultReceiver(str, bundle, customActionCallback, this.mHandler), this.mCallbacksMessenger);
                    return;
                } catch (Throwable e) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Remote error sending a custom action: action=");
                    stringBuilder.append(str);
                    stringBuilder.append(", extras=");
                    stringBuilder.append(bundle);
                    Log.i(str2, stringBuilder.toString(), e);
                    if (customActionCallback != null) {
                        this.mHandler.post(new Runnable() {
                            public void run() {
                                customActionCallback.onError(str, bundle, null);
                            }
                        });
                        return;
                    }
                    return;
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Cannot send a custom action (");
            stringBuilder2.append(str);
            stringBuilder2.append(") with ");
            stringBuilder2.append("extras ");
            stringBuilder2.append(bundle);
            stringBuilder2.append(" because the browser is not connected to the ");
            stringBuilder2.append("service.");
            throw new IllegalStateException(stringBuilder2.toString());
        }

        public void subscribe(java.lang.String r3, android.os.Bundle r4, android.support.v4.media.MediaBrowserCompat.SubscriptionCallback r5) {
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
            r2 = this;
            r0 = r2.mSubscriptions;
            r0 = r0.get(r3);
            r0 = (android.support.v4.media.MediaBrowserCompat.Subscription) r0;
            if (r0 != 0) goto L_0x0014;
        L_0x000a:
            r0 = new android.support.v4.media.MediaBrowserCompat$Subscription;
            r0.<init>();
            r1 = r2.mSubscriptions;
            r1.put(r3, r0);
        L_0x0014:
            r5.setSubscription(r0);
            if (r4 != 0) goto L_0x001b;
        L_0x0019:
            r4 = 0;
            goto L_0x0021;
        L_0x001b:
            r1 = new android.os.Bundle;
            r1.<init>(r4);
            r4 = r1;
        L_0x0021:
            r0.putCallback(r4, r5);
            r0 = r2.mServiceBinderWrapper;
            if (r0 != 0) goto L_0x0030;
        L_0x0028:
            r4 = r2.mBrowserObj;
            r5 = r5.mSubscriptionCallbackObj;
            android.support.v4.media.MediaBrowserCompatApi21.subscribe(r4, r3, r5);
            goto L_0x004e;
        L_0x0030:
            r5 = r5.mToken;	 Catch:{ RemoteException -> 0x0038 }
            r1 = r2.mCallbacksMessenger;	 Catch:{ RemoteException -> 0x0038 }
            r0.addSubscription(r3, r5, r4, r1);	 Catch:{ RemoteException -> 0x0038 }
            goto L_0x004e;
        L_0x0038:
            r4 = new java.lang.StringBuilder;
            r4.<init>();
            r5 = "Remote error subscribing media item: ";
            r4.append(r5);
            r4.append(r3);
            r3 = r4.toString();
            r4 = "MediaBrowserCompat";
            android.util.Log.i(r4, r3);
        L_0x004e:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.subscribe(java.lang.String, android.os.Bundle, android.support.v4.media.MediaBrowserCompat$SubscriptionCallback):void");
        }

        public void unsubscribe(java.lang.String r8, android.support.v4.media.MediaBrowserCompat.SubscriptionCallback r9) {
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
            r7 = this;
            r0 = r7.mSubscriptions;
            r0 = r0.get(r8);
            r0 = (android.support.v4.media.MediaBrowserCompat.Subscription) r0;
            if (r0 != 0) goto L_0x000b;
        L_0x000a:
            return;
        L_0x000b:
            r1 = r7.mServiceBinderWrapper;
            if (r1 != 0) goto L_0x003d;
        L_0x000f:
            if (r9 != 0) goto L_0x0017;
        L_0x0011:
            r1 = r7.mBrowserObj;
            android.support.v4.media.MediaBrowserCompatApi21.unsubscribe(r1, r8);
            goto L_0x0084;
        L_0x0017:
            r1 = r0.getCallbacks();
            r2 = r0.getOptionsList();
            r3 = r1.size();
            r3 = r3 + -1;
        L_0x0025:
            if (r3 < 0) goto L_0x0036;
        L_0x0027:
            r4 = r1.get(r3);
            if (r4 != r9) goto L_0x0033;
        L_0x002d:
            r1.remove(r3);
            r2.remove(r3);
        L_0x0033:
            r3 = r3 + -1;
            goto L_0x0025;
        L_0x0036:
            r1 = r1.size();
            if (r1 != 0) goto L_0x0084;
        L_0x003c:
            goto L_0x0011;
        L_0x003d:
            if (r9 != 0) goto L_0x0046;
        L_0x003f:
            r2 = 0;
            r3 = r7.mCallbacksMessenger;	 Catch:{ RemoteException -> 0x006e }
            r1.removeSubscription(r8, r2, r3);	 Catch:{ RemoteException -> 0x006e }
            goto L_0x0084;	 Catch:{ RemoteException -> 0x006e }
        L_0x0046:
            r1 = r0.getCallbacks();	 Catch:{ RemoteException -> 0x006e }
            r2 = r0.getOptionsList();	 Catch:{ RemoteException -> 0x006e }
            r3 = r1.size();	 Catch:{ RemoteException -> 0x006e }
            r3 = r3 + -1;	 Catch:{ RemoteException -> 0x006e }
        L_0x0054:
            if (r3 < 0) goto L_0x0084;	 Catch:{ RemoteException -> 0x006e }
        L_0x0056:
            r4 = r1.get(r3);	 Catch:{ RemoteException -> 0x006e }
            if (r4 != r9) goto L_0x006b;	 Catch:{ RemoteException -> 0x006e }
        L_0x005c:
            r4 = r7.mServiceBinderWrapper;	 Catch:{ RemoteException -> 0x006e }
            r5 = r9.mToken;	 Catch:{ RemoteException -> 0x006e }
            r6 = r7.mCallbacksMessenger;	 Catch:{ RemoteException -> 0x006e }
            r4.removeSubscription(r8, r5, r6);	 Catch:{ RemoteException -> 0x006e }
            r1.remove(r3);	 Catch:{ RemoteException -> 0x006e }
            r2.remove(r3);	 Catch:{ RemoteException -> 0x006e }
        L_0x006b:
            r3 = r3 + -1;
            goto L_0x0054;
        L_0x006e:
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = "removeSubscription failed with RemoteException parentId=";
            r1.append(r2);
            r1.append(r8);
            r1 = r1.toString();
            r2 = "MediaBrowserCompat";
            android.util.Log.d(r2, r1);
        L_0x0084:
            r0 = r0.isEmpty();
            if (r0 != 0) goto L_0x008c;
        L_0x008a:
            if (r9 != 0) goto L_0x0091;
        L_0x008c:
            r9 = r7.mSubscriptions;
            r9.remove(r8);
        L_0x0091:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.unsubscribe(java.lang.String, android.support.v4.media.MediaBrowserCompat$SubscriptionCallback):void");
        }
    }

    static class MediaBrowserImplBase implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl {
        static final int CONNECT_STATE_CONNECTED = 3;
        static final int CONNECT_STATE_CONNECTING = 2;
        static final int CONNECT_STATE_DISCONNECTED = 1;
        static final int CONNECT_STATE_DISCONNECTING = 0;
        static final int CONNECT_STATE_SUSPENDED = 4;
        final ConnectionCallback mCallback;
        Messenger mCallbacksMessenger;
        final Context mContext;
        private Bundle mExtras;
        final CallbackHandler mHandler = new CallbackHandler(this);
        private Token mMediaSessionToken;
        private Bundle mNotifyChildrenChangedOptions;
        final Bundle mRootHints;
        private String mRootId;
        ServiceBinderWrapper mServiceBinderWrapper;
        final ComponentName mServiceComponent;
        MediaServiceConnection mServiceConnection;
        int mState = 1;
        private final ArrayMap<String, Subscription> mSubscriptions = new ArrayMap();

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$1 */
        class C01181 implements Runnable {
            C01181() {
            }

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
                r0 = "MediaBrowserCompat";
                r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                r2 = r1.mState;
                if (r2 != 0) goto L_0x0009;
            L_0x0008:
                return;
            L_0x0009:
                r2 = 2;
                r1.mState = r2;
                r2 = android.support.v4.media.MediaBrowserCompat.DEBUG;
                if (r2 == 0) goto L_0x0030;
            L_0x0010:
                r1 = r1.mServiceConnection;
                if (r1 != 0) goto L_0x0015;
            L_0x0014:
                goto L_0x0030;
            L_0x0015:
                r0 = new java.lang.RuntimeException;
                r1 = new java.lang.StringBuilder;
                r1.<init>();
                r2 = "mServiceConnection should be null. Instead it is ";
                r1.append(r2);
                r2 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                r2 = r2.mServiceConnection;
                r1.append(r2);
                r1 = r1.toString();
                r0.<init>(r1);
                throw r0;
            L_0x0030:
                r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                r2 = r1.mServiceBinderWrapper;
                if (r2 != 0) goto L_0x00b0;
            L_0x0036:
                r1 = r1.mCallbacksMessenger;
                if (r1 != 0) goto L_0x0095;
            L_0x003a:
                r1 = new android.content.Intent;
                r2 = "android.media.browse.MediaBrowserService";
                r1.<init>(r2);
                r2 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                r2 = r2.mServiceComponent;
                r1.setComponent(r2);
                r2 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                r3 = new android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection;
                r3.<init>();
                r2.mServiceConnection = r3;
                r2 = 0;
                r3 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;	 Catch:{ Exception -> 0x0060 }
                r3 = r3.mContext;	 Catch:{ Exception -> 0x0060 }
                r4 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;	 Catch:{ Exception -> 0x0060 }
                r4 = r4.mServiceConnection;	 Catch:{ Exception -> 0x0060 }
                r5 = 1;	 Catch:{ Exception -> 0x0060 }
                r2 = r3.bindService(r1, r4, r5);	 Catch:{ Exception -> 0x0060 }
                goto L_0x0078;
            L_0x0060:
                r1 = new java.lang.StringBuilder;
                r1.<init>();
                r3 = "Failed binding to service ";
                r1.append(r3);
                r3 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                r3 = r3.mServiceComponent;
                r1.append(r3);
                r1 = r1.toString();
                android.util.Log.e(r0, r1);
            L_0x0078:
                if (r2 != 0) goto L_0x0086;
            L_0x007a:
                r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                r1.forceCloseConnection();
                r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                r1 = r1.mCallback;
                r1.onConnectionFailed();
            L_0x0086:
                r1 = android.support.v4.media.MediaBrowserCompat.DEBUG;
                if (r1 == 0) goto L_0x0094;
            L_0x008a:
                r1 = "connect...";
                android.util.Log.d(r0, r1);
                r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                r0.dump();
            L_0x0094:
                return;
            L_0x0095:
                r0 = new java.lang.RuntimeException;
                r1 = new java.lang.StringBuilder;
                r1.<init>();
                r2 = "mCallbacksMessenger should be null. Instead it is ";
                r1.append(r2);
                r2 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                r2 = r2.mCallbacksMessenger;
                r1.append(r2);
                r1 = r1.toString();
                r0.<init>(r1);
                throw r0;
            L_0x00b0:
                r0 = new java.lang.RuntimeException;
                r1 = new java.lang.StringBuilder;
                r1.<init>();
                r2 = "mServiceBinderWrapper should be null. Instead it is ";
                r1.append(r2);
                r2 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                r2 = r2.mServiceBinderWrapper;
                r1.append(r2);
                r1 = r1.toString();
                r0.<init>(r1);
                throw r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.1.run():void");
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$2 */
        class C01192 implements Runnable {
            C01192() {
            }

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
                r3 = this;
                r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                r1 = r0.mCallbacksMessenger;
                r2 = "MediaBrowserCompat";
                if (r1 == 0) goto L_0x0026;
            L_0x0008:
                r0 = r0.mServiceBinderWrapper;	 Catch:{ RemoteException -> 0x000e }
                r0.disconnect(r1);	 Catch:{ RemoteException -> 0x000e }
                goto L_0x0026;
            L_0x000e:
                r0 = new java.lang.StringBuilder;
                r0.<init>();
                r1 = "RemoteException during connect for ";
                r0.append(r1);
                r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                r1 = r1.mServiceComponent;
                r0.append(r1);
                r0 = r0.toString();
                android.util.Log.w(r2, r0);
            L_0x0026:
                r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                r1 = r0.mState;
                r0.forceCloseConnection();
                if (r1 == 0) goto L_0x0033;
            L_0x002f:
                r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                r0.mState = r1;
            L_0x0033:
                r0 = android.support.v4.media.MediaBrowserCompat.DEBUG;
                if (r0 == 0) goto L_0x0041;
            L_0x0037:
                r0 = "disconnect...";
                android.util.Log.d(r2, r0);
                r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                r0.dump();
            L_0x0041:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.2.run():void");
            }
        }

        private class MediaServiceConnection implements ServiceConnection {
            MediaServiceConnection() {
            }

            private void postOrRun(Runnable runnable) {
                if (Thread.currentThread() == MediaBrowserImplBase.this.mHandler.getLooper().getThread()) {
                    runnable.run();
                } else {
                    MediaBrowserImplBase.this.mHandler.post(runnable);
                }
            }

            boolean isCurrent(String str) {
                int i;
                MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                if (mediaBrowserImplBase.mServiceConnection == this) {
                    i = mediaBrowserImplBase.mState;
                    if (i != 0) {
                        if (i != 1) {
                            return true;
                        }
                    }
                }
                i = MediaBrowserImplBase.this.mState;
                if (!(i == 0 || i == 1)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(" for ");
                    stringBuilder.append(MediaBrowserImplBase.this.mServiceComponent);
                    stringBuilder.append(" with mServiceConnection=");
                    stringBuilder.append(MediaBrowserImplBase.this.mServiceConnection);
                    stringBuilder.append(" this=");
                    stringBuilder.append(this);
                    Log.i(MediaBrowserCompat.TAG, stringBuilder.toString());
                }
                return false;
            }

            public void onServiceConnected(final ComponentName componentName, final IBinder iBinder) {
                postOrRun(new Runnable() {
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
                        /*
                        r6 = this;
                        r0 = "ServiceCallbacks.onConnect...";
                        r1 = android.support.v4.media.MediaBrowserCompat.DEBUG;
                        r2 = "MediaBrowserCompat";
                        if (r1 == 0) goto L_0x002f;
                    L_0x0008:
                        r1 = new java.lang.StringBuilder;
                        r1.<init>();
                        r3 = "MediaServiceConnection.onServiceConnected name=";
                        r1.append(r3);
                        r3 = r2;
                        r1.append(r3);
                        r3 = " binder=";
                        r1.append(r3);
                        r3 = r3;
                        r1.append(r3);
                        r1 = r1.toString();
                        android.util.Log.d(r2, r1);
                        r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this;
                        r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r1.dump();
                    L_0x002f:
                        r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this;
                        r3 = "onServiceConnected";
                        r1 = r1.isCurrent(r3);
                        if (r1 != 0) goto L_0x003a;
                    L_0x0039:
                        return;
                    L_0x003a:
                        r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this;
                        r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r3 = new android.support.v4.media.MediaBrowserCompat$ServiceBinderWrapper;
                        r4 = r3;
                        r5 = r1.mRootHints;
                        r3.<init>(r4, r5);
                        r1.mServiceBinderWrapper = r3;
                        r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this;
                        r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r3 = new android.os.Messenger;
                        r4 = r1.mHandler;
                        r3.<init>(r4);
                        r1.mCallbacksMessenger = r3;
                        r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this;
                        r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r3 = r1.mHandler;
                        r1 = r1.mCallbacksMessenger;
                        r3.setCallbacksMessenger(r1);
                        r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this;
                        r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r3 = 2;
                        r1.mState = r3;
                        r1 = android.support.v4.media.MediaBrowserCompat.DEBUG;	 Catch:{ RemoteException -> 0x008c }
                        if (r1 == 0) goto L_0x0076;	 Catch:{ RemoteException -> 0x008c }
                    L_0x006c:
                        android.util.Log.d(r2, r0);	 Catch:{ RemoteException -> 0x008c }
                        r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this;	 Catch:{ RemoteException -> 0x008c }
                        r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;	 Catch:{ RemoteException -> 0x008c }
                        r1.dump();	 Catch:{ RemoteException -> 0x008c }
                    L_0x0076:
                        r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this;	 Catch:{ RemoteException -> 0x008c }
                        r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;	 Catch:{ RemoteException -> 0x008c }
                        r1 = r1.mServiceBinderWrapper;	 Catch:{ RemoteException -> 0x008c }
                        r3 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this;	 Catch:{ RemoteException -> 0x008c }
                        r3 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;	 Catch:{ RemoteException -> 0x008c }
                        r3 = r3.mContext;	 Catch:{ RemoteException -> 0x008c }
                        r4 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this;	 Catch:{ RemoteException -> 0x008c }
                        r4 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;	 Catch:{ RemoteException -> 0x008c }
                        r4 = r4.mCallbacksMessenger;	 Catch:{ RemoteException -> 0x008c }
                        r1.connect(r3, r4);	 Catch:{ RemoteException -> 0x008c }
                        goto L_0x00b5;
                        r1 = new java.lang.StringBuilder;
                        r1.<init>();
                        r3 = "RemoteException during connect for ";
                        r1.append(r3);
                        r3 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this;
                        r3 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r3 = r3.mServiceComponent;
                        r1.append(r3);
                        r1 = r1.toString();
                        android.util.Log.w(r2, r1);
                        r1 = android.support.v4.media.MediaBrowserCompat.DEBUG;
                        if (r1 == 0) goto L_0x00b5;
                    L_0x00ab:
                        android.util.Log.d(r2, r0);
                        r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this;
                        r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r0.dump();
                    L_0x00b5:
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.1.run():void");
                    }
                });
            }

            public void onServiceDisconnected(final ComponentName componentName) {
                postOrRun(new Runnable() {
                    public void run() {
                        if (MediaBrowserCompat.DEBUG) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("MediaServiceConnection.onServiceDisconnected name=");
                            stringBuilder.append(componentName);
                            stringBuilder.append(" this=");
                            stringBuilder.append(this);
                            stringBuilder.append(" mServiceConnection=");
                            stringBuilder.append(MediaBrowserImplBase.this.mServiceConnection);
                            Log.d(MediaBrowserCompat.TAG, stringBuilder.toString());
                            MediaBrowserImplBase.this.dump();
                        }
                        if (MediaServiceConnection.this.isCurrent("onServiceDisconnected")) {
                            MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                            mediaBrowserImplBase.mServiceBinderWrapper = null;
                            mediaBrowserImplBase.mCallbacksMessenger = null;
                            mediaBrowserImplBase.mHandler.setCallbacksMessenger(null);
                            mediaBrowserImplBase = MediaBrowserImplBase.this;
                            mediaBrowserImplBase.mState = 4;
                            mediaBrowserImplBase.mCallback.onConnectionSuspended();
                        }
                    }
                });
            }
        }

        public MediaBrowserImplBase(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            if (context == null) {
                throw new IllegalArgumentException("context must not be null");
            } else if (componentName == null) {
                throw new IllegalArgumentException("service component must not be null");
            } else if (connectionCallback != null) {
                this.mContext = context;
                this.mServiceComponent = componentName;
                this.mCallback = connectionCallback;
                this.mRootHints = bundle == null ? null : new Bundle(bundle);
            } else {
                throw new IllegalArgumentException("connection callback must not be null");
            }
        }

        private static String getStateLabel(int i) {
            if (i == 0) {
                return "CONNECT_STATE_DISCONNECTING";
            }
            if (i == 1) {
                return "CONNECT_STATE_DISCONNECTED";
            }
            if (i == 2) {
                return "CONNECT_STATE_CONNECTING";
            }
            if (i == 3) {
                return "CONNECT_STATE_CONNECTED";
            }
            if (i == 4) {
                return "CONNECT_STATE_SUSPENDED";
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("UNKNOWN/");
            stringBuilder.append(i);
            return stringBuilder.toString();
        }

        private boolean isCurrent(Messenger messenger, String str) {
            int i;
            if (this.mCallbacksMessenger == messenger) {
                i = this.mState;
                if (i != 0) {
                    if (i != 1) {
                        return true;
                    }
                }
            }
            i = this.mState;
            if (!(i == 0 || i == 1)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(" for ");
                stringBuilder.append(this.mServiceComponent);
                stringBuilder.append(" with mCallbacksMessenger=");
                stringBuilder.append(this.mCallbacksMessenger);
                stringBuilder.append(" this=");
                stringBuilder.append(this);
                Log.i(MediaBrowserCompat.TAG, stringBuilder.toString());
            }
            return false;
        }

        public void connect() {
            int i = this.mState;
            if (i != 0) {
                if (i != 1) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("connect() called while neigther disconnecting nor disconnected (state=");
                    stringBuilder.append(getStateLabel(this.mState));
                    stringBuilder.append(")");
                    throw new IllegalStateException(stringBuilder.toString());
                }
            }
            this.mState = 2;
            this.mHandler.post(new C01181());
        }

        public void disconnect() {
            this.mState = 0;
            this.mHandler.post(new C01192());
        }

        void dump() {
            String str = MediaBrowserCompat.TAG;
            Log.d(str, "MediaBrowserCompat...");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("  mServiceComponent=");
            stringBuilder.append(this.mServiceComponent);
            Log.d(str, stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("  mCallback=");
            stringBuilder.append(this.mCallback);
            Log.d(str, stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("  mRootHints=");
            stringBuilder.append(this.mRootHints);
            Log.d(str, stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("  mState=");
            stringBuilder.append(getStateLabel(this.mState));
            Log.d(str, stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("  mServiceConnection=");
            stringBuilder.append(this.mServiceConnection);
            Log.d(str, stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("  mServiceBinderWrapper=");
            stringBuilder.append(this.mServiceBinderWrapper);
            Log.d(str, stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("  mCallbacksMessenger=");
            stringBuilder.append(this.mCallbacksMessenger);
            Log.d(str, stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("  mRootId=");
            stringBuilder.append(this.mRootId);
            Log.d(str, stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("  mMediaSessionToken=");
            stringBuilder.append(this.mMediaSessionToken);
            Log.d(str, stringBuilder.toString());
        }

        void forceCloseConnection() {
            ServiceConnection serviceConnection = this.mServiceConnection;
            if (serviceConnection != null) {
                this.mContext.unbindService(serviceConnection);
            }
            this.mState = 1;
            this.mServiceConnection = null;
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mHandler.setCallbacksMessenger(null);
            this.mRootId = null;
            this.mMediaSessionToken = null;
        }

        public Bundle getExtras() {
            if (isConnected()) {
                return this.mExtras;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getExtras() called while not connected (state=");
            stringBuilder.append(getStateLabel(this.mState));
            stringBuilder.append(")");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public void getItem(final java.lang.String r5, final android.support.v4.media.MediaBrowserCompat.ItemCallback r6) {
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
            r4 = this;
            r0 = android.text.TextUtils.isEmpty(r5);
            if (r0 != 0) goto L_0x0056;
        L_0x0006:
            if (r6 == 0) goto L_0x004e;
        L_0x0008:
            r0 = r4.isConnected();
            r1 = "MediaBrowserCompat";
            if (r0 != 0) goto L_0x0020;
        L_0x0010:
            r0 = "Not connected, unable to retrieve the MediaItem.";
            android.util.Log.i(r1, r0);
            r0 = r4.mHandler;
            r1 = new android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$3;
            r1.<init>(r6, r5);
            r0.post(r1);
            return;
        L_0x0020:
            r0 = new android.support.v4.media.MediaBrowserCompat$ItemReceiver;
            r2 = r4.mHandler;
            r0.<init>(r5, r6, r2);
            r2 = r4.mServiceBinderWrapper;	 Catch:{ RemoteException -> 0x002f }
            r3 = r4.mCallbacksMessenger;	 Catch:{ RemoteException -> 0x002f }
            r2.getMediaItem(r5, r0, r3);	 Catch:{ RemoteException -> 0x002f }
            goto L_0x004d;
        L_0x002f:
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r2 = "Remote error getting media item: ";
            r0.append(r2);
            r0.append(r5);
            r0 = r0.toString();
            android.util.Log.i(r1, r0);
            r0 = r4.mHandler;
            r1 = new android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$4;
            r1.<init>(r6, r5);
            r0.post(r1);
        L_0x004d:
            return;
        L_0x004e:
            r5 = new java.lang.IllegalArgumentException;
            r6 = "cb is null";
            r5.<init>(r6);
            throw r5;
        L_0x0056:
            r5 = new java.lang.IllegalArgumentException;
            r6 = "mediaId is empty";
            r5.<init>(r6);
            throw r5;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.getItem(java.lang.String, android.support.v4.media.MediaBrowserCompat$ItemCallback):void");
        }

        public Bundle getNotifyChildrenChangedOptions() {
            return this.mNotifyChildrenChangedOptions;
        }

        public String getRoot() {
            if (isConnected()) {
                return this.mRootId;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getRoot() called while not connected(state=");
            stringBuilder.append(getStateLabel(this.mState));
            stringBuilder.append(")");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public ComponentName getServiceComponent() {
            if (isConnected()) {
                return this.mServiceComponent;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getServiceComponent() called while not connected (state=");
            stringBuilder.append(this.mState);
            stringBuilder.append(")");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Token getSessionToken() {
            if (isConnected()) {
                return this.mMediaSessionToken;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getSessionToken() called while not connected(state=");
            stringBuilder.append(this.mState);
            stringBuilder.append(")");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public boolean isConnected() {
            return this.mState == 3;
        }

        public void onConnectionFailed(Messenger messenger) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onConnectFailed for ");
            stringBuilder.append(this.mServiceComponent);
            String stringBuilder2 = stringBuilder.toString();
            String str = MediaBrowserCompat.TAG;
            Log.e(str, stringBuilder2);
            if (!isCurrent(messenger, "onConnectFailed")) {
                return;
            }
            if (this.mState != 2) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("onConnect from service while mState=");
                stringBuilder3.append(getStateLabel(this.mState));
                stringBuilder3.append("... ignoring");
                Log.w(str, stringBuilder3.toString());
                return;
            }
            forceCloseConnection();
            this.mCallback.onConnectionFailed();
        }

        public void onLoadChildren(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            if (isCurrent(messenger, "onLoadChildren")) {
                StringBuilder stringBuilder;
                boolean z = MediaBrowserCompat.DEBUG;
                String str2 = MediaBrowserCompat.TAG;
                if (z) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("onLoadChildren for ");
                    stringBuilder.append(this.mServiceComponent);
                    stringBuilder.append(" id=");
                    stringBuilder.append(str);
                    Log.d(str2, stringBuilder.toString());
                }
                Subscription subscription = (Subscription) this.mSubscriptions.get(str);
                if (subscription == null) {
                    if (MediaBrowserCompat.DEBUG) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("onLoadChildren for id that isn't subscribed id=");
                        stringBuilder.append(str);
                        Log.d(str2, stringBuilder.toString());
                    }
                    return;
                }
                SubscriptionCallback callback = subscription.getCallback(bundle);
                if (callback != null) {
                    if (bundle == null) {
                        if (list == null) {
                            callback.onError(str);
                        } else {
                            this.mNotifyChildrenChangedOptions = bundle2;
                            callback.onChildrenLoaded(str, list);
                        }
                    } else if (list == null) {
                        callback.onError(str, bundle);
                    } else {
                        this.mNotifyChildrenChangedOptions = bundle2;
                        callback.onChildrenLoaded(str, list, bundle);
                    }
                    this.mNotifyChildrenChangedOptions = null;
                }
            }
        }

        public void onServiceConnected(android.os.Messenger r7, java.lang.String r8, android.support.v4.media.session.MediaSessionCompat.Token r9, android.os.Bundle r10) {
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
            r6 = this;
            r0 = "onConnect";
            r7 = r6.isCurrent(r7, r0);
            if (r7 != 0) goto L_0x0009;
        L_0x0008:
            return;
        L_0x0009:
            r7 = r6.mState;
            r0 = 2;
            r1 = "MediaBrowserCompat";
            if (r7 == r0) goto L_0x0030;
        L_0x0010:
            r7 = new java.lang.StringBuilder;
            r7.<init>();
            r8 = "onConnect from service while mState=";
            r7.append(r8);
            r8 = r6.mState;
            r8 = getStateLabel(r8);
            r7.append(r8);
            r8 = "... ignoring";
            r7.append(r8);
            r7 = r7.toString();
            android.util.Log.w(r1, r7);
            return;
        L_0x0030:
            r6.mRootId = r8;
            r6.mMediaSessionToken = r9;
            r6.mExtras = r10;
            r7 = 3;
            r6.mState = r7;
            r7 = android.support.v4.media.MediaBrowserCompat.DEBUG;
            if (r7 == 0) goto L_0x0045;
        L_0x003d:
            r7 = "ServiceCallbacks.onConnect...";
            android.util.Log.d(r1, r7);
            r6.dump();
        L_0x0045:
            r7 = r6.mCallback;
            r7.onConnected();
            r7 = r6.mSubscriptions;	 Catch:{ RemoteException -> 0x0093 }
            r7 = r7.entrySet();	 Catch:{ RemoteException -> 0x0093 }
            r7 = r7.iterator();	 Catch:{ RemoteException -> 0x0093 }
        L_0x0054:
            r8 = r7.hasNext();	 Catch:{ RemoteException -> 0x0093 }
            if (r8 == 0) goto L_0x0098;	 Catch:{ RemoteException -> 0x0093 }
        L_0x005a:
            r8 = r7.next();	 Catch:{ RemoteException -> 0x0093 }
            r8 = (java.util.Map.Entry) r8;	 Catch:{ RemoteException -> 0x0093 }
            r9 = r8.getKey();	 Catch:{ RemoteException -> 0x0093 }
            r9 = (java.lang.String) r9;	 Catch:{ RemoteException -> 0x0093 }
            r8 = r8.getValue();	 Catch:{ RemoteException -> 0x0093 }
            r8 = (android.support.v4.media.MediaBrowserCompat.Subscription) r8;	 Catch:{ RemoteException -> 0x0093 }
            r10 = r8.getCallbacks();	 Catch:{ RemoteException -> 0x0093 }
            r8 = r8.getOptionsList();	 Catch:{ RemoteException -> 0x0093 }
            r0 = 0;	 Catch:{ RemoteException -> 0x0093 }
        L_0x0075:
            r2 = r10.size();	 Catch:{ RemoteException -> 0x0093 }
            if (r0 >= r2) goto L_0x0054;	 Catch:{ RemoteException -> 0x0093 }
        L_0x007b:
            r2 = r6.mServiceBinderWrapper;	 Catch:{ RemoteException -> 0x0093 }
            r3 = r10.get(r0);	 Catch:{ RemoteException -> 0x0093 }
            r3 = (android.support.v4.media.MediaBrowserCompat.SubscriptionCallback) r3;	 Catch:{ RemoteException -> 0x0093 }
            r3 = r3.mToken;	 Catch:{ RemoteException -> 0x0093 }
            r4 = r8.get(r0);	 Catch:{ RemoteException -> 0x0093 }
            r4 = (android.os.Bundle) r4;	 Catch:{ RemoteException -> 0x0093 }
            r5 = r6.mCallbacksMessenger;	 Catch:{ RemoteException -> 0x0093 }
            r2.addSubscription(r9, r3, r4, r5);	 Catch:{ RemoteException -> 0x0093 }
            r0 = r0 + 1;
            goto L_0x0075;
        L_0x0093:
            r7 = "addSubscription failed with RemoteException.";
            android.util.Log.d(r1, r7);
        L_0x0098:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.onServiceConnected(android.os.Messenger, java.lang.String, android.support.v4.media.session.MediaSessionCompat$Token, android.os.Bundle):void");
        }

        public void search(final String str, final Bundle bundle, final SearchCallback searchCallback) {
            if (isConnected()) {
                try {
                    this.mServiceBinderWrapper.search(str, bundle, new SearchResultReceiver(str, bundle, searchCallback, this.mHandler), this.mCallbacksMessenger);
                    return;
                } catch (Throwable e) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Remote error searching items with query: ");
                    stringBuilder.append(str);
                    Log.i(MediaBrowserCompat.TAG, stringBuilder.toString(), e);
                    this.mHandler.post(new Runnable() {
                        public void run() {
                            searchCallback.onError(str, bundle);
                        }
                    });
                    return;
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("search() called while not connected (state=");
            stringBuilder2.append(getStateLabel(this.mState));
            stringBuilder2.append(")");
            throw new IllegalStateException(stringBuilder2.toString());
        }

        public void sendCustomAction(final String str, final Bundle bundle, final CustomActionCallback customActionCallback) {
            if (isConnected()) {
                try {
                    this.mServiceBinderWrapper.sendCustomAction(str, bundle, new CustomActionResultReceiver(str, bundle, customActionCallback, this.mHandler), this.mCallbacksMessenger);
                    return;
                } catch (Throwable e) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Remote error sending a custom action: action=");
                    stringBuilder.append(str);
                    stringBuilder.append(", extras=");
                    stringBuilder.append(bundle);
                    Log.i(MediaBrowserCompat.TAG, stringBuilder.toString(), e);
                    if (customActionCallback != null) {
                        this.mHandler.post(new Runnable() {
                            public void run() {
                                customActionCallback.onError(str, bundle, null);
                            }
                        });
                        return;
                    }
                    return;
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Cannot send a custom action (");
            stringBuilder2.append(str);
            stringBuilder2.append(") with ");
            stringBuilder2.append("extras ");
            stringBuilder2.append(bundle);
            stringBuilder2.append(" because the browser is not connected to the ");
            stringBuilder2.append("service.");
            throw new IllegalStateException(stringBuilder2.toString());
        }

        public void subscribe(java.lang.String r3, android.os.Bundle r4, android.support.v4.media.MediaBrowserCompat.SubscriptionCallback r5) {
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
            r2 = this;
            r0 = r2.mSubscriptions;
            r0 = r0.get(r3);
            r0 = (android.support.v4.media.MediaBrowserCompat.Subscription) r0;
            if (r0 != 0) goto L_0x0014;
        L_0x000a:
            r0 = new android.support.v4.media.MediaBrowserCompat$Subscription;
            r0.<init>();
            r1 = r2.mSubscriptions;
            r1.put(r3, r0);
        L_0x0014:
            if (r4 != 0) goto L_0x0018;
        L_0x0016:
            r4 = 0;
            goto L_0x001e;
        L_0x0018:
            r1 = new android.os.Bundle;
            r1.<init>(r4);
            r4 = r1;
        L_0x001e:
            r0.putCallback(r4, r5);
            r0 = r2.isConnected();
            if (r0 == 0) goto L_0x0047;
        L_0x0027:
            r0 = r2.mServiceBinderWrapper;	 Catch:{ RemoteException -> 0x0031 }
            r5 = r5.mToken;	 Catch:{ RemoteException -> 0x0031 }
            r1 = r2.mCallbacksMessenger;	 Catch:{ RemoteException -> 0x0031 }
            r0.addSubscription(r3, r5, r4, r1);	 Catch:{ RemoteException -> 0x0031 }
            goto L_0x0047;
        L_0x0031:
            r4 = new java.lang.StringBuilder;
            r4.<init>();
            r5 = "addSubscription failed with RemoteException parentId=";
            r4.append(r5);
            r4.append(r3);
            r3 = r4.toString();
            r4 = "MediaBrowserCompat";
            android.util.Log.d(r4, r3);
        L_0x0047:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.subscribe(java.lang.String, android.os.Bundle, android.support.v4.media.MediaBrowserCompat$SubscriptionCallback):void");
        }

        public void unsubscribe(java.lang.String r8, android.support.v4.media.MediaBrowserCompat.SubscriptionCallback r9) {
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
            r7 = this;
            r0 = r7.mSubscriptions;
            r0 = r0.get(r8);
            r0 = (android.support.v4.media.MediaBrowserCompat.Subscription) r0;
            if (r0 != 0) goto L_0x000b;
        L_0x000a:
            return;
        L_0x000b:
            if (r9 != 0) goto L_0x001c;
        L_0x000d:
            r1 = r7.isConnected();	 Catch:{ RemoteException -> 0x004a }
            if (r1 == 0) goto L_0x0060;	 Catch:{ RemoteException -> 0x004a }
        L_0x0013:
            r1 = r7.mServiceBinderWrapper;	 Catch:{ RemoteException -> 0x004a }
            r2 = 0;	 Catch:{ RemoteException -> 0x004a }
            r3 = r7.mCallbacksMessenger;	 Catch:{ RemoteException -> 0x004a }
            r1.removeSubscription(r8, r2, r3);	 Catch:{ RemoteException -> 0x004a }
            goto L_0x0060;	 Catch:{ RemoteException -> 0x004a }
        L_0x001c:
            r1 = r0.getCallbacks();	 Catch:{ RemoteException -> 0x004a }
            r2 = r0.getOptionsList();	 Catch:{ RemoteException -> 0x004a }
            r3 = r1.size();	 Catch:{ RemoteException -> 0x004a }
            r3 = r3 + -1;	 Catch:{ RemoteException -> 0x004a }
        L_0x002a:
            if (r3 < 0) goto L_0x0060;	 Catch:{ RemoteException -> 0x004a }
        L_0x002c:
            r4 = r1.get(r3);	 Catch:{ RemoteException -> 0x004a }
            if (r4 != r9) goto L_0x0047;	 Catch:{ RemoteException -> 0x004a }
        L_0x0032:
            r4 = r7.isConnected();	 Catch:{ RemoteException -> 0x004a }
            if (r4 == 0) goto L_0x0041;	 Catch:{ RemoteException -> 0x004a }
        L_0x0038:
            r4 = r7.mServiceBinderWrapper;	 Catch:{ RemoteException -> 0x004a }
            r5 = r9.mToken;	 Catch:{ RemoteException -> 0x004a }
            r6 = r7.mCallbacksMessenger;	 Catch:{ RemoteException -> 0x004a }
            r4.removeSubscription(r8, r5, r6);	 Catch:{ RemoteException -> 0x004a }
        L_0x0041:
            r1.remove(r3);	 Catch:{ RemoteException -> 0x004a }
            r2.remove(r3);	 Catch:{ RemoteException -> 0x004a }
        L_0x0047:
            r3 = r3 + -1;
            goto L_0x002a;
        L_0x004a:
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = "removeSubscription failed with RemoteException parentId=";
            r1.append(r2);
            r1.append(r8);
            r1 = r1.toString();
            r2 = "MediaBrowserCompat";
            android.util.Log.d(r2, r1);
        L_0x0060:
            r0 = r0.isEmpty();
            if (r0 != 0) goto L_0x0068;
        L_0x0066:
            if (r9 != 0) goto L_0x006d;
        L_0x0068:
            r9 = r7.mSubscriptions;
            r9.remove(r8);
        L_0x006d:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.unsubscribe(java.lang.String, android.support.v4.media.MediaBrowserCompat$SubscriptionCallback):void");
        }
    }

    private static class SearchResultReceiver extends ResultReceiver {
        private final SearchCallback mCallback;
        private final Bundle mExtras;
        private final String mQuery;

        SearchResultReceiver(String str, Bundle bundle, SearchCallback searchCallback, Handler handler) {
            super(handler);
            this.mQuery = str;
            this.mExtras = bundle;
            this.mCallback = searchCallback;
        }

        protected void onReceiveResult(int i, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            if (i == 0 && bundle != null) {
                String str = MediaBrowserServiceCompat.KEY_SEARCH_RESULTS;
                if (bundle.containsKey(str)) {
                    Parcelable[] parcelableArray = bundle.getParcelableArray(str);
                    List list = null;
                    if (parcelableArray != null) {
                        list = new ArrayList();
                        for (Parcelable parcelable : parcelableArray) {
                            list.add((MediaItem) parcelable);
                        }
                    }
                    this.mCallback.onSearchResult(this.mQuery, this.mExtras, list);
                    return;
                }
            }
            this.mCallback.onError(this.mQuery, this.mExtras);
        }
    }

    static class MediaBrowserImplApi23 extends MediaBrowserImplApi21 {
        MediaBrowserImplApi23(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }

        public void getItem(String str, ItemCallback itemCallback) {
            if (this.mServiceBinderWrapper == null) {
                MediaBrowserCompatApi23.getItem(this.mBrowserObj, str, itemCallback.mItemCallbackObj);
            } else {
                super.getItem(str, itemCallback);
            }
        }
    }

    static class MediaBrowserImplApi26 extends MediaBrowserImplApi23 {
        MediaBrowserImplApi26(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }

        public void subscribe(String str, Bundle bundle, SubscriptionCallback subscriptionCallback) {
            if (this.mServiceBinderWrapper != null) {
                if (this.mServiceVersion >= 2) {
                    super.subscribe(str, bundle, subscriptionCallback);
                    return;
                }
            }
            if (bundle == null) {
                MediaBrowserCompatApi21.subscribe(this.mBrowserObj, str, subscriptionCallback.mSubscriptionCallbackObj);
            } else {
                MediaBrowserCompatApi26.subscribe(this.mBrowserObj, str, bundle, subscriptionCallback.mSubscriptionCallbackObj);
            }
        }

        public void unsubscribe(String str, SubscriptionCallback subscriptionCallback) {
            if (this.mServiceBinderWrapper != null) {
                if (this.mServiceVersion >= 2) {
                    super.unsubscribe(str, subscriptionCallback);
                    return;
                }
            }
            if (subscriptionCallback == null) {
                MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, str);
            } else {
                MediaBrowserCompatApi26.unsubscribe(this.mBrowserObj, str, subscriptionCallback.mSubscriptionCallbackObj);
            }
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
        int i = VERSION.SDK_INT;
        MediaBrowserImpl mediaBrowserImplApi26 = i >= 26 ? new MediaBrowserImplApi26(context, componentName, connectionCallback, bundle) : i >= 23 ? new MediaBrowserImplApi23(context, componentName, connectionCallback, bundle) : i >= 21 ? new MediaBrowserImplApi21(context, componentName, connectionCallback, bundle) : new MediaBrowserImplBase(context, componentName, connectionCallback, bundle);
        this.mImpl = mediaBrowserImplApi26;
    }

    public void connect() {
        this.mImpl.connect();
    }

    public void disconnect() {
        this.mImpl.disconnect();
    }

    public Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public void getItem(String str, ItemCallback itemCallback) {
        this.mImpl.getItem(str, itemCallback);
    }

    public Bundle getNotifyChildrenChangedOptions() {
        return this.mImpl.getNotifyChildrenChangedOptions();
    }

    public String getRoot() {
        return this.mImpl.getRoot();
    }

    public ComponentName getServiceComponent() {
        return this.mImpl.getServiceComponent();
    }

    public Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public boolean isConnected() {
        return this.mImpl.isConnected();
    }

    public void search(String str, Bundle bundle, SearchCallback searchCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("query cannot be empty");
        } else if (searchCallback != null) {
            this.mImpl.search(str, bundle, searchCallback);
        } else {
            throw new IllegalArgumentException("callback cannot be null");
        }
    }

    public void sendCustomAction(String str, Bundle bundle, CustomActionCallback customActionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("action cannot be empty");
        }
        this.mImpl.sendCustomAction(str, bundle, customActionCallback);
    }

    public void subscribe(String str, Bundle bundle, SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        } else if (subscriptionCallback == null) {
            throw new IllegalArgumentException("callback is null");
        } else if (bundle != null) {
            this.mImpl.subscribe(str, bundle, subscriptionCallback);
        } else {
            throw new IllegalArgumentException("options are null");
        }
    }

    public void subscribe(String str, SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        } else if (subscriptionCallback != null) {
            this.mImpl.subscribe(str, null, subscriptionCallback);
        } else {
            throw new IllegalArgumentException("callback is null");
        }
    }

    public void unsubscribe(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        this.mImpl.unsubscribe(str, null);
    }

    public void unsubscribe(String str, SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        } else if (subscriptionCallback != null) {
            this.mImpl.unsubscribe(str, subscriptionCallback);
        } else {
            throw new IllegalArgumentException("callback is null");
        }
    }
}
