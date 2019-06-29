package com.facebook.p033b.p034a;

import android.net.nsd.NsdManager.RegistrationListener;
import android.net.nsd.NsdServiceInfo;

/* renamed from: com.facebook.b.a.a */
class C0437a implements RegistrationListener {
    /* renamed from: a */
    final /* synthetic */ String f753a;
    /* renamed from: b */
    final /* synthetic */ String f754b;

    C0437a(String str, String str2) {
        this.f753a = str;
        this.f754b = str2;
    }

    public void onRegistrationFailed(NsdServiceInfo nsdServiceInfo, int i) {
        C0438b.m835a(this.f754b);
    }

    public void onServiceRegistered(NsdServiceInfo nsdServiceInfo) {
        if (!this.f753a.equals(nsdServiceInfo.getServiceName())) {
            C0438b.m835a(this.f754b);
        }
    }

    public void onServiceUnregistered(NsdServiceInfo nsdServiceInfo) {
    }

    public void onUnregistrationFailed(NsdServiceInfo nsdServiceInfo, int i) {
    }
}
