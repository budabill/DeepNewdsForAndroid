package com.onesignal;

import android.content.Context;

/* renamed from: com.onesignal.J */
class C0593J implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f1136a;

    C0593J(Context context) {
        this.f1136a = context;
    }

    public void run() {
        Thread.currentThread().setPriority(10);
        C0594K.m1387b(this.f1136a);
    }
}
