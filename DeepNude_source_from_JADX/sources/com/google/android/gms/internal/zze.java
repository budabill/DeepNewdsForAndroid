package com.google.android.gms.internal;

final class zze implements Runnable {
    private /* synthetic */ zzr zzn;
    private /* synthetic */ zzd zzo;

    zze(zzd zzd, zzr zzr) {
        this.zzo = zzd;
        this.zzn = zzr;
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
        r0 = r2.zzo;	 Catch:{ InterruptedException -> 0x000c }
        r0 = r0.zzi;	 Catch:{ InterruptedException -> 0x000c }
        r1 = r2.zzn;	 Catch:{ InterruptedException -> 0x000c }
        r0.put(r1);	 Catch:{ InterruptedException -> 0x000c }
        return;
    L_0x000c:
        r0 = java.lang.Thread.currentThread();
        r0.interrupt();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zze.run():void");
    }
}
