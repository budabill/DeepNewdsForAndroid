package p014c.p015a.p016a.p023d;

import java.util.Map;
import p014c.p015a.p016a.C0278a;
import p014c.p015a.p016a.C0293c;
import p014c.p015a.p016a.p019b.C0283b;

/* renamed from: c.a.a.d.h */
public class C0911h extends C0809o {
    /* renamed from: a */
    private static int m2443a(String str, int i) {
        int i2 = 0;
        int i3 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            i2 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i3;
            i3++;
            if (i3 > i) {
                i3 = 1;
            }
        }
        return i2 % 47;
    }

    /* renamed from: a */
    protected static int m2444a(boolean[] zArr, int i, int[] iArr, boolean z) {
        int length = iArr.length;
        int i2 = i;
        i = 0;
        while (i < length) {
            int i3 = i2 + 1;
            zArr[i2] = iArr[i] != 0;
            i++;
            i2 = i3;
        }
        return 9;
    }

    /* renamed from: a */
    private static void m2445a(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i) == 0) {
                i3 = 0;
            }
            iArr[i2] = i3;
        }
    }

    /* renamed from: a */
    public C0283b mo941a(String str, C0278a c0278a, int i, int i2, Map<C0293c, ?> map) {
        if (c0278a == C0278a.CODE_93) {
            return super.mo941a(str, c0278a, i, i2, map);
        }
        StringBuilder stringBuilder = new StringBuilder("Can only encode CODE_93, but got ");
        stringBuilder.append(c0278a);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public boolean[] mo1603a(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            boolean[] zArr = new boolean[((((str.length() + 2) + 2) * 9) + 1)];
            C0911h.m2445a(C0910g.f1944b[47], iArr);
            int i = 0;
            int a = C0911h.m2444a(zArr, 0, iArr, true);
            while (true) {
                String str2 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";
                if (i < length) {
                    C0911h.m2445a(C0910g.f1944b[str2.indexOf(str.charAt(i))], iArr);
                    a += C0911h.m2444a(zArr, a, iArr, true);
                    i++;
                } else {
                    length = C0911h.m2443a(str, 20);
                    C0911h.m2445a(C0910g.f1944b[length], iArr);
                    a += C0911h.m2444a(zArr, a, iArr, true);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(str2.charAt(length));
                    C0911h.m2445a(C0910g.f1944b[C0911h.m2443a(stringBuilder.toString(), 15)], iArr);
                    a += C0911h.m2444a(zArr, a, iArr, true);
                    C0911h.m2445a(C0910g.f1944b[47], iArr);
                    zArr[a + C0911h.m2444a(zArr, a, iArr, true)] = true;
                    return zArr;
                }
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder("Requested contents should be less than 80 digits long, but got ");
        stringBuilder2.append(length);
        throw new IllegalArgumentException(stringBuilder2.toString());
    }
}
