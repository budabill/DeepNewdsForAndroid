package p014c.p015a.p016a.p023d;

import java.util.Map;
import p014c.p015a.p016a.C0278a;
import p014c.p015a.p016a.C0293c;
import p014c.p015a.p016a.p019b.C0283b;

/* renamed from: c.a.a.d.f */
public final class C0909f extends C0809o {
    /* renamed from: a */
    private static void m2440a(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i) != 0) {
                i3 = 2;
            }
            iArr[i2] = i3;
        }
    }

    /* renamed from: a */
    public C0283b mo941a(String str, C0278a c0278a, int i, int i2, Map<C0293c, ?> map) {
        if (c0278a == C0278a.CODE_39) {
            return super.mo941a(str, c0278a, i, i2, map);
        }
        StringBuilder stringBuilder = new StringBuilder("Can only encode CODE_39, but got ");
        stringBuilder.append(c0278a);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public boolean[] mo1603a(String str) {
        int length = str.length();
        if (length <= 80) {
            String str2;
            int[] iArr = new int[9];
            int i = length + 25;
            int i2 = 0;
            while (true) {
                str2 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%";
                if (i2 >= length) {
                    break;
                }
                int indexOf = str2.indexOf(str.charAt(i2));
                if (indexOf >= 0) {
                    C0909f.m2440a(C0908e.f1941a[indexOf], iArr);
                    indexOf = i;
                    for (i = 0; i < 9; i++) {
                        indexOf += iArr[i];
                    }
                    i2++;
                    i = indexOf;
                } else {
                    StringBuilder stringBuilder = new StringBuilder("Bad contents: ");
                    stringBuilder.append(str);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            boolean[] zArr = new boolean[i];
            C0909f.m2440a(C0908e.f1942b, iArr);
            i = C0809o.m2096a(zArr, 0, iArr, true);
            int[] iArr2 = new int[]{1};
            int a = i + C0809o.m2096a(zArr, i, iArr2, false);
            for (i = 0; i < length; i++) {
                C0909f.m2440a(C0908e.f1941a[str2.indexOf(str.charAt(i))], iArr);
                a += C0809o.m2096a(zArr, a, iArr, true);
                a += C0809o.m2096a(zArr, a, iArr2, false);
            }
            C0909f.m2440a(C0908e.f1942b, iArr);
            C0809o.m2096a(zArr, a, iArr, true);
            return zArr;
        }
        stringBuilder = new StringBuilder("Requested contents should be less than 80 digits long, but got ");
        stringBuilder.append(length);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
