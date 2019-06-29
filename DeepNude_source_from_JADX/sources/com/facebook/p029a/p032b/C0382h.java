package com.facebook.p029a.p032b;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.util.Log;
import com.facebook.C0560t;
import com.facebook.internal.C0457C;
import com.facebook.internal.C0475Q;
import com.facebook.internal.C0503y;
import com.facebook.p029a.p030a.C0363e;
import com.facebook.p029a.p030a.C0371l;
import com.facebook.p029a.p030a.C0373m;
import com.facebook.p029a.p032b.C0401y.C0400a;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.facebook.a.b.h */
public class C0382h {
    /* renamed from: a */
    private static final String f616a = "com.facebook.a.b.h";
    /* renamed from: b */
    private static final ScheduledExecutorService f617b = Executors.newSingleThreadScheduledExecutor();
    /* renamed from: c */
    private static volatile ScheduledFuture f618c;
    /* renamed from: d */
    private static final Object f619d = new Object();
    /* renamed from: e */
    private static AtomicInteger f620e = new AtomicInteger(0);
    /* renamed from: f */
    private static volatile C0397v f621f;
    /* renamed from: g */
    private static AtomicBoolean f622g = new AtomicBoolean(false);
    /* renamed from: h */
    private static String f623h;
    /* renamed from: i */
    private static long f624i;
    /* renamed from: j */
    private static final C0363e f625j = new C0363e();
    /* renamed from: k */
    private static final C0373m f626k = new C0373m();
    /* renamed from: l */
    private static SensorManager f627l;
    /* renamed from: m */
    private static C0371l f628m;
    /* renamed from: n */
    private static String f629n = null;
    /* renamed from: o */
    private static Boolean f630o;
    /* renamed from: p */
    private static volatile Boolean f631p;

    static {
        Boolean valueOf = Boolean.valueOf(false);
        f630o = valueOf;
        f631p = valueOf;
    }

    /* renamed from: a */
    public static void m666a(Application application, String str) {
        if (f622g.compareAndSet(false, true)) {
            f623h = str;
            application.registerActivityLifecycleCallbacks(new C0376a());
        }
    }

    /* renamed from: b */
    public static void m669b(Activity activity) {
        System.currentTimeMillis();
        activity.getApplicationContext();
        C0475Q.m993b((Context) activity);
        C0400a.m744a(activity);
        f617b.execute(new C0377b());
    }

    /* renamed from: b */
    public static void m670b(String str) {
        if (!f631p.booleanValue()) {
            f631p = Boolean.valueOf(true);
            C0560t.m1258j().execute(new C0381g(str));
        }
    }

    /* renamed from: c */
    public static void m672c(Activity activity) {
        f620e.incrementAndGet();
        C0382h.m685n();
        long currentTimeMillis = System.currentTimeMillis();
        f624i = currentTimeMillis;
        String b = C0475Q.m993b((Context) activity);
        f625j.m642a(activity);
        f617b.execute(new C0378c(currentTimeMillis, b));
        Context applicationContext = activity.getApplicationContext();
        String e = C0560t.m1253e();
        C0503y b2 = C0457C.m876b(e);
        if (b2 != null) {
            if (b2.m1100c()) {
                f627l = (SensorManager) applicationContext.getSystemService("sensor");
                SensorManager sensorManager = f627l;
                if (sensorManager != null) {
                    Sensor defaultSensor = sensorManager.getDefaultSensor(1);
                    f628m = new C0371l(activity);
                    f626k.m659a(new C0823d(b2, e));
                    f627l.registerListener(f626k, defaultSensor, 2);
                    if (b2 != null && b2.m1099b()) {
                        f628m.m656b();
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public static void m673c(Boolean bool) {
        f630o = bool;
    }

    /* renamed from: d */
    private static void m675d(Activity activity) {
        if (f620e.decrementAndGet() < 0) {
            f620e.set(0);
            Log.w(f616a, "Unexpected activity pause without a matching activity resume. Logging data may be incorrect. Make sure you call activateApp from your Application's onCreate method");
        }
        C0382h.m685n();
        long currentTimeMillis = System.currentTimeMillis();
        String b = C0475Q.m993b((Context) activity);
        f625j.m643b(activity);
        f617b.execute(new C0380f(currentTimeMillis, b));
        C0371l c0371l = f628m;
        if (c0371l != null) {
            c0371l.m657c();
        }
        SensorManager sensorManager = f627l;
        if (sensorManager != null) {
            sensorManager.unregisterListener(f626k);
        }
    }

    /* renamed from: k */
    public static String m682k() {
        if (f629n == null) {
            f629n = UUID.randomUUID().toString();
        }
        return f629n;
    }

    /* renamed from: l */
    public static UUID m683l() {
        return f621f != null ? f621f.m734d() : null;
    }

    /* renamed from: m */
    public static boolean m684m() {
        return f630o.booleanValue();
    }

    /* renamed from: n */
    private static void m685n() {
        synchronized (f619d) {
            if (f618c != null) {
                f618c.cancel(false);
            }
            f618c = null;
        }
    }

    /* renamed from: o */
    private static int m686o() {
        C0503y b = C0457C.m876b(C0560t.m1253e());
        return b == null ? C0390n.m700a() : b.m1106i();
    }
}
