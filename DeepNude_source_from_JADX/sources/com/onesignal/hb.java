package com.onesignal;

import com.onesignal.nb.C0634a;
import org.json.JSONException;
import org.json.JSONObject;

class hb extends nb {
    /* renamed from: j */
    private static boolean f1837j;

    hb() {
    }

    /* renamed from: a */
    protected cb mo1374a(String str, boolean z) {
        return new fb(str, z);
    }

    /* renamed from: a */
    protected String mo1375a() {
        return sa.m1616A();
    }

    /* renamed from: a */
    void mo1376a(String str) {
        sa.m1713h(str);
    }

    /* renamed from: a */
    protected void mo1377a(JSONObject jSONObject) {
    }

    /* renamed from: b */
    protected void mo1378b(JSONObject jSONObject) {
        if (jSONObject.has("email")) {
            sa.m1732o();
        }
    }

    /* renamed from: c */
    C0634a m2283c(boolean z) {
        C0634a c0634a;
        if (z) {
            String A = sa.m1616A();
            String x = sa.m1741x();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("players/");
            stringBuilder.append(A);
            stringBuilder.append("?app_id=");
            stringBuilder.append(x);
            Ga.m1329b(stringBuilder.toString(), new gb(this));
        }
        synchronized (this.f1283a) {
            c0634a = new C0634a(f1837j, C0662y.m1759a(this.f1291i.f1270f, "tags"));
        }
        return c0634a;
    }

    /* renamed from: c */
    protected void mo1379c(JSONObject jSONObject) {
        if (jSONObject.has("email")) {
            sa.m1733p();
        }
        if (jSONObject.has("identifier")) {
            sa.m1734q();
        }
    }

    /* renamed from: d */
    public void m2285d(boolean z) {
        try {
            m1561d().f1269e.put("androidPermission", z);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    void m2286e(JSONObject jSONObject) {
        String str = "parent_player_id";
        String str2 = "identifier";
        String str3 = "androidPermission";
        String str4 = "device_type";
        String str5 = "subscribableStatus";
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt(str2, jSONObject.optString(str2, null));
            if (jSONObject.has(str4)) {
                jSONObject2.put(str4, jSONObject.optInt(str4));
            }
            jSONObject2.putOpt(str, jSONObject.optString(str, null));
            JSONObject jSONObject3 = m1561d().f1270f;
            m1551a(jSONObject3, jSONObject2, jSONObject3, null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            jSONObject3 = new JSONObject();
            if (jSONObject.has(str5)) {
                jSONObject3.put(str5, jSONObject.optInt(str5));
            }
            if (jSONObject.has(str3)) {
                jSONObject3.put(str3, jSONObject.optBoolean(str3));
            }
            jSONObject = m1561d().f1269e;
            m1551a(jSONObject, jSONObject3, jSONObject, null);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: h */
    protected void mo1380h() {
        m1549a(Integer.valueOf(0)).m1532b();
    }

    /* renamed from: j */
    boolean mo1381j() {
        return m1559c().mo1373b();
    }

    /* renamed from: k */
    public boolean mo1383k() {
        return m1559c().f1269e.optBoolean("userSubscribePref", true);
    }
}
