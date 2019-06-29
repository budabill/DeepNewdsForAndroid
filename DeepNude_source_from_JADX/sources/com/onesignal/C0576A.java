package com.onesignal;

/* renamed from: com.onesignal.A */
class C0576A implements Runnable {
    C0576A() {
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
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r2 = this;
        r0 = com.onesignal.C0582B.m1270a();	 Catch:{ InterruptedException -> 0x0019 }
        r0 = (long) r0;	 Catch:{ InterruptedException -> 0x0019 }
        java.lang.Thread.sleep(r0);	 Catch:{ InterruptedException -> 0x0019 }
        r0 = com.onesignal.sa.C0650i.f1336d;	 Catch:{ InterruptedException -> 0x0019 }
        r1 = "Location permission exists but GoogleApiClient timed out. Maybe related to mismatch google-play aar versions.";	 Catch:{ InterruptedException -> 0x0019 }
        com.onesignal.sa.m1656a(r0, r1);	 Catch:{ InterruptedException -> 0x0019 }
        com.onesignal.C0582B.m1282e();	 Catch:{ InterruptedException -> 0x0019 }
        r0 = com.onesignal.C0582B.m1276b();	 Catch:{ InterruptedException -> 0x0019 }
        com.onesignal.C0582B.m1275a(r0);	 Catch:{ InterruptedException -> 0x0019 }
    L_0x0019:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.A.run():void");
    }
}
