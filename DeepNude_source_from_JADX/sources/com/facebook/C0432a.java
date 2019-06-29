package com.facebook;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.a */
class C0432a implements Creator {
    C0432a() {
    }

    public AccessToken createFromParcel(Parcel parcel) {
        return new AccessToken(parcel);
    }

    public AccessToken[] newArray(int i) {
        return new AccessToken[i];
    }
}
