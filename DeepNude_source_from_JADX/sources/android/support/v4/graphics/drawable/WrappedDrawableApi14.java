package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

class WrappedDrawableApi14 extends Drawable implements Callback, WrappedDrawable, TintAwareDrawable {
    static final Mode DEFAULT_TINT_MODE = Mode.SRC_IN;
    private boolean mColorFilterSet;
    private int mCurrentColor;
    private Mode mCurrentMode;
    Drawable mDrawable;
    private boolean mMutated;
    DrawableWrapperState mState;

    protected static abstract class DrawableWrapperState extends ConstantState {
        int mChangingConfigurations;
        ConstantState mDrawableState;
        ColorStateList mTint = null;
        Mode mTintMode = WrappedDrawableApi14.DEFAULT_TINT_MODE;

        DrawableWrapperState(DrawableWrapperState drawableWrapperState, Resources resources) {
            if (drawableWrapperState != null) {
                this.mChangingConfigurations = drawableWrapperState.mChangingConfigurations;
                this.mDrawableState = drawableWrapperState.mDrawableState;
                this.mTint = drawableWrapperState.mTint;
                this.mTintMode = drawableWrapperState.mTintMode;
            }
        }

        boolean canConstantState() {
            return this.mDrawableState != null;
        }

        public int getChangingConfigurations() {
            int i = this.mChangingConfigurations;
            ConstantState constantState = this.mDrawableState;
            return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
        }

        public Drawable newDrawable() {
            return newDrawable(null);
        }

        public abstract Drawable newDrawable(Resources resources);
    }

    private static class DrawableWrapperStateBase extends DrawableWrapperState {
        DrawableWrapperStateBase(DrawableWrapperState drawableWrapperState, Resources resources) {
            super(drawableWrapperState, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new WrappedDrawableApi14(this, resources);
        }
    }

    WrappedDrawableApi14(Drawable drawable) {
        this.mState = mutateConstantState();
        setWrappedDrawable(drawable);
    }

    WrappedDrawableApi14(DrawableWrapperState drawableWrapperState, Resources resources) {
        this.mState = drawableWrapperState;
        updateLocalState(resources);
    }

    private void updateLocalState(Resources resources) {
        DrawableWrapperState drawableWrapperState = this.mState;
        if (drawableWrapperState != null) {
            ConstantState constantState = drawableWrapperState.mDrawableState;
            if (constantState != null) {
                setWrappedDrawable(constantState.newDrawable(resources));
            }
        }
    }

    private boolean updateTint(int[] iArr) {
        if (!isCompatTintEnabled()) {
            return false;
        }
        DrawableWrapperState drawableWrapperState = this.mState;
        ColorStateList colorStateList = drawableWrapperState.mTint;
        Mode mode = drawableWrapperState.mTintMode;
        if (colorStateList == null || mode == null) {
            this.mColorFilterSet = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!(this.mColorFilterSet && colorForState == this.mCurrentColor && mode == this.mCurrentMode)) {
                setColorFilter(colorForState, mode);
                this.mCurrentColor = colorForState;
                this.mCurrentMode = mode;
                this.mColorFilterSet = true;
                return true;
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        this.mDrawable.draw(canvas);
    }

    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        DrawableWrapperState drawableWrapperState = this.mState;
        return (changingConfigurations | (drawableWrapperState != null ? drawableWrapperState.getChangingConfigurations() : 0)) | this.mDrawable.getChangingConfigurations();
    }

    public ConstantState getConstantState() {
        DrawableWrapperState drawableWrapperState = this.mState;
        if (drawableWrapperState == null || !drawableWrapperState.canConstantState()) {
            return null;
        }
        this.mState.mChangingConfigurations = getChangingConfigurations();
        return this.mState;
    }

    public Drawable getCurrent() {
        return this.mDrawable.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.mDrawable.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.mDrawable.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.mDrawable.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.mDrawable.getMinimumWidth();
    }

    public int getOpacity() {
        return this.mDrawable.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.mDrawable.getPadding(rect);
    }

    public int[] getState() {
        return this.mDrawable.getState();
    }

    public Region getTransparentRegion() {
        return this.mDrawable.getTransparentRegion();
    }

    public final Drawable getWrappedDrawable() {
        return this.mDrawable;
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return this.mDrawable.isAutoMirrored();
    }

    protected boolean isCompatTintEnabled() {
        return true;
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        if (isCompatTintEnabled()) {
            DrawableWrapperState drawableWrapperState = this.mState;
            if (drawableWrapperState != null) {
                colorStateList = drawableWrapperState.mTint;
                return (colorStateList == null && colorStateList.isStateful()) || this.mDrawable.isStateful();
            }
        }
        colorStateList = null;
        if (colorStateList == null) {
        }
    }

    public void jumpToCurrentState() {
        this.mDrawable.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.mState = mutateConstantState();
            Drawable drawable = this.mDrawable;
            if (drawable != null) {
                drawable.mutate();
            }
            DrawableWrapperState drawableWrapperState = this.mState;
            if (drawableWrapperState != null) {
                Drawable drawable2 = this.mDrawable;
                drawableWrapperState.mDrawableState = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.mMutated = true;
        }
        return this;
    }

    DrawableWrapperState mutateConstantState() {
        return new DrawableWrapperStateBase(this.mState, null);
    }

    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    protected boolean onLevelChange(int i) {
        return this.mDrawable.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.mDrawable.setAlpha(i);
    }

    public void setAutoMirrored(boolean z) {
        this.mDrawable.setAutoMirrored(z);
    }

    public void setChangingConfigurations(int i) {
        this.mDrawable.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mDrawable.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.mDrawable.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.mDrawable.setFilterBitmap(z);
    }

    public boolean setState(int[] iArr) {
        boolean state = this.mDrawable.setState(iArr);
        if (!updateTint(iArr)) {
            if (!state) {
                return false;
            }
        }
        return true;
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.mState.mTint = colorStateList;
        updateTint(getState());
    }

    public void setTintMode(Mode mode) {
        this.mState.mTintMode = mode;
        updateTint(getState());
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (!super.setVisible(z, z2)) {
            if (!this.mDrawable.setVisible(z, z2)) {
                return false;
            }
        }
        return true;
    }

    public final void setWrappedDrawable(Drawable drawable) {
        Drawable drawable2 = this.mDrawable;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            DrawableWrapperState drawableWrapperState = this.mState;
            if (drawableWrapperState != null) {
                drawableWrapperState.mDrawableState = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
