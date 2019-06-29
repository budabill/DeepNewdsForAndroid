package p014c.p015a.p016a.p019b.p020a;

/* renamed from: c.a.a.b.a.b */
final class C0280b {
    /* renamed from: a */
    private final C0279a f179a;
    /* renamed from: b */
    private final int[] f180b;

    C0280b(C0279a c0279a, int[] iArr) {
        if (iArr.length != 0) {
            this.f179a = c0279a;
            int length = iArr.length;
            if (length <= 1 || iArr[0] != 0) {
                this.f180b = iArr;
                return;
            }
            int i = 1;
            while (i < length && iArr[i] == 0) {
                i++;
            }
            if (i == length) {
                this.f180b = new int[]{0};
                return;
            }
            this.f180b = new int[(length - i)];
            Object obj = this.f180b;
            System.arraycopy(iArr, i, obj, 0, obj.length);
            return;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    int m194a(int i) {
        int[] iArr = this.f180b;
        return iArr[(iArr.length - 1) - i];
    }

    /* renamed from: a */
    C0280b m195a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f179a.m190b();
        } else {
            int length = this.f180b.length;
            int[] iArr = new int[(i + length)];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.f179a.m193c(this.f180b[i3], i2);
            }
            return new C0280b(this.f179a, iArr);
        }
    }

    /* renamed from: a */
    C0280b m196a(C0280b c0280b) {
        if (!this.f179a.equals(c0280b.f179a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (m201c()) {
            return c0280b;
        } else {
            if (c0280b.m201c()) {
                return this;
            }
            int[] iArr = this.f180b;
            Object obj = c0280b.f180b;
            if (iArr.length > obj.length) {
                Object obj2 = iArr;
                iArr = obj;
                obj = obj2;
            }
            Object obj3 = new int[obj.length];
            int length = obj.length - iArr.length;
            System.arraycopy(obj, 0, obj3, 0, length);
            for (int i = length; i < obj.length; i++) {
                obj3[i] = C0279a.m186a(iArr[i - length], obj[i]);
            }
            return new C0280b(this.f179a, obj3);
        }
    }

    /* renamed from: a */
    int[] m197a() {
        return this.f180b;
    }

    /* renamed from: b */
    int m198b() {
        return this.f180b.length - 1;
    }

    /* renamed from: b */
    C0280b[] m199b(C0280b c0280b) {
        if (!this.f179a.equals(c0280b.f179a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (c0280b.m201c()) {
            throw new IllegalArgumentException("Divide by 0");
        } else {
            C0280b b = this.f179a.m190b();
            int b2 = this.f179a.m189b(c0280b.m194a(c0280b.m198b()));
            C0280b c0280b2 = b;
            b = this;
            while (b.m198b() >= c0280b.m198b() && !b.m201c()) {
                int b3 = b.m198b() - c0280b.m198b();
                int c = this.f179a.m193c(b.m194a(b.m198b()), b2);
                C0280b a = c0280b.m195a(b3, c);
                c0280b2 = c0280b2.m196a(this.f179a.m191b(b3, c));
                b = b.m196a(a);
            }
            return new C0280b[]{c0280b2, b};
        }
    }

    /* renamed from: c */
    C0280b m200c(C0280b c0280b) {
        if (this.f179a.equals(c0280b.f179a)) {
            if (!m201c()) {
                if (!c0280b.m201c()) {
                    int[] iArr = this.f180b;
                    int length = iArr.length;
                    int[] iArr2 = c0280b.f180b;
                    int length2 = iArr2.length;
                    int[] iArr3 = new int[((length + length2) - 1)];
                    for (int i = 0; i < length; i++) {
                        int i2 = iArr[i];
                        for (int i3 = 0; i3 < length2; i3++) {
                            int i4 = i + i3;
                            iArr3[i4] = C0279a.m186a(iArr3[i4], this.f179a.m193c(i2, iArr2[i3]));
                        }
                    }
                    return new C0280b(this.f179a, iArr3);
                }
            }
            return this.f179a.m190b();
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    /* renamed from: c */
    boolean m201c() {
        return this.f180b[0] == 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(m198b() * 8);
        for (int b = m198b(); b >= 0; b--) {
            int a = m194a(b);
            if (a != 0) {
                if (a < 0) {
                    stringBuilder.append(" - ");
                    a = -a;
                } else if (stringBuilder.length() > 0) {
                    stringBuilder.append(" + ");
                }
                if (b == 0 || a != 1) {
                    char c;
                    a = this.f179a.m192c(a);
                    if (a == 0) {
                        c = '1';
                    } else if (a == 1) {
                        c = 'a';
                    } else {
                        stringBuilder.append("a^");
                        stringBuilder.append(a);
                    }
                    stringBuilder.append(c);
                }
                if (b != 0) {
                    if (b == 1) {
                        stringBuilder.append('x');
                    } else {
                        stringBuilder.append("x^");
                        stringBuilder.append(b);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
}
