package android.support.v4.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View.OnUnhandledKeyEventListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeProvider;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import p000a.p005b.p006a.C0011e;

public class ViewCompat {
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
    @Deprecated
    public static final int LAYER_TYPE_HARDWARE = 2;
    @Deprecated
    public static final int LAYER_TYPE_NONE = 0;
    @Deprecated
    public static final int LAYER_TYPE_SOFTWARE = 1;
    public static final int LAYOUT_DIRECTION_INHERIT = 2;
    public static final int LAYOUT_DIRECTION_LOCALE = 3;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;
    @Deprecated
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
    @Deprecated
    public static final int MEASURED_SIZE_MASK = 16777215;
    @Deprecated
    public static final int MEASURED_STATE_MASK = -16777216;
    @Deprecated
    public static final int MEASURED_STATE_TOO_SMALL = 16777216;
    @Deprecated
    public static final int OVER_SCROLL_ALWAYS = 0;
    @Deprecated
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    @Deprecated
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    public static final int SCROLL_INDICATOR_BOTTOM = 2;
    public static final int SCROLL_INDICATOR_END = 32;
    public static final int SCROLL_INDICATOR_LEFT = 4;
    public static final int SCROLL_INDICATOR_RIGHT = 8;
    public static final int SCROLL_INDICATOR_START = 16;
    public static final int SCROLL_INDICATOR_TOP = 1;
    private static final String TAG = "ViewCompat";
    public static final int TYPE_NON_TOUCH = 1;
    public static final int TYPE_TOUCH = 0;
    private static boolean sAccessibilityDelegateCheckFailed = false;
    private static Field sAccessibilityDelegateField;
    private static Method sChildrenDrawingOrderMethod;
    private static Method sDispatchFinishTemporaryDetach;
    private static Method sDispatchStartTemporaryDetach;
    private static Field sMinHeightField;
    private static boolean sMinHeightFieldFetched;
    private static Field sMinWidthField;
    private static boolean sMinWidthFieldFetched;
    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
    private static boolean sTempDetachBound;
    private static ThreadLocal<Rect> sThreadLocalRect;
    private static WeakHashMap<View, String> sTransitionNameMap;
    private static WeakHashMap<View, ViewPropertyAnimatorCompat> sViewPropertyAnimatorMap = null;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusRealDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusRelativeDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NestedScrollType {
    }

    public interface OnUnhandledKeyEventListenerCompat {
        boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent);
    }

    private static class OnUnhandledKeyEventListenerWrapper implements OnUnhandledKeyEventListener {
        private OnUnhandledKeyEventListenerCompat mCompatListener;

        OnUnhandledKeyEventListenerWrapper(OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
            this.mCompatListener = onUnhandledKeyEventListenerCompat;
        }

        public boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
            return this.mCompatListener.onUnhandledKeyEvent(view, keyEvent);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollAxis {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollIndicators {
    }

    static class UnhandledKeyEventManager {
        private static final ArrayList<WeakReference<View>> sViewsWithListeners = new ArrayList();
        private SparseArray<WeakReference<View>> mCapturedKeys = null;
        private WeakReference<KeyEvent> mLastDispatchedPreViewKeyEvent = null;
        private WeakHashMap<View, Boolean> mViewsContainingListeners = null;

        UnhandledKeyEventManager() {
        }

        static UnhandledKeyEventManager at(View view) {
            UnhandledKeyEventManager unhandledKeyEventManager = (UnhandledKeyEventManager) view.getTag(C0011e.tag_unhandled_key_event_manager);
            if (unhandledKeyEventManager != null) {
                return unhandledKeyEventManager;
            }
            unhandledKeyEventManager = new UnhandledKeyEventManager();
            view.setTag(C0011e.tag_unhandled_key_event_manager, unhandledKeyEventManager);
            return unhandledKeyEventManager;
        }

        private View dispatchInOrder(View view, KeyEvent keyEvent) {
            WeakHashMap weakHashMap = this.mViewsContainingListeners;
            if (weakHashMap != null) {
                if (weakHashMap.containsKey(view)) {
                    if (view instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view;
                        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                            View dispatchInOrder = dispatchInOrder(viewGroup.getChildAt(childCount), keyEvent);
                            if (dispatchInOrder != null) {
                                return dispatchInOrder;
                            }
                        }
                    }
                    if (onUnhandledKeyEvent(view, keyEvent)) {
                        return view;
                    }
                }
            }
            return null;
        }

        private SparseArray<WeakReference<View>> getCapturedKeys() {
            if (this.mCapturedKeys == null) {
                this.mCapturedKeys = new SparseArray();
            }
            return this.mCapturedKeys;
        }

        private boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(C0011e.tag_unhandled_key_listeners);
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (((OnUnhandledKeyEventListenerCompat) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private void recalcViewsWithUnhandled() {
            WeakHashMap weakHashMap = this.mViewsContainingListeners;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            if (!sViewsWithListeners.isEmpty()) {
                synchronized (sViewsWithListeners) {
                    if (this.mViewsContainingListeners == null) {
                        this.mViewsContainingListeners = new WeakHashMap();
                    }
                    for (int size = sViewsWithListeners.size() - 1; size >= 0; size--) {
                        View view = (View) ((WeakReference) sViewsWithListeners.get(size)).get();
                        if (view == null) {
                            sViewsWithListeners.remove(size);
                        } else {
                            this.mViewsContainingListeners.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.mViewsContainingListeners.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }

        static void registerListeningView(View view) {
            synchronized (sViewsWithListeners) {
                Iterator it = sViewsWithListeners.iterator();
                while (it.hasNext()) {
                    if (((WeakReference) it.next()).get() == view) {
                        return;
                    }
                }
                sViewsWithListeners.add(new WeakReference(view));
            }
        }

        static void unregisterListeningView(View view) {
            synchronized (sViewsWithListeners) {
                for (int i = 0; i < sViewsWithListeners.size(); i++) {
                    if (((WeakReference) sViewsWithListeners.get(i)).get() == view) {
                        sViewsWithListeners.remove(i);
                        return;
                    }
                }
            }
        }

        boolean dispatch(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                recalcViewsWithUnhandled();
            }
            view = dispatchInOrder(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (!(view == null || KeyEvent.isModifierKey(keyCode))) {
                    getCapturedKeys().put(keyCode, new WeakReference(view));
                }
            }
            return view != null;
        }

        boolean preDispatch(KeyEvent keyEvent) {
            WeakReference weakReference = this.mLastDispatchedPreViewKeyEvent;
            if (weakReference != null && weakReference.get() == keyEvent) {
                return false;
            }
            this.mLastDispatchedPreViewKeyEvent = new WeakReference(keyEvent);
            weakReference = null;
            SparseArray capturedKeys = getCapturedKeys();
            if (keyEvent.getAction() == 1) {
                int indexOfKey = capturedKeys.indexOfKey(keyEvent.getKeyCode());
                if (indexOfKey >= 0) {
                    weakReference = (WeakReference) capturedKeys.valueAt(indexOfKey);
                    capturedKeys.removeAt(indexOfKey);
                }
            }
            if (weakReference == null) {
                weakReference = (WeakReference) capturedKeys.get(keyEvent.getKeyCode());
            }
            if (weakReference == null) {
                return false;
            }
            View view = (View) weakReference.get();
            if (view != null && ViewCompat.isAttachedToWindow(view)) {
                onUnhandledKeyEvent(view, keyEvent);
            }
            return true;
        }
    }

    protected ViewCompat() {
    }

    public static void addKeyboardNavigationClusters(View view, Collection<View> collection, int i) {
        if (VERSION.SDK_INT >= 26) {
            view.addKeyboardNavigationClusters(collection, i);
        }
    }

    public static void addOnUnhandledKeyEventListener(View view, OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        if (VERSION.SDK_INT >= 28) {
            Map map = (Map) view.getTag(C0011e.tag_unhandled_key_listeners);
            if (map == null) {
                map = new ArrayMap();
                view.setTag(C0011e.tag_unhandled_key_listeners, map);
            }
            OnUnhandledKeyEventListenerWrapper onUnhandledKeyEventListenerWrapper = new OnUnhandledKeyEventListenerWrapper(onUnhandledKeyEventListenerCompat);
            map.put(onUnhandledKeyEventListenerCompat, onUnhandledKeyEventListenerWrapper);
            view.addOnUnhandledKeyEventListener(onUnhandledKeyEventListenerWrapper);
            return;
        }
        ArrayList arrayList = (ArrayList) view.getTag(C0011e.tag_unhandled_key_listeners);
        if (arrayList == null) {
            arrayList = new ArrayList();
            view.setTag(C0011e.tag_unhandled_key_listeners, arrayList);
        }
        arrayList.add(onUnhandledKeyEventListenerCompat);
        if (arrayList.size() == 1) {
            UnhandledKeyEventManager.registerListeningView(view);
        }
    }

    public static ViewPropertyAnimatorCompat animate(View view) {
        if (sViewPropertyAnimatorMap == null) {
            sViewPropertyAnimatorMap = new WeakHashMap();
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat) sViewPropertyAnimatorMap.get(view);
        if (viewPropertyAnimatorCompat != null) {
            return viewPropertyAnimatorCompat;
        }
        viewPropertyAnimatorCompat = new ViewPropertyAnimatorCompat(view);
        sViewPropertyAnimatorMap.put(view, viewPropertyAnimatorCompat);
        return viewPropertyAnimatorCompat;
    }

    private static void bindTempDetach() {
        try {
            sDispatchStartTemporaryDetach = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
            sDispatchFinishTemporaryDetach = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
        } catch (Throwable e) {
            Log.e(TAG, "Couldn't find method", e);
        }
        sTempDetachBound = true;
    }

    @Deprecated
    public static boolean canScrollHorizontally(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    @Deprecated
    public static boolean canScrollVertically(View view, int i) {
        return view.canScrollVertically(i);
    }

    public static void cancelDragAndDrop(View view) {
        if (VERSION.SDK_INT >= 24) {
            view.cancelDragAndDrop();
        }
    }

    @Deprecated
    public static int combineMeasuredStates(int i, int i2) {
        return View.combineMeasuredStates(i, i2);
    }

    private static void compatOffsetLeftAndRight(View view, int i) {
        view.offsetLeftAndRight(i);
        if (view.getVisibility() == 0) {
            tickleInvalidationFlag(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                tickleInvalidationFlag((View) parent);
            }
        }
    }

    private static void compatOffsetTopAndBottom(View view, int i) {
        view.offsetTopAndBottom(i);
        if (view.getVisibility() == 0) {
            tickleInvalidationFlag(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                tickleInvalidationFlag((View) parent);
            }
        }
    }

    public static WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        if (VERSION.SDK_INT < 21) {
            return windowInsetsCompat;
        }
        Object obj = (WindowInsets) WindowInsetsCompat.unwrap(windowInsetsCompat);
        WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(obj);
        if (dispatchApplyWindowInsets != obj) {
            obj = new WindowInsets(dispatchApplyWindowInsets);
        }
        return WindowInsetsCompat.wrap(obj);
    }

    public static void dispatchFinishTemporaryDetach(View view) {
        if (VERSION.SDK_INT >= 24) {
            view.dispatchFinishTemporaryDetach();
            return;
        }
        if (!sTempDetachBound) {
            bindTempDetach();
        }
        Method method = sDispatchFinishTemporaryDetach;
        if (method != null) {
            try {
                method.invoke(view, new Object[0]);
                return;
            } catch (Throwable e) {
                Log.d(TAG, "Error calling dispatchFinishTemporaryDetach", e);
                return;
            }
        }
        view.onFinishTemporaryDetach();
    }

    public static boolean dispatchNestedFling(View view, float f, float f2, boolean z) {
        return VERSION.SDK_INT >= 21 ? view.dispatchNestedFling(f, f2, z) : view instanceof NestedScrollingChild ? ((NestedScrollingChild) view).dispatchNestedFling(f, f2, z) : false;
    }

    public static boolean dispatchNestedPreFling(View view, float f, float f2) {
        return VERSION.SDK_INT >= 21 ? view.dispatchNestedPreFling(f, f2) : view instanceof NestedScrollingChild ? ((NestedScrollingChild) view).dispatchNestedPreFling(f, f2) : false;
    }

    public static boolean dispatchNestedPreScroll(View view, int i, int i2, int[] iArr, int[] iArr2) {
        return VERSION.SDK_INT >= 21 ? view.dispatchNestedPreScroll(i, i2, iArr, iArr2) : view instanceof NestedScrollingChild ? ((NestedScrollingChild) view).dispatchNestedPreScroll(i, i2, iArr, iArr2) : false;
    }

    public static boolean dispatchNestedPreScroll(View view, int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return view instanceof NestedScrollingChild2 ? ((NestedScrollingChild2) view).dispatchNestedPreScroll(i, i2, iArr, iArr2, i3) : i3 == 0 ? dispatchNestedPreScroll(view, i, i2, iArr, iArr2) : false;
    }

    public static boolean dispatchNestedScroll(View view, int i, int i2, int i3, int i4, int[] iArr) {
        return VERSION.SDK_INT >= 21 ? view.dispatchNestedScroll(i, i2, i3, i4, iArr) : view instanceof NestedScrollingChild ? ((NestedScrollingChild) view).dispatchNestedScroll(i, i2, i3, i4, iArr) : false;
    }

    public static boolean dispatchNestedScroll(View view, int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return view instanceof NestedScrollingChild2 ? ((NestedScrollingChild2) view).dispatchNestedScroll(i, i2, i3, i4, iArr, i5) : i5 == 0 ? dispatchNestedScroll(view, i, i2, i3, i4, iArr) : false;
    }

    public static void dispatchStartTemporaryDetach(View view) {
        if (VERSION.SDK_INT >= 24) {
            view.dispatchStartTemporaryDetach();
            return;
        }
        if (!sTempDetachBound) {
            bindTempDetach();
        }
        Method method = sDispatchStartTemporaryDetach;
        if (method != null) {
            try {
                method.invoke(view, new Object[0]);
                return;
            } catch (Throwable e) {
                Log.d(TAG, "Error calling dispatchStartTemporaryDetach", e);
                return;
            }
        }
        view.onStartTemporaryDetach();
    }

    static boolean dispatchUnhandledKeyEventBeforeCallback(View view, KeyEvent keyEvent) {
        return VERSION.SDK_INT >= 28 ? false : UnhandledKeyEventManager.at(view).dispatch(view, keyEvent);
    }

    static boolean dispatchUnhandledKeyEventBeforeHierarchy(View view, KeyEvent keyEvent) {
        return VERSION.SDK_INT >= 28 ? false : UnhandledKeyEventManager.at(view).preDispatch(keyEvent);
    }

    public static int generateViewId() {
        if (VERSION.SDK_INT >= 17) {
            return View.generateViewId();
        }
        int i;
        int i2;
        do {
            i = sNextGeneratedId.get();
            i2 = i + 1;
            if (i2 > MEASURED_SIZE_MASK) {
                i2 = 1;
            }
        } while (!sNextGeneratedId.compareAndSet(i, i2));
        return i;
    }

    public static int getAccessibilityLiveRegion(View view) {
        return VERSION.SDK_INT >= 19 ? view.getAccessibilityLiveRegion() : 0;
    }

    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (VERSION.SDK_INT >= 16) {
            AccessibilityNodeProvider accessibilityNodeProvider = view.getAccessibilityNodeProvider();
            if (accessibilityNodeProvider != null) {
                return new AccessibilityNodeProviderCompat(accessibilityNodeProvider);
            }
        }
        return null;
    }

    @Deprecated
    public static float getAlpha(View view) {
        return view.getAlpha();
    }

    public static ColorStateList getBackgroundTintList(View view) {
        if (VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        return view instanceof TintableBackgroundView ? ((TintableBackgroundView) view).getSupportBackgroundTintList() : null;
    }

    public static Mode getBackgroundTintMode(View view) {
        if (VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        return view instanceof TintableBackgroundView ? ((TintableBackgroundView) view).getSupportBackgroundTintMode() : null;
    }

    public static Rect getClipBounds(View view) {
        return VERSION.SDK_INT >= 18 ? view.getClipBounds() : null;
    }

    public static Display getDisplay(View view) {
        return VERSION.SDK_INT >= 17 ? view.getDisplay() : isAttachedToWindow(view) ? ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay() : null;
    }

    public static float getElevation(View view) {
        return VERSION.SDK_INT >= 21 ? view.getElevation() : 0.0f;
    }

    private static Rect getEmptyTempRect() {
        if (sThreadLocalRect == null) {
            sThreadLocalRect = new ThreadLocal();
        }
        Rect rect = (Rect) sThreadLocalRect.get();
        if (rect == null) {
            rect = new Rect();
            sThreadLocalRect.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static boolean getFitsSystemWindows(View view) {
        return VERSION.SDK_INT >= 16 ? view.getFitsSystemWindows() : false;
    }

    public static int getImportantForAccessibility(View view) {
        return VERSION.SDK_INT >= 16 ? view.getImportantForAccessibility() : 0;
    }

    @SuppressLint({"InlinedApi"})
    public static int getImportantForAutofill(View view) {
        return VERSION.SDK_INT >= 26 ? view.getImportantForAutofill() : 0;
    }

    public static int getLabelFor(View view) {
        return VERSION.SDK_INT >= 17 ? view.getLabelFor() : 0;
    }

    @Deprecated
    public static int getLayerType(View view) {
        return view.getLayerType();
    }

    public static int getLayoutDirection(View view) {
        return VERSION.SDK_INT >= 17 ? view.getLayoutDirection() : 0;
    }

    @Deprecated
    public static Matrix getMatrix(View view) {
        return view.getMatrix();
    }

    @Deprecated
    public static int getMeasuredHeightAndState(View view) {
        return view.getMeasuredHeightAndState();
    }

    @Deprecated
    public static int getMeasuredState(View view) {
        return view.getMeasuredState();
    }

    @Deprecated
    public static int getMeasuredWidthAndState(View view) {
        return view.getMeasuredWidthAndState();
    }

    public static int getMinimumHeight(android.view.View r3) {
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
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 16;
        if (r0 < r1) goto L_0x000b;
    L_0x0006:
        r3 = r3.getMinimumHeight();
        return r3;
    L_0x000b:
        r0 = sMinHeightFieldFetched;
        if (r0 != 0) goto L_0x0021;
    L_0x000f:
        r0 = 1;
        r1 = android.view.View.class;	 Catch:{ NoSuchFieldException -> 0x001f }
        r2 = "mMinHeight";	 Catch:{ NoSuchFieldException -> 0x001f }
        r1 = r1.getDeclaredField(r2);	 Catch:{ NoSuchFieldException -> 0x001f }
        sMinHeightField = r1;	 Catch:{ NoSuchFieldException -> 0x001f }
        r1 = sMinHeightField;	 Catch:{ NoSuchFieldException -> 0x001f }
        r1.setAccessible(r0);	 Catch:{ NoSuchFieldException -> 0x001f }
    L_0x001f:
        sMinHeightFieldFetched = r0;
    L_0x0021:
        r0 = sMinHeightField;
        if (r0 == 0) goto L_0x0030;
    L_0x0025:
        r3 = r0.get(r3);	 Catch:{ Exception -> 0x0030 }
        r3 = (java.lang.Integer) r3;	 Catch:{ Exception -> 0x0030 }
        r3 = r3.intValue();	 Catch:{ Exception -> 0x0030 }
        return r3;
    L_0x0030:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewCompat.getMinimumHeight(android.view.View):int");
    }

    public static int getMinimumWidth(android.view.View r3) {
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
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 16;
        if (r0 < r1) goto L_0x000b;
    L_0x0006:
        r3 = r3.getMinimumWidth();
        return r3;
    L_0x000b:
        r0 = sMinWidthFieldFetched;
        if (r0 != 0) goto L_0x0021;
    L_0x000f:
        r0 = 1;
        r1 = android.view.View.class;	 Catch:{ NoSuchFieldException -> 0x001f }
        r2 = "mMinWidth";	 Catch:{ NoSuchFieldException -> 0x001f }
        r1 = r1.getDeclaredField(r2);	 Catch:{ NoSuchFieldException -> 0x001f }
        sMinWidthField = r1;	 Catch:{ NoSuchFieldException -> 0x001f }
        r1 = sMinWidthField;	 Catch:{ NoSuchFieldException -> 0x001f }
        r1.setAccessible(r0);	 Catch:{ NoSuchFieldException -> 0x001f }
    L_0x001f:
        sMinWidthFieldFetched = r0;
    L_0x0021:
        r0 = sMinWidthField;
        if (r0 == 0) goto L_0x0030;
    L_0x0025:
        r3 = r0.get(r3);	 Catch:{ Exception -> 0x0030 }
        r3 = (java.lang.Integer) r3;	 Catch:{ Exception -> 0x0030 }
        r3 = r3.intValue();	 Catch:{ Exception -> 0x0030 }
        return r3;
    L_0x0030:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewCompat.getMinimumWidth(android.view.View):int");
    }

    public static int getNextClusterForwardId(View view) {
        return VERSION.SDK_INT >= 26 ? view.getNextClusterForwardId() : -1;
    }

    @Deprecated
    public static int getOverScrollMode(View view) {
        return view.getOverScrollMode();
    }

    public static int getPaddingEnd(View view) {
        return VERSION.SDK_INT >= 17 ? view.getPaddingEnd() : view.getPaddingRight();
    }

    public static int getPaddingStart(View view) {
        return VERSION.SDK_INT >= 17 ? view.getPaddingStart() : view.getPaddingLeft();
    }

    public static ViewParent getParentForAccessibility(View view) {
        return VERSION.SDK_INT >= 16 ? view.getParentForAccessibility() : view.getParent();
    }

    @Deprecated
    public static float getPivotX(View view) {
        return view.getPivotX();
    }

    @Deprecated
    public static float getPivotY(View view) {
        return view.getPivotY();
    }

    @Deprecated
    public static float getRotation(View view) {
        return view.getRotation();
    }

    @Deprecated
    public static float getRotationX(View view) {
        return view.getRotationX();
    }

    @Deprecated
    public static float getRotationY(View view) {
        return view.getRotationY();
    }

    @Deprecated
    public static float getScaleX(View view) {
        return view.getScaleX();
    }

    @Deprecated
    public static float getScaleY(View view) {
        return view.getScaleY();
    }

    public static int getScrollIndicators(View view) {
        return VERSION.SDK_INT >= 23 ? view.getScrollIndicators() : 0;
    }

    public static String getTransitionName(View view) {
        if (VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap weakHashMap = sTransitionNameMap;
        return weakHashMap == null ? null : (String) weakHashMap.get(view);
    }

    @Deprecated
    public static float getTranslationX(View view) {
        return view.getTranslationX();
    }

    @Deprecated
    public static float getTranslationY(View view) {
        return view.getTranslationY();
    }

    public static float getTranslationZ(View view) {
        return VERSION.SDK_INT >= 21 ? view.getTranslationZ() : 0.0f;
    }

    public static int getWindowSystemUiVisibility(View view) {
        return VERSION.SDK_INT >= 16 ? view.getWindowSystemUiVisibility() : 0;
    }

    @Deprecated
    public static float getX(View view) {
        return view.getX();
    }

    @Deprecated
    public static float getY(View view) {
        return view.getY();
    }

    public static float getZ(View view) {
        return VERSION.SDK_INT >= 21 ? view.getZ() : 0.0f;
    }

    public static boolean hasAccessibilityDelegate(android.view.View r4) {
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
        r0 = sAccessibilityDelegateCheckFailed;
        r1 = 0;
        if (r0 == 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r0 = sAccessibilityDelegateField;
        r2 = 1;
        if (r0 != 0) goto L_0x001e;
    L_0x000b:
        r0 = android.view.View.class;	 Catch:{ Throwable -> 0x001b }
        r3 = "mAccessibilityDelegate";	 Catch:{ Throwable -> 0x001b }
        r0 = r0.getDeclaredField(r3);	 Catch:{ Throwable -> 0x001b }
        sAccessibilityDelegateField = r0;	 Catch:{ Throwable -> 0x001b }
        r0 = sAccessibilityDelegateField;	 Catch:{ Throwable -> 0x001b }
        r0.setAccessible(r2);	 Catch:{ Throwable -> 0x001b }
        goto L_0x001e;
    L_0x001b:
        sAccessibilityDelegateCheckFailed = r2;
        return r1;
    L_0x001e:
        r0 = sAccessibilityDelegateField;	 Catch:{ Throwable -> 0x0028 }
        r4 = r0.get(r4);	 Catch:{ Throwable -> 0x0028 }
        if (r4 == 0) goto L_0x0027;
    L_0x0026:
        r1 = 1;
    L_0x0027:
        return r1;
    L_0x0028:
        sAccessibilityDelegateCheckFailed = r2;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewCompat.hasAccessibilityDelegate(android.view.View):boolean");
    }

    public static boolean hasExplicitFocusable(View view) {
        return VERSION.SDK_INT >= 26 ? view.hasExplicitFocusable() : view.hasFocusable();
    }

    public static boolean hasNestedScrollingParent(View view) {
        return VERSION.SDK_INT >= 21 ? view.hasNestedScrollingParent() : view instanceof NestedScrollingChild ? ((NestedScrollingChild) view).hasNestedScrollingParent() : false;
    }

    public static boolean hasNestedScrollingParent(View view, int i) {
        if (view instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2) view).hasNestedScrollingParent(i);
        } else if (i == 0) {
            return hasNestedScrollingParent(view);
        }
        return false;
    }

    public static boolean hasOnClickListeners(View view) {
        return VERSION.SDK_INT >= 15 ? view.hasOnClickListeners() : false;
    }

    public static boolean hasOverlappingRendering(View view) {
        return VERSION.SDK_INT >= 16 ? view.hasOverlappingRendering() : true;
    }

    public static boolean hasTransientState(View view) {
        return VERSION.SDK_INT >= 16 ? view.hasTransientState() : false;
    }

    public static boolean isAttachedToWindow(View view) {
        if (VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    public static boolean isFocusedByDefault(View view) {
        return VERSION.SDK_INT >= 26 ? view.isFocusedByDefault() : false;
    }

    public static boolean isImportantForAccessibility(View view) {
        return VERSION.SDK_INT >= 21 ? view.isImportantForAccessibility() : true;
    }

    public static boolean isImportantForAutofill(View view) {
        return VERSION.SDK_INT >= 26 ? view.isImportantForAutofill() : true;
    }

    public static boolean isInLayout(View view) {
        return VERSION.SDK_INT >= 18 ? view.isInLayout() : false;
    }

    public static boolean isKeyboardNavigationCluster(View view) {
        return VERSION.SDK_INT >= 26 ? view.isKeyboardNavigationCluster() : false;
    }

    public static boolean isLaidOut(View view) {
        if (VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        boolean z = view.getWidth() > 0 && view.getHeight() > 0;
        return z;
    }

    public static boolean isLayoutDirectionResolved(View view) {
        return VERSION.SDK_INT >= 19 ? view.isLayoutDirectionResolved() : false;
    }

    public static boolean isNestedScrollingEnabled(View view) {
        return VERSION.SDK_INT >= 21 ? view.isNestedScrollingEnabled() : view instanceof NestedScrollingChild ? ((NestedScrollingChild) view).isNestedScrollingEnabled() : false;
    }

    @Deprecated
    public static boolean isOpaque(View view) {
        return view.isOpaque();
    }

    public static boolean isPaddingRelative(View view) {
        return VERSION.SDK_INT >= 17 ? view.isPaddingRelative() : false;
    }

    @Deprecated
    public static void jumpDrawablesToCurrentState(View view) {
        view.jumpDrawablesToCurrentState();
    }

    public static View keyboardNavigationClusterSearch(View view, View view2, int i) {
        return VERSION.SDK_INT >= 26 ? view.keyboardNavigationClusterSearch(view2, i) : null;
    }

    public static void offsetLeftAndRight(View view, int i) {
        int i2 = VERSION.SDK_INT;
        if (i2 >= 23) {
            view.offsetLeftAndRight(i);
        } else if (i2 >= 21) {
            Rect emptyTempRect = getEmptyTempRect();
            int i3 = 0;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                emptyTempRect.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                i3 = emptyTempRect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ^ 1;
            }
            compatOffsetLeftAndRight(view, i);
            if (i3 != 0 && emptyTempRect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(emptyTempRect);
            }
        } else {
            compatOffsetLeftAndRight(view, i);
        }
    }

    public static void offsetTopAndBottom(View view, int i) {
        int i2 = VERSION.SDK_INT;
        if (i2 >= 23) {
            view.offsetTopAndBottom(i);
        } else if (i2 >= 21) {
            Rect emptyTempRect = getEmptyTempRect();
            int i3 = 0;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                emptyTempRect.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                i3 = emptyTempRect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ^ 1;
            }
            compatOffsetTopAndBottom(view, i);
            if (i3 != 0 && emptyTempRect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(emptyTempRect);
            }
        } else {
            compatOffsetTopAndBottom(view, i);
        }
    }

    public static WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        if (VERSION.SDK_INT < 21) {
            return windowInsetsCompat;
        }
        Object obj = (WindowInsets) WindowInsetsCompat.unwrap(windowInsetsCompat);
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(obj);
        if (onApplyWindowInsets != obj) {
            obj = new WindowInsets(onApplyWindowInsets);
        }
        return WindowInsetsCompat.wrap(obj);
    }

    @Deprecated
    public static void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        view.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public static void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat.unwrap());
    }

    @Deprecated
    public static void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        view.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    public static boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return VERSION.SDK_INT >= 16 ? view.performAccessibilityAction(i, bundle) : false;
    }

    public static void postInvalidateOnAnimation(View view) {
        if (VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    public static void postInvalidateOnAnimation(View view, int i, int i2, int i3, int i4) {
        if (VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation(i, i2, i3, i4);
        } else {
            view.postInvalidate(i, i2, i3, i4);
        }
    }

    public static void postOnAnimation(View view, Runnable runnable) {
        if (VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    public static void postOnAnimationDelayed(View view, Runnable runnable, long j) {
        if (VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j);
        }
    }

    public static void removeOnUnhandledKeyEventListener(View view, OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        if (VERSION.SDK_INT >= 28) {
            Map map = (Map) view.getTag(C0011e.tag_unhandled_key_listeners);
            if (map != null) {
                OnUnhandledKeyEventListener onUnhandledKeyEventListener = (OnUnhandledKeyEventListener) map.get(onUnhandledKeyEventListenerCompat);
                if (onUnhandledKeyEventListener != null) {
                    view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
                }
                return;
            }
            return;
        }
        ArrayList arrayList = (ArrayList) view.getTag(C0011e.tag_unhandled_key_listeners);
        if (arrayList != null) {
            arrayList.remove(onUnhandledKeyEventListenerCompat);
            if (arrayList.size() == 0) {
                UnhandledKeyEventManager.unregisterListeningView(view);
            }
        }
    }

    public static void requestApplyInsets(View view) {
        int i = VERSION.SDK_INT;
        if (i >= 20) {
            view.requestApplyInsets();
        } else if (i >= 16) {
            view.requestFitSystemWindows();
        }
    }

    public static <T extends View> T requireViewById(View view, int i) {
        if (VERSION.SDK_INT >= 28) {
            return view.requireViewById(i);
        }
        T findViewById = view.findViewById(i);
        if (findViewById != null) {
            return findViewById;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this View");
    }

    @Deprecated
    public static int resolveSizeAndState(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    public static boolean restoreDefaultFocus(View view) {
        return VERSION.SDK_INT >= 26 ? view.restoreDefaultFocus() : view.requestFocus();
    }

    public static void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        view.setAccessibilityDelegate(accessibilityDelegateCompat == null ? null : accessibilityDelegateCompat.getBridge());
    }

    public static void setAccessibilityLiveRegion(View view, int i) {
        if (VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(i);
        }
    }

    @Deprecated
    public static void setActivated(View view, boolean z) {
        view.setActivated(z);
    }

    @Deprecated
    public static void setAlpha(View view, float f) {
        view.setAlpha(f);
    }

    public static void setAutofillHints(View view, String... strArr) {
        if (VERSION.SDK_INT >= 26) {
            view.setAutofillHints(strArr);
        }
    }

    public static void setBackground(View view, Drawable drawable) {
        if (VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void setBackgroundTintList(View view, ColorStateList colorStateList) {
        if (VERSION.SDK_INT >= 21) {
            view.setBackgroundTintList(colorStateList);
            if (VERSION.SDK_INT == 21) {
                Object obj;
                Drawable background = view.getBackground();
                if (view.getBackgroundTintList() == null) {
                    if (view.getBackgroundTintMode() == null) {
                        obj = null;
                        if (background != null && r0 != null) {
                            if (background.isStateful()) {
                                background.setState(view.getDrawableState());
                            }
                            view.setBackground(background);
                            return;
                        }
                    }
                }
                obj = 1;
                if (background != null) {
                }
            }
        } else if (view instanceof TintableBackgroundView) {
            ((TintableBackgroundView) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    public static void setBackgroundTintMode(View view, Mode mode) {
        if (VERSION.SDK_INT >= 21) {
            view.setBackgroundTintMode(mode);
            if (VERSION.SDK_INT == 21) {
                Object obj;
                Drawable background = view.getBackground();
                if (view.getBackgroundTintList() == null) {
                    if (view.getBackgroundTintMode() == null) {
                        obj = null;
                        if (background != null && r0 != null) {
                            if (background.isStateful()) {
                                background.setState(view.getDrawableState());
                            }
                            view.setBackground(background);
                            return;
                        }
                    }
                }
                obj = 1;
                if (background != null) {
                }
            }
        } else if (view instanceof TintableBackgroundView) {
            ((TintableBackgroundView) view).setSupportBackgroundTintMode(mode);
        }
    }

    @Deprecated
    public static void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean z) {
        Throwable e;
        String str = "Unable to invoke childrenDrawingOrderEnabled";
        Method method = sChildrenDrawingOrderMethod;
        String str2 = TAG;
        if (method == null) {
            try {
                sChildrenDrawingOrderMethod = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
            } catch (Throwable e2) {
                Log.e(str2, "Unable to find childrenDrawingOrderEnabled", e2);
            }
            sChildrenDrawingOrderMethod.setAccessible(true);
        }
        try {
            sChildrenDrawingOrderMethod.invoke(viewGroup, new Object[]{Boolean.valueOf(z)});
        } catch (IllegalAccessException e3) {
            e = e3;
            Log.e(str2, str, e);
        } catch (IllegalArgumentException e4) {
            e = e4;
            Log.e(str2, str, e);
        } catch (InvocationTargetException e5) {
            e = e5;
            Log.e(str2, str, e);
        }
    }

    public static void setClipBounds(View view, Rect rect) {
        if (VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    public static void setElevation(View view, float f) {
        if (VERSION.SDK_INT >= 21) {
            view.setElevation(f);
        }
    }

    @Deprecated
    public static void setFitsSystemWindows(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static void setFocusedByDefault(View view, boolean z) {
        if (VERSION.SDK_INT >= 26) {
            view.setFocusedByDefault(z);
        }
    }

    public static void setHasTransientState(View view, boolean z) {
        if (VERSION.SDK_INT >= 16) {
            view.setHasTransientState(z);
        }
    }

    public static void setImportantForAccessibility(View view, int i) {
        int i2 = VERSION.SDK_INT;
        if (i2 < 19) {
            if (i2 < 16) {
                return;
            }
            if (i == 4) {
                i = 2;
            }
        }
        view.setImportantForAccessibility(i);
    }

    public static void setImportantForAutofill(View view, int i) {
        if (VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i);
        }
    }

    public static void setKeyboardNavigationCluster(View view, boolean z) {
        if (VERSION.SDK_INT >= 26) {
            view.setKeyboardNavigationCluster(z);
        }
    }

    public static void setLabelFor(View view, int i) {
        if (VERSION.SDK_INT >= 17) {
            view.setLabelFor(i);
        }
    }

    public static void setLayerPaint(View view, Paint paint) {
        if (VERSION.SDK_INT >= 17) {
            view.setLayerPaint(paint);
            return;
        }
        view.setLayerType(view.getLayerType(), paint);
        view.invalidate();
    }

    @Deprecated
    public static void setLayerType(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public static void setLayoutDirection(View view, int i) {
        if (VERSION.SDK_INT >= 17) {
            view.setLayoutDirection(i);
        }
    }

    public static void setNestedScrollingEnabled(View view, boolean z) {
        if (VERSION.SDK_INT >= 21) {
            view.setNestedScrollingEnabled(z);
        } else if (view instanceof NestedScrollingChild) {
            ((NestedScrollingChild) view).setNestedScrollingEnabled(z);
        }
    }

    public static void setNextClusterForwardId(View view, int i) {
        if (VERSION.SDK_INT >= 26) {
            view.setNextClusterForwardId(i);
        }
    }

    public static void setOnApplyWindowInsetsListener(View view, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        if (VERSION.SDK_INT >= 21) {
            if (onApplyWindowInsetsListener == null) {
                view.setOnApplyWindowInsetsListener(null);
                return;
            }
            view.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return (WindowInsets) WindowInsetsCompat.unwrap(onApplyWindowInsetsListener.onApplyWindowInsets(view, WindowInsetsCompat.wrap(windowInsets)));
                }
            });
        }
    }

    @Deprecated
    public static void setOverScrollMode(View view, int i) {
        view.setOverScrollMode(i);
    }

    public static void setPaddingRelative(View view, int i, int i2, int i3, int i4) {
        if (VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i, i2, i3, i4);
        } else {
            view.setPadding(i, i2, i3, i4);
        }
    }

    @Deprecated
    public static void setPivotX(View view, float f) {
        view.setPivotX(f);
    }

    @Deprecated
    public static void setPivotY(View view, float f) {
        view.setPivotY(f);
    }

    public static void setPointerIcon(View view, PointerIconCompat pointerIconCompat) {
        if (VERSION.SDK_INT >= 24) {
            view.setPointerIcon((PointerIcon) (pointerIconCompat != null ? pointerIconCompat.getPointerIcon() : null));
        }
    }

    @Deprecated
    public static void setRotation(View view, float f) {
        view.setRotation(f);
    }

    @Deprecated
    public static void setRotationX(View view, float f) {
        view.setRotationX(f);
    }

    @Deprecated
    public static void setRotationY(View view, float f) {
        view.setRotationY(f);
    }

    @Deprecated
    public static void setSaveFromParentEnabled(View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }

    @Deprecated
    public static void setScaleX(View view, float f) {
        view.setScaleX(f);
    }

    @Deprecated
    public static void setScaleY(View view, float f) {
        view.setScaleY(f);
    }

    public static void setScrollIndicators(View view, int i) {
        if (VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i);
        }
    }

    public static void setScrollIndicators(View view, int i, int i2) {
        if (VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i, i2);
        }
    }

    public static void setTooltipText(View view, CharSequence charSequence) {
        if (VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        }
    }

    public static void setTransitionName(View view, String str) {
        if (VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (sTransitionNameMap == null) {
            sTransitionNameMap = new WeakHashMap();
        }
        sTransitionNameMap.put(view, str);
    }

    @Deprecated
    public static void setTranslationX(View view, float f) {
        view.setTranslationX(f);
    }

    @Deprecated
    public static void setTranslationY(View view, float f) {
        view.setTranslationY(f);
    }

    public static void setTranslationZ(View view, float f) {
        if (VERSION.SDK_INT >= 21) {
            view.setTranslationZ(f);
        }
    }

    @Deprecated
    public static void setX(View view, float f) {
        view.setX(f);
    }

    @Deprecated
    public static void setY(View view, float f) {
        view.setY(f);
    }

    public static void setZ(View view, float f) {
        if (VERSION.SDK_INT >= 21) {
            view.setZ(f);
        }
    }

    public static boolean startDragAndDrop(View view, ClipData clipData, DragShadowBuilder dragShadowBuilder, Object obj, int i) {
        return VERSION.SDK_INT >= 24 ? view.startDragAndDrop(clipData, dragShadowBuilder, obj, i) : view.startDrag(clipData, dragShadowBuilder, obj, i);
    }

    public static boolean startNestedScroll(View view, int i) {
        return VERSION.SDK_INT >= 21 ? view.startNestedScroll(i) : view instanceof NestedScrollingChild ? ((NestedScrollingChild) view).startNestedScroll(i) : false;
    }

    public static boolean startNestedScroll(View view, int i, int i2) {
        return view instanceof NestedScrollingChild2 ? ((NestedScrollingChild2) view).startNestedScroll(i, i2) : i2 == 0 ? startNestedScroll(view, i) : false;
    }

    public static void stopNestedScroll(View view) {
        if (VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof NestedScrollingChild) {
            ((NestedScrollingChild) view).stopNestedScroll();
        }
    }

    public static void stopNestedScroll(View view, int i) {
        if (view instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2) view).stopNestedScroll(i);
        } else if (i == 0) {
            stopNestedScroll(view);
        }
    }

    private static void tickleInvalidationFlag(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static void updateDragShadow(View view, DragShadowBuilder dragShadowBuilder) {
        if (VERSION.SDK_INT >= 24) {
            view.updateDragShadow(dragShadowBuilder);
        }
    }
}
