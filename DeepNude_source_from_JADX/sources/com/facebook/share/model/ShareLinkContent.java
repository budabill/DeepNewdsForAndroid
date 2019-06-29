package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ShareLinkContent extends ShareContent<ShareLinkContent, Object> {
    public static final Creator<ShareLinkContent> CREATOR = new C0554b();
    @Deprecated
    /* renamed from: g */
    private final String f1966g;
    @Deprecated
    /* renamed from: h */
    private final String f1967h;
    @Deprecated
    /* renamed from: i */
    private final Uri f1968i;
    /* renamed from: j */
    private final String f1969j;

    ShareLinkContent(Parcel parcel) {
        super(parcel);
        this.f1966g = parcel.readString();
        this.f1967h = parcel.readString();
        this.f1968i = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f1969j = parcel.readString();
    }

    /* renamed from: c */
    public String m2485c() {
        return this.f1969j;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f1966g);
        parcel.writeString(this.f1967h);
        parcel.writeParcelable(this.f1968i, 0);
        parcel.writeString(this.f1969j);
    }
}
