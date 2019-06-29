package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v7.cardview.C0223R;

class RoundRectDrawableWithShadow extends Drawable {
    private static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    private static final float SHADOW_MULTIPLIER = 1.5f;
    static RoundRectHelper sRoundRectHelper;
    private boolean mAddPaddingForCorners = true;
    private ColorStateList mBackground;
    private final RectF mCardBounds;
    private float mCornerRadius;
    private Paint mCornerShadowPaint;
    private Path mCornerShadowPath;
    private boolean mDirty = true;
    private Paint mEdgeShadowPaint;
    private final int mInsetShadow;
    private Paint mPaint;
    private boolean mPrintedShadowClipWarning = false;
    private float mRawMaxShadowSize;
    private float mRawShadowSize;
    private final int mShadowEndColor;
    private float mShadowSize;
    private final int mShadowStartColor;

    interface RoundRectHelper {
        void drawRoundRect(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    RoundRectDrawableWithShadow(Resources resources, ColorStateList colorStateList, float f, float f2, float f3) {
        this.mShadowStartColor = resources.getColor(C0223R.color.cardview_shadow_start_color);
        this.mShadowEndColor = resources.getColor(C0223R.color.cardview_shadow_end_color);
        this.mInsetShadow = resources.getDimensionPixelSize(C0223R.dimen.cardview_compat_inset_shadow);
        this.mPaint = new Paint(5);
        setBackground(colorStateList);
        this.mCornerShadowPaint = new Paint(5);
        this.mCornerShadowPaint.setStyle(Style.FILL);
        this.mCornerRadius = (float) ((int) (f + 0.5f));
        this.mCardBounds = new RectF();
        this.mEdgeShadowPaint = new Paint(this.mCornerShadowPaint);
        this.mEdgeShadowPaint.setAntiAlias(false);
        setShadowSize(f2, f3);
    }

    private void buildComponents(Rect rect) {
        float f = this.mRawMaxShadowSize;
        float f2 = SHADOW_MULTIPLIER * f;
        this.mCardBounds.set(((float) rect.left) + f, ((float) rect.top) + f2, ((float) rect.right) - f, ((float) rect.bottom) - f2);
        buildShadowCorners();
    }

    private void buildShadowCorners() {
        float f = this.mCornerRadius;
        RectF rectF = new RectF(-f, -f, f, f);
        RectF rectF2 = new RectF(rectF);
        float f2 = this.mShadowSize;
        rectF2.inset(-f2, -f2);
        Path path = this.mCornerShadowPath;
        if (path == null) {
            r0.mCornerShadowPath = new Path();
        } else {
            path.reset();
        }
        r0.mCornerShadowPath.setFillType(FillType.EVEN_ODD);
        r0.mCornerShadowPath.moveTo(-r0.mCornerRadius, 0.0f);
        r0.mCornerShadowPath.rLineTo(-r0.mShadowSize, 0.0f);
        r0.mCornerShadowPath.arcTo(rectF2, 180.0f, 90.0f, false);
        r0.mCornerShadowPath.arcTo(rectF, 270.0f, -90.0f, false);
        r0.mCornerShadowPath.close();
        float f3 = r0.mCornerRadius;
        f = r0.mShadowSize;
        f2 = f3 / (f3 + f);
        Paint paint = r0.mCornerShadowPaint;
        float f4 = f3 + f;
        r12 = new int[3];
        int i = r0.mShadowStartColor;
        r12[0] = i;
        r12[1] = i;
        r12[2] = r0.mShadowEndColor;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f4, r12, new float[]{0.0f, f2, 1.0f}, TileMode.CLAMP));
        Paint paint2 = r0.mEdgeShadowPaint;
        float f5 = r0.mCornerRadius;
        float f6 = -f5;
        float f7 = r0.mShadowSize;
        float f8 = f6 + f7;
        float f9 = (-f5) - f7;
        r4 = new int[3];
        int i2 = r0.mShadowStartColor;
        r4[0] = i2;
        r4[1] = i2;
        r4[2] = r0.mShadowEndColor;
        paint2.setShader(new LinearGradient(0.0f, f8, 0.0f, f9, r4, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
        r0.mEdgeShadowPaint.setAntiAlias(false);
    }

    static float calculateHorizontalPadding(float f, float f2, boolean z) {
        if (!z) {
            return f;
        }
        double d = (double) f;
        double d2 = 1.0d - COS_45;
        double d3 = (double) f2;
        Double.isNaN(d3);
        d2 *= d3;
        Double.isNaN(d);
        return (float) (d + d2);
    }

    static float calculateVerticalPadding(float f, float f2, boolean z) {
        if (!z) {
            return f * SHADOW_MULTIPLIER;
        }
        double d = (double) (f * SHADOW_MULTIPLIER);
        double d2 = 1.0d - COS_45;
        double d3 = (double) f2;
        Double.isNaN(d3);
        d2 *= d3;
        Double.isNaN(d);
        return (float) (d + d2);
    }

    private void drawShadow(Canvas canvas) {
        float f = this.mCornerRadius;
        float f2 = (-f) - this.mShadowSize;
        f = (f + ((float) this.mInsetShadow)) + (this.mRawShadowSize / 2.0f);
        float f3 = f * 2.0f;
        Object obj = this.mCardBounds.width() - f3 > 0.0f ? 1 : null;
        Object obj2 = this.mCardBounds.height() - f3 > 0.0f ? 1 : null;
        int save = canvas.save();
        RectF rectF = this.mCardBounds;
        canvas.translate(rectF.left + f, rectF.top + f);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (obj != null) {
            canvas.drawRect(0.0f, f2, this.mCardBounds.width() - f3, -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(save);
        save = canvas.save();
        rectF = this.mCardBounds;
        canvas.translate(rectF.right - f, rectF.bottom - f);
        canvas.rotate(180.0f);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (obj != null) {
            canvas.drawRect(0.0f, f2, this.mCardBounds.width() - f3, (-this.mCornerRadius) + this.mShadowSize, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        rectF = this.mCardBounds;
        canvas.translate(rectF.left + f, rectF.bottom - f);
        canvas.rotate(270.0f);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (obj2 != null) {
            canvas.drawRect(0.0f, f2, this.mCardBounds.height() - f3, -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(save2);
        save2 = canvas.save();
        rectF = this.mCardBounds;
        canvas.translate(rectF.right - f, rectF.top + f);
        canvas.rotate(90.0f);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (obj2 != null) {
            canvas.drawRect(0.0f, f2, this.mCardBounds.height() - f3, -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(save2);
    }

    private void setBackground(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.mBackground = colorStateList;
        this.mPaint.setColor(this.mBackground.getColorForState(getState(), this.mBackground.getDefaultColor()));
    }

    private void setShadowSize(float f, float f2) {
        String str = ". Must be >= 0";
        StringBuilder stringBuilder;
        if (f < 0.0f) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid shadow size ");
            stringBuilder.append(f);
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (f2 >= 0.0f) {
            f = (float) toEven(f);
            f2 = (float) toEven(f2);
            if (f > f2) {
                if (!this.mPrintedShadowClipWarning) {
                    this.mPrintedShadowClipWarning = true;
                }
                f = f2;
            }
            if (this.mRawShadowSize != f || this.mRawMaxShadowSize != f2) {
                this.mRawShadowSize = f;
                this.mRawMaxShadowSize = f2;
                this.mShadowSize = (float) ((int) (((f * SHADOW_MULTIPLIER) + ((float) this.mInsetShadow)) + 0.5f));
                this.mDirty = true;
                invalidateSelf();
            }
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid max shadow size ");
            stringBuilder.append(f2);
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    private int toEven(float f) {
        int i = (int) (f + 0.5f);
        return i % 2 == 1 ? i - 1 : i;
    }

    public void draw(Canvas canvas) {
        if (this.mDirty) {
            buildComponents(getBounds());
            this.mDirty = false;
        }
        canvas.translate(0.0f, this.mRawShadowSize / 2.0f);
        drawShadow(canvas);
        canvas.translate(0.0f, (-this.mRawShadowSize) / 2.0f);
        sRoundRectHelper.drawRoundRect(canvas, this.mCardBounds, this.mCornerRadius, this.mPaint);
    }

    ColorStateList getColor() {
        return this.mBackground;
    }

    float getCornerRadius() {
        return this.mCornerRadius;
    }

    void getMaxShadowAndCornerPadding(Rect rect) {
        getPadding(rect);
    }

    float getMaxShadowSize() {
        return this.mRawMaxShadowSize;
    }

    float getMinHeight() {
        float f = this.mRawMaxShadowSize;
        return (Math.max(f, (this.mCornerRadius + ((float) this.mInsetShadow)) + ((f * SHADOW_MULTIPLIER) / 2.0f)) * 2.0f) + (((this.mRawMaxShadowSize * SHADOW_MULTIPLIER) + ((float) this.mInsetShadow)) * 2.0f);
    }

    float getMinWidth() {
        float f = this.mRawMaxShadowSize;
        return (Math.max(f, (this.mCornerRadius + ((float) this.mInsetShadow)) + (f / 2.0f)) * 2.0f) + ((this.mRawMaxShadowSize + ((float) this.mInsetShadow)) * 2.0f);
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) calculateVerticalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        int ceil2 = (int) Math.ceil((double) calculateHorizontalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    float getShadowSize() {
        return this.mRawShadowSize;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.mBackground;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mDirty = true;
    }

    protected boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.mBackground;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.mPaint.getColor() == colorForState) {
            return false;
        }
        this.mPaint.setColor(colorForState);
        this.mDirty = true;
        invalidateSelf();
        return true;
    }

    void setAddPaddingForCorners(boolean z) {
        this.mAddPaddingForCorners = z;
        invalidateSelf();
    }

    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
        this.mCornerShadowPaint.setAlpha(i);
        this.mEdgeShadowPaint.setAlpha(i);
    }

    void setColor(ColorStateList colorStateList) {
        setBackground(colorStateList);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    void setCornerRadius(float f) {
        if (f >= 0.0f) {
            f = (float) ((int) (f + 0.5f));
            if (this.mCornerRadius != f) {
                this.mCornerRadius = f;
                this.mDirty = true;
                invalidateSelf();
                return;
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid radius ");
        stringBuilder.append(f);
        stringBuilder.append(". Must be >= 0");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    void setMaxShadowSize(float f) {
        setShadowSize(this.mRawShadowSize, f);
    }

    void setShadowSize(float f) {
        setShadowSize(f, this.mRawMaxShadowSize);
    }
}
