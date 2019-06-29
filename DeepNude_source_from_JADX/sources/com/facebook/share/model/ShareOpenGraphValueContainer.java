package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import java.util.Set;

public abstract class ShareOpenGraphValueContainer<P extends ShareOpenGraphValueContainer, E extends C0918a> implements ShareModel {
    /* renamed from: a */
    private final Bundle f1815a;

    /* renamed from: com.facebook.share.model.ShareOpenGraphValueContainer$a */
    public static abstract class C0918a<P extends ShareOpenGraphValueContainer, E extends C0918a> implements C0863c<P, E> {
        /* renamed from: a */
        private Bundle f1972a = new Bundle();

        /* renamed from: a */
        public E m2489a(P p) {
            if (p != null) {
                this.f1972a.putAll(p.m2221a());
            }
            return this;
        }

        /* renamed from: a */
        public E m2490a(String str, String str2) {
            this.f1972a.putString(str, str2);
            return this;
        }
    }

    ShareOpenGraphValueContainer(Parcel parcel) {
        this.f1815a = parcel.readBundle(C0918a.class.getClassLoader());
    }

    protected ShareOpenGraphValueContainer(C0918a<P, E> c0918a) {
        this.f1815a = (Bundle) c0918a.f1972a.clone();
    }

    /* renamed from: a */
    public Bundle m2221a() {
        return (Bundle) this.f1815a.clone();
    }

    /* renamed from: a */
    public Object m2222a(String str) {
        return this.f1815a.get(str);
    }

    /* renamed from: b */
    public String m2223b(String str) {
        return this.f1815a.getString(str);
    }

    /* renamed from: b */
    public Set<String> m2224b() {
        return this.f1815a.keySet();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f1815a);
    }
}
