package com.google.android.gms.internal;

final class zzfkw extends zzfkt {
    zzfkw() {
    }

    private static int zza(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            return zzfks.zzmu(i);
        }
        if (i2 == 1) {
            return zzfks.zzam(i, zzfkq.zzb(bArr, j));
        }
        if (i2 == 2) {
            return zzfks.zzi(i, zzfkq.zzb(bArr, j), zzfkq.zzb(bArr, j + 1));
        }
        throw new AssertionError();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzb(byte[] r11, long r12, int r14) {
        /*
        r0 = 0;
        r1 = 1;
        r3 = 16;
        if (r14 >= r3) goto L_0x0009;
    L_0x0007:
        r3 = 0;
        goto L_0x001b;
    L_0x0009:
        r4 = r12;
        r3 = 0;
    L_0x000b:
        if (r3 >= r14) goto L_0x001a;
    L_0x000d:
        r6 = r4 + r1;
        r4 = com.google.android.gms.internal.zzfkq.zzb(r11, r4);
        if (r4 >= 0) goto L_0x0016;
    L_0x0015:
        goto L_0x001b;
    L_0x0016:
        r3 = r3 + 1;
        r4 = r6;
        goto L_0x000b;
    L_0x001a:
        r3 = r14;
    L_0x001b:
        r14 = r14 - r3;
        r3 = (long) r3;
        r12 = r12 + r3;
    L_0x001e:
        r3 = 0;
    L_0x001f:
        if (r14 <= 0) goto L_0x002f;
    L_0x0021:
        r3 = r12 + r1;
        r12 = com.google.android.gms.internal.zzfkq.zzb(r11, r12);
        if (r12 < 0) goto L_0x0032;
    L_0x0029:
        r14 = r14 + -1;
        r9 = r3;
        r3 = r12;
        r12 = r9;
        goto L_0x001f;
    L_0x002f:
        r9 = r12;
        r12 = r3;
        r3 = r9;
    L_0x0032:
        if (r14 != 0) goto L_0x0035;
    L_0x0034:
        return r0;
    L_0x0035:
        r14 = r14 + -1;
        r13 = -32;
        r5 = -65;
        r6 = -1;
        if (r12 >= r13) goto L_0x0050;
    L_0x003e:
        if (r14 != 0) goto L_0x0041;
    L_0x0040:
        return r12;
    L_0x0041:
        r14 = r14 + -1;
        r13 = -62;
        if (r12 < r13) goto L_0x004f;
    L_0x0047:
        r12 = r3 + r1;
        r3 = com.google.android.gms.internal.zzfkq.zzb(r11, r3);
        if (r3 <= r5) goto L_0x001e;
    L_0x004f:
        return r6;
    L_0x0050:
        r7 = -16;
        if (r12 >= r7) goto L_0x007b;
    L_0x0054:
        r7 = 2;
        if (r14 >= r7) goto L_0x005c;
    L_0x0057:
        r11 = zza(r11, r12, r3, r14);
        return r11;
    L_0x005c:
        r14 = r14 + -2;
        r7 = r3 + r1;
        r3 = com.google.android.gms.internal.zzfkq.zzb(r11, r3);
        if (r3 > r5) goto L_0x007a;
    L_0x0066:
        r4 = -96;
        if (r12 != r13) goto L_0x006c;
    L_0x006a:
        if (r3 < r4) goto L_0x007a;
    L_0x006c:
        r13 = -19;
        if (r12 != r13) goto L_0x0072;
    L_0x0070:
        if (r3 >= r4) goto L_0x007a;
    L_0x0072:
        r12 = r7 + r1;
        r3 = com.google.android.gms.internal.zzfkq.zzb(r11, r7);
        if (r3 <= r5) goto L_0x001e;
    L_0x007a:
        return r6;
    L_0x007b:
        r13 = 3;
        if (r14 >= r13) goto L_0x0083;
    L_0x007e:
        r11 = zza(r11, r12, r3, r14);
        return r11;
    L_0x0083:
        r14 = r14 + -3;
        r7 = r3 + r1;
        r13 = com.google.android.gms.internal.zzfkq.zzb(r11, r3);
        if (r13 > r5) goto L_0x00aa;
    L_0x008d:
        r12 = r12 << 28;
        r13 = r13 + 112;
        r12 = r12 + r13;
        r12 = r12 >> 30;
        if (r12 != 0) goto L_0x00aa;
    L_0x0096:
        r12 = r7 + r1;
        r3 = com.google.android.gms.internal.zzfkq.zzb(r11, r7);
        if (r3 > r5) goto L_0x00aa;
    L_0x009e:
        r3 = r12 + r1;
        r12 = com.google.android.gms.internal.zzfkq.zzb(r11, r12);
        if (r12 <= r5) goto L_0x00a7;
    L_0x00a6:
        goto L_0x00aa;
    L_0x00a7:
        r12 = r3;
        goto L_0x001e;
    L_0x00aa:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfkw.zzb(byte[], long, int):int");
    }

    final int zzb(int i, byte[] bArr, int i2, int i3) {
        if (((i2 | i3) | (bArr.length - i3)) >= 0) {
            long j = (long) i2;
            return zzb(bArr, j, (int) (((long) i3) - j));
        }
        throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)}));
    }

    final int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
        CharSequence charSequence2 = charSequence;
        byte[] bArr2 = bArr;
        int i3 = i;
        int i4 = i2;
        long j = (long) i3;
        long j2 = ((long) i4) + j;
        int length = charSequence.length();
        String str = " at index ";
        String str2 = "Failed writing ";
        if (length > i4 || bArr2.length - i4 < i3) {
            char charAt = charSequence2.charAt(length - 1);
            i3 += i4;
            StringBuilder stringBuilder = new StringBuilder(37);
            stringBuilder.append(str2);
            stringBuilder.append(charAt);
            stringBuilder.append(str);
            stringBuilder.append(i3);
            throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
        }
        i3 = 0;
        while (true) {
            char c = '';
            long j3 = 1;
            if (i3 >= length) {
                break;
            }
            char charAt2 = charSequence2.charAt(i3);
            if (charAt2 >= '') {
                break;
            }
            j3 = 1 + j;
            zzfkq.zza(bArr2, j, (byte) charAt2);
            i3++;
            j = j3;
        }
        if (i3 == length) {
            return (int) j;
        }
        while (i3 < length) {
            long j4;
            long j5;
            charAt2 = charSequence2.charAt(i3);
            long j6;
            if (charAt2 < c && j < j2) {
                j6 = j + j3;
                zzfkq.zza(bArr2, j, (byte) charAt2);
                j = j3;
                j4 = j6;
            } else if (charAt2 < 'ࠀ' && j <= j2 - 2) {
                j6 = j + j3;
                zzfkq.zza(bArr2, j, (byte) ((charAt2 >>> 6) | 960));
                r3 = j6 + j3;
                zzfkq.zza(bArr2, j6, (byte) ((charAt2 & 63) | 128));
                j4 = r3;
                j = j3;
                i3++;
                c = '';
                j5 = j;
                j = j4;
                j3 = j5;
            } else if ((charAt2 < '?' || '?' < charAt2) && j <= j2 - 3) {
                j6 = j + j3;
                zzfkq.zza(bArr2, j, (byte) ((charAt2 >>> 12) | 480));
                r3 = j6 + j3;
                zzfkq.zza(bArr2, j6, (byte) (((charAt2 >>> 6) & 63) | 128));
                long j7 = r3 + 1;
                zzfkq.zza(bArr2, r3, (byte) ((charAt2 & 63) | 128));
                j4 = j7;
                j = 1;
            } else if (j <= j2 - 4) {
                i4 = i3 + 1;
                if (i4 != length) {
                    char charAt3 = charSequence2.charAt(i4);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        i3 = Character.toCodePoint(charAt2, charAt3);
                        long j8 = j + 1;
                        zzfkq.zza(bArr2, j, (byte) ((i3 >>> 18) | 240));
                        j = j8 + 1;
                        zzfkq.zza(bArr2, j8, (byte) (((i3 >>> 12) & 63) | 128));
                        j6 = j + 1;
                        zzfkq.zza(bArr2, j, (byte) (((i3 >>> 6) & 63) | 128));
                        j = 1;
                        j4 = j6 + 1;
                        zzfkq.zza(bArr2, j6, (byte) ((i3 & 63) | 128));
                        i3 = i4;
                        i3++;
                        c = '';
                        j5 = j;
                        j = j4;
                        j3 = j5;
                    } else {
                        i3 = i4;
                    }
                }
                throw new zzfkv(i3 - 1, length);
            } else {
                if ('?' <= charAt2 && charAt2 <= '?') {
                    int i5 = i3 + 1;
                    if (i5 == length || !Character.isSurrogatePair(charAt2, charSequence2.charAt(i5))) {
                        throw new zzfkv(i3, length);
                    }
                }
                StringBuilder stringBuilder2 = new StringBuilder(46);
                stringBuilder2.append(str2);
                stringBuilder2.append(charAt2);
                stringBuilder2.append(str);
                stringBuilder2.append(j);
                throw new ArrayIndexOutOfBoundsException(stringBuilder2.toString());
            }
            i3++;
            c = '';
            j5 = j;
            j = j4;
            j3 = j5;
        }
        return (int) j;
    }
}
