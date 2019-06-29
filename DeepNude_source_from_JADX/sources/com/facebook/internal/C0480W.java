package com.facebook.internal;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* renamed from: com.facebook.internal.W */
class C0480W implements OnTouchListener {
    /* renamed from: a */
    final /* synthetic */ C0485X f853a;

    C0480W(C0485X c0485x) {
        this.f853a = c0485x;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!view.hasFocus()) {
            view.requestFocus();
        }
        return false;
    }
}
