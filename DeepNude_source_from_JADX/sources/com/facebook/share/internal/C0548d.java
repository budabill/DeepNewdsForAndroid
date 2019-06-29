package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.share.internal.d */
class C0548d implements Creator<RequestState> {
    C0548d() {
    }

    public RequestState createFromParcel(Parcel parcel) {
        return new RequestState(parcel);
    }

    public RequestState[] newArray(int i) {
        return new RequestState[i];
    }
}
