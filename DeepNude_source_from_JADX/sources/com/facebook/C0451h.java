package com.facebook;

/* renamed from: com.facebook.h */
public enum C0451h {
    NONE(false),
    FACEBOOK_APPLICATION_WEB(true),
    FACEBOOK_APPLICATION_NATIVE(true),
    FACEBOOK_APPLICATION_SERVICE(true),
    WEB_VIEW(true),
    CHROME_CUSTOM_TAB(true),
    TEST_USER(true),
    CLIENT_TOKEN(true),
    DEVICE_AUTH(true);
    
    /* renamed from: k */
    private final boolean f783k;

    private C0451h(boolean z) {
        this.f783k = z;
    }

    /* renamed from: a */
    boolean m867a() {
        return this.f783k;
    }
}
