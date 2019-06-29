package com.facebook.marketing.internal;

import android.content.Context;
import com.facebook.C0560t;
import com.facebook.internal.C0489b;
import org.json.JSONObject;

/* renamed from: com.facebook.marketing.internal.j */
class C0538j implements Runnable {
    C0538j() {
    }

    public void run() {
        Context d = C0560t.m1252d();
        String e = C0560t.m1253e();
        C0489b a = C0489b.m1065a(d);
        if (a != null && a.m1072a() != null) {
            JSONObject a2 = C0539k.m1220b(e, a.m1072a());
            if (a2 != null) {
                C0539k.m1221b(e, a2);
            }
        }
    }
}
