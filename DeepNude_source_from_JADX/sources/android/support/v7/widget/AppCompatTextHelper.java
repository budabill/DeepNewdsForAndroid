package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.widget.AutoSizeableTextView;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.appcompat.C0222R;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;

class AppCompatTextHelper {
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private boolean mAsyncFontPending;
    private final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
    private TintInfo mDrawableBottomTint;
    private TintInfo mDrawableEndTint;
    private TintInfo mDrawableLeftTint;
    private TintInfo mDrawableRightTint;
    private TintInfo mDrawableStartTint;
    private TintInfo mDrawableTopTint;
    private Typeface mFontTypeface;
    private int mStyle = 0;
    private final TextView mView;

    AppCompatTextHelper(TextView textView) {
        this.mView = textView;
        this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(this.mView);
    }

    private void applyCompoundDrawableTint(Drawable drawable, TintInfo tintInfo) {
        if (drawable != null && tintInfo != null) {
            AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
        }
    }

    private static TintInfo createTintInfo(Context context, AppCompatDrawableManager appCompatDrawableManager, int i) {
        ColorStateList tintList = appCompatDrawableManager.getTintList(context, i);
        if (tintList == null) {
            return null;
        }
        TintInfo tintInfo = new TintInfo();
        tintInfo.mHasTintList = true;
        tintInfo.mTintList = tintList;
        return tintInfo;
    }

    private void setTextSizeInternal(int i, float f) {
        this.mAutoSizeTextHelper.setTextSizeInternal(i, f);
    }

    private void updateTypefaceAndStyle(android.content.Context r5, android.support.v7.widget.TintTypedArray r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r4 = this;
        r0 = android.support.v7.appcompat.C0222R.styleable.TextAppearance_android_textStyle;
        r1 = r4.mStyle;
        r0 = r6.getInt(r0, r1);
        r4.mStyle = r0;
        r0 = android.support.v7.appcompat.C0222R.styleable.TextAppearance_android_fontFamily;
        r0 = r6.hasValue(r0);
        r1 = 0;
        r2 = 1;
        if (r0 != 0) goto L_0x0041;
    L_0x0014:
        r0 = android.support.v7.appcompat.C0222R.styleable.TextAppearance_fontFamily;
        r0 = r6.hasValue(r0);
        if (r0 == 0) goto L_0x001d;
    L_0x001c:
        goto L_0x0041;
    L_0x001d:
        r5 = android.support.v7.appcompat.C0222R.styleable.TextAppearance_android_typeface;
        r5 = r6.hasValue(r5);
        if (r5 == 0) goto L_0x0040;
    L_0x0025:
        r4.mAsyncFontPending = r1;
        r5 = android.support.v7.appcompat.C0222R.styleable.TextAppearance_android_typeface;
        r5 = r6.getInt(r5, r2);
        if (r5 == r2) goto L_0x003c;
    L_0x002f:
        r6 = 2;
        if (r5 == r6) goto L_0x0039;
    L_0x0032:
        r6 = 3;
        if (r5 == r6) goto L_0x0036;
    L_0x0035:
        goto L_0x0040;
    L_0x0036:
        r5 = android.graphics.Typeface.MONOSPACE;
        goto L_0x003e;
    L_0x0039:
        r5 = android.graphics.Typeface.SERIF;
        goto L_0x003e;
    L_0x003c:
        r5 = android.graphics.Typeface.SANS_SERIF;
    L_0x003e:
        r4.mFontTypeface = r5;
    L_0x0040:
        return;
    L_0x0041:
        r0 = 0;
        r4.mFontTypeface = r0;
        r0 = android.support.v7.appcompat.C0222R.styleable.TextAppearance_fontFamily;
        r0 = r6.hasValue(r0);
        if (r0 == 0) goto L_0x004f;
    L_0x004c:
        r0 = android.support.v7.appcompat.C0222R.styleable.TextAppearance_fontFamily;
        goto L_0x0051;
    L_0x004f:
        r0 = android.support.v7.appcompat.C0222R.styleable.TextAppearance_android_fontFamily;
    L_0x0051:
        r5 = r5.isRestricted();
        if (r5 != 0) goto L_0x0074;
    L_0x0057:
        r5 = new java.lang.ref.WeakReference;
        r3 = r4.mView;
        r5.<init>(r3);
        r3 = new android.support.v7.widget.AppCompatTextHelper$1;
        r3.<init>(r5);
        r5 = r4.mStyle;	 Catch:{ UnsupportedOperationException -> 0x0073, UnsupportedOperationException -> 0x0073 }
        r5 = r6.getFont(r0, r5, r3);	 Catch:{ UnsupportedOperationException -> 0x0073, UnsupportedOperationException -> 0x0073 }
        r4.mFontTypeface = r5;	 Catch:{ UnsupportedOperationException -> 0x0073, UnsupportedOperationException -> 0x0073 }
        r5 = r4.mFontTypeface;	 Catch:{ UnsupportedOperationException -> 0x0073, UnsupportedOperationException -> 0x0073 }
        if (r5 != 0) goto L_0x0070;	 Catch:{ UnsupportedOperationException -> 0x0073, UnsupportedOperationException -> 0x0073 }
    L_0x006f:
        r1 = 1;	 Catch:{ UnsupportedOperationException -> 0x0073, UnsupportedOperationException -> 0x0073 }
    L_0x0070:
        r4.mAsyncFontPending = r1;	 Catch:{ UnsupportedOperationException -> 0x0073, UnsupportedOperationException -> 0x0073 }
        goto L_0x0074;
    L_0x0074:
        r5 = r4.mFontTypeface;
        if (r5 != 0) goto L_0x0086;
    L_0x0078:
        r5 = r6.getString(r0);
        if (r5 == 0) goto L_0x0086;
    L_0x007e:
        r6 = r4.mStyle;
        r5 = android.graphics.Typeface.create(r5, r6);
        r4.mFontTypeface = r5;
    L_0x0086:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AppCompatTextHelper.updateTypefaceAndStyle(android.content.Context, android.support.v7.widget.TintTypedArray):void");
    }

    void applyCompoundDrawablesTints() {
        if (!(this.mDrawableLeftTint == null && this.mDrawableTopTint == null && this.mDrawableRightTint == null && this.mDrawableBottomTint == null)) {
            Drawable[] compoundDrawables = this.mView.getCompoundDrawables();
            applyCompoundDrawableTint(compoundDrawables[0], this.mDrawableLeftTint);
            applyCompoundDrawableTint(compoundDrawables[1], this.mDrawableTopTint);
            applyCompoundDrawableTint(compoundDrawables[2], this.mDrawableRightTint);
            applyCompoundDrawableTint(compoundDrawables[3], this.mDrawableBottomTint);
        }
        if (VERSION.SDK_INT < 17) {
            return;
        }
        if (this.mDrawableStartTint != null || this.mDrawableEndTint != null) {
            compoundDrawables = this.mView.getCompoundDrawablesRelative();
            applyCompoundDrawableTint(compoundDrawables[0], this.mDrawableStartTint);
            applyCompoundDrawableTint(compoundDrawables[2], this.mDrawableEndTint);
        }
    }

    void autoSizeText() {
        this.mAutoSizeTextHelper.autoSizeText();
    }

    int getAutoSizeMaxTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMaxTextSize();
    }

    int getAutoSizeMinTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMinTextSize();
    }

    int getAutoSizeStepGranularity() {
        return this.mAutoSizeTextHelper.getAutoSizeStepGranularity();
    }

    int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
    }

    int getAutoSizeTextType() {
        return this.mAutoSizeTextHelper.getAutoSizeTextType();
    }

    boolean isAutoSizeEnabled() {
        return this.mAutoSizeTextHelper.isAutoSizeEnabled();
    }

    @SuppressLint({"NewApi"})
    void loadFromAttributes(AttributeSet attributeSet, int i) {
        TintTypedArray obtainStyledAttributes;
        Object obj;
        boolean z;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        AttributeSet attributeSet2 = attributeSet;
        int i2 = i;
        Context context = this.mView.getContext();
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        TintTypedArray obtainStyledAttributes2 = TintTypedArray.obtainStyledAttributes(context, attributeSet2, C0222R.styleable.AppCompatTextHelper, i2, 0);
        int resourceId = obtainStyledAttributes2.getResourceId(C0222R.styleable.AppCompatTextHelper_android_textAppearance, -1);
        if (obtainStyledAttributes2.hasValue(C0222R.styleable.AppCompatTextHelper_android_drawableLeft)) {
            r0.mDrawableLeftTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes2.getResourceId(C0222R.styleable.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (obtainStyledAttributes2.hasValue(C0222R.styleable.AppCompatTextHelper_android_drawableTop)) {
            r0.mDrawableTopTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes2.getResourceId(C0222R.styleable.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (obtainStyledAttributes2.hasValue(C0222R.styleable.AppCompatTextHelper_android_drawableRight)) {
            r0.mDrawableRightTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes2.getResourceId(C0222R.styleable.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (obtainStyledAttributes2.hasValue(C0222R.styleable.AppCompatTextHelper_android_drawableBottom)) {
            r0.mDrawableBottomTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes2.getResourceId(C0222R.styleable.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (VERSION.SDK_INT >= 17) {
            if (obtainStyledAttributes2.hasValue(C0222R.styleable.AppCompatTextHelper_android_drawableStart)) {
                r0.mDrawableStartTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes2.getResourceId(C0222R.styleable.AppCompatTextHelper_android_drawableStart, 0));
            }
            if (obtainStyledAttributes2.hasValue(C0222R.styleable.AppCompatTextHelper_android_drawableEnd)) {
                r0.mDrawableEndTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes2.getResourceId(C0222R.styleable.AppCompatTextHelper_android_drawableEnd, 0));
            }
        }
        obtainStyledAttributes2.recycle();
        boolean z2 = r0.mView.getTransformationMethod() instanceof PasswordTransformationMethod;
        Object obj2 = 1;
        ColorStateList colorStateList3 = null;
        if (resourceId != -1) {
            obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, resourceId, C0222R.styleable.TextAppearance);
            if (z2 || !obtainStyledAttributes.hasValue(C0222R.styleable.TextAppearance_textAllCaps)) {
                obj = null;
                z = false;
            } else {
                z = obtainStyledAttributes.getBoolean(C0222R.styleable.TextAppearance_textAllCaps, false);
                obj = 1;
            }
            updateTypefaceAndStyle(context, obtainStyledAttributes);
            if (VERSION.SDK_INT < 23) {
                colorStateList = obtainStyledAttributes.hasValue(C0222R.styleable.TextAppearance_android_textColor) ? obtainStyledAttributes.getColorStateList(C0222R.styleable.TextAppearance_android_textColor) : null;
                colorStateList2 = obtainStyledAttributes.hasValue(C0222R.styleable.TextAppearance_android_textColorHint) ? obtainStyledAttributes.getColorStateList(C0222R.styleable.TextAppearance_android_textColorHint) : null;
                if (obtainStyledAttributes.hasValue(C0222R.styleable.TextAppearance_android_textColorLink)) {
                    colorStateList3 = obtainStyledAttributes.getColorStateList(C0222R.styleable.TextAppearance_android_textColorLink);
                }
                ColorStateList colorStateList4 = colorStateList;
                colorStateList = colorStateList3;
                colorStateList3 = colorStateList4;
            } else {
                colorStateList = null;
                colorStateList2 = colorStateList;
            }
            obtainStyledAttributes.recycle();
        } else {
            colorStateList = null;
            colorStateList2 = colorStateList;
            obj = null;
            z = false;
        }
        obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet2, C0222R.styleable.TextAppearance, i2, 0);
        if (z2 || !obtainStyledAttributes.hasValue(C0222R.styleable.TextAppearance_textAllCaps)) {
            obj2 = obj;
        } else {
            z = obtainStyledAttributes.getBoolean(C0222R.styleable.TextAppearance_textAllCaps, false);
        }
        if (VERSION.SDK_INT < 23) {
            if (obtainStyledAttributes.hasValue(C0222R.styleable.TextAppearance_android_textColor)) {
                colorStateList3 = obtainStyledAttributes.getColorStateList(C0222R.styleable.TextAppearance_android_textColor);
            }
            if (obtainStyledAttributes.hasValue(C0222R.styleable.TextAppearance_android_textColorHint)) {
                colorStateList2 = obtainStyledAttributes.getColorStateList(C0222R.styleable.TextAppearance_android_textColorHint);
            }
            if (obtainStyledAttributes.hasValue(C0222R.styleable.TextAppearance_android_textColorLink)) {
                colorStateList = obtainStyledAttributes.getColorStateList(C0222R.styleable.TextAppearance_android_textColorLink);
            }
        }
        if (VERSION.SDK_INT >= 28 && obtainStyledAttributes.hasValue(C0222R.styleable.TextAppearance_android_textSize) && obtainStyledAttributes.getDimensionPixelSize(C0222R.styleable.TextAppearance_android_textSize, -1) == 0) {
            r0.mView.setTextSize(0, 0.0f);
        }
        updateTypefaceAndStyle(context, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        if (colorStateList3 != null) {
            r0.mView.setTextColor(colorStateList3);
        }
        if (colorStateList2 != null) {
            r0.mView.setHintTextColor(colorStateList2);
        }
        if (colorStateList != null) {
            r0.mView.setLinkTextColor(colorStateList);
        }
        if (!(z2 || r5 == null)) {
            setAllCaps(z);
        }
        Typeface typeface = r0.mFontTypeface;
        if (typeface != null) {
            r0.mView.setTypeface(typeface, r0.mStyle);
        }
        r0.mAutoSizeTextHelper.loadFromAttributes(attributeSet2, i2);
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE && r0.mAutoSizeTextHelper.getAutoSizeTextType() != 0) {
            int[] autoSizeTextAvailableSizes = r0.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
            if (autoSizeTextAvailableSizes.length > 0) {
                if (((float) r0.mView.getAutoSizeStepGranularity()) != -1.0f) {
                    r0.mView.setAutoSizeTextTypeUniformWithConfiguration(r0.mAutoSizeTextHelper.getAutoSizeMinTextSize(), r0.mAutoSizeTextHelper.getAutoSizeMaxTextSize(), r0.mAutoSizeTextHelper.getAutoSizeStepGranularity(), 0);
                } else {
                    r0.mView.setAutoSizeTextTypeUniformWithPresetSizes(autoSizeTextAvailableSizes, 0);
                }
            }
        }
        TintTypedArray obtainStyledAttributes3 = TintTypedArray.obtainStyledAttributes(context, attributeSet2, C0222R.styleable.AppCompatTextView);
        i2 = obtainStyledAttributes3.getDimensionPixelSize(C0222R.styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
        int dimensionPixelSize = obtainStyledAttributes3.getDimensionPixelSize(C0222R.styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
        int dimensionPixelSize2 = obtainStyledAttributes3.getDimensionPixelSize(C0222R.styleable.AppCompatTextView_lineHeight, -1);
        obtainStyledAttributes3.recycle();
        if (i2 != -1) {
            TextViewCompat.setFirstBaselineToTopHeight(r0.mView, i2);
        }
        if (dimensionPixelSize != -1) {
            TextViewCompat.setLastBaselineToBottomHeight(r0.mView, dimensionPixelSize);
        }
        if (dimensionPixelSize2 != -1) {
            TextViewCompat.setLineHeight(r0.mView, dimensionPixelSize2);
        }
    }

    void onAsyncTypefaceReceived(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.mAsyncFontPending) {
            this.mFontTypeface = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.mStyle);
            }
        }
    }

    void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
            autoSizeText();
        }
    }

    void onSetTextAppearance(Context context, int i) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, i, C0222R.styleable.TextAppearance);
        if (obtainStyledAttributes.hasValue(C0222R.styleable.TextAppearance_textAllCaps)) {
            setAllCaps(obtainStyledAttributes.getBoolean(C0222R.styleable.TextAppearance_textAllCaps, false));
        }
        if (VERSION.SDK_INT < 23 && obtainStyledAttributes.hasValue(C0222R.styleable.TextAppearance_android_textColor)) {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(C0222R.styleable.TextAppearance_android_textColor);
            if (colorStateList != null) {
                this.mView.setTextColor(colorStateList);
            }
        }
        if (obtainStyledAttributes.hasValue(C0222R.styleable.TextAppearance_android_textSize) && obtainStyledAttributes.getDimensionPixelSize(C0222R.styleable.TextAppearance_android_textSize, -1) == 0) {
            this.mView.setTextSize(0, 0.0f);
        }
        updateTypefaceAndStyle(context, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        Typeface typeface = this.mFontTypeface;
        if (typeface != null) {
            this.mView.setTypeface(typeface, this.mStyle);
        }
    }

    void setAllCaps(boolean z) {
        this.mView.setAllCaps(z);
    }

    void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
    }

    void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
    }

    void setAutoSizeTextTypeWithDefaults(int i) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeWithDefaults(i);
    }

    void setTextSize(int i, float f) {
        if (!AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE && !isAutoSizeEnabled()) {
            setTextSizeInternal(i, f);
        }
    }
}
