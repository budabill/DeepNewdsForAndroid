package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzbgm;

@Hide
public final class zzbw implements Creator<zzbv> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        int i = 0;
        Scope[] scopeArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i4 = SupportMenu.USER_MASK & readInt;
            if (i4 == 1) {
                i = zzbgm.zzg(parcel, readInt);
            } else if (i4 == 2) {
                i2 = zzbgm.zzg(parcel, readInt);
            } else if (i4 == 3) {
                i3 = zzbgm.zzg(parcel, readInt);
            } else if (i4 != 4) {
                zzbgm.zzb(parcel, readInt);
            } else {
                scopeArr = (Scope[]) zzbgm.zzb(parcel, readInt, Scope.CREATOR);
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzbv(i, i2, i3, scopeArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbv[i];
    }
}
