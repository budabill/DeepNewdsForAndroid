package com.onesignal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import com.onesignal.sa.C0650i;
import java.util.Locale;
import java.util.UUID;

class aa {
    aa() {
    }

    /* renamed from: a */
    static String m1443a(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString(str);
        } catch (Throwable th) {
            sa.m1657a(C0650i.ERROR, "", th);
            return null;
        }
    }

    /* renamed from: a */
    static String m1444a(Context context, String str, String str2) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(str, "string", context.getPackageName());
        return identifier != 0 ? resources.getString(identifier) : str2;
    }

    /* renamed from: a */
    static void m1445a(int i) {
        try {
            Thread.sleep((long) i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    static void m1446a(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    /* renamed from: a */
    static boolean m1447a(android.content.Context r0) {
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
        r0 = com.onesignal.sa.f1380f;	 Catch:{ Throwable -> 0x000b }
        r0 = android.support.v4.app.NotificationManagerCompat.from(r0);	 Catch:{ Throwable -> 0x000b }
        r0 = r0.areNotificationsEnabled();	 Catch:{ Throwable -> 0x000b }
        return r0;
    L_0x000b:
        r0 = 1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.aa.a(android.content.Context):boolean");
    }

    /* renamed from: a */
    static boolean m1448a(String str) {
        return (str == null || str.matches("^[0-9]")) ? false : true;
    }

    /* renamed from: a */
    static long[] m1449a(org.json.JSONObject r4) {
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
        r0 = "vib_pt";	 Catch:{ JSONException -> 0x002c }
        r4 = r4.opt(r0);	 Catch:{ JSONException -> 0x002c }
        r0 = r4 instanceof java.lang.String;	 Catch:{ JSONException -> 0x002c }
        if (r0 == 0) goto L_0x0012;	 Catch:{ JSONException -> 0x002c }
    L_0x000a:
        r0 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x002c }
        r4 = (java.lang.String) r4;	 Catch:{ JSONException -> 0x002c }
        r0.<init>(r4);	 Catch:{ JSONException -> 0x002c }
        goto L_0x0015;	 Catch:{ JSONException -> 0x002c }
    L_0x0012:
        r0 = r4;	 Catch:{ JSONException -> 0x002c }
        r0 = (org.json.JSONArray) r0;	 Catch:{ JSONException -> 0x002c }
    L_0x0015:
        r4 = r0.length();	 Catch:{ JSONException -> 0x002c }
        r4 = new long[r4];	 Catch:{ JSONException -> 0x002c }
        r1 = 0;	 Catch:{ JSONException -> 0x002c }
    L_0x001c:
        r2 = r0.length();	 Catch:{ JSONException -> 0x002c }
        if (r1 >= r2) goto L_0x002b;	 Catch:{ JSONException -> 0x002c }
    L_0x0022:
        r2 = r0.optLong(r1);	 Catch:{ JSONException -> 0x002c }
        r4[r1] = r2;	 Catch:{ JSONException -> 0x002c }
        r1 = r1 + 1;
        goto L_0x001c;
    L_0x002b:
        return r4;
    L_0x002c:
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.aa.a(org.json.JSONObject):long[]");
    }

    /* renamed from: b */
    static int m1450b(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return 15;
        }
    }

    /* renamed from: b */
    static Uri m1451b(Context context, String str) {
        int identifier;
        Resources resources = context.getResources();
        String packageName = context.getPackageName();
        String str2 = "/";
        String str3 = "android.resource://";
        String str4 = "raw";
        if (m1448a(str)) {
            identifier = resources.getIdentifier(str, str4, packageName);
            if (identifier != 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str3);
                stringBuilder.append(packageName);
                stringBuilder.append(str2);
                stringBuilder.append(identifier);
                return Uri.parse(stringBuilder.toString());
            }
        }
        identifier = resources.getIdentifier("onesignal_default_sound", str4, packageName);
        if (identifier == 0) {
            return null;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str3);
        stringBuilder.append(packageName);
        stringBuilder.append(str2);
        stringBuilder.append(identifier);
        return Uri.parse(stringBuilder.toString());
    }

    /* renamed from: c */
    private Integer m1452c(Context context) {
        boolean j = m1458j();
        boolean i = m1457i();
        if (j || i) {
            String str = "The included Android Support Library is to old or incomplete. Please update to the 26.0.0 revision or newer.";
            if (j) {
                if (i) {
                    if (VERSION.SDK_INT < 26 || m1450b(context) < 26 || m1456h()) {
                        return null;
                    }
                    sa.m1656a(C0650i.FATAL, str);
                    return Integer.valueOf(-5);
                }
            }
            sa.m1656a(C0650i.FATAL, str);
            return Integer.valueOf(-5);
        }
        sa.m1656a(C0650i.FATAL, "Could not find the Android Support Library. Please make sure it has been correctly added to your project.");
        return Integer.valueOf(-3);
    }

    /* renamed from: c */
    static String m1453c() {
        String language = Locale.getDefault().getLanguage();
        if (language.equals("iw")) {
            return "he";
        }
        if (language.equals("in")) {
            return "id";
        }
        if (language.equals("ji")) {
            return "yi";
        }
        if (language.equals("zh")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(language);
            stringBuilder.append("-");
            stringBuilder.append(Locale.getDefault().getCountry());
            language = stringBuilder.toString();
        }
        return language;
    }

    /* renamed from: f */
    static boolean m1454f() {
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
        r0 = com.google.firebase.messaging.FirebaseMessaging.class;	 Catch:{ Throwable -> 0x0004 }
        r0 = 1;
        return r0;
    L_0x0004:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.aa.f():boolean");
    }

    /* renamed from: g */
    private static boolean m1455g() {
        return true;
    }

    /* renamed from: h */
    private static boolean m1456h() {
        return true;
    }

    /* renamed from: i */
    private static boolean m1457i() {
        return true;
    }

    /* renamed from: j */
    private static boolean m1458j() {
        return true;
    }

    /* renamed from: a */
    int m1459a(Context context, int i, String str) {
        try {
            UUID.fromString(str);
            if ("b2f7f966-d8cc-11e4-bed1-df8f05be55ba".equals(str) || "5eb5a37e-b458-11e3-ac11-000c2940e62c".equals(str)) {
                sa.m1656a(C0650i.ERROR, "OneSignal Example AppID detected, please update to your app's id found on OneSignal.com");
            }
            int i2 = 1;
            if (i == 1) {
                Integer a = m1460a();
                if (a != null) {
                    i2 = a.intValue();
                }
            }
            Integer c = m1452c(context);
            if (c != null) {
                i2 = c.intValue();
            }
            return i2;
        } catch (Throwable th) {
            sa.m1657a(C0650i.FATAL, "OneSignal AppId format is invalid.\nExample: 'b2f7f966-d8cc-11e4-bed1-df8f05be55ba'\n", th);
            return -999;
        }
    }

    /* renamed from: a */
    Integer m1460a() {
        boolean f = m1454f();
        boolean g = m1455g();
        if (f || g) {
            if (g && !f) {
                sa.m1656a(C0650i.WARN, "GCM Library detected, please upgrade to Firebase FCM library as GCM is deprecated!");
            }
            if (g && f) {
                sa.m1656a(C0650i.WARN, "Both GCM & FCM Libraries detected! Please remove the deprecated GCM library.");
            }
            return null;
        }
        sa.m1656a(C0650i.FATAL, "The Firebase FCM library is missing! Please make sure to include it in your project.");
        return Integer.valueOf(-4);
    }

    /* renamed from: b */
    String m1461b() {
        String str = null;
        try {
            String networkOperatorName = ((TelephonyManager) sa.f1380f.getSystemService("phone")).getNetworkOperatorName();
            if (!"".equals(networkOperatorName)) {
                str = networkOperatorName;
            }
            return str;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: d */
    int m1462d() {
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
        r1 = this;
        r0 = "com.amazon.device.messaging.ADM";
        java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0007 }
        r0 = 2;
        return r0;
    L_0x0007:
        r0 = 1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.aa.d():int");
    }

    /* renamed from: e */
    Integer m1463e() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) sa.f1380f.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return null;
        }
        int type = activeNetworkInfo.getType();
        if (type != 1) {
            if (type != 9) {
                return Integer.valueOf(1);
            }
        }
        return Integer.valueOf(0);
    }
}
