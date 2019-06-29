package com.onesignal;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.onesignal.Ia.C0873a;

public class SyncService extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        Ia.m1365a((Context) this, new C0873a(this));
        return 1;
    }
}
