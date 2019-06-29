package com.facebook.internal;

import com.facebook.C0331D;
import com.facebook.GraphRequest.C0338b;
import com.facebook.internal.C0475Q.C0473a;

/* renamed from: com.facebook.internal.O */
class C0834O implements C0338b {
    /* renamed from: a */
    final /* synthetic */ C0473a f1768a;
    /* renamed from: b */
    final /* synthetic */ String f1769b;

    C0834O(C0473a c0473a, String str) {
        this.f1768a = c0473a;
        this.f1769b = str;
    }

    /* renamed from: a */
    public void mo949a(C0331D c0331d) {
        if (c0331d.m486a() != null) {
            this.f1768a.mo946a(c0331d.m486a().m502e());
            return;
        }
        C0469L.m945a(this.f1769b, c0331d.m487b());
        this.f1768a.mo947a(c0331d.m487b());
    }
}
