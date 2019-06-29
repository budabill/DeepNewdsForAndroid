package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;

@Hide
public final class zzd implements Creator<zzc> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i2 = SupportMenu.USER_MASK & readInt;
            if (i2 == 1) {
                str = zzbgm.zzq(parcel, readInt);
            } else if (i2 != 2) {
                zzbgm.zzb(parcel, readInt);
            } else {
                i = zzbgm.zzg(parcel, readInt);
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzc(str, i);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzc[i];
    }
}
