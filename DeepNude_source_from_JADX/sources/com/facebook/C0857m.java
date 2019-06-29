package com.facebook;

/* renamed from: com.facebook.m */
public class C0857m extends C0506l {
    /* renamed from: a */
    private final C0331D f1802a;

    public C0857m(C0331D c0331d, String str) {
        super(str);
        this.f1802a = c0331d;
    }

    public final String toString() {
        C0331D c0331d = this.f1802a;
        FacebookRequestError a = c0331d != null ? c0331d.m486a() : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{FacebookGraphResponseException: ");
        String message = getMessage();
        if (message != null) {
            stringBuilder.append(message);
            stringBuilder.append(" ");
        }
        if (a != null) {
            stringBuilder.append("httpResponseCode: ");
            stringBuilder.append(a.m503f());
            stringBuilder.append(", facebookErrorCode: ");
            stringBuilder.append(a.m499b());
            stringBuilder.append(", facebookErrorType: ");
            stringBuilder.append(a.m501d());
            stringBuilder.append(", message: ");
            stringBuilder.append(a.m500c());
            stringBuilder.append("}");
        }
        return stringBuilder.toString();
    }
}
