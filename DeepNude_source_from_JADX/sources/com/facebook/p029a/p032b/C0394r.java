package com.facebook.p029a.p032b;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.facebook.C0560t;

/* renamed from: com.facebook.a.b.r */
class C0394r implements ActivityLifecycleCallbacks {
    C0394r() {
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        C0560t.m1258j().execute(new C0392p(this));
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
        if (C0395s.f647d.booleanValue() && activity.getLocalClassName().equals("com.android.billingclient.api.ProxyBillingActivity")) {
            C0560t.m1258j().execute(new C0393q(this));
        }
    }
}
