package com.onesignal;

import com.onesignal.Ga.C0589a;
import com.onesignal.sa.C0650i;

class kb extends C0589a {
    /* renamed from: a */
    final /* synthetic */ nb f1839a;

    kb(nb nbVar) {
        this.f1839a = nbVar;
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
        if (this.f1839a.m1535a(i, str, "already logged out of email")) {
            this.f1839a.m1546m();
            return;
        }
        if (this.f1839a.m1535a(i, str, "not a valid device_type")) {
            this.f1839a.mo1383k();
        } else {
            this.f1839a.mo1381j();
        }
    }

    /* renamed from: a */
    void mo1370a(String str) {
        this.f1839a.m1546m();
    }
}
