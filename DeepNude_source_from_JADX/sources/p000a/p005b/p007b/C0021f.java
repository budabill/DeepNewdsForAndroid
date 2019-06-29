package p000a.p005b.p007b;

import android.net.Uri;
import android.os.Bundle;

/* renamed from: a.b.b.f */
class C0021f implements Runnable {
    /* renamed from: a */
    final /* synthetic */ int f19a;
    /* renamed from: b */
    final /* synthetic */ Uri f20b;
    /* renamed from: c */
    final /* synthetic */ boolean f21c;
    /* renamed from: d */
    final /* synthetic */ Bundle f22d;
    /* renamed from: e */
    final /* synthetic */ C0890g f23e;

    C0021f(C0890g c0890g, int i, Uri uri, boolean z, Bundle bundle) {
        this.f23e = c0890g;
        this.f19a = i;
        this.f20b = uri;
        this.f21c = z;
        this.f22d = bundle;
    }

    public void run() {
        this.f23e.f1895b.m11a(this.f19a, this.f20b, this.f21c, this.f22d);
    }
}
