package p014c.p015a.p016a.p023d;

import java.util.Map;
import p014c.p015a.p016a.C0278a;
import p014c.p015a.p016a.C0293c;
import p014c.p015a.p016a.C0317i;
import p014c.p015a.p016a.p019b.C0283b;

/* renamed from: c.a.a.d.p */
public final class C0810p implements C0317i {
    /* renamed from: a */
    private final C0921j f1730a = new C0921j();

    /* renamed from: a */
    private static String m2101a(String str) {
        StringBuilder stringBuilder;
        int length = str.length();
        if (length == 11) {
            int i = 0;
            for (length = 0; length < 11; length++) {
                i += (str.charAt(length) - 48) * (length % 2 == 0 ? 3 : 1);
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append((1000 - i) % 10);
            str = stringBuilder.toString();
        } else if (length != 12) {
            StringBuilder stringBuilder2 = new StringBuilder("Requested contents should be 11 or 12 digits long, but got ");
            stringBuilder2.append(str.length());
            throw new IllegalArgumentException(stringBuilder2.toString());
        }
        stringBuilder = new StringBuilder("0");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public C0283b mo941a(String str, C0278a c0278a, int i, int i2, Map<C0293c, ?> map) {
        if (c0278a == C0278a.UPC_A) {
            return this.f1730a.mo941a(C0810p.m2101a(str), C0278a.EAN_13, i, i2, map);
        }
        StringBuilder stringBuilder = new StringBuilder("Can only encode UPC-A, but got ");
        stringBuilder.append(c0278a);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
