package com.facebook.p029a.p030a;

import android.os.Bundle;
import com.facebook.C0560t;
import com.facebook.p029a.C0422r;
import com.facebook.p029a.p030a.C0359c.C0358a;

/* renamed from: com.facebook.a.a.b */
class C0357b implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f561a;
    /* renamed from: b */
    final /* synthetic */ Bundle f562b;
    /* renamed from: c */
    final /* synthetic */ C0358a f563c;

    C0357b(C0358a c0358a, String str, Bundle bundle) {
        this.f563c = c0358a;
        this.f561a = str;
        this.f562b = bundle;
    }

    public void run() {
        C0422r.m795b(C0560t.m1252d()).m805a(this.f561a, this.f562b);
    }
}
