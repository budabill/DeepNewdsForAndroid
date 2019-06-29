package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Hide;

@Hide
public final class zzcgm implements Creator<zzcgl> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        Status status = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            if ((SupportMenu.USER_MASK & readInt) != 1) {
                zzbgm.zzb(parcel, readInt);
            } else {
                status = (Status) zzbgm.zza(parcel, readInt, Status.CREATOR);
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzcgl(status);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcgl[i];
    }
}
