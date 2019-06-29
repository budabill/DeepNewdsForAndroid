package io.gonative.android;

import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import com.onesignal.sa;
import io.gonative.android.SubscriptionsActivity.C0687b;

class ea implements OnPreferenceChangeListener {
    /* renamed from: a */
    final /* synthetic */ String f1576a;
    /* renamed from: b */
    final /* synthetic */ C0687b f1577b;

    ea(C0687b c0687b, String str) {
        this.f1577b = c0687b;
        this.f1576a = str;
    }

    public boolean onPreferenceChange(Preference preference, Object obj) {
        if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
            sa.m1662a(this.f1576a, "1");
        } else {
            sa.m1686c(this.f1576a);
        }
        return true;
    }
}
