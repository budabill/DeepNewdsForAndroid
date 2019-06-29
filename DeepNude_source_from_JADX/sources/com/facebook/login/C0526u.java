package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.login.LoginClient.Result;

/* renamed from: com.facebook.login.u */
class C0526u implements Creator<Result> {
    C0526u() {
    }

    public Result createFromParcel(Parcel parcel) {
        return new Result(parcel);
    }

    public Result[] newArray(int i) {
        return new Result[i];
    }
}
