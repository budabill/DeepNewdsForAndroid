package com.facebook.p029a.p030a.p031a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.a.a.a.b */
public final class C0350b {
    /* renamed from: a */
    public final String f536a;
    /* renamed from: b */
    public final String f537b;
    /* renamed from: c */
    public final List<C0352c> f538c;
    /* renamed from: d */
    public final String f539d;

    public C0350b(JSONObject jSONObject) {
        this.f536a = jSONObject.getString("name");
        this.f537b = jSONObject.optString("value");
        List arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("path");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(new C0352c(optJSONArray.getJSONObject(i)));
            }
        }
        this.f538c = arrayList;
        this.f539d = jSONObject.optString("path_type", "absolute");
    }
}
