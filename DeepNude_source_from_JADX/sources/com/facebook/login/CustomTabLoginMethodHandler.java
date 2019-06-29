package com.facebook.login;

import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.C0451h;
import com.facebook.C0560t;
import com.facebook.C0860n;
import com.facebook.CustomTabMainActivity;
import com.facebook.internal.C0457C;
import com.facebook.internal.C0475Q;
import com.facebook.internal.C0476S;
import com.facebook.internal.C0503y;
import com.facebook.login.LoginClient.Request;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

public class CustomTabLoginMethodHandler extends WebLoginMethodHandler {
    public static final Creator<CustomTabLoginMethodHandler> CREATOR = new C0512a();
    /* renamed from: d */
    private static final String[] f1957d = new String[]{"com.android.chrome", "com.chrome.beta", "com.chrome.dev"};
    /* renamed from: e */
    private String f1958e;
    /* renamed from: f */
    private String f1959f;

    CustomTabLoginMethodHandler(Parcel parcel) {
        super(parcel);
        this.f1959f = parcel.readString();
    }

    CustomTabLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        this.f1959f = C0475Q.m963a(20);
    }

    /* renamed from: a */
    private void m2452a(java.lang.String r7, com.facebook.login.LoginClient.Request r8) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r6 = this;
        if (r7 == 0) goto L_0x00ad;
    L_0x0002:
        r0 = com.facebook.CustomTabMainActivity.m478a();
        r0 = r7.startsWith(r0);
        if (r0 == 0) goto L_0x00ad;
    L_0x000c:
        r7 = android.net.Uri.parse(r7);
        r0 = r7.getQuery();
        r0 = com.facebook.internal.C0475Q.m1004d(r0);
        r7 = r7.getFragment();
        r7 = com.facebook.internal.C0475Q.m1004d(r7);
        r0.putAll(r7);
        r7 = r6.m2453a(r0);
        r1 = 0;
        if (r7 != 0) goto L_0x0035;
    L_0x002a:
        r7 = new com.facebook.l;
        r0 = "Invalid state parameter";
        r7.<init>(r0);
        super.m2196a(r8, r1, r7);
        return;
    L_0x0035:
        r7 = "error";
        r7 = r0.getString(r7);
        if (r7 != 0) goto L_0x0043;
    L_0x003d:
        r7 = "error_type";
        r7 = r0.getString(r7);
    L_0x0043:
        r2 = "error_msg";
        r2 = r0.getString(r2);
        if (r2 != 0) goto L_0x0051;
    L_0x004b:
        r2 = "error_message";
        r2 = r0.getString(r2);
    L_0x0051:
        if (r2 != 0) goto L_0x0059;
    L_0x0053:
        r2 = "error_description";
        r2 = r0.getString(r2);
    L_0x0059:
        r3 = "error_code";
        r3 = r0.getString(r3);
        r4 = com.facebook.internal.C0475Q.m998b(r3);
        r5 = -1;
        if (r4 != 0) goto L_0x006b;
    L_0x0066:
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ NumberFormatException -> 0x006b }
        goto L_0x006c;
    L_0x006b:
        r3 = -1;
    L_0x006c:
        r4 = com.facebook.internal.C0475Q.m998b(r7);
        if (r4 == 0) goto L_0x007e;
    L_0x0072:
        r4 = com.facebook.internal.C0475Q.m998b(r2);
        if (r4 == 0) goto L_0x007e;
    L_0x0078:
        if (r3 != r5) goto L_0x007e;
    L_0x007a:
        super.m2196a(r8, r0, r1);
        goto L_0x00ad;
    L_0x007e:
        if (r7 == 0) goto L_0x0096;
    L_0x0080:
        r0 = "access_denied";
        r0 = r7.equals(r0);
        if (r0 != 0) goto L_0x0090;
    L_0x0088:
        r0 = "OAuthAccessDeniedException";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x0096;
    L_0x0090:
        r7 = new com.facebook.n;
        r7.<init>();
        goto L_0x00aa;
    L_0x0096:
        r0 = 4201; // 0x1069 float:5.887E-42 double:2.0756E-320;
        if (r3 != r0) goto L_0x00a0;
    L_0x009a:
        r7 = new com.facebook.n;
        r7.<init>();
        goto L_0x00aa;
    L_0x00a0:
        r0 = new com.facebook.FacebookRequestError;
        r0.<init>(r3, r7, r2);
        r7 = new com.facebook.v;
        r7.<init>(r0, r2);
    L_0x00aa:
        super.m2196a(r8, r1, r7);
    L_0x00ad:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.CustomTabLoginMethodHandler.a(java.lang.String, com.facebook.login.LoginClient$Request):void");
    }

    /* renamed from: a */
    private boolean m2453a(android.os.Bundle r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r2 = this;
        r0 = 0;
        r1 = "state";	 Catch:{ JSONException -> 0x001c }
        r3 = r3.getString(r1);	 Catch:{ JSONException -> 0x001c }
        if (r3 != 0) goto L_0x000a;	 Catch:{ JSONException -> 0x001c }
    L_0x0009:
        return r0;	 Catch:{ JSONException -> 0x001c }
    L_0x000a:
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x001c }
        r1.<init>(r3);	 Catch:{ JSONException -> 0x001c }
        r3 = "7_challenge";	 Catch:{ JSONException -> 0x001c }
        r3 = r1.getString(r3);	 Catch:{ JSONException -> 0x001c }
        r1 = r2.f1959f;	 Catch:{ JSONException -> 0x001c }
        r3 = r3.equals(r1);	 Catch:{ JSONException -> 0x001c }
        return r3;
    L_0x001c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.CustomTabLoginMethodHandler.a(android.os.Bundle):boolean");
    }

    /* renamed from: h */
    private String m2454h() {
        String str = this.f1958e;
        if (str != null) {
            return str;
        }
        ContextWrapper c = this.f980b.m1158c();
        List<ResolveInfo> queryIntentServices = c.getPackageManager().queryIntentServices(new Intent("android.support.customtabs.action.CustomTabsService"), 0);
        if (queryIntentServices != null) {
            Set hashSet = new HashSet(Arrays.asList(f1957d));
            for (ResolveInfo resolveInfo : queryIntentServices) {
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                if (serviceInfo != null && hashSet.contains(serviceInfo.packageName)) {
                    this.f1958e = serviceInfo.packageName;
                    return this.f1958e;
                }
            }
        }
        return null;
    }

    /* renamed from: i */
    private boolean m2455i() {
        return m2457k() && m2454h() != null && m2456j() && C0476S.m1019a(C0560t.m1252d());
    }

    /* renamed from: j */
    private boolean m2456j() {
        return !C0475Q.m1005d(this.f980b.m1158c());
    }

    /* renamed from: k */
    private boolean m2457k() {
        C0503y b = C0457C.m876b(C0475Q.m999c(this.f980b.m1158c()));
        return b != null && b.m1101d();
    }

    /* renamed from: a */
    protected void mo1605a(JSONObject jSONObject) {
        jSONObject.put("7_challenge", this.f1959f);
    }

    /* renamed from: a */
    boolean mo965a(int i, int i2, Intent intent) {
        if (i != 1) {
            return super.mo965a(i, i2, intent);
        }
        Request i3 = this.f980b.m1164i();
        if (i2 == -1) {
            m2452a(intent.getStringExtra(CustomTabMainActivity.f426c), i3);
            return true;
        }
        super.m2196a(i3, null, new C0860n());
        return false;
    }

    /* renamed from: a */
    boolean mo961a(Request request) {
        if (!m2455i()) {
            return false;
        }
        Bundle b = m2197b(request);
        m2195a(b, request);
        Intent intent = new Intent(this.f980b.m1158c(), CustomTabMainActivity.class);
        intent.putExtra(CustomTabMainActivity.f424a, b);
        intent.putExtra(CustomTabMainActivity.f425b, m2454h());
        this.f980b.m1162f().startActivityForResult(intent, 1);
        return true;
    }

    /* renamed from: b */
    String mo962b() {
        return "custom_tab";
    }

    /* renamed from: d */
    protected String mo1606d() {
        return "chrome_custom_tab";
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    C0451h mo1607e() {
        return C0451h.CHROME_CUSTOM_TAB;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f1959f);
    }
}
