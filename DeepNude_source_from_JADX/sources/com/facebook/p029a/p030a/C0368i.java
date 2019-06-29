package com.facebook.p029a.p030a;

import android.util.Log;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.facebook.a.a.i */
class C0368i implements Runnable {
    /* renamed from: a */
    final /* synthetic */ TimerTask f596a;
    /* renamed from: b */
    final /* synthetic */ C0371l f597b;

    C0368i(C0371l c0371l, TimerTask timerTask) {
        this.f597b = c0371l;
        this.f596a = timerTask;
    }

    public void run() {
        try {
            if (this.f597b.f605e != null) {
                this.f597b.f605e.cancel();
            }
            this.f597b.f606f = null;
            this.f597b.f605e = new Timer();
            this.f597b.f605e.scheduleAtFixedRate(this.f596a, 0, 1000);
        } catch (Throwable e) {
            Log.e(C0371l.f601a, "Error scheduling indexing job", e);
        }
    }
}
