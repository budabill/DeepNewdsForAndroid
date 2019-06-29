package com.google.android.gms.iid;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Hide;
import java.io.IOException;
import java.security.KeyPair;
import java.util.Map;

public class InstanceID {
    public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
    public static final String ERROR_MISSING_INSTANCEID_SERVICE = "MISSING_INSTANCEID_SERVICE";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    public static final String ERROR_TIMEOUT = "TIMEOUT";
    private static Map<String, InstanceID> zzimu = new ArrayMap();
    private static zzaf zzimv;
    private static zzaa zzimw;
    private static String zzina;
    private Context mContext;
    private KeyPair zzimx;
    private String zzimy = "";
    private long zzimz;

    @Hide
    private InstanceID(Context context, String str) {
        this.mContext = context.getApplicationContext();
        this.zzimy = str;
    }

    public static InstanceID getInstance(Context context) {
        return getInstance(context, null);
    }

    @Hide
    @KeepForSdk
    public static synchronized InstanceID getInstance(Context context, Bundle bundle) {
        InstanceID instanceID;
        synchronized (InstanceID.class) {
            String string = bundle == null ? "" : bundle.getString("subtype");
            if (string == null) {
                string = "";
            }
            context = context.getApplicationContext();
            if (zzimv == null) {
                zzimv = new zzaf(context);
                zzimw = new zzaa(context);
            }
            zzina = Integer.toString(zzdo(context));
            instanceID = (InstanceID) zzimu.get(string);
            if (instanceID == null) {
                instanceID = new InstanceID(context, string);
                zzimu.put(string, instanceID);
            }
        }
        return instanceID;
    }

    static java.lang.String zza(java.security.KeyPair r3) {
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
        r3 = r3.getPublic();
        r3 = r3.getEncoded();
        r0 = "SHA1";	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r0 = java.security.MessageDigest.getInstance(r0);	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r3 = r0.digest(r3);	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r0 = 0;	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r1 = r3[r0];	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r1 = r1 & 15;	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r1 = r1 + 112;	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r1 = (byte) r1;	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r3[r0] = r1;	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r1 = 8;	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r2 = 11;	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r3 = android.util.Base64.encodeToString(r3, r0, r1, r2);	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        return r3;
    L_0x0025:
        r3 = "InstanceID";
        r0 = "Unexpected error, device missing required algorithms";
        android.util.Log.w(r3, r0);
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.InstanceID.zza(java.security.KeyPair):java.lang.String");
    }

    private final KeyPair zzawp() {
        if (this.zzimx == null) {
            this.zzimx = zzimv.zzii(this.zzimy);
        }
        if (this.zzimx == null) {
            this.zzimz = System.currentTimeMillis();
            this.zzimx = zzimv.zzc(this.zzimy, this.zzimz);
        }
        return this.zzimx;
    }

    @Hide
    public static zzaf zzawr() {
        return zzimv;
    }

    static int zzdo(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 38);
            stringBuilder.append("Never happens: can't find own package ");
            stringBuilder.append(valueOf);
            Log.w("InstanceID", stringBuilder.toString());
            return 0;
        }
    }

    static String zzdp(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 38);
            stringBuilder.append("Never happens: can't find own package ");
            stringBuilder.append(valueOf);
            Log.w("InstanceID", stringBuilder.toString());
            return null;
        }
    }

    static String zzp(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    public void deleteInstanceID() {
        String str = "*";
        zza(str, str, null);
        zzawq();
    }

    public void deleteToken(String str, String str2) {
        zza(str, str2, null);
    }

    public long getCreationTime() {
        if (this.zzimz == 0) {
            String str = zzimv.get(this.zzimy, "cre");
            if (str != null) {
                this.zzimz = Long.parseLong(str);
            }
        }
        return this.zzimz;
    }

    public String getId() {
        return zza(zzawp());
    }

    @Hide
    @KeepForSdk
    public String getSubtype() {
        return this.zzimy;
    }

    public String getToken(String str, String str2) {
        return getToken(str, str2, null);
    }

    public String getToken(String str, String str2, Bundle bundle) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Object obj;
            String zzb;
            String str3 = zzimv.get("appVersion");
            Object obj2 = null;
            Object obj3 = 1;
            if (str3 != null) {
                if (str3.equals(zzina)) {
                    str3 = zzimv.get("lastToken");
                    if (str3 != null) {
                        if ((System.currentTimeMillis() / 1000) - Long.valueOf(Long.parseLong(str3)).longValue() <= 604800) {
                            obj = null;
                            str3 = obj == null ? null : zzimv.zzf(this.zzimy, str, str2);
                            if (str3 != null) {
                                return str3;
                            }
                            if (bundle == null) {
                                bundle = new Bundle();
                            }
                            if (bundle.getString("ttl") != null) {
                                obj3 = null;
                            }
                            if ("jwt".equals(bundle.getString("type"))) {
                                obj2 = obj3;
                            }
                            zzb = zzb(str, str2, bundle);
                            if (!(zzb == null || r1 == null)) {
                                zzimv.zza(this.zzimy, str, str2, zzb, zzina);
                            }
                            return zzb;
                        }
                    }
                }
            }
            obj = 1;
            if (obj == null) {
            }
            if (str3 != null) {
                return str3;
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (bundle.getString("ttl") != null) {
                obj3 = null;
            }
            if ("jwt".equals(bundle.getString("type"))) {
                obj2 = obj3;
            }
            zzb = zzb(str, str2, bundle);
            zzimv.zza(this.zzimy, str, str2, zzb, zzina);
            return zzb;
        }
        throw new IOException("MAIN_THREAD");
    }

    @Hide
    public final void zza(String str, String str2, Bundle bundle) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            zzimv.zzg(this.zzimy, str, str2);
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("sender", str);
            if (str2 != null) {
                bundle.putString("scope", str2);
            }
            bundle.putString("subscription", str);
            str2 = "1";
            bundle.putString("delete", str2);
            bundle.putString("X-delete", str2);
            String str3 = "";
            bundle.putString("subtype", str3.equals(this.zzimy) ? str : this.zzimy);
            if (!str3.equals(this.zzimy)) {
                str = this.zzimy;
            }
            bundle.putString("X-subtype", str);
            zzaa.zzy(zzimw.zza(bundle, zzawp()));
            return;
        }
        throw new IOException("MAIN_THREAD");
    }

    @Hide
    public final void zzawq() {
        this.zzimz = 0;
        zzimv.zzih(String.valueOf(this.zzimy).concat("|"));
        this.zzimx = null;
    }

    @Hide
    public final String zzb(String str, String str2, Bundle bundle) {
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("sender", str);
        str2 = "".equals(this.zzimy) ? str : this.zzimy;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", str);
            bundle.putString("subtype", str2);
            bundle.putString("X-subscription", str);
            bundle.putString("X-subtype", str2);
        }
        str = zzaa.zzy(zzimw.zza(bundle, zzawp()));
        if (!"RST".equals(str) && !str.startsWith("RST|")) {
            return str;
        }
        InstanceIDListenerService.zza(this.mContext, zzimv);
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }
}
