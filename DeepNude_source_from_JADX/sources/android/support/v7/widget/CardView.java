package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.cardview.C0223R;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class CardView extends FrameLayout {
    private static final int[] COLOR_BACKGROUND_ATTR = new int[]{16842801};
    private static final CardViewImpl IMPL;
    private final CardViewDelegate mCardViewDelegate;
    private boolean mCompatPadding;
    final Rect mContentPadding;
    private boolean mPreventCornerOverlap;
    final Rect mShadowBounds;
    int mUserSetMinHeight;
    int mUserSetMinWidth;

    /* renamed from: android.support.v7.widget.CardView$1 */
    class C07911 implements CardViewDelegate {
        private Drawable mCardBackground;

        C07911() {
        }

        public Drawable getCardBackground() {
            return this.mCardBackground;
        }

        public View getCardView() {
            return CardView.this;
        }

        public boolean getPreventCornerOverlap() {
            return CardView.this.getPreventCornerOverlap();
        }

        public boolean getUseCompatPadding() {
            return CardView.this.getUseCompatPadding();
        }

        public void setCardBackground(Drawable drawable) {
            this.mCardBackground = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        public void setMinWidthHeightInternal(int i, int i2) {
            CardView cardView = CardView.this;
            if (i > cardView.mUserSetMinWidth) {
                super.setMinimumWidth(i);
            }
            CardView cardView2 = CardView.this;
            if (i2 > cardView2.mUserSetMinHeight) {
                super.setMinimumHeight(i2);
            }
        }

        public void setShadowPadding(int i, int i2, int i3, int i4) {
            CardView.this.mShadowBounds.set(i, i2, i3, i4);
            CardView cardView = CardView.this;
            Rect rect = cardView.mContentPadding;
            super.setPadding(i + rect.left, i2 + rect.top, i3 + rect.right, i4 + rect.bottom);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        CardViewImpl cardViewApi21Impl = i >= 21 ? new CardViewApi21Impl() : i >= 17 ? new CardViewApi17Impl() : new CardViewBaseImpl();
        IMPL = cardViewApi21Impl;
        IMPL.initStatic();
    }

    public CardView(Context context) {
        this(context, null);
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0223R.attr.cardViewStyle);
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        ColorStateList colorStateList;
        int color;
        super(context, attributeSet, i);
        this.mContentPadding = new Rect();
        this.mShadowBounds = new Rect();
        this.mCardViewDelegate = new C07911();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0223R.styleable.CardView, i, C0223R.style.CardView);
        if (obtainStyledAttributes.hasValue(C0223R.styleable.CardView_cardBackgroundColor)) {
            colorStateList = obtainStyledAttributes.getColorStateList(C0223R.styleable.CardView_cardBackgroundColor);
        } else {
            Resources resources;
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
            color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                resources = getResources();
                color = C0223R.color.cardview_light_background;
            } else {
                resources = getResources();
                color = C0223R.color.cardview_dark_background;
            }
            colorStateList = ColorStateList.valueOf(resources.getColor(color));
        }
        ColorStateList colorStateList2 = colorStateList;
        float dimension = obtainStyledAttributes.getDimension(C0223R.styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(C0223R.styleable.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(C0223R.styleable.CardView_cardMaxElevation, 0.0f);
        this.mCompatPadding = obtainStyledAttributes.getBoolean(C0223R.styleable.CardView_cardUseCompatPadding, false);
        this.mPreventCornerOverlap = obtainStyledAttributes.getBoolean(C0223R.styleable.CardView_cardPreventCornerOverlap, true);
        color = obtainStyledAttributes.getDimensionPixelSize(C0223R.styleable.CardView_contentPadding, 0);
        this.mContentPadding.left = obtainStyledAttributes.getDimensionPixelSize(C0223R.styleable.CardView_contentPaddingLeft, color);
        this.mContentPadding.top = obtainStyledAttributes.getDimensionPixelSize(C0223R.styleable.CardView_contentPaddingTop, color);
        this.mContentPadding.right = obtainStyledAttributes.getDimensionPixelSize(C0223R.styleable.CardView_contentPaddingRight, color);
        this.mContentPadding.bottom = obtainStyledAttributes.getDimensionPixelSize(C0223R.styleable.CardView_contentPaddingBottom, color);
        float f = dimension2 > dimension3 ? dimension2 : dimension3;
        this.mUserSetMinWidth = obtainStyledAttributes.getDimensionPixelSize(C0223R.styleable.CardView_android_minWidth, 0);
        this.mUserSetMinHeight = obtainStyledAttributes.getDimensionPixelSize(C0223R.styleable.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        IMPL.initialize(this.mCardViewDelegate, context, colorStateList2, dimension, dimension2, f);
    }

    public ColorStateList getCardBackgroundColor() {
        return IMPL.getBackgroundColor(this.mCardViewDelegate);
    }

    public float getCardElevation() {
        return IMPL.getElevation(this.mCardViewDelegate);
    }

    public int getContentPaddingBottom() {
        return this.mContentPadding.bottom;
    }

    public int getContentPaddingLeft() {
        return this.mContentPadding.left;
    }

    public int getContentPaddingRight() {
        return this.mContentPadding.right;
    }

    public int getContentPaddingTop() {
        return this.mContentPadding.top;
    }

    public float getMaxCardElevation() {
        return IMPL.getMaxElevation(this.mCardViewDelegate);
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public float getRadius() {
        return IMPL.getRadius(this.mCardViewDelegate);
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    protected void onMeasure(int i, int i2) {
        if (!(IMPL instanceof CardViewApi21Impl)) {
            int mode = MeasureSpec.getMode(i);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) IMPL.getMinWidth(this.mCardViewDelegate)), MeasureSpec.getSize(i)), mode);
            }
            mode = MeasureSpec.getMode(i2);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i2 = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) IMPL.getMinHeight(this.mCardViewDelegate)), MeasureSpec.getSize(i2)), mode);
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCardBackgroundColor(int i) {
        IMPL.setBackgroundColor(this.mCardViewDelegate, ColorStateList.valueOf(i));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        IMPL.setBackgroundColor(this.mCardViewDelegate, colorStateList);
    }

    public void setCardElevation(float f) {
        IMPL.setElevation(this.mCardViewDelegate, f);
    }

    public void setContentPadding(int i, int i2, int i3, int i4) {
        this.mContentPadding.set(i, i2, i3, i4);
        IMPL.updatePadding(this.mCardViewDelegate);
    }

    public void setMaxCardElevation(float f) {
        IMPL.setMaxElevation(this.mCardViewDelegate, f);
    }

    public void setMinimumHeight(int i) {
        this.mUserSetMinHeight = i;
        super.setMinimumHeight(i);
    }

    public void setMinimumWidth(int i) {
        this.mUserSetMinWidth = i;
        super.setMinimumWidth(i);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.mPreventCornerOverlap) {
            this.mPreventCornerOverlap = z;
            IMPL.onPreventCornerOverlapChanged(this.mCardViewDelegate);
        }
    }

    public void setRadius(float f) {
        IMPL.setRadius(this.mCardViewDelegate, f);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.mCompatPadding != z) {
            this.mCompatPadding = z;
            IMPL.onCompatPaddingChanged(this.mCardViewDelegate);
        }
    }
}
