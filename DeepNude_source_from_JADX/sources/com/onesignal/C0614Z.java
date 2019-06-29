package com.onesignal;

import org.json.JSONObject;

/* renamed from: com.onesignal.Z */
public class C0614Z {
    /* renamed from: a */
    OSSubscriptionState f1237a;
    /* renamed from: b */
    OSSubscriptionState f1238b;

    /* renamed from: a */
    public OSSubscriptionState m1434a() {
        return this.f1237a;
    }

    /* renamed from: b */
    public JSONObject m1435b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.f1238b.m1409e());
            jSONObject.put("to", this.f1237a.m1409e());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return m1435b().toString();
    }
}
