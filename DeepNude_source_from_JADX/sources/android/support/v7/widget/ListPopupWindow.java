package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.C0222R;
import android.support.v7.view.menu.ShowableListMenu;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.lang.reflect.Method;

public class ListPopupWindow implements ShowableListMenu {
    private static final boolean DEBUG = false;
    static final int EXPAND_LIST_TIMEOUT = 250;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int MATCH_PARENT = -1;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    private static final String TAG = "ListPopupWindow";
    public static final int WRAP_CONTENT = -2;
    private static Method sClipToWindowEnabledMethod;
    private static Method sGetMaxAvailableHeightMethod;
    private static Method sSetEpicenterBoundsMethod;
    private ListAdapter mAdapter;
    private Context mContext;
    private boolean mDropDownAlwaysVisible;
    private View mDropDownAnchorView;
    private int mDropDownGravity;
    private int mDropDownHeight;
    private int mDropDownHorizontalOffset;
    DropDownListView mDropDownList;
    private Drawable mDropDownListHighlight;
    private int mDropDownVerticalOffset;
    private boolean mDropDownVerticalOffsetSet;
    private int mDropDownWidth;
    private int mDropDownWindowLayoutType;
    private Rect mEpicenterBounds;
    private boolean mForceIgnoreOutsideTouch;
    final Handler mHandler;
    private final ListSelectorHider mHideSelector;
    private boolean mIsAnimatedFromAnchor;
    private OnItemClickListener mItemClickListener;
    private OnItemSelectedListener mItemSelectedListener;
    int mListItemExpandMaximum;
    private boolean mModal;
    private DataSetObserver mObserver;
    private boolean mOverlapAnchor;
    private boolean mOverlapAnchorSet;
    PopupWindow mPopup;
    private int mPromptPosition;
    private View mPromptView;
    final ResizePopupRunnable mResizePopupRunnable;
    private final PopupScrollListener mScrollListener;
    private Runnable mShowDropDownRunnable;
    private final Rect mTempRect;
    private final PopupTouchInterceptor mTouchInterceptor;

    /* renamed from: android.support.v7.widget.ListPopupWindow$2 */
    class C02462 implements Runnable {
        C02462() {
        }

        public void run() {
            View anchorView = ListPopupWindow.this.getAnchorView();
            if (anchorView != null && anchorView.getWindowToken() != null) {
                ListPopupWindow.this.show();
            }
        }
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow$3 */
    class C02473 implements OnItemSelectedListener {
        C02473() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (i != -1) {
                DropDownListView dropDownListView = ListPopupWindow.this.mDropDownList;
                if (dropDownListView != null) {
                    dropDownListView.setListSelectionHidden(false);
                }
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    private class ListSelectorHider implements Runnable {
        ListSelectorHider() {
        }

        public void run() {
            ListPopupWindow.this.clearListSelection();
        }
    }

    private class PopupDataSetObserver extends DataSetObserver {
        PopupDataSetObserver() {
        }

        public void onChanged() {
            if (ListPopupWindow.this.isShowing()) {
                ListPopupWindow.this.show();
            }
        }

        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    private class PopupScrollListener implements OnScrollListener {
        PopupScrollListener() {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !ListPopupWindow.this.isInputMethodNotNeeded() && ListPopupWindow.this.mPopup.getContentView() != null) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.mHandler.removeCallbacks(listPopupWindow.mResizePopupRunnable);
                ListPopupWindow.this.mResizePopupRunnable.run();
            }
        }
    }

    private class PopupTouchInterceptor implements OnTouchListener {
        PopupTouchInterceptor() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0) {
                PopupWindow popupWindow = ListPopupWindow.this.mPopup;
                if (popupWindow != null && popupWindow.isShowing() && x >= 0 && x < ListPopupWindow.this.mPopup.getWidth() && y >= 0 && y < ListPopupWindow.this.mPopup.getHeight()) {
                    ListPopupWindow listPopupWindow = ListPopupWindow.this;
                    listPopupWindow.mHandler.postDelayed(listPopupWindow.mResizePopupRunnable, 250);
                    return false;
                }
            }
            if (action == 1) {
                listPopupWindow = ListPopupWindow.this;
                listPopupWindow.mHandler.removeCallbacks(listPopupWindow.mResizePopupRunnable);
            }
            return false;
        }
    }

    private class ResizePopupRunnable implements Runnable {
        ResizePopupRunnable() {
        }

        public void run() {
            View view = ListPopupWindow.this.mDropDownList;
            if (view != null && ViewCompat.isAttachedToWindow(view) && ListPopupWindow.this.mDropDownList.getCount() > ListPopupWindow.this.mDropDownList.getChildCount()) {
                int childCount = ListPopupWindow.this.mDropDownList.getChildCount();
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                if (childCount <= listPopupWindow.mListItemExpandMaximum) {
                    listPopupWindow.mPopup.setInputMethodMode(2);
                    ListPopupWindow.this.show();
                }
            }
        }
    }

    static {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r0 = "ListPopupWindow";
        r1 = 0;
        r2 = 1;
        r3 = android.widget.PopupWindow.class;	 Catch:{ NoSuchMethodException -> 0x0015 }
        r4 = "setClipToScreenEnabled";	 Catch:{ NoSuchMethodException -> 0x0015 }
        r5 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x0015 }
        r6 = java.lang.Boolean.TYPE;	 Catch:{ NoSuchMethodException -> 0x0015 }
        r5[r1] = r6;	 Catch:{ NoSuchMethodException -> 0x0015 }
        r3 = r3.getDeclaredMethod(r4, r5);	 Catch:{ NoSuchMethodException -> 0x0015 }
        sClipToWindowEnabledMethod = r3;	 Catch:{ NoSuchMethodException -> 0x0015 }
        goto L_0x001a;
    L_0x0015:
        r3 = "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.";
        android.util.Log.i(r0, r3);
    L_0x001a:
        r3 = android.widget.PopupWindow.class;	 Catch:{ NoSuchMethodException -> 0x0035 }
        r4 = 3;	 Catch:{ NoSuchMethodException -> 0x0035 }
        r4 = new java.lang.Class[r4];	 Catch:{ NoSuchMethodException -> 0x0035 }
        r5 = android.view.View.class;	 Catch:{ NoSuchMethodException -> 0x0035 }
        r4[r1] = r5;	 Catch:{ NoSuchMethodException -> 0x0035 }
        r5 = java.lang.Integer.TYPE;	 Catch:{ NoSuchMethodException -> 0x0035 }
        r4[r2] = r5;	 Catch:{ NoSuchMethodException -> 0x0035 }
        r5 = 2;	 Catch:{ NoSuchMethodException -> 0x0035 }
        r6 = java.lang.Boolean.TYPE;	 Catch:{ NoSuchMethodException -> 0x0035 }
        r4[r5] = r6;	 Catch:{ NoSuchMethodException -> 0x0035 }
        r5 = "getMaxAvailableHeight";
        r3 = r3.getDeclaredMethod(r5, r4);	 Catch:{ NoSuchMethodException -> 0x0035 }
        sGetMaxAvailableHeightMethod = r3;	 Catch:{ NoSuchMethodException -> 0x0035 }
        goto L_0x003a;
    L_0x0035:
        r3 = "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.";
        android.util.Log.i(r0, r3);
    L_0x003a:
        r3 = android.widget.PopupWindow.class;	 Catch:{ NoSuchMethodException -> 0x004b }
        r4 = "setEpicenterBounds";	 Catch:{ NoSuchMethodException -> 0x004b }
        r2 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x004b }
        r5 = android.graphics.Rect.class;	 Catch:{ NoSuchMethodException -> 0x004b }
        r2[r1] = r5;	 Catch:{ NoSuchMethodException -> 0x004b }
        r1 = r3.getDeclaredMethod(r4, r2);	 Catch:{ NoSuchMethodException -> 0x004b }
        sSetEpicenterBoundsMethod = r1;	 Catch:{ NoSuchMethodException -> 0x004b }
        goto L_0x0050;
    L_0x004b:
        r1 = "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.";
        android.util.Log.i(r0, r1);
    L_0x0050:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ListPopupWindow.<clinit>():void");
    }

    public ListPopupWindow(Context context) {
        this(context, null, C0222R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0222R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mDropDownHeight = -2;
        this.mDropDownWidth = -2;
        this.mDropDownWindowLayoutType = 1002;
        this.mIsAnimatedFromAnchor = true;
        this.mDropDownGravity = 0;
        this.mDropDownAlwaysVisible = false;
        this.mForceIgnoreOutsideTouch = false;
        this.mListItemExpandMaximum = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mPromptPosition = 0;
        this.mResizePopupRunnable = new ResizePopupRunnable();
        this.mTouchInterceptor = new PopupTouchInterceptor();
        this.mScrollListener = new PopupScrollListener();
        this.mHideSelector = new ListSelectorHider();
        this.mTempRect = new Rect();
        this.mContext = context;
        this.mHandler = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0222R.styleable.ListPopupWindow, i, i2);
        this.mDropDownHorizontalOffset = obtainStyledAttributes.getDimensionPixelOffset(C0222R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.mDropDownVerticalOffset = obtainStyledAttributes.getDimensionPixelOffset(C0222R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.mDropDownVerticalOffset != 0) {
            this.mDropDownVerticalOffsetSet = true;
        }
        obtainStyledAttributes.recycle();
        this.mPopup = new AppCompatPopupWindow(context, attributeSet, i, i2);
        this.mPopup.setInputMethodMode(1);
    }

    private int buildDropDown() {
        Drawable drawable;
        int i;
        int i2;
        int i3 = Integer.MIN_VALUE;
        boolean z = true;
        if (this.mDropDownList == null) {
            Context context = this.mContext;
            this.mShowDropDownRunnable = new C02462();
            this.mDropDownList = createDropDownListView(context, this.mModal ^ true);
            drawable = this.mDropDownListHighlight;
            if (drawable != null) {
                this.mDropDownList.setSelector(drawable);
            }
            this.mDropDownList.setAdapter(this.mAdapter);
            this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
            this.mDropDownList.setFocusable(true);
            this.mDropDownList.setFocusableInTouchMode(true);
            this.mDropDownList.setOnItemSelectedListener(new C02473());
            this.mDropDownList.setOnScrollListener(this.mScrollListener);
            OnItemSelectedListener onItemSelectedListener = this.mItemSelectedListener;
            if (onItemSelectedListener != null) {
                this.mDropDownList.setOnItemSelectedListener(onItemSelectedListener);
            }
            View view = this.mDropDownList;
            View view2 = this.mPromptView;
            if (view2 != null) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i4 = this.mPromptPosition;
                if (i4 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(view, layoutParams);
                } else if (i4 != 1) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid hint position ");
                    stringBuilder.append(this.mPromptPosition);
                    Log.e(TAG, stringBuilder.toString());
                } else {
                    linearLayout.addView(view, layoutParams);
                    linearLayout.addView(view2);
                }
                i = this.mDropDownWidth;
                if (i >= 0) {
                    i2 = Integer.MIN_VALUE;
                } else {
                    i = 0;
                    i2 = 0;
                }
                view2.measure(MeasureSpec.makeMeasureSpec(i, i2), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i = (view2.getMeasuredHeight() + layoutParams2.topMargin) + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                i = 0;
            }
            this.mPopup.setContentView(view);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.mPopup.getContentView();
            View view3 = this.mPromptView;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                i = (view3.getMeasuredHeight() + layoutParams3.topMargin) + layoutParams3.bottomMargin;
            } else {
                i = 0;
            }
        }
        drawable = this.mPopup.getBackground();
        if (drawable != null) {
            drawable.getPadding(this.mTempRect);
            Rect rect = this.mTempRect;
            int i5 = rect.top;
            i2 = rect.bottom + i5;
            if (!this.mDropDownVerticalOffsetSet) {
                this.mDropDownVerticalOffset = -i5;
            }
        } else {
            this.mTempRect.setEmpty();
            i2 = 0;
        }
        if (this.mPopup.getInputMethodMode() != 2) {
            z = false;
        }
        int maxAvailableHeight = getMaxAvailableHeight(getAnchorView(), this.mDropDownVerticalOffset, z);
        if (!this.mDropDownAlwaysVisible) {
            if (this.mDropDownHeight != -1) {
                int i6 = this.mDropDownWidth;
                if (i6 != -2) {
                    i3 = 1073741824;
                    if (i6 != -1) {
                        i3 = MeasureSpec.makeMeasureSpec(i6, 1073741824);
                        i3 = this.mDropDownList.measureHeightOfChildrenCompat(i3, 0, -1, maxAvailableHeight - i, -1);
                        if (i3 > 0) {
                            i += i2 + (this.mDropDownList.getPaddingTop() + this.mDropDownList.getPaddingBottom());
                        }
                        return i3 + i;
                    }
                }
                int i7 = this.mContext.getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = this.mTempRect;
                i3 = MeasureSpec.makeMeasureSpec(i7 - (rect2.left + rect2.right), i3);
                i3 = this.mDropDownList.measureHeightOfChildrenCompat(i3, 0, -1, maxAvailableHeight - i, -1);
                if (i3 > 0) {
                    i += i2 + (this.mDropDownList.getPaddingTop() + this.mDropDownList.getPaddingBottom());
                }
                return i3 + i;
            }
        }
        return maxAvailableHeight + i2;
    }

    private int getMaxAvailableHeight(android.view.View r6, int r7, boolean r8) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r5 = this;
        r0 = sGetMaxAvailableHeightMethod;
        if (r0 == 0) goto L_0x002c;
    L_0x0004:
        r1 = r5.mPopup;	 Catch:{ Exception -> 0x0025 }
        r2 = 3;	 Catch:{ Exception -> 0x0025 }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0025 }
        r3 = 0;	 Catch:{ Exception -> 0x0025 }
        r2[r3] = r6;	 Catch:{ Exception -> 0x0025 }
        r3 = 1;	 Catch:{ Exception -> 0x0025 }
        r4 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x0025 }
        r2[r3] = r4;	 Catch:{ Exception -> 0x0025 }
        r3 = 2;	 Catch:{ Exception -> 0x0025 }
        r8 = java.lang.Boolean.valueOf(r8);	 Catch:{ Exception -> 0x0025 }
        r2[r3] = r8;	 Catch:{ Exception -> 0x0025 }
        r8 = r0.invoke(r1, r2);	 Catch:{ Exception -> 0x0025 }
        r8 = (java.lang.Integer) r8;	 Catch:{ Exception -> 0x0025 }
        r6 = r8.intValue();	 Catch:{ Exception -> 0x0025 }
        return r6;
    L_0x0025:
        r8 = "ListPopupWindow";
        r0 = "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.";
        android.util.Log.i(r8, r0);
    L_0x002c:
        r8 = r5.mPopup;
        r6 = r8.getMaxAvailableHeight(r6, r7);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ListPopupWindow.getMaxAvailableHeight(android.view.View, int, boolean):int");
    }

    private static boolean isConfirmKey(int i) {
        if (i != 66) {
            if (i != 23) {
                return false;
            }
        }
        return true;
    }

    private void removePromptView() {
        View view = this.mPromptView;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.mPromptView);
            }
        }
    }

    private void setPopupClipToScreenEnabled(boolean r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r4 = this;
        r0 = sClipToWindowEnabledMethod;
        if (r0 == 0) goto L_0x001b;
    L_0x0004:
        r1 = r4.mPopup;	 Catch:{ Exception -> 0x0014 }
        r2 = 1;	 Catch:{ Exception -> 0x0014 }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0014 }
        r3 = 0;	 Catch:{ Exception -> 0x0014 }
        r5 = java.lang.Boolean.valueOf(r5);	 Catch:{ Exception -> 0x0014 }
        r2[r3] = r5;	 Catch:{ Exception -> 0x0014 }
        r0.invoke(r1, r2);	 Catch:{ Exception -> 0x0014 }
        goto L_0x001b;
    L_0x0014:
        r5 = "ListPopupWindow";
        r0 = "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.";
        android.util.Log.i(r5, r0);
    L_0x001b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ListPopupWindow.setPopupClipToScreenEnabled(boolean):void");
    }

    public void clearListSelection() {
        ListView listView = this.mDropDownList;
        if (listView != null) {
            listView.setListSelectionHidden(true);
            listView.requestLayout();
        }
    }

    public OnTouchListener createDragToOpenListener(View view) {
        return new ForwardingListener(view) {
            public ListPopupWindow getPopup() {
                return ListPopupWindow.this;
            }
        };
    }

    DropDownListView createDropDownListView(Context context, boolean z) {
        return new DropDownListView(context, z);
    }

    public void dismiss() {
        this.mPopup.dismiss();
        removePromptView();
        this.mPopup.setContentView(null);
        this.mDropDownList = null;
        this.mHandler.removeCallbacks(this.mResizePopupRunnable);
    }

    public View getAnchorView() {
        return this.mDropDownAnchorView;
    }

    public int getAnimationStyle() {
        return this.mPopup.getAnimationStyle();
    }

    public Drawable getBackground() {
        return this.mPopup.getBackground();
    }

    public int getHeight() {
        return this.mDropDownHeight;
    }

    public int getHorizontalOffset() {
        return this.mDropDownHorizontalOffset;
    }

    public int getInputMethodMode() {
        return this.mPopup.getInputMethodMode();
    }

    public ListView getListView() {
        return this.mDropDownList;
    }

    public int getPromptPosition() {
        return this.mPromptPosition;
    }

    public Object getSelectedItem() {
        return !isShowing() ? null : this.mDropDownList.getSelectedItem();
    }

    public long getSelectedItemId() {
        return !isShowing() ? Long.MIN_VALUE : this.mDropDownList.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        return !isShowing() ? -1 : this.mDropDownList.getSelectedItemPosition();
    }

    public View getSelectedView() {
        return !isShowing() ? null : this.mDropDownList.getSelectedView();
    }

    public int getSoftInputMode() {
        return this.mPopup.getSoftInputMode();
    }

    public int getVerticalOffset() {
        return !this.mDropDownVerticalOffsetSet ? 0 : this.mDropDownVerticalOffset;
    }

    public int getWidth() {
        return this.mDropDownWidth;
    }

    public boolean isDropDownAlwaysVisible() {
        return this.mDropDownAlwaysVisible;
    }

    public boolean isInputMethodNotNeeded() {
        return this.mPopup.getInputMethodMode() == 2;
    }

    public boolean isModal() {
        return this.mModal;
    }

    public boolean isShowing() {
        return this.mPopup.isShowing();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (isShowing() && i != 62 && (this.mDropDownList.getSelectedItemPosition() >= 0 || !isConfirmKey(i))) {
            int count;
            int selectedItemPosition = this.mDropDownList.getSelectedItemPosition();
            int isAboveAnchor = this.mPopup.isAboveAnchor() ^ 1;
            ListAdapter listAdapter = this.mAdapter;
            int i2 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            if (listAdapter != null) {
                boolean areAllItemsEnabled = listAdapter.areAllItemsEnabled();
                int lookForSelectablePosition = areAllItemsEnabled ? 0 : this.mDropDownList.lookForSelectablePosition(0, true);
                count = areAllItemsEnabled ? listAdapter.getCount() - 1 : this.mDropDownList.lookForSelectablePosition(listAdapter.getCount() - 1, false);
                i2 = lookForSelectablePosition;
            } else {
                count = Integer.MIN_VALUE;
            }
            if ((isAboveAnchor == 0 || i != 19 || selectedItemPosition > i2) && !(isAboveAnchor == 0 && i == 20 && selectedItemPosition >= count)) {
                this.mDropDownList.setListSelectionHidden(false);
                if (this.mDropDownList.onKeyDown(i, keyEvent)) {
                    this.mPopup.setInputMethodMode(2);
                    this.mDropDownList.requestFocusFromTouch();
                    show();
                    if (i == 19 || i == 20 || i == 23 || i == 66) {
                        return true;
                    }
                } else if (isAboveAnchor == 0 || i != 20) {
                    return isAboveAnchor == 0 && i == 19 && selectedItemPosition == i2;
                } else {
                    if (selectedItemPosition == count) {
                        return true;
                    }
                }
            }
            clearListSelection();
            this.mPopup.setInputMethodMode(1);
            show();
            return true;
        }
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == 4 && isShowing()) {
            View view = this.mDropDownAnchorView;
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                keyDispatcherState = view.getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    keyDispatcherState.startTracking(keyEvent, this);
                }
                return true;
            } else if (keyEvent.getAction() == 1) {
                keyDispatcherState = view.getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    keyDispatcherState.handleUpEvent(keyEvent);
                }
                if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                    dismiss();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (!isShowing() || this.mDropDownList.getSelectedItemPosition() < 0) {
            return false;
        }
        boolean onKeyUp = this.mDropDownList.onKeyUp(i, keyEvent);
        if (onKeyUp && isConfirmKey(i)) {
            dismiss();
        }
        return onKeyUp;
    }

    public boolean performItemClick(int i) {
        if (!isShowing()) {
            return false;
        }
        if (this.mItemClickListener != null) {
            AdapterView adapterView = this.mDropDownList;
            int i2 = i;
            this.mItemClickListener.onItemClick(adapterView, adapterView.getChildAt(i - adapterView.getFirstVisiblePosition()), i2, adapterView.getAdapter().getItemId(i));
        }
        return true;
    }

    public void postShow() {
        this.mHandler.post(this.mShowDropDownRunnable);
    }

    public void setAdapter(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.mObserver;
        if (dataSetObserver == null) {
            this.mObserver = new PopupDataSetObserver();
        } else {
            ListAdapter listAdapter2 = this.mAdapter;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.mAdapter = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.mObserver);
        }
        ListView listView = this.mDropDownList;
        if (listView != null) {
            listView.setAdapter(this.mAdapter);
        }
    }

    public void setAnchorView(View view) {
        this.mDropDownAnchorView = view;
    }

    public void setAnimationStyle(int i) {
        this.mPopup.setAnimationStyle(i);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.mPopup.setBackgroundDrawable(drawable);
    }

    public void setContentWidth(int i) {
        Drawable background = this.mPopup.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            Rect rect = this.mTempRect;
            this.mDropDownWidth = (rect.left + rect.right) + i;
            return;
        }
        setWidth(i);
    }

    public void setDropDownAlwaysVisible(boolean z) {
        this.mDropDownAlwaysVisible = z;
    }

    public void setDropDownGravity(int i) {
        this.mDropDownGravity = i;
    }

    public void setEpicenterBounds(Rect rect) {
        this.mEpicenterBounds = rect;
    }

    public void setForceIgnoreOutsideTouch(boolean z) {
        this.mForceIgnoreOutsideTouch = z;
    }

    public void setHeight(int i) {
        if (i < 0 && -2 != i) {
            if (-1 != i) {
                throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
            }
        }
        this.mDropDownHeight = i;
    }

    public void setHorizontalOffset(int i) {
        this.mDropDownHorizontalOffset = i;
    }

    public void setInputMethodMode(int i) {
        this.mPopup.setInputMethodMode(i);
    }

    void setListItemExpandMax(int i) {
        this.mListItemExpandMaximum = i;
    }

    public void setListSelector(Drawable drawable) {
        this.mDropDownListHighlight = drawable;
    }

    public void setModal(boolean z) {
        this.mModal = z;
        this.mPopup.setFocusable(z);
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.mPopup.setOnDismissListener(onDismissListener);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mItemClickListener = onItemClickListener;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.mItemSelectedListener = onItemSelectedListener;
    }

    public void setOverlapAnchor(boolean z) {
        this.mOverlapAnchorSet = true;
        this.mOverlapAnchor = z;
    }

    public void setPromptPosition(int i) {
        this.mPromptPosition = i;
    }

    public void setPromptView(View view) {
        boolean isShowing = isShowing();
        if (isShowing) {
            removePromptView();
        }
        this.mPromptView = view;
        if (isShowing) {
            show();
        }
    }

    public void setSelection(int i) {
        ListView listView = this.mDropDownList;
        if (isShowing() && listView != null) {
            listView.setListSelectionHidden(false);
            listView.setSelection(i);
            if (listView.getChoiceMode() != 0) {
                listView.setItemChecked(i, true);
            }
        }
    }

    public void setSoftInputMode(int i) {
        this.mPopup.setSoftInputMode(i);
    }

    public void setVerticalOffset(int i) {
        this.mDropDownVerticalOffset = i;
        this.mDropDownVerticalOffsetSet = true;
    }

    public void setWidth(int i) {
        this.mDropDownWidth = i;
    }

    public void setWindowLayoutType(int i) {
        this.mDropDownWindowLayoutType = i;
    }

    public void show() {
        int buildDropDown = buildDropDown();
        boolean isInputMethodNotNeeded = isInputMethodNotNeeded();
        PopupWindowCompat.setWindowLayoutType(this.mPopup, this.mDropDownWindowLayoutType);
        boolean z = true;
        int i;
        if (!this.mPopup.isShowing()) {
            int i2 = this.mDropDownWidth;
            if (i2 == -1) {
                i2 = -1;
            } else if (i2 == -2) {
                i2 = getAnchorView().getWidth();
            }
            i = this.mDropDownHeight;
            if (i == -1) {
                buildDropDown = -1;
            } else if (i != -2) {
                buildDropDown = i;
            }
            this.mPopup.setWidth(i2);
            this.mPopup.setHeight(buildDropDown);
            setPopupClipToScreenEnabled(true);
            PopupWindow popupWindow = this.mPopup;
            isInputMethodNotNeeded = (this.mForceIgnoreOutsideTouch || this.mDropDownAlwaysVisible) ? false : true;
            popupWindow.setOutsideTouchable(isInputMethodNotNeeded);
            this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
            if (this.mOverlapAnchorSet) {
                PopupWindowCompat.setOverlapAnchor(this.mPopup, this.mOverlapAnchor);
            }
            Method method = sSetEpicenterBoundsMethod;
            if (method != null) {
                try {
                    method.invoke(this.mPopup, new Object[]{this.mEpicenterBounds});
                } catch (Throwable e) {
                    Log.e(TAG, "Could not invoke setEpicenterBounds on PopupWindow", e);
                }
            }
            PopupWindowCompat.showAsDropDown(this.mPopup, getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, this.mDropDownGravity);
            this.mDropDownList.setSelection(-1);
            if (!this.mModal || this.mDropDownList.isInTouchMode()) {
                clearListSelection();
            }
            if (!this.mModal) {
                this.mHandler.post(this.mHideSelector);
            }
        } else if (ViewCompat.isAttachedToWindow(getAnchorView())) {
            i = this.mDropDownWidth;
            if (i == -1) {
                i = -1;
            } else if (i == -2) {
                i = getAnchorView().getWidth();
            }
            int i3 = this.mDropDownHeight;
            if (i3 == -1) {
                if (!isInputMethodNotNeeded) {
                    buildDropDown = -1;
                }
                if (isInputMethodNotNeeded) {
                    this.mPopup.setWidth(this.mDropDownWidth == -1 ? -1 : 0);
                    this.mPopup.setHeight(0);
                } else {
                    this.mPopup.setWidth(this.mDropDownWidth == -1 ? -1 : 0);
                    this.mPopup.setHeight(-1);
                }
            } else if (i3 != -2) {
                buildDropDown = i3;
            }
            PopupWindow popupWindow2 = this.mPopup;
            if (this.mForceIgnoreOutsideTouch || this.mDropDownAlwaysVisible) {
                z = false;
            }
            popupWindow2.setOutsideTouchable(z);
            this.mPopup.update(getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, i < 0 ? -1 : i, buildDropDown < 0 ? -1 : buildDropDown);
        }
    }
}
