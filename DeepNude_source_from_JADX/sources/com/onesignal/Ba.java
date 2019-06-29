package com.onesignal;

import com.onesignal.Ga.C0589a;
import org.json.JSONObject;

class Ba implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f1096a;
    /* renamed from: b */
    final /* synthetic */ JSONObject f1097b;
    /* renamed from: c */
    final /* synthetic */ C0589a f1098c;

    Ba(String str, JSONObject jSONObject, C0589a c0589a) {
        this.f1096a = str;
        this.f1097b = jSONObject;
        this.f1098c = c0589a;
    }

    public void run() {
        Ga.m1331c(this.f1096a, "POST", this.f1097b, this.f1098c, 120000);
    }
}
