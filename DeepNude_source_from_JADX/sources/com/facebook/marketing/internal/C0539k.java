package com.facebook.marketing.internal;

import android.os.Bundle;
import android.util.Log;
import com.facebook.C0332E;
import com.facebook.C0560t;
import com.facebook.GraphRequest;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.marketing.internal.k */
public class C0539k {
    /* renamed from: a */
    private static final String f1038a = "com.facebook.marketing.internal.k";
    /* renamed from: b */
    private static final Map<String, C0537i> f1039b = new ConcurrentHashMap();

    /* renamed from: a */
    public static C0537i m1216a(String str) {
        return str != null ? (C0537i) f1039b.get(str) : null;
    }

    /* renamed from: a */
    public static void m1218a() {
        C0560t.m1258j().execute(new C0538j());
    }

    /* renamed from: b */
    private static JSONObject m1220b(String str, String str2) {
        try {
            String format = String.format(Locale.US, "%s/button_auto_detection_device_selection", new Object[]{str});
            Bundle bundle = new Bundle();
            bundle.putString("device_id", str2);
            bundle.putString("fields", "is_selected");
            GraphRequest graphRequest = new GraphRequest(null, format, bundle, C0332E.GET, null);
            graphRequest.m554a(true);
            return graphRequest.m555b().m487b();
        } catch (Throwable e) {
            Log.e(f1038a, "fail to request button sampling api", e);
            return new JSONObject();
        }
    }

    /* renamed from: b */
    private static void m1221b(String str, JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            jSONObject = optJSONArray.optJSONObject(0);
            if (jSONObject != null) {
                f1039b.put(str, new C0537i(jSONObject.optBoolean("is_selected", false)));
            }
        }
    }
}
