package com.onesignal;

import java.lang.reflect.Method;

/* renamed from: com.onesignal.T */
class C0607T implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Method f1208a;
    /* renamed from: b */
    final /* synthetic */ Object f1209b;
    /* renamed from: c */
    final /* synthetic */ Object f1210c;
    /* renamed from: d */
    final /* synthetic */ C0608U f1211d;

    C0607T(C0608U c0608u, Method method, Object obj, Object obj2) {
        this.f1211d = c0608u;
        this.f1208a = method;
        this.f1209b = obj;
        this.f1210c = obj2;
    }

    public void run() {
        try {
            this.f1208a.invoke(this.f1209b, new Object[]{this.f1210c});
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
