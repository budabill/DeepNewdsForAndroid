package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import com.google.android.gms.internal.zzbih;

public final class zzz {
    @TargetApi(19)
    public static boolean zzb(Context context, int i, String str) {
        return zzbih.zzdd(context).zzf(i, str);
    }

    public static boolean zze(android.content.Context r3, int r4) {
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
        r0 = "com.google.android.gms";
        r4 = zzb(r3, r4, r0);
        r1 = 0;
        if (r4 != 0) goto L_0x000a;
    L_0x0009:
        return r1;
    L_0x000a:
        r4 = r3.getPackageManager();
        r2 = 64;
        r4 = r4.getPackageInfo(r0, r2);	 Catch:{ NameNotFoundException -> 0x001d }
        r3 = com.google.android.gms.common.zzt.zzcj(r3);
        r3 = r3.zza(r4);
        return r3;
    L_0x001d:
        r3 = 3;
        r4 = "UidVerifier";
        r3 = android.util.Log.isLoggable(r4, r3);
        if (r3 == 0) goto L_0x002b;
    L_0x0026:
        r3 = "Package manager can't find google play services package, defaulting to false";
        android.util.Log.d(r4, r3);
    L_0x002b:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.zzz.zze(android.content.Context, int):boolean");
    }
}
