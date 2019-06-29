package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareOpenGraphAction.C0926a;

public final class ShareOpenGraphContent extends ShareContent<ShareOpenGraphContent, Object> {
    public static final Creator<ShareOpenGraphContent> CREATOR = new C0556e();
    /* renamed from: g */
    private final ShareOpenGraphAction f1970g;
    /* renamed from: h */
    private final String f1971h;

    ShareOpenGraphContent(Parcel parcel) {
        super(parcel);
        this.f1970g = new C0926a().m2548a(parcel).m2551a();
        this.f1971h = parcel.readString();
    }

    /* renamed from: c */
    public ShareOpenGraphAction m2487c() {
        return this.f1970g;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f1970g, 0);
        parcel.writeString(this.f1971h);
    }
}
