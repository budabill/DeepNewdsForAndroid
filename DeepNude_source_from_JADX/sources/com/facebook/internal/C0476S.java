package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import com.facebook.C0560t;
import com.facebook.C0864u;
import java.util.Collection;
import java.util.List;

/* renamed from: com.facebook.internal.S */
public final class C0476S {
    /* renamed from: a */
    private static final String f849a = "com.facebook.internal.S";

    /* renamed from: a */
    public static String m1014a() {
        String e = C0560t.m1253e();
        if (e != null) {
            return e;
        }
        throw new IllegalStateException("No App ID found, please set the App ID.");
    }

    /* renamed from: a */
    public static void m1015a(android.content.Context r3, boolean r4) {
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
        r0 = "context";
        com.facebook.internal.C0476S.m1016a(r3, r0);
        r0 = r3.getPackageManager();
        if (r0 == 0) goto L_0x0018;
    L_0x000b:
        r1 = new android.content.ComponentName;
        r2 = "com.facebook.FacebookActivity";
        r1.<init>(r3, r2);
        r3 = 1;
        r3 = r0.getActivityInfo(r1, r3);	 Catch:{ NameNotFoundException -> 0x0018 }
        goto L_0x0019;
    L_0x0018:
        r3 = 0;
    L_0x0019:
        if (r3 != 0) goto L_0x002b;
    L_0x001b:
        r3 = "FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.";
        if (r4 != 0) goto L_0x0025;
    L_0x001f:
        r4 = f849a;
        android.util.Log.w(r4, r3);
        goto L_0x002b;
    L_0x0025:
        r4 = new java.lang.IllegalStateException;
        r4.<init>(r3);
        throw r4;
    L_0x002b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.S.a(android.content.Context, boolean):void");
    }

    /* renamed from: a */
    public static void m1016a(Object obj, String str) {
        if (obj == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Argument '");
            stringBuilder.append(str);
            stringBuilder.append("' cannot be null");
            throw new NullPointerException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    public static void m1017a(String str, String str2) {
        if (C0475Q.m998b(str)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Argument '");
            stringBuilder.append(str2);
            stringBuilder.append("' cannot be null or empty");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    public static <T> void m1018a(Collection<T> collection, String str) {
        C0476S.m1016a((Object) collection, str);
        for (T t : collection) {
            if (t == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Container '");
                stringBuilder.append(str);
                stringBuilder.append("' cannot contain null values");
                throw new NullPointerException(stringBuilder.toString());
            }
        }
    }

    /* renamed from: a */
    public static boolean m1019a(Context context) {
        C0476S.m1016a((Object) context, "context");
        PackageManager packageManager = context.getPackageManager();
        List queryIntentActivities;
        if (packageManager != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("fb");
            stringBuilder.append(C0560t.m1253e());
            stringBuilder.append("://authorize");
            intent.setData(Uri.parse(stringBuilder.toString()));
            queryIntentActivities = packageManager.queryIntentActivities(intent, 64);
        } else {
            queryIntentActivities = null;
        }
        boolean z = false;
        if (r0 != null) {
            boolean z2 = false;
            for (ResolveInfo resolveInfo : r0) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (!activityInfo.name.equals("com.facebook.CustomTabActivity") || !activityInfo.packageName.equals(context.getPackageName())) {
                    return false;
                }
                z2 = true;
            }
            z = z2;
        }
        return z;
    }

    /* renamed from: b */
    public static String m1020b() {
        String h = C0560t.m1256h();
        if (h != null) {
            return h;
        }
        throw new IllegalStateException("No Client Token found, please set the Client Token.");
    }

    /* renamed from: b */
    public static void m1021b(Context context, boolean z) {
        C0476S.m1016a((Object) context, "context");
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) {
            String str = "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.";
            if (z) {
                throw new IllegalStateException(str);
            }
            Log.w(f849a, str);
        }
    }

    /* renamed from: b */
    public static <T> void m1022b(Collection<T> collection, String str) {
        if (collection.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Container '");
            stringBuilder.append(str);
            stringBuilder.append("' cannot be empty");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* renamed from: c */
    public static void m1023c() {
        if (!C0560t.m1264p()) {
            throw new C0864u("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
        }
    }

    /* renamed from: c */
    public static <T> void m1024c(Collection<T> collection, String str) {
        C0476S.m1018a((Collection) collection, str);
        C0476S.m1022b((Collection) collection, str);
    }
}
