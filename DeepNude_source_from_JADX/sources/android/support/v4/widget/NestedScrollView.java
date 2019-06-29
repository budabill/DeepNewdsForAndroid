package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.NestedScrollingChild2;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.NestedScrollingParent2;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ScrollingView;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.OverScroller;
import android.widget.ScrollView;
import java.util.List;

public class NestedScrollView extends FrameLayout implements NestedScrollingParent2, NestedScrollingChild2, ScrollingView {
    private static final AccessibilityDelegate ACCESSIBILITY_DELEGATE = new AccessibilityDelegate();
    static final int ANIMATED_SCROLL_GAP = 250;
    private static final int INVALID_POINTER = -1;
    static final float MAX_SCROLL_FACTOR = 0.5f;
    private static final int[] SCROLLVIEW_STYLEABLE = new int[]{16843130};
    private static final String TAG = "NestedScrollView";
    private int mActivePointerId;
    private final NestedScrollingChildHelper mChildHelper;
    private View mChildToScrollTo;
    private EdgeEffect mEdgeGlowBottom;
    private EdgeEffect mEdgeGlowTop;
    private boolean mFillViewport;
    private boolean mIsBeingDragged;
    private boolean mIsLaidOut;
    private boolean mIsLayoutDirty;
    private int mLastMotionY;
    private long mLastScroll;
    private int mLastScrollerY;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mNestedYOffset;
    private OnScrollChangeListener mOnScrollChangeListener;
    private final NestedScrollingParentHelper mParentHelper;
    private SavedState mSavedState;
    private final int[] mScrollConsumed;
    private final int[] mScrollOffset;
    private OverScroller mScroller;
    private boolean mSmoothScrollingEnabled;
    private final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private float mVerticalScrollFactor;

    public interface OnScrollChangeListener {
        void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C01951();
        public int scrollPosition;

        /* renamed from: android.support.v4.widget.NestedScrollView$SavedState$1 */
        static class C01951 implements Creator<SavedState> {
            C01951() {
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.scrollPosition = parcel.readInt();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("HorizontalScrollView.SavedState{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" scrollPosition=");
            stringBuilder.append(this.scrollPosition);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.scrollPosition);
        }
    }

    static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        AccessibilityDelegate() {
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            AccessibilityRecordCompat.setMaxScrollX(accessibilityEvent, nestedScrollView.getScrollX());
            AccessibilityRecordCompat.setMaxScrollY(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityNodeInfoCompat.setClassName(ScrollView.class.getName());
            if (nestedScrollView.isEnabled()) {
                int scrollRange = nestedScrollView.getScrollRange();
                if (scrollRange > 0) {
                    accessibilityNodeInfoCompat.setScrollable(true);
                    if (nestedScrollView.getScrollY() > 0) {
                        accessibilityNodeInfoCompat.addAction(8192);
                    }
                    if (nestedScrollView.getScrollY() < scrollRange) {
                        accessibilityNodeInfoCompat.addAction(4096);
                    }
                }
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            if (i == 4096) {
                i = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
                if (i == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.smoothScrollTo(0, i);
                return true;
            } else if (i != 8192) {
                return false;
            } else {
                i = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                if (i == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.smoothScrollTo(0, i);
                return true;
            }
        }
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTempRect = new Rect();
        this.mIsLayoutDirty = true;
        this.mIsLaidOut = false;
        this.mChildToScrollTo = null;
        this.mIsBeingDragged = false;
        this.mSmoothScrollingEnabled = true;
        this.mActivePointerId = -1;
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        initScrollView();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, SCROLLVIEW_STYLEABLE, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.mParentHelper = new NestedScrollingParentHelper(this);
        this.mChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.setAccessibilityDelegate(this, ACCESSIBILITY_DELEGATE);
    }

    private boolean canScroll() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
        return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private static int clamp(int i, int i2, int i3) {
        if (i2 < i3) {
            if (i >= 0) {
                return i2 + i > i3 ? i3 - i2 : i;
            }
        }
        return 0;
    }

    private void doScrollY(int i) {
        if (i == 0) {
            return;
        }
        if (this.mSmoothScrollingEnabled) {
            smoothScrollBy(0, i);
        } else {
            scrollBy(0, i);
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        recycleVelocityTracker();
        stopNestedScroll(0);
        EdgeEffect edgeEffect = this.mEdgeGlowTop;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.mEdgeGlowBottom.onRelease();
        }
    }

    private void ensureGlows() {
        if (getOverScrollMode() == 2) {
            this.mEdgeGlowTop = null;
            this.mEdgeGlowBottom = null;
        } else if (this.mEdgeGlowTop == null) {
            Context context = getContext();
            this.mEdgeGlowTop = new EdgeEffect(context);
            this.mEdgeGlowBottom = new EdgeEffect(context);
        }
    }

    private View findFocusableViewInBounds(boolean z, int i, int i2) {
        List focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        Object obj = null;
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = (View) focusables.get(i3);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i < bottom && top < i2) {
                Object obj2 = (i >= top || bottom >= i2) ? null : 1;
                if (view == null) {
                    view = view2;
                    obj = obj2;
                } else {
                    Object obj3 = ((!z || top >= view.getTop()) && (z || bottom <= view.getBottom())) ? null : 1;
                    if (obj != null) {
                        if (!(obj2 == null || obj3 == null)) {
                        }
                    } else if (obj2 != null) {
                        view = view2;
                        obj = 1;
                    } else if (obj3 == null) {
                    }
                    view = view2;
                }
            }
        }
        return view;
    }

    private void flingWithNestedDispatch(int i) {
        boolean z;
        float f;
        int scrollY = getScrollY();
        if (scrollY > 0 || i > 0) {
            if (scrollY >= getScrollRange()) {
                if (i < 0) {
                }
            }
            z = true;
            f = (float) i;
            if (!dispatchNestedPreFling(0.0f, f)) {
                dispatchNestedFling(0.0f, f, z);
                fling(i);
            }
        }
        z = false;
        f = (float) i;
        if (!dispatchNestedPreFling(0.0f, f)) {
            dispatchNestedFling(0.0f, f, z);
            fling(i);
        }
    }

    private float getVerticalScrollFactorCompat() {
        if (this.mVerticalScrollFactor == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.mVerticalScrollFactor = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.mVerticalScrollFactor;
    }

    private boolean inChild(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i2 >= childAt.getTop() - scrollY && i2 < childAt.getBottom() - scrollY && i >= childAt.getLeft() && i < childAt.getRight();
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void initScrollView() {
        this.mScroller = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private boolean isOffScreen(View view) {
        return isWithinDeltaOfScreen(view, 0, getHeight()) ^ 1;
    }

    private static boolean isViewDescendantOf(View view, View view2) {
        boolean z = true;
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup) || !isViewDescendantOf((View) parent, view2)) {
            z = false;
        }
        return z;
    }

    private boolean isWithinDeltaOfScreen(View view, int i, int i2) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        return this.mTempRect.bottom + i >= getScrollY() && this.mTempRect.top - i <= getScrollY() + i2;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            actionIndex = actionIndex == 0 ? 1 : 0;
            this.mLastMotionY = (int) motionEvent.getY(actionIndex);
            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private boolean scrollAndFocus(int i, int i2, int i3) {
        int height = getHeight();
        int scrollY = getScrollY();
        height += scrollY;
        boolean z = false;
        boolean z2 = i == 33;
        View findFocusableViewInBounds = findFocusableViewInBounds(z2, i2, i3);
        if (findFocusableViewInBounds == null) {
            findFocusableViewInBounds = this;
        }
        if (i2 < scrollY || i3 > height) {
            doScrollY(z2 ? i2 - scrollY : i3 - height);
            z = true;
        }
        if (findFocusableViewInBounds != findFocus()) {
            findFocusableViewInBounds.requestFocus(i);
        }
        return z;
    }

    private void scrollToChild(View view) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
        }
    }

    private boolean scrollToChildRect(Rect rect, boolean z) {
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        boolean z2 = computeScrollDeltaToGetChildRectOnScreen != 0;
        if (z2) {
            if (z) {
                scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            } else {
                smoothScrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            }
        }
        return z2;
    }

    public void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, int i) {
        if (getChildCount() <= 0) {
            super.addView(view, i);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public boolean arrowScroll(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !isWithinDeltaOfScreen(findNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                findNextFocus = getChildAt(0);
                maxScrollAmount = Math.min((findNextFocus.getBottom() + ((LayoutParams) findNextFocus.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            doScrollY(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(findNextFocus, this.mTempRect);
            doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
            findNextFocus.requestFocus(i);
        }
        if (findFocus != null && findFocus.isFocused() && isOffScreen(findFocus)) {
            i = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(i);
        }
        return true;
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            r10.mScroller.getCurrX();
            int currY = r10.mScroller.getCurrY();
            int i = currY - r10.mLastScrollerY;
            if (dispatchNestedPreScroll(0, i, r10.mScrollConsumed, null, 1)) {
                i -= r10.mScrollConsumed[1];
            }
            int i2 = i;
            if (i2 != 0) {
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i3 = scrollY;
                overScrollByCompat(0, i2, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
                int scrollY2 = getScrollY() - i3;
                if (!dispatchNestedScroll(0, scrollY2, 0, i2 - scrollY2, null, 1)) {
                    Object obj;
                    EdgeEffect edgeEffect;
                    int overScrollMode = getOverScrollMode();
                    if (overScrollMode != 0) {
                        if (overScrollMode != 1 || scrollRange <= 0) {
                            obj = null;
                            if (obj != null) {
                                ensureGlows();
                                if (currY > 0 && i3 > 0) {
                                    edgeEffect = r10.mEdgeGlowTop;
                                } else if (currY >= scrollRange && i3 < scrollRange) {
                                    edgeEffect = r10.mEdgeGlowBottom;
                                }
                                edgeEffect.onAbsorb((int) r10.mScroller.getCurrVelocity());
                            }
                        }
                    }
                    obj = 1;
                    if (obj != null) {
                        ensureGlows();
                        if (currY > 0) {
                        }
                        edgeEffect = r10.mEdgeGlowBottom;
                        edgeEffect.onAbsorb((int) r10.mScroller.getCurrVelocity());
                    }
                }
            }
            r10.mLastScrollerY = currY;
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }
        if (hasNestedScrollingParent(1)) {
            stopNestedScroll(1);
        }
        r10.mLastScrollerY = 0;
    }

    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        int i = 0;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i2 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
        verticalFadingEdgeLength = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i2 - verticalFadingEdgeLength : i2;
        if (rect.bottom > verticalFadingEdgeLength && rect.top > scrollY) {
            i = Math.min((rect.height() > height ? rect.top - scrollY : rect.bottom - verticalFadingEdgeLength) + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i2);
        } else if (rect.top < scrollY && rect.bottom < verticalFadingEdgeLength) {
            i = Math.max(rect.height() > height ? 0 - (verticalFadingEdgeLength - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
        }
        return i;
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollRange() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (getChildCount() == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        if (scrollY < 0) {
            bottom -= scrollY;
        } else if (scrollY > max) {
            bottom += scrollY - max;
        }
        return bottom;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!super.dispatchKeyEvent(keyEvent)) {
            if (!executeKeyEvent(keyEvent)) {
                return false;
            }
        }
        return true;
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.mChildHelper.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.mChildHelper.dispatchNestedPreFling(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return dispatchNestedPreScroll(i, i2, iArr, iArr2, 0);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.mChildHelper.dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return dispatchNestedScroll(i, i2, i3, i4, iArr, 0);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return this.mChildHelper.dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.mEdgeGlowTop != null) {
            int save;
            int width;
            int height;
            int scrollY = getScrollY();
            int i = 0;
            if (!this.mEdgeGlowTop.isFinished()) {
                int i2;
                save = canvas.save();
                width = getWidth();
                height = getHeight();
                int min = Math.min(0, scrollY);
                if (VERSION.SDK_INT >= 21) {
                    if (!getClipToPadding()) {
                        i2 = 0;
                        if (VERSION.SDK_INT >= 21 && getClipToPadding()) {
                            height -= getPaddingTop() + getPaddingBottom();
                            min += getPaddingTop();
                        }
                        canvas.translate((float) i2, (float) min);
                        this.mEdgeGlowTop.setSize(width, height);
                        if (this.mEdgeGlowTop.draw(canvas)) {
                            ViewCompat.postInvalidateOnAnimation(this);
                        }
                        canvas.restoreToCount(save);
                    }
                }
                width -= getPaddingLeft() + getPaddingRight();
                i2 = getPaddingLeft() + 0;
                height -= getPaddingTop() + getPaddingBottom();
                min += getPaddingTop();
                canvas.translate((float) i2, (float) min);
                this.mEdgeGlowTop.setSize(width, height);
                if (this.mEdgeGlowTop.draw(canvas)) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.mEdgeGlowBottom.isFinished()) {
                save = canvas.save();
                width = getWidth();
                height = getHeight();
                scrollY = Math.max(getScrollRange(), scrollY) + height;
                if (VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    i = 0 + getPaddingLeft();
                }
                if (VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    scrollY -= getPaddingBottom();
                }
                canvas.translate((float) (i - width), (float) scrollY);
                canvas.rotate(180.0f, (float) width, 0.0f);
                this.mEdgeGlowBottom.setSize(width, height);
                if (this.mEdgeGlowBottom.draw(canvas)) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        this.mTempRect.setEmpty();
        boolean z = false;
        int i = 130;
        if (canScroll()) {
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == 19) {
                    z = !keyEvent.isAltPressed() ? arrowScroll(33) : fullScroll(33);
                } else if (keyCode == 20) {
                    z = !keyEvent.isAltPressed() ? arrowScroll(130) : fullScroll(130);
                } else if (keyCode == 62) {
                    if (keyEvent.isShiftPressed()) {
                        i = 33;
                    }
                    pageScroll(i);
                }
            }
            return z;
        }
        if (isFocused() && keyEvent.getKeyCode() != 4) {
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            findFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            if (!(findFocus == null || findFocus == this || !findFocus.requestFocus(130))) {
                z = true;
            }
        }
        return z;
    }

    public void fling(int i) {
        if (getChildCount() > 0) {
            startNestedScroll(2, 1);
            this.mScroller.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, 0);
            this.mLastScrollerY = getScrollY();
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public boolean fullScroll(int i) {
        Rect rect;
        Object obj = i == 130 ? 1 : null;
        int height = getHeight();
        Rect rect2 = this.mTempRect;
        rect2.top = 0;
        rect2.bottom = height;
        if (obj != null) {
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                this.mTempRect.bottom = (childAt.getBottom() + ((LayoutParams) childAt.getLayoutParams()).bottomMargin) + getPaddingBottom();
                rect = this.mTempRect;
                rect.top = rect.bottom - height;
            }
        }
        rect = this.mTempRect;
        return scrollAndFocus(i, rect.top, rect.bottom);
    }

    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        return bottom < verticalFadingEdgeLength ? ((float) bottom) / ((float) verticalFadingEdgeLength) : 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (((float) getHeight()) * MAX_SCROLL_FACTOR);
    }

    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        return scrollY < verticalFadingEdgeLength ? ((float) scrollY) / ((float) verticalFadingEdgeLength) : 1.0f;
    }

    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    public boolean hasNestedScrollingParent(int i) {
        return this.mChildHelper.hasNestedScrollingParent(i);
    }

    public boolean isFillViewport() {
        return this.mFillViewport;
    }

    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }

    public boolean isSmoothScrollingEnabled() {
        return this.mSmoothScrollingEnabled;
    }

    protected void measureChild(View view, int i, int i2) {
        view.measure(FrameLayout.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), MeasureSpec.makeMeasureSpec(0, 0));
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(FrameLayout.getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width), MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsLaidOut = false;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0) {
            if (motionEvent.getAction() == 8) {
                if (!this.mIsBeingDragged) {
                    float axisValue = motionEvent.getAxisValue(9);
                    if (axisValue != 0.0f) {
                        int verticalScrollFactorCompat = (int) (axisValue * getVerticalScrollFactorCompat());
                        int scrollRange = getScrollRange();
                        int scrollY = getScrollY();
                        verticalScrollFactorCompat = scrollY - verticalScrollFactorCompat;
                        if (verticalScrollFactorCompat < 0) {
                            verticalScrollFactorCompat = 0;
                        } else if (verticalScrollFactorCompat > scrollRange) {
                            verticalScrollFactorCompat = scrollRange;
                        }
                        if (verticalScrollFactorCompat != scrollY) {
                            super.scrollTo(getScrollX(), verticalScrollFactorCompat);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.mIsBeingDragged) {
            return true;
        }
        action &= 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    action = this.mActivePointerId;
                    if (action != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(action);
                        if (findPointerIndex == -1) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Invalid pointerId=");
                            stringBuilder.append(action);
                            stringBuilder.append(" in onInterceptTouchEvent");
                            Log.e(TAG, stringBuilder.toString());
                        } else {
                            action = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(action - this.mLastMotionY) > this.mTouchSlop && (2 & getNestedScrollAxes()) == 0) {
                                this.mIsBeingDragged = true;
                                this.mLastMotionY = action;
                                initVelocityTrackerIfNotExists();
                                this.mVelocityTracker.addMovement(motionEvent);
                                this.mNestedYOffset = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                } else if (action != 3) {
                    if (action == 6) {
                        onSecondaryPointerUp(motionEvent);
                    }
                }
            }
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            recycleVelocityTracker();
            if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                ViewCompat.postInvalidateOnAnimation(this);
            }
            stopNestedScroll(0);
        } else {
            action = (int) motionEvent.getY();
            if (inChild((int) motionEvent.getX(), action)) {
                this.mLastMotionY = action;
                this.mActivePointerId = motionEvent.getPointerId(0);
                initOrResetVelocityTracker();
                this.mVelocityTracker.addMovement(motionEvent);
                this.mScroller.computeScrollOffset();
                this.mIsBeingDragged = this.mScroller.isFinished() ^ true;
                startNestedScroll(2, 0);
            } else {
                this.mIsBeingDragged = false;
                recycleVelocityTracker();
            }
        }
        return this.mIsBeingDragged;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = 0;
        this.mIsLayoutDirty = false;
        View view = this.mChildToScrollTo;
        if (view != null && isViewDescendantOf(view, this)) {
            scrollToChild(this.mChildToScrollTo);
        }
        this.mChildToScrollTo = null;
        if (!this.mIsLaidOut) {
            if (this.mSavedState != null) {
                scrollTo(getScrollX(), this.mSavedState.scrollPosition);
                this.mSavedState = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                i5 = (childAt.getMeasuredHeight() + layoutParams.topMargin) + layoutParams.bottomMargin;
            }
            i4 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
            i = getScrollY();
            i5 = clamp(i, i4, i5);
            if (i5 != i) {
                scrollTo(getScrollX(), i5);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.mIsLaidOut = true;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mFillViewport && MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(FrameLayout.getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + layoutParams.leftMargin) + layoutParams.rightMargin, layoutParams.width), MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            }
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        flingWithNestedDispatch((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        dispatchNestedPreScroll(i, i2, iArr, null, i3);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        onNestedScroll(view, i, i2, i3, i4, 0);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        dispatchNestedScroll(0, scrollY2, 0, i4 - scrollY2, null, i5);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        this.mParentHelper.onNestedScrollAccepted(view, view2, i, i2);
        startNestedScroll(2, i2);
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        return (findNextFocus == null || isOffScreen(findNextFocus)) ? false : findNextFocus.requestFocus(i, rect);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.mSavedState = savedState;
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.scrollPosition = getScrollY();
        return savedState;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        OnScrollChangeListener onScrollChangeListener = this.mOnScrollChangeListener;
        if (onScrollChangeListener != null) {
            onScrollChangeListener.onScrollChange(this, i, i2, i3, i4);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus == null) {
            return;
        }
        if (this != findFocus) {
            if (isWithinDeltaOfScreen(findFocus, 0, i4)) {
                findFocus.getDrawingRect(this.mTempRect);
                offsetDescendantRectToMyCoords(findFocus, this.mTempRect);
                doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
            }
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return (i & 2) != 0;
    }

    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    public void onStopNestedScroll(View view, int i) {
        this.mParentHelper.onStopNestedScroll(view, i);
        stopNestedScroll(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r24) {
        /*
        r23 = this;
        r10 = r23;
        r11 = r24;
        r23.initVelocityTrackerIfNotExists();
        r12 = android.view.MotionEvent.obtain(r24);
        r0 = r24.getActionMasked();
        r13 = 0;
        if (r0 != 0) goto L_0x0014;
    L_0x0012:
        r10.mNestedYOffset = r13;
    L_0x0014:
        r1 = r10.mNestedYOffset;
        r1 = (float) r1;
        r14 = 0;
        r12.offsetLocation(r14, r1);
        r1 = 2;
        r15 = 1;
        if (r0 == 0) goto L_0x021c;
    L_0x001f:
        r2 = -1;
        if (r0 == r15) goto L_0x01e4;
    L_0x0022:
        if (r0 == r1) goto L_0x007f;
    L_0x0024:
        r1 = 3;
        if (r0 == r1) goto L_0x0054;
    L_0x0027:
        r1 = 5;
        if (r0 == r1) goto L_0x0041;
    L_0x002a:
        r1 = 6;
        if (r0 == r1) goto L_0x002f;
    L_0x002d:
        goto L_0x0254;
    L_0x002f:
        r23.onSecondaryPointerUp(r24);
        r0 = r10.mActivePointerId;
        r0 = r11.findPointerIndex(r0);
        r0 = r11.getY(r0);
        r0 = (int) r0;
        r10.mLastMotionY = r0;
        goto L_0x0254;
    L_0x0041:
        r0 = r24.getActionIndex();
        r1 = r11.getY(r0);
        r1 = (int) r1;
        r10.mLastMotionY = r1;
        r0 = r11.getPointerId(r0);
        r10.mActivePointerId = r0;
        goto L_0x0254;
    L_0x0054:
        r0 = r10.mIsBeingDragged;
        if (r0 == 0) goto L_0x0078;
    L_0x0058:
        r0 = r23.getChildCount();
        if (r0 <= 0) goto L_0x0078;
    L_0x005e:
        r3 = r10.mScroller;
        r4 = r23.getScrollX();
        r5 = r23.getScrollY();
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = r23.getScrollRange();
        r0 = r3.springBack(r4, r5, r6, r7, r8, r9);
        if (r0 == 0) goto L_0x0078;
    L_0x0075:
        android.support.v4.view.ViewCompat.postInvalidateOnAnimation(r23);
    L_0x0078:
        r10.mActivePointerId = r2;
        r23.endDrag();
        goto L_0x0254;
    L_0x007f:
        r0 = r10.mActivePointerId;
        r9 = r11.findPointerIndex(r0);
        if (r9 != r2) goto L_0x00a6;
    L_0x0087:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Invalid pointerId=";
        r0.append(r1);
        r1 = r10.mActivePointerId;
        r0.append(r1);
        r1 = " in onTouchEvent";
        r0.append(r1);
        r0 = r0.toString();
        r1 = "NestedScrollView";
        android.util.Log.e(r1, r0);
        goto L_0x0254;
    L_0x00a6:
        r0 = r11.getY(r9);
        r6 = (int) r0;
        r0 = r10.mLastMotionY;
        r7 = r0 - r6;
        r1 = 0;
        r3 = r10.mScrollConsumed;
        r4 = r10.mScrollOffset;
        r5 = 0;
        r0 = r23;
        r2 = r7;
        r0 = r0.dispatchNestedPreScroll(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x00d4;
    L_0x00be:
        r0 = r10.mScrollConsumed;
        r0 = r0[r15];
        r7 = r7 - r0;
        r0 = r10.mScrollOffset;
        r0 = r0[r15];
        r0 = (float) r0;
        r12.offsetLocation(r14, r0);
        r0 = r10.mNestedYOffset;
        r1 = r10.mScrollOffset;
        r1 = r1[r15];
        r0 = r0 + r1;
        r10.mNestedYOffset = r0;
    L_0x00d4:
        r0 = r10.mIsBeingDragged;
        if (r0 != 0) goto L_0x00f4;
    L_0x00d8:
        r0 = java.lang.Math.abs(r7);
        r1 = r10.mTouchSlop;
        if (r0 <= r1) goto L_0x00f4;
    L_0x00e0:
        r0 = r23.getParent();
        if (r0 == 0) goto L_0x00e9;
    L_0x00e6:
        r0.requestDisallowInterceptTouchEvent(r15);
    L_0x00e9:
        r10.mIsBeingDragged = r15;
        if (r7 <= 0) goto L_0x00f1;
    L_0x00ed:
        r0 = r10.mTouchSlop;
        r7 = r7 - r0;
        goto L_0x00f4;
    L_0x00f1:
        r0 = r10.mTouchSlop;
        r7 = r7 + r0;
    L_0x00f4:
        r8 = r7;
        r0 = r10.mIsBeingDragged;
        if (r0 == 0) goto L_0x0254;
    L_0x00f9:
        r0 = r10.mScrollOffset;
        r0 = r0[r15];
        r6 = r6 - r0;
        r10.mLastMotionY = r6;
        r16 = r23.getScrollY();
        r7 = r23.getScrollRange();
        r0 = r23.getOverScrollMode();
        if (r0 == 0) goto L_0x0116;
    L_0x010e:
        if (r0 != r15) goto L_0x0113;
    L_0x0110:
        if (r7 <= 0) goto L_0x0113;
    L_0x0112:
        goto L_0x0116;
    L_0x0113:
        r17 = 0;
        goto L_0x0118;
    L_0x0116:
        r17 = 1;
    L_0x0118:
        r1 = 0;
        r3 = 0;
        r4 = r23.getScrollY();
        r5 = 0;
        r18 = 0;
        r19 = 0;
        r20 = 1;
        r0 = r23;
        r2 = r8;
        r6 = r7;
        r21 = r7;
        r7 = r18;
        r14 = r8;
        r8 = r19;
        r22 = r9;
        r9 = r20;
        r0 = r0.overScrollByCompat(r1, r2, r3, r4, r5, r6, r7, r8, r9);
        if (r0 == 0) goto L_0x0145;
    L_0x013a:
        r0 = r10.hasNestedScrollingParent(r13);
        if (r0 != 0) goto L_0x0145;
    L_0x0140:
        r0 = r10.mVelocityTracker;
        r0.clear();
    L_0x0145:
        r0 = r23.getScrollY();
        r2 = r0 - r16;
        r4 = r14 - r2;
        r1 = 0;
        r3 = 0;
        r5 = r10.mScrollOffset;
        r6 = 0;
        r0 = r23;
        r0 = r0.dispatchNestedScroll(r1, r2, r3, r4, r5, r6);
        if (r0 == 0) goto L_0x0175;
    L_0x015a:
        r0 = r10.mLastMotionY;
        r1 = r10.mScrollOffset;
        r2 = r1[r15];
        r0 = r0 - r2;
        r10.mLastMotionY = r0;
        r0 = r1[r15];
        r0 = (float) r0;
        r1 = 0;
        r12.offsetLocation(r1, r0);
        r0 = r10.mNestedYOffset;
        r1 = r10.mScrollOffset;
        r1 = r1[r15];
        r0 = r0 + r1;
        r10.mNestedYOffset = r0;
        goto L_0x0254;
    L_0x0175:
        if (r17 == 0) goto L_0x0254;
    L_0x0177:
        r23.ensureGlows();
        r0 = r16 + r14;
        if (r0 >= 0) goto L_0x01a4;
    L_0x017e:
        r0 = r10.mEdgeGlowTop;
        r1 = (float) r14;
        r2 = r23.getHeight();
        r2 = (float) r2;
        r1 = r1 / r2;
        r2 = r22;
        r2 = r11.getX(r2);
        r3 = r23.getWidth();
        r3 = (float) r3;
        r2 = r2 / r3;
        android.support.v4.widget.EdgeEffectCompat.onPull(r0, r1, r2);
        r0 = r10.mEdgeGlowBottom;
        r0 = r0.isFinished();
        if (r0 != 0) goto L_0x01ce;
    L_0x019e:
        r0 = r10.mEdgeGlowBottom;
    L_0x01a0:
        r0.onRelease();
        goto L_0x01ce;
    L_0x01a4:
        r1 = r21;
        r2 = r22;
        if (r0 <= r1) goto L_0x01ce;
    L_0x01aa:
        r0 = r10.mEdgeGlowBottom;
        r1 = (float) r14;
        r3 = r23.getHeight();
        r3 = (float) r3;
        r1 = r1 / r3;
        r3 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r2 = r11.getX(r2);
        r4 = r23.getWidth();
        r4 = (float) r4;
        r2 = r2 / r4;
        r3 = r3 - r2;
        android.support.v4.widget.EdgeEffectCompat.onPull(r0, r1, r3);
        r0 = r10.mEdgeGlowTop;
        r0 = r0.isFinished();
        if (r0 != 0) goto L_0x01ce;
    L_0x01cb:
        r0 = r10.mEdgeGlowTop;
        goto L_0x01a0;
    L_0x01ce:
        r0 = r10.mEdgeGlowTop;
        if (r0 == 0) goto L_0x0254;
    L_0x01d2:
        r0 = r0.isFinished();
        if (r0 == 0) goto L_0x01e0;
    L_0x01d8:
        r0 = r10.mEdgeGlowBottom;
        r0 = r0.isFinished();
        if (r0 != 0) goto L_0x0254;
    L_0x01e0:
        android.support.v4.view.ViewCompat.postInvalidateOnAnimation(r23);
        goto L_0x0254;
    L_0x01e4:
        r0 = r10.mVelocityTracker;
        r1 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r3 = r10.mMaximumVelocity;
        r3 = (float) r3;
        r0.computeCurrentVelocity(r1, r3);
        r1 = r10.mActivePointerId;
        r0 = r0.getYVelocity(r1);
        r0 = (int) r0;
        r1 = java.lang.Math.abs(r0);
        r3 = r10.mMinimumVelocity;
        if (r1 <= r3) goto L_0x0203;
    L_0x01fd:
        r0 = -r0;
        r10.flingWithNestedDispatch(r0);
        goto L_0x0078;
    L_0x0203:
        r3 = r10.mScroller;
        r4 = r23.getScrollX();
        r5 = r23.getScrollY();
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = r23.getScrollRange();
        r0 = r3.springBack(r4, r5, r6, r7, r8, r9);
        if (r0 == 0) goto L_0x0078;
    L_0x021a:
        goto L_0x0075;
    L_0x021c:
        r0 = r23.getChildCount();
        if (r0 != 0) goto L_0x0223;
    L_0x0222:
        return r13;
    L_0x0223:
        r0 = r10.mScroller;
        r0 = r0.isFinished();
        r0 = r0 ^ r15;
        r10.mIsBeingDragged = r0;
        if (r0 == 0) goto L_0x0237;
    L_0x022e:
        r0 = r23.getParent();
        if (r0 == 0) goto L_0x0237;
    L_0x0234:
        r0.requestDisallowInterceptTouchEvent(r15);
    L_0x0237:
        r0 = r10.mScroller;
        r0 = r0.isFinished();
        if (r0 != 0) goto L_0x0244;
    L_0x023f:
        r0 = r10.mScroller;
        r0.abortAnimation();
    L_0x0244:
        r0 = r24.getY();
        r0 = (int) r0;
        r10.mLastMotionY = r0;
        r0 = r11.getPointerId(r13);
        r10.mActivePointerId = r0;
        r10.startNestedScroll(r1, r13);
    L_0x0254:
        r0 = r10.mVelocityTracker;
        if (r0 == 0) goto L_0x025b;
    L_0x0258:
        r0.addMovement(r12);
    L_0x025b:
        r12.recycle();
        return r15;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.NestedScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    boolean overScrollByCompat(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        Object obj;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z2;
        boolean z3;
        NestedScrollView nestedScrollView = this;
        int overScrollMode = getOverScrollMode();
        Object obj2 = computeHorizontalScrollRange() > computeHorizontalScrollExtent() ? 1 : null;
        Object obj3 = computeVerticalScrollRange() > computeVerticalScrollExtent() ? 1 : null;
        if (overScrollMode != 0) {
            if (overScrollMode != 1 || obj2 == null) {
                obj2 = null;
                if (overScrollMode != 0) {
                    if (overScrollMode == 1 || obj3 == null) {
                        obj = null;
                        i9 = i3 + i;
                        i10 = obj2 != null ? 0 : i7;
                        i11 = i4 + i2;
                        overScrollMode = obj != null ? 0 : i8;
                        i12 = -i10;
                        i10 += i5;
                        i13 = -overScrollMode;
                        overScrollMode += i6;
                        if (i9 <= i10) {
                            i12 = i10;
                        } else if (i9 >= i12) {
                            i12 = i9;
                            z2 = false;
                            if (i11 <= overScrollMode) {
                                i11 = overScrollMode;
                            } else if (i11 >= i13) {
                                i11 = i13;
                            } else {
                                z3 = false;
                                if (z3 && !hasNestedScrollingParent(1)) {
                                    nestedScrollView.mScroller.springBack(i12, i11, 0, 0, 0, getScrollRange());
                                }
                                onOverScrolled(i12, i11, z2, z3);
                                return z2 || z3;
                            }
                            z3 = true;
                            nestedScrollView.mScroller.springBack(i12, i11, 0, 0, 0, getScrollRange());
                            onOverScrolled(i12, i11, z2, z3);
                            if (!z2) {
                            }
                        }
                        z2 = true;
                        if (i11 <= overScrollMode) {
                            i11 = overScrollMode;
                        } else if (i11 >= i13) {
                            z3 = false;
                            nestedScrollView.mScroller.springBack(i12, i11, 0, 0, 0, getScrollRange());
                            onOverScrolled(i12, i11, z2, z3);
                            if (z2) {
                            }
                        } else {
                            i11 = i13;
                        }
                        z3 = true;
                        nestedScrollView.mScroller.springBack(i12, i11, 0, 0, 0, getScrollRange());
                        onOverScrolled(i12, i11, z2, z3);
                        if (z2) {
                        }
                    }
                }
                obj = 1;
                i9 = i3 + i;
                if (obj2 != null) {
                }
                i11 = i4 + i2;
                if (obj != null) {
                }
                i12 = -i10;
                i10 += i5;
                i13 = -overScrollMode;
                overScrollMode += i6;
                if (i9 <= i10) {
                    i12 = i10;
                } else if (i9 >= i12) {
                    i12 = i9;
                    z2 = false;
                    if (i11 <= overScrollMode) {
                        i11 = overScrollMode;
                    } else if (i11 >= i13) {
                        i11 = i13;
                    } else {
                        z3 = false;
                        nestedScrollView.mScroller.springBack(i12, i11, 0, 0, 0, getScrollRange());
                        onOverScrolled(i12, i11, z2, z3);
                        if (z2) {
                        }
                    }
                    z3 = true;
                    nestedScrollView.mScroller.springBack(i12, i11, 0, 0, 0, getScrollRange());
                    onOverScrolled(i12, i11, z2, z3);
                    if (z2) {
                    }
                }
                z2 = true;
                if (i11 <= overScrollMode) {
                    i11 = overScrollMode;
                } else if (i11 >= i13) {
                    z3 = false;
                    nestedScrollView.mScroller.springBack(i12, i11, 0, 0, 0, getScrollRange());
                    onOverScrolled(i12, i11, z2, z3);
                    if (z2) {
                    }
                } else {
                    i11 = i13;
                }
                z3 = true;
                nestedScrollView.mScroller.springBack(i12, i11, 0, 0, 0, getScrollRange());
                onOverScrolled(i12, i11, z2, z3);
                if (z2) {
                }
            }
        }
        obj2 = 1;
        if (overScrollMode != 0) {
            if (overScrollMode == 1) {
            }
            obj = null;
            i9 = i3 + i;
            if (obj2 != null) {
            }
            i11 = i4 + i2;
            if (obj != null) {
            }
            i12 = -i10;
            i10 += i5;
            i13 = -overScrollMode;
            overScrollMode += i6;
            if (i9 <= i10) {
                i12 = i10;
            } else if (i9 >= i12) {
                i12 = i9;
                z2 = false;
                if (i11 <= overScrollMode) {
                    i11 = overScrollMode;
                } else if (i11 >= i13) {
                    i11 = i13;
                } else {
                    z3 = false;
                    nestedScrollView.mScroller.springBack(i12, i11, 0, 0, 0, getScrollRange());
                    onOverScrolled(i12, i11, z2, z3);
                    if (z2) {
                    }
                }
                z3 = true;
                nestedScrollView.mScroller.springBack(i12, i11, 0, 0, 0, getScrollRange());
                onOverScrolled(i12, i11, z2, z3);
                if (z2) {
                }
            }
            z2 = true;
            if (i11 <= overScrollMode) {
                i11 = overScrollMode;
            } else if (i11 >= i13) {
                z3 = false;
                nestedScrollView.mScroller.springBack(i12, i11, 0, 0, 0, getScrollRange());
                onOverScrolled(i12, i11, z2, z3);
                if (z2) {
                }
            } else {
                i11 = i13;
            }
            z3 = true;
            nestedScrollView.mScroller.springBack(i12, i11, 0, 0, 0, getScrollRange());
            onOverScrolled(i12, i11, z2, z3);
            if (z2) {
            }
        }
        obj = 1;
        i9 = i3 + i;
        if (obj2 != null) {
        }
        i11 = i4 + i2;
        if (obj != null) {
        }
        i12 = -i10;
        i10 += i5;
        i13 = -overScrollMode;
        overScrollMode += i6;
        if (i9 <= i10) {
            i12 = i10;
        } else if (i9 >= i12) {
            i12 = i9;
            z2 = false;
            if (i11 <= overScrollMode) {
                i11 = overScrollMode;
            } else if (i11 >= i13) {
                i11 = i13;
            } else {
                z3 = false;
                nestedScrollView.mScroller.springBack(i12, i11, 0, 0, 0, getScrollRange());
                onOverScrolled(i12, i11, z2, z3);
                if (z2) {
                }
            }
            z3 = true;
            nestedScrollView.mScroller.springBack(i12, i11, 0, 0, 0, getScrollRange());
            onOverScrolled(i12, i11, z2, z3);
            if (z2) {
            }
        }
        z2 = true;
        if (i11 <= overScrollMode) {
            i11 = overScrollMode;
        } else if (i11 >= i13) {
            z3 = false;
            nestedScrollView.mScroller.springBack(i12, i11, 0, 0, 0, getScrollRange());
            onOverScrolled(i12, i11, z2, z3);
            if (z2) {
            }
        } else {
            i11 = i13;
        }
        z3 = true;
        nestedScrollView.mScroller.springBack(i12, i11, 0, 0, 0, getScrollRange());
        onOverScrolled(i12, i11, z2, z3);
        if (z2) {
        }
    }

    public boolean pageScroll(int i) {
        int childCount;
        Rect rect;
        Object obj = i == 130 ? 1 : null;
        int height = getHeight();
        if (obj != null) {
            this.mTempRect.top = getScrollY() + height;
            childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = (childAt.getBottom() + ((LayoutParams) childAt.getLayoutParams()).bottomMargin) + getPaddingBottom();
                Rect rect2 = this.mTempRect;
                if (rect2.top + height > bottom) {
                    rect2.top = bottom - height;
                }
            }
        } else {
            this.mTempRect.top = getScrollY() - height;
            rect = this.mTempRect;
            if (rect.top < 0) {
                rect.top = 0;
            }
        }
        rect = this.mTempRect;
        childCount = rect.top;
        rect.bottom = height + childCount;
        return scrollAndFocus(i, childCount, rect.bottom);
    }

    public void requestChildFocus(View view, View view2) {
        if (this.mIsLayoutDirty) {
            this.mChildToScrollTo = view2;
        } else {
            scrollToChild(view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return scrollToChildRect(rect, z);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void requestLayout() {
        this.mIsLayoutDirty = true;
        super.requestLayout();
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int width = (childAt.getWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin;
            i = clamp(i, (getWidth() - getPaddingLeft()) - getPaddingRight(), width);
            i2 = clamp(i2, height, height2);
            if (i != getScrollX() || i2 != getScrollY()) {
                super.scrollTo(i, i2);
            }
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.mFillViewport) {
            this.mFillViewport = z;
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.mChildHelper.setNestedScrollingEnabled(z);
    }

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        this.mOnScrollChangeListener = onScrollChangeListener;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.mSmoothScrollingEnabled = z;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public final void smoothScrollBy(int i, int i2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll > 250) {
                View childAt = getChildAt(0);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int height = (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin;
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int scrollY = getScrollY();
                i2 = Math.max(0, Math.min(i2 + scrollY, Math.max(0, height - height2))) - scrollY;
                this.mLastScrollerY = getScrollY();
                this.mScroller.startScroll(getScrollX(), scrollY, 0, i2);
                ViewCompat.postInvalidateOnAnimation(this);
            } else {
                if (!this.mScroller.isFinished()) {
                    this.mScroller.abortAnimation();
                }
                scrollBy(i, i2);
            }
            this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public final void smoothScrollTo(int i, int i2) {
        smoothScrollBy(i - getScrollX(), i2 - getScrollY());
    }

    public boolean startNestedScroll(int i) {
        return startNestedScroll(i, 0);
    }

    public boolean startNestedScroll(int i, int i2) {
        return this.mChildHelper.startNestedScroll(i, i2);
    }

    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public void stopNestedScroll(int i) {
        this.mChildHelper.stopNestedScroll(i);
    }
}
