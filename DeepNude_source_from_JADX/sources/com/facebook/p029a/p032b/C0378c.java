package com.facebook.p029a.p032b;

/* renamed from: com.facebook.a.b.c */
class C0378c implements Runnable {
    /* renamed from: a */
    final /* synthetic */ long f610a;
    /* renamed from: b */
    final /* synthetic */ String f611b;

    C0378c(long j, String str) {
        this.f610a = j;
        this.f611b = str;
    }

    public void run() {
        if (C0382h.f621f == null) {
            C0382h.f621f = new C0397v(Long.valueOf(this.f610a), null);
            C0398w.m743a(this.f611b, null, C0382h.f623h);
        } else if (C0382h.f621f.m735e() != null) {
            long longValue = this.f610a - C0382h.f621f.m735e().longValue();
            if (longValue > ((long) (C0382h.m686o() * 1000))) {
                C0398w.m742a(this.f611b, C0382h.f621f, C0382h.f623h);
                C0398w.m743a(this.f611b, null, C0382h.f623h);
                C0382h.f621f = new C0397v(Long.valueOf(this.f610a), null);
            } else if (longValue > 1000) {
                C0382h.f621f.m738i();
            }
        }
        C0382h.f621f.m731a(Long.valueOf(this.f610a));
        C0382h.f621f.m739j();
    }
}
