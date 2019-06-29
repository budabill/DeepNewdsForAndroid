package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.C0451h;
import com.facebook.C0506l;
import com.facebook.internal.C0475Q;
import com.facebook.login.LoginClient.Request;
import com.facebook.p029a.C0422r;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

abstract class LoginMethodHandler implements Parcelable {
    /* renamed from: a */
    Map<String, String> f979a;
    /* renamed from: b */
    protected LoginClient f980b;

    LoginMethodHandler(Parcel parcel) {
        this.f979a = C0475Q.m974a(parcel);
    }

    LoginMethodHandler(LoginClient loginClient) {
        this.f980b = loginClient;
    }

    /* renamed from: a */
    static AccessToken m1169a(Bundle bundle, C0451h c0451h, String str) {
        Bundle bundle2 = bundle;
        Date a = C0475Q.m970a(bundle, "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH", new Date(0));
        Collection stringArrayList = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
        String string = bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN");
        Date a2 = C0475Q.m970a(bundle, "com.facebook.platform.extra.EXTRA_DATA_ACCESS_EXPIRATION_TIME", new Date(0));
        if (C0475Q.m998b(string)) {
            return null;
        }
        return new AccessToken(string, str, bundle.getString("com.facebook.platform.extra.USER_ID"), stringArrayList, null, c0451h, a, new Date(), a2);
    }

    /* renamed from: a */
    public static AccessToken m1170a(Collection<String> collection, Bundle bundle, C0451h c0451h, String str) {
        Date a = C0475Q.m970a(bundle, "expires_in", new Date());
        String string = bundle.getString("access_token");
        Date a2 = C0475Q.m970a(bundle, "data_access_expiration_time", new Date(0));
        String string2 = bundle.getString("granted_scopes");
        String str2 = ",";
        if (!C0475Q.m998b(string2)) {
            collection = new ArrayList(Arrays.asList(string2.split(str2)));
        }
        Collection<String> collection2 = collection;
        String string3 = bundle.getString("denied_scopes");
        Collection arrayList = !C0475Q.m998b(string3) ? new ArrayList(Arrays.asList(string3.split(str2))) : null;
        if (C0475Q.m998b(string)) {
            return null;
        }
        return new AccessToken(string, str, m1171b(bundle.getString("signed_request")), collection2, arrayList, c0451h, a, new Date(), a2);
    }

    /* renamed from: b */
    static java.lang.String m1171b(java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        if (r2 == 0) goto L_0x0035;
    L_0x0002:
        r0 = r2.isEmpty();
        if (r0 != 0) goto L_0x0035;
    L_0x0008:
        r0 = "\\.";	 Catch:{ UnsupportedEncodingException -> 0x002d, UnsupportedEncodingException -> 0x002d }
        r2 = r2.split(r0);	 Catch:{ UnsupportedEncodingException -> 0x002d, UnsupportedEncodingException -> 0x002d }
        r0 = r2.length;	 Catch:{ UnsupportedEncodingException -> 0x002d, UnsupportedEncodingException -> 0x002d }
        r1 = 2;	 Catch:{ UnsupportedEncodingException -> 0x002d, UnsupportedEncodingException -> 0x002d }
        if (r0 != r1) goto L_0x002d;	 Catch:{ UnsupportedEncodingException -> 0x002d, UnsupportedEncodingException -> 0x002d }
    L_0x0012:
        r0 = 1;	 Catch:{ UnsupportedEncodingException -> 0x002d, UnsupportedEncodingException -> 0x002d }
        r2 = r2[r0];	 Catch:{ UnsupportedEncodingException -> 0x002d, UnsupportedEncodingException -> 0x002d }
        r0 = 0;	 Catch:{ UnsupportedEncodingException -> 0x002d, UnsupportedEncodingException -> 0x002d }
        r2 = android.util.Base64.decode(r2, r0);	 Catch:{ UnsupportedEncodingException -> 0x002d, UnsupportedEncodingException -> 0x002d }
        r0 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x002d, UnsupportedEncodingException -> 0x002d }
        r1 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x002d, UnsupportedEncodingException -> 0x002d }
        r0.<init>(r2, r1);	 Catch:{ UnsupportedEncodingException -> 0x002d, UnsupportedEncodingException -> 0x002d }
        r2 = new org.json.JSONObject;	 Catch:{ UnsupportedEncodingException -> 0x002d, UnsupportedEncodingException -> 0x002d }
        r2.<init>(r0);	 Catch:{ UnsupportedEncodingException -> 0x002d, UnsupportedEncodingException -> 0x002d }
        r0 = "user_id";	 Catch:{ UnsupportedEncodingException -> 0x002d, UnsupportedEncodingException -> 0x002d }
        r2 = r2.getString(r0);	 Catch:{ UnsupportedEncodingException -> 0x002d, UnsupportedEncodingException -> 0x002d }
        return r2;
    L_0x002d:
        r2 = new com.facebook.l;
        r0 = "Failed to retrieve user_id from signed_request";
        r2.<init>(r0);
        throw r2;
    L_0x0035:
        r2 = new com.facebook.l;
        r0 = "Authorization response does not contain the signed_request";
        r2.<init>(r0);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginMethodHandler.b(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    protected String m1172a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("0_auth_logger_id", str);
            jSONObject.put("3_method", mo962b());
            mo1605a(jSONObject);
        } catch (JSONException e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error creating client state json: ");
            stringBuilder.append(e.getMessage());
            Log.w("LoginMethodHandler", stringBuilder.toString());
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    void mo964a() {
    }

    /* renamed from: a */
    void m1174a(LoginClient loginClient) {
        if (this.f980b == null) {
            this.f980b = loginClient;
            return;
        }
        throw new C0506l("Can't set LoginClient if it is already set.");
    }

    /* renamed from: a */
    protected void m1175a(String str, Object obj) {
        if (this.f979a == null) {
            this.f979a = new HashMap();
        }
        this.f979a.put(str, obj == null ? null : obj.toString());
    }

    /* renamed from: a */
    void mo1605a(JSONObject jSONObject) {
    }

    /* renamed from: a */
    boolean mo965a(int i, int i2, Intent intent) {
        return false;
    }

    /* renamed from: a */
    abstract boolean mo961a(Request request);

    /* renamed from: b */
    abstract String mo962b();

    /* renamed from: c */
    protected void m1180c(String str) {
        String a = this.f980b.m1164i().m1120a();
        C0422r b = C0422r.m796b(this.f980b.m1158c(), a);
        Bundle bundle = new Bundle();
        bundle.putString("fb_web_login_e2e", str);
        bundle.putLong("fb_web_login_switchback_time", System.currentTimeMillis());
        bundle.putString("app_id", a);
        b.m806a("fb_dialogs_web_login_dialog_complete", null, bundle);
    }

    /* renamed from: c */
    boolean mo1608c() {
        return false;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0475Q.m980a(parcel, this.f979a);
    }
}
