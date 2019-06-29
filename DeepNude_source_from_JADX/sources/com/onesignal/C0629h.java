package com.onesignal;

import android.content.Context;
import android.os.Build.VERSION;

/* renamed from: com.onesignal.h */
class C0629h {
    /* renamed from: a */
    static int m1520a(Context context, int i) {
        return VERSION.SDK_INT > 22 ? context.getColor(i) : context.getResources().getColor(i);
    }

    /* renamed from: a */
    static int m1521a(android.content.Context r2, java.lang.String r3) {
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
        r0 = android.os.Process.myPid();	 Catch:{ Throwable -> 0x000d }
        r1 = android.os.Process.myUid();	 Catch:{ Throwable -> 0x000d }
        r2 = r2.checkPermission(r3, r0, r1);	 Catch:{ Throwable -> 0x000d }
        return r2;
    L_0x000d:
        r2 = "OneSignal";
        r3 = "checkSelfPermission failed, returning PERMISSION_DENIED";
        android.util.Log.e(r2, r3);
        r2 = -1;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.h.a(android.content.Context, java.lang.String):int");
    }
}
