package com.google.android.gms.phenotype;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.UserManager;
import android.support.v4.content.PermissionChecker;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.zzdnm;
import com.google.android.gms.internal.zzdob;

@KeepForSdk
@Deprecated
public abstract class PhenotypeFlag<T> {
    @SuppressLint({"StaticFieldLeak"})
    private static Context zzaiq = null;
    private static boolean zzciw = false;
    private static final Object zzkgs = new Object();
    private static Boolean zzkgt = null;
    private final T zzinq;
    private final Factory zzkgu;
    final String zzkgv;
    private final String zzkgw;
    private T zzkgx;

    @KeepForSdk
    public static class Factory {
        private final String zzkhb;
        private final Uri zzkhc;
        private final String zzkhd;
        private final String zzkhe;
        private final boolean zzkhf;
        private final boolean zzkhg;

        @KeepForSdk
        public Factory(Uri uri) {
            this(null, uri, "", "", false, false);
        }

        private Factory(String str, Uri uri, String str2, String str3, boolean z, boolean z2) {
            this.zzkhb = str;
            this.zzkhc = uri;
            this.zzkhd = str2;
            this.zzkhe = str3;
            this.zzkhf = z;
            this.zzkhg = z2;
        }

        @KeepForSdk
        public PhenotypeFlag<String> createFlag(String str, String str2) {
            return PhenotypeFlag.zza(this, str, str2);
        }

        @KeepForSdk
        public Factory withGservicePrefix(String str) {
            boolean z = this.zzkhf;
            if (z) {
                throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
            }
            return new Factory(this.zzkhb, this.zzkhc, str, this.zzkhe, z, this.zzkhg);
        }

        @KeepForSdk
        public Factory withPhenotypePrefix(String str) {
            return new Factory(this.zzkhb, this.zzkhc, this.zzkhd, str, this.zzkhf, this.zzkhg);
        }
    }

    interface zza<V> {
        V zzbel();
    }

    private PhenotypeFlag(Factory factory, String str, T t) {
        this.zzkgx = null;
        if (factory.zzkhb == null) {
            if (factory.zzkhc == null) {
                throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
            }
        }
        if (factory.zzkhb != null) {
            if (factory.zzkhc != null) {
                throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
            }
        }
        this.zzkgu = factory;
        String valueOf = String.valueOf(factory.zzkhd);
        String valueOf2 = String.valueOf(str);
        this.zzkgw = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        String valueOf3 = String.valueOf(factory.zzkhe);
        str = String.valueOf(str);
        this.zzkgv = str.length() != 0 ? valueOf3.concat(str) : new String(valueOf3);
        this.zzinq = t;
    }

    @KeepForSdk
    public static void maybeInit(Context context) {
        zzdob.maybeInit(context);
        if (zzaiq == null) {
            zzdob.zzch(context);
            synchronized (zzkgs) {
                if (VERSION.SDK_INT < 24 || !context.isDeviceProtectedStorage()) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                }
                if (zzaiq != context) {
                    zzkgt = null;
                }
                zzaiq = context;
            }
            zzciw = false;
        }
    }

    private static PhenotypeFlag<String> zza(Factory factory, String str, String str2) {
        return new zzs(factory, str, str2);
    }

    private static <V> V zza(com.google.android.gms.phenotype.PhenotypeFlag.zza<V> r2) {
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
        r2 = r2.zzbel();	 Catch:{ SecurityException -> 0x0005 }
        goto L_0x0010;
    L_0x0005:
        r0 = android.os.Binder.clearCallingIdentity();
        r2 = r2.zzbel();	 Catch:{ all -> 0x0011 }
        android.os.Binder.restoreCallingIdentity(r0);
    L_0x0010:
        return r2;
    L_0x0011:
        r2 = move-exception;
        android.os.Binder.restoreCallingIdentity(r0);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.phenotype.PhenotypeFlag.zza(com.google.android.gms.phenotype.PhenotypeFlag$zza):V");
    }

    @TargetApi(24)
    private final T zzbeh() {
        String str;
        if (zzh("gms:phenotype:phenotype_flag:debug_bypass_phenotype", false)) {
            str = "Bypass reading Phenotype values for flag: ";
            String valueOf = String.valueOf(this.zzkgv);
            Log.w("PhenotypeFlag", valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        } else if (this.zzkgu.zzkhc != null) {
            str = (String) zza(new zzo(this, zza.zza(zzaiq.getContentResolver(), this.zzkgu.zzkhc)));
            if (str != null) {
                return zzkz(str);
            }
        } else if (this.zzkgu.zzkhb == null || (VERSION.SDK_INT >= 24 && !zzaiq.isDeviceProtectedStorage() && !((UserManager) zzaiq.getSystemService(UserManager.class)).isUserUnlocked())) {
            return null;
        } else {
            SharedPreferences sharedPreferences = zzaiq.getSharedPreferences(this.zzkgu.zzkhb, 0);
            if (sharedPreferences.contains(this.zzkgv)) {
                return zzb(sharedPreferences);
            }
        }
        return null;
    }

    private final T zzbei() {
        if (!this.zzkgu.zzkhf && zzbej()) {
            String str = (String) zza(new zzp(this));
            if (str != null) {
                return zzkz(str);
            }
        }
        return null;
    }

    private static boolean zzbej() {
        if (zzkgt == null) {
            Context context = zzaiq;
            boolean z = false;
            if (context == null) {
                return false;
            }
            if (PermissionChecker.checkCallingOrSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                z = true;
            }
            zzkgt = Boolean.valueOf(z);
        }
        return zzkgt.booleanValue();
    }

    static boolean zzh(String str, boolean z) {
        return zzbej() ? ((Boolean) zza(new zzq(str, false))).booleanValue() : false;
    }

    @KeepForSdk
    public T get() {
        if (zzaiq != null) {
            T zzbei;
            if (this.zzkgu.zzkhg) {
                zzbei = zzbei();
                if (zzbei != null) {
                    return zzbei;
                }
                zzbei = zzbeh();
                if (zzbei != null) {
                    return zzbei;
                }
            }
            zzbei = zzbeh();
            if (zzbei != null) {
                return zzbei;
            }
            zzbei = zzbei();
            if (zzbei != null) {
                return zzbei;
            }
            return this.zzinq;
        }
        throw new IllegalStateException("Must call PhenotypeFlag.init() first");
    }

    public abstract T zzb(SharedPreferences sharedPreferences);

    final /* synthetic */ String zzbek() {
        return zzdnm.zza(zzaiq.getContentResolver(), this.zzkgw, null);
    }

    public abstract T zzkz(String str);
}
