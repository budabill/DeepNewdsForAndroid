package io.gonative.android;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class LeanWebView extends WebView implements C0720m {
    /* renamed from: a */
    private WebViewClient f1865a = null;
    /* renamed from: b */
    private WebChromeClient f1866b = null;
    /* renamed from: c */
    private boolean f1867c = true;
    /* renamed from: d */
    private GestureDetector f1868d;
    /* renamed from: e */
    private C0674a f1869e;
    /* renamed from: f */
    SimpleOnGestureListener f1870f = new C0727t(this);

    /* renamed from: io.gonative.android.LeanWebView$a */
    public interface C0674a {
        /* renamed from: a */
        void mo1815a();

        /* renamed from: b */
        void mo1816b();
    }

    public LeanWebView(Context context) {
        super(context);
        this.f1868d = new GestureDetector(context, this.f1870f);
    }

    public LeanWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1868d = new GestureDetector(context, this.f1870f);
    }

    public LeanWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1868d = new GestureDetector(context, this.f1870f);
    }

    /* renamed from: b */
    public static boolean m2363b() {
        return false;
    }

    /* renamed from: a */
    public void mo1401a(Bundle bundle) {
        saveState(bundle);
    }

    /* renamed from: a */
    public void mo1402a(String str) {
        if (VERSION.SDK_INT < 19) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("javascript:");
            stringBuilder.append(str);
            mo1404b(stringBuilder.toString());
            return;
        }
        evaluateJavascript(str, null);
    }

    /* renamed from: a */
    public boolean mo1403a() {
        WebChromeClient webChromeClient = this.f1866b;
        return (webChromeClient == null || !(webChromeClient instanceof C0718k)) ? false : ((C0718k) webChromeClient).m1931a();
    }

    /* renamed from: b */
    public void m2367b(Bundle bundle) {
        restoreState(bundle);
    }

    /* renamed from: b */
    public void mo1404b(String str) {
        super.loadUrl(str);
    }

    public C0674a getOnSwipeListener() {
        return this.f1869e;
    }

    public void goBack() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r2 = this;
        r0 = r2.copyBackForwardList();	 Catch:{ Exception -> 0x001f }
        r1 = r0.getCurrentIndex();	 Catch:{ Exception -> 0x001f }
        r1 = r1 + -1;	 Catch:{ Exception -> 0x001f }
        r0 = r0.getItemAtIndex(r1);	 Catch:{ Exception -> 0x001f }
        r1 = r2.f1865a;	 Catch:{ Exception -> 0x001f }
        r0 = r0.getUrl();	 Catch:{ Exception -> 0x001f }
        r0 = r1.shouldOverrideUrlLoading(r2, r0);	 Catch:{ Exception -> 0x001f }
        if (r0 == 0) goto L_0x001b;	 Catch:{ Exception -> 0x001f }
    L_0x001a:
        return;	 Catch:{ Exception -> 0x001f }
    L_0x001b:
        super.goBack();	 Catch:{ Exception -> 0x001f }
        return;
    L_0x001f:
        super.goBack();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.gonative.android.LeanWebView.goBack():void");
    }

    public void loadUrl(String str) {
        if (str != null) {
            if (str.startsWith("javascript:")) {
                mo1402a(str.substring(11));
            } else {
                WebViewClient webViewClient = this.f1865a;
                if (webViewClient == null || !webViewClient.shouldOverrideUrlLoading(this, str)) {
                    super.loadUrl(str);
                }
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f1868d.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    public void reload() {
        WebViewClient webViewClient = this.f1865a;
        if (webViewClient != null) {
            if (webViewClient instanceof C0719l) {
                if (((C0719l) webViewClient).m1937a(this, getUrl(), true)) {
                    return;
                }
            }
        }
        super.reload();
    }

    public void setCheckLoginSignup(boolean z) {
        this.f1867c = z;
    }

    public void setOnSwipeListener(C0674a c0674a) {
        this.f1869e = c0674a;
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.f1866b = webChromeClient;
        super.setWebChromeClient(webChromeClient);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        this.f1865a = webViewClient;
        super.setWebViewClient(webViewClient);
    }
}
