package io.gonative.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: io.gonative.android.Y */
class C0696Y extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ aa f1496a;

    C0696Y(aa aaVar) {
        this.f1496a = aaVar;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        if (intent.getAction() != null) {
            if (intent.getAction().equals("io.gonative.android.AppConfig.processedSegmentedControl")) {
                this.f1496a.m1905b();
            }
        }
    }
}
