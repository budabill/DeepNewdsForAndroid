package p000a.p005b.p007b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.BundleCompat;
import android.support.v4.content.ContextCompat;
import java.util.ArrayList;

/* renamed from: a.b.b.i */
public final class C0024i {
    /* renamed from: a */
    public final Intent f31a;
    /* renamed from: b */
    public final Bundle f32b;

    /* renamed from: a.b.b.i$a */
    public static final class C0023a {
        /* renamed from: a */
        private final Intent f26a;
        /* renamed from: b */
        private ArrayList<Bundle> f27b;
        /* renamed from: c */
        private Bundle f28c;
        /* renamed from: d */
        private ArrayList<Bundle> f29d;
        /* renamed from: e */
        private boolean f30e;

        public C0023a() {
            this(null);
        }

        public C0023a(C0026l c0026l) {
            this.f26a = new Intent("android.intent.action.VIEW");
            IBinder iBinder = null;
            this.f27b = null;
            this.f28c = null;
            this.f29d = null;
            this.f30e = true;
            if (c0026l != null) {
                this.f26a.setPackage(c0026l.m24b().getPackageName());
            }
            Bundle bundle = new Bundle();
            if (c0026l != null) {
                iBinder = c0026l.m22a();
            }
            BundleCompat.putBinder(bundle, "android.support.customtabs.extra.SESSION", iBinder);
            this.f26a.putExtras(bundle);
        }

        /* renamed from: a */
        public C0024i m19a() {
            ArrayList arrayList = this.f27b;
            if (arrayList != null) {
                this.f26a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            arrayList = this.f29d;
            if (arrayList != null) {
                this.f26a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList);
            }
            this.f26a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f30e);
            return new C0024i(this.f26a, this.f28c);
        }
    }

    C0024i(Intent intent, Bundle bundle) {
        this.f31a = intent;
        this.f32b = bundle;
    }

    /* renamed from: a */
    public void m20a(Context context, Uri uri) {
        this.f31a.setData(uri);
        ContextCompat.startActivity(context, this.f31a, this.f32b);
    }
}
