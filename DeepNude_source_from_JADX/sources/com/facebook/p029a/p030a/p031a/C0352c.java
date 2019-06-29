package com.facebook.p029a.p030a.p031a;

import org.json.JSONObject;

/* renamed from: com.facebook.a.a.a.c */
public final class C0352c {
    /* renamed from: a */
    public final String f547a;
    /* renamed from: b */
    public final int f548b;
    /* renamed from: c */
    public final int f549c;
    /* renamed from: d */
    public final String f550d;
    /* renamed from: e */
    public final String f551e;
    /* renamed from: f */
    public final String f552f;
    /* renamed from: g */
    public final String f553g;
    /* renamed from: h */
    public final int f554h;

    /* renamed from: com.facebook.a.a.a.c$a */
    public enum C0351a {
        ID(1),
        TEXT(2),
        TAG(4),
        DESCRIPTION(8),
        HINT(16);
        
        /* renamed from: g */
        private final int f546g;

        private C0351a(int i) {
            this.f546g = i;
        }

        /* renamed from: a */
        public int m593a() {
            return this.f546g;
        }
    }

    C0352c(JSONObject jSONObject) {
        this.f547a = jSONObject.getString("class_name");
        this.f548b = jSONObject.optInt("index", -1);
        this.f549c = jSONObject.optInt("id");
        this.f550d = jSONObject.optString("text");
        this.f551e = jSONObject.optString("tag");
        this.f552f = jSONObject.optString("description");
        this.f553g = jSONObject.optString("hint");
        this.f554h = jSONObject.optInt("match_bitmask");
    }
}
