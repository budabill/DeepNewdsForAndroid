package android.support.v7.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar.LayoutParams;
import android.support.v7.app.ActionBar.OnMenuVisibilityListener;
import android.support.v7.app.ActionBar.OnNavigationListener;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.view.WindowCallbackWrapper;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;
import android.widget.SpinnerAdapter;
import java.util.ArrayList;

class ToolbarActionBar extends ActionBar {
    DecorToolbar mDecorToolbar;
    private boolean mLastMenuVisibility;
    private boolean mMenuCallbackSet;
    private final OnMenuItemClickListener mMenuClicker = new C07832();
    private final Runnable mMenuInvalidator = new C02211();
    private ArrayList<OnMenuVisibilityListener> mMenuVisibilityListeners = new ArrayList();
    boolean mToolbarMenuPrepared;
    Callback mWindowCallback;

    /* renamed from: android.support.v7.app.ToolbarActionBar$1 */
    class C02211 implements Runnable {
        C02211() {
        }

        public void run() {
            ToolbarActionBar.this.populateOptionsMenu();
        }
    }

    /* renamed from: android.support.v7.app.ToolbarActionBar$2 */
    class C07832 implements OnMenuItemClickListener {
        C07832() {
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return ToolbarActionBar.this.mWindowCallback.onMenuItemSelected(0, menuItem);
        }
    }

    private final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        private boolean mClosingActionMenu;

        ActionMenuPresenterCallback() {
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            if (!this.mClosingActionMenu) {
                this.mClosingActionMenu = true;
                ToolbarActionBar.this.mDecorToolbar.dismissPopupMenus();
                Callback callback = ToolbarActionBar.this.mWindowCallback;
                if (callback != null) {
                    callback.onPanelClosed(108, menuBuilder);
                }
                this.mClosingActionMenu = false;
            }
        }

        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Callback callback = ToolbarActionBar.this.mWindowCallback;
            if (callback == null) {
                return false;
            }
            callback.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    private final class MenuBuilderCallback implements MenuBuilder.Callback {
        MenuBuilderCallback() {
        }

        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            return false;
        }

        public void onMenuModeChange(MenuBuilder menuBuilder) {
            ToolbarActionBar toolbarActionBar = ToolbarActionBar.this;
            if (toolbarActionBar.mWindowCallback == null) {
                return;
            }
            if (toolbarActionBar.mDecorToolbar.isOverflowMenuShowing()) {
                ToolbarActionBar.this.mWindowCallback.onPanelClosed(108, menuBuilder);
            } else if (ToolbarActionBar.this.mWindowCallback.onPreparePanel(0, null, menuBuilder)) {
                ToolbarActionBar.this.mWindowCallback.onMenuOpened(108, menuBuilder);
            }
        }
    }

    private class ToolbarCallbackWrapper extends WindowCallbackWrapper {
        public ToolbarCallbackWrapper(Callback callback) {
            super(callback);
        }

        public View onCreatePanelView(int i) {
            return i == 0 ? new View(ToolbarActionBar.this.mDecorToolbar.getContext()) : super.onCreatePanelView(i);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel) {
                ToolbarActionBar toolbarActionBar = ToolbarActionBar.this;
                if (!toolbarActionBar.mToolbarMenuPrepared) {
                    toolbarActionBar.mDecorToolbar.setMenuPrepared();
                    ToolbarActionBar.this.mToolbarMenuPrepared = true;
                }
            }
            return onPreparePanel;
        }
    }

    ToolbarActionBar(Toolbar toolbar, CharSequence charSequence, Callback callback) {
        this.mDecorToolbar = new ToolbarWidgetWrapper(toolbar, false);
        this.mWindowCallback = new ToolbarCallbackWrapper(callback);
        this.mDecorToolbar.setWindowCallback(this.mWindowCallback);
        toolbar.setOnMenuItemClickListener(this.mMenuClicker);
        this.mDecorToolbar.setWindowTitle(charSequence);
    }

    private Menu getMenu() {
        if (!this.mMenuCallbackSet) {
            this.mDecorToolbar.setMenuCallbacks(new ActionMenuPresenterCallback(), new MenuBuilderCallback());
            this.mMenuCallbackSet = true;
        }
        return this.mDecorToolbar.getMenu();
    }

    public void addOnMenuVisibilityListener(OnMenuVisibilityListener onMenuVisibilityListener) {
        this.mMenuVisibilityListeners.add(onMenuVisibilityListener);
    }

    public void addTab(Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void addTab(Tab tab, int i) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void addTab(Tab tab, int i, boolean z) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void addTab(Tab tab, boolean z) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public boolean closeOptionsMenu() {
        return this.mDecorToolbar.hideOverflowMenu();
    }

    public boolean collapseActionView() {
        if (!this.mDecorToolbar.hasExpandedActionView()) {
            return false;
        }
        this.mDecorToolbar.collapseActionView();
        return true;
    }

    public void dispatchMenuVisibilityChanged(boolean z) {
        if (z != this.mLastMenuVisibility) {
            this.mLastMenuVisibility = z;
            int size = this.mMenuVisibilityListeners.size();
            for (int i = 0; i < size; i++) {
                ((OnMenuVisibilityListener) this.mMenuVisibilityListeners.get(i)).onMenuVisibilityChanged(z);
            }
        }
    }

    public View getCustomView() {
        return this.mDecorToolbar.getCustomView();
    }

    public int getDisplayOptions() {
        return this.mDecorToolbar.getDisplayOptions();
    }

    public float getElevation() {
        return ViewCompat.getElevation(this.mDecorToolbar.getViewGroup());
    }

    public int getHeight() {
        return this.mDecorToolbar.getHeight();
    }

    public int getNavigationItemCount() {
        return 0;
    }

    public int getNavigationMode() {
        return 0;
    }

    public int getSelectedNavigationIndex() {
        return -1;
    }

    public Tab getSelectedTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public CharSequence getSubtitle() {
        return this.mDecorToolbar.getSubtitle();
    }

    public Tab getTabAt(int i) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public int getTabCount() {
        return 0;
    }

    public Context getThemedContext() {
        return this.mDecorToolbar.getContext();
    }

    public CharSequence getTitle() {
        return this.mDecorToolbar.getTitle();
    }

    public Callback getWrappedWindowCallback() {
        return this.mWindowCallback;
    }

    public void hide() {
        this.mDecorToolbar.setVisibility(8);
    }

    public boolean invalidateOptionsMenu() {
        this.mDecorToolbar.getViewGroup().removeCallbacks(this.mMenuInvalidator);
        ViewCompat.postOnAnimation(this.mDecorToolbar.getViewGroup(), this.mMenuInvalidator);
        return true;
    }

    public boolean isShowing() {
        return this.mDecorToolbar.getVisibility() == 0;
    }

    public boolean isTitleTruncated() {
        return super.isTitleTruncated();
    }

    public Tab newTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    void onDestroy() {
        this.mDecorToolbar.getViewGroup().removeCallbacks(this.mMenuInvalidator);
    }

    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        Menu menu = getMenu();
        if (menu == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        menu.setQwertyMode(z);
        return menu.performShortcut(i, keyEvent, 0);
    }

    public boolean onMenuKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            openOptionsMenu();
        }
        return true;
    }

    public boolean openOptionsMenu() {
        return this.mDecorToolbar.showOverflowMenu();
    }

    void populateOptionsMenu() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x002f in list [B:13:0x002c]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r5 = this;
        r0 = r5.getMenu();
        r1 = r0 instanceof android.support.v7.view.menu.MenuBuilder;
        r2 = 0;
        if (r1 == 0) goto L_0x000d;
    L_0x0009:
        r1 = r0;
        r1 = (android.support.v7.view.menu.MenuBuilder) r1;
        goto L_0x000e;
    L_0x000d:
        r1 = r2;
    L_0x000e:
        if (r1 == 0) goto L_0x0013;
    L_0x0010:
        r1.stopDispatchingItemsChanged();
    L_0x0013:
        r0.clear();	 Catch:{ all -> 0x0030 }
        r3 = r5.mWindowCallback;	 Catch:{ all -> 0x0030 }
        r4 = 0;	 Catch:{ all -> 0x0030 }
        r3 = r3.onCreatePanelMenu(r4, r0);	 Catch:{ all -> 0x0030 }
        if (r3 == 0) goto L_0x0027;	 Catch:{ all -> 0x0030 }
    L_0x001f:
        r3 = r5.mWindowCallback;	 Catch:{ all -> 0x0030 }
        r2 = r3.onPreparePanel(r4, r2, r0);	 Catch:{ all -> 0x0030 }
        if (r2 != 0) goto L_0x002a;	 Catch:{ all -> 0x0030 }
    L_0x0027:
        r0.clear();	 Catch:{ all -> 0x0030 }
    L_0x002a:
        if (r1 == 0) goto L_0x002f;
    L_0x002c:
        r1.startDispatchingItemsChanged();
    L_0x002f:
        return;
    L_0x0030:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0036;
    L_0x0033:
        r1.startDispatchingItemsChanged();
    L_0x0036:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.ToolbarActionBar.populateOptionsMenu():void");
    }

    public void removeAllTabs() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void removeOnMenuVisibilityListener(OnMenuVisibilityListener onMenuVisibilityListener) {
        this.mMenuVisibilityListeners.remove(onMenuVisibilityListener);
    }

    public void removeTab(Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void removeTabAt(int i) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public boolean requestFocus() {
        ViewGroup viewGroup = this.mDecorToolbar.getViewGroup();
        if (viewGroup == null || viewGroup.hasFocus()) {
            return false;
        }
        viewGroup.requestFocus();
        return true;
    }

    public void selectTab(Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.mDecorToolbar.setBackgroundDrawable(drawable);
    }

    public void setCustomView(int i) {
        setCustomView(LayoutInflater.from(this.mDecorToolbar.getContext()).inflate(i, this.mDecorToolbar.getViewGroup(), false));
    }

    public void setCustomView(View view) {
        setCustomView(view, new LayoutParams(-2, -2));
    }

    public void setCustomView(View view, LayoutParams layoutParams) {
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        this.mDecorToolbar.setCustomView(view);
    }

    public void setDefaultDisplayHomeAsUpEnabled(boolean z) {
    }

    public void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    @SuppressLint({"WrongConstant"})
    public void setDisplayOptions(int i) {
        setDisplayOptions(i, -1);
    }

    public void setDisplayOptions(int i, int i2) {
        this.mDecorToolbar.setDisplayOptions((i & i2) | ((i2 ^ -1) & this.mDecorToolbar.getDisplayOptions()));
    }

    public void setDisplayShowCustomEnabled(boolean z) {
        setDisplayOptions(z ? 16 : 0, 16);
    }

    public void setDisplayShowHomeEnabled(boolean z) {
        setDisplayOptions(z ? 2 : 0, 2);
    }

    public void setDisplayShowTitleEnabled(boolean z) {
        setDisplayOptions(z ? 8 : 0, 8);
    }

    public void setDisplayUseLogoEnabled(boolean z) {
        setDisplayOptions(z, 1);
    }

    public void setElevation(float f) {
        ViewCompat.setElevation(this.mDecorToolbar.getViewGroup(), f);
    }

    public void setHomeActionContentDescription(int i) {
        this.mDecorToolbar.setNavigationContentDescription(i);
    }

    public void setHomeActionContentDescription(CharSequence charSequence) {
        this.mDecorToolbar.setNavigationContentDescription(charSequence);
    }

    public void setHomeAsUpIndicator(int i) {
        this.mDecorToolbar.setNavigationIcon(i);
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        this.mDecorToolbar.setNavigationIcon(drawable);
    }

    public void setHomeButtonEnabled(boolean z) {
    }

    public void setIcon(int i) {
        this.mDecorToolbar.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        this.mDecorToolbar.setIcon(drawable);
    }

    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, OnNavigationListener onNavigationListener) {
        this.mDecorToolbar.setDropdownParams(spinnerAdapter, new NavItemSelectedListener(onNavigationListener));
    }

    public void setLogo(int i) {
        this.mDecorToolbar.setLogo(i);
    }

    public void setLogo(Drawable drawable) {
        this.mDecorToolbar.setLogo(drawable);
    }

    public void setNavigationMode(int i) {
        if (i != 2) {
            this.mDecorToolbar.setNavigationMode(i);
            return;
        }
        throw new IllegalArgumentException("Tabs not supported in this configuration");
    }

    public void setSelectedNavigationItem(int i) {
        if (this.mDecorToolbar.getNavigationMode() == 1) {
            this.mDecorToolbar.setDropdownSelectedPosition(i);
            return;
        }
        throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
    }

    public void setShowHideAnimationEnabled(boolean z) {
    }

    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    public void setStackedBackgroundDrawable(Drawable drawable) {
    }

    public void setSubtitle(int i) {
        DecorToolbar decorToolbar = this.mDecorToolbar;
        decorToolbar.setSubtitle(i != 0 ? decorToolbar.getContext().getText(i) : null);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mDecorToolbar.setSubtitle(charSequence);
    }

    public void setTitle(int i) {
        DecorToolbar decorToolbar = this.mDecorToolbar;
        decorToolbar.setTitle(i != 0 ? decorToolbar.getContext().getText(i) : null);
    }

    public void setTitle(CharSequence charSequence) {
        this.mDecorToolbar.setTitle(charSequence);
    }

    public void setWindowTitle(CharSequence charSequence) {
        this.mDecorToolbar.setWindowTitle(charSequence);
    }

    public void show() {
        this.mDecorToolbar.setVisibility(0);
    }
}
