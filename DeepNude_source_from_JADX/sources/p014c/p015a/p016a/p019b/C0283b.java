package p014c.p015a.p016a.p019b;

import java.util.Arrays;

/* renamed from: c.a.a.b.b */
public final class C0283b implements Cloneable {
    /* renamed from: a */
    private final int f185a;
    /* renamed from: b */
    private final int f186b;
    /* renamed from: c */
    private final int f187c;
    /* renamed from: d */
    private final int[] f188d;

    public C0283b(int i) {
        this(i, i);
    }

    public C0283b(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f185a = i;
        this.f186b = i2;
        this.f187c = (i + 31) / 32;
        this.f188d = new int[(this.f187c * i2)];
    }

    private C0283b(int i, int i2, int i3, int[] iArr) {
        this.f185a = i;
        this.f186b = i2;
        this.f187c = i3;
        this.f188d = iArr;
    }

    /* renamed from: a */
    private String m214a(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder(this.f186b * (this.f185a + 1));
        for (int i = 0; i < this.f186b; i++) {
            for (int i2 = 0; i2 < this.f185a; i2++) {
                stringBuilder.append(m218a(i2, i) ? str : str2);
            }
            stringBuilder.append(str3);
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public String m215a(String str, String str2) {
        return m214a(str, str2, "\n");
    }

    /* renamed from: a */
    public void m216a() {
        int length = this.f188d.length;
        for (int i = 0; i < length; i++) {
            this.f188d[i] = 0;
        }
    }

    /* renamed from: a */
    public void m217a(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        } else if (i4 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } else {
            i3 += i;
            i4 += i2;
            if (i4 > this.f186b || i3 > this.f185a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i2 < i4) {
                int i5 = this.f187c * i2;
                for (int i6 = i; i6 < i3; i6++) {
                    int[] iArr = this.f188d;
                    int i7 = (i6 / 32) + i5;
                    iArr[i7] = iArr[i7] | (1 << (i6 & 31));
                }
                i2++;
            }
        }
    }

    /* renamed from: a */
    public boolean m218a(int i, int i2) {
        return ((this.f188d[(i2 * this.f187c) + (i / 32)] >>> (i & 31)) & 1) != 0;
    }

    /* renamed from: b */
    public int m219b() {
        return this.f186b;
    }

    /* renamed from: b */
    public void m220b(int i, int i2) {
        i2 = (i2 * this.f187c) + (i / 32);
        int[] iArr = this.f188d;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }

    /* renamed from: c */
    public int m221c() {
        return this.f185a;
    }

    public C0283b clone() {
        return new C0283b(this.f185a, this.f186b, this.f187c, (int[]) this.f188d.clone());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0283b)) {
            return false;
        }
        C0283b c0283b = (C0283b) obj;
        return this.f185a == c0283b.f185a && this.f186b == c0283b.f186b && this.f187c == c0283b.f187c && Arrays.equals(this.f188d, c0283b.f188d);
    }

    public int hashCode() {
        int i = this.f185a;
        return (((((((i * 31) + i) * 31) + this.f186b) * 31) + this.f187c) * 31) + Arrays.hashCode(this.f188d);
    }

    public String toString() {
        return m215a("X ", "  ");
    }
}
