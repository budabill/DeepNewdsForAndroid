package com.facebook;

/* renamed from: com.facebook.l */
public class C0506l extends RuntimeException {
    static final long serialVersionUID = 1;

    public C0506l(String str) {
        super(str);
    }

    public C0506l(String str, Throwable th) {
        super(str, th);
    }

    public C0506l(Throwable th) {
        super(th);
    }

    public String toString() {
        return getMessage();
    }
}
