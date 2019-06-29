package com.onesignal;

import com.onesignal.nb.C0634a;
import com.onesignal.sa.C0647f;

class da implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0647f f1271a;

    da(C0647f c0647f) {
        this.f1271a = c0647f;
    }

    public void run() {
        C0634a a = Ha.m1336a(sa.f1360L ^ true);
        if (a.f1277a) {
            sa.f1360L = true;
        }
        if (a.f1278b != null) {
            if (!a.toString().equals("{}")) {
                this.f1271a.mo1410a(a.f1278b);
                return;
            }
        }
        this.f1271a.mo1410a(null);
    }
}
