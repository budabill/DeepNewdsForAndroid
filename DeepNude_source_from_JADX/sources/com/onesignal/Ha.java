package com.onesignal;

import com.onesignal.C0582B.C0581f;
import com.onesignal.nb.C0634a;
import com.onesignal.sa.C0643b;
import com.onesignal.sa.C0655n;
import org.json.JSONException;
import org.json.JSONObject;

class Ha {
    /* renamed from: a */
    private static hb f1131a;
    /* renamed from: b */
    private static eb f1132b;

    /* renamed from: a */
    static eb m1335a() {
        if (f1132b == null) {
            f1132b = new eb();
        }
        return f1132b;
    }

    /* renamed from: a */
    static C0634a m1336a(boolean z) {
        return m1340b().m2283c(z);
    }

    /* renamed from: a */
    static void m1337a(C0581f c0581f) {
        m1340b().m1552a(c0581f);
        m1335a().m1552a(c0581f);
    }

    /* renamed from: a */
    static void m1338a(JSONObject jSONObject) {
        m1340b().m1562d(jSONObject);
        m1335a().m1562d(jSONObject);
    }

    /* renamed from: a */
    static void m1339a(JSONObject jSONObject, C0643b c0643b) {
        try {
            jSONObject = new JSONObject().put("tags", jSONObject);
            m1340b().m1555a(jSONObject, c0643b);
            m1335a().m1555a(jSONObject, c0643b);
        } catch (JSONException e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Encountered an error attempting to serialize your tags into JSON: ");
            stringBuilder.append(e.getMessage());
            stringBuilder.append("\n");
            stringBuilder.append(e.getStackTrace());
            c0643b.m1607a(new C0655n(-1, stringBuilder.toString()));
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    static hb m1340b() {
        if (f1131a == null) {
            f1131a = new hb();
        }
        return f1131a;
    }

    /* renamed from: b */
    static void m1341b(JSONObject jSONObject) {
        m1340b().m2286e(jSONObject);
    }

    /* renamed from: b */
    static void m1342b(boolean z) {
        m1340b().m2285d(z);
    }

    /* renamed from: c */
    static String m1343c() {
        return m1340b().m1557b();
    }

    /* renamed from: c */
    static void m1344c(boolean z) {
        m1340b().m1556a(z);
        m1335a().m1556a(z);
    }

    /* renamed from: d */
    static boolean m1345d() {
        return m1340b().mo1381j();
    }

    /* renamed from: e */
    static boolean m1346e() {
        return m1340b().mo1383k();
    }

    /* renamed from: f */
    static void m1347f() {
        m1340b().m1563e();
        m1335a().m1563e();
    }

    /* renamed from: g */
    static boolean m1348g() {
        boolean f = m1340b().m1564f();
        boolean f2 = m1335a().m1564f();
        if (f2) {
            f2 = m1335a().m1557b() != null;
        }
        return f || f2;
    }

    /* renamed from: h */
    static void m1349h() {
        m1335a().mo1381j();
    }

    /* renamed from: i */
    static void m1350i() {
        m1340b().m1565g();
        m1335a().m1565g();
        sa.m1700e(null);
        sa.m1695d(null);
        sa.m1684c(-3660);
    }

    /* renamed from: j */
    static void m1351j() {
        m1340b().m1567i();
        m1335a().m1567i();
    }

    /* renamed from: k */
    static void m1352k() {
        m1335a().m1567i();
    }
}
