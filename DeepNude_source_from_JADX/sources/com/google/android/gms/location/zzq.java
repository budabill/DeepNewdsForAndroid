package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;
import com.google.android.gms.internal.zzchp;
import java.util.List;

@Hide
public final class zzq implements Creator<GeofencingRequest> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        List list = null;
        int i = 0;
        String str = "";
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i2 = SupportMenu.USER_MASK & readInt;
            if (i2 == 1) {
                list = zzbgm.zzc(parcel, readInt, zzchp.CREATOR);
            } else if (i2 == 2) {
                i = zzbgm.zzg(parcel, readInt);
            } else if (i2 != 3) {
                zzbgm.zzb(parcel, readInt);
            } else {
                str = zzbgm.zzq(parcel, readInt);
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new GeofencingRequest(list, i, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GeofencingRequest[i];
    }
}
