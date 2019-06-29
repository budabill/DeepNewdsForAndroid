package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import java.util.Arrays;
import java.util.Comparator;

public final class zzi extends zzbgl implements Comparable<zzi> {
    public static final Creator<zzi> CREATOR = new zzk();
    private static Comparator<zzi> zzkgq = new zzj();
    public final String name;
    private String zzgim;
    private boolean zzili;
    private double zzilk;
    private long zzkgm;
    private byte[] zzkgn;
    private int zzkgo;
    public final int zzkgp;

    public zzi(String str, long j, boolean z, double d, String str2, byte[] bArr, int i, int i2) {
        this.name = str;
        this.zzkgm = j;
        this.zzili = z;
        this.zzilk = d;
        this.zzgim = str2;
        this.zzkgn = bArr;
        this.zzkgo = i;
        this.zzkgp = i2;
    }

    private static int compare(int i, int i2) {
        return i < i2 ? -1 : i == i2 ? 0 : 1;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        zzi zzi = (zzi) obj;
        int compareTo = this.name.compareTo(zzi.name);
        if (compareTo != 0) {
            return compareTo;
        }
        compareTo = compare(this.zzkgo, zzi.zzkgo);
        if (compareTo != 0) {
            return compareTo;
        }
        compareTo = this.zzkgo;
        int i = 0;
        if (compareTo == 1) {
            long j = this.zzkgm;
            long j2 = zzi.zzkgm;
            return j < j2 ? -1 : j == j2 ? 0 : 1;
        } else if (compareTo == 2) {
            boolean z = this.zzili;
            return z == zzi.zzili ? 0 : z ? 1 : -1;
        } else if (compareTo == 3) {
            return Double.compare(this.zzilk, zzi.zzilk);
        } else {
            if (compareTo == 4) {
                String str = this.zzgim;
                String str2 = zzi.zzgim;
                return str == str2 ? 0 : str == null ? -1 : str2 == null ? 1 : str.compareTo(str2);
            } else if (compareTo == 5) {
                byte[] bArr = this.zzkgn;
                byte[] bArr2 = zzi.zzkgn;
                if (bArr == bArr2) {
                    return 0;
                }
                if (bArr == null) {
                    return -1;
                }
                if (bArr2 == null) {
                    return 1;
                }
                while (i < Math.min(this.zzkgn.length, zzi.zzkgn.length)) {
                    compareTo = this.zzkgn[i] - zzi.zzkgn[i];
                    if (compareTo != 0) {
                        return compareTo;
                    }
                    i++;
                }
                return compare(this.zzkgn.length, zzi.zzkgn.length);
            } else {
                StringBuilder stringBuilder = new StringBuilder(31);
                stringBuilder.append("Invalid enum value: ");
                stringBuilder.append(compareTo);
                throw new AssertionError(stringBuilder.toString());
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzi) {
            zzi zzi = (zzi) obj;
            if (zzn.equals(this.name, zzi.name)) {
                int i = this.zzkgo;
                if (i == zzi.zzkgo) {
                    if (this.zzkgp == zzi.zzkgp) {
                        if (i != 1) {
                            if (i == 2) {
                                return this.zzili == zzi.zzili;
                            } else {
                                if (i == 3) {
                                    return this.zzilk == zzi.zzilk;
                                } else {
                                    if (i == 4) {
                                        return zzn.equals(this.zzgim, zzi.zzgim);
                                    }
                                    if (i == 5) {
                                        return Arrays.equals(this.zzkgn, zzi.zzkgn);
                                    }
                                    StringBuilder stringBuilder = new StringBuilder(31);
                                    stringBuilder.append("Invalid enum value: ");
                                    stringBuilder.append(i);
                                    throw new AssertionError(stringBuilder.toString());
                                }
                            }
                        } else if (this.zzkgm == zzi.zzkgm) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Flag(");
        stringBuilder.append(this.name);
        String str = ", ";
        stringBuilder.append(str);
        int i = this.zzkgo;
        if (i == 1) {
            stringBuilder.append(this.zzkgm);
        } else if (i == 2) {
            stringBuilder.append(this.zzili);
        } else if (i != 3) {
            String str2;
            String str3 = "'";
            if (i == 4) {
                stringBuilder.append(str3);
                str2 = this.zzgim;
            } else if (i != 5) {
                String str4 = this.name;
                StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(str4).length() + 27);
                stringBuilder2.append("Invalid type: ");
                stringBuilder2.append(str4);
                stringBuilder2.append(str);
                stringBuilder2.append(i);
                throw new AssertionError(stringBuilder2.toString());
            } else if (this.zzkgn == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(str3);
                str2 = Base64.encodeToString(this.zzkgn, 3);
            }
            stringBuilder.append(str2);
            stringBuilder.append(str3);
        } else {
            stringBuilder.append(this.zzilk);
        }
        stringBuilder.append(str);
        stringBuilder.append(this.zzkgo);
        stringBuilder.append(str);
        stringBuilder.append(this.zzkgp);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 2, this.name, false);
        zzbgo.zza(parcel, 3, this.zzkgm);
        zzbgo.zza(parcel, 4, this.zzili);
        zzbgo.zza(parcel, 5, this.zzilk);
        zzbgo.zza(parcel, 6, this.zzgim, false);
        zzbgo.zza(parcel, 7, this.zzkgn, false);
        zzbgo.zzc(parcel, 8, this.zzkgo);
        zzbgo.zzc(parcel, 9, this.zzkgp);
        zzbgo.zzai(parcel, i);
    }
}
