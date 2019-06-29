package com.google.android.gms.iid;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.stats.zza;
import java.util.ArrayDeque;
import java.util.Queue;

final class zzo implements ServiceConnection {
    int state;
    final Messenger zzing;
    zzt zzinh;
    final Queue<zzu<?>> zzini;
    final SparseArray<zzu<?>> zzinj;
    final /* synthetic */ zzm zzink;

    private zzo(zzm zzm) {
        this.zzink = zzm;
        this.state = 0;
        this.zzing = new Messenger(new Handler(Looper.getMainLooper(), new zzp(this)));
        this.zzini = new ArrayDeque();
        this.zzinj = new SparseArray();
    }

    private final void zza(zzv zzv) {
        for (zzu zzb : this.zzini) {
            zzb.zzb(zzv);
        }
        this.zzini.clear();
        for (int i = 0; i < this.zzinj.size(); i++) {
            ((zzu) this.zzinj.valueAt(i)).zzb(zzv);
        }
        this.zzinj.clear();
    }

    private final void zzawt() {
        this.zzink.zzind.execute(new zzr(this));
    }

    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        if (iBinder == null) {
            zzl(0, "Null service connection");
            return;
        }
        try {
            this.zzinh = new zzt(iBinder);
            this.state = 2;
            zzawt();
        } catch (RemoteException e) {
            zzl(0, e.getMessage());
        }
    }

    public final synchronized void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        zzl(2, "Service disconnected");
    }

    final synchronized void zzawu() {
        if (this.state == 2 && this.zzini.isEmpty() && this.zzinj.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.state = 3;
            zza.zzanm();
            this.zzink.zzaiq.unbindService(this);
        }
    }

    final synchronized void zzawv() {
        if (this.state == 1) {
            zzl(1, "Timed out while binding");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final synchronized boolean zzb(com.google.android.gms.iid.zzu r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.state;	 Catch:{ all -> 0x0097 }
        r1 = 2;
        r2 = 0;
        r3 = 1;
        if (r0 == 0) goto L_0x0041;
    L_0x0008:
        if (r0 == r3) goto L_0x003a;
    L_0x000a:
        if (r0 == r1) goto L_0x0030;
    L_0x000c:
        r6 = 3;
        if (r0 == r6) goto L_0x002e;
    L_0x000f:
        r6 = 4;
        if (r0 != r6) goto L_0x0013;
    L_0x0012:
        goto L_0x002e;
    L_0x0013:
        r6 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0097 }
        r0 = r5.state;	 Catch:{ all -> 0x0097 }
        r1 = 26;
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0097 }
        r2.<init>(r1);	 Catch:{ all -> 0x0097 }
        r1 = "Unknown state: ";
        r2.append(r1);	 Catch:{ all -> 0x0097 }
        r2.append(r0);	 Catch:{ all -> 0x0097 }
        r0 = r2.toString();	 Catch:{ all -> 0x0097 }
        r6.<init>(r0);	 Catch:{ all -> 0x0097 }
        throw r6;	 Catch:{ all -> 0x0097 }
    L_0x002e:
        monitor-exit(r5);
        return r2;
    L_0x0030:
        r0 = r5.zzini;	 Catch:{ all -> 0x0097 }
        r0.add(r6);	 Catch:{ all -> 0x0097 }
        r5.zzawt();	 Catch:{ all -> 0x0097 }
        monitor-exit(r5);
        return r3;
    L_0x003a:
        r0 = r5.zzini;	 Catch:{ all -> 0x0097 }
        r0.add(r6);	 Catch:{ all -> 0x0097 }
        monitor-exit(r5);
        return r3;
    L_0x0041:
        r0 = r5.zzini;	 Catch:{ all -> 0x0097 }
        r0.add(r6);	 Catch:{ all -> 0x0097 }
        r6 = r5.state;	 Catch:{ all -> 0x0097 }
        if (r6 != 0) goto L_0x004c;
    L_0x004a:
        r6 = 1;
        goto L_0x004d;
    L_0x004c:
        r6 = 0;
    L_0x004d:
        com.google.android.gms.common.internal.zzbq.checkState(r6);	 Catch:{ all -> 0x0097 }
        r6 = "MessengerIpcClient";
        r6 = android.util.Log.isLoggable(r6, r1);	 Catch:{ all -> 0x0097 }
        if (r6 == 0) goto L_0x005f;
    L_0x0058:
        r6 = "MessengerIpcClient";
        r0 = "Starting bind to GmsCore";
        android.util.Log.v(r6, r0);	 Catch:{ all -> 0x0097 }
    L_0x005f:
        r5.state = r3;	 Catch:{ all -> 0x0097 }
        r6 = new android.content.Intent;	 Catch:{ all -> 0x0097 }
        r0 = "com.google.android.c2dm.intent.REGISTER";
        r6.<init>(r0);	 Catch:{ all -> 0x0097 }
        r0 = "com.google.android.gms";
        r6.setPackage(r0);	 Catch:{ all -> 0x0097 }
        r0 = com.google.android.gms.common.stats.zza.zzanm();	 Catch:{ all -> 0x0097 }
        r1 = r5.zzink;	 Catch:{ all -> 0x0097 }
        r1 = r1.zzaiq;	 Catch:{ all -> 0x0097 }
        r6 = r0.zza(r1, r6, r5, r3);	 Catch:{ all -> 0x0097 }
        if (r6 != 0) goto L_0x0083;
    L_0x007d:
        r6 = "Unable to bind to service";
        r5.zzl(r2, r6);	 Catch:{ all -> 0x0097 }
        goto L_0x0095;
    L_0x0083:
        r6 = r5.zzink;	 Catch:{ all -> 0x0097 }
        r6 = r6.zzind;	 Catch:{ all -> 0x0097 }
        r0 = new com.google.android.gms.iid.zzq;	 Catch:{ all -> 0x0097 }
        r0.<init>(r5);	 Catch:{ all -> 0x0097 }
        r1 = 30;
        r4 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ all -> 0x0097 }
        r6.schedule(r0, r1, r4);	 Catch:{ all -> 0x0097 }
    L_0x0095:
        monitor-exit(r5);
        return r3;
    L_0x0097:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.zzo.zzb(com.google.android.gms.iid.zzu):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final boolean zzc(android.os.Message r5) {
        /*
        r4 = this;
        r0 = r5.arg1;
        r1 = "MessengerIpcClient";
        r2 = 3;
        r1 = android.util.Log.isLoggable(r1, r2);
        if (r1 == 0) goto L_0x0023;
    L_0x000b:
        r1 = 41;
        r2 = new java.lang.StringBuilder;
        r2.<init>(r1);
        r1 = "Received response to request: ";
        r2.append(r1);
        r2.append(r0);
        r1 = r2.toString();
        r2 = "MessengerIpcClient";
        android.util.Log.d(r2, r1);
    L_0x0023:
        monitor-enter(r4);
        r1 = r4.zzinj;	 Catch:{ all -> 0x006f }
        r1 = r1.get(r0);	 Catch:{ all -> 0x006f }
        r1 = (com.google.android.gms.iid.zzu) r1;	 Catch:{ all -> 0x006f }
        r2 = 1;
        if (r1 != 0) goto L_0x0049;
    L_0x002f:
        r5 = "MessengerIpcClient";
        r1 = 50;
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x006f }
        r3.<init>(r1);	 Catch:{ all -> 0x006f }
        r1 = "Received response for unknown request: ";
        r3.append(r1);	 Catch:{ all -> 0x006f }
        r3.append(r0);	 Catch:{ all -> 0x006f }
        r0 = r3.toString();	 Catch:{ all -> 0x006f }
        android.util.Log.w(r5, r0);	 Catch:{ all -> 0x006f }
        monitor-exit(r4);	 Catch:{ all -> 0x006f }
        return r2;
    L_0x0049:
        r3 = r4.zzinj;	 Catch:{ all -> 0x006f }
        r3.remove(r0);	 Catch:{ all -> 0x006f }
        r4.zzawu();	 Catch:{ all -> 0x006f }
        monitor-exit(r4);	 Catch:{ all -> 0x006f }
        r5 = r5.getData();
        r0 = 0;
        r3 = "unsupported";
        r0 = r5.getBoolean(r3, r0);
        if (r0 == 0) goto L_0x006b;
    L_0x005f:
        r5 = new com.google.android.gms.iid.zzv;
        r0 = 4;
        r3 = "Not supported by GmsCore";
        r5.<init>(r0, r3);
        r1.zzb(r5);
        goto L_0x006e;
    L_0x006b:
        r1.zzx(r5);
    L_0x006e:
        return r2;
    L_0x006f:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x006f }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.zzo.zzc(android.os.Message):boolean");
    }

    final synchronized void zzec(int i) {
        zzu zzu = (zzu) this.zzinj.get(i);
        if (zzu != null) {
            StringBuilder stringBuilder = new StringBuilder(31);
            stringBuilder.append("Timing out request: ");
            stringBuilder.append(i);
            Log.w("MessengerIpcClient", stringBuilder.toString());
            this.zzinj.remove(i);
            zzu.zzb(new zzv(3, "Timed out waiting for response"));
            zzawu();
        }
    }

    final synchronized void zzl(int i, String str) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String str2 = "MessengerIpcClient";
            String str3 = "Disconnected: ";
            String valueOf = String.valueOf(str);
            Log.d(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        }
        int i2 = this.state;
        if (i2 == 0) {
            throw new IllegalStateException();
        } else if (i2 == 1 || i2 == 2) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Unbinding service");
            }
            this.state = 4;
            zza.zzanm();
            this.zzink.zzaiq.unbindService(this);
            zza(new zzv(i, str));
        } else if (i2 == 3) {
            this.state = 4;
        } else if (i2 != 4) {
            int i3 = this.state;
            StringBuilder stringBuilder = new StringBuilder(26);
            stringBuilder.append("Unknown state: ");
            stringBuilder.append(i3);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }
}
