package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IInterface;
import com.google.android.gms.common.api.internal.zzca;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.zzal;

@Hide
public interface zzcgw extends IInterface {
    void zza(long j, boolean z, PendingIntent pendingIntent);

    void zza(PendingIntent pendingIntent, zzca zzca);

    void zza(zzcfw zzcfw);

    void zza(zzcgr zzcgr);

    void zza(zzchn zzchn);

    void zza(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent, zzca zzca);

    void zza(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzcgu zzcgu);

    void zza(LocationSettingsRequest locationSettingsRequest, zzcgy zzcgy, String str);

    void zza(zzal zzal, zzcgu zzcgu);

    void zzbo(boolean z);

    void zzc(PendingIntent pendingIntent);

    void zzc(Location location);

    Location zzim(String str);

    LocationAvailability zzin(String str);
}
