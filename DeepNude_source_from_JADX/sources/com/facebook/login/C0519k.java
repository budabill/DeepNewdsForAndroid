package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.login.k */
class C0519k implements Creator {
    C0519k() {
    }

    public DeviceAuthMethodHandler createFromParcel(Parcel parcel) {
        return new DeviceAuthMethodHandler(parcel);
    }

    public DeviceAuthMethodHandler[] newArray(int i) {
        return new DeviceAuthMethodHandler[i];
    }
}
