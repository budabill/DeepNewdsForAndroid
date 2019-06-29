package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;
import java.util.List;

@Hide
public final class zzac implements Creator<LocationResult> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        List list = LocationResult.zzisl;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            if ((SupportMenu.USER_MASK & readInt) != 1) {
                zzbgm.zzb(parcel, readInt);
            } else {
                list = zzbgm.zzc(parcel, readInt, Location.CREATOR);
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new LocationResult(list);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationResult[i];
    }
}
