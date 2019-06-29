package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final Comparator<ItemInfo> COMPARATOR = new C01821();
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    static final int[] LAYOUT_ATTRS = new int[]{16842931};
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private static final Interpolator sInterpolator = new C01832();
    private static final ViewPositionComparator sPositionComparator = new ViewPositionComparator();
    private int mActivePointerId = -1;
    PagerAdapter mAdapter;
    private List<OnAdapterChangeListener> mAdapterChangeListeners;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable = new C01843();
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout = true;
    private float mFirstOffset = -3.4028235E38f;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList<ItemInfo> mItems = new ArrayList();
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset = Float.MAX_VALUE;
    private EdgeEffect mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets = false;
    private PagerObserver mObserver;
    private int mOffscreenPageLimit = 1;
    private OnPageChangeListener mOnPageChangeListener;
    private List<OnPageChangeListener> mOnPageChangeListeners;
    private int mPageMargin;
    private PageTransformer mPageTransformer;
    private int mPageTransformerLayerType;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState = null;
    private ClassLoader mRestoredClassLoader = null;
    private int mRestoredCurItem = -1;
    private EdgeEffect mRightEdge;
    private int mScrollState = 0;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private final ItemInfo mTempItem = new ItemInfo();
    private final Rect mTempRect = new Rect();
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    /* renamed from: android.support.v4.view.ViewPager$1 */
    static class C01821 implements Comparator<ItemInfo> {
        C01821() {
        }

        public int compare(ItemInfo itemInfo, ItemInfo itemInfo2) {
            return itemInfo.position - itemInfo2.position;
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$2 */
    static class C01832 implements Interpolator {
        C01832() {
        }

        public float getInterpolation(float f) {
            f -= 1.0f;
            return ((((f * f) * f) * f) * f) + 1.0f;
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$3 */
    class C01843 implements Runnable {
        C01843() {
        }

        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.populate();
        }
    }

    @Inherited
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DecorView {
    }

    static class ItemInfo {
        Object object;
        float offset;
        int position;
        boolean scrolling;
        float widthFactor;

        ItemInfo() {
        }
    }

    public static class LayoutParams extends android.view.ViewGroup.LayoutParams {
        int childIndex;
        public int gravity;
        public boolean isDecor;
        boolean needsMeasure;
        int position;
        float widthFactor = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.LAYOUT_ATTRS);
            this.gravity = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    public interface OnAdapterChangeListener {
        void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    public interface PageTransformer {
        void transformPage(View view, float f);
    }

    private class PagerObserver extends DataSetObserver {
        PagerObserver() {
        }

        public void onChanged() {
            ViewPager.this.dataSetChanged();
        }

        public void onInvalidated() {
            ViewPager.this.dataSetChanged();
        }
    }

    static class ViewPositionComparator implements Comparator<View> {
        ViewPositionComparator() {
        }

        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            boolean z = layoutParams.isDecor;
            if (z == layoutParams2.isDecor) {
                return layoutParams.position - layoutParams2.position;
            }
            return z ? 1 : -1;
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$4 */
    class C07754 implements OnApplyWindowInsetsListener {
        private final Rect mTempRect = new Rect();

        C07754() {
        }

        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            WindowInsetsCompat onApplyWindowInsets = ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
            if (onApplyWindowInsets.isConsumed()) {
                return onApplyWindowInsets;
            }
            Rect rect = this.mTempRect;
            rect.left = onApplyWindowInsets.getSystemWindowInsetLeft();
            rect.top = onApplyWindowInsets.getSystemWindowInsetTop();
            rect.right = onApplyWindowInsets.getSystemWindowInsetRight();
            rect.bottom = onApplyWindowInsets.getSystemWindowInsetBottom();
            int childCount = ViewPager.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                WindowInsetsCompat dispatchApplyWindowInsets = ViewCompat.dispatchApplyWindowInsets(ViewPager.this.getChildAt(i), onApplyWindowInsets);
                rect.left = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetLeft(), rect.left);
                rect.top = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetTop(), rect.top);
                rect.right = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetRight(), rect.right);
                rect.bottom = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetBottom(), rect.bottom);
            }
            return onApplyWindowInsets.replaceSystemWindowInsets(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        MyAccessibilityDelegate() {
        }

        private boolean canScroll() {
            PagerAdapter pagerAdapter = ViewPager.this.mAdapter;
            return pagerAdapter != null && pagerAdapter.getCount() > 1;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(canScroll());
            if (accessibilityEvent.getEventType() == 4096) {
                PagerAdapter pagerAdapter = ViewPager.this.mAdapter;
                if (pagerAdapter != null) {
                    accessibilityEvent.setItemCount(pagerAdapter.getCount());
                    accessibilityEvent.setFromIndex(ViewPager.this.mCurItem);
                    accessibilityEvent.setToIndex(ViewPager.this.mCurItem);
                }
            }
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
            accessibilityNodeInfoCompat.setScrollable(canScroll());
            if (ViewPager.this.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            ViewPager viewPager;
            if (i != 4096) {
                if (i != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                viewPager = ViewPager.this;
                i = viewPager.mCurItem - 1;
            } else if (!ViewPager.this.canScrollHorizontally(1)) {
                return false;
            } else {
                viewPager = ViewPager.this;
                i = viewPager.mCurItem + 1;
            }
            viewPager.setCurrentItem(i);
            return true;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new C01851();
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        /* renamed from: android.support.v4.view.ViewPager$SavedState$1 */
        static class C01851 implements ClassLoaderCreator<SavedState> {
            C01851() {
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = SavedState.class.getClassLoader();
            }
            this.position = parcel.readInt();
            this.adapterState = parcel.readParcelable(classLoader);
            this.loader = classLoader;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("FragmentPager.SavedState{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" position=");
            stringBuilder.append(this.position);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.adapterState, i);
        }
    }

    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
        }
    }

    public ViewPager(Context context) {
        super(context);
        initViewPager();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initViewPager();
    }

    private void calculatePageOffsets(ItemInfo itemInfo, int i, ItemInfo itemInfo2) {
        int i2;
        int i3;
        int count = this.mAdapter.getCount();
        int clientWidth = getClientWidth();
        float f = clientWidth > 0 ? ((float) this.mPageMargin) / ((float) clientWidth) : 0.0f;
        if (itemInfo2 != null) {
            int i4 = itemInfo2.position;
            i2 = itemInfo.position;
            ItemInfo itemInfo3;
            if (i4 < i2) {
                float f2 = (itemInfo2.offset + itemInfo2.widthFactor) + f;
                i4++;
                i3 = 0;
                while (i4 <= itemInfo.position && r13 < this.mItems.size()) {
                    while (true) {
                        itemInfo3 = (ItemInfo) this.mItems.get(i3);
                        if (i4 <= itemInfo3.position || i3 >= this.mItems.size() - 1) {
                            while (i4 < itemInfo3.position) {
                                f2 += this.mAdapter.getPageWidth(i4) + f;
                                i4++;
                            }
                        } else {
                            i3++;
                        }
                    }
                    while (i4 < itemInfo3.position) {
                        f2 += this.mAdapter.getPageWidth(i4) + f;
                        i4++;
                    }
                    itemInfo3.offset = f2;
                    f2 += itemInfo3.widthFactor + f;
                    i4++;
                }
            } else if (i4 > i2) {
                i2 = this.mItems.size() - 1;
                float f3 = itemInfo2.offset;
                i4--;
                while (i4 >= itemInfo.position && r4 >= 0) {
                    while (true) {
                        itemInfo3 = (ItemInfo) this.mItems.get(i2);
                        if (i4 >= itemInfo3.position || i2 <= 0) {
                            while (i4 > itemInfo3.position) {
                                f3 -= this.mAdapter.getPageWidth(i4) + f;
                                i4--;
                            }
                        } else {
                            i2--;
                        }
                    }
                    while (i4 > itemInfo3.position) {
                        f3 -= this.mAdapter.getPageWidth(i4) + f;
                        i4--;
                    }
                    f3 -= itemInfo3.widthFactor + f;
                    itemInfo3.offset = f3;
                    i4--;
                }
            }
        }
        i3 = this.mItems.size();
        float f4 = itemInfo.offset;
        i2 = itemInfo.position;
        int i5 = i2 - 1;
        this.mFirstOffset = i2 == 0 ? f4 : -3.4028235E38f;
        count--;
        this.mLastOffset = itemInfo.position == count ? (itemInfo.offset + itemInfo.widthFactor) - 1.0f : Float.MAX_VALUE;
        i2 = i - 1;
        while (i2 >= 0) {
            ItemInfo itemInfo4 = (ItemInfo) this.mItems.get(i2);
            while (true) {
                int i6 = itemInfo4.position;
                if (i5 <= i6) {
                    break;
                }
                f4 -= this.mAdapter.getPageWidth(i5) + f;
                i5--;
            }
            f4 -= itemInfo4.widthFactor + f;
            itemInfo4.offset = f4;
            if (i6 == 0) {
                this.mFirstOffset = f4;
            }
            i2--;
            i5--;
        }
        f4 = (itemInfo.offset + itemInfo.widthFactor) + f;
        int i7 = itemInfo.position + 1;
        i++;
        while (i < i3) {
            ItemInfo itemInfo5 = (ItemInfo) this.mItems.get(i);
            while (true) {
                i5 = itemInfo5.position;
                if (i7 >= i5) {
                    break;
                }
                f4 += this.mAdapter.getPageWidth(i7) + f;
                i7++;
            }
            if (i5 == count) {
                this.mLastOffset = (itemInfo5.widthFactor + f4) - 1.0f;
            }
            itemInfo5.offset = f4;
            f4 += itemInfo5.widthFactor + f;
            i++;
            i7++;
        }
        this.mNeedCalculatePageOffsets = false;
    }

    private void completeScroll(boolean z) {
        Object obj = this.mScrollState == 2 ? 1 : null;
        if (obj != null) {
            setScrollingCacheEnabled(false);
            if ((this.mScroller.isFinished() ^ 1) != 0) {
                this.mScroller.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        pageScrolled(currX);
                    }
                }
            }
        }
        this.mPopulatePending = false;
        Object obj2 = obj;
        for (int i = 0; i < this.mItems.size(); i++) {
            ItemInfo itemInfo = (ItemInfo) this.mItems.get(i);
            if (itemInfo.scrolling) {
                itemInfo.scrolling = false;
                obj2 = 1;
            }
        }
        if (obj2 == null) {
            return;
        }
        if (z) {
            ViewCompat.postOnAnimation(this, this.mEndScrollRunnable);
        } else {
            this.mEndScrollRunnable.run();
        }
    }

    private int determineTargetPage(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.mFlingDistance || Math.abs(i2) <= this.mMinimumVelocity) {
            i += (int) (f + (i >= this.mCurItem ? 0.4f : 0.6f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.mItems.size() <= 0) {
            return i;
        }
        ItemInfo itemInfo = (ItemInfo) this.mItems.get(0);
        ArrayList arrayList = this.mItems;
        return Math.max(itemInfo.position, Math.min(i, ((ItemInfo) arrayList.get(arrayList.size() - 1)).position));
    }

    private void dispatchOnPageScrolled(int i, float f, int i2) {
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i, f, i2);
        }
        List list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                OnPageChangeListener onPageChangeListener2 = (OnPageChangeListener) this.mOnPageChangeListeners.get(i3);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.onPageScrolled(i, f, i2);
                }
            }
        }
        onPageChangeListener = this.mInternalPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    private void dispatchOnPageSelected(int i) {
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i);
        }
        List list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnPageChangeListener onPageChangeListener2 = (OnPageChangeListener) this.mOnPageChangeListeners.get(i2);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.onPageSelected(i);
                }
            }
        }
        onPageChangeListener = this.mInternalPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i);
        }
    }

    private void dispatchOnScrollStateChanged(int i) {
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i);
        }
        List list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnPageChangeListener onPageChangeListener2 = (OnPageChangeListener) this.mOnPageChangeListeners.get(i2);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.onPageScrollStateChanged(i);
                }
            }
        }
        onPageChangeListener = this.mInternalPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i);
        }
    }

    private void enableLayers(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setLayerType(z ? this.mPageTransformerLayerType : 0, null);
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewPager parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private ItemInfo infoForCurrentScrollPosition() {
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f = clientWidth > 0 ? ((float) this.mPageMargin) / ((float) clientWidth) : 0.0f;
        ItemInfo itemInfo = null;
        int i = 0;
        Object obj = 1;
        int i2 = -1;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (i < this.mItems.size()) {
            ItemInfo itemInfo2 = (ItemInfo) this.mItems.get(i);
            if (obj == null) {
                i2++;
                if (itemInfo2.position != i2) {
                    itemInfo2 = this.mTempItem;
                    itemInfo2.offset = (f2 + f3) + f;
                    itemInfo2.position = i2;
                    itemInfo2.widthFactor = this.mAdapter.getPageWidth(itemInfo2.position);
                    i--;
                }
            }
            f2 = itemInfo2.offset;
            float f4 = (itemInfo2.widthFactor + f2) + f;
            if (obj == null) {
                if (scrollX < f2) {
                    return itemInfo;
                }
            }
            if (scrollX >= f4) {
                if (i != this.mItems.size() - 1) {
                    i2 = itemInfo2.position;
                    f3 = itemInfo2.widthFactor;
                    i++;
                    itemInfo = itemInfo2;
                    obj = null;
                }
            }
            return itemInfo2;
        }
        return itemInfo;
    }

    private static boolean isDecorView(View view) {
        return view.getClass().getAnnotation(DecorView.class) != null;
    }

    private boolean isGutterDrag(float f, float f2) {
        return (f < ((float) this.mGutterSize) && f2 > 0.0f) || (f > ((float) (getWidth() - this.mGutterSize)) && f2 < 0.0f);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            actionIndex = actionIndex == 0 ? 1 : 0;
            this.mLastMotionX = motionEvent.getX(actionIndex);
            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private boolean pageScrolled(int i) {
        String str = "onPageScrolled did not call superclass implementation";
        if (this.mItems.size() != 0) {
            ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            int clientWidth = getClientWidth();
            int i2 = this.mPageMargin;
            int i3 = clientWidth + i2;
            float f = (float) clientWidth;
            float f2 = ((float) i2) / f;
            int i4 = infoForCurrentScrollPosition.position;
            float f3 = ((((float) i) / f) - infoForCurrentScrollPosition.offset) / (infoForCurrentScrollPosition.widthFactor + f2);
            int i5 = (int) (((float) i3) * f3);
            this.mCalledSuper = false;
            onPageScrolled(i4, f3, i5);
            if (this.mCalledSuper) {
                return true;
            }
            throw new IllegalStateException(str);
        } else if (this.mFirstLayout) {
            return false;
        } else {
            this.mCalledSuper = false;
            onPageScrolled(0, 0.0f, 0);
            if (this.mCalledSuper) {
                return false;
            }
            throw new IllegalStateException(str);
        }
    }

    private boolean performDrag(float f) {
        Object obj;
        Object obj2;
        float f2 = this.mLastMotionX - f;
        this.mLastMotionX = f;
        f = ((float) getScrollX()) + f2;
        f2 = (float) getClientWidth();
        float f3 = this.mFirstOffset * f2;
        float f4 = this.mLastOffset * f2;
        boolean z = false;
        ItemInfo itemInfo = (ItemInfo) this.mItems.get(0);
        ArrayList arrayList = this.mItems;
        ItemInfo itemInfo2 = (ItemInfo) arrayList.get(arrayList.size() - 1);
        if (itemInfo.position != 0) {
            f3 = itemInfo.offset * f2;
            obj = null;
        } else {
            obj = 1;
        }
        if (itemInfo2.position != this.mAdapter.getCount() - 1) {
            f4 = itemInfo2.offset * f2;
            obj2 = null;
        } else {
            obj2 = 1;
        }
        if (f < f3) {
            if (obj != null) {
                this.mLeftEdge.onPull(Math.abs(f3 - f) / f2);
                z = true;
            }
            f = f3;
        } else if (f > f4) {
            if (obj2 != null) {
                this.mRightEdge.onPull(Math.abs(f - f4) / f2);
                z = true;
            }
            f = f4;
        }
        int i = (int) f;
        this.mLastMotionX += f - ((float) i);
        scrollTo(i, getScrollY());
        pageScrolled(i);
        return z;
    }

    private void recomputeScrollPosition(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.mItems.isEmpty()) {
            ItemInfo infoForPosition = infoForPosition(this.mCurItem);
            i = (int) ((infoForPosition != null ? Math.min(infoForPosition.offset, this.mLastOffset) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (i != getScrollX()) {
                completeScroll(false);
            } else {
                return;
            }
        } else if (this.mScroller.isFinished()) {
            i = (int) ((((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))) * ((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)));
        } else {
            this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
            return;
        }
        scrollTo(i, getScrollY());
    }

    private void removeNonDecorViews() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((LayoutParams) getChildAt(i).getLayoutParams()).isDecor) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    private void requestParentDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean resetTouch() {
        this.mActivePointerId = -1;
        endDrag();
        this.mLeftEdge.onRelease();
        this.mRightEdge.onRelease();
        if (!this.mLeftEdge.isFinished()) {
            if (!this.mRightEdge.isFinished()) {
                return false;
            }
        }
        return true;
    }

    private void scrollToItem(int i, boolean z, int i2, boolean z2) {
        ItemInfo infoForPosition = infoForPosition(i);
        int clientWidth = infoForPosition != null ? (int) (((float) getClientWidth()) * Math.max(this.mFirstOffset, Math.min(infoForPosition.offset, this.mLastOffset))) : 0;
        if (z) {
            smoothScrollTo(clientWidth, 0, i2);
            if (z2) {
                dispatchOnPageSelected(i);
                return;
            }
            return;
        }
        if (z2) {
            dispatchOnPageSelected(i);
        }
        completeScroll(false);
        scrollTo(clientWidth, 0);
        pageScrolled(clientWidth);
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.mScrollingCacheEnabled != z) {
            this.mScrollingCacheEnabled = z;
        }
    }

    private void sortChildDrawingOrder() {
        if (this.mDrawingOrder != 0) {
            ArrayList arrayList = this.mDrawingOrderedChildren;
            if (arrayList == null) {
                this.mDrawingOrderedChildren = new ArrayList();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.mDrawingOrderedChildren.add(getChildAt(i));
            }
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    ItemInfo infoForChild = infoForChild(childAt);
                    if (infoForChild != null && infoForChild.position == this.mCurItem) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (!(((i2 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null)) {
            arrayList.add(this);
        }
    }

    ItemInfo addNewItem(int i, int i2) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.position = i;
        itemInfo.object = this.mAdapter.instantiateItem((ViewGroup) this, i);
        itemInfo.widthFactor = this.mAdapter.getPageWidth(i);
        if (i2 >= 0) {
            if (i2 < this.mItems.size()) {
                this.mItems.add(i2, itemInfo);
                return itemInfo;
            }
        }
        this.mItems.add(itemInfo);
        return itemInfo;
    }

    public void addOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        if (this.mAdapterChangeListeners == null) {
            this.mAdapterChangeListeners = new ArrayList();
        }
        this.mAdapterChangeListeners.add(onAdapterChangeListener);
    }

    public void addOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList();
        }
        this.mOnPageChangeListeners.add(onPageChangeListener);
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                ItemInfo infoForChild = infoForChild(childAt);
                if (infoForChild != null && infoForChild.position == this.mCurItem) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        layoutParams2.isDecor |= isDecorView(view);
        if (this.mInLayout) {
            if (layoutParams2 != null) {
                if (layoutParams2.isDecor) {
                    throw new IllegalStateException("Cannot add pager decor view during layout");
                }
            }
            layoutParams2.needsMeasure = true;
            addViewInLayout(view, i, layoutParams);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    public boolean arrowScroll(int i) {
        View findFocus = findFocus();
        boolean z = false;
        View view = null;
        if (findFocus != this) {
            if (findFocus != null) {
                Object obj;
                for (ViewPager parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == this) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        stringBuilder.append(" => ");
                        stringBuilder.append(parent2.getClass().getSimpleName());
                    }
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("arrowScroll tried to find focus based on non-child current focused view ");
                    stringBuilder2.append(stringBuilder.toString());
                    Log.e(TAG, stringBuilder2.toString());
                }
            }
            view = findFocus;
        }
        findFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findFocus == null || findFocus == view) {
            if (i != 17) {
                if (i != 1) {
                    if (i == 66 || i == 2) {
                        z = pageRight();
                    }
                }
            }
            z = pageLeft();
        } else {
            boolean pageLeft;
            int i2;
            int i3;
            if (i == 17) {
                i2 = getChildRectInPagerCoordinates(this.mTempRect, findFocus).left;
                i3 = getChildRectInPagerCoordinates(this.mTempRect, view).left;
                if (view != null && i2 >= i3) {
                    pageLeft = pageLeft();
                    z = pageLeft;
                }
            } else if (i == 66) {
                i2 = getChildRectInPagerCoordinates(this.mTempRect, findFocus).left;
                i3 = getChildRectInPagerCoordinates(this.mTempRect, view).left;
                if (view != null && i2 <= i3) {
                    pageLeft = pageRight();
                    z = pageLeft;
                }
            }
            pageLeft = findFocus.requestFocus();
            z = pageLeft;
        }
        if (z) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return z;
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return false;
        }
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
        this.mFakeDragBeginTime = uptimeMillis;
        return true;
    }

    protected boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        View view2 = view;
        boolean z2 = true;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i4 = i2 + scrollX;
                if (i4 >= childAt.getLeft() && i4 < childAt.getRight()) {
                    int i5 = i3 + scrollY;
                    if (i5 >= childAt.getTop() && i5 < childAt.getBottom()) {
                        if (canScroll(childAt, true, i, i4 - childAt.getLeft(), i5 - childAt.getTop())) {
                            return true;
                        }
                    }
                }
            }
        }
        if (!z || !view.canScrollHorizontally(-i)) {
            z2 = false;
        }
        return z2;
    }

    public boolean canScrollHorizontally(int i) {
        boolean z = false;
        if (this.mAdapter == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX > ((int) (((float) clientWidth) * this.mFirstOffset))) {
                z = true;
            }
            return z;
        }
        if (i > 0 && scrollX < ((int) (((float) clientWidth) * this.mLastOffset))) {
            z = true;
        }
        return z;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void clearOnPageChangeListeners() {
        List list = this.mOnPageChangeListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void computeScroll() {
        this.mIsScrollStarted = true;
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            completeScroll(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mScroller.getCurrX();
        int currY = this.mScroller.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!pageScrolled(currX)) {
                this.mScroller.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    void dataSetChanged() {
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        Object obj = (this.mItems.size() >= (this.mOffscreenPageLimit * 2) + 1 || this.mItems.size() >= count) ? null : 1;
        Object obj2 = obj;
        int i = this.mCurItem;
        int i2 = 0;
        Object obj3 = null;
        while (i2 < this.mItems.size()) {
            ItemInfo itemInfo = (ItemInfo) this.mItems.get(i2);
            int itemPosition = this.mAdapter.getItemPosition(itemInfo.object);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.mItems.remove(i2);
                    i2--;
                    if (obj3 == null) {
                        this.mAdapter.startUpdate((ViewGroup) this);
                        obj3 = 1;
                    }
                    this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
                    int i3 = this.mCurItem;
                    if (i3 == itemInfo.position) {
                        i = Math.max(0, Math.min(i3, count - 1));
                    }
                } else {
                    int i4 = itemInfo.position;
                    if (i4 != itemPosition) {
                        if (i4 == this.mCurItem) {
                            i = itemPosition;
                        }
                        itemInfo.position = itemPosition;
                    }
                }
                obj2 = 1;
            }
            i2++;
        }
        if (obj3 != null) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (obj2 != null) {
            count = getChildCount();
            for (i2 = 0; i2 < count; i2++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
                if (!layoutParams.isDecor) {
                    layoutParams.widthFactor = 0.0f;
                }
            }
            setCurrentItemInternal(i, false, true);
            requestLayout();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!super.dispatchKeyEvent(keyEvent)) {
            if (!executeKeyEvent(keyEvent)) {
                return false;
            }
        }
        return true;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                ItemInfo infoForChild = infoForChild(childAt);
                if (infoForChild != null && infoForChild.position == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    float distanceInfluenceForSnapDuration(float f) {
        return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        int i = 0;
        if (overScrollMode != 0) {
            if (overScrollMode == 1) {
                PagerAdapter pagerAdapter = this.mAdapter;
                if (pagerAdapter != null && pagerAdapter.getCount() > 1) {
                }
            }
            this.mLeftEdge.finish();
            this.mRightEdge.finish();
            if (i != 0) {
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }
        if (!this.mLeftEdge.isFinished()) {
            overScrollMode = canvas.save();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int width = getWidth();
            canvas.rotate(270.0f);
            canvas.translate((float) ((-height) + getPaddingTop()), this.mFirstOffset * ((float) width));
            this.mLeftEdge.setSize(height, width);
            i = 0 | this.mLeftEdge.draw(canvas);
            canvas.restoreToCount(overScrollMode);
        }
        if (!this.mRightEdge.isFinished()) {
            overScrollMode = canvas.save();
            height = getWidth();
            width = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(90.0f);
            canvas.translate((float) (-getPaddingTop()), (-(this.mLastOffset + 1.0f)) * ((float) height));
            this.mRightEdge.setSize(width, height);
            i |= this.mRightEdge.draw(canvas);
            canvas.restoreToCount(overScrollMode);
        }
        if (i != 0) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public void endFakeDrag() {
        if (this.mFakeDragging) {
            if (this.mAdapter != null) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
                int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
                this.mPopulatePending = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.position, ((((float) scrollX) / ((float) clientWidth)) - infoForCurrentScrollPosition.offset) / infoForCurrentScrollPosition.widthFactor, xVelocity, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, xVelocity);
            }
            endDrag();
            this.mFakeDragging = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int i;
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode != 22) {
                    if (keyCode == 61) {
                        if (keyEvent.hasNoModifiers()) {
                            return arrowScroll(2);
                        }
                        if (keyEvent.hasModifiers(1)) {
                            return arrowScroll(1);
                        }
                    }
                } else if (keyEvent.hasModifiers(2)) {
                    return pageRight();
                } else {
                    i = 66;
                }
            } else if (keyEvent.hasModifiers(2)) {
                return pageLeft();
            } else {
                i = 17;
            }
            return arrowScroll(i);
        }
        return false;
    }

    public void fakeDragBy(float f) {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        } else if (this.mAdapter != null) {
            this.mLastMotionX += f;
            float scrollX = ((float) getScrollX()) - f;
            f = (float) getClientWidth();
            float f2 = this.mFirstOffset * f;
            float f3 = this.mLastOffset * f;
            ItemInfo itemInfo = (ItemInfo) this.mItems.get(0);
            ArrayList arrayList = this.mItems;
            ItemInfo itemInfo2 = (ItemInfo) arrayList.get(arrayList.size() - 1);
            if (itemInfo.position != 0) {
                f2 = itemInfo.offset * f;
            }
            if (itemInfo2.position != this.mAdapter.getCount() - 1) {
                f3 = itemInfo2.offset * f;
            }
            if (scrollX < f2) {
                scrollX = f2;
            } else if (scrollX > f3) {
                scrollX = f3;
            }
            int i = (int) scrollX;
            this.mLastMotionX += scrollX - ((float) i);
            scrollTo(i, getScrollY());
            pageScrolled(i);
            MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
            this.mVelocityTracker.addMovement(obtain);
            obtain.recycle();
        }
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.mDrawingOrder == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) ((View) this.mDrawingOrderedChildren.get(i2)).getLayoutParams()).childIndex;
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    ItemInfo infoForAnyChild(View view) {
        while (true) {
            ViewPager parent = view.getParent();
            if (parent == this) {
                return infoForChild(view);
            }
            if (parent == null) {
                break;
            } else if (!(parent instanceof View)) {
                break;
            } else {
                view = parent;
            }
        }
        return null;
    }

    ItemInfo infoForChild(View view) {
        for (int i = 0; i < this.mItems.size(); i++) {
            ItemInfo itemInfo = (ItemInfo) this.mItems.get(i);
            if (this.mAdapter.isViewFromObject(view, itemInfo.object)) {
                return itemInfo;
            }
        }
        return null;
    }

    ItemInfo infoForPosition(int i) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            ItemInfo itemInfo = (ItemInfo) this.mItems.get(i2);
            if (itemInfo.position == i) {
                return itemInfo;
            }
        }
        return null;
    }

    void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int) (400.0f * f);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffect(context);
        this.mRightEdge = new EdgeEffect(context);
        this.mFlingDistance = (int) (25.0f * f);
        this.mCloseEnough = (int) (2.0f * f);
        this.mDefaultGutterSize = (int) (f * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new MyAccessibilityDelegate());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        ViewCompat.setOnApplyWindowInsetsListener(this, new C07754());
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        Scroller scroller = this.mScroller;
        if (!(scroller == null || scroller.isFinished())) {
            this.mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mPageMargin > 0 && r0.mMarginDrawable != null && r0.mItems.size() > 0 && r0.mAdapter != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = (float) width;
            float f2 = ((float) r0.mPageMargin) / f;
            int i = 0;
            ItemInfo itemInfo = (ItemInfo) r0.mItems.get(0);
            float f3 = itemInfo.offset;
            int size = r0.mItems.size();
            int i2 = itemInfo.position;
            int i3 = ((ItemInfo) r0.mItems.get(size - 1)).position;
            while (i2 < i3) {
                float f4;
                float f5;
                while (i2 > itemInfo.position && i < size) {
                    i++;
                    itemInfo = (ItemInfo) r0.mItems.get(i);
                }
                float f6;
                if (i2 == itemInfo.position) {
                    f3 = itemInfo.offset;
                    f6 = itemInfo.widthFactor;
                    f4 = (f3 + f6) * f;
                    f3 = (f3 + f6) + f2;
                } else {
                    f6 = r0.mAdapter.getPageWidth(i2);
                    f4 = (f3 + f6) * f;
                    f3 += f6 + f2;
                }
                if (((float) r0.mPageMargin) + f4 > ((float) scrollX)) {
                    f5 = f2;
                    r0.mMarginDrawable.setBounds(Math.round(f4), r0.mTopPageBounds, Math.round(((float) r0.mPageMargin) + f4), r0.mBottomPageBounds);
                    r0.mMarginDrawable.draw(canvas);
                } else {
                    Canvas canvas2 = canvas;
                    f5 = f2;
                }
                if (f4 <= ((float) (scrollX + width))) {
                    i2++;
                    f2 = f5;
                } else {
                    return;
                }
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewPager viewPager = this;
        MotionEvent motionEvent2 = motionEvent;
        int action = motionEvent.getAction() & 255;
        if (action != 3) {
            if (action != 1) {
                if (action != 0) {
                    if (viewPager.mIsBeingDragged) {
                        return true;
                    }
                    if (viewPager.mIsUnableToDrag) {
                        return false;
                    }
                }
                if (action == 0) {
                    float x = motionEvent.getX();
                    viewPager.mInitialMotionX = x;
                    viewPager.mLastMotionX = x;
                    x = motionEvent.getY();
                    viewPager.mInitialMotionY = x;
                    viewPager.mLastMotionY = x;
                    viewPager.mActivePointerId = motionEvent2.getPointerId(0);
                    viewPager.mIsUnableToDrag = false;
                    viewPager.mIsScrollStarted = true;
                    viewPager.mScroller.computeScrollOffset();
                    if (viewPager.mScrollState != 2 || Math.abs(viewPager.mScroller.getFinalX() - viewPager.mScroller.getCurrX()) <= viewPager.mCloseEnough) {
                        completeScroll(false);
                        viewPager.mIsBeingDragged = false;
                    } else {
                        viewPager.mScroller.abortAnimation();
                        viewPager.mPopulatePending = false;
                        populate();
                        viewPager.mIsBeingDragged = true;
                        requestParentDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                } else if (action == 2) {
                    action = viewPager.mActivePointerId;
                    if (action != -1) {
                        action = motionEvent2.findPointerIndex(action);
                        float x2 = motionEvent2.getX(action);
                        float f = x2 - viewPager.mLastMotionX;
                        float abs = Math.abs(f);
                        float y = motionEvent2.getY(action);
                        float abs2 = Math.abs(y - viewPager.mInitialMotionY);
                        if (f == 0.0f || isGutterDrag(viewPager.mLastMotionX, f) || !canScroll(this, false, (int) f, (int) x2, (int) y)) {
                            if (abs > ((float) viewPager.mTouchSlop) && abs * 0.5f > abs2) {
                                viewPager.mIsBeingDragged = true;
                                requestParentDisallowInterceptTouchEvent(true);
                                setScrollState(1);
                                viewPager.mLastMotionX = f > 0.0f ? viewPager.mInitialMotionX + ((float) viewPager.mTouchSlop) : viewPager.mInitialMotionX - ((float) viewPager.mTouchSlop);
                                viewPager.mLastMotionY = y;
                                setScrollingCacheEnabled(true);
                            } else if (abs2 > ((float) viewPager.mTouchSlop)) {
                                viewPager.mIsUnableToDrag = true;
                            }
                            if (viewPager.mIsBeingDragged && performDrag(x2)) {
                                ViewCompat.postInvalidateOnAnimation(this);
                            }
                        } else {
                            viewPager.mLastMotionX = x2;
                            viewPager.mLastMotionY = y;
                            viewPager.mIsUnableToDrag = true;
                            return false;
                        }
                    }
                } else if (action == 6) {
                    onSecondaryPointerUp(motionEvent);
                }
                if (viewPager.mVelocityTracker == null) {
                    viewPager.mVelocityTracker = VelocityTracker.obtain();
                }
                viewPager.mVelocityTracker.addMovement(motionEvent2);
                return viewPager.mIsBeingDragged;
            }
        }
        resetTouch();
        return false;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        ViewGroup viewGroup = this;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = paddingBottom;
        int i8 = 0;
        paddingBottom = paddingTop;
        paddingTop = paddingLeft;
        for (paddingLeft = 0; paddingLeft < childCount; paddingLeft++) {
            View childAt = getChildAt(paddingLeft);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    int i9 = layoutParams.gravity;
                    int i10 = i9 & 7;
                    i9 &= 112;
                    if (i10 == 1) {
                        i10 = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingTop);
                    } else if (i10 == 3) {
                        i10 = paddingTop;
                        paddingTop = childAt.getMeasuredWidth() + paddingTop;
                    } else if (i10 != 5) {
                        i10 = paddingTop;
                    } else {
                        i10 = (i5 - paddingRight) - childAt.getMeasuredWidth();
                        paddingRight += childAt.getMeasuredWidth();
                    }
                    if (i9 == 16) {
                        i9 = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingBottom);
                    } else if (i9 == 48) {
                        i9 = paddingBottom;
                        paddingBottom = childAt.getMeasuredHeight() + paddingBottom;
                    } else if (i9 != 80) {
                        i9 = paddingBottom;
                    } else {
                        i9 = (i6 - i7) - childAt.getMeasuredHeight();
                        i7 += childAt.getMeasuredHeight();
                    }
                    i10 += scrollX;
                    childAt.layout(i10, i9, childAt.getMeasuredWidth() + i10, i9 + childAt.getMeasuredHeight());
                    i8++;
                }
            }
        }
        i5 = (i5 - paddingTop) - paddingRight;
        for (paddingLeft = 0; paddingLeft < childCount; paddingLeft++) {
            View childAt2 = getChildAt(paddingLeft);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.isDecor) {
                    ItemInfo infoForChild = infoForChild(childAt2);
                    if (infoForChild != null) {
                        float f = (float) i5;
                        int i11 = ((int) (infoForChild.offset * f)) + paddingTop;
                        if (layoutParams2.needsMeasure) {
                            layoutParams2.needsMeasure = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (f * layoutParams2.widthFactor), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingBottom) - i7, 1073741824));
                        }
                        childAt2.layout(i11, paddingBottom, childAt2.getMeasuredWidth() + i11, childAt2.getMeasuredHeight() + paddingBottom);
                    }
                }
            }
        }
        viewGroup.mTopPageBounds = paddingBottom;
        viewGroup.mBottomPageBounds = i6 - i7;
        viewGroup.mDecorChildCount = i8;
        if (viewGroup.mFirstLayout) {
            z2 = false;
            scrollToItem(viewGroup.mCurItem, false, 0, false);
        } else {
            z2 = false;
        }
        viewGroup.mFirstLayout = z2;
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        setMeasuredDimension(ViewGroup.getDefaultSize(0, i), ViewGroup.getDefaultSize(0, i2));
        i = getMeasuredWidth();
        this.mGutterSize = Math.min(i / 10, this.mDefaultGutterSize);
        i = (i - getPaddingLeft()) - getPaddingRight();
        i2 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i4 = i2;
        i2 = i;
        i = 0;
        while (true) {
            boolean z = true;
            int i5 = 1073741824;
            if (i >= childCount) {
                break;
            }
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null && layoutParams.isDecor) {
                    Object obj;
                    int i6;
                    int i7;
                    int i8;
                    int i9 = layoutParams.gravity;
                    int i10 = i9 & 7;
                    i9 &= 112;
                    if (i9 != 48) {
                        if (i9 != 80) {
                            obj = null;
                            if (i10 != 3) {
                                if (i10 == 5) {
                                    z = false;
                                }
                            }
                            i10 = Integer.MIN_VALUE;
                            if (obj != null) {
                                i10 = 1073741824;
                            } else if (z) {
                                i6 = 1073741824;
                                i7 = layoutParams.width;
                                if (i7 == -2) {
                                    if (i7 == -1) {
                                        i7 = i2;
                                    }
                                    i10 = 1073741824;
                                } else {
                                    i7 = i2;
                                }
                                i8 = layoutParams.height;
                                if (i8 == -2) {
                                    i8 = i4;
                                    i5 = i6;
                                } else if (i8 == -1) {
                                    i8 = i4;
                                }
                                childAt.measure(MeasureSpec.makeMeasureSpec(i7, i10), MeasureSpec.makeMeasureSpec(i8, i5));
                                if (obj == null) {
                                    i4 -= childAt.getMeasuredHeight();
                                } else if (!z) {
                                    i2 -= childAt.getMeasuredWidth();
                                }
                            }
                            i6 = Integer.MIN_VALUE;
                            i7 = layoutParams.width;
                            if (i7 == -2) {
                                i7 = i2;
                            } else {
                                if (i7 == -1) {
                                    i7 = i2;
                                }
                                i10 = 1073741824;
                            }
                            i8 = layoutParams.height;
                            if (i8 == -2) {
                                i8 = i4;
                                i5 = i6;
                            } else if (i8 == -1) {
                                i8 = i4;
                            }
                            childAt.measure(MeasureSpec.makeMeasureSpec(i7, i10), MeasureSpec.makeMeasureSpec(i8, i5));
                            if (obj == null) {
                                i4 -= childAt.getMeasuredHeight();
                            } else if (!z) {
                                i2 -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    obj = 1;
                    if (i10 != 3) {
                        if (i10 == 5) {
                            z = false;
                        }
                    }
                    i10 = Integer.MIN_VALUE;
                    if (obj != null) {
                        i10 = 1073741824;
                    } else if (z) {
                        i6 = 1073741824;
                        i7 = layoutParams.width;
                        if (i7 == -2) {
                            if (i7 == -1) {
                                i7 = i2;
                            }
                            i10 = 1073741824;
                        } else {
                            i7 = i2;
                        }
                        i8 = layoutParams.height;
                        if (i8 == -2) {
                            i8 = i4;
                            i5 = i6;
                        } else if (i8 == -1) {
                            i8 = i4;
                        }
                        childAt.measure(MeasureSpec.makeMeasureSpec(i7, i10), MeasureSpec.makeMeasureSpec(i8, i5));
                        if (obj == null) {
                            i4 -= childAt.getMeasuredHeight();
                        } else if (!z) {
                            i2 -= childAt.getMeasuredWidth();
                        }
                    }
                    i6 = Integer.MIN_VALUE;
                    i7 = layoutParams.width;
                    if (i7 == -2) {
                        i7 = i2;
                    } else {
                        if (i7 == -1) {
                            i7 = i2;
                        }
                        i10 = 1073741824;
                    }
                    i8 = layoutParams.height;
                    if (i8 == -2) {
                        i8 = i4;
                        i5 = i6;
                    } else if (i8 == -1) {
                        i8 = i4;
                    }
                    childAt.measure(MeasureSpec.makeMeasureSpec(i7, i10), MeasureSpec.makeMeasureSpec(i8, i5));
                    if (obj == null) {
                        i4 -= childAt.getMeasuredHeight();
                    } else if (!z) {
                        i2 -= childAt.getMeasuredWidth();
                    }
                }
            }
            i++;
        }
        this.mChildWidthMeasureSpec = MeasureSpec.makeMeasureSpec(i2, 1073741824);
        this.mChildHeightMeasureSpec = MeasureSpec.makeMeasureSpec(i4, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        i = getChildCount();
        while (i3 < i) {
            View childAt2 = getChildAt(i3);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (layoutParams2 == null || !layoutParams2.isDecor) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (((float) i2) * layoutParams2.widthFactor), 1073741824), this.mChildHeightMeasureSpec);
                }
            }
            i3++;
        }
    }

    protected void onPageScrolled(int i, float f, int i2) {
        if (this.mDecorChildCount > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            int i3 = paddingRight;
            paddingRight = paddingLeft;
            for (paddingLeft = 0; paddingLeft < childCount; paddingLeft++) {
                View childAt = getChildAt(paddingLeft);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    int i4 = layoutParams.gravity & 7;
                    if (i4 != 1) {
                        if (i4 == 3) {
                            i4 = childAt.getWidth() + paddingRight;
                        } else if (i4 != 5) {
                            i4 = paddingRight;
                        } else {
                            i4 = (width - i3) - childAt.getMeasuredWidth();
                            i3 += childAt.getMeasuredWidth();
                        }
                        paddingRight = (paddingRight + scrollX) - childAt.getLeft();
                        if (paddingRight != 0) {
                            childAt.offsetLeftAndRight(paddingRight);
                        }
                        paddingRight = i4;
                    } else {
                        i4 = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingRight);
                    }
                    int i5 = i4;
                    i4 = paddingRight;
                    paddingRight = i5;
                    paddingRight = (paddingRight + scrollX) - childAt.getLeft();
                    if (paddingRight != 0) {
                        childAt.offsetLeftAndRight(paddingRight);
                    }
                    paddingRight = i4;
                }
            }
        }
        dispatchOnPageScrolled(i, f, i2);
        if (this.mPageTransformer != null) {
            i = getScrollX();
            int childCount2 = getChildCount();
            for (int i6 = 0; i6 < childCount2; i6++) {
                View childAt2 = getChildAt(i6);
                if (!((LayoutParams) childAt2.getLayoutParams()).isDecor) {
                    this.mPageTransformer.transformPage(childAt2, ((float) (childAt2.getLeft() - i)) / ((float) getClientWidth()));
                }
            }
        }
        this.mCalledSuper = true;
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int childCount = getChildCount();
        int i3 = -1;
        if ((i & 2) != 0) {
            i3 = childCount;
            childCount = 0;
            i2 = 1;
        } else {
            childCount--;
            i2 = -1;
        }
        while (childCount != i3) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                ItemInfo infoForChild = infoForChild(childAt);
                if (infoForChild != null && infoForChild.position == this.mCurItem && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            childCount += i2;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            PagerAdapter pagerAdapter = this.mAdapter;
            if (pagerAdapter != null) {
                pagerAdapter.restoreState(savedState.adapterState, savedState.loader);
                setCurrentItemInternal(savedState.position, false, true);
            } else {
                this.mRestoredCurItem = savedState.position;
                this.mRestoredAdapterState = savedState.adapterState;
                this.mRestoredClassLoader = savedState.loader;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.mCurItem;
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter != null) {
            savedState.adapterState = pagerAdapter.saveState();
        }
        return savedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            i2 = this.mPageMargin;
            recomputeScrollPosition(i, i3, i2, i2);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mFakeDragging) {
            return true;
        }
        boolean z = false;
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter != null) {
            if (pagerAdapter.getCount() != 0) {
                int pointerId;
                if (this.mVelocityTracker == null) {
                    this.mVelocityTracker = VelocityTracker.obtain();
                }
                this.mVelocityTracker.addMovement(motionEvent);
                int action = motionEvent.getAction() & 255;
                float y;
                if (action != 0) {
                    if (action == 1) {
                        if (this.mIsBeingDragged) {
                            VelocityTracker velocityTracker = this.mVelocityTracker;
                            velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
                            action = (int) velocityTracker.getXVelocity(this.mActivePointerId);
                            this.mPopulatePending = true;
                            int clientWidth = getClientWidth();
                            int scrollX = getScrollX();
                            ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                            float f = (float) clientWidth;
                            setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.position, ((((float) scrollX) / f) - infoForCurrentScrollPosition.offset) / (infoForCurrentScrollPosition.widthFactor + (((float) this.mPageMargin) / f)), action, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX)), true, true, action);
                        }
                        if (z) {
                            ViewCompat.postInvalidateOnAnimation(this);
                        }
                        return true;
                    } else if (action != 2) {
                        if (action != 3) {
                            if (action == 5) {
                                action = motionEvent.getActionIndex();
                                this.mLastMotionX = motionEvent.getX(action);
                                pointerId = motionEvent.getPointerId(action);
                            } else if (action == 6) {
                                onSecondaryPointerUp(motionEvent);
                                this.mLastMotionX = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                            }
                        } else if (this.mIsBeingDragged) {
                            scrollToItem(this.mCurItem, true, 0, false);
                        }
                        if (z) {
                            ViewCompat.postInvalidateOnAnimation(this);
                        }
                        return true;
                    } else {
                        if (!this.mIsBeingDragged) {
                            action = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (action != -1) {
                                float x = motionEvent.getX(action);
                                float abs = Math.abs(x - this.mLastMotionX);
                                y = motionEvent.getY(action);
                                float abs2 = Math.abs(y - this.mLastMotionY);
                                if (abs > ((float) this.mTouchSlop) && abs > abs2) {
                                    this.mIsBeingDragged = true;
                                    requestParentDisallowInterceptTouchEvent(true);
                                    abs = this.mInitialMotionX;
                                    this.mLastMotionX = x - abs > 0.0f ? abs + ((float) this.mTouchSlop) : abs - ((float) this.mTouchSlop);
                                    this.mLastMotionY = y;
                                    setScrollState(1);
                                    setScrollingCacheEnabled(true);
                                    ViewParent parent = getParent();
                                    if (parent != null) {
                                        parent.requestDisallowInterceptTouchEvent(true);
                                    }
                                }
                            }
                        }
                        if (this.mIsBeingDragged) {
                            z = false | performDrag(motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)));
                        }
                        if (z) {
                            ViewCompat.postInvalidateOnAnimation(this);
                        }
                        return true;
                    }
                    z = resetTouch();
                    if (z) {
                        ViewCompat.postInvalidateOnAnimation(this);
                    }
                    return true;
                }
                this.mScroller.abortAnimation();
                this.mPopulatePending = false;
                populate();
                y = motionEvent.getX();
                this.mInitialMotionX = y;
                this.mLastMotionX = y;
                y = motionEvent.getY();
                this.mInitialMotionY = y;
                this.mLastMotionY = y;
                pointerId = motionEvent.getPointerId(0);
                this.mActivePointerId = pointerId;
                if (z) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                return true;
            }
        }
        return false;
    }

    boolean pageLeft() {
        int i = this.mCurItem;
        if (i <= 0) {
            return false;
        }
        setCurrentItem(i - 1, true);
        return true;
    }

    boolean pageRight() {
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter == null || this.mCurItem >= pagerAdapter.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    }

    void populate() {
        populate(this.mCurItem);
    }

    void populate(int r18) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r17 = this;
        r0 = r17;
        r1 = r18;
        r2 = r0.mCurItem;
        if (r2 == r1) goto L_0x000f;
    L_0x0008:
        r2 = r0.infoForPosition(r2);
        r0.mCurItem = r1;
        goto L_0x0010;
    L_0x000f:
        r2 = 0;
    L_0x0010:
        r1 = r0.mAdapter;
        if (r1 != 0) goto L_0x0018;
    L_0x0014:
        r17.sortChildDrawingOrder();
        return;
    L_0x0018:
        r1 = r0.mPopulatePending;
        if (r1 == 0) goto L_0x0020;
    L_0x001c:
        r17.sortChildDrawingOrder();
        return;
    L_0x0020:
        r1 = r17.getWindowToken();
        if (r1 != 0) goto L_0x0027;
    L_0x0026:
        return;
    L_0x0027:
        r1 = r0.mAdapter;
        r1.startUpdate(r0);
        r1 = r0.mOffscreenPageLimit;
        r4 = r0.mCurItem;
        r4 = r4 - r1;
        r5 = 0;
        r4 = java.lang.Math.max(r5, r4);
        r6 = r0.mAdapter;
        r6 = r6.getCount();
        r7 = r6 + -1;
        r8 = r0.mCurItem;
        r8 = r8 + r1;
        r1 = java.lang.Math.min(r7, r8);
        r7 = r0.mExpectedAdapterCount;
        if (r6 != r7) goto L_0x01f2;
    L_0x0049:
        r7 = 0;
    L_0x004a:
        r8 = r0.mItems;
        r8 = r8.size();
        if (r7 >= r8) goto L_0x0066;
    L_0x0052:
        r8 = r0.mItems;
        r8 = r8.get(r7);
        r8 = (android.support.v4.view.ViewPager.ItemInfo) r8;
        r9 = r8.position;
        r10 = r0.mCurItem;
        if (r9 < r10) goto L_0x0063;
    L_0x0060:
        if (r9 != r10) goto L_0x0066;
    L_0x0062:
        goto L_0x0067;
    L_0x0063:
        r7 = r7 + 1;
        goto L_0x004a;
    L_0x0066:
        r8 = 0;
    L_0x0067:
        if (r8 != 0) goto L_0x0071;
    L_0x0069:
        if (r6 <= 0) goto L_0x0071;
    L_0x006b:
        r8 = r0.mCurItem;
        r8 = r0.addNewItem(r8, r7);
    L_0x0071:
        r9 = 0;
        if (r8 == 0) goto L_0x017f;
    L_0x0074:
        r10 = r7 + -1;
        if (r10 < 0) goto L_0x0081;
    L_0x0078:
        r11 = r0.mItems;
        r11 = r11.get(r10);
        r11 = (android.support.v4.view.ViewPager.ItemInfo) r11;
        goto L_0x0082;
    L_0x0081:
        r11 = 0;
    L_0x0082:
        r12 = r17.getClientWidth();
        r13 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r12 > 0) goto L_0x008c;
    L_0x008a:
        r3 = 0;
        goto L_0x0099;
    L_0x008c:
        r14 = r8.widthFactor;
        r14 = r13 - r14;
        r15 = r17.getPaddingLeft();
        r15 = (float) r15;
        r3 = (float) r12;
        r15 = r15 / r3;
        r3 = r14 + r15;
    L_0x0099:
        r14 = r0.mCurItem;
        r14 = r14 + -1;
        r15 = r10;
        r10 = r7;
        r7 = 0;
    L_0x00a0:
        if (r14 < 0) goto L_0x00f0;
    L_0x00a2:
        r16 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1));
        if (r16 < 0) goto L_0x00c6;
    L_0x00a6:
        if (r14 >= r4) goto L_0x00c6;
    L_0x00a8:
        if (r11 != 0) goto L_0x00ab;
    L_0x00aa:
        goto L_0x00f0;
    L_0x00ab:
        r5 = r11.position;
        if (r14 != r5) goto L_0x00ec;
    L_0x00af:
        r5 = r11.scrolling;
        if (r5 != 0) goto L_0x00ec;
    L_0x00b3:
        r5 = r0.mItems;
        r5.remove(r15);
        r5 = r0.mAdapter;
        r11 = r11.object;
        r5.destroyItem(r0, r14, r11);
        r15 = r15 + -1;
        r10 = r10 + -1;
        if (r15 < 0) goto L_0x00ea;
    L_0x00c5:
        goto L_0x00e1;
    L_0x00c6:
        if (r11 == 0) goto L_0x00d4;
    L_0x00c8:
        r5 = r11.position;
        if (r14 != r5) goto L_0x00d4;
    L_0x00cc:
        r5 = r11.widthFactor;
        r7 = r7 + r5;
        r15 = r15 + -1;
        if (r15 < 0) goto L_0x00ea;
    L_0x00d3:
        goto L_0x00e1;
    L_0x00d4:
        r5 = r15 + 1;
        r5 = r0.addNewItem(r14, r5);
        r5 = r5.widthFactor;
        r7 = r7 + r5;
        r10 = r10 + 1;
        if (r15 < 0) goto L_0x00ea;
    L_0x00e1:
        r5 = r0.mItems;
        r5 = r5.get(r15);
        r5 = (android.support.v4.view.ViewPager.ItemInfo) r5;
        goto L_0x00eb;
    L_0x00ea:
        r5 = 0;
    L_0x00eb:
        r11 = r5;
    L_0x00ec:
        r14 = r14 + -1;
        r5 = 0;
        goto L_0x00a0;
    L_0x00f0:
        r3 = r8.widthFactor;
        r4 = r10 + 1;
        r5 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1));
        if (r5 >= 0) goto L_0x0173;
    L_0x00f8:
        r5 = r0.mItems;
        r5 = r5.size();
        if (r4 >= r5) goto L_0x0109;
    L_0x0100:
        r5 = r0.mItems;
        r5 = r5.get(r4);
        r5 = (android.support.v4.view.ViewPager.ItemInfo) r5;
        goto L_0x010a;
    L_0x0109:
        r5 = 0;
    L_0x010a:
        if (r12 > 0) goto L_0x010e;
    L_0x010c:
        r7 = 0;
        goto L_0x0116;
    L_0x010e:
        r7 = r17.getPaddingRight();
        r7 = (float) r7;
        r11 = (float) r12;
        r7 = r7 / r11;
        r7 = r7 + r13;
    L_0x0116:
        r11 = r0.mCurItem;
    L_0x0118:
        r11 = r11 + 1;
        if (r11 >= r6) goto L_0x0173;
    L_0x011c:
        r12 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1));
        if (r12 < 0) goto L_0x014c;
    L_0x0120:
        if (r11 <= r1) goto L_0x014c;
    L_0x0122:
        if (r5 != 0) goto L_0x0125;
    L_0x0124:
        goto L_0x0173;
    L_0x0125:
        r12 = r5.position;
        if (r11 != r12) goto L_0x0172;
    L_0x0129:
        r12 = r5.scrolling;
        if (r12 != 0) goto L_0x0172;
    L_0x012d:
        r12 = r0.mItems;
        r12.remove(r4);
        r12 = r0.mAdapter;
        r5 = r5.object;
        r12.destroyItem(r0, r11, r5);
        r5 = r0.mItems;
        r5 = r5.size();
        if (r4 >= r5) goto L_0x014a;
    L_0x0141:
        r5 = r0.mItems;
        r5 = r5.get(r4);
        r5 = (android.support.v4.view.ViewPager.ItemInfo) r5;
        goto L_0x0172;
    L_0x014a:
        r5 = 0;
        goto L_0x0172;
    L_0x014c:
        if (r5 == 0) goto L_0x0160;
    L_0x014e:
        r12 = r5.position;
        if (r11 != r12) goto L_0x0160;
    L_0x0152:
        r5 = r5.widthFactor;
        r3 = r3 + r5;
        r4 = r4 + 1;
        r5 = r0.mItems;
        r5 = r5.size();
        if (r4 >= r5) goto L_0x014a;
    L_0x015f:
        goto L_0x0141;
    L_0x0160:
        r5 = r0.addNewItem(r11, r4);
        r4 = r4 + 1;
        r5 = r5.widthFactor;
        r3 = r3 + r5;
        r5 = r0.mItems;
        r5 = r5.size();
        if (r4 >= r5) goto L_0x014a;
    L_0x0171:
        goto L_0x0141;
    L_0x0172:
        goto L_0x0118;
    L_0x0173:
        r0.calculatePageOffsets(r8, r10, r2);
        r1 = r0.mAdapter;
        r2 = r0.mCurItem;
        r3 = r8.object;
        r1.setPrimaryItem(r0, r2, r3);
    L_0x017f:
        r1 = r0.mAdapter;
        r1.finishUpdate(r0);
        r1 = r17.getChildCount();
        r2 = 0;
    L_0x0189:
        if (r2 >= r1) goto L_0x01b2;
    L_0x018b:
        r3 = r0.getChildAt(r2);
        r4 = r3.getLayoutParams();
        r4 = (android.support.v4.view.ViewPager.LayoutParams) r4;
        r4.childIndex = r2;
        r5 = r4.isDecor;
        if (r5 != 0) goto L_0x01af;
    L_0x019b:
        r5 = r4.widthFactor;
        r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1));
        if (r5 != 0) goto L_0x01af;
    L_0x01a1:
        r3 = r0.infoForChild(r3);
        if (r3 == 0) goto L_0x01af;
    L_0x01a7:
        r5 = r3.widthFactor;
        r4.widthFactor = r5;
        r3 = r3.position;
        r4.position = r3;
    L_0x01af:
        r2 = r2 + 1;
        goto L_0x0189;
    L_0x01b2:
        r17.sortChildDrawingOrder();
        r1 = r17.hasFocus();
        if (r1 == 0) goto L_0x01f1;
    L_0x01bb:
        r1 = r17.findFocus();
        if (r1 == 0) goto L_0x01c6;
    L_0x01c1:
        r3 = r0.infoForAnyChild(r1);
        goto L_0x01c7;
    L_0x01c6:
        r3 = 0;
    L_0x01c7:
        if (r3 == 0) goto L_0x01cf;
    L_0x01c9:
        r1 = r3.position;
        r2 = r0.mCurItem;
        if (r1 == r2) goto L_0x01f1;
    L_0x01cf:
        r1 = 0;
    L_0x01d0:
        r2 = r17.getChildCount();
        if (r1 >= r2) goto L_0x01f1;
    L_0x01d6:
        r2 = r0.getChildAt(r1);
        r3 = r0.infoForChild(r2);
        if (r3 == 0) goto L_0x01ee;
    L_0x01e0:
        r3 = r3.position;
        r4 = r0.mCurItem;
        if (r3 != r4) goto L_0x01ee;
    L_0x01e6:
        r3 = 2;
        r2 = r2.requestFocus(r3);
        if (r2 == 0) goto L_0x01ee;
    L_0x01ed:
        goto L_0x01f1;
    L_0x01ee:
        r1 = r1 + 1;
        goto L_0x01d0;
    L_0x01f1:
        return;
    L_0x01f2:
        r1 = r17.getResources();	 Catch:{ NotFoundException -> 0x01ff }
        r2 = r17.getId();	 Catch:{ NotFoundException -> 0x01ff }
        r1 = r1.getResourceName(r2);	 Catch:{ NotFoundException -> 0x01ff }
        goto L_0x0207;
    L_0x01ff:
        r1 = r17.getId();
        r1 = java.lang.Integer.toHexString(r1);
    L_0x0207:
        r2 = new java.lang.IllegalStateException;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r3.append(r4);
        r4 = r0.mExpectedAdapterCount;
        r3.append(r4);
        r4 = ", found: ";
        r3.append(r4);
        r3.append(r6);
        r4 = " Pager id: ";
        r3.append(r4);
        r3.append(r1);
        r1 = " Pager class: ";
        r3.append(r1);
        r1 = android.support.v4.view.ViewPager.class;
        r3.append(r1);
        r1 = " Problematic adapter: ";
        r3.append(r1);
        r1 = r0.mAdapter;
        r1 = r1.getClass();
        r3.append(r1);
        r1 = r3.toString();
        r2.<init>(r1);
        goto L_0x0249;
    L_0x0248:
        throw r2;
    L_0x0249:
        goto L_0x0248;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.populate(int):void");
    }

    public void removeOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        List list = this.mAdapterChangeListeners;
        if (list != null) {
            list.remove(onAdapterChangeListener);
        }
    }

    public void removeOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        List list = this.mOnPageChangeListeners;
        if (list != null) {
            list.remove(onPageChangeListener);
        }
    }

    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        PagerAdapter pagerAdapter2 = this.mAdapter;
        int i = 0;
        if (pagerAdapter2 != null) {
            pagerAdapter2.setViewPagerObserver(null);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i2 = 0; i2 < this.mItems.size(); i2++) {
                ItemInfo itemInfo = (ItemInfo) this.mItems.get(i2);
                this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            removeNonDecorViews();
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        pagerAdapter2 = this.mAdapter;
        this.mAdapter = pagerAdapter;
        this.mExpectedAdapterCount = 0;
        if (this.mAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new PagerObserver();
            }
            this.mAdapter.setViewPagerObserver(this.mObserver);
            this.mPopulatePending = false;
            boolean z = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (z) {
                requestLayout();
            } else {
                populate();
            }
        }
        List list = this.mAdapterChangeListeners;
        if (list != null && !list.isEmpty()) {
            int size = this.mAdapterChangeListeners.size();
            while (i < size) {
                ((OnAdapterChangeListener) this.mAdapterChangeListeners.get(i)).onAdapterChanged(this, pagerAdapter2, pagerAdapter);
                i++;
            }
        }
    }

    public void setCurrentItem(int i) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i, this.mFirstLayout ^ 1, false);
    }

    public void setCurrentItem(int i, boolean z) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i, z, false);
    }

    void setCurrentItemInternal(int i, boolean z, boolean z2) {
        setCurrentItemInternal(i, z, z2, 0);
    }

    void setCurrentItemInternal(int i, boolean z, boolean z2, int i2) {
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter != null) {
            if (pagerAdapter.getCount() > 0) {
                if (z2 || this.mCurItem != i || this.mItems.size() == 0) {
                    z2 = true;
                    if (i < 0) {
                        i = 0;
                    } else if (i >= this.mAdapter.getCount()) {
                        i = this.mAdapter.getCount() - 1;
                    }
                    int i3 = this.mOffscreenPageLimit;
                    int i4 = this.mCurItem;
                    if (i > i4 + i3 || i < i4 - i3) {
                        for (i3 = 0; i3 < this.mItems.size(); i3++) {
                            ((ItemInfo) this.mItems.get(i3)).scrolling = true;
                        }
                    }
                    if (this.mCurItem == i) {
                        z2 = false;
                    }
                    if (this.mFirstLayout) {
                        this.mCurItem = i;
                        if (z2) {
                            dispatchOnPageSelected(i);
                        }
                        requestLayout();
                    } else {
                        populate(i);
                        scrollToItem(i, z, i2, z2);
                    }
                    return;
                }
                setScrollingCacheEnabled(false);
                return;
            }
        }
        setScrollingCacheEnabled(false);
    }

    OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = onPageChangeListener;
        return onPageChangeListener2;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Requested offscreen page limit ");
            stringBuilder.append(i);
            stringBuilder.append(" too small; defaulting to ");
            stringBuilder.append(1);
            Log.w(TAG, stringBuilder.toString());
            i = 1;
        }
        if (i != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i;
            populate();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void setPageMargin(int i) {
        int i2 = this.mPageMargin;
        this.mPageMargin = i;
        int width = getWidth();
        recomputeScrollPosition(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(ContextCompat.getDrawable(getContext(), i));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z, PageTransformer pageTransformer) {
        setPageTransformer(z, pageTransformer, 2);
    }

    public void setPageTransformer(boolean z, PageTransformer pageTransformer, int i) {
        int i2 = 1;
        boolean z2 = pageTransformer != null;
        Object obj = z2 != (this.mPageTransformer != null) ? 1 : null;
        this.mPageTransformer = pageTransformer;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            if (z) {
                i2 = 2;
            }
            this.mDrawingOrder = i2;
            this.mPageTransformerLayerType = i;
        } else {
            this.mDrawingOrder = 0;
        }
        if (obj != null) {
            populate();
        }
    }

    void setScrollState(int i) {
        if (this.mScrollState != i) {
            this.mScrollState = i;
            if (this.mPageTransformer != null) {
                enableLayers(i != 0);
            }
            dispatchOnScrollStateChanged(i);
        }
    }

    void smoothScrollTo(int i, int i2) {
        smoothScrollTo(i, i2, 0);
    }

    void smoothScrollTo(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int currX;
        Scroller scroller = this.mScroller;
        Object obj = (scroller == null || scroller.isFinished()) ? null : 1;
        if (obj != null) {
            currX = this.mIsScrollStarted ? this.mScroller.getCurrX() : this.mScroller.getStartX();
            this.mScroller.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            currX = getScrollX();
        }
        int i4 = currX;
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            completeScroll(false);
            populate();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        i = getClientWidth();
        i2 = i / 2;
        float f = (float) i;
        float f2 = (float) i2;
        f2 += distanceInfluenceForSnapDuration(Math.min(1.0f, (((float) Math.abs(i5)) * 1.0f) / f)) * f2;
        i3 = Math.abs(i3);
        int min = Math.min(i3 > 0 ? Math.round(Math.abs(f2 / ((float) i3)) * 1000.0f) * 4 : (int) (((((float) Math.abs(i5)) / ((f * this.mAdapter.getPageWidth(this.mCurItem)) + ((float) this.mPageMargin))) + 1.0f) * 100.0f), MAX_SETTLE_DURATION);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(i4, scrollY, i5, i6, min);
        ViewCompat.postInvalidateOnAnimation(this);
    }

    protected boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable)) {
            if (drawable != this.mMarginDrawable) {
                return false;
            }
        }
        return true;
    }
}
