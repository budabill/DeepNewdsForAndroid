package com.facebook.login;

import java.util.Collections;
import java.util.Set;

/* renamed from: com.facebook.login.A */
public class C0507A {
    /* renamed from: a */
    private static final Set<String> f942a = C0507A.m1109a();

    /* renamed from: a */
    private static Set<String> m1109a() {
        return Collections.unmodifiableSet(new C0528z());
    }

    /* renamed from: a */
    static boolean m1110a(String str) {
        return str != null && (str.startsWith("publish") || str.startsWith("manage") || f942a.contains(str));
    }
}
