package com.facebook;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.facebook.p */
class C0541p implements ThreadFactory {
    /* renamed from: a */
    private final AtomicInteger f1040a = new AtomicInteger(0);

    C0541p() {
    }

    public Thread newThread(Runnable runnable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FacebookSdk #");
        stringBuilder.append(this.f1040a.incrementAndGet());
        return new Thread(runnable, stringBuilder.toString());
    }
}
