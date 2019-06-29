package com.onesignal;

import com.onesignal.Ga.C0589a;

class Ca implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f1100a;
    /* renamed from: b */
    final /* synthetic */ C0589a f1101b;

    Ca(String str, C0589a c0589a) {
        this.f1100a = str;
        this.f1101b = c0589a;
    }

    public void run() {
        Ga.m1331c(this.f1100a, null, null, this.f1101b, 60000);
    }
}
