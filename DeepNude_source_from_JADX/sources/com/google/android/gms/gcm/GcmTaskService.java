package com.google.android.gms.gcm;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.common.util.zzz;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class GcmTaskService extends Service {
    public static final String SERVICE_ACTION_EXECUTE_TASK = "com.google.android.gms.gcm.ACTION_TASK_READY";
    public static final String SERVICE_ACTION_INITIALIZE = "com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE";
    public static final String SERVICE_PERMISSION = "com.google.android.gms.permission.BIND_NETWORK_TASK_SERVICE";
    private ComponentName componentName;
    private final Object lock = new Object();
    private ExecutorService zzair;
    private int zzijt;
    private Messenger zziju;
    private GcmNetworkManager zzijv;

    @TargetApi(21)
    class zza extends Handler {
        private /* synthetic */ GcmTaskService zzijx;

        zza(GcmTaskService gcmTaskService, Looper looper) {
            this.zzijx = gcmTaskService;
            super(looper);
        }

        public final void handleMessage(Message message) {
            String str = "GcmTaskService";
            if (zzz.zzb(this.zzijx, message.sendingUid, "com.google.android.gms")) {
                int i = message.what;
                if (i == 1) {
                    Bundle data = message.getData();
                    if (!data.isEmpty()) {
                        Messenger messenger = message.replyTo;
                        if (messenger != null) {
                            String string = data.getString("tag");
                            List parcelableArrayList = data.getParcelableArrayList("triggered_uris");
                            if (!this.zzijx.zzig(string)) {
                                this.zzijx.zza(new zzb(this.zzijx, string, messenger, data.getBundle("extras"), parcelableArrayList));
                            }
                        }
                    }
                    return;
                } else if (i == 2) {
                    if (Log.isLoggable(str, 3)) {
                        r9 = String.valueOf(message);
                        r2 = new StringBuilder(String.valueOf(r9).length() + 45);
                        r2.append("ignoring unimplemented stop message for now: ");
                        r2.append(r9);
                        Log.d(str, r2.toString());
                    }
                    return;
                } else if (i != 4) {
                    r9 = String.valueOf(message);
                    r2 = new StringBuilder(String.valueOf(r9).length() + 31);
                    r2.append("Unrecognized message received: ");
                    r2.append(r9);
                    Log.e(str, r2.toString());
                    return;
                } else {
                    this.zzijx.onInitializeTasks();
                    return;
                }
            }
            Log.e(str, "unable to verify presence of Google Play Services");
        }
    }

    class zzb implements Runnable {
        private final Bundle mExtras;
        private final Messenger mMessenger;
        private final String mTag;
        private /* synthetic */ GcmTaskService zzijx;
        private final List<Uri> zzijy;
        private final zzd zzijz;

        zzb(GcmTaskService gcmTaskService, String str, IBinder iBinder, Bundle bundle, List<Uri> list) {
            zzd zzd;
            this.zzijx = gcmTaskService;
            this.mTag = str;
            if (iBinder == null) {
                zzd = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.gcm.INetworkTaskCallback");
                zzd = queryLocalInterface instanceof zzd ? (zzd) queryLocalInterface : new zze(iBinder);
            }
            this.zzijz = zzd;
            this.mExtras = bundle;
            this.zzijy = list;
            this.mMessenger = null;
        }

        zzb(GcmTaskService gcmTaskService, String str, Messenger messenger, Bundle bundle, List<Uri> list) {
            this.zzijx = gcmTaskService;
            this.mTag = str;
            this.mMessenger = messenger;
            this.mExtras = bundle;
            this.zzijy = list;
            this.zzijz = null;
        }

        private final boolean zzawg() {
            return this.mMessenger != null;
        }

        private final void zzea(int r6) {
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
            r0 = r5.zzijx;
            r0 = r0.lock;
            monitor-enter(r0);
            r1 = r5.zzijx;	 Catch:{ RemoteException -> 0x00d0 }
            r1 = r1.zzijv;	 Catch:{ RemoteException -> 0x00d0 }
            r2 = r5.mTag;	 Catch:{ RemoteException -> 0x00d0 }
            r3 = r5.zzijx;	 Catch:{ RemoteException -> 0x00d0 }
            r3 = r3.componentName;	 Catch:{ RemoteException -> 0x00d0 }
            r3 = r3.getClassName();	 Catch:{ RemoteException -> 0x00d0 }
            r1 = r1.zzac(r2, r3);	 Catch:{ RemoteException -> 0x00d0 }
            if (r1 == 0) goto L_0x005d;
        L_0x001f:
            r6 = r5.zzijx;	 Catch:{ all -> 0x0167 }
            r6 = r6.zzijv;	 Catch:{ all -> 0x0167 }
            r1 = r5.mTag;	 Catch:{ all -> 0x0167 }
            r2 = r5.zzijx;	 Catch:{ all -> 0x0167 }
            r2 = r2.componentName;	 Catch:{ all -> 0x0167 }
            r2 = r2.getClassName();	 Catch:{ all -> 0x0167 }
            r6.zzab(r1, r2);	 Catch:{ all -> 0x0167 }
            r6 = r5.zzawg();	 Catch:{ all -> 0x0167 }
            if (r6 != 0) goto L_0x005b;	 Catch:{ all -> 0x0167 }
        L_0x003a:
            r6 = r5.zzijx;	 Catch:{ all -> 0x0167 }
            r6 = r6.zzijv;	 Catch:{ all -> 0x0167 }
            r1 = r5.zzijx;	 Catch:{ all -> 0x0167 }
            r1 = r1.componentName;	 Catch:{ all -> 0x0167 }
            r1 = r1.getClassName();	 Catch:{ all -> 0x0167 }
            r6 = r6.zzif(r1);	 Catch:{ all -> 0x0167 }
            if (r6 != 0) goto L_0x005b;	 Catch:{ all -> 0x0167 }
        L_0x0050:
            r6 = r5.zzijx;	 Catch:{ all -> 0x0167 }
            r1 = r5.zzijx;	 Catch:{ all -> 0x0167 }
            r1 = r1.zzijt;	 Catch:{ all -> 0x0167 }
            r6.stopSelf(r1);	 Catch:{ all -> 0x0167 }
        L_0x005b:
            monitor-exit(r0);	 Catch:{ all -> 0x0167 }
            return;
        L_0x005d:
            r1 = r5.zzawg();	 Catch:{ RemoteException -> 0x00d0 }
            if (r1 == 0) goto L_0x008c;	 Catch:{ RemoteException -> 0x00d0 }
        L_0x0063:
            r1 = r5.mMessenger;	 Catch:{ RemoteException -> 0x00d0 }
            r2 = android.os.Message.obtain();	 Catch:{ RemoteException -> 0x00d0 }
            r3 = 3;	 Catch:{ RemoteException -> 0x00d0 }
            r2.what = r3;	 Catch:{ RemoteException -> 0x00d0 }
            r2.arg1 = r6;	 Catch:{ RemoteException -> 0x00d0 }
            r6 = new android.os.Bundle;	 Catch:{ RemoteException -> 0x00d0 }
            r6.<init>();	 Catch:{ RemoteException -> 0x00d0 }
            r3 = "component";	 Catch:{ RemoteException -> 0x00d0 }
            r4 = r5.zzijx;	 Catch:{ RemoteException -> 0x00d0 }
            r4 = r4.componentName;	 Catch:{ RemoteException -> 0x00d0 }
            r6.putParcelable(r3, r4);	 Catch:{ RemoteException -> 0x00d0 }
            r3 = "tag";	 Catch:{ RemoteException -> 0x00d0 }
            r4 = r5.mTag;	 Catch:{ RemoteException -> 0x00d0 }
            r6.putString(r3, r4);	 Catch:{ RemoteException -> 0x00d0 }
            r2.setData(r6);	 Catch:{ RemoteException -> 0x00d0 }
            r1.send(r2);	 Catch:{ RemoteException -> 0x00d0 }
            goto L_0x0091;	 Catch:{ RemoteException -> 0x00d0 }
        L_0x008c:
            r1 = r5.zzijz;	 Catch:{ RemoteException -> 0x00d0 }
            r1.zzeb(r6);	 Catch:{ RemoteException -> 0x00d0 }
        L_0x0091:
            r6 = r5.zzijx;	 Catch:{ all -> 0x0167 }
            r6 = r6.zzijv;	 Catch:{ all -> 0x0167 }
            r1 = r5.mTag;	 Catch:{ all -> 0x0167 }
            r2 = r5.zzijx;	 Catch:{ all -> 0x0167 }
            r2 = r2.componentName;	 Catch:{ all -> 0x0167 }
            r2 = r2.getClassName();	 Catch:{ all -> 0x0167 }
            r6.zzab(r1, r2);	 Catch:{ all -> 0x0167 }
            r6 = r5.zzawg();	 Catch:{ all -> 0x0167 }
            if (r6 != 0) goto L_0x0128;	 Catch:{ all -> 0x0167 }
        L_0x00ac:
            r6 = r5.zzijx;	 Catch:{ all -> 0x0167 }
            r6 = r6.zzijv;	 Catch:{ all -> 0x0167 }
            r1 = r5.zzijx;	 Catch:{ all -> 0x0167 }
            r1 = r1.componentName;	 Catch:{ all -> 0x0167 }
            r1 = r1.getClassName();	 Catch:{ all -> 0x0167 }
            r6 = r6.zzif(r1);	 Catch:{ all -> 0x0167 }
            if (r6 != 0) goto L_0x0128;	 Catch:{ all -> 0x0167 }
        L_0x00c2:
            r6 = r5.zzijx;	 Catch:{ all -> 0x0167 }
            r1 = r5.zzijx;	 Catch:{ all -> 0x0167 }
            r1 = r1.zzijt;	 Catch:{ all -> 0x0167 }
        L_0x00ca:
            r6.stopSelf(r1);	 Catch:{ all -> 0x0167 }
            goto L_0x0128;
        L_0x00ce:
            r6 = move-exception;
            goto L_0x012a;
        L_0x00d0:
            r6 = "GcmTaskService";	 Catch:{ all -> 0x00ce }
            r1 = "Error reporting result of operation to scheduler for ";	 Catch:{ all -> 0x00ce }
            r2 = r5.mTag;	 Catch:{ all -> 0x00ce }
            r2 = java.lang.String.valueOf(r2);	 Catch:{ all -> 0x00ce }
            r3 = r2.length();	 Catch:{ all -> 0x00ce }
            if (r3 == 0) goto L_0x00e5;	 Catch:{ all -> 0x00ce }
        L_0x00e0:
            r1 = r1.concat(r2);	 Catch:{ all -> 0x00ce }
            goto L_0x00eb;	 Catch:{ all -> 0x00ce }
        L_0x00e5:
            r2 = new java.lang.String;	 Catch:{ all -> 0x00ce }
            r2.<init>(r1);	 Catch:{ all -> 0x00ce }
            r1 = r2;	 Catch:{ all -> 0x00ce }
        L_0x00eb:
            android.util.Log.e(r6, r1);	 Catch:{ all -> 0x00ce }
            r6 = r5.zzijx;	 Catch:{ all -> 0x0167 }
            r6 = r6.zzijv;	 Catch:{ all -> 0x0167 }
            r1 = r5.mTag;	 Catch:{ all -> 0x0167 }
            r2 = r5.zzijx;	 Catch:{ all -> 0x0167 }
            r2 = r2.componentName;	 Catch:{ all -> 0x0167 }
            r2 = r2.getClassName();	 Catch:{ all -> 0x0167 }
            r6.zzab(r1, r2);	 Catch:{ all -> 0x0167 }
            r6 = r5.zzawg();	 Catch:{ all -> 0x0167 }
            if (r6 != 0) goto L_0x0128;	 Catch:{ all -> 0x0167 }
        L_0x0109:
            r6 = r5.zzijx;	 Catch:{ all -> 0x0167 }
            r6 = r6.zzijv;	 Catch:{ all -> 0x0167 }
            r1 = r5.zzijx;	 Catch:{ all -> 0x0167 }
            r1 = r1.componentName;	 Catch:{ all -> 0x0167 }
            r1 = r1.getClassName();	 Catch:{ all -> 0x0167 }
            r6 = r6.zzif(r1);	 Catch:{ all -> 0x0167 }
            if (r6 != 0) goto L_0x0128;	 Catch:{ all -> 0x0167 }
        L_0x011f:
            r6 = r5.zzijx;	 Catch:{ all -> 0x0167 }
            r1 = r5.zzijx;	 Catch:{ all -> 0x0167 }
            r1 = r1.zzijt;	 Catch:{ all -> 0x0167 }
            goto L_0x00ca;	 Catch:{ all -> 0x0167 }
        L_0x0128:
            monitor-exit(r0);	 Catch:{ all -> 0x0167 }
            return;	 Catch:{ all -> 0x0167 }
        L_0x012a:
            r1 = r5.zzijx;	 Catch:{ all -> 0x0167 }
            r1 = r1.zzijv;	 Catch:{ all -> 0x0167 }
            r2 = r5.mTag;	 Catch:{ all -> 0x0167 }
            r3 = r5.zzijx;	 Catch:{ all -> 0x0167 }
            r3 = r3.componentName;	 Catch:{ all -> 0x0167 }
            r3 = r3.getClassName();	 Catch:{ all -> 0x0167 }
            r1.zzab(r2, r3);	 Catch:{ all -> 0x0167 }
            r1 = r5.zzawg();	 Catch:{ all -> 0x0167 }
            if (r1 != 0) goto L_0x0166;	 Catch:{ all -> 0x0167 }
        L_0x0145:
            r1 = r5.zzijx;	 Catch:{ all -> 0x0167 }
            r1 = r1.zzijv;	 Catch:{ all -> 0x0167 }
            r2 = r5.zzijx;	 Catch:{ all -> 0x0167 }
            r2 = r2.componentName;	 Catch:{ all -> 0x0167 }
            r2 = r2.getClassName();	 Catch:{ all -> 0x0167 }
            r1 = r1.zzif(r2);	 Catch:{ all -> 0x0167 }
            if (r1 != 0) goto L_0x0166;	 Catch:{ all -> 0x0167 }
        L_0x015b:
            r1 = r5.zzijx;	 Catch:{ all -> 0x0167 }
            r2 = r5.zzijx;	 Catch:{ all -> 0x0167 }
            r2 = r2.zzijt;	 Catch:{ all -> 0x0167 }
            r1.stopSelf(r2);	 Catch:{ all -> 0x0167 }
        L_0x0166:
            throw r6;	 Catch:{ all -> 0x0167 }
        L_0x0167:
            r6 = move-exception;	 Catch:{ all -> 0x0167 }
            monitor-exit(r0);	 Catch:{ all -> 0x0167 }
            goto L_0x016b;
        L_0x016a:
            throw r6;
        L_0x016b:
            goto L_0x016a;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.gcm.GcmTaskService.zzb.zzea(int):void");
        }

        public final void run() {
            zzea(this.zzijx.onRunTask(new TaskParams(this.mTag, this.mExtras, this.zzijy)));
        }
    }

    private final void zza(zzb zzb) {
        try {
            this.zzair.execute(zzb);
        } catch (Throwable e) {
            Log.e("GcmTaskService", "Executor is shutdown. onDestroy was called but main looper had an unprocessed start task message. The task will be retried with backoff delay.", e);
            zzb.zzea(1);
        }
    }

    private final void zzdz(int i) {
        synchronized (this.lock) {
            this.zzijt = i;
            if (!this.zzijv.zzif(this.componentName.getClassName())) {
                stopSelf(this.zzijt);
            }
        }
    }

    @Hide
    private final boolean zzig(String str) {
        boolean zzaa;
        synchronized (this.lock) {
            zzaa = this.zzijv.zzaa(str, this.componentName.getClassName()) ^ 1;
            if (zzaa) {
                String packageName = getPackageName();
                StringBuilder stringBuilder = new StringBuilder((String.valueOf(packageName).length() + 44) + String.valueOf(str).length());
                stringBuilder.append(packageName);
                stringBuilder.append(" ");
                stringBuilder.append(str);
                stringBuilder.append(": Task already running, won't start another");
                Log.w("GcmTaskService", stringBuilder.toString());
            }
        }
        return zzaa;
    }

    public IBinder onBind(Intent intent) {
        if (intent != null && zzs.zzanx()) {
            if (SERVICE_ACTION_EXECUTE_TASK.equals(intent.getAction())) {
                return this.zziju.getBinder();
            }
        }
        return null;
    }

    public void onCreate() {
        super.onCreate();
        this.zzijv = GcmNetworkManager.getInstance(this);
        this.zzair = Executors.newFixedThreadPool(2, new zzb(this));
        this.zziju = new Messenger(new zza(this, Looper.getMainLooper()));
        this.componentName = new ComponentName(this, GcmTaskService.class);
    }

    public void onDestroy() {
        super.onDestroy();
        List shutdownNow = this.zzair.shutdownNow();
        if (!shutdownNow.isEmpty()) {
            int size = shutdownNow.size();
            StringBuilder stringBuilder = new StringBuilder(79);
            stringBuilder.append("Shutting down, but not all tasks are finished executing. Remaining: ");
            stringBuilder.append(size);
            Log.e("GcmTaskService", stringBuilder.toString());
        }
    }

    public void onInitializeTasks() {
    }

    public abstract int onRunTask(TaskParams taskParams);

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            zzdz(i2);
            return 2;
        }
        try {
            intent.setExtrasClassLoader(PendingCallback.class.getClassLoader());
            String action = intent.getAction();
            String str = "GcmTaskService";
            StringBuilder stringBuilder;
            if (SERVICE_ACTION_EXECUTE_TASK.equals(action)) {
                String stringExtra = intent.getStringExtra("tag");
                Parcelable parcelableExtra = intent.getParcelableExtra("callback");
                Bundle bundleExtra = intent.getBundleExtra("extras");
                List parcelableArrayListExtra = intent.getParcelableArrayListExtra("triggered_uris");
                if (!(parcelableExtra instanceof PendingCallback)) {
                    String packageName = getPackageName();
                    stringBuilder = new StringBuilder((String.valueOf(packageName).length() + 47) + String.valueOf(stringExtra).length());
                    stringBuilder.append(packageName);
                    stringBuilder.append(" ");
                    stringBuilder.append(stringExtra);
                    stringBuilder.append(": Could not process request, invalid callback.");
                    Log.e(str, stringBuilder.toString());
                    return 2;
                } else if (zzig(stringExtra)) {
                    zzdz(i2);
                    return 2;
                } else {
                    zza(new zzb(this, stringExtra, ((PendingCallback) parcelableExtra).zzgfp, bundleExtra, parcelableArrayListExtra));
                }
            } else if (SERVICE_ACTION_INITIALIZE.equals(action)) {
                onInitializeTasks();
            } else {
                stringBuilder = new StringBuilder(String.valueOf(action).length() + 37);
                stringBuilder.append("Unknown action received ");
                stringBuilder.append(action);
                stringBuilder.append(", terminating");
                Log.e(str, stringBuilder.toString());
            }
            zzdz(i2);
            return 2;
        } finally {
            zzdz(i2);
        }
    }
}
