package com.facebook;

/* renamed from: com.facebook.v */
public class C0865v extends C0506l {
    private static final long serialVersionUID = 1;
    /* renamed from: a */
    private final FacebookRequestError f1816a;

    public C0865v(FacebookRequestError facebookRequestError, String str) {
        super(str);
        this.f1816a = facebookRequestError;
    }

    /* renamed from: a */
    public final FacebookRequestError m2225a() {
        return this.f1816a;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{FacebookServiceException: ");
        stringBuilder.append("httpResponseCode: ");
        stringBuilder.append(this.f1816a.m503f());
        stringBuilder.append(", facebookErrorCode: ");
        stringBuilder.append(this.f1816a.m499b());
        stringBuilder.append(", facebookErrorType: ");
        stringBuilder.append(this.f1816a.m501d());
        stringBuilder.append(", message: ");
        stringBuilder.append(this.f1816a.m500c());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
