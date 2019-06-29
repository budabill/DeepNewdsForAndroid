package io.gonative.android;

import android.webkit.WebView;

/* renamed from: io.gonative.android.Q */
class C0684Q implements Runnable {
    /* renamed from: a */
    final /* synthetic */ WebView f1466a;
    /* renamed from: b */
    final /* synthetic */ C0685S f1467b;

    C0684Q(C0685S c0685s, WebView webView) {
        this.f1467b = c0685s;
        this.f1466a = webView;
    }

    public void run() {
        this.f1466a.setWebViewClient(null);
    }
}
