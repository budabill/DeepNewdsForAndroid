package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;

@Hide
public final class zzbho implements Creator<zzbhm> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i3 = SupportMenu.USER_MASK & readInt;
            if (i3 == 1) {
                i = zzbgm.zzg(parcel, readInt);
            } else if (i3 == 2) {
                str = zzbgm.zzq(parcel, readInt);
            } else if (i3 != 3) {
                zzbgm.zzb(parcel, readInt);
            } else {
                i2 = zzbgm.zzg(parcel, readInt);
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzbhm(i, str, i2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbhm[i];
    }
}
