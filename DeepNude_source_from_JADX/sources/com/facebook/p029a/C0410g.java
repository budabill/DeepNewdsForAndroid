package com.facebook.p029a;

import android.content.Context;
import com.facebook.C0560t;
import com.facebook.internal.C0489b;
import java.util.HashMap;
import java.util.Set;

/* renamed from: com.facebook.a.g */
class C0410g {
    /* renamed from: a */
    private final HashMap<C0403b, C0429x> f693a = new HashMap();

    /* renamed from: b */
    private synchronized C0429x m762b(C0403b c0403b) {
        C0429x c0429x;
        c0429x = (C0429x) this.f693a.get(c0403b);
        if (c0429x == null) {
            Context d = C0560t.m1252d();
            c0429x = new C0429x(C0489b.m1065a(d), C0422r.m787a(d));
        }
        this.f693a.put(c0403b, c0429x);
        return c0429x;
    }

    /* renamed from: a */
    public synchronized int m763a() {
        int i;
        i = 0;
        for (C0429x a : this.f693a.values()) {
            i += a.m816a();
        }
        return i;
    }

    /* renamed from: a */
    public synchronized C0429x m764a(C0403b c0403b) {
        return (C0429x) this.f693a.get(c0403b);
    }

    /* renamed from: a */
    public synchronized void m765a(C0403b c0403b, C0409f c0409f) {
        m762b(c0403b).m818a(c0409f);
    }

    /* renamed from: a */
    public synchronized void m766a(C0428w c0428w) {
        if (c0428w != null) {
            for (C0403b c0403b : c0428w.m811a()) {
                C0429x b = m762b(c0403b);
                for (C0409f a : c0428w.m814b(c0403b)) {
                    b.m818a(a);
                }
            }
        }
    }

    /* renamed from: b */
    public synchronized Set<C0403b> m767b() {
        return this.f693a.keySet();
    }
}
