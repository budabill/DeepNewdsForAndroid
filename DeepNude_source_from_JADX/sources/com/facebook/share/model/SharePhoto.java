package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class SharePhoto extends ShareMedia {
    public static final Creator<SharePhoto> CREATOR = new C0558g();
    /* renamed from: b */
    private final Bitmap f1973b;
    /* renamed from: c */
    private final Uri f1974c;
    /* renamed from: d */
    private final boolean f1975d;
    /* renamed from: e */
    private final String f1976e;

    SharePhoto(Parcel parcel) {
        super(parcel);
        this.f1973b = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.f1974c = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f1975d = parcel.readByte() != (byte) 0;
        this.f1976e = parcel.readString();
    }

    /* renamed from: a */
    public Uri m2491a() {
        return this.f1974c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f1973b, 0);
        parcel.writeParcelable(this.f1974c, 0);
        parcel.writeByte((byte) this.f1975d);
        parcel.writeString(this.f1976e);
    }
}
