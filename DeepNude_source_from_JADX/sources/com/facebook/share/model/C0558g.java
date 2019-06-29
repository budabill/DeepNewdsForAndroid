package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.share.model.g */
class C0558g implements Creator<SharePhoto> {
    C0558g() {
    }

    public SharePhoto createFromParcel(Parcel parcel) {
        return new SharePhoto(parcel);
    }

    public SharePhoto[] newArray(int i) {
        return new SharePhoto[i];
    }
}
