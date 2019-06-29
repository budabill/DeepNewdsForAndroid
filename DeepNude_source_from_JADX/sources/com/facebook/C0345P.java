package com.facebook;

import com.facebook.GraphRequest.C0817d;

/* renamed from: com.facebook.P */
class C0345P implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0817d f503a;
    /* renamed from: b */
    final /* synthetic */ long f504b;
    /* renamed from: c */
    final /* synthetic */ long f505c;
    /* renamed from: d */
    final /* synthetic */ C0346Q f506d;

    C0345P(C0346Q c0346q, C0817d c0817d, long j, long j2) {
        this.f506d = c0346q;
        this.f503a = c0817d;
        this.f504b = j;
        this.f505c = j2;
    }

    public void run() {
        this.f503a.m2112a(this.f504b, this.f505c);
    }
}
