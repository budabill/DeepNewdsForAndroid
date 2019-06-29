package p014c.p015a.p016a.p026f.p028b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import p014c.p015a.p016a.C0293c;
import p014c.p015a.p016a.C0318j;
import p014c.p015a.p016a.p019b.C0282a;
import p014c.p015a.p016a.p019b.C0284c;
import p014c.p015a.p016a.p019b.p020a.C0279a;
import p014c.p015a.p016a.p019b.p020a.C0281c;
import p014c.p015a.p016a.p026f.p027a.C0303a;
import p014c.p015a.p016a.p026f.p027a.C0304b;
import p014c.p015a.p016a.p026f.p027a.C0307c;
import p014c.p015a.p016a.p026f.p027a.C0307c.C0306b;

/* renamed from: c.a.a.f.b.d */
public final class C0311d {
    /* renamed from: a */
    private static final int[] f338a = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* renamed from: a */
    static int m347a(int i) {
        int[] iArr = f338a;
        return i < iArr.length ? iArr[i] : -1;
    }

    /* renamed from: a */
    private static int m348a(C0282a c0282a, C0303a c0303a, C0307c c0307c, C0309b c0309b) {
        int i = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i2 = -1;
        for (int i3 = 0; i3 < 8; i3++) {
            C0313f.m381a(c0282a, c0303a, c0307c, i3, c0309b);
            int a = C0311d.m350a(c0309b);
            if (a < i) {
                i2 = i3;
                i = a;
            }
        }
        return i2;
    }

    /* renamed from: a */
    private static int m349a(C0304b c0304b, C0282a c0282a, C0282a c0282a2, C0307c c0307c) {
        return (c0282a.m206a() + c0304b.m325a(c0307c)) + c0282a2.m206a();
    }

    /* renamed from: a */
    private static int m350a(C0309b c0309b) {
        return ((C0312e.m369a(c0309b) + C0312e.m374b(c0309b)) + C0312e.m375c(c0309b)) + C0312e.m376d(c0309b);
    }

    /* renamed from: a */
    static C0282a m351a(C0282a c0282a, int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        if (c0282a.m212b() == i5) {
            Collection<C0308a> arrayList = new ArrayList(i6);
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            for (int i11 = 0; i11 < i6; i11++) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                int[] iArr3 = iArr2;
                C0311d.m356a(i, i2, i3, i11, iArr, iArr2);
                int i12 = iArr[0];
                byte[] bArr = new byte[i12];
                c0282a.m208a(i8 << 3, bArr, 0, i12);
                byte[] a = C0311d.m367a(bArr, iArr3[0]);
                arrayList.add(new C0308a(bArr, a));
                i9 = Math.max(i9, i12);
                i10 = Math.max(i10, a.length);
                i8 += iArr[0];
            }
            if (i5 == i8) {
                C0282a c0282a2 = new C0282a();
                for (int i13 = 0; i13 < i9; i13++) {
                    for (C0308a a2 : arrayList) {
                        byte[] a3 = a2.m338a();
                        if (i13 < a3.length) {
                            c0282a2.m207a(a3[i13], 8);
                        }
                    }
                }
                while (i7 < i10) {
                    for (C0308a b : arrayList) {
                        byte[] b2 = b.m339b();
                        if (i7 < b2.length) {
                            c0282a2.m207a(b2[i7], 8);
                        }
                    }
                    i7++;
                }
                if (i4 == c0282a2.m212b()) {
                    return c0282a2;
                }
                StringBuilder stringBuilder = new StringBuilder("Interleaving error: ");
                stringBuilder.append(i4);
                stringBuilder.append(" and ");
                stringBuilder.append(c0282a2.m212b());
                stringBuilder.append(" differ.");
                throw new C0318j(stringBuilder.toString());
            }
            throw new C0318j("Data bytes does not match offset");
        }
        throw new C0318j("Number of bits and data bytes does not match");
    }

    /* renamed from: a */
    private static C0304b m352a(String str, String str2) {
        if ("Shift_JIS".equals(str2) && C0311d.m366a(str)) {
            return C0304b.KANJI;
        }
        Object obj = null;
        Object obj2 = null;
        for (int i = 0; i < str.length(); i++) {
            int charAt = str.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                obj2 = 1;
            } else if (C0311d.m347a(charAt) == -1) {
                return C0304b.BYTE;
            } else {
                obj = 1;
            }
        }
        return obj != null ? C0304b.ALPHANUMERIC : obj2 != null ? C0304b.NUMERIC : C0304b.BYTE;
    }

    /* renamed from: a */
    private static C0307c m353a(int i, C0303a c0303a) {
        for (int i2 = 1; i2 <= 40; i2++) {
            C0307c a = C0307c.m332a(i2);
            if (C0311d.m365a(i, a, c0303a)) {
                return a;
            }
        }
        throw new C0318j("Data too big");
    }

    /* renamed from: a */
    private static C0307c m354a(C0303a c0303a, C0304b c0304b, C0282a c0282a, C0282a c0282a2) {
        return C0311d.m353a(C0311d.m349a(c0304b, c0282a, c0282a2, C0311d.m353a(C0311d.m349a(c0304b, c0282a, c0282a2, C0307c.m332a(1)), c0303a)), c0303a);
    }

    /* renamed from: a */
    public static C0314g m355a(String str, C0303a c0303a, Map<C0293c, ?> map) {
        C0307c a;
        String str2 = "ISO-8859-1";
        String obj = (map == null || !map.containsKey(C0293c.CHARACTER_SET)) ? str2 : map.get(C0293c.CHARACTER_SET).toString();
        C0304b a2 = C0311d.m352a(str, obj);
        C0282a c0282a = new C0282a();
        if (a2 == C0304b.BYTE && !str2.equals(obj)) {
            C0284c a3 = C0284c.m222a(obj);
            if (a3 != null) {
                C0311d.m359a(a3, c0282a);
            }
        }
        C0311d.m360a(a2, c0282a);
        C0282a c0282a2 = new C0282a();
        C0311d.m364a(str, a2, c0282a2, obj);
        if (map == null || !map.containsKey(C0293c.QR_VERSION)) {
            a = C0311d.m354a(c0303a, a2, c0282a, c0282a2);
        } else {
            a = C0307c.m332a(Integer.parseInt(map.get(C0293c.QR_VERSION).toString()));
            if (!C0311d.m365a(C0311d.m349a(a2, c0282a, c0282a2, a), a, c0303a)) {
                throw new C0318j("Data too big for requested version");
            }
        }
        C0282a c0282a3 = new C0282a();
        c0282a3.m209a(c0282a);
        C0311d.m358a(a2 == C0304b.BYTE ? c0282a2.m212b() : str.length(), a, a2, c0282a3);
        c0282a3.m209a(c0282a2);
        C0306b a4 = a.m335a(c0303a);
        int b = a.m336b() - a4.m331d();
        C0311d.m357a(b, c0282a3);
        C0282a a5 = C0311d.m351a(c0282a3, a.m336b(), b, a4.m330c());
        C0314g c0314g = new C0314g();
        c0314g.m398a(c0303a);
        c0314g.m399a(a2);
        c0314g.m400a(a);
        int a6 = a.m334a();
        C0309b c0309b = new C0309b(a6, a6);
        a6 = C0311d.m348a(a5, c0303a, a, c0309b);
        c0314g.m402b(a6);
        C0313f.m381a(a5, c0303a, a, a6, c0309b);
        c0314g.m401a(c0309b);
        return c0314g;
    }

    /* renamed from: a */
    static void m356a(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) {
        if (i4 < i3) {
            int i5 = i % i3;
            int i6 = i3 - i5;
            int i7 = i / i3;
            int i8 = i7 + 1;
            i2 /= i3;
            int i9 = i2 + 1;
            i7 -= i2;
            i8 -= i9;
            if (i7 != i8) {
                throw new C0318j("EC bytes mismatch");
            } else if (i3 != i6 + i5) {
                throw new C0318j("RS blocks mismatch");
            } else if (i != ((i2 + i7) * i6) + ((i9 + i8) * i5)) {
                throw new C0318j("Total bytes mismatch");
            } else if (i4 < i6) {
                iArr[0] = i2;
                iArr2[0] = i7;
                return;
            } else {
                iArr[0] = i9;
                iArr2[0] = i8;
                return;
            }
        }
        throw new C0318j("Block ID too large");
    }

    /* renamed from: a */
    static void m357a(int i, C0282a c0282a) {
        int i2 = i << 3;
        if (c0282a.m206a() <= i2) {
            int i3;
            int i4 = 0;
            for (i3 = 0; i3 < 4 && c0282a.m206a() < i2; i3++) {
                c0282a.m210a(false);
            }
            i3 = c0282a.m206a() & 7;
            if (i3 > 0) {
                while (i3 < 8) {
                    c0282a.m210a(false);
                    i3++;
                }
            }
            i -= c0282a.m212b();
            while (i4 < i) {
                c0282a.m207a((i4 & 1) == 0 ? 236 : 17, 8);
                i4++;
            }
            if (c0282a.m206a() != i2) {
                throw new C0318j("Bits size does not equal capacity");
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("data bits cannot fit in the QR Code");
        stringBuilder.append(c0282a.m206a());
        stringBuilder.append(" > ");
        stringBuilder.append(i2);
        throw new C0318j(stringBuilder.toString());
    }

    /* renamed from: a */
    static void m358a(int i, C0307c c0307c, C0304b c0304b, C0282a c0282a) {
        int a = c0304b.m325a(c0307c);
        int i2 = 1 << a;
        if (i < i2) {
            c0282a.m207a(i, a);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append(" is bigger than ");
        stringBuilder.append(i2 - 1);
        throw new C0318j(stringBuilder.toString());
    }

    /* renamed from: a */
    private static void m359a(C0284c c0284c, C0282a c0282a) {
        c0282a.m207a(C0304b.ECI.m324a(), 4);
        c0282a.m207a(c0284c.m223a(), 8);
    }

    /* renamed from: a */
    static void m360a(C0304b c0304b, C0282a c0282a) {
        c0282a.m207a(c0304b.m324a(), 4);
    }

    /* renamed from: a */
    static void m361a(CharSequence charSequence, C0282a c0282a) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int a = C0311d.m347a(charSequence.charAt(i));
            if (a != -1) {
                int i2 = i + 1;
                if (i2 < length) {
                    i2 = C0311d.m347a(charSequence.charAt(i2));
                    if (i2 != -1) {
                        c0282a.m207a((a * 45) + i2, 11);
                        i += 2;
                    } else {
                        throw new C0318j();
                    }
                }
                c0282a.m207a(a, 6);
                i = i2;
            } else {
                throw new C0318j();
            }
        }
    }

    /* renamed from: a */
    static void m362a(String str, C0282a c0282a) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i = 0; i < length; i += 2) {
                int i2 = ((bytes[i] & 255) << 8) | (bytes[i + 1] & 255);
                int i3 = 33088;
                if (i2 < 33088 || i2 > 40956) {
                    if (i2 < 57408 || i2 > 60351) {
                        i2 = -1;
                        if (i2 == -1) {
                            c0282a.m207a(((i2 >> 8) * 192) + (i2 & 255), 13);
                        } else {
                            throw new C0318j("Invalid byte sequence");
                        }
                    }
                    i3 = 49472;
                }
                i2 -= i3;
                if (i2 == -1) {
                    throw new C0318j("Invalid byte sequence");
                }
                c0282a.m207a(((i2 >> 8) * 192) + (i2 & 255), 13);
            }
        } catch (Throwable e) {
            throw new C0318j(e);
        }
    }

    /* renamed from: a */
    static void m363a(String str, C0282a c0282a, String str2) {
        try {
            for (byte a : str.getBytes(str2)) {
                c0282a.m207a(a, 8);
            }
        } catch (Throwable e) {
            throw new C0318j(e);
        }
    }

    /* renamed from: a */
    static void m364a(String str, C0304b c0304b, C0282a c0282a, String str2) {
        int i = C0310c.f337a[c0304b.ordinal()];
        if (i == 1) {
            C0311d.m368b(str, c0282a);
        } else if (i == 2) {
            C0311d.m361a((CharSequence) str, c0282a);
        } else if (i == 3) {
            C0311d.m363a(str, c0282a, str2);
        } else if (i == 4) {
            C0311d.m362a(str, c0282a);
        } else {
            StringBuilder stringBuilder = new StringBuilder("Invalid mode: ");
            stringBuilder.append(c0304b);
            throw new C0318j(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    private static boolean m365a(int i, C0307c c0307c, C0303a c0303a) {
        return c0307c.m336b() - c0307c.m335a(c0303a).m331d() >= (i + 7) / 8;
    }

    /* renamed from: a */
    private static boolean m366a(java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r0 = 0;
        r1 = "Shift_JIS";	 Catch:{ UnsupportedEncodingException -> 0x002b }
        r5 = r5.getBytes(r1);	 Catch:{ UnsupportedEncodingException -> 0x002b }
        r1 = r5.length;
        r2 = r1 % 2;
        if (r2 == 0) goto L_0x000d;
    L_0x000c:
        return r0;
    L_0x000d:
        r2 = 0;
    L_0x000e:
        if (r2 >= r1) goto L_0x0029;
    L_0x0010:
        r3 = r5[r2];
        r3 = r3 & 255;
        r4 = 129; // 0x81 float:1.81E-43 double:6.37E-322;
        if (r3 < r4) goto L_0x001c;
    L_0x0018:
        r4 = 159; // 0x9f float:2.23E-43 double:7.86E-322;
        if (r3 <= r4) goto L_0x0025;
    L_0x001c:
        r4 = 224; // 0xe0 float:3.14E-43 double:1.107E-321;
        if (r3 < r4) goto L_0x0028;
    L_0x0020:
        r4 = 235; // 0xeb float:3.3E-43 double:1.16E-321;
        if (r3 <= r4) goto L_0x0025;
    L_0x0024:
        goto L_0x0028;
    L_0x0025:
        r2 = r2 + 2;
        goto L_0x000e;
    L_0x0028:
        return r0;
    L_0x0029:
        r5 = 1;
        return r5;
    L_0x002b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: c.a.a.f.b.d.a(java.lang.String):boolean");
    }

    /* renamed from: a */
    static byte[] m367a(byte[] bArr, int i) {
        int length = bArr.length;
        int[] iArr = new int[(length + i)];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        new C0281c(C0279a.f168e).m203a(iArr, i);
        bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) iArr[length + i3];
        }
        return bArr;
    }

    /* renamed from: b */
    static void m368b(CharSequence charSequence, C0282a c0282a) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int charAt = charSequence.charAt(i) - 48;
            int i2 = i + 2;
            if (i2 < length) {
                c0282a.m207a(((charAt * 100) + ((charSequence.charAt(i + 1) - 48) * 10)) + (charSequence.charAt(i2) - 48), 10);
                i += 3;
            } else {
                i++;
                if (i < length) {
                    c0282a.m207a((charAt * 10) + (charSequence.charAt(i) - 48), 7);
                    i = i2;
                } else {
                    c0282a.m207a(charAt, 4);
                }
            }
        }
    }
}
