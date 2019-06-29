package com.facebook.p029a;

import android.preference.PreferenceManager;
import android.util.Log;
import com.facebook.C0560t;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: com.facebook.a.z */
public class C0431z {
    /* renamed from: a */
    private static final String f740a = "z";
    /* renamed from: b */
    private static ReentrantReadWriteLock f741b = new ReentrantReadWriteLock();
    /* renamed from: c */
    private static String f742c;
    /* renamed from: d */
    private static volatile boolean f743d = false;

    /* renamed from: b */
    public static String m822b() {
        if (!f743d) {
            Log.w(f740a, "initStore should have been called before calling setUserID");
            C0431z.m824d();
        }
        f741b.readLock().lock();
        try {
            String str = f742c;
            return str;
        } finally {
            f741b.readLock().unlock();
        }
    }

    /* renamed from: c */
    public static void m823c() {
        if (!f743d) {
            C0422r.m797c().execute(new C0430y());
        }
    }

    /* renamed from: d */
    private static void m824d() {
        if (!f743d) {
            f741b.writeLock().lock();
            try {
                if (!f743d) {
                    f742c = PreferenceManager.getDefaultSharedPreferences(C0560t.m1252d()).getString("com.facebook.appevents.UserDataStore.userData", null);
                    f743d = true;
                    f741b.writeLock().unlock();
                }
            } finally {
                f741b.writeLock().unlock();
            }
        }
    }
}
