package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbih;

@Hide
public class zzt {
    private static zzt zzfrx;
    private final Context mContext;

    private zzt(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @Hide
    private static zzh zza(PackageInfo packageInfo, zzh... zzhArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        int i = 0;
        zzi zzi = new zzi(signatureArr[0].toByteArray());
        while (i < zzhArr.length) {
            if (zzhArr[i].equals(zzi)) {
                return zzhArr[i];
            }
            i++;
        }
        return null;
    }

    @Hide
    public static boolean zza(PackageInfo packageInfo, boolean z) {
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            zzh zza;
            if (z) {
                zza = zza(packageInfo, zzk.zzfrh);
            } else {
                zza = zza(packageInfo, zzk.zzfrh[0]);
            }
            if (zza != null) {
                return true;
            }
        }
        return false;
    }

    public static zzt zzcj(Context context) {
        zzbq.checkNotNull(context);
        synchronized (zzt.class) {
            if (zzfrx == null) {
                zzg.zzch(context);
                zzfrx = new zzt(context);
            }
        }
        return zzfrx;
    }

    private final com.google.android.gms.common.zzp zzgh(java.lang.String r7) {
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
        r6 = this;
        r0 = r6.mContext;	 Catch:{ NameNotFoundException -> 0x0052 }
        r0 = com.google.android.gms.internal.zzbih.zzdd(r0);	 Catch:{ NameNotFoundException -> 0x0052 }
        r1 = 64;	 Catch:{ NameNotFoundException -> 0x0052 }
        r7 = r0.getPackageInfo(r7, r1);	 Catch:{ NameNotFoundException -> 0x0052 }
        r0 = r6.mContext;
        r0 = com.google.android.gms.common.zzs.zzci(r0);
        if (r7 != 0) goto L_0x001b;
    L_0x0014:
        r7 = "null pkg";
    L_0x0016:
        r7 = com.google.android.gms.common.zzp.zzgg(r7);
        return r7;
    L_0x001b:
        r1 = r7.signatures;
        r2 = r1.length;
        r3 = 1;
        if (r2 == r3) goto L_0x0024;
    L_0x0021:
        r7 = "single cert required";
        goto L_0x0016;
    L_0x0024:
        r2 = new com.google.android.gms.common.zzi;
        r3 = 0;
        r1 = r1[r3];
        r1 = r1.toByteArray();
        r2.<init>(r1);
        r1 = r7.packageName;
        r4 = com.google.android.gms.common.zzg.zza(r1, r2, r0);
        r5 = r4.zzfrm;
        if (r5 == 0) goto L_0x0051;
    L_0x003a:
        r7 = r7.applicationInfo;
        if (r7 == 0) goto L_0x0051;
    L_0x003e:
        r7 = r7.flags;
        r7 = r7 & 2;
        if (r7 == 0) goto L_0x0051;
    L_0x0044:
        if (r0 == 0) goto L_0x004e;
    L_0x0046:
        r7 = com.google.android.gms.common.zzg.zza(r1, r2, r3);
        r7 = r7.zzfrm;
        if (r7 == 0) goto L_0x0051;
    L_0x004e:
        r7 = "debuggable release cert app rejected";
        goto L_0x0016;
    L_0x0051:
        return r4;
        r0 = "no pkg ";
        r7 = java.lang.String.valueOf(r7);
        r1 = r7.length();
        if (r1 == 0) goto L_0x0064;
    L_0x005f:
        r7 = r0.concat(r7);
        goto L_0x0069;
    L_0x0064:
        r7 = new java.lang.String;
        r7.<init>(r0);
    L_0x0069:
        r7 = com.google.android.gms.common.zzp.zzgg(r7);
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.zzt.zzgh(java.lang.String):com.google.android.gms.common.zzp");
    }

    @Hide
    public final boolean zza(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zza(packageInfo, false)) {
            return true;
        }
        if (zza(packageInfo, true)) {
            if (zzs.zzci(this.mContext)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    @Hide
    public final boolean zzbp(int i) {
        zzp zzp;
        String str;
        String[] packagesForUid = zzbih.zzdd(this.mContext).getPackagesForUid(i);
        if (packagesForUid != null) {
            if (packagesForUid.length != 0) {
                zzp = null;
                for (String zzgh : packagesForUid) {
                    zzp = zzgh(zzgh);
                    if (zzp.zzfrm) {
                        break;
                    }
                }
                if (!zzp.zzfrm) {
                    str = "GoogleCertificatesRslt";
                    if (zzp.cause == null) {
                        Log.d(str, zzp.getErrorMessage(), zzp.cause);
                    } else {
                        Log.d(str, zzp.getErrorMessage());
                    }
                }
                return zzp.zzfrm;
            }
        }
        zzp = zzp.zzgg("no pkgs");
        if (zzp.zzfrm) {
            str = "GoogleCertificatesRslt";
            if (zzp.cause == null) {
                Log.d(str, zzp.getErrorMessage());
            } else {
                Log.d(str, zzp.getErrorMessage(), zzp.cause);
            }
        }
        return zzp.zzfrm;
    }
}
