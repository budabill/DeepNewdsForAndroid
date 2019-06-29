package com.facebook.login;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.facebook.C0451h;
import com.facebook.internal.C0468K;
import com.facebook.internal.C0475Q;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import java.util.ArrayList;
import java.util.HashSet;

class GetTokenLoginMethodHandler extends LoginMethodHandler {
    public static final Creator<GetTokenLoginMethodHandler> CREATOR = new C0521p();
    /* renamed from: c */
    private C0852m f1783c;

    GetTokenLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }

    GetTokenLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    /* renamed from: a */
    void mo964a() {
        C0468K c0468k = this.f1783c;
        if (c0468k != null) {
            c0468k.m939a();
            this.f1783c.m942a(null);
            this.f1783c = null;
        }
    }

    /* renamed from: a */
    void m2181a(Request request, Bundle bundle) {
        String string = bundle.getString("com.facebook.platform.extra.USER_ID");
        if (string != null) {
            if (!string.isEmpty()) {
                m2185c(request, bundle);
                return;
            }
        }
        this.f980b.m1165j();
        C0475Q.m982a(bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN"), new C0854o(this, bundle, request));
    }

    /* renamed from: a */
    boolean mo961a(Request request) {
        this.f1783c = new C0852m(this.f980b.m1158c(), request.m1120a());
        if (!this.f1783c.m943b()) {
            return false;
        }
        this.f980b.m1165j();
        this.f1783c.m942a(new C0853n(this, request));
        return true;
    }

    /* renamed from: b */
    String mo962b() {
        return "get_token";
    }

    /* renamed from: b */
    void m2184b(Request request, Bundle bundle) {
        C0468K c0468k = this.f1783c;
        if (c0468k != null) {
            c0468k.m942a(null);
        }
        this.f1783c = null;
        this.f980b.m1166k();
        if (bundle != null) {
            ArrayList stringArrayList = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
            Object<String> h = request.m1128h();
            if (stringArrayList == null || !(h == null || stringArrayList.containsAll(h))) {
                Object hashSet = new HashSet();
                for (String str : h) {
                    if (!stringArrayList.contains(str)) {
                        hashSet.add(str);
                    }
                }
                if (!hashSet.isEmpty()) {
                    m1175a("new_permissions", TextUtils.join(",", hashSet));
                }
                request.m1121a(hashSet);
            } else {
                m2181a(request, bundle);
                return;
            }
        }
        this.f980b.m1168m();
    }

    /* renamed from: c */
    void m2185c(Request request, Bundle bundle) {
        this.f980b.m1155b(Result.m1132a(this.f980b.m1164i(), LoginMethodHandler.m1169a(bundle, C0451h.FACEBOOK_APPLICATION_SERVICE, request.m1120a())));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
