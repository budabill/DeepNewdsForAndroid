package com.onesignal;

import com.onesignal.Ga.C0589a;
import org.json.JSONObject;

class oa extends C0589a {
    oa() {
    }

    /* renamed from: a */
    void mo1382a(int i, String str, Throwable th) {
        new Thread(new na(this), "OS_PARAMS_REQUEST").start();
    }

    /* renamed from: a */
    void mo1370a(String str) {
        String str2 = "android_sender_id";
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(str2)) {
                sa.f1379e = true;
                sa.f1378d = jSONObject.getString(str2);
            }
            sa.f1364P = jSONObject.optBoolean("enterp", false);
            sa.f1365Q = jSONObject.optBoolean("use_email_auth", false);
            sa.f1363O = jSONObject.getJSONObject("awl_list");
            za.m1778b(za.f1415a, "GT_FIREBASE_TRACKING_ENABLED", jSONObject.optBoolean("fba", false));
            C0586E.m1312a(sa.f1380f, jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        sa.f1352D = true;
        sa.m1633R();
    }
}
