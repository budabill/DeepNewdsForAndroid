package com.google.android.gms.common.api.internal;

abstract class zzay implements Runnable {
    private /* synthetic */ zzao zzfxt;

    private zzay(zzao zzao) {
        this.zzfxt = zzao;
    }

    public void run() {
        this.zzfxt.zzfwa.lock();
        try {
            if (!Thread.interrupted()) {
                zzajj();
            }
        } catch (RuntimeException e) {
            this.zzfxt.zzfxd.zzb(e);
        } catch (Throwable th) {
            this.zzfxt.zzfwa.unlock();
        }
        this.zzfxt.zzfwa.unlock();
    }

    protected abstract void zzajj();
}
