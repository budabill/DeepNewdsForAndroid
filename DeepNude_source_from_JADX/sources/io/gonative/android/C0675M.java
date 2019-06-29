package io.gonative.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: io.gonative.android.M */
class C0675M extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ MainActivity f1457a;

    C0675M(MainActivity mainActivity) {
        this.f1457a = mainActivity;
    }

    public void onReceive(Context context, Intent intent) {
        if ("io.gonative.android.AppConfig.processedNavigationLevels".equals(intent.getAction())) {
            String url = this.f1457a.f2030a.getUrl();
            if (url != null) {
                this.f1457a.m2589a(this.f1457a.m2618j(url));
            }
        }
    }
}
