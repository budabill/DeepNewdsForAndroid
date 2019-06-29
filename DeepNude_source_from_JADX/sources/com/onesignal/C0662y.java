package com.onesignal;

import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.onesignal.y */
class C0662y {
    /* renamed from: a */
    static java.lang.String m1758a(org.json.JSONArray r5) {
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
        r0 = "\"";
        r1 = 0;
        r2 = "[";
    L_0x0005:
        r3 = r5.length();	 Catch:{ Throwable -> 0x0027 }
        if (r1 >= r3) goto L_0x0027;	 Catch:{ Throwable -> 0x0027 }
    L_0x000b:
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0027 }
        r3.<init>();	 Catch:{ Throwable -> 0x0027 }
        r3.append(r2);	 Catch:{ Throwable -> 0x0027 }
        r3.append(r0);	 Catch:{ Throwable -> 0x0027 }
        r4 = r5.getString(r1);	 Catch:{ Throwable -> 0x0027 }
        r3.append(r4);	 Catch:{ Throwable -> 0x0027 }
        r3.append(r0);	 Catch:{ Throwable -> 0x0027 }
        r2 = r3.toString();	 Catch:{ Throwable -> 0x0027 }
        r1 = r1 + 1;
        goto L_0x0005;
    L_0x0027:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r5.append(r2);
        r0 = "]";
        r5.append(r0);
        r5 = r5.toString();
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.y.a(org.json.JSONArray):java.lang.String");
    }

    /* renamed from: a */
    static org.json.JSONObject m1759a(org.json.JSONObject r4, java.lang.String r5) {
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
        r0 = r4.has(r5);
        if (r0 != 0) goto L_0x0008;
    L_0x0006:
        r4 = 0;
        return r4;
    L_0x0008:
        r0 = new org.json.JSONObject;
        r0.<init>();
        r4 = r4.optJSONObject(r5);
        r5 = r4.keys();
    L_0x0015:
        r1 = r5.hasNext();
        if (r1 == 0) goto L_0x0033;
    L_0x001b:
        r1 = r5.next();
        r1 = (java.lang.String) r1;
        r2 = r4.get(r1);	 Catch:{ Throwable -> 0x0031 }
        r3 = "";	 Catch:{ Throwable -> 0x0031 }
        r3 = r3.equals(r2);	 Catch:{ Throwable -> 0x0031 }
        if (r3 != 0) goto L_0x0015;	 Catch:{ Throwable -> 0x0031 }
    L_0x002d:
        r0.put(r1, r2);	 Catch:{ Throwable -> 0x0031 }
        goto L_0x0015;
        goto L_0x0015;
    L_0x0033:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.y.a(org.json.JSONObject, java.lang.String):org.json.JSONObject");
    }

    /* renamed from: a */
    static JSONObject m1760a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, Set<String> set) {
        if (jSONObject == null) {
            return null;
        }
        if (jSONObject2 == null) {
            return jSONObject3;
        }
        Iterator keys = jSONObject2.keys();
        JSONObject jSONObject4 = jSONObject3 != null ? jSONObject3 : new JSONObject();
        while (keys.hasNext()) {
            try {
                Object jSONObject5;
                String str = (String) keys.next();
                Object obj = jSONObject2.get(str);
                if (jSONObject.has(str)) {
                    if (obj instanceof JSONObject) {
                        JSONObject jSONObject6 = jSONObject.getJSONObject(str);
                        JSONObject jSONObject7 = (jSONObject3 == null || !jSONObject3.has(str)) ? null : jSONObject3.getJSONObject(str);
                        String jSONObject8 = C0662y.m1760a(jSONObject6, (JSONObject) obj, jSONObject7, (Set) set).toString();
                        if (!jSONObject8.equals("{}")) {
                            jSONObject5 = new JSONObject(jSONObject8);
                        }
                    } else if (obj instanceof JSONArray) {
                        C0662y.m1761a(str, (JSONArray) obj, jSONObject.getJSONArray(str), jSONObject4);
                    } else {
                        if (set == null || !set.contains(str)) {
                            jSONObject5 = jSONObject.get(str);
                            if (!obj.equals(jSONObject5)) {
                                if ((jSONObject5 instanceof Integer) && !"".equals(obj)) {
                                    if (((Number) jSONObject5).doubleValue() != ((Number) obj).doubleValue()) {
                                    }
                                }
                            }
                        }
                        jSONObject4.put(str, obj);
                    }
                } else if (obj instanceof JSONObject) {
                    jSONObject5 = new JSONObject(obj.toString());
                } else {
                    if (obj instanceof JSONArray) {
                        C0662y.m1761a(str, (JSONArray) obj, null, jSONObject4);
                    }
                    jSONObject4.put(str, obj);
                }
                jSONObject4.put(str, jSONObject5);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject4;
    }

    /* renamed from: a */
    private static void m1761a(String str, JSONArray jSONArray, JSONArray jSONArray2, JSONObject jSONObject) {
        String str2 = "_a";
        if (!str.endsWith(str2)) {
            String str3 = "_d";
            if (!str.endsWith(str3)) {
                StringBuilder stringBuilder;
                String a = C0662y.m1758a(jSONArray);
                JSONArray jSONArray3 = new JSONArray();
                JSONArray jSONArray4 = new JSONArray();
                String a2 = jSONArray2 == null ? null : C0662y.m1758a(jSONArray2);
                for (int i = 0; i < jSONArray.length(); i++) {
                    String str4 = (String) jSONArray.get(i);
                    if (jSONArray2 == null || !a2.contains(str4)) {
                        jSONArray3.put(str4);
                    }
                }
                if (jSONArray2 != null) {
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        CharSequence string = jSONArray2.getString(i2);
                        if (!a.contains(string)) {
                            jSONArray4.put(string);
                        }
                    }
                }
                String str5 = "[]";
                if (!jSONArray3.toString().equals(str5)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(str2);
                    jSONObject.put(stringBuilder.toString(), jSONArray3);
                }
                if (!jSONArray4.toString().equals(str5)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(str3);
                    jSONObject.put(stringBuilder.toString(), jSONArray4);
                }
                return;
            }
        }
        jSONObject.put(str, jSONArray);
    }
}
