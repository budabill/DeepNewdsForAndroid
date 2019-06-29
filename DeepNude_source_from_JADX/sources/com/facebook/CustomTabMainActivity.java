package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.internal.C0494m;

public class CustomTabMainActivity extends Activity {
    /* renamed from: a */
    public static final String f424a;
    /* renamed from: b */
    public static final String f425b;
    /* renamed from: c */
    public static final String f426c;
    /* renamed from: d */
    public static final String f427d;
    /* renamed from: e */
    private boolean f428e = true;
    /* renamed from: f */
    private BroadcastReceiver f429f;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CustomTabMainActivity.class.getSimpleName());
        stringBuilder.append(".extra_params");
        f424a = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(CustomTabMainActivity.class.getSimpleName());
        stringBuilder.append(".extra_chromePackage");
        f425b = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(CustomTabMainActivity.class.getSimpleName());
        stringBuilder.append(".extra_url");
        f426c = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(CustomTabMainActivity.class.getSimpleName());
        stringBuilder.append(".action_refresh");
        f427d = stringBuilder.toString();
    }

    /* renamed from: a */
    public static final String m478a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fb");
        stringBuilder.append(C0560t.m1253e());
        stringBuilder.append("://authorize");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private void m479a(int i, Intent intent) {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f429f);
        if (intent != null) {
            setResult(i, intent);
        } else {
            setResult(i);
        }
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (CustomTabActivity.f421a.equals(getIntent().getAction())) {
            setResult(0);
            finish();
            return;
        }
        if (bundle == null) {
            bundle = getIntent().getBundleExtra(f424a);
            new C0494m("oauth", bundle).m1082a(this, getIntent().getStringExtra(f425b));
            this.f428e = false;
            this.f429f = new C0505j(this);
            LocalBroadcastManager.getInstance(this).registerReceiver(this.f429f, new IntentFilter(CustomTabActivity.f421a));
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (f427d.equals(intent.getAction())) {
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(CustomTabActivity.f422b));
        } else if (!CustomTabActivity.f421a.equals(intent.getAction())) {
            return;
        }
        m479a(-1, intent);
    }

    protected void onResume() {
        super.onResume();
        if (this.f428e) {
            m479a(0, null);
        }
        this.f428e = true;
    }
}
