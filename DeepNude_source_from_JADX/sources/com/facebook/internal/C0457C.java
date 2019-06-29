package com.facebook.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.C0560t;
import com.facebook.GraphRequest;
import com.facebook.internal.C0503y.C0502a;
import com.facebook.p029a.p030a.p031a.C0354e;
import com.facebook.p029a.p032b.C0390n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.internal.C */
public final class C0457C {
    /* renamed from: a */
    private static final String f793a = "C";
    /* renamed from: b */
    private static final String[] f794b = new String[]{"supports_implicit_sdk_logging", "gdpv4_nux_content", "gdpv4_nux_enabled", "gdpv4_chrome_custom_tabs_enabled", "android_dialog_configs", "android_sdk_error_categories", "app_events_session_timeout", "app_events_feature_bitmask", "auto_event_mapping_android", "auto_event_setup_enabled", "seamless_login", "smart_login_bookmark_icon_url", "smart_login_menu_icon_url"};
    /* renamed from: c */
    private static final Map<String, C0503y> f795c = new ConcurrentHashMap();
    /* renamed from: d */
    private static final AtomicReference<C0455a> f796d = new AtomicReference(C0455a.NOT_LOADED);
    /* renamed from: e */
    private static final ConcurrentLinkedQueue<C0456b> f797e = new ConcurrentLinkedQueue();
    /* renamed from: f */
    private static boolean f798f = false;
    /* renamed from: g */
    private static boolean f799g = false;
    /* renamed from: h */
    private static JSONArray f800h = null;

    /* renamed from: com.facebook.internal.C$a */
    enum C0455a {
        NOT_LOADED,
        LOADING,
        SUCCESS,
        ERROR
    }

    /* renamed from: com.facebook.internal.C$b */
    public interface C0456b {
        /* renamed from: a */
        void m868a();

        /* renamed from: a */
        void m869a(C0503y c0503y);
    }

    /* renamed from: a */
    public static C0503y m871a(String str, boolean z) {
        if (!z && f795c.containsKey(str)) {
            return (C0503y) f795c.get(str);
        }
        JSONObject c = C0457C.m880c(str);
        if (c == null) {
            return null;
        }
        C0503y b = C0457C.m877b(str, c);
        if (str.equals(C0560t.m1253e())) {
            f796d.set(C0455a.SUCCESS);
            C0457C.m884g();
        }
        return b;
    }

    /* renamed from: a */
    private static Map<String, Map<String, C0502a>> m872a(JSONObject jSONObject) {
        Map hashMap = new HashMap();
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    C0502a a = C0502a.m1094a(optJSONArray.optJSONObject(i));
                    if (a != null) {
                        String a2 = a.m1096a();
                        Map map = (Map) hashMap.get(a2);
                        if (map == null) {
                            map = new HashMap();
                            hashMap.put(a2, map);
                        }
                        map.put(a.m1097b(), a);
                    }
                }
            }
        }
        return hashMap;
    }

    /* renamed from: b */
    public static C0503y m876b(String str) {
        return str != null ? (C0503y) f795c.get(str) : null;
    }

    /* renamed from: b */
    private static C0503y m877b(String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        JSONArray optJSONArray = jSONObject2.optJSONArray("android_sdk_error_categories");
        C0498t a = optJSONArray == null ? C0498t.m1083a() : C0498t.m1084a(optJSONArray);
        int optInt = jSONObject2.optInt("app_events_feature_bitmask", 0);
        boolean z = (optInt & 8) != 0;
        boolean z2 = (optInt & 16) != 0;
        boolean z3 = (optInt & 32) != 0;
        boolean z4 = (optInt & 256) != 0;
        boolean optBoolean = jSONObject2.optBoolean("auto_event_setup_enabled", false);
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("auto_event_mapping_android");
        f800h = optJSONArray2;
        if (f800h != null && C0458D.m886b()) {
            C0354e.m602a(optJSONArray2.toString());
        }
        C0503y c0503y = r2;
        C0503y c0503y2 = new C0503y(jSONObject2.optBoolean("supports_implicit_sdk_logging", false), jSONObject2.optString("gdpv4_nux_content", ""), jSONObject2.optBoolean("gdpv4_nux_enabled", false), jSONObject2.optBoolean("gdpv4_chrome_custom_tabs_enabled", false), jSONObject2.optInt("app_events_session_timeout", C0390n.m700a()), C0471N.m950a(jSONObject2.optLong("seamless_login")), C0457C.m872a(jSONObject2.optJSONObject("android_dialog_configs")), z, a, jSONObject2.optString("smart_login_bookmark_icon_url"), jSONObject2.optString("smart_login_menu_icon_url"), z2, z3, optJSONArray2, jSONObject2.optString("sdk_update_message"), z4, optBoolean);
        c0503y2 = c0503y;
        f795c.put(str, c0503y2);
        return c0503y2;
    }

    /* renamed from: c */
    private static JSONObject m880c(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", TextUtils.join(",", new ArrayList(Arrays.asList(f794b))));
        C0489b a = C0489b.m1065a(C0560t.m1252d());
        if (!(a == null || a.m1072a() == null)) {
            bundle.putString("advertiser_id", a.m1072a());
        }
        GraphRequest a2 = GraphRequest.m512a(null, str, null);
        a2.m554a(true);
        a2.m550a(bundle);
        return a2.m555b().m487b();
    }

    /* renamed from: f */
    public static void m883f() {
        Context d = C0560t.m1252d();
        String e = C0560t.m1253e();
        if (C0475Q.m998b(e)) {
            f796d.set(C0455a.ERROR);
            C0457C.m884g();
        } else if (f795c.containsKey(e)) {
            f796d.set(C0455a.SUCCESS);
            C0457C.m884g();
        } else {
            Object obj;
            if (!f796d.compareAndSet(C0455a.NOT_LOADED, C0455a.LOADING)) {
                if (!f796d.compareAndSet(C0455a.ERROR, C0455a.LOADING)) {
                    obj = null;
                    if (obj != null) {
                        C0457C.m884g();
                    }
                    C0560t.m1258j().execute(new C0504z(d, String.format("com.facebook.internal.APP_SETTINGS.%s", new Object[]{e}), e));
                    return;
                }
            }
            obj = 1;
            if (obj != null) {
                C0560t.m1258j().execute(new C0504z(d, String.format("com.facebook.internal.APP_SETTINGS.%s", new Object[]{e}), e));
                return;
            }
            C0457C.m884g();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: g */
    private static synchronized void m884g() {
        /*
        r0 = com.facebook.internal.C0457C.class;
        monitor-enter(r0);
        r1 = f796d;	 Catch:{ all -> 0x0071 }
        r1 = r1.get();	 Catch:{ all -> 0x0071 }
        r1 = (com.facebook.internal.C0457C.C0455a) r1;	 Catch:{ all -> 0x0071 }
        r2 = com.facebook.internal.C0457C.C0455a.NOT_LOADED;	 Catch:{ all -> 0x0071 }
        r2 = r2.equals(r1);	 Catch:{ all -> 0x0071 }
        if (r2 != 0) goto L_0x006f;
    L_0x0013:
        r2 = com.facebook.internal.C0457C.C0455a.LOADING;	 Catch:{ all -> 0x0071 }
        r2 = r2.equals(r1);	 Catch:{ all -> 0x0071 }
        if (r2 == 0) goto L_0x001c;
    L_0x001b:
        goto L_0x006f;
    L_0x001c:
        r2 = com.facebook.C0560t.m1253e();	 Catch:{ all -> 0x0071 }
        r3 = f795c;	 Catch:{ all -> 0x0071 }
        r2 = r3.get(r2);	 Catch:{ all -> 0x0071 }
        r2 = (com.facebook.internal.C0503y) r2;	 Catch:{ all -> 0x0071 }
        r3 = new android.os.Handler;	 Catch:{ all -> 0x0071 }
        r4 = android.os.Looper.getMainLooper();	 Catch:{ all -> 0x0071 }
        r3.<init>(r4);	 Catch:{ all -> 0x0071 }
        r4 = com.facebook.internal.C0457C.C0455a.ERROR;	 Catch:{ all -> 0x0071 }
        r1 = r4.equals(r1);	 Catch:{ all -> 0x0071 }
        if (r1 == 0) goto L_0x0054;
    L_0x0039:
        r1 = f797e;	 Catch:{ all -> 0x0071 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0071 }
        if (r1 != 0) goto L_0x0052;
    L_0x0041:
        r1 = f797e;	 Catch:{ all -> 0x0071 }
        r1 = r1.poll();	 Catch:{ all -> 0x0071 }
        r1 = (com.facebook.internal.C0457C.C0456b) r1;	 Catch:{ all -> 0x0071 }
        r2 = new com.facebook.internal.A;	 Catch:{ all -> 0x0071 }
        r2.<init>(r1);	 Catch:{ all -> 0x0071 }
        r3.post(r2);	 Catch:{ all -> 0x0071 }
        goto L_0x0039;
    L_0x0052:
        monitor-exit(r0);
        return;
    L_0x0054:
        r1 = f797e;	 Catch:{ all -> 0x0071 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0071 }
        if (r1 != 0) goto L_0x006d;
    L_0x005c:
        r1 = f797e;	 Catch:{ all -> 0x0071 }
        r1 = r1.poll();	 Catch:{ all -> 0x0071 }
        r1 = (com.facebook.internal.C0457C.C0456b) r1;	 Catch:{ all -> 0x0071 }
        r4 = new com.facebook.internal.B;	 Catch:{ all -> 0x0071 }
        r4.<init>(r1, r2);	 Catch:{ all -> 0x0071 }
        r3.post(r4);	 Catch:{ all -> 0x0071 }
        goto L_0x0054;
    L_0x006d:
        monitor-exit(r0);
        return;
    L_0x006f:
        monitor-exit(r0);
        return;
    L_0x0071:
        r1 = move-exception;
        monitor-exit(r0);
        goto L_0x0075;
    L_0x0074:
        throw r1;
    L_0x0075:
        goto L_0x0074;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.C.g():void");
    }
}
