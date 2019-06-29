package com.facebook;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.I */
class C0340I implements Creator<Profile> {
    C0340I() {
    }

    public Profile createFromParcel(Parcel parcel) {
        return new Profile(parcel);
    }

    public Profile[] newArray(int i) {
        return new Profile[i];
    }
}
