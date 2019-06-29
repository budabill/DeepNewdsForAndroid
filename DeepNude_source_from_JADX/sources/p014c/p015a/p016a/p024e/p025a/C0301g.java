package p014c.p015a.p016a.p024e.p025a;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import p014c.p015a.p016a.C0318j;
import p014c.p015a.p016a.p019b.C0284c;

/* renamed from: c.a.a.e.a.g */
final class C0301g {
    /* renamed from: a */
    private static final byte[] f296a = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 38, (byte) 13, (byte) 9, (byte) 44, (byte) 58, (byte) 35, (byte) 45, (byte) 46, (byte) 36, (byte) 47, (byte) 43, (byte) 37, (byte) 42, (byte) 61, (byte) 94, (byte) 0, (byte) 32, (byte) 0, (byte) 0, (byte) 0};
    /* renamed from: b */
    private static final byte[] f297b = new byte[]{(byte) 59, (byte) 60, (byte) 62, (byte) 64, (byte) 91, (byte) 92, (byte) 93, (byte) 95, (byte) 96, (byte) 126, (byte) 33, (byte) 13, (byte) 9, (byte) 44, (byte) 58, (byte) 10, (byte) 45, (byte) 46, (byte) 36, (byte) 47, (byte) 34, (byte) 124, (byte) 42, (byte) 40, (byte) 41, (byte) 63, (byte) 123, (byte) 125, (byte) 39, (byte) 0};
    /* renamed from: c */
    private static final byte[] f298c = new byte[128];
    /* renamed from: d */
    private static final byte[] f299d = new byte[128];
    /* renamed from: e */
    private static final Charset f300e = Charset.forName("ISO-8859-1");

    static {
        Arrays.fill(f298c, (byte) -1);
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = f296a;
            if (i2 >= bArr.length) {
                break;
            }
            byte b = bArr[i2];
            if (b > (byte) 0) {
                f298c[b] = (byte) i2;
            }
            i2++;
        }
        Arrays.fill(f299d, (byte) -1);
        while (true) {
            byte[] bArr2 = f297b;
            if (i < bArr2.length) {
                byte b2 = bArr2[i];
                if (b2 > (byte) 0) {
                    f299d[b2] = (byte) i;
                }
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private static int m309a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        if (i < length) {
            loop0:
            while (true) {
                char charAt = charSequence.charAt(i);
                while (C0301g.m319c(charAt) && i < length) {
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
    private static int m310a(java.lang.CharSequence r16, int r17, int r18, java.lang.StringBuilder r19, int r20) {
        /*
        r0 = r16;
        r1 = r18;
        r2 = r19;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r1);
        r4 = 2;
        r5 = 0;
        r6 = 1;
        r8 = r20;
        r7 = 0;
    L_0x0011:
        r9 = r17 + r7;
        r10 = r0.charAt(r9);
        r11 = 26;
        r12 = 32;
        r13 = 28;
        r14 = 27;
        r15 = 29;
        if (r8 == 0) goto L_0x009a;
    L_0x0023:
        if (r8 == r6) goto L_0x0075;
    L_0x0025:
        if (r8 == r4) goto L_0x003c;
    L_0x0027:
        r9 = p014c.p015a.p016a.p024e.p025a.C0301g.m321e(r10);
        if (r9 == 0) goto L_0x0037;
    L_0x002d:
        r9 = f299d;
        r9 = r9[r10];
    L_0x0031:
        r9 = (char) r9;
    L_0x0032:
        r3.append(r9);
        goto L_0x00cb;
    L_0x0037:
        r3.append(r15);
    L_0x003a:
        r8 = 0;
        goto L_0x0011;
    L_0x003c:
        r11 = p014c.p015a.p016a.p024e.p025a.C0301g.m320d(r10);
        if (r11 == 0) goto L_0x0047;
    L_0x0042:
        r9 = f298c;
        r9 = r9[r10];
        goto L_0x0031;
    L_0x0047:
        r11 = p014c.p015a.p016a.p024e.p025a.C0301g.m318b(r10);
        if (r11 == 0) goto L_0x0051;
    L_0x004d:
        r3.append(r13);
        goto L_0x003a;
    L_0x0051:
        r11 = p014c.p015a.p016a.p024e.p025a.C0301g.m316a(r10);
        if (r11 == 0) goto L_0x0058;
    L_0x0057:
        goto L_0x00b0;
    L_0x0058:
        r9 = r9 + 1;
        if (r9 >= r1) goto L_0x006d;
    L_0x005c:
        r9 = r0.charAt(r9);
        r9 = p014c.p015a.p016a.p024e.p025a.C0301g.m321e(r9);
        if (r9 == 0) goto L_0x006d;
    L_0x0066:
        r8 = 3;
        r9 = 25;
        r3.append(r9);
        goto L_0x0011;
    L_0x006d:
        r3.append(r15);
        r9 = f299d;
        r9 = r9[r10];
        goto L_0x0031;
    L_0x0075:
        r9 = p014c.p015a.p016a.p024e.p025a.C0301g.m316a(r10);
        if (r9 == 0) goto L_0x0081;
    L_0x007b:
        if (r10 != r12) goto L_0x007e;
    L_0x007d:
        goto L_0x00a2;
    L_0x007e:
        r10 = r10 + -97;
        goto L_0x00a8;
    L_0x0081:
        r9 = p014c.p015a.p016a.p024e.p025a.C0301g.m318b(r10);
        if (r9 == 0) goto L_0x008b;
    L_0x0087:
        r3.append(r14);
        goto L_0x00a6;
    L_0x008b:
        r9 = p014c.p015a.p016a.p024e.p025a.C0301g.m320d(r10);
        if (r9 == 0) goto L_0x0092;
    L_0x0091:
        goto L_0x00bc;
    L_0x0092:
        r3.append(r15);
        r9 = f299d;
        r9 = r9[r10];
        goto L_0x0031;
    L_0x009a:
        r9 = p014c.p015a.p016a.p024e.p025a.C0301g.m318b(r10);
        if (r9 == 0) goto L_0x00aa;
    L_0x00a0:
        if (r10 != r12) goto L_0x00a6;
    L_0x00a2:
        r3.append(r11);
        goto L_0x00cb;
    L_0x00a6:
        r10 = r10 + -65;
    L_0x00a8:
        r9 = (char) r10;
        goto L_0x0032;
    L_0x00aa:
        r9 = p014c.p015a.p016a.p024e.p025a.C0301g.m316a(r10);
        if (r9 == 0) goto L_0x00b6;
    L_0x00b0:
        r3.append(r14);
        r8 = 1;
        goto L_0x0011;
    L_0x00b6:
        r9 = p014c.p015a.p016a.p024e.p025a.C0301g.m320d(r10);
        if (r9 == 0) goto L_0x00c2;
    L_0x00bc:
        r3.append(r13);
        r8 = 2;
        goto L_0x0011;
    L_0x00c2:
        r3.append(r15);
        r9 = f299d;
        r9 = r9[r10];
        goto L_0x0031;
    L_0x00cb:
        r7 = r7 + 1;
        if (r7 < r1) goto L_0x0011;
    L_0x00cf:
        r0 = r3.length();
        r1 = 0;
        r7 = 0;
    L_0x00d5:
        if (r1 >= r0) goto L_0x00f3;
    L_0x00d7:
        r9 = r1 % 2;
        if (r9 == 0) goto L_0x00dd;
    L_0x00db:
        r9 = 1;
        goto L_0x00de;
    L_0x00dd:
        r9 = 0;
    L_0x00de:
        if (r9 == 0) goto L_0x00ec;
    L_0x00e0:
        r7 = r7 * 30;
        r9 = r3.charAt(r1);
        r7 = r7 + r9;
        r7 = (char) r7;
        r2.append(r7);
        goto L_0x00f0;
    L_0x00ec:
        r7 = r3.charAt(r1);
    L_0x00f0:
        r1 = r1 + 1;
        goto L_0x00d5;
    L_0x00f3:
        r0 = r0 % r4;
        if (r0 == 0) goto L_0x00fd;
    L_0x00f6:
        r7 = r7 * 30;
        r7 = r7 + r15;
        r0 = (char) r7;
        r2.append(r0);
    L_0x00fd:
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: c.a.a.e.a.g.a(java.lang.CharSequence, int, int, java.lang.StringBuilder, int):int");
    }

    /* renamed from: a */
    private static int m311a(String str, int i, Charset charset) {
        CharsetEncoder newEncoder = charset.newEncoder();
        int length = str.length();
        int i2 = i;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            int i3 = 0;
            while (i3 < 13 && C0301g.m319c(r2)) {
                i3++;
                int i4 = i2 + i3;
                if (i4 >= length) {
                    break;
                }
                charAt = str.charAt(i4);
            }
            if (i3 >= 13) {
                return i2 - i;
            }
            charAt = str.charAt(i2);
            if (newEncoder.canEncode(charAt)) {
                i2++;
            } else {
                StringBuilder stringBuilder = new StringBuilder("Non-encodable character detected: ");
                stringBuilder.append(charAt);
                stringBuilder.append(" (Unicode: ");
                stringBuilder.append(charAt);
                stringBuilder.append(')');
                throw new C0318j(stringBuilder.toString());
            }
        }
        return i2 - i;
    }

    /* renamed from: a */
    static String m312a(String str, C0297c c0297c, Charset charset) {
        StringBuilder stringBuilder = new StringBuilder(str.length());
        if (charset == null) {
            charset = f300e;
        } else if (!f300e.equals(charset)) {
            C0284c a = C0284c.m222a(charset.name());
            if (a != null) {
                C0301g.m313a(a.m223a(), stringBuilder);
            }
        }
        int length = str.length();
        if (c0297c == C0297c.TEXT) {
            C0301g.m310a((CharSequence) str, 0, length, stringBuilder, 0);
        } else if (c0297c == C0297c.BYTE) {
            byte[] bytes = str.getBytes(charset);
            C0301g.m315a(bytes, 0, bytes.length, 1, stringBuilder);
        } else if (c0297c == C0297c.NUMERIC) {
            stringBuilder.append('Ά');
            C0301g.m314a(str, 0, length, stringBuilder);
        } else {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (i < length) {
                int a2 = C0301g.m309a((CharSequence) str, i);
                if (a2 >= 13) {
                    stringBuilder.append('Ά');
                    i3 = 2;
                    C0301g.m314a(str, i, a2, stringBuilder);
                    i += a2;
                    i2 = 0;
                } else {
                    int b = C0301g.m317b(str, i);
                    if (b < 5) {
                        if (a2 != length) {
                            a2 = C0301g.m311a(str, i, charset);
                            if (a2 == 0) {
                                a2 = 1;
                            }
                            a2 += i;
                            byte[] bytes2 = str.substring(i, a2).getBytes(charset);
                            if (bytes2.length == 1 && i3 == 0) {
                                C0301g.m315a(bytes2, 0, 1, 0, stringBuilder);
                            } else {
                                C0301g.m315a(bytes2, 0, bytes2.length, i3, stringBuilder);
                                i2 = 0;
                                i3 = 1;
                            }
                            i = a2;
                        }
                    }
                    if (i3 != 0) {
                        stringBuilder.append('΄');
                        i2 = 0;
                        i3 = 0;
                    }
                    i2 = C0301g.m310a((CharSequence) str, i, b, stringBuilder, i2);
                    i += b;
                }
            }
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private static void m313a(int i, StringBuilder stringBuilder) {
        char c;
        if (i >= 0 && i < 900) {
            stringBuilder.append('Ο');
        } else if (i < 810900) {
            stringBuilder.append('Ξ');
            stringBuilder.append((char) ((i / 900) - 1));
            i %= 900;
        } else if (i < 811800) {
            stringBuilder.append('Ν');
            c = (char) (810900 - i);
            stringBuilder.append(c);
        } else {
            StringBuilder stringBuilder2 = new StringBuilder("ECI number not in valid range from 0..811799, but was ");
            stringBuilder2.append(i);
            throw new C0318j(stringBuilder2.toString());
        }
        c = (char) i;
        stringBuilder.append(c);
    }

    /* renamed from: a */
    private static void m314a(String str, int i, int i2, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder((i2 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900);
        BigInteger valueOf2 = BigInteger.valueOf(0);
        int i3 = 0;
        while (i3 < i2) {
            stringBuilder2.setLength(0);
            int min = Math.min(44, i2 - i3);
            StringBuilder stringBuilder3 = new StringBuilder("1");
            int i4 = i + i3;
            stringBuilder3.append(str.substring(i4, i4 + min));
            BigInteger bigInteger = new BigInteger(stringBuilder3.toString());
            do {
                stringBuilder2.append((char) bigInteger.mod(valueOf).intValue());
                bigInteger = bigInteger.divide(valueOf);
            } while (!bigInteger.equals(valueOf2));
            for (int length = stringBuilder2.length() - 1; length >= 0; length--) {
                stringBuilder.append(stringBuilder2.charAt(length));
            }
            i3 += min;
        }
    }

    /* renamed from: a */
    private static void m315a(byte[] bArr, int i, int i2, int i3, StringBuilder stringBuilder) {
        int i4;
        char c = (i2 == 1 && i3 == 0) ? 'Α' : i2 % 6 == 0 ? 'Μ' : '΅';
        stringBuilder.append(c);
        if (i2 >= 6) {
            char[] cArr = new char[5];
            i4 = i;
            while ((i + i2) - i4 >= 6) {
                int i5;
                long j = 0;
                for (i5 = 0; i5 < 6; i5++) {
                    j = (j << 8) + ((long) (bArr[i4 + i5] & 255));
                }
                for (int i6 = 0; i6 < 5; i6++) {
                    cArr[i6] = (char) ((int) (j % 900));
                    j /= 900;
                }
                for (i5 = 4; i5 >= 0; i5--) {
                    stringBuilder.append(cArr[i5]);
                }
                i4 += 6;
            }
        } else {
            i4 = i;
        }
        while (i4 < i + i2) {
            stringBuilder.append((char) (bArr[i4] & 255));
            i4++;
        }
    }

    /* renamed from: a */
    private static boolean m316a(char c) {
        if (c != ' ') {
            if (c < 'a' || c > 'z') {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private static int m317b(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = i;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            int i3 = 0;
            while (i3 < 13 && C0301g.m319c(r2) && i2 < length) {
                i3++;
                i2++;
                if (i2 < length) {
                    charAt = charSequence.charAt(i2);
                }
            }
            if (i3 < 13) {
                if (i3 <= 0) {
                    if (!C0301g.m322f(charSequence.charAt(i2))) {
                        break;
                    }
                    i2++;
                }
            } else {
                return (i2 - i) - i3;
            }
        }
        return i2 - i;
    }

    /* renamed from: b */
    private static boolean m318b(char c) {
        if (c != ' ') {
            if (c < 'A' || c > 'Z') {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    private static boolean m319c(char c) {
        return c >= '0' && c <= '9';
    }

    /* renamed from: d */
    private static boolean m320d(char c) {
        return f298c[c] != (byte) -1;
    }

    /* renamed from: e */
    private static boolean m321e(char c) {
        return f299d[c] != (byte) -1;
    }

    /* renamed from: f */
    private static boolean m322f(char c) {
        if (!(c == '\t' || c == '\n' || c == '\r')) {
            if (c < ' ' || c > '~') {
                return false;
            }
        }
        return true;
    }
}
