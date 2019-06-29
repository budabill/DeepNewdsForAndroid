package p014c.p015a.p016a.p026f.p027a;

/* renamed from: c.a.a.f.a.c */
public final class C0307c {
    /* renamed from: a */
    private static final int[] f326a = new int[]{31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017};
    /* renamed from: b */
    private static final C0307c[] f327b = C0307c.m333d();
    /* renamed from: c */
    private final int f328c;
    /* renamed from: d */
    private final int[] f329d;
    /* renamed from: e */
    private final C0306b[] f330e;
    /* renamed from: f */
    private final int f331f;

    /* renamed from: c.a.a.f.a.c$a */
    public static final class C0305a {
        /* renamed from: a */
        private final int f322a;
        /* renamed from: b */
        private final int f323b;

        C0305a(int i, int i2) {
            this.f322a = i;
            this.f323b = i2;
        }

        /* renamed from: a */
        public int m326a() {
            return this.f322a;
        }

        /* renamed from: b */
        public int m327b() {
            return this.f323b;
        }
    }

    /* renamed from: c.a.a.f.a.c$b */
    public static final class C0306b {
        /* renamed from: a */
        private final int f324a;
        /* renamed from: b */
        private final C0305a[] f325b;

        C0306b(int i, C0305a... c0305aArr) {
            this.f324a = i;
            this.f325b = c0305aArr;
        }

        /* renamed from: a */
        public C0305a[] m328a() {
            return this.f325b;
        }

        /* renamed from: b */
        public int m329b() {
            return this.f324a;
        }

        /* renamed from: c */
        public int m330c() {
            int i = 0;
            for (C0305a a : this.f325b) {
                i += a.m326a();
            }
            return i;
        }

        /* renamed from: d */
        public int m331d() {
            return this.f324a * m330c();
        }
    }

    private C0307c(int i, int[] iArr, C0306b... c0306bArr) {
        this.f328c = i;
        this.f329d = iArr;
        this.f330e = c0306bArr;
        i = 0;
        int b = c0306bArr[0].m329b();
        C0305a[] a = c0306bArr[0].m328a();
        int length = a.length;
        int i2 = 0;
        while (i < length) {
            C0305a c0305a = a[i];
            i2 += c0305a.m326a() * (c0305a.m327b() + b);
            i++;
        }
        this.f331f = i2;
    }

    /* renamed from: a */
    public static C0307c m332a(int i) {
        if (i > 0 && i <= 40) {
            return f327b[i - 1];
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: d */
    private static C0307c[] m333d() {
        r0 = new C0307c[40];
        int[] iArr = new int[0];
        C0306b[] c0306bArr = new C0306b[4];
        c0306bArr[0] = new C0306b(7, new C0305a(1, 19));
        c0306bArr[1] = new C0306b(10, new C0305a(1, 16));
        c0306bArr[2] = new C0306b(13, new C0305a(1, 13));
        c0306bArr[3] = new C0306b(17, new C0305a(1, 9));
        r0[0] = new C0307c(1, iArr, c0306bArr);
        iArr = new int[]{6, 18};
        c0306bArr = new C0306b[4];
        c0306bArr[0] = new C0306b(10, new C0305a(1, 34));
        c0306bArr[1] = new C0306b(16, new C0305a(1, 28));
        c0306bArr[2] = new C0306b(22, new C0305a(1, 22));
        c0306bArr[3] = new C0306b(28, new C0305a(1, 16));
        r0[1] = new C0307c(2, iArr, c0306bArr);
        iArr = new int[]{6, 22};
        c0306bArr = new C0306b[4];
        c0306bArr[0] = new C0306b(15, new C0305a(1, 55));
        c0306bArr[1] = new C0306b(26, new C0305a(1, 44));
        c0306bArr[2] = new C0306b(18, new C0305a(2, 17));
        c0306bArr[3] = new C0306b(22, new C0305a(2, 13));
        r0[2] = new C0307c(3, iArr, c0306bArr);
        iArr = new int[]{6, 26};
        c0306bArr = new C0306b[4];
        c0306bArr[0] = new C0306b(20, new C0305a(1, 80));
        c0306bArr[1] = new C0306b(18, new C0305a(2, 32));
        c0306bArr[2] = new C0306b(26, new C0305a(2, 24));
        c0306bArr[3] = new C0306b(16, new C0305a(4, 9));
        r0[3] = new C0307c(4, iArr, c0306bArr);
        iArr = new int[]{6, 30};
        c0306bArr = new C0306b[4];
        c0306bArr[0] = new C0306b(26, new C0305a(1, 108));
        c0306bArr[1] = new C0306b(24, new C0305a(2, 43));
        c0306bArr[2] = new C0306b(18, new C0305a(2, 15), new C0305a(2, 16));
        c0306bArr[3] = new C0306b(22, new C0305a(2, 11), new C0305a(2, 12));
        r0[4] = new C0307c(5, iArr, c0306bArr);
        iArr = new int[]{6, 34};
        c0306bArr = new C0306b[4];
        c0306bArr[0] = new C0306b(18, new C0305a(2, 68));
        c0306bArr[1] = new C0306b(16, new C0305a(4, 27));
        c0306bArr[2] = new C0306b(24, new C0305a(4, 19));
        c0306bArr[3] = new C0306b(28, new C0305a(4, 15));
        r0[5] = new C0307c(6, iArr, c0306bArr);
        iArr = new int[]{6, 22, 38};
        c0306bArr = new C0306b[4];
        c0306bArr[0] = new C0306b(20, new C0305a(2, 78));
        c0306bArr[1] = new C0306b(18, new C0305a(4, 31));
        c0306bArr[2] = new C0306b(18, new C0305a(2, 14), new C0305a(4, 15));
        c0306bArr[3] = new C0306b(26, new C0305a(4, 13), new C0305a(1, 14));
        r0[6] = new C0307c(7, iArr, c0306bArr);
        iArr = new int[]{6, 24, 42};
        c0306bArr = new C0306b[4];
        c0306bArr[0] = new C0306b(24, new C0305a(2, 97));
        c0306bArr[1] = new C0306b(22, new C0305a(2, 38), new C0305a(2, 39));
        c0306bArr[2] = new C0306b(22, new C0305a(4, 18), new C0305a(2, 19));
        c0306bArr[3] = new C0306b(26, new C0305a(4, 14), new C0305a(2, 15));
        r0[7] = new C0307c(8, iArr, c0306bArr);
        iArr = new int[]{6, 26, 46};
        c0306bArr = new C0306b[4];
        c0306bArr[0] = new C0306b(30, new C0305a(2, 116));
        c0306bArr[1] = new C0306b(22, new C0305a(3, 36), new C0305a(2, 37));
        c0306bArr[2] = new C0306b(20, new C0305a(4, 16), new C0305a(4, 17));
        c0306bArr[3] = new C0306b(24, new C0305a(4, 12), new C0305a(4, 13));
        r0[8] = new C0307c(9, iArr, c0306bArr);
        iArr = new int[]{6, 28, 50};
        c0306bArr = new C0306b[4];
        c0306bArr[0] = new C0306b(18, new C0305a(2, 68), new C0305a(2, 69));
        c0306bArr[1] = new C0306b(26, new C0305a(4, 43), new C0305a(1, 44));
        c0306bArr[2] = new C0306b(24, new C0305a(6, 19), new C0305a(2, 20));
        c0306bArr[3] = new C0306b(28, new C0305a(6, 15), new C0305a(2, 16));
        r0[9] = new C0307c(10, iArr, c0306bArr);
        iArr = new int[]{6, 30, 54};
        c0306bArr = new C0306b[4];
        c0306bArr[0] = new C0306b(20, new C0305a(4, 81));
        c0306bArr[1] = new C0306b(30, new C0305a(1, 50), new C0305a(4, 51));
        c0306bArr[2] = new C0306b(28, new C0305a(4, 22), new C0305a(4, 23));
        c0306bArr[3] = new C0306b(24, new C0305a(3, 12), new C0305a(8, 13));
        r0[10] = new C0307c(11, iArr, c0306bArr);
        iArr = new int[]{6, 32, 58};
        c0306bArr = new C0306b[4];
        c0306bArr[0] = new C0306b(24, new C0305a(2, 92), new C0305a(2, 93));
        c0306bArr[1] = new C0306b(22, new C0305a(6, 36), new C0305a(2, 37));
        c0306bArr[2] = new C0306b(26, new C0305a(4, 20), new C0305a(6, 21));
        c0306bArr[3] = new C0306b(28, new C0305a(7, 14), new C0305a(4, 15));
        r0[11] = new C0307c(12, iArr, c0306bArr);
        iArr = new int[]{6, 34, 62};
        c0306bArr = new C0306b[4];
        c0306bArr[0] = new C0306b(26, new C0305a(4, 107));
        c0306bArr[1] = new C0306b(22, new C0305a(8, 37), new C0305a(1, 38));
        c0306bArr[2] = new C0306b(24, new C0305a(8, 20), new C0305a(4, 21));
        c0306bArr[3] = new C0306b(22, new C0305a(12, 11), new C0305a(4, 12));
        r0[12] = new C0307c(13, iArr, c0306bArr);
        iArr = new int[]{6, 26, 46, 66};
        c0306bArr = new C0306b[4];
        c0306bArr[0] = new C0306b(30, new C0305a(3, 115), new C0305a(1, 116));
        c0306bArr[1] = new C0306b(24, new C0305a(4, 40), new C0305a(5, 41));
        c0306bArr[2] = new C0306b(20, new C0305a(11, 16), new C0305a(5, 17));
        c0306bArr[3] = new C0306b(24, new C0305a(11, 12), new C0305a(5, 13));
        r0[13] = new C0307c(14, iArr, c0306bArr);
        iArr = new int[]{6, 26, 48, 70};
        c0306bArr = new C0306b[4];
        c0306bArr[0] = new C0306b(22, new C0305a(5, 87), new C0305a(1, 88));
        c0306bArr[1] = new C0306b(24, new C0305a(5, 41), new C0305a(5, 42));
        c0306bArr[2] = new C0306b(30, new C0305a(5, 24), new C0305a(7, 25));
        c0306bArr[3] = new C0306b(24, new C0305a(11, 12), new C0305a(7, 13));
        r0[14] = new C0307c(15, iArr, c0306bArr);
        iArr = new int[]{6, 26, 50, 74};
        c0306bArr = new C0306b[4];
        c0306bArr[0] = new C0306b(24, new C0305a(5, 98), new C0305a(1, 99));
        c0306bArr[1] = new C0306b(28, new C0305a(7, 45), new C0305a(3, 46));
        c0306bArr[2] = new C0306b(24, new C0305a(15, 19), new C0305a(2, 20));
        c0306bArr[3] = new C0306b(30, new C0305a(3, 15), new C0305a(13, 16));
        r0[15] = new C0307c(16, iArr, c0306bArr);
        iArr = new int[]{6, 30, 54, 78};
        c0306bArr = new C0306b[4];
        c0306bArr[0] = new C0306b(28, new C0305a(1, 107), new C0305a(5, 108));
        c0306bArr[1] = new C0306b(28, new C0305a(10, 46), new C0305a(1, 47));
        c0306bArr[2] = new C0306b(28, new C0305a(1, 22), new C0305a(15, 23));
        c0306bArr[3] = new C0306b(28, new C0305a(2, 14), new C0305a(17, 15));
        r0[16] = new C0307c(17, iArr, c0306bArr);
        iArr = new int[]{6, 30, 56, 82};
        c0306bArr = new C0306b[4];
        c0306bArr[0] = new C0306b(30, new C0305a(5, 120), new C0305a(1, 121));
        c0306bArr[1] = new C0306b(26, new C0305a(9, 43), new C0305a(4, 44));
        c0306bArr[2] = new C0306b(28, new C0305a(17, 22), new C0305a(1, 23));
        c0306bArr[3] = new C0306b(28, new C0305a(2, 14), new C0305a(19, 15));
        r0[17] = new C0307c(18, iArr, c0306bArr);
        iArr = new int[]{6, 30, 58, 86};
        c0306bArr = new C0306b[4];
        c0306bArr[0] = new C0306b(28, new C0305a(3, 113), new C0305a(4, 114));
        c0306bArr[1] = new C0306b(26, new C0305a(3, 44), new C0305a(11, 45));
        c0306bArr[2] = new C0306b(26, new C0305a(17, 21), new C0305a(4, 22));
        c0306bArr[3] = new C0306b(26, new C0305a(9, 13), new C0305a(16, 14));
        r0[18] = new C0307c(19, iArr, c0306bArr);
        iArr = new int[]{6, 34, 62, 90};
        c0306bArr = new C0306b[4];
        c0306bArr[0] = new C0306b(28, new C0305a(3, 107), new C0305a(5, 108));
        c0306bArr[1] = new C0306b(26, new C0305a(3, 41), new C0305a(13, 42));
        c0306bArr[2] = new C0306b(30, new C0305a(15, 24), new C0305a(5, 25));
        c0306bArr[3] = new C0306b(28, new C0305a(15, 15), new C0305a(10, 16));
        r0[19] = new C0307c(20, iArr, c0306bArr);
        int[] iArr2 = new int[]{6, 28, 50, 72, 94};
        r3 = new C0306b[4];
        r3[0] = new C0306b(28, new C0305a(4, 116), new C0305a(4, 117));
        r3[1] = new C0306b(26, new C0305a(17, 42));
        r3[2] = new C0306b(28, new C0305a(17, 22), new C0305a(6, 23));
        r3[3] = new C0306b(30, new C0305a(19, 16), new C0305a(6, 17));
        r0[20] = new C0307c(21, iArr2, r3);
        iArr2 = new int[]{6, 26, 50, 74, 98};
        r3 = new C0306b[4];
        r3[0] = new C0306b(28, new C0305a(2, 111), new C0305a(7, 112));
        r3[1] = new C0306b(28, new C0305a(17, 46));
        r3[2] = new C0306b(30, new C0305a(7, 24), new C0305a(16, 25));
        r3[3] = new C0306b(24, new C0305a(34, 13));
        r0[21] = new C0307c(22, iArr2, r3);
        iArr2 = new int[]{6, 30, 54, 78, 102};
        r6 = new C0306b[4];
        r6[0] = new C0306b(30, new C0305a(4, 121), new C0305a(5, 122));
        r6[1] = new C0306b(28, new C0305a(4, 47), new C0305a(14, 48));
        r6[2] = new C0306b(30, new C0305a(11, 24), new C0305a(14, 25));
        r6[3] = new C0306b(30, new C0305a(16, 15), new C0305a(14, 16));
        r0[22] = new C0307c(23, iArr2, r6);
        iArr2 = new int[]{6, 28, 54, 80, 106};
        r3 = new C0306b[4];
        r3[0] = new C0306b(30, new C0305a(6, 117), new C0305a(4, 118));
        r3[1] = new C0306b(28, new C0305a(6, 45), new C0305a(14, 46));
        r3[2] = new C0306b(30, new C0305a(11, 24), new C0305a(16, 25));
        r3[3] = new C0306b(30, new C0305a(30, 16), new C0305a(2, 17));
        r0[23] = new C0307c(24, iArr2, r3);
        iArr2 = new int[]{6, 32, 58, 84, 110};
        r3 = new C0306b[4];
        r3[0] = new C0306b(26, new C0305a(8, 106), new C0305a(4, 107));
        r3[1] = new C0306b(28, new C0305a(8, 47), new C0305a(13, 48));
        r3[2] = new C0306b(30, new C0305a(7, 24), new C0305a(22, 25));
        r3[3] = new C0306b(30, new C0305a(22, 15), new C0305a(13, 16));
        r0[24] = new C0307c(25, iArr2, r3);
        iArr2 = new int[]{6, 30, 58, 86, 114};
        r3 = new C0306b[4];
        r3[0] = new C0306b(28, new C0305a(10, 114), new C0305a(2, 115));
        r3[1] = new C0306b(28, new C0305a(19, 46), new C0305a(4, 47));
        r3[2] = new C0306b(28, new C0305a(28, 22), new C0305a(6, 23));
        r3[3] = new C0306b(30, new C0305a(33, 16), new C0305a(4, 17));
        r0[25] = new C0307c(26, iArr2, r3);
        iArr2 = new int[]{6, 34, 62, 90, 118};
        r3 = new C0306b[4];
        r3[0] = new C0306b(30, new C0305a(8, 122), new C0305a(4, 123));
        r3[1] = new C0306b(28, new C0305a(22, 45), new C0305a(3, 46));
        r3[2] = new C0306b(30, new C0305a(8, 23), new C0305a(26, 24));
        r3[3] = new C0306b(30, new C0305a(12, 15), new C0305a(28, 16));
        r0[26] = new C0307c(27, iArr2, r3);
        iArr2 = new int[]{6, 26, 50, 74, 98, 122};
        r3 = new C0306b[4];
        r3[0] = new C0306b(30, new C0305a(3, 117), new C0305a(10, 118));
        r3[1] = new C0306b(28, new C0305a(3, 45), new C0305a(23, 46));
        r3[2] = new C0306b(30, new C0305a(4, 24), new C0305a(31, 25));
        r3[3] = new C0306b(30, new C0305a(11, 15), new C0305a(31, 16));
        r0[27] = new C0307c(28, iArr2, r3);
        iArr2 = new int[]{6, 30, 54, 78, 102, 126};
        r3 = new C0306b[4];
        r3[0] = new C0306b(30, new C0305a(7, 116), new C0305a(7, 117));
        r3[1] = new C0306b(28, new C0305a(21, 45), new C0305a(7, 46));
        r3[2] = new C0306b(30, new C0305a(1, 23), new C0305a(37, 24));
        r3[3] = new C0306b(30, new C0305a(19, 15), new C0305a(26, 16));
        r0[28] = new C0307c(29, iArr2, r3);
        iArr2 = new int[]{6, 26, 52, 78, 104, 130};
        r3 = new C0306b[4];
        r3[0] = new C0306b(30, new C0305a(5, 115), new C0305a(10, 116));
        r3[1] = new C0306b(28, new C0305a(19, 47), new C0305a(10, 48));
        r3[2] = new C0306b(30, new C0305a(15, 24), new C0305a(25, 25));
        r3[3] = new C0306b(30, new C0305a(23, 15), new C0305a(25, 16));
        r0[29] = new C0307c(30, iArr2, r3);
        iArr2 = new int[]{6, 30, 56, 82, 108, 134};
        r3 = new C0306b[4];
        r3[0] = new C0306b(30, new C0305a(13, 115), new C0305a(3, 116));
        r3[1] = new C0306b(28, new C0305a(2, 46), new C0305a(29, 47));
        r3[2] = new C0306b(30, new C0305a(42, 24), new C0305a(1, 25));
        r3[3] = new C0306b(30, new C0305a(23, 15), new C0305a(28, 16));
        r0[30] = new C0307c(31, iArr2, r3);
        iArr2 = new int[]{6, 34, 60, 86, 112, 138};
        r3 = new C0306b[4];
        r3[0] = new C0306b(30, new C0305a(17, 115));
        r3[1] = new C0306b(28, new C0305a(10, 46), new C0305a(23, 47));
        r3[2] = new C0306b(30, new C0305a(10, 24), new C0305a(35, 25));
        r3[3] = new C0306b(30, new C0305a(19, 15), new C0305a(35, 16));
        r0[31] = new C0307c(32, iArr2, r3);
        iArr2 = new int[]{6, 30, 58, 86, 114, 142};
        r3 = new C0306b[4];
        r3[0] = new C0306b(30, new C0305a(17, 115), new C0305a(1, 116));
        r3[1] = new C0306b(28, new C0305a(14, 46), new C0305a(21, 47));
        r3[2] = new C0306b(30, new C0305a(29, 24), new C0305a(19, 25));
        r3[3] = new C0306b(30, new C0305a(11, 15), new C0305a(46, 16));
        r0[32] = new C0307c(33, iArr2, r3);
        iArr2 = new int[]{6, 34, 62, 90, 118, 146};
        r3 = new C0306b[4];
        r3[0] = new C0306b(30, new C0305a(13, 115), new C0305a(6, 116));
        r3[1] = new C0306b(28, new C0305a(14, 46), new C0305a(23, 47));
        r3[2] = new C0306b(30, new C0305a(44, 24), new C0305a(7, 25));
        r3[3] = new C0306b(30, new C0305a(59, 16), new C0305a(1, 17));
        r0[33] = new C0307c(34, iArr2, r3);
        iArr2 = new int[]{6, 30, 54, 78, 102, 126, 150};
        r3 = new C0306b[4];
        r3[0] = new C0306b(30, new C0305a(12, 121), new C0305a(7, 122));
        r3[1] = new C0306b(28, new C0305a(12, 47), new C0305a(26, 48));
        r3[2] = new C0306b(30, new C0305a(39, 24), new C0305a(14, 25));
        r3[3] = new C0306b(30, new C0305a(22, 15), new C0305a(41, 16));
        r0[34] = new C0307c(35, iArr2, r3);
        iArr2 = new int[]{6, 24, 50, 76, 102, 128, 154};
        r3 = new C0306b[4];
        r3[0] = new C0306b(30, new C0305a(6, 121), new C0305a(14, 122));
        r3[1] = new C0306b(28, new C0305a(6, 47), new C0305a(34, 48));
        r3[2] = new C0306b(30, new C0305a(46, 24), new C0305a(10, 25));
        r3[3] = new C0306b(30, new C0305a(2, 15), new C0305a(64, 16));
        r0[35] = new C0307c(36, iArr2, r3);
        iArr2 = new int[]{6, 28, 54, 80, 106, 132, 158};
        r3 = new C0306b[4];
        r3[0] = new C0306b(30, new C0305a(17, 122), new C0305a(4, 123));
        r3[1] = new C0306b(28, new C0305a(29, 46), new C0305a(14, 47));
        r3[2] = new C0306b(30, new C0305a(49, 24), new C0305a(10, 25));
        r3[3] = new C0306b(30, new C0305a(24, 15), new C0305a(46, 16));
        r0[36] = new C0307c(37, iArr2, r3);
        iArr2 = new int[]{6, 32, 58, 84, 110, 136, 162};
        r3 = new C0306b[4];
        r3[0] = new C0306b(30, new C0305a(4, 122), new C0305a(18, 123));
        r3[1] = new C0306b(28, new C0305a(13, 46), new C0305a(32, 47));
        r3[2] = new C0306b(30, new C0305a(48, 24), new C0305a(14, 25));
        r3[3] = new C0306b(30, new C0305a(42, 15), new C0305a(32, 16));
        r0[37] = new C0307c(38, iArr2, r3);
        iArr2 = new int[]{6, 26, 54, 82, 110, 138, 166};
        r3 = new C0306b[4];
        r3[0] = new C0306b(30, new C0305a(20, 117), new C0305a(4, 118));
        r3[1] = new C0306b(28, new C0305a(40, 47), new C0305a(7, 48));
        r3[2] = new C0306b(30, new C0305a(43, 24), new C0305a(22, 25));
        r3[3] = new C0306b(30, new C0305a(10, 15), new C0305a(67, 16));
        r0[38] = new C0307c(39, iArr2, r3);
        iArr = new int[]{6, 30, 58, 86, 114, 142, 170};
        r4 = new C0306b[4];
        r4[0] = new C0306b(30, new C0305a(19, 118), new C0305a(6, 119));
        r4[1] = new C0306b(28, new C0305a(18, 47), new C0305a(31, 48));
        r4[2] = new C0306b(30, new C0305a(34, 24), new C0305a(34, 25));
        r4[3] = new C0306b(30, new C0305a(20, 15), new C0305a(61, 16));
        r0[39] = new C0307c(40, iArr, r4);
        return r0;
    }

    /* renamed from: a */
    public int m334a() {
        return (this.f328c * 4) + 17;
    }

    /* renamed from: a */
    public C0306b m335a(C0303a c0303a) {
        return this.f330e[c0303a.ordinal()];
    }

    /* renamed from: b */
    public int m336b() {
        return this.f331f;
    }

    /* renamed from: c */
    public int m337c() {
        return this.f328c;
    }

    public String toString() {
        return String.valueOf(this.f328c);
    }
}
