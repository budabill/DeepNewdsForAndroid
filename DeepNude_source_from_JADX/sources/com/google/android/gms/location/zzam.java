package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;
import java.util.List;

@Hide
public final class zzam implements Creator<zzal> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        List list = null;
        String str = "";
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i = SupportMenu.USER_MASK & readInt;
            if (i == 1) {
                list = zzbgm.zzac(parcel, readInt);
            } else if (i == 2) {
                pendingIntent = (PendingIntent) zzbgm.zza(parcel, readInt, PendingIntent.CREATOR);
            } else if (i != 3) {
                zzbgm.zzb(parcel, readInt);
            } else {
                str = zzbgm.zzq(parcel, readInt);
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzal(list, pendingIntent, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzal[i];
    }
}
