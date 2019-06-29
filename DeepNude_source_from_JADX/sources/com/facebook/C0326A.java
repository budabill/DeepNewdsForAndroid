package com.facebook;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.GraphRequest.ParcelableResourceWithMimeType;

/* renamed from: com.facebook.A */
class C0326A implements Creator<ParcelableResourceWithMimeType> {
    C0326A() {
    }

    public ParcelableResourceWithMimeType createFromParcel(Parcel parcel) {
        return new ParcelableResourceWithMimeType(parcel);
    }

    public ParcelableResourceWithMimeType[] newArray(int i) {
        return new ParcelableResourceWithMimeType[i];
    }
}
