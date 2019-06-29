package com.facebook;

import android.content.Context;
import com.facebook.C0560t.C0559a;
import com.facebook.p029a.C0422r;
import java.util.concurrent.Callable;

/* renamed from: com.facebook.r */
class C0543r implements Callable<Void> {
    /* renamed from: a */
    final /* synthetic */ C0559a f1041a;
    /* renamed from: b */
    final /* synthetic */ Context f1042b;

    C0543r(C0559a c0559a, Context context) {
        this.f1041a = c0559a;
        this.f1042b = context;
    }

    public Void call() {
        C0450g.m858d().m866e();
        C0342K.m573b().m576c();
        if (AccessToken.m447l() && Profile.m581c() == null) {
            Profile.m580b();
        }
        C0559a c0559a = this.f1041a;
        if (c0559a != null) {
            c0559a.mo973a();
        }
        C0422r.m790a(C0560t.f1063o, C0560t.f1052d);
        C0422r.m795b(this.f1042b.getApplicationContext()).m809b();
        return null;
    }
}
