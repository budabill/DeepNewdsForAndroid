package p014c.p015a.p016a.p021c.p022a;

/* renamed from: c.a.a.c.a.a */
final class C0802a implements C0287g {
    C0802a() {
    }

    /* renamed from: a */
    private static char m2073a(char c, char c2) {
        if (C0290j.m266b(c) && C0290j.m266b(c2)) {
            return (char) ((((c - 48) * 10) + (c2 - 48)) + 130);
        }
        StringBuilder stringBuilder = new StringBuilder("not digits: ");
        stringBuilder.append(c);
        stringBuilder.append(c2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public int m2074a() {
        return 0;
    }

    /* renamed from: a */
    public void mo942a(C0288h c0288h) {
        if (C0290j.m260a(c0288h.m248d(), c0288h.f232f) >= 2) {
            c0288h.m239a(C0802a.m2073a(c0288h.m248d().charAt(c0288h.f232f), c0288h.m248d().charAt(c0288h.f232f + 1)));
            c0288h.f232f += 2;
            return;
        }
        char c = c0288h.m246c();
        int a = C0290j.m261a(c0288h.m248d(), c0288h.f232f, m2074a());
        if (a != m2074a()) {
            if (a == 1) {
                c0288h.m239a('æ');
                c0288h.m245b(1);
            } else if (a == 2) {
                c0288h.m239a('ï');
                c0288h.m245b(2);
            } else if (a == 3) {
                c0288h.m239a('î');
                c0288h.m245b(3);
            } else if (a == 4) {
                c0288h.m239a('ð');
                c0288h.m245b(4);
            } else if (a == 5) {
                c0288h.m239a('ç');
                c0288h.m245b(5);
            } else {
                StringBuilder stringBuilder = new StringBuilder("Illegal mode: ");
                stringBuilder.append(a);
                throw new IllegalStateException(stringBuilder.toString());
            }
        } else if (C0290j.m267c(c)) {
            c0288h.m239a('ë');
            c0288h.m239a((char) ((c - 128) + 1));
            c0288h.f232f++;
        } else {
            c0288h.m239a((char) (c + 1));
            c0288h.f232f++;
        }
    }
}
