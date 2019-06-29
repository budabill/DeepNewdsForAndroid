package p014c.p015a.p016a.p023d;

import java.util.Map;
import p014c.p015a.p016a.C0278a;
import p014c.p015a.p016a.C0293c;
import p014c.p015a.p016a.C0317i;
import p014c.p015a.p016a.p019b.C0283b;

/* renamed from: c.a.a.d.o */
public abstract class C0809o implements C0317i {
    /* renamed from: a */
    protected static int m2096a(boolean[] zArr, int i, int[] iArr, boolean z) {
        int length = iArr.length;
        int i2 = i;
        boolean z2 = z;
        i = 0;
        int i3 = 0;
        while (i < length) {
            int i4 = iArr[i];
            int i5 = i2;
            i2 = 0;
            while (i2 < i4) {
                int i6 = i5 + 1;
                zArr[i5] = z2;
                i2++;
                i5 = i6;
            }
            i3 += i4;
            z2 = !z2;
            i++;
            i2 = i5;
        }
        return i3;
    }

    /* renamed from: a */
    private static C0283b m2097a(boolean[] zArr, int i, int i2, int i3) {
        int length = zArr.length;
        i3 += length;
        i = Math.max(i, i3);
        i2 = Math.max(1, i2);
        i3 = i / i3;
        int i4 = (i - (length * i3)) / 2;
        C0283b c0283b = new C0283b(i, i2);
        int i5 = i4;
        i4 = 0;
        while (i4 < length) {
            if (zArr[i4]) {
                c0283b.m217a(i5, 0, i3, i2);
            }
            i4++;
            i5 += i3;
        }
        return c0283b;
    }

    /* renamed from: a */
    public int mo1604a() {
        return 10;
    }

    /* renamed from: a */
    public C0283b mo941a(String str, C0278a c0278a, int i, int i2, Map<C0293c, ?> map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (i < 0 || i2 < 0) {
            StringBuilder stringBuilder = new StringBuilder("Negative size is not allowed. Input: ");
            stringBuilder.append(i);
            stringBuilder.append('x');
            stringBuilder.append(i2);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else {
            int a = mo1604a();
            if (map != null && map.containsKey(C0293c.MARGIN)) {
                a = Integer.parseInt(map.get(C0293c.MARGIN).toString());
            }
            return C0809o.m2097a(mo1603a(str), i, i2, a);
        }
    }

    /* renamed from: a */
    public abstract boolean[] mo1603a(String str);
}
