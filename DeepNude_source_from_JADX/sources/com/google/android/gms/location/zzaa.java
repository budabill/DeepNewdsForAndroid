package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;

@Hide
public final class zzaa implements Creator<LocationAvailability> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        long j = 0;
        zzaj[] zzajArr = null;
        int i = 1000;
        int i2 = 1;
        int i3 = 1;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i4 = SupportMenu.USER_MASK & readInt;
            if (i4 == 1) {
                i2 = zzbgm.zzg(parcel, readInt);
            } else if (i4 == 2) {
                i3 = zzbgm.zzg(parcel, readInt);
            } else if (i4 == 3) {
                j = zzbgm.zzi(parcel, readInt);
            } else if (i4 == 4) {
                i = zzbgm.zzg(parcel, readInt);
            } else if (i4 != 5) {
                zzbgm.zzb(parcel, readInt);
            } else {
                zzajArr = (zzaj[]) zzbgm.zzb(parcel, readInt, zzaj.CREATOR);
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new LocationAvailability(i, i2, i3, j, zzajArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationAvailability[i];
    }
}
