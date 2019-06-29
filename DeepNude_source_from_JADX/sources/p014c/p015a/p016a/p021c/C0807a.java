package p014c.p015a.p016a.p021c;

import java.util.Map;
import p014c.p015a.p016a.C0278a;
import p014c.p015a.p016a.C0285b;
import p014c.p015a.p016a.C0293c;
import p014c.p015a.p016a.C0317i;
import p014c.p015a.p016a.p019b.C0283b;
import p014c.p015a.p016a.p021c.p022a.C0286e;
import p014c.p015a.p016a.p021c.p022a.C0289i;
import p014c.p015a.p016a.p021c.p022a.C0290j;
import p014c.p015a.p016a.p021c.p022a.C0291k;
import p014c.p015a.p016a.p021c.p022a.C0292l;
import p014c.p015a.p016a.p026f.p028b.C0309b;

/* renamed from: c.a.a.c.a */
public final class C0807a implements C0317i {
    /* renamed from: a */
    private static C0283b m2093a(C0286e c0286e, C0291k c0291k) {
        int e = c0291k.m283e();
        int d = c0291k.m282d();
        C0309b c0309b = new C0309b(c0291k.m285g(), c0291k.m284f());
        int i = 0;
        for (int i2 = 0; i2 < d; i2++) {
            int i3;
            int i4;
            if (i2 % c0291k.f246g == 0) {
                i3 = 0;
                for (i4 = 0; i4 < c0291k.m285g(); i4++) {
                    c0309b.m343a(i3, i, i4 % 2 == 0);
                    i3++;
                }
                i++;
            }
            i3 = 0;
            for (i4 = 0; i4 < e; i4++) {
                if (i4 % c0291k.f245f == 0) {
                    c0309b.m343a(i3, i, true);
                    i3++;
                }
                c0309b.m343a(i3, i, c0286e.m235a(i4, i2));
                i3++;
                int i5 = c0291k.f245f;
                if (i4 % i5 == i5 - 1) {
                    c0309b.m343a(i3, i, i2 % 2 == 0);
                    i3++;
                }
            }
            i++;
            i4 = c0291k.f246g;
            if (i2 % i4 == i4 - 1) {
                i3 = 0;
                for (i4 = 0; i4 < c0291k.m285g(); i4++) {
                    c0309b.m343a(i3, i, true);
                    i3++;
                }
                i++;
            }
        }
        return C0807a.m2094a(c0309b);
    }

    /* renamed from: a */
    private static C0283b m2094a(C0309b c0309b) {
        int c = c0309b.m346c();
        int b = c0309b.m345b();
        C0283b c0283b = new C0283b(c, b);
        c0283b.m216a();
        for (int i = 0; i < c; i++) {
            for (int i2 = 0; i2 < b; i2++) {
                if (c0309b.m340a(i, i2) == (byte) 1) {
                    c0283b.m220b(i, i2);
                }
            }
        }
        return c0283b;
    }

    /* renamed from: a */
    public C0283b mo941a(String str, C0278a c0278a, int i, int i2, Map<C0293c, ?> map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (c0278a != C0278a.DATA_MATRIX) {
            StringBuilder stringBuilder = new StringBuilder("Can only encode DATA_MATRIX, but got ");
            stringBuilder.append(c0278a);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (i < 0 || i2 < 0) {
            StringBuilder stringBuilder2 = new StringBuilder("Requested dimensions are too small: ");
            stringBuilder2.append(i);
            stringBuilder2.append('x');
            stringBuilder2.append(i2);
            throw new IllegalArgumentException(stringBuilder2.toString());
        } else {
            C0285b c0285b;
            C0292l c0292l = C0292l.FORCE_NONE;
            C0285b c0285b2 = null;
            if (map != null) {
                C0292l c0292l2 = (C0292l) map.get(C0293c.DATA_MATRIX_SHAPE);
                if (c0292l2 != null) {
                    c0292l = c0292l2;
                }
                c0285b = (C0285b) map.get(C0293c.MIN_SIZE);
                if (c0285b == null) {
                    c0285b = null;
                }
                C0285b c0285b3 = (C0285b) map.get(C0293c.MAX_SIZE);
                if (c0285b3 != null) {
                    c0285b2 = c0285b3;
                }
            } else {
                c0285b = null;
            }
            str = C0290j.m264a(str, c0292l, c0285b, c0285b2);
            C0291k a = C0291k.m274a(str.length(), c0292l, c0285b, c0285b2, true);
            C0286e c0286e = new C0286e(C0289i.m258a(str, a), a.m283e(), a.m282d());
            c0286e.m234a();
            return C0807a.m2093a(c0286e, a);
        }
    }
}
