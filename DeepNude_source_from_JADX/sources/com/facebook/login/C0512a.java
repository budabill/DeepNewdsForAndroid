package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.login.a */
class C0512a implements Creator {
    C0512a() {
    }

    public CustomTabLoginMethodHandler createFromParcel(Parcel parcel) {
        return new CustomTabLoginMethodHandler(parcel);
    }

    public CustomTabLoginMethodHandler[] newArray(int i) {
        return new CustomTabLoginMethodHandler[i];
    }
}
