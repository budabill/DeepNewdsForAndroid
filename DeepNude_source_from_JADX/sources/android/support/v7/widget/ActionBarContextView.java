package android.support.v7.widget;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.appcompat.C0222R;
import android.support.v7.view.ActionMode;
import android.support.v7.view.menu.MenuBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView extends AbsActionBarView {
    private static final String TAG = "ActionBarContextView";
    private View mClose;
    private int mCloseItemLayout;
    private View mCustomView;
    private CharSequence mSubtitle;
    private int mSubtitleStyleRes;
    private TextView mSubtitleView;
    private CharSequence mTitle;
    private LinearLayout mTitleLayout;
    private boolean mTitleOptional;
    private int mTitleStyleRes;
    private TextView mTitleView;

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0222R.attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, C0222R.styleable.ActionMode, i, 0);
        ViewCompat.setBackground(this, obtainStyledAttributes.getDrawable(C0222R.styleable.ActionMode_background));
        this.mTitleStyleRes = obtainStyledAttributes.getResourceId(C0222R.styleable.ActionMode_titleTextStyle, 0);
        this.mSubtitleStyleRes = obtainStyledAttributes.getResourceId(C0222R.styleable.ActionMode_subtitleTextStyle, 0);
        this.mContentHeight = obtainStyledAttributes.getLayoutDimension(C0222R.styleable.ActionMode_height, 0);
        this.mCloseItemLayout = obtainStyledAttributes.getResourceId(C0222R.styleable.ActionMode_closeItemLayout, C0222R.layout.abc_action_mode_close_item_material);
        obtainStyledAttributes.recycle();
    }

    private void initTitle() {
        if (this.mTitleLayout == null) {
            LayoutInflater.from(getContext()).inflate(C0222R.layout.abc_action_bar_title_item, this);
            this.mTitleLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.mTitleView = (TextView) this.mTitleLayout.findViewById(C0222R.id.action_bar_title);
            this.mSubtitleView = (TextView) this.mTitleLayout.findViewById(C0222R.id.action_bar_subtitle);
            if (this.mTitleStyleRes != 0) {
                this.mTitleView.setTextAppearance(getContext(), this.mTitleStyleRes);
            }
            if (this.mSubtitleStyleRes != 0) {
                this.mSubtitleView.setTextAppearance(getContext(), this.mSubtitleStyleRes);
            }
        }
        this.mTitleView.setText(this.mTitle);
        this.mSubtitleView.setText(this.mSubtitle);
        int isEmpty = TextUtils.isEmpty(this.mTitle) ^ 1;
        int isEmpty2 = TextUtils.isEmpty(this.mSubtitle) ^ 1;
        int i = 0;
        this.mSubtitleView.setVisibility(isEmpty2 != 0 ? 0 : 8);
        LinearLayout linearLayout = this.mTitleLayout;
        if (isEmpty == 0) {
            if (isEmpty2 == 0) {
                i = 8;
            }
        }
        linearLayout.setVisibility(i);
        if (this.mTitleLayout.getParent() == null) {
            addView(this.mTitleLayout);
        }
    }

    public /* bridge */ /* synthetic */ void animateToVisibility(int i) {
        super.animateToVisibility(i);
    }

    public /* bridge */ /* synthetic */ boolean canShowOverflowMenu() {
        return super.canShowOverflowMenu();
    }

    public void closeMode() {
        if (this.mClose == null) {
            killMode();
        }
    }

    public /* bridge */ /* synthetic */ void dismissPopupMenus() {
        super.dismissPopupMenus();
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        return actionMenuPresenter != null ? actionMenuPresenter.hideOverflowMenu() : false;
    }

    public void initForMode(final ActionMode actionMode) {
        MenuBuilder menuBuilder;
        ActionMenuPresenter actionMenuPresenter;
        LayoutParams layoutParams;
        View view = this.mClose;
        if (view == null) {
            this.mClose = LayoutInflater.from(getContext()).inflate(this.mCloseItemLayout, this, false);
        } else {
            if (view.getParent() == null) {
            }
            this.mClose.findViewById(C0222R.id.action_mode_close_button).setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    actionMode.finish();
                }
            });
            menuBuilder = (MenuBuilder) actionMode.getMenu();
            actionMenuPresenter = this.mActionMenuPresenter;
            if (actionMenuPresenter != null) {
                actionMenuPresenter.dismissPopupMenus();
            }
            this.mActionMenuPresenter = new ActionMenuPresenter(getContext());
            this.mActionMenuPresenter.setReserveOverflow(true);
            layoutParams = new LayoutParams(-2, -1);
            menuBuilder.addMenuPresenter(this.mActionMenuPresenter, this.mPopupContext);
            this.mMenuView = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
            ViewCompat.setBackground(this.mMenuView, null);
            addView(this.mMenuView, layoutParams);
        }
        addView(this.mClose);
        this.mClose.findViewById(C0222R.id.action_mode_close_button).setOnClickListener(/* anonymous class already generated */);
        menuBuilder = (MenuBuilder) actionMode.getMenu();
        actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.dismissPopupMenus();
        }
        this.mActionMenuPresenter = new ActionMenuPresenter(getContext());
        this.mActionMenuPresenter.setReserveOverflow(true);
        layoutParams = new LayoutParams(-2, -1);
        menuBuilder.addMenuPresenter(this.mActionMenuPresenter, this.mPopupContext);
        this.mMenuView = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
        ViewCompat.setBackground(this.mMenuView, null);
        addView(this.mMenuView, layoutParams);
    }

    public /* bridge */ /* synthetic */ boolean isOverflowMenuShowPending() {
        return super.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        return actionMenuPresenter != null ? actionMenuPresenter.isOverflowMenuShowing() : false;
    }

    public /* bridge */ /* synthetic */ boolean isOverflowReserved() {
        return super.isOverflowReserved();
    }

    public boolean isTitleOptional() {
        return this.mTitleOptional;
    }

    public void killMode() {
        removeAllViews();
        this.mCustomView = null;
        this.mMenuView = null;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.hideOverflowMenu();
            this.mActionMenuPresenter.hideSubMenus();
        }
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(ActionBarContextView.class.getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.mTitle);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        z = ViewUtils.isLayoutRtl(this);
        int paddingRight = z ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        i2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        View view = this.mClose;
        if (view == null || view.getVisibility() == 8) {
            i4 = paddingRight;
        } else {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.mClose.getLayoutParams();
            int i5 = z ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            i4 = z ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int next = AbsActionBarView.next(paddingRight, i5, z);
            i4 = AbsActionBarView.next(next + positionChild(this.mClose, next, paddingTop, i2, z), i4, z);
        }
        LinearLayout linearLayout = this.mTitleLayout;
        if (!(linearLayout == null || this.mCustomView != null || linearLayout.getVisibility() == 8)) {
            i4 += positionChild(this.mTitleLayout, i4, paddingTop, i2, z);
        }
        int i6 = i4;
        View view2 = this.mCustomView;
        if (view2 != null) {
            positionChild(view2, i6, paddingTop, i2, z);
        }
        int paddingLeft = z ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        View view3 = this.mMenuView;
        if (view3 != null) {
            positionChild(view3, paddingLeft, paddingTop, i2, z ^ 1);
        }
    }

    protected void onMeasure(int i, int i2) {
        String str = " can only be used ";
        int i3 = 1073741824;
        StringBuilder stringBuilder;
        if (MeasureSpec.getMode(i) != 1073741824) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(ActionBarContextView.class.getSimpleName());
            stringBuilder.append(str);
            stringBuilder.append("with android:layout_width=\"match_parent\" (or fill_parent)");
            throw new IllegalStateException(stringBuilder.toString());
        } else if (MeasureSpec.getMode(i2) != 0) {
            i = MeasureSpec.getSize(i);
            int i4 = this.mContentHeight;
            if (i4 <= 0) {
                i4 = MeasureSpec.getSize(i2);
            }
            i2 = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
            int i5 = i4 - i2;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
            View view = this.mClose;
            int i6 = 0;
            if (view != null) {
                paddingLeft = measureChildView(view, paddingLeft, makeMeasureSpec, 0);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.mClose.getLayoutParams();
                paddingLeft -= marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            }
            ViewGroup viewGroup = this.mMenuView;
            if (viewGroup != null && viewGroup.getParent() == this) {
                paddingLeft = measureChildView(this.mMenuView, paddingLeft, makeMeasureSpec, 0);
            }
            view = this.mTitleLayout;
            if (view != null && this.mCustomView == null) {
                if (this.mTitleOptional) {
                    this.mTitleLayout.measure(MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    makeMeasureSpec = this.mTitleLayout.getMeasuredWidth();
                    Object obj = makeMeasureSpec <= paddingLeft ? 1 : null;
                    if (obj != null) {
                        paddingLeft -= makeMeasureSpec;
                    }
                    this.mTitleLayout.setVisibility(obj != null ? 0 : 8);
                } else {
                    paddingLeft = measureChildView(view, paddingLeft, makeMeasureSpec, 0);
                }
            }
            View view2 = this.mCustomView;
            if (view2 != null) {
                LayoutParams layoutParams = view2.getLayoutParams();
                int i7 = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
                int i8 = layoutParams.width;
                if (i8 >= 0) {
                    paddingLeft = Math.min(i8, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = Integer.MIN_VALUE;
                }
                int i9 = layoutParams.height;
                if (i9 >= 0) {
                    i5 = Math.min(i9, i5);
                }
                this.mCustomView.measure(MeasureSpec.makeMeasureSpec(paddingLeft, i7), MeasureSpec.makeMeasureSpec(i5, i3));
            }
            if (this.mContentHeight <= 0) {
                i4 = getChildCount();
                paddingLeft = 0;
                while (i6 < i4) {
                    i3 = getChildAt(i6).getMeasuredHeight() + i2;
                    if (i3 > paddingLeft) {
                        paddingLeft = i3;
                    }
                    i6++;
                }
                setMeasuredDimension(i, paddingLeft);
                return;
            }
            setMeasuredDimension(i, i4);
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(ActionBarContextView.class.getSimpleName());
            stringBuilder.append(str);
            stringBuilder.append("with android:layout_height=\"wrap_content\"");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ void postShowOverflowMenu() {
        super.postShowOverflowMenu();
    }

    public void setContentHeight(int i) {
        this.mContentHeight = i;
    }

    public void setCustomView(View view) {
        View view2 = this.mCustomView;
        if (view2 != null) {
            removeView(view2);
        }
        this.mCustomView = view;
        if (view != null) {
            view2 = this.mTitleLayout;
            if (view2 != null) {
                removeView(view2);
                this.mTitleLayout = null;
            }
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mSubtitle = charSequence;
        initTitle();
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        initTitle();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.mTitleOptional) {
            requestLayout();
        }
        this.mTitleOptional = z;
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public /* bridge */ /* synthetic */ ViewPropertyAnimatorCompat setupAnimatorToVisibility(int i, long j) {
        return super.setupAnimatorToVisibility(i, j);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        return actionMenuPresenter != null ? actionMenuPresenter.showOverflowMenu() : false;
    }
}
