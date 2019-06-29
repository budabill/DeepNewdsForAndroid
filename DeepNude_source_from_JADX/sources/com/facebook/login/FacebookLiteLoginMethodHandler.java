package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.internal.C0465I;
import com.facebook.login.LoginClient.Request;

class FacebookLiteLoginMethodHandler extends NativeAppLoginMethodHandler {
    public static final Creator<FacebookLiteLoginMethodHandler> CREATOR = new C0520l();

    FacebookLiteLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }

    FacebookLiteLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    /* renamed from: a */
    boolean mo961a(Request request) {
        String e = LoginClient.m1143e();
        Intent a = C0465I.m914a(this.f980b.m1158c(), request.m1120a(), request.m1128h(), e, request.m1130j(), request.m1129i(), request.m1124d(), m1172a(request.m1122b()), request.m1123c());
        m1175a("e2e", e);
        return m2191a(a, LoginClient.m1144h());
    }

    /* renamed from: b */
    String mo962b() {
        return "fb_lite_login";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
