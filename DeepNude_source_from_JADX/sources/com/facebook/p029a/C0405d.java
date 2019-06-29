package com.facebook.p029a;

import android.preference.PreferenceManager;
import android.util.Log;
import com.facebook.C0560t;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: com.facebook.a.d */
class C0405d {
    /* renamed from: a */
    private static final String f679a = "d";
    /* renamed from: b */
    private static ReentrantReadWriteLock f680b = new ReentrantReadWriteLock();
    /* renamed from: c */
    private static String f681c;
    /* renamed from: d */
    private static volatile boolean f682d = false;

    /* renamed from: b */
    public static String m751b() {
        if (!f682d) {
            Log.w(f679a, "initStore should have been called before calling setUserID");
            C0405d.m753d();
        }
        f680b.readLock().lock();
        try {
            String str = f681c;
            return str;
        } finally {
            f680b.readLock().unlock();
        }
    }

    /* renamed from: c */
    public static void m752c() {
        if (!f682d) {
            C0422r.m797c().execute(new C0404c());
        }
    }

    /* renamed from: d */
    private static void m753d() {
        if (!f682d) {
            f680b.writeLock().lock();
            try {
                if (!f682d) {
                    f681c = PreferenceManager.getDefaultSharedPreferences(C0560t.m1252d()).getString("com.facebook.appevents.AnalyticsUserIDStore.userID", null);
                    f682d = true;
                    f680b.writeLock().unlock();
                }
            } finally {
                f680b.writeLock().unlock();
            }
        }
    }
}
