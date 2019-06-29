package com.astuetz;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.HorizontalScrollView;

/* renamed from: com.astuetz.c */
class C0324c implements OnGlobalLayoutListener {
    /* renamed from: a */
    final /* synthetic */ PagerSlidingTabStrip f396a;

    C0324c(PagerSlidingTabStrip pagerSlidingTabStrip) {
        this.f396a = pagerSlidingTabStrip;
    }

    public void onGlobalLayout() {
        View childAt = this.f396a.f374h.getChildAt(0);
        if (VERSION.SDK_INT < 16) {
            this.f396a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        } else {
            this.f396a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
        if (this.f396a.f358E) {
            int width = childAt.getWidth() / 2;
            PagerSlidingTabStrip pagerSlidingTabStrip = this.f396a;
            int width2 = (pagerSlidingTabStrip.getWidth() / 2) - width;
            pagerSlidingTabStrip.f355B = width2;
            pagerSlidingTabStrip.f354A = width2;
        }
        PagerSlidingTabStrip pagerSlidingTabStrip2 = this.f396a;
        pagerSlidingTabStrip2.setPadding(pagerSlidingTabStrip2.f354A, this.f396a.getPaddingTop(), this.f396a.f355B, this.f396a.getPaddingBottom());
        if (this.f396a.f362I == 0) {
            HorizontalScrollView horizontalScrollView = this.f396a;
            horizontalScrollView.f362I = (horizontalScrollView.getWidth() / 2) - this.f396a.f354A;
        }
    }
}
