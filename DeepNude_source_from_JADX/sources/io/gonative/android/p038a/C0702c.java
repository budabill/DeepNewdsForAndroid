package io.gonative.android.p038a;

import android.graphics.Color;
import android.util.Log;
import org.json.JSONObject;

/* renamed from: io.gonative.android.a.c */
public class C0702c {
    /* renamed from: a */
    private static final String f1556a = "io.gonative.android.a.c";

    /* renamed from: a */
    public static Integer m1896a(String str) {
        if (str == null) {
            return null;
        }
        try {
            str = Integer.valueOf(Color.parseColor(str));
            return str;
        } catch (Throwable e) {
            String str2 = f1556a;
            StringBuilder stringBuilder = new StringBuilder("Bad color string:");
            stringBuilder.append(str);
            Log.e(str2, stringBuilder.toString(), e);
            return null;
        }
    }

    /* renamed from: a */
    public static String m1897a(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            if (str != null) {
                return jSONObject.isNull(str) ? null : jSONObject.optString(str, null);
            }
        }
        return null;
    }
}
