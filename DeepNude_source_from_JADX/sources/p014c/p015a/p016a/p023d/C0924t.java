package p014c.p015a.p016a.p023d;

import java.util.Map;
import p014c.p015a.p016a.C0278a;
import p014c.p015a.p016a.C0293c;
import p014c.p015a.p016a.p019b.C0283b;

/* renamed from: c.a.a.d.t */
public final class C0924t extends C0915r {
    /* renamed from: a */
    public C0283b mo941a(String str, C0278a c0278a, int i, int i2, Map<C0293c, ?> map) {
        if (c0278a == C0278a.UPC_E) {
            return super.mo941a(str, c0278a, i, i2, map);
        }
        StringBuilder stringBuilder = new StringBuilder("Can only encode UPC_E, but got ");
        stringBuilder.append(c0278a);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public boolean[] mo1603a(String str) {
        if (str.length() == 8) {
            int i = C0923s.f1981f[Integer.parseInt(str.substring(7, 8))];
            boolean[] zArr = new boolean[51];
            int a = C0809o.m2096a(zArr, 0, C0914q.f1952a, true) + 0;
            int i2 = 1;
            while (i2 <= 6) {
                int i3 = i2 + 1;
                int parseInt = Integer.parseInt(str.substring(i2, i3));
                if (((i >> (6 - i2)) & 1) == 1) {
                    parseInt += 10;
                }
                a += C0809o.m2096a(zArr, a, C0914q.f1956e[parseInt], false);
                i2 = i3;
            }
            C0809o.m2096a(zArr, a, C0914q.f1954c, false);
            return zArr;
        }
        StringBuilder stringBuilder = new StringBuilder("Requested contents should be 8 digits long, but got ");
        stringBuilder.append(str.length());
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
