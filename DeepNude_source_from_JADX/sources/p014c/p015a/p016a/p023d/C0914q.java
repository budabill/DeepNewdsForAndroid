package p014c.p015a.p016a.p023d;

import p014c.p015a.p016a.C0811d;

/* renamed from: c.a.a.d.q */
public abstract class C0914q extends C0808n {
    /* renamed from: a */
    static final int[] f1952a = new int[]{1, 1, 1};
    /* renamed from: b */
    static final int[] f1953b = new int[]{1, 1, 1, 1, 1};
    /* renamed from: c */
    static final int[] f1954c = new int[]{1, 1, 1, 1, 1, 1};
    /* renamed from: d */
    static final int[][] f1955d = new int[][]{new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
    /* renamed from: e */
    static final int[][] f1956e = new int[20][];

    static {
        int i = 10;
        System.arraycopy(f1955d, 0, f1956e, 0, 10);
        while (i < 20) {
            int[] iArr = f1955d[i - 10];
            int[] iArr2 = new int[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr2[i2] = iArr[(iArr.length - i2) - 1];
            }
            f1956e[i] = iArr2;
            i++;
        }
    }

    /* renamed from: a */
    static boolean m2450a(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        for (int i2 = length - 2; i2 >= 0; i2 -= 2) {
            int charAt = charSequence.charAt(i2) - 48;
            if (charAt < 0 || charAt > 9) {
                throw C0811d.m2103a();
            }
            i += charAt;
        }
        i *= 3;
        for (length--; length >= 0; length -= 2) {
            charAt = charSequence.charAt(length) - 48;
            if (charAt < 0 || charAt > 9) {
                throw C0811d.m2103a();
            }
            i += charAt;
        }
        return i % 10 == 0;
    }
}
