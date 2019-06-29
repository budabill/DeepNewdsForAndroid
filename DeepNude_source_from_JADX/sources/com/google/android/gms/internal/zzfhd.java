package com.google.android.gms.internal;

import java.util.Arrays;

final class zzfhd extends zzfhb {
    private final byte[] buffer;
    private final boolean immutable;
    private int limit;
    private int pos;
    private int zzpoh;
    private int zzpoi;
    private int zzpoj;
    private int zzpok;

    private zzfhd(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzpok = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zzpoi = this.pos;
        this.immutable = z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long zzcyr() {
        /*
        r11 = this;
        r0 = r11.pos;
        r1 = r11.limit;
        if (r1 == r0) goto L_0x00b5;
    L_0x0006:
        r2 = r11.buffer;
        r3 = r0 + 1;
        r0 = r2[r0];
        if (r0 < 0) goto L_0x0012;
    L_0x000e:
        r11.pos = r3;
        r0 = (long) r0;
        return r0;
    L_0x0012:
        r1 = r1 - r3;
        r4 = 9;
        if (r1 < r4) goto L_0x00b5;
    L_0x0017:
        r1 = r3 + 1;
        r3 = r2[r3];
        r3 = r3 << 7;
        r0 = r0 ^ r3;
        if (r0 >= 0) goto L_0x0026;
    L_0x0020:
        r0 = r0 ^ -128;
    L_0x0022:
        r2 = (long) r0;
        r3 = r2;
        goto L_0x00b2;
    L_0x0026:
        r3 = r1 + 1;
        r1 = r2[r1];
        r1 = r1 << 14;
        r0 = r0 ^ r1;
        if (r0 < 0) goto L_0x0037;
    L_0x002f:
        r0 = r0 ^ 16256;
        r0 = (long) r0;
        r9 = r0;
        r1 = r3;
        r3 = r9;
        goto L_0x00b2;
    L_0x0037:
        r1 = r3 + 1;
        r3 = r2[r3];
        r3 = r3 << 21;
        r0 = r0 ^ r3;
        if (r0 >= 0) goto L_0x0045;
    L_0x0040:
        r2 = -2080896; // 0xffffffffffe03f80 float:NaN double:NaN;
        r0 = r0 ^ r2;
        goto L_0x0022;
    L_0x0045:
        r3 = (long) r0;
        r0 = r1 + 1;
        r1 = r2[r1];
        r5 = (long) r1;
        r1 = 28;
        r5 = r5 << r1;
        r3 = r3 ^ r5;
        r5 = 0;
        r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r1 < 0) goto L_0x005c;
    L_0x0055:
        r1 = 266354560; // 0xfe03f80 float:2.2112565E-29 double:1.315966377E-315;
    L_0x0058:
        r1 = r1 ^ r3;
        r3 = r1;
    L_0x005a:
        r1 = r0;
        goto L_0x00b2;
    L_0x005c:
        r1 = r0 + 1;
        r0 = r2[r0];
        r7 = (long) r0;
        r0 = 35;
        r7 = r7 << r0;
        r3 = r3 ^ r7;
        r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r0 >= 0) goto L_0x0070;
    L_0x0069:
        r5 = -34093383808; // 0xfffffff80fe03f80 float:2.2112565E-29 double:NaN;
    L_0x006e:
        r3 = r3 ^ r5;
        goto L_0x00b2;
    L_0x0070:
        r0 = r1 + 1;
        r1 = r2[r1];
        r7 = (long) r1;
        r1 = 42;
        r7 = r7 << r1;
        r3 = r3 ^ r7;
        r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r1 < 0) goto L_0x0083;
    L_0x007d:
        r1 = 4363953127296; // 0x3f80fe03f80 float:2.2112565E-29 double:2.1560793202584E-311;
        goto L_0x0058;
    L_0x0083:
        r1 = r0 + 1;
        r0 = r2[r0];
        r7 = (long) r0;
        r0 = 49;
        r7 = r7 << r0;
        r3 = r3 ^ r7;
        r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r0 >= 0) goto L_0x0096;
    L_0x0090:
        r5 = -558586000294016; // 0xfffe03f80fe03f80 float:2.2112565E-29 double:NaN;
        goto L_0x006e;
    L_0x0096:
        r0 = r1 + 1;
        r1 = r2[r1];
        r7 = (long) r1;
        r1 = 56;
        r7 = r7 << r1;
        r3 = r3 ^ r7;
        r7 = 71499008037633920; // 0xfe03f80fe03f80 float:2.2112565E-29 double:6.838959413692434E-304;
        r3 = r3 ^ r7;
        r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r1 >= 0) goto L_0x005a;
    L_0x00a9:
        r1 = r0 + 1;
        r0 = r2[r0];
        r7 = (long) r0;
        r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1));
        if (r0 < 0) goto L_0x00b5;
    L_0x00b2:
        r11.pos = r1;
        return r3;
    L_0x00b5:
        r0 = r11.zzcyn();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfhd.zzcyr():long");
    }

    private final int zzcys() {
        int i = this.pos;
        if (this.limit - i >= 4) {
            byte[] bArr = this.buffer;
            this.pos = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (((bArr[i] & 255) | ((bArr[i + 1] & 255) << 8)) | ((bArr[i + 2] & 255) << 16));
        }
        throw zzfie.zzdae();
    }

    private final long zzcyt() {
        int i = this.pos;
        if (this.limit - i >= 8) {
            byte[] bArr = this.buffer;
            this.pos = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((((((((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8)) | ((((long) bArr[i + 2]) & 255) << 16)) | ((((long) bArr[i + 3]) & 255) << 24)) | ((((long) bArr[i + 4]) & 255) << 32)) | ((((long) bArr[i + 5]) & 255) << 40)) | ((((long) bArr[i + 6]) & 255) << 48));
        }
        throw zzfie.zzdae();
    }

    private final void zzcyu() {
        this.limit += this.zzpoh;
        int i = this.limit;
        int i2 = i - this.zzpoi;
        int i3 = this.zzpok;
        if (i2 > i3) {
            this.zzpoh = i2 - i3;
            this.limit = i - this.zzpoh;
            return;
        }
        this.zzpoh = 0;
    }

    private final byte zzcyv() {
        int i = this.pos;
        if (i != this.limit) {
            byte[] bArr = this.buffer;
            this.pos = i + 1;
            return bArr[i];
        }
        throw zzfie.zzdae();
    }

    public final double readDouble() {
        return Double.longBitsToDouble(zzcyt());
    }

    public final float readFloat() {
        return Float.intBitsToFloat(zzcys());
    }

    public final String readString() {
        int zzcym = zzcym();
        if (zzcym > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzcym <= i - i2) {
                String str = new String(this.buffer, i2, zzcym, zzfhz.UTF_8);
                this.pos += zzcym;
                return str;
            }
        }
        if (zzcym == 0) {
            return "";
        }
        if (zzcym < 0) {
            throw zzfie.zzdaf();
        }
        throw zzfie.zzdae();
    }

    public final <T extends zzfhu<T, ?>> T zza(T t, zzfhm zzfhm) {
        int zzcym = zzcym();
        if (this.zzpoc < this.zzpod) {
            zzcym = zzli(zzcym);
            this.zzpoc++;
            t = zzfhu.zza((zzfhu) t, (zzfhb) this, zzfhm);
            zzlf(0);
            this.zzpoc--;
            zzlj(zzcym);
            return t;
        }
        throw zzfie.zzdak();
    }

    public final void zza(zzfjd zzfjd, zzfhm zzfhm) {
        int zzcym = zzcym();
        if (this.zzpoc < this.zzpod) {
            zzcym = zzli(zzcym);
            this.zzpoc++;
            zzfjd.zzb(this, zzfhm);
            zzlf(0);
            this.zzpoc--;
            zzlj(zzcym);
            return;
        }
        throw zzfie.zzdak();
    }

    public final int zzcxx() {
        if (zzcyp()) {
            this.zzpoj = 0;
            return 0;
        }
        this.zzpoj = zzcym();
        int i = this.zzpoj;
        if ((i >>> 3) != 0) {
            return i;
        }
        throw zzfie.zzdah();
    }

    public final long zzcxy() {
        return zzcyr();
    }

    public final long zzcxz() {
        return zzcyr();
    }

    public final int zzcya() {
        return zzcym();
    }

    public final long zzcyb() {
        return zzcyt();
    }

    public final int zzcyc() {
        return zzcys();
    }

    public final boolean zzcyd() {
        return zzcyr() != 0;
    }

    public final String zzcye() {
        int zzcym = zzcym();
        if (zzcym > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzcym <= i - i2) {
                if (zzfks.zzl(this.buffer, i2, i2 + zzcym)) {
                    i = this.pos;
                    this.pos = i + zzcym;
                    return new String(this.buffer, i, zzcym, zzfhz.UTF_8);
                }
                throw zzfie.zzdam();
            }
        }
        if (zzcym == 0) {
            return "";
        }
        if (zzcym <= 0) {
            throw zzfie.zzdaf();
        }
        throw zzfie.zzdae();
    }

    public final zzfgs zzcyf() {
        int i;
        int i2;
        int zzcym = zzcym();
        if (zzcym > 0) {
            i = this.limit;
            i2 = this.pos;
            if (zzcym <= i - i2) {
                zzfgs zzf = zzfgs.zzf(this.buffer, i2, zzcym);
                this.pos += zzcym;
                return zzf;
            }
        }
        if (zzcym == 0) {
            return zzfgs.zzpnw;
        }
        if (zzcym > 0) {
            i = this.limit;
            i2 = this.pos;
            if (zzcym <= i - i2) {
                this.pos = zzcym + i2;
                byte[] copyOfRange = Arrays.copyOfRange(this.buffer, i2, this.pos);
                return zzfgs.zzba(copyOfRange);
            }
        }
        if (zzcym > 0) {
            throw zzfie.zzdae();
        } else if (zzcym == 0) {
            copyOfRange = zzfhz.EMPTY_BYTE_ARRAY;
            return zzfgs.zzba(copyOfRange);
        } else {
            throw zzfie.zzdaf();
        }
    }

    public final int zzcyg() {
        return zzcym();
    }

    public final int zzcyh() {
        return zzcym();
    }

    public final int zzcyi() {
        return zzcys();
    }

    public final long zzcyj() {
        return zzcyt();
    }

    public final int zzcyk() {
        return zzfhb.zzll(zzcym());
    }

    public final long zzcyl() {
        return zzfhb.zzct(zzcyr());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzcym() {
        /*
        r5 = this;
        r0 = r5.pos;
        r1 = r5.limit;
        if (r1 == r0) goto L_0x006b;
    L_0x0006:
        r2 = r5.buffer;
        r3 = r0 + 1;
        r0 = r2[r0];
        if (r0 < 0) goto L_0x0011;
    L_0x000e:
        r5.pos = r3;
        return r0;
    L_0x0011:
        r1 = r1 - r3;
        r4 = 9;
        if (r1 < r4) goto L_0x006b;
    L_0x0016:
        r1 = r3 + 1;
        r3 = r2[r3];
        r3 = r3 << 7;
        r0 = r0 ^ r3;
        if (r0 >= 0) goto L_0x0022;
    L_0x001f:
        r0 = r0 ^ -128;
        goto L_0x0068;
    L_0x0022:
        r3 = r1 + 1;
        r1 = r2[r1];
        r1 = r1 << 14;
        r0 = r0 ^ r1;
        if (r0 < 0) goto L_0x002f;
    L_0x002b:
        r0 = r0 ^ 16256;
    L_0x002d:
        r1 = r3;
        goto L_0x0068;
    L_0x002f:
        r1 = r3 + 1;
        r3 = r2[r3];
        r3 = r3 << 21;
        r0 = r0 ^ r3;
        if (r0 >= 0) goto L_0x003d;
    L_0x0038:
        r2 = -2080896; // 0xffffffffffe03f80 float:NaN double:NaN;
        r0 = r0 ^ r2;
        goto L_0x0068;
    L_0x003d:
        r3 = r1 + 1;
        r1 = r2[r1];
        r4 = r1 << 28;
        r0 = r0 ^ r4;
        r4 = 266354560; // 0xfe03f80 float:2.2112565E-29 double:1.315966377E-315;
        r0 = r0 ^ r4;
        if (r1 >= 0) goto L_0x002d;
    L_0x004a:
        r1 = r3 + 1;
        r3 = r2[r3];
        if (r3 >= 0) goto L_0x0068;
    L_0x0050:
        r3 = r1 + 1;
        r1 = r2[r1];
        if (r1 >= 0) goto L_0x002d;
    L_0x0056:
        r1 = r3 + 1;
        r3 = r2[r3];
        if (r3 >= 0) goto L_0x0068;
    L_0x005c:
        r3 = r1 + 1;
        r1 = r2[r1];
        if (r1 >= 0) goto L_0x002d;
    L_0x0062:
        r1 = r3 + 1;
        r2 = r2[r3];
        if (r2 < 0) goto L_0x006b;
    L_0x0068:
        r5.pos = r1;
        return r0;
    L_0x006b:
        r0 = r5.zzcyn();
        r1 = (int) r0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfhd.zzcym():int");
    }

    final long zzcyn() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzcyv = zzcyv();
            j |= ((long) (zzcyv & 127)) << i;
            if ((zzcyv & 128) == 0) {
                return j;
            }
        }
        throw zzfie.zzdag();
    }

    public final int zzcyo() {
        int i = this.zzpok;
        return i == ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED ? -1 : i - zzcyq();
    }

    public final boolean zzcyp() {
        return this.pos == this.limit;
    }

    public final int zzcyq() {
        return this.pos - this.zzpoi;
    }

    public final void zzlf(int i) {
        if (this.zzpoj != i) {
            throw zzfie.zzdai();
        }
    }

    public final boolean zzlg(int i) {
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.limit - this.pos >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.buffer;
                    int i4 = this.pos;
                    this.pos = i4 + 1;
                    if (bArr[i4] < (byte) 0) {
                        i3++;
                    }
                }
                throw zzfie.zzdag();
            }
            while (i3 < 10) {
                if (zzcyv() < (byte) 0) {
                    i3++;
                }
            }
            throw zzfie.zzdag();
            return true;
        } else if (i2 == 1) {
            zzlk(8);
            return true;
        } else if (i2 == 2) {
            zzlk(zzcym());
            return true;
        } else if (i2 == 3) {
            do {
                i2 = zzcxx();
                if (i2 == 0) {
                    break;
                }
            } while (zzlg(i2));
            zzlf(((i >>> 3) << 3) | 4);
            return true;
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzlk(4);
                return true;
            }
            throw zzfie.zzdaj();
        }
    }

    public final int zzli(int i) {
        if (i >= 0) {
            i += zzcyq();
            int i2 = this.zzpok;
            if (i <= i2) {
                this.zzpok = i;
                zzcyu();
                return i2;
            }
            throw zzfie.zzdae();
        }
        throw zzfie.zzdaf();
    }

    public final void zzlj(int i) {
        this.zzpok = i;
        zzcyu();
    }

    public final void zzlk(int i) {
        if (i >= 0) {
            int i2 = this.limit;
            int i3 = this.pos;
            if (i <= i2 - i3) {
                this.pos = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzfie.zzdaf();
        }
        throw zzfie.zzdae();
    }
}
