package com.facebook.p029a.p032b;

import android.content.Context;
import com.facebook.C0560t;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.facebook.a.b.p */
class C0392p implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0394r f642a;

    C0392p(C0394r c0394r) {
        this.f642a = c0394r;
    }

    public void run() {
        Context d = C0560t.m1252d();
        C0395s.m706b(d, C0396t.m722b(d, C0395s.f651h));
        Map c = C0396t.m727c(d, C0395s.f651h);
        Iterator it = C0396t.m728d(d, C0395s.f651h).iterator();
        while (it.hasNext()) {
            c.put((String) it.next(), C0402z.EXPIRE);
        }
        C0395s.m707b(d, c);
    }
}
