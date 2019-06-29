package p014c.p015a.p016a.p024e;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;
import p014c.p015a.p016a.C0278a;
import p014c.p015a.p016a.C0293c;
import p014c.p015a.p016a.C0317i;
import p014c.p015a.p016a.p019b.C0283b;
import p014c.p015a.p016a.p024e.p025a.C0297c;
import p014c.p015a.p016a.p024e.p025a.C0298d;
import p014c.p015a.p016a.p024e.p025a.C0299e;

/* renamed from: c.a.a.e.a */
public final class C0812a implements C0317i {
    /* renamed from: a */
    private static C0283b m2104a(C0299e c0299e, String str, int i, int i2, int i3, int i4) {
        Object obj;
        c0299e.m304a(str, i);
        byte[][] a = c0299e.m301a().m287a(1, 4);
        if (((i3 > i2 ? 1 : 0) ^ (a[0].length < a.length ? 1 : 0)) != 0) {
            a = C0812a.m2106a(a);
            obj = 1;
        } else {
            obj = null;
        }
        i2 /= a[0].length;
        i3 /= a.length;
        if (i2 >= i3) {
            i2 = i3;
        }
        if (i2 <= 1) {
            return C0812a.m2105a(a, i4);
        }
        byte[][] a2 = c0299e.m301a().m287a(i2, i2 << 2);
        if (obj != null) {
            a2 = C0812a.m2106a(a2);
        }
        return C0812a.m2105a(a2, i4);
    }

    /* renamed from: a */
    private static C0283b m2105a(byte[][] bArr, int i) {
        int i2 = i * 2;
        C0283b c0283b = new C0283b(bArr[0].length + i2, bArr.length + i2);
        c0283b.m216a();
        int b = (c0283b.m219b() - i) - 1;
        int i3 = 0;
        while (i3 < bArr.length) {
            for (int i4 = 0; i4 < bArr[0].length; i4++) {
                if (bArr[i3][i4] == (byte) 1) {
                    c0283b.m220b(i4 + i, b);
                }
            }
            i3++;
            b--;
        }
        return c0283b;
    }

    /* renamed from: a */
    private static byte[][] m2106a(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance(byte.class, new int[]{bArr[0].length, bArr.length});
        for (int i = 0; i < bArr.length; i++) {
            int length = (bArr.length - i) - 1;
            for (int i2 = 0; i2 < bArr[0].length; i2++) {
                bArr2[i2][length] = bArr[i][i2];
            }
        }
        return bArr2;
    }

    /* renamed from: a */
    public C0283b mo941a(String str, C0278a c0278a, int i, int i2, Map<C0293c, ?> map) {
        if (c0278a == C0278a.PDF_417) {
            int i3;
            int i4;
            C0299e c0299e = new C0299e();
            int i5 = 30;
            int i6 = 2;
            if (map != null) {
                if (map.containsKey(C0293c.PDF417_COMPACT)) {
                    c0299e.m306a(Boolean.valueOf(map.get(C0293c.PDF417_COMPACT).toString()).booleanValue());
                }
                if (map.containsKey(C0293c.PDF417_COMPACTION)) {
                    c0299e.m303a(C0297c.valueOf(map.get(C0293c.PDF417_COMPACTION).toString()));
                }
                if (map.containsKey(C0293c.PDF417_DIMENSIONS)) {
                    C0298d c0298d = (C0298d) map.get(C0293c.PDF417_DIMENSIONS);
                    c0299e.m302a(c0298d.m292a(), c0298d.m294c(), c0298d.m293b(), c0298d.m295d());
                }
                if (map.containsKey(C0293c.MARGIN)) {
                    i5 = Integer.parseInt(map.get(C0293c.MARGIN).toString());
                }
                if (map.containsKey(C0293c.ERROR_CORRECTION)) {
                    i6 = Integer.parseInt(map.get(C0293c.ERROR_CORRECTION).toString());
                }
                if (map.containsKey(C0293c.CHARACTER_SET)) {
                    c0299e.m305a(Charset.forName(map.get(C0293c.CHARACTER_SET).toString()));
                }
                i3 = i5;
                i4 = i6;
            } else {
                i4 = 2;
                i3 = 30;
            }
            return C0812a.m2104a(c0299e, str, i4, i, i2, i3);
        }
        StringBuilder stringBuilder = new StringBuilder("Can only encode PDF_417, but got ");
        stringBuilder.append(c0278a);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
