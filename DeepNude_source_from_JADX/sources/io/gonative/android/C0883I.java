package io.gonative.android;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Handler;
import com.facebook.applinks.C0435b;
import com.facebook.applinks.C0435b.C0434a;

/* renamed from: io.gonative.android.I */
class C0883I implements C0434a {
    /* renamed from: a */
    final /* synthetic */ MainActivity f1864a;

    C0883I(MainActivity mainActivity) {
        this.f1864a = mainActivity;
    }

    /* renamed from: a */
    public void mo1400a(C0435b c0435b) {
        if (c0435b != null) {
            Uri a = c0435b.m832a();
            if (a != null) {
                String uri;
                String str = ".http";
                String str2 = ".https";
                if (!a.getScheme().endsWith(str)) {
                    if (a.getScheme().endsWith(str2)) {
                    }
                    uri = a.toString();
                    if (uri != null) {
                        new Handler(this.f1864a.getMainLooper()).post(new C0671H(this, uri));
                    }
                }
                Builder buildUpon = a.buildUpon();
                if (a.getScheme().endsWith(str2)) {
                    uri = "https";
                } else {
                    if (a.getScheme().endsWith(str)) {
                        uri = "http";
                    }
                    a = buildUpon.build();
                    uri = a.toString();
                    if (uri != null) {
                        new Handler(this.f1864a.getMainLooper()).post(new C0671H(this, uri));
                    }
                }
                buildUpon.scheme(uri);
                a = buildUpon.build();
                uri = a.toString();
                if (uri != null) {
                    new Handler(this.f1864a.getMainLooper()).post(new C0671H(this, uri));
                }
            }
        }
    }
}
