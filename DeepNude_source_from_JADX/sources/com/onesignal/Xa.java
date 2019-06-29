package com.onesignal;

import android.content.Context;
import android.os.Bundle;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicLong;

class Xa {
    /* renamed from: a */
    private static Class<?> f1230a;
    /* renamed from: b */
    private static AtomicLong f1231b;
    /* renamed from: c */
    private static AtomicLong f1232c;
    /* renamed from: d */
    private static C0606S f1233d;
    /* renamed from: e */
    private Object f1234e;
    /* renamed from: f */
    private Context f1235f;

    Xa(Context context) {
        this.f1235f = context;
    }

    /* renamed from: a */
    private Object m1426a(Context context) {
        if (this.f1234e == null) {
            try {
                this.f1234e = m1428a(f1230a).invoke(null, new Object[]{context});
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return this.f1234e;
    }

    /* renamed from: a */
    private String m1427a(C0606S c0606s) {
        if (c0606s.f1187b.isEmpty() || c0606s.f1188c.isEmpty()) {
            String str = c0606s.f1189d;
            return str != null ? str.substring(0, Math.min(10, str.length())) : "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(c0606s.f1187b);
            stringBuilder.append(" - ");
            stringBuilder.append(c0606s.f1188c);
            return stringBuilder.toString();
        }
    }

    /* renamed from: a */
    private static Method m1428a(Class cls) {
        try {
            return cls.getMethod("getInstance", new Class[]{Context.class});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    static boolean m1429a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r0 = "com.google.firebase.analytics.FirebaseAnalytics";
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x000a }
        f1230a = r0;	 Catch:{ Throwable -> 0x000a }
        r0 = 1;
        return r0;
    L_0x000a:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.Xa.a():boolean");
    }

    /* renamed from: b */
    private static Method m1430b(Class cls) {
        try {
            return cls.getMethod("logEvent", new Class[]{String.class, Bundle.class});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    void m1431a(C0603Q c0603q) {
        if (f1232c == null) {
            f1232c = new AtomicLong();
        }
        f1232c.set(System.currentTimeMillis());
        try {
            Object a = m1426a(this.f1235f);
            Method b = m1430b(f1230a);
            Bundle bundle = new Bundle();
            bundle.putString("source", "OneSignal");
            bundle.putString("medium", "notification");
            bundle.putString("notification_id", c0603q.f1178a.f1160d.f1186a);
            bundle.putString("campaign", m1427a(c0603q.f1178a.f1160d));
            b.invoke(a, new Object[]{"os_notification_opened", bundle});
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    void m1432b() {
        if (f1231b != null) {
            if (f1233d != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - f1231b.get() <= 120000) {
                    AtomicLong atomicLong = f1232c;
                    if (atomicLong == null || currentTimeMillis - atomicLong.get() >= 30000) {
                        try {
                            Object a = m1426a(this.f1235f);
                            Method b = m1430b(f1230a);
                            Bundle bundle = new Bundle();
                            bundle.putString("source", "OneSignal");
                            bundle.putString("medium", "notification");
                            bundle.putString("notification_id", f1233d.f1186a);
                            bundle.putString("campaign", m1427a(f1233d));
                            b.invoke(a, new Object[]{"os_notification_influence_open", bundle});
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    void m1433b(C0603Q c0603q) {
        try {
            Object a = m1426a(this.f1235f);
            Method b = m1430b(f1230a);
            Bundle bundle = new Bundle();
            bundle.putString("source", "OneSignal");
            bundle.putString("medium", "notification");
            bundle.putString("notification_id", c0603q.f1178a.f1160d.f1186a);
            bundle.putString("campaign", m1427a(c0603q.f1178a.f1160d));
            b.invoke(a, new Object[]{"os_notification_received", bundle});
            if (f1231b == null) {
                f1231b = new AtomicLong();
            }
            f1231b.set(System.currentTimeMillis());
            f1233d = c0603q.f1178a.f1160d;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
