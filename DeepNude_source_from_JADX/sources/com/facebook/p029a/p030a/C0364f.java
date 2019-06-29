package com.facebook.p029a.p030a;

import android.os.Bundle;
import com.facebook.C0560t;
import com.facebook.p029a.C0422r;
import com.facebook.p029a.p030a.C0366g.C0365a;

/* renamed from: com.facebook.a.a.f */
class C0364f implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f585a;
    /* renamed from: b */
    final /* synthetic */ Bundle f586b;
    /* renamed from: c */
    final /* synthetic */ C0365a f587c;

    C0364f(C0365a c0365a, String str, Bundle bundle) {
        this.f587c = c0365a;
        this.f585a = str;
        this.f586b = bundle;
    }

    public void run() {
        C0422r.m795b(C0560t.m1252d()).m805a(this.f585a, this.f586b);
    }
}
