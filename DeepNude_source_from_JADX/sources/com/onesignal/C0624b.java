package com.onesignal;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import com.onesignal.sa.C0650i;

/* renamed from: com.onesignal.b */
class C0624b {
    /* renamed from: a */
    static boolean f1258a;
    /* renamed from: b */
    static Activity f1259b;
    /* renamed from: c */
    private static C0621a f1260c;
    /* renamed from: d */
    static C0623c f1261d = new C0623c();

    /* renamed from: com.onesignal.b$a */
    interface C0621a {
        /* renamed from: a */
        void mo1362a(Activity activity);
    }

    /* renamed from: com.onesignal.b$b */
    private static class C0622b implements Runnable {
        /* renamed from: a */
        private boolean f1254a;
        /* renamed from: b */
        private boolean f1255b;

        private C0622b() {
        }

        public void run() {
            if (C0624b.f1259b == null) {
                this.f1254a = true;
                sa.m1622G();
                this.f1255b = true;
            }
        }
    }

    /* renamed from: com.onesignal.b$c */
    static class C0623c extends HandlerThread {
        /* renamed from: a */
        Handler f1256a = null;
        /* renamed from: b */
        private C0622b f1257b;

        C0623c() {
            super("FocusHandlerThread");
            start();
            this.f1256a = new Handler(getLooper());
        }

        /* renamed from: a */
        void m1489a(C0622b c0622b) {
            C0622b c0622b2 = this.f1257b;
            if (c0622b2 == null || !c0622b2.f1254a || this.f1257b.f1255b) {
                this.f1257b = c0622b;
                this.f1256a.removeCallbacksAndMessages(null);
                this.f1256a.postDelayed(c0622b, 2000);
            }
        }

        /* renamed from: a */
        boolean m1490a() {
            C0622b c0622b = this.f1257b;
            return c0622b != null && c0622b.f1254a;
        }

        /* renamed from: b */
        void m1491b() {
            C0622b c0622b = this.f1257b;
            if (c0622b != null) {
                c0622b.f1254a = false;
            }
        }

        /* renamed from: c */
        void m1492c() {
            this.f1256a.removeCallbacksAndMessages(null);
        }
    }

    /* renamed from: a */
    private static void m1493a() {
        if (!f1261d.m1490a()) {
            if (!f1258a) {
                f1261d.m1492c();
                return;
            }
        }
        f1258a = false;
        f1261d.m1491b();
        sa.m1621F();
    }

    /* renamed from: a */
    static void m1494a(Activity activity) {
    }

    /* renamed from: a */
    public static void m1495a(C0621a c0621a) {
        f1260c = null;
    }

    /* renamed from: b */
    private static void m1496b() {
        f1261d.m1489a(new C0622b());
    }

    /* renamed from: b */
    static void m1497b(Activity activity) {
        C0650i c0650i = C0650i.DEBUG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onActivityDestroyed: ");
        stringBuilder.append(activity.getClass().getName());
        sa.m1656a(c0650i, stringBuilder.toString());
        if (activity == f1259b) {
            f1259b = null;
            C0624b.m1496b();
        }
        C0624b.m1499c();
    }

    /* renamed from: b */
    static void m1498b(C0621a c0621a) {
        Activity activity = f1259b;
        if (activity != null) {
            c0621a.mo1362a(activity);
        }
        f1260c = c0621a;
    }

    /* renamed from: c */
    private static void m1499c() {
        String stringBuilder;
        C0650i c0650i = C0650i.DEBUG;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("curActivity is NOW: ");
        if (f1259b != null) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("");
            stringBuilder3.append(f1259b.getClass().getName());
            stringBuilder3.append(":");
            stringBuilder3.append(f1259b);
            stringBuilder = stringBuilder3.toString();
        } else {
            stringBuilder = "null";
        }
        stringBuilder2.append(stringBuilder);
        sa.m1656a(c0650i, stringBuilder2.toString());
    }

    /* renamed from: c */
    static void m1500c(Activity activity) {
        if (activity == f1259b) {
            f1259b = null;
            C0624b.m1496b();
        }
        C0624b.m1499c();
    }

    /* renamed from: d */
    static void m1501d(Activity activity) {
        C0624b.m1504g(activity);
        C0624b.m1499c();
        C0624b.m1493a();
    }

    /* renamed from: e */
    static void m1502e(Activity activity) {
    }

    /* renamed from: f */
    static void m1503f(Activity activity) {
        C0650i c0650i = C0650i.DEBUG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onActivityStopped: ");
        stringBuilder.append(activity.getClass().getName());
        sa.m1656a(c0650i, stringBuilder.toString());
        if (activity == f1259b) {
            f1259b = null;
            C0624b.m1496b();
        }
        C0624b.m1499c();
    }

    /* renamed from: g */
    private static void m1504g(Activity activity) {
        f1259b = activity;
        C0621a c0621a = f1260c;
        if (c0621a != null) {
            c0621a.mo1362a(f1259b);
        }
    }
}
