package com.google.android.gms.iid;

import android.content.BroadcastReceiver.PendingResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

@Hide
public final class zzh implements ServiceConnection {
    private final Context zzaiq;
    private final Intent zzimp;
    private final ScheduledExecutorService zzimq;
    private final Queue<zzd> zzimr;
    private zzf zzims;
    private boolean zzimt;

    public zzh(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0));
    }

    private zzh(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.zzimr = new ArrayDeque();
        this.zzimt = false;
        this.zzaiq = context.getApplicationContext();
        this.zzimp = new Intent(str).setPackage(this.zzaiq.getPackageName());
        this.zzimq = scheduledExecutorService;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zzawo() {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = "EnhancedIntentService";
        r1 = 3;
        r0 = android.util.Log.isLoggable(r0, r1);	 Catch:{ all -> 0x00b9 }
        if (r0 == 0) goto L_0x0011;
    L_0x000a:
        r0 = "EnhancedIntentService";
        r2 = "flush queue called";
        android.util.Log.d(r0, r2);	 Catch:{ all -> 0x00b9 }
    L_0x0011:
        r0 = r5.zzimr;	 Catch:{ all -> 0x00b9 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x00b9 }
        if (r0 != 0) goto L_0x00b7;
    L_0x0019:
        r0 = "EnhancedIntentService";
        r0 = android.util.Log.isLoggable(r0, r1);	 Catch:{ all -> 0x00b9 }
        if (r0 == 0) goto L_0x0028;
    L_0x0021:
        r0 = "EnhancedIntentService";
        r2 = "found intent to be delivered";
        android.util.Log.d(r0, r2);	 Catch:{ all -> 0x00b9 }
    L_0x0028:
        r0 = r5.zzims;	 Catch:{ all -> 0x00b9 }
        if (r0 == 0) goto L_0x0051;
    L_0x002c:
        r0 = r5.zzims;	 Catch:{ all -> 0x00b9 }
        r0 = r0.isBinderAlive();	 Catch:{ all -> 0x00b9 }
        if (r0 == 0) goto L_0x0051;
    L_0x0034:
        r0 = "EnhancedIntentService";
        r0 = android.util.Log.isLoggable(r0, r1);	 Catch:{ all -> 0x00b9 }
        if (r0 == 0) goto L_0x0043;
    L_0x003c:
        r0 = "EnhancedIntentService";
        r2 = "binder is alive, sending the intent.";
        android.util.Log.d(r0, r2);	 Catch:{ all -> 0x00b9 }
    L_0x0043:
        r0 = r5.zzimr;	 Catch:{ all -> 0x00b9 }
        r0 = r0.poll();	 Catch:{ all -> 0x00b9 }
        r0 = (com.google.android.gms.iid.zzd) r0;	 Catch:{ all -> 0x00b9 }
        r2 = r5.zzims;	 Catch:{ all -> 0x00b9 }
        r2.zza(r0);	 Catch:{ all -> 0x00b9 }
        goto L_0x0011;
    L_0x0051:
        r0 = "EnhancedIntentService";
        r0 = android.util.Log.isLoggable(r0, r1);	 Catch:{ all -> 0x00b9 }
        r1 = 1;
        if (r0 == 0) goto L_0x0079;
    L_0x005a:
        r0 = "EnhancedIntentService";
        r2 = r5.zzimt;	 Catch:{ all -> 0x00b9 }
        if (r2 != 0) goto L_0x0062;
    L_0x0060:
        r2 = 1;
        goto L_0x0063;
    L_0x0062:
        r2 = 0;
    L_0x0063:
        r3 = 39;
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00b9 }
        r4.<init>(r3);	 Catch:{ all -> 0x00b9 }
        r3 = "binder is dead. start connection? ";
        r4.append(r3);	 Catch:{ all -> 0x00b9 }
        r4.append(r2);	 Catch:{ all -> 0x00b9 }
        r2 = r4.toString();	 Catch:{ all -> 0x00b9 }
        android.util.Log.d(r0, r2);	 Catch:{ all -> 0x00b9 }
    L_0x0079:
        r0 = r5.zzimt;	 Catch:{ all -> 0x00b9 }
        if (r0 != 0) goto L_0x00b5;
    L_0x007d:
        r5.zzimt = r1;	 Catch:{ all -> 0x00b9 }
        r0 = com.google.android.gms.common.stats.zza.zzanm();	 Catch:{ SecurityException -> 0x0099 }
        r1 = r5.zzaiq;	 Catch:{ SecurityException -> 0x0099 }
        r2 = r5.zzimp;	 Catch:{ SecurityException -> 0x0099 }
        r3 = 65;
        r0 = r0.zza(r1, r2, r5, r3);	 Catch:{ SecurityException -> 0x0099 }
        if (r0 == 0) goto L_0x0091;
    L_0x008f:
        monitor-exit(r5);
        return;
    L_0x0091:
        r0 = "EnhancedIntentService";
        r1 = "binding to the service failed";
        android.util.Log.e(r0, r1);	 Catch:{ SecurityException -> 0x0099 }
        goto L_0x00a1;
    L_0x0099:
        r0 = move-exception;
        r1 = "EnhancedIntentService";
        r2 = "Exception while binding the service";
        android.util.Log.e(r1, r2, r0);	 Catch:{ all -> 0x00b9 }
    L_0x00a1:
        r0 = r5.zzimr;	 Catch:{ all -> 0x00b9 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x00b9 }
        if (r0 != 0) goto L_0x00b5;
    L_0x00a9:
        r0 = r5.zzimr;	 Catch:{ all -> 0x00b9 }
        r0 = r0.poll();	 Catch:{ all -> 0x00b9 }
        r0 = (com.google.android.gms.iid.zzd) r0;	 Catch:{ all -> 0x00b9 }
        r0.finish();	 Catch:{ all -> 0x00b9 }
        goto L_0x00a1;
    L_0x00b5:
        monitor-exit(r5);
        return;
    L_0x00b7:
        monitor-exit(r5);
        return;
    L_0x00b9:
        r0 = move-exception;
        monitor-exit(r5);
        goto L_0x00bd;
    L_0x00bc:
        throw r0;
    L_0x00bd:
        goto L_0x00bc;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.zzh.zzawo():void");
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this) {
            this.zzimt = false;
            this.zzims = (zzf) iBinder;
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                String valueOf = String.valueOf(componentName);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 20);
                stringBuilder.append("onServiceConnected: ");
                stringBuilder.append(valueOf);
                Log.d("EnhancedIntentService", stringBuilder.toString());
            }
            zzawo();
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        String str = "EnhancedIntentService";
        if (Log.isLoggable(str, 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 23);
            stringBuilder.append("onServiceDisconnected: ");
            stringBuilder.append(valueOf);
            Log.d(str, stringBuilder.toString());
        }
        zzawo();
    }

    public final synchronized void zza(Intent intent, PendingResult pendingResult) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "new intent queued in the bind-strategy delivery");
        }
        this.zzimr.add(new zzd(intent, pendingResult, this.zzimq));
        zzawo();
    }
}
