package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.login.l */
class C0520l implements Creator<FacebookLiteLoginMethodHandler> {
    C0520l() {
    }

    public FacebookLiteLoginMethodHandler createFromParcel(Parcel parcel) {
        return new FacebookLiteLoginMethodHandler(parcel);
    }

    public FacebookLiteLoginMethodHandler[] newArray(int i) {
        return new FacebookLiteLoginMethodHandler[i];
    }
}
