package p014c.p015a.p016a.p021c.p022a;

/* renamed from: c.a.a.c.a.m */
final class C0902m extends C0804c {
    C0902m() {
    }

    /* renamed from: a */
    public int mo1600a() {
        return 2;
    }

    /* renamed from: a */
    int mo1601a(char c, StringBuilder stringBuilder) {
        if (c == ' ') {
            c = '\u0003';
        } else {
            int i;
            if (c >= '0' && c <= '9') {
                i = (c - 48) + 4;
            } else if (c < 'a' || c > 'z') {
                if (c < '\u0000' || c > '\u001f') {
                    int i2 = 33;
                    if (c >= '!' && c <= '/') {
                        stringBuilder.append('\u0001');
                    } else if (c >= ':' && c <= '@') {
                        stringBuilder.append('\u0001');
                        i = (c - 58) + 15;
                        c = (char) i;
                    } else if (c < '[' || c > '_') {
                        i2 = 96;
                        if (c == '`') {
                            stringBuilder.append('\u0002');
                        } else if (c >= 'A' && c <= 'Z') {
                            stringBuilder.append('\u0002');
                            i = (c - 65) + 1;
                            c = (char) i;
                        } else if (c >= '{' && c <= '') {
                            stringBuilder.append('\u0002');
                            i = (c - 123) + 27;
                            c = (char) i;
                        } else if (c >= '') {
                            stringBuilder.append("\u0001\u001e");
                            return mo1601a((char) (c - 128), stringBuilder) + 2;
                        } else {
                            C0290j.m265a(c);
                            throw null;
                        }
                    } else {
                        stringBuilder.append('\u0001');
                        i = (c - 91) + 22;
                        c = (char) i;
                    }
                    i = c - i2;
                    c = (char) i;
                } else {
                    stringBuilder.append('\u0000');
                }
                stringBuilder.append(c);
                return 2;
            } else {
                i = (c - 97) + 14;
            }
            c = (char) i;
        }
        stringBuilder.append(c);
        return 1;
    }
}
