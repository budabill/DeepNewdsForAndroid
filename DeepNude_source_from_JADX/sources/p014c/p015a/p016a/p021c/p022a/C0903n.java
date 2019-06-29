package p014c.p015a.p016a.p021c.p022a;

/* renamed from: c.a.a.c.a.n */
final class C0903n extends C0804c {
    C0903n() {
    }

    /* renamed from: a */
    public int mo1600a() {
        return 3;
    }

    /* renamed from: a */
    int mo1601a(char c, StringBuilder stringBuilder) {
        if (c == '\r') {
            c = '\u0000';
        } else if (c == '*') {
            stringBuilder.append('\u0001');
            return 1;
        } else if (c == '>') {
            c = '\u0002';
        } else if (c == ' ') {
            c = '\u0003';
        } else {
            int i;
            if (c >= '0' && c <= '9') {
                i = (c - 48) + 4;
            } else if (c < 'A' || c > 'Z') {
                C0290j.m265a(c);
                throw null;
            } else {
                i = (c - 65) + 14;
            }
            c = (char) i;
        }
        stringBuilder.append(c);
        return 1;
    }

    /* renamed from: a */
    public void mo942a(C0288h c0288h) {
        StringBuilder stringBuilder = new StringBuilder();
        while (c0288h.m252h()) {
            char c = c0288h.m246c();
            c0288h.f232f++;
            mo1601a(c, stringBuilder);
            if (stringBuilder.length() % 3 == 0) {
                C0804c.m2081b(c0288h, stringBuilder);
                int a = C0290j.m261a(c0288h.m248d(), c0288h.f232f, mo1600a());
                if (a != mo1600a()) {
                    c0288h.m245b(a);
                    break;
                }
            }
        }
        mo1602a(c0288h, stringBuilder);
    }

    /* renamed from: a */
    void mo1602a(C0288h c0288h, StringBuilder stringBuilder) {
        c0288h.m255k();
        int a = c0288h.m251g().m277a() - c0288h.m238a();
        c0288h.f232f -= stringBuilder.length();
        if (c0288h.m250f() > 1 || a > 1 || c0288h.m250f() != a) {
            c0288h.m239a('þ');
        }
        if (c0288h.m249e() < 0) {
            c0288h.m245b(0);
        }
    }
}
