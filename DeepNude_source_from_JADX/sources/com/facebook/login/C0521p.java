package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.login.p */
class C0521p implements Creator {
    C0521p() {
    }

    public GetTokenLoginMethodHandler createFromParcel(Parcel parcel) {
        return new GetTokenLoginMethodHandler(parcel);
    }

    public GetTokenLoginMethodHandler[] newArray(int i) {
        return new GetTokenLoginMethodHandler[i];
    }
}
