package com.facebook.login;

import com.facebook.C0331D;
import com.facebook.C0506l;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest.C0338b;
import com.facebook.p033b.p034a.C0438b;
import org.json.JSONObject;

/* renamed from: com.facebook.login.f */
class C0850f implements C0338b {
    /* renamed from: a */
    final /* synthetic */ DeviceAuthDialog f1789a;

    C0850f(DeviceAuthDialog deviceAuthDialog) {
        this.f1789a = deviceAuthDialog;
    }

    /* renamed from: a */
    public void mo949a(C0331D c0331d) {
        if (!this.f1789a.f1992e.get()) {
            FacebookRequestError a = c0331d.m486a();
            if (a != null) {
                int g = a.m504g();
                if (g != 1349152) {
                    switch (g) {
                        case 1349172:
                        case 1349174:
                            this.f1789a.m2527d();
                            break;
                        case 1349173:
                            break;
                        default:
                            this.f1789a.m2534a(c0331d.m486a().m502e());
                            break;
                    }
                }
                if (this.f1789a.f1995h != null) {
                    C0438b.m835a(this.f1789a.f1995h.m1118d());
                }
                if (this.f1789a.f1999l != null) {
                    DeviceAuthDialog deviceAuthDialog = this.f1789a;
                    deviceAuthDialog.m2535a(deviceAuthDialog.f1999l);
                    return;
                }
                this.f1789a.m2533a();
                return;
            }
            try {
                JSONObject b = c0331d.m487b();
                this.f1789a.m2519a(b.getString("access_token"), Long.valueOf(b.getLong("expires_in")), Long.valueOf(b.optLong("data_access_expiration_time")));
            } catch (Throwable e) {
                this.f1789a.m2534a(new C0506l(e));
            }
        }
    }
}
