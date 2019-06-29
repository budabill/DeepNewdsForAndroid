package com.facebook.p029a.p032b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.facebook.C0560t;
import java.util.UUID;

/* renamed from: com.facebook.a.b.v */
class C0397v {
    /* renamed from: a */
    private Long f659a;
    /* renamed from: b */
    private Long f660b;
    /* renamed from: c */
    private int f661c;
    /* renamed from: d */
    private Long f662d;
    /* renamed from: e */
    private C0401y f663e;
    /* renamed from: f */
    private UUID f664f;

    public C0397v(Long l, Long l2) {
        this(l, l2, UUID.randomUUID());
    }

    public C0397v(Long l, Long l2, UUID uuid) {
        this.f659a = l;
        this.f660b = l2;
        this.f664f = uuid;
    }

    /* renamed from: a */
    public static void m729a() {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(C0560t.m1252d()).edit();
        edit.remove("com.facebook.appevents.SessionInfo.sessionStartTime");
        edit.remove("com.facebook.appevents.SessionInfo.sessionEndTime");
        edit.remove("com.facebook.appevents.SessionInfo.interruptionCount");
        edit.remove("com.facebook.appevents.SessionInfo.sessionId");
        edit.apply();
        C0401y.m745a();
    }

    /* renamed from: h */
    public static C0397v m730h() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(C0560t.m1252d());
        long j = defaultSharedPreferences.getLong("com.facebook.appevents.SessionInfo.sessionStartTime", 0);
        long j2 = defaultSharedPreferences.getLong("com.facebook.appevents.SessionInfo.sessionEndTime", 0);
        String string = defaultSharedPreferences.getString("com.facebook.appevents.SessionInfo.sessionId", null);
        if (!(j == 0 || j2 == 0)) {
            if (string != null) {
                C0397v c0397v = new C0397v(Long.valueOf(j), Long.valueOf(j2));
                c0397v.f661c = defaultSharedPreferences.getInt("com.facebook.appevents.SessionInfo.interruptionCount", 0);
                c0397v.f663e = C0401y.m746b();
                c0397v.f662d = Long.valueOf(System.currentTimeMillis());
                c0397v.f664f = UUID.fromString(string);
                return c0397v;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m731a(Long l) {
        this.f660b = l;
    }

    /* renamed from: b */
    public long m732b() {
        Long l = this.f662d;
        return l == null ? 0 : l.longValue();
    }

    /* renamed from: c */
    public int m733c() {
        return this.f661c;
    }

    /* renamed from: d */
    public UUID m734d() {
        return this.f664f;
    }

    /* renamed from: e */
    public Long m735e() {
        return this.f660b;
    }

    /* renamed from: f */
    public long m736f() {
        if (this.f659a != null) {
            Long l = this.f660b;
            if (l != null) {
                return l.longValue() - this.f659a.longValue();
            }
        }
        return 0;
    }

    /* renamed from: g */
    public C0401y m737g() {
        return this.f663e;
    }

    /* renamed from: i */
    public void m738i() {
        this.f661c++;
    }

    /* renamed from: j */
    public void m739j() {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(C0560t.m1252d()).edit();
        edit.putLong("com.facebook.appevents.SessionInfo.sessionStartTime", this.f659a.longValue());
        edit.putLong("com.facebook.appevents.SessionInfo.sessionEndTime", this.f660b.longValue());
        edit.putInt("com.facebook.appevents.SessionInfo.interruptionCount", this.f661c);
        edit.putString("com.facebook.appevents.SessionInfo.sessionId", this.f664f.toString());
        edit.apply();
        C0401y c0401y = this.f663e;
        if (c0401y != null) {
            c0401y.m747c();
        }
    }
}
