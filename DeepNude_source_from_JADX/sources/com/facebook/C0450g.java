package com.facebook;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.AccessToken.C0327a;
import com.facebook.GraphRequest.C0338b;
import com.facebook.internal.C0475Q;
import com.facebook.internal.C0476S;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.g */
public final class C0450g {
    /* renamed from: a */
    private static volatile C0450g f767a;
    /* renamed from: b */
    private final LocalBroadcastManager f768b;
    /* renamed from: c */
    private final C0439b f769c;
    /* renamed from: d */
    private AccessToken f770d;
    /* renamed from: e */
    private AtomicBoolean f771e = new AtomicBoolean(false);
    /* renamed from: f */
    private Date f772f = new Date(0);

    /* renamed from: com.facebook.g$a */
    private static class C0449a {
        /* renamed from: a */
        public String f764a;
        /* renamed from: b */
        public int f765b;
        /* renamed from: c */
        public Long f766c;

        private C0449a() {
        }
    }

    C0450g(LocalBroadcastManager localBroadcastManager, C0439b c0439b) {
        C0476S.m1016a((Object) localBroadcastManager, "localBroadcastManager");
        C0476S.m1016a((Object) c0439b, "accessTokenCache");
        this.f768b = localBroadcastManager;
        this.f769c = c0439b;
    }

    /* renamed from: a */
    private static GraphRequest m851a(AccessToken accessToken, C0338b c0338b) {
        Bundle bundle = new Bundle();
        bundle.putString("grant_type", "fb_extend_sso_token");
        return new GraphRequest(accessToken, "oauth/access_token", bundle, C0332E.GET, c0338b);
    }

    /* renamed from: a */
    private void m853a(AccessToken accessToken, AccessToken accessToken2) {
        Intent intent = new Intent(C0560t.m1252d(), CurrentAccessTokenExpirationBroadcastReceiver.class);
        intent.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN", accessToken);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN", accessToken2);
        this.f768b.sendBroadcast(intent);
    }

    /* renamed from: a */
    private void m854a(AccessToken accessToken, boolean z) {
        AccessToken accessToken2 = this.f770d;
        this.f770d = accessToken;
        this.f771e.set(false);
        this.f772f = new Date(0);
        if (z) {
            if (accessToken != null) {
                this.f769c.m847a(accessToken);
            } else {
                this.f769c.m846a();
                C0475Q.m976a(C0560t.m1252d());
            }
        }
        if (!C0475Q.m991a((Object) accessToken2, (Object) accessToken)) {
            m853a(accessToken2, accessToken);
            m859f();
        }
    }

    /* renamed from: b */
    private static GraphRequest m856b(AccessToken accessToken, C0338b c0338b) {
        return new GraphRequest(accessToken, "me/permissions", new Bundle(), C0332E.GET, c0338b);
    }

    /* renamed from: b */
    private void m857b(C0327a c0327a) {
        AccessToken accessToken = this.f770d;
        if (accessToken == null) {
            if (c0327a != null) {
                c0327a.m438a(new C0506l("No current access token to refresh"));
            }
        } else if (this.f771e.compareAndSet(false, true)) {
            this.f772f = new Date();
            Set hashSet = new HashSet();
            Set hashSet2 = new HashSet();
            C0330C c0330c = new C0330C(C0450g.m856b(accessToken, new C0826d(this, new AtomicBoolean(false), hashSet, hashSet2)), C0450g.m851a(accessToken, new C0827e(this, new C0449a())));
            c0330c.m466a(new C0828f(this, accessToken, c0327a, r4, r5, hashSet, hashSet2));
            c0330c.m470c();
        } else {
            if (c0327a != null) {
                c0327a.m438a(new C0506l("Refresh already in progress"));
            }
        }
    }

    /* renamed from: d */
    static C0450g m858d() {
        if (f767a == null) {
            synchronized (C0450g.class) {
                if (f767a == null) {
                    f767a = new C0450g(LocalBroadcastManager.getInstance(C0560t.m1252d()), new C0439b());
                }
            }
        }
        return f767a;
    }

    /* renamed from: f */
    private void m859f() {
        Context d = C0560t.m1252d();
        AccessToken c = AccessToken.m446c();
        AlarmManager alarmManager = (AlarmManager) d.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (AccessToken.m447l() && c.m452f() != null) {
            if (alarmManager != null) {
                Intent intent = new Intent(d, CurrentAccessTokenExpirationBroadcastReceiver.class);
                intent.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
                alarmManager.set(1, c.m452f().getTime(), PendingIntent.getBroadcast(d, 0, intent, 0));
            }
        }
    }

    /* renamed from: g */
    private boolean m860g() {
        boolean z = false;
        if (this.f770d == null) {
            return false;
        }
        Long valueOf = Long.valueOf(new Date().getTime());
        if (this.f770d.m455i().m867a() && valueOf.longValue() - this.f772f.getTime() > 3600000 && valueOf.longValue() - this.f770d.m453g().getTime() > 86400000) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    void m861a() {
        AccessToken accessToken = this.f770d;
        m853a(accessToken, accessToken);
    }

    /* renamed from: a */
    void m862a(C0327a c0327a) {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            m857b(c0327a);
        } else {
            new Handler(Looper.getMainLooper()).post(new C0443c(this, c0327a));
        }
    }

    /* renamed from: a */
    void m863a(AccessToken accessToken) {
        m854a(accessToken, true);
    }

    /* renamed from: b */
    void m864b() {
        if (m860g()) {
            m862a(null);
        }
    }

    /* renamed from: c */
    AccessToken m865c() {
        return this.f770d;
    }

    /* renamed from: e */
    boolean m866e() {
        AccessToken b = this.f769c.m848b();
        if (b == null) {
            return false;
        }
        m854a(b, false);
        return true;
    }
}
