package com.onesignal;

import com.google.android.gms.common.api.GoogleApiClient;

/* renamed from: com.onesignal.t */
class C0657t {
    /* renamed from: a */
    private final GoogleApiClient f1402a;
    /* renamed from: b */
    private final Class f1403b;

    C0657t(GoogleApiClient googleApiClient) {
        this.f1402a = googleApiClient;
        this.f1403b = googleApiClient.getClass();
    }

    /* renamed from: a */
    void m1744a() {
        try {
            this.f1403b.getMethod("connect", new Class[0]).invoke(this.f1402a, new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    void m1745b() {
        try {
            this.f1403b.getMethod("disconnect", new Class[0]).invoke(this.f1402a, new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: c */
    GoogleApiClient m1746c() {
        return this.f1402a;
    }
}
