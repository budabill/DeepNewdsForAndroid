package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.C0562R;
import com.google.android.gms.common.util.zzj;

public final class zzby extends Button {
    public zzby(Context context) {
        this(context, null);
    }

    private zzby(Context context, AttributeSet attributeSet) {
        super(context, null, 16842824);
    }

    private static int zzf(int i, int i2, int i3, int i4) {
        if (i == 0) {
            return i2;
        }
        if (i == 1) {
            return i3;
        }
        if (i == 2) {
            return i4;
        }
        StringBuilder stringBuilder = new StringBuilder(33);
        stringBuilder.append("Unknown color scheme: ");
        stringBuilder.append(i);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final void zza(Resources resources, int i, int i2) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        int i3 = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
        setMinHeight(i3);
        setMinWidth(i3);
        i3 = C0562R.drawable.common_google_signin_btn_icon_dark;
        int i4 = C0562R.drawable.common_google_signin_btn_icon_light;
        i3 = zzf(i2, i3, i4, i4);
        i4 = C0562R.drawable.common_google_signin_btn_text_dark;
        int i5 = C0562R.drawable.common_google_signin_btn_text_light;
        i4 = zzf(i2, i4, i5, i5);
        String str = "Unknown button size: ";
        if (i == 0 || i == 1) {
            i3 = i4;
        } else if (i != 2) {
            StringBuilder stringBuilder = new StringBuilder(32);
            stringBuilder.append(str);
            stringBuilder.append(i);
            throw new IllegalStateException(stringBuilder.toString());
        }
        Drawable wrap = DrawableCompat.wrap(resources.getDrawable(i3));
        DrawableCompat.setTintList(wrap, resources.getColorStateList(C0562R.color.common_google_signin_btn_tint));
        DrawableCompat.setTintMode(wrap, Mode.SRC_ATOP);
        setBackgroundDrawable(wrap);
        i3 = C0562R.color.common_google_signin_btn_text_dark;
        i4 = C0562R.color.common_google_signin_btn_text_light;
        ColorStateList colorStateList = resources.getColorStateList(zzf(i2, i3, i4, i4));
        zzbq.checkNotNull(colorStateList);
        setTextColor(colorStateList);
        if (i == 0) {
            i = C0562R.string.common_signin_button_text;
        } else if (i == 1) {
            i = C0562R.string.common_signin_button_text_long;
        } else if (i == 2) {
            setText(null);
            setTransformationMethod(null);
            if (zzj.zzcu(getContext())) {
                setGravity(19);
            }
        } else {
            stringBuilder = new StringBuilder(32);
            stringBuilder.append(str);
            stringBuilder.append(i);
            throw new IllegalStateException(stringBuilder.toString());
        }
        setText(resources.getString(i));
        setTransformationMethod(null);
        if (zzj.zzcu(getContext())) {
            setGravity(19);
        }
    }
}
