package io.gonative.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: io.gonative.android.q */
class C0724q extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ C0725r f1631a;

    C0724q(C0725r c0725r) {
        this.f1631a = c0725r;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals("io.gonative.android.AppConfig.processedMenu")) {
            this.f1631a.m1956a();
        }
    }
}
