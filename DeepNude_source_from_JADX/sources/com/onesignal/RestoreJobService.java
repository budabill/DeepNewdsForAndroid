package com.onesignal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

public class RestoreJobService extends JobIntentService {
    /* renamed from: a */
    protected final void mo1364a(Intent intent) {
        if (intent != null) {
            C0585D.m1294a(getApplicationContext(), new C0876l(new Bundle(intent.getExtras())), null);
        }
    }

    /* renamed from: d */
    public /* bridge */ /* synthetic */ boolean mo1365d() {
        return super.mo1365d();
    }

    public /* bridge */ /* synthetic */ IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    public /* bridge */ /* synthetic */ void onCreate() {
        super.onCreate();
    }

    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    public /* bridge */ /* synthetic */ int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }
}
