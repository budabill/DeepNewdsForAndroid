package com.onesignal;

import com.onesignal.C0582B.C0581f;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

abstract class cb {
    /* renamed from: a */
    private static final String[] f1265a = new String[]{"lat", "long", "loc_acc", "loc_type", "loc_bg", "loc_time_stamp", "ad_id"};
    /* renamed from: b */
    private static final Set<String> f1266b = new HashSet(Arrays.asList(f1265a));
    /* renamed from: c */
    private static final Object f1267c = new bb();
    /* renamed from: d */
    private String f1268d;
    /* renamed from: e */
    JSONObject f1269e;
    /* renamed from: f */
    JSONObject f1270f;

    cb(String str, boolean z) {
        this.f1268d = str;
        if (z) {
            m1508d();
            return;
        }
        this.f1269e = new JSONObject();
        this.f1270f = new JSONObject();
    }

    /* renamed from: a */
    private java.util.Set<java.lang.String> m1505a(com.onesignal.cb r8) {
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
        r7 = this;
        r0 = "loc_bg";
        r1 = "loc_time_stamp";
        r2 = r7.f1269e;	 Catch:{ Throwable -> 0x002d }
        r2 = r2.optLong(r1);	 Catch:{ Throwable -> 0x002d }
        r4 = r8.f1269e;	 Catch:{ Throwable -> 0x002d }
        r4 = r4.getLong(r1);	 Catch:{ Throwable -> 0x002d }
        r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));	 Catch:{ Throwable -> 0x002d }
        if (r6 == 0) goto L_0x002d;	 Catch:{ Throwable -> 0x002d }
    L_0x0014:
        r2 = r8.f1270f;	 Catch:{ Throwable -> 0x002d }
        r3 = r8.f1269e;	 Catch:{ Throwable -> 0x002d }
        r3 = r3.opt(r0);	 Catch:{ Throwable -> 0x002d }
        r2.put(r0, r3);	 Catch:{ Throwable -> 0x002d }
        r0 = r8.f1270f;	 Catch:{ Throwable -> 0x002d }
        r8 = r8.f1269e;	 Catch:{ Throwable -> 0x002d }
        r8 = r8.opt(r1);	 Catch:{ Throwable -> 0x002d }
        r0.put(r1, r8);	 Catch:{ Throwable -> 0x002d }
        r8 = f1266b;	 Catch:{ Throwable -> 0x002d }
        return r8;
    L_0x002d:
        r8 = 0;
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.cb.a(com.onesignal.cb):java.util.Set<java.lang.String>");
    }

    /* renamed from: a */
    private static JSONObject m1506a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, Set<String> set) {
        synchronized (f1267c) {
            jSONObject = C0662y.m1760a(jSONObject, jSONObject2, jSONObject3, (Set) set);
        }
        return jSONObject;
    }

    /* renamed from: c */
    private void m1507c(java.lang.String r9) {
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
        r8 = this;
        r0 = "_a";
        r1 = "_d";
        r2 = r8.f1270f;	 Catch:{ Throwable -> 0x00d3 }
        r2 = r2.has(r9);	 Catch:{ Throwable -> 0x00d3 }
        if (r2 == 0) goto L_0x0013;	 Catch:{ Throwable -> 0x00d3 }
    L_0x000c:
        r2 = r8.f1270f;	 Catch:{ Throwable -> 0x00d3 }
        r2 = r2.getJSONArray(r9);	 Catch:{ Throwable -> 0x00d3 }
        goto L_0x0018;	 Catch:{ Throwable -> 0x00d3 }
    L_0x0013:
        r2 = new org.json.JSONArray;	 Catch:{ Throwable -> 0x00d3 }
        r2.<init>();	 Catch:{ Throwable -> 0x00d3 }
    L_0x0018:
        r3 = new org.json.JSONArray;	 Catch:{ Throwable -> 0x00d3 }
        r3.<init>();	 Catch:{ Throwable -> 0x00d3 }
        r4 = r8.f1270f;	 Catch:{ Throwable -> 0x00d3 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00d3 }
        r5.<init>();	 Catch:{ Throwable -> 0x00d3 }
        r5.append(r9);	 Catch:{ Throwable -> 0x00d3 }
        r5.append(r1);	 Catch:{ Throwable -> 0x00d3 }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x00d3 }
        r4 = r4.has(r5);	 Catch:{ Throwable -> 0x00d3 }
        r5 = 0;	 Catch:{ Throwable -> 0x00d3 }
        if (r4 == 0) goto L_0x006a;	 Catch:{ Throwable -> 0x00d3 }
    L_0x0035:
        r4 = r8.f1270f;	 Catch:{ Throwable -> 0x00d3 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00d3 }
        r6.<init>();	 Catch:{ Throwable -> 0x00d3 }
        r6.append(r9);	 Catch:{ Throwable -> 0x00d3 }
        r6.append(r1);	 Catch:{ Throwable -> 0x00d3 }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x00d3 }
        r4 = r4.getJSONArray(r6);	 Catch:{ Throwable -> 0x00d3 }
        r4 = com.onesignal.C0662y.m1758a(r4);	 Catch:{ Throwable -> 0x00d3 }
        r6 = 0;	 Catch:{ Throwable -> 0x00d3 }
    L_0x004f:
        r7 = r2.length();	 Catch:{ Throwable -> 0x00d3 }
        if (r6 >= r7) goto L_0x0069;	 Catch:{ Throwable -> 0x00d3 }
    L_0x0055:
        r7 = r2.getString(r6);	 Catch:{ Throwable -> 0x00d3 }
        r7 = r4.contains(r7);	 Catch:{ Throwable -> 0x00d3 }
        if (r7 != 0) goto L_0x0066;	 Catch:{ Throwable -> 0x00d3 }
    L_0x005f:
        r7 = r2.get(r6);	 Catch:{ Throwable -> 0x00d3 }
        r3.put(r7);	 Catch:{ Throwable -> 0x00d3 }
    L_0x0066:
        r6 = r6 + 1;	 Catch:{ Throwable -> 0x00d3 }
        goto L_0x004f;	 Catch:{ Throwable -> 0x00d3 }
    L_0x0069:
        r2 = r3;	 Catch:{ Throwable -> 0x00d3 }
    L_0x006a:
        r3 = r8.f1270f;	 Catch:{ Throwable -> 0x00d3 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00d3 }
        r4.<init>();	 Catch:{ Throwable -> 0x00d3 }
        r4.append(r9);	 Catch:{ Throwable -> 0x00d3 }
        r4.append(r0);	 Catch:{ Throwable -> 0x00d3 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x00d3 }
        r3 = r3.has(r4);	 Catch:{ Throwable -> 0x00d3 }
        if (r3 == 0) goto L_0x00a6;	 Catch:{ Throwable -> 0x00d3 }
    L_0x0081:
        r3 = r8.f1270f;	 Catch:{ Throwable -> 0x00d3 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00d3 }
        r4.<init>();	 Catch:{ Throwable -> 0x00d3 }
        r4.append(r9);	 Catch:{ Throwable -> 0x00d3 }
        r4.append(r0);	 Catch:{ Throwable -> 0x00d3 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x00d3 }
        r3 = r3.getJSONArray(r4);	 Catch:{ Throwable -> 0x00d3 }
    L_0x0096:
        r4 = r3.length();	 Catch:{ Throwable -> 0x00d3 }
        if (r5 >= r4) goto L_0x00a6;	 Catch:{ Throwable -> 0x00d3 }
    L_0x009c:
        r4 = r3.get(r5);	 Catch:{ Throwable -> 0x00d3 }
        r2.put(r4);	 Catch:{ Throwable -> 0x00d3 }
        r5 = r5 + 1;	 Catch:{ Throwable -> 0x00d3 }
        goto L_0x0096;	 Catch:{ Throwable -> 0x00d3 }
    L_0x00a6:
        r3 = r8.f1270f;	 Catch:{ Throwable -> 0x00d3 }
        r3.put(r9, r2);	 Catch:{ Throwable -> 0x00d3 }
        r2 = r8.f1270f;	 Catch:{ Throwable -> 0x00d3 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00d3 }
        r3.<init>();	 Catch:{ Throwable -> 0x00d3 }
        r3.append(r9);	 Catch:{ Throwable -> 0x00d3 }
        r3.append(r0);	 Catch:{ Throwable -> 0x00d3 }
        r0 = r3.toString();	 Catch:{ Throwable -> 0x00d3 }
        r2.remove(r0);	 Catch:{ Throwable -> 0x00d3 }
        r0 = r8.f1270f;	 Catch:{ Throwable -> 0x00d3 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00d3 }
        r2.<init>();	 Catch:{ Throwable -> 0x00d3 }
        r2.append(r9);	 Catch:{ Throwable -> 0x00d3 }
        r2.append(r1);	 Catch:{ Throwable -> 0x00d3 }
        r9 = r2.toString();	 Catch:{ Throwable -> 0x00d3 }
        r0.remove(r9);	 Catch:{ Throwable -> 0x00d3 }
    L_0x00d3:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.cb.c(java.lang.String):void");
    }

    /* renamed from: d */
    private void m1508d() {
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
        r5 = this;
        r0 = com.onesignal.za.f1415a;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "ONESIGNAL_USERSTATE_DEPENDVALYES_";
        r1.append(r2);
        r2 = r5.f1268d;
        r1.append(r2);
        r1 = r1.toString();
        r2 = 0;
        r0 = com.onesignal.za.m1770a(r0, r1, r2);
        if (r0 != 0) goto L_0x0051;
    L_0x001c:
        r0 = new org.json.JSONObject;
        r0.<init>();
        r5.f1269e = r0;
        r0 = r5.f1268d;	 Catch:{ JSONException -> 0x005d }
        r1 = "CURRENT_STATE";	 Catch:{ JSONException -> 0x005d }
        r0 = r0.equals(r1);	 Catch:{ JSONException -> 0x005d }
        r1 = 1;	 Catch:{ JSONException -> 0x005d }
        if (r0 == 0) goto L_0x0037;	 Catch:{ JSONException -> 0x005d }
    L_0x002e:
        r0 = com.onesignal.za.f1415a;	 Catch:{ JSONException -> 0x005d }
        r3 = "ONESIGNAL_SUBSCRIPTION";	 Catch:{ JSONException -> 0x005d }
    L_0x0032:
        r0 = com.onesignal.za.m1766a(r0, r3, r1);	 Catch:{ JSONException -> 0x005d }
        goto L_0x003c;	 Catch:{ JSONException -> 0x005d }
    L_0x0037:
        r0 = com.onesignal.za.f1415a;	 Catch:{ JSONException -> 0x005d }
        r3 = "ONESIGNAL_SYNCED_SUBSCRIPTION";	 Catch:{ JSONException -> 0x005d }
        goto L_0x0032;	 Catch:{ JSONException -> 0x005d }
    L_0x003c:
        r3 = -2;	 Catch:{ JSONException -> 0x005d }
        if (r0 != r3) goto L_0x0042;	 Catch:{ JSONException -> 0x005d }
    L_0x003f:
        r0 = 0;	 Catch:{ JSONException -> 0x005d }
        r0 = 1;	 Catch:{ JSONException -> 0x005d }
        r1 = 0;	 Catch:{ JSONException -> 0x005d }
    L_0x0042:
        r3 = r5.f1269e;	 Catch:{ JSONException -> 0x005d }
        r4 = "subscribableStatus";	 Catch:{ JSONException -> 0x005d }
        r3.put(r4, r0);	 Catch:{ JSONException -> 0x005d }
        r0 = r5.f1269e;	 Catch:{ JSONException -> 0x005d }
        r3 = "userSubscribePref";	 Catch:{ JSONException -> 0x005d }
        r0.put(r3, r1);	 Catch:{ JSONException -> 0x005d }
        goto L_0x005d;
    L_0x0051:
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0059 }
        r1.<init>(r0);	 Catch:{ JSONException -> 0x0059 }
        r5.f1269e = r1;	 Catch:{ JSONException -> 0x0059 }
        goto L_0x005d;
    L_0x0059:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x005d:
        r0 = com.onesignal.za.f1415a;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = "ONESIGNAL_USERSTATE_SYNCVALYES_";
        r1.append(r3);
        r3 = r5.f1268d;
        r1.append(r3);
        r1 = r1.toString();
        r0 = com.onesignal.za.m1770a(r0, r1, r2);
        if (r0 != 0) goto L_0x008f;
    L_0x0078:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0097 }
        r0.<init>();	 Catch:{ JSONException -> 0x0097 }
        r5.f1270f = r0;	 Catch:{ JSONException -> 0x0097 }
        r0 = com.onesignal.za.f1415a;	 Catch:{ JSONException -> 0x0097 }
        r1 = "GT_REGISTRATION_ID";	 Catch:{ JSONException -> 0x0097 }
        r0 = com.onesignal.za.m1770a(r0, r1, r2);	 Catch:{ JSONException -> 0x0097 }
        r1 = r5.f1270f;	 Catch:{ JSONException -> 0x0097 }
        r2 = "identifier";	 Catch:{ JSONException -> 0x0097 }
        r1.put(r2, r0);	 Catch:{ JSONException -> 0x0097 }
        goto L_0x009b;	 Catch:{ JSONException -> 0x0097 }
    L_0x008f:
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0097 }
        r1.<init>(r0);	 Catch:{ JSONException -> 0x0097 }
        r5.f1270f = r1;	 Catch:{ JSONException -> 0x0097 }
        goto L_0x009b;
    L_0x0097:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x009b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.cb.d():void");
    }

    /* renamed from: a */
    cb m1509a(String str) {
        cb b = mo1372b(str);
        try {
            b.f1269e = new JSONObject(this.f1269e.toString());
            b.f1270f = new JSONObject(this.f1270f.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return b;
    }

    /* renamed from: a */
    JSONObject m1510a(cb cbVar, boolean z) {
        String str = "email_auth_hash";
        String str2 = "app_id";
        mo1371a();
        cbVar.mo1371a();
        JSONObject a = m1506a(this.f1270f, cbVar.f1270f, null, m1505a(cbVar));
        if (!z && a.toString().equals("{}")) {
            return null;
        }
        try {
            if (!a.has(str2)) {
                a.put(str2, this.f1270f.optString(str2));
            }
            if (this.f1270f.has(str)) {
                a.put(str, this.f1270f.optString(str));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return a;
    }

    /* renamed from: a */
    protected abstract void mo1371a();

    /* renamed from: a */
    void m1512a(C0581f c0581f) {
        try {
            this.f1270f.put("lat", c0581f.f1080a);
            this.f1270f.put("long", c0581f.f1081b);
            this.f1270f.put("loc_acc", c0581f.f1082c);
            this.f1270f.put("loc_type", c0581f.f1083d);
            this.f1269e.put("loc_bg", c0581f.f1084e);
            this.f1269e.put("loc_time_stamp", c0581f.f1085f);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    void m1513a(org.json.JSONObject r7, org.json.JSONObject r8) {
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
        r6 = this;
        r0 = f1267c;
        monitor-enter(r0);
        r1 = "tags";	 Catch:{ all -> 0x0081 }
        r1 = r7.has(r1);	 Catch:{ all -> 0x0081 }
        if (r1 == 0) goto L_0x007f;	 Catch:{ all -> 0x0081 }
    L_0x000b:
        r1 = r6.f1270f;	 Catch:{ all -> 0x0081 }
        r2 = "tags";	 Catch:{ all -> 0x0081 }
        r1 = r1.has(r2);	 Catch:{ all -> 0x0081 }
        if (r1 == 0) goto L_0x0029;
    L_0x0015:
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0023 }
        r2 = r6.f1270f;	 Catch:{ JSONException -> 0x0023 }
        r3 = "tags";	 Catch:{ JSONException -> 0x0023 }
        r2 = r2.optString(r3);	 Catch:{ JSONException -> 0x0023 }
        r1.<init>(r2);	 Catch:{ JSONException -> 0x0023 }
        goto L_0x002e;
    L_0x0023:
        r1 = new org.json.JSONObject;	 Catch:{ all -> 0x0081 }
        r1.<init>();	 Catch:{ all -> 0x0081 }
        goto L_0x002e;	 Catch:{ all -> 0x0081 }
    L_0x0029:
        r1 = new org.json.JSONObject;	 Catch:{ all -> 0x0081 }
        r1.<init>();	 Catch:{ all -> 0x0081 }
    L_0x002e:
        r2 = "tags";	 Catch:{ all -> 0x0081 }
        r7 = r7.optJSONObject(r2);	 Catch:{ all -> 0x0081 }
        r2 = r7.keys();	 Catch:{ all -> 0x0081 }
    L_0x0038:
        r3 = r2.hasNext();	 Catch:{ Throwable -> 0x007f }
        if (r3 == 0) goto L_0x0064;	 Catch:{ Throwable -> 0x007f }
    L_0x003e:
        r3 = r2.next();	 Catch:{ Throwable -> 0x007f }
        r3 = (java.lang.String) r3;	 Catch:{ Throwable -> 0x007f }
        r4 = "";	 Catch:{ Throwable -> 0x007f }
        r5 = r7.optString(r3);	 Catch:{ Throwable -> 0x007f }
        r4 = r4.equals(r5);	 Catch:{ Throwable -> 0x007f }
        if (r4 == 0) goto L_0x0054;	 Catch:{ Throwable -> 0x007f }
    L_0x0050:
        r1.remove(r3);	 Catch:{ Throwable -> 0x007f }
        goto L_0x0038;	 Catch:{ Throwable -> 0x007f }
    L_0x0054:
        if (r8 == 0) goto L_0x005c;	 Catch:{ Throwable -> 0x007f }
    L_0x0056:
        r4 = r8.has(r3);	 Catch:{ Throwable -> 0x007f }
        if (r4 != 0) goto L_0x0038;	 Catch:{ Throwable -> 0x007f }
    L_0x005c:
        r4 = r7.optString(r3);	 Catch:{ Throwable -> 0x007f }
        r1.put(r3, r4);	 Catch:{ Throwable -> 0x007f }
        goto L_0x0038;	 Catch:{ Throwable -> 0x007f }
    L_0x0064:
        r7 = r1.toString();	 Catch:{ Throwable -> 0x007f }
        r8 = "{}";	 Catch:{ Throwable -> 0x007f }
        r7 = r7.equals(r8);	 Catch:{ Throwable -> 0x007f }
        if (r7 == 0) goto L_0x0078;	 Catch:{ Throwable -> 0x007f }
    L_0x0070:
        r7 = r6.f1270f;	 Catch:{ Throwable -> 0x007f }
        r8 = "tags";	 Catch:{ Throwable -> 0x007f }
        r7.remove(r8);	 Catch:{ Throwable -> 0x007f }
        goto L_0x007f;	 Catch:{ Throwable -> 0x007f }
    L_0x0078:
        r7 = r6.f1270f;	 Catch:{ Throwable -> 0x007f }
        r8 = "tags";	 Catch:{ Throwable -> 0x007f }
        r7.put(r8, r1);	 Catch:{ Throwable -> 0x007f }
    L_0x007f:
        monitor-exit(r0);	 Catch:{ all -> 0x0081 }
        return;	 Catch:{ all -> 0x0081 }
    L_0x0081:
        r7 = move-exception;	 Catch:{ all -> 0x0081 }
        monitor-exit(r0);	 Catch:{ all -> 0x0081 }
        goto L_0x0085;
    L_0x0084:
        throw r7;
    L_0x0085:
        goto L_0x0084;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.cb.a(org.json.JSONObject, org.json.JSONObject):void");
    }

    /* renamed from: b */
    abstract cb mo1372b(String str);

    /* renamed from: b */
    void m1515b(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null) {
            JSONObject jSONObject3 = this.f1269e;
            m1506a(jSONObject3, jSONObject, jSONObject3, null);
        }
        if (jSONObject2 != null) {
            jSONObject3 = this.f1270f;
            m1506a(jSONObject3, jSONObject2, jSONObject3, null);
            m1513a(jSONObject2, null);
        }
        if (jSONObject != null || jSONObject2 != null) {
            m1517c();
        }
    }

    /* renamed from: b */
    abstract boolean mo1373b();

    /* renamed from: c */
    void m1517c() {
        synchronized (f1267c) {
            m1507c("pkgs");
            String str = za.f1415a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ONESIGNAL_USERSTATE_SYNCVALYES_");
            stringBuilder.append(this.f1268d);
            za.m1777b(str, stringBuilder.toString(), this.f1270f.toString());
            str = za.f1415a;
            stringBuilder = new StringBuilder();
            stringBuilder.append("ONESIGNAL_USERSTATE_DEPENDVALYES_");
            stringBuilder.append(this.f1268d);
            za.m1777b(str, stringBuilder.toString(), this.f1269e.toString());
        }
    }
}
