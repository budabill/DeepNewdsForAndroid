package com.facebook.internal;

import com.facebook.C0560t;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;

/* renamed from: com.facebook.internal.F */
public class C0460F<T> {
    /* renamed from: a */
    private T f804a;
    /* renamed from: b */
    private CountDownLatch f805b = new CountDownLatch(1);

    public C0460F(Callable<T> callable) {
        C0560t.m1258j().execute(new FutureTask(new C0459E(this, callable)));
    }
}
