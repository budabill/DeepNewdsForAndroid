package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareOpenGraphValueContainer.C0918a;

public final class ShareOpenGraphAction extends ShareOpenGraphValueContainer<ShareOpenGraphAction, C0926a> {
    public static final Creator<ShareOpenGraphAction> CREATOR = new C0555d();

    /* renamed from: com.facebook.share.model.ShareOpenGraphAction$a */
    public static final class C0926a extends C0918a<ShareOpenGraphAction, C0926a> {
        /* renamed from: a */
        C0926a m2548a(Parcel parcel) {
            return m2549a((ShareOpenGraphAction) parcel.readParcelable(ShareOpenGraphAction.class.getClassLoader()));
        }

        /* renamed from: a */
        public C0926a m2549a(ShareOpenGraphAction shareOpenGraphAction) {
            if (shareOpenGraphAction == null) {
                return this;
            }
            super.m2489a((ShareOpenGraphValueContainer) shareOpenGraphAction);
            C0926a c0926a = this;
            m2550a(shareOpenGraphAction.m2486c());
            return c0926a;
        }

        /* renamed from: a */
        public C0926a m2550a(String str) {
            m2490a("og:type", str);
            return this;
        }

        /* renamed from: a */
        public ShareOpenGraphAction m2551a() {
            return new ShareOpenGraphAction();
        }
    }

    ShareOpenGraphAction(Parcel parcel) {
        super(parcel);
    }

    private ShareOpenGraphAction(C0926a c0926a) {
        super((C0918a) c0926a);
    }

    /* renamed from: c */
    public String m2486c() {
        return m2223b("og:type");
    }
}
