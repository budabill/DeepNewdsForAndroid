package p014c.p015a.p016a.p023d;

import java.util.Map;
import p014c.p015a.p016a.C0278a;
import p014c.p015a.p016a.C0293c;
import p014c.p015a.p016a.p019b.C0283b;

/* renamed from: c.a.a.d.k */
public final class C0922k extends C0915r {
    /* renamed from: a */
    public C0283b mo941a(String str, C0278a c0278a, int i, int i2, Map<C0293c, ?> map) {
        if (c0278a == C0278a.EAN_8) {
            return super.mo941a(str, c0278a, i, i2, map);
        }
        StringBuilder stringBuilder = new StringBuilder("Can only encode EAN_8, but got ");
        stringBuilder.append(c0278a);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public boolean[] mo1603a(String str) {
        if (str.length() == 8) {
            boolean[] zArr = new boolean[67];
            int a = C0809o.m2096a(zArr, 0, C0914q.f1952a, true) + 0;
            int i = 0;
            while (i <= 3) {
                int i2 = i + 1;
                a += C0809o.m2096a(zArr, a, C0914q.f1955d[Integer.parseInt(str.substring(i, i2))], false);
                i = i2;
            }
            a += C0809o.m2096a(zArr, a, C0914q.f1953b, false);
            i = 4;
            while (i <= 7) {
                int i3 = i + 1;
                a += C0809o.m2096a(zArr, a, C0914q.f1955d[Integer.parseInt(str.substring(i, i3))], true);
                i = i3;
            }
            C0809o.m2096a(zArr, a, C0914q.f1952a, true);
            return zArr;
        }
        StringBuilder stringBuilder = new StringBuilder("Requested contents should be 8 digits long, but got ");
        stringBuilder.append(str.length());
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
