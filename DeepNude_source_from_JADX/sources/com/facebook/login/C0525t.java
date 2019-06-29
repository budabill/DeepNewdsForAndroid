package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.login.LoginClient.Request;

/* renamed from: com.facebook.login.t */
class C0525t implements Creator<Request> {
    C0525t() {
    }

    public Request createFromParcel(Parcel parcel) {
        return new Request(parcel);
    }

    public Request[] newArray(int i) {
        return new Request[i];
    }
}
