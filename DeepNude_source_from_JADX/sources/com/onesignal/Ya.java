package com.onesignal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.lang.reflect.Method;

class Ya implements ServiceConnection {
    /* renamed from: a */
    final /* synthetic */ ab f1236a;

    Ya(ab abVar) {
        this.f1236a = abVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            Method a = ab.m1478c(Class.forName("com.android.vending.billing.IInAppBillingService$Stub"));
            a.setAccessible(true);
            this.f1236a.f1247d = a.invoke(null, new Object[]{iBinder});
            this.f1236a.m1479c();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        ab.f1244a = -99;
        this.f1236a.f1247d = null;
    }
}
