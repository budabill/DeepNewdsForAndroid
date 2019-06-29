package io.gonative.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class ga extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ ja f1604a;

    ga(ja jaVar) {
        this.f1604a = jaVar;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals("io.gonative.android.AppConfig.processedTabNavigation")) {
            this.f1604a.f1882c = null;
            ja jaVar = this.f1604a;
            jaVar.m2386b(jaVar.f1883d);
        }
    }
}
