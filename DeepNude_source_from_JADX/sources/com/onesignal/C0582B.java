package com.onesignal;

import android.content.Context;
import android.location.Location;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.onesignal.sa.C0650i;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.onesignal.B */
class C0582B {
    /* renamed from: a */
    private static C0657t f1086a;
    /* renamed from: b */
    private static Location f1087b;
    /* renamed from: c */
    static String f1088c;
    /* renamed from: d */
    private static Context f1089d;
    /* renamed from: e */
    private static C0580e f1090e;
    /* renamed from: f */
    protected static final Object f1091f = new C0663z();
    /* renamed from: g */
    private static ConcurrentHashMap<C0577a, C0579d> f1092g = new ConcurrentHashMap();
    /* renamed from: h */
    private static Thread f1093h;
    /* renamed from: i */
    private static boolean f1094i;
    /* renamed from: j */
    static C0871g f1095j;

    /* renamed from: com.onesignal.B$a */
    enum C0577a {
        STARTUP,
        PROMPT_LOCATION,
        SYNC_SERVICE
    }

    /* renamed from: com.onesignal.B$b */
    static class C0578b {
        /* renamed from: a */
        static Location m1267a(GoogleApiClient googleApiClient) {
            synchronized (C0582B.f1091f) {
                if (googleApiClient.isConnected()) {
                    Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
                    return lastLocation;
                }
                return null;
            }
        }

        /* renamed from: a */
        static void m1268a(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener) {
            try {
                synchronized (C0582B.f1091f) {
                    if (googleApiClient.isConnected()) {
                        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, locationListener);
                    }
                }
            } catch (Throwable th) {
                sa.m1657a(C0650i.WARN, "FusedLocationApi.requestLocationUpdates failed!", th);
            }
        }
    }

    /* renamed from: com.onesignal.B$d */
    interface C0579d {
        /* renamed from: a */
        void mo1352a(C0581f c0581f);

        C0577a getType();
    }

    /* renamed from: com.onesignal.B$e */
    private static class C0580e extends HandlerThread {
        /* renamed from: a */
        Handler f1079a = new Handler(getLooper());

        C0580e() {
            super("OSH_LocationHandlerThread");
            start();
        }
    }

    /* renamed from: com.onesignal.B$f */
    static class C0581f {
        /* renamed from: a */
        Double f1080a;
        /* renamed from: b */
        Double f1081b;
        /* renamed from: c */
        Float f1082c;
        /* renamed from: d */
        Integer f1083d;
        /* renamed from: e */
        Boolean f1084e;
        /* renamed from: f */
        Long f1085f;

        C0581f() {
        }
    }

    /* renamed from: com.onesignal.B$c */
    private static class C0870c implements ConnectionCallbacks, OnConnectionFailedListener {
        private C0870c() {
        }

        public void onConnected(Bundle bundle) {
            synchronized (C0582B.f1091f) {
                PermissionsActivity.f1176b = false;
                if (C0582B.f1087b == null) {
                    C0582B.f1087b = C0578b.m1267a(C0582B.f1086a.m1746c());
                    if (C0582B.f1087b != null) {
                        C0582B.m1280c(C0582B.f1087b);
                    }
                }
                C0582B.f1095j = new C0871g(C0582B.f1086a.m1746c());
            }
        }

        public void onConnectionFailed(ConnectionResult connectionResult) {
            C0582B.m1282e();
        }

        public void onConnectionSuspended(int i) {
            C0582B.m1282e();
        }
    }

    /* renamed from: com.onesignal.B$g */
    static class C0871g implements LocationListener {
        /* renamed from: a */
        private GoogleApiClient f1821a;

        C0871g(GoogleApiClient googleApiClient) {
            this.f1821a = googleApiClient;
            long j = sa.m1620E() ? 270000 : 570000;
            LocationRequest interval = LocationRequest.create().setFastestInterval(j).setInterval(j);
            double d = (double) j;
            Double.isNaN(d);
            C0578b.m1268a(this.f1821a, interval.setMaxWaitTime((long) (d * 1.5d)).setPriority(102), this);
        }

        public void onLocationChanged(Location location) {
            C0582B.f1087b = location;
            sa.m1656a(C0650i.INFO, "Location Change Detected");
        }
    }

    C0582B() {
    }

    /* renamed from: a */
    private static void m1272a(long j) {
        za.m1776b(za.f1415a, "OS_LAST_LOCATION_TIME", j);
    }

    /* renamed from: a */
    static void m1273a(Context context, boolean z, C0579d c0579d) {
        f1089d = context;
        f1092g.put(c0579d.getType(), c0579d);
        if (sa.f1355G) {
            String str = "android.permission.ACCESS_FINE_LOCATION";
            int a = C0629h.m1521a(context, str);
            int i = -1;
            String str2 = "android.permission.ACCESS_COARSE_LOCATION";
            if (a == -1) {
                i = C0629h.m1521a(context, str2);
                f1094i = true;
            }
            if (VERSION.SDK_INT < 23) {
                if (!(a == 0 || i == 0)) {
                    c0579d.mo1352a(null);
                    return;
                }
            } else if (a != 0) {
                try {
                    List asList = Arrays.asList(context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions);
                    if (asList.contains(str)) {
                        f1088c = str;
                    } else if (asList.contains(str2) && i != 0) {
                        f1088c = str2;
                    }
                    if (f1088c == null || !z) {
                        if (i == 0) {
                            C0582B.m1284g();
                        } else {
                            C0582B.m1282e();
                        }
                        return;
                    }
                    PermissionsActivity.m1410a();
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            C0582B.m1284g();
            return;
        }
        C0582B.m1282e();
    }

    /* renamed from: a */
    private static void m1274a(C0581f c0581f) {
        HashMap hashMap = new HashMap();
        synchronized (C0582B.class) {
            hashMap.putAll(f1092g);
            f1092g.clear();
            Thread thread = f1093h;
        }
        for (C0577a c0577a : hashMap.keySet()) {
            ((C0579d) hashMap.get(c0577a)).mo1352a(c0581f);
        }
        if (!(thread == null || Thread.currentThread().equals(thread))) {
            thread.interrupt();
        }
        if (thread == f1093h) {
            synchronized (C0582B.class) {
                if (thread == f1093h) {
                    f1093h = null;
                }
            }
        }
        C0582B.m1272a(System.currentTimeMillis());
    }

    /* renamed from: a */
    static boolean m1275a(Context context) {
        if (C0582B.m1278b(context)) {
            if (sa.f1355G) {
                long currentTimeMillis = System.currentTimeMillis() - C0582B.m1286i();
                long j = sa.m1620E() ? 300 : 600;
                Long.signum(j);
                Ia.m1364a(context, (j * 1000) - currentTimeMillis);
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private static boolean m1278b(Context context) {
        if (C0629h.m1521a(context, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            if (C0629h.m1521a(context, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    private static void m1280c(Location location) {
        double doubleValue;
        C0581f c0581f = new C0581f();
        c0581f.f1082c = Float.valueOf(location.getAccuracy());
        c0581f.f1084e = Boolean.valueOf(sa.m1620E() ^ 1);
        c0581f.f1083d = Integer.valueOf(f1094i ^ 1);
        c0581f.f1085f = Long.valueOf(location.getTime());
        if (f1094i) {
            c0581f.f1080a = Double.valueOf(new BigDecimal(location.getLatitude()).setScale(7, RoundingMode.HALF_UP).doubleValue());
            doubleValue = new BigDecimal(location.getLongitude()).setScale(7, RoundingMode.HALF_UP).doubleValue();
        } else {
            c0581f.f1080a = Double.valueOf(location.getLatitude());
            doubleValue = location.getLongitude();
        }
        c0581f.f1081b = Double.valueOf(doubleValue);
        C0582B.m1274a(c0581f);
        C0582B.m1275a(f1089d);
    }

    /* renamed from: e */
    static void m1282e() {
        PermissionsActivity.f1176b = false;
        synchronized (f1091f) {
            if (f1086a != null) {
                f1086a.m1745b();
            }
            f1086a = null;
        }
        C0582B.m1274a(null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: f */
    static void m1283f() {
        /*
        r0 = f1091f;
        monitor-enter(r0);
        r1 = f1086a;	 Catch:{ all -> 0x0030 }
        if (r1 == 0) goto L_0x002e;
    L_0x0007:
        r1 = f1086a;	 Catch:{ all -> 0x0030 }
        r1 = r1.m1746c();	 Catch:{ all -> 0x0030 }
        r1 = r1.isConnected();	 Catch:{ all -> 0x0030 }
        if (r1 != 0) goto L_0x0014;
    L_0x0013:
        goto L_0x002e;
    L_0x0014:
        r1 = f1086a;	 Catch:{ all -> 0x0030 }
        r1 = r1.m1746c();	 Catch:{ all -> 0x0030 }
        r2 = f1095j;	 Catch:{ all -> 0x0030 }
        if (r2 == 0) goto L_0x0025;
    L_0x001e:
        r2 = com.google.android.gms.location.LocationServices.FusedLocationApi;	 Catch:{ all -> 0x0030 }
        r3 = f1095j;	 Catch:{ all -> 0x0030 }
        r2.removeLocationUpdates(r1, r3);	 Catch:{ all -> 0x0030 }
    L_0x0025:
        r2 = new com.onesignal.B$g;	 Catch:{ all -> 0x0030 }
        r2.<init>(r1);	 Catch:{ all -> 0x0030 }
        f1095j = r2;	 Catch:{ all -> 0x0030 }
        monitor-exit(r0);	 Catch:{ all -> 0x0030 }
        return;
    L_0x002e:
        monitor-exit(r0);	 Catch:{ all -> 0x0030 }
        return;
    L_0x0030:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0030 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.B.f():void");
    }

    /* renamed from: g */
    static void m1284g() {
        if (f1093h == null) {
            try {
                synchronized (f1091f) {
                    C0582B.m1287j();
                    if (f1090e == null) {
                        f1090e = new C0580e();
                    }
                    if (f1086a != null) {
                        if (f1087b != null) {
                            if (f1087b != null) {
                                C0582B.m1280c(f1087b);
                            }
                        }
                    }
                    Object c0870c = new C0870c();
                    f1086a = new C0657t(new Builder(f1089d).addApi(LocationServices.API).addConnectionCallbacks(c0870c).addOnConnectionFailedListener(c0870c).setHandler(f1090e.f1079a).build());
                    f1086a.m1744a();
                }
            } catch (Throwable th) {
                sa.m1657a(C0650i.WARN, "Location permission exists but there was an error initializing: ", th);
                C0582B.m1282e();
            }
        }
    }

    /* renamed from: h */
    private static int m1285h() {
        return 30000;
    }

    /* renamed from: i */
    private static long m1286i() {
        return za.m1767a(za.f1415a, "OS_LAST_LOCATION_TIME", -600000);
    }

    /* renamed from: j */
    private static void m1287j() {
        f1093h = new Thread(new C0576A(), "OS_GMS_LOCATION_FALLBACK");
        f1093h.start();
    }
}
