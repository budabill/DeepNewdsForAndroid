package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.share.model.d */
class C0555d implements Creator<ShareOpenGraphAction> {
    C0555d() {
    }

    public ShareOpenGraphAction createFromParcel(Parcel parcel) {
        return new ShareOpenGraphAction(parcel);
    }

    public ShareOpenGraphAction[] newArray(int i) {
        return new ShareOpenGraphAction[i];
    }
}
