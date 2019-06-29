package com.onesignal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

/* renamed from: com.onesignal.c */
class C0625c implements ActivityLifecycleCallbacks {
    C0625c() {
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        C0624b.m1494a(activity);
    }

    public void onActivityDestroyed(Activity activity) {
        C0624b.m1497b(activity);
    }

    public void onActivityPaused(Activity activity) {
        C0624b.m1500c(activity);
    }

    public void onActivityResumed(Activity activity) {
        C0624b.m1501d(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        C0624b.m1502e(activity);
    }

    public void onActivityStopped(Activity activity) {
        C0624b.m1503f(activity);
    }
}
