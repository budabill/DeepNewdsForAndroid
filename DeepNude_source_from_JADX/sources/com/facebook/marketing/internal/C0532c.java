package com.facebook.marketing.internal;

import android.view.View;
import com.facebook.C0560t;
import com.facebook.marketing.internal.C0533d.C0858a;

/* renamed from: com.facebook.marketing.internal.c */
class C0532c implements Runnable {
    /* renamed from: a */
    final /* synthetic */ View f1027a;
    /* renamed from: b */
    final /* synthetic */ String f1028b;
    /* renamed from: c */
    final /* synthetic */ C0858a f1029c;

    C0532c(C0858a c0858a, View view, String str) {
        this.f1029c = c0858a;
        this.f1027a = view;
        this.f1028b = str;
    }

    public void run() {
        C0535f.m1212a(C0560t.m1253e(), this.f1027a, this.f1028b, C0560t.m1252d());
    }
}
