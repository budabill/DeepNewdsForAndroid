package android.arch.lifecycle;

import android.arch.lifecycle.C0053a.C0051a;
import android.arch.lifecycle.C0058d.C0056a;

class ReflectiveGenericLifecycleObserver implements GenericLifecycleObserver {
    /* renamed from: a */
    private final Object f1930a;
    /* renamed from: b */
    private final C0051a f1931b = C0053a.f99a.m91a(this.f1930a.getClass());

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f1930a = obj;
    }

    /* renamed from: a */
    public void mo1442a(C0060f c0060f, C0056a c0056a) {
        this.f1931b.m86a(c0060f, c0056a, this.f1930a);
    }
}
