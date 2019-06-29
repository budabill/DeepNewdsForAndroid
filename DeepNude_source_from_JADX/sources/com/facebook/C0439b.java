package com.facebook;

import android.content.SharedPreferences;
import android.os.Bundle;

/* renamed from: com.facebook.b */
class C0439b {
    /* renamed from: a */
    private final SharedPreferences f757a;
    /* renamed from: b */
    private final C0436a f758b;
    /* renamed from: c */
    private C0333F f759c;

    /* renamed from: com.facebook.b$a */
    static class C0436a {
        C0436a() {
        }

        /* renamed from: a */
        public C0333F m833a() {
            return new C0333F(C0560t.m1252d());
        }
    }

    public C0439b() {
        this(C0560t.m1252d().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0), new C0436a());
    }

    C0439b(SharedPreferences sharedPreferences, C0436a c0436a) {
        this.f757a = sharedPreferences;
        this.f758b = c0436a;
    }

    /* renamed from: c */
    private com.facebook.AccessToken m841c() {
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
        r0 = r3.f757a;
        r1 = 0;
        r2 = "com.facebook.AccessTokenManager.CachedAccessToken";
        r0 = r0.getString(r2, r1);
        if (r0 == 0) goto L_0x0015;
    L_0x000b:
        r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0015 }
        r2.<init>(r0);	 Catch:{ JSONException -> 0x0015 }
        r0 = com.facebook.AccessToken.m441a(r2);	 Catch:{ JSONException -> 0x0015 }
        return r0;
    L_0x0015:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.b.c():com.facebook.AccessToken");
    }

    /* renamed from: d */
    private AccessToken m842d() {
        Bundle b = m843e().m495b();
        return (b == null || !C0333F.m493d(b)) ? null : AccessToken.m439a(b);
    }

    /* renamed from: e */
    private C0333F m843e() {
        if (this.f759c == null) {
            synchronized (this) {
                if (this.f759c == null) {
                    this.f759c = this.f758b.m833a();
                }
            }
        }
        return this.f759c;
    }

    /* renamed from: f */
    private boolean m844f() {
        return this.f757a.contains("com.facebook.AccessTokenManager.CachedAccessToken");
    }

    /* renamed from: g */
    private boolean m845g() {
        return C0560t.m1265q();
    }

    /* renamed from: a */
    public void m846a() {
        this.f757a.edit().remove("com.facebook.AccessTokenManager.CachedAccessToken").apply();
        if (m845g()) {
            m843e().m494a();
        }
    }

    /* renamed from: a */
    public void m847a(com.facebook.AccessToken r3) {
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
        r0 = "accessToken";
        com.facebook.internal.C0476S.m1016a(r3, r0);
        r3 = r3.m459n();	 Catch:{ JSONException -> 0x001c }
        r0 = r2.f757a;	 Catch:{ JSONException -> 0x001c }
        r0 = r0.edit();	 Catch:{ JSONException -> 0x001c }
        r1 = "com.facebook.AccessTokenManager.CachedAccessToken";	 Catch:{ JSONException -> 0x001c }
        r3 = r3.toString();	 Catch:{ JSONException -> 0x001c }
        r3 = r0.putString(r1, r3);	 Catch:{ JSONException -> 0x001c }
        r3.apply();	 Catch:{ JSONException -> 0x001c }
    L_0x001c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.b.a(com.facebook.AccessToken):void");
    }

    /* renamed from: b */
    public AccessToken m848b() {
        if (m844f()) {
            return m841c();
        }
        if (!m845g()) {
            return null;
        }
        AccessToken d = m842d();
        if (d == null) {
            return d;
        }
        m847a(d);
        m843e().m494a();
        return d;
    }
}
