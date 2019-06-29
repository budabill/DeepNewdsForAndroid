package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v7.appcompat.C0222R;
import android.support.v7.graphics.drawable.DrawableWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

class DropDownListView extends ListView {
    public static final int INVALID_POSITION = -1;
    public static final int NO_POSITION = -1;
    private ViewPropertyAnimatorCompat mClickAnimation;
    private boolean mDrawsInPressedState;
    private boolean mHijackFocus;
    private Field mIsChildViewEnabled;
    private boolean mListSelectionHidden;
    private int mMotionPosition;
    ResolveHoverRunnable mResolveHoverRunnable;
    private ListViewAutoScrollHelper mScrollHelper;
    private int mSelectionBottomPadding = 0;
    private int mSelectionLeftPadding = 0;
    private int mSelectionRightPadding = 0;
    private int mSelectionTopPadding = 0;
    private GateKeeperDrawable mSelector;
    private final Rect mSelectorRect = new Rect();

    private class ResolveHoverRunnable implements Runnable {
        ResolveHoverRunnable() {
        }

        public void cancel() {
            ListView listView = DropDownListView.this;
            listView.mResolveHoverRunnable = null;
            listView.removeCallbacks(this);
        }

        public void post() {
            DropDownListView.this.post(this);
        }

        public void run() {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.mResolveHoverRunnable = null;
            dropDownListView.drawableStateChanged();
        }
    }

    private static class GateKeeperDrawable extends DrawableWrapper {
        private boolean mEnabled = true;

        GateKeeperDrawable(Drawable drawable) {
            super(drawable);
        }

        public void draw(Canvas canvas) {
            if (this.mEnabled) {
                super.draw(canvas);
            }
        }

        void setEnabled(boolean z) {
            this.mEnabled = z;
        }

        public void setHotspot(float f, float f2) {
            if (this.mEnabled) {
                super.setHotspot(f, f2);
            }
        }

        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.mEnabled) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        public boolean setState(int[] iArr) {
            return this.mEnabled ? super.setState(iArr) : false;
        }

        public boolean setVisible(boolean z, boolean z2) {
            return this.mEnabled ? super.setVisible(z, z2) : false;
        }
    }

    DropDownListView(Context context, boolean z) {
        super(context, null, C0222R.attr.dropDownListViewStyle);
        this.mHijackFocus = z;
        setCacheColorHint(0);
        try {
            this.mIsChildViewEnabled = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.mIsChildViewEnabled.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private void clearPressedItem() {
        this.mDrawsInPressedState = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.mMotionPosition - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mClickAnimation;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
            this.mClickAnimation = null;
        }
    }

    private void clickPressedItem(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    private void drawSelectorCompat(Canvas canvas) {
        if (!this.mSelectorRect.isEmpty()) {
            Drawable selector = getSelector();
            if (selector != null) {
                selector.setBounds(this.mSelectorRect);
                selector.draw(canvas);
            }
        }
    }

    private void positionSelectorCompat(int i, View view) {
        Rect rect = this.mSelectorRect;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.mSelectionLeftPadding;
        rect.top -= this.mSelectionTopPadding;
        rect.right += this.mSelectionRightPadding;
        rect.bottom += this.mSelectionBottomPadding;
        try {
            boolean z = this.mIsChildViewEnabled.getBoolean(this);
            if (view.isEnabled() != z) {
                this.mIsChildViewEnabled.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void positionSelectorLikeFocusCompat(int i, View view) {
        Drawable selector = getSelector();
        boolean z = true;
        Object obj = (selector == null || i == -1) ? null : 1;
        if (obj != null) {
            selector.setVisible(false, false);
        }
        positionSelectorCompat(i, view);
        if (obj != null) {
            Rect rect = this.mSelectorRect;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z = false;
            }
            selector.setVisible(z, false);
            DrawableCompat.setHotspot(selector, exactCenterX, exactCenterY);
        }
    }

    private void positionSelectorLikeTouchCompat(int i, View view, float f, float f2) {
        positionSelectorLikeFocusCompat(i, view);
        Drawable selector = getSelector();
        if (selector != null && i != -1) {
            DrawableCompat.setHotspot(selector, f, f2);
        }
    }

    private void setPressedItem(View view, int i, float f, float f2) {
        this.mDrawsInPressedState = true;
        if (VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i2 = this.mMotionPosition;
        if (i2 != -1) {
            View childAt = getChildAt(i2 - getFirstVisiblePosition());
            if (!(childAt == null || childAt == view || !childAt.isPressed())) {
                childAt.setPressed(false);
            }
        }
        this.mMotionPosition = i;
        float left = f - ((float) view.getLeft());
        float top = f2 - ((float) view.getTop());
        if (VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        positionSelectorLikeTouchCompat(i, view, f, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    private void setSelectorEnabled(boolean z) {
        GateKeeperDrawable gateKeeperDrawable = this.mSelector;
        if (gateKeeperDrawable != null) {
            gateKeeperDrawable.setEnabled(z);
        }
    }

    private boolean touchModeDrawsInPressedStateCompat() {
        return this.mDrawsInPressedState;
    }

    private void updateSelectorStateCompat() {
        Drawable selector = getSelector();
        if (selector != null && touchModeDrawsInPressedStateCompat() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        drawSelectorCompat(canvas);
        super.dispatchDraw(canvas);
    }

    protected void drawableStateChanged() {
        if (this.mResolveHoverRunnable == null) {
            super.drawableStateChanged();
            setSelectorEnabled(true);
            updateSelectorStateCompat();
        }
    }

    public boolean hasFocus() {
        if (!this.mHijackFocus) {
            if (!super.hasFocus()) {
                return false;
            }
        }
        return true;
    }

    public boolean hasWindowFocus() {
        if (!this.mHijackFocus) {
            if (!super.hasWindowFocus()) {
                return false;
            }
        }
        return true;
    }

    public boolean isFocused() {
        if (!this.mHijackFocus) {
            if (!super.isFocused()) {
                return false;
            }
        }
        return true;
    }

    public boolean isInTouchMode() {
        return (this.mHijackFocus && this.mListSelectionHidden) || super.isInTouchMode();
    }

    public int lookForSelectablePosition(int i, boolean z) {
        ListAdapter adapter = getAdapter();
        if (adapter != null) {
            if (!isInTouchMode()) {
                int count = adapter.getCount();
                if (!getAdapter().areAllItemsEnabled()) {
                    if (z) {
                        i = Math.max(0, i);
                        while (i < count && !adapter.isEnabled(i)) {
                            i++;
                        }
                    } else {
                        i = Math.min(i, count - 1);
                        while (i >= 0 && !adapter.isEnabled(i)) {
                            i--;
                        }
                    }
                    if (i >= 0) {
                        if (i < count) {
                            return i;
                        }
                    }
                    return -1;
                } else if (i >= 0) {
                    if (i < count) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public int measureHeightOfChildrenCompat(int i, int i2, int i3, int i4, int i5) {
        i2 = getListPaddingTop();
        i3 = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return i2 + i3;
        }
        i2 += i3;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i6 = i2;
        View view = null;
        i2 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i2 < count) {
            int itemViewType = adapter.getItemViewType(i2);
            if (itemViewType != i7) {
                view = null;
                i7 = itemViewType;
            }
            view = adapter.getView(i2, view, this);
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            itemViewType = layoutParams.height;
            view.measure(i, itemViewType > 0 ? MeasureSpec.makeMeasureSpec(itemViewType, 1073741824) : MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i2 > 0) {
                i6 += dividerHeight;
            }
            i6 += view.getMeasuredHeight();
            if (i6 >= i4) {
                if (i5 >= 0 && i2 > i5 && i8 > 0 && i6 != i4) {
                    i4 = i8;
                }
                return i4;
            }
            if (i5 >= 0 && i2 >= i5) {
                i8 = i6;
            }
            i2++;
        }
        return i6;
    }

    protected void onDetachedFromWindow() {
        this.mResolveHoverRunnable = null;
        super.onDetachedFromWindow();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onForwardedEvent(android.view.MotionEvent r8, int r9) {
        /*
        r7 = this;
        r0 = r8.getActionMasked();
        r1 = 0;
        r2 = 1;
        if (r0 == r2) goto L_0x0016;
    L_0x0008:
        r3 = 2;
        if (r0 == r3) goto L_0x0014;
    L_0x000b:
        r9 = 3;
        if (r0 == r9) goto L_0x0011;
    L_0x000e:
        r9 = 0;
        r3 = 1;
        goto L_0x0046;
    L_0x0011:
        r9 = 0;
        r3 = 0;
        goto L_0x0046;
    L_0x0014:
        r3 = 1;
        goto L_0x0017;
    L_0x0016:
        r3 = 0;
    L_0x0017:
        r9 = r8.findPointerIndex(r9);
        if (r9 >= 0) goto L_0x001e;
    L_0x001d:
        goto L_0x0011;
    L_0x001e:
        r4 = r8.getX(r9);
        r4 = (int) r4;
        r9 = r8.getY(r9);
        r9 = (int) r9;
        r5 = r7.pointToPosition(r4, r9);
        r6 = -1;
        if (r5 != r6) goto L_0x0031;
    L_0x002f:
        r9 = 1;
        goto L_0x0046;
    L_0x0031:
        r3 = r7.getFirstVisiblePosition();
        r3 = r5 - r3;
        r3 = r7.getChildAt(r3);
        r4 = (float) r4;
        r9 = (float) r9;
        r7.setPressedItem(r3, r5, r4, r9);
        if (r0 != r2) goto L_0x000e;
    L_0x0042:
        r7.clickPressedItem(r3, r5);
        goto L_0x000e;
    L_0x0046:
        if (r3 == 0) goto L_0x004a;
    L_0x0048:
        if (r9 == 0) goto L_0x004d;
    L_0x004a:
        r7.clearPressedItem();
    L_0x004d:
        if (r3 == 0) goto L_0x0065;
    L_0x004f:
        r9 = r7.mScrollHelper;
        if (r9 != 0) goto L_0x005a;
    L_0x0053:
        r9 = new android.support.v4.widget.ListViewAutoScrollHelper;
        r9.<init>(r7);
        r7.mScrollHelper = r9;
    L_0x005a:
        r9 = r7.mScrollHelper;
        r9.setEnabled(r2);
        r9 = r7.mScrollHelper;
        r9.onTouch(r7, r8);
        goto L_0x006c;
    L_0x0065:
        r8 = r7.mScrollHelper;
        if (r8 == 0) goto L_0x006c;
    L_0x0069:
        r8.setEnabled(r1);
    L_0x006c:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.DropDownListView.onForwardedEvent(android.view.MotionEvent, int):boolean");
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.mResolveHoverRunnable == null) {
            this.mResolveHoverRunnable = new ResolveHoverRunnable();
            this.mResolveHoverRunnable.post();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked != 9) {
            if (actionMasked != 7) {
                setSelection(-1);
                return onHoverEvent;
            }
        }
        int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        if (!(pointToPosition == -1 || pointToPosition == getSelectedItemPosition())) {
            View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
            if (childAt.isEnabled()) {
                setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
            }
            updateSelectorStateCompat();
        }
        return onHoverEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mMotionPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        ResolveHoverRunnable resolveHoverRunnable = this.mResolveHoverRunnable;
        if (resolveHoverRunnable != null) {
            resolveHoverRunnable.cancel();
        }
        return super.onTouchEvent(motionEvent);
    }

    void setListSelectionHidden(boolean z) {
        this.mListSelectionHidden = z;
    }

    public void setSelector(Drawable drawable) {
        this.mSelector = drawable != null ? new GateKeeperDrawable(drawable) : null;
        super.setSelector(this.mSelector);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.mSelectionLeftPadding = rect.left;
        this.mSelectionTopPadding = rect.top;
        this.mSelectionRightPadding = rect.right;
        this.mSelectionBottomPadding = rect.bottom;
    }
}
