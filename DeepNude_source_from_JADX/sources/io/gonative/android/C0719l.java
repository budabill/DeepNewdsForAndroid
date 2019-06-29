package io.gonative.android;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* renamed from: io.gonative.android.l */
public class C0719l extends WebViewClient {
    /* renamed from: a */
    private wa f1617a;
    /* renamed from: b */
    private Context f1618b;

    public C0719l(MainActivity mainActivity, wa waVar) {
        this.f1617a = waVar;
        this.f1618b = mainActivity;
    }

    /* renamed from: a */
    public boolean m1937a(WebView webView, String str, boolean z) {
        return this.f1617a.m2003b((C0720m) webView, str, z);
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        this.f1617a.m1997a((C0720m) webView, str, z);
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f1617a.m1996a((C0720m) webView, str);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.f1617a.m1998a(str);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.f1617a.m1995a((C0720m) webView, i);
    }

    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        this.f1617a.m1995a((C0720m) webView, webResourceError.getErrorCode());
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        sslErrorHandler.cancel();
        this.f1617a.m1994a(sslError);
    }

    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        String method = webResourceRequest.getMethod();
        if (method != null) {
            if (method.equalsIgnoreCase("GET")) {
                Uri url = webResourceRequest.getUrl();
                if (url != null) {
                    if (url.getScheme().startsWith("http")) {
                        return shouldInterceptRequest(webView, url.toString());
                    }
                }
            }
        }
        return null;
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return this.f1617a.m1993a((LeanWebView) webView, str);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return this.f1617a.m2002b((C0720m) webView, str);
    }
}
