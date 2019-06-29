package com.google.android.gms.internal;

public final class zzfmo extends zzflm<zzfmo> implements Cloneable {
    private String[] zzpyk;
    private String[] zzpyl;
    private int[] zzpym = zzflv.zzpvy;
    private long[] zzpyn;
    private long[] zzpyo;

    public zzfmo() {
        String[] strArr = zzflv.EMPTY_STRING_ARRAY;
        this.zzpyk = strArr;
        this.zzpyl = strArr;
        long[] jArr = zzflv.zzpvz;
        this.zzpyn = jArr;
        this.zzpyo = jArr;
        this.zzpvl = null;
        this.zzpnr = -1;
    }

    private zzfmo zzddb() {
        try {
            zzfmo zzfmo = (zzfmo) super.zzdck();
            Object obj = this.zzpyk;
            if (obj != null && obj.length > 0) {
                zzfmo.zzpyk = (String[]) obj.clone();
            }
            obj = this.zzpyl;
            if (obj != null && obj.length > 0) {
                zzfmo.zzpyl = (String[]) obj.clone();
            }
            obj = this.zzpym;
            if (obj != null && obj.length > 0) {
                zzfmo.zzpym = (int[]) obj.clone();
            }
            obj = this.zzpyn;
            if (obj != null && obj.length > 0) {
                zzfmo.zzpyn = (long[]) obj.clone();
            }
            obj = this.zzpyo;
            if (obj != null && obj.length > 0) {
                zzfmo.zzpyo = (long[]) obj.clone();
            }
            return zzfmo;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final /* synthetic */ Object clone() {
        return zzddb();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfmo)) {
            return false;
        }
        zzfmo zzfmo = (zzfmo) obj;
        if (!zzflq.equals(this.zzpyk, zzfmo.zzpyk) || !zzflq.equals(this.zzpyl, zzfmo.zzpyl) || !zzflq.equals(this.zzpym, zzfmo.zzpym) || !zzflq.equals(this.zzpyn, zzfmo.zzpyn) || !zzflq.equals(this.zzpyo, zzfmo.zzpyo)) {
            return false;
        }
        zzflo zzflo = this.zzpvl;
        if (zzflo != null) {
            if (!zzflo.isEmpty()) {
                return this.zzpvl.equals(zzfmo.zzpvl);
            }
        }
        zzflo zzflo2 = zzfmo.zzpvl;
        if (zzflo2 != null) {
            if (!zzflo2.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = (((((((((((zzfmo.class.getName().hashCode() + 527) * 31) + zzflq.hashCode(this.zzpyk)) * 31) + zzflq.hashCode(this.zzpyl)) * 31) + zzflq.hashCode(this.zzpym)) * 31) + zzflq.hashCode(this.zzpyn)) * 31) + zzflq.hashCode(this.zzpyo)) * 31;
        zzflo zzflo = this.zzpvl;
        if (zzflo != null) {
            if (!zzflo.isEmpty()) {
                hashCode = this.zzpvl.hashCode();
                return hashCode2 + hashCode;
            }
        }
        hashCode = 0;
        return hashCode2 + hashCode;
    }

    public final /* synthetic */ zzfls zza(zzflj zzflj) {
        while (true) {
            int zzcxx = zzflj.zzcxx();
            if (zzcxx == 0) {
                return this;
            }
            String[] strArr;
            int length;
            Object obj;
            if (zzcxx == 10) {
                zzcxx = zzflv.zzb(zzflj, 10);
                strArr = this.zzpyk;
                length = strArr == null ? 0 : strArr.length;
                obj = new String[(zzcxx + length)];
                if (length != 0) {
                    System.arraycopy(this.zzpyk, 0, obj, 0, length);
                }
                while (length < obj.length - 1) {
                    obj[length] = zzflj.readString();
                    zzflj.zzcxx();
                    length++;
                }
                obj[length] = zzflj.readString();
                this.zzpyk = obj;
            } else if (zzcxx == 18) {
                zzcxx = zzflv.zzb(zzflj, 18);
                strArr = this.zzpyl;
                length = strArr == null ? 0 : strArr.length;
                obj = new String[(zzcxx + length)];
                if (length != 0) {
                    System.arraycopy(this.zzpyl, 0, obj, 0, length);
                }
                while (length < obj.length - 1) {
                    obj[length] = zzflj.readString();
                    zzflj.zzcxx();
                    length++;
                }
                obj[length] = zzflj.readString();
                this.zzpyl = obj;
            } else if (zzcxx != 24) {
                int i;
                Object obj2;
                if (zzcxx == 26) {
                    zzcxx = zzflj.zzli(zzflj.zzcym());
                    length = zzflj.getPosition();
                    i = 0;
                    while (zzflj.zzcyo() > 0) {
                        zzflj.zzcya();
                        i++;
                    }
                    zzflj.zzmw(length);
                    r1 = this.zzpym;
                    length = r1 == null ? 0 : r1.length;
                    obj2 = new int[(i + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzpym, 0, obj2, 0, length);
                    }
                    while (length < obj2.length) {
                        obj2[length] = zzflj.zzcya();
                        length++;
                    }
                    this.zzpym = obj2;
                } else if (zzcxx == 32) {
                    zzcxx = zzflv.zzb(zzflj, 32);
                    r1 = this.zzpyn;
                    length = r1 == null ? 0 : r1.length;
                    obj = new long[(zzcxx + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzpyn, 0, obj, 0, length);
                    }
                    while (length < obj.length - 1) {
                        obj[length] = zzflj.zzcxz();
                        zzflj.zzcxx();
                        length++;
                    }
                    obj[length] = zzflj.zzcxz();
                    this.zzpyn = obj;
                } else if (zzcxx == 34) {
                    zzcxx = zzflj.zzli(zzflj.zzcym());
                    length = zzflj.getPosition();
                    i = 0;
                    while (zzflj.zzcyo() > 0) {
                        zzflj.zzcxz();
                        i++;
                    }
                    zzflj.zzmw(length);
                    r1 = this.zzpyn;
                    length = r1 == null ? 0 : r1.length;
                    obj2 = new long[(i + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzpyn, 0, obj2, 0, length);
                    }
                    while (length < obj2.length) {
                        obj2[length] = zzflj.zzcxz();
                        length++;
                    }
                    this.zzpyn = obj2;
                } else if (zzcxx == 40) {
                    zzcxx = zzflv.zzb(zzflj, 40);
                    r1 = this.zzpyo;
                    length = r1 == null ? 0 : r1.length;
                    obj = new long[(zzcxx + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzpyo, 0, obj, 0, length);
                    }
                    while (length < obj.length - 1) {
                        obj[length] = zzflj.zzcxz();
                        zzflj.zzcxx();
                        length++;
                    }
                    obj[length] = zzflj.zzcxz();
                    this.zzpyo = obj;
                } else if (zzcxx == 42) {
                    zzcxx = zzflj.zzli(zzflj.zzcym());
                    length = zzflj.getPosition();
                    i = 0;
                    while (zzflj.zzcyo() > 0) {
                        zzflj.zzcxz();
                        i++;
                    }
                    zzflj.zzmw(length);
                    r1 = this.zzpyo;
                    length = r1 == null ? 0 : r1.length;
                    obj2 = new long[(i + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzpyo, 0, obj2, 0, length);
                    }
                    while (length < obj2.length) {
                        obj2[length] = zzflj.zzcxz();
                        length++;
                    }
                    this.zzpyo = obj2;
                } else if (!super.zza(zzflj, zzcxx)) {
                    return this;
                }
                zzflj.zzlj(zzcxx);
            } else {
                zzcxx = zzflv.zzb(zzflj, 24);
                r1 = this.zzpym;
                length = r1 == null ? 0 : r1.length;
                obj = new int[(zzcxx + length)];
                if (length != 0) {
                    System.arraycopy(this.zzpym, 0, obj, 0, length);
                }
                while (length < obj.length - 1) {
                    obj[length] = zzflj.zzcya();
                    zzflj.zzcxx();
                    length++;
                }
                obj[length] = zzflj.zzcya();
                this.zzpym = obj;
            }
        }
    }

    public final void zza(zzflk zzflk) {
        int i;
        String[] strArr;
        String str;
        String[] strArr2 = this.zzpyk;
        int i2 = 0;
        if (strArr2 != null && strArr2.length > 0) {
            i = 0;
            while (true) {
                strArr = this.zzpyk;
                if (i >= strArr.length) {
                    break;
                }
                str = strArr[i];
                if (str != null) {
                    zzflk.zzp(1, str);
                }
                i++;
            }
        }
        strArr2 = this.zzpyl;
        if (strArr2 != null && strArr2.length > 0) {
            i = 0;
            while (true) {
                strArr = this.zzpyl;
                if (i >= strArr.length) {
                    break;
                }
                str = strArr[i];
                if (str != null) {
                    zzflk.zzp(2, str);
                }
                i++;
            }
        }
        int[] iArr = this.zzpym;
        if (iArr != null && iArr.length > 0) {
            i = 0;
            while (true) {
                int[] iArr2 = this.zzpym;
                if (i >= iArr2.length) {
                    break;
                }
                zzflk.zzad(3, iArr2[i]);
                i++;
            }
        }
        long[] jArr = this.zzpyn;
        if (jArr != null && jArr.length > 0) {
            i = 0;
            while (true) {
                long[] jArr2 = this.zzpyn;
                if (i >= jArr2.length) {
                    break;
                }
                zzflk.zzf(4, jArr2[i]);
                i++;
            }
        }
        jArr = this.zzpyo;
        if (jArr != null && jArr.length > 0) {
            while (true) {
                jArr = this.zzpyo;
                if (i2 >= jArr.length) {
                    break;
                }
                zzflk.zzf(5, jArr[i2]);
                i2++;
            }
        }
        super.zza(zzflk);
    }

    public final /* synthetic */ zzflm zzdck() {
        return (zzfmo) clone();
    }

    public final /* synthetic */ zzfls zzdcl() {
        return (zzfmo) clone();
    }

    protected final int zzq() {
        int i;
        int i2;
        int i3;
        String[] strArr;
        String str;
        int zzq = super.zzq();
        String[] strArr2 = this.zzpyk;
        int i4 = 0;
        if (strArr2 != null && strArr2.length > 0) {
            i = 0;
            i2 = 0;
            i3 = 0;
            while (true) {
                strArr = this.zzpyk;
                if (i >= strArr.length) {
                    break;
                }
                str = strArr[i];
                if (str != null) {
                    i3++;
                    i2 += zzflk.zztx(str);
                }
                i++;
            }
            zzq = (zzq + i2) + (i3 * 1);
        }
        strArr2 = this.zzpyl;
        if (strArr2 != null && strArr2.length > 0) {
            i = 0;
            i2 = 0;
            i3 = 0;
            while (true) {
                strArr = this.zzpyl;
                if (i >= strArr.length) {
                    break;
                }
                str = strArr[i];
                if (str != null) {
                    i3++;
                    i2 += zzflk.zztx(str);
                }
                i++;
            }
            zzq = (zzq + i2) + (i3 * 1);
        }
        int[] iArr = this.zzpym;
        if (iArr != null && iArr.length > 0) {
            int[] iArr2;
            i = 0;
            i2 = 0;
            while (true) {
                iArr2 = this.zzpym;
                if (i >= iArr2.length) {
                    break;
                }
                i2 += zzflk.zzlx(iArr2[i]);
                i++;
            }
            zzq = (zzq + i2) + (iArr2.length * 1);
        }
        long[] jArr = this.zzpyn;
        if (jArr != null && jArr.length > 0) {
            long[] jArr2;
            i = 0;
            i2 = 0;
            while (true) {
                jArr2 = this.zzpyn;
                if (i >= jArr2.length) {
                    break;
                }
                i2 += zzflk.zzdj(jArr2[i]);
                i++;
            }
            zzq = (zzq + i2) + (jArr2.length * 1);
        }
        jArr = this.zzpyo;
        if (jArr == null || jArr.length <= 0) {
            return zzq;
        }
        i = 0;
        while (true) {
            long[] jArr3 = this.zzpyo;
            if (i4 >= jArr3.length) {
                return (zzq + i) + (jArr3.length * 1);
            }
            i += zzflk.zzdj(jArr3[i4]);
            i4++;
        }
    }
}
