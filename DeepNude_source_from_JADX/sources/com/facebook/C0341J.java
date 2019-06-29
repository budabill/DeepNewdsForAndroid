package com.facebook;

import android.content.SharedPreferences;
import com.facebook.internal.C0476S;
import com.google.android.gms.common.Scopes;
import org.json.JSONObject;

/* renamed from: com.facebook.J */
final class C0341J {
    /* renamed from: a */
    private final SharedPreferences f496a = C0560t.m1252d().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);

    C0341J() {
    }

    /* renamed from: a */
    void m568a() {
        this.f496a.edit().remove("com.facebook.ProfileManager.CachedProfile").apply();
    }

    /* renamed from: a */
    void m569a(Profile profile) {
        C0476S.m1016a((Object) profile, Scopes.PROFILE);
        JSONObject d = profile.m582d();
        if (d != null) {
            this.f496a.edit().putString("com.facebook.ProfileManager.CachedProfile", d.toString()).apply();
        }
    }

    /* renamed from: b */
    com.facebook.Profile m570b() {
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
        r3 = this;
        r0 = r3.f496a;
        r1 = 0;
        r2 = "com.facebook.ProfileManager.CachedProfile";
        r0 = r0.getString(r2, r1);
        if (r0 == 0) goto L_0x0016;
    L_0x000b:
        r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0016 }
        r2.<init>(r0);	 Catch:{ JSONException -> 0x0016 }
        r0 = new com.facebook.Profile;	 Catch:{ JSONException -> 0x0016 }
        r0.<init>(r2);	 Catch:{ JSONException -> 0x0016 }
        return r0;
    L_0x0016:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.J.b():com.facebook.Profile");
    }
}
