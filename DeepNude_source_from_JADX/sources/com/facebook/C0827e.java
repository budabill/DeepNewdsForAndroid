package com.facebook;

import com.facebook.C0450g.C0449a;
import com.facebook.GraphRequest.C0338b;
import org.json.JSONObject;

/* renamed from: com.facebook.e */
class C0827e implements C0338b {
    /* renamed from: a */
    final /* synthetic */ C0449a f1759a;
    /* renamed from: b */
    final /* synthetic */ C0450g f1760b;

    C0827e(C0450g c0450g, C0449a c0449a) {
        this.f1760b = c0450g;
        this.f1759a = c0449a;
    }

    /* renamed from: a */
    public void mo949a(C0331D c0331d) {
        JSONObject b = c0331d.m487b();
        if (b != null) {
            this.f1759a.f764a = b.optString("access_token");
            this.f1759a.f765b = b.optInt("expires_at");
            this.f1759a.f766c = Long.valueOf(b.optLong("data_access_expiration_time"));
        }
    }
}
