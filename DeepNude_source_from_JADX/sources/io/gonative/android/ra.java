package io.gonative.android;

import io.gonative.android.p038a.C0700a;

class ra implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0700a f1640a;
    /* renamed from: b */
    final /* synthetic */ String f1641b;
    /* renamed from: c */
    final /* synthetic */ wa f1642c;

    ra(wa waVar, C0700a c0700a, String str) {
        this.f1642c = waVar;
        this.f1640a = c0700a;
        this.f1641b = str;
    }

    public void run() {
        this.f1642c.f1663b.m2598a(this.f1640a.m1890a(this.f1641b));
    }
}
