package com.facebook.p029a;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.facebook.C0336G;
import com.facebook.C0560t;
import com.facebook.GraphRequest;
import com.facebook.internal.C0457C;
import com.facebook.internal.C0461G;
import com.facebook.internal.C0503y;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

/* renamed from: com.facebook.a.n */
class C0416n {
    /* renamed from: a */
    private static final String f699a = "com.facebook.a.n";
    /* renamed from: b */
    private static volatile C0410g f700b = new C0410g();
    /* renamed from: c */
    private static final ScheduledExecutorService f701c = Executors.newSingleThreadScheduledExecutor();
    /* renamed from: d */
    private static ScheduledFuture f702d;
    /* renamed from: e */
    private static final Runnable f703e = new C0411h();

    /* renamed from: a */
    private static GraphRequest m768a(C0403b c0403b, C0429x c0429x, boolean z, C0425u c0425u) {
        boolean z2 = false;
        C0503y a = C0457C.m871a(c0403b.m749b(), false);
        GraphRequest a2 = GraphRequest.m513a(null, String.format("%s/activities", new Object[]{r0}), null, null);
        Bundle i = a2.m563i();
        if (i == null) {
            i = new Bundle();
        }
        i.putString("access_token", c0403b.m748a());
        String e = C0422r.m799e();
        if (e != null) {
            i.putString("device_token", e);
        }
        a2.m550a(i);
        if (a != null) {
            z2 = a.m1108k();
        }
        int a3 = c0429x.m817a(a2, C0560t.m1252d(), z2, z);
        if (a3 == 0) {
            return null;
        }
        c0425u.f730a += a3;
        a2.m552a(new C0825l(c0403b, a2, c0429x, c0425u));
        return a2;
    }

    /* renamed from: a */
    private static C0425u m770a(C0423s c0423s, C0410g c0410g) {
        C0425u c0425u = new C0425u();
        boolean a = C0560t.m1245a(C0560t.m1252d());
        List<GraphRequest> arrayList = new ArrayList();
        for (C0403b c0403b : c0410g.m767b()) {
            GraphRequest a2 = C0416n.m768a(c0403b, c0410g.m764a(c0403b), a, c0425u);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        C0461G.m892a(C0336G.APP_EVENTS, f699a, "Flushing %d events due to %s.", Integer.valueOf(c0425u.f730a), c0423s.toString());
        for (GraphRequest b : arrayList) {
            b.m555b();
        }
        return c0425u;
    }

    /* renamed from: a */
    public static void m774a(C0403b c0403b, C0409f c0409f) {
        f701c.execute(new C0414k(c0403b, c0409f));
    }

    /* renamed from: a */
    public static void m775a(C0423s c0423s) {
        f701c.execute(new C0413j(c0423s));
    }

    /* renamed from: b */
    private static void m777b(com.facebook.p029a.C0403b r9, com.facebook.GraphRequest r10, com.facebook.C0331D r11, com.facebook.p029a.C0429x r12, com.facebook.p029a.C0425u r13) {
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
        r0 = r11.m486a();
        r1 = com.facebook.p029a.C0424t.f725a;
        r2 = 1;
        r3 = 0;
        r4 = 2;
        if (r0 == 0) goto L_0x002e;
    L_0x000b:
        r1 = r0.m499b();
        r5 = -1;
        if (r1 != r5) goto L_0x0017;
    L_0x0012:
        r1 = com.facebook.p029a.C0424t.f727c;
        r11 = "Failed: No Connectivity";
        goto L_0x0030;
    L_0x0017:
        r1 = new java.lang.Object[r4];
        r11 = r11.toString();
        r1[r3] = r11;
        r11 = r0.toString();
        r1[r2] = r11;
        r11 = "Failed:\n  Response: %s\n  Error %s";
        r11 = java.lang.String.format(r11, r1);
        r1 = com.facebook.p029a.C0424t.f726b;
        goto L_0x0030;
    L_0x002e:
        r11 = "Success";
    L_0x0030:
        r5 = com.facebook.C0336G.APP_EVENTS;
        r5 = com.facebook.C0560t.m1246a(r5);
        if (r5 == 0) goto L_0x0064;
    L_0x0038:
        r5 = r10.m565k();
        r5 = (java.lang.String) r5;
        r6 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x0048 }
        r6.<init>(r5);	 Catch:{ JSONException -> 0x0048 }
        r5 = r6.toString(r4);	 Catch:{ JSONException -> 0x0048 }
        goto L_0x004a;
    L_0x0048:
        r5 = "<Can't encode events for debug logging>";
    L_0x004a:
        r6 = com.facebook.C0336G.APP_EVENTS;
        r7 = f699a;
        r8 = 3;
        r8 = new java.lang.Object[r8];
        r10 = r10.m560f();
        r10 = r10.toString();
        r8[r3] = r10;
        r8[r2] = r11;
        r8[r4] = r5;
        r10 = "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s";
        com.facebook.internal.C0461G.m892a(r6, r7, r10, r8);
    L_0x0064:
        if (r0 == 0) goto L_0x0067;
    L_0x0066:
        goto L_0x0068;
    L_0x0067:
        r2 = 0;
    L_0x0068:
        r12.m819a(r2);
        r10 = com.facebook.p029a.C0424t.f727c;
        if (r1 != r10) goto L_0x007b;
    L_0x006f:
        r10 = com.facebook.C0560t.m1258j();
        r11 = new com.facebook.a.m;
        r11.<init>(r9, r12);
        r10.execute(r11);
    L_0x007b:
        r9 = com.facebook.p029a.C0424t.f725a;
        if (r1 == r9) goto L_0x0087;
    L_0x007f:
        r9 = r13.f731b;
        r10 = com.facebook.p029a.C0424t.f727c;
        if (r9 == r10) goto L_0x0087;
    L_0x0085:
        r13.f731b = r1;
    L_0x0087:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.a.n.b(com.facebook.a.b, com.facebook.GraphRequest, com.facebook.D, com.facebook.a.x, com.facebook.a.u):void");
    }

    /* renamed from: b */
    static void m778b(C0423s c0423s) {
        f700b.m766a(C0418o.m783a());
        try {
            C0425u a = C0416n.m770a(c0423s, f700b);
            if (a != null) {
                Intent intent = new Intent("com.facebook.sdk.APP_EVENTS_FLUSHED");
                intent.putExtra("com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED", a.f730a);
                intent.putExtra("com.facebook.sdk.APP_EVENTS_FLUSH_RESULT", a.f731b);
                LocalBroadcastManager.getInstance(C0560t.m1252d()).sendBroadcast(intent);
            }
        } catch (Throwable e) {
            Log.w(f699a, "Caught unexpected exception while flushing app events: ", e);
        }
    }

    /* renamed from: e */
    public static Set<C0403b> m781e() {
        return f700b.m767b();
    }

    /* renamed from: f */
    public static void m782f() {
        f701c.execute(new C0412i());
    }
}
