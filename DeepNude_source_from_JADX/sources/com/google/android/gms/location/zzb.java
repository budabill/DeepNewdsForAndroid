package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;
import java.util.List;

@Hide
public final class zzb implements Creator<ActivityRecognitionResult> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        long j = 0;
        long j2 = j;
        List list = null;
        Bundle bundle = list;
        int i = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i2 = SupportMenu.USER_MASK & readInt;
            if (i2 == 1) {
                list = zzbgm.zzc(parcel, readInt, DetectedActivity.CREATOR);
            } else if (i2 == 2) {
                j = zzbgm.zzi(parcel, readInt);
            } else if (i2 == 3) {
                j2 = zzbgm.zzi(parcel, readInt);
            } else if (i2 == 4) {
                i = zzbgm.zzg(parcel, readInt);
            } else if (i2 != 5) {
                zzbgm.zzb(parcel, readInt);
            } else {
                bundle = zzbgm.zzs(parcel, readInt);
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new ActivityRecognitionResult(list, j, j2, i, bundle);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ActivityRecognitionResult[i];
    }
}
