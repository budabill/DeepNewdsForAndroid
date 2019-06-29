package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.share.model.f */
class C0557f implements Creator<ShareOpenGraphObject> {
    C0557f() {
    }

    public ShareOpenGraphObject createFromParcel(Parcel parcel) {
        return new ShareOpenGraphObject(parcel);
    }

    public ShareOpenGraphObject[] newArray(int i) {
        return new ShareOpenGraphObject[i];
    }
}
