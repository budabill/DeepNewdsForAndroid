package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0222R;
import android.support.v7.view.menu.MenuView.ItemView;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.SelectionBoundsAdjuster;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView extends LinearLayout implements ItemView, SelectionBoundsAdjuster {
    private static final String TAG = "ListMenuItemView";
    private Drawable mBackground;
    private CheckBox mCheckBox;
    private LinearLayout mContent;
    private boolean mForceShowIcon;
    private ImageView mGroupDivider;
    private boolean mHasListDivider;
    private ImageView mIconView;
    private LayoutInflater mInflater;
    private MenuItemImpl mItemData;
    private int mMenuType;
    private boolean mPreserveIconSpacing;
    private RadioButton mRadioButton;
    private TextView mShortcutView;
    private Drawable mSubMenuArrow;
    private ImageView mSubMenuArrowView;
    private int mTextAppearance;
    private Context mTextAppearanceContext;
    private TextView mTitleView;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0222R.attr.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getContext(), attributeSet, C0222R.styleable.MenuView, i, 0);
        this.mBackground = obtainStyledAttributes.getDrawable(C0222R.styleable.MenuView_android_itemBackground);
        this.mTextAppearance = obtainStyledAttributes.getResourceId(C0222R.styleable.MenuView_android_itemTextAppearance, -1);
        this.mPreserveIconSpacing = obtainStyledAttributes.getBoolean(C0222R.styleable.MenuView_preserveIconSpacing, false);
        this.mTextAppearanceContext = context;
        this.mSubMenuArrow = obtainStyledAttributes.getDrawable(C0222R.styleable.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(null, new int[]{16843049}, C0222R.attr.dropDownListViewStyle, 0);
        this.mHasListDivider = obtainStyledAttributes2.hasValue(0);
        obtainStyledAttributes.recycle();
        obtainStyledAttributes2.recycle();
    }

    private void addContentView(View view) {
        addContentView(view, -1);
    }

    private void addContentView(View view, int i) {
        LinearLayout linearLayout = this.mContent;
        if (linearLayout != null) {
            linearLayout.addView(view, i);
        } else {
            addView(view, i);
        }
    }

    private LayoutInflater getInflater() {
        if (this.mInflater == null) {
            this.mInflater = LayoutInflater.from(getContext());
        }
        return this.mInflater;
    }

    private void insertCheckBox() {
        this.mCheckBox = (CheckBox) getInflater().inflate(C0222R.layout.abc_list_menu_item_checkbox, this, false);
        addContentView(this.mCheckBox);
    }

    private void insertIconView() {
        this.mIconView = (ImageView) getInflater().inflate(C0222R.layout.abc_list_menu_item_icon, this, false);
        addContentView(this.mIconView, 0);
    }

    private void insertRadioButton() {
        this.mRadioButton = (RadioButton) getInflater().inflate(C0222R.layout.abc_list_menu_item_radio, this, false);
        addContentView(this.mRadioButton);
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.mSubMenuArrowView;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.mGroupDivider;
        if (imageView != null && imageView.getVisibility() == 0) {
            LayoutParams layoutParams = (LayoutParams) this.mGroupDivider.getLayoutParams();
            rect.top += (this.mGroupDivider.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin;
        }
    }

    public MenuItemImpl getItemData() {
        return this.mItemData;
    }

    public void initialize(MenuItemImpl menuItemImpl, int i) {
        this.mItemData = menuItemImpl;
        this.mMenuType = i;
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setTitle(menuItemImpl.getTitleForItemView(this));
        setCheckable(menuItemImpl.isCheckable());
        setShortcut(menuItemImpl.shouldShowShortcut(), menuItemImpl.getShortcut());
        setIcon(menuItemImpl.getIcon());
        setEnabled(menuItemImpl.isEnabled());
        setSubMenuArrowVisible(menuItemImpl.hasSubMenu());
        setContentDescription(menuItemImpl.getContentDescription());
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        ViewCompat.setBackground(this, this.mBackground);
        this.mTitleView = (TextView) findViewById(C0222R.id.title);
        int i = this.mTextAppearance;
        if (i != -1) {
            this.mTitleView.setTextAppearance(this.mTextAppearanceContext, i);
        }
        this.mShortcutView = (TextView) findViewById(C0222R.id.shortcut);
        this.mSubMenuArrowView = (ImageView) findViewById(C0222R.id.submenuarrow);
        ImageView imageView = this.mSubMenuArrowView;
        if (imageView != null) {
            imageView.setImageDrawable(this.mSubMenuArrow);
        }
        this.mGroupDivider = (ImageView) findViewById(C0222R.id.group_divider);
        this.mContent = (LinearLayout) findViewById(C0222R.id.content);
    }

    protected void onMeasure(int i, int i2) {
        if (this.mIconView != null && this.mPreserveIconSpacing) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) this.mIconView.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setCheckable(boolean z) {
        if (z || this.mRadioButton != null || this.mCheckBox != null) {
            CompoundButton compoundButton;
            CompoundButton compoundButton2;
            if (this.mItemData.isExclusiveCheckable()) {
                if (this.mRadioButton == null) {
                    insertRadioButton();
                }
                compoundButton = this.mRadioButton;
                compoundButton2 = this.mCheckBox;
            } else {
                if (this.mCheckBox == null) {
                    insertCheckBox();
                }
                compoundButton = this.mCheckBox;
                compoundButton2 = this.mRadioButton;
            }
            if (z) {
                compoundButton.setChecked(this.mItemData.isChecked());
                if (compoundButton.getVisibility() != 0) {
                    compoundButton.setVisibility(0);
                }
                if (!(compoundButton2 == null || compoundButton2.getVisibility() == 8)) {
                    compoundButton2.setVisibility(8);
                }
            } else {
                CheckBox checkBox = this.mCheckBox;
                if (checkBox != null) {
                    checkBox.setVisibility(8);
                }
                RadioButton radioButton = this.mRadioButton;
                if (radioButton != null) {
                    radioButton.setVisibility(8);
                }
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.mItemData.isExclusiveCheckable()) {
            if (this.mRadioButton == null) {
                insertRadioButton();
            }
            compoundButton = this.mRadioButton;
        } else {
            if (this.mCheckBox == null) {
                insertCheckBox();
            }
            compoundButton = this.mCheckBox;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.mForceShowIcon = z;
        this.mPreserveIconSpacing = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.mGroupDivider;
        if (imageView != null) {
            int i = (this.mHasListDivider || !z) ? 8 : 0;
            imageView.setVisibility(i);
        }
    }

    public void setIcon(Drawable drawable) {
        Object obj;
        ImageView imageView;
        if (!this.mItemData.shouldShowIcon()) {
            if (!this.mForceShowIcon) {
                obj = null;
                if (obj != null && !this.mPreserveIconSpacing) {
                    return;
                }
                if (this.mIconView == null || drawable != null || this.mPreserveIconSpacing) {
                    if (this.mIconView == null) {
                        insertIconView();
                    }
                    if (drawable == null) {
                        if (this.mPreserveIconSpacing) {
                            this.mIconView.setVisibility(8);
                        }
                    }
                    imageView = this.mIconView;
                    if (obj != null) {
                        drawable = null;
                    }
                    imageView.setImageDrawable(drawable);
                    if (this.mIconView.getVisibility() != 0) {
                        this.mIconView.setVisibility(0);
                    }
                }
                return;
            }
        }
        obj = 1;
        if (obj != null) {
        }
        if (this.mIconView == null) {
        }
        if (this.mIconView == null) {
            insertIconView();
        }
        if (drawable == null) {
            if (this.mPreserveIconSpacing) {
                this.mIconView.setVisibility(8);
            }
        }
        imageView = this.mIconView;
        if (obj != null) {
            drawable = null;
        }
        imageView.setImageDrawable(drawable);
        if (this.mIconView.getVisibility() != 0) {
            this.mIconView.setVisibility(0);
        }
    }

    public void setShortcut(boolean z, char c) {
        int i = (z && this.mItemData.shouldShowShortcut()) ? 0 : 8;
        if (i == 0) {
            this.mShortcutView.setText(this.mItemData.getShortcutLabel());
        }
        if (this.mShortcutView.getVisibility() != i) {
            this.mShortcutView.setVisibility(i);
        }
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView;
        int i;
        if (charSequence != null) {
            this.mTitleView.setText(charSequence);
            if (this.mTitleView.getVisibility() != 0) {
                textView = this.mTitleView;
                i = 0;
            } else {
                return;
            }
        }
        i = 8;
        if (this.mTitleView.getVisibility() != 8) {
            textView = this.mTitleView;
        } else {
            return;
        }
        textView.setVisibility(i);
    }

    public boolean showsIcon() {
        return this.mForceShowIcon;
    }
}
