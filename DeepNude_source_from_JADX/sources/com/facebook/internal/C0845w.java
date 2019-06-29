package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import org.json.JSONObject;

/* renamed from: com.facebook.internal.w */
public class C0845w extends C0485X {
    /* renamed from: o */
    private static final String f1776o = "com.facebook.internal.w";
    /* renamed from: p */
    private boolean f1777p;

    private C0845w(Context context, String str, String str2) {
        super(context, str);
        m1058b(str2);
    }

    /* renamed from: a */
    public static C0845w m2166a(Context context, String str, String str2) {
        C0485X.m1043a(context);
        return new C0845w(context, str, str2);
    }

    /* renamed from: a */
    protected Bundle mo958a(String str) {
        Bundle d = C0475Q.m1004d(Uri.parse(str).getQuery());
        String str2 = "bridge_args";
        String string = d.getString(str2);
        d.remove(str2);
        String str3 = "Unable to parse bridge_args JSON";
        if (!C0475Q.m998b(string)) {
            try {
                d.putBundle("com.facebook.platform.protocol.BRIDGE_ARGS", C0492k.m1080a(new JSONObject(string)));
            } catch (Throwable e) {
                C0475Q.m985a(f1776o, str3, e);
            }
        }
        str2 = "method_results";
        string = d.getString(str2);
        d.remove(str2);
        if (!C0475Q.m998b(string)) {
            if (C0475Q.m998b(string)) {
                string = "{}";
            }
            try {
                d.putBundle("com.facebook.platform.protocol.RESULT_ARGS", C0492k.m1080a(new JSONObject(string)));
            } catch (Throwable e2) {
                C0475Q.m985a(f1776o, str3, e2);
            }
        }
        d.remove("version");
        d.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", C0465I.m929c());
        return d;
    }

    public void cancel() {
        WebView b = m1057b();
        if (!(!m1060d() || m1059c() || b == null)) {
            if (b.isShown()) {
                if (!this.f1777p) {
                    this.f1777p = true;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("javascript:");
                    stringBuilder.append("(function() {  var event = document.createEvent('Event');  event.initEvent('fbPlatformDialogMustClose',true,true);  document.dispatchEvent(event);})();");
                    b.loadUrl(stringBuilder.toString());
                    new Handler(Looper.getMainLooper()).postDelayed(new C0500v(this), 1500);
                    return;
                }
                return;
            }
        }
        super.cancel();
    }
}
