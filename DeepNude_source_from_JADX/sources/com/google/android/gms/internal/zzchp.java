package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

@Hide
public final class zzchp extends zzbgl implements Geofence {
    public static final Creator<zzchp> CREATOR = new zzchq();
    private final String zzcwj;
    private final int zziro;
    private final short zzirq;
    private final double zzirr;
    private final double zzirs;
    private final float zzirt;
    private final int zziru;
    private final int zzirv;
    private final long zziuu;

    public zzchp(String str, int i, short s, double d, double d2, float f, long j, int i2, int i3) {
        if (str != null) {
            if (str.length() <= 100) {
                StringBuilder stringBuilder;
                if (f <= 0.0f) {
                    stringBuilder = new StringBuilder(31);
                    stringBuilder.append("invalid radius: ");
                    stringBuilder.append(f);
                    throw new IllegalArgumentException(stringBuilder.toString());
                } else if (d > 90.0d || d < -90.0d) {
                    stringBuilder = new StringBuilder(42);
                    stringBuilder.append("invalid latitude: ");
                    stringBuilder.append(d);
                    throw new IllegalArgumentException(stringBuilder.toString());
                } else if (d2 > 180.0d || d2 < -180.0d) {
                    stringBuilder = new StringBuilder(43);
                    stringBuilder.append("invalid longitude: ");
                    stringBuilder.append(d2);
                    throw new IllegalArgumentException(stringBuilder.toString());
                } else {
                    int i4 = i & 7;
                    if (i4 != 0) {
                        this.zzirq = s;
                        this.zzcwj = str;
                        this.zzirr = d;
                        this.zzirs = d2;
                        this.zzirt = f;
                        this.zziuu = j;
                        this.zziro = i4;
                        this.zziru = i2;
                        this.zzirv = i3;
                        return;
                    }
                    StringBuilder stringBuilder2 = new StringBuilder(46);
                    stringBuilder2.append("No supported transition specified: ");
                    stringBuilder2.append(i);
                    throw new IllegalArgumentException(stringBuilder2.toString());
                }
            }
        }
        String str2 = "requestId is null or too long: ";
        str = String.valueOf(str);
        throw new IllegalArgumentException(str.length() != 0 ? str2.concat(str) : new String(str2));
    }

    public static zzchp zzq(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        zzchp zzchp = (zzchp) CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return zzchp;
    }

    @Hide
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzchp)) {
            return false;
        }
        zzchp zzchp = (zzchp) obj;
        return this.zzirt == zzchp.zzirt && this.zzirr == zzchp.zzirr && this.zzirs == zzchp.zzirs && this.zzirq == zzchp.zzirq;
    }

    public final String getRequestId() {
        return this.zzcwj;
    }

    @Hide
    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.zzirr);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.zzirs);
        return (((((((i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.zzirt)) * 31) + this.zzirq) * 31) + this.zziro;
    }

    @Hide
    public final String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[9];
        objArr[0] = this.zzirq != (short) 1 ? null : "CIRCLE";
        objArr[1] = this.zzcwj.replaceAll("\\p{C}", "?");
        objArr[2] = Integer.valueOf(this.zziro);
        objArr[3] = Double.valueOf(this.zzirr);
        objArr[4] = Double.valueOf(this.zzirs);
        objArr[5] = Float.valueOf(this.zzirt);
        objArr[6] = Integer.valueOf(this.zziru / 1000);
        objArr[7] = Integer.valueOf(this.zzirv);
        objArr[8] = Long.valueOf(this.zziuu);
        return String.format(locale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 1, getRequestId(), false);
        zzbgo.zza(parcel, 2, this.zziuu);
        zzbgo.zza(parcel, 3, this.zzirq);
        zzbgo.zza(parcel, 4, this.zzirr);
        zzbgo.zza(parcel, 5, this.zzirs);
        zzbgo.zza(parcel, 6, this.zzirt);
        zzbgo.zzc(parcel, 7, this.zziro);
        zzbgo.zzc(parcel, 8, this.zziru);
        zzbgo.zzc(parcel, 9, this.zzirv);
        zzbgo.zzai(parcel, i);
    }
}
