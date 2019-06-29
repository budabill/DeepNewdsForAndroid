package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

final class zzx implements zzcd {
    private /* synthetic */ zzv zzfwc;

    private zzx(zzv zzv) {
        this.zzfwc = zzv;
    }

    public final void zzc(ConnectionResult connectionResult) {
        this.zzfwc.zzfwa.lock();
        try {
            this.zzfwc.zzfvx = connectionResult;
            this.zzfwc.zzait();
        } finally {
            this.zzfwc.zzfwa.unlock();
        }
    }

    public final void zzf(int i, boolean z) {
        this.zzfwc.zzfwa.lock();
        try {
            if (!(this.zzfwc.zzfvz || this.zzfwc.zzfvy == null)) {
                if (this.zzfwc.zzfvy.isSuccess()) {
                    this.zzfwc.zzfvz = true;
                    this.zzfwc.zzfvs.onConnectionSuspended(i);
                    this.zzfwc.zzfwa.unlock();
                }
            }
            this.zzfwc.zzfvz = false;
            this.zzfwc.zze(i, z);
            this.zzfwc.zzfwa.unlock();
        } catch (Throwable th) {
            this.zzfwc.zzfwa.unlock();
        }
    }

    public final void zzk(Bundle bundle) {
        this.zzfwc.zzfwa.lock();
        try {
            this.zzfwc.zzj(bundle);
            this.zzfwc.zzfvx = ConnectionResult.zzfqt;
            this.zzfwc.zzait();
        } finally {
            this.zzfwc.zzfwa.unlock();
        }
    }
}
