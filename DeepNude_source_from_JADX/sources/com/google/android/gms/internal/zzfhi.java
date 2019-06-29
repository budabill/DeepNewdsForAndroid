package com.google.android.gms.internal;

import com.google.android.gms.internal.zzfhu.zzg;

final class zzfhi implements zzfli {
    private final zzfhg zzpob;

    private zzfhi(zzfhg zzfhg) {
        zzfhz.zzc(zzfhg, "output");
        this.zzpob = zzfhg;
    }

    public static zzfhi zzb(zzfhg zzfhg) {
        zzfhi zzfhi = zzfhg.zzpoq;
        return zzfhi != null ? zzfhi : new zzfhi(zzfhg);
    }

    public final void zzb(int i, Object obj) {
        try {
            if (obj instanceof zzfgs) {
                this.zzpob.zzb(i, (zzfgs) obj);
            } else {
                this.zzpob.zzb(i, (zzfjc) obj);
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final int zzcyz() {
        return zzg.zzpqf;
    }
}
