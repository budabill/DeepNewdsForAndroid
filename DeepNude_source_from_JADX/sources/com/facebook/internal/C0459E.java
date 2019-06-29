package com.facebook.internal;

import java.util.concurrent.Callable;

/* renamed from: com.facebook.internal.E */
class C0459E implements Callable<Void> {
    /* renamed from: a */
    final /* synthetic */ Callable f802a;
    /* renamed from: b */
    final /* synthetic */ C0460F f803b;

    C0459E(C0460F c0460f, Callable callable) {
        this.f803b = c0460f;
        this.f802a = callable;
    }

    public Void call() {
        try {
            this.f803b.f804a = this.f802a.call();
            return null;
        } finally {
            this.f803b.f805b.countDown();
        }
    }
}
