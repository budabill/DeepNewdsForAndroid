package com.facebook.applinks;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.C0506l;
import com.facebook.C0560t;
import com.facebook.internal.C0475Q;
import com.facebook.internal.C0476S;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.applinks.b */
public class C0435b {
    /* renamed from: a */
    private static final String f747a = "com.facebook.applinks.b";
    /* renamed from: b */
    private String f748b;
    /* renamed from: c */
    private Uri f749c;
    /* renamed from: d */
    private JSONObject f750d;
    /* renamed from: e */
    private Bundle f751e;
    /* renamed from: f */
    private String f752f;

    /* renamed from: com.facebook.applinks.b$a */
    public interface C0434a {
        /* renamed from: a */
        void mo1400a(C0435b c0435b);
    }

    private C0435b() {
    }

    /* renamed from: a */
    private static Bundle m826a(JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object obj = jSONObject.get(str);
            if (obj instanceof JSONObject) {
                bundle.putBundle(str, C0435b.m826a((JSONObject) obj));
            } else if (obj instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj;
                int i = 0;
                if (jSONArray.length() == 0) {
                    bundle.putStringArray(str, new String[0]);
                } else {
                    Object obj2 = jSONArray.get(0);
                    if (obj2 instanceof JSONObject) {
                        Parcelable[] parcelableArr = new Bundle[jSONArray.length()];
                        while (i < jSONArray.length()) {
                            parcelableArr[i] = C0435b.m826a(jSONArray.getJSONObject(i));
                            i++;
                        }
                        bundle.putParcelableArray(str, parcelableArr);
                    } else if (obj2 instanceof JSONArray) {
                        throw new C0506l("Nested arrays are not supported.");
                    } else {
                        String[] strArr = new String[jSONArray.length()];
                        while (i < jSONArray.length()) {
                            strArr[i] = jSONArray.get(i).toString();
                            i++;
                        }
                        bundle.putStringArray(str, strArr);
                    }
                }
            } else {
                bundle.putString(str, obj.toString());
            }
        }
        return bundle;
    }

    /* renamed from: a */
    private static C0435b m827a(String str) {
        Throwable e;
        String str2 = "promo_code";
        String str3 = "deeplink_context";
        String str4 = "extras";
        String str5 = "fb_ref";
        String str6 = "target_url";
        String str7 = "referer_data";
        String str8 = "ref";
        String str9 = "Unable to parse AppLink JSON";
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            str = jSONObject.getString("version");
            if (jSONObject.getJSONObject("bridge_args").getString("method").equals("applink") && str.equals("2")) {
                JSONObject jSONObject2;
                JSONObject jSONObject3;
                C0435b c0435b = new C0435b();
                c0435b.f750d = jSONObject.getJSONObject("method_args");
                if (c0435b.f750d.has(str8)) {
                    str5 = c0435b.f750d.getString(str8);
                } else {
                    if (c0435b.f750d.has(str7)) {
                        JSONObject jSONObject4 = c0435b.f750d.getJSONObject(str7);
                        if (jSONObject4.has(str5)) {
                            str5 = jSONObject4.getString(str5);
                        }
                    }
                    if (c0435b.f750d.has(str6)) {
                        c0435b.f749c = Uri.parse(c0435b.f750d.getString(str6));
                    }
                    if (c0435b.f750d.has(str4)) {
                        jSONObject2 = c0435b.f750d.getJSONObject(str4);
                        if (jSONObject2.has(str3)) {
                            jSONObject3 = jSONObject2.getJSONObject(str3);
                            if (jSONObject3.has(str2)) {
                                c0435b.f752f = jSONObject3.getString(str2);
                            }
                        }
                    }
                    c0435b.f751e = C0435b.m826a(c0435b.f750d);
                    return c0435b;
                }
                c0435b.f748b = str5;
                if (c0435b.f750d.has(str6)) {
                    c0435b.f749c = Uri.parse(c0435b.f750d.getString(str6));
                }
                if (c0435b.f750d.has(str4)) {
                    jSONObject2 = c0435b.f750d.getJSONObject(str4);
                    if (jSONObject2.has(str3)) {
                        jSONObject3 = jSONObject2.getJSONObject(str3);
                        if (jSONObject3.has(str2)) {
                            c0435b.f752f = jSONObject3.getString(str2);
                        }
                    }
                }
                c0435b.f751e = C0435b.m826a(c0435b.f750d);
                return c0435b;
            }
        } catch (JSONException e2) {
            e = e2;
            C0475Q.m985a(f747a, str9, e);
            return null;
        } catch (C0506l e3) {
            e = e3;
            C0475Q.m985a(f747a, str9, e);
            return null;
        }
        return null;
    }

    /* renamed from: a */
    public static void m828a(Context context, C0434a c0434a) {
        C0435b.m830b(context, null, c0434a);
    }

    /* renamed from: b */
    public static void m830b(Context context, String str, C0434a c0434a) {
        Object c;
        C0476S.m1016a((Object) context, "context");
        C0476S.m1016a((Object) c0434a, "completionHandler");
        if (str == null) {
            c = C0475Q.m999c(context);
        }
        C0476S.m1016a(c, "applicationId");
        C0560t.m1258j().execute(new C0433a(context.getApplicationContext(), c, c0434a));
    }

    /* renamed from: c */
    private static void m831c(android.content.Context r7, java.lang.String r8, com.facebook.applinks.C0435b.C0434a r9) {
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
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = "event";	 Catch:{ JSONException -> 0x00d2 }
        r2 = "DEFERRED_APP_LINK";	 Catch:{ JSONException -> 0x00d2 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x00d2 }
        r1 = com.facebook.internal.C0489b.m1065a(r7);	 Catch:{ JSONException -> 0x00d2 }
        r2 = com.facebook.p029a.C0422r.m787a(r7);	 Catch:{ JSONException -> 0x00d2 }
        r3 = com.facebook.C0560t.m1245a(r7);	 Catch:{ JSONException -> 0x00d2 }
        com.facebook.internal.C0475Q.m988a(r0, r1, r2, r3);	 Catch:{ JSONException -> 0x00d2 }
        r1 = com.facebook.C0560t.m1252d();	 Catch:{ JSONException -> 0x00d2 }
        com.facebook.internal.C0475Q.m987a(r0, r1);	 Catch:{ JSONException -> 0x00d2 }
        r1 = "application_package_name";	 Catch:{ JSONException -> 0x00d2 }
        r7 = r7.getPackageName();	 Catch:{ JSONException -> 0x00d2 }
        r0.put(r1, r7);	 Catch:{ JSONException -> 0x00d2 }
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r1 = 0;
        r7[r1] = r8;
        r8 = "%s/activities";
        r7 = java.lang.String.format(r8, r7);
        r8 = 0;
        r7 = com.facebook.GraphRequest.m513a(r8, r7, r0, r8);	 Catch:{ Exception -> 0x00c7 }
        r7 = r7.m555b();	 Catch:{ Exception -> 0x00c7 }
        r7 = r7.m487b();	 Catch:{ Exception -> 0x00c7 }
        if (r7 == 0) goto L_0x00ce;	 Catch:{ Exception -> 0x00c7 }
    L_0x0046:
        r0 = "applink_args";	 Catch:{ Exception -> 0x00c7 }
        r0 = r7.optString(r0);	 Catch:{ Exception -> 0x00c7 }
        r1 = "click_time";	 Catch:{ Exception -> 0x00c7 }
        r2 = -1;	 Catch:{ Exception -> 0x00c7 }
        r4 = r7.optLong(r1, r2);	 Catch:{ Exception -> 0x00c7 }
        r1 = "applink_class";	 Catch:{ Exception -> 0x00c7 }
        r1 = r7.optString(r1);	 Catch:{ Exception -> 0x00c7 }
        r6 = "applink_url";	 Catch:{ Exception -> 0x00c7 }
        r7 = r7.optString(r6);	 Catch:{ Exception -> 0x00c7 }
        r6 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x00c7 }
        if (r6 != 0) goto L_0x00ce;	 Catch:{ Exception -> 0x00c7 }
    L_0x0066:
        r8 = com.facebook.applinks.C0435b.m827a(r0);	 Catch:{ Exception -> 0x00c7 }
        r0 = "Unable to put tap time in AppLinkData.arguments";
        r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r6 == 0) goto L_0x008e;
    L_0x0070:
        r2 = r8.f750d;	 Catch:{ JSONException -> 0x0089 }
        r3 = "com.facebook.platform.APPLINK_TAP_TIME_UTC";
        if (r2 == 0) goto L_0x007b;
    L_0x0076:
        r2 = r8.f750d;	 Catch:{ JSONException -> 0x0089 }
        r2.put(r3, r4);	 Catch:{ JSONException -> 0x0089 }
    L_0x007b:
        r2 = r8.f751e;	 Catch:{ JSONException -> 0x0089 }
        if (r2 == 0) goto L_0x008e;	 Catch:{ JSONException -> 0x0089 }
    L_0x007f:
        r2 = r8.f751e;	 Catch:{ JSONException -> 0x0089 }
        r4 = java.lang.Long.toString(r4);	 Catch:{ JSONException -> 0x0089 }
        r2.putString(r3, r4);	 Catch:{ JSONException -> 0x0089 }
        goto L_0x008e;
    L_0x0089:
        r2 = f747a;	 Catch:{ Exception -> 0x00c7 }
        com.facebook.internal.C0475Q.m984a(r2, r0);	 Catch:{ Exception -> 0x00c7 }
    L_0x008e:
        if (r1 == 0) goto L_0x00aa;
    L_0x0090:
        r2 = r8.f750d;	 Catch:{ JSONException -> 0x00a5 }
        r3 = "com.facebook.platform.APPLINK_NATIVE_CLASS";
        if (r2 == 0) goto L_0x009b;
    L_0x0096:
        r2 = r8.f750d;	 Catch:{ JSONException -> 0x00a5 }
        r2.put(r3, r1);	 Catch:{ JSONException -> 0x00a5 }
    L_0x009b:
        r2 = r8.f751e;	 Catch:{ JSONException -> 0x00a5 }
        if (r2 == 0) goto L_0x00aa;	 Catch:{ JSONException -> 0x00a5 }
    L_0x009f:
        r2 = r8.f751e;	 Catch:{ JSONException -> 0x00a5 }
        r2.putString(r3, r1);	 Catch:{ JSONException -> 0x00a5 }
        goto L_0x00aa;
    L_0x00a5:
        r1 = f747a;	 Catch:{ Exception -> 0x00c7 }
        com.facebook.internal.C0475Q.m984a(r1, r0);	 Catch:{ Exception -> 0x00c7 }
    L_0x00aa:
        if (r7 == 0) goto L_0x00ce;
    L_0x00ac:
        r1 = r8.f750d;	 Catch:{ JSONException -> 0x00c1 }
        r2 = "com.facebook.platform.APPLINK_NATIVE_URL";
        if (r1 == 0) goto L_0x00b7;
    L_0x00b2:
        r1 = r8.f750d;	 Catch:{ JSONException -> 0x00c1 }
        r1.put(r2, r7);	 Catch:{ JSONException -> 0x00c1 }
    L_0x00b7:
        r1 = r8.f751e;	 Catch:{ JSONException -> 0x00c1 }
        if (r1 == 0) goto L_0x00ce;	 Catch:{ JSONException -> 0x00c1 }
    L_0x00bb:
        r1 = r8.f751e;	 Catch:{ JSONException -> 0x00c1 }
        r1.putString(r2, r7);	 Catch:{ JSONException -> 0x00c1 }
        goto L_0x00ce;
    L_0x00c1:
        r7 = f747a;	 Catch:{ Exception -> 0x00c7 }
        com.facebook.internal.C0475Q.m984a(r7, r0);	 Catch:{ Exception -> 0x00c7 }
        goto L_0x00ce;
    L_0x00c7:
        r7 = f747a;
        r0 = "Unable to fetch deferred applink from server";
        com.facebook.internal.C0475Q.m984a(r7, r0);
    L_0x00ce:
        r9.mo1400a(r8);
        return;
    L_0x00d2:
        r7 = move-exception;
        r8 = new com.facebook.l;
        r9 = "An error occurred while preparing deferred app link";
        r8.<init>(r9, r7);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.applinks.b.c(android.content.Context, java.lang.String, com.facebook.applinks.b$a):void");
    }

    /* renamed from: a */
    public Uri m832a() {
        return this.f749c;
    }
}
