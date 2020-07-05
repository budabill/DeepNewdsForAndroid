package com.onesignal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.HashMap;

class za {
    /* renamed from: a */
    public static final String f1415a = sa.class.getSimpleName();
    /* renamed from: b */
    static HashMap<String, HashMap<String, Object>> f1416b;
    /* renamed from: c */
    public static C0664a f1417c;

    /* renamed from: com.onesignal.za$a */
    public static class C0664a extends HandlerThread {
        /* renamed from: a */
        public Handler f1413a;
        /* renamed from: b */
        private long f1414b = 0;

        C0664a() {
            super("OSH_WritePrefs");
            start();
            this.f1413a = new Handler(getLooper());
        }

        /* renamed from: b */
        private void m1763b() {
            if (sa.f1380f != null) {
                for (String str : za.f1416b.keySet()) {
                    Editor edit = za.m1774b(str).edit();
                    HashMap hashMap = (HashMap) za.f1416b.get(str);
                    synchronized (hashMap) {
                        for (String str2 : hashMap.keySet()) {
                            Object obj = hashMap.get(str2);
                            if (obj instanceof String) {
                                edit.putString(str2, (String) obj);
                            } else if (obj instanceof Boolean) {
                                edit.putBoolean(str2, ((Boolean) obj).booleanValue());
                            } else if (obj instanceof Integer) {
                                edit.putInt(str2, ((Integer) obj).intValue());
                            } else if (obj instanceof Long) {
                                edit.putLong(str2, ((Long) obj).longValue());
                            }
                        }
                        hashMap.clear();
                    }
                    edit.apply();
                }
                this.f1414b = System.currentTimeMillis();
            }
        }

        /* renamed from: c */
        private Runnable m1764c() {
            return new ya(this);
        }

        /* renamed from: a */
        void m1765a() {
            synchronized (this.f1413a) {
                this.f1413a.removeCallbacksAndMessages(null);
                if (this.f1414b == 0) {
                    this.f1414b = System.currentTimeMillis();
                }
                this.f1413a.postDelayed(m1764c(), (this.f1414b - System.currentTimeMillis()) + 200);
            }
        }
    }

    static {
        m1771a();
    }

    /* renamed from: a */
    static int m1766a(String str, String str2, int i) {
        return ((Integer) m1769a(str, str2, Integer.class, Integer.valueOf(i))).intValue();
    }

    /* renamed from: a */
    static long m1767a(String str, String str2, long j) {
        return ((Long) m1769a(str, str2, Long.class, Long.valueOf(j))).longValue();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static java.lang.Object m1769a(java.lang.String r3, java.lang.String r4, java.lang.Class r5, java.lang.Object r6) {
        /*
        r0 = f1416b;
        r0 = r0.get(r3);
        r0 = (java.util.HashMap) r0;
        monitor-enter(r0);
        r1 = java.lang.Object.class;
        r1 = r5.equals(r1);	 Catch:{ all -> 0x009c }
        if (r1 == 0) goto L_0x001e;
    L_0x0011:
        r1 = r0.containsKey(r4);	 Catch:{ all -> 0x009c }
        if (r1 == 0) goto L_0x001e;
    L_0x0017:
        r3 = 1;
        r3 = java.lang.Boolean.valueOf(r3);	 Catch:{ all -> 0x009c }
        monitor-exit(r0);	 Catch:{ all -> 0x009c }
        return r3;
    L_0x001e:
        r1 = r0.get(r4);	 Catch:{ all -> 0x009c }
        if (r1 != 0) goto L_0x009a;
    L_0x0024:
        r2 = r0.containsKey(r4);	 Catch:{ all -> 0x009c }
        if (r2 == 0) goto L_0x002b;
    L_0x002a:
        goto L_0x009a;
    L_0x002b:
        monitor-exit(r0);	 Catch:{ all -> 0x009c }
        r3 = m1774b(r3);
        if (r3 == 0) goto L_0x0099;
    L_0x0032:
        r0 = java.lang.String.class;
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x0041;
    L_0x003a:
        r6 = (java.lang.String) r6;
        r3 = r3.getString(r4, r6);
        return r3;
    L_0x0041:
        r0 = java.lang.Boolean.class;
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x0058;
    L_0x0049:
        r6 = (java.lang.Boolean) r6;
        r5 = r6.booleanValue();
        r3 = r3.getBoolean(r4, r5);
        r3 = java.lang.Boolean.valueOf(r3);
        return r3;
    L_0x0058:
        r0 = java.lang.Integer.class;
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x006f;
    L_0x0060:
        r6 = (java.lang.Integer) r6;
        r5 = r6.intValue();
        r3 = r3.getInt(r4, r5);
        r3 = java.lang.Integer.valueOf(r3);
        return r3;
    L_0x006f:
        r0 = java.lang.Long.class;
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x0086;
    L_0x0077:
        r6 = (java.lang.Long) r6;
        r5 = r6.longValue();
        r3 = r3.getLong(r4, r5);
        r3 = java.lang.Long.valueOf(r3);
        return r3;
    L_0x0086:
        r6 = java.lang.Object.class;
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x0097;
    L_0x008e:
        r3 = r3.contains(r4);
        r3 = java.lang.Boolean.valueOf(r3);
        return r3;
    L_0x0097:
        r3 = 0;
        return r3;
    L_0x0099:
        return r6;
    L_0x009a:
        monitor-exit(r0);	 Catch:{ all -> 0x009c }
        return r1;
    L_0x009c:
        r3 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x009c }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.za.a(java.lang.String, java.lang.String, java.lang.Class, java.lang.Object):java.lang.Object");
    }

    /* renamed from: a */
    static String m1770a(String str, String str2, String str3) {
        return (String) m1769a(str, str2, String.class, str3);
    }

    /* renamed from: a */
    public static void m1771a() {
        f1416b = new HashMap();
        f1416b.put(f1415a, new HashMap());
        f1416b.put("GTPlayerPurchases", new HashMap());
        f1417c = new C0664a();
    }

    /* renamed from: a */
    private static void m1772a(String str, String str2, Object obj) {
        HashMap hashMap = (HashMap) f1416b.get(str);
        synchronized (hashMap) {
            hashMap.put(str2, obj);
        }
        m1775b();
    }

    /* renamed from: a */
    static boolean m1773a(String str, String str2, boolean z) {
        return ((Boolean) m1769a(str, str2, Boolean.class, Boolean.valueOf(z))).booleanValue();
    }

    /* renamed from: b */
    private static synchronized SharedPreferences m1774b(String str) {
        synchronized (za.class) {
            if (sa.f1380f == null) {
                return null;
            }
            SharedPreferences sharedPreferences = sa.f1380f.getSharedPreferences(str, 0);
            return sharedPreferences;
        }
    }

    /* renamed from: b */
    public static void m1775b() {
        f1417c.m1765a();
    }

    /* renamed from: b */
    public static void m1776b(String str, String str2, long j) {
        m1772a(str, str2, Long.valueOf(j));
    }

    /* renamed from: b */
    public static void m1777b(String str, String str2, String str3) {
        m1772a(str, str2, (Object) str3);
    }

    /* renamed from: b */
    public static void m1778b(String str, String str2, boolean z) {
        m1772a(str, str2, Boolean.valueOf(z));
    }
}
