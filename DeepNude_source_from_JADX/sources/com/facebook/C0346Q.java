package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequest.C0338b;
import com.facebook.GraphRequest.C0817d;

/* renamed from: com.facebook.Q */
class C0346Q {
    /* renamed from: a */
    private final GraphRequest f514a;
    /* renamed from: b */
    private final Handler f515b;
    /* renamed from: c */
    private final long f516c = C0560t.m1261m();
    /* renamed from: d */
    private long f517d;
    /* renamed from: e */
    private long f518e;
    /* renamed from: f */
    private long f519f;

    C0346Q(Handler handler, GraphRequest graphRequest) {
        this.f514a = graphRequest;
        this.f515b = handler;
    }

    /* renamed from: a */
    void m583a() {
        if (this.f517d > this.f518e) {
            C0338b e = this.f514a.m559e();
            long j = this.f519f;
            if (j > 0 && (e instanceof C0817d)) {
                long j2 = this.f517d;
                C0817d c0817d = (C0817d) e;
                Handler handler = this.f515b;
                if (handler == null) {
                    c0817d.m2112a(j2, j);
                } else {
                    handler.post(new C0345P(this, c0817d, j2, j));
                }
                this.f518e = this.f517d;
            }
        }
    }

    /* renamed from: a */
    void m584a(long j) {
        this.f517d += j;
        j = this.f517d;
        if (j >= this.f518e + this.f516c || j >= this.f519f) {
            m583a();
        }
    }

    /* renamed from: b */
    void m585b(long j) {
        this.f519f += j;
    }
}
