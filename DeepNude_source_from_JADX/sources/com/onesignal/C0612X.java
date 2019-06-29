package com.onesignal;

import org.json.JSONObject;

/* renamed from: com.onesignal.X */
public class C0612X {
    /* renamed from: a */
    OSSubscriptionState f1227a;
    /* renamed from: b */
    C0609V f1228b;
    /* renamed from: c */
    C0598N f1229c;

    /* renamed from: a */
    public OSSubscriptionState m1424a() {
        return this.f1227a;
    }

    /* renamed from: b */
    public JSONObject m1425b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("permissionStatus", this.f1228b.m1420d());
            jSONObject.put("subscriptionStatus", this.f1227a.m1409e());
            jSONObject.put("emailSubscriptionStatus", this.f1229c.m1397b());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return m1425b().toString();
    }
}
