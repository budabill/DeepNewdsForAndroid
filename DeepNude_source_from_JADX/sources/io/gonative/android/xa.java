package io.gonative.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class xa extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ Aa f1670a;

    xa(Aa aa) {
        this.f1670a = aa;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        if (intent.getAction() != null) {
            String action = intent.getAction();
            int i = -1;
            switch (action.hashCode()) {
                case -2060673285:
                    if (action.equals("io.gonative.android.AppConfig.processedWebViewPools")) {
                        i = 2;
                        break;
                    }
                    break;
                case -1004750843:
                    if (action.equals("io.gonative.android.webview.clearPools")) {
                        i = 3;
                        break;
                    }
                    break;
                case -799068755:
                    if (action.equals("io.gonative.android.webview.finished")) {
                        i = 1;
                        break;
                    }
                    break;
                case 731168742:
                    if (action.equals("io.gonative.android.webview.started")) {
                        i = 0;
                        break;
                    }
                    break;
                default:
                    break;
            }
            Aa aa;
            if (i == 0) {
                aa = this.f1670a;
                aa.f1432m = true;
                if (aa.f1428i != null) {
                    aa.f1428i.stopLoading();
                    aa.f1430k = false;
                }
            } else if (i == 1) {
                aa = this.f1670a;
                aa.f1432m = false;
                aa.m1791c();
            } else if (i == 2) {
                this.f1670a.m1788b();
            } else if (i == 3) {
                this.f1670a.m1784a();
            }
        }
    }
}
