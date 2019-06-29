package com.facebook.internal;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.internal.k */
public class C0492k {
    /* renamed from: a */
    private static final Map<Class<?>, C0491a> f892a = new HashMap();

    /* renamed from: com.facebook.internal.k$a */
    public interface C0491a {
        /* renamed from: a */
        void mo956a(Bundle bundle, String str, Object obj);
    }

    static {
        f892a.put(Boolean.class, new C0836d());
        f892a.put(Integer.class, new C0837e());
        f892a.put(Long.class, new C0838f());
        f892a.put(Double.class, new C0839g());
        f892a.put(String.class, new C0840h());
        f892a.put(String[].class, new C0841i());
        f892a.put(JSONArray.class, new C0842j());
    }

    /* renamed from: a */
    public static Bundle m1080a(JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object obj = jSONObject.get(str);
            if (obj != null) {
                if (obj != JSONObject.NULL) {
                    if (obj instanceof JSONObject) {
                        bundle.putBundle(str, C0492k.m1080a((JSONObject) obj));
                    } else {
                        C0491a c0491a = (C0491a) f892a.get(obj.getClass());
                        if (c0491a != null) {
                            c0491a.mo956a(bundle, str, obj);
                        } else {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Unsupported type: ");
                            stringBuilder.append(obj.getClass());
                            throw new IllegalArgumentException(stringBuilder.toString());
                        }
                    }
                }
            }
        }
        return bundle;
    }
}
