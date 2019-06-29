package android.arch.lifecycle;

import android.arch.lifecycle.C0058d.C0056a;

class FullLifecycleObserverAdapter implements GenericLifecycleObserver {
    /* renamed from: a */
    private final FullLifecycleObserver f1927a;

    FullLifecycleObserverAdapter(FullLifecycleObserver fullLifecycleObserver) {
        this.f1927a = fullLifecycleObserver;
    }

    /* renamed from: a */
    public void mo1442a(C0060f c0060f, C0056a c0056a) {
        switch (C0054b.f102a[c0056a.ordinal()]) {
            case 1:
                this.f1927a.m2033d(c0060f);
                return;
            case 2:
                this.f1927a.m2030a(c0060f);
                return;
            case 3:
                this.f1927a.m2034e(c0060f);
                return;
            case 4:
                this.f1927a.m2031b(c0060f);
                return;
            case 5:
                this.f1927a.m2035f(c0060f);
                return;
            case 6:
                this.f1927a.m2032c(c0060f);
                return;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
