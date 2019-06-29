package com.facebook;

import android.net.Uri;
import android.util.Log;
import com.facebook.internal.C0475Q.C0473a;
import org.json.JSONObject;

/* renamed from: com.facebook.H */
class C0819H implements C0473a {
    C0819H() {
    }

    /* renamed from: a */
    public void mo946a(C0506l c0506l) {
        String a = Profile.f507a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Got unexpected exception: ");
        stringBuilder.append(c0506l);
        Log.e(a, stringBuilder.toString());
    }

    /* renamed from: a */
    public void mo947a(JSONObject jSONObject) {
        String optString = jSONObject.optString("id");
        if (optString != null) {
            String optString2 = jSONObject.optString("link");
            Profile.m579a(new Profile(optString, jSONObject.optString("first_name"), jSONObject.optString("middle_name"), jSONObject.optString("last_name"), jSONObject.optString("name"), optString2 != null ? Uri.parse(optString2) : null));
        }
    }
}
