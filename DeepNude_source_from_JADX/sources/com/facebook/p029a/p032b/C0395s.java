package com.facebook.p029a.p032b;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.facebook.C0560t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.facebook.a.b.s */
public class C0395s {
    /* renamed from: a */
    private static final String f644a = "com.facebook.a.b.s";
    /* renamed from: b */
    private static final AtomicBoolean f645b = new AtomicBoolean(false);
    /* renamed from: c */
    private static Boolean f646c = null;
    /* renamed from: d */
    private static Boolean f647d = null;
    /* renamed from: e */
    private static ServiceConnection f648e;
    /* renamed from: f */
    private static ActivityLifecycleCallbacks f649f;
    /* renamed from: g */
    private static Intent f650g;
    /* renamed from: h */
    private static Object f651h;

    /* renamed from: b */
    private static void m706b(Context context, ArrayList<String> arrayList) {
        if (!arrayList.isEmpty()) {
            Map hashMap = new HashMap();
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                try {
                    String string = new JSONObject(str).getString("productId");
                    hashMap.put(string, str);
                    arrayList2.add(string);
                } catch (Throwable e) {
                    Log.e(f644a, "Error parsing in-app purchase data.", e);
                }
            }
            for (Entry entry : C0396t.m719a(context, arrayList2, f651h, false).entrySet()) {
                C0389m.m696a((String) hashMap.get(entry.getKey()), (String) entry.getValue());
            }
        }
    }

    /* renamed from: b */
    private static void m707b(Context context, Map<String, C0402z> map) {
        if (!map.isEmpty()) {
            String str;
            Map hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (String str2 : map.keySet()) {
                try {
                    String string = new JSONObject(str2).getString("productId");
                    arrayList.add(string);
                    hashMap.put(string, str2);
                } catch (Throwable e) {
                    Log.e(f644a, "Error parsing in-app purchase data.", e);
                }
            }
            Map a = C0396t.m719a(context, arrayList, f651h, true);
            for (String str3 : a.keySet()) {
                str2 = (String) hashMap.get(str3);
                C0389m.m694a((C0402z) map.get(str2), str2, (String) a.get(str3));
            }
        }
    }

    /* renamed from: c */
    public static void m708c() {
        C0395s.m709d();
        if (f646c.booleanValue() && C0389m.m697a()) {
            C0395s.m710e();
        }
    }

    /* renamed from: d */
    private static void m709d() {
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
        r0 = f646c;
        if (r0 == 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = "com.android.vending.billing.IInAppBillingService$Stub";
        r1 = 0;
        java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0045 }
        r0 = 1;	 Catch:{ ClassNotFoundException -> 0x0045 }
        r2 = java.lang.Boolean.valueOf(r0);	 Catch:{ ClassNotFoundException -> 0x0045 }
        f646c = r2;	 Catch:{ ClassNotFoundException -> 0x0045 }
        r2 = "com.android.billingclient.api.ProxyBillingActivity";
        java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x001e }
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ ClassNotFoundException -> 0x001e }
        f647d = r0;	 Catch:{ ClassNotFoundException -> 0x001e }
        goto L_0x0024;
    L_0x001e:
        r0 = java.lang.Boolean.valueOf(r1);
        f647d = r0;
    L_0x0024:
        com.facebook.p029a.p032b.C0396t.m720a();
        r0 = new android.content.Intent;
        r1 = "com.android.vending.billing.InAppBillingService.BIND";
        r0.<init>(r1);
        r1 = "com.android.vending";
        r0 = r0.setPackage(r1);
        f650g = r0;
        r0 = new com.facebook.a.b.o;
        r0.<init>();
        f648e = r0;
        r0 = new com.facebook.a.b.r;
        r0.<init>();
        f649f = r0;
        return;
    L_0x0045:
        r0 = java.lang.Boolean.valueOf(r1);
        f646c = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.a.b.s.d():void");
    }

    /* renamed from: e */
    private static void m710e() {
        if (f645b.compareAndSet(false, true)) {
            Context d = C0560t.m1252d();
            if (d instanceof Application) {
                ((Application) d).registerActivityLifecycleCallbacks(f649f);
                d.bindService(f650g, f648e, 1);
            }
        }
    }
}
