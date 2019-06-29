package com.onesignal;

import com.onesignal.Ga.C0589a;
import com.onesignal.sa.C0643b;
import com.onesignal.sa.C0650i;
import com.onesignal.sa.C0655n;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

class lb extends C0589a {
    /* renamed from: a */
    final /* synthetic */ JSONObject f1841a;
    /* renamed from: b */
    final /* synthetic */ ArrayList f1842b;
    /* renamed from: c */
    final /* synthetic */ JSONObject f1843c;
    /* renamed from: d */
    final /* synthetic */ nb f1844d;

    lb(nb nbVar, JSONObject jSONObject, ArrayList arrayList, JSONObject jSONObject2) {
        this.f1844d = nbVar;
        this.f1841a = jSONObject;
        this.f1842b = arrayList;
        this.f1843c = jSONObject2;
    }

    /* renamed from: a */
    void mo1382a(int i, String str, Throwable th) {
        C0650i c0650i = C0650i.WARN;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed last request. statusCode: ");
        stringBuilder.append(i);
        stringBuilder.append("\nresponse: ");
        stringBuilder.append(str);
        sa.m1656a(c0650i, stringBuilder.toString());
        synchronized (this.f1844d.f1283a) {
            if (this.f1844d.m1535a(i, str, "No user with this id found")) {
                this.f1844d.mo1383k();
            } else {
                this.f1844d.mo1381j();
            }
        }
        if (this.f1841a.has("tags")) {
            Iterator it = this.f1842b.iterator();
            while (it.hasNext()) {
                C0643b c0643b = (C0643b) it.next();
                if (c0643b != null) {
                    c0643b.m1607a(new C0655n(i, str));
                }
            }
        }
    }

    /* renamed from: a */
    void mo1370a(String str) {
        synchronized (this.f1844d.f1283a) {
            this.f1844d.f1290h.m1515b(this.f1843c, this.f1841a);
            this.f1844d.mo1379c(this.f1841a);
        }
        JSONObject jSONObject = Ha.m1336a(false).f1278b;
        if (this.f1841a.has("tags") && jSONObject != null) {
            Iterator it = this.f1842b.iterator();
            while (it.hasNext()) {
                C0643b c0643b = (C0643b) it.next();
                if (c0643b != null) {
                    c0643b.m1608a(jSONObject);
                }
            }
        }
    }
}
