package com.google.android.gms.internal;

public final class zzfmp extends zzflm<zzfmp> implements Cloneable {
    private String version;
    private int zzjgl = 0;
    private String zzpyp;

    public zzfmp() {
        String str = "";
        this.zzpyp = str;
        this.version = str;
        this.zzpvl = null;
        this.zzpnr = -1;
    }

    private zzfmp zzddc() {
        try {
            return (zzfmp) super.zzdck();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final /* synthetic */ Object clone() {
        return zzddc();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfmp)) {
            return false;
        }
        zzfmp zzfmp = (zzfmp) obj;
        if (this.zzjgl != zzfmp.zzjgl) {
            return false;
        }
        String str = this.zzpyp;
        if (str == null) {
            if (zzfmp.zzpyp != null) {
                return false;
            }
        } else if (!str.equals(zzfmp.zzpyp)) {
            return false;
        }
        str = this.version;
        if (str == null) {
            if (zzfmp.version != null) {
                return false;
            }
        } else if (!str.equals(zzfmp.version)) {
            return false;
        }
        zzflo zzflo = this.zzpvl;
        if (zzflo != null) {
            if (!zzflo.isEmpty()) {
                return this.zzpvl.equals(zzfmp.zzpvl);
            }
        }
        zzflo zzflo2 = zzfmp.zzpvl;
        if (zzflo2 != null) {
            if (!zzflo2.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int hashCode = (((zzfmp.class.getName().hashCode() + 527) * 31) + this.zzjgl) * 31;
        String str = this.zzpyp;
        int i = 0;
        hashCode = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        str = this.version;
        hashCode = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
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
            if (zzcxx == 8) {
                this.zzjgl = zzflj.zzcya();
            } else if (zzcxx == 18) {
                this.zzpyp = zzflj.readString();
            } else if (zzcxx == 26) {
                this.version = zzflj.readString();
            } else if (!super.zza(zzflj, zzcxx)) {
                return this;
            }
        }
    }

    public final void zza(zzflk zzflk) {
        int i = this.zzjgl;
        if (i != 0) {
            zzflk.zzad(1, i);
        }
        String str = this.zzpyp;
        String str2 = "";
        if (!(str == null || str.equals(str2))) {
            zzflk.zzp(2, this.zzpyp);
        }
        str = this.version;
        if (!(str == null || str.equals(str2))) {
            zzflk.zzp(3, this.version);
        }
        super.zza(zzflk);
    }

    public final /* synthetic */ zzflm zzdck() {
        return (zzfmp) clone();
    }

    public final /* synthetic */ zzfls zzdcl() {
        return (zzfmp) clone();
    }

    protected final int zzq() {
        int zzq = super.zzq();
        int i = this.zzjgl;
        if (i != 0) {
            zzq += zzflk.zzag(1, i);
        }
        String str = this.zzpyp;
        String str2 = "";
        if (!(str == null || str.equals(str2))) {
            zzq += zzflk.zzq(2, this.zzpyp);
        }
        str = this.version;
        return (str == null || str.equals(str2)) ? zzq : zzq + zzflk.zzq(3, this.version);
    }
}
