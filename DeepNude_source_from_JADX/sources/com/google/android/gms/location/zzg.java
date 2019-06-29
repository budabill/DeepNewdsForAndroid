package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;
import java.util.List;

@Hide
public final class zzg implements Creator<ActivityTransitionResult> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        List list = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            if ((SupportMenu.USER_MASK & readInt) != 1) {
                zzbgm.zzb(parcel, readInt);
            } else {
                list = zzbgm.zzc(parcel, readInt, ActivityTransitionEvent.CREATOR);
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new ActivityTransitionResult(list);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ActivityTransitionResult[i];
    }
}
