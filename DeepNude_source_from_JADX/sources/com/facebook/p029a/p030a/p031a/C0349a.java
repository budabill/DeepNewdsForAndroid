package com.facebook.p029a.p030a.p031a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.a.a.a.a */
public class C0349a {
    /* renamed from: a */
    private final String f527a;
    /* renamed from: b */
    private final C0348b f528b;
    /* renamed from: c */
    private final C0347a f529c;
    /* renamed from: d */
    private final String f530d;
    /* renamed from: e */
    private final List<C0352c> f531e;
    /* renamed from: f */
    private final List<C0350b> f532f;
    /* renamed from: g */
    private final String f533g;
    /* renamed from: h */
    private final String f534h;
    /* renamed from: i */
    private final String f535i;

    /* renamed from: com.facebook.a.a.a.a$a */
    public enum C0347a {
        CLICK,
        SELECTED,
        TEXT_CHANGED
    }

    /* renamed from: com.facebook.a.a.a.a$b */
    public enum C0348b {
        MANUAL,
        INFERENCE
    }

    public C0349a(String str, C0348b c0348b, C0347a c0347a, String str2, List<C0352c> list, List<C0350b> list2, String str3, String str4, String str5) {
        this.f527a = str;
        this.f528b = c0348b;
        this.f529c = c0347a;
        this.f530d = str2;
        this.f531e = list;
        this.f532f = list2;
        this.f533g = str3;
        this.f534h = str4;
        this.f535i = str5;
    }

    /* renamed from: a */
    public static C0349a m586a(JSONObject jSONObject) {
        String string = jSONObject.getString("event_name");
        C0348b valueOf = C0348b.valueOf(jSONObject.getString("method").toUpperCase());
        C0347a valueOf2 = C0347a.valueOf(jSONObject.getString("event_type").toUpperCase());
        String string2 = jSONObject.getString("app_version");
        JSONArray jSONArray = jSONObject.getJSONArray("path");
        List arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new C0352c(jSONArray.getJSONObject(i)));
        }
        String optString = jSONObject.optString("path_type", "absolute");
        jSONArray = jSONObject.optJSONArray("parameters");
        List arrayList2 = new ArrayList();
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                arrayList2.add(new C0350b(jSONArray.getJSONObject(i2)));
            }
        }
        return new C0349a(string, valueOf, valueOf2, string2, arrayList, arrayList2, jSONObject.optString("component_id"), optString, jSONObject.optString("activity_name"));
    }

    /* renamed from: a */
    public static java.util.List<com.facebook.p029a.p030a.p031a.C0349a> m587a(org.json.JSONArray r4) {
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
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = 0;
        if (r4 == 0) goto L_0x000d;
    L_0x0008:
        r2 = r4.length();	 Catch:{ JSONException -> 0x001e }
        goto L_0x000e;	 Catch:{ JSONException -> 0x001e }
    L_0x000d:
        r2 = 0;	 Catch:{ JSONException -> 0x001e }
    L_0x000e:
        if (r1 >= r2) goto L_0x001e;	 Catch:{ JSONException -> 0x001e }
    L_0x0010:
        r3 = r4.getJSONObject(r1);	 Catch:{ JSONException -> 0x001e }
        r3 = com.facebook.p029a.p030a.p031a.C0349a.m586a(r3);	 Catch:{ JSONException -> 0x001e }
        r0.add(r3);	 Catch:{ JSONException -> 0x001e }
        r1 = r1 + 1;
        goto L_0x000e;
    L_0x001e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.a.a.a.a.a(org.json.JSONArray):java.util.List<com.facebook.a.a.a.a>");
    }

    /* renamed from: a */
    public String m588a() {
        return this.f535i;
    }

    /* renamed from: b */
    public String m589b() {
        return this.f527a;
    }

    /* renamed from: c */
    public C0347a m590c() {
        return this.f529c;
    }

    /* renamed from: d */
    public List<C0350b> m591d() {
        return Collections.unmodifiableList(this.f532f);
    }

    /* renamed from: e */
    public List<C0352c> m592e() {
        return Collections.unmodifiableList(this.f531e);
    }
}
