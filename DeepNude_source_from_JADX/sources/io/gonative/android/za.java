package io.gonative.android;

import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

class za implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f1675a;
    /* renamed from: b */
    final /* synthetic */ Aa f1676b;

    za(Aa aa, String str) {
        this.f1676b = aa;
        this.f1675a = str;
    }

    public void run() {
        C0720m leanWebView = new LeanWebView(this.f1676b.f1420a);
        this.f1676b.f1428i = leanWebView;
        this.f1676b.f1427h.remove(this.f1675a);
        Ca.m1804a(leanWebView, this.f1676b.f1420a);
        WindowManager windowManager = (WindowManager) this.f1676b.f1420a.getSystemService("window");
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            leanWebView.layout(0, 0, point.x, point.y);
        }
        C0685S c0685s = new C0685S(this.f1676b.f1425f, leanWebView);
        this.f1676b.f1428i = leanWebView;
        this.f1676b.f1427h.remove(this.f1675a);
        this.f1676b.f1428i.loadUrl(this.f1675a);
    }
}
