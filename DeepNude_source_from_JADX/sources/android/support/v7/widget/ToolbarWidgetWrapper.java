package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.appcompat.C0222R;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.menu.ActionMenuItem;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window.Callback;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class ToolbarWidgetWrapper implements DecorToolbar {
    private static final int AFFECTS_LOGO_MASK = 3;
    private static final long DEFAULT_FADE_DURATION_MS = 200;
    private static final String TAG = "ToolbarWidgetWrapper";
    private ActionMenuPresenter mActionMenuPresenter;
    private View mCustomView;
    private int mDefaultNavigationContentDescription;
    private Drawable mDefaultNavigationIcon;
    private int mDisplayOpts;
    private CharSequence mHomeDescription;
    private Drawable mIcon;
    private Drawable mLogo;
    boolean mMenuPrepared;
    private Drawable mNavIcon;
    private int mNavigationMode;
    private Spinner mSpinner;
    private CharSequence mSubtitle;
    private View mTabView;
    CharSequence mTitle;
    private boolean mTitleSet;
    Toolbar mToolbar;
    Callback mWindowCallback;

    /* renamed from: android.support.v7.widget.ToolbarWidgetWrapper$1 */
    class C02651 implements OnClickListener {
        final ActionMenuItem mNavItem = new ActionMenuItem(ToolbarWidgetWrapper.this.mToolbar.getContext(), 0, 16908332, 0, 0, ToolbarWidgetWrapper.this.mTitle);

        C02651() {
        }

        public void onClick(View view) {
            ToolbarWidgetWrapper toolbarWidgetWrapper = ToolbarWidgetWrapper.this;
            Callback callback = toolbarWidgetWrapper.mWindowCallback;
            if (callback != null && toolbarWidgetWrapper.mMenuPrepared) {
                callback.onMenuItemSelected(0, this.mNavItem);
            }
        }
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z) {
        this(toolbar, z, C0222R.string.abc_action_bar_up_description, C0222R.drawable.abc_ic_ab_back_material);
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z, int i, int i2) {
        this.mNavigationMode = 0;
        this.mDefaultNavigationContentDescription = 0;
        this.mToolbar = toolbar;
        this.mTitle = toolbar.getTitle();
        this.mSubtitle = toolbar.getSubtitle();
        this.mTitleSet = this.mTitle != null;
        this.mNavIcon = toolbar.getNavigationIcon();
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(toolbar.getContext(), null, C0222R.styleable.ActionBar, C0222R.attr.actionBarStyle, 0);
        this.mDefaultNavigationIcon = obtainStyledAttributes.getDrawable(C0222R.styleable.ActionBar_homeAsUpIndicator);
        if (z) {
            ViewGroup viewGroup;
            CharSequence text = obtainStyledAttributes.getText(C0222R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(text)) {
                setTitle(text);
            }
            text = obtainStyledAttributes.getText(C0222R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(text)) {
                setSubtitle(text);
            }
            Drawable drawable = obtainStyledAttributes.getDrawable(C0222R.styleable.ActionBar_logo);
            if (drawable != null) {
                setLogo(drawable);
            }
            drawable = obtainStyledAttributes.getDrawable(C0222R.styleable.ActionBar_icon);
            if (drawable != null) {
                setIcon(drawable);
            }
            if (this.mNavIcon == null) {
                drawable = this.mDefaultNavigationIcon;
                if (drawable != null) {
                    setNavigationIcon(drawable);
                }
            }
            setDisplayOptions(obtainStyledAttributes.getInt(C0222R.styleable.ActionBar_displayOptions, 0));
            int resourceId = obtainStyledAttributes.getResourceId(C0222R.styleable.ActionBar_customNavigationLayout, 0);
            if (resourceId != 0) {
                setCustomView(LayoutInflater.from(this.mToolbar.getContext()).inflate(resourceId, this.mToolbar, false));
                setDisplayOptions(this.mDisplayOpts | 16);
            }
            resourceId = obtainStyledAttributes.getLayoutDimension(C0222R.styleable.ActionBar_height, 0);
            if (resourceId > 0) {
                LayoutParams layoutParams = this.mToolbar.getLayoutParams();
                layoutParams.height = resourceId;
                this.mToolbar.setLayoutParams(layoutParams);
            }
            resourceId = obtainStyledAttributes.getDimensionPixelOffset(C0222R.styleable.ActionBar_contentInsetStart, -1);
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(C0222R.styleable.ActionBar_contentInsetEnd, -1);
            if (resourceId >= 0 || dimensionPixelOffset >= 0) {
                this.mToolbar.setContentInsetsRelative(Math.max(resourceId, 0), Math.max(dimensionPixelOffset, 0));
            }
            resourceId = obtainStyledAttributes.getResourceId(C0222R.styleable.ActionBar_titleTextStyle, 0);
            if (resourceId != 0) {
                viewGroup = this.mToolbar;
                viewGroup.setTitleTextAppearance(viewGroup.getContext(), resourceId);
            }
            resourceId = obtainStyledAttributes.getResourceId(C0222R.styleable.ActionBar_subtitleTextStyle, 0);
            if (resourceId != 0) {
                viewGroup = this.mToolbar;
                viewGroup.setSubtitleTextAppearance(viewGroup.getContext(), resourceId);
            }
            resourceId = obtainStyledAttributes.getResourceId(C0222R.styleable.ActionBar_popupTheme, 0);
            if (resourceId != 0) {
                this.mToolbar.setPopupTheme(resourceId);
            }
        } else {
            this.mDisplayOpts = detectDisplayOptions();
        }
        obtainStyledAttributes.recycle();
        setDefaultNavigationContentDescription(i);
        this.mHomeDescription = this.mToolbar.getNavigationContentDescription();
        this.mToolbar.setNavigationOnClickListener(new C02651());
    }

    private int detectDisplayOptions() {
        if (this.mToolbar.getNavigationIcon() == null) {
            return 11;
        }
        this.mDefaultNavigationIcon = this.mToolbar.getNavigationIcon();
        return 15;
    }

    private void ensureSpinner() {
        if (this.mSpinner == null) {
            this.mSpinner = new AppCompatSpinner(getContext(), null, C0222R.attr.actionDropDownStyle);
            this.mSpinner.setLayoutParams(new Toolbar.LayoutParams(-2, -2, 8388627));
        }
    }

    private void setTitleInt(CharSequence charSequence) {
        this.mTitle = charSequence;
        if ((this.mDisplayOpts & 8) != 0) {
            this.mToolbar.setTitle(charSequence);
        }
    }

    private void updateHomeAccessibility() {
        if ((this.mDisplayOpts & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.mHomeDescription)) {
            this.mToolbar.setNavigationContentDescription(this.mDefaultNavigationContentDescription);
        } else {
            this.mToolbar.setNavigationContentDescription(this.mHomeDescription);
        }
    }

    private void updateNavigationIcon() {
        Toolbar toolbar;
        Drawable drawable;
        if ((this.mDisplayOpts & 4) != 0) {
            toolbar = this.mToolbar;
            drawable = this.mNavIcon;
            if (drawable == null) {
                drawable = this.mDefaultNavigationIcon;
            }
        } else {
            toolbar = this.mToolbar;
            drawable = null;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void updateToolbarLogo() {
        Drawable drawable;
        int i = this.mDisplayOpts;
        if ((i & 2) != 0) {
            if ((i & 1) != 0) {
                drawable = this.mLogo;
                if (drawable != null) {
                }
            }
            drawable = this.mIcon;
        } else {
            drawable = null;
        }
        this.mToolbar.setLogo(drawable);
    }

    public void animateToVisibility(int i) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = setupAnimatorToVisibility(i, DEFAULT_FADE_DURATION_MS);
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.start();
        }
    }

    public boolean canShowOverflowMenu() {
        return this.mToolbar.canShowOverflowMenu();
    }

    public void collapseActionView() {
        this.mToolbar.collapseActionView();
    }

    public void dismissPopupMenus() {
        this.mToolbar.dismissPopupMenus();
    }

    public Context getContext() {
        return this.mToolbar.getContext();
    }

    public View getCustomView() {
        return this.mCustomView;
    }

    public int getDisplayOptions() {
        return this.mDisplayOpts;
    }

    public int getDropdownItemCount() {
        Spinner spinner = this.mSpinner;
        return spinner != null ? spinner.getCount() : 0;
    }

    public int getDropdownSelectedPosition() {
        Spinner spinner = this.mSpinner;
        return spinner != null ? spinner.getSelectedItemPosition() : 0;
    }

    public int getHeight() {
        return this.mToolbar.getHeight();
    }

    public Menu getMenu() {
        return this.mToolbar.getMenu();
    }

    public int getNavigationMode() {
        return this.mNavigationMode;
    }

    public CharSequence getSubtitle() {
        return this.mToolbar.getSubtitle();
    }

    public CharSequence getTitle() {
        return this.mToolbar.getTitle();
    }

    public ViewGroup getViewGroup() {
        return this.mToolbar;
    }

    public int getVisibility() {
        return this.mToolbar.getVisibility();
    }

    public boolean hasEmbeddedTabs() {
        return this.mTabView != null;
    }

    public boolean hasExpandedActionView() {
        return this.mToolbar.hasExpandedActionView();
    }

    public boolean hasIcon() {
        return this.mIcon != null;
    }

    public boolean hasLogo() {
        return this.mLogo != null;
    }

    public boolean hideOverflowMenu() {
        return this.mToolbar.hideOverflowMenu();
    }

    public void initIndeterminateProgress() {
        Log.i(TAG, "Progress display unsupported");
    }

    public void initProgress() {
        Log.i(TAG, "Progress display unsupported");
    }

    public boolean isOverflowMenuShowPending() {
        return this.mToolbar.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        return this.mToolbar.isOverflowMenuShowing();
    }

    public boolean isTitleTruncated() {
        return this.mToolbar.isTitleTruncated();
    }

    public void restoreHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.mToolbar.restoreHierarchyState(sparseArray);
    }

    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.mToolbar.saveHierarchyState(sparseArray);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        ViewCompat.setBackground(this.mToolbar, drawable);
    }

    public void setCollapsible(boolean z) {
        this.mToolbar.setCollapsible(z);
    }

    public void setCustomView(View view) {
        View view2 = this.mCustomView;
        if (!(view2 == null || (this.mDisplayOpts & 16) == 0)) {
            this.mToolbar.removeView(view2);
        }
        this.mCustomView = view;
        if (view != null && (this.mDisplayOpts & 16) != 0) {
            this.mToolbar.addView(this.mCustomView);
        }
    }

    public void setDefaultNavigationContentDescription(int i) {
        if (i != this.mDefaultNavigationContentDescription) {
            this.mDefaultNavigationContentDescription = i;
            if (TextUtils.isEmpty(this.mToolbar.getNavigationContentDescription())) {
                setNavigationContentDescription(this.mDefaultNavigationContentDescription);
            }
        }
    }

    public void setDefaultNavigationIcon(Drawable drawable) {
        if (this.mDefaultNavigationIcon != drawable) {
            this.mDefaultNavigationIcon = drawable;
            updateNavigationIcon();
        }
    }

    public void setDisplayOptions(int i) {
        int i2 = this.mDisplayOpts ^ i;
        this.mDisplayOpts = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    updateHomeAccessibility();
                }
                updateNavigationIcon();
            }
            if ((i2 & 3) != 0) {
                updateToolbarLogo();
            }
            if ((i2 & 8) != 0) {
                Toolbar toolbar;
                CharSequence charSequence;
                if ((i & 8) != 0) {
                    this.mToolbar.setTitle(this.mTitle);
                    toolbar = this.mToolbar;
                    charSequence = this.mSubtitle;
                } else {
                    charSequence = null;
                    this.mToolbar.setTitle(null);
                    toolbar = this.mToolbar;
                }
                toolbar.setSubtitle(charSequence);
            }
            if ((i2 & 16) != 0) {
                View view = this.mCustomView;
                if (view == null) {
                    return;
                }
                if ((i & 16) != 0) {
                    this.mToolbar.addView(view);
                } else {
                    this.mToolbar.removeView(view);
                }
            }
        }
    }

    public void setDropdownParams(SpinnerAdapter spinnerAdapter, OnItemSelectedListener onItemSelectedListener) {
        ensureSpinner();
        this.mSpinner.setAdapter(spinnerAdapter);
        this.mSpinner.setOnItemSelectedListener(onItemSelectedListener);
    }

    public void setDropdownSelectedPosition(int i) {
        Spinner spinner = this.mSpinner;
        if (spinner != null) {
            spinner.setSelection(i);
            return;
        }
        throw new IllegalStateException("Can't set dropdown selected position without an adapter");
    }

    public void setEmbeddedTabView(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.mTabView;
        if (view != null) {
            ViewParent parent = view.getParent();
            ViewParent viewParent = this.mToolbar;
            if (parent == viewParent) {
                viewParent.removeView(this.mTabView);
            }
        }
        this.mTabView = scrollingTabContainerView;
        if (scrollingTabContainerView != null && this.mNavigationMode == 2) {
            this.mToolbar.addView(this.mTabView, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.mTabView.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.gravity = 8388691;
            scrollingTabContainerView.setAllowCollapse(true);
        }
    }

    public void setHomeButtonEnabled(boolean z) {
    }

    public void setIcon(int i) {
        setIcon(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
        updateToolbarLogo();
    }

    public void setLogo(int i) {
        setLogo(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setLogo(Drawable drawable) {
        this.mLogo = drawable;
        updateToolbarLogo();
    }

    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        if (this.mActionMenuPresenter == null) {
            this.mActionMenuPresenter = new ActionMenuPresenter(this.mToolbar.getContext());
            this.mActionMenuPresenter.setId(C0222R.id.action_menu_presenter);
        }
        this.mActionMenuPresenter.setCallback(callback);
        this.mToolbar.setMenu((MenuBuilder) menu, this.mActionMenuPresenter);
    }

    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.mToolbar.setMenuCallbacks(callback, callback2);
    }

    public void setMenuPrepared() {
        this.mMenuPrepared = true;
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i == 0 ? null : getContext().getString(i));
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        this.mHomeDescription = charSequence;
        updateHomeAccessibility();
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setNavigationIcon(Drawable drawable) {
        this.mNavIcon = drawable;
        updateNavigationIcon();
    }

    public void setNavigationMode(int i) {
        int i2 = this.mNavigationMode;
        if (i != i2) {
            View view;
            ViewGroup viewGroup;
            View view2;
            Toolbar.LayoutParams layoutParams;
            StringBuilder stringBuilder;
            ViewParent parent;
            if (i2 != 1) {
                if (i2 == 2) {
                    view = this.mTabView;
                    if (view != null) {
                        parent = view.getParent();
                        viewGroup = this.mToolbar;
                        if (parent == viewGroup) {
                            view = this.mTabView;
                        }
                    }
                }
                this.mNavigationMode = i;
                if (i == 0) {
                    return;
                }
                if (i != 1) {
                    ensureSpinner();
                    this.mToolbar.addView(this.mSpinner, 0);
                } else if (i == 2) {
                    view2 = this.mTabView;
                    if (view2 == null) {
                        this.mToolbar.addView(view2, 0);
                        layoutParams = (Toolbar.LayoutParams) this.mTabView.getLayoutParams();
                        layoutParams.width = -2;
                        layoutParams.height = -2;
                        layoutParams.gravity = 8388691;
                    }
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid navigation mode ");
                    stringBuilder.append(i);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            Spinner spinner = this.mSpinner;
            if (spinner != null) {
                parent = spinner.getParent();
                viewGroup = this.mToolbar;
                if (parent == viewGroup) {
                    view = this.mSpinner;
                }
            }
            this.mNavigationMode = i;
            if (i == 0) {
                if (i != 1) {
                    ensureSpinner();
                    this.mToolbar.addView(this.mSpinner, 0);
                } else if (i == 2) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid navigation mode ");
                    stringBuilder.append(i);
                    throw new IllegalArgumentException(stringBuilder.toString());
                } else {
                    view2 = this.mTabView;
                    if (view2 == null) {
                        this.mToolbar.addView(view2, 0);
                        layoutParams = (Toolbar.LayoutParams) this.mTabView.getLayoutParams();
                        layoutParams.width = -2;
                        layoutParams.height = -2;
                        layoutParams.gravity = 8388691;
                    }
                }
            }
            return;
            viewGroup.removeView(view);
            this.mNavigationMode = i;
            if (i == 0) {
                return;
            }
            if (i != 1) {
                ensureSpinner();
                this.mToolbar.addView(this.mSpinner, 0);
            } else if (i == 2) {
                view2 = this.mTabView;
                if (view2 == null) {
                    this.mToolbar.addView(view2, 0);
                    layoutParams = (Toolbar.LayoutParams) this.mTabView.getLayoutParams();
                    layoutParams.width = -2;
                    layoutParams.height = -2;
                    layoutParams.gravity = 8388691;
                }
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid navigation mode ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mSubtitle = charSequence;
        if ((this.mDisplayOpts & 8) != 0) {
            this.mToolbar.setSubtitle(charSequence);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitleSet = true;
        setTitleInt(charSequence);
    }

    public void setVisibility(int i) {
        this.mToolbar.setVisibility(i);
    }

    public void setWindowCallback(Callback callback) {
        this.mWindowCallback = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        if (!this.mTitleSet) {
            setTitleInt(charSequence);
        }
    }

    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(final int i, long j) {
        return ViewCompat.animate(this.mToolbar).alpha(i == 0 ? 1.0f : 0.0f).setDuration(j).setListener(new ViewPropertyAnimatorListenerAdapter() {
            private boolean mCanceled = false;

            public void onAnimationCancel(View view) {
                this.mCanceled = true;
            }

            public void onAnimationEnd(View view) {
                if (!this.mCanceled) {
                    ToolbarWidgetWrapper.this.mToolbar.setVisibility(i);
                }
            }

            public void onAnimationStart(View view) {
                ToolbarWidgetWrapper.this.mToolbar.setVisibility(0);
            }
        });
    }

    public boolean showOverflowMenu() {
        return this.mToolbar.showOverflowMenu();
    }
}
