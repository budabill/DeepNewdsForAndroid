package io.gonative.android;

class ta implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0720m f1648a;
    /* renamed from: b */
    final /* synthetic */ String f1649b;
    /* renamed from: c */
    final /* synthetic */ wa f1650c;

    ta(wa waVar, C0720m c0720m, String str) {
        this.f1650c = waVar;
        this.f1648a = c0720m;
        this.f1649b = str;
    }

    public void run() {
        this.f1650c.f1663b.m2593a(this.f1648a, true, false);
        this.f1650c.f1663b.m2601b(this.f1649b);
    }
}
