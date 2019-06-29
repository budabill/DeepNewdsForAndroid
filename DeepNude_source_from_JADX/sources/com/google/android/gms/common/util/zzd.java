package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.google.android.gms.common.internal.Hide;

@Hide
public final class zzd {
    public static int zzt(Context context, String str) {
        PackageInfo zzu = zzu(context, str);
        if (zzu != null) {
            ApplicationInfo applicationInfo = zzu.applicationInfo;
            if (applicationInfo != null) {
                Bundle bundle = applicationInfo.metaData;
                return bundle == null ? -1 : bundle.getInt("com.google.android.gms.version", -1);
            }
        }
        return -1;
    }

    private static android.content.pm.PackageInfo zzu(android.content.Context r1, java.lang.String r2) {
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
        r1 = com.google.android.gms.internal.zzbih.zzdd(r1);	 Catch:{ NameNotFoundException -> 0x000b }
        r0 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ NameNotFoundException -> 0x000b }
        r1 = r1.getPackageInfo(r2, r0);	 Catch:{ NameNotFoundException -> 0x000b }
        return r1;
    L_0x000b:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.zzd.zzu(android.content.Context, java.lang.String):android.content.pm.PackageInfo");
    }

    public static boolean zzv(android.content.Context r1, java.lang.String r2) {
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
        r0 = "com.google.android.gms";
        r0.equals(r2);
        r0 = 0;
        r1 = com.google.android.gms.internal.zzbih.zzdd(r1);	 Catch:{ NameNotFoundException -> 0x0017 }
        r1 = r1.getApplicationInfo(r2, r0);	 Catch:{ NameNotFoundException -> 0x0017 }
        r1 = r1.flags;	 Catch:{ NameNotFoundException -> 0x0017 }
        r2 = 2097152; // 0x200000 float:2.938736E-39 double:1.0361308E-317;
        r1 = r1 & r2;
        if (r1 == 0) goto L_0x0017;
    L_0x0015:
        r1 = 1;
        return r1;
    L_0x0017:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.zzd.zzv(android.content.Context, java.lang.String):boolean");
    }
}
