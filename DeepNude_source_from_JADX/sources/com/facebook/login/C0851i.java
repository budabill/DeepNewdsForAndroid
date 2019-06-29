package com.facebook.login;

import com.facebook.C0331D;
import com.facebook.C0506l;
import com.facebook.C0560t;
import com.facebook.GraphRequest.C0338b;
import com.facebook.internal.C0457C;
import com.facebook.internal.C0471N;
import com.facebook.internal.C0475Q;
import com.facebook.internal.C0475Q.C0474b;
import com.facebook.p033b.p034a.C0438b;
import java.util.Date;
import org.json.JSONObject;

/* renamed from: com.facebook.login.i */
class C0851i implements C0338b {
    /* renamed from: a */
    final /* synthetic */ String f1790a;
    /* renamed from: b */
    final /* synthetic */ Date f1791b;
    /* renamed from: c */
    final /* synthetic */ Date f1792c;
    /* renamed from: d */
    final /* synthetic */ DeviceAuthDialog f1793d;

    C0851i(DeviceAuthDialog deviceAuthDialog, String str, Date date, Date date2) {
        this.f1793d = deviceAuthDialog;
        this.f1790a = str;
        this.f1791b = date;
        this.f1792c = date2;
    }

    /* renamed from: a */
    public void mo949a(C0331D c0331d) {
        if (!this.f1793d.f1992e.get()) {
            if (c0331d.m486a() != null) {
                this.f1793d.m2534a(c0331d.m486a().m502e());
                return;
            }
            try {
                JSONObject b = c0331d.m487b();
                String string = b.getString("id");
                C0474b a = C0475Q.m960a(b);
                String string2 = b.getString("name");
                C0438b.m835a(this.f1793d.f1995h.m1118d());
                if (!C0457C.m876b(C0560t.m1253e()).m1107j().contains(C0471N.RequireConfirm) || this.f1793d.f1998k) {
                    this.f1793d.m2518a(string, a, this.f1790a, this.f1791b, this.f1792c);
                    return;
                }
                this.f1793d.f1998k = true;
                this.f1793d.m2517a(string, a, this.f1790a, string2, this.f1791b, this.f1792c);
            } catch (Throwable e) {
                this.f1793d.m2534a(new C0506l(e));
            }
        }
    }
}
