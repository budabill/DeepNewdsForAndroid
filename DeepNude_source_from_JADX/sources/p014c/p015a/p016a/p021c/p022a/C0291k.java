package p014c.p015a.p016a.p021c.p022a;

import p014c.p015a.p016a.C0285b;

/* renamed from: c.a.a.c.a.k */
public class C0291k {
    /* renamed from: a */
    static final C0291k[] f240a;
    /* renamed from: b */
    private static C0291k[] f241b;
    /* renamed from: c */
    private final boolean f242c;
    /* renamed from: d */
    private final int f243d;
    /* renamed from: e */
    private final int f244e;
    /* renamed from: f */
    public final int f245f;
    /* renamed from: g */
    public final int f246g;
    /* renamed from: h */
    private final int f247h;
    /* renamed from: i */
    private final int f248i;
    /* renamed from: j */
    private final int f249j;

    static {
        C0291k[] c0291kArr = new C0291k[]{new C0291k(false, 3, 5, 8, 8, 1), new C0291k(false, 5, 7, 10, 10, 1), new C0291k(true, 5, 7, 16, 6, 1), new C0291k(false, 8, 10, 12, 12, 1), new C0291k(true, 10, 11, 14, 6, 2), new C0291k(false, 12, 12, 14, 14, 1), new C0291k(true, 16, 14, 24, 10, 1), new C0291k(false, 18, 14, 16, 16, 1), new C0291k(false, 22, 18, 18, 18, 1), new C0291k(true, 22, 18, 16, 10, 2), new C0291k(false, 30, 20, 20, 20, 1), new C0291k(true, 32, 24, 16, 14, 2), new C0291k(false, 36, 24, 22, 22, 1), new C0291k(false, 44, 28, 24, 24, 1), new C0291k(true, 49, 28, 22, 14, 2), new C0291k(false, 62, 36, 14, 14, 4), new C0291k(false, 86, 42, 16, 16, 4), new C0291k(false, 114, 48, 18, 18, 4), new C0291k(false, 144, 56, 20, 20, 4), new C0291k(false, 174, 68, 22, 22, 4), new C0291k(false, 204, 84, 24, 24, 4, 102, 42), new C0291k(false, 280, 112, 14, 14, 16, 140, 56), new C0291k(false, 368, 144, 16, 16, 16, 92, 36), new C0291k(false, 456, 192, 18, 18, 16, 114, 48), new C0291k(false, 576, 224, 20, 20, 16, 144, 56), new C0291k(false, 696, 272, 22, 22, 16, 174, 68), new C0291k(false, 816, 336, 24, 24, 16, 136, 56), new C0291k(false, 1050, 408, 18, 18, 36, 175, 68), new C0291k(false, 1304, 496, 20, 20, 36, 163, 62), new C0805d()};
        f240a = c0291kArr;
        f241b = c0291kArr;
    }

    public C0291k(boolean z, int i, int i2, int i3, int i4, int i5) {
        this(z, i, i2, i3, i4, i5, i, i2);
    }

    C0291k(boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f242c = z;
        this.f243d = i;
        this.f244e = i2;
        this.f245f = i3;
        this.f246g = i4;
        this.f247h = i5;
        this.f248i = i6;
        this.f249j = i7;
    }

    /* renamed from: a */
    public static C0291k m274a(int i, C0292l c0292l, C0285b c0285b, C0285b c0285b2, boolean z) {
        for (C0291k c0291k : f241b) {
            if ((c0292l != C0292l.FORCE_SQUARE || !c0291k.f242c) && ((c0292l != C0292l.FORCE_RECTANGLE || c0291k.f242c) && ((c0285b == null || (c0291k.m285g() >= c0285b.m225b() && c0291k.m284f() >= c0285b.m224a())) && ((c0285b2 == null || (c0291k.m285g() <= c0285b2.m225b() && c0291k.m284f() <= c0285b2.m224a())) && i <= c0291k.f243d)))) {
                return c0291k;
            }
        }
        if (!z) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("Can't find a symbol arrangement that matches the message. Data codewords: ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: h */
    private int m275h() {
        int i = this.f247h;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (!(i == 2 || i == 4)) {
                if (i == 16) {
                    return 4;
                }
                if (i == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return i2;
    }

    /* renamed from: i */
    private int m276i() {
        int i = this.f247h;
        if (i == 1 || i == 2) {
            return 1;
        }
        if (i == 4) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    /* renamed from: a */
    public final int m277a() {
        return this.f243d;
    }

    /* renamed from: a */
    public int mo943a(int i) {
        return this.f248i;
    }

    /* renamed from: b */
    public final int m279b() {
        return this.f244e;
    }

    /* renamed from: b */
    public final int m280b(int i) {
        return this.f249j;
    }

    /* renamed from: c */
    public int mo944c() {
        return this.f243d / this.f248i;
    }

    /* renamed from: d */
    public final int m282d() {
        return m276i() * this.f246g;
    }

    /* renamed from: e */
    public final int m283e() {
        return m275h() * this.f245f;
    }

    /* renamed from: f */
    public final int m284f() {
        return m282d() + (m276i() << 1);
    }

    /* renamed from: g */
    public final int m285g() {
        return m283e() + (m275h() << 1);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f242c ? "Rectangular Symbol:" : "Square Symbol:");
        stringBuilder.append(" data region ");
        stringBuilder.append(this.f245f);
        stringBuilder.append('x');
        stringBuilder.append(this.f246g);
        stringBuilder.append(", symbol size ");
        stringBuilder.append(m285g());
        stringBuilder.append('x');
        stringBuilder.append(m284f());
        stringBuilder.append(", symbol data size ");
        stringBuilder.append(m283e());
        stringBuilder.append('x');
        stringBuilder.append(m282d());
        stringBuilder.append(", codewords ");
        stringBuilder.append(this.f243d);
        stringBuilder.append('+');
        stringBuilder.append(this.f244e);
        return stringBuilder.toString();
    }
}
