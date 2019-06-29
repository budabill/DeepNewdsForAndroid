package p014c.p015a.p016a.p021c.p022a;

import java.util.Arrays;
import p014c.p015a.p016a.C0285b;

/* renamed from: c.a.a.c.a.j */
public final class C0290j {
    /* renamed from: a */
    private static char m259a(char c, int i) {
        int i2 = c + (((i * 149) % 253) + 1);
        if (i2 > 254) {
            i2 -= 254;
        }
        return (char) i2;
    }

    /* renamed from: a */
    public static int m260a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        if (i < length) {
            loop0:
            while (true) {
                char charAt = charSequence.charAt(i);
                while (C0290j.m266b(charAt) && i < length) {
                    i2++;
                    i++;
                    if (i < length) {
                    }
                }
            }
        }
        return i2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static int m261a(java.lang.CharSequence r17, int r18, int r19) {
        /*
        r0 = r17;
        r1 = r18;
        r2 = r17.length();
        if (r1 < r2) goto L_0x000b;
    L_0x000a:
        return r19;
    L_0x000b:
        r2 = 6;
        if (r19 != 0) goto L_0x0014;
    L_0x000e:
        r3 = new float[r2];
        r3 = {0, 1065353216, 1065353216, 1065353216, 1065353216, 1067450368};
        goto L_0x001c;
    L_0x0014:
        r3 = new float[r2];
        r3 = {1065353216, 1073741824, 1073741824, 1073741824, 1073741824, 1074790400};
        r4 = 0;
        r3[r19] = r4;
    L_0x001c:
        r4 = 0;
        r5 = 0;
    L_0x001e:
        r6 = r1 + r5;
        r7 = r17.length();
        r8 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r9 = 5;
        r10 = 2;
        r11 = 4;
        r12 = 3;
        r13 = 1;
        if (r6 != r7) goto L_0x005c;
    L_0x002e:
        r0 = new byte[r2];
        r1 = new int[r2];
        r2 = p014c.p015a.p016a.p021c.p022a.C0290j.m263a(r3, r1, r8, r0);
        r3 = p014c.p015a.p016a.p021c.p022a.C0290j.m262a(r0);
        r1 = r1[r4];
        if (r1 != r2) goto L_0x003f;
    L_0x003e:
        return r4;
    L_0x003f:
        if (r3 != r13) goto L_0x0046;
    L_0x0041:
        r1 = r0[r9];
        if (r1 <= 0) goto L_0x0046;
    L_0x0045:
        return r9;
    L_0x0046:
        if (r3 != r13) goto L_0x004d;
    L_0x0048:
        r1 = r0[r11];
        if (r1 <= 0) goto L_0x004d;
    L_0x004c:
        return r11;
    L_0x004d:
        if (r3 != r13) goto L_0x0054;
    L_0x004f:
        r1 = r0[r10];
        if (r1 <= 0) goto L_0x0054;
    L_0x0053:
        return r10;
    L_0x0054:
        if (r3 != r13) goto L_0x005b;
    L_0x0056:
        r0 = r0[r12];
        if (r0 <= 0) goto L_0x005b;
    L_0x005a:
        return r12;
    L_0x005b:
        return r13;
    L_0x005c:
        r6 = r0.charAt(r6);
        r5 = r5 + 1;
        r7 = p014c.p015a.p016a.p021c.p022a.C0290j.m266b(r6);
        r14 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        if (r7 == 0) goto L_0x0072;
    L_0x006a:
        r7 = r3[r4];
        r15 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r7 = r7 + r15;
        r3[r4] = r7;
        goto L_0x0099;
    L_0x0072:
        r7 = p014c.p015a.p016a.p021c.p022a.C0290j.m267c(r6);
        if (r7 == 0) goto L_0x008a;
    L_0x0078:
        r7 = r3[r4];
        r8 = (double) r7;
        r7 = java.lang.Math.ceil(r8);
        r7 = (float) r7;
        r3[r4] = r7;
        r7 = r3[r4];
        r8 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r7 = r7 + r8;
        r3[r4] = r7;
        goto L_0x0099;
    L_0x008a:
        r7 = r3[r4];
        r7 = (double) r7;
        r7 = java.lang.Math.ceil(r7);
        r7 = (float) r7;
        r3[r4] = r7;
        r7 = r3[r4];
        r7 = r7 + r14;
        r3[r4] = r7;
    L_0x0099:
        r7 = p014c.p015a.p016a.p021c.p022a.C0290j.m268d(r6);
        r8 = 1076538027; // 0x402aaaab float:2.6666667 double:5.318804556E-315;
        r9 = 1068149419; // 0x3faaaaab float:1.3333334 double:5.277359326E-315;
        r16 = 1059760811; // 0x3f2aaaab float:0.6666667 double:5.235914095E-315;
        if (r7 == 0) goto L_0x00af;
    L_0x00a8:
        r7 = r3[r13];
        r7 = r7 + r16;
        r3[r13] = r7;
        goto L_0x00c0;
    L_0x00af:
        r7 = p014c.p015a.p016a.p021c.p022a.C0290j.m267c(r6);
        if (r7 == 0) goto L_0x00bb;
    L_0x00b5:
        r7 = r3[r13];
        r7 = r7 + r8;
        r3[r13] = r7;
        goto L_0x00c0;
    L_0x00bb:
        r7 = r3[r13];
        r7 = r7 + r9;
        r3[r13] = r7;
    L_0x00c0:
        r7 = p014c.p015a.p016a.p021c.p022a.C0290j.m270f(r6);
        if (r7 == 0) goto L_0x00cd;
    L_0x00c6:
        r7 = r3[r10];
        r7 = r7 + r16;
        r3[r10] = r7;
        goto L_0x00de;
    L_0x00cd:
        r7 = p014c.p015a.p016a.p021c.p022a.C0290j.m267c(r6);
        if (r7 == 0) goto L_0x00d9;
    L_0x00d3:
        r7 = r3[r10];
        r7 = r7 + r8;
        r3[r10] = r7;
        goto L_0x00de;
    L_0x00d9:
        r7 = r3[r10];
        r7 = r7 + r9;
        r3[r10] = r7;
    L_0x00de:
        r7 = p014c.p015a.p016a.p021c.p022a.C0290j.m271g(r6);
        if (r7 == 0) goto L_0x00eb;
    L_0x00e4:
        r7 = r3[r12];
        r7 = r7 + r16;
        r3[r12] = r7;
        goto L_0x0102;
    L_0x00eb:
        r7 = p014c.p015a.p016a.p021c.p022a.C0290j.m267c(r6);
        if (r7 == 0) goto L_0x00fa;
    L_0x00f1:
        r7 = r3[r12];
        r8 = 1082829483; // 0x408aaaab float:4.3333335 double:5.34988848E-315;
        r7 = r7 + r8;
        r3[r12] = r7;
        goto L_0x0102;
    L_0x00fa:
        r7 = r3[r12];
        r8 = 1079334229; // 0x40555555 float:3.3333333 double:5.33261963E-315;
        r7 = r7 + r8;
        r3[r12] = r7;
    L_0x0102:
        r7 = p014c.p015a.p016a.p021c.p022a.C0290j.m269e(r6);
        if (r7 == 0) goto L_0x0110;
    L_0x0108:
        r7 = r3[r11];
        r8 = 1061158912; // 0x3f400000 float:0.75 double:5.24282163E-315;
        r7 = r7 + r8;
        r3[r11] = r7;
        goto L_0x0125;
    L_0x0110:
        r7 = p014c.p015a.p016a.p021c.p022a.C0290j.m267c(r6);
        if (r7 == 0) goto L_0x011e;
    L_0x0116:
        r7 = r3[r11];
        r8 = 1082654720; // 0x40880000 float:4.25 double:5.349025035E-315;
        r7 = r7 + r8;
        r3[r11] = r7;
        goto L_0x0125;
    L_0x011e:
        r7 = r3[r11];
        r8 = 1078984704; // 0x40500000 float:3.25 double:5.330892746E-315;
        r7 = r7 + r8;
        r3[r11] = r7;
    L_0x0125:
        r6 = p014c.p015a.p016a.p021c.p022a.C0290j.m272h(r6);
        if (r6 == 0) goto L_0x0134;
    L_0x012b:
        r6 = 5;
        r7 = r3[r6];
        r8 = 1082130432; // 0x40800000 float:4.0 double:5.34643471E-315;
        r7 = r7 + r8;
        r3[r6] = r7;
        goto L_0x013a;
    L_0x0134:
        r6 = 5;
        r7 = r3[r6];
        r7 = r7 + r14;
        r3[r6] = r7;
    L_0x013a:
        if (r5 < r11) goto L_0x001e;
    L_0x013c:
        r7 = new int[r2];
        r8 = new byte[r2];
        r9 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        p014c.p015a.p016a.p021c.p022a.C0290j.m263a(r3, r7, r9, r8);
        r9 = p014c.p015a.p016a.p021c.p022a.C0290j.m262a(r8);
        r14 = r7[r4];
        r15 = r7[r6];
        r6 = r15;
        if (r14 >= r6) goto L_0x016a;
    L_0x0151:
        r6 = r7[r4];
        r14 = r7[r13];
        if (r6 >= r14) goto L_0x016a;
    L_0x0157:
        r6 = r7[r4];
        r14 = r7[r10];
        if (r6 >= r14) goto L_0x016a;
    L_0x015d:
        r6 = r7[r4];
        r14 = r7[r12];
        if (r6 >= r14) goto L_0x016a;
    L_0x0163:
        r6 = r7[r4];
        r14 = r7[r11];
        if (r6 >= r14) goto L_0x016a;
    L_0x0169:
        return r4;
    L_0x016a:
        r6 = 5;
        r14 = r7[r6];
        r6 = r7[r4];
        if (r14 < r6) goto L_0x01db;
    L_0x0171:
        r6 = r8[r13];
        r14 = r8[r10];
        r6 = r6 + r14;
        r14 = r8[r12];
        r6 = r6 + r14;
        r14 = r8[r11];
        r6 = r6 + r14;
        if (r6 != 0) goto L_0x017f;
    L_0x017e:
        goto L_0x01db;
    L_0x017f:
        if (r9 != r13) goto L_0x0186;
    L_0x0181:
        r6 = r8[r11];
        if (r6 <= 0) goto L_0x0186;
    L_0x0185:
        return r11;
    L_0x0186:
        if (r9 != r13) goto L_0x018d;
    L_0x0188:
        r6 = r8[r10];
        if (r6 <= 0) goto L_0x018d;
    L_0x018c:
        return r10;
    L_0x018d:
        if (r9 != r13) goto L_0x0194;
    L_0x018f:
        r6 = r8[r12];
        if (r6 <= 0) goto L_0x0194;
    L_0x0193:
        return r12;
    L_0x0194:
        r6 = r7[r13];
        r6 = r6 + r13;
        r8 = r7[r4];
        if (r6 >= r8) goto L_0x001e;
    L_0x019b:
        r6 = r7[r13];
        r6 = r6 + r13;
        r8 = 5;
        r8 = r7[r8];
        if (r6 >= r8) goto L_0x001e;
    L_0x01a3:
        r6 = r7[r13];
        r6 = r6 + r13;
        r8 = r7[r11];
        if (r6 >= r8) goto L_0x001e;
    L_0x01aa:
        r6 = r7[r13];
        r6 = r6 + r13;
        r8 = r7[r10];
        if (r6 >= r8) goto L_0x001e;
    L_0x01b1:
        r6 = r7[r13];
        r8 = r7[r12];
        if (r6 >= r8) goto L_0x01b8;
    L_0x01b7:
        return r13;
    L_0x01b8:
        r6 = r7[r13];
        r7 = r7[r12];
        if (r6 != r7) goto L_0x001e;
    L_0x01be:
        r1 = r1 + r5;
        r1 = r1 + r13;
    L_0x01c0:
        r2 = r17.length();
        if (r1 >= r2) goto L_0x01da;
    L_0x01c6:
        r2 = r0.charAt(r1);
        r3 = p014c.p015a.p016a.p021c.p022a.C0290j.m273i(r2);
        if (r3 == 0) goto L_0x01d1;
    L_0x01d0:
        return r12;
    L_0x01d1:
        r2 = p014c.p015a.p016a.p021c.p022a.C0290j.m271g(r2);
        if (r2 == 0) goto L_0x01da;
    L_0x01d7:
        r1 = r1 + 1;
        goto L_0x01c0;
    L_0x01da:
        return r13;
    L_0x01db:
        r0 = 5;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: c.a.a.c.a.j.a(java.lang.CharSequence, int, int):int");
    }

    /* renamed from: a */
    private static int m262a(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 6; i2++) {
            i += bArr[i2];
        }
        return i;
    }

    /* renamed from: a */
    private static int m263a(float[] fArr, int[] iArr, int i, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        int i2 = i;
        for (i = 0; i < 6; i++) {
            iArr[i] = (int) Math.ceil((double) fArr[i]);
            int i3 = iArr[i];
            if (i2 > i3) {
                Arrays.fill(bArr, (byte) 0);
                i2 = i3;
            }
            if (i2 == i3) {
                bArr[i] = (byte) (bArr[i] + 1);
            }
        }
        return i2;
    }

    /* renamed from: a */
    public static String m264a(String str, C0292l c0292l, C0285b c0285b, C0285b c0285b2) {
        char c;
        int a;
        int a2;
        StringBuilder b;
        r0 = new C0287g[6];
        int i = 0;
        r0[0] = new C0802a();
        r0[1] = new C0804c();
        r0[2] = new C0902m();
        r0[3] = new C0903n();
        r0[4] = new C0806f();
        r0[5] = new C0803b();
        C0288h c0288h = new C0288h(str);
        c0288h.m242a(c0292l);
        c0288h.m241a(c0285b, c0285b2);
        String str2 = "\u001e\u0004";
        if (str.startsWith("[)>\u001e05\u001d") && str.endsWith(str2)) {
            c = 'ì';
        } else {
            if (str.startsWith("[)>\u001e06\u001d") && str.endsWith(str2)) {
                c = 'í';
            }
            while (c0288h.m252h()) {
                r0[i].mo942a(c0288h);
                if (c0288h.m249e() >= 0) {
                    i = c0288h.m249e();
                    c0288h.m253i();
                }
            }
            a = c0288h.m238a();
            c0288h.m255k();
            a2 = c0288h.m251g().m277a();
            if (!(a >= a2 || i == 0 || i == 5)) {
                c0288h.m239a('þ');
            }
            b = c0288h.m244b();
            if (b.length() < a2) {
                b.append('');
            }
            while (b.length() < a2) {
                b.append(C0290j.m259a('', b.length() + 1));
            }
            return c0288h.m244b().toString();
        }
        c0288h.m239a(c);
        c0288h.m240a(2);
        c0288h.f232f += 7;
        while (c0288h.m252h()) {
            r0[i].mo942a(c0288h);
            if (c0288h.m249e() >= 0) {
                i = c0288h.m249e();
                c0288h.m253i();
            }
        }
        a = c0288h.m238a();
        c0288h.m255k();
        a2 = c0288h.m251g().m277a();
        c0288h.m239a('þ');
        b = c0288h.m244b();
        if (b.length() < a2) {
            b.append('');
        }
        while (b.length() < a2) {
            b.append(C0290j.m259a('', b.length() + 1));
        }
        return c0288h.m244b().toString();
    }

    /* renamed from: a */
    static void m265a(char c) {
        String toHexString = Integer.toHexString(c);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0000".substring(0, 4 - toHexString.length()));
        stringBuilder.append(toHexString);
        toHexString = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder("Illegal character: ");
        stringBuilder2.append(c);
        stringBuilder2.append(" (0x");
        stringBuilder2.append(toHexString);
        stringBuilder2.append(')');
        throw new IllegalArgumentException(stringBuilder2.toString());
    }

    /* renamed from: b */
    static boolean m266b(char c) {
        return c >= '0' && c <= '9';
    }

    /* renamed from: c */
    static boolean m267c(char c) {
        return c >= '' && c <= 'ÿ';
    }

    /* renamed from: d */
    private static boolean m268d(char c) {
        if (c != ' ' && (c < '0' || c > '9')) {
            if (c < 'A' || c > 'Z') {
                return false;
            }
        }
        return true;
    }

    /* renamed from: e */
    private static boolean m269e(char c) {
        return c >= ' ' && c <= '^';
    }

    /* renamed from: f */
    private static boolean m270f(char c) {
        if (c != ' ' && (c < '0' || c > '9')) {
            if (c < 'a' || c > 'z') {
                return false;
            }
        }
        return true;
    }

    /* renamed from: g */
    private static boolean m271g(char c) {
        if (!(C0290j.m273i(c) || c == ' ' || (c >= '0' && c <= '9'))) {
            if (c < 'A' || c > 'Z') {
                return false;
            }
        }
        return true;
    }

    /* renamed from: h */
    private static boolean m272h(char c) {
        return false;
    }

    /* renamed from: i */
    private static boolean m273i(char c) {
        if (!(c == '\r' || c == '*')) {
            if (c != '>') {
                return false;
            }
        }
        return true;
    }
}
