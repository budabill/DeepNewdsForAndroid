package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.internal.C0457C;
import com.facebook.internal.C0498t;
import com.facebook.internal.C0503y;
import java.net.HttpURLConnection;
import org.json.JSONObject;

public final class FacebookRequestError implements Parcelable {
    public static final Creator<FacebookRequestError> CREATOR = new C0540o();
    /* renamed from: a */
    static final C0335b f450a = new C0335b(200, 299);
    /* renamed from: b */
    private final C0334a f451b;
    /* renamed from: c */
    private final int f452c;
    /* renamed from: d */
    private final int f453d;
    /* renamed from: e */
    private final int f454e;
    /* renamed from: f */
    private final String f455f;
    /* renamed from: g */
    private final String f456g;
    /* renamed from: h */
    private final String f457h;
    /* renamed from: i */
    private final String f458i;
    /* renamed from: j */
    private final String f459j;
    /* renamed from: k */
    private final JSONObject f460k;
    /* renamed from: l */
    private final JSONObject f461l;
    /* renamed from: m */
    private final Object f462m;
    /* renamed from: n */
    private final HttpURLConnection f463n;
    /* renamed from: o */
    private final C0506l f464o;

    /* renamed from: com.facebook.FacebookRequestError$a */
    public enum C0334a {
        LOGIN_RECOVERABLE,
        OTHER,
        TRANSIENT
    }

    /* renamed from: com.facebook.FacebookRequestError$b */
    private static class C0335b {
        /* renamed from: a */
        private final int f448a;
        /* renamed from: b */
        private final int f449b;

        private C0335b(int i, int i2) {
            this.f448a = i;
            this.f449b = i2;
        }

        /* renamed from: a */
        boolean m496a(int i) {
            return this.f448a <= i && i <= this.f449b;
        }
    }

    private FacebookRequestError(int i, int i2, int i3, String str, String str2, String str3, String str4, boolean z, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, C0506l c0506l) {
        Object obj2;
        this.f452c = i;
        this.f453d = i2;
        this.f454e = i3;
        this.f455f = str;
        this.f456g = str2;
        this.f461l = jSONObject;
        this.f460k = jSONObject2;
        this.f462m = obj;
        this.f463n = httpURLConnection;
        this.f457h = str3;
        this.f458i = str4;
        if (c0506l != null) {
            this.f464o = c0506l;
            obj2 = 1;
        } else {
            this.f464o = new C0865v(this, str2);
            obj2 = null;
        }
        C0498t a = m498a();
        this.f451b = obj2 != null ? C0334a.OTHER : a.m1087a(i2, i3, z);
        this.f459j = a.m1088a(this.f451b);
    }

    public FacebookRequestError(int i, String str, String str2) {
        this(-1, i, -1, str, str2, null, null, false, null, null, null, null, null);
    }

    private FacebookRequestError(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), false, null, null, null, null, null);
    }

    FacebookRequestError(HttpURLConnection httpURLConnection, Exception exception) {
        Throwable th = exception;
        this(-1, -1, -1, null, null, null, null, false, null, null, null, httpURLConnection, th instanceof C0506l ? (C0506l) th : new C0506l(th));
    }

    /* renamed from: a */
    static com.facebook.FacebookRequestError m497a(org.json.JSONObject r18, java.lang.Object r19, java.net.HttpURLConnection r20) {
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
        r10 = r18;
        r0 = "error_code";
        r1 = "error";
        r2 = "FACEBOOK_NON_JSON_RESULT";
        r3 = "body";
        r4 = "code";
        r14 = 0;
        r5 = r10.has(r4);	 Catch:{ JSONException -> 0x00ea }
        if (r5 == 0) goto L_0x00ea;	 Catch:{ JSONException -> 0x00ea }
    L_0x0013:
        r5 = r10.getInt(r4);	 Catch:{ JSONException -> 0x00ea }
        r6 = com.facebook.internal.C0475Q.m962a(r10, r3, r2);	 Catch:{ JSONException -> 0x00ea }
        if (r6 == 0) goto L_0x00b2;	 Catch:{ JSONException -> 0x00ea }
    L_0x001d:
        r7 = r6 instanceof org.json.JSONObject;	 Catch:{ JSONException -> 0x00ea }
        if (r7 == 0) goto L_0x00b2;	 Catch:{ JSONException -> 0x00ea }
    L_0x0021:
        r9 = r6;	 Catch:{ JSONException -> 0x00ea }
        r9 = (org.json.JSONObject) r9;	 Catch:{ JSONException -> 0x00ea }
        r6 = r9.has(r1);	 Catch:{ JSONException -> 0x00ea }
        r7 = 1;
        r8 = "error_subcode";
        r11 = 0;
        r12 = -1;
        if (r6 == 0) goto L_0x0060;
    L_0x002f:
        r0 = com.facebook.internal.C0475Q.m962a(r9, r1, r14);	 Catch:{ JSONException -> 0x00ea }
        r0 = (org.json.JSONObject) r0;	 Catch:{ JSONException -> 0x00ea }
        r1 = "type";	 Catch:{ JSONException -> 0x00ea }
        r1 = r0.optString(r1, r14);	 Catch:{ JSONException -> 0x00ea }
        r6 = "message";	 Catch:{ JSONException -> 0x00ea }
        r6 = r0.optString(r6, r14);	 Catch:{ JSONException -> 0x00ea }
        r4 = r0.optInt(r4, r12);	 Catch:{ JSONException -> 0x00ea }
        r8 = r0.optInt(r8, r12);	 Catch:{ JSONException -> 0x00ea }
        r12 = "error_user_msg";	 Catch:{ JSONException -> 0x00ea }
        r12 = r0.optString(r12, r14);	 Catch:{ JSONException -> 0x00ea }
        r13 = "error_user_title";	 Catch:{ JSONException -> 0x00ea }
        r13 = r0.optString(r13, r14);	 Catch:{ JSONException -> 0x00ea }
        r15 = "is_transient";	 Catch:{ JSONException -> 0x00ea }
        r0 = r0.optBoolean(r15, r11);	 Catch:{ JSONException -> 0x00ea }
        r15 = r0;	 Catch:{ JSONException -> 0x00ea }
        r11 = r6;	 Catch:{ JSONException -> 0x00ea }
        r6 = r8;	 Catch:{ JSONException -> 0x00ea }
        r8 = r1;	 Catch:{ JSONException -> 0x00ea }
        goto L_0x0096;	 Catch:{ JSONException -> 0x00ea }
    L_0x0060:
        r1 = r9.has(r0);	 Catch:{ JSONException -> 0x00ea }
        r4 = "error_msg";
        r6 = "error_reason";
        if (r1 != 0) goto L_0x0080;
    L_0x006a:
        r1 = r9.has(r4);	 Catch:{ JSONException -> 0x00ea }
        if (r1 != 0) goto L_0x0080;	 Catch:{ JSONException -> 0x00ea }
    L_0x0070:
        r1 = r9.has(r6);	 Catch:{ JSONException -> 0x00ea }
        if (r1 == 0) goto L_0x0077;	 Catch:{ JSONException -> 0x00ea }
    L_0x0076:
        goto L_0x0080;	 Catch:{ JSONException -> 0x00ea }
    L_0x0077:
        r8 = r14;	 Catch:{ JSONException -> 0x00ea }
        r11 = r8;	 Catch:{ JSONException -> 0x00ea }
        r12 = r11;	 Catch:{ JSONException -> 0x00ea }
        r13 = r12;	 Catch:{ JSONException -> 0x00ea }
        r4 = -1;	 Catch:{ JSONException -> 0x00ea }
        r6 = -1;	 Catch:{ JSONException -> 0x00ea }
        r7 = 0;	 Catch:{ JSONException -> 0x00ea }
        r15 = 0;	 Catch:{ JSONException -> 0x00ea }
        goto L_0x0096;	 Catch:{ JSONException -> 0x00ea }
    L_0x0080:
        r1 = r9.optString(r6, r14);	 Catch:{ JSONException -> 0x00ea }
        r4 = r9.optString(r4, r14);	 Catch:{ JSONException -> 0x00ea }
        r0 = r9.optInt(r0, r12);	 Catch:{ JSONException -> 0x00ea }
        r6 = r9.optInt(r8, r12);	 Catch:{ JSONException -> 0x00ea }
        r8 = r1;	 Catch:{ JSONException -> 0x00ea }
        r11 = r4;	 Catch:{ JSONException -> 0x00ea }
        r12 = r14;	 Catch:{ JSONException -> 0x00ea }
        r13 = r12;	 Catch:{ JSONException -> 0x00ea }
        r15 = 0;	 Catch:{ JSONException -> 0x00ea }
        r4 = r0;	 Catch:{ JSONException -> 0x00ea }
    L_0x0096:
        if (r7 == 0) goto L_0x00b2;	 Catch:{ JSONException -> 0x00ea }
    L_0x0098:
        r16 = new com.facebook.FacebookRequestError;	 Catch:{ JSONException -> 0x00ea }
        r17 = 0;	 Catch:{ JSONException -> 0x00ea }
        r0 = r16;	 Catch:{ JSONException -> 0x00ea }
        r1 = r5;	 Catch:{ JSONException -> 0x00ea }
        r2 = r4;	 Catch:{ JSONException -> 0x00ea }
        r3 = r6;	 Catch:{ JSONException -> 0x00ea }
        r4 = r8;	 Catch:{ JSONException -> 0x00ea }
        r5 = r11;	 Catch:{ JSONException -> 0x00ea }
        r6 = r13;	 Catch:{ JSONException -> 0x00ea }
        r7 = r12;	 Catch:{ JSONException -> 0x00ea }
        r8 = r15;	 Catch:{ JSONException -> 0x00ea }
        r10 = r18;	 Catch:{ JSONException -> 0x00ea }
        r11 = r19;	 Catch:{ JSONException -> 0x00ea }
        r12 = r20;	 Catch:{ JSONException -> 0x00ea }
        r13 = r17;	 Catch:{ JSONException -> 0x00ea }
        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);	 Catch:{ JSONException -> 0x00ea }
        return r16;	 Catch:{ JSONException -> 0x00ea }
    L_0x00b2:
        r0 = f450a;	 Catch:{ JSONException -> 0x00ea }
        r0 = r0.m496a(r5);	 Catch:{ JSONException -> 0x00ea }
        if (r0 != 0) goto L_0x00ea;	 Catch:{ JSONException -> 0x00ea }
    L_0x00ba:
        r15 = new com.facebook.FacebookRequestError;	 Catch:{ JSONException -> 0x00ea }
        r4 = -1;	 Catch:{ JSONException -> 0x00ea }
        r6 = -1;	 Catch:{ JSONException -> 0x00ea }
        r7 = 0;	 Catch:{ JSONException -> 0x00ea }
        r8 = 0;	 Catch:{ JSONException -> 0x00ea }
        r9 = 0;	 Catch:{ JSONException -> 0x00ea }
        r11 = 0;	 Catch:{ JSONException -> 0x00ea }
        r12 = 0;	 Catch:{ JSONException -> 0x00ea }
        r0 = r10.has(r3);	 Catch:{ JSONException -> 0x00ea }
        if (r0 == 0) goto L_0x00d1;	 Catch:{ JSONException -> 0x00ea }
    L_0x00c9:
        r0 = com.facebook.internal.C0475Q.m962a(r10, r3, r2);	 Catch:{ JSONException -> 0x00ea }
        r0 = (org.json.JSONObject) r0;	 Catch:{ JSONException -> 0x00ea }
        r13 = r0;	 Catch:{ JSONException -> 0x00ea }
        goto L_0x00d2;	 Catch:{ JSONException -> 0x00ea }
    L_0x00d1:
        r13 = r14;	 Catch:{ JSONException -> 0x00ea }
    L_0x00d2:
        r16 = 0;	 Catch:{ JSONException -> 0x00ea }
        r0 = r15;	 Catch:{ JSONException -> 0x00ea }
        r1 = r5;	 Catch:{ JSONException -> 0x00ea }
        r2 = r4;	 Catch:{ JSONException -> 0x00ea }
        r3 = r6;	 Catch:{ JSONException -> 0x00ea }
        r4 = r7;	 Catch:{ JSONException -> 0x00ea }
        r5 = r8;	 Catch:{ JSONException -> 0x00ea }
        r6 = r9;	 Catch:{ JSONException -> 0x00ea }
        r7 = r11;	 Catch:{ JSONException -> 0x00ea }
        r8 = r12;	 Catch:{ JSONException -> 0x00ea }
        r9 = r13;	 Catch:{ JSONException -> 0x00ea }
        r10 = r18;	 Catch:{ JSONException -> 0x00ea }
        r11 = r19;	 Catch:{ JSONException -> 0x00ea }
        r12 = r20;	 Catch:{ JSONException -> 0x00ea }
        r13 = r16;	 Catch:{ JSONException -> 0x00ea }
        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);	 Catch:{ JSONException -> 0x00ea }
        return r15;
    L_0x00ea:
        return r14;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookRequestError.a(org.json.JSONObject, java.lang.Object, java.net.HttpURLConnection):com.facebook.FacebookRequestError");
    }

    /* renamed from: a */
    static synchronized C0498t m498a() {
        synchronized (FacebookRequestError.class) {
            C0503y b = C0457C.m876b(C0560t.m1253e());
            if (b == null) {
                C0498t a = C0498t.m1083a();
                return a;
            }
            a = b.m1102e();
            return a;
        }
    }

    /* renamed from: b */
    public int m499b() {
        return this.f453d;
    }

    /* renamed from: c */
    public String m500c() {
        String str = this.f456g;
        return str != null ? str : this.f464o.getLocalizedMessage();
    }

    /* renamed from: d */
    public String m501d() {
        return this.f455f;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public C0506l m502e() {
        return this.f464o;
    }

    /* renamed from: f */
    public int m503f() {
        return this.f452c;
    }

    /* renamed from: g */
    public int m504g() {
        return this.f454e;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{HttpStatus: ");
        stringBuilder.append(this.f452c);
        stringBuilder.append(", errorCode: ");
        stringBuilder.append(this.f453d);
        stringBuilder.append(", subErrorCode: ");
        stringBuilder.append(this.f454e);
        stringBuilder.append(", errorType: ");
        stringBuilder.append(this.f455f);
        stringBuilder.append(", errorMessage: ");
        stringBuilder.append(m500c());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f452c);
        parcel.writeInt(this.f453d);
        parcel.writeInt(this.f454e);
        parcel.writeString(this.f455f);
        parcel.writeString(this.f456g);
        parcel.writeString(this.f457h);
        parcel.writeString(this.f458i);
    }
}
