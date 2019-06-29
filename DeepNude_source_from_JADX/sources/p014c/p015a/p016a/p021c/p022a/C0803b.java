package p014c.p015a.p016a.p021c.p022a;

import android.support.v4.view.InputDeviceCompat;

/* renamed from: c.a.a.c.a.b */
final class C0803b implements C0287g {
    C0803b() {
    }

    /* renamed from: a */
    private static char m2076a(char c, int i) {
        int i2 = c + (((i * 149) % 255) + 1);
        return i2 <= 255 ? (char) i2 : (char) (i2 + InputDeviceCompat.SOURCE_ANY);
    }

    /* renamed from: a */
    public int m2077a() {
        return 5;
    }

    /* renamed from: a */
    public void mo942a(C0288h c0288h) {
        int a;
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        stringBuilder.append('\u0000');
        while (c0288h.m252h()) {
            stringBuilder.append(c0288h.m246c());
            c0288h.f232f++;
            a = C0290j.m261a(c0288h.m248d(), c0288h.f232f, m2077a());
            if (a != m2077a()) {
                c0288h.m245b(a);
                break;
            }
        }
        a = stringBuilder.length() - 1;
        int a2 = (c0288h.m238a() + a) + 1;
        c0288h.m247c(a2);
        Object obj = c0288h.m251g().m277a() - a2 > 0 ? 1 : null;
        if (c0288h.m252h() || obj != null) {
            if (a <= 249) {
                stringBuilder.setCharAt(0, (char) a);
            } else if (a <= 1555) {
                stringBuilder.setCharAt(0, (char) ((a / 250) + 249));
                stringBuilder.insert(1, (char) (a % 250));
            } else {
                stringBuilder = new StringBuilder("Message length not in valid ranges: ");
                stringBuilder.append(a);
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
        a = stringBuilder.length();
        while (i < a) {
            c0288h.m239a(C0803b.m2076a(stringBuilder.charAt(i), c0288h.m238a() + 1));
            i++;
        }
    }
}
