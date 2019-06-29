package com.onesignal;

import com.onesignal.Ga.C0589a;
import org.json.JSONException;
import org.json.JSONObject;

class gb extends C0589a {
    /* renamed from: a */
    final /* synthetic */ hb f1836a;

    gb(hb hbVar) {
        this.f1836a = hbVar;
    }

    /* renamed from: a */
    void mo1370a(String str) {
        hb.f1837j = true;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("tags")) {
                synchronized (this.f1836a.f1283a) {
                    JSONObject a = this.f1836a.m1551a(this.f1836a.f1290h.f1270f.optJSONObject("tags"), this.f1836a.m1559c().f1270f.optJSONObject("tags"), null, null);
                    this.f1836a.f1290h.f1270f.put("tags", jSONObject.optJSONObject("tags"));
                    this.f1836a.f1290h.m1517c();
                    this.f1836a.m1559c().m1513a(jSONObject, a);
                    this.f1836a.m1559c().m1517c();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
