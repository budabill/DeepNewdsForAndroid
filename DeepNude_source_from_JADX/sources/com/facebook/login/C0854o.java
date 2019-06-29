package com.facebook.login;

import android.os.Bundle;
import com.facebook.C0506l;
import com.facebook.internal.C0475Q.C0473a;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.login.o */
class C0854o implements C0473a {
    /* renamed from: a */
    final /* synthetic */ Bundle f1796a;
    /* renamed from: b */
    final /* synthetic */ Request f1797b;
    /* renamed from: c */
    final /* synthetic */ GetTokenLoginMethodHandler f1798c;

    C0854o(GetTokenLoginMethodHandler getTokenLoginMethodHandler, Bundle bundle, Request request) {
        this.f1798c = getTokenLoginMethodHandler;
        this.f1796a = bundle;
        this.f1797b = request;
    }

    /* renamed from: a */
    public void mo946a(C0506l c0506l) {
        LoginClient loginClient = this.f1798c.f980b;
        loginClient.m1151a(Result.m1134a(loginClient.m1164i(), "Caught exception", c0506l.getMessage()));
    }

    /* renamed from: a */
    public void mo947a(JSONObject jSONObject) {
        try {
            this.f1796a.putString("com.facebook.platform.extra.USER_ID", jSONObject.getString("id"));
            this.f1798c.m2185c(this.f1797b, this.f1796a);
        } catch (JSONException e) {
            LoginClient loginClient = this.f1798c.f980b;
            loginClient.m1151a(Result.m1134a(loginClient.m1164i(), "Caught exception", e.getMessage()));
        }
    }
}
