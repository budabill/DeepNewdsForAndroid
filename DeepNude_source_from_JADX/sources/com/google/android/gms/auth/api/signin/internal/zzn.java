package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;

@Hide
public final class zzn implements Creator<zzo> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        int i = 0;
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i3 = SupportMenu.USER_MASK & readInt;
            if (i3 == 1) {
                i = zzbgm.zzg(parcel, readInt);
            } else if (i3 == 2) {
                i2 = zzbgm.zzg(parcel, readInt);
            } else if (i3 != 3) {
                zzbgm.zzb(parcel, readInt);
            } else {
                bundle = zzbgm.zzs(parcel, readInt);
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzo(i, i2, bundle);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzo[i];
    }
}
