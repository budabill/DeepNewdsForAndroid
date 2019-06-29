package p000a.p001a.p002a.p003a;

import java.util.concurrent.Executor;

/* renamed from: a.a.a.a.c */
public class C0734c extends C0002e {
    /* renamed from: a */
    private static volatile C0734c f1677a;
    /* renamed from: b */
    private static final Executor f1678b = new C0000a();
    /* renamed from: c */
    private static final Executor f1679c = new C0001b();
    /* renamed from: d */
    private C0002e f1680d = this.f1681e;
    /* renamed from: e */
    private C0002e f1681e = new C0735d();

    private C0734c() {
    }

    /* renamed from: b */
    public static C0734c m2004b() {
        if (f1677a != null) {
            return f1677a;
        }
        synchronized (C0734c.class) {
            if (f1677a == null) {
                f1677a = new C0734c();
            }
        }
        return f1677a;
    }

    /* renamed from: a */
    public void mo1a(Runnable runnable) {
        this.f1680d.mo1a(runnable);
    }

    /* renamed from: a */
    public boolean mo2a() {
        return this.f1680d.mo2a();
    }

    /* renamed from: b */
    public void mo3b(Runnable runnable) {
        this.f1680d.mo3b(runnable);
    }
}
