package com.facebook.login;

import android.os.Bundle;
import com.facebook.internal.C0468K.C0467a;
import com.facebook.login.LoginClient.Request;

/* renamed from: com.facebook.login.n */
class C0853n implements C0467a {
    /* renamed from: a */
    final /* synthetic */ Request f1794a;
    /* renamed from: b */
    final /* synthetic */ GetTokenLoginMethodHandler f1795b;

    C0853n(GetTokenLoginMethodHandler getTokenLoginMethodHandler, Request request) {
        this.f1795b = getTokenLoginMethodHandler;
        this.f1794a = request;
    }

    /* renamed from: a */
    public void mo968a(Bundle bundle) {
        this.f1795b.m2184b(this.f1794a, bundle);
    }
}
