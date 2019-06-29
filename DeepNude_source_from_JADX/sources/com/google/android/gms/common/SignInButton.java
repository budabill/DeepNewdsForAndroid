package com.google.android.gms.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.C0562R;
import com.google.android.gms.common.api.Scope;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class SignInButton extends FrameLayout implements OnClickListener {
    public static final int COLOR_AUTO = 2;
    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;
    private int mColor;
    private int mSize;
    private View zzfry;
    private OnClickListener zzfrz;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ButtonSize {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorScheme {
    }

    public SignInButton(Context context) {
        this(context, null);
    }

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignInButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzfrz = null;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C0562R.styleable.SignInButton, 0, 0);
        try {
            this.mSize = obtainStyledAttributes.getInt(C0562R.styleable.SignInButton_buttonSize, 0);
            this.mColor = obtainStyledAttributes.getInt(C0562R.styleable.SignInButton_colorScheme, 2);
            setStyle(this.mSize, this.mColor);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final void onClick(View view) {
        OnClickListener onClickListener = this.zzfrz;
        if (onClickListener != null && view == this.zzfry) {
            onClickListener.onClick(this);
        }
    }

    public final void setColorScheme(int i) {
        setStyle(this.mSize, i);
    }

    public final void setEnabled(boolean z) {
        super.setEnabled(z);
        this.zzfry.setEnabled(z);
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.zzfrz = onClickListener;
        View view = this.zzfry;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    @Deprecated
    public final void setScopes(Scope[] scopeArr) {
        setStyle(this.mSize, this.mColor);
    }

    public final void setSize(int i) {
        setStyle(i, this.mColor);
    }

    public final void setStyle(int r3, int r4) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r2 = this;
        r2.mSize = r3;
        r2.mColor = r4;
        r3 = r2.getContext();
        r4 = r2.zzfry;
        if (r4 == 0) goto L_0x000f;
    L_0x000c:
        r2.removeView(r4);
    L_0x000f:
        r4 = r2.mSize;	 Catch:{ zzq -> 0x001a }
        r0 = r2.mColor;	 Catch:{ zzq -> 0x001a }
        r4 = com.google.android.gms.common.internal.zzbx.zzc(r3, r4, r0);	 Catch:{ zzq -> 0x001a }
        r2.zzfry = r4;	 Catch:{ zzq -> 0x001a }
        goto L_0x0033;
    L_0x001a:
        r4 = "SignInButton";
        r0 = "Sign in button not found, using placeholder instead";
        android.util.Log.w(r4, r0);
        r4 = r2.mSize;
        r0 = r2.mColor;
        r1 = new com.google.android.gms.common.internal.zzby;
        r1.<init>(r3);
        r3 = r3.getResources();
        r1.zza(r3, r4, r0);
        r2.zzfry = r1;
    L_0x0033:
        r3 = r2.zzfry;
        r2.addView(r3);
        r3 = r2.zzfry;
        r4 = r2.isEnabled();
        r3.setEnabled(r4);
        r3 = r2.zzfry;
        r3.setOnClickListener(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.SignInButton.setStyle(int, int):void");
    }

    @Deprecated
    public final void setStyle(int i, int i2, Scope[] scopeArr) {
        setStyle(i, i2);
    }
}
