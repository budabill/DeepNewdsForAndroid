package com.onesignal;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.onesignal.C0582B.C0579d;
import com.onesignal.C0582B.C0581f;
import com.onesignal.C0600O.C0599a;
import com.onesignal.C0602P.C0601a;
import com.onesignal.Ga.C0589a;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class sa {
    /* renamed from: A */
    private static String f1349A;
    /* renamed from: B */
    private static boolean f1350B;
    /* renamed from: C */
    private static boolean f1351C;
    /* renamed from: D */
    private static boolean f1352D;
    /* renamed from: E */
    private static boolean f1353E;
    /* renamed from: F */
    private static C0581f f1354F;
    /* renamed from: G */
    static boolean f1355G = true;
    /* renamed from: H */
    static C0642a f1356H;
    /* renamed from: I */
    private static Collection<JSONArray> f1357I = new ArrayList();
    /* renamed from: J */
    private static HashSet<String> f1358J = new HashSet();
    /* renamed from: K */
    private static C0647f f1359K;
    /* renamed from: L */
    private static boolean f1360L;
    /* renamed from: M */
    private static boolean f1361M;
    /* renamed from: N */
    private static boolean f1362N;
    /* renamed from: O */
    private static JSONObject f1363O;
    /* renamed from: P */
    static boolean f1364P;
    /* renamed from: Q */
    private static boolean f1365Q;
    /* renamed from: R */
    static boolean f1366R = false;
    /* renamed from: S */
    static C0636o f1367S;
    /* renamed from: T */
    private static C0609V f1368T;
    /* renamed from: U */
    static C0609V f1369U;
    /* renamed from: V */
    private static C0608U<Object, C0610W> f1370V;
    /* renamed from: W */
    private static OSSubscriptionState f1371W;
    /* renamed from: X */
    static OSSubscriptionState f1372X;
    /* renamed from: Y */
    private static C0608U<C0613Y, C0614Z> f1373Y;
    /* renamed from: Z */
    private static C0598N f1374Z;
    /* renamed from: a */
    private static C0646e f1375a;
    private static C0648g aa;
    /* renamed from: b */
    private static C0646e f1376b;
    private static La ba;
    /* renamed from: c */
    static String f1377c;
    private static int ca = 0;
    /* renamed from: d */
    private static String f1378d;
    /* renamed from: e */
    private static boolean f1379e;
    /* renamed from: f */
    static Context f1380f;
    /* renamed from: g */
    private static C0650i f1381g = C0650i.NONE;
    /* renamed from: h */
    private static C0650i f1382h = C0650i.WARN;
    /* renamed from: i */
    private static String f1383i = null;
    /* renamed from: j */
    private static String f1384j = null;
    /* renamed from: k */
    private static int f1385k;
    /* renamed from: l */
    static boolean f1386l;
    /* renamed from: m */
    private static boolean f1387m;
    /* renamed from: n */
    static ExecutorService f1388n;
    /* renamed from: o */
    public static ConcurrentLinkedQueue<Runnable> f1389o = new ConcurrentLinkedQueue();
    /* renamed from: p */
    static AtomicLong f1390p = new AtomicLong();
    /* renamed from: q */
    private static C0649h f1391q;
    /* renamed from: r */
    private static long f1392r = 1;
    /* renamed from: s */
    private static long f1393s = -1;
    /* renamed from: t */
    private static ab f1394t;
    /* renamed from: u */
    private static Wa f1395u;
    /* renamed from: v */
    private static Xa f1396v;
    /* renamed from: w */
    private static C0626e f1397w = new C0875d();
    /* renamed from: x */
    private static int f1398x;
    /* renamed from: y */
    public static String f1399y = "native";
    /* renamed from: z */
    private static aa f1400z;

    /* renamed from: com.onesignal.sa$a */
    public static class C0642a {
        /* renamed from: a */
        C0651j f1315a;
        /* renamed from: b */
        C0652k f1316b;
        /* renamed from: c */
        boolean f1317c;
        /* renamed from: d */
        boolean f1318d;
        /* renamed from: e */
        boolean f1319e;
        /* renamed from: f */
        boolean f1320f;
        /* renamed from: g */
        boolean f1321g;
        /* renamed from: h */
        C0653l f1322h;

        private C0642a() {
            this.f1322h = C0653l.InAppAlert;
        }
    }

    /* renamed from: com.onesignal.sa$b */
    public interface C0643b {
        /* renamed from: a */
        void m1607a(C0655n c0655n);

        /* renamed from: a */
        void m1608a(JSONObject jSONObject);
    }

    /* renamed from: com.onesignal.sa$c */
    public enum C0644c {
        VALIDATION,
        REQUIRES_EMAIL_AUTH,
        INVALID_OPERATION,
        NETWORK
    }

    /* renamed from: com.onesignal.sa$d */
    public static class C0645d {
        /* renamed from: a */
        private C0644c f1328a;
        /* renamed from: b */
        private String f1329b;

        C0645d(C0644c c0644c, String str) {
            this.f1328a = c0644c;
            this.f1329b = str;
        }
    }

    /* renamed from: com.onesignal.sa$e */
    public interface C0646e {
        /* renamed from: a */
        void m1609a(C0645d c0645d);

        void onSuccess();
    }

    /* renamed from: com.onesignal.sa$f */
    public interface C0647f {
        /* renamed from: a */
        void mo1410a(JSONObject jSONObject);
    }

    /* renamed from: com.onesignal.sa$g */
    private static class C0648g {
        /* renamed from: a */
        JSONArray f1330a;
        /* renamed from: b */
        boolean f1331b;
        /* renamed from: c */
        C0589a f1332c;

        C0648g(JSONArray jSONArray) {
            this.f1330a = jSONArray;
        }
    }

    /* renamed from: com.onesignal.sa$h */
    public interface C0649h {
        /* renamed from: a */
        void m1611a(String str, String str2);
    }

    /* renamed from: com.onesignal.sa$i */
    public enum C0650i {
        NONE,
        FATAL,
        ERROR,
        WARN,
        INFO,
        DEBUG,
        VERBOSE
    }

    /* renamed from: com.onesignal.sa$j */
    public interface C0651j {
        /* renamed from: a */
        void mo1409a(C0603Q c0603q);
    }

    /* renamed from: com.onesignal.sa$k */
    public interface C0652k {
        /* renamed from: a */
        void m1613a(C0600O c0600o);
    }

    /* renamed from: com.onesignal.sa$l */
    public enum C0653l {
        None,
        InAppAlert,
        Notification
    }

    /* renamed from: com.onesignal.sa$m */
    private static class C0654m implements Runnable {
        /* renamed from: a */
        private Runnable f1345a;
        /* renamed from: b */
        private long f1346b;

        C0654m(Runnable runnable) {
            this.f1345a = runnable;
        }

        public void run() {
            this.f1345a.run();
            sa.m1699e(this.f1346b);
        }
    }

    /* renamed from: com.onesignal.sa$n */
    public static class C0655n {
        /* renamed from: a */
        private String f1347a;
        /* renamed from: b */
        private int f1348b;

        C0655n(int i, String str) {
            this.f1347a = str;
            this.f1348b = i;
        }
    }

    /* renamed from: A */
    static String m1616A() {
        if (f1383i == null && f1380f != null) {
            f1383i = za.m1770a(za.f1415a, "GT_PLAYER_ID", null);
        }
        return f1383i;
    }

    /* renamed from: B */
    static void m1617B() {
        C0646e c0646e = f1376b;
        if (c0646e != null) {
            c0646e.m1609a(new C0645d(C0644c.NETWORK, "Failed due to network failure. Will retry on next sync."));
            f1376b = null;
        }
    }

    /* renamed from: C */
    static void m1618C() {
        C0646e c0646e = f1376b;
        if (c0646e != null) {
            c0646e.onSuccess();
            f1376b = null;
        }
    }

    /* renamed from: D */
    static boolean m1619D() {
        return f1386l && m1620E();
    }

    /* renamed from: E */
    static boolean m1620E() {
        return f1387m;
    }

    /* renamed from: F */
    static void m1621F() {
        f1387m = true;
        C0582B.m1283f();
        f1392r = SystemClock.elapsedRealtime();
        f1362N = m1631P();
        m1684c(System.currentTimeMillis());
        m1639X();
        ab abVar = f1394t;
        if (abVar != null) {
            abVar.m1484b();
        }
        C0594K.m1384a(f1380f);
        m1715i(f1380f).m1419c();
        if (f1396v != null && m1690c(f1380f)) {
            f1396v.m1432b();
        }
        Ia.m1363a(f1380f);
    }

    /* renamed from: G */
    static boolean m1622G() {
        boolean z = false;
        f1387m = false;
        C0582B.m1283f();
        if (!f1386l) {
            return false;
        }
        Wa wa = f1395u;
        if (wa != null) {
            wa.m1423a();
        }
        if (f1392r == -1) {
            return false;
        }
        double elapsedRealtime = (double) (SystemClock.elapsedRealtime() - f1392r);
        Double.isNaN(elapsedRealtime);
        long j = (long) ((elapsedRealtime / 1000.0d) + 0.5d);
        f1392r = SystemClock.elapsedRealtime();
        if (j >= 0) {
            if (j <= 86400) {
                if (f1380f == null) {
                    m1656a(C0650i.ERROR, "Android Context not found, please call OneSignal.init when your app starts.");
                    return false;
                }
                boolean I = m1624I();
                m1684c(System.currentTimeMillis());
                long a = m1641a() + j;
                m1694d(a);
                if (a >= 60) {
                    if (m1616A() != null) {
                        if (!I) {
                            Ia.m1366b(f1380f);
                        }
                        Ia.m1370c();
                        return false;
                    }
                }
                if (a >= 60) {
                    z = true;
                }
            }
        }
        return z;
    }

    /* renamed from: H */
    public static void m1623H() {
        if (!m1705f("promptLocation()")) {
            Runnable jaVar = new ja();
            if (f1380f != null) {
                if (!m1636U()) {
                    jaVar.run();
                    return;
                }
            }
            m1656a(C0650i.ERROR, "OneSignal.init has not been called. Could not prompt for location at this time - moving this operation to awaiting queue.");
            m1659a(new C0654m(jaVar));
        }
    }

    /* renamed from: I */
    static boolean m1624I() {
        boolean g = Ha.m1348g();
        if (g) {
            Ia.m1366b(f1380f);
        }
        if (!C0582B.m1275a(f1380f)) {
            if (!g) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: J */
    static void m1625J() {
        f1362N = false;
        m1684c(System.currentTimeMillis());
    }

    /* renamed from: K */
    public static boolean m1626K() {
        return m1742y();
    }

    /* renamed from: L */
    private static void m1627L() {
        for (JSONArray c : f1357I) {
            m1687c(c, true, false);
        }
        f1357I.clear();
    }

    /* renamed from: M */
    private static La m1628M() {
        La la = ba;
        if (la != null) {
            return la;
        }
        la = f1398x == 2 ? new Na() : aa.m1454f() ? new Qa() : new Ra();
        ba = la;
        return ba;
    }

    /* renamed from: N */
    private static int m1629N() {
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        int rawOffset = timeZone.getRawOffset();
        if (timeZone.inDaylightTime(new Date())) {
            rawOffset += timeZone.getDSTSavings();
        }
        return rawOffset / 1000;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: O */
    private static synchronized void m1630O() {
        /*
        r0 = com.onesignal.sa.class;
        monitor-enter(r0);
        r1 = f1391q;	 Catch:{ all -> 0x0028 }
        if (r1 != 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r0);
        return;
    L_0x0009:
        r1 = com.onesignal.Ha.m1343c();	 Catch:{ all -> 0x0028 }
        r2 = com.onesignal.Ha.m1345d();	 Catch:{ all -> 0x0028 }
        r3 = 0;
        if (r2 != 0) goto L_0x0015;
    L_0x0014:
        r1 = r3;
    L_0x0015:
        r2 = m1616A();	 Catch:{ all -> 0x0028 }
        if (r2 != 0) goto L_0x001d;
    L_0x001b:
        monitor-exit(r0);
        return;
    L_0x001d:
        r4 = f1391q;	 Catch:{ all -> 0x0028 }
        r4.m1611a(r2, r1);	 Catch:{ all -> 0x0028 }
        if (r1 == 0) goto L_0x0026;
    L_0x0024:
        f1391q = r3;	 Catch:{ all -> 0x0028 }
    L_0x0026:
        monitor-exit(r0);
        return;
    L_0x0028:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.sa.O():void");
    }

    /* renamed from: P */
    private static boolean m1631P() {
        boolean z = true;
        if (f1362N) {
            return true;
        }
        if ((System.currentTimeMillis() - m1722k(f1380f)) / 1000 < 30) {
            z = false;
        }
        return z;
    }

    /* renamed from: Q */
    private static void m1632Q() {
        if (f1352D) {
            m1633R();
            return;
        }
        C0589a oaVar = new oa();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("apps/");
        stringBuilder.append(f1377c);
        stringBuilder.append("/android_params.js");
        String stringBuilder2 = stringBuilder.toString();
        String A = m1616A();
        if (A != null) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(stringBuilder2);
            stringBuilder3.append("?player_id=");
            stringBuilder3.append(A);
            stringBuilder2 = stringBuilder3.toString();
        }
        m1656a(C0650i.DEBUG, "Starting request to get Android parameters.");
        Ga.m1325a(stringBuilder2, oaVar);
    }

    /* renamed from: R */
    private static void m1633R() {
        m1628M().mo1363a(f1380f, f1378d, new ma());
    }

    /* renamed from: S */
    private static void m1634S() {
        C0650i c0650i = C0650i.DEBUG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("registerUser: registerForPushFired:");
        stringBuilder.append(f1350B);
        stringBuilder.append(", locationFired: ");
        stringBuilder.append(f1351C);
        stringBuilder.append(", awlFired: ");
        stringBuilder.append(f1352D);
        m1656a(c0650i, stringBuilder.toString());
        if (!f1350B || !f1351C) {
            return;
        }
        if (f1352D) {
            new Thread(new ra(), "OS_REG_USER").start();
        }
    }

    /* renamed from: T */
    private static void m1635T() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r0 = f1380f;
        r0 = r0.getPackageName();
        r1 = f1380f;
        r1 = r1.getPackageManager();
        r2 = new org.json.JSONObject;
        r2.<init>();
        r3 = f1377c;
        r4 = "app_id";
        r2.put(r4, r3);
        r3 = android.os.Build.VERSION.RELEASE;
        r4 = "device_os";
        r2.put(r4, r3);
        r3 = m1629N();
        r4 = "timezone";
        r2.put(r4, r3);
        r3 = com.onesignal.aa.m1453c();
        r4 = "language";
        r2.put(r4, r3);
        r3 = "sdk";
        r4 = "031001";
        r2.put(r3, r4);
        r3 = f1399y;
        r4 = "sdk_type";
        r2.put(r4, r3);
        r3 = "android_package";
        r2.put(r3, r0);
        r3 = android.os.Build.MODEL;
        r4 = "device_model";
        r2.put(r4, r3);
        r3 = 0;
        r4 = "game_version";	 Catch:{ NameNotFoundException -> 0x0057 }
        r0 = r1.getPackageInfo(r0, r3);	 Catch:{ NameNotFoundException -> 0x0057 }
        r0 = r0.versionCode;	 Catch:{ NameNotFoundException -> 0x0057 }
        r2.put(r4, r0);	 Catch:{ NameNotFoundException -> 0x0057 }
    L_0x0057:
        r0 = r1.getInstalledPackages(r3);	 Catch:{ Throwable -> 0x0098 }
        r1 = new org.json.JSONArray;	 Catch:{ Throwable -> 0x0098 }
        r1.<init>();	 Catch:{ Throwable -> 0x0098 }
        r4 = "SHA-256";	 Catch:{ Throwable -> 0x0098 }
        r4 = java.security.MessageDigest.getInstance(r4);	 Catch:{ Throwable -> 0x0098 }
        r5 = 0;	 Catch:{ Throwable -> 0x0098 }
    L_0x0067:
        r6 = r0.size();	 Catch:{ Throwable -> 0x0098 }
        if (r5 >= r6) goto L_0x0093;	 Catch:{ Throwable -> 0x0098 }
    L_0x006d:
        r6 = r0.get(r5);	 Catch:{ Throwable -> 0x0098 }
        r6 = (android.content.pm.PackageInfo) r6;	 Catch:{ Throwable -> 0x0098 }
        r6 = r6.packageName;	 Catch:{ Throwable -> 0x0098 }
        r6 = r6.getBytes();	 Catch:{ Throwable -> 0x0098 }
        r4.update(r6);	 Catch:{ Throwable -> 0x0098 }
        r6 = r4.digest();	 Catch:{ Throwable -> 0x0098 }
        r7 = 2;	 Catch:{ Throwable -> 0x0098 }
        r6 = android.util.Base64.encodeToString(r6, r7);	 Catch:{ Throwable -> 0x0098 }
        r7 = f1363O;	 Catch:{ Throwable -> 0x0098 }
        r7 = r7.has(r6);	 Catch:{ Throwable -> 0x0098 }
        if (r7 == 0) goto L_0x0090;	 Catch:{ Throwable -> 0x0098 }
    L_0x008d:
        r1.put(r6);	 Catch:{ Throwable -> 0x0098 }
    L_0x0090:
        r5 = r5 + 1;	 Catch:{ Throwable -> 0x0098 }
        goto L_0x0067;	 Catch:{ Throwable -> 0x0098 }
    L_0x0093:
        r0 = "pkgs";	 Catch:{ Throwable -> 0x0098 }
        r2.put(r0, r1);	 Catch:{ Throwable -> 0x0098 }
    L_0x0098:
        r0 = f1400z;
        r0 = r0.m1463e();
        r1 = "net_type";
        r2.put(r1, r0);
        r0 = f1400z;
        r0 = r0.m1461b();
        r1 = "carrier";
        r2.put(r1, r0);
        r0 = com.onesignal.Ua.m1415a();
        r1 = "rooted";
        r2.put(r1, r0);
        com.onesignal.Ha.m1338a(r2);
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = f1349A;
        r2 = "identifier";
        r0.put(r2, r1);
        r1 = f1385k;
        r2 = "subscribableStatus";
        r0.put(r2, r1);
        r1 = m1728m();
        r2 = "androidPermission";
        r0.put(r2, r1);
        r1 = f1398x;
        r2 = "device_type";
        r0.put(r2, r1);
        com.onesignal.Ha.m1341b(r0);
        r0 = f1355G;
        if (r0 == 0) goto L_0x00eb;
    L_0x00e4:
        r0 = f1354F;
        if (r0 == 0) goto L_0x00eb;
    L_0x00e8:
        com.onesignal.Ha.m1337a(r0);
    L_0x00eb:
        r0 = f1362N;
        if (r0 == 0) goto L_0x00f2;
    L_0x00ef:
        com.onesignal.Ha.m1351j();
    L_0x00f2:
        f1361M = r3;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.sa.T():void");
    }

    /* renamed from: U */
    private static boolean m1636U() {
        if (f1386l && f1388n == null) {
            return false;
        }
        if (!f1386l && f1388n == null) {
            return true;
        }
        ExecutorService executorService = f1388n;
        return (executorService == null || executorService.isShutdown()) ? false : true;
    }

    /* renamed from: V */
    private static void m1637V() {
        C0579d laVar = new la();
        boolean z = f1356H.f1317c && !f1353E;
        C0582B.m1273a(f1380f, z, laVar);
    }

    /* renamed from: W */
    private static void m1638W() {
        if (!f1389o.isEmpty()) {
            f1388n = Executors.newSingleThreadExecutor(new ha());
            while (!f1389o.isEmpty()) {
                f1388n.submit((Runnable) f1389o.poll());
            }
        }
    }

    /* renamed from: X */
    private static void m1639X() {
        if (!f1361M) {
            boolean z = true;
            f1361M = true;
            f1350B = false;
            if (f1362N) {
                f1351C = false;
            }
            m1637V();
            m1632Q();
            if (!f1353E) {
                if (!f1356H.f1317c) {
                    z = false;
                }
            }
            f1353E = z;
        }
    }

    /* renamed from: a */
    static long m1641a() {
        if (f1393s == -1 && f1380f != null) {
            f1393s = za.m1767a(za.f1415a, "GT_UNSENT_ACTIVE_TIME", 0);
        }
        C0650i c0650i = C0650i.INFO;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GetUnsentActiveTime: ");
        stringBuilder.append(f1393s);
        m1656a(c0650i, stringBuilder.toString());
        return f1393s;
    }

    /* renamed from: a */
    static String m1644a(Bundle bundle) {
        String str = "i";
        String str2 = "custom";
        if (bundle.isEmpty()) {
            return null;
        }
        try {
            C0650i c0650i;
            if (bundle.containsKey(str2)) {
                JSONObject jSONObject = new JSONObject(bundle.getString(str2));
                if (jSONObject.has(str)) {
                    return jSONObject.optString(str, null);
                }
                c0650i = C0650i.DEBUG;
                str = "Not a OneSignal formatted GCM message. No 'i' field in custom.";
            } else {
                c0650i = C0650i.DEBUG;
                str = "Not a OneSignal formatted GCM message. No 'custom' field in the bundle.";
            }
            m1656a(c0650i, str);
        } catch (Throwable th) {
            m1657a(C0650i.DEBUG, "Could not parse bundle, probably not a OneSignal notification.", th);
        }
        return null;
    }

    /* renamed from: a */
    static void m1648a(long j, boolean z) {
        try {
            JSONObject put = new JSONObject().put("app_id", f1377c).put("type", 1).put("state", "ping").put("active_time", j);
            m1688c(put);
            m1663a(m1616A(), put, z);
            String s = m1736s();
            if (s != null) {
                m1663a(s, put, z);
            }
        } catch (Throwable th) {
            m1657a(C0650i.ERROR, "Generating on_focus:JSON Failed.", th);
        }
    }

    /* renamed from: a */
    public static void m1649a(Context context, String str, String str2, C0651j c0651j) {
        m1650a(context, str, str2, c0651j, null);
    }

    /* renamed from: a */
    public static void m1650a(android.content.Context r8, java.lang.String r9, java.lang.String r10, com.onesignal.sa.C0651j r11, com.onesignal.sa.C0652k r12) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        m1704f(r8);
        r0 = f1366R;
        if (r0 == 0) goto L_0x0022;
    L_0x0007:
        r0 = m1626K();
        if (r0 != 0) goto L_0x0022;
    L_0x000d:
        r0 = com.onesignal.sa.C0650i.VERBOSE;
        r1 = "OneSignal SDK initialization delayed, user privacy consent is set to required for this application.";
        m1656a(r0, r1);
        r0 = new com.onesignal.o;
        r2 = r0;
        r3 = r8;
        r4 = r9;
        r5 = r10;
        r6 = r11;
        r7 = r12;
        r2.<init>(r3, r4, r5, r6, r7);
        f1367S = r0;
        return;
    L_0x0022:
        r0 = m1735r();
        f1356H = r0;
        r0 = f1356H;
        r1 = 0;
        r0.f1321g = r1;
        r0.f1315a = r11;
        r0.f1316b = r12;
        r11 = f1379e;
        if (r11 != 0) goto L_0x0037;
    L_0x0035:
        f1378d = r9;
    L_0x0037:
        r9 = new com.onesignal.aa;
        r9.<init>();
        f1400z = r9;
        r9 = f1400z;
        r9 = r9.m1462d();
        f1398x = r9;
        r9 = f1400z;
        r11 = f1398x;
        r9 = r9.m1459a(r8, r11, r10);
        f1385k = r9;
        r9 = f1385k;
        r11 = -999; // 0xfffffffffffffc19 float:NaN double:NaN;
        if (r9 != r11) goto L_0x0057;
    L_0x0056:
        return;
    L_0x0057:
        r9 = f1386l;
        if (r9 == 0) goto L_0x0065;
    L_0x005b:
        r8 = f1356H;
        r8 = r8.f1315a;
        if (r8 == 0) goto L_0x0064;
    L_0x0061:
        m1627L();
    L_0x0064:
        return;
    L_0x0065:
        r9 = r8 instanceof android.app.Activity;
        f1387m = r9;
        f1377c = r10;
        r10 = f1356H;
        r10 = r10.f1320f;
        m1717i(r10);
        r10 = 1;
        if (r9 == 0) goto L_0x007f;
    L_0x0075:
        r8 = (android.app.Activity) r8;
        com.onesignal.C0624b.f1259b = r8;
        r8 = f1380f;
        com.onesignal.C0594K.m1384a(r8);
        goto L_0x0081;
    L_0x007f:
        com.onesignal.C0624b.f1258a = r10;
    L_0x0081:
        r8 = android.os.SystemClock.elapsedRealtime();
        f1392r = r8;
        com.onesignal.Ha.m1347f();
        r8 = f1380f;
        r8 = (android.app.Application) r8;
        r9 = new com.onesignal.c;
        r9.<init>();
        r8.registerActivityLifecycleCallbacks(r9);
        r8 = "com.amazon.device.iap.PurchasingListener";
        java.lang.Class.forName(r8);	 Catch:{ ClassNotFoundException -> 0x00a4 }
        r8 = new com.onesignal.Wa;	 Catch:{ ClassNotFoundException -> 0x00a4 }
        r9 = f1380f;	 Catch:{ ClassNotFoundException -> 0x00a4 }
        r8.<init>(r9);	 Catch:{ ClassNotFoundException -> 0x00a4 }
        f1395u = r8;	 Catch:{ ClassNotFoundException -> 0x00a4 }
    L_0x00a4:
        r8 = m1741x();
        if (r8 == 0) goto L_0x00c2;
    L_0x00aa:
        r9 = f1377c;
        r8 = r8.equals(r9);
        if (r8 != 0) goto L_0x00cc;
    L_0x00b2:
        r8 = com.onesignal.sa.C0650i.DEBUG;
        r9 = "APP ID changed, clearing user id as it is no longer valid.";
        m1656a(r8, r9);
        r8 = f1377c;
        m1716i(r8);
        com.onesignal.Ha.m1350i();
        goto L_0x00cc;
    L_0x00c2:
        r8 = f1380f;
        com.onesignal.C0631j.m1522a(r1, r8);
        r8 = f1377c;
        m1716i(r8);
    L_0x00cc:
        r8 = f1380f;
        r8 = m1715i(r8);
        com.onesignal.OSPermissionChangedInternalObserver.m1399b(r8);
        r8 = f1387m;
        if (r8 != 0) goto L_0x00df;
    L_0x00d9:
        r8 = m1616A();
        if (r8 != 0) goto L_0x00ef;
    L_0x00df:
        r8 = m1631P();
        f1362N = r8;
        r8 = java.lang.System.currentTimeMillis();
        m1684c(r8);
        m1639X();
    L_0x00ef:
        r8 = f1356H;
        r8 = r8.f1315a;
        if (r8 == 0) goto L_0x00f8;
    L_0x00f5:
        m1627L();
    L_0x00f8:
        r8 = f1380f;
        r8 = com.onesignal.ab.m1472a(r8);
        if (r8 == 0) goto L_0x0109;
    L_0x0100:
        r8 = new com.onesignal.ab;
        r9 = f1380f;
        r8.<init>(r9);
        f1394t = r8;
    L_0x0109:
        r8 = com.onesignal.Xa.m1429a();
        if (r8 == 0) goto L_0x0118;
    L_0x010f:
        r8 = new com.onesignal.Xa;
        r9 = f1380f;
        r8.<init>(r9);
        f1396v = r8;
    L_0x0118:
        r8 = f1380f;
        com.onesignal.Qa.m2492a(r8);
        f1386l = r10;
        m1638W();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.sa.a(android.content.Context, java.lang.String, java.lang.String, com.onesignal.sa$j, com.onesignal.sa$k):void");
    }

    /* renamed from: a */
    private static void m1651a(Context context, JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                String optString = new JSONObject(jSONArray.getJSONObject(i).optString("custom", null)).optString("i", null);
                if (!f1358J.contains(optString)) {
                    f1358J.add(optString);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("app_id", m1727m(context));
                    jSONObject.put("player_id", m1731o(context));
                    jSONObject.put("opened", true);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("notifications/");
                    stringBuilder.append(optString);
                    Ga.m1332c(stringBuilder.toString(), jSONObject, new ga());
                }
            } catch (Throwable th) {
                m1657a(C0650i.ERROR, "Failed to generate JSON to send notification opened.", th);
            }
        }
    }

    /* renamed from: a */
    public static void m1652a(Context context, JSONArray jSONArray, boolean z) {
        if (!m1705f(null)) {
            m1651a(context, jSONArray);
            if (f1396v != null && m1690c(f1380f)) {
                f1396v.m1431a(m1673b(jSONArray, true, z));
            }
            boolean z2 = false;
            boolean equals = "DISABLE".equals(aa.m1443a(context, "com.onesignal.NotificationOpened.DEFAULT"));
            if (!equals) {
                z2 = m1681b(context, jSONArray);
            }
            m1687c(jSONArray, true, z);
            if (!(z || r0 || equals)) {
                m1708g(context);
            }
        }
    }

    /* renamed from: a */
    private static void m1653a(C0603Q c0603q) {
        aa.m1446a(new fa(c0603q));
    }

    /* renamed from: a */
    public static void m1654a(C0613Y c0613y) {
        if (!m1705f("addSubscriptionObserver()")) {
            if (f1380f == null) {
                m1656a(C0650i.ERROR, "OneSignal.init has not been called. Could not add subscription observer");
                return;
            }
            m1743z().m1412a(c0613y);
            if (m1719j(f1380f).m1404a(m1726l(f1380f))) {
                OSSubscriptionChangedInternalObserver.m1400a(m1719j(f1380f));
            }
        }
    }

    /* renamed from: a */
    static void m1656a(C0650i c0650i, String str) {
        m1657a(c0650i, str, null);
    }

    /* renamed from: a */
    static void m1657a(C0650i c0650i, String str, Throwable th) {
        String str2 = "OneSignal";
        if (c0650i.compareTo(f1382h) < 1) {
            if (c0650i == C0650i.VERBOSE) {
                Log.v(str2, str, th);
            } else if (c0650i == C0650i.DEBUG) {
                Log.d(str2, str, th);
            } else if (c0650i == C0650i.INFO) {
                Log.i(str2, str, th);
            } else if (c0650i == C0650i.WARN) {
                Log.w(str2, str, th);
            } else if (c0650i == C0650i.ERROR || c0650i == C0650i.FATAL) {
                Log.e(str2, str, th);
            }
        }
        if (c0650i.compareTo(f1381g) < 1 && C0624b.f1259b != null) {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("\n");
                str = stringBuilder.toString();
                if (th != null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(th.getMessage());
                    str = stringBuilder.toString();
                    Writer stringWriter = new StringWriter();
                    th.printStackTrace(new PrintWriter(stringWriter));
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str);
                    stringBuilder2.append(stringWriter.toString());
                    str = stringBuilder2.toString();
                }
                aa.m1446a(new pa(c0650i, str));
            } catch (Throwable th2) {
                Log.e(str2, "Error showing logging message.", th2);
            }
        }
    }

    /* renamed from: a */
    public static void m1658a(C0653l c0653l) {
        m1735r().f1321g = true;
        m1735r().f1322h = c0653l;
    }

    /* renamed from: a */
    private static void m1659a(C0654m c0654m) {
        c0654m.f1346b = f1390p.incrementAndGet();
        ExecutorService executorService = f1388n;
        C0650i c0650i;
        StringBuilder stringBuilder;
        if (executorService == null) {
            c0650i = C0650i.INFO;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Adding a task to the pending queue with ID: ");
            stringBuilder.append(c0654m.f1346b);
            m1656a(c0650i, stringBuilder.toString());
            f1389o.add(c0654m);
        } else if (!executorService.isShutdown()) {
            c0650i = C0650i.INFO;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Executor is still running, add to the executor with ID: ");
            stringBuilder.append(c0654m.f1346b);
            m1656a(c0650i, stringBuilder.toString());
            f1388n.submit(c0654m);
        }
    }

    /* renamed from: a */
    public static void m1661a(String str, C0643b c0643b) {
        if (!m1705f("deleteTag()")) {
            Collection arrayList = new ArrayList(1);
            arrayList.add(str);
            m1664a(arrayList, c0643b);
        }
    }

    /* renamed from: a */
    public static void m1662a(String str, String str2) {
        if (!m1705f("sendTag()")) {
            try {
                m1678b(new JSONObject().put(str, str2));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private static void m1663a(String str, JSONObject jSONObject, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("players/");
        stringBuilder.append(str);
        stringBuilder.append("/on_focus");
        str = stringBuilder.toString();
        C0589a qaVar = new qa();
        if (z) {
            Ga.m1330b(str, jSONObject, qaVar);
        } else {
            Ga.m1327a(str, jSONObject, qaVar);
        }
    }

    /* renamed from: a */
    public static void m1664a(Collection<String> collection, C0643b c0643b) {
        if (!m1705f("deleteTags()")) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (String put : collection) {
                    jSONObject.put(put, "");
                }
                m1667a(jSONObject, c0643b);
            } catch (Throwable th) {
                m1657a(C0650i.ERROR, "Failed to generate JSON for deleteTags.", th);
            }
        }
    }

    /* renamed from: a */
    static void m1665a(JSONArray jSONArray, boolean z, C0589a c0589a) {
        String str = "/on_purchase";
        String str2 = "players/";
        if (!m1705f("sendPurchases()")) {
            if (m1616A() == null) {
                aa = new C0648g(jSONArray);
                C0648g c0648g = aa;
                c0648g.f1331b = z;
                c0648g.f1332c = c0589a;
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("app_id", f1377c);
                if (z) {
                    jSONObject.put("existing", true);
                }
                jSONObject.put("purchases", jSONArray);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str2);
                stringBuilder.append(m1616A());
                stringBuilder.append(str);
                Ga.m1327a(stringBuilder.toString(), jSONObject, c0589a);
                if (m1736s() != null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str2);
                    stringBuilder.append(m1736s());
                    stringBuilder.append(str);
                    Ga.m1327a(stringBuilder.toString(), jSONObject, null);
                }
            } catch (Throwable th) {
                m1657a(C0650i.ERROR, "Failed to generate JSON for sendPurchases.", th);
            }
        }
    }

    /* renamed from: a */
    static void m1666a(JSONArray jSONArray, boolean z, boolean z2) {
        C0603Q b = m1673b(jSONArray, z, z2);
        if (f1396v != null && m1690c(f1380f)) {
            f1396v.m1433b(b);
        }
        C0642a c0642a = f1356H;
        if (c0642a != null) {
            C0652k c0652k = c0642a.f1316b;
            if (c0652k != null) {
                c0652k.m1613a(b.f1178a);
            }
        }
    }

    /* renamed from: a */
    public static void m1667a(JSONObject jSONObject, C0643b c0643b) {
        if (!m1705f("sendTags()")) {
            Runnable baVar = new ba(jSONObject, c0643b);
            if (f1380f != null) {
                if (!m1636U()) {
                    baVar.run();
                    return;
                }
            }
            String str = "You must initialize OneSignal before modifying tags!Moving this operation to a pending task queue.";
            m1656a(C0650i.ERROR, str);
            if (c0643b != null) {
                c0643b.m1607a(new C0655n(-1, str));
            }
            m1659a(new C0654m(baVar));
        }
    }

    /* renamed from: a */
    static boolean m1668a(Context context, JSONObject jSONObject) {
        String d = m1692d(jSONObject);
        if (d != null) {
            if (!m1670a(d, context)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m1669a(C0650i c0650i) {
        return c0650i.compareTo(f1381g) >= 1 ? c0650i.compareTo(f1382h) < 1 : true;
    }

    /* renamed from: a */
    private static boolean m1670a(String str, Context context) {
        if (str != null) {
            if (!"".equals(str)) {
                boolean moveToFirst;
                Cursor cursor = null;
                try {
                    cursor = va.m1748a(context).m1750a().query("notification", new String[]{"notification_id"}, "notification_id = ?", new String[]{str}, null, null, null);
                    moveToFirst = cursor.moveToFirst();
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
                if (!moveToFirst) {
                    return false;
                }
                C0650i c0650i = C0650i.DEBUG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Duplicate GCM message received, skip processing of ");
                stringBuilder.append(str);
                m1656a(c0650i, stringBuilder.toString());
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private static C0603Q m1673b(JSONArray jSONArray, boolean z, boolean z2) {
        C0600O c0600o;
        C0599a c0599a;
        String str = "actionSelected";
        int length = jSONArray.length();
        C0603Q c0603q = new C0603Q();
        C0600O c0600o2 = new C0600O();
        c0600o2.f1157a = m1619D();
        c0600o2.f1158b = z;
        c0600o2.f1159c = jSONArray.optJSONObject(0).optInt("notificationId");
        String str2 = null;
        Object obj = 1;
        for (int i = 0; i < length; i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                c0600o2.f1160d = C0585D.m1291a(jSONObject);
                if (str2 == null && jSONObject.has(str)) {
                    str2 = jSONObject.optString(str, null);
                }
                if (obj != null) {
                    obj = null;
                } else {
                    if (c0600o2.f1162f == null) {
                        c0600o2.f1162f = new ArrayList();
                    }
                    c0600o2.f1162f.add(c0600o2.f1160d);
                }
            } catch (Throwable th) {
                C0650i c0650i = C0650i.ERROR;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error parsing JSON item ");
                stringBuilder.append(i);
                stringBuilder.append("/");
                stringBuilder.append(length);
                stringBuilder.append(" for callback.");
                m1657a(c0650i, stringBuilder.toString(), th);
            }
        }
        c0603q.f1178a = c0600o2;
        c0603q.f1179b = new C0602P();
        C0602P c0602p = c0603q.f1179b;
        c0602p.f1174b = str2;
        c0602p.f1173a = str2 != null ? C0601a.ActionTaken : C0601a.Opened;
        if (z2) {
            c0600o = c0603q.f1178a;
            c0599a = C0599a.InAppAlert;
        } else {
            c0600o = c0603q.f1178a;
            c0599a = C0599a.Notification;
        }
        c0600o.f1161e = c0599a;
        return c0603q;
    }

    /* renamed from: b */
    public static void m1676b(C0647f c0647f) {
        if (!m1705f("getTags()")) {
            f1359K = c0647f;
            Runnable caVar = new ca(c0647f);
            if (f1380f == null) {
                m1656a(C0650i.ERROR, "You must initialize OneSignal before getting tags! Moving this tag operation to a pending queue.");
                f1389o.add(caVar);
                return;
            }
            caVar.run();
        }
    }

    /* renamed from: b */
    private static void m1677b(String str, int i, Throwable th, String str2) {
        if (str2 == null || !m1669a(C0650i.INFO)) {
            str2 = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            String str3 = "\n";
            stringBuilder.append(str3);
            stringBuilder.append(str2);
            stringBuilder.append(str3);
            str2 = stringBuilder.toString();
        }
        C0650i c0650i = C0650i.WARN;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("HTTP code: ");
        stringBuilder2.append(i);
        stringBuilder2.append(" ");
        stringBuilder2.append(str);
        stringBuilder2.append(str2);
        m1657a(c0650i, stringBuilder2.toString(), th);
    }

    /* renamed from: b */
    public static void m1678b(JSONObject jSONObject) {
        m1667a(jSONObject, null);
    }

    /* renamed from: b */
    static boolean m1680b(Context context) {
        return za.m1773a(za.f1415a, "OS_FILTER_OTHER_GCM_RECEIVERS", false);
    }

    /* renamed from: b */
    private static boolean m1681b(Context context, JSONArray jSONArray) {
        String str = "u";
        String str2 = "custom";
        int i = 0;
        if (m1705f(null)) {
            return false;
        }
        int length = jSONArray.length();
        boolean z = false;
        while (i < length) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.has(str2)) {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString(str2));
                    if (jSONObject2.has(str)) {
                        String optString = jSONObject2.optString(str, null);
                        if (!optString.contains("://")) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("http://");
                            stringBuilder.append(optString);
                            optString = stringBuilder.toString();
                        }
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(optString.trim()));
                        intent.addFlags(1476919296);
                        context.startActivity(intent);
                        z = true;
                    }
                }
            } catch (Throwable th) {
                C0650i c0650i = C0650i.ERROR;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Error parsing JSON item ");
                stringBuilder2.append(i);
                stringBuilder2.append("/");
                stringBuilder2.append(length);
                stringBuilder2.append(" for launching a web URL.");
                m1657a(c0650i, stringBuilder2.toString(), th);
            }
            i++;
        }
        return z;
    }

    /* renamed from: c */
    static /* synthetic */ int m1683c() {
        int i = ca;
        ca = i + 1;
        return i;
    }

    /* renamed from: c */
    static void m1684c(long j) {
        za.m1776b(za.f1415a, "OS_LAST_SESSION_TIME", j);
    }

    /* renamed from: c */
    private static void m1685c(C0647f c0647f) {
        if (c0647f != null) {
            new Thread(new da(c0647f), "OS_GETTAGS_CALLBACK").start();
        }
    }

    /* renamed from: c */
    public static void m1686c(String str) {
        m1661a(str, null);
    }

    /* renamed from: c */
    private static void m1687c(JSONArray jSONArray, boolean z, boolean z2) {
        C0642a c0642a = f1356H;
        if (c0642a != null) {
            if (c0642a.f1315a != null) {
                m1653a(m1673b(jSONArray, z, z2));
                return;
            }
        }
        f1357I.add(jSONArray);
    }

    /* renamed from: c */
    private static void m1688c(org.json.JSONObject r2) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r0 = "net_type";	 Catch:{ Throwable -> 0x000b }
        r1 = f1400z;	 Catch:{ Throwable -> 0x000b }
        r1 = r1.m1463e();	 Catch:{ Throwable -> 0x000b }
        r2.put(r0, r1);	 Catch:{ Throwable -> 0x000b }
    L_0x000b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.sa.c(org.json.JSONObject):void");
    }

    /* renamed from: c */
    private static boolean m1689c(int i) {
        return i < -6;
    }

    /* renamed from: c */
    static boolean m1690c(Context context) {
        return za.m1773a(za.f1415a, "GT_FIREBASE_TRACKING_ENABLED", false);
    }

    /* renamed from: d */
    private static java.lang.String m1692d(org.json.JSONObject r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r0 = 0;
        r1 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0013 }
        r2 = "custom";	 Catch:{ Throwable -> 0x0013 }
        r3 = r3.optString(r2);	 Catch:{ Throwable -> 0x0013 }
        r1.<init>(r3);	 Catch:{ Throwable -> 0x0013 }
        r3 = "i";	 Catch:{ Throwable -> 0x0013 }
        r3 = r1.optString(r3, r0);	 Catch:{ Throwable -> 0x0013 }
        return r3;
    L_0x0013:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.sa.d(org.json.JSONObject):java.lang.String");
    }

    /* renamed from: d */
    private static void m1694d(long j) {
        f1393s = j;
        if (f1380f != null) {
            C0650i c0650i = C0650i.INFO;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SaveUnsentActiveTime: ");
            stringBuilder.append(f1393s);
            m1656a(c0650i, stringBuilder.toString());
            za.m1776b(za.f1415a, "GT_UNSENT_ACTIVE_TIME", j);
        }
    }

    /* renamed from: d */
    static void m1695d(String str) {
        f1384j = str;
        if (f1380f != null) {
            za.m1777b(za.f1415a, "OS_EMAIL_ID", "".equals(f1384j) ? null : f1384j);
        }
    }

    /* renamed from: d */
    static boolean m1696d(Context context) {
        return za.m1773a(za.f1415a, "GT_SOUND_ENABLED", true);
    }

    /* renamed from: e */
    private static void m1699e(long j) {
        if (f1390p.get() == j) {
            m1656a(C0650i.INFO, "Last Pending Task has ran, shutting down");
            f1388n.shutdown();
        }
    }

    /* renamed from: e */
    static void m1700e(String str) {
        f1383i = str;
        if (f1380f != null) {
            za.m1777b(za.f1415a, "GT_PLAYER_ID", f1383i);
        }
    }

    /* renamed from: e */
    static boolean m1701e(Context context) {
        return za.m1773a(za.f1415a, "GT_VIBRATE_ENABLED", true);
    }

    /* renamed from: f */
    static void m1704f(Context context) {
        f1380f = context.getApplicationContext();
        za.m1775b();
    }

    /* renamed from: f */
    static boolean m1705f(String str) {
        if (!f1366R || m1626K()) {
            return false;
        }
        if (str != null) {
            C0650i c0650i = C0650i.WARN;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Method ");
            stringBuilder.append(str);
            stringBuilder.append(" was called before the user provided privacy consent. Your application is set to require the user's privacy consent before the OneSignal SDK can be initialized. Please ensure the user has provided consent before calling this method. You can check the latest OneSignal consent status by calling OneSignal.userProvidedPrivacyConsent()");
            m1656a(c0650i, stringBuilder.toString());
        }
        return true;
    }

    /* renamed from: g */
    private static void m1708g(Context context) {
        if (!m1705f(null)) {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setFlags(268566528);
                context.startActivity(launchIntentForPackage);
            }
        }
    }

    /* renamed from: g */
    static void m1709g(String str) {
        m1695d(str);
        m1711h(f1380f).m1395a(str);
        try {
            Ha.m1341b(new JSONObject().put("parent_player_id", str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: h */
    private static C0598N m1711h(Context context) {
        if (context == null) {
            return null;
        }
        if (f1374Z == null) {
            f1374Z = new C0598N(false);
            f1374Z.f1150a.m1413b(new C0597M());
        }
        return f1374Z;
    }

    /* renamed from: h */
    static void m1713h(String str) {
        m1700e(str);
        m1734q();
        m1685c(f1359K);
        m1719j(f1380f).m1405b(str);
        C0648g c0648g = aa;
        if (c0648g != null) {
            m1665a(c0648g.f1330a, c0648g.f1331b, c0648g.f1332c);
            aa = null;
        }
        Ha.m1349h();
        ua.m1747a(f1380f, f1377c, str, C0875d.m2259a());
    }

    /* renamed from: h */
    public static void m1714h(boolean z) {
        boolean K = m1626K();
        m1721j(z);
        if (!K && z) {
            C0636o c0636o = f1367S;
            if (c0636o != null) {
                m1650a(c0636o.f1292a, c0636o.f1293b, c0636o.f1294c, c0636o.f1295d, c0636o.f1296e);
                f1367S = null;
            }
        }
    }

    /* renamed from: i */
    private static C0609V m1715i(Context context) {
        if (context == null) {
            return null;
        }
        if (f1368T == null) {
            f1368T = new C0609V(false);
            f1368T.f1215a.m1413b(new OSPermissionChangedInternalObserver());
        }
        return f1368T;
    }

    /* renamed from: i */
    private static void m1716i(String str) {
        if (f1380f != null) {
            za.m1777b(za.f1415a, "GT_APP_ID", str);
        }
    }

    /* renamed from: i */
    static void m1717i(boolean z) {
        if (f1380f != null) {
            za.m1778b(za.f1415a, "OS_FILTER_OTHER_GCM_RECEIVERS", z);
        }
    }

    /* renamed from: j */
    private static OSSubscriptionState m1719j(Context context) {
        if (context == null) {
            return null;
        }
        if (f1371W == null) {
            f1371W = new OSSubscriptionState(false, m1715i(context).m1417a());
            m1715i(context).f1215a.m1412a(f1371W);
            f1371W.f1163a.m1413b(new OSSubscriptionChangedInternalObserver());
        }
        return f1371W;
    }

    /* renamed from: j */
    static void m1721j(boolean z) {
        if (f1380f != null) {
            za.m1778b(za.f1415a, "ONESIGNAL_USER_PROVIDED_CONSENT", z);
        }
    }

    /* renamed from: k */
    private static long m1722k(Context context) {
        return za.m1767a(za.f1415a, "OS_LAST_SESSION_TIME", -31000);
    }

    /* renamed from: k */
    public static void m1724k(boolean z) {
        if (!f1366R || z) {
            f1366R = z;
        } else {
            m1656a(C0650i.ERROR, "Cannot change requiresUserPrivacyConsent() from TRUE to FALSE");
        }
    }

    /* renamed from: l */
    private static OSSubscriptionState m1726l(Context context) {
        if (context == null) {
            return null;
        }
        if (f1372X == null) {
            f1372X = new OSSubscriptionState(true, false);
        }
        return f1372X;
    }

    /* renamed from: m */
    private static String m1727m(Context context) {
        return context == null ? "" : za.m1770a(za.f1415a, "GT_APP_ID", null);
    }

    /* renamed from: m */
    static boolean m1728m() {
        return f1356H.f1319e ? aa.m1447a(f1380f) : true;
    }

    /* renamed from: n */
    public static void m1729n() {
        if (!m1705f("clearOneSignalNotifications()")) {
            Runnable kaVar = new ka();
            if (f1380f != null) {
                if (!m1636U()) {
                    kaVar.run();
                    return;
                }
            }
            m1656a(C0650i.ERROR, "OneSignal.init has not been called. Could not clear notifications at this time - moving this operation toa waiting task queue.");
            m1659a(new C0654m(kaVar));
        }
    }

    /* renamed from: n */
    private static boolean m1730n(Context context) {
        return context == null ? false : za.m1773a(za.f1415a, "ONESIGNAL_USER_PROVIDED_CONSENT", false);
    }

    /* renamed from: o */
    private static String m1731o(Context context) {
        return context == null ? "" : za.m1770a(za.f1415a, "GT_PLAYER_ID", null);
    }

    /* renamed from: o */
    static void m1732o() {
        C0646e c0646e = f1375a;
        if (c0646e != null) {
            c0646e.m1609a(new C0645d(C0644c.NETWORK, "Failed due to network failure. Will retry on next sync."));
            f1375a = null;
        }
    }

    /* renamed from: p */
    static void m1733p() {
        C0646e c0646e = f1375a;
        if (c0646e != null) {
            c0646e.onSuccess();
            f1375a = null;
        }
    }

    /* renamed from: q */
    static void m1734q() {
        if (f1391q != null) {
            aa.m1446a(new ea());
        }
    }

    /* renamed from: r */
    public static C0642a m1735r() {
        if (f1356H == null) {
            f1356H = new C0642a();
        }
        return f1356H;
    }

    /* renamed from: s */
    static String m1736s() {
        if ("".equals(f1384j)) {
            return null;
        }
        if (f1384j == null && f1380f != null) {
            f1384j = za.m1770a(za.f1415a, "OS_EMAIL_ID", null);
        }
        return f1384j;
    }

    /* renamed from: t */
    static boolean m1737t() {
        C0642a c0642a = f1356H;
        boolean z = false;
        if (c0642a == null) {
            return false;
        }
        if (c0642a.f1322h == C0653l.InAppAlert) {
            z = true;
        }
        return z;
    }

    /* renamed from: u */
    static boolean m1738u() {
        C0642a c0642a = f1356H;
        boolean z = true;
        if (c0642a == null) {
            return true;
        }
        if (c0642a.f1322h != C0653l.Notification) {
            z = false;
        }
        return z;
    }

    /* renamed from: v */
    static C0608U<Object, C0610W> m1739v() {
        if (f1370V == null) {
            f1370V = new C0608U("onOSPermissionChanged", true);
        }
        return f1370V;
    }

    /* renamed from: w */
    public static C0612X m1740w() {
        if (m1705f("getPermissionSubscriptionState()")) {
            return null;
        }
        if (f1380f == null) {
            m1656a(C0650i.ERROR, "OneSignal.init has not been called. Could not get OSPermissionSubscriptionState");
            return null;
        }
        C0612X c0612x = new C0612X();
        c0612x.f1227a = m1719j(f1380f);
        c0612x.f1228b = m1715i(f1380f);
        c0612x.f1229c = m1711h(f1380f);
        return c0612x;
    }

    /* renamed from: x */
    static String m1741x() {
        return m1727m(f1380f);
    }

    /* renamed from: y */
    static boolean m1742y() {
        return m1730n(f1380f);
    }

    /* renamed from: z */
    static C0608U<C0613Y, C0614Z> m1743z() {
        if (f1373Y == null) {
            f1373Y = new C0608U("onOSSubscriptionChanged", true);
        }
        return f1373Y;
    }
}
