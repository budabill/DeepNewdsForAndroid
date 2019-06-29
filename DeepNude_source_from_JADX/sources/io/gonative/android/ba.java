package io.gonative.android;

import android.widget.Toast;

class ba implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f1569a;
    /* renamed from: b */
    final /* synthetic */ SubscriptionsActivity f1570b;

    ba(SubscriptionsActivity subscriptionsActivity, String str) {
        this.f1570b = subscriptionsActivity;
        this.f1569a = str;
    }

    public void run() {
        Toast.makeText(this.f1570b, this.f1569a, 1).show();
        this.f1570b.finish();
    }
}
