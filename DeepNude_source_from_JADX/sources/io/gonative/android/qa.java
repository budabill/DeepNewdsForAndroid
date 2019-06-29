package io.gonative.android;

class qa implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f1632a;
    /* renamed from: b */
    final /* synthetic */ wa f1633b;

    qa(wa waVar, String str) {
        this.f1633b = waVar;
        this.f1632a = str;
    }

    public void run() {
        this.f1633b.f1663b.setTitle(this.f1632a);
    }
}
