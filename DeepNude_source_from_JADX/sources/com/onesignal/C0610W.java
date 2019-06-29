package com.onesignal;

import org.json.JSONObject;

/* renamed from: com.onesignal.W */
public class C0610W {
    /* renamed from: a */
    C0609V f1218a;
    /* renamed from: b */
    C0609V f1219b;

    /* renamed from: a */
    public JSONObject m1421a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.f1219b.m1420d());
            jSONObject.put("to", this.f1218a.m1420d());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return m1421a().toString();
    }
}
