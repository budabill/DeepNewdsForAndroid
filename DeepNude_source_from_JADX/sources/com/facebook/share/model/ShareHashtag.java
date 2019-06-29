package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class ShareHashtag implements ShareModel {
    public static final Creator<ShareHashtag> CREATOR = new C0553a();
    /* renamed from: a */
    private final String f1813a;

    /* renamed from: com.facebook.share.model.ShareHashtag$a */
    public static class C0917a implements C0863c<ShareHashtag, C0917a> {
        /* renamed from: a */
        private String f1965a;

        /* renamed from: a */
        C0917a m2481a(Parcel parcel) {
            m2482a((ShareHashtag) parcel.readParcelable(ShareHashtag.class.getClassLoader()));
            return this;
        }

        /* renamed from: a */
        public C0917a m2482a(ShareHashtag shareHashtag) {
            if (shareHashtag == null) {
                return this;
            }
            m2483a(shareHashtag.m2220a());
            return this;
        }

        /* renamed from: a */
        public C0917a m2483a(String str) {
            this.f1965a = str;
            return this;
        }

        /* renamed from: a */
        public ShareHashtag m2484a() {
            return new ShareHashtag();
        }
    }

    ShareHashtag(Parcel parcel) {
        this.f1813a = parcel.readString();
    }

    private ShareHashtag(C0917a c0917a) {
        this.f1813a = c0917a.f1965a;
    }

    /* renamed from: a */
    public String m2220a() {
        return this.f1813a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1813a);
    }
}
