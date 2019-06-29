package com.facebook.internal;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.C0560t;
import p000a.p005b.p007b.C0024i;
import p000a.p005b.p007b.C0024i.C0023a;

/* renamed from: com.facebook.internal.m */
public class C0494m {
    /* renamed from: a */
    private Uri f904a;

    public C0494m(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        String b = C0470M.m947b();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C0560t.m1260l());
        stringBuilder.append("/");
        stringBuilder.append("dialog/");
        stringBuilder.append(str);
        this.f904a = C0475Q.m959a(b, stringBuilder.toString(), bundle);
    }

    /* renamed from: a */
    public void m1082a(Activity activity, String str) {
        C0024i a = new C0023a().m19a();
        a.f31a.setPackage(str);
        a.f31a.addFlags(1073741824);
        a.m20a(activity, this.f904a);
    }
}
