package com.facebook.p029a.p032b;

import android.content.Context;
import com.facebook.C0560t;
import java.util.ArrayList;

/* renamed from: com.facebook.a.b.q */
class C0393q implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0394r f643a;

    C0393q(C0394r c0394r) {
        this.f643a = c0394r;
    }

    public void run() {
        Context d = C0560t.m1252d();
        ArrayList b = C0396t.m722b(d, C0395s.f651h);
        if (b.isEmpty()) {
            b = C0396t.m716a(d, C0395s.f651h);
        }
        C0395s.m706b(d, b);
    }
}
