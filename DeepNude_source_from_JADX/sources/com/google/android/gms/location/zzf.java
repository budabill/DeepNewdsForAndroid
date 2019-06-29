package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;
import com.google.android.gms.internal.zzcfs;
import java.util.List;

@Hide
public final class zzf implements Creator<ActivityTransitionRequest> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        List list = null;
        String str = null;
        List list2 = str;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i = SupportMenu.USER_MASK & readInt;
            if (i == 1) {
                list = zzbgm.zzc(parcel, readInt, ActivityTransition.CREATOR);
            } else if (i == 2) {
                str = zzbgm.zzq(parcel, readInt);
            } else if (i != 3) {
                zzbgm.zzb(parcel, readInt);
            } else {
                list2 = zzbgm.zzc(parcel, readInt, zzcfs.CREATOR);
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new ActivityTransitionRequest(list, str, list2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ActivityTransitionRequest[i];
    }
}
