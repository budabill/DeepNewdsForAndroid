package io.gonative.android;

import android.webkit.GeolocationPermissions.Callback;
import io.gonative.android.MainActivity.C0677b;

/* renamed from: io.gonative.android.i */
class C0885i implements C0677b {
    /* renamed from: a */
    final /* synthetic */ Callback f1875a;
    /* renamed from: b */
    final /* synthetic */ String f1876b;
    /* renamed from: c */
    final /* synthetic */ C0718k f1877c;

    C0885i(C0718k c0718k, Callback callback, String str) {
        this.f1877c = c0718k;
        this.f1875a = callback;
        this.f1876b = str;
    }

    /* renamed from: a */
    public void mo1399a(boolean z) {
        this.f1875a.invoke(this.f1876b, z, z);
    }
}
