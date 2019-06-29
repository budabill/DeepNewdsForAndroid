package com.facebook.p029a;

import android.content.Context;
import com.facebook.GraphRequest;
import com.facebook.internal.C0475Q;
import com.facebook.internal.C0489b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* renamed from: com.facebook.a.x */
class C0429x {
    /* renamed from: a */
    private List<C0409f> f734a = new ArrayList();
    /* renamed from: b */
    private List<C0409f> f735b = new ArrayList();
    /* renamed from: c */
    private int f736c;
    /* renamed from: d */
    private C0489b f737d;
    /* renamed from: e */
    private String f738e;
    /* renamed from: f */
    private final int f739f = 1000;

    public C0429x(C0489b c0489b, String str) {
        this.f737d = c0489b;
        this.f738e = str;
    }

    /* renamed from: a */
    private void m815a(com.facebook.GraphRequest r4, android.content.Context r5, int r6, org.json.JSONArray r7, boolean r8) {
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
        r3 = this;
        r0 = com.facebook.p029a.p032b.C0386k.C0385a.CUSTOM_APP_EVENTS;	 Catch:{ JSONException -> 0x0014 }
        r1 = r3.f737d;	 Catch:{ JSONException -> 0x0014 }
        r2 = r3.f738e;	 Catch:{ JSONException -> 0x0014 }
        r5 = com.facebook.p029a.p032b.C0386k.m693a(r0, r1, r2, r8, r5);	 Catch:{ JSONException -> 0x0014 }
        r8 = r3.f736c;	 Catch:{ JSONException -> 0x0014 }
        if (r8 <= 0) goto L_0x0019;	 Catch:{ JSONException -> 0x0014 }
    L_0x000e:
        r8 = "num_skipped_events";	 Catch:{ JSONException -> 0x0014 }
        r5.put(r8, r6);	 Catch:{ JSONException -> 0x0014 }
        goto L_0x0019;
    L_0x0014:
        r5 = new org.json.JSONObject;
        r5.<init>();
    L_0x0019:
        r4.m553a(r5);
        r5 = r4.m563i();
        if (r5 != 0) goto L_0x0027;
    L_0x0022:
        r5 = new android.os.Bundle;
        r5.<init>();
    L_0x0027:
        r6 = r7.toString();
        if (r6 == 0) goto L_0x0035;
    L_0x002d:
        r7 = "custom_events";
        r5.putString(r7, r6);
        r4.m557c(r6);
    L_0x0035:
        r4.m550a(r5);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.a.x.a(com.facebook.GraphRequest, android.content.Context, int, org.json.JSONArray, boolean):void");
    }

    /* renamed from: a */
    public synchronized int m816a() {
        return this.f734a.size();
    }

    /* renamed from: a */
    public int m817a(GraphRequest graphRequest, Context context, boolean z, boolean z2) {
        synchronized (this) {
            int i = this.f736c;
            this.f735b.addAll(this.f734a);
            this.f734a.clear();
            JSONArray jSONArray = new JSONArray();
            for (C0409f c0409f : this.f735b) {
                if (!c0409f.m761d()) {
                    C0475Q.m984a("Event with invalid checksum: %s", c0409f.toString());
                } else if (z || !c0409f.m758a()) {
                    jSONArray.put(c0409f.m759b());
                }
            }
            if (jSONArray.length() == 0) {
                return 0;
            }
            m815a(graphRequest, context, i, jSONArray, z2);
            return jSONArray.length();
        }
    }

    /* renamed from: a */
    public synchronized void m818a(C0409f c0409f) {
        if (this.f734a.size() + this.f735b.size() >= 1000) {
            this.f736c++;
        } else {
            this.f734a.add(c0409f);
        }
    }

    /* renamed from: a */
    public synchronized void m819a(boolean z) {
        if (z) {
            this.f734a.addAll(this.f735b);
        }
        this.f735b.clear();
        this.f736c = 0;
    }

    /* renamed from: b */
    public synchronized List<C0409f> m820b() {
        List<C0409f> list;
        list = this.f734a;
        this.f734a = new ArrayList();
        return list;
    }
}
