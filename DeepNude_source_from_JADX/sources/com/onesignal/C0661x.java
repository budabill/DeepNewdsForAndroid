package com.onesignal;

/* renamed from: com.onesignal.x */
class C0661x {
    /* renamed from: a */
    static void m1752a() {
        if (!C0661x.m1755b()) {
            if (C0661x.m1756c()) {
                if (!za.m1773a(za.f1415a, "GT_DO_NOT_SHOW_MISSING_GPS", false)) {
                    aa.m1446a(new C0660w());
                }
            }
        }
    }

    /* renamed from: b */
    private static void m1754b(android.app.Activity r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r0 = com.google.android.gms.common.GoogleApiAvailability.getInstance();	 Catch:{ CanceledException -> 0x0018, Throwable -> 0x0014 }
        r1 = com.onesignal.sa.f1380f;	 Catch:{ CanceledException -> 0x0018, Throwable -> 0x0014 }
        r1 = r0.isGooglePlayServicesAvailable(r1);	 Catch:{ CanceledException -> 0x0018, Throwable -> 0x0014 }
        r2 = 9000; // 0x2328 float:1.2612E-41 double:4.4466E-320;	 Catch:{ CanceledException -> 0x0018, Throwable -> 0x0014 }
        r3 = r0.getErrorResolutionPendingIntent(r3, r1, r2);	 Catch:{ CanceledException -> 0x0018, Throwable -> 0x0014 }
        r3.send();	 Catch:{ CanceledException -> 0x0018, Throwable -> 0x0014 }
        goto L_0x0018;
    L_0x0014:
        r3 = move-exception;
        r3.printStackTrace();
    L_0x0018:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.x.b(android.app.Activity):void");
    }

    /* renamed from: b */
    static boolean m1755b() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r0 = com.onesignal.sa.f1380f;	 Catch:{ NameNotFoundException -> 0x0012 }
        r0 = r0.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0012 }
        r1 = "com.google.android.gms";	 Catch:{ NameNotFoundException -> 0x0012 }
        r2 = 1;	 Catch:{ NameNotFoundException -> 0x0012 }
        r0 = r0.getPackageInfo(r1, r2);	 Catch:{ NameNotFoundException -> 0x0012 }
        r0 = r0.applicationInfo;	 Catch:{ NameNotFoundException -> 0x0012 }
        r0 = r0.enabled;	 Catch:{ NameNotFoundException -> 0x0012 }
        return r0;
    L_0x0012:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.x.b():boolean");
    }

    /* renamed from: c */
    private static boolean m1756c() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r0 = 0;
        r1 = com.onesignal.sa.f1380f;	 Catch:{ Throwable -> 0x0021 }
        r1 = r1.getPackageManager();	 Catch:{ Throwable -> 0x0021 }
        r2 = "com.google.android.gms";	 Catch:{ Throwable -> 0x0021 }
        r3 = 1;	 Catch:{ Throwable -> 0x0021 }
        r2 = r1.getPackageInfo(r2, r3);	 Catch:{ Throwable -> 0x0021 }
        r2 = r2.applicationInfo;	 Catch:{ Throwable -> 0x0021 }
        r1 = r2.loadLabel(r1);	 Catch:{ Throwable -> 0x0021 }
        r1 = (java.lang.String) r1;	 Catch:{ Throwable -> 0x0021 }
        if (r1 == 0) goto L_0x0021;	 Catch:{ Throwable -> 0x0021 }
    L_0x0018:
        r2 = "Market";	 Catch:{ Throwable -> 0x0021 }
        r1 = r1.equals(r2);	 Catch:{ Throwable -> 0x0021 }
        if (r1 != 0) goto L_0x0021;
    L_0x0020:
        r0 = 1;
    L_0x0021:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.x.c():boolean");
    }
}
