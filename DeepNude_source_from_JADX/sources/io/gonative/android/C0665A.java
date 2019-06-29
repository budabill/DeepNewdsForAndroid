package io.gonative.android;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;

/* renamed from: io.gonative.android.A */
class C0665A extends PhoneStateListener {
    /* renamed from: a */
    final /* synthetic */ MainActivity f1418a;

    C0665A(MainActivity mainActivity) {
        this.f1418a = mainActivity;
    }

    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
        this.f1418a.f2029W = signalStrength;
        this.f1418a.m2560I();
        if (this.f1418a.f2026T != null) {
            MainActivity mainActivity = this.f1418a;
            mainActivity.m2585l(mainActivity.f2026T);
        }
    }
}
