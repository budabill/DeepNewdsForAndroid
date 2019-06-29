package com.google.android.gms.internal;

import android.net.TrafficStats;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public final class zzn extends Thread {
    private final zzm zzaa;
    private final zzb zzj;
    private final zzaa zzk;
    private volatile boolean zzl = false;
    private final BlockingQueue<zzr<?>> zzz;

    public zzn(BlockingQueue<zzr<?>> blockingQueue, zzm zzm, zzb zzb, zzaa zzaa) {
        this.zzz = blockingQueue;
        this.zzaa = zzm;
        this.zzj = zzb;
        this.zzk = zzaa;
    }

    private final void processRequest() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        zzr zzr = (zzr) this.zzz.take();
        try {
            zzr.zzb("network-queue-take");
            zzr.isCanceled();
            TrafficStats.setThreadStatsTag(zzr.zzd());
            zzp zzc = this.zzaa.zzc(zzr);
            zzr.zzb("network-http-complete");
            if (zzc.zzac && zzr.zzk()) {
                zzr.zzc("not-modified");
                zzr.zzl();
                return;
            }
            zzx zza = zzr.zza(zzc);
            zzr.zzb("network-parse-complete");
            if (zzr.zzg() && zza.zzbg != null) {
                this.zzj.zza(zzr.getUrl(), zza.zzbg);
                zzr.zzb("network-cache-written");
            }
            zzr.zzj();
            this.zzk.zzb(zzr, zza);
            zzr.zza(zza);
        } catch (zzae e) {
            e.zza(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.zzk.zza(zzr, e);
            zzr.zzl();
        } catch (Throwable e2) {
            zzaf.zza(e2, "Unhandled exception %s", e2.toString());
            zzae zzae = new zzae(e2);
            zzae.zza(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.zzk.zza(zzr, zzae);
            zzr.zzl();
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
        r1 = this;
        r0 = 10;
        android.os.Process.setThreadPriority(r0);
    L_0x0005:
        r1.processRequest();	 Catch:{ InterruptedException -> 0x0009 }
        goto L_0x0005;
    L_0x0009:
        r0 = r1.zzl;
        if (r0 == 0) goto L_0x0005;
    L_0x000d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzn.run():void");
    }
}
