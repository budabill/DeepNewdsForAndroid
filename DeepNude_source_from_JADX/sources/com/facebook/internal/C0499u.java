package com.facebook.internal;

import java.util.HashSet;

/* renamed from: com.facebook.internal.u */
public class C0499u {
    /* renamed from: a */
    private static final HashSet<String> f913a = C0499u.m1089a();

    /* renamed from: a */
    private static HashSet<String> m1089a() {
        HashSet<String> hashSet = new HashSet();
        hashSet.add("8a3c4b262d721acd49a4bf97d5213199c86fa2b9");
        hashSet.add("cc2751449a350f668590264ed76692694a80308a");
        hashSet.add("a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc");
        hashSet.add("5e8f16062ea3cd2c4a0d547876baa6f38cabf625");
        hashSet.add("df6b721c8b4d3b6eb44c861d4415007e5a35fc95");
        hashSet.add("9b8f518b086098de3d77736f9458a3d2f6f95a37");
        hashSet.add("2438bce1ddb7bd026d5ff89f598b3b5e5bb824b3");
        return hashSet;
    }

    /* renamed from: a */
    public static boolean m1090a(android.content.Context r5, java.lang.String r6) {
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
        r0 = android.os.Build.BRAND;
        r1 = r5.getApplicationInfo();
        r1 = r1.flags;
        r2 = "generic";
        r0 = r0.startsWith(r2);
        r2 = 1;
        if (r0 == 0) goto L_0x0016;
    L_0x0011:
        r0 = r1 & 2;
        if (r0 == 0) goto L_0x0016;
    L_0x0015:
        return r2;
    L_0x0016:
        r0 = 0;
        r5 = r5.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0044 }
        r1 = 64;	 Catch:{ NameNotFoundException -> 0x0044 }
        r5 = r5.getPackageInfo(r6, r1);	 Catch:{ NameNotFoundException -> 0x0044 }
        r5 = r5.signatures;
        if (r5 == 0) goto L_0x0044;
    L_0x0025:
        r6 = r5.length;
        if (r6 > 0) goto L_0x0029;
    L_0x0028:
        goto L_0x0044;
    L_0x0029:
        r6 = r5.length;
        r1 = 0;
    L_0x002b:
        if (r1 >= r6) goto L_0x0043;
    L_0x002d:
        r3 = r5[r1];
        r3 = r3.toByteArray();
        r3 = com.facebook.internal.C0475Q.m967a(r3);
        r4 = f913a;
        r3 = r4.contains(r3);
        if (r3 != 0) goto L_0x0040;
    L_0x003f:
        return r0;
    L_0x0040:
        r1 = r1 + 1;
        goto L_0x002b;
    L_0x0043:
        return r2;
    L_0x0044:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.u.a(android.content.Context, java.lang.String):boolean");
    }
}
