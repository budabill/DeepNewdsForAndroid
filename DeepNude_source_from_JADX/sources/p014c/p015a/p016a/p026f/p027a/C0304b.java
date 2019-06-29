package p014c.p015a.p016a.p026f.p027a;

/* renamed from: c.a.a.f.a.b */
public enum C0304b {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);
    
    /* renamed from: l */
    private final int[] f320l;
    /* renamed from: m */
    private final int f321m;

    private C0304b(int[] iArr, int i) {
        this.f320l = iArr;
        this.f321m = i;
    }

    /* renamed from: a */
    public int m324a() {
        return this.f321m;
    }

    /* renamed from: a */
    public int m325a(C0307c c0307c) {
        int c = c0307c.m337c();
        c = c <= 9 ? 0 : c <= 26 ? 1 : 2;
        return this.f320l[c];
    }
}
