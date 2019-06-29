package io.gonative.android;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Handler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import io.gonative.android.Aa.C0666a;

/* renamed from: io.gonative.android.S */
public class C0685S extends WebViewClient {
    /* renamed from: a */
    private C0666a f1468a;

    public C0685S(C0666a c0666a, LeanWebView leanWebView) {
        this.f1468a = c0666a;
        leanWebView.setWebViewClient(this);
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        new Handler(webView.getContext().getMainLooper()).post(new C0684Q(this, webView));
        this.f1468a.m1780b((C0720m) webView, str);
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
        return this.f1468a.m1779a((C0720m) webView, str);
    }
}
