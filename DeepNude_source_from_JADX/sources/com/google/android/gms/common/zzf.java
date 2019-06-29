package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzak;
import com.google.android.gms.common.util.zzj;

@Hide
public class zzf {
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zzs.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    private static final zzf zzfqz = new zzf();

    zzf() {
    }

    @Hide
    public static Intent zza(Context context, int i, String str) {
        String str2 = "com.google.android.gms";
        return (i == 1 || i == 2) ? (context == null || !zzj.zzcv(context)) ? zzak.zzt(str2, zzq(context, str)) : zzak.zzamw() : i != 3 ? null : zzak.zzgt(str2);
    }

    public static zzf zzahf() {
        return zzfqz;
    }

    public static int zzc(Context context, int i) {
        i = zzs.zzc(context, i);
        return zzs.zzd(context, i) ? 18 : i;
    }

    @Hide
    public static void zzce(Context context) {
        zzs.zzbo(context);
    }

    @Hide
    public static void zzcf(Context context) {
        zzs.zzcf(context);
    }

    @Hide
    public static int zzcg(Context context) {
        return zzs.zzcg(context);
    }

    @Hide
    public static boolean zzd(Context context, int i) {
        return zzs.zzd(context, i);
    }

    private static java.lang.String zzq(android.content.Context r3, java.lang.String r4) {
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
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "gcore_";
        r0.append(r1);
        r1 = GOOGLE_PLAY_SERVICES_VERSION_CODE;
        r0.append(r1);
        r1 = "-";
        r0.append(r1);
        r2 = android.text.TextUtils.isEmpty(r4);
        if (r2 != 0) goto L_0x001d;
    L_0x001a:
        r0.append(r4);
    L_0x001d:
        r0.append(r1);
        if (r3 == 0) goto L_0x0029;
    L_0x0022:
        r4 = r3.getPackageName();
        r0.append(r4);
    L_0x0029:
        r0.append(r1);
        if (r3 == 0) goto L_0x0040;
    L_0x002e:
        r4 = com.google.android.gms.internal.zzbih.zzdd(r3);	 Catch:{ NameNotFoundException -> 0x0040 }
        r3 = r3.getPackageName();	 Catch:{ NameNotFoundException -> 0x0040 }
        r1 = 0;	 Catch:{ NameNotFoundException -> 0x0040 }
        r3 = r4.getPackageInfo(r3, r1);	 Catch:{ NameNotFoundException -> 0x0040 }
        r3 = r3.versionCode;	 Catch:{ NameNotFoundException -> 0x0040 }
        r0.append(r3);	 Catch:{ NameNotFoundException -> 0x0040 }
    L_0x0040:
        r3 = r0.toString();
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.zzf.zzq(android.content.Context, java.lang.String):java.lang.String");
    }

    public PendingIntent getErrorResolutionPendingIntent(Context context, int i, int i2) {
        return zza(context, i, i2, null);
    }

    public String getErrorString(int i) {
        return zzs.getErrorString(i);
    }

    public int isGooglePlayServicesAvailable(Context context) {
        return zzc(context, -1);
    }

    public boolean isUserResolvableError(int i) {
        return zzs.isUserRecoverableError(i);
    }

    @Hide
    public final PendingIntent zza(Context context, int i, int i2, String str) {
        Intent zza = zza(context, i, str);
        return zza == null ? null : PendingIntent.getActivity(context, i2, zza, 268435456);
    }

    @Hide
    @Deprecated
    public final Intent zzbo(int i) {
        return zza(null, i, null);
    }
}
