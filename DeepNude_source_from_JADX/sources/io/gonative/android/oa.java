package io.gonative.android;

import android.os.Handler;
import android.util.Log;
import com.onesignal.sa.C0647f;
import org.json.JSONObject;

class oa implements C0647f {
    /* renamed from: a */
    final /* synthetic */ String f1890a;
    /* renamed from: b */
    final /* synthetic */ wa f1891b;

    oa(wa waVar, String str) {
        this.f1891b = waVar;
        this.f1890a = str;
    }

    /* renamed from: a */
    public void mo1410a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("success", true);
            if (jSONObject != null) {
                jSONObject2.put("tags", jSONObject);
            }
            new Handler(this.f1891b.f1663b.getMainLooper()).post(new la(this, C0726s.m1966a(this.f1890a, jSONObject2)));
        } catch (Throwable e) {
            Log.e(wa.f1662a, "Error json encoding tags", e);
        }
    }
}
