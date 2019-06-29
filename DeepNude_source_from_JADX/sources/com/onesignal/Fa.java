package com.onesignal;

import com.onesignal.Ga.C0589a;

class Fa implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0589a f1115a;
    /* renamed from: b */
    final /* synthetic */ int f1116b;
    /* renamed from: c */
    final /* synthetic */ String f1117c;
    /* renamed from: d */
    final /* synthetic */ Throwable f1118d;

    Fa(C0589a c0589a, int i, String str, Throwable th) {
        this.f1115a = c0589a;
        this.f1116b = i;
        this.f1117c = str;
        this.f1118d = th;
    }

    public void run() {
        this.f1115a.mo1382a(this.f1116b, this.f1117c, this.f1118d);
    }
}
