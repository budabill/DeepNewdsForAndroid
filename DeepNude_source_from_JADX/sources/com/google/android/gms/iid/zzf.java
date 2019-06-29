package com.google.android.gms.iid;

import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;

@Hide
public final class zzf extends Binder {
    private final zzb zzimm;

    zzf(zzb zzb) {
        this.zzimm = zzb;
    }

    public final void zza(zzd zzd) {
        if (Binder.getCallingUid() == Process.myUid()) {
            String str = "EnhancedIntentService";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "service received new intent via bind strategy");
            }
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "intent being queued for bg execution");
            }
            this.zzimm.zzimc.execute(new zzg(this, zzd));
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
