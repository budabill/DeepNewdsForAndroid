package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.facebook.internal.C0457C.C0455a;
import com.facebook.p029a.p032b.C0389m;
import com.facebook.p029a.p032b.C0395s;
import org.json.JSONObject;

/* renamed from: com.facebook.internal.z */
class C0504z implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f938a;
    /* renamed from: b */
    final /* synthetic */ String f939b;
    /* renamed from: c */
    final /* synthetic */ String f940c;

    C0504z(Context context, String str, String str2) {
        this.f938a = context;
        this.f939b = str;
        this.f940c = str2;
    }

    public void run() {
        SharedPreferences sharedPreferences = this.f938a.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0);
        C0503y c0503y = null;
        String string = sharedPreferences.getString(this.f939b, null);
        if (!C0475Q.m998b(string)) {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject(string);
            } catch (Exception e) {
                C0475Q.m983a("FacebookSDK", e);
                jSONObject = null;
            }
            if (jSONObject != null) {
                c0503y = C0457C.m877b(this.f940c, jSONObject);
            }
        }
        JSONObject a = C0457C.m880c(this.f940c);
        if (a != null) {
            C0457C.m877b(this.f940c, a);
            sharedPreferences.edit().putString(this.f939b, a.toString()).apply();
        }
        if (c0503y != null) {
            string = c0503y.m1105h();
            if (!(C0457C.f798f || string == null || string.length() <= 0)) {
                C0457C.f798f = true;
                Log.w(C0457C.f793a, string);
            }
        }
        C0501x.m1093a(this.f940c, true);
        C0389m.m699b();
        C0395s.m708c();
        C0457C.f796d.set(C0457C.f795c.containsKey(this.f940c) ? C0455a.SUCCESS : C0455a.ERROR);
        C0457C.m884g();
    }
}
