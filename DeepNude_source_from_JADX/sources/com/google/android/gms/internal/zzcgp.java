package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zzn;
import com.google.android.gms.location.zzal;

final class zzcgp extends zzcgq {
    private /* synthetic */ zzal zziub;

    zzcgp(zzcgn zzcgn, GoogleApiClient googleApiClient, zzal zzal) {
        this.zziub = zzal;
        super(googleApiClient);
    }

    protected final /* synthetic */ void zza(zzb zzb) {
        ((zzchh) zzb).zza(this.zziub, (zzn) this);
    }
}
