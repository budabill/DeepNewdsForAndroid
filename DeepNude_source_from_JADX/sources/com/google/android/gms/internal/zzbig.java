package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Binder;
import android.os.Process;
import com.google.android.gms.common.util.zzs;

public final class zzbig {
    private Context mContext;

    public zzbig(Context context) {
        this.mContext = context;
    }

    public final int checkCallingOrSelfPermission(String str) {
        return this.mContext.checkCallingOrSelfPermission(str);
    }

    public final int checkPermission(String str, String str2) {
        return this.mContext.getPackageManager().checkPermission(str, str2);
    }

    public final ApplicationInfo getApplicationInfo(String str, int i) {
        return this.mContext.getPackageManager().getApplicationInfo(str, i);
    }

    public final PackageInfo getPackageInfo(String str, int i) {
        return this.mContext.getPackageManager().getPackageInfo(str, i);
    }

    public final String[] getPackagesForUid(int i) {
        return this.mContext.getPackageManager().getPackagesForUid(i);
    }

    public final boolean zzaoe() {
        if (Binder.getCallingUid() == Process.myUid()) {
            return zzbif.zzdb(this.mContext);
        }
        if (zzs.isAtLeastO()) {
            String nameForUid = this.mContext.getPackageManager().getNameForUid(Binder.getCallingUid());
            if (nameForUid != null) {
                return this.mContext.getPackageManager().isInstantApp(nameForUid);
            }
        }
        return false;
    }

    @android.annotation.TargetApi(19)
    public final boolean zzf(int r5, java.lang.String r6) {
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
        r4 = this;
        r0 = com.google.android.gms.common.util.zzs.zzanv();
        r1 = 1;
        r2 = 0;
        if (r0 == 0) goto L_0x0017;
    L_0x0008:
        r0 = r4.mContext;	 Catch:{ SecurityException -> 0x0016 }
        r3 = "appops";	 Catch:{ SecurityException -> 0x0016 }
        r0 = r0.getSystemService(r3);	 Catch:{ SecurityException -> 0x0016 }
        r0 = (android.app.AppOpsManager) r0;	 Catch:{ SecurityException -> 0x0016 }
        r0.checkPackage(r5, r6);	 Catch:{ SecurityException -> 0x0016 }
        return r1;
    L_0x0016:
        return r2;
    L_0x0017:
        r0 = r4.mContext;
        r0 = r0.getPackageManager();
        r5 = r0.getPackagesForUid(r5);
        if (r6 == 0) goto L_0x0035;
    L_0x0023:
        if (r5 == 0) goto L_0x0035;
    L_0x0025:
        r0 = 0;
    L_0x0026:
        r3 = r5.length;
        if (r0 >= r3) goto L_0x0035;
    L_0x0029:
        r3 = r5[r0];
        r3 = r6.equals(r3);
        if (r3 == 0) goto L_0x0032;
    L_0x0031:
        return r1;
    L_0x0032:
        r0 = r0 + 1;
        goto L_0x0026;
    L_0x0035:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbig.zzf(int, java.lang.String):boolean");
    }

    public final CharSequence zzhc(String str) {
        return this.mContext.getPackageManager().getApplicationLabel(this.mContext.getPackageManager().getApplicationInfo(str, 0));
    }
}
