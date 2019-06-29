package com.facebook.p029a.p032b;

import android.os.Bundle;
import com.facebook.C0336G;
import com.facebook.internal.C0461G;
import com.facebook.p029a.C0422r;
import com.facebook.p029a.C0422r.C0421a;
import java.util.Locale;

/* renamed from: com.facebook.a.b.w */
class C0398w {
    /* renamed from: a */
    private static final String f665a = "com.facebook.a.b.w";
    /* renamed from: b */
    private static final long[] f666b = new long[]{300000, 900000, 1800000, 3600000, 21600000, 43200000, 86400000, 172800000, 259200000, 604800000, 1209600000, 1814400000, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L};

    /* renamed from: a */
    private static int m740a(long j) {
        int i = 0;
        while (true) {
            long[] jArr = f666b;
            if (i >= jArr.length || jArr[i] >= j) {
                return i;
            }
            i++;
        }
        return i;
    }

    /* renamed from: a */
    private static void m741a() {
        C0461G.m891a(C0336G.APP_EVENTS, f665a, "Clock skew detected");
    }

    /* renamed from: a */
    public static void m742a(String str, C0397v c0397v, String str2) {
        Long valueOf = Long.valueOf(c0397v.m732b() - c0397v.m735e().longValue());
        long longValue = valueOf.longValue();
        Long valueOf2 = Long.valueOf(0);
        if (longValue < 0) {
            C0398w.m741a();
            valueOf = valueOf2;
        }
        Long valueOf3 = Long.valueOf(c0397v.m736f());
        if (valueOf3.longValue() < 0) {
            C0398w.m741a();
            valueOf3 = valueOf2;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("fb_mobile_app_interruptions", c0397v.m733c());
        bundle.putString("fb_mobile_time_between_sessions", String.format(Locale.ROOT, "session_quanta_%d", new Object[]{Integer.valueOf(C0398w.m740a(valueOf.longValue()))}));
        C0401y g = c0397v.m737g();
        bundle.putString("fb_mobile_launch_source", g != null ? g.toString() : "Unclassified");
        bundle.putLong("_logTime", c0397v.m735e().longValue() / 1000);
        new C0824u(str, str2, null).m804a("fb_mobile_deactivate_app", (double) (valueOf3.longValue() / 1000), bundle);
    }

    /* renamed from: a */
    public static void m743a(String str, C0401y c0401y, String str2) {
        String c0401y2 = c0401y != null ? c0401y.toString() : "Unclassified";
        Bundle bundle = new Bundle();
        bundle.putString("fb_mobile_launch_source", c0401y2);
        C0422r c0824u = new C0824u(str, str2, null);
        c0824u.m805a("fb_mobile_activate_app", bundle);
        if (C0422r.m798d() != C0421a.EXPLICIT_ONLY) {
            c0824u.m809b();
        }
    }
}
