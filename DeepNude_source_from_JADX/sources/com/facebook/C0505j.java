package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.facebook.j */
class C0505j extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ CustomTabMainActivity f941a;

    C0505j(CustomTabMainActivity customTabMainActivity) {
        this.f941a = customTabMainActivity;
    }

    public void onReceive(Context context, Intent intent) {
        Intent intent2 = new Intent(this.f941a, CustomTabMainActivity.class);
        intent2.setAction(CustomTabMainActivity.f427d);
        String str = CustomTabMainActivity.f426c;
        intent2.putExtra(str, intent.getStringExtra(str));
        intent2.addFlags(603979776);
        this.f941a.startActivity(intent2);
    }
}
