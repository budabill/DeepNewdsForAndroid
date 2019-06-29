package com.facebook.marketing.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.C0560t;
import com.facebook.p029a.C0422r;

/* renamed from: com.facebook.marketing.internal.h */
public final class C0536h {
    /* renamed from: a */
    private final C0422r f1036a;

    public C0536h(Context context, String str) {
        this.f1036a = C0422r.m796b(context, str);
    }

    /* renamed from: a */
    public void m1214a() {
        if (!C0560t.m1254f()) {
            return;
        }
        if (C0560t.m1257i()) {
            Bundle bundle = new Bundle();
            bundle.putString("_codeless_action", "sdk_initialized");
            this.f1036a.m806a("fb_codeless_debug", null, bundle);
        }
    }
}
