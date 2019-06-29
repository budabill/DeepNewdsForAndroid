package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.share.model.e */
class C0556e implements Creator<ShareOpenGraphContent> {
    C0556e() {
    }

    public ShareOpenGraphContent createFromParcel(Parcel parcel) {
        return new ShareOpenGraphContent(parcel);
    }

    public ShareOpenGraphContent[] newArray(int i) {
        return new ShareOpenGraphContent[i];
    }
}
