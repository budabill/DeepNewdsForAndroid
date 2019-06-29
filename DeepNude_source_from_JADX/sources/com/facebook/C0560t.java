package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.internal.C0460F;
import com.facebook.internal.C0470M;
import com.facebook.internal.C0475Q;
import com.facebook.internal.C0476S;
import com.facebook.internal.C0489b;
import com.facebook.p029a.C0422r;
import com.facebook.p029a.p032b.C0386k;
import com.facebook.p029a.p032b.C0386k.C0385a;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.facebook.t */
public final class C0560t {
    /* renamed from: a */
    private static final String f1049a = "com.facebook.t";
    /* renamed from: b */
    private static final HashSet<C0336G> f1050b = new HashSet(Arrays.asList(new C0336G[]{C0336G.DEVELOPER_ERRORS}));
    /* renamed from: c */
    private static Executor f1051c;
    /* renamed from: d */
    private static volatile String f1052d;
    /* renamed from: e */
    private static volatile String f1053e;
    /* renamed from: f */
    private static volatile String f1054f;
    /* renamed from: g */
    private static volatile Boolean f1055g;
    /* renamed from: h */
    private static volatile Boolean f1056h;
    /* renamed from: i */
    private static volatile Boolean f1057i;
    /* renamed from: j */
    private static volatile String f1058j = "facebook.com";
    /* renamed from: k */
    private static AtomicLong f1059k = new AtomicLong(PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
    /* renamed from: l */
    private static volatile boolean f1060l = false;
    /* renamed from: m */
    private static boolean f1061m = false;
    /* renamed from: n */
    private static C0460F<File> f1062n;
    /* renamed from: o */
    private static Context f1063o;
    /* renamed from: p */
    private static int f1064p = 64206;
    /* renamed from: q */
    private static final Object f1065q = new Object();
    /* renamed from: r */
    private static String f1066r = C0470M.m946a();
    /* renamed from: s */
    private static final BlockingQueue<Runnable> f1067s = new LinkedBlockingQueue(10);
    /* renamed from: t */
    private static final ThreadFactory f1068t = new C0541p();
    /* renamed from: u */
    private static Boolean f1069u = Boolean.valueOf(false);

    /* renamed from: com.facebook.t$a */
    public interface C0559a {
        /* renamed from: a */
        void mo973a();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @java.lang.Deprecated
    /* renamed from: a */
    public static synchronized void m1242a(android.content.Context r3, com.facebook.C0560t.C0559a r4) {
        /*
        r0 = com.facebook.C0560t.class;
        monitor-enter(r0);
        r1 = f1069u;	 Catch:{ all -> 0x0081 }
        r1 = r1.booleanValue();	 Catch:{ all -> 0x0081 }
        if (r1 == 0) goto L_0x0012;
    L_0x000b:
        if (r4 == 0) goto L_0x0010;
    L_0x000d:
        r4.mo973a();	 Catch:{ all -> 0x0081 }
    L_0x0010:
        monitor-exit(r0);
        return;
    L_0x0012:
        r1 = "applicationContext";
        com.facebook.internal.C0476S.m1016a(r3, r1);	 Catch:{ all -> 0x0081 }
        r1 = 0;
        com.facebook.internal.C0476S.m1015a(r3, r1);	 Catch:{ all -> 0x0081 }
        com.facebook.internal.C0476S.m1021b(r3, r1);	 Catch:{ all -> 0x0081 }
        r1 = r3.getApplicationContext();	 Catch:{ all -> 0x0081 }
        f1063o = r1;	 Catch:{ all -> 0x0081 }
        r1 = f1063o;	 Catch:{ all -> 0x0081 }
        com.facebook.C0560t.m1248b(r1);	 Catch:{ all -> 0x0081 }
        r1 = f1052d;	 Catch:{ all -> 0x0081 }
        r1 = com.facebook.internal.C0475Q.m998b(r1);	 Catch:{ all -> 0x0081 }
        if (r1 != 0) goto L_0x0079;
    L_0x0031:
        r1 = f1063o;	 Catch:{ all -> 0x0081 }
        r1 = r1 instanceof android.app.Application;	 Catch:{ all -> 0x0081 }
        if (r1 == 0) goto L_0x0048;
    L_0x0037:
        r1 = f1055g;	 Catch:{ all -> 0x0081 }
        r1 = r1.booleanValue();	 Catch:{ all -> 0x0081 }
        if (r1 == 0) goto L_0x0048;
    L_0x003f:
        r1 = f1063o;	 Catch:{ all -> 0x0081 }
        r1 = (android.app.Application) r1;	 Catch:{ all -> 0x0081 }
        r2 = f1052d;	 Catch:{ all -> 0x0081 }
        com.facebook.p029a.p032b.C0382h.m666a(r1, r2);	 Catch:{ all -> 0x0081 }
    L_0x0048:
        r1 = 1;
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ all -> 0x0081 }
        f1069u = r1;	 Catch:{ all -> 0x0081 }
        com.facebook.internal.C0457C.m883f();	 Catch:{ all -> 0x0081 }
        com.facebook.internal.C0465I.m932d();	 Catch:{ all -> 0x0081 }
        r1 = f1063o;	 Catch:{ all -> 0x0081 }
        com.facebook.internal.C0490c.m1076a(r1);	 Catch:{ all -> 0x0081 }
        r1 = new com.facebook.internal.F;	 Catch:{ all -> 0x0081 }
        r2 = new com.facebook.q;	 Catch:{ all -> 0x0081 }
        r2.<init>();	 Catch:{ all -> 0x0081 }
        r1.<init>(r2);	 Catch:{ all -> 0x0081 }
        f1062n = r1;	 Catch:{ all -> 0x0081 }
        r1 = new java.util.concurrent.FutureTask;	 Catch:{ all -> 0x0081 }
        r2 = new com.facebook.r;	 Catch:{ all -> 0x0081 }
        r2.<init>(r4, r3);	 Catch:{ all -> 0x0081 }
        r1.<init>(r2);	 Catch:{ all -> 0x0081 }
        r3 = com.facebook.C0560t.m1258j();	 Catch:{ all -> 0x0081 }
        r3.execute(r1);	 Catch:{ all -> 0x0081 }
        monitor-exit(r0);
        return;
    L_0x0079:
        r3 = new com.facebook.l;	 Catch:{ all -> 0x0081 }
        r4 = "A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.";
        r3.<init>(r4);	 Catch:{ all -> 0x0081 }
        throw r3;	 Catch:{ all -> 0x0081 }
    L_0x0081:
        r3 = move-exception;
        monitor-exit(r0);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.t.a(android.content.Context, com.facebook.t$a):void");
    }

    /* renamed from: a */
    static void m1243a(Context context, String str) {
        if (context == null || str == null) {
            throw new IllegalArgumentException("Both context and applicationId must be non-null");
        }
        try {
            C0489b a = C0489b.m1065a(context);
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.attributionTracking", 0);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("ping");
            String stringBuilder2 = stringBuilder.toString();
            long j = sharedPreferences.getLong(stringBuilder2, 0);
            GraphRequest a2 = GraphRequest.m513a(null, String.format("%s/activities", new Object[]{str}), C0386k.m693a(C0385a.MOBILE_INSTALL_EVENT, a, C0422r.m787a(context), C0560t.m1245a(context), context), null);
            if (j == 0) {
                a2.m555b();
                Editor edit = sharedPreferences.edit();
                edit.putLong(stringBuilder2, System.currentTimeMillis());
                edit.apply();
            }
        } catch (Throwable e) {
            throw new C0506l("An error occurred while publishing install.", e);
        } catch (Exception e2) {
            C0475Q.m983a("Facebook-publish", e2);
        }
    }

    /* renamed from: a */
    public static void m1244a(String str) {
        f1052d = str;
    }

    /* renamed from: a */
    public static boolean m1245a(Context context) {
        C0476S.m1023c();
        return context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("limitEventUsage", false);
    }

    /* renamed from: a */
    public static boolean m1246a(C0336G c0336g) {
        boolean z;
        synchronized (f1050b) {
            z = C0560t.m1263o() && f1050b.contains(c0336g);
        }
        return z;
    }

    /* renamed from: b */
    static void m1248b(android.content.Context r4) {
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
        if (r4 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = r4.getPackageManager();	 Catch:{ NameNotFoundException -> 0x00b3 }
        r4 = r4.getPackageName();	 Catch:{ NameNotFoundException -> 0x00b3 }
        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ NameNotFoundException -> 0x00b3 }
        r4 = r0.getApplicationInfo(r4, r1);	 Catch:{ NameNotFoundException -> 0x00b3 }
        if (r4 == 0) goto L_0x00b3;
    L_0x0013:
        r0 = r4.metaData;
        if (r0 != 0) goto L_0x0019;
    L_0x0017:
        goto L_0x00b3;
    L_0x0019:
        r0 = f1052d;
        if (r0 != 0) goto L_0x004e;
    L_0x001d:
        r0 = r4.metaData;
        r1 = "com.facebook.sdk.ApplicationId";
        r0 = r0.get(r1);
        r1 = r0 instanceof java.lang.String;
        if (r1 == 0) goto L_0x0041;
    L_0x0029:
        r0 = (java.lang.String) r0;
        r1 = java.util.Locale.ROOT;
        r1 = r0.toLowerCase(r1);
        r2 = "fb";
        r1 = r1.startsWith(r2);
        if (r1 == 0) goto L_0x003e;
    L_0x0039:
        r1 = 2;
        r0 = r0.substring(r1);
    L_0x003e:
        f1052d = r0;
        goto L_0x004e;
    L_0x0041:
        r0 = r0 instanceof java.lang.Integer;
        if (r0 != 0) goto L_0x0046;
    L_0x0045:
        goto L_0x004e;
    L_0x0046:
        r4 = new com.facebook.l;
        r0 = "App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.";
        r4.<init>(r0);
        throw r4;
    L_0x004e:
        r0 = f1053e;
        if (r0 != 0) goto L_0x005c;
    L_0x0052:
        r0 = r4.metaData;
        r1 = "com.facebook.sdk.ApplicationName";
        r0 = r0.getString(r1);
        f1053e = r0;
    L_0x005c:
        r0 = f1054f;
        if (r0 != 0) goto L_0x006a;
    L_0x0060:
        r0 = r4.metaData;
        r1 = "com.facebook.sdk.ClientToken";
        r0 = r0.getString(r1);
        f1054f = r0;
    L_0x006a:
        r0 = f1064p;
        r1 = 64206; // 0xface float:8.9972E-41 double:3.1722E-319;
        if (r0 != r1) goto L_0x007b;
    L_0x0071:
        r0 = r4.metaData;
        r2 = "com.facebook.sdk.CallbackOffset";
        r0 = r0.getInt(r2, r1);
        f1064p = r0;
    L_0x007b:
        r0 = f1055g;
        r1 = 1;
        if (r0 != 0) goto L_0x008e;
    L_0x0080:
        r0 = r4.metaData;
        r2 = "com.facebook.sdk.AutoLogAppEventsEnabled";
        r0 = r0.getBoolean(r2, r1);
        r0 = java.lang.Boolean.valueOf(r0);
        f1055g = r0;
    L_0x008e:
        r0 = f1056h;
        if (r0 != 0) goto L_0x00a1;
    L_0x0092:
        r0 = r4.metaData;
        r2 = 0;
        r3 = "com.facebook.sdk.CodelessDebugLogEnabled";
        r0 = r0.getBoolean(r3, r2);
        r0 = java.lang.Boolean.valueOf(r0);
        f1056h = r0;
    L_0x00a1:
        r0 = f1057i;
        if (r0 != 0) goto L_0x00b3;
    L_0x00a5:
        r4 = r4.metaData;
        r0 = "com.facebook.sdk.AdvertiserIDCollectionEnabled";
        r4 = r4.getBoolean(r0, r1);
        r4 = java.lang.Boolean.valueOf(r4);
        f1057i = r4;
    L_0x00b3:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.t.b(android.content.Context):void");
    }

    /* renamed from: b */
    public static void m1249b(Context context, String str) {
        C0560t.m1258j().execute(new C0544s(context.getApplicationContext(), str));
    }

    @Deprecated
    /* renamed from: c */
    public static synchronized void m1250c(Context context) {
        synchronized (C0560t.class) {
            C0560t.m1242a(context, null);
        }
    }

    /* renamed from: c */
    public static boolean m1251c() {
        C0476S.m1023c();
        return f1057i.booleanValue();
    }

    /* renamed from: d */
    public static Context m1252d() {
        C0476S.m1023c();
        return f1063o;
    }

    /* renamed from: e */
    public static String m1253e() {
        C0476S.m1023c();
        return f1052d;
    }

    /* renamed from: f */
    public static boolean m1254f() {
        C0476S.m1023c();
        return f1055g.booleanValue();
    }

    /* renamed from: g */
    public static int m1255g() {
        C0476S.m1023c();
        return f1064p;
    }

    /* renamed from: h */
    public static String m1256h() {
        C0476S.m1023c();
        return f1054f;
    }

    /* renamed from: i */
    public static boolean m1257i() {
        C0476S.m1023c();
        return f1056h.booleanValue();
    }

    /* renamed from: j */
    public static Executor m1258j() {
        synchronized (f1065q) {
            if (f1051c == null) {
                f1051c = AsyncTask.THREAD_POOL_EXECUTOR;
            }
        }
        return f1051c;
    }

    /* renamed from: k */
    public static String m1259k() {
        return f1058j;
    }

    /* renamed from: l */
    public static String m1260l() {
        C0475Q.m984a(f1049a, String.format("getGraphApiVersion: %s", new Object[]{f1066r}));
        return f1066r;
    }

    /* renamed from: m */
    public static long m1261m() {
        C0476S.m1023c();
        return f1059k.get();
    }

    /* renamed from: n */
    public static String m1262n() {
        return "4.39.0";
    }

    /* renamed from: o */
    public static boolean m1263o() {
        return f1060l;
    }

    /* renamed from: p */
    public static synchronized boolean m1264p() {
        boolean booleanValue;
        synchronized (C0560t.class) {
            booleanValue = f1069u.booleanValue();
        }
        return booleanValue;
    }

    /* renamed from: q */
    public static boolean m1265q() {
        return f1061m;
    }
}
