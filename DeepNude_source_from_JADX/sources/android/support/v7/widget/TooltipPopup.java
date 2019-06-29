package android.support.v7.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.support.v7.appcompat.C0222R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;

class TooltipPopup {
    private static final String TAG = "TooltipPopup";
    private final View mContentView;
    private final Context mContext;
    private final LayoutParams mLayoutParams = new LayoutParams();
    private final TextView mMessageView;
    private final int[] mTmpAnchorPos = new int[2];
    private final int[] mTmpAppPos = new int[2];
    private final Rect mTmpDisplayFrame = new Rect();

    TooltipPopup(Context context) {
        this.mContext = context;
        this.mContentView = LayoutInflater.from(this.mContext).inflate(C0222R.layout.abc_tooltip, null);
        this.mMessageView = (TextView) this.mContentView.findViewById(C0222R.id.message);
        this.mLayoutParams.setTitle(TooltipPopup.class.getSimpleName());
        this.mLayoutParams.packageName = this.mContext.getPackageName();
        LayoutParams layoutParams = this.mLayoutParams;
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = C0222R.style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void computePosition(android.view.View r9, int r10, int r11, boolean r12, android.view.WindowManager.LayoutParams r13) {
        /*
        r8 = this;
        r0 = r9.getApplicationWindowToken();
        r13.token = r0;
        r0 = r8.mContext;
        r0 = r0.getResources();
        r1 = android.support.v7.appcompat.C0222R.dimen.tooltip_precise_anchor_threshold;
        r0 = r0.getDimensionPixelOffset(r1);
        r1 = r9.getWidth();
        if (r1 < r0) goto L_0x0019;
    L_0x0018:
        goto L_0x001f;
    L_0x0019:
        r10 = r9.getWidth();
        r10 = r10 / 2;
    L_0x001f:
        r1 = r9.getHeight();
        r2 = 0;
        if (r1 < r0) goto L_0x0036;
    L_0x0026:
        r0 = r8.mContext;
        r0 = r0.getResources();
        r1 = android.support.v7.appcompat.C0222R.dimen.tooltip_precise_anchor_extra_offset;
        r0 = r0.getDimensionPixelOffset(r1);
        r1 = r11 + r0;
        r11 = r11 - r0;
        goto L_0x003b;
    L_0x0036:
        r1 = r9.getHeight();
        r11 = 0;
    L_0x003b:
        r0 = 49;
        r13.gravity = r0;
        r0 = r8.mContext;
        r0 = r0.getResources();
        if (r12 == 0) goto L_0x004a;
    L_0x0047:
        r3 = android.support.v7.appcompat.C0222R.dimen.tooltip_y_offset_touch;
        goto L_0x004c;
    L_0x004a:
        r3 = android.support.v7.appcompat.C0222R.dimen.tooltip_y_offset_non_touch;
    L_0x004c:
        r0 = r0.getDimensionPixelOffset(r3);
        r3 = getAppRootView(r9);
        if (r3 != 0) goto L_0x005e;
    L_0x0056:
        r9 = "TooltipPopup";
        r10 = "Cannot find app view";
        android.util.Log.e(r9, r10);
        return;
    L_0x005e:
        r4 = r8.mTmpDisplayFrame;
        r3.getWindowVisibleDisplayFrame(r4);
        r4 = r8.mTmpDisplayFrame;
        r5 = r4.left;
        if (r5 >= 0) goto L_0x0092;
    L_0x0069:
        r4 = r4.top;
        if (r4 >= 0) goto L_0x0092;
    L_0x006d:
        r4 = r8.mContext;
        r4 = r4.getResources();
        r5 = "status_bar_height";
        r6 = "dimen";
        r7 = "android";
        r5 = r4.getIdentifier(r5, r6, r7);
        if (r5 == 0) goto L_0x0084;
    L_0x007f:
        r5 = r4.getDimensionPixelSize(r5);
        goto L_0x0085;
    L_0x0084:
        r5 = 0;
    L_0x0085:
        r4 = r4.getDisplayMetrics();
        r6 = r8.mTmpDisplayFrame;
        r7 = r4.widthPixels;
        r4 = r4.heightPixels;
        r6.set(r2, r5, r7, r4);
    L_0x0092:
        r4 = r8.mTmpAppPos;
        r3.getLocationOnScreen(r4);
        r4 = r8.mTmpAnchorPos;
        r9.getLocationOnScreen(r4);
        r9 = r8.mTmpAnchorPos;
        r4 = r9[r2];
        r5 = r8.mTmpAppPos;
        r6 = r5[r2];
        r4 = r4 - r6;
        r9[r2] = r4;
        r4 = 1;
        r6 = r9[r4];
        r5 = r5[r4];
        r6 = r6 - r5;
        r9[r4] = r6;
        r9 = r9[r2];
        r9 = r9 + r10;
        r10 = r3.getWidth();
        r10 = r10 / 2;
        r9 = r9 - r10;
        r13.x = r9;
        r9 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r2);
        r10 = r8.mContentView;
        r10.measure(r9, r9);
        r9 = r8.mContentView;
        r9 = r9.getMeasuredHeight();
        r10 = r8.mTmpAnchorPos;
        r2 = r10[r4];
        r2 = r2 + r11;
        r2 = r2 - r0;
        r2 = r2 - r9;
        r10 = r10[r4];
        r10 = r10 + r1;
        r10 = r10 + r0;
        if (r12 == 0) goto L_0x00da;
    L_0x00d7:
        if (r2 < 0) goto L_0x00e3;
    L_0x00d9:
        goto L_0x00e6;
    L_0x00da:
        r9 = r9 + r10;
        r11 = r8.mTmpDisplayFrame;
        r11 = r11.height();
        if (r9 > r11) goto L_0x00e6;
    L_0x00e3:
        r13.y = r10;
        goto L_0x00e8;
    L_0x00e6:
        r13.y = r2;
    L_0x00e8:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.TooltipPopup.computePosition(android.view.View, int, int, boolean, android.view.WindowManager$LayoutParams):void");
    }

    private static View getAppRootView(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof LayoutParams) && ((LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    void hide() {
        if (isShowing()) {
            ((WindowManager) this.mContext.getSystemService("window")).removeView(this.mContentView);
        }
    }

    boolean isShowing() {
        return this.mContentView.getParent() != null;
    }

    void show(View view, int i, int i2, boolean z, CharSequence charSequence) {
        if (isShowing()) {
            hide();
        }
        this.mMessageView.setText(charSequence);
        computePosition(view, i, i2, z, this.mLayoutParams);
        ((WindowManager) this.mContext.getSystemService("window")).addView(this.mContentView, this.mLayoutParams);
    }
}
