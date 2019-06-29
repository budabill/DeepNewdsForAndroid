package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.login.j */
class C0518j implements Creator<RequestState> {
    C0518j() {
    }

    public RequestState createFromParcel(Parcel parcel) {
        return new RequestState(parcel);
    }

    public RequestState[] newArray(int i) {
        return new RequestState[i];
    }
}
