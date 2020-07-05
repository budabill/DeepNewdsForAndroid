package com.onesignal;

import com.onesignal.sa.C0650i;

class ra implements Runnable {
    ra() {
    }

    public void run() {
        try {
            sa.m1635T();
            ua.m1747a(sa.f1380f, sa.f1377c, sa.f1383i, C0875d.m2259a());
        } catch (Throwable e) {
            sa.m1657a(C0650i.FATAL, "FATAL Error registering device!", e);
        }
    }
}
