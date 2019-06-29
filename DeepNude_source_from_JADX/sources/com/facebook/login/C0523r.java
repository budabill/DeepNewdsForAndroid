package com.facebook.login;

/* renamed from: com.facebook.login.r */
public enum C0523r {
    NATIVE_WITH_FALLBACK(true, true, true, false, true, true),
    NATIVE_ONLY(true, true, false, false, false, true),
    KATANA_ONLY(false, true, false, false, false, false),
    WEB_ONLY(false, false, true, false, true, false),
    WEB_VIEW_ONLY(false, false, true, false, false, false),
    DIALOG_ONLY(false, true, true, false, true, true),
    DEVICE_AUTH(false, false, false, true, false, false);
    
    /* renamed from: i */
    private final boolean f1004i;
    /* renamed from: j */
    private final boolean f1005j;
    /* renamed from: k */
    private final boolean f1006k;
    /* renamed from: l */
    private final boolean f1007l;
    /* renamed from: m */
    private final boolean f1008m;
    /* renamed from: n */
    private final boolean f1009n;

    private C0523r(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.f1004i = z;
        this.f1005j = z2;
        this.f1006k = z3;
        this.f1007l = z4;
        this.f1008m = z5;
        this.f1009n = z6;
    }

    /* renamed from: a */
    boolean m1183a() {
        return this.f1008m;
    }

    /* renamed from: b */
    boolean m1184b() {
        return this.f1007l;
    }

    /* renamed from: c */
    boolean m1185c() {
        return this.f1009n;
    }

    /* renamed from: d */
    boolean m1186d() {
        return this.f1004i;
    }

    /* renamed from: e */
    boolean m1187e() {
        return this.f1005j;
    }

    /* renamed from: f */
    boolean m1188f() {
        return this.f1006k;
    }
}
