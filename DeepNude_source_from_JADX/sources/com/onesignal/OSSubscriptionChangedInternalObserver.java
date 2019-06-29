package com.onesignal;

class OSSubscriptionChangedInternalObserver {
    OSSubscriptionChangedInternalObserver() {
    }

    /* renamed from: a */
    static void m1400a(OSSubscriptionState oSSubscriptionState) {
        C0614Z c0614z = new C0614Z();
        c0614z.f1238b = sa.f1372X;
        c0614z.f1237a = (OSSubscriptionState) oSSubscriptionState.clone();
        if (sa.m1743z().m1414c(c0614z)) {
            sa.f1372X = (OSSubscriptionState) oSSubscriptionState.clone();
            sa.f1372X.m1408d();
        }
    }

    public void changed(OSSubscriptionState oSSubscriptionState) {
        m1400a(oSSubscriptionState);
    }
}
