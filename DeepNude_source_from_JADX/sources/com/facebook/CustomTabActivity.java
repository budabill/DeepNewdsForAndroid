package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;

public class CustomTabActivity extends Activity {
    /* renamed from: a */
    public static final String f421a;
    /* renamed from: b */
    public static final String f422b;
    /* renamed from: c */
    private BroadcastReceiver f423c;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CustomTabActivity.class.getSimpleName());
        stringBuilder.append(".action_customTabRedirect");
        f421a = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(CustomTabActivity.class.getSimpleName());
        stringBuilder.append(".action_destroy");
        f422b = stringBuilder.toString();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 0) {
            Intent intent2 = new Intent(f421a);
            intent2.putExtra(CustomTabMainActivity.f426c, getIntent().getDataString());
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent2);
            this.f423c = new C0452i(this);
            LocalBroadcastManager.getInstance(this).registerReceiver(this.f423c, new IntentFilter(f422b));
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = new Intent(this, CustomTabMainActivity.class);
        intent.setAction(f421a);
        intent.putExtra(CustomTabMainActivity.f426c, getIntent().getDataString());
        intent.addFlags(603979776);
        startActivityForResult(intent, 2);
    }

    protected void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f423c);
        super.onDestroy();
    }
}
