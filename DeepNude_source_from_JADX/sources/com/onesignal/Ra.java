package com.onesignal;

import com.google.android.gms.gcm.GoogleCloudMessaging;

class Ra extends Pa {
    Ra() {
    }

    /* renamed from: a */
    String mo1747a(String str) {
        return GoogleCloudMessaging.getInstance(sa.f1380f).register(str);
    }

    /* renamed from: c */
    String mo1748c() {
        return GoogleCloudMessaging.INSTANCE_ID_SCOPE;
    }
}
