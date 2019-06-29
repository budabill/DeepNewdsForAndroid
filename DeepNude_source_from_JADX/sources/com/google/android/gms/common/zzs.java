package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.util.zzz;
import com.google.android.gms.internal.zzbih;
import java.util.concurrent.atomic.AtomicBoolean;

@Hide
public class zzs {
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 12211000;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    @Hide
    private static boolean zzfrr = false;
    @Hide
    private static boolean zzfrs = false;
    private static boolean zzfrt = false;
    private static boolean zzfru = false;
    static final AtomicBoolean zzfrv = new AtomicBoolean();
    private static final AtomicBoolean zzfrw = new AtomicBoolean();

    zzs() {
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return zzf.zzahf().getErrorResolutionPendingIntent(context, i, i2);
    }

    @Deprecated
    public static String getErrorString(int i) {
        return ConnectionResult.getStatusString(i);
    }

    public static android.content.Context getRemoteContext(android.content.Context r2) {
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
        r0 = "com.google.android.gms";	 Catch:{ NameNotFoundException -> 0x0008 }
        r1 = 3;	 Catch:{ NameNotFoundException -> 0x0008 }
        r2 = r2.createPackageContext(r0, r1);	 Catch:{ NameNotFoundException -> 0x0008 }
        return r2;
    L_0x0008:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.zzs.getRemoteContext(android.content.Context):android.content.Context");
    }

    public static android.content.res.Resources getRemoteResource(android.content.Context r1) {
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
        r1 = r1.getPackageManager();	 Catch:{ NameNotFoundException -> 0x000b }
        r0 = "com.google.android.gms";	 Catch:{ NameNotFoundException -> 0x000b }
        r1 = r1.getResourcesForApplication(r0);	 Catch:{ NameNotFoundException -> 0x000b }
        return r1;
    L_0x000b:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.zzs.getRemoteResource(android.content.Context):android.content.res.Resources");
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        return zzc(context, -1);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        return i == 1 || i == 2 || i == 3 || i == 9;
    }

    private static int zza(android.content.Context r9, boolean r10, int r11, int r12) {
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
        r1 = -1;
        r2 = 0;
        r3 = 1;
        if (r12 == r1) goto L_0x000c;
    L_0x0007:
        if (r12 < 0) goto L_0x000a;
    L_0x0009:
        goto L_0x000c;
    L_0x000a:
        r4 = 0;
        goto L_0x000d;
    L_0x000c:
        r4 = 1;
    L_0x000d:
        com.google.android.gms.common.internal.zzbq.checkArgument(r4);
        r4 = r9.getPackageManager();
        r5 = 0;
        r6 = 9;
        r7 = "GooglePlayServicesUtil";
        if (r10 == 0) goto L_0x002a;
    L_0x001b:
        r5 = "com.android.vending";	 Catch:{ NameNotFoundException -> 0x0024 }
        r8 = 8256; // 0x2040 float:1.1569E-41 double:4.079E-320;	 Catch:{ NameNotFoundException -> 0x0024 }
        r5 = r4.getPackageInfo(r5, r8);	 Catch:{ NameNotFoundException -> 0x0024 }
        goto L_0x002a;
    L_0x0024:
        r9 = "Google Play Store is missing.";
    L_0x0026:
        android.util.Log.w(r7, r9);
        return r6;
    L_0x002a:
        r8 = 64;
        r8 = r4.getPackageInfo(r0, r8);	 Catch:{ NameNotFoundException -> 0x009e }
        com.google.android.gms.common.zzt.zzcj(r9);
        r9 = com.google.android.gms.common.zzt.zza(r8, r3);
        if (r9 != 0) goto L_0x003c;
    L_0x0039:
        r9 = "Google Play services signature invalid.";
        goto L_0x0026;
    L_0x003c:
        if (r10 == 0) goto L_0x0055;
    L_0x003e:
        r9 = com.google.android.gms.common.zzt.zza(r5, r3);
        if (r9 == 0) goto L_0x0052;
    L_0x0044:
        r9 = r5.signatures;
        r9 = r9[r2];
        r10 = r8.signatures;
        r10 = r10[r2];
        r9 = r9.equals(r10);
        if (r9 != 0) goto L_0x0055;
    L_0x0052:
        r9 = "Google Play Store signature invalid.";
        goto L_0x0026;
    L_0x0055:
        r11 = r11 / 1000;
        r9 = r8.versionCode;
        r9 = r9 / 1000;
        if (r9 >= r11) goto L_0x0087;
    L_0x005d:
        if (r12 == r1) goto L_0x0063;
    L_0x005f:
        r12 = r12 / 1000;
        if (r9 >= r12) goto L_0x0087;
    L_0x0063:
        r9 = GOOGLE_PLAY_SERVICES_VERSION_CODE;
        r10 = r8.versionCode;
        r11 = 77;
        r12 = new java.lang.StringBuilder;
        r12.<init>(r11);
        r11 = "Google Play services out of date.  Requires ";
        r12.append(r11);
        r12.append(r9);
        r9 = " but found ";
        r12.append(r9);
        r12.append(r10);
        r9 = r12.toString();
        android.util.Log.w(r7, r9);
        r9 = 2;
        return r9;
    L_0x0087:
        r9 = r8.applicationInfo;
        if (r9 != 0) goto L_0x0097;
    L_0x008b:
        r9 = r4.getApplicationInfo(r0, r2);	 Catch:{ NameNotFoundException -> 0x0090 }
        goto L_0x0097;
    L_0x0090:
        r9 = move-exception;
        r10 = "Google Play services missing when getting application info.";
        android.util.Log.wtf(r7, r10, r9);
        return r3;
    L_0x0097:
        r9 = r9.enabled;
        if (r9 != 0) goto L_0x009d;
    L_0x009b:
        r9 = 3;
        return r9;
    L_0x009d:
        return r2;
    L_0x009e:
        r9 = "Google Play services is missing.";
        android.util.Log.w(r7, r9);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.zzs.zza(android.content.Context, boolean, int, int):int");
    }

    @Hide
    @TargetApi(19)
    @Deprecated
    public static boolean zzb(Context context, int i, String str) {
        return zzz.zzb(context, i, str);
    }

    @Hide
    @Deprecated
    public static void zzbo(Context context) {
        zzf.zzahf();
        int zzc = zzf.zzc(context, -1);
        if (zzc != 0) {
            zzf.zzahf();
            Intent zza = zzf.zza(context, zzc, "e");
            StringBuilder stringBuilder = new StringBuilder(57);
            stringBuilder.append("GooglePlayServices not available due to error ");
            stringBuilder.append(zzc);
            Log.e("GooglePlayServicesUtil", stringBuilder.toString());
            if (zza == null) {
                throw new GooglePlayServicesNotAvailableException(zzc);
            }
            throw new GooglePlayServicesRepairableException(zzc, "Google Play Services not available", zza);
        }
    }

    @java.lang.Deprecated
    public static int zzc(android.content.Context r3, int r4) {
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
        r0 = r3.getResources();	 Catch:{ Throwable -> 0x000a }
        r1 = com.google.android.gms.C0562R.string.common_google_play_services_unknown_issue;	 Catch:{ Throwable -> 0x000a }
        r0.getString(r1);	 Catch:{ Throwable -> 0x000a }
        goto L_0x0011;
    L_0x000a:
        r0 = "GooglePlayServicesUtil";
        r1 = "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.";
        android.util.Log.e(r0, r1);
    L_0x0011:
        r0 = r3.getPackageName();
        r1 = "com.google.android.gms";
        r0 = r1.equals(r0);
        if (r0 != 0) goto L_0x005e;
    L_0x001d:
        r0 = zzfrw;
        r0 = r0.get();
        if (r0 != 0) goto L_0x005e;
    L_0x0025:
        r0 = com.google.android.gms.common.internal.zzbf.zzcs(r3);
        if (r0 == 0) goto L_0x0056;
    L_0x002b:
        r1 = GOOGLE_PLAY_SERVICES_VERSION_CODE;
        if (r0 != r1) goto L_0x0030;
    L_0x002f:
        goto L_0x005e;
    L_0x0030:
        r3 = new java.lang.IllegalStateException;
        r4 = 320; // 0x140 float:4.48E-43 double:1.58E-321;
        r2 = new java.lang.StringBuilder;
        r2.<init>(r4);
        r4 = "The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ";
        r2.append(r4);
        r2.append(r1);
        r4 = " but found ";
        r2.append(r4);
        r2.append(r0);
        r4 = ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />";
        r2.append(r4);
        r4 = r2.toString();
        r3.<init>(r4);
        throw r3;
    L_0x0056:
        r3 = new java.lang.IllegalStateException;
        r4 = "A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />";
        r3.<init>(r4);
        throw r3;
    L_0x005e:
        r0 = com.google.android.gms.common.util.zzj.zzcv(r3);
        if (r0 != 0) goto L_0x006c;
    L_0x0064:
        r0 = com.google.android.gms.common.util.zzj.zzcx(r3);
        if (r0 != 0) goto L_0x006c;
    L_0x006a:
        r0 = 1;
        goto L_0x006d;
    L_0x006c:
        r0 = 0;
    L_0x006d:
        r1 = GOOGLE_PLAY_SERVICES_VERSION_CODE;
        r3 = zza(r3, r0, r1, r4);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.zzs.zzc(android.content.Context, int):int");
    }

    @com.google.android.gms.common.internal.Hide
    @java.lang.Deprecated
    public static void zzcf(android.content.Context r2) {
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
        r0 = zzfrv;
        r1 = 1;
        r0 = r0.getAndSet(r1);
        if (r0 == 0) goto L_0x000a;
    L_0x0009:
        return;
    L_0x000a:
        r0 = "notification";	 Catch:{ SecurityException -> 0x0019 }
        r2 = r2.getSystemService(r0);	 Catch:{ SecurityException -> 0x0019 }
        r2 = (android.app.NotificationManager) r2;	 Catch:{ SecurityException -> 0x0019 }
        if (r2 == 0) goto L_0x0019;	 Catch:{ SecurityException -> 0x0019 }
    L_0x0014:
        r0 = 10436; // 0x28c4 float:1.4624E-41 double:5.156E-320;	 Catch:{ SecurityException -> 0x0019 }
        r2.cancel(r0);	 Catch:{ SecurityException -> 0x0019 }
    L_0x0019:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.zzs.zzcf(android.content.Context):void");
    }

    @com.google.android.gms.common.internal.Hide
    @java.lang.Deprecated
    public static int zzcg(android.content.Context r2) {
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
        r2 = r2.getPackageManager();	 Catch:{ NameNotFoundException -> 0x000e }
        r1 = "com.google.android.gms";	 Catch:{ NameNotFoundException -> 0x000e }
        r2 = r2.getPackageInfo(r1, r0);	 Catch:{ NameNotFoundException -> 0x000e }
        r2 = r2.versionCode;
        return r2;
    L_0x000e:
        r2 = "GooglePlayServicesUtil";
        r1 = "Google Play services is missing.";
        android.util.Log.w(r2, r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.zzs.zzcg(android.content.Context):int");
    }

    @Hide
    public static boolean zzci(Context context) {
        if (!zzfru) {
            try {
                PackageInfo packageInfo = zzbih.zzdd(context).getPackageInfo("com.google.android.gms", 64);
                zzt.zzcj(context);
                if (packageInfo == null || zzt.zza(packageInfo, false) || !zzt.zza(packageInfo, true)) {
                    zzfrt = false;
                    zzfru = true;
                } else {
                    zzfrt = true;
                    zzfru = true;
                }
            } catch (Throwable e) {
                Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e);
            } catch (Throwable th) {
                zzfru = true;
            }
        }
        if (!zzfrt) {
            if ("user".equals(Build.TYPE)) {
                return false;
            }
        }
        return true;
    }

    @Hide
    @Deprecated
    public static boolean zzd(Context context, int i) {
        return i == 18 ? true : i == 1 ? zzr(context, "com.google.android.gms") : false;
    }

    @Hide
    @Deprecated
    public static boolean zze(Context context, int i) {
        return zzz.zze(context, i);
    }

    @android.annotation.TargetApi(21)
    static boolean zzr(android.content.Context r5, java.lang.String r6) {
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
        r0 = r6.equals(r0);
        r1 = com.google.android.gms.common.util.zzs.zzanx();
        r2 = 1;
        r3 = 0;
        if (r1 == 0) goto L_0x0036;
    L_0x000e:
        r1 = r5.getPackageManager();	 Catch:{ Exception -> 0x0035 }
        r1 = r1.getPackageInstaller();	 Catch:{ Exception -> 0x0035 }
        r1 = r1.getAllSessions();	 Catch:{ Exception -> 0x0035 }
        r1 = r1.iterator();
    L_0x001e:
        r4 = r1.hasNext();
        if (r4 == 0) goto L_0x0036;
    L_0x0024:
        r4 = r1.next();
        r4 = (android.content.pm.PackageInstaller.SessionInfo) r4;
        r4 = r4.getAppPackageName();
        r4 = r6.equals(r4);
        if (r4 == 0) goto L_0x001e;
    L_0x0034:
        return r2;
    L_0x0035:
        return r3;
    L_0x0036:
        r1 = r5.getPackageManager();
        r4 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r6 = r1.getApplicationInfo(r6, r4);	 Catch:{ NameNotFoundException -> 0x0075 }
        if (r0 == 0) goto L_0x0045;	 Catch:{ NameNotFoundException -> 0x0075 }
    L_0x0042:
        r5 = r6.enabled;	 Catch:{ NameNotFoundException -> 0x0075 }
        return r5;	 Catch:{ NameNotFoundException -> 0x0075 }
    L_0x0045:
        r6 = r6.enabled;	 Catch:{ NameNotFoundException -> 0x0075 }
        if (r6 == 0) goto L_0x0075;	 Catch:{ NameNotFoundException -> 0x0075 }
    L_0x0049:
        r6 = com.google.android.gms.common.util.zzs.zzanu();	 Catch:{ NameNotFoundException -> 0x0075 }
        if (r6 == 0) goto L_0x0071;	 Catch:{ NameNotFoundException -> 0x0075 }
    L_0x004f:
        r6 = "user";	 Catch:{ NameNotFoundException -> 0x0075 }
        r6 = r5.getSystemService(r6);	 Catch:{ NameNotFoundException -> 0x0075 }
        r6 = (android.os.UserManager) r6;	 Catch:{ NameNotFoundException -> 0x0075 }
        r5 = r5.getPackageName();	 Catch:{ NameNotFoundException -> 0x0075 }
        r5 = r6.getApplicationRestrictions(r5);	 Catch:{ NameNotFoundException -> 0x0075 }
        if (r5 == 0) goto L_0x0071;	 Catch:{ NameNotFoundException -> 0x0075 }
    L_0x0061:
        r6 = "true";	 Catch:{ NameNotFoundException -> 0x0075 }
        r0 = "restricted_profile";	 Catch:{ NameNotFoundException -> 0x0075 }
        r5 = r5.getString(r0);	 Catch:{ NameNotFoundException -> 0x0075 }
        r5 = r6.equals(r5);	 Catch:{ NameNotFoundException -> 0x0075 }
        if (r5 == 0) goto L_0x0071;
    L_0x006f:
        r5 = 1;
        goto L_0x0072;
    L_0x0071:
        r5 = 0;
    L_0x0072:
        if (r5 != 0) goto L_0x0075;
    L_0x0074:
        return r2;
    L_0x0075:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.zzs.zzr(android.content.Context, java.lang.String):boolean");
    }
}
