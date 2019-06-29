package com.google.android.gms.internal;

import java.util.concurrent.BlockingQueue;

public final class zzd extends Thread {
    private static final boolean DEBUG = zzaf.DEBUG;
    private final BlockingQueue<zzr<?>> zzh;
    private final BlockingQueue<zzr<?>> zzi;
    private final zzb zzj;
    private final zzaa zzk;
    private volatile boolean zzl = false;
    private final zzf zzm;

    public zzd(BlockingQueue<zzr<?>> blockingQueue, BlockingQueue<zzr<?>> blockingQueue2, zzb zzb, zzaa zzaa) {
        this.zzh = blockingQueue;
        this.zzi = blockingQueue2;
        this.zzj = zzb;
        this.zzk = zzaa;
        this.zzm = new zzf(this);
    }

    private final void processRequest() {
        zzr zzr = (zzr) this.zzh.take();
        zzr.zzb("cache-queue-take");
        zzr.isCanceled();
        zzc zza = this.zzj.zza(zzr.getUrl());
        if (zza == null) {
            zzr.zzb("cache-miss");
            if (!this.zzm.zzb(zzr)) {
                this.zzi.put(zzr);
            }
        } else if (zza.zza()) {
            zzr.zzb("cache-hit-expired");
            zzr.zza(zza);
            if (!this.zzm.zzb(zzr)) {
                this.zzi.put(zzr);
            }
        } else {
            zzr.zzb("cache-hit");
            zzx zza2 = zzr.zza(new zzp(zza.data, zza.zzf));
            zzr.zzb("cache-hit-parsed");
            if ((zza.zze < System.currentTimeMillis() ? 1 : null) != null) {
                zzr.zzb("cache-hit-refresh-needed");
                zzr.zza(zza);
                zza2.zzbi = true;
                if (!this.zzm.zzb(zzr)) {
                    this.zzk.zza(zzr, zza2, new zze(this, zzr));
                    return;
                }
            }
            this.zzk.zzb(zzr, zza2);
        }
    }

    public final void quit() {
        this.zzl = true;
        interrupt();
    }

    public final void run() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r2 = this;
        r0 = DEBUG;
        if (r0 == 0) goto L_0x000c;
    L_0x0004:
        r0 = 0;
        r0 = new java.lang.Object[r0];
        r1 = "start new dispatcher";
        com.google.android.gms.internal.zzaf.zza(r1, r0);
    L_0x000c:
        r0 = 10;
        android.os.Process.setThreadPriority(r0);
        r0 = r2.zzj;
        r0.initialize();
    L_0x0016:
        r2.processRequest();	 Catch:{ InterruptedException -> 0x001a }
        goto L_0x0016;
    L_0x001a:
        r0 = r2.zzl;
        if (r0 == 0) goto L_0x0016;
    L_0x001e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzd.run():void");
    }
}
