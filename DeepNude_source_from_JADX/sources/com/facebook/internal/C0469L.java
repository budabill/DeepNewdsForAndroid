package com.facebook.internal;

import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* renamed from: com.facebook.internal.L */
class C0469L {
    /* renamed from: a */
    private static final ConcurrentHashMap<String, JSONObject> f831a = new ConcurrentHashMap();

    /* renamed from: a */
    public static JSONObject m944a(String str) {
        return (JSONObject) f831a.get(str);
    }

    /* renamed from: a */
    public static void m945a(String str, JSONObject jSONObject) {
        f831a.put(str, jSONObject);
    }
}
