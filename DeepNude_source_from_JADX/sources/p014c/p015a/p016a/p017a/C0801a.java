package p014c.p015a.p016a.p017a;

import java.nio.charset.Charset;
import java.util.Map;
import p014c.p015a.p016a.C0278a;
import p014c.p015a.p016a.C0293c;
import p014c.p015a.p016a.C0317i;
import p014c.p015a.p016a.p017a.p018a.C0272a;
import p014c.p015a.p016a.p017a.p018a.C0273c;
import p014c.p015a.p016a.p019b.C0283b;

/* renamed from: c.a.a.a.a */
public final class C0801a implements C0317i {
    /* renamed from: a */
    private static final Charset f1729a = Charset.forName("ISO-8859-1");

    /* renamed from: a */
    private static C0283b m2070a(C0272a c0272a, int i, int i2) {
        C0283b a = c0272a.m151a();
        if (a != null) {
            int c = a.m221c();
            int b = a.m219b();
            i = Math.max(i, c);
            i2 = Math.max(i2, b);
            int min = Math.min(i / c, i2 / b);
            int i3 = (i - (c * min)) / 2;
            int i4 = (i2 - (b * min)) / 2;
            C0283b c0283b = new C0283b(i, i2);
            i2 = 0;
            while (i2 < b) {
                int i5 = i3;
                int i6 = 0;
                while (i6 < c) {
                    if (a.m218a(i6, i2)) {
                        c0283b.m217a(i5, i4, min, min);
                    }
                    i6++;
                    i5 += min;
                }
                i2++;
                i4 += min;
            }
            return c0283b;
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    private static C0283b m2071a(String str, C0278a c0278a, int i, int i2, Charset charset, int i3, int i4) {
        if (c0278a == C0278a.AZTEC) {
            return C0801a.m2070a(C0273c.m158a(str.getBytes(charset), i3, i4), i, i2);
        }
        StringBuilder stringBuilder = new StringBuilder("Can only encode AZTEC, but got ");
        stringBuilder.append(c0278a);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public C0283b mo941a(String str, C0278a c0278a, int i, int i2, Map<C0293c, ?> map) {
        Charset charset;
        int i3;
        int parseInt;
        Charset charset2 = f1729a;
        int i4 = 33;
        if (map != null) {
            if (map.containsKey(C0293c.CHARACTER_SET)) {
                charset2 = Charset.forName(map.get(C0293c.CHARACTER_SET).toString());
            }
            if (map.containsKey(C0293c.ERROR_CORRECTION)) {
                i4 = Integer.parseInt(map.get(C0293c.ERROR_CORRECTION).toString());
            }
            if (map.containsKey(C0293c.AZTEC_LAYERS)) {
                charset = charset2;
                i3 = i4;
                parseInt = Integer.parseInt(map.get(C0293c.AZTEC_LAYERS).toString());
                return C0801a.m2071a(str, c0278a, i, i2, charset, i3, parseInt);
            }
            charset = charset2;
            i3 = i4;
        } else {
            charset = charset2;
            i3 = 33;
        }
        parseInt = 0;
        return C0801a.m2071a(str, c0278a, i, i2, charset, i3, parseInt);
    }
}
