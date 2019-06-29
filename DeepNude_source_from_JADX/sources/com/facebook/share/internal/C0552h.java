package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.C0506l;
import com.facebook.internal.C0475Q;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import org.json.JSONObject;

/* renamed from: com.facebook.share.internal.h */
public class C0552h {
    /* renamed from: a */
    public static Bundle m1237a(ShareContent shareContent) {
        Bundle bundle = new Bundle();
        ShareHashtag b = shareContent.m2219b();
        if (b != null) {
            C0475Q.m979a(bundle, "hashtag", b.m2220a());
        }
        return bundle;
    }

    /* renamed from: a */
    public static Bundle m1238a(ShareLinkContent shareLinkContent) {
        Bundle a = C0552h.m1237a((ShareContent) shareLinkContent);
        C0475Q.m978a(a, "href", shareLinkContent.m2218a());
        C0475Q.m979a(a, "quote", shareLinkContent.m2485c());
        return a;
    }

    /* renamed from: a */
    public static Bundle m1239a(ShareOpenGraphContent shareOpenGraphContent) {
        Bundle a = C0552h.m1237a((ShareContent) shareOpenGraphContent);
        C0475Q.m979a(a, "action_type", shareOpenGraphContent.m2487c().m2486c());
        try {
            JSONObject a2 = C0551g.m1236a(C0551g.m1235a(shareOpenGraphContent), false);
            if (a2 != null) {
                C0475Q.m979a(a, "action_properties", a2.toString());
            }
            return a;
        } catch (Throwable e) {
            throw new C0506l("Unable to serialize the ShareOpenGraphContent to JSON", e);
        }
    }
}
