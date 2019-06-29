package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.BaseMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.ItemInvoker;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.view.menu.MenuView;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends LinearLayoutCompat implements ItemInvoker, MenuView {
    static final int GENERATED_ITEM_PADDING = 4;
    static final int MIN_CELL_SIZE = 56;
    private static final String TAG = "ActionMenuView";
    private Callback mActionMenuPresenterCallback;
    private boolean mFormatItems;
    private int mFormatItemsWidth;
    private int mGeneratedItemPadding;
    private MenuBuilder mMenu;
    MenuBuilder.Callback mMenuBuilderCallback;
    private int mMinCellSize;
    OnMenuItemClickListener mOnMenuItemClickListener;
    private Context mPopupContext;
    private int mPopupTheme;
    private ActionMenuPresenter mPresenter;
    private boolean mReserveOverflow;

    public interface ActionMenuChildView {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    private static class ActionMenuPresenterCallback implements Callback {
        ActionMenuPresenterCallback() {
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            return false;
        }
    }

    public static class LayoutParams extends android.support.v7.widget.LinearLayoutCompat.LayoutParams {
        @ExportedProperty
        public int cellsUsed;
        @ExportedProperty
        public boolean expandable;
        boolean expanded;
        @ExportedProperty
        public int extraPixels;
        @ExportedProperty
        public boolean isOverflowButton;
        @ExportedProperty
        public boolean preventEdgeOffset;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.isOverflowButton = false;
        }

        LayoutParams(int i, int i2, boolean z) {
            super(i, i2);
            this.isOverflowButton = z;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((android.view.ViewGroup.LayoutParams) layoutParams);
            this.isOverflowButton = layoutParams.isOverflowButton;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    private class MenuBuilderCallback implements MenuBuilder.Callback {
        MenuBuilderCallback() {
        }

        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            OnMenuItemClickListener onMenuItemClickListener = ActionMenuView.this.mOnMenuItemClickListener;
            return onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(menuItem);
        }

        public void onMenuModeChange(MenuBuilder menuBuilder) {
            MenuBuilder.Callback callback = ActionMenuView.this.mMenuBuilderCallback;
            if (callback != null) {
                callback.onMenuModeChange(menuBuilder);
            }
        }
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.mMinCellSize = (int) (56.0f * f);
        this.mGeneratedItemPadding = (int) (f * 4.0f);
        this.mPopupContext = context;
        this.mPopupTheme = 0;
    }

    static int measureChildForCells(View view, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        i3 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i3) - i4, MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = true;
        Object obj = (actionMenuItemView == null || !actionMenuItemView.hasText()) ? null : 1;
        int i5 = 2;
        if (i2 <= 0 || (obj != null && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(MeasureSpec.makeMeasureSpec(i2 * i, Integer.MIN_VALUE), i3);
            i2 = view.getMeasuredWidth();
            int i6 = i2 / i;
            if (i2 % i != 0) {
                i6++;
            }
            if (obj == null || i6 >= 2) {
                i5 = i6;
            }
        }
        if (layoutParams.isOverflowButton || obj == null) {
            z = false;
        }
        layoutParams.expandable = z;
        layoutParams.cellsUsed = i5;
        view.measure(MeasureSpec.makeMeasureSpec(i * i5, 1073741824), i3);
        return i5;
    }

    private void onMeasureExactFormat(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingTop, -2);
        size -= paddingLeft;
        paddingLeft = this.mMinCellSize;
        int i3 = size / paddingLeft;
        int i4 = size % paddingLeft;
        if (i3 == 0) {
            setMeasuredDimension(size, 0);
            return;
        }
        int i5;
        int i6;
        int i7;
        Object obj;
        int i8;
        int i9;
        Object obj2;
        paddingLeft += i4 / i3;
        i4 = getChildCount();
        int i10 = i3;
        i3 = 0;
        int i11 = 0;
        Object obj3 = null;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        long j = 0;
        while (i3 < i4) {
            View childAt = getChildAt(i3);
            i5 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z;
                boolean z2 = childAt instanceof ActionMenuItemView;
                i12++;
                if (z2) {
                    int i15 = r0.mGeneratedItemPadding;
                    i6 = i12;
                    z = false;
                    childAt.setPadding(i15, 0, i15, 0);
                } else {
                    i6 = i12;
                    z = false;
                }
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.expanded = z;
                layoutParams.extraPixels = z;
                layoutParams.cellsUsed = z;
                layoutParams.expandable = z;
                layoutParams.leftMargin = z;
                layoutParams.rightMargin = z;
                z2 = z2 && ((ActionMenuItemView) childAt).hasText();
                layoutParams.preventEdgeOffset = z2;
                size2 = measureChildForCells(childAt, paddingLeft, layoutParams.isOverflowButton ? 1 : i10, childMeasureSpec, paddingTop);
                i12 = Math.max(i13, size2);
                if (layoutParams.expandable) {
                    i14++;
                }
                if (layoutParams.isOverflowButton) {
                    obj3 = 1;
                }
                i10 -= size2;
                i11 = Math.max(i11, childAt.getMeasuredHeight());
                if (size2 == 1) {
                    j |= (long) (1 << i3);
                    i11 = i11;
                } else {
                    i7 = i11;
                }
                i13 = i12;
                i12 = i6;
            }
            i3++;
            size2 = i5;
        }
        i5 = size2;
        Object obj4 = (obj3 == null || i12 != 2) ? null : 1;
        Object obj5 = null;
        while (i14 > 0 && i10 > 0) {
            size2 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            i15 = 0;
            i7 = 0;
            long j2 = 0;
            while (i15 < i4) {
                obj = obj5;
                LayoutParams layoutParams2 = (LayoutParams) getChildAt(i15).getLayoutParams();
                i8 = i11;
                if (layoutParams2.expandable) {
                    i3 = layoutParams2.cellsUsed;
                    if (i3 < size2) {
                        size2 = i3;
                        j2 = 1 << i15;
                        i7 = 1;
                    } else if (i3 == size2) {
                        j2 |= 1 << i15;
                        i7++;
                    }
                }
                i15++;
                i11 = i8;
                obj5 = obj;
            }
            obj = obj5;
            i8 = i11;
            j |= j2;
            if (i7 > i10) {
                i7 = mode;
                i9 = size;
                break;
            }
            size2++;
            i3 = 0;
            while (i3 < i4) {
                View childAt2 = getChildAt(i3);
                LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
                i9 = size;
                i7 = mode;
                long j3 = (long) (1 << i3);
                if ((j2 & j3) == 0) {
                    if (layoutParams3.cellsUsed == size2) {
                        j |= j3;
                    }
                    i6 = size2;
                } else {
                    if (obj4 != null && layoutParams3.preventEdgeOffset && i10 == 1) {
                        size = r0.mGeneratedItemPadding;
                        i6 = size2;
                        childAt2.setPadding(size + paddingLeft, 0, size, 0);
                    } else {
                        i6 = size2;
                    }
                    layoutParams3.cellsUsed++;
                    layoutParams3.expanded = true;
                    i10--;
                }
                i3++;
                mode = i7;
                size2 = i6;
                size = i9;
            }
            i11 = i8;
            obj5 = 1;
        }
        i7 = mode;
        i9 = size;
        obj = obj5;
        i8 = i11;
        View childAt3;
        LayoutParams layoutParams4;
        if (obj3 == null) {
            mode = 1;
            if (i12 == 1) {
                obj2 = 1;
                if (i10 > 0 || j == 0 || (i10 >= i12 - r1 && obj2 == null && i13 <= r1)) {
                    i12 = 0;
                } else {
                    float bitCount = (float) Long.bitCount(j);
                    if (obj2 == null) {
                        if ((j & 1) != 0) {
                            i12 = 0;
                            if (!((LayoutParams) getChildAt(0).getLayoutParams()).preventEdgeOffset) {
                                bitCount -= 0.5f;
                            }
                        } else {
                            i12 = 0;
                        }
                        size = i4 - 1;
                        if (!((j & ((long) (1 << size))) == 0 || ((LayoutParams) getChildAt(size).getLayoutParams()).preventEdgeOffset)) {
                            bitCount -= 0.5f;
                        }
                    } else {
                        i12 = 0;
                    }
                    i15 = bitCount > 0.0f ? (int) (((float) (i10 * paddingLeft)) / bitCount) : 0;
                    for (mode = 0; mode < i4; mode++) {
                        if ((j & ((long) (1 << mode))) != 0) {
                            childAt3 = getChildAt(mode);
                            layoutParams4 = (LayoutParams) childAt3.getLayoutParams();
                            if (childAt3 instanceof ActionMenuItemView) {
                                layoutParams4.extraPixels = i15;
                                layoutParams4.expanded = true;
                                if (mode == 0 && !layoutParams4.preventEdgeOffset) {
                                    layoutParams4.leftMargin = (-i15) / 2;
                                }
                            } else if (layoutParams4.isOverflowButton) {
                                layoutParams4.extraPixels = i15;
                                layoutParams4.expanded = true;
                                layoutParams4.rightMargin = (-i15) / 2;
                            } else {
                                if (mode != 0) {
                                    layoutParams4.leftMargin = i15 / 2;
                                }
                                if (mode != i4 - 1) {
                                    layoutParams4.rightMargin = i15 / 2;
                                }
                            }
                            obj = 1;
                        }
                    }
                }
                if (obj != null) {
                    for (i12 = 
/*
Method generation error in method: android.support.v7.widget.ActionMenuView.onMeasureExactFormat(int, int):void, dex: classes.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r13_16 'i12' int) = (r13_14 'i12' int), (r13_15 'i12' int) binds: {(r13_14 'i12' int)=B:161:0x0237, (r13_15 'i12' int)=B:133:0x0236} in method: android.support.v7.widget.ActionMenuView.onMeasureExactFormat(int, int):void, dex: classes.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:184)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:187)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:320)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:257)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:220)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:110)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:75)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:12)
	at jadx.core.ProcessClass.process(ProcessClass.java:40)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:537)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:509)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 37 more

*/

                    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
                        return layoutParams != null && (layoutParams instanceof LayoutParams);
                    }

                    public void dismissPopupMenus() {
                        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
                        if (actionMenuPresenter != null) {
                            actionMenuPresenter.dismissPopupMenus();
                        }
                    }

                    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
                        return false;
                    }

                    protected LayoutParams generateDefaultLayoutParams() {
                        android.support.v7.widget.LinearLayoutCompat.LayoutParams layoutParams = new LayoutParams(-2, -2);
                        layoutParams.gravity = 16;
                        return layoutParams;
                    }

                    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
                        return new LayoutParams(getContext(), attributeSet);
                    }

                    protected LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
                        if (layoutParams == null) {
                            return generateDefaultLayoutParams();
                        }
                        android.support.v7.widget.LinearLayoutCompat.LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : new LayoutParams(layoutParams);
                        if (layoutParams2.gravity <= 0) {
                            layoutParams2.gravity = 16;
                        }
                        return layoutParams2;
                    }

                    public LayoutParams generateOverflowButtonLayoutParams() {
                        LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
                        generateDefaultLayoutParams.isOverflowButton = true;
                        return generateDefaultLayoutParams;
                    }

                    public Menu getMenu() {
                        if (this.mMenu == null) {
                            Context context = getContext();
                            this.mMenu = new MenuBuilder(context);
                            this.mMenu.setCallback(new MenuBuilderCallback());
                            this.mPresenter = new ActionMenuPresenter(context);
                            this.mPresenter.setReserveOverflow(true);
                            BaseMenuPresenter baseMenuPresenter = this.mPresenter;
                            Callback callback = this.mActionMenuPresenterCallback;
                            if (callback == null) {
                                callback = new ActionMenuPresenterCallback();
                            }
                            baseMenuPresenter.setCallback(callback);
                            this.mMenu.addMenuPresenter(this.mPresenter, this.mPopupContext);
                            this.mPresenter.setMenuView(this);
                        }
                        return this.mMenu;
                    }

                    public Drawable getOverflowIcon() {
                        getMenu();
                        return this.mPresenter.getOverflowIcon();
                    }

                    public int getPopupTheme() {
                        return this.mPopupTheme;
                    }

                    public int getWindowAnimations() {
                        return 0;
                    }

                    protected boolean hasSupportDividerBeforeChildAt(int i) {
                        boolean z = false;
                        if (i == 0) {
                            return false;
                        }
                        View childAt = getChildAt(i - 1);
                        View childAt2 = getChildAt(i);
                        if (i < getChildCount() && (childAt instanceof ActionMenuChildView)) {
                            z = 0 | ((ActionMenuChildView) childAt).needsDividerAfter();
                        }
                        if (i > 0 && (childAt2 instanceof ActionMenuChildView)) {
                            z |= ((ActionMenuChildView) childAt2).needsDividerBefore();
                        }
                        return z;
                    }

                    public boolean hideOverflowMenu() {
                        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
                        return actionMenuPresenter != null && actionMenuPresenter.hideOverflowMenu();
                    }

                    public void initialize(MenuBuilder menuBuilder) {
                        this.mMenu = menuBuilder;
                    }

                    public boolean invokeItem(MenuItemImpl menuItemImpl) {
                        return this.mMenu.performItemAction(menuItemImpl, 0);
                    }

                    public boolean isOverflowMenuShowPending() {
                        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
                        return actionMenuPresenter != null && actionMenuPresenter.isOverflowMenuShowPending();
                    }

                    public boolean isOverflowMenuShowing() {
                        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
                        return actionMenuPresenter != null && actionMenuPresenter.isOverflowMenuShowing();
                    }

                    public boolean isOverflowReserved() {
                        return this.mReserveOverflow;
                    }

                    public void onConfigurationChanged(Configuration configuration) {
                        super.onConfigurationChanged(configuration);
                        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
                        if (actionMenuPresenter != null) {
                            actionMenuPresenter.updateMenuView(false);
                            if (this.mPresenter.isOverflowMenuShowing()) {
                                this.mPresenter.hideOverflowMenu();
                                this.mPresenter.showOverflowMenu();
                            }
                        }
                    }

                    public void onDetachedFromWindow() {
                        super.onDetachedFromWindow();
                        dismissPopupMenus();
                    }

                    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
                        if (this.mFormatItems) {
                            int i5;
                            int childCount = getChildCount();
                            int i6 = (i4 - i2) / 2;
                            int dividerWidth = getDividerWidth();
                            int i7 = i3 - i;
                            int paddingRight = (i7 - getPaddingRight()) - getPaddingLeft();
                            boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
                            int i8 = paddingRight;
                            int i9 = 0;
                            int i10 = 0;
                            for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
                                View childAt = getChildAt(paddingRight);
                                if (childAt.getVisibility() != 8) {
                                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                                    if (layoutParams.isOverflowButton) {
                                        int paddingLeft;
                                        int i11;
                                        i9 = childAt.getMeasuredWidth();
                                        if (hasSupportDividerBeforeChildAt(paddingRight)) {
                                            i9 += dividerWidth;
                                        }
                                        int measuredHeight = childAt.getMeasuredHeight();
                                        if (isLayoutRtl) {
                                            paddingLeft = getPaddingLeft() + layoutParams.leftMargin;
                                            i11 = paddingLeft + i9;
                                        } else {
                                            i11 = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                                            paddingLeft = i11 - i9;
                                        }
                                        i5 = i6 - (measuredHeight / 2);
                                        childAt.layout(paddingLeft, i5, i11, measuredHeight + i5);
                                        i8 -= i9;
                                        i9 = 1;
                                    } else {
                                        i8 -= (childAt.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
                                        boolean hasSupportDividerBeforeChildAt = hasSupportDividerBeforeChildAt(paddingRight);
                                        i10++;
                                    }
                                }
                            }
                            if (childCount == 1 && i9 == 0) {
                                View childAt2 = getChildAt(0);
                                dividerWidth = childAt2.getMeasuredWidth();
                                paddingRight = childAt2.getMeasuredHeight();
                                i7 = (i7 / 2) - (dividerWidth / 2);
                                i6 -= paddingRight / 2;
                                childAt2.layout(i7, i6, dividerWidth + i7, paddingRight + i6);
                                return;
                            }
                            i10 -= i9 ^ 1;
                            if (i10 > 0) {
                                i5 = i8 / i10;
                                dividerWidth = 0;
                            } else {
                                dividerWidth = 0;
                                i5 = 0;
                            }
                            i7 = Math.max(dividerWidth, i5);
                            View childAt3;
                            LayoutParams layoutParams2;
                            if (isLayoutRtl) {
                                paddingRight = getWidth() - getPaddingRight();
                                while (dividerWidth < childCount) {
                                    childAt3 = getChildAt(dividerWidth);
                                    layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                                    if (childAt3.getVisibility() != 8) {
                                        if (!layoutParams2.isOverflowButton) {
                                            paddingRight -= layoutParams2.rightMargin;
                                            i9 = childAt3.getMeasuredWidth();
                                            i10 = childAt3.getMeasuredHeight();
                                            i8 = i6 - (i10 / 2);
                                            childAt3.layout(paddingRight - i9, i8, paddingRight, i10 + i8);
                                            paddingRight -= (i9 + layoutParams2.leftMargin) + i7;
                                        }
                                    }
                                    dividerWidth++;
                                }
                            } else {
                                paddingRight = getPaddingLeft();
                                while (dividerWidth < childCount) {
                                    childAt3 = getChildAt(dividerWidth);
                                    layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                                    if (childAt3.getVisibility() != 8) {
                                        if (!layoutParams2.isOverflowButton) {
                                            paddingRight += layoutParams2.leftMargin;
                                            i9 = childAt3.getMeasuredWidth();
                                            i10 = childAt3.getMeasuredHeight();
                                            i8 = i6 - (i10 / 2);
                                            childAt3.layout(paddingRight, i8, paddingRight + i9, i10 + i8);
                                            paddingRight += (i9 + layoutParams2.rightMargin) + i7;
                                        }
                                    }
                                    dividerWidth++;
                                }
                            }
                            return;
                        }
                        super.onLayout(z, i, i2, i3, i4);
                    }

                    protected void onMeasure(int i, int i2) {
                        boolean z = this.mFormatItems;
                        this.mFormatItems = MeasureSpec.getMode(i) == 1073741824;
                        if (z != this.mFormatItems) {
                            this.mFormatItemsWidth = 0;
                        }
                        int size = MeasureSpec.getSize(i);
                        if (this.mFormatItems) {
                            MenuBuilder menuBuilder = this.mMenu;
                            if (!(menuBuilder == null || size == this.mFormatItemsWidth)) {
                                this.mFormatItemsWidth = size;
                                menuBuilder.onItemsChanged(true);
                            }
                        }
                        size = getChildCount();
                        if (!this.mFormatItems || size <= 0) {
                            for (int i3 = 0; i3 < size; i3++) {
                                LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                                layoutParams.rightMargin = 0;
                                layoutParams.leftMargin = 0;
                            }
                            super.onMeasure(i, i2);
                            return;
                        }
                        onMeasureExactFormat(i, i2);
                    }

                    public MenuBuilder peekMenu() {
                        return this.mMenu;
                    }

                    public void setExpandedActionViewsExclusive(boolean z) {
                        this.mPresenter.setExpandedActionViewsExclusive(z);
                    }

                    public void setMenuCallbacks(Callback callback, MenuBuilder.Callback callback2) {
                        this.mActionMenuPresenterCallback = callback;
                        this.mMenuBuilderCallback = callback2;
                    }

                    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
                        this.mOnMenuItemClickListener = onMenuItemClickListener;
                    }

                    public void setOverflowIcon(Drawable drawable) {
                        getMenu();
                        this.mPresenter.setOverflowIcon(drawable);
                    }

                    public void setOverflowReserved(boolean z) {
                        this.mReserveOverflow = z;
                    }

                    public void setPopupTheme(int i) {
                        if (this.mPopupTheme != i) {
                            this.mPopupTheme = i;
                            if (i == 0) {
                                this.mPopupContext = getContext();
                            } else {
                                this.mPopupContext = new ContextThemeWrapper(getContext(), i);
                            }
                        }
                    }

                    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
                        this.mPresenter = actionMenuPresenter;
                        this.mPresenter.setMenuView(this);
                    }

                    public boolean showOverflowMenu() {
                        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
                        return actionMenuPresenter != null && actionMenuPresenter.showOverflowMenu();
                    }
                }
