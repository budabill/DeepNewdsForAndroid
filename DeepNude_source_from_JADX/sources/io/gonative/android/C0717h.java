package io.gonative.android;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.onesignal.OSSubscriptionState;
import com.onesignal.sa;

/* renamed from: io.gonative.android.h */
class C0717h implements Runnable {
    /* renamed from: a */
    final /* synthetic */ GoNativeApplication f1605a;

    C0717h(GoNativeApplication goNativeApplication) {
        this.f1605a = goNativeApplication;
    }

    public void run() {
        if (this.f1605a.f1450f) {
            this.f1605a.f1452h.shutdown();
            return;
        }
        OSSubscriptionState a = sa.m1740w().m1424a();
        if (this.f1605a.f1447c != null) {
            this.f1605a.f1447c.m1845a(a.m1407c(), a.m1402a(), Boolean.valueOf(a.m1406b()));
        }
        if (a.m1406b()) {
            this.f1605a.f1452h.shutdown();
            this.f1605a.f1450f = true;
            LocalBroadcastManager.getInstance(this.f1605a).sendBroadcast(new Intent("io.gonative.android.onesignal.statuschanged"));
        } else if (this.f1605a.f1451g = this.f1605a.f1451g + 1 > 10) {
            this.f1605a.f1452h.shutdown();
        }
    }
}
