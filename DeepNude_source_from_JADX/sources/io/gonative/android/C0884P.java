package io.gonative.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.onesignal.C0600O;
import com.onesignal.C0603Q;
import com.onesignal.sa.C0651j;
import org.json.JSONObject;

/* renamed from: io.gonative.android.P */
public class C0884P implements C0651j {
    /* renamed from: a */
    private Context f1871a;

    C0884P(Context context) {
        this.f1871a = context;
    }

    /* renamed from: a */
    public void mo1409a(C0603Q c0603q) {
        Intent intent;
        C0600O c0600o = c0603q.f1178a;
        String str = c0600o.f1160d.f1196k;
        if (str == null || str.isEmpty()) {
            JSONObject jSONObject = c0600o.f1160d.f1191f;
            str = "targetUrl";
            String a = C0726s.m1968a(jSONObject, str);
            if (a == null) {
                a = C0726s.m1968a(jSONObject, "u");
            }
            intent = new Intent(this.f1871a, MainActivity.class);
            intent.setFlags(872415232);
            if (!(a == null || a.isEmpty())) {
                intent.putExtra(str, a);
            }
        } else {
            intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        }
        this.f1871a.startActivity(intent);
    }
}
