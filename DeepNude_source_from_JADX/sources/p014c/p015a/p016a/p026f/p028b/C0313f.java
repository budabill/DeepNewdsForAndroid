package p014c.p015a.p016a.p026f.p028b;

import p014c.p015a.p016a.C0318j;
import p014c.p015a.p016a.p019b.C0282a;
import p014c.p015a.p016a.p026f.p027a.C0303a;
import p014c.p015a.p016a.p026f.p027a.C0307c;

/* renamed from: c.a.a.f.b.f */
final class C0313f {
    /* renamed from: a */
    private static final int[][] f339a = new int[][]{new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    /* renamed from: b */
    private static final int[][] f340b = new int[][]{new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    /* renamed from: c */
    private static final int[][] f341c = new int[][]{new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};
    /* renamed from: d */
    private static final int[][] f342d = new int[][]{new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    /* renamed from: a */
    static int m377a(int i) {
        return 32 - Integer.numberOfLeadingZeros(i);
    }

    /* renamed from: a */
    static int m378a(int i, int i2) {
        if (i2 != 0) {
            int a = C0313f.m377a(i2);
            i <<= a - 1;
            while (C0313f.m377a(i) >= a) {
                i ^= i2 << (C0313f.m377a(i) - a);
            }
            return i;
        }
        throw new IllegalArgumentException("0 polynomial");
    }

    /* renamed from: a */
    private static void m379a(int i, int i2, C0309b c0309b) {
        int i3 = 0;
        while (i3 < 8) {
            int i4 = i + i3;
            if (C0313f.m390b(c0309b.m340a(i4, i2))) {
                c0309b.m342a(i4, i2, 0);
                i3++;
            } else {
                throw new C0318j();
            }
        }
    }

    /* renamed from: a */
    static void m380a(C0282a c0282a, int i, C0309b c0309b) {
        int c = c0309b.m346c() - 1;
        int b = c0309b.m345b() - 1;
        int i2 = 0;
        int i3 = -1;
        while (c > 0) {
            if (c == 6) {
                c--;
            }
            while (b >= 0 && b < c0309b.m345b()) {
                int i4 = i2;
                for (i2 = 0; i2 < 2; i2++) {
                    int i5 = c - i2;
                    if (C0313f.m390b(c0309b.m340a(i5, b))) {
                        boolean a;
                        if (i4 < c0282a.m206a()) {
                            a = c0282a.m211a(i4);
                            i4++;
                        } else {
                            a = false;
                        }
                        if (i != -1 && C0312e.m371a(i, i5, b)) {
                            a = !a;
                        }
                        c0309b.m343a(i5, b, a);
                    }
                }
                b += i3;
                i2 = i4;
            }
            i3 = -i3;
            b += i3;
            c -= 2;
        }
        if (i2 != c0282a.m206a()) {
            StringBuilder stringBuilder = new StringBuilder("Not all bits consumed: ");
            stringBuilder.append(i2);
            stringBuilder.append('/');
            stringBuilder.append(c0282a.m206a());
            throw new C0318j(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    static void m381a(C0282a c0282a, C0303a c0303a, C0307c c0307c, int i, C0309b c0309b) {
        C0313f.m386a(c0309b);
        C0313f.m385a(c0307c, c0309b);
        C0313f.m383a(c0303a, i, c0309b);
        C0313f.m388b(c0307c, c0309b);
        C0313f.m380a(c0282a, i, c0309b);
    }

    /* renamed from: a */
    static void m382a(C0303a c0303a, int i, C0282a c0282a) {
        if (C0314g.m396a(i)) {
            int a = (c0303a.m323a() << 3) | i;
            c0282a.m207a(a, 5);
            c0282a.m207a(C0313f.m378a(a, 1335), 10);
            C0282a c0282a2 = new C0282a();
            c0282a2.m207a(21522, 15);
            c0282a.m213b(c0282a2);
            if (c0282a.m206a() != 15) {
                StringBuilder stringBuilder = new StringBuilder("should not happen but we got: ");
                stringBuilder.append(c0282a.m206a());
                throw new C0318j(stringBuilder.toString());
            }
            return;
        }
        throw new C0318j("Invalid mask pattern");
    }

    /* renamed from: a */
    static void m383a(C0303a c0303a, int i, C0309b c0309b) {
        C0282a c0282a = new C0282a();
        C0313f.m382a(c0303a, i, c0282a);
        for (i = 0; i < c0282a.m206a(); i++) {
            boolean a = c0282a.m211a((c0282a.m206a() - 1) - i);
            int[][] iArr = f342d;
            c0309b.m343a(iArr[i][0], iArr[i][1], a);
            if (i < 8) {
                c0309b.m343a((c0309b.m346c() - i) - 1, 8, a);
            } else {
                c0309b.m343a(8, (c0309b.m345b() - 7) + (i - 8), a);
            }
        }
    }

    /* renamed from: a */
    static void m384a(C0307c c0307c, C0282a c0282a) {
        c0282a.m207a(c0307c.m337c(), 6);
        c0282a.m207a(C0313f.m378a(c0307c.m337c(), 7973), 12);
        if (c0282a.m206a() != 18) {
            StringBuilder stringBuilder = new StringBuilder("should not happen but we got: ");
            stringBuilder.append(c0282a.m206a());
            throw new C0318j(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    static void m385a(C0307c c0307c, C0309b c0309b) {
        C0313f.m393c(c0309b);
        C0313f.m389b(c0309b);
        C0313f.m392c(c0307c, c0309b);
        C0313f.m395d(c0309b);
    }

    /* renamed from: a */
    static void m386a(C0309b c0309b) {
        c0309b.m341a((byte) -1);
    }

    /* renamed from: b */
    private static void m387b(int i, int i2, C0309b c0309b) {
        for (int i3 = 0; i3 < 5; i3++) {
            for (int i4 = 0; i4 < 5; i4++) {
                c0309b.m342a(i + i4, i2 + i3, f340b[i3][i4]);
            }
        }
    }

    /* renamed from: b */
    static void m388b(C0307c c0307c, C0309b c0309b) {
        if (c0307c.m337c() >= 7) {
            C0282a c0282a = new C0282a();
            C0313f.m384a(c0307c, c0282a);
            int i = 0;
            int i2 = 17;
            while (i < 6) {
                int i3 = i2;
                for (i2 = 0; i2 < 3; i2++) {
                    boolean a = c0282a.m211a(i3);
                    i3--;
                    c0309b.m343a(i, (c0309b.m345b() - 11) + i2, a);
                    c0309b.m343a((c0309b.m345b() - 11) + i2, i, a);
                }
                i++;
                i2 = i3;
            }
        }
    }

    /* renamed from: b */
    private static void m389b(C0309b c0309b) {
        if (c0309b.m340a(8, c0309b.m345b() - 8) != (byte) 0) {
            c0309b.m342a(8, c0309b.m345b() - 8, 1);
            return;
        }
        throw new C0318j();
    }

    /* renamed from: b */
    private static boolean m390b(int i) {
        return i == -1;
    }

    /* renamed from: c */
    private static void m391c(int i, int i2, C0309b c0309b) {
        for (int i3 = 0; i3 < 7; i3++) {
            for (int i4 = 0; i4 < 7; i4++) {
                c0309b.m342a(i + i4, i2 + i3, f339a[i3][i4]);
            }
        }
    }

    /* renamed from: c */
    private static void m392c(C0307c c0307c, C0309b c0309b) {
        if (c0307c.m337c() >= 2) {
            int c = c0307c.m337c() - 1;
            int[][] iArr = f341c;
            int[] iArr2 = iArr[c];
            c = iArr[c].length;
            for (int i = 0; i < c; i++) {
                for (int i2 = 0; i2 < c; i2++) {
                    int i3 = iArr2[i];
                    int i4 = iArr2[i2];
                    if (!(i4 == -1 || i3 == -1 || !C0313f.m390b(c0309b.m340a(i4, i3)))) {
                        C0313f.m387b(i4 - 2, i3 - 2, c0309b);
                    }
                }
            }
        }
    }

    /* renamed from: c */
    private static void m393c(C0309b c0309b) {
        int length = f339a[0].length;
        C0313f.m391c(0, 0, c0309b);
        C0313f.m391c(c0309b.m346c() - length, 0, c0309b);
        C0313f.m391c(0, c0309b.m346c() - length, c0309b);
        C0313f.m379a(0, 7, c0309b);
        C0313f.m379a(c0309b.m346c() - 8, 7, c0309b);
        C0313f.m379a(0, c0309b.m346c() - 8, c0309b);
        C0313f.m394d(7, 0, c0309b);
        C0313f.m394d((c0309b.m345b() - 7) - 1, 0, c0309b);
        C0313f.m394d(7, c0309b.m345b() - 7, c0309b);
    }

    /* renamed from: d */
    private static void m394d(int i, int i2, C0309b c0309b) {
        int i3 = 0;
        while (i3 < 7) {
            int i4 = i2 + i3;
            if (C0313f.m390b(c0309b.m340a(i, i4))) {
                c0309b.m342a(i, i4, 0);
                i3++;
            } else {
                throw new C0318j();
            }
        }
    }

    /* renamed from: d */
    private static void m395d(C0309b c0309b) {
        int i = 8;
        while (i < c0309b.m346c() - 8) {
            int i2 = i + 1;
            int i3 = i2 % 2;
            if (C0313f.m390b(c0309b.m340a(i, 6))) {
                c0309b.m342a(i, 6, i3);
            }
            if (C0313f.m390b(c0309b.m340a(6, i))) {
                c0309b.m342a(6, i, i3);
            }
            i = i2;
        }
    }
}
