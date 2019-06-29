package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

final class zzy implements zzcd {
    private /* synthetic */ zzv zzfwc;

    private zzy(zzv zzv) {
        this.zzfwc = zzv;
    }

    public final void zzc(ConnectionResult connectionResult) {
        this.zzfwc.zzfwa.lock();
        try {
            this.zzfwc.zzfvy = connectionResult;
            this.zzfwc.zzait();
        } finally {
            this.zzfwc.zzfwa.unlock();
        }
    }

    public final void zzf(int i, boolean z) {
        this.zzfwc.zzfwa.lock();
        try {
            if (this.zzfwc.zzfvz) {
                this.zzfwc.zzfvz = false;
                this.zzfwc.zze(i, z);
            } else {
                this.zzfwc.zzfvz = true;
                this.zzfwc.zzfvr.onConnectionSuspended(i);
            }
            this.zzfwc.zzfwa.unlock();
        } catch (Throwable th) {
            this.zzfwc.zzfwa.unlock();
        }
    }

    public final void zzk(Bundle bundle) {
        this.zzfwc.zzfwa.lock();
        try {
            this.zzfwc.zzfvy = ConnectionResult.zzfqt;
            this.zzfwc.zzait();
        } finally {
            this.zzfwc.zzfwa.unlock();
        }
    }
}
