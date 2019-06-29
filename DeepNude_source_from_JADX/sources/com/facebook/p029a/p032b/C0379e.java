package com.facebook.p029a.p032b;

/* renamed from: com.facebook.a.b.e */
class C0379e implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0380f f612a;

    C0379e(C0380f c0380f) {
        this.f612a = c0380f;
    }

    public void run() {
        if (C0382h.f620e.get() <= 0) {
            C0398w.m742a(this.f612a.f614b, C0382h.f621f, C0382h.f623h);
            C0397v.m729a();
            C0382h.f621f = null;
        }
        synchronized (C0382h.f619d) {
            C0382h.f618c = null;
        }
    }
}
