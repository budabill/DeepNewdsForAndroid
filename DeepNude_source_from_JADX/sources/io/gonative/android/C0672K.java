package io.gonative.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: io.gonative.android.K */
class C0672K extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ MainActivity f1455a;

    C0672K(MainActivity mainActivity) {
        this.f1455a = mainActivity;
    }

    public void onReceive(Context context, Intent intent) {
        if ("io.gonative.android.onesignal.statuschanged".equals(intent.getAction())) {
            this.f1455a.m2561J();
        }
    }
}
