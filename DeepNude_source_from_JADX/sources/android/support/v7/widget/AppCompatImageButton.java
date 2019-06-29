package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.view.TintableBackgroundView;
import android.support.v4.widget.TintableImageSourceView;
import android.support.v7.appcompat.C0222R;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class AppCompatImageButton extends ImageButton implements TintableBackgroundView, TintableImageSourceView {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final AppCompatImageHelper mImageHelper;

    public AppCompatImageButton(Context context) {
        this(context, null);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0222R.attr.imageButtonStyle);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.wrap(context), attributeSet, i);
        this.mBackgroundTintHelper = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper.loadFromAttributes(attributeSet, i);
        this.mImageHelper = new AppCompatImageHelper(this);
        this.mImageHelper.loadFromAttributes(attributeSet, i);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.applySupportBackgroundTint();
        }
        AppCompatImageHelper appCompatImageHelper = this.mImageHelper;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.applySupportImageTint();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        return appCompatBackgroundHelper != null ? appCompatBackgroundHelper.getSupportBackgroundTintList() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        return appCompatBackgroundHelper != null ? appCompatBackgroundHelper.getSupportBackgroundTintMode() : null;
    }

    public ColorStateList getSupportImageTintList() {
        AppCompatImageHelper appCompatImageHelper = this.mImageHelper;
        return appCompatImageHelper != null ? appCompatImageHelper.getSupportImageTintList() : null;
    }

    public Mode getSupportImageTintMode() {
        AppCompatImageHelper appCompatImageHelper = this.mImageHelper;
        return appCompatImageHelper != null ? appCompatImageHelper.getSupportImageTintMode() : null;
    }

    public boolean hasOverlappingRendering() {
        return this.mImageHelper.hasOverlappingRendering() && super.hasOverlappingRendering();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.onSetBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.onSetBackgroundResource(i);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        AppCompatImageHelper appCompatImageHelper = this.mImageHelper;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.applySupportImageTint();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        AppCompatImageHelper appCompatImageHelper = this.mImageHelper;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.applySupportImageTint();
        }
    }

    public void setImageResource(int i) {
        this.mImageHelper.setImageResource(i);
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        AppCompatImageHelper appCompatImageHelper = this.mImageHelper;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.applySupportImageTint();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.setSupportBackgroundTintList(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.setSupportBackgroundTintMode(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        AppCompatImageHelper appCompatImageHelper = this.mImageHelper;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.setSupportImageTintList(colorStateList);
        }
    }

    public void setSupportImageTintMode(Mode mode) {
        AppCompatImageHelper appCompatImageHelper = this.mImageHelper;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.setSupportImageTintMode(mode);
        }
    }
}
