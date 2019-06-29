package com.facebook.login;

import android.os.Bundle;
import com.facebook.C0506l;
import com.facebook.internal.C0485X.C0483c;
import com.facebook.login.LoginClient.Request;

/* renamed from: com.facebook.login.B */
class C0847B implements C0483c {
    /* renamed from: a */
    final /* synthetic */ Request f1780a;
    /* renamed from: b */
    final /* synthetic */ WebViewLoginMethodHandler f1781b;

    C0847B(WebViewLoginMethodHandler webViewLoginMethodHandler, Request request) {
        this.f1781b = webViewLoginMethodHandler;
        this.f1780a = request;
    }

    /* renamed from: a */
    public void mo957a(Bundle bundle, C0506l c0506l) {
        this.f1781b.m2471b(this.f1780a, bundle, c0506l);
    }
}
