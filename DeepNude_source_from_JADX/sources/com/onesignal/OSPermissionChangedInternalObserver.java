package com.onesignal;

class OSPermissionChangedInternalObserver {
    OSPermissionChangedInternalObserver() {
    }

    /* renamed from: a */
    static void m1398a(C0609V c0609v) {
        C0610W c0610w = new C0610W();
        c0610w.f1219b = sa.f1369U;
        c0610w.f1218a = (C0609V) c0609v.clone();
        if (sa.m1739v().m1414c(c0610w)) {
            sa.f1369U = (C0609V) c0609v.clone();
            sa.f1369U.m1418b();
        }
    }

    /* renamed from: b */
    static void m1399b(C0609V c0609v) {
        if (!c0609v.m1417a()) {
            C0631j.m1522a(0, sa.f1380f);
        }
        Ha.m1342b(sa.m1728m());
    }

    void changed(C0609V c0609v) {
        m1399b(c0609v);
        m1398a(c0609v);
    }
}
