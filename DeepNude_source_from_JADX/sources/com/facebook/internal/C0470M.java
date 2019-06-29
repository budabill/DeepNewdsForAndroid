package com.facebook.internal;

import com.facebook.C0560t;
import java.util.Collection;

/* renamed from: com.facebook.internal.M */
public final class C0470M {
    /* renamed from: a */
    public static final Collection<String> f832a = C0475Q.m995b("service_disabled", "AndroidAuthKillSwitchException");
    /* renamed from: b */
    public static final Collection<String> f833b = C0475Q.m995b("access_denied", "OAuthAccessDeniedException");

    /* renamed from: a */
    public static final String m946a() {
        return "v3.2";
    }

    /* renamed from: b */
    public static final String m947b() {
        return String.format("m.%s", new Object[]{C0560t.m1259k()});
    }

    /* renamed from: c */
    public static final String m948c() {
        return String.format("https://graph.%s", new Object[]{C0560t.m1259k()});
    }

    /* renamed from: d */
    public static final String m949d() {
        return String.format("https://graph-video.%s", new Object[]{C0560t.m1259k()});
    }
}
