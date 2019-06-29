package com.facebook;

import com.facebook.AccessToken.C0327a;
import com.facebook.C0330C.C0329a;
import com.facebook.C0450g.C0449a;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.f */
class C0828f implements C0329a {
    /* renamed from: a */
    final /* synthetic */ AccessToken f1761a;
    /* renamed from: b */
    final /* synthetic */ C0327a f1762b;
    /* renamed from: c */
    final /* synthetic */ AtomicBoolean f1763c;
    /* renamed from: d */
    final /* synthetic */ C0449a f1764d;
    /* renamed from: e */
    final /* synthetic */ Set f1765e;
    /* renamed from: f */
    final /* synthetic */ Set f1766f;
    /* renamed from: g */
    final /* synthetic */ C0450g f1767g;

    C0828f(C0450g c0450g, AccessToken accessToken, C0327a c0327a, AtomicBoolean atomicBoolean, C0449a c0449a, Set set, Set set2) {
        this.f1767g = c0450g;
        this.f1761a = accessToken;
        this.f1762b = c0327a;
        this.f1763c = atomicBoolean;
        this.f1764d = c0449a;
        this.f1765e = set;
        this.f1766f = set2;
    }

    /* renamed from: a */
    public void mo953a(C0330C c0330c) {
        Throwable th;
        AccessToken accessToken;
        C0327a c0327a;
        C0828f c0828f = this;
        try {
            C0327a c0327a2;
            if (C0450g.m858d().m865c() != null) {
                if (C0450g.m858d().m865c().m457k() == c0828f.f1761a.m457k()) {
                    if (!c0828f.f1763c.get() && c0828f.f1764d.f764a == null && c0828f.f1764d.f765b == 0) {
                        if (c0828f.f1762b != null) {
                            c0828f.f1762b.m438a(new C0506l("Failed to refresh access token"));
                        }
                        c0828f.f1767g.f771e.set(false);
                        c0327a2 = c0828f.f1762b;
                        return;
                    }
                    AccessToken accessToken2 = new AccessToken(c0828f.f1764d.f764a != null ? c0828f.f1764d.f764a : c0828f.f1761a.m456j(), c0828f.f1761a.m449b(), c0828f.f1761a.m457k(), c0828f.f1763c.get() ? c0828f.f1765e : c0828f.f1761a.m454h(), c0828f.f1763c.get() ? c0828f.f1766f : c0828f.f1761a.m451e(), c0828f.f1761a.m455i(), c0828f.f1764d.f765b != 0 ? new Date(((long) c0828f.f1764d.f765b) * 1000) : c0828f.f1761a.m452f(), new Date(), c0828f.f1764d.f766c != null ? new Date(1000 * c0828f.f1764d.f766c.longValue()) : c0828f.f1761a.m450d());
                    try {
                        C0450g.m858d().m863a(accessToken2);
                        c0828f.f1767g.f771e.set(false);
                        c0327a2 = c0828f.f1762b;
                        if (c0327a2 != null) {
                            c0327a2.m437a(accessToken2);
                        }
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        accessToken = accessToken2;
                        c0828f.f1767g.f771e.set(false);
                        c0327a = c0828f.f1762b;
                        c0327a.m437a(accessToken);
                        throw th;
                    }
                }
            }
            if (c0828f.f1762b != null) {
                c0828f.f1762b.m438a(new C0506l("No current access token to refresh"));
            }
            c0828f.f1767g.f771e.set(false);
            c0327a2 = c0828f.f1762b;
        } catch (Throwable th3) {
            th = th3;
            accessToken = null;
            c0828f.f1767g.f771e.set(false);
            c0327a = c0828f.f1762b;
            if (!(c0327a == null || accessToken == null)) {
                c0327a.m437a(accessToken);
            }
            throw th;
        }
    }
}
