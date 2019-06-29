package com.facebook.p029a.p032b;

import android.content.Context;
import android.support.v4.app.NotificationCompat;
import com.facebook.C0336G;
import com.facebook.internal.C0461G;
import com.facebook.internal.C0475Q;
import com.facebook.internal.C0489b;
import com.facebook.p029a.C0422r;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.facebook.a.b.k */
public class C0386k {
    /* renamed from: a */
    private static final Map<C0385a, String> f635a = new C0384j();

    /* renamed from: com.facebook.a.b.k$a */
    public enum C0385a {
        MOBILE_INSTALL_EVENT,
        CUSTOM_APP_EVENTS
    }

    /* renamed from: a */
    public static JSONObject m693a(C0385a c0385a, C0489b c0489b, String str, boolean z, Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, f635a.get(c0385a));
        String g = C0422r.m801g();
        if (g != null) {
            jSONObject.put("app_user_id", g);
        }
        g = C0422r.m800f();
        if (g != null) {
            jSONObject.put("ud", g);
        }
        C0475Q.m988a(jSONObject, c0489b, str, z);
        try {
            C0475Q.m987a(jSONObject, context);
        } catch (Exception e) {
            C0461G.m892a(C0336G.APP_EVENTS, "AppEvents", "Fetching extended device info parameters failed: '%s'", e.toString());
        }
        jSONObject.put("application_package_name", context.getPackageName());
        return jSONObject;
    }
}
