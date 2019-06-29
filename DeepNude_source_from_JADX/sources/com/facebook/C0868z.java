package com.facebook;

import com.facebook.GraphRequest.C0339c;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Locale;

/* renamed from: com.facebook.z */
class C0868z implements C0339c {
    /* renamed from: a */
    final /* synthetic */ ArrayList f1819a;
    /* renamed from: b */
    final /* synthetic */ GraphRequest f1820b;

    C0868z(GraphRequest graphRequest, ArrayList arrayList) {
        this.f1820b = graphRequest;
        this.f1819a = arrayList;
    }

    /* renamed from: a */
    public void mo945a(String str, String str2) {
        this.f1819a.add(String.format(Locale.US, "%s=%s", new Object[]{str, URLEncoder.encode(str2, "UTF-8")}));
    }
}
