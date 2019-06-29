package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.share.model.a */
class C0553a implements Creator<ShareHashtag> {
    C0553a() {
    }

    public ShareHashtag createFromParcel(Parcel parcel) {
        return new ShareHashtag(parcel);
    }

    public ShareHashtag[] newArray(int i) {
        return new ShareHashtag[i];
    }
}
