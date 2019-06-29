package com.facebook.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.C0560t;
import com.facebook.GraphRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.internal.x */
public class C0501x {
    /* renamed from: a */
    private static final Map<String, JSONObject> f915a = new ConcurrentHashMap();
    /* renamed from: b */
    private static Long f916b = null;

    /* renamed from: a */
    private static JSONObject m1091a(String str) {
        Bundle bundle = new Bundle();
        C0489b d = C0489b.m1069d();
        String a = (d == null || d.m1072a() == null) ? "" : d.m1072a();
        String n = C0560t.m1262n();
        bundle.putString("platform", "android");
        bundle.putString("device_id", a);
        bundle.putString("sdk_version", n);
        bundle.putString("fields", "gatekeepers");
        GraphRequest a2 = GraphRequest.m512a(null, String.format("%s/%s", new Object[]{str, "mobile_sdk_gk"}), null);
        a2.m554a(true);
        a2.m550a(bundle);
        return a2.m555b().m487b();
    }

    /* renamed from: a */
    private static synchronized JSONObject m1092a(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        synchronized (C0501x.class) {
            jSONObject2 = f915a.containsKey(str) ? (JSONObject) f915a.get(str) : new JSONObject();
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            JSONObject jSONObject3 = null;
            int i = 0;
            if (optJSONArray != null) {
                jSONObject3 = optJSONArray.optJSONObject(0);
            }
            if (!(jSONObject3 == null || jSONObject3.optJSONArray("gatekeepers") == null)) {
                optJSONArray = jSONObject3.optJSONArray("gatekeepers");
                while (i < optJSONArray.length()) {
                    try {
                        jSONObject3 = optJSONArray.getJSONObject(i);
                        jSONObject2.put(jSONObject3.getString("key"), jSONObject3.getBoolean("value"));
                    } catch (Exception e) {
                        C0475Q.m983a("FacebookSDK", e);
                    }
                    i++;
                }
            }
            f915a.put(str, jSONObject2);
        }
        return jSONObject2;
    }

    /* renamed from: a */
    public static JSONObject m1093a(String str, boolean z) {
        if (!z && f915a.containsKey(str)) {
            return (JSONObject) f915a.get(str);
        }
        JSONObject a = C0501x.m1091a(str);
        if (a == null) {
            return null;
        }
        Context d = C0560t.m1252d();
        d.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).edit().putString(String.format("com.facebook.internal.APP_GATEKEEPERS.%s", new Object[]{str}), a.toString()).apply();
        return C0501x.m1092a(str, a);
    }
}
