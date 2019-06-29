package io.gonative.android;

/* renamed from: io.gonative.android.E */
class C0670E implements Runnable {
    /* renamed from: a */
    final /* synthetic */ MainActivity f1444a;

    C0670E(MainActivity mainActivity) {
        this.f1444a = mainActivity;
    }

    public void run() {
        this.f1444a.runOnUiThread(new C0730v(this));
        this.f1444a.f2010D.postDelayed(this.f1444a.f2011E, 100);
    }
}
