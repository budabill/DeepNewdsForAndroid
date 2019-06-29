package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment;
import com.facebook.C0451h;
import com.facebook.C0506l;
import com.facebook.internal.C0475Q;
import com.facebook.internal.C0485X;
import com.facebook.internal.C0485X.C0481a;
import com.facebook.internal.C0485X.C0483c;
import com.facebook.internal.C0925p;
import com.facebook.login.LoginClient.Request;

class WebViewLoginMethodHandler extends WebLoginMethodHandler {
    public static final Creator<WebViewLoginMethodHandler> CREATOR = new C0508C();
    /* renamed from: d */
    private C0485X f1960d;
    /* renamed from: e */
    private String f1961e;

    /* renamed from: com.facebook.login.WebViewLoginMethodHandler$a */
    static class C0848a extends C0481a {
        /* renamed from: h */
        private String f1785h;
        /* renamed from: i */
        private String f1786i;
        /* renamed from: j */
        private String f1787j = "fbconnect://success";

        public C0848a(Context context, String str, Bundle bundle) {
            super(context, str, "oauth", bundle);
        }

        /* renamed from: a */
        public C0485X mo966a() {
            Bundle e = m1031e();
            e.putString("redirect_uri", this.f1787j);
            e.putString("client_id", m1028b());
            e.putString("e2e", this.f1785h);
            e.putString("response_type", "token,signed_request");
            e.putString("return_scopes", "true");
            e.putString("auth_type", this.f1786i);
            return C0485X.m1039a(m1029c(), "oauth", e, m1032f(), m1030d());
        }

        /* renamed from: a */
        public C0848a m2201a(String str) {
            this.f1786i = str;
            return this;
        }

        /* renamed from: a */
        public C0848a m2202a(boolean z) {
            this.f1787j = z ? "fbconnect://chrome_os_success" : "fbconnect://success";
            return this;
        }

        /* renamed from: b */
        public C0848a m2203b(String str) {
            this.f1785h = str;
            return this;
        }
    }

    WebViewLoginMethodHandler(Parcel parcel) {
        super(parcel);
        this.f1961e = parcel.readString();
    }

    WebViewLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    /* renamed from: a */
    void mo964a() {
        C0485X c0485x = this.f1960d;
        if (c0485x != null) {
            c0485x.cancel();
            this.f1960d = null;
        }
    }

    /* renamed from: a */
    boolean mo961a(Request request) {
        Bundle b = m2197b(request);
        C0483c c0847b = new C0847B(this, request);
        this.f1961e = LoginClient.m1143e();
        m1175a("e2e", this.f1961e);
        Context c = this.f980b.m1158c();
        boolean e = C0475Q.m1009e(c);
        C0481a c0848a = new C0848a(c, request.m1120a(), b);
        c0848a.m2203b(this.f1961e);
        c0848a.m2202a(e);
        c0848a.m2201a(request.m1123c());
        c0848a.m1026a(c0847b);
        this.f1960d = c0848a.mo966a();
        Fragment c0925p = new C0925p();
        c0925p.setRetainInstance(true);
        c0925p.m2511a(this.f1960d);
        c0925p.show(c.getSupportFragmentManager(), "FacebookDialogFragment");
        return true;
    }

    /* renamed from: b */
    String mo962b() {
        return "web_view";
    }

    /* renamed from: b */
    void m2471b(Request request, Bundle bundle, C0506l c0506l) {
        super.m2196a(request, bundle, c0506l);
    }

    /* renamed from: c */
    boolean mo1608c() {
        return true;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    C0451h mo1607e() {
        return C0451h.WEB_VIEW;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f1961e);
    }
}
