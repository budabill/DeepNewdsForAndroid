package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import java.util.Arrays;

public class ActivityTransitionEvent extends zzbgl {
    public static final Creator<ActivityTransitionEvent> CREATOR = new zzd();
    private final int zziqw;
    private final int zziqx;
    private final long zziqy;

    public ActivityTransitionEvent(int i, int i2, long j) {
        DetectedActivity.zzei(i);
        ActivityTransition.zzeh(i2);
        this.zziqw = i;
        this.zziqx = i2;
        this.zziqy = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransitionEvent)) {
            return false;
        }
        ActivityTransitionEvent activityTransitionEvent = (ActivityTransitionEvent) obj;
        return this.zziqw == activityTransitionEvent.zziqw && this.zziqx == activityTransitionEvent.zziqx && this.zziqy == activityTransitionEvent.zziqy;
    }

    public int getActivityType() {
        return this.zziqw;
    }

    public long getElapsedRealTimeNanos() {
        return this.zziqy;
    }

    public int getTransitionType() {
        return this.zziqx;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zziqw), Integer.valueOf(this.zziqx), Long.valueOf(this.zziqy)});
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int i = this.zziqw;
        StringBuilder stringBuilder2 = new StringBuilder(24);
        stringBuilder2.append("ActivityType ");
        stringBuilder2.append(i);
        stringBuilder.append(stringBuilder2.toString());
        String str = " ";
        stringBuilder.append(str);
        int i2 = this.zziqx;
        StringBuilder stringBuilder3 = new StringBuilder(26);
        stringBuilder3.append("TransitionType ");
        stringBuilder3.append(i2);
        stringBuilder.append(stringBuilder3.toString());
        stringBuilder.append(str);
        long j = this.zziqy;
        stringBuilder3 = new StringBuilder(41);
        stringBuilder3.append("ElapsedRealTimeNanos ");
        stringBuilder3.append(j);
        stringBuilder.append(stringBuilder3.toString());
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        i = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, getActivityType());
        zzbgo.zzc(parcel, 2, getTransitionType());
        zzbgo.zza(parcel, 3, getElapsedRealTimeNanos());
        zzbgo.zzai(parcel, i);
    }
}
