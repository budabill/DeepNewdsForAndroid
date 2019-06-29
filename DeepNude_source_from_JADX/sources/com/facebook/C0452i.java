package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.facebook.i */
class C0452i extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ CustomTabActivity f784a;

    C0452i(CustomTabActivity customTabActivity) {
        this.f784a = customTabActivity;
    }

    public void onReceive(Context context, Intent intent) {
        this.f784a.finish();
    }
}
