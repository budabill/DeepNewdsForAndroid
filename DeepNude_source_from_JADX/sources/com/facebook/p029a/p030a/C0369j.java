package com.facebook.p029a.p030a;

import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.C0331D;
import com.facebook.C0336G;
import com.facebook.C0560t;
import com.facebook.GraphRequest;
import com.facebook.internal.C0461G;
import com.facebook.internal.C0475Q;
import com.facebook.p029a.p032b.C0382h;
import org.json.JSONObject;

/* renamed from: com.facebook.a.a.j */
class C0369j implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f598a;
    /* renamed from: b */
    final /* synthetic */ C0371l f599b;

    C0369j(C0371l c0371l, String str) {
        this.f599b = c0371l;
        this.f598a = str;
    }

    public void run() {
        String str = "is_app_indexing_enabled";
        String str2 = "success";
        String e = C0560t.m1253e();
        String c = C0475Q.m1000c(this.f598a);
        AccessToken c2 = AccessToken.m446c();
        if (c == null || !c.equals(this.f599b.f606f)) {
            GraphRequest a = C0371l.m648a(this.f598a, c2, e, "app_indexing");
            if (a != null) {
                C0331D b = a.m555b();
                try {
                    JSONObject b2 = b.m487b();
                    if (b2 != null) {
                        if (b2.has(str2) && b2.getString(str2) == "true") {
                            C0461G.m891a(C0336G.APP_EVENTS, C0371l.f601a, "Successfully send UI component tree to server");
                            this.f599b.f606f = c;
                        }
                        if (b2.has(str)) {
                            C0382h.m673c(Boolean.valueOf(b2.getBoolean(str)));
                        }
                    } else {
                        str = C0371l.f601a;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Error sending UI component tree to Facebook: ");
                        stringBuilder.append(b.m486a());
                        Log.e(str, stringBuilder.toString());
                    }
                } catch (Throwable e2) {
                    Log.e(C0371l.f601a, "Error decoding server response.", e2);
                }
            }
        }
    }
}
