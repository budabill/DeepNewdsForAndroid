package com.facebook.applinks;

import android.content.Context;
import com.facebook.applinks.C0435b.C0434a;

/* renamed from: com.facebook.applinks.a */
class C0433a implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f744a;
    /* renamed from: b */
    final /* synthetic */ String f745b;
    /* renamed from: c */
    final /* synthetic */ C0434a f746c;

    C0433a(Context context, String str, C0434a c0434a) {
        this.f744a = context;
        this.f745b = str;
        this.f746c = c0434a;
    }

    public void run() {
        C0435b.m831c(this.f744a, this.f745b, this.f746c);
    }
}
