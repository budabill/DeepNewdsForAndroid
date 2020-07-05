package com.onesignal;

import com.onesignal.sa.C0647f;
import com.onesignal.sa.C0650i;

class ca implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0647f f1264a;

    ca(C0647f c0647f) {
        this.f1264a = c0647f;
    }

    public void run() {
        if (this.f1264a == null) {
            sa.m1656a(C0650i.ERROR, "getTagsHandler is null!");
        } else if (sa.m1616A() != null) {
            sa.m1685c(sa.f1359K);
        }
    }
}
