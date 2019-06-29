package io.gonative.android;

class ua implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0720m f1656a;
    /* renamed from: b */
    final /* synthetic */ String f1657b;
    /* renamed from: c */
    final /* synthetic */ wa f1658c;

    ua(wa waVar, C0720m c0720m, String str) {
        this.f1658c = waVar;
        this.f1656a = c0720m;
        this.f1657b = str;
    }

    public void run() {
        this.f1658c.f1663b.m2593a(this.f1656a, true, false);
        this.f1658c.f1663b.m2601b(this.f1657b);
    }
}
