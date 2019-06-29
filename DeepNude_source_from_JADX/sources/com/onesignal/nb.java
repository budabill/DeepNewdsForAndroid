package com.onesignal;

import android.os.Handler;
import android.os.HandlerThread;
import com.onesignal.C0582B.C0581f;
import com.onesignal.sa.C0643b;
import com.onesignal.sa.C0650i;
import com.onesignal.sa.C0655n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

abstract class nb {
    /* renamed from: a */
    protected final Object f1283a = new ib(this);
    /* renamed from: b */
    private AtomicBoolean f1284b = new AtomicBoolean();
    /* renamed from: c */
    private ArrayList<C0643b> f1285c = new ArrayList();
    /* renamed from: d */
    HashMap<Integer, C0635b> f1286d = new HashMap();
    /* renamed from: e */
    private final Object f1287e = new jb(this);
    /* renamed from: f */
    protected boolean f1288f = false;
    /* renamed from: g */
    protected boolean f1289g = false;
    /* renamed from: h */
    protected cb f1290h;
    /* renamed from: i */
    protected cb f1291i;

    /* renamed from: com.onesignal.nb$a */
    static class C0634a {
        /* renamed from: a */
        boolean f1277a;
        /* renamed from: b */
        JSONObject f1278b;

        C0634a(boolean z, JSONObject jSONObject) {
            this.f1277a = z;
            this.f1278b = jSONObject;
        }
    }

    /* renamed from: com.onesignal.nb$b */
    class C0635b extends HandlerThread {
        /* renamed from: a */
        int f1279a;
        /* renamed from: b */
        Handler f1280b = null;
        /* renamed from: c */
        int f1281c;
        /* renamed from: d */
        final /* synthetic */ nb f1282d;

        C0635b(nb nbVar, int i) {
            this.f1282d = nbVar;
            super("OSH_NetworkHandlerThread");
            this.f1279a = i;
            start();
            this.f1280b = new Handler(getLooper());
        }

        /* renamed from: c */
        private Runnable m1530c() {
            return this.f1279a != 0 ? null : new ob(this);
        }

        /* renamed from: a */
        boolean m1531a() {
            boolean hasMessages;
            synchronized (this.f1280b) {
                Object obj = this.f1281c < 3 ? 1 : null;
                boolean hasMessages2 = this.f1280b.hasMessages(0);
                if (!(obj == null || hasMessages2)) {
                    this.f1281c++;
                    this.f1280b.postDelayed(m1530c(), (long) (this.f1281c * 15000));
                }
                hasMessages = this.f1280b.hasMessages(0);
            }
            return hasMessages;
        }

        /* renamed from: b */
        void m1532b() {
            synchronized (this.f1280b) {
                this.f1281c = 0;
                this.f1280b.removeCallbacksAndMessages(null);
                this.f1280b.postDelayed(m1530c(), 5000);
            }
        }
    }

    nb() {
    }

    /* renamed from: a */
    private void m1534a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        String str2;
        if (str == null) {
            str2 = "players";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("players/");
            stringBuilder.append(str);
            stringBuilder.append("/on_session");
            str2 = stringBuilder.toString();
        }
        this.f1289g = true;
        mo1377a(jSONObject);
        Ga.m1330b(str2, jSONObject, new mb(this, jSONObject2, jSONObject, str));
    }

    /* renamed from: a */
    private boolean m1535a(int i, String str, String str2) {
        String str3 = "errors";
        boolean z = false;
        if (i == 400 && str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(str3) && jSONObject.optString(str3).contains(str2)) {
                    z = true;
                }
                return z;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m1538b(String str) {
        String str2 = "app_id";
        String str3 = "parent_player_id";
        String str4 = "email_auth_hash";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("players/");
        stringBuilder.append(str);
        stringBuilder.append("/email_logout");
        str = stringBuilder.toString();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = this.f1290h.f1269e;
            if (jSONObject2.has(str4)) {
                jSONObject.put(str4, jSONObject2.optString(str4));
            }
            JSONObject jSONObject3 = this.f1290h.f1270f;
            if (jSONObject3.has(str3)) {
                jSONObject.put(str3, jSONObject3.optString(str3));
            }
            jSONObject.put(str2, jSONObject3.optString(str2));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Ga.m1330b(str, jSONObject, new kb(this));
    }

    /* renamed from: b */
    private void m1539b(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        if (str == null) {
            Iterator it = this.f1285c.iterator();
            while (it.hasNext()) {
                C0643b c0643b = (C0643b) it.next();
                if (c0643b != null) {
                    c0643b.m1607a(new C0655n(-1, "Unable to update tags: the current user is not registered with OneSignal"));
                }
            }
            this.f1285c.clear();
            return;
        }
        ArrayList arrayList = (ArrayList) this.f1285c.clone();
        this.f1285c.clear();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("players/");
        stringBuilder.append(str);
        Ga.m1334d(stringBuilder.toString(), jSONObject, new lb(this, jSONObject, arrayList, jSONObject2));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private void m1540b(boolean r8) {
        /*
        r7 = this;
        r0 = r7.mo1375a();
        r1 = r7.m1547n();
        if (r1 == 0) goto L_0x0010;
    L_0x000a:
        if (r0 == 0) goto L_0x0010;
    L_0x000c:
        r7.m1538b(r0);
        return;
    L_0x0010:
        r1 = r7.f1290h;
        if (r1 != 0) goto L_0x0017;
    L_0x0014:
        r7.m1563e();
    L_0x0017:
        r1 = r7.m1545l();
        r2 = r7.f1283a;
        monitor-enter(r2);
        r3 = r7.f1290h;	 Catch:{ all -> 0x0079 }
        r4 = r7.m1559c();	 Catch:{ all -> 0x0079 }
        r3 = r3.m1510a(r4, r1);	 Catch:{ all -> 0x0079 }
        r4 = r7.f1290h;	 Catch:{ all -> 0x0079 }
        r4 = r4.f1269e;	 Catch:{ all -> 0x0079 }
        r5 = r7.m1559c();	 Catch:{ all -> 0x0079 }
        r5 = r5.f1269e;	 Catch:{ all -> 0x0079 }
        r6 = 0;
        r4 = r7.m1551a(r4, r5, r6, r6);	 Catch:{ all -> 0x0079 }
        if (r3 != 0) goto L_0x0064;
    L_0x0039:
        r8 = r7.f1290h;	 Catch:{ all -> 0x0079 }
        r8.m1515b(r4, r6);	 Catch:{ all -> 0x0079 }
        r8 = r7.f1285c;	 Catch:{ all -> 0x0079 }
        r8 = r8.iterator();	 Catch:{ all -> 0x0079 }
    L_0x0044:
        r0 = r8.hasNext();	 Catch:{ all -> 0x0079 }
        if (r0 == 0) goto L_0x005d;
    L_0x004a:
        r0 = r8.next();	 Catch:{ all -> 0x0079 }
        r0 = (com.onesignal.sa.C0643b) r0;	 Catch:{ all -> 0x0079 }
        if (r0 == 0) goto L_0x0044;
    L_0x0052:
        r1 = 0;
        r1 = com.onesignal.Ha.m1336a(r1);	 Catch:{ all -> 0x0079 }
        r1 = r1.f1278b;	 Catch:{ all -> 0x0079 }
        r0.m1608a(r1);	 Catch:{ all -> 0x0079 }
        goto L_0x0044;
    L_0x005d:
        r8 = r7.f1285c;	 Catch:{ all -> 0x0079 }
        r8.clear();	 Catch:{ all -> 0x0079 }
        monitor-exit(r2);	 Catch:{ all -> 0x0079 }
        return;
    L_0x0064:
        r5 = r7.m1559c();	 Catch:{ all -> 0x0079 }
        r5.m1517c();	 Catch:{ all -> 0x0079 }
        monitor-exit(r2);	 Catch:{ all -> 0x0079 }
        if (r1 == 0) goto L_0x0075;
    L_0x006e:
        if (r8 == 0) goto L_0x0071;
    L_0x0070:
        goto L_0x0075;
    L_0x0071:
        r7.m1534a(r0, r3, r4);
        goto L_0x0078;
    L_0x0075:
        r7.m1539b(r0, r3, r4);
    L_0x0078:
        return;
    L_0x0079:
        r8 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0079 }
        goto L_0x007d;
    L_0x007c:
        throw r8;
    L_0x007d:
        goto L_0x007c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.nb.b(boolean):void");
    }

    /* renamed from: j */
    private void mo1381j() {
        if (!m1549a(Integer.valueOf(0)).m1531a()) {
            JSONObject a = this.f1290h.m1510a(this.f1291i, false);
            if (a != null) {
                mo1378b(a);
            }
            if (m1559c().f1269e.optBoolean("logoutEmail", false)) {
                sa.m1617B();
            }
        }
    }

    /* renamed from: k */
    private void mo1383k() {
        sa.m1618C();
        m1565g();
        this.f1288f = true;
        mo1380h();
    }

    /* renamed from: l */
    private boolean m1545l() {
        return this.f1288f && !this.f1289g;
    }

    /* renamed from: m */
    private void m1546m() {
        m1559c().f1269e.remove("logoutEmail");
        String str = "email_auth_hash";
        this.f1291i.f1269e.remove(str);
        String str2 = "parent_player_id";
        this.f1291i.f1270f.remove(str2);
        this.f1291i.m1517c();
        this.f1290h.f1269e.remove(str);
        this.f1290h.f1270f.remove(str2);
        str = "email";
        String optString = this.f1290h.f1270f.optString(str);
        this.f1290h.f1270f.remove(str);
        Ha.m1352k();
        C0650i c0650i = C0650i.INFO;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Device successfully logged out of email: ");
        stringBuilder.append(optString);
        sa.m1656a(c0650i, stringBuilder.toString());
        sa.m1618C();
    }

    /* renamed from: n */
    private boolean m1547n() {
        return m1559c().f1269e.optBoolean("logoutEmail", false);
    }

    /* renamed from: a */
    protected abstract cb mo1374a(String str, boolean z);

    /* renamed from: a */
    protected C0635b m1549a(Integer num) {
        C0635b c0635b;
        synchronized (this.f1287e) {
            if (!this.f1286d.containsKey(num)) {
                this.f1286d.put(num, new C0635b(this, num.intValue()));
            }
            c0635b = (C0635b) this.f1286d.get(num);
        }
        return c0635b;
    }

    /* renamed from: a */
    protected abstract String mo1375a();

    /* renamed from: a */
    protected JSONObject m1551a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, Set<String> set) {
        synchronized (this.f1283a) {
            jSONObject = C0662y.m1760a(jSONObject, jSONObject2, jSONObject3, (Set) set);
        }
        return jSONObject;
    }

    /* renamed from: a */
    void m1552a(C0581f c0581f) {
        m1561d().m1512a(c0581f);
    }

    /* renamed from: a */
    abstract void mo1376a(String str);

    /* renamed from: a */
    protected abstract void mo1377a(JSONObject jSONObject);

    /* renamed from: a */
    void m1555a(JSONObject jSONObject, C0643b c0643b) {
        this.f1285c.add(c0643b);
        JSONObject jSONObject2 = m1561d().f1270f;
        m1551a(jSONObject2, jSONObject, jSONObject2, null);
    }

    /* renamed from: a */
    void m1556a(boolean z) {
        this.f1284b.set(true);
        m1540b(z);
        this.f1284b.set(false);
    }

    /* renamed from: b */
    String m1557b() {
        return m1559c().f1270f.optString("identifier", null);
    }

    /* renamed from: b */
    protected abstract void mo1378b(JSONObject jSONObject);

    /* renamed from: c */
    protected cb m1559c() {
        synchronized (this.f1283a) {
            if (this.f1291i == null) {
                this.f1291i = mo1374a("TOSYNC_STATE", true);
            }
        }
        return this.f1291i;
    }

    /* renamed from: c */
    protected abstract void mo1379c(JSONObject jSONObject);

    /* renamed from: d */
    protected cb m1561d() {
        if (this.f1291i == null) {
            this.f1291i = this.f1290h.m1509a("TOSYNC_STATE");
        }
        mo1380h();
        return this.f1291i;
    }

    /* renamed from: d */
    void m1562d(JSONObject jSONObject) {
        JSONObject jSONObject2 = m1561d().f1270f;
        m1551a(jSONObject2, jSONObject, jSONObject2, null);
    }

    /* renamed from: e */
    void m1563e() {
        synchronized (this.f1283a) {
            if (this.f1290h == null) {
                this.f1290h = mo1374a("CURRENT_STATE", true);
            }
        }
        m1559c();
    }

    /* renamed from: f */
    boolean m1564f() {
        boolean z = false;
        if (this.f1291i == null) {
            return false;
        }
        synchronized (this.f1283a) {
            if (this.f1290h.m1510a(this.f1291i, m1545l()) != null) {
                z = true;
            }
            this.f1291i.m1517c();
        }
        return z;
    }

    /* renamed from: g */
    void m1565g() {
        this.f1290h.f1270f = new JSONObject();
        this.f1290h.m1517c();
    }

    /* renamed from: h */
    protected abstract void mo1380h();

    /* renamed from: i */
    void m1567i() {
        this.f1288f = true;
    }
}
