package io.gonative.android;

import com.onesignal.sa.C0647f;
import io.gonative.android.SubscriptionsActivity.C0686a;
import io.gonative.android.fa.C0714a;
import io.gonative.android.fa.C0715b;
import org.json.JSONObject;

class da implements C0647f {
    /* renamed from: a */
    final /* synthetic */ fa f1872a;
    /* renamed from: b */
    final /* synthetic */ SubscriptionsActivity f1873b;
    /* renamed from: c */
    final /* synthetic */ C0686a f1874c;

    da(C0686a c0686a, fa faVar, SubscriptionsActivity subscriptionsActivity) {
        this.f1874c = c0686a;
        this.f1872a = faVar;
        this.f1873b = subscriptionsActivity;
    }

    /* renamed from: a */
    public void mo1410a(JSONObject jSONObject) {
        if (jSONObject != null) {
            for (C0715b c0715b : this.f1872a.f1602b) {
                for (C0714a c0714a : c0715b.f1600b) {
                    String str = c0714a.f1596a;
                    if (str != null && jSONObject.has(str)) {
                        c0714a.f1598c = true;
                    }
                }
            }
        }
        this.f1873b.runOnUiThread(new ca(this));
    }
}
