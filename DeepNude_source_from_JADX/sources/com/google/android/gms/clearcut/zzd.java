package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;

@Hide
public final class zzd implements Creator<zzc> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        long j = 0;
        long j2 = j;
        boolean z = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i = SupportMenu.USER_MASK & readInt;
            if (i == 1) {
                z = zzbgm.zzc(parcel, readInt);
            } else if (i == 2) {
                j2 = zzbgm.zzi(parcel, readInt);
            } else if (i != 3) {
                zzbgm.zzb(parcel, readInt);
            } else {
                j = zzbgm.zzi(parcel, readInt);
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzc(z, j, j2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzc[i];
    }
}
