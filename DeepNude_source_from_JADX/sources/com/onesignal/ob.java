package com.onesignal;

import com.onesignal.nb.C0635b;

class ob implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0635b f1297a;

    ob(C0635b c0635b) {
        this.f1297a = c0635b;
    }

    public void run() {
        if (!this.f1297a.f1282d.f1284b.get()) {
            this.f1297a.f1282d.m1556a(false);
        }
    }
}
