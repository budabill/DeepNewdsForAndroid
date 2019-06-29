package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.login.q */
class C0522q implements Creator<KatanaProxyLoginMethodHandler> {
    C0522q() {
    }

    public KatanaProxyLoginMethodHandler createFromParcel(Parcel parcel) {
        return new KatanaProxyLoginMethodHandler(parcel);
    }

    public KatanaProxyLoginMethodHandler[] newArray(int i) {
        return new KatanaProxyLoginMethodHandler[i];
    }
}
