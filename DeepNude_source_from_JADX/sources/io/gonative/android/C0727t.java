package io.gonative.android;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

/* renamed from: io.gonative.android.t */
class C0727t extends SimpleOnGestureListener {
    /* renamed from: a */
    final /* synthetic */ LeanWebView f1647a;

    C0727t(LeanWebView leanWebView) {
        this.f1647a = leanWebView;
    }

    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.f1647a.f1869e == null) {
            return true;
        }
        float abs = Math.abs(f);
        f2 = Math.abs(f2);
        if (abs >= 500.0f) {
            if (abs >= f2) {
                if (f < 0.0f) {
                    this.f1647a.f1869e.mo1815a();
                } else {
                    this.f1647a.f1869e.mo1816b();
                }
            }
        }
        return true;
    }
}
