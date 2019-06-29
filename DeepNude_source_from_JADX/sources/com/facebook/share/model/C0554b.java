package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.share.model.b */
class C0554b implements Creator<ShareLinkContent> {
    C0554b() {
    }

    public ShareLinkContent createFromParcel(Parcel parcel) {
        return new ShareLinkContent(parcel);
    }

    public ShareLinkContent[] newArray(int i) {
        return new ShareLinkContent[i];
    }
}
