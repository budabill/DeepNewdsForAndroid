package androidx.browser.browseractions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import p000a.p005b.p007b.C0029o;

public class BrowserActionsFallbackMenuView extends LinearLayout {
    /* renamed from: a */
    private final int f124a = getResources().getDimensionPixelOffset(C0029o.browser_actions_context_menu_min_padding);
    /* renamed from: b */
    private final int f125b = getResources().getDimensionPixelOffset(C0029o.browser_actions_context_menu_max_width);

    public BrowserActionsFallbackMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(MeasureSpec.makeMeasureSpec(Math.min(getResources().getDisplayMetrics().widthPixels - (this.f124a * 2), this.f125b), 1073741824), i2);
    }
}
