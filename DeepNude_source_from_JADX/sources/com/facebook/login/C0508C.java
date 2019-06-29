package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.login.C */
class C0508C implements Creator<WebViewLoginMethodHandler> {
    C0508C() {
    }

    public WebViewLoginMethodHandler createFromParcel(Parcel parcel) {
        return new WebViewLoginMethodHandler(parcel);
    }

    public WebViewLoginMethodHandler[] newArray(int i) {
        return new WebViewLoginMethodHandler[i];
    }
}
