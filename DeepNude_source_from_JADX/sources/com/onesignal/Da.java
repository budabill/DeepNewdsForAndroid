package com.onesignal;

import com.onesignal.Ga.C0589a;
import org.json.JSONObject;

class Da implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Thread[] f1105a;
    /* renamed from: b */
    final /* synthetic */ String f1106b;
    /* renamed from: c */
    final /* synthetic */ String f1107c;
    /* renamed from: d */
    final /* synthetic */ JSONObject f1108d;
    /* renamed from: e */
    final /* synthetic */ C0589a f1109e;
    /* renamed from: f */
    final /* synthetic */ int f1110f;

    Da(Thread[] threadArr, String str, String str2, JSONObject jSONObject, C0589a c0589a, int i) {
        this.f1105a = threadArr;
        this.f1106b = str;
        this.f1107c = str2;
        this.f1108d = jSONObject;
        this.f1109e = c0589a;
        this.f1110f = i;
    }

    public void run() {
        this.f1105a[0] = Ga.m1333d(this.f1106b, this.f1107c, this.f1108d, this.f1109e, this.f1110f);
    }
}
