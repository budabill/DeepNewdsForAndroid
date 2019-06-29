package com.facebook.p035c;

import android.app.Application;
import com.facebook.marketing.internal.C0531b;

/* renamed from: com.facebook.c.b */
public class C0441b {
    /* renamed from: a */
    private static Boolean f760a = Boolean.valueOf(false);
    /* renamed from: b */
    private static final C0531b f761b = new C0531b();

    /* renamed from: a */
    public static void m850a(Application application) {
        application.registerActivityLifecycleCallbacks(new C0440a());
    }
}
