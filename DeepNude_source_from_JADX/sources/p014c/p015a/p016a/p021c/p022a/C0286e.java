package p014c.p015a.p016a.p021c.p022a;

import java.util.Arrays;

/* renamed from: c.a.a.c.a.e */
public class C0286e {
    /* renamed from: a */
    private final CharSequence f223a;
    /* renamed from: b */
    private final int f224b;
    /* renamed from: c */
    private final int f225c;
    /* renamed from: d */
    private final byte[] f226d;

    public C0286e(CharSequence charSequence, int i, int i2) {
        this.f223a = charSequence;
        this.f225c = i;
        this.f224b = i2;
        this.f226d = new byte[(i * i2)];
        Arrays.fill(this.f226d, (byte) -1);
    }

    /* renamed from: a */
    private void m226a(int i) {
        m228a(this.f224b - 1, 0, i, 1);
        m228a(this.f224b - 1, 1, i, 2);
        m228a(this.f224b - 1, 2, i, 3);
        m228a(0, this.f225c - 2, i, 4);
        m228a(0, this.f225c - 1, i, 5);
        m228a(1, this.f225c - 1, i, 6);
        m228a(2, this.f225c - 1, i, 7);
        m228a(3, this.f225c - 1, i, 8);
    }

    /* renamed from: a */
    private void m227a(int i, int i2, int i3) {
        int i4 = i - 2;
        int i5 = i2 - 2;
        m228a(i4, i5, i3, 1);
        int i6 = i2 - 1;
        m228a(i4, i6, i3, 2);
        i4 = i - 1;
        m228a(i4, i5, i3, 3);
        m228a(i4, i6, i3, 4);
        m228a(i4, i2, i3, 5);
        m228a(i, i5, i3, 6);
        m228a(i, i6, i3, 7);
        m228a(i, i2, i3, 8);
    }

    /* renamed from: a */
    private void m228a(int i, int i2, int i3, int i4) {
        if (i < 0) {
            int i5 = this.f224b;
            i += i5;
            i2 += 4 - ((i5 + 4) % 8);
        }
        if (i2 < 0) {
            i5 = this.f225c;
            i2 += i5;
            i += 4 - ((i5 + 4) % 8);
        }
        boolean z = true;
        if ((this.f223a.charAt(i3) & (1 << (8 - i4))) == 0) {
            z = false;
        }
        m229a(i2, i, z);
    }

    /* renamed from: a */
    private void m229a(int i, int i2, boolean z) {
        this.f226d[(i2 * this.f225c) + i] = (byte) z;
    }

    /* renamed from: b */
    private void m230b(int i) {
        m228a(this.f224b - 3, 0, i, 1);
        m228a(this.f224b - 2, 0, i, 2);
        m228a(this.f224b - 1, 0, i, 3);
        m228a(0, this.f225c - 4, i, 4);
        m228a(0, this.f225c - 3, i, 5);
        m228a(0, this.f225c - 2, i, 6);
        m228a(0, this.f225c - 1, i, 7);
        m228a(1, this.f225c - 1, i, 8);
    }

    /* renamed from: b */
    private boolean m231b(int i, int i2) {
        return this.f226d[(i2 * this.f225c) + i] >= (byte) 0;
    }

    /* renamed from: c */
    private void m232c(int i) {
        m228a(this.f224b - 3, 0, i, 1);
        m228a(this.f224b - 2, 0, i, 2);
        m228a(this.f224b - 1, 0, i, 3);
        m228a(0, this.f225c - 2, i, 4);
        m228a(0, this.f225c - 1, i, 5);
        m228a(1, this.f225c - 1, i, 6);
        m228a(2, this.f225c - 1, i, 7);
        m228a(3, this.f225c - 1, i, 8);
    }

    /* renamed from: d */
    private void m233d(int i) {
        m228a(this.f224b - 1, 0, i, 1);
        m228a(this.f224b - 1, this.f225c - 1, i, 2);
        m228a(0, this.f225c - 3, i, 3);
        m228a(0, this.f225c - 2, i, 4);
        m228a(0, this.f225c - 1, i, 5);
        m228a(1, this.f225c - 3, i, 6);
        m228a(1, this.f225c - 2, i, 7);
        m228a(1, this.f225c - 1, i, 8);
    }

    /* renamed from: a */
    public final void m234a() {
        int i = 4;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4;
            int i5;
            if (i == this.f224b && r2 == 0) {
                i4 = i3 + 1;
                m226a(i3);
                i3 = i4;
            }
            if (i == this.f224b - 2 && r2 == 0 && this.f225c % 4 != 0) {
                i4 = i3 + 1;
                m230b(i3);
                i3 = i4;
            }
            if (i == this.f224b - 2 && r2 == 0 && this.f225c % 8 == 4) {
                i4 = i3 + 1;
                m232c(i3);
                i3 = i4;
            }
            if (i == this.f224b + 4 && r2 == 2 && this.f225c % 8 == 0) {
                i4 = i3 + 1;
                m233d(i3);
                i3 = i4;
            }
            do {
                if (i < this.f224b && i2 >= 0 && !m231b(i2, i)) {
                    i4 = i3 + 1;
                    m227a(i, i2, i3);
                    i3 = i4;
                }
                i -= 2;
                i2 += 2;
                if (i < 0) {
                    break;
                }
            } while (i2 < this.f225c);
            i++;
            i2 += 3;
            do {
                if (i >= 0 && i2 < this.f225c && !m231b(i2, i)) {
                    i4 = i3 + 1;
                    m227a(i, i2, i3);
                    i3 = i4;
                }
                i += 2;
                i2 -= 2;
                if (i >= this.f224b) {
                    break;
                }
            } while (i2 >= 0);
            i += 3;
            i2++;
            i4 = this.f224b;
            if (i >= i4) {
                i5 = this.f225c;
                if (i2 >= i5) {
                    break;
                }
            }
        }
        if (!m231b(i5 - 1, i4 - 1)) {
            m229a(this.f225c - 1, this.f224b - 1, true);
            m229a(this.f225c - 2, this.f224b - 2, true);
        }
    }

    /* renamed from: a */
    public final boolean m235a(int i, int i2) {
        return this.f226d[(i2 * this.f225c) + i] == (byte) 1;
    }
}
