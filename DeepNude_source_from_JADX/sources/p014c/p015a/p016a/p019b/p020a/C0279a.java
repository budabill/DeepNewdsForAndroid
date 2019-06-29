package p014c.p015a.p016a.p019b.p020a;

/* renamed from: c.a.a.b.a.a */
public final class C0279a {
    /* renamed from: a */
    public static final C0279a f164a = new C0279a(4201, 4096, 1);
    /* renamed from: b */
    public static final C0279a f165b = new C0279a(1033, 1024, 1);
    /* renamed from: c */
    public static final C0279a f166c = new C0279a(67, 64, 1);
    /* renamed from: d */
    public static final C0279a f167d = new C0279a(19, 16, 1);
    /* renamed from: e */
    public static final C0279a f168e = new C0279a(285, 256, 0);
    /* renamed from: f */
    public static final C0279a f169f;
    /* renamed from: g */
    public static final C0279a f170g;
    /* renamed from: h */
    public static final C0279a f171h = f166c;
    /* renamed from: i */
    private final int[] f172i;
    /* renamed from: j */
    private final int[] f173j;
    /* renamed from: k */
    private final C0280b f174k;
    /* renamed from: l */
    private final C0280b f175l;
    /* renamed from: m */
    private final int f176m;
    /* renamed from: n */
    private final int f177n;
    /* renamed from: o */
    private final int f178o;

    static {
        C0279a c0279a = new C0279a(301, 256, 1);
        f169f = c0279a;
        f170g = c0279a;
    }

    public C0279a(int i, int i2, int i3) {
        this.f177n = i;
        this.f176m = i2;
        this.f178o = i3;
        this.f172i = new int[i2];
        this.f173j = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.f172i[i5] = i4;
            i4 <<= 1;
            if (i4 >= i2) {
                i4 = (i4 ^ i) & (i2 - 1);
            }
        }
        for (i = 0; i < i2 - 1; i++) {
            this.f173j[this.f172i[i]] = i;
        }
        this.f174k = new C0280b(this, new int[]{0});
        this.f175l = new C0280b(this, new int[]{1});
    }

    /* renamed from: a */
    static int m186a(int i, int i2) {
        return i ^ i2;
    }

    /* renamed from: a */
    public int m187a() {
        return this.f178o;
    }

    /* renamed from: a */
    int m188a(int i) {
        return this.f172i[i];
    }

    /* renamed from: b */
    int m189b(int i) {
        if (i != 0) {
            return this.f172i[(this.f176m - this.f173j[i]) - 1];
        }
        throw new ArithmeticException();
    }

    /* renamed from: b */
    C0280b m190b() {
        return this.f174k;
    }

    /* renamed from: b */
    C0280b m191b(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f174k;
        } else {
            int[] iArr = new int[(i + 1)];
            iArr[0] = i2;
            return new C0280b(this, iArr);
        }
    }

    /* renamed from: c */
    int m192c(int i) {
        if (i != 0) {
            return this.f173j[i];
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: c */
    int m193c(int i, int i2) {
        if (i != 0) {
            if (i2 != 0) {
                int[] iArr = this.f172i;
                int[] iArr2 = this.f173j;
                return iArr[(iArr2[i] + iArr2[i2]) % (this.f176m - 1)];
            }
        }
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("GF(0x");
        stringBuilder.append(Integer.toHexString(this.f177n));
        stringBuilder.append(',');
        stringBuilder.append(this.f176m);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
