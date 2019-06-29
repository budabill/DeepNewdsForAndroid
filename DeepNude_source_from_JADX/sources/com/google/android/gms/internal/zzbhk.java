package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;

@Hide
public final class zzbhk implements Creator<zzbhj> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        int i = 0;
        zzbhl zzbhl = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i2 = SupportMenu.USER_MASK & readInt;
            if (i2 == 1) {
                i = zzbgm.zzg(parcel, readInt);
            } else if (i2 != 2) {
                zzbgm.zzb(parcel, readInt);
            } else {
                zzbhl = (zzbhl) zzbgm.zza(parcel, readInt, zzbhl.CREATOR);
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzbhj(i, zzbhl);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbhj[i];
    }
}
