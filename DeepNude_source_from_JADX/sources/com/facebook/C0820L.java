package com.facebook;

import android.os.Handler;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.L */
class C0820L extends OutputStream implements C0344O {
    /* renamed from: a */
    private final Map<GraphRequest, C0346Q> f1737a = new HashMap();
    /* renamed from: b */
    private final Handler f1738b;
    /* renamed from: c */
    private GraphRequest f1739c;
    /* renamed from: d */
    private C0346Q f1740d;
    /* renamed from: e */
    private int f1741e;

    C0820L(Handler handler) {
        this.f1738b = handler;
    }

    /* renamed from: a */
    int m2127a() {
        return this.f1741e;
    }

    /* renamed from: a */
    void m2128a(long j) {
        if (this.f1740d == null) {
            this.f1740d = new C0346Q(this.f1738b, this.f1739c);
            this.f1737a.put(this.f1739c, this.f1740d);
        }
        this.f1740d.m585b(j);
        this.f1741e = (int) (((long) this.f1741e) + j);
    }

    /* renamed from: a */
    public void mo948a(GraphRequest graphRequest) {
        this.f1739c = graphRequest;
        this.f1740d = graphRequest != null ? (C0346Q) this.f1737a.get(graphRequest) : null;
    }

    /* renamed from: b */
    Map<GraphRequest, C0346Q> m2130b() {
        return this.f1737a;
    }

    public void write(int i) {
        m2128a(1);
    }

    public void write(byte[] bArr) {
        m2128a((long) bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        m2128a((long) i2);
    }
}
