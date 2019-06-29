package io.gonative.android;

import android.app.Fragment;
import io.gonative.android.SubscriptionsActivity.C0687b;
import io.gonative.android.azzpro.R;

class ca implements Runnable {
    /* renamed from: a */
    final /* synthetic */ da f1574a;

    ca(da daVar) {
        this.f1574a = daVar;
    }

    public void run() {
        this.f1574a.f1873b.f2056a.setVisibility(8);
        Fragment c0687b = new C0687b();
        c0687b.m1822a(this.f1574a.f1872a);
        this.f1574a.f1873b.getFragmentManager().beginTransaction().replace(R.id.subscriptions_fragment, c0687b).commit();
    }
}
