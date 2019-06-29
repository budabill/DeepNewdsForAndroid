package p000a.p005b.p007b;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import p000a.p005b.p007b.C0027m.C0740a;

/* renamed from: a.b.b.g */
class C0890g extends C0740a {
    /* renamed from: a */
    private Handler f1894a = new Handler(Looper.getMainLooper());
    /* renamed from: b */
    final /* synthetic */ C0016a f1895b;
    /* renamed from: c */
    final /* synthetic */ C0022h f1896c;

    C0890g(C0022h c0022h, C0016a c0016a) {
        this.f1896c = c0022h;
        this.f1895b = c0016a;
    }

    /* renamed from: a */
    public void mo1419a(int i, Uri uri, boolean z, Bundle bundle) {
        if (this.f1895b != null) {
            this.f1894a.post(new C0021f(this, i, uri, z, bundle));
        }
    }

    /* renamed from: a */
    public void mo1420a(int i, Bundle bundle) {
        if (this.f1895b != null) {
            this.f1894a.post(new C0017b(this, i, bundle));
        }
    }

    /* renamed from: a */
    public void mo1421a(Bundle bundle) {
        if (this.f1895b != null) {
            this.f1894a.post(new C0019d(this, bundle));
        }
    }

    /* renamed from: a */
    public void mo1422a(String str, Bundle bundle) {
        if (this.f1895b != null) {
            this.f1894a.post(new C0018c(this, str, bundle));
        }
    }

    /* renamed from: b */
    public void mo1423b(String str, Bundle bundle) {
        if (this.f1895b != null) {
            this.f1894a.post(new C0020e(this, str, bundle));
        }
    }
}
