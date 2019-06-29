package io.gonative.android;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;

public class MySwipeRefreshLayout extends SwipeRefreshLayout {
    /* renamed from: a */
    private C0681a f1979a;

    /* renamed from: io.gonative.android.MySwipeRefreshLayout$a */
    public interface C0681a {
        /* renamed from: a */
        boolean mo1398a();
    }

    public MySwipeRefreshLayout(Context context) {
        super(context);
    }

    public MySwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean canChildScrollUp() {
        C0681a c0681a = this.f1979a;
        return c0681a != null ? c0681a.mo1398a() : super.canChildScrollUp();
    }

    public void setCanChildScrollUpCallback(C0681a c0681a) {
        this.f1979a = c0681a;
    }
}
