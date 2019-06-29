package com.facebook;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.o */
class C0540o implements Creator<FacebookRequestError> {
    C0540o() {
    }

    public FacebookRequestError createFromParcel(Parcel parcel) {
        return new FacebookRequestError(parcel);
    }

    public FacebookRequestError[] newArray(int i) {
        return new FacebookRequestError[i];
    }
}
