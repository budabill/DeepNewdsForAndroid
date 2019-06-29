package p014c.p015a.p016a.p023d;

import java.util.Map;
import p014c.p015a.p016a.C0278a;
import p014c.p015a.p016a.C0293c;
import p014c.p015a.p016a.p019b.C0283b;

/* renamed from: c.a.a.d.m */
public final class C0913m extends C0809o {
    /* renamed from: a */
    private static final int[] f1950a = new int[]{1, 1, 1, 1};
    /* renamed from: b */
    private static final int[] f1951b = new int[]{3, 1, 1};

    /* renamed from: a */
    public C0283b mo941a(String str, C0278a c0278a, int i, int i2, Map<C0293c, ?> map) {
        if (c0278a == C0278a.ITF) {
            return super.mo941a(str, c0278a, i, i2, map);
        }
        StringBuilder stringBuilder = new StringBuilder("Can only encode ITF, but got ");
        stringBuilder.append(c0278a);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public boolean[] mo1603a(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The length of the input should be even");
        } else if (length <= 80) {
            boolean[] zArr = new boolean[((length * 9) + 9)];
            int a = C0809o.m2096a(zArr, 0, f1950a, true);
            for (int i = 0; i < length; i += 2) {
                int digit = Character.digit(str.charAt(i), 10);
                int digit2 = Character.digit(str.charAt(i + 1), 10);
                int[] iArr = new int[18];
                for (int i2 = 0; i2 < 5; i2++) {
                    int i3 = i2 * 2;
                    int[][] iArr2 = C0912l.f1949d;
                    iArr[i3] = iArr2[digit][i2];
                    iArr[i3 + 1] = iArr2[digit2][i2];
                }
                a += C0809o.m2096a(zArr, a, iArr, true);
            }
            C0809o.m2096a(zArr, a, f1951b, true);
            return zArr;
        } else {
            StringBuilder stringBuilder = new StringBuilder("Requested contents should be less than 80 digits long, but got ");
            stringBuilder.append(length);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
