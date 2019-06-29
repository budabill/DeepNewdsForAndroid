package com.facebook;

import android.os.Handler;
import com.facebook.C0330C.C0329a;
import com.facebook.C0330C.C0816b;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.util.Map;

/* renamed from: com.facebook.N */
class C0821N extends FilterOutputStream implements C0344O {
    /* renamed from: a */
    private final Map<GraphRequest, C0346Q> f1742a;
    /* renamed from: b */
    private final C0330C f1743b;
    /* renamed from: c */
    private final long f1744c = C0560t.m1261m();
    /* renamed from: d */
    private long f1745d;
    /* renamed from: e */
    private long f1746e;
    /* renamed from: f */
    private long f1747f;
    /* renamed from: g */
    private C0346Q f1748g;

    C0821N(OutputStream outputStream, C0330C c0330c, Map<GraphRequest, C0346Q> map, long j) {
        super(outputStream);
        this.f1743b = c0330c;
        this.f1742a = map;
        this.f1747f = j;
    }

    /* renamed from: a */
    private void m2132a() {
        if (this.f1745d > this.f1746e) {
            for (C0329a c0329a : this.f1743b.m474g()) {
                if (c0329a instanceof C0816b) {
                    Handler f = this.f1743b.m473f();
                    C0816b c0816b = (C0816b) c0329a;
                    if (f == null) {
                        c0816b.m2111a(this.f1743b, this.f1745d, this.f1747f);
                    } else {
                        f.post(new C0343M(this, c0816b));
                    }
                }
            }
            this.f1746e = this.f1745d;
        }
    }

    /* renamed from: a */
    private void m2133a(long j) {
        C0346Q c0346q = this.f1748g;
        if (c0346q != null) {
            c0346q.m584a(j);
        }
        this.f1745d += j;
        j = this.f1745d;
        if (j >= this.f1746e + this.f1744c || j >= this.f1747f) {
            m2132a();
        }
    }

    /* renamed from: a */
    public void mo948a(GraphRequest graphRequest) {
        this.f1748g = graphRequest != null ? (C0346Q) this.f1742a.get(graphRequest) : null;
    }

    public void close() {
        super.close();
        for (C0346Q a : this.f1742a.values()) {
            a.m583a();
        }
        m2132a();
    }

    public void write(int i) {
        this.out.write(i);
        m2133a(1);
    }

    public void write(byte[] bArr) {
        this.out.write(bArr);
        m2133a((long) bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.out.write(bArr, i, i2);
        m2133a((long) i2);
    }
}
