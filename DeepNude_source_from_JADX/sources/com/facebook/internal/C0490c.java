package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.p029a.C0422r;

/* renamed from: com.facebook.internal.c */
public class C0490c extends BroadcastReceiver {
    /* renamed from: a */
    private static C0490c f890a;
    /* renamed from: b */
    private Context f891b;

    private C0490c(Context context) {
        this.f891b = context.getApplicationContext();
    }

    /* renamed from: a */
    public static C0490c m1076a(Context context) {
        C0490c c0490c = f890a;
        if (c0490c != null) {
            return c0490c;
        }
        f890a = new C0490c(context);
        f890a.m1078b();
        return f890a;
    }

    /* renamed from: a */
    private void m1077a() {
        LocalBroadcastManager.getInstance(this.f891b).unregisterReceiver(this);
    }

    /* renamed from: b */
    private void m1078b() {
        LocalBroadcastManager.getInstance(this.f891b).registerReceiver(this, new IntentFilter("com.parse.bolts.measurement_event"));
    }

    protected void finalize() {
        try {
            m1077a();
        } finally {
            super.finalize();
        }
    }

    public void onReceive(Context context, Intent intent) {
        C0422r b = C0422r.m795b(context);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("bf_");
        stringBuilder.append(intent.getStringExtra("event_name"));
        String stringBuilder2 = stringBuilder.toString();
        Bundle bundleExtra = intent.getBundleExtra("event_args");
        Bundle bundle = new Bundle();
        for (String str : bundleExtra.keySet()) {
            String str2 = "";
            bundle.putString(str.replaceAll("[^0-9a-zA-Z _-]", "-").replaceAll("^[ -]*", str2).replaceAll("[ -]*$", str2), (String) bundleExtra.get(str));
        }
        b.m805a(stringBuilder2, bundle);
    }
}
