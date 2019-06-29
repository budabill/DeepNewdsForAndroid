package com.facebook;

/* renamed from: com.facebook.k */
public class C0846k extends C0506l {
    static final long serialVersionUID = 1;
    /* renamed from: a */
    private int f1778a;
    /* renamed from: b */
    private String f1779b;

    public C0846k(String str, int i, String str2) {
        super(str);
        this.f1778a = i;
        this.f1779b = str2;
    }

    /* renamed from: a */
    public int m2169a() {
        return this.f1778a;
    }

    /* renamed from: b */
    public String m2170b() {
        return this.f1779b;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{FacebookDialogException: ");
        stringBuilder.append("errorCode: ");
        stringBuilder.append(m2169a());
        stringBuilder.append(", message: ");
        stringBuilder.append(getMessage());
        stringBuilder.append(", url: ");
        stringBuilder.append(m2170b());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
