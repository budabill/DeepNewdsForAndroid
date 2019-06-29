package com.facebook.marketing.internal;

import com.facebook.AccessToken;
import com.facebook.C0560t;
import com.facebook.GraphRequest;
import com.facebook.internal.C0475Q;
import com.facebook.p029a.p030a.C0371l;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.marketing.internal.e */
class C0534e implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f1031a;
    /* renamed from: b */
    final /* synthetic */ JSONObject f1032b;

    C0534e(String str, JSONObject jSONObject) {
        this.f1031a = str;
        this.f1032b = jSONObject;
    }

    public void run() {
        JSONObject jSONObject = new JSONObject();
        try {
            String e = C0560t.m1253e();
            AccessToken c = AccessToken.m446c();
            jSONObject.put("screenname", this.f1031a);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.f1032b);
            jSONObject.put("view", jSONArray);
            GraphRequest a = C0371l.m648a(jSONObject.toString(), c, e, "button_sampling");
            if (a != null) {
                a.m555b();
            }
        } catch (Exception e2) {
            C0475Q.m983a(C0535f.f1033a, e2);
        }
    }
}
