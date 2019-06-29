package com.google.android.gms.internal;

import java.util.Arrays;

public final class zzfmq extends zzflm<zzfmq> implements Cloneable {
    private byte[] zzpyq = zzflv.zzpwe;
    private String zzpyr = "";
    private byte[][] zzpys = zzflv.zzpwd;
    private boolean zzpyt = false;

    private zzfmq zzddd() {
        try {
            zzfmq zzfmq = (zzfmq) super.zzdck();
            Object obj = this.zzpys;
            if (obj != null && obj.length > 0) {
                zzfmq.zzpys = (byte[][]) obj.clone();
            }
            return zzfmq;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final /* synthetic */ Object clone() {
        return zzddd();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfmq)) {
            return false;
        }
        zzfmq zzfmq = (zzfmq) obj;
        if (!Arrays.equals(this.zzpyq, zzfmq.zzpyq)) {
            return false;
        }
        String str = this.zzpyr;
        if (str == null) {
            if (zzfmq.zzpyr != null) {
                return false;
            }
        } else if (!str.equals(zzfmq.zzpyr)) {
            return false;
        }
        if (!zzflq.zza(this.zzpys, zzfmq.zzpys) || this.zzpyt != zzfmq.zzpyt) {
            return false;
        }
        zzflo zzflo = this.zzpvl;
        if (zzflo != null) {
            if (!zzflo.isEmpty()) {
                return this.zzpvl.equals(zzfmq.zzpvl);
            }
        }
        zzflo zzflo2 = zzfmq.zzpvl;
        if (zzflo2 != null) {
            if (!zzflo2.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int hashCode = (((zzfmq.class.getName().hashCode() + 527) * 31) + Arrays.hashCode(this.zzpyq)) * 31;
        String str = this.zzpyr;
        int i = 0;
        hashCode = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + zzflq.zzd(this.zzpys)) * 31) + (this.zzpyt ? 1231 : 1237)) * 31;
        zzflo zzflo = this.zzpvl;
        if (zzflo != null) {
            if (!zzflo.isEmpty()) {
                i = this.zzpvl.hashCode();
            }
        }
        return hashCode + i;
    }

    public final /* synthetic */ zzfls zza(zzflj zzflj) {
        while (true) {
            int zzcxx = zzflj.zzcxx();
            if (zzcxx == 0) {
                return this;
            }
            if (zzcxx == 10) {
                this.zzpyq = zzflj.readBytes();
            } else if (zzcxx == 18) {
                zzcxx = zzflv.zzb(zzflj, 18);
                byte[][] bArr = this.zzpys;
                int length = bArr == null ? 0 : bArr.length;
                Object obj = new byte[(zzcxx + length)][];
                if (length != 0) {
                    System.arraycopy(this.zzpys, 0, obj, 0, length);
                }
                while (length < obj.length - 1) {
                    obj[length] = zzflj.readBytes();
                    zzflj.zzcxx();
                    length++;
                }
                obj[length] = zzflj.readBytes();
                this.zzpys = obj;
            } else if (zzcxx == 24) {
                this.zzpyt = zzflj.zzcyd();
            } else if (zzcxx == 34) {
                this.zzpyr = zzflj.readString();
            } else if (!super.zza(zzflj, zzcxx)) {
                return this;
            }
        }
    }

    public final void zza(zzflk zzflk) {
        if (!Arrays.equals(this.zzpyq, zzflv.zzpwe)) {
            zzflk.zzc(1, this.zzpyq);
        }
        byte[][] bArr = this.zzpys;
        if (bArr != null && bArr.length > 0) {
            int i = 0;
            while (true) {
                byte[][] bArr2 = this.zzpys;
                if (i >= bArr2.length) {
                    break;
                }
                byte[] bArr3 = bArr2[i];
                if (bArr3 != null) {
                    zzflk.zzc(2, bArr3);
                }
                i++;
            }
        }
        boolean z = this.zzpyt;
        if (z) {
            zzflk.zzl(3, z);
        }
        String str = this.zzpyr;
        if (!(str == null || str.equals(""))) {
            zzflk.zzp(4, this.zzpyr);
        }
        super.zza(zzflk);
    }

    public final /* synthetic */ zzflm zzdck() {
        return (zzfmq) clone();
    }

    public final /* synthetic */ zzfls zzdcl() {
        return (zzfmq) clone();
    }

    protected final int zzq() {
        int zzq = super.zzq();
        if (!Arrays.equals(this.zzpyq, zzflv.zzpwe)) {
            zzq += zzflk.zzd(1, this.zzpyq);
        }
        byte[][] bArr = this.zzpys;
        if (bArr != null && bArr.length > 0) {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                byte[][] bArr2 = this.zzpys;
                if (i >= bArr2.length) {
                    break;
                }
                byte[] bArr3 = bArr2[i];
                if (bArr3 != null) {
                    i3++;
                    i2 += zzflk.zzbg(bArr3);
                }
                i++;
            }
            zzq = (zzq + i2) + (i3 * 1);
        }
        if (this.zzpyt) {
            zzq += zzflk.zzlw(3) + 1;
        }
        String str = this.zzpyr;
        return (str == null || str.equals("")) ? zzq : zzq + zzflk.zzq(4, this.zzpyr);
    }
}
