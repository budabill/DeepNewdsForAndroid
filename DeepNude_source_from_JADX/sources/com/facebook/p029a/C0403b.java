package com.facebook.p029a;

import com.facebook.AccessToken;
import com.facebook.C0560t;
import com.facebook.internal.C0475Q;
import java.io.Serializable;

/* renamed from: com.facebook.a.b */
class C0403b implements Serializable {
    private static final long serialVersionUID = 1;
    /* renamed from: a */
    private final String f677a;
    /* renamed from: b */
    private final String f678b;

    /* renamed from: com.facebook.a.b$a */
    static class C0375a implements Serializable {
        private static final long serialVersionUID = -2488473066578201069L;
        /* renamed from: a */
        private final String f608a;
        /* renamed from: b */
        private final String f609b;

        private C0375a(String str, String str2) {
            this.f608a = str;
            this.f609b = str2;
        }

        private Object readResolve() {
            return new C0403b(this.f608a, this.f609b);
        }
    }

    public C0403b(AccessToken accessToken) {
        this(accessToken.m456j(), C0560t.m1253e());
    }

    public C0403b(String str, String str2) {
        if (C0475Q.m998b(str)) {
            str = null;
        }
        this.f677a = str;
        this.f678b = str2;
    }

    private Object writeReplace() {
        return new C0375a(this.f677a, this.f678b);
    }

    /* renamed from: a */
    public String m748a() {
        return this.f677a;
    }

    /* renamed from: b */
    public String m749b() {
        return this.f678b;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof C0403b)) {
            return false;
        }
        C0403b c0403b = (C0403b) obj;
        if (C0475Q.m991a(c0403b.f677a, this.f677a) && C0475Q.m991a(c0403b.f678b, this.f678b)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        String str = this.f677a;
        int i = 0;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.f678b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode ^ i;
    }
}
