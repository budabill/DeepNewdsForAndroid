package com.google.android.gms.iid;

final /* synthetic */ class zzr implements Runnable {
    private final zzo zzinl;

    zzr(zzo zzo) {
        this.zzinl = zzo;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r8 = this;
        r0 = r8.zzinl;
    L_0x0002:
        monitor-enter(r0);
        r1 = r0.state;	 Catch:{ all -> 0x00c7 }
        r2 = 2;
        if (r1 == r2) goto L_0x000a;
    L_0x0008:
        monitor-exit(r0);	 Catch:{ all -> 0x00c7 }
        return;
    L_0x000a:
        r1 = r0.zzini;	 Catch:{ all -> 0x00c7 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x00c7 }
        if (r1 == 0) goto L_0x0017;
    L_0x0012:
        r0.zzawu();	 Catch:{ all -> 0x00c7 }
        monitor-exit(r0);	 Catch:{ all -> 0x00c7 }
        return;
    L_0x0017:
        r1 = r0.zzini;	 Catch:{ all -> 0x00c7 }
        r1 = r1.poll();	 Catch:{ all -> 0x00c7 }
        r1 = (com.google.android.gms.iid.zzu) r1;	 Catch:{ all -> 0x00c7 }
        r3 = r0.zzinj;	 Catch:{ all -> 0x00c7 }
        r4 = r1.zzino;	 Catch:{ all -> 0x00c7 }
        r3.put(r4, r1);	 Catch:{ all -> 0x00c7 }
        r3 = r0.zzink;	 Catch:{ all -> 0x00c7 }
        r3 = r3.zzind;	 Catch:{ all -> 0x00c7 }
        r4 = new com.google.android.gms.iid.zzs;	 Catch:{ all -> 0x00c7 }
        r4.<init>(r0, r1);	 Catch:{ all -> 0x00c7 }
        r5 = 30;
        r7 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ all -> 0x00c7 }
        r3.schedule(r4, r5, r7);	 Catch:{ all -> 0x00c7 }
        monitor-exit(r0);	 Catch:{ all -> 0x00c7 }
        r3 = 3;
        r4 = "MessengerIpcClient";
        r3 = android.util.Log.isLoggable(r4, r3);
        if (r3 == 0) goto L_0x0066;
    L_0x0042:
        r3 = java.lang.String.valueOf(r1);
        r4 = java.lang.String.valueOf(r3);
        r4 = r4.length();
        r4 = r4 + 8;
        r5 = new java.lang.StringBuilder;
        r5.<init>(r4);
        r4 = "Sending ";
        r5.append(r4);
        r5.append(r3);
        r3 = r5.toString();
        r4 = "MessengerIpcClient";
        android.util.Log.d(r4, r3);
    L_0x0066:
        r3 = r0.zzink;
        r3 = r3.zzaiq;
        r4 = r0.zzing;
        r5 = android.os.Message.obtain();
        r6 = r1.what;
        r5.what = r6;
        r6 = r1.zzino;
        r5.arg1 = r6;
        r5.replyTo = r4;
        r4 = new android.os.Bundle;
        r4.<init>();
        r6 = r1.zzaww();
        r7 = "oneWay";
        r4.putBoolean(r7, r6);
        r3 = r3.getPackageName();
        r6 = "pkg";
        r4.putString(r6, r3);
        r1 = r1.zzinp;
        r3 = "data";
        r4.putBundle(r3, r1);
        r5.setData(r4);
        r1 = r0.zzinh;	 Catch:{ RemoteException -> 0x00bd }
        r3 = r1.zzinb;	 Catch:{ RemoteException -> 0x00bd }
        if (r3 == 0) goto L_0x00aa;
    L_0x00a3:
        r1 = r1.zzinb;	 Catch:{ RemoteException -> 0x00bd }
        r1.send(r5);	 Catch:{ RemoteException -> 0x00bd }
        goto L_0x0002;
    L_0x00aa:
        r3 = r1.zzinn;	 Catch:{ RemoteException -> 0x00bd }
        if (r3 == 0) goto L_0x00b5;
    L_0x00ae:
        r1 = r1.zzinn;	 Catch:{ RemoteException -> 0x00bd }
        r1.send(r5);	 Catch:{ RemoteException -> 0x00bd }
        goto L_0x0002;
    L_0x00b5:
        r1 = new java.lang.IllegalStateException;	 Catch:{ RemoteException -> 0x00bd }
        r3 = "Both messengers are null";
        r1.<init>(r3);	 Catch:{ RemoteException -> 0x00bd }
        throw r1;	 Catch:{ RemoteException -> 0x00bd }
    L_0x00bd:
        r1 = move-exception;
        r1 = r1.getMessage();
        r0.zzl(r2, r1);
        goto L_0x0002;
    L_0x00c7:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00c7 }
        goto L_0x00cb;
    L_0x00ca:
        throw r1;
    L_0x00cb:
        goto L_0x00ca;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.zzr.run():void");
    }
}
