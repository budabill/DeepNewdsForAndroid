package com.facebook.p029a.p032b;

import android.os.Build;
import android.os.Bundle;
import com.facebook.C0560t;
import com.facebook.GraphRequest;
import com.facebook.internal.C0475Q;
import com.facebook.internal.C0489b;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.a.b.g */
class C0381g implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f615a;

    C0381g(String str) {
        this.f615a = str;
    }

    public void run() {
        boolean z = true;
        GraphRequest a = GraphRequest.m513a(null, String.format(Locale.US, "%s/app_indexing_session", new Object[]{this.f615a}), null, null);
        Bundle i = a.m563i();
        if (i == null) {
            i = new Bundle();
        }
        C0489b a2 = C0489b.m1065a(C0560t.m1252d());
        JSONArray jSONArray = new JSONArray();
        Object obj = Build.MODEL;
        String str = "";
        if (obj == null) {
            obj = str;
        }
        jSONArray.put(obj);
        if (a2 == null || a2.m1072a() == null) {
            jSONArray.put(str);
        } else {
            jSONArray.put(a2.m1072a());
        }
        Object obj2 = "0";
        jSONArray.put(obj2);
        if (C0383i.m692d()) {
            obj2 = "1";
        }
        jSONArray.put(obj2);
        Locale a3 = C0475Q.m973a();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a3.getLanguage());
        stringBuilder.append("_");
        stringBuilder.append(a3.getCountry());
        jSONArray.put(stringBuilder.toString());
        String jSONArray2 = jSONArray.toString();
        i.putString("device_session_id", C0382h.m682k());
        i.putString("extinfo", jSONArray2);
        a.m550a(i);
        if (a != null) {
            JSONObject b = a.m555b().m487b();
            if (b == null || !b.optBoolean("is_app_indexing_enabled", false)) {
                z = false;
            }
            C0382h.f630o = Boolean.valueOf(z);
            if (C0382h.f630o.booleanValue()) {
                C0382h.f628m.m656b();
            } else {
                C0382h.f629n = null;
            }
        }
        C0382h.f631p = Boolean.valueOf(false);
    }
}
