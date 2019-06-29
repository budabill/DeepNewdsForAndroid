package com.facebook.p029a.p032b;

import android.os.Build;
import android.support.v4.os.EnvironmentCompat;

/* renamed from: com.facebook.a.b.i */
public class C0383i {
    /* renamed from: a */
    public static double m687a(java.lang.String r4) {
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
        r2 = "[-+]*\\d+([\\,\\.]\\d+)*([\\.\\,]\\d+)?";	 Catch:{ ParseException -> 0x0029 }
        r3 = 8;	 Catch:{ ParseException -> 0x0029 }
        r2 = java.util.regex.Pattern.compile(r2, r3);	 Catch:{ ParseException -> 0x0029 }
        r4 = r2.matcher(r4);	 Catch:{ ParseException -> 0x0029 }
        r2 = r4.find();	 Catch:{ ParseException -> 0x0029 }
        if (r2 == 0) goto L_0x0029;	 Catch:{ ParseException -> 0x0029 }
    L_0x0014:
        r2 = 0;	 Catch:{ ParseException -> 0x0029 }
        r4 = r4.group(r2);	 Catch:{ ParseException -> 0x0029 }
        r2 = com.facebook.internal.C0475Q.m973a();	 Catch:{ ParseException -> 0x0029 }
        r2 = java.text.NumberFormat.getNumberInstance(r2);	 Catch:{ ParseException -> 0x0029 }
        r4 = r2.parse(r4);	 Catch:{ ParseException -> 0x0029 }
        r0 = r4.doubleValue();	 Catch:{ ParseException -> 0x0029 }
    L_0x0029:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.a.b.i.a(java.lang.String):double");
    }

    /* renamed from: a */
    public static String m688a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static void m689a() {
    }

    /* renamed from: b */
    public static void m690b() {
    }

    /* renamed from: c */
    public static java.lang.String m691c() {
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
        r0 = com.facebook.C0560t.m1252d();
        r1 = r0.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0014 }
        r0 = r0.getPackageName();	 Catch:{ NameNotFoundException -> 0x0014 }
        r2 = 0;	 Catch:{ NameNotFoundException -> 0x0014 }
        r0 = r1.getPackageInfo(r0, r2);	 Catch:{ NameNotFoundException -> 0x0014 }
        r0 = r0.versionName;	 Catch:{ NameNotFoundException -> 0x0014 }
        return r0;
    L_0x0014:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.a.b.i.c():java.lang.String");
    }

    /* renamed from: d */
    public static boolean m692d() {
        String str = "generic";
        if (!(Build.FINGERPRINT.startsWith(str) || Build.FINGERPRINT.startsWith(EnvironmentCompat.MEDIA_UNKNOWN))) {
            Object obj = "google_sdk";
            if (!(Build.MODEL.contains(obj) || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || (Build.BRAND.startsWith(str) && Build.DEVICE.startsWith(str)))) {
                if (!obj.equals(Build.PRODUCT)) {
                    return false;
                }
            }
        }
        return true;
    }
}
