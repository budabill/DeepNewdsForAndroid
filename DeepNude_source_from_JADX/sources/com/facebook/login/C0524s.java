package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.login.s */
class C0524s implements Creator<LoginClient> {
    C0524s() {
    }

    public LoginClient createFromParcel(Parcel parcel) {
        return new LoginClient(parcel);
    }

    public LoginClient[] newArray(int i) {
        return new LoginClient[i];
    }
}
