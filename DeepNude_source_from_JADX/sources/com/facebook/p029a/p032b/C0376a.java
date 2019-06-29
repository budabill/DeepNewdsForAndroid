package com.facebook.p029a.p032b;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.facebook.C0336G;
import com.facebook.internal.C0461G;
import com.facebook.p029a.C0422r;

/* renamed from: com.facebook.a.b.a */
class C0376a implements ActivityLifecycleCallbacks {
    C0376a() {
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        C0461G.m891a(C0336G.APP_EVENTS, C0382h.f616a, "onActivityCreated");
        C0383i.m689a();
        C0382h.m669b(activity);
    }

    public void onActivityDestroyed(Activity activity) {
        C0461G.m891a(C0336G.APP_EVENTS, C0382h.f616a, "onActivityDestroyed");
    }

    public void onActivityPaused(Activity activity) {
        C0461G.m891a(C0336G.APP_EVENTS, C0382h.f616a, "onActivityPaused");
        C0383i.m689a();
        C0382h.m675d(activity);
    }

    public void onActivityResumed(Activity activity) {
        C0461G.m891a(C0336G.APP_EVENTS, C0382h.f616a, "onActivityResumed");
        C0383i.m689a();
        C0382h.m672c(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        C0461G.m891a(C0336G.APP_EVENTS, C0382h.f616a, "onActivitySaveInstanceState");
    }

    public void onActivityStarted(Activity activity) {
        C0461G.m891a(C0336G.APP_EVENTS, C0382h.f616a, "onActivityStarted");
    }

    public void onActivityStopped(Activity activity) {
        C0461G.m891a(C0336G.APP_EVENTS, C0382h.f616a, "onActivityStopped");
        C0422r.m802h();
    }
}
