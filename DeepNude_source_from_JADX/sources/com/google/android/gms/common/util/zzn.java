package com.google.android.gms.common.util;

public final class zzn {
    public static String zza(byte[] bArr, int i, int i2, boolean z) {
        if (!(bArr == null || bArr.length == 0 || i2 <= 0)) {
            if (i2 <= bArr.length) {
                StringBuilder stringBuilder = new StringBuilder((((i2 + 16) - 1) / 16) * 57);
                int i3 = i2;
                int i4 = 0;
                int i5 = 0;
                while (i3 > 0) {
                    String str;
                    if (i4 != 0) {
                        if (i4 == 8) {
                            str = " -";
                        }
                        stringBuilder.append(String.format(" %02X", new Object[]{Integer.valueOf(bArr[i5] & 255)}));
                        i3--;
                        i4++;
                        if (i4 != 16 || i3 == 0) {
                            stringBuilder.append('\n');
                            i4 = 0;
                        }
                        i5++;
                    } else if (i2 < 65536) {
                        str = String.format("%04X:", new Object[]{Integer.valueOf(i5)});
                    } else {
                        str = String.format("%08X:", new Object[]{Integer.valueOf(i5)});
                    }
                    stringBuilder.append(str);
                    stringBuilder.append(String.format(" %02X", new Object[]{Integer.valueOf(bArr[i5] & 255)}));
                    i3--;
                    i4++;
                    if (i4 != 16) {
                    }
                    stringBuilder.append('\n');
                    i4 = 0;
                    i5++;
                }
                return stringBuilder.toString();
            }
        }
        return null;
    }
}
