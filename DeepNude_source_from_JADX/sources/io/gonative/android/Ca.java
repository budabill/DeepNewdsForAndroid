package io.gonative.android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Message;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import io.gonative.android.p038a.C0700a;
import java.io.File;

public class Ca {
    /* renamed from: a */
    private static final String f1441a = "io.gonative.android.Ca";

    /* renamed from: a */
    public static void m1802a(Context context) {
        if (VERSION.SDK_INT >= 19) {
            String str = (String) C0723p.m1949a(context).get("distribution");
            if (str == null) {
                return;
            }
            if (str.equals("debug") || str.equals("adhoc")) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
        }
    }

    /* renamed from: a */
    public static void m1803a(LeanWebView leanWebView) {
        leanWebView.setWebViewClient(null);
        leanWebView.setWebChromeClient(null);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: a */
    public static void m1804a(C0720m c0720m, Context context) {
        if (c0720m instanceof LeanWebView) {
            C0700a a = C0700a.m1851a(context);
            LeanWebView leanWebView = (LeanWebView) c0720m;
            WebSettings settings = leanWebView.getSettings();
            if (C0700a.m1851a(context).ub) {
                settings.setBuiltInZoomControls(true);
            } else {
                settings.setBuiltInZoomControls(false);
            }
            settings.setDisplayZoomControls(false);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setJavaScriptEnabled(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setMinimumFontSize(1);
            settings.setMinimumLogicalFontSize(1);
            if (VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(2);
                CookieManager.getInstance().setAcceptThirdPartyCookies(leanWebView, true);
            }
            settings.setDomStorageEnabled(true);
            settings.setAppCachePath(new File(context.getCacheDir(), "webviewAppCache").getAbsolutePath());
            settings.setAppCacheEnabled(true);
            settings.setDatabaseEnabled(true);
            settings.setSaveFormData(false);
            settings.setSavePassword(false);
            settings.setUserAgentString(a.f1541m);
            settings.setSupportMultipleWindows(a.f1549u);
            settings.setGeolocationEnabled(a.Fa);
            if (VERSION.SDK_INT >= 17) {
                settings.setMediaPlaybackRequiresUserGesture(false);
            }
            return;
        }
        String str = f1441a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected webview to be of class LeanWebView and not ");
        stringBuilder.append(c0720m.getClass().getName());
        Log.e(str, stringBuilder.toString());
    }

    /* renamed from: a */
    public static void m1805a(C0720m c0720m, MainActivity mainActivity) {
        if (c0720m instanceof LeanWebView) {
            C0720m c0720m2 = (LeanWebView) c0720m;
            m1804a(c0720m2, (Context) mainActivity);
            wa waVar = new wa(mainActivity);
            waVar.m2001b(c0720m.getUrl());
            c0720m2.setWebChromeClient(new C0718k(mainActivity, waVar));
            c0720m2.setWebViewClient(new C0719l(mainActivity, waVar));
            DownloadListener h = mainActivity.m2613h();
            if (h != null) {
                c0720m2.setDownloadListener(h);
            }
            C0691V k = mainActivity.m2619k();
            String str = "gonative_profile_picker";
            c0720m2.removeJavascriptInterface(str);
            if (k != null) {
                c0720m2.addJavascriptInterface(k.m1832a(), str);
            }
            String str2 = "gonative_status_checker";
            c0720m2.removeJavascriptInterface(str2);
            c0720m2.addJavascriptInterface(mainActivity.m2620l(), str2);
            if (mainActivity.getIntent().getBooleanExtra("io.gonative.android.MainActivity.Extra.WEBVIEW_WINDOW_OPEN", false)) {
                Message d = ((GoNativeApplication) mainActivity.getApplication()).m1815d();
                if (d != null) {
                    WebViewTransport webViewTransport = (WebViewTransport) d.obj;
                    if (webViewTransport != null) {
                        webViewTransport.setWebView(c0720m2);
                        d.sendToTarget();
                    }
                }
            }
            return;
        }
        String str3 = f1441a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected webview to be of class LeanWebView and not ");
        stringBuilder.append(c0720m.getClass().getName());
        Log.e(str3, stringBuilder.toString());
    }
}
