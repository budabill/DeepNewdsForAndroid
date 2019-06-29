package com.facebook.internal;

import android.net.Uri;
import java.util.EnumSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.internal.y */
public final class C0503y {
    /* renamed from: a */
    private boolean f921a;
    /* renamed from: b */
    private String f922b;
    /* renamed from: c */
    private boolean f923c;
    /* renamed from: d */
    private boolean f924d;
    /* renamed from: e */
    private int f925e;
    /* renamed from: f */
    private EnumSet<C0471N> f926f;
    /* renamed from: g */
    private Map<String, Map<String, C0502a>> f927g;
    /* renamed from: h */
    private boolean f928h;
    /* renamed from: i */
    private C0498t f929i;
    /* renamed from: j */
    private String f930j;
    /* renamed from: k */
    private String f931k;
    /* renamed from: l */
    private boolean f932l;
    /* renamed from: m */
    private boolean f933m;
    /* renamed from: n */
    private String f934n;
    /* renamed from: o */
    private JSONArray f935o;
    /* renamed from: p */
    private boolean f936p;
    /* renamed from: q */
    private boolean f937q;

    /* renamed from: com.facebook.internal.y$a */
    public static class C0502a {
        /* renamed from: a */
        private String f917a;
        /* renamed from: b */
        private String f918b;
        /* renamed from: c */
        private Uri f919c;
        /* renamed from: d */
        private int[] f920d;

        private C0502a(String str, String str2, Uri uri, int[] iArr) {
            this.f917a = str;
            this.f918b = str2;
            this.f919c = uri;
            this.f920d = iArr;
        }

        /* renamed from: a */
        public static C0502a m1094a(JSONObject jSONObject) {
            String optString = jSONObject.optString("name");
            Uri uri = null;
            if (C0475Q.m998b(optString)) {
                return null;
            }
            String[] split = optString.split("\\|");
            if (split.length != 2) {
                return null;
            }
            String str = split[0];
            optString = split[1];
            if (!C0475Q.m998b(str)) {
                if (!C0475Q.m998b(optString)) {
                    String optString2 = jSONObject.optString("url");
                    if (!C0475Q.m998b(optString2)) {
                        uri = Uri.parse(optString2);
                    }
                    return new C0502a(str, optString, uri, C0502a.m1095a(jSONObject.optJSONArray("versions")));
                }
            }
            return null;
        }

        /* renamed from: a */
        private static int[] m1095a(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            int length = jSONArray.length();
            int[] iArr = new int[length];
            for (int i = 0; i < length; i++) {
                int i2 = -1;
                int optInt = jSONArray.optInt(i, -1);
                if (optInt == -1) {
                    String optString = jSONArray.optString(i);
                    if (!C0475Q.m998b(optString)) {
                        try {
                            i2 = Integer.parseInt(optString);
                        } catch (Exception e) {
                            C0475Q.m983a("FacebookSDK", e);
                        }
                        iArr[i] = i2;
                    }
                }
                i2 = optInt;
                iArr[i] = i2;
            }
            return iArr;
        }

        /* renamed from: a */
        public String m1096a() {
            return this.f917a;
        }

        /* renamed from: b */
        public String m1097b() {
            return this.f918b;
        }
    }

    public C0503y(boolean z, String str, boolean z2, boolean z3, int i, EnumSet<C0471N> enumSet, Map<String, Map<String, C0502a>> map, boolean z4, C0498t c0498t, String str2, String str3, boolean z5, boolean z6, JSONArray jSONArray, String str4, boolean z7, boolean z8) {
        this.f921a = z;
        this.f922b = str;
        this.f923c = z2;
        this.f924d = z3;
        this.f927g = map;
        this.f929i = c0498t;
        this.f925e = i;
        this.f928h = z4;
        this.f926f = enumSet;
        this.f930j = str2;
        this.f931k = str3;
        this.f932l = z5;
        this.f933m = z6;
        this.f935o = jSONArray;
        this.f934n = str4;
        this.f936p = z7;
        this.f937q = z8;
    }

    /* renamed from: a */
    public boolean m1098a() {
        return this.f928h;
    }

    /* renamed from: b */
    public boolean m1099b() {
        return this.f933m;
    }

    /* renamed from: c */
    public boolean m1100c() {
        return this.f937q;
    }

    /* renamed from: d */
    public boolean m1101d() {
        return this.f924d;
    }

    /* renamed from: e */
    public C0498t m1102e() {
        return this.f929i;
    }

    /* renamed from: f */
    public JSONArray m1103f() {
        return this.f935o;
    }

    /* renamed from: g */
    public boolean m1104g() {
        return this.f932l;
    }

    /* renamed from: h */
    public String m1105h() {
        return this.f934n;
    }

    /* renamed from: i */
    public int m1106i() {
        return this.f925e;
    }

    /* renamed from: j */
    public EnumSet<C0471N> m1107j() {
        return this.f926f;
    }

    /* renamed from: k */
    public boolean m1108k() {
        return this.f921a;
    }
}
