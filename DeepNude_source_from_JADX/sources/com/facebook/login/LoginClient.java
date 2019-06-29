package com.facebook.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.C0506l;
import com.facebook.common.C0447d;
import com.facebook.internal.C0475Q;
import com.facebook.internal.C0476S;
import com.facebook.internal.C0493l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class LoginClient implements Parcelable {
    public static final Creator<LoginClient> CREATOR = new C0524s();
    /* renamed from: a */
    LoginMethodHandler[] f969a;
    /* renamed from: b */
    int f970b = -1;
    /* renamed from: c */
    Fragment f971c;
    /* renamed from: d */
    C0511b f972d;
    /* renamed from: e */
    C0510a f973e;
    /* renamed from: f */
    boolean f974f;
    /* renamed from: g */
    Request f975g;
    /* renamed from: h */
    Map<String, String> f976h;
    /* renamed from: i */
    Map<String, String> f977i;
    /* renamed from: j */
    private C0527y f978j;

    public static class Request implements Parcelable {
        public static final Creator<Request> CREATOR = new C0525t();
        /* renamed from: a */
        private final C0523r f948a;
        /* renamed from: b */
        private Set<String> f949b;
        /* renamed from: c */
        private final C0513b f950c;
        /* renamed from: d */
        private final String f951d;
        /* renamed from: e */
        private final String f952e;
        /* renamed from: f */
        private boolean f953f;
        /* renamed from: g */
        private String f954g;
        /* renamed from: h */
        private String f955h;
        /* renamed from: i */
        private String f956i;

        private Request(Parcel parcel) {
            boolean z = false;
            this.f953f = false;
            String readString = parcel.readString();
            C0513b c0513b = null;
            this.f948a = readString != null ? C0523r.valueOf(readString) : null;
            Collection arrayList = new ArrayList();
            parcel.readStringList(arrayList);
            this.f949b = new HashSet(arrayList);
            readString = parcel.readString();
            if (readString != null) {
                c0513b = C0513b.valueOf(readString);
            }
            this.f950c = c0513b;
            this.f951d = parcel.readString();
            this.f952e = parcel.readString();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            }
            this.f953f = z;
            this.f954g = parcel.readString();
            this.f955h = parcel.readString();
            this.f956i = parcel.readString();
        }

        /* renamed from: a */
        String m1120a() {
            return this.f951d;
        }

        /* renamed from: a */
        void m1121a(Set<String> set) {
            C0476S.m1016a((Object) set, "permissions");
            this.f949b = set;
        }

        /* renamed from: b */
        String m1122b() {
            return this.f952e;
        }

        /* renamed from: c */
        String m1123c() {
            return this.f955h;
        }

        /* renamed from: d */
        C0513b m1124d() {
            return this.f950c;
        }

        public int describeContents() {
            return 0;
        }

        /* renamed from: e */
        String m1125e() {
            return this.f956i;
        }

        /* renamed from: f */
        String m1126f() {
            return this.f954g;
        }

        /* renamed from: g */
        C0523r m1127g() {
            return this.f948a;
        }

        /* renamed from: h */
        Set<String> m1128h() {
            return this.f949b;
        }

        /* renamed from: i */
        boolean m1129i() {
            for (String a : this.f949b) {
                if (C0507A.m1110a(a)) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: j */
        boolean m1130j() {
            return this.f953f;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Enum enumR = this.f948a;
            String str = null;
            parcel.writeString(enumR != null ? enumR.name() : null);
            parcel.writeStringList(new ArrayList(this.f949b));
            enumR = this.f950c;
            if (enumR != null) {
                str = enumR.name();
            }
            parcel.writeString(str);
            parcel.writeString(this.f951d);
            parcel.writeString(this.f952e);
            parcel.writeByte((byte) this.f953f);
            parcel.writeString(this.f954g);
            parcel.writeString(this.f955h);
            parcel.writeString(this.f956i);
        }
    }

    public static class Result implements Parcelable {
        public static final Creator<Result> CREATOR = new C0526u();
        /* renamed from: a */
        final C0509a f962a;
        /* renamed from: b */
        final AccessToken f963b;
        /* renamed from: c */
        final String f964c;
        /* renamed from: d */
        final String f965d;
        /* renamed from: e */
        final Request f966e;
        /* renamed from: f */
        public Map<String, String> f967f;
        /* renamed from: g */
        public Map<String, String> f968g;

        /* renamed from: com.facebook.login.LoginClient$Result$a */
        enum C0509a {
            SUCCESS("success"),
            CANCEL("cancel"),
            ERROR("error");
            
            /* renamed from: e */
            private final String f961e;

            private C0509a(String str) {
                this.f961e = str;
            }

            /* renamed from: a */
            String m1131a() {
                return this.f961e;
            }
        }

        private Result(Parcel parcel) {
            this.f962a = C0509a.valueOf(parcel.readString());
            this.f963b = (AccessToken) parcel.readParcelable(AccessToken.class.getClassLoader());
            this.f964c = parcel.readString();
            this.f965d = parcel.readString();
            this.f966e = (Request) parcel.readParcelable(Request.class.getClassLoader());
            this.f967f = C0475Q.m974a(parcel);
            this.f968g = C0475Q.m974a(parcel);
        }

        Result(Request request, C0509a c0509a, AccessToken accessToken, String str, String str2) {
            C0476S.m1016a((Object) c0509a, "code");
            this.f966e = request;
            this.f963b = accessToken;
            this.f964c = str;
            this.f962a = c0509a;
            this.f965d = str2;
        }

        /* renamed from: a */
        static Result m1132a(Request request, AccessToken accessToken) {
            return new Result(request, C0509a.SUCCESS, accessToken, null, null);
        }

        /* renamed from: a */
        static Result m1133a(Request request, String str) {
            return new Result(request, C0509a.CANCEL, null, str, null);
        }

        /* renamed from: a */
        static Result m1134a(Request request, String str, String str2) {
            return m1135a(request, str, str2, null);
        }

        /* renamed from: a */
        static Result m1135a(Request request, String str, String str2, String str3) {
            Object[] objArr = new String[]{str, str2};
            return new Result(request, C0509a.ERROR, null, TextUtils.join(": ", C0475Q.m972a(objArr)), str3);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f962a.name());
            parcel.writeParcelable(this.f963b, i);
            parcel.writeString(this.f964c);
            parcel.writeString(this.f965d);
            parcel.writeParcelable(this.f966e, i);
            C0475Q.m980a(parcel, this.f967f);
            C0475Q.m980a(parcel, this.f968g);
        }
    }

    /* renamed from: com.facebook.login.LoginClient$a */
    interface C0510a {
        /* renamed from: a */
        void mo970a();

        /* renamed from: b */
        void mo971b();
    }

    /* renamed from: com.facebook.login.LoginClient$b */
    public interface C0511b {
        /* renamed from: a */
        void mo969a(Result result);
    }

    public LoginClient(Parcel parcel) {
        Parcelable[] readParcelableArray = parcel.readParcelableArray(LoginMethodHandler.class.getClassLoader());
        this.f969a = new LoginMethodHandler[readParcelableArray.length];
        for (int i = 0; i < readParcelableArray.length; i++) {
            LoginMethodHandler[] loginMethodHandlerArr = this.f969a;
            loginMethodHandlerArr[i] = (LoginMethodHandler) readParcelableArray[i];
            loginMethodHandlerArr[i].m1174a(this);
        }
        this.f970b = parcel.readInt();
        this.f975g = (Request) parcel.readParcelable(Request.class.getClassLoader());
        this.f976h = C0475Q.m974a(parcel);
        this.f977i = C0475Q.m974a(parcel);
    }

    public LoginClient(Fragment fragment) {
        this.f971c = fragment;
    }

    /* renamed from: a */
    private void m1139a(String str, Result result, Map<String, String> map) {
        m1140a(str, result.f962a.m1131a(), result.f964c, result.f965d, map);
    }

    /* renamed from: a */
    private void m1140a(String str, String str2, String str3, String str4, Map<String, String> map) {
        if (this.f975g == null) {
            m1146o().m1192a("fb_mobile_login_method_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", str);
        } else {
            m1146o().m1193a(this.f975g.m1122b(), str, str2, str3, str4, map);
        }
    }

    /* renamed from: a */
    private void m1141a(String str, String str2, boolean z) {
        Object stringBuilder;
        if (this.f976h == null) {
            this.f976h = new HashMap();
        }
        if (this.f976h.containsKey(str) && z) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append((String) this.f976h.get(str));
            stringBuilder2.append(",");
            stringBuilder2.append(str2);
            stringBuilder = stringBuilder2.toString();
        }
        this.f976h.put(str, stringBuilder);
    }

    /* renamed from: d */
    private void m1142d(Result result) {
        C0511b c0511b = this.f972d;
        if (c0511b != null) {
            c0511b.mo969a(result);
        }
    }

    /* renamed from: e */
    static java.lang.String m1143e() {
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
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = "init";	 Catch:{ JSONException -> 0x000e }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ JSONException -> 0x000e }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x000e }
    L_0x000e:
        r0 = r0.toString();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginClient.e():java.lang.String");
    }

    /* renamed from: h */
    public static int m1144h() {
        return C0493l.Login.m1081a();
    }

    /* renamed from: n */
    private void m1145n() {
        m1151a(Result.m1134a(this.f975g, "Login attempt failed.", null));
    }

    /* renamed from: o */
    private C0527y m1146o() {
        C0527y c0527y = this.f978j;
        if (c0527y == null || !c0527y.m1190a().equals(this.f975g.m1120a())) {
            this.f978j = new C0527y(m1158c(), this.f975g.m1120a());
        }
        return this.f978j;
    }

    /* renamed from: a */
    int m1147a(String str) {
        return m1158c().checkCallingOrSelfPermission(str);
    }

    /* renamed from: a */
    void m1148a() {
        if (this.f970b >= 0) {
            m1161d().mo964a();
        }
    }

    /* renamed from: a */
    void m1149a(Fragment fragment) {
        if (this.f971c == null) {
            this.f971c = fragment;
            return;
        }
        throw new C0506l("Can't set fragment once it is already set.");
    }

    /* renamed from: a */
    void m1150a(Request request) {
        if (request != null) {
            if (this.f975g != null) {
                throw new C0506l("Attempted to authorize while a request is pending.");
            } else if (!AccessToken.m447l() || m1156b()) {
                this.f975g = request;
                this.f969a = m1157b(request);
                m1168m();
            }
        }
    }

    /* renamed from: a */
    void m1151a(Result result) {
        LoginMethodHandler d = m1161d();
        if (d != null) {
            m1139a(d.mo962b(), result, d.f979a);
        }
        Map map = this.f976h;
        if (map != null) {
            result.f967f = map;
        }
        map = this.f977i;
        if (map != null) {
            result.f968g = map;
        }
        this.f969a = null;
        this.f970b = -1;
        this.f975g = null;
        this.f976h = null;
        m1142d(result);
    }

    /* renamed from: a */
    void m1152a(C0510a c0510a) {
        this.f973e = c0510a;
    }

    /* renamed from: a */
    void m1153a(C0511b c0511b) {
        this.f972d = c0511b;
    }

    /* renamed from: a */
    public boolean m1154a(int i, int i2, Intent intent) {
        return this.f975g != null ? m1161d().mo965a(i, i2, intent) : false;
    }

    /* renamed from: b */
    void m1155b(Result result) {
        if (result.f963b == null || !AccessToken.m447l()) {
            m1151a(result);
        } else {
            m1160c(result);
        }
    }

    /* renamed from: b */
    boolean m1156b() {
        if (this.f974f) {
            return true;
        }
        if (m1147a("android.permission.INTERNET") != 0) {
            Activity c = m1158c();
            m1151a(Result.m1134a(this.f975g, c.getString(C0447d.com_facebook_internet_permission_error_title), c.getString(C0447d.com_facebook_internet_permission_error_message)));
            return false;
        }
        this.f974f = true;
        return true;
    }

    /* renamed from: b */
    protected LoginMethodHandler[] m1157b(Request request) {
        ArrayList arrayList = new ArrayList();
        C0523r g = request.m1127g();
        if (g.m1186d()) {
            arrayList.add(new GetTokenLoginMethodHandler(this));
        }
        if (g.m1187e()) {
            arrayList.add(new KatanaProxyLoginMethodHandler(this));
        }
        if (g.m1185c()) {
            arrayList.add(new FacebookLiteLoginMethodHandler(this));
        }
        if (g.m1183a()) {
            arrayList.add(new CustomTabLoginMethodHandler(this));
        }
        if (g.m1188f()) {
            arrayList.add(new WebViewLoginMethodHandler(this));
        }
        if (g.m1184b()) {
            arrayList.add(new DeviceAuthMethodHandler(this));
        }
        LoginMethodHandler[] loginMethodHandlerArr = new LoginMethodHandler[arrayList.size()];
        arrayList.toArray(loginMethodHandlerArr);
        return loginMethodHandlerArr;
    }

    /* renamed from: c */
    FragmentActivity m1158c() {
        return this.f971c.getActivity();
    }

    /* renamed from: c */
    void m1159c(Request request) {
        if (!m1163g()) {
            m1150a(request);
        }
    }

    /* renamed from: c */
    void m1160c(Result result) {
        if (result.f963b != null) {
            AccessToken c = AccessToken.m446c();
            AccessToken accessToken = result.f963b;
            if (!(c == null || accessToken == null)) {
                try {
                    if (c.m457k().equals(accessToken.m457k())) {
                        result = Result.m1132a(this.f975g, result.f963b);
                        m1151a(result);
                        return;
                    }
                } catch (Exception e) {
                    m1151a(Result.m1134a(this.f975g, "Caught exception", e.getMessage()));
                    return;
                }
            }
            result = Result.m1134a(this.f975g, "User logged in as different Facebook user.", null);
            m1151a(result);
            return;
        }
        throw new C0506l("Can't validate without a token");
    }

    /* renamed from: d */
    LoginMethodHandler m1161d() {
        int i = this.f970b;
        return i >= 0 ? this.f969a[i] : null;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: f */
    public Fragment m1162f() {
        return this.f971c;
    }

    /* renamed from: g */
    boolean m1163g() {
        return this.f975g != null && this.f970b >= 0;
    }

    /* renamed from: i */
    public Request m1164i() {
        return this.f975g;
    }

    /* renamed from: j */
    void m1165j() {
        C0510a c0510a = this.f973e;
        if (c0510a != null) {
            c0510a.mo970a();
        }
    }

    /* renamed from: k */
    void m1166k() {
        C0510a c0510a = this.f973e;
        if (c0510a != null) {
            c0510a.mo971b();
        }
    }

    /* renamed from: l */
    boolean m1167l() {
        LoginMethodHandler d = m1161d();
        if (!d.mo1608c() || m1156b()) {
            boolean a = d.mo961a(this.f975g);
            if (a) {
                m1146o().m1194b(this.f975g.m1122b(), d.mo962b());
            } else {
                m1146o().m1191a(this.f975g.m1122b(), d.mo962b());
                m1141a("not_tried", d.mo962b(), true);
            }
            return a;
        }
        m1141a("no_internet_permission", "1", false);
        return false;
    }

    /* renamed from: m */
    void m1168m() {
        if (this.f970b >= 0) {
            m1140a(m1161d().mo962b(), "skipped", null, null, m1161d().f979a);
        }
        do {
            LoginMethodHandler[] loginMethodHandlerArr = this.f969a;
            if (loginMethodHandlerArr != null) {
                int i = this.f970b;
                if (i < loginMethodHandlerArr.length - 1) {
                    this.f970b = i + 1;
                }
            }
            if (this.f975g != null) {
                m1145n();
            }
            return;
        } while (!m1167l());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelableArray(this.f969a, i);
        parcel.writeInt(this.f970b);
        parcel.writeParcelable(this.f975g, i);
        C0475Q.m980a(parcel, this.f976h);
        C0475Q.m980a(parcel, this.f977i);
    }
}
