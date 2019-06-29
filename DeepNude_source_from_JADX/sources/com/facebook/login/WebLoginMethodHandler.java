package com.facebook.login;

import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.C0451h;
import com.facebook.C0506l;
import com.facebook.C0560t;
import com.facebook.C0860n;
import com.facebook.C0865v;
import com.facebook.FacebookRequestError;
import com.facebook.internal.C0475Q;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import java.util.Locale;

abstract class WebLoginMethodHandler extends LoginMethodHandler {
    /* renamed from: c */
    private String f1784c;

    WebLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }

    WebLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    /* renamed from: d */
    private void m2192d(String str) {
        this.f980b.m1158c().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).edit().putString("TOKEN", str).apply();
    }

    /* renamed from: f */
    private static final String m2193f() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fb");
        stringBuilder.append(C0560t.m1253e());
        stringBuilder.append("://authorize");
        return stringBuilder.toString();
    }

    /* renamed from: g */
    private String m2194g() {
        return this.f980b.m1158c().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).getString("TOKEN", "");
    }

    /* renamed from: a */
    protected Bundle m2195a(Bundle bundle, Request request) {
        bundle.putString("redirect_uri", m2193f());
        bundle.putString("client_id", request.m1120a());
        LoginClient loginClient = this.f980b;
        bundle.putString("e2e", LoginClient.m1143e());
        bundle.putString("response_type", "token,signed_request");
        bundle.putString("return_scopes", "true");
        bundle.putString("auth_type", request.m1123c());
        if (mo1606d() != null) {
            bundle.putString("sso", mo1606d());
        }
        return bundle;
    }

    /* renamed from: a */
    protected void m2196a(Request request, Bundle bundle, C0506l c0506l) {
        Result a;
        this.f1784c = null;
        if (bundle != null) {
            String str = "e2e";
            if (bundle.containsKey(str)) {
                this.f1784c = bundle.getString(str);
            }
            try {
                AccessToken a2 = LoginMethodHandler.m1170a(request.m1128h(), bundle, mo1607e(), request.m1120a());
                a = Result.m1132a(this.f980b.m1164i(), a2);
                CookieSyncManager.createInstance(this.f980b.m1158c()).sync();
                m2192d(a2.m456j());
            } catch (RuntimeException e) {
                a = Result.m1134a(this.f980b.m1164i(), null, e.getMessage());
            }
        } else if (c0506l instanceof C0860n) {
            a = Result.m1133a(this.f980b.m1164i(), "User canceled log in.");
        } else {
            String format;
            this.f1784c = null;
            String message = c0506l.getMessage();
            if (c0506l instanceof C0865v) {
                FacebookRequestError a3 = ((C0865v) c0506l).m2225a();
                format = String.format(Locale.ROOT, "%d", new Object[]{Integer.valueOf(a3.m499b())});
                message = a3.toString();
            } else {
                format = null;
            }
            a = Result.m1135a(this.f980b.m1164i(), null, message, format);
        }
        if (!C0475Q.m998b(this.f1784c)) {
            m1180c(this.f1784c);
        }
        this.f980b.m1155b(a);
    }

    /* renamed from: b */
    protected Bundle m2197b(Request request) {
        String join;
        Object obj;
        Bundle bundle = new Bundle();
        if (!C0475Q.m992a(request.m1128h())) {
            join = TextUtils.join(",", request.m1128h());
            String str = "scope";
            bundle.putString(str, join);
            m1175a(str, join);
        }
        bundle.putString("default_audience", request.m1124d().m1182a());
        bundle.putString("state", m1172a(request.m1122b()));
        AccessToken c = AccessToken.m446c();
        String j = c != null ? c.m456j() : null;
        join = "access_token";
        if (j == null || !j.equals(m2194g())) {
            C0475Q.m976a(this.f980b.m1158c());
            obj = "0";
        } else {
            bundle.putString(join, j);
            obj = "1";
        }
        m1175a(join, obj);
        return bundle;
    }

    /* renamed from: d */
    protected String mo1606d() {
        return null;
    }

    /* renamed from: e */
    abstract C0451h mo1607e();
}
