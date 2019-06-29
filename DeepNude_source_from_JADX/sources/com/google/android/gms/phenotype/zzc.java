package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;

@Hide
public final class zzc implements Creator<Configuration> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        zzi[] zziArr = null;
        int i = 0;
        String[] strArr = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i2 = SupportMenu.USER_MASK & readInt;
            if (i2 == 2) {
                i = zzbgm.zzg(parcel, readInt);
            } else if (i2 == 3) {
                zziArr = (zzi[]) zzbgm.zzb(parcel, readInt, zzi.CREATOR);
            } else if (i2 != 4) {
                zzbgm.zzb(parcel, readInt);
            } else {
                strArr = zzbgm.zzaa(parcel, readInt);
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new Configuration(i, zziArr, strArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Configuration[i];
    }
}
