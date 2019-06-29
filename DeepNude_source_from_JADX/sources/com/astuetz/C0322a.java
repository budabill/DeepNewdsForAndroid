package com.astuetz;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

/* renamed from: com.astuetz.a */
class C0322a implements OnGlobalLayoutListener {
    /* renamed from: a */
    final /* synthetic */ PagerSlidingTabStrip f393a;

    C0322a(PagerSlidingTabStrip pagerSlidingTabStrip) {
        this.f393a = pagerSlidingTabStrip;
    }

    @SuppressLint({"NewApi"})
    public void onGlobalLayout() {
        if (VERSION.SDK_INT < 16) {
            this.f393a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        } else {
            this.f393a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
        PagerSlidingTabStrip pagerSlidingTabStrip = this.f393a;
        pagerSlidingTabStrip.f377k = pagerSlidingTabStrip.f375i.getCurrentItem();
        this.f393a.f378l = 0.0f;
        pagerSlidingTabStrip = this.f393a;
        pagerSlidingTabStrip.m411a(pagerSlidingTabStrip.f377k, 0);
        pagerSlidingTabStrip = this.f393a;
        pagerSlidingTabStrip.m419b(pagerSlidingTabStrip.f377k);
    }
}
