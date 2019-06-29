package com.onesignal;

import com.onesignal.Ga.C0589a;
import org.json.JSONObject;

class Aa implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f1072a;
    /* renamed from: b */
    final /* synthetic */ JSONObject f1073b;
    /* renamed from: c */
    final /* synthetic */ C0589a f1074c;

    Aa(String str, JSONObject jSONObject, C0589a c0589a) {
        this.f1072a = str;
        this.f1073b = jSONObject;
        this.f1074c = c0589a;
    }

    public void run() {
        Ga.m1331c(this.f1072a, "PUT", this.f1073b, this.f1074c, 120000);
    }
}
