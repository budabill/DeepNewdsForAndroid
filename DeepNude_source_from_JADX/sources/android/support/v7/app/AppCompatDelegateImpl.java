package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.view.KeyEventDispatcher;
import android.support.v4.view.KeyEventDispatcher.Component;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.app.ActionBarDrawerToggle.Delegate;
import android.support.v7.appcompat.C0222R;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.view.SupportActionModeWrapper.CallbackWrapper;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.WindowCallbackWrapper;
import android.support.v7.view.menu.ListMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ContentFrameLayout.OnAttachListener;
import android.support.v7.widget.DecorContentParent;
import android.support.v7.widget.FitWindowsViewGroup;
import android.support.v7.widget.FitWindowsViewGroup.OnFitSystemWindowsListener;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.VectorEnabledTintResources;
import android.support.v7.widget.ViewUtils;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

class AppCompatDelegateImpl extends AppCompatDelegate implements Callback, Factory2 {
    private static final boolean DEBUG = false;
    static final String EXCEPTION_HANDLER_MESSAGE_SUFFIX = ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.";
    private static final boolean IS_PRE_LOLLIPOP = (VERSION.SDK_INT < 21);
    private static final String KEY_LOCAL_NIGHT_MODE = "appcompat:local_night_mode";
    private static boolean sInstalledExceptionHandler = true;
    private static final int[] sWindowBackgroundStyleable = new int[]{16842836};
    ActionBar mActionBar;
    private ActionMenuPresenterCallback mActionMenuPresenterCallback;
    ActionMode mActionMode;
    PopupWindow mActionModePopup;
    ActionBarContextView mActionModeView;
    final AppCompatCallback mAppCompatCallback;
    private AppCompatViewInflater mAppCompatViewInflater;
    final Window.Callback mAppCompatWindowCallback;
    private boolean mApplyDayNightCalled;
    private AutoNightModeManager mAutoNightModeManager;
    private boolean mClosingActionMenu;
    final Context mContext;
    private DecorContentParent mDecorContentParent;
    private boolean mEnableDefaultActionBarUp;
    ViewPropertyAnimatorCompat mFadeAnim = null;
    private boolean mFeatureIndeterminateProgress;
    private boolean mFeatureProgress;
    private boolean mHandleNativeActionModes = true;
    boolean mHasActionBar;
    int mInvalidatePanelMenuFeatures;
    boolean mInvalidatePanelMenuPosted;
    private final Runnable mInvalidatePanelMenuRunnable = new C02172();
    boolean mIsDestroyed;
    boolean mIsFloating;
    private int mLocalNightMode = -100;
    private boolean mLongPressBackDown;
    MenuInflater mMenuInflater;
    final Window.Callback mOriginalWindowCallback;
    boolean mOverlayActionBar;
    boolean mOverlayActionMode;
    private PanelMenuPresenterCallback mPanelMenuPresenterCallback;
    private PanelFeatureState[] mPanels;
    private PanelFeatureState mPreparedPanel;
    Runnable mShowActionModePopup;
    private View mStatusGuard;
    private ViewGroup mSubDecor;
    private boolean mSubDecorInstalled;
    private Rect mTempRect1;
    private Rect mTempRect2;
    private CharSequence mTitle;
    private TextView mTitleView;
    final Window mWindow;
    boolean mWindowNoTitle;

    /* renamed from: android.support.v7.app.AppCompatDelegateImpl$2 */
    class C02172 implements Runnable {
        C02172() {
        }

        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl.mInvalidatePanelMenuFeatures & 1) != 0) {
                appCompatDelegateImpl.doInvalidatePanelMenu(0);
            }
            appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl.mInvalidatePanelMenuFeatures & 4096) != 0) {
                appCompatDelegateImpl.doInvalidatePanelMenu(108);
            }
            appCompatDelegateImpl = AppCompatDelegateImpl.this;
            appCompatDelegateImpl.mInvalidatePanelMenuPosted = false;
            appCompatDelegateImpl.mInvalidatePanelMenuFeatures = 0;
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImpl$6 */
    class C02186 implements Runnable {

        /* renamed from: android.support.v7.app.AppCompatDelegateImpl$6$1 */
        class C08951 extends ViewPropertyAnimatorListenerAdapter {
            C08951() {
            }

            public void onAnimationEnd(View view) {
                AppCompatDelegateImpl.this.mActionModeView.setAlpha(1.0f);
                AppCompatDelegateImpl.this.mFadeAnim.setListener(null);
                AppCompatDelegateImpl.this.mFadeAnim = null;
            }

            public void onAnimationStart(View view) {
                AppCompatDelegateImpl.this.mActionModeView.setVisibility(0);
            }
        }

        C02186() {
        }

        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            appCompatDelegateImpl.mActionModePopup.showAtLocation(appCompatDelegateImpl.mActionModeView, 55, 0, 0);
            AppCompatDelegateImpl.this.endOnGoingFadeAnimation();
            if (AppCompatDelegateImpl.this.shouldAnimateActionModeView()) {
                AppCompatDelegateImpl.this.mActionModeView.setAlpha(0.0f);
                appCompatDelegateImpl = AppCompatDelegateImpl.this;
                appCompatDelegateImpl.mFadeAnim = ViewCompat.animate(appCompatDelegateImpl.mActionModeView).alpha(1.0f);
                AppCompatDelegateImpl.this.mFadeAnim.setListener(new C08951());
                return;
            }
            AppCompatDelegateImpl.this.mActionModeView.setAlpha(1.0f);
            AppCompatDelegateImpl.this.mActionModeView.setVisibility(0);
        }
    }

    final class AutoNightModeManager {
        private BroadcastReceiver mAutoTimeChangeReceiver;
        private IntentFilter mAutoTimeChangeReceiverFilter;
        private boolean mIsNight;
        private TwilightManager mTwilightManager;

        /* renamed from: android.support.v7.app.AppCompatDelegateImpl$AutoNightModeManager$1 */
        class C02191 extends BroadcastReceiver {
            C02191() {
            }

            public void onReceive(Context context, Intent intent) {
                AutoNightModeManager.this.dispatchTimeChanged();
            }
        }

        AutoNightModeManager(TwilightManager twilightManager) {
            this.mTwilightManager = twilightManager;
            this.mIsNight = twilightManager.isNight();
        }

        void cleanup() {
            BroadcastReceiver broadcastReceiver = this.mAutoTimeChangeReceiver;
            if (broadcastReceiver != null) {
                AppCompatDelegateImpl.this.mContext.unregisterReceiver(broadcastReceiver);
                this.mAutoTimeChangeReceiver = null;
            }
        }

        void dispatchTimeChanged() {
            boolean isNight = this.mTwilightManager.isNight();
            if (isNight != this.mIsNight) {
                this.mIsNight = isNight;
                AppCompatDelegateImpl.this.applyDayNight();
            }
        }

        int getApplyableNightMode() {
            this.mIsNight = this.mTwilightManager.isNight();
            return this.mIsNight ? 2 : 1;
        }

        void setup() {
            cleanup();
            if (this.mAutoTimeChangeReceiver == null) {
                this.mAutoTimeChangeReceiver = new C02191();
            }
            if (this.mAutoTimeChangeReceiverFilter == null) {
                this.mAutoTimeChangeReceiverFilter = new IntentFilter();
                this.mAutoTimeChangeReceiverFilter.addAction("android.intent.action.TIME_SET");
                this.mAutoTimeChangeReceiverFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
                this.mAutoTimeChangeReceiverFilter.addAction("android.intent.action.TIME_TICK");
            }
            AppCompatDelegateImpl.this.mContext.registerReceiver(this.mAutoTimeChangeReceiver, this.mAutoTimeChangeReceiverFilter);
        }
    }

    protected static final class PanelFeatureState {
        int background;
        View createdPanelView;
        ViewGroup decorView;
        int featureId;
        Bundle frozenActionViewState;
        Bundle frozenMenuState;
        int gravity;
        boolean isHandled;
        boolean isOpen;
        boolean isPrepared;
        ListMenuPresenter listMenuPresenter;
        Context listPresenterContext;
        MenuBuilder menu;
        public boolean qwertyMode;
        boolean refreshDecorView = false;
        boolean refreshMenuContent;
        View shownPanelView;
        boolean wasLastOpen;
        int windowAnimations;
        /* renamed from: x */
        int f122x;
        /* renamed from: y */
        int f123y;

        private static class SavedState implements Parcelable {
            public static final Creator<SavedState> CREATOR = new C02201();
            int featureId;
            boolean isOpen;
            Bundle menuState;

            /* renamed from: android.support.v7.app.AppCompatDelegateImpl$PanelFeatureState$SavedState$1 */
            static class C02201 implements ClassLoaderCreator<SavedState> {
                C02201() {
                }

                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.readFromParcel(parcel, null);
                }

                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.readFromParcel(parcel, classLoader);
                }

                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }
            }

            SavedState() {
            }

            static SavedState readFromParcel(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.featureId = parcel.readInt();
                boolean z = true;
                if (parcel.readInt() != 1) {
                    z = false;
                }
                savedState.isOpen = z;
                if (savedState.isOpen) {
                    savedState.menuState = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.featureId);
                parcel.writeInt(this.isOpen);
                if (this.isOpen) {
                    parcel.writeBundle(this.menuState);
                }
            }
        }

        PanelFeatureState(int i) {
            this.featureId = i;
        }

        void applyFrozenState() {
            MenuBuilder menuBuilder = this.menu;
            if (menuBuilder != null) {
                Bundle bundle = this.frozenMenuState;
                if (bundle != null) {
                    menuBuilder.restorePresenterStates(bundle);
                    this.frozenMenuState = null;
                }
            }
        }

        public void clearMenuPresenters() {
            MenuBuilder menuBuilder = this.menu;
            if (menuBuilder != null) {
                menuBuilder.removeMenuPresenter(this.listMenuPresenter);
            }
            this.listMenuPresenter = null;
        }

        MenuView getListMenuView(MenuPresenter.Callback callback) {
            if (this.menu == null) {
                return null;
            }
            if (this.listMenuPresenter == null) {
                this.listMenuPresenter = new ListMenuPresenter(this.listPresenterContext, C0222R.layout.abc_list_menu_item_layout);
                this.listMenuPresenter.setCallback(callback);
                this.menu.addMenuPresenter(this.listMenuPresenter);
            }
            return this.listMenuPresenter.getMenuView(this.decorView);
        }

        public boolean hasPanelItems() {
            boolean z = false;
            if (this.shownPanelView == null) {
                return false;
            }
            if (this.createdPanelView != null) {
                return true;
            }
            if (this.listMenuPresenter.getAdapter().getCount() > 0) {
                z = true;
            }
            return z;
        }

        void onRestoreInstanceState(Parcelable parcelable) {
            SavedState savedState = (SavedState) parcelable;
            this.featureId = savedState.featureId;
            this.wasLastOpen = savedState.isOpen;
            this.frozenMenuState = savedState.menuState;
            this.shownPanelView = null;
            this.decorView = null;
        }

        Parcelable onSaveInstanceState() {
            Parcelable savedState = new SavedState();
            savedState.featureId = this.featureId;
            savedState.isOpen = this.isOpen;
            if (this.menu != null) {
                savedState.menuState = new Bundle();
                this.menu.savePresenterStates(savedState.menuState);
            }
            return savedState;
        }

        void setMenu(MenuBuilder menuBuilder) {
            MenuBuilder menuBuilder2 = this.menu;
            if (menuBuilder != menuBuilder2) {
                if (menuBuilder2 != null) {
                    menuBuilder2.removeMenuPresenter(this.listMenuPresenter);
                }
                this.menu = menuBuilder;
                if (menuBuilder != null) {
                    MenuPresenter menuPresenter = this.listMenuPresenter;
                    if (menuPresenter != null) {
                        menuBuilder.addMenuPresenter(menuPresenter);
                    }
                }
            }
        }

        void setStyle(Context context) {
            TypedValue typedValue = new TypedValue();
            Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(C0222R.attr.actionBarPopupTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                newTheme.applyStyle(i, true);
            }
            newTheme.resolveAttribute(C0222R.attr.panelMenuListTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 == 0) {
                i2 = C0222R.style.Theme_AppCompat_CompactMenu;
            }
            newTheme.applyStyle(i2, true);
            Context contextThemeWrapper = new ContextThemeWrapper(context, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.listPresenterContext = contextThemeWrapper;
            TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(C0222R.styleable.AppCompatTheme);
            this.background = obtainStyledAttributes.getResourceId(C0222R.styleable.AppCompatTheme_panelBackground, 0);
            this.windowAnimations = obtainStyledAttributes.getResourceId(C0222R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImpl$3 */
    class C07793 implements OnApplyWindowInsetsListener {
        C07793() {
        }

        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            int updateStatusGuard = AppCompatDelegateImpl.this.updateStatusGuard(systemWindowInsetTop);
            if (systemWindowInsetTop != updateStatusGuard) {
                windowInsetsCompat = windowInsetsCompat.replaceSystemWindowInsets(windowInsetsCompat.getSystemWindowInsetLeft(), updateStatusGuard, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            }
            return ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImpl$4 */
    class C07804 implements OnFitSystemWindowsListener {
        C07804() {
        }

        public void onFitSystemWindows(Rect rect) {
            rect.top = AppCompatDelegateImpl.this.updateStatusGuard(rect.top);
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImpl$5 */
    class C07815 implements OnAttachListener {
        C07815() {
        }

        public void onAttachedFromWindow() {
        }

        public void onDetachedFromWindow() {
            AppCompatDelegateImpl.this.dismissPopups();
        }
    }

    private class ActionBarDrawableToggleImpl implements Delegate {
        ActionBarDrawableToggleImpl() {
        }

        public Context getActionBarThemedContext() {
            return AppCompatDelegateImpl.this.getActionBarThemedContext();
        }

        public Drawable getThemeUpIndicator() {
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getActionBarThemedContext(), null, new int[]{C0222R.attr.homeAsUpIndicator});
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }

        public boolean isNavigationVisible() {
            ActionBar supportActionBar = AppCompatDelegateImpl.this.getSupportActionBar();
            return (supportActionBar == null || (supportActionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        public void setActionBarDescription(int i) {
            ActionBar supportActionBar = AppCompatDelegateImpl.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeActionContentDescription(i);
            }
        }

        public void setActionBarUpIndicator(Drawable drawable, int i) {
            ActionBar supportActionBar = AppCompatDelegateImpl.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeAsUpIndicator(drawable);
                supportActionBar.setHomeActionContentDescription(i);
            }
        }
    }

    private final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        ActionMenuPresenterCallback() {
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            AppCompatDelegateImpl.this.checkCloseActionMenu(menuBuilder);
        }

        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback windowCallback = AppCompatDelegateImpl.this.getWindowCallback();
            if (windowCallback != null) {
                windowCallback.onMenuOpened(108, menuBuilder);
            }
            return true;
        }
    }

    class ActionModeCallbackWrapperV9 implements ActionMode.Callback {
        private ActionMode.Callback mWrapped;

        /* renamed from: android.support.v7.app.AppCompatDelegateImpl$ActionModeCallbackWrapperV9$1 */
        class C08971 extends ViewPropertyAnimatorListenerAdapter {
            C08971() {
            }

            public void onAnimationEnd(View view) {
                AppCompatDelegateImpl.this.mActionModeView.setVisibility(8);
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                PopupWindow popupWindow = appCompatDelegateImpl.mActionModePopup;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (appCompatDelegateImpl.mActionModeView.getParent() instanceof View) {
                    ViewCompat.requestApplyInsets((View) AppCompatDelegateImpl.this.mActionModeView.getParent());
                }
                AppCompatDelegateImpl.this.mActionModeView.removeAllViews();
                AppCompatDelegateImpl.this.mFadeAnim.setListener(null);
                AppCompatDelegateImpl.this.mFadeAnim = null;
            }
        }

        public ActionModeCallbackWrapperV9(ActionMode.Callback callback) {
            this.mWrapped = callback;
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.mWrapped.onActionItemClicked(actionMode, menuItem);
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.mWrapped.onCreateActionMode(actionMode, menu);
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.mWrapped.onDestroyActionMode(actionMode);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.mActionModePopup != null) {
                appCompatDelegateImpl.mWindow.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.mShowActionModePopup);
            }
            appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.mActionModeView != null) {
                appCompatDelegateImpl.endOnGoingFadeAnimation();
                appCompatDelegateImpl = AppCompatDelegateImpl.this;
                appCompatDelegateImpl.mFadeAnim = ViewCompat.animate(appCompatDelegateImpl.mActionModeView).alpha(0.0f);
                AppCompatDelegateImpl.this.mFadeAnim.setListener(new C08971());
            }
            appCompatDelegateImpl = AppCompatDelegateImpl.this;
            AppCompatCallback appCompatCallback = appCompatDelegateImpl.mAppCompatCallback;
            if (appCompatCallback != null) {
                appCompatCallback.onSupportActionModeFinished(appCompatDelegateImpl.mActionMode);
            }
            AppCompatDelegateImpl.this.mActionMode = null;
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.mWrapped.onPrepareActionMode(actionMode, menu);
        }
    }

    class AppCompatWindowCallback extends WindowCallbackWrapper {
        AppCompatWindowCallback(Window.Callback callback) {
            super(callback);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (!AppCompatDelegateImpl.this.dispatchKeyEvent(keyEvent)) {
                if (!super.dispatchKeyEvent(keyEvent)) {
                    return false;
                }
            }
            return true;
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            if (!super.dispatchKeyShortcutEvent(keyEvent)) {
                if (!AppCompatDelegateImpl.this.onKeyShortcut(keyEvent.getKeyCode(), keyEvent)) {
                    return false;
                }
            }
            return true;
        }

        public void onContentChanged() {
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            return (i != 0 || (menu instanceof MenuBuilder)) ? super.onCreatePanelMenu(i, menu) : false;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            AppCompatDelegateImpl.this.onMenuOpened(i);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            AppCompatDelegateImpl.this.onPanelClosed(i);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
            if (i == 0 && menuBuilder == null) {
                return false;
            }
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(false);
            }
            return onPreparePanel;
        }

        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            PanelFeatureState panelState = AppCompatDelegateImpl.this.getPanelState(0, true);
            if (panelState != null) {
                Menu menu2 = panelState.menu;
                if (menu2 != null) {
                    super.onProvideKeyboardShortcuts(list, menu2, i);
                    return;
                }
            }
            super.onProvideKeyboardShortcuts(list, menu, i);
        }

        public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback) {
            return VERSION.SDK_INT >= 23 ? null : AppCompatDelegateImpl.this.isHandleNativeActionModesEnabled() ? startAsSupportActionMode(callback) : super.onWindowStartingActionMode(callback);
        }

        public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback, int i) {
            if (AppCompatDelegateImpl.this.isHandleNativeActionModesEnabled()) {
                if (i == 0) {
                    return startAsSupportActionMode(callback);
                }
            }
            return super.onWindowStartingActionMode(callback, i);
        }

        final android.view.ActionMode startAsSupportActionMode(android.view.ActionMode.Callback callback) {
            Object callbackWrapper = new CallbackWrapper(AppCompatDelegateImpl.this.mContext, callback);
            ActionMode startSupportActionMode = AppCompatDelegateImpl.this.startSupportActionMode(callbackWrapper);
            return startSupportActionMode != null ? callbackWrapper.getActionModeWrapper(startSupportActionMode) : null;
        }
    }

    private class ListMenuDecorView extends ContentFrameLayout {
        public ListMenuDecorView(Context context) {
            super(context);
        }

        private boolean isOutOfBounds(int i, int i2) {
            if (i >= -5 && i2 >= -5 && i <= getWidth() + 5) {
                if (i2 <= getHeight() + 5) {
                    return false;
                }
            }
            return true;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (!AppCompatDelegateImpl.this.dispatchKeyEvent(keyEvent)) {
                if (!super.dispatchKeyEvent(keyEvent)) {
                    return false;
                }
            }
            return true;
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !isOutOfBounds((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImpl.this.closePanel(0);
            return true;
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(AppCompatResources.getDrawable(getContext(), i));
        }
    }

    private final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
        PanelMenuPresenterCallback() {
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            Menu menu;
            Menu rootMenu = menuBuilder.getRootMenu();
            Object obj = rootMenu != menuBuilder ? 1 : null;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (obj != null) {
                menu = rootMenu;
            }
            PanelFeatureState findMenuPanel = appCompatDelegateImpl.findMenuPanel(menu);
            if (findMenuPanel == null) {
                return;
            }
            if (obj != null) {
                AppCompatDelegateImpl.this.callOnPanelClosed(findMenuPanel.featureId, findMenuPanel, rootMenu);
                AppCompatDelegateImpl.this.closePanel(findMenuPanel, true);
                return;
            }
            AppCompatDelegateImpl.this.closePanel(findMenuPanel, z);
        }

        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            if (menuBuilder == null) {
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                if (appCompatDelegateImpl.mHasActionBar) {
                    Window.Callback windowCallback = appCompatDelegateImpl.getWindowCallback();
                    if (!(windowCallback == null || AppCompatDelegateImpl.this.mIsDestroyed)) {
                        windowCallback.onMenuOpened(108, menuBuilder);
                    }
                }
            }
            return true;
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImpl$7 */
    class C08967 extends ViewPropertyAnimatorListenerAdapter {
        C08967() {
        }

        public void onAnimationEnd(View view) {
            AppCompatDelegateImpl.this.mActionModeView.setAlpha(1.0f);
            AppCompatDelegateImpl.this.mFadeAnim.setListener(null);
            AppCompatDelegateImpl.this.mFadeAnim = null;
        }

        public void onAnimationStart(View view) {
            AppCompatDelegateImpl.this.mActionModeView.setVisibility(0);
            AppCompatDelegateImpl.this.mActionModeView.sendAccessibilityEvent(32);
            if (AppCompatDelegateImpl.this.mActionModeView.getParent() instanceof View) {
                ViewCompat.requestApplyInsets((View) AppCompatDelegateImpl.this.mActionModeView.getParent());
            }
        }
    }

    static {
        if (IS_PRE_LOLLIPOP && !sInstalledExceptionHandler) {
            final UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
                private boolean shouldWrapException(Throwable th) {
                    if (!(th instanceof NotFoundException)) {
                        return false;
                    }
                    String message = th.getMessage();
                    return message != null ? message.contains("drawable") || message.contains("Drawable") : false;
                }

                public void uncaughtException(Thread thread, Throwable th) {
                    if (shouldWrapException(th)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(th.getMessage());
                        stringBuilder.append(AppCompatDelegateImpl.EXCEPTION_HANDLER_MESSAGE_SUFFIX);
                        Throwable notFoundException = new NotFoundException(stringBuilder.toString());
                        notFoundException.initCause(th.getCause());
                        notFoundException.setStackTrace(th.getStackTrace());
                        defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                        return;
                    }
                    defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                }
            });
        }
    }

    AppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback) {
        this.mContext = context;
        this.mWindow = window;
        this.mAppCompatCallback = appCompatCallback;
        this.mOriginalWindowCallback = this.mWindow.getCallback();
        Window.Callback callback = this.mOriginalWindowCallback;
        if (callback instanceof AppCompatWindowCallback) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.mAppCompatWindowCallback = new AppCompatWindowCallback(callback);
        this.mWindow.setCallback(this.mAppCompatWindowCallback);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, null, sWindowBackgroundStyleable);
        Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(0);
        if (drawableIfKnown != null) {
            this.mWindow.setBackgroundDrawable(drawableIfKnown);
        }
        obtainStyledAttributes.recycle();
    }

    private void applyFixedSizeWindow() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.mSubDecor.findViewById(16908290);
        View decorView = this.mWindow.getDecorView();
        contentFrameLayout.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(C0222R.styleable.AppCompatTheme);
        obtainStyledAttributes.getValue(C0222R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(C0222R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(C0222R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(C0222R.styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(C0222R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(C0222R.styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(C0222R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(C0222R.styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(C0222R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(C0222R.styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private ViewGroup createSubDecor() {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(C0222R.styleable.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(C0222R.styleable.AppCompatTheme_windowActionBar)) {
            View view;
            if (obtainStyledAttributes.getBoolean(C0222R.styleable.AppCompatTheme_windowNoTitle, false)) {
                requestWindowFeature(1);
            } else if (obtainStyledAttributes.getBoolean(C0222R.styleable.AppCompatTheme_windowActionBar, false)) {
                requestWindowFeature(108);
            }
            if (obtainStyledAttributes.getBoolean(C0222R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
                requestWindowFeature(109);
            }
            if (obtainStyledAttributes.getBoolean(C0222R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
                requestWindowFeature(10);
            }
            this.mIsFloating = obtainStyledAttributes.getBoolean(C0222R.styleable.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            this.mWindow.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.mContext);
            if (this.mWindowNoTitle) {
                view = (ViewGroup) from.inflate(this.mOverlayActionMode ? C0222R.layout.abc_screen_simple_overlay_action_mode : C0222R.layout.abc_screen_simple, null);
                if (VERSION.SDK_INT >= 21) {
                    ViewCompat.setOnApplyWindowInsetsListener(view, new C07793());
                } else {
                    ((FitWindowsViewGroup) view).setOnFitSystemWindowsListener(new C07804());
                }
            } else if (this.mIsFloating) {
                view = (ViewGroup) from.inflate(C0222R.layout.abc_dialog_title_material, null);
                this.mOverlayActionBar = false;
                this.mHasActionBar = false;
            } else if (this.mHasActionBar) {
                TypedValue typedValue = new TypedValue();
                this.mContext.getTheme().resolveAttribute(C0222R.attr.actionBarTheme, typedValue, true);
                int i = typedValue.resourceId;
                view = (ViewGroup) LayoutInflater.from(i != 0 ? new ContextThemeWrapper(this.mContext, i) : this.mContext).inflate(C0222R.layout.abc_screen_toolbar, null);
                this.mDecorContentParent = (DecorContentParent) view.findViewById(C0222R.id.decor_content_parent);
                this.mDecorContentParent.setWindowCallback(getWindowCallback());
                if (this.mOverlayActionBar) {
                    this.mDecorContentParent.initFeature(109);
                }
                if (this.mFeatureProgress) {
                    this.mDecorContentParent.initFeature(2);
                }
                if (this.mFeatureIndeterminateProgress) {
                    this.mDecorContentParent.initFeature(5);
                }
            } else {
                view = null;
            }
            if (view != null) {
                if (this.mDecorContentParent == null) {
                    this.mTitleView = (TextView) view.findViewById(C0222R.id.title);
                }
                ViewUtils.makeOptionalFitsSystemWindows(view);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view.findViewById(C0222R.id.action_bar_activity_content);
                ViewGroup viewGroup = (ViewGroup) this.mWindow.findViewById(16908290);
                if (viewGroup != null) {
                    while (viewGroup.getChildCount() > 0) {
                        View childAt = viewGroup.getChildAt(0);
                        viewGroup.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup instanceof FrameLayout) {
                        ((FrameLayout) viewGroup).setForeground(null);
                    }
                }
                this.mWindow.setContentView(view);
                contentFrameLayout.setAttachListener(new C07815());
                return view;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AppCompat does not support the current theme features: { windowActionBar: ");
            stringBuilder.append(this.mHasActionBar);
            stringBuilder.append(", windowActionBarOverlay: ");
            stringBuilder.append(this.mOverlayActionBar);
            stringBuilder.append(", android:windowIsFloating: ");
            stringBuilder.append(this.mIsFloating);
            stringBuilder.append(", windowActionModeOverlay: ");
            stringBuilder.append(this.mOverlayActionMode);
            stringBuilder.append(", windowNoTitle: ");
            stringBuilder.append(this.mWindowNoTitle);
            stringBuilder.append(" }");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void ensureAutoNightModeManager() {
        if (this.mAutoNightModeManager == null) {
            this.mAutoNightModeManager = new AutoNightModeManager(TwilightManager.getInstance(this.mContext));
        }
    }

    private void ensureSubDecor() {
        if (!this.mSubDecorInstalled) {
            this.mSubDecor = createSubDecor();
            CharSequence title = getTitle();
            if (!TextUtils.isEmpty(title)) {
                DecorContentParent decorContentParent = this.mDecorContentParent;
                if (decorContentParent != null) {
                    decorContentParent.setWindowTitle(title);
                } else if (peekSupportActionBar() != null) {
                    peekSupportActionBar().setWindowTitle(title);
                } else {
                    TextView textView = this.mTitleView;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
            applyFixedSizeWindow();
            onSubDecorInstalled(this.mSubDecor);
            this.mSubDecorInstalled = true;
            PanelFeatureState panelState = getPanelState(0, false);
            if (!this.mIsDestroyed) {
                if (panelState == null || panelState.menu == null) {
                    invalidatePanelMenu(108);
                }
            }
        }
    }

    private int getNightMode() {
        int i = this.mLocalNightMode;
        return i != -100 ? i : AppCompatDelegate.getDefaultNightMode();
    }

    private void initWindowDecorActionBar() {
        ensureSubDecor();
        if (!this.mHasActionBar) {
            return;
        }
        if (this.mActionBar == null) {
            ActionBar windowDecorActionBar;
            ActionBar actionBar;
            Window.Callback callback = this.mOriginalWindowCallback;
            if (callback instanceof Activity) {
                windowDecorActionBar = new WindowDecorActionBar((Activity) callback, this.mOverlayActionBar);
            } else {
                if (callback instanceof Dialog) {
                    windowDecorActionBar = new WindowDecorActionBar((Dialog) callback);
                }
                actionBar = this.mActionBar;
                if (actionBar != null) {
                    actionBar.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
                }
            }
            this.mActionBar = windowDecorActionBar;
            actionBar = this.mActionBar;
            if (actionBar != null) {
                actionBar.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
            }
        }
    }

    private boolean initializePanelContent(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.createdPanelView;
        boolean z = true;
        if (view != null) {
            panelFeatureState.shownPanelView = view;
            return true;
        } else if (panelFeatureState.menu == null) {
            return false;
        } else {
            if (this.mPanelMenuPresenterCallback == null) {
                this.mPanelMenuPresenterCallback = new PanelMenuPresenterCallback();
            }
            panelFeatureState.shownPanelView = (View) panelFeatureState.getListMenuView(this.mPanelMenuPresenterCallback);
            if (panelFeatureState.shownPanelView == null) {
                z = false;
            }
            return z;
        }
    }

    private boolean initializePanelDecor(PanelFeatureState panelFeatureState) {
        panelFeatureState.setStyle(getActionBarThemedContext());
        panelFeatureState.decorView = new ListMenuDecorView(panelFeatureState.listPresenterContext);
        panelFeatureState.gravity = 81;
        return true;
    }

    private boolean initializePanelMenu(PanelFeatureState panelFeatureState) {
        Context context = this.mContext;
        int i = panelFeatureState.featureId;
        if ((i == 0 || i == 108) && this.mDecorContentParent != null) {
            TypedValue typedValue = new TypedValue();
            Theme theme = context.getTheme();
            theme.resolveAttribute(C0222R.attr.actionBarTheme, typedValue, true);
            Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(C0222R.attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(C0222R.attr.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                Context contextThemeWrapper = new ContextThemeWrapper(context, 0);
                contextThemeWrapper.getTheme().setTo(theme2);
                context = contextThemeWrapper;
            }
        }
        MenuBuilder menuBuilder = new MenuBuilder(context);
        menuBuilder.setCallback(this);
        panelFeatureState.setMenu(menuBuilder);
        return true;
    }

    private void invalidatePanelMenu(int i) {
        this.mInvalidatePanelMenuFeatures = (1 << i) | this.mInvalidatePanelMenuFeatures;
        if (!this.mInvalidatePanelMenuPosted) {
            ViewCompat.postOnAnimation(this.mWindow.getDecorView(), this.mInvalidatePanelMenuRunnable);
            this.mInvalidatePanelMenuPosted = true;
        }
    }

    private boolean onKeyDownPanel(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            PanelFeatureState panelState = getPanelState(i, true);
            if (!panelState.isOpen) {
                return preparePanel(panelState, keyEvent);
            }
        }
        return false;
    }

    private boolean onKeyUpPanel(int i, KeyEvent keyEvent) {
        if (this.mActionMode != null) {
            return false;
        }
        boolean hideOverflowMenu;
        AudioManager audioManager;
        PanelFeatureState panelState = getPanelState(i, true);
        if (i == 0) {
            DecorContentParent decorContentParent = this.mDecorContentParent;
            if (!(decorContentParent == null || !decorContentParent.canShowOverflowMenu() || ViewConfiguration.get(this.mContext).hasPermanentMenuKey())) {
                if (this.mDecorContentParent.isOverflowMenuShowing()) {
                    hideOverflowMenu = this.mDecorContentParent.hideOverflowMenu();
                } else {
                    if (!this.mIsDestroyed && preparePanel(panelState, keyEvent)) {
                        hideOverflowMenu = this.mDecorContentParent.showOverflowMenu();
                    }
                    hideOverflowMenu = false;
                }
                if (hideOverflowMenu) {
                    audioManager = (AudioManager) this.mContext.getSystemService("audio");
                    if (audioManager == null) {
                        audioManager.playSoundEffect(0);
                    } else {
                        Log.w("AppCompatDelegate", "Couldn't get audio manager");
                    }
                }
                return hideOverflowMenu;
            }
        }
        if (!panelState.isOpen) {
            if (!panelState.isHandled) {
                if (panelState.isPrepared) {
                    if (panelState.refreshMenuContent) {
                        panelState.isPrepared = false;
                        hideOverflowMenu = preparePanel(panelState, keyEvent);
                    } else {
                        hideOverflowMenu = true;
                    }
                    if (hideOverflowMenu) {
                        openPanel(panelState, keyEvent);
                        hideOverflowMenu = true;
                        if (hideOverflowMenu) {
                            audioManager = (AudioManager) this.mContext.getSystemService("audio");
                            if (audioManager == null) {
                                Log.w("AppCompatDelegate", "Couldn't get audio manager");
                            } else {
                                audioManager.playSoundEffect(0);
                            }
                        }
                        return hideOverflowMenu;
                    }
                }
                hideOverflowMenu = false;
                if (hideOverflowMenu) {
                    audioManager = (AudioManager) this.mContext.getSystemService("audio");
                    if (audioManager == null) {
                        audioManager.playSoundEffect(0);
                    } else {
                        Log.w("AppCompatDelegate", "Couldn't get audio manager");
                    }
                }
                return hideOverflowMenu;
            }
        }
        hideOverflowMenu = panelState.isOpen;
        closePanel(panelState, true);
        if (hideOverflowMenu) {
            audioManager = (AudioManager) this.mContext.getSystemService("audio");
            if (audioManager == null) {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            } else {
                audioManager.playSoundEffect(0);
            }
        }
        return hideOverflowMenu;
    }

    private void openPanel(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        if (!panelFeatureState.isOpen) {
            if (!this.mIsDestroyed) {
                if (panelFeatureState.featureId == 0) {
                    if (((this.mContext.getResources().getConfiguration().screenLayout & 15) == 4 ? 1 : null) != null) {
                        return;
                    }
                }
                Window.Callback windowCallback = getWindowCallback();
                if (windowCallback == null || windowCallback.onMenuOpened(panelFeatureState.featureId, panelFeatureState.menu)) {
                    WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
                    if (windowManager != null && preparePanel(panelFeatureState, keyEvent)) {
                        LayoutParams layoutParams;
                        int i;
                        LayoutParams layoutParams2;
                        if (panelFeatureState.decorView != null) {
                            if (!panelFeatureState.refreshDecorView) {
                                View view = panelFeatureState.createdPanelView;
                                if (view != null) {
                                    layoutParams = view.getLayoutParams();
                                    if (layoutParams != null && layoutParams.width == -1) {
                                        i = -1;
                                        panelFeatureState.isHandled = false;
                                        layoutParams2 = new WindowManager.LayoutParams(i, -2, panelFeatureState.f122x, panelFeatureState.f123y, 1002, 8519680, -3);
                                        layoutParams2.gravity = panelFeatureState.gravity;
                                        layoutParams2.windowAnimations = panelFeatureState.windowAnimations;
                                        windowManager.addView(panelFeatureState.decorView, layoutParams2);
                                        panelFeatureState.isOpen = true;
                                    }
                                }
                                i = -2;
                                panelFeatureState.isHandled = false;
                                layoutParams2 = new WindowManager.LayoutParams(i, -2, panelFeatureState.f122x, panelFeatureState.f123y, 1002, 8519680, -3);
                                layoutParams2.gravity = panelFeatureState.gravity;
                                layoutParams2.windowAnimations = panelFeatureState.windowAnimations;
                                windowManager.addView(panelFeatureState.decorView, layoutParams2);
                                panelFeatureState.isOpen = true;
                            }
                        }
                        ViewGroup viewGroup = panelFeatureState.decorView;
                        if (viewGroup == null) {
                            if (!initializePanelDecor(panelFeatureState) || panelFeatureState.decorView == null) {
                                return;
                            }
                        } else if (panelFeatureState.refreshDecorView && viewGroup.getChildCount() > 0) {
                            panelFeatureState.decorView.removeAllViews();
                        }
                        if (initializePanelContent(panelFeatureState)) {
                            if (panelFeatureState.hasPanelItems()) {
                                layoutParams = panelFeatureState.shownPanelView.getLayoutParams();
                                if (layoutParams == null) {
                                    layoutParams = new LayoutParams(-2, -2);
                                }
                                panelFeatureState.decorView.setBackgroundResource(panelFeatureState.background);
                                ViewParent parent = panelFeatureState.shownPanelView.getParent();
                                if (parent != null && (parent instanceof ViewGroup)) {
                                    ((ViewGroup) parent).removeView(panelFeatureState.shownPanelView);
                                }
                                panelFeatureState.decorView.addView(panelFeatureState.shownPanelView, layoutParams);
                                if (!panelFeatureState.shownPanelView.hasFocus()) {
                                    panelFeatureState.shownPanelView.requestFocus();
                                }
                                i = -2;
                                panelFeatureState.isHandled = false;
                                layoutParams2 = new WindowManager.LayoutParams(i, -2, panelFeatureState.f122x, panelFeatureState.f123y, 1002, 8519680, -3);
                                layoutParams2.gravity = panelFeatureState.gravity;
                                layoutParams2.windowAnimations = panelFeatureState.windowAnimations;
                                windowManager.addView(panelFeatureState.decorView, layoutParams2);
                                panelFeatureState.isOpen = true;
                            }
                        }
                    } else {
                        return;
                    }
                }
                closePanel(panelFeatureState, true);
            }
        }
    }

    private boolean performPanelShortcut(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent, int i2) {
        boolean z = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if (panelFeatureState.isPrepared || preparePanel(panelFeatureState, keyEvent)) {
            MenuBuilder menuBuilder = panelFeatureState.menu;
            if (menuBuilder != null) {
                z = menuBuilder.performShortcut(i, keyEvent, i2);
            }
        }
        if (z && (i2 & 1) == 0 && this.mDecorContentParent == null) {
            closePanel(panelFeatureState, true);
        }
        return z;
    }

    private boolean preparePanel(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        if (this.mIsDestroyed) {
            return false;
        }
        if (panelFeatureState.isPrepared) {
            return true;
        }
        Object obj;
        DecorContentParent decorContentParent;
        DecorContentParent decorContentParent2;
        Bundle bundle;
        DecorContentParent decorContentParent3;
        PanelFeatureState panelFeatureState2 = this.mPreparedPanel;
        if (!(panelFeatureState2 == null || panelFeatureState2 == panelFeatureState)) {
            closePanel(panelFeatureState2, false);
        }
        Window.Callback windowCallback = getWindowCallback();
        if (windowCallback != null) {
            panelFeatureState.createdPanelView = windowCallback.onCreatePanelView(panelFeatureState.featureId);
        }
        int i = panelFeatureState.featureId;
        if (i != 0) {
            if (i != 108) {
                obj = null;
                if (obj != null) {
                    decorContentParent = this.mDecorContentParent;
                    if (decorContentParent != null) {
                        decorContentParent.setMenuPrepared();
                    }
                }
                if (panelFeatureState.createdPanelView == null && (obj == null || !(peekSupportActionBar() instanceof ToolbarActionBar))) {
                    if (panelFeatureState.menu == null || panelFeatureState.refreshMenuContent) {
                        if (panelFeatureState.menu != null && (!initializePanelMenu(panelFeatureState) || panelFeatureState.menu == null)) {
                            return false;
                        }
                        if (!(obj == null || this.mDecorContentParent == null)) {
                            if (this.mActionMenuPresenterCallback == null) {
                                this.mActionMenuPresenterCallback = new ActionMenuPresenterCallback();
                            }
                            this.mDecorContentParent.setMenu(panelFeatureState.menu, this.mActionMenuPresenterCallback);
                        }
                        panelFeatureState.menu.stopDispatchingItemsChanged();
                        if (windowCallback.onCreatePanelMenu(panelFeatureState.featureId, panelFeatureState.menu)) {
                            panelFeatureState.setMenu(null);
                            if (obj != null) {
                                decorContentParent2 = this.mDecorContentParent;
                                if (decorContentParent2 != null) {
                                    decorContentParent2.setMenu(null, this.mActionMenuPresenterCallback);
                                }
                            }
                            return false;
                        }
                        panelFeatureState.refreshMenuContent = false;
                    }
                    panelFeatureState.menu.stopDispatchingItemsChanged();
                    bundle = panelFeatureState.frozenActionViewState;
                    if (bundle != null) {
                        panelFeatureState.menu.restoreActionViewStates(bundle);
                        panelFeatureState.frozenActionViewState = null;
                    }
                    if (windowCallback.onPreparePanel(0, panelFeatureState.createdPanelView, panelFeatureState.menu)) {
                        if (obj != null) {
                            decorContentParent3 = this.mDecorContentParent;
                            if (decorContentParent3 != null) {
                                decorContentParent3.setMenu(null, this.mActionMenuPresenterCallback);
                            }
                        }
                        panelFeatureState.menu.startDispatchingItemsChanged();
                        return false;
                    }
                    panelFeatureState.qwertyMode = KeyCharacterMap.load(keyEvent == null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1;
                    panelFeatureState.menu.setQwertyMode(panelFeatureState.qwertyMode);
                    panelFeatureState.menu.startDispatchingItemsChanged();
                }
                panelFeatureState.isPrepared = true;
                panelFeatureState.isHandled = false;
                this.mPreparedPanel = panelFeatureState;
                return true;
            }
        }
        obj = 1;
        if (obj != null) {
            decorContentParent = this.mDecorContentParent;
            if (decorContentParent != null) {
                decorContentParent.setMenuPrepared();
            }
        }
        if (panelFeatureState.menu != null) {
        }
        if (this.mActionMenuPresenterCallback == null) {
            this.mActionMenuPresenterCallback = new ActionMenuPresenterCallback();
        }
        this.mDecorContentParent.setMenu(panelFeatureState.menu, this.mActionMenuPresenterCallback);
        panelFeatureState.menu.stopDispatchingItemsChanged();
        if (windowCallback.onCreatePanelMenu(panelFeatureState.featureId, panelFeatureState.menu)) {
            panelFeatureState.refreshMenuContent = false;
            panelFeatureState.menu.stopDispatchingItemsChanged();
            bundle = panelFeatureState.frozenActionViewState;
            if (bundle != null) {
                panelFeatureState.menu.restoreActionViewStates(bundle);
                panelFeatureState.frozenActionViewState = null;
            }
            if (windowCallback.onPreparePanel(0, panelFeatureState.createdPanelView, panelFeatureState.menu)) {
                if (keyEvent == null) {
                }
                if (KeyCharacterMap.load(keyEvent == null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
                }
                panelFeatureState.qwertyMode = KeyCharacterMap.load(keyEvent == null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1;
                panelFeatureState.menu.setQwertyMode(panelFeatureState.qwertyMode);
                panelFeatureState.menu.startDispatchingItemsChanged();
                panelFeatureState.isPrepared = true;
                panelFeatureState.isHandled = false;
                this.mPreparedPanel = panelFeatureState;
                return true;
            }
            if (obj != null) {
                decorContentParent3 = this.mDecorContentParent;
                if (decorContentParent3 != null) {
                    decorContentParent3.setMenu(null, this.mActionMenuPresenterCallback);
                }
            }
            panelFeatureState.menu.startDispatchingItemsChanged();
            return false;
        }
        panelFeatureState.setMenu(null);
        if (obj != null) {
            decorContentParent2 = this.mDecorContentParent;
            if (decorContentParent2 != null) {
                decorContentParent2.setMenu(null, this.mActionMenuPresenterCallback);
            }
        }
        return false;
    }

    private void reopenMenu(MenuBuilder menuBuilder, boolean z) {
        DecorContentParent decorContentParent = this.mDecorContentParent;
        if (decorContentParent == null || !decorContentParent.canShowOverflowMenu() || (ViewConfiguration.get(this.mContext).hasPermanentMenuKey() && !this.mDecorContentParent.isOverflowMenuShowPending())) {
            PanelFeatureState panelState = getPanelState(0, true);
            panelState.refreshDecorView = true;
            closePanel(panelState, false);
            openPanel(panelState, null);
            return;
        }
        Window.Callback windowCallback = getWindowCallback();
        if (this.mDecorContentParent.isOverflowMenuShowing()) {
            if (z) {
                this.mDecorContentParent.hideOverflowMenu();
                if (!this.mIsDestroyed) {
                    windowCallback.onPanelClosed(108, getPanelState(0, true).menu);
                }
            }
        }
        if (!(windowCallback == null || this.mIsDestroyed)) {
            if (this.mInvalidatePanelMenuPosted && (this.mInvalidatePanelMenuFeatures & 1) != 0) {
                this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
                this.mInvalidatePanelMenuRunnable.run();
            }
            PanelFeatureState panelState2 = getPanelState(0, true);
            Menu menu = panelState2.menu;
            if (!(menu == null || panelState2.refreshMenuContent || !windowCallback.onPreparePanel(0, panelState2.createdPanelView, menu))) {
                windowCallback.onMenuOpened(108, panelState2.menu);
                this.mDecorContentParent.showOverflowMenu();
            }
        }
    }

    private int sanitizeWindowFeatureId(int i) {
        String str = "AppCompatDelegate";
        if (i == 8) {
            Log.i(str, "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i == 9) {
            Log.i(str, "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i = 109;
        }
        return i;
    }

    private boolean shouldInheritContext(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        ViewParent decorView = this.mWindow.getDecorView();
        while (viewParent != null) {
            if (viewParent != decorView && (viewParent instanceof View)) {
                if (!ViewCompat.isAttachedToWindow((View) viewParent)) {
                    viewParent = viewParent.getParent();
                }
            }
            return false;
        }
        return true;
    }

    private boolean shouldRecreateOnNightModeChange() {
        boolean z = false;
        if (this.mApplyDayNightCalled) {
            Context context = this.mContext;
            if (context instanceof Activity) {
                try {
                    if ((context.getPackageManager().getActivityInfo(new ComponentName(this.mContext, this.mContext.getClass()), 0).configChanges & 512) == 0) {
                        z = true;
                    }
                    return z;
                } catch (Throwable e) {
                    Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
                    return true;
                }
            }
        }
        return false;
    }

    private void throwFeatureRequestIfSubDecorInstalled() {
        if (this.mSubDecorInstalled) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private boolean updateForNightMode(int i) {
        Resources resources = this.mContext.getResources();
        Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        i = i == 2 ? 32 : 16;
        if (i2 == i) {
            return false;
        }
        if (shouldRecreateOnNightModeChange()) {
            ((Activity) this.mContext).recreate();
        } else {
            Configuration configuration2 = new Configuration(configuration);
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            configuration2.uiMode = i | (configuration2.uiMode & -49);
            resources.updateConfiguration(configuration2, displayMetrics);
            if (VERSION.SDK_INT < 26) {
                ResourcesFlusher.flush(resources);
            }
        }
        return true;
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        ensureSubDecor();
        ((ViewGroup) this.mSubDecor.findViewById(16908290)).addView(view, layoutParams);
        this.mOriginalWindowCallback.onContentChanged();
    }

    public boolean applyDayNight() {
        int nightMode = getNightMode();
        int mapNightMode = mapNightMode(nightMode);
        boolean updateForNightMode = mapNightMode != -1 ? updateForNightMode(mapNightMode) : false;
        if (nightMode == 0) {
            ensureAutoNightModeManager();
            this.mAutoNightModeManager.setup();
        }
        this.mApplyDayNightCalled = true;
        return updateForNightMode;
    }

    void callOnPanelClosed(int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.mPanels;
                if (i < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.menu;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.isOpen) && !this.mIsDestroyed) {
            this.mOriginalWindowCallback.onPanelClosed(i, menu);
        }
    }

    void checkCloseActionMenu(MenuBuilder menuBuilder) {
        if (!this.mClosingActionMenu) {
            this.mClosingActionMenu = true;
            this.mDecorContentParent.dismissPopups();
            Window.Callback windowCallback = getWindowCallback();
            if (!(windowCallback == null || this.mIsDestroyed)) {
                windowCallback.onPanelClosed(108, menuBuilder);
            }
            this.mClosingActionMenu = false;
        }
    }

    void closePanel(int i) {
        closePanel(getPanelState(i, true), true);
    }

    void closePanel(PanelFeatureState panelFeatureState, boolean z) {
        if (z && panelFeatureState.featureId == 0) {
            DecorContentParent decorContentParent = this.mDecorContentParent;
            if (decorContentParent != null && decorContentParent.isOverflowMenuShowing()) {
                checkCloseActionMenu(panelFeatureState.menu);
                return;
            }
        }
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null && panelFeatureState.isOpen) {
            View view = panelFeatureState.decorView;
            if (view != null) {
                windowManager.removeView(view);
                if (z) {
                    callOnPanelClosed(panelFeatureState.featureId, panelFeatureState, null);
                }
            }
        }
        panelFeatureState.isPrepared = false;
        panelFeatureState.isHandled = false;
        panelFeatureState.isOpen = false;
        panelFeatureState.shownPanelView = null;
        panelFeatureState.refreshDecorView = true;
        if (this.mPreparedPanel == panelFeatureState) {
            this.mPreparedPanel = null;
        }
    }

    public View createView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        boolean z2 = false;
        if (this.mAppCompatViewInflater == null) {
            AppCompatViewInflater appCompatViewInflater;
            String string = this.mContext.obtainStyledAttributes(C0222R.styleable.AppCompatTheme).getString(C0222R.styleable.AppCompatTheme_viewInflaterClass);
            if (string != null) {
                if (!AppCompatViewInflater.class.getName().equals(string)) {
                    try {
                        this.mAppCompatViewInflater = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    } catch (Throwable th) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Failed to instantiate custom view inflater ");
                        stringBuilder.append(string);
                        stringBuilder.append(". Falling back to default.");
                        Log.i("AppCompatDelegate", stringBuilder.toString(), th);
                        appCompatViewInflater = new AppCompatViewInflater();
                    }
                }
            }
            appCompatViewInflater = new AppCompatViewInflater();
            this.mAppCompatViewInflater = appCompatViewInflater;
        }
        if (IS_PRE_LOLLIPOP) {
            if (!(attributeSet instanceof XmlPullParser)) {
                z2 = shouldInheritContext((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z2 = true;
            }
            z = z2;
        } else {
            z = false;
        }
        return this.mAppCompatViewInflater.createView(view, str, context, attributeSet, z, IS_PRE_LOLLIPOP, true, VectorEnabledTintResources.shouldBeUsed());
    }

    void dismissPopups() {
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
        r2 = this;
        r0 = r2.mDecorContentParent;
        if (r0 == 0) goto L_0x0007;
    L_0x0004:
        r0.dismissPopups();
    L_0x0007:
        r0 = r2.mActionModePopup;
        if (r0 == 0) goto L_0x0026;
    L_0x000b:
        r0 = r2.mWindow;
        r0 = r0.getDecorView();
        r1 = r2.mShowActionModePopup;
        r0.removeCallbacks(r1);
        r0 = r2.mActionModePopup;
        r0 = r0.isShowing();
        if (r0 == 0) goto L_0x0023;
    L_0x001e:
        r0 = r2.mActionModePopup;	 Catch:{ IllegalArgumentException -> 0x0023 }
        r0.dismiss();	 Catch:{ IllegalArgumentException -> 0x0023 }
    L_0x0023:
        r0 = 0;
        r2.mActionModePopup = r0;
    L_0x0026:
        r2.endOnGoingFadeAnimation();
        r0 = 0;
        r0 = r2.getPanelState(r0, r0);
        if (r0 == 0) goto L_0x0037;
    L_0x0030:
        r0 = r0.menu;
        if (r0 == 0) goto L_0x0037;
    L_0x0034:
        r0.close();
    L_0x0037:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatDelegateImpl.dismissPopups():void");
    }

    boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Window.Callback callback = this.mOriginalWindowCallback;
        boolean z = true;
        if ((callback instanceof Component) || (callback instanceof AppCompatDialog)) {
            View decorView = this.mWindow.getDecorView();
            if (decorView != null && KeyEventDispatcher.dispatchBeforeHierarchy(decorView, keyEvent)) {
                return true;
            }
        }
        if (keyEvent.getKeyCode() == 82 && this.mOriginalWindowCallback.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z = false;
        }
        return z ? onKeyDown(keyCode, keyEvent) : onKeyUp(keyCode, keyEvent);
    }

    void doInvalidatePanelMenu(int i) {
        PanelFeatureState panelState = getPanelState(i, true);
        if (panelState.menu != null) {
            Bundle bundle = new Bundle();
            panelState.menu.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                panelState.frozenActionViewState = bundle;
            }
            panelState.menu.stopDispatchingItemsChanged();
            panelState.menu.clear();
        }
        panelState.refreshMenuContent = true;
        panelState.refreshDecorView = true;
        if ((i == 108 || i == 0) && this.mDecorContentParent != null) {
            PanelFeatureState panelState2 = getPanelState(0, false);
            if (panelState2 != null) {
                panelState2.isPrepared = false;
                preparePanel(panelState2, null);
            }
        }
    }

    void endOnGoingFadeAnimation() {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mFadeAnim;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
        }
    }

    PanelFeatureState findMenuPanel(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.mPanels;
        int i = 0;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        while (i < length) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.menu == menu) {
                return panelFeatureState;
            }
            i++;
        }
        return null;
    }

    public <T extends View> T findViewById(int i) {
        ensureSubDecor();
        return this.mWindow.findViewById(i);
    }

    final Context getActionBarThemedContext() {
        ActionBar supportActionBar = getSupportActionBar();
        Context themedContext = supportActionBar != null ? supportActionBar.getThemedContext() : null;
        return themedContext == null ? this.mContext : themedContext;
    }

    final AutoNightModeManager getAutoNightModeManager() {
        ensureAutoNightModeManager();
        return this.mAutoNightModeManager;
    }

    public final Delegate getDrawerToggleDelegate() {
        return new ActionBarDrawableToggleImpl();
    }

    public MenuInflater getMenuInflater() {
        if (this.mMenuInflater == null) {
            initWindowDecorActionBar();
            ActionBar actionBar = this.mActionBar;
            this.mMenuInflater = new SupportMenuInflater(actionBar != null ? actionBar.getThemedContext() : this.mContext);
        }
        return this.mMenuInflater;
    }

    protected PanelFeatureState getPanelState(int i, boolean z) {
        Object obj = this.mPanels;
        if (obj == null || obj.length <= i) {
            Object obj2 = new PanelFeatureState[(i + 1)];
            if (obj != null) {
                System.arraycopy(obj, 0, obj2, 0, obj.length);
            }
            this.mPanels = obj2;
            obj = obj2;
        }
        PanelFeatureState panelFeatureState = obj[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        panelFeatureState = new PanelFeatureState(i);
        obj[i] = panelFeatureState;
        return panelFeatureState;
    }

    ViewGroup getSubDecor() {
        return this.mSubDecor;
    }

    public ActionBar getSupportActionBar() {
        initWindowDecorActionBar();
        return this.mActionBar;
    }

    final CharSequence getTitle() {
        Window.Callback callback = this.mOriginalWindowCallback;
        return callback instanceof Activity ? ((Activity) callback).getTitle() : this.mTitle;
    }

    final Window.Callback getWindowCallback() {
        return this.mWindow.getCallback();
    }

    public boolean hasWindowFeature(int i) {
        int sanitizeWindowFeatureId = sanitizeWindowFeatureId(i);
        boolean z = sanitizeWindowFeatureId != 1 ? sanitizeWindowFeatureId != 2 ? sanitizeWindowFeatureId != 5 ? sanitizeWindowFeatureId != 10 ? sanitizeWindowFeatureId != 108 ? sanitizeWindowFeatureId != 109 ? false : this.mOverlayActionBar : this.mHasActionBar : this.mOverlayActionMode : this.mFeatureIndeterminateProgress : this.mFeatureProgress : this.mWindowNoTitle;
        return !z ? this.mWindow.hasFeature(i) : true;
    }

    public void installViewFactory() {
        LayoutInflater from = LayoutInflater.from(this.mContext);
        if (from.getFactory() == null) {
            LayoutInflaterCompat.setFactory2(from, this);
        } else if (!(from.getFactory2() instanceof AppCompatDelegateImpl)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public void invalidateOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null || !supportActionBar.invalidateOptionsMenu()) {
            invalidatePanelMenu(0);
        }
    }

    public boolean isHandleNativeActionModesEnabled() {
        return this.mHandleNativeActionModes;
    }

    int mapNightMode(int i) {
        if (i == -100) {
            return -1;
        }
        if (i != 0) {
            return i;
        }
        if (VERSION.SDK_INT >= 23 && ((UiModeManager) this.mContext.getSystemService(UiModeManager.class)).getNightMode() == 0) {
            return -1;
        }
        ensureAutoNightModeManager();
        return this.mAutoNightModeManager.getApplyableNightMode();
    }

    boolean onBackPressed() {
        ActionMode actionMode = this.mActionMode;
        if (actionMode != null) {
            actionMode.finish();
            return true;
        }
        ActionBar supportActionBar = getSupportActionBar();
        return supportActionBar != null && supportActionBar.collapseActionView();
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.mHasActionBar && this.mSubDecorInstalled) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.onConfigurationChanged(configuration);
            }
        }
        AppCompatDrawableManager.get().onConfigurationChanged(this.mContext);
        applyDayNight();
    }

    public void onCreate(android.os.Bundle r3) {
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
        r2 = this;
        r0 = r2.mOriginalWindowCallback;
        r1 = r0 instanceof android.app.Activity;
        if (r1 == 0) goto L_0x001c;
    L_0x0006:
        r1 = 0;
        r0 = (android.app.Activity) r0;	 Catch:{ IllegalArgumentException -> 0x000d }
        r1 = android.support.v4.app.NavUtils.getParentActivityName(r0);	 Catch:{ IllegalArgumentException -> 0x000d }
    L_0x000d:
        if (r1 == 0) goto L_0x001c;
    L_0x000f:
        r0 = r2.peekSupportActionBar();
        r1 = 1;
        if (r0 != 0) goto L_0x0019;
    L_0x0016:
        r2.mEnableDefaultActionBarUp = r1;
        goto L_0x001c;
    L_0x0019:
        r0.setDefaultDisplayHomeAsUpEnabled(r1);
    L_0x001c:
        if (r3 == 0) goto L_0x002c;
    L_0x001e:
        r0 = r2.mLocalNightMode;
        r1 = -100;
        if (r0 != r1) goto L_0x002c;
    L_0x0024:
        r0 = "appcompat:local_night_mode";
        r3 = r3.getInt(r0, r1);
        r2.mLocalNightMode = r3;
    L_0x002c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatDelegateImpl.onCreate(android.os.Bundle):void");
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return createView(view, str, context, attributeSet);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public void onDestroy() {
        if (this.mInvalidatePanelMenuPosted) {
            this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
        }
        this.mIsDestroyed = true;
        ActionBar actionBar = this.mActionBar;
        if (actionBar != null) {
            actionBar.onDestroy();
        }
        AutoNightModeManager autoNightModeManager = this.mAutoNightModeManager;
        if (autoNightModeManager != null) {
            autoNightModeManager.cleanup();
        }
    }

    boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (i == 4) {
            if ((keyEvent.getFlags() & 128) == 0) {
                z = false;
            }
            this.mLongPressBackDown = z;
        } else if (i == 82) {
            onKeyDownPanel(0, keyEvent);
            return true;
        }
        return false;
    }

    boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null && supportActionBar.onKeyShortcut(i, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.mPreparedPanel;
        if (panelFeatureState == null || !performPanelShortcut(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.mPreparedPanel == null) {
                panelFeatureState = getPanelState(0, true);
                preparePanel(panelFeatureState, keyEvent);
                boolean performPanelShortcut = performPanelShortcut(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1);
                panelFeatureState.isPrepared = false;
                if (performPanelShortcut) {
                    return true;
                }
            }
            return false;
        }
        panelFeatureState = this.mPreparedPanel;
        if (panelFeatureState != null) {
            panelFeatureState.isHandled = true;
        }
        return true;
    }

    boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            boolean z = this.mLongPressBackDown;
            this.mLongPressBackDown = false;
            PanelFeatureState panelState = getPanelState(0, false);
            if (panelState != null && panelState.isOpen) {
                if (!z) {
                    closePanel(panelState, true);
                }
                return true;
            } else if (onBackPressed()) {
                return true;
            }
        } else if (i == 82) {
            onKeyUpPanel(0, keyEvent);
            return true;
        }
        return false;
    }

    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        Window.Callback windowCallback = getWindowCallback();
        if (!(windowCallback == null || this.mIsDestroyed)) {
            PanelFeatureState findMenuPanel = findMenuPanel(menuBuilder.getRootMenu());
            if (findMenuPanel != null) {
                return windowCallback.onMenuItemSelected(findMenuPanel.featureId, menuItem);
            }
        }
        return false;
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
        reopenMenu(menuBuilder, true);
    }

    void onMenuOpened(int i) {
        if (i == 108) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.dispatchMenuVisibilityChanged(true);
            }
        }
    }

    void onPanelClosed(int i) {
        if (i == 108) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.dispatchMenuVisibilityChanged(false);
            }
        } else if (i == 0) {
            PanelFeatureState panelState = getPanelState(i, true);
            if (panelState.isOpen) {
                closePanel(panelState, false);
            }
        }
    }

    public void onPostCreate(Bundle bundle) {
        ensureSubDecor();
    }

    public void onPostResume() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(true);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        int i = this.mLocalNightMode;
        if (i != -100) {
            bundle.putInt(KEY_LOCAL_NIGHT_MODE, i);
        }
    }

    public void onStart() {
        applyDayNight();
    }

    public void onStop() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
        }
        AutoNightModeManager autoNightModeManager = this.mAutoNightModeManager;
        if (autoNightModeManager != null) {
            autoNightModeManager.cleanup();
        }
    }

    void onSubDecorInstalled(ViewGroup viewGroup) {
    }

    final ActionBar peekSupportActionBar() {
        return this.mActionBar;
    }

    public boolean requestWindowFeature(int i) {
        i = sanitizeWindowFeatureId(i);
        if (this.mWindowNoTitle && i == 108) {
            return false;
        }
        if (this.mHasActionBar && i == 1) {
            this.mHasActionBar = false;
        }
        if (i == 1) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mWindowNoTitle = true;
            return true;
        } else if (i == 2) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mFeatureProgress = true;
            return true;
        } else if (i == 5) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mFeatureIndeterminateProgress = true;
            return true;
        } else if (i == 10) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mOverlayActionMode = true;
            return true;
        } else if (i == 108) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mHasActionBar = true;
            return true;
        } else if (i != 109) {
            return this.mWindow.requestFeature(i);
        } else {
            throwFeatureRequestIfSubDecorInstalled();
            this.mOverlayActionBar = true;
            return true;
        }
    }

    public void setContentView(int i) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.mContext).inflate(i, viewGroup);
        this.mOriginalWindowCallback.onContentChanged();
    }

    public void setContentView(View view) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.mOriginalWindowCallback.onContentChanged();
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.mOriginalWindowCallback.onContentChanged();
    }

    public void setHandleNativeActionModesEnabled(boolean z) {
        this.mHandleNativeActionModes = z;
    }

    public void setLocalNightMode(int i) {
        if (i != -1 && i != 0 && i != 1 && i != 2) {
            Log.i("AppCompatDelegate", "setLocalNightMode() called with an unknown mode");
        } else if (this.mLocalNightMode != i) {
            this.mLocalNightMode = i;
            if (this.mApplyDayNightCalled) {
                applyDayNight();
            }
        }
    }

    public void setSupportActionBar(Toolbar toolbar) {
        if (this.mOriginalWindowCallback instanceof Activity) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar instanceof WindowDecorActionBar) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            Window window;
            Window.Callback wrappedWindowCallback;
            this.mMenuInflater = null;
            if (supportActionBar != null) {
                supportActionBar.onDestroy();
            }
            if (toolbar != null) {
                supportActionBar = new ToolbarActionBar(toolbar, ((Activity) this.mOriginalWindowCallback).getTitle(), this.mAppCompatWindowCallback);
                this.mActionBar = supportActionBar;
                window = this.mWindow;
                wrappedWindowCallback = supportActionBar.getWrappedWindowCallback();
            } else {
                this.mActionBar = null;
                window = this.mWindow;
                wrappedWindowCallback = this.mAppCompatWindowCallback;
            }
            window.setCallback(wrappedWindowCallback);
            invalidateOptionsMenu();
        }
    }

    public final void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        DecorContentParent decorContentParent = this.mDecorContentParent;
        if (decorContentParent != null) {
            decorContentParent.setWindowTitle(charSequence);
        } else if (peekSupportActionBar() != null) {
            peekSupportActionBar().setWindowTitle(charSequence);
        } else {
            TextView textView = this.mTitleView;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    final boolean shouldAnimateActionModeView() {
        if (this.mSubDecorInstalled) {
            View view = this.mSubDecor;
            if (view != null && ViewCompat.isLaidOut(view)) {
                return true;
            }
        }
        return false;
    }

    public ActionMode startSupportActionMode(ActionMode.Callback callback) {
        if (callback != null) {
            ActionMode actionMode = this.mActionMode;
            if (actionMode != null) {
                actionMode.finish();
            }
            ActionMode.Callback actionModeCallbackWrapperV9 = new ActionModeCallbackWrapperV9(callback);
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                this.mActionMode = supportActionBar.startActionMode(actionModeCallbackWrapperV9);
                ActionMode actionMode2 = this.mActionMode;
                if (actionMode2 != null) {
                    AppCompatCallback appCompatCallback = this.mAppCompatCallback;
                    if (appCompatCallback != null) {
                        appCompatCallback.onSupportActionModeStarted(actionMode2);
                    }
                }
            }
            if (this.mActionMode == null) {
                this.mActionMode = startSupportActionModeFromWindow(actionModeCallbackWrapperV9);
            }
            return this.mActionMode;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    android.support.v7.view.ActionMode startSupportActionModeFromWindow(android.support.v7.view.ActionMode.Callback r8) {
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
        r7 = this;
        r7.endOnGoingFadeAnimation();
        r0 = r7.mActionMode;
        if (r0 == 0) goto L_0x000a;
    L_0x0007:
        r0.finish();
    L_0x000a:
        r0 = r8 instanceof android.support.v7.app.AppCompatDelegateImpl.ActionModeCallbackWrapperV9;
        if (r0 != 0) goto L_0x0014;
    L_0x000e:
        r0 = new android.support.v7.app.AppCompatDelegateImpl$ActionModeCallbackWrapperV9;
        r0.<init>(r8);
        r8 = r0;
    L_0x0014:
        r0 = r7.mAppCompatCallback;
        r1 = 0;
        if (r0 == 0) goto L_0x0022;
    L_0x0019:
        r2 = r7.mIsDestroyed;
        if (r2 != 0) goto L_0x0022;
    L_0x001d:
        r0 = r0.onWindowStartingSupportActionMode(r8);	 Catch:{ AbstractMethodError -> 0x0022 }
        goto L_0x0023;
    L_0x0022:
        r0 = r1;
    L_0x0023:
        if (r0 == 0) goto L_0x0029;
    L_0x0025:
        r7.mActionMode = r0;
        goto L_0x0166;
    L_0x0029:
        r0 = r7.mActionModeView;
        r2 = 0;
        r3 = 1;
        if (r0 != 0) goto L_0x00d6;
    L_0x002f:
        r0 = r7.mIsFloating;
        if (r0 == 0) goto L_0x00b7;
    L_0x0033:
        r0 = new android.util.TypedValue;
        r0.<init>();
        r4 = r7.mContext;
        r4 = r4.getTheme();
        r5 = android.support.v7.appcompat.C0222R.attr.actionBarTheme;
        r4.resolveAttribute(r5, r0, r3);
        r5 = r0.resourceId;
        if (r5 == 0) goto L_0x0068;
    L_0x0047:
        r5 = r7.mContext;
        r5 = r5.getResources();
        r5 = r5.newTheme();
        r5.setTo(r4);
        r4 = r0.resourceId;
        r5.applyStyle(r4, r3);
        r4 = new android.support.v7.view.ContextThemeWrapper;
        r6 = r7.mContext;
        r4.<init>(r6, r2);
        r6 = r4.getTheme();
        r6.setTo(r5);
        goto L_0x006a;
    L_0x0068:
        r4 = r7.mContext;
    L_0x006a:
        r5 = new android.support.v7.widget.ActionBarContextView;
        r5.<init>(r4);
        r7.mActionModeView = r5;
        r5 = new android.widget.PopupWindow;
        r6 = android.support.v7.appcompat.C0222R.attr.actionModePopupWindowStyle;
        r5.<init>(r4, r1, r6);
        r7.mActionModePopup = r5;
        r5 = r7.mActionModePopup;
        r6 = 2;
        android.support.v4.widget.PopupWindowCompat.setWindowLayoutType(r5, r6);
        r5 = r7.mActionModePopup;
        r6 = r7.mActionModeView;
        r5.setContentView(r6);
        r5 = r7.mActionModePopup;
        r6 = -1;
        r5.setWidth(r6);
        r5 = r4.getTheme();
        r6 = android.support.v7.appcompat.C0222R.attr.actionBarSize;
        r5.resolveAttribute(r6, r0, r3);
        r0 = r0.data;
        r4 = r4.getResources();
        r4 = r4.getDisplayMetrics();
        r0 = android.util.TypedValue.complexToDimensionPixelSize(r0, r4);
        r4 = r7.mActionModeView;
        r4.setContentHeight(r0);
        r0 = r7.mActionModePopup;
        r4 = -2;
        r0.setHeight(r4);
        r0 = new android.support.v7.app.AppCompatDelegateImpl$6;
        r0.<init>();
        r7.mShowActionModePopup = r0;
        goto L_0x00d6;
    L_0x00b7:
        r0 = r7.mSubDecor;
        r4 = android.support.v7.appcompat.C0222R.id.action_mode_bar_stub;
        r0 = r0.findViewById(r4);
        r0 = (android.support.v7.widget.ViewStubCompat) r0;
        if (r0 == 0) goto L_0x00d6;
    L_0x00c3:
        r4 = r7.getActionBarThemedContext();
        r4 = android.view.LayoutInflater.from(r4);
        r0.setLayoutInflater(r4);
        r0 = r0.inflate();
        r0 = (android.support.v7.widget.ActionBarContextView) r0;
        r7.mActionModeView = r0;
    L_0x00d6:
        r0 = r7.mActionModeView;
        if (r0 == 0) goto L_0x0166;
    L_0x00da:
        r7.endOnGoingFadeAnimation();
        r0 = r7.mActionModeView;
        r0.killMode();
        r0 = new android.support.v7.view.StandaloneActionMode;
        r4 = r7.mActionModeView;
        r4 = r4.getContext();
        r5 = r7.mActionModeView;
        r6 = r7.mActionModePopup;
        if (r6 != 0) goto L_0x00f1;
    L_0x00f0:
        goto L_0x00f2;
    L_0x00f1:
        r3 = 0;
    L_0x00f2:
        r0.<init>(r4, r5, r8, r3);
        r3 = r0.getMenu();
        r8 = r8.onCreateActionMode(r0, r3);
        if (r8 == 0) goto L_0x0164;
    L_0x00ff:
        r0.invalidate();
        r8 = r7.mActionModeView;
        r8.initForMode(r0);
        r7.mActionMode = r0;
        r8 = r7.shouldAnimateActionModeView();
        r0 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        if (r8 == 0) goto L_0x012e;
    L_0x0111:
        r8 = r7.mActionModeView;
        r1 = 0;
        r8.setAlpha(r1);
        r8 = r7.mActionModeView;
        r8 = android.support.v4.view.ViewCompat.animate(r8);
        r8 = r8.alpha(r0);
        r7.mFadeAnim = r8;
        r8 = r7.mFadeAnim;
        r0 = new android.support.v7.app.AppCompatDelegateImpl$7;
        r0.<init>();
        r8.setListener(r0);
        goto L_0x0154;
    L_0x012e:
        r8 = r7.mActionModeView;
        r8.setAlpha(r0);
        r8 = r7.mActionModeView;
        r8.setVisibility(r2);
        r8 = r7.mActionModeView;
        r0 = 32;
        r8.sendAccessibilityEvent(r0);
        r8 = r7.mActionModeView;
        r8 = r8.getParent();
        r8 = r8 instanceof android.view.View;
        if (r8 == 0) goto L_0x0154;
    L_0x0149:
        r8 = r7.mActionModeView;
        r8 = r8.getParent();
        r8 = (android.view.View) r8;
        android.support.v4.view.ViewCompat.requestApplyInsets(r8);
    L_0x0154:
        r8 = r7.mActionModePopup;
        if (r8 == 0) goto L_0x0166;
    L_0x0158:
        r8 = r7.mWindow;
        r8 = r8.getDecorView();
        r0 = r7.mShowActionModePopup;
        r8.post(r0);
        goto L_0x0166;
    L_0x0164:
        r7.mActionMode = r1;
    L_0x0166:
        r8 = r7.mActionMode;
        if (r8 == 0) goto L_0x0171;
    L_0x016a:
        r0 = r7.mAppCompatCallback;
        if (r0 == 0) goto L_0x0171;
    L_0x016e:
        r0.onSupportActionModeStarted(r8);
    L_0x0171:
        r8 = r7.mActionMode;
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatDelegateImpl.startSupportActionModeFromWindow(android.support.v7.view.ActionMode$Callback):android.support.v7.view.ActionMode");
    }

    int updateStatusGuard(int i) {
        Object obj;
        ViewGroup viewGroup = this.mActionModeView;
        int i2 = 0;
        if (viewGroup == null || !(viewGroup.getLayoutParams() instanceof MarginLayoutParams)) {
            obj = null;
        } else {
            Object obj2;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.mActionModeView.getLayoutParams();
            obj = 1;
            if (this.mActionModeView.isShown()) {
                if (this.mTempRect1 == null) {
                    this.mTempRect1 = new Rect();
                    this.mTempRect2 = new Rect();
                }
                Rect rect = this.mTempRect1;
                Rect rect2 = this.mTempRect2;
                rect.set(0, i, 0, 0);
                ViewUtils.computeFitSystemWindows(this.mSubDecor, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    View view = this.mStatusGuard;
                    if (view == null) {
                        this.mStatusGuard = new View(this.mContext);
                        this.mStatusGuard.setBackgroundColor(this.mContext.getResources().getColor(C0222R.color.abc_input_method_navigation_guard));
                        this.mSubDecor.addView(this.mStatusGuard, -1, new LayoutParams(-1, i));
                    } else {
                        LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.mStatusGuard.setLayoutParams(layoutParams);
                        }
                    }
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (this.mStatusGuard == null) {
                    obj = null;
                }
                if (!(this.mOverlayActionMode || r3 == null)) {
                    i = 0;
                }
            } else {
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                obj = null;
            }
            if (obj2 != null) {
                this.mActionModeView.setLayoutParams(marginLayoutParams);
            }
        }
        View view2 = this.mStatusGuard;
        if (view2 != null) {
            if (obj == null) {
                i2 = 8;
            }
            view2.setVisibility(i2);
        }
        return i;
    }
}
