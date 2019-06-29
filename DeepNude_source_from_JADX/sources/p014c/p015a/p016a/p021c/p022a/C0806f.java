package p014c.p015a.p016a.p021c.p022a;

/* renamed from: c.a.a.c.a.f */
final class C0806f implements C0287g {
    C0806f() {
    }

    /* renamed from: a */
    private static String m2088a(CharSequence charSequence, int i) {
        int length = charSequence.length() - i;
        if (length != 0) {
            char charAt = charSequence.charAt(i);
            int i2 = 0;
            int charAt2 = length >= 2 ? charSequence.charAt(i + 1) : 0;
            int charAt3 = length >= 3 ? charSequence.charAt(i + 2) : 0;
            if (length >= 4) {
                i2 = charSequence.charAt(i + 3);
            }
            int i3 = (((charAt << 18) + (charAt2 << 12)) + (charAt3 << 6)) + i2;
            char c = (char) ((i3 >> 16) & 255);
            charAt = (char) ((i3 >> 8) & 255);
            char c2 = (char) (i3 & 255);
            StringBuilder stringBuilder = new StringBuilder(3);
            stringBuilder.append(c);
            if (length >= 2) {
                stringBuilder.append(charAt);
            }
            if (length >= 3) {
                stringBuilder.append(c2);
            }
            return stringBuilder.toString();
        }
        throw new IllegalStateException("StringBuilder must not be empty");
    }

    /* renamed from: a */
    private static void m2089a(char c, StringBuilder stringBuilder) {
        if (c >= ' ' && c <= '?') {
            stringBuilder.append(c);
        } else if (c < '@' || c > '^') {
            C0290j.m265a(c);
            throw null;
        } else {
            stringBuilder.append((char) (c - 64));
        }
    }

    /* renamed from: a */
    private static void m2090a(C0288h c0288h, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length != 0) {
                int i = 1;
                if (length == 1) {
                    c0288h.m255k();
                    int a = c0288h.m251g().m277a() - c0288h.m238a();
                    if (c0288h.m250f() == 0 && a <= 2) {
                        c0288h.m245b(0);
                        return;
                    }
                }
                if (length <= 4) {
                    length--;
                    String a2 = C0806f.m2088a(charSequence, 0);
                    if ((c0288h.m252h() ^ 1) == 0 || length > 2) {
                        i = 0;
                    }
                    if (length <= 2) {
                        c0288h.m247c(c0288h.m238a() + length);
                        if (c0288h.m251g().m277a() - c0288h.m238a() >= 3) {
                            c0288h.m247c(c0288h.m238a() + a2.length());
                            i = 0;
                        }
                    }
                    if (i != 0) {
                        c0288h.m254j();
                        c0288h.f232f -= length;
                    } else {
                        c0288h.m243a(a2);
                    }
                    c0288h.m245b(0);
                    return;
                }
                throw new IllegalStateException("Count must not exceed 4");
            }
        } finally {
            c0288h.m245b(0);
        }
    }

    /* renamed from: a */
    public int m2091a() {
        return 4;
    }

    /* renamed from: a */
    public void mo942a(C0288h c0288h) {
        CharSequence stringBuilder = new StringBuilder();
        while (c0288h.m252h()) {
            C0806f.m2089a(c0288h.m246c(), (StringBuilder) stringBuilder);
            c0288h.f232f++;
            if (stringBuilder.length() >= 4) {
                c0288h.m243a(C0806f.m2088a(stringBuilder, 0));
                stringBuilder.delete(0, 4);
                if (C0290j.m261a(c0288h.m248d(), c0288h.f232f, m2091a()) != m2091a()) {
                    c0288h.m245b(0);
                    break;
                }
            }
        }
        stringBuilder.append('\u001f');
        C0806f.m2090a(c0288h, stringBuilder);
    }
}
