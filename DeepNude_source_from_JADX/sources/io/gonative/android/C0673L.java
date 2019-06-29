package io.gonative.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import io.gonative.android.azzpro.R;

/* renamed from: io.gonative.android.L */
class C0673L extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ MainActivity f1456a;

    C0673L(MainActivity mainActivity) {
        this.f1456a = mainActivity;
    }

    public void onReceive(Context context, Intent intent) {
        if ("io.gonative.android.AppConfig.processedNavigationTitles".equals(intent.getAction())) {
            String url = this.f1456a.f2030a.getUrl();
            if (url != null) {
                CharSequence i = this.f1456a.m2616i(url);
                if (i != null) {
                    this.f1456a.setTitle(i);
                } else {
                    this.f1456a.setTitle(R.string.app_name);
                }
            }
        }
    }
}
