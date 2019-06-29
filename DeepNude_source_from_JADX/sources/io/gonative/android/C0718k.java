package io.gonative.android;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import io.gonative.android.p038a.C0700a;
import java.util.ArrayList;

/* renamed from: io.gonative.android.k */
class C0718k extends WebChromeClient {
    /* renamed from: a */
    private MainActivity f1608a;
    /* renamed from: b */
    private wa f1609b;
    /* renamed from: c */
    private View f1610c;
    /* renamed from: d */
    private CustomViewCallback f1611d;
    /* renamed from: e */
    private boolean f1612e = false;

    public C0718k(MainActivity mainActivity, wa waVar) {
        this.f1608a = mainActivity;
        this.f1609b = waVar;
    }

    /* renamed from: a */
    public boolean m1931a() {
        if (!this.f1612e) {
            return false;
        }
        onHideCustomView();
        return true;
    }

    public void onCloseWindow(WebView webView) {
        if (this.f1608a.m2626r()) {
            this.f1608a.finish();
        }
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        return this.f1609b.m1999a(message);
    }

    public void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        if (C0700a.m1851a(this.f1608a).Fa) {
            this.f1608a.m2592a(new C0885i(this, callback, str));
        } else {
            callback.invoke(str, false, false);
        }
    }

    public void onHideCustomView() {
        this.f1610c = null;
        this.f1612e = false;
        RelativeLayout i = this.f1608a.m2615i();
        if (i != null) {
            i.setVisibility(4);
            i.removeAllViews();
        }
        CustomViewCallback customViewCallback = this.f1611d;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
        }
        this.f1608a.m2602b(this.f1612e);
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        Toast.makeText(this.f1608a, str2, 1).show();
        jsResult.confirm();
        return true;
    }

    @TargetApi(21)
    public void onPermissionRequest(PermissionRequest permissionRequest) {
        String[] resources = permissionRequest.getResources();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < resources.length; i++) {
            Object obj;
            if (resources[i].equals("android.webkit.resource.AUDIO_CAPTURE")) {
                arrayList.add("android.permission.RECORD_AUDIO");
                obj = "android.permission.MODIFY_AUDIO_SETTINGS";
            } else if (resources[i].equals("android.webkit.resource.VIDEO_CAPTURE")) {
                obj = "android.permission.CAMERA";
            } else {
            }
            arrayList.add(obj);
        }
        this.f1608a.m2599a((String[]) arrayList.toArray(new String[arrayList.size()]), new C0886j(this, permissionRequest));
    }

    public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
        super.onPermissionRequestCanceled(permissionRequest);
    }

    public void onReceivedTitle(WebView webView, String str) {
        this.f1608a.m2633y();
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        RelativeLayout i = this.f1608a.m2615i();
        if (i != null) {
            this.f1610c = view;
            this.f1611d = customViewCallback;
            this.f1612e = true;
            i.setVisibility(0);
            i.addView(view, new LayoutParams(-1, -1));
            this.f1608a.m2602b(this.f1612e);
        }
    }

    @TargetApi(21)
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        this.f1608a.m2603c();
        int mode = fileChooserParams.getMode();
        boolean z = false;
        if (mode != 0) {
            if (mode != 1) {
                valueCallback.onReceiveValue(null);
                return false;
            }
            z = true;
        }
        this.f1608a.m2591a((ValueCallback) valueCallback);
        return this.f1609b.m2000a(fileChooserParams.getAcceptTypes(), z);
    }
}
