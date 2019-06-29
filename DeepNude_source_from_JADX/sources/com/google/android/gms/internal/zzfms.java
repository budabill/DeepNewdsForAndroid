package com.google.android.gms.internal;

public final class zzfms extends zzflm<zzfms> implements Cloneable {
    private static volatile zzfms[] zzpzo;
    private String key;
    private String value;

    public zzfms() {
        String str = "";
        this.key = str;
        this.value = str;
    }

    public static zzfms[] zzddf() {
        if (zzpzo == null) {
            synchronized (zzflq.zzpvt) {
                if (zzpzo == null) {
                    zzpzo = new zzfms[0];
                }
            }
        }
        return zzpzo;
    }

    private zzfms zzddg() {
        try {
            return (zzfms) super.zzdck();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final /* synthetic */ Object clone() {
        return zzddg();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfms)) {
            return false;
        }
        zzfms zzfms = (zzfms) obj;
        String str = this.key;
        if (str == null) {
            if (zzfms.key != null) {
                return false;
            }
        } else if (!str.equals(zzfms.key)) {
            return false;
        }
        str = this.value;
        if (str == null) {
            if (zzfms.value != null) {
                return false;
            }
        } else if (!str.equals(zzfms.value)) {
            return false;
        }
        zzflo zzflo = this.zzpvl;
        if (zzflo != null) {
            if (!zzflo.isEmpty()) {
                return this.zzpvl.equals(zzfms.zzpvl);
            }
        }
        zzflo zzflo2 = zzfms.zzpvl;
        if (zzflo2 != null) {
            if (!zzflo2.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int hashCode = (zzfms.class.getName().hashCode() + 527) * 31;
        String str = this.key;
        int i = 0;
        hashCode = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        str = this.value;
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
            if (zzcxx == 10) {
                this.key = zzflj.readString();
            } else if (zzcxx == 18) {
                this.value = zzflj.readString();
            } else if (!super.zza(zzflj, zzcxx)) {
                return this;
            }
        }
    }

    public final void zza(zzflk zzflk) {
        String str = this.key;
        String str2 = "";
        if (!(str == null || str.equals(str2))) {
            zzflk.zzp(1, this.key);
        }
        str = this.value;
        if (!(str == null || str.equals(str2))) {
            zzflk.zzp(2, this.value);
        }
        super.zza(zzflk);
    }

    public final /* synthetic */ zzflm zzdck() {
        return (zzfms) clone();
    }

    public final /* synthetic */ zzfls zzdcl() {
        return (zzfms) clone();
    }

    protected final int zzq() {
        int zzq = super.zzq();
        String str = this.key;
        String str2 = "";
        if (!(str == null || str.equals(str2))) {
            zzq += zzflk.zzq(1, this.key);
        }
        str = this.value;
        return (str == null || str.equals(str2)) ? zzq : zzq + zzflk.zzq(2, this.value);
    }
}
