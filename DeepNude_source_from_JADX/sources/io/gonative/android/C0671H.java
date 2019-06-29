package io.gonative.android;

/* renamed from: io.gonative.android.H */
class C0671H implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f1453a;
    /* renamed from: b */
    final /* synthetic */ C0883I f1454b;

    C0671H(C0883I c0883i, String str) {
        this.f1454b = c0883i;
        this.f1453a = str;
    }

    public void run() {
        this.f1454b.f1864a.f2030a.loadUrl(this.f1453a);
    }
}
