package com.facebook;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.internal.C0475Q;
import com.facebook.internal.C0476S;

/* renamed from: com.facebook.K */
public final class C0342K {
    /* renamed from: a */
    private static volatile C0342K f497a;
    /* renamed from: b */
    private final LocalBroadcastManager f498b;
    /* renamed from: c */
    private final C0341J f499c;
    /* renamed from: d */
    private Profile f500d;

    C0342K(LocalBroadcastManager localBroadcastManager, C0341J c0341j) {
        C0476S.m1016a((Object) localBroadcastManager, "localBroadcastManager");
        C0476S.m1016a((Object) c0341j, "profileCache");
        this.f498b = localBroadcastManager;
        this.f499c = c0341j;
    }

    /* renamed from: a */
    private void m571a(Profile profile, Profile profile2) {
        Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_PROFILE", profile);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_PROFILE", profile2);
        this.f498b.sendBroadcast(intent);
    }

    /* renamed from: a */
    private void m572a(Profile profile, boolean z) {
        Profile profile2 = this.f500d;
        this.f500d = profile;
        if (z) {
            if (profile != null) {
                this.f499c.m569a(profile);
            } else {
                this.f499c.m568a();
            }
        }
        if (!C0475Q.m991a((Object) profile2, (Object) profile)) {
            m571a(profile2, profile);
        }
    }

    /* renamed from: b */
    static C0342K m573b() {
        if (f497a == null) {
            synchronized (C0342K.class) {
                if (f497a == null) {
                    f497a = new C0342K(LocalBroadcastManager.getInstance(C0560t.m1252d()), new C0341J());
                }
            }
        }
        return f497a;
    }

    /* renamed from: a */
    Profile m574a() {
        return this.f500d;
    }

    /* renamed from: a */
    void m575a(Profile profile) {
        m572a(profile, true);
    }

    /* renamed from: c */
    boolean m576c() {
        Profile b = this.f499c.m570b();
        if (b == null) {
            return false;
        }
        m572a(b, false);
        return true;
    }
}
