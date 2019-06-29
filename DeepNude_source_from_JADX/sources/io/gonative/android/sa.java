package io.gonative.android;

class sa implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0720m f1644a;
    /* renamed from: b */
    final /* synthetic */ String f1645b;
    /* renamed from: c */
    final /* synthetic */ wa f1646c;

    sa(wa waVar, C0720m c0720m, String str) {
        this.f1646c = waVar;
        this.f1644a = c0720m;
        this.f1645b = str;
    }

    public void run() {
        this.f1646c.f1663b.m2593a(this.f1644a, true, false);
        this.f1646c.f1663b.m2601b(this.f1645b);
    }
}
