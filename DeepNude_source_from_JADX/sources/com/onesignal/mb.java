package com.onesignal;

import com.onesignal.Ga.C0589a;
import com.onesignal.sa.C0650i;
import org.json.JSONObject;

class mb extends C0589a {
    /* renamed from: a */
    final /* synthetic */ JSONObject f1845a;
    /* renamed from: b */
    final /* synthetic */ JSONObject f1846b;
    /* renamed from: c */
    final /* synthetic */ String f1847c;
    /* renamed from: d */
    final /* synthetic */ nb f1848d;

    mb(nb nbVar, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        this.f1848d = nbVar;
        this.f1845a = jSONObject;
        this.f1846b = jSONObject2;
        this.f1847c = str;
    }

    /* renamed from: a */
    void mo1382a(int i, String str, Throwable th) {
        synchronized (this.f1848d.f1283a) {
            this.f1848d.f1289g = false;
            C0650i c0650i = C0650i.WARN;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed last request. statusCode: ");
            stringBuilder.append(i);
            stringBuilder.append("\nresponse: ");
            stringBuilder.append(str);
            sa.m1656a(c0650i, stringBuilder.toString());
            if (this.f1848d.m1535a(i, str, "not a valid device_type")) {
                this.f1848d.mo1383k();
            } else {
                this.f1848d.mo1381j();
            }
        }
    }

    /* renamed from: a */
    void mo1370a(String str) {
        synchronized (this.f1848d.f1283a) {
            nb nbVar = this.f1848d;
            this.f1848d.f1289g = false;
            nbVar.f1288f = false;
            this.f1848d.f1290h.m1515b(this.f1845a, this.f1846b);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("id")) {
                    str = jSONObject.optString("id");
                    this.f1848d.mo1376a(str);
                    C0650i c0650i = C0650i.INFO;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Device registered, UserId = ");
                    stringBuilder.append(str);
                    sa.m1656a(c0650i, stringBuilder.toString());
                } else {
                    C0650i c0650i2 = C0650i.INFO;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("session sent, UserId = ");
                    stringBuilder2.append(this.f1847c);
                    sa.m1656a(c0650i2, stringBuilder2.toString());
                }
                sa.m1625J();
                this.f1848d.mo1379c(this.f1846b);
            } catch (Throwable th) {
                sa.m1657a(C0650i.ERROR, "ERROR parsing on_session or create JSON Response.", th);
            }
        }
    }
}
