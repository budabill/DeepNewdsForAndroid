package com.onesignal;

import org.json.JSONException;
import org.json.JSONObject;

class eb extends nb {
    eb() {
    }

    /* renamed from: a */
    protected cb mo1374a(String str, boolean z) {
        return new db(str, z);
    }

    /* renamed from: a */
    protected String mo1375a() {
        return sa.m1736s();
    }

    /* renamed from: a */
    void mo1376a(String str) {
        sa.m1709g(str);
    }

    /* renamed from: a */
    protected void mo1377a(JSONObject jSONObject) {
        try {
            jSONObject.put("device_type", 11);
            jSONObject.putOpt("device_player_id", sa.m1616A());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    protected void mo1378b(JSONObject jSONObject) {
        if (jSONObject.has("identifier")) {
            sa.m1732o();
        }
    }

    /* renamed from: c */
    protected void mo1379c(JSONObject jSONObject) {
        if (jSONObject.has("identifier")) {
            sa.m1733p();
        }
    }

    /* renamed from: h */
    protected void mo1380h() {
        Object obj = (mo1375a() == null && m1557b() == null) ? 1 : null;
        if (obj != null) {
            return;
        }
        if (sa.m1616A() != null) {
            m1549a(Integer.valueOf(0)).m1532b();
        }
    }

    /* renamed from: j */
    void mo1381j() {
        mo1380h();
    }
}
