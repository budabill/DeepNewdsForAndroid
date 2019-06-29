package com.facebook.share.internal;

import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.share.internal.e */
public final class C0550e {

    /* renamed from: com.facebook.share.internal.e$a */
    public interface C0549a {
        /* renamed from: a */
        JSONObject mo974a(SharePhoto sharePhoto);
    }

    /* renamed from: a */
    public static Object m1227a(Object obj, C0549a c0549a) {
        if (obj == null) {
            return JSONObject.NULL;
        }
        if (!((obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer))) {
            if (!(obj instanceof Long)) {
                if (obj instanceof SharePhoto) {
                    return c0549a != null ? c0549a.mo974a((SharePhoto) obj) : null;
                } else {
                    if (obj instanceof ShareOpenGraphObject) {
                        return C0550e.m1230a((ShareOpenGraphObject) obj, c0549a);
                    }
                    if (obj instanceof List) {
                        return C0550e.m1228a((List) obj, c0549a);
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid object found for JSON serialization: ");
                    stringBuilder.append(obj.toString());
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
        }
        return obj;
    }

    /* renamed from: a */
    private static JSONArray m1228a(List list, C0549a c0549a) {
        JSONArray jSONArray = new JSONArray();
        for (Object a : list) {
            jSONArray.put(C0550e.m1227a(a, c0549a));
        }
        return jSONArray;
    }

    /* renamed from: a */
    public static JSONObject m1229a(ShareOpenGraphAction shareOpenGraphAction, C0549a c0549a) {
        JSONObject jSONObject = new JSONObject();
        for (String str : shareOpenGraphAction.m2224b()) {
            jSONObject.put(str, C0550e.m1227a(shareOpenGraphAction.m2222a(str), c0549a));
        }
        return jSONObject;
    }

    /* renamed from: a */
    private static JSONObject m1230a(ShareOpenGraphObject shareOpenGraphObject, C0549a c0549a) {
        JSONObject jSONObject = new JSONObject();
        for (String str : shareOpenGraphObject.m2224b()) {
            jSONObject.put(str, C0550e.m1227a(shareOpenGraphObject.m2222a(str), c0549a));
        }
        return jSONObject;
    }
}
