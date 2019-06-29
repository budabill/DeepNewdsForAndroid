package p014c.p015a.p016a.p026f;

import java.util.Map;
import p014c.p015a.p016a.C0278a;
import p014c.p015a.p016a.C0293c;
import p014c.p015a.p016a.C0317i;
import p014c.p015a.p016a.p019b.C0283b;
import p014c.p015a.p016a.p026f.p027a.C0303a;
import p014c.p015a.p016a.p026f.p028b.C0309b;
import p014c.p015a.p016a.p026f.p028b.C0311d;
import p014c.p015a.p016a.p026f.p028b.C0314g;

/* renamed from: c.a.a.f.a */
public final class C0813a implements C0317i {
    /* renamed from: a */
    private static C0283b m2108a(C0314g c0314g, int i, int i2, int i3) {
        C0309b a = c0314g.m397a();
        if (a != null) {
            int c = a.m346c();
            int b = a.m345b();
            i3 <<= 1;
            int i4 = c + i3;
            i3 += b;
            i = Math.max(i, i4);
            i2 = Math.max(i2, i3);
            i3 = Math.min(i / i4, i2 / i3);
            i4 = (i - (c * i3)) / 2;
            int i5 = (i2 - (b * i3)) / 2;
            C0283b c0283b = new C0283b(i, i2);
            i2 = 0;
            while (i2 < b) {
                int i6 = i4;
                int i7 = 0;
                while (i7 < c) {
                    if (a.m340a(i7, i2) == (byte) 1) {
                        c0283b.m217a(i6, i5, i3, i3);
                    }
                    i7++;
                    i6 += i3;
                }
                i2++;
                i5 += i3;
            }
            return c0283b;
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    public C0283b mo941a(String str, C0278a c0278a, int i, int i2, Map<C0293c, ?> map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (c0278a != C0278a.QR_CODE) {
            StringBuilder stringBuilder = new StringBuilder("Can only encode QR_CODE, but got ");
            stringBuilder.append(c0278a);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (i < 0 || i2 < 0) {
            StringBuilder stringBuilder2 = new StringBuilder("Requested dimensions are too small: ");
            stringBuilder2.append(i);
            stringBuilder2.append('x');
            stringBuilder2.append(i2);
            throw new IllegalArgumentException(stringBuilder2.toString());
        } else {
            C0303a c0303a = C0303a.L;
            int i3 = 4;
            if (map != null) {
                if (map.containsKey(C0293c.ERROR_CORRECTION)) {
                    c0303a = C0303a.valueOf(map.get(C0293c.ERROR_CORRECTION).toString());
                }
                if (map.containsKey(C0293c.MARGIN)) {
                    i3 = Integer.parseInt(map.get(C0293c.MARGIN).toString());
                }
            }
            return C0813a.m2108a(C0311d.m355a(str, c0303a, (Map) map), i, i2, i3);
        }
    }
}
