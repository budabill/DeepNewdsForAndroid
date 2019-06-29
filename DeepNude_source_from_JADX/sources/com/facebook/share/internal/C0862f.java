package com.facebook.share.internal;

import android.net.Uri;
import com.facebook.C0506l;
import com.facebook.internal.C0475Q;
import com.facebook.share.internal.C0550e.C0549a;
import com.facebook.share.model.SharePhoto;
import org.json.JSONObject;

/* renamed from: com.facebook.share.internal.f */
class C0862f implements C0549a {
    C0862f() {
    }

    /* renamed from: a */
    public JSONObject mo974a(SharePhoto sharePhoto) {
        Uri a = sharePhoto.m2491a();
        if (C0475Q.m1006d(a)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", a.toString());
                return jSONObject;
            } catch (Throwable e) {
                throw new C0506l("Unable to attach images", e);
            }
        }
        throw new C0506l("Only web images may be used in OG objects shared via the web dialog");
    }
}
