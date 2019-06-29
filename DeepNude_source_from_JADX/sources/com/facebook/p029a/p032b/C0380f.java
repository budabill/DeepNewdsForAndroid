package com.facebook.p029a.p032b;

import java.util.concurrent.TimeUnit;

/* renamed from: com.facebook.a.b.f */
class C0380f implements Runnable {
    /* renamed from: a */
    final /* synthetic */ long f613a;
    /* renamed from: b */
    final /* synthetic */ String f614b;

    C0380f(long j, String str) {
        this.f613a = j;
        this.f614b = str;
    }

    public void run() {
        if (C0382h.f621f == null) {
            C0382h.f621f = new C0397v(Long.valueOf(this.f613a), null);
        }
        C0382h.f621f.m731a(Long.valueOf(this.f613a));
        if (C0382h.f620e.get() <= 0) {
            Runnable c0379e = new C0379e(this);
            synchronized (C0382h.f619d) {
                C0382h.f618c = C0382h.f617b.schedule(c0379e, (long) C0382h.m686o(), TimeUnit.SECONDS);
            }
        }
        long j = C0382h.f624i;
        long j2 = 0;
        if (j > 0) {
            j2 = (this.f613a - j) / 1000;
        }
        C0389m.m695a(this.f614b, j2);
        C0382h.f621f.m739j();
    }
}
