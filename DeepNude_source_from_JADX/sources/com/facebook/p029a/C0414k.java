package com.facebook.p029a;

import com.facebook.p029a.C0422r.C0421a;
import java.util.concurrent.TimeUnit;

/* renamed from: com.facebook.a.k */
class C0414k implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0403b f695a;
    /* renamed from: b */
    final /* synthetic */ C0409f f696b;

    C0414k(C0403b c0403b, C0409f c0409f) {
        this.f695a = c0403b;
        this.f696b = c0409f;
    }

    public void run() {
        C0416n.f700b.m765a(this.f695a, this.f696b);
        if (C0422r.m798d() != C0421a.EXPLICIT_ONLY && C0416n.f700b.m763a() > 100) {
            C0416n.m778b(C0423s.EVENT_THRESHOLD);
        } else if (C0416n.f702d == null) {
            C0416n.f702d = C0416n.f701c.schedule(C0416n.f703e, 15, TimeUnit.SECONDS);
        }
    }
}
