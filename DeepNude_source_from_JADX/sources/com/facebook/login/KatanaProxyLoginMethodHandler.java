package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.internal.C0465I;
import com.facebook.login.LoginClient.Request;

class KatanaProxyLoginMethodHandler extends NativeAppLoginMethodHandler {
    public static final Creator<KatanaProxyLoginMethodHandler> CREATOR = new C0522q();

    KatanaProxyLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }

    KatanaProxyLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    /* renamed from: a */
    boolean mo961a(Request request) {
        String e = LoginClient.m1143e();
        Intent b = C0465I.m924b(this.f980b.m1158c(), request.m1120a(), request.m1128h(), e, request.m1130j(), request.m1129i(), request.m1124d(), m1172a(request.m1122b()), request.m1123c());
        m1175a("e2e", e);
        return m2191a(b, LoginClient.m1144h());
    }

    /* renamed from: b */
    String mo962b() {
        return "katana_proxy_auth";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
