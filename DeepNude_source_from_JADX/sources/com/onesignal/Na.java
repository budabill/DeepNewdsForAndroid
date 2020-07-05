package com.onesignal;

class na implements Runnable {
    /* renamed from: a */
    final /* synthetic */ oa f1276a;

    na(oa oaVar) {
        this.f1276a = oaVar;
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
        r4 = this;
        r0 = com.onesignal.sa.ca;	 Catch:{ Throwable -> 0x0031 }
        r0 = r0 * 10000;	 Catch:{ Throwable -> 0x0031 }
        r0 = r0 + 30000;	 Catch:{ Throwable -> 0x0031 }
        r1 = 90000; // 0x15f90 float:1.26117E-40 double:4.4466E-319;	 Catch:{ Throwable -> 0x0031 }
        if (r0 <= r1) goto L_0x0010;	 Catch:{ Throwable -> 0x0031 }
    L_0x000d:
        r0 = 90000; // 0x15f90 float:1.26117E-40 double:4.4466E-319;	 Catch:{ Throwable -> 0x0031 }
    L_0x0010:
        r1 = com.onesignal.sa.C0650i.INFO;	 Catch:{ Throwable -> 0x0031 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0031 }
        r2.<init>();	 Catch:{ Throwable -> 0x0031 }
        r3 = "Failed to get Android parameters, trying again in ";	 Catch:{ Throwable -> 0x0031 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0031 }
        r3 = r0 / 1000;	 Catch:{ Throwable -> 0x0031 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0031 }
        r3 = " seconds.";	 Catch:{ Throwable -> 0x0031 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0031 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x0031 }
        com.onesignal.sa.m1656a(r1, r2);	 Catch:{ Throwable -> 0x0031 }
        r0 = (long) r0;	 Catch:{ Throwable -> 0x0031 }
        java.lang.Thread.sleep(r0);	 Catch:{ Throwable -> 0x0031 }
    L_0x0031:
        com.onesignal.sa.m1683c();
        com.onesignal.sa.m1632Q();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.na.run():void");
    }
}
