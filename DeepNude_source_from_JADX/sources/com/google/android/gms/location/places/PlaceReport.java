package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.os.EnvironmentCompat;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbi;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import java.util.Arrays;

public class PlaceReport extends zzbgl implements ReflectedParcelable {
    public static final Creator<PlaceReport> CREATOR = new zzl();
    private final String mTag;
    private final String zzdwr;
    private int zzehz;
    private final String zzivz;

    @Hide
    PlaceReport(int i, String str, String str2, String str3) {
        this.zzehz = i;
        this.zzivz = str;
        this.mTag = str2;
        this.zzdwr = str3;
    }

    public static PlaceReport create(String str, String str2) {
        int i;
        zzbq.checkNotNull(str);
        zzbq.zzgv(str2);
        String str3 = EnvironmentCompat.MEDIA_UNKNOWN;
        zzbq.zzgv(str3);
        boolean z = false;
        switch (str3.hashCode()) {
            case -1436706272:
            case -1194968642:
            case -262743844:
            case 1164924125:
            case 1287171955:
                break;
            case -284840886:
                i = 0;
                break;
            default:
                break;
        }
        i = -1;
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
            z = true;
        }
        zzbq.checkArgument(z, "Invalid source");
        return new PlaceReport(1, str, str2, str3);
    }

    @Hide
    public boolean equals(Object obj) {
        if (!(obj instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) obj;
        return zzbg.equal(this.zzivz, placeReport.zzivz) && zzbg.equal(this.mTag, placeReport.mTag) && zzbg.equal(this.zzdwr, placeReport.zzdwr);
    }

    public String getPlaceId() {
        return this.zzivz;
    }

    public String getTag() {
        return this.mTag;
    }

    @Hide
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzivz, this.mTag, this.zzdwr});
    }

    @Hide
    public String toString() {
        zzbi zzx = zzbg.zzx(this);
        zzx.zzg("placeId", this.zzivz);
        zzx.zzg("tag", this.mTag);
        if (!EnvironmentCompat.MEDIA_UNKNOWN.equals(this.zzdwr)) {
            zzx.zzg("source", this.zzdwr);
        }
        return zzx.toString();
    }

    @Hide
    public void writeToParcel(Parcel parcel, int i) {
        i = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.zzehz);
        zzbgo.zza(parcel, 2, getPlaceId(), false);
        zzbgo.zza(parcel, 3, getTag(), false);
        zzbgo.zza(parcel, 4, this.zzdwr, false);
        zzbgo.zzai(parcel, i);
    }
}
