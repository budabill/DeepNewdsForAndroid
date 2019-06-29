package io.gonative.android;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class fa {
    /* renamed from: a */
    private static final String f1601a = "io.gonative.android.fa";
    /* renamed from: b */
    public List<C0715b> f1602b;

    /* renamed from: io.gonative.android.fa$a */
    public static class C0714a {
        /* renamed from: a */
        public String f1596a;
        /* renamed from: b */
        public String f1597b;
        /* renamed from: c */
        public boolean f1598c;
    }

    /* renamed from: io.gonative.android.fa$b */
    public static class C0715b {
        /* renamed from: a */
        public String f1599a;
        /* renamed from: b */
        public List<C0714a> f1600b;
    }

    /* renamed from: a */
    public static fa m1930a(String str) {
        String str2 = "name";
        try {
            JSONObject jSONObject = new JSONObject(str);
            fa faVar = new fa();
            faVar.f1602b = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("sections");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        C0715b c0715b = new C0715b();
                        c0715b.f1599a = optJSONObject.optString(str2);
                        c0715b.f1600b = new ArrayList();
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("items");
                        if (optJSONArray2 != null) {
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                                if (optJSONObject2 != null) {
                                    C0714a c0714a = new C0714a();
                                    c0714a.f1596a = optJSONObject2.optString("identifier");
                                    c0714a.f1597b = optJSONObject2.optString(str2);
                                    c0714a.f1598c = false;
                                    c0715b.f1600b.add(c0714a);
                                }
                            }
                        }
                        faVar.f1602b.add(c0715b);
                    }
                }
            }
            return faVar;
        } catch (Throwable e) {
            Log.e(f1601a, "Error parsing JSON for subscriptions", e);
            return null;
        }
    }
}
