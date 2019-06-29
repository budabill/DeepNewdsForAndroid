package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.ActionProvider.SubUiVisibilityListener;
import android.support.v4.view.GravityCompat;
import android.support.v7.appcompat.C0222R;
import android.support.v7.view.ActionBarPolicy;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.ActionMenuItemView.PopupCallback;
import android.support.v7.view.menu.BaseMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.MenuView.ItemView;
import android.support.v7.view.menu.ShowableListMenu;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.ActionMenuView.ActionMenuChildView;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.ImageView;
import java.util.ArrayList;

class ActionMenuPresenter extends BaseMenuPresenter implements SubUiVisibilityListener {
    private static final String TAG = "ActionMenuPresenter";
    private final SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
    ActionButtonSubmenu mActionButtonPopup;
    private int mActionItemWidthLimit;
    private boolean mExpandedActionViewsExclusive;
    private int mMaxItems;
    private boolean mMaxItemsSet;
    private int mMinCellSize;
    int mOpenSubMenuId;
    OverflowMenuButton mOverflowButton;
    OverflowPopup mOverflowPopup;
    private Drawable mPendingOverflowIcon;
    private boolean mPendingOverflowIconSet;
    private ActionMenuPopupCallback mPopupCallback;
    final PopupPresenterCallback mPopupPresenterCallback = new PopupPresenterCallback();
    OpenOverflowRunnable mPostedOpenRunnable;
    private boolean mReserveOverflow;
    private boolean mReserveOverflowSet;
    private View mScrapActionButtonView;
    private boolean mStrictWidthLimit;
    private int mWidthLimit;
    private boolean mWidthLimitSet;

    private class OpenOverflowRunnable implements Runnable {
        private OverflowPopup mPopup;

        public OpenOverflowRunnable(OverflowPopup overflowPopup) {
            this.mPopup = overflowPopup;
        }

        public void run() {
            if (ActionMenuPresenter.this.mMenu != null) {
                ActionMenuPresenter.this.mMenu.changeMenuMode();
            }
            View view = (View) ActionMenuPresenter.this.mMenuView;
            if (!(view == null || view.getWindowToken() == null || !this.mPopup.tryShow())) {
                ActionMenuPresenter.this.mOverflowPopup = this.mPopup;
            }
            ActionMenuPresenter.this.mPostedOpenRunnable = null;
        }
    }

    private static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new C02381();
        public int openSubMenuId;

        /* renamed from: android.support.v7.widget.ActionMenuPresenter$SavedState$1 */
        static class C02381 implements Creator<SavedState> {
            C02381() {
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.openSubMenuId = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.openSubMenuId);
        }
    }

    private class ActionMenuPopupCallback extends PopupCallback {
        ActionMenuPopupCallback() {
        }

        public ShowableListMenu getPopup() {
            MenuPopupHelper menuPopupHelper = ActionMenuPresenter.this.mActionButtonPopup;
            return menuPopupHelper != null ? menuPopupHelper.getPopup() : null;
        }
    }

    private class PopupPresenterCallback implements Callback {
        PopupPresenterCallback() {
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            if (menuBuilder instanceof SubMenuBuilder) {
                menuBuilder.getRootMenu().close(false);
            }
            Callback callback = ActionMenuPresenter.this.getCallback();
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, z);
            }
        }

        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            boolean z = false;
            if (menuBuilder == null) {
                return false;
            }
            ActionMenuPresenter.this.mOpenSubMenuId = ((SubMenuBuilder) menuBuilder).getItem().getItemId();
            Callback callback = ActionMenuPresenter.this.getCallback();
            if (callback != null) {
                z = callback.onOpenSubMenu(menuBuilder);
            }
            return z;
        }
    }

    private class ActionButtonSubmenu extends MenuPopupHelper {
        public ActionButtonSubmenu(Context context, SubMenuBuilder subMenuBuilder, View view) {
            super(context, subMenuBuilder, view, false, C0222R.attr.actionOverflowMenuStyle);
            if (!((MenuItemImpl) subMenuBuilder.getItem()).isActionButton()) {
                View view2 = ActionMenuPresenter.this.mOverflowButton;
                if (view2 == null) {
                    view2 = (View) ActionMenuPresenter.this.mMenuView;
                }
                setAnchorView(view2);
            }
            setPresenterCallback(ActionMenuPresenter.this.mPopupPresenterCallback);
        }

        protected void onDismiss() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.mActionButtonPopup = null;
            actionMenuPresenter.mOpenSubMenuId = 0;
            super.onDismiss();
        }
    }

    private class OverflowMenuButton extends AppCompatImageView implements ActionMenuChildView {
        private final float[] mTempPts = new float[2];

        public OverflowMenuButton(Context context) {
            super(context, null, C0222R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            TooltipCompat.setTooltipText(this, getContentDescription());
            setOnTouchListener(new ForwardingListener(this, ActionMenuPresenter.this) {
                public ShowableListMenu getPopup() {
                    MenuPopupHelper menuPopupHelper = ActionMenuPresenter.this.mOverflowPopup;
                    return menuPopupHelper == null ? null : menuPopupHelper.getPopup();
                }

                public boolean onForwardingStarted() {
                    ActionMenuPresenter.this.showOverflowMenu();
                    return true;
                }

                public boolean onForwardingStopped() {
                    ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                    if (actionMenuPresenter.mPostedOpenRunnable != null) {
                        return false;
                    }
                    actionMenuPresenter.hideOverflowMenu();
                    return true;
                }
            });
        }

        public boolean needsDividerAfter() {
            return false;
        }

        public boolean needsDividerBefore() {
            return false;
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.showOverflowMenu();
            return true;
        }

        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                i2 = getWidth();
                i4 = getHeight();
                int max = Math.max(i2, i4) / 2;
                i2 = (i2 + (getPaddingLeft() - getPaddingRight())) / 2;
                i4 = (i4 + (getPaddingTop() - getPaddingBottom())) / 2;
                DrawableCompat.setHotspotBounds(background, i2 - max, i4 - max, i2 + max, i4 + max);
            }
            return frame;
        }
    }

    private class OverflowPopup extends MenuPopupHelper {
        public OverflowPopup(Context context, MenuBuilder menuBuilder, View view, boolean z) {
            super(context, menuBuilder, view, z, C0222R.attr.actionOverflowMenuStyle);
            setGravity(GravityCompat.END);
            setPresenterCallback(ActionMenuPresenter.this.mPopupPresenterCallback);
        }

        protected void onDismiss() {
            if (ActionMenuPresenter.this.mMenu != null) {
                ActionMenuPresenter.this.mMenu.close();
            }
            ActionMenuPresenter.this.mOverflowPopup = null;
            super.onDismiss();
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, C0222R.layout.abc_action_menu_layout, C0222R.layout.abc_action_menu_item_layout);
    }

    private View findViewForItem(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof ItemView) && ((ItemView) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public void bindItemView(MenuItemImpl menuItemImpl, ItemView itemView) {
        itemView.initialize(menuItemImpl, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) itemView;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.mMenuView);
        if (this.mPopupCallback == null) {
            this.mPopupCallback = new ActionMenuPopupCallback();
        }
        actionMenuItemView.setPopupCallback(this.mPopupCallback);
    }

    public boolean dismissPopupMenus() {
        return hideOverflowMenu() | hideSubMenus();
    }

    public boolean filterLeftoverView(ViewGroup viewGroup, int i) {
        return viewGroup.getChildAt(i) == this.mOverflowButton ? false : super.filterLeftoverView(viewGroup, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean flagActionItems() {
        /*
        r19 = this;
        r0 = r19;
        r1 = r0.mMenu;
        r2 = 0;
        if (r1 == 0) goto L_0x0010;
    L_0x0007:
        r1 = r1.getVisibleItems();
        r3 = r1.size();
        goto L_0x0012;
    L_0x0010:
        r1 = 0;
        r3 = 0;
    L_0x0012:
        r4 = r0.mMaxItems;
        r5 = r0.mActionItemWidthLimit;
        r6 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r2);
        r7 = r0.mMenuView;
        r7 = (android.view.ViewGroup) r7;
        r11 = r4;
        r4 = 0;
        r8 = 0;
        r9 = 0;
        r10 = 0;
    L_0x0023:
        if (r4 >= r3) goto L_0x004c;
    L_0x0025:
        r13 = r1.get(r4);
        r13 = (android.support.v7.view.menu.MenuItemImpl) r13;
        r14 = r13.requiresActionButton();
        if (r14 == 0) goto L_0x0034;
    L_0x0031:
        r9 = r9 + 1;
        goto L_0x003e;
    L_0x0034:
        r14 = r13.requestsActionButton();
        if (r14 == 0) goto L_0x003d;
    L_0x003a:
        r10 = r10 + 1;
        goto L_0x003e;
    L_0x003d:
        r8 = 1;
    L_0x003e:
        r12 = r0.mExpandedActionViewsExclusive;
        if (r12 == 0) goto L_0x0049;
    L_0x0042:
        r12 = r13.isActionViewExpanded();
        if (r12 == 0) goto L_0x0049;
    L_0x0048:
        r11 = 0;
    L_0x0049:
        r4 = r4 + 1;
        goto L_0x0023;
    L_0x004c:
        r4 = r0.mReserveOverflow;
        if (r4 == 0) goto L_0x0057;
    L_0x0050:
        if (r8 != 0) goto L_0x0055;
    L_0x0052:
        r10 = r10 + r9;
        if (r10 <= r11) goto L_0x0057;
    L_0x0055:
        r11 = r11 + -1;
    L_0x0057:
        r11 = r11 - r9;
        r4 = r0.mActionButtonGroups;
        r4.clear();
        r8 = r0.mStrictWidthLimit;
        if (r8 == 0) goto L_0x006a;
    L_0x0061:
        r8 = r0.mMinCellSize;
        r9 = r5 / r8;
        r10 = r5 % r8;
        r10 = r10 / r9;
        r8 = r8 + r10;
        goto L_0x006c;
    L_0x006a:
        r8 = 0;
        r9 = 0;
    L_0x006c:
        r10 = r5;
        r5 = 0;
        r13 = 0;
    L_0x006f:
        if (r5 >= r3) goto L_0x015a;
    L_0x0071:
        r14 = r1.get(r5);
        r14 = (android.support.v7.view.menu.MenuItemImpl) r14;
        r15 = r14.requiresActionButton();
        if (r15 == 0) goto L_0x00b4;
    L_0x007d:
        r15 = r0.mScrapActionButtonView;
        r15 = r0.getItemView(r14, r15, r7);
        r12 = r0.mScrapActionButtonView;
        if (r12 != 0) goto L_0x0089;
    L_0x0087:
        r0.mScrapActionButtonView = r15;
    L_0x0089:
        r12 = r0.mStrictWidthLimit;
        if (r12 == 0) goto L_0x0093;
    L_0x008d:
        r12 = android.support.v7.widget.ActionMenuView.measureChildForCells(r15, r8, r9, r6, r2);
        r9 = r9 - r12;
        goto L_0x0096;
    L_0x0093:
        r15.measure(r6, r6);
    L_0x0096:
        r12 = r15.getMeasuredWidth();
        r10 = r10 - r12;
        if (r13 != 0) goto L_0x009e;
    L_0x009d:
        goto L_0x009f;
    L_0x009e:
        r12 = r13;
    L_0x009f:
        r13 = r14.getGroupId();
        if (r13 == 0) goto L_0x00aa;
    L_0x00a5:
        r15 = 1;
        r4.put(r13, r15);
        goto L_0x00ab;
    L_0x00aa:
        r15 = 1;
    L_0x00ab:
        r14.setIsActionButton(r15);
        r17 = r3;
        r13 = r12;
    L_0x00b1:
        r0 = 0;
        goto L_0x0151;
    L_0x00b4:
        r12 = r14.requestsActionButton();
        if (r12 == 0) goto L_0x014b;
    L_0x00ba:
        r12 = r14.getGroupId();
        r15 = r4.get(r12);
        if (r11 > 0) goto L_0x00c6;
    L_0x00c4:
        if (r15 == 0) goto L_0x00d0;
    L_0x00c6:
        if (r10 <= 0) goto L_0x00d0;
    L_0x00c8:
        r2 = r0.mStrictWidthLimit;
        if (r2 == 0) goto L_0x00ce;
    L_0x00cc:
        if (r9 <= 0) goto L_0x00d0;
    L_0x00ce:
        r2 = 1;
        goto L_0x00d1;
    L_0x00d0:
        r2 = 0;
    L_0x00d1:
        if (r2 == 0) goto L_0x010f;
    L_0x00d3:
        r16 = r2;
        r2 = r0.mScrapActionButtonView;
        r2 = r0.getItemView(r14, r2, r7);
        r17 = r3;
        r3 = r0.mScrapActionButtonView;
        if (r3 != 0) goto L_0x00e3;
    L_0x00e1:
        r0.mScrapActionButtonView = r2;
    L_0x00e3:
        r3 = r0.mStrictWidthLimit;
        if (r3 == 0) goto L_0x00f3;
    L_0x00e7:
        r3 = 0;
        r18 = android.support.v7.widget.ActionMenuView.measureChildForCells(r2, r8, r9, r6, r3);
        r9 = r9 - r18;
        if (r18 != 0) goto L_0x00f6;
    L_0x00f0:
        r16 = 0;
        goto L_0x00f6;
    L_0x00f3:
        r2.measure(r6, r6);
    L_0x00f6:
        r2 = r2.getMeasuredWidth();
        r10 = r10 - r2;
        if (r13 != 0) goto L_0x00fe;
    L_0x00fd:
        r13 = r2;
    L_0x00fe:
        r2 = r0.mStrictWidthLimit;
        if (r2 == 0) goto L_0x0105;
    L_0x0102:
        if (r10 < 0) goto L_0x010b;
    L_0x0104:
        goto L_0x0109;
    L_0x0105:
        r2 = r10 + r13;
        if (r2 <= 0) goto L_0x010b;
    L_0x0109:
        r2 = 1;
        goto L_0x010c;
    L_0x010b:
        r2 = 0;
    L_0x010c:
        r2 = r16 & r2;
        goto L_0x0113;
    L_0x010f:
        r16 = r2;
        r17 = r3;
    L_0x0113:
        if (r2 == 0) goto L_0x011c;
    L_0x0115:
        if (r12 == 0) goto L_0x011c;
    L_0x0117:
        r3 = 1;
        r4.put(r12, r3);
        goto L_0x0142;
    L_0x011c:
        if (r15 == 0) goto L_0x0142;
    L_0x011e:
        r3 = 0;
        r4.put(r12, r3);
        r3 = 0;
    L_0x0123:
        if (r3 >= r5) goto L_0x0142;
    L_0x0125:
        r15 = r1.get(r3);
        r15 = (android.support.v7.view.menu.MenuItemImpl) r15;
        r0 = r15.getGroupId();
        if (r0 != r12) goto L_0x013d;
    L_0x0131:
        r0 = r15.isActionButton();
        if (r0 == 0) goto L_0x0139;
    L_0x0137:
        r11 = r11 + 1;
    L_0x0139:
        r0 = 0;
        r15.setIsActionButton(r0);
    L_0x013d:
        r3 = r3 + 1;
        r0 = r19;
        goto L_0x0123;
    L_0x0142:
        if (r2 == 0) goto L_0x0146;
    L_0x0144:
        r11 = r11 + -1;
    L_0x0146:
        r14.setIsActionButton(r2);
        goto L_0x00b1;
    L_0x014b:
        r17 = r3;
        r0 = 0;
        r14.setIsActionButton(r0);
    L_0x0151:
        r5 = r5 + 1;
        r2 = 0;
        r0 = r19;
        r3 = r17;
        goto L_0x006f;
    L_0x015a:
        r2 = 1;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ActionMenuPresenter.flagActionItems():boolean");
    }

    public View getItemView(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        View actionView = menuItemImpl.getActionView();
        if (actionView == null || menuItemImpl.hasCollapsibleActionView()) {
            actionView = super.getItemView(menuItemImpl, view, viewGroup);
        }
        actionView.setVisibility(menuItemImpl.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        MenuView menuView = this.mMenuView;
        MenuView menuView2 = super.getMenuView(viewGroup);
        if (menuView != menuView2) {
            ((ActionMenuView) menuView2).setPresenter(this);
        }
        return menuView2;
    }

    public Drawable getOverflowIcon() {
        ImageView imageView = this.mOverflowButton;
        return imageView != null ? imageView.getDrawable() : this.mPendingOverflowIconSet ? this.mPendingOverflowIcon : null;
    }

    public boolean hideOverflowMenu() {
        Runnable runnable = this.mPostedOpenRunnable;
        if (runnable != null) {
            MenuView menuView = this.mMenuView;
            if (menuView != null) {
                ((View) menuView).removeCallbacks(runnable);
                this.mPostedOpenRunnable = null;
                return true;
            }
        }
        MenuPopupHelper menuPopupHelper = this.mOverflowPopup;
        if (menuPopupHelper == null) {
            return false;
        }
        menuPopupHelper.dismiss();
        return true;
    }

    public boolean hideSubMenus() {
        MenuPopupHelper menuPopupHelper = this.mActionButtonPopup;
        if (menuPopupHelper == null) {
            return false;
        }
        menuPopupHelper.dismiss();
        return true;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        super.initForMenu(context, menuBuilder);
        Resources resources = context.getResources();
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(context);
        if (!this.mReserveOverflowSet) {
            this.mReserveOverflow = actionBarPolicy.showsOverflowMenuButton();
        }
        if (!this.mWidthLimitSet) {
            this.mWidthLimit = actionBarPolicy.getEmbeddedMenuWidthLimit();
        }
        if (!this.mMaxItemsSet) {
            this.mMaxItems = actionBarPolicy.getMaxActionButtons();
        }
        int i = this.mWidthLimit;
        if (this.mReserveOverflow) {
            if (this.mOverflowButton == null) {
                this.mOverflowButton = new OverflowMenuButton(this.mSystemContext);
                if (this.mPendingOverflowIconSet) {
                    this.mOverflowButton.setImageDrawable(this.mPendingOverflowIcon);
                    this.mPendingOverflowIcon = null;
                    this.mPendingOverflowIconSet = false;
                }
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.mOverflowButton.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.mOverflowButton.getMeasuredWidth();
        } else {
            this.mOverflowButton = null;
        }
        this.mActionItemWidthLimit = i;
        this.mMinCellSize = (int) (resources.getDisplayMetrics().density * 56.0f);
        this.mScrapActionButtonView = null;
    }

    public boolean isOverflowMenuShowPending() {
        if (this.mPostedOpenRunnable == null) {
            if (!isOverflowMenuShowing()) {
                return false;
            }
        }
        return true;
    }

    public boolean isOverflowMenuShowing() {
        MenuPopupHelper menuPopupHelper = this.mOverflowPopup;
        return menuPopupHelper != null && menuPopupHelper.isShowing();
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        dismissPopupMenus();
        super.onCloseMenu(menuBuilder, z);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.mMaxItemsSet) {
            this.mMaxItems = ActionBarPolicy.get(this.mContext).getMaxActionButtons();
        }
        MenuBuilder menuBuilder = this.mMenu;
        if (menuBuilder != null) {
            menuBuilder.onItemsChanged(true);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            int i = ((SavedState) parcelable).openSubMenuId;
            if (i > 0) {
                MenuItem findItem = this.mMenu.findItem(i);
                if (findItem != null) {
                    onSubMenuSelected((SubMenuBuilder) findItem.getSubMenu());
                }
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState();
        savedState.openSubMenuId = this.mOpenSubMenuId;
        return savedState;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        boolean z = false;
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        while (subMenuBuilder2.getParentMenu() != this.mMenu) {
            subMenuBuilder2 = (SubMenuBuilder) subMenuBuilder2.getParentMenu();
        }
        View findViewForItem = findViewForItem(subMenuBuilder2.getItem());
        if (findViewForItem == null) {
            return false;
        }
        this.mOpenSubMenuId = subMenuBuilder.getItem().getItemId();
        int size = subMenuBuilder.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = subMenuBuilder.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
        }
        this.mActionButtonPopup = new ActionButtonSubmenu(this.mContext, subMenuBuilder, findViewForItem);
        this.mActionButtonPopup.setForceShowIcon(z);
        this.mActionButtonPopup.show();
        super.onSubMenuSelected(subMenuBuilder);
        return true;
    }

    public void onSubUiVisibilityChanged(boolean z) {
        if (z) {
            super.onSubMenuSelected(null);
            return;
        }
        MenuBuilder menuBuilder = this.mMenu;
        if (menuBuilder != null) {
            menuBuilder.close(false);
        }
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.mExpandedActionViewsExclusive = z;
    }

    public void setItemLimit(int i) {
        this.mMaxItems = i;
        this.mMaxItemsSet = true;
    }

    public void setMenuView(ActionMenuView actionMenuView) {
        this.mMenuView = actionMenuView;
        actionMenuView.initialize(this.mMenu);
    }

    public void setOverflowIcon(Drawable drawable) {
        AppCompatImageView appCompatImageView = this.mOverflowButton;
        if (appCompatImageView != null) {
            appCompatImageView.setImageDrawable(drawable);
            return;
        }
        this.mPendingOverflowIconSet = true;
        this.mPendingOverflowIcon = drawable;
    }

    public void setReserveOverflow(boolean z) {
        this.mReserveOverflow = z;
        this.mReserveOverflowSet = true;
    }

    public void setWidthLimit(int i, boolean z) {
        this.mWidthLimit = i;
        this.mStrictWidthLimit = z;
        this.mWidthLimitSet = true;
    }

    public boolean shouldIncludeItem(int i, MenuItemImpl menuItemImpl) {
        return menuItemImpl.isActionButton();
    }

    public boolean showOverflowMenu() {
        if (this.mReserveOverflow && !isOverflowMenuShowing()) {
            MenuBuilder menuBuilder = this.mMenu;
            if (!(menuBuilder == null || this.mMenuView == null || this.mPostedOpenRunnable != null || menuBuilder.getNonActionItems().isEmpty())) {
                this.mPostedOpenRunnable = new OpenOverflowRunnable(new OverflowPopup(this.mContext, this.mMenu, this.mOverflowButton, true));
                ((View) this.mMenuView).post(this.mPostedOpenRunnable);
                super.onSubMenuSelected(null);
                return true;
            }
        }
        return false;
    }

    public void updateMenuView(boolean z) {
        ArrayList actionItems;
        int size;
        super.updateMenuView(z);
        ((View) this.mMenuView).requestLayout();
        MenuBuilder menuBuilder = this.mMenu;
        int i = 0;
        if (menuBuilder != null) {
            actionItems = menuBuilder.getActionItems();
            size = actionItems.size();
            for (int i2 = 0; i2 < size; i2++) {
                ActionProvider supportActionProvider = ((MenuItemImpl) actionItems.get(i2)).getSupportActionProvider();
                if (supportActionProvider != null) {
                    supportActionProvider.setSubUiVisibilityListener(this);
                }
            }
        }
        menuBuilder = this.mMenu;
        actionItems = menuBuilder != null ? menuBuilder.getNonActionItems() : null;
        if (this.mReserveOverflow && actionItems != null) {
            size = actionItems.size();
            if (size == 1) {
                i = ((MenuItemImpl) actionItems.get(0)).isActionViewExpanded() ^ 1;
            } else if (size > 0) {
                i = 1;
            }
        }
        if (i != 0) {
            if (this.mOverflowButton == null) {
                this.mOverflowButton = new OverflowMenuButton(this.mSystemContext);
            }
            ViewGroup viewGroup = (ViewGroup) this.mOverflowButton.getParent();
            if (viewGroup != this.mMenuView) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.mOverflowButton);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.mMenuView;
                actionMenuView.addView(this.mOverflowButton, actionMenuView.generateOverflowButtonLayoutParams());
            }
        } else {
            ImageView imageView = this.mOverflowButton;
            if (imageView != null) {
                ViewParent parent = imageView.getParent();
                ViewParent viewParent = this.mMenuView;
                if (parent == viewParent) {
                    ((ViewGroup) viewParent).removeView(this.mOverflowButton);
                }
            }
        }
        ((ActionMenuView) this.mMenuView).setOverflowReserved(this.mReserveOverflow);
    }
}
