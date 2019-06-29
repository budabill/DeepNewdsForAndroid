package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import com.facebook.share.model.ShareHashtag.C0917a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ShareContent<P extends ShareContent, E> implements ShareModel {
    /* renamed from: a */
    private final Uri f1807a;
    /* renamed from: b */
    private final List<String> f1808b;
    /* renamed from: c */
    private final String f1809c;
    /* renamed from: d */
    private final String f1810d;
    /* renamed from: e */
    private final String f1811e;
    /* renamed from: f */
    private final ShareHashtag f1812f;

    protected ShareContent(Parcel parcel) {
        this.f1807a = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f1808b = m2217a(parcel);
        this.f1809c = parcel.readString();
        this.f1810d = parcel.readString();
        this.f1811e = parcel.readString();
        C0917a c0917a = new C0917a();
        c0917a.m2481a(parcel);
        this.f1812f = c0917a.m2484a();
    }

    /* renamed from: a */
    private List<String> m2217a(Parcel parcel) {
        List arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        return arrayList.size() == 0 ? null : Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    public Uri m2218a() {
        return this.f1807a;
    }

    /* renamed from: b */
    public ShareHashtag m2219b() {
        return this.f1812f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f1807a, 0);
        parcel.writeStringList(this.f1808b);
        parcel.writeString(this.f1809c);
        parcel.writeString(this.f1810d);
        parcel.writeString(this.f1811e);
        parcel.writeParcelable(this.f1812f, 0);
    }
}
