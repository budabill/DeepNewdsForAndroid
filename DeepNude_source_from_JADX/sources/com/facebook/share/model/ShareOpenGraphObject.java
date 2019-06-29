package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ShareOpenGraphObject extends ShareOpenGraphValueContainer<ShareOpenGraphObject, Object> {
    public static final Creator<ShareOpenGraphObject> CREATOR = new C0557f();

    ShareOpenGraphObject(Parcel parcel) {
        super(parcel);
    }
}
