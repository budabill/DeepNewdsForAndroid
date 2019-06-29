package com.astuetz;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.astuetz.b */
class C0323b implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ int f394a;
    /* renamed from: b */
    final /* synthetic */ PagerSlidingTabStrip f395b;

    C0323b(PagerSlidingTabStrip pagerSlidingTabStrip, int i) {
        this.f395b = pagerSlidingTabStrip;
        this.f394a = i;
    }

    public void onClick(View view) {
        this.f395b.m424c();
        if (this.f395b.f368b != null) {
            this.f395b.f368b.mo1412a(this.f394a);
        }
        if (this.f395b.f375i.getCurrentItem() != this.f394a) {
            this.f395b.m413a(this.f395b.f374h.getChildAt(this.f395b.f375i.getCurrentItem()));
            this.f395b.f375i.setCurrentItem(this.f394a);
        }
    }
}
