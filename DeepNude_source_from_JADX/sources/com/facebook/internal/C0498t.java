package com.facebook.internal;

import com.facebook.FacebookRequestError.C0334a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.internal.t */
public final class C0498t {
    /* renamed from: a */
    private static C0498t f906a;
    /* renamed from: b */
    private final Map<Integer, Set<Integer>> f907b;
    /* renamed from: c */
    private final Map<Integer, Set<Integer>> f908c;
    /* renamed from: d */
    private final Map<Integer, Set<Integer>> f909d;
    /* renamed from: e */
    private final String f910e;
    /* renamed from: f */
    private final String f911f;
    /* renamed from: g */
    private final String f912g;

    C0498t(Map<Integer, Set<Integer>> map, Map<Integer, Set<Integer>> map2, Map<Integer, Set<Integer>> map3, String str, String str2, String str3) {
        this.f907b = map;
        this.f908c = map2;
        this.f909d = map3;
        this.f910e = str;
        this.f911f = str2;
        this.f912g = str3;
    }

    /* renamed from: a */
    public static synchronized C0498t m1083a() {
        C0498t c0498t;
        synchronized (C0498t.class) {
            if (f906a == null) {
                f906a = C0498t.m1086b();
            }
            c0498t = f906a;
        }
        return c0498t;
    }

    /* renamed from: a */
    public static C0498t m1084a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        Map map = null;
        Map map2 = map;
        Map map3 = map2;
        String str = map3;
        String str2 = str;
        String str3 = str2;
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("name");
                if (optString != null) {
                    String str4 = "recovery_message";
                    if (optString.equalsIgnoreCase("other")) {
                        str = optJSONObject.optString(str4, null);
                        map = C0498t.m1085a(optJSONObject);
                    } else if (optString.equalsIgnoreCase("transient")) {
                        str2 = optJSONObject.optString(str4, null);
                        map2 = C0498t.m1085a(optJSONObject);
                    } else if (optString.equalsIgnoreCase("login_recoverable")) {
                        str3 = optJSONObject.optString(str4, null);
                        map3 = C0498t.m1085a(optJSONObject);
                    }
                }
            }
        }
        return new C0498t(map, map2, map3, str, str2, str3);
    }

    /* renamed from: a */
    private static Map<Integer, Set<Integer>> m1085a(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        if (optJSONArray.length() == 0) {
            return null;
        }
        Map<Integer, Set<Integer>> hashMap = new HashMap();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                int optInt = optJSONObject.optInt("code");
                if (optInt != 0) {
                    Object obj;
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("subcodes");
                    if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                        obj = null;
                    } else {
                        obj = new HashSet();
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            int optInt2 = optJSONArray2.optInt(i2);
                            if (optInt2 != 0) {
                                obj.add(Integer.valueOf(optInt2));
                            }
                        }
                    }
                    hashMap.put(Integer.valueOf(optInt), obj);
                }
            }
        }
        return hashMap;
    }

    /* renamed from: b */
    private static C0498t m1086b() {
        return new C0498t(null, new C0495q(), new C0496r(), null, null, null);
    }

    /* renamed from: a */
    public C0334a m1087a(int i, int i2, boolean z) {
        if (z) {
            return C0334a.TRANSIENT;
        }
        Set set;
        Map map = this.f907b;
        if (map != null && map.containsKey(Integer.valueOf(i))) {
            set = (Set) this.f907b.get(Integer.valueOf(i));
            if (set == null || set.contains(Integer.valueOf(i2))) {
                return C0334a.OTHER;
            }
        }
        map = this.f909d;
        if (map != null && map.containsKey(Integer.valueOf(i))) {
            set = (Set) this.f909d.get(Integer.valueOf(i));
            if (set == null || set.contains(Integer.valueOf(i2))) {
                return C0334a.LOGIN_RECOVERABLE;
            }
        }
        map = this.f908c;
        if (map != null && map.containsKey(Integer.valueOf(i))) {
            Set set2 = (Set) this.f908c.get(Integer.valueOf(i));
            if (set2 == null || set2.contains(Integer.valueOf(i2))) {
                return C0334a.TRANSIENT;
            }
        }
        return C0334a.OTHER;
    }

    /* renamed from: a */
    public String m1088a(C0334a c0334a) {
        int i = C0497s.f905a[c0334a.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? null : this.f911f : this.f912g : this.f910e;
    }
}
