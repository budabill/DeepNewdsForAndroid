package com.facebook.login;

import com.facebook.C0331D;
import com.facebook.C0506l;
import com.facebook.GraphRequest.C0338b;
import org.json.JSONObject;

/* renamed from: com.facebook.login.c */
class C0849c implements C0338b {
    /* renamed from: a */
    final /* synthetic */ DeviceAuthDialog f1788a;

    C0849c(DeviceAuthDialog deviceAuthDialog) {
        this.f1788a = deviceAuthDialog;
    }

    /* renamed from: a */
    public void mo949a(C0331D c0331d) {
        if (!this.f1788a.f1997j) {
            if (c0331d.m486a() != null) {
                this.f1788a.m2534a(c0331d.m486a().m502e());
                return;
            }
            JSONObject b = c0331d.m487b();
            RequestState requestState = new RequestState();
            try {
                requestState.m1116b(b.getString("user_code"));
                requestState.m1113a(b.getString("code"));
                requestState.m1112a(b.getLong("interval"));
                this.f1788a.m2512a(requestState);
            } catch (Throwable e) {
                this.f1788a.m2534a(new C0506l(e));
            }
        }
    }
}
