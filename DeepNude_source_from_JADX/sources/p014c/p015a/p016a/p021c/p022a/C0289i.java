package p014c.p015a.p016a.p021c.p022a;

/* renamed from: c.a.a.c.a.i */
public final class C0289i {
    /* renamed from: a */
    private static final int[] f236a = new int[]{5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    /* renamed from: b */
    private static final int[][] f237b;
    /* renamed from: c */
    private static final int[] f238c = new int[256];
    /* renamed from: d */
    private static final int[] f239d = new int[255];

    static {
        r0 = new int[16][];
        int i = 0;
        r0[0] = new int[]{228, 48, 15, 111, 62};
        r0[1] = new int[]{23, 68, 144, 134, 240, 92, 254};
        r0[2] = new int[]{28, 24, 185, 166, 223, 248, 116, 255, 110, 61};
        r0[3] = new int[]{175, 138, 205, 12, 194, 168, 39, 245, 60, 97, 120};
        r0[4] = new int[]{41, 153, 158, 91, 61, 42, 142, 213, 97, 178, 100, 242};
        r0[5] = new int[]{156, 97, 192, 252, 95, 9, 157, 119, 138, 45, 18, 186, 83, 185};
        r0[6] = new int[]{83, 195, 100, 39, 188, 75, 66, 61, 241, 213, 109, 129, 94, 254, 225, 48, 90, 188};
        r0[7] = new int[]{15, 195, 244, 9, 233, 71, 168, 2, 188, 160, 153, 145, 253, 79, 108, 82, 27, 174, 186, 172};
        r0[8] = new int[]{52, 190, 88, 205, 109, 39, 176, 21, 155, 197, 251, 223, 155, 21, 5, 172, 254, 124, 12, 181, 184, 96, 50, 193};
        r0[9] = new int[]{211, 231, 43, 97, 71, 96, 103, 174, 37, 151, 170, 53, 75, 34, 249, 121, 17, 138, 110, 213, 141, 136, 120, 151, 233, 168, 93, 255};
        r0[10] = new int[]{245, 127, 242, 218, 130, 250, 162, 181, 102, 120, 84, 179, 220, 251, 80, 182, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, 175, 184, 59, 25, 225, 98, 81, 112};
        r0[11] = new int[]{77, 193, 137, 31, 19, 38, 22, 153, 247, 105, 122, 2, 245, 133, 242, 8, 175, 95, 100, 9, 167, 105, 214, 111, 57, 121, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, 150, 177, 226, 5, 9, 5};
        r0[12] = new int[]{245, 132, 172, 223, 96, 32, 117, 22, 238, 133, 238, 231, 205, 188, 237, 87, 191, 106, 16, 147, 118, 23, 37, 90, 170, 205, 131, 88, 120, 100, 66, 138, 186, 240, 82, 44, 176, 87, 187, 147, 160, 175, 69, 213, 92, 253, 225, 19};
        r0[13] = new int[]{175, 9, 223, 238, 12, 17, 220, 208, 100, 29, 175, 170, 230, 192, 215, 235, 150, 159, 36, 223, 38, 200, 132, 54, 228, 146, 218, 234, 117, 203, 29, 232, 144, 238, 22, 150, 201, 117, 62, 207, 164, 13, 137, 245, 127, 67, 247, 28, 155, 43, 203, 107, 233, 53, 143, 46};
        r0[14] = new int[]{242, 93, 169, 50, 144, 210, 39, 118, 202, 188, 201, 189, 143, 108, 196, 37, 185, 112, 134, 230, 245, 63, 197, 190, 250, 106, 185, 221, 175, 64, 114, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, 130, 188, 17, 163, 31, 176, 170, 4, 107, 232, 7, 94, 166, 224, 124, 86, 47, 11, 204};
        r0[15] = new int[]{220, 228, 173, 89, 251, 149, 159, 56, 89, 33, 147, 244, 154, 36, 73, 127, 213, 136, 248, 180, 234, 197, 158, 177, 68, 122, 93, 213, 15, 160, 227, 236, 66, 139, 153, 185, 202, 167, 179, 25, 220, 232, 96, 210, 231, 136, 223, 239, 181, 241, 59, 52, 172, 25, 49, 232, 211, 189, 64, 54, 108, 153, 132, 63, 96, 103, 82, 186};
        f237b = r0;
        int i2 = 1;
        while (i < 255) {
            f239d[i] = i2;
            f238c[i2] = i;
            i2 <<= 1;
            if (i2 >= 256) {
                i2 ^= 301;
            }
            i++;
        }
    }

    /* renamed from: a */
    private static String m256a(CharSequence charSequence, int i) {
        return C0289i.m257a(charSequence, 0, charSequence.length(), i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static java.lang.String m257a(java.lang.CharSequence r11, int r12, int r13, int r14) {
        /*
        r0 = 0;
        r1 = 0;
    L_0x0002:
        r2 = f236a;
        r3 = r2.length;
        if (r1 >= r3) goto L_0x000f;
    L_0x0007:
        r2 = r2[r1];
        if (r2 != r14) goto L_0x000c;
    L_0x000b:
        goto L_0x0010;
    L_0x000c:
        r1 = r1 + 1;
        goto L_0x0002;
    L_0x000f:
        r1 = -1;
    L_0x0010:
        if (r1 < 0) goto L_0x0089;
    L_0x0012:
        r2 = f237b;
        r1 = r2[r1];
        r2 = new char[r14];
        r3 = 0;
    L_0x0019:
        if (r3 >= r14) goto L_0x0020;
    L_0x001b:
        r2[r3] = r0;
        r3 = r3 + 1;
        goto L_0x0019;
    L_0x0020:
        r3 = r12;
    L_0x0021:
        r4 = r12 + r13;
        if (r3 >= r4) goto L_0x0075;
    L_0x0025:
        r4 = r14 + -1;
        r5 = r2[r4];
        r6 = r11.charAt(r3);
        r5 = r5 ^ r6;
    L_0x002e:
        if (r4 <= 0) goto L_0x0057;
    L_0x0030:
        if (r5 == 0) goto L_0x004e;
    L_0x0032:
        r6 = r1[r4];
        if (r6 == 0) goto L_0x004e;
    L_0x0036:
        r6 = r4 + -1;
        r6 = r2[r6];
        r7 = f239d;
        r8 = f238c;
        r9 = r8[r5];
        r10 = r1[r4];
        r8 = r8[r10];
        r9 = r9 + r8;
        r9 = r9 % 255;
        r7 = r7[r9];
        r6 = r6 ^ r7;
        r6 = (char) r6;
        r2[r4] = r6;
        goto L_0x0054;
    L_0x004e:
        r6 = r4 + -1;
        r6 = r2[r6];
        r2[r4] = r6;
    L_0x0054:
        r4 = r4 + -1;
        goto L_0x002e;
    L_0x0057:
        if (r5 == 0) goto L_0x0070;
    L_0x0059:
        r4 = r1[r0];
        if (r4 == 0) goto L_0x0070;
    L_0x005d:
        r4 = f239d;
        r6 = f238c;
        r5 = r6[r5];
        r7 = r1[r0];
        r6 = r6[r7];
        r5 = r5 + r6;
        r5 = r5 % 255;
        r4 = r4[r5];
        r4 = (char) r4;
        r2[r0] = r4;
        goto L_0x0072;
    L_0x0070:
        r2[r0] = r0;
    L_0x0072:
        r3 = r3 + 1;
        goto L_0x0021;
    L_0x0075:
        r11 = new char[r14];
    L_0x0077:
        if (r0 >= r14) goto L_0x0084;
    L_0x0079:
        r12 = r14 - r0;
        r12 = r12 + -1;
        r12 = r2[r12];
        r11[r0] = r12;
        r0 = r0 + 1;
        goto L_0x0077;
    L_0x0084:
        r11 = java.lang.String.valueOf(r11);
        return r11;
    L_0x0089:
        r11 = new java.lang.IllegalArgumentException;
        r12 = new java.lang.StringBuilder;
        r13 = "Illegal number of error correction codewords specified: ";
        r12.<init>(r13);
        r12.append(r14);
        r12 = r12.toString();
        r11.<init>(r12);
        goto L_0x009e;
    L_0x009d:
        throw r11;
    L_0x009e:
        goto L_0x009d;
        */
        throw new UnsupportedOperationException("Method not decompiled: c.a.a.c.a.i.a(java.lang.CharSequence, int, int, int):java.lang.String");
    }

    /* renamed from: a */
    public static String m258a(String str, C0291k c0291k) {
        if (str.length() == c0291k.m277a()) {
            StringBuilder stringBuilder = new StringBuilder(c0291k.m277a() + c0291k.m279b());
            stringBuilder.append(str);
            int c = c0291k.mo944c();
            if (c == 1) {
                stringBuilder.append(C0289i.m256a((CharSequence) str, c0291k.m279b()));
            } else {
                int i;
                stringBuilder.setLength(stringBuilder.capacity());
                int[] iArr = new int[c];
                int[] iArr2 = new int[c];
                int[] iArr3 = new int[c];
                int i2 = 0;
                while (i2 < c) {
                    i = i2 + 1;
                    iArr[i2] = c0291k.mo943a(i);
                    iArr2[i2] = c0291k.m280b(i);
                    iArr3[i2] = 0;
                    if (i2 > 0) {
                        iArr3[i2] = iArr3[i2 - 1] + iArr[i2];
                    }
                    i2 = i;
                }
                for (int i3 = 0; i3 < c; i3++) {
                    StringBuilder stringBuilder2 = new StringBuilder(iArr[i3]);
                    for (i = i3; i < c0291k.m277a(); i += c) {
                        stringBuilder2.append(str.charAt(i));
                    }
                    String a = C0289i.m256a(stringBuilder2.toString(), iArr2[i3]);
                    i = i3;
                    int i4 = 0;
                    while (i < iArr2[i3] * c) {
                        int i5 = i4 + 1;
                        stringBuilder.setCharAt(c0291k.m277a() + i, a.charAt(i4));
                        i += c;
                        i4 = i5;
                    }
                }
            }
            return stringBuilder.toString();
        }
        throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
    }
}
