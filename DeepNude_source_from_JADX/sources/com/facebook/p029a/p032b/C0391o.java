package com.facebook.p029a.p032b;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.facebook.C0560t;

/* renamed from: com.facebook.a.b.o */
class C0391o implements ServiceConnection {
    C0391o() {
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C0395s.f651h = C0396t.m713a(C0560t.m1252d(), iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
