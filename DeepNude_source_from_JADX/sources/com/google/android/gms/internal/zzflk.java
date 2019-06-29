package com.google.android.gms.internal;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzflk {
    private final ByteBuffer buffer;

    private zzflk(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
        this.buffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zzflk(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    private static int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int length = charSequence.length();
        i2 += i;
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + i;
            if (i4 >= i2) {
                break;
            }
            char charAt = charSequence.charAt(i3);
            if (charAt >= '') {
                break;
            }
            bArr[i4] = (byte) charAt;
            i3++;
        }
        if (i3 == length) {
            return i + length;
        }
        i += i3;
        while (i3 < length) {
            int i5;
            char charAt2 = charSequence.charAt(i3);
            if (charAt2 < '' && i < i2) {
                i5 = i + 1;
                bArr[i] = (byte) charAt2;
            } else if (charAt2 < 'ࠀ' && i <= i2 - 2) {
                i5 = i + 1;
                bArr[i] = (byte) ((charAt2 >>> 6) | 960);
                i = i5 + 1;
                bArr[i5] = (byte) ((charAt2 & 63) | 128);
                i3++;
            } else if ((charAt2 < '?' || '?' < charAt2) && i <= i2 - 3) {
                i5 = i + 1;
                bArr[i] = (byte) ((charAt2 >>> 12) | 480);
                i = i5 + 1;
                bArr[i5] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i5 = i + 1;
                bArr[i] = (byte) ((charAt2 & 63) | 128);
            } else if (i <= i2 - 4) {
                i5 = i3 + 1;
                if (i5 != charSequence.length()) {
                    char charAt3 = charSequence.charAt(i5);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        i3 = Character.toCodePoint(charAt2, charAt3);
                        i4 = i + 1;
                        bArr[i] = (byte) ((i3 >>> 18) | 240);
                        i = i4 + 1;
                        bArr[i4] = (byte) (((i3 >>> 12) & 63) | 128);
                        i4 = i + 1;
                        bArr[i] = (byte) (((i3 >>> 6) & 63) | 128);
                        i = i4 + 1;
                        bArr[i4] = (byte) ((i3 & 63) | 128);
                        i3 = i5;
                        i3++;
                    } else {
                        i3 = i5;
                    }
                }
                i3--;
                StringBuilder stringBuilder = new StringBuilder(39);
                stringBuilder.append("Unpaired surrogate at index ");
                stringBuilder.append(i3);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else {
                StringBuilder stringBuilder2 = new StringBuilder(37);
                stringBuilder2.append("Failed writing ");
                stringBuilder2.append(charAt2);
                stringBuilder2.append(" at index ");
                stringBuilder2.append(i);
                throw new ArrayIndexOutOfBoundsException(stringBuilder2.toString());
            }
            i = i5;
            i3++;
        }
        return i;
    }

    private static void zza(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(zza(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            } catch (Throwable e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            zzb(charSequence, byteBuffer);
        }
    }

    public static int zzag(int i, int i2) {
        return zzlw(i) + zzlx(i2);
    }

    public static int zzb(int i, zzfls zzfls) {
        i = zzlw(i);
        int zzhs = zzfls.zzhs();
        return i + (zzmf(zzhs) + zzhs);
    }

    private static void zzb(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int charAt = charSequence.charAt(i);
            if (charAt >= 128) {
                int i2;
                if (charAt < 2048) {
                    i2 = (charAt >>> 6) | 960;
                } else {
                    if (charAt >= 55296) {
                        if (57343 >= charAt) {
                            i2 = i + 1;
                            if (i2 != charSequence.length()) {
                                char charAt2 = charSequence.charAt(i2);
                                if (Character.isSurrogatePair(charAt, charAt2)) {
                                    i = Character.toCodePoint(charAt, charAt2);
                                    byteBuffer.put((byte) ((i >>> 18) | 240));
                                    byteBuffer.put((byte) (((i >>> 12) & 63) | 128));
                                    byteBuffer.put((byte) (((i >>> 6) & 63) | 128));
                                    byteBuffer.put((byte) ((i & 63) | 128));
                                    i = i2;
                                    i++;
                                } else {
                                    i = i2;
                                }
                            }
                            i--;
                            StringBuilder stringBuilder = new StringBuilder(39);
                            stringBuilder.append("Unpaired surrogate at index ");
                            stringBuilder.append(i);
                            throw new IllegalArgumentException(stringBuilder.toString());
                        }
                    }
                    byteBuffer.put((byte) ((charAt >>> 12) | 480));
                    i2 = ((charAt >>> 6) & 63) | 128;
                }
                byteBuffer.put((byte) i2);
                charAt = (charAt & 63) | 128;
            }
            byteBuffer.put((byte) charAt);
            i++;
        }
    }

    public static zzflk zzbf(byte[] bArr) {
        return zzp(bArr, 0, bArr.length);
    }

    public static int zzbg(byte[] bArr) {
        return zzmf(bArr.length) + bArr.length;
    }

    public static int zzc(int i, long j) {
        return zzlw(i) + zzdj(j);
    }

    public static int zzd(int i, byte[] bArr) {
        return zzlw(i) + zzbg(bArr);
    }

    private static int zzd(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < '') {
            i2++;
        }
        int i3 = length;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt < 'ࠀ') {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 'ࠀ') {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if ('?' <= charAt2 && charAt2 <= '?') {
                            if (Character.codePointAt(charSequence, i2) >= 65536) {
                                i2++;
                            } else {
                                StringBuilder stringBuilder = new StringBuilder(39);
                                stringBuilder.append("Unpaired surrogate at index ");
                                stringBuilder.append(i2);
                                throw new IllegalArgumentException(stringBuilder.toString());
                            }
                        }
                    }
                    i2++;
                }
                i3 += i;
                if (i3 >= length) {
                    return i3;
                }
                long j = ((long) i3) + 4294967296L;
                StringBuilder stringBuilder2 = new StringBuilder(54);
                stringBuilder2.append("UTF-8 length does not fit in int: ");
                stringBuilder2.append(j);
                throw new IllegalArgumentException(stringBuilder2.toString());
            }
        }
        if (i3 >= length) {
            return i3;
        }
        long j2 = ((long) i3) + 4294967296L;
        StringBuilder stringBuilder22 = new StringBuilder(54);
        stringBuilder22.append("UTF-8 length does not fit in int: ");
        stringBuilder22.append(j2);
        throw new IllegalArgumentException(stringBuilder22.toString());
    }

    private static long zzdc(long j) {
        return (j >> 63) ^ (j << 1);
    }

    private final void zzdi(long j) {
        while ((-128 & j) != 0) {
            zzmx((((int) j) & 127) | 128);
            j >>>= 7;
        }
        zzmx((int) j);
    }

    public static int zzdj(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    private final void zzdk(long j) {
        if (this.buffer.remaining() >= 8) {
            this.buffer.putLong(j);
            return;
        }
        throw new zzfll(this.buffer.position(), this.buffer.limit());
    }

    public static int zzh(int i, long j) {
        return zzlw(i) + zzdj(zzdc(j));
    }

    public static int zzlw(int i) {
        return zzmf(i << 3);
    }

    public static int zzlx(int i) {
        return i >= 0 ? zzmf(i) : 10;
    }

    public static int zzme(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static int zzmf(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (i & -268435456) == 0 ? 4 : 5;
    }

    private final void zzmx(int i) {
        byte b = (byte) i;
        if (this.buffer.hasRemaining()) {
            this.buffer.put(b);
            return;
        }
        throw new zzfll(this.buffer.position(), this.buffer.limit());
    }

    public static zzflk zzp(byte[] bArr, int i, int i2) {
        return new zzflk(bArr, 0, i2);
    }

    public static int zzq(int i, String str) {
        return zzlw(i) + zztx(str);
    }

    public static int zztx(String str) {
        int zzd = zzd(str);
        return zzmf(zzd) + zzd;
    }

    public final void zza(int i, double d) {
        zzac(i, 1);
        zzdk(Double.doubleToLongBits(d));
    }

    public final void zza(int i, long j) {
        zzac(i, 0);
        zzdi(j);
    }

    public final void zza(int i, zzfls zzfls) {
        zzac(i, 2);
        zzb(zzfls);
    }

    public final void zzac(int i, int i2) {
        zzmy((i << 3) | i2);
    }

    public final void zzad(int i, int i2) {
        zzac(i, 0);
        if (i2 >= 0) {
            zzmy(i2);
        } else {
            zzdi((long) i2);
        }
    }

    public final void zzb(int i, long j) {
        zzac(i, 1);
        zzdk(j);
    }

    public final void zzb(zzfls zzfls) {
        zzmy(zzfls.zzdcr());
        zzfls.zza(this);
    }

    public final void zzbh(byte[] bArr) {
        int length = bArr.length;
        if (this.buffer.remaining() >= length) {
            this.buffer.put(bArr, 0, length);
            return;
        }
        throw new zzfll(this.buffer.position(), this.buffer.limit());
    }

    public final void zzc(int i, byte[] bArr) {
        zzac(i, 2);
        zzmy(bArr.length);
        zzbh(bArr);
    }

    public final void zzcyx() {
        if (this.buffer.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", new Object[]{Integer.valueOf(this.buffer.remaining())}));
        }
    }

    public final void zzd(int i, float f) {
        zzac(i, 5);
        i = Float.floatToIntBits(f);
        if (this.buffer.remaining() >= 4) {
            this.buffer.putInt(i);
            return;
        }
        throw new zzfll(this.buffer.position(), this.buffer.limit());
    }

    public final void zzf(int i, long j) {
        zzac(i, 0);
        zzdi(j);
    }

    public final void zzg(int i, long j) {
        zzac(i, 0);
        zzdi(zzdc(j));
    }

    public final void zzl(int i, boolean z) {
        zzac(i, 0);
        byte b = (byte) z;
        if (this.buffer.hasRemaining()) {
            this.buffer.put(b);
            return;
        }
        throw new zzfll(this.buffer.position(), this.buffer.limit());
    }

    public final void zzmy(int i) {
        while ((i & -128) != 0) {
            zzmx((i & 127) | 128);
            i >>>= 7;
        }
        zzmx(i);
    }

    public final void zzp(int i, String str) {
        zzac(i, 2);
        try {
            i = zzmf(str.length());
            if (i == zzmf(str.length() * 3)) {
                int position = this.buffer.position();
                if (this.buffer.remaining() >= i) {
                    this.buffer.position(position + i);
                    zza((CharSequence) str, this.buffer);
                    int position2 = this.buffer.position();
                    this.buffer.position(position);
                    zzmy((position2 - position) - i);
                    this.buffer.position(position2);
                    return;
                }
                throw new zzfll(position + i, this.buffer.limit());
            }
            zzmy(zzd(str));
            zza((CharSequence) str, this.buffer);
        } catch (Throwable e) {
            IOException zzfll = new zzfll(this.buffer.position(), this.buffer.limit());
            zzfll.initCause(e);
            throw zzfll;
        }
    }
}
