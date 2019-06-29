package com.facebook;

import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.facebook.GraphRequest.C0338b;
import com.facebook.internal.C0475Q;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.d */
class C0826d implements C0338b {
    /* renamed from: a */
    final /* synthetic */ AtomicBoolean f1755a;
    /* renamed from: b */
    final /* synthetic */ Set f1756b;
    /* renamed from: c */
    final /* synthetic */ Set f1757c;
    /* renamed from: d */
    final /* synthetic */ C0450g f1758d;

    C0826d(C0450g c0450g, AtomicBoolean atomicBoolean, Set set, Set set2) {
        this.f1758d = c0450g;
        this.f1755a = atomicBoolean;
        this.f1756b = set;
        this.f1757c = set2;
    }

    /* renamed from: a */
    public void mo949a(C0331D c0331d) {
        JSONObject b = c0331d.m487b();
        if (b != null) {
            JSONArray optJSONArray = b.optJSONArray("data");
            if (optJSONArray != null) {
                this.f1755a.set(true);
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("permission");
                        String optString2 = optJSONObject.optString(NotificationCompat.CATEGORY_STATUS);
                        if (!(C0475Q.m998b(optString) || C0475Q.m998b(optString2))) {
                            Set set;
                            optString2 = optString2.toLowerCase(Locale.US);
                            if (optString2.equals("granted")) {
                                set = this.f1756b;
                            } else if (optString2.equals("declined")) {
                                set = this.f1757c;
                            } else {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Unexpected status: ");
                                stringBuilder.append(optString2);
                                Log.w("AccessTokenManager", stringBuilder.toString());
                            }
                            set.add(optString);
                        }
                    }
                }
            }
        }
    }
}
