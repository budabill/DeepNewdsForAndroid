package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.zzbq;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class zzaa {
    private static final Lock zzeok = new ReentrantLock();
    private static zzaa zzeol;
    private final Lock zzeom = new ReentrantLock();
    private final SharedPreferences zzeon;

    private zzaa(Context context) {
        this.zzeon = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static zzaa zzbs(Context context) {
        zzbq.checkNotNull(context);
        zzeok.lock();
        try {
            if (zzeol == null) {
                zzeol = new zzaa(context.getApplicationContext());
            }
            zzaa zzaa = zzeol;
            return zzaa;
        } finally {
            zzeok.unlock();
        }
    }

    private final com.google.android.gms.auth.api.signin.GoogleSignInAccount zzfe(java.lang.String r3) {
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
        r2 = this;
        r0 = android.text.TextUtils.isEmpty(r3);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = "googleSignInAccount";
        r3 = zzp(r0, r3);
        r3 = r2.zzfg(r3);
        if (r3 == 0) goto L_0x0019;
    L_0x0014:
        r3 = com.google.android.gms.auth.api.signin.GoogleSignInAccount.zzfa(r3);	 Catch:{ JSONException -> 0x0019 }
        return r3;
    L_0x0019:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.internal.zzaa.zzfe(java.lang.String):com.google.android.gms.auth.api.signin.GoogleSignInAccount");
    }

    private final com.google.android.gms.auth.api.signin.GoogleSignInOptions zzff(java.lang.String r3) {
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
        r2 = this;
        r0 = android.text.TextUtils.isEmpty(r3);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = "googleSignInOptions";
        r3 = zzp(r0, r3);
        r3 = r2.zzfg(r3);
        if (r3 == 0) goto L_0x0019;
    L_0x0014:
        r3 = com.google.android.gms.auth.api.signin.GoogleSignInOptions.zzfb(r3);	 Catch:{ JSONException -> 0x0019 }
        return r3;
    L_0x0019:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.internal.zzaa.zzff(java.lang.String):com.google.android.gms.auth.api.signin.GoogleSignInOptions");
    }

    private final void zzfh(String str) {
        this.zzeom.lock();
        try {
            this.zzeon.edit().remove(str).apply();
        } finally {
            this.zzeom.unlock();
        }
    }

    private static String zzp(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(str2).length());
        stringBuilder.append(str);
        stringBuilder.append(":");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    public final void clear() {
        this.zzeom.lock();
        try {
            this.zzeon.edit().clear().apply();
        } finally {
            this.zzeom.unlock();
        }
    }

    final void zza(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        zzbq.checkNotNull(googleSignInAccount);
        zzbq.checkNotNull(googleSignInOptions);
        String zzace = googleSignInAccount.zzace();
        zzo(zzp("googleSignInAccount", zzace), googleSignInAccount.zzacg());
        zzo(zzp("googleSignInOptions", zzace), googleSignInOptions.zzack());
    }

    public final GoogleSignInAccount zzacx() {
        return zzfe(zzfg("defaultGoogleSignInAccount"));
    }

    public final GoogleSignInOptions zzacy() {
        return zzff(zzfg("defaultGoogleSignInAccount"));
    }

    public final void zzacz() {
        String str = "defaultGoogleSignInAccount";
        String zzfg = zzfg(str);
        zzfh(str);
        if (!TextUtils.isEmpty(zzfg)) {
            zzfh(zzp("googleSignInAccount", zzfg));
            zzfh(zzp("googleSignInOptions", zzfg));
        }
    }

    protected final String zzfg(String str) {
        this.zzeom.lock();
        try {
            str = this.zzeon.getString(str, null);
            return str;
        } finally {
            this.zzeom.unlock();
        }
    }

    protected final void zzo(String str, String str2) {
        this.zzeom.lock();
        try {
            this.zzeon.edit().putString(str, str2).apply();
        } finally {
            this.zzeom.unlock();
        }
    }
}
