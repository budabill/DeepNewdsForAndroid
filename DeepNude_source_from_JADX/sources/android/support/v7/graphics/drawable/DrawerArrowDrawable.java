package android.support.v7.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.C0222R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class DrawerArrowDrawable extends Drawable {
    public static final int ARROW_DIRECTION_END = 3;
    public static final int ARROW_DIRECTION_LEFT = 0;
    public static final int ARROW_DIRECTION_RIGHT = 1;
    public static final int ARROW_DIRECTION_START = 2;
    private static final float ARROW_HEAD_ANGLE = ((float) Math.toRadians(45.0d));
    private float mArrowHeadLength;
    private float mArrowShaftLength;
    private float mBarGap;
    private float mBarLength;
    private int mDirection = 2;
    private float mMaxCutForBarSize;
    private final Paint mPaint = new Paint();
    private final Path mPath = new Path();
    private float mProgress;
    private final int mSize;
    private boolean mSpin;
    private boolean mVerticalMirror = false;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ArrowDirection {
    }

    public DrawerArrowDrawable(Context context) {
        this.mPaint.setStyle(Style.STROKE);
        this.mPaint.setStrokeJoin(Join.MITER);
        this.mPaint.setStrokeCap(Cap.BUTT);
        this.mPaint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, C0222R.styleable.DrawerArrowToggle, C0222R.attr.drawerArrowStyle, C0222R.style.Base_Widget_AppCompat_DrawerArrowToggle);
        setColor(obtainStyledAttributes.getColor(C0222R.styleable.DrawerArrowToggle_color, 0));
        setBarThickness(obtainStyledAttributes.getDimension(C0222R.styleable.DrawerArrowToggle_thickness, 0.0f));
        setSpinEnabled(obtainStyledAttributes.getBoolean(C0222R.styleable.DrawerArrowToggle_spinBars, true));
        setGapSize((float) Math.round(obtainStyledAttributes.getDimension(C0222R.styleable.DrawerArrowToggle_gapBetweenBars, 0.0f)));
        this.mSize = obtainStyledAttributes.getDimensionPixelSize(C0222R.styleable.DrawerArrowToggle_drawableSize, 0);
        this.mBarLength = (float) Math.round(obtainStyledAttributes.getDimension(C0222R.styleable.DrawerArrowToggle_barLength, 0.0f));
        this.mArrowHeadLength = (float) Math.round(obtainStyledAttributes.getDimension(C0222R.styleable.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.mArrowShaftLength = obtainStyledAttributes.getDimension(C0222R.styleable.DrawerArrowToggle_arrowShaftLength, 0.0f);
        obtainStyledAttributes.recycle();
    }

    private static float lerp(float f, float f2, float f3) {
        return f + ((f2 - f) * f3);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r19) {
        /*
        r18 = this;
        r0 = r18;
        r1 = r19;
        r2 = r18.getBounds();
        r3 = r0.mDirection;
        r4 = 0;
        r5 = 1;
        if (r3 == 0) goto L_0x0021;
    L_0x000e:
        if (r3 == r5) goto L_0x0020;
    L_0x0010:
        r6 = 3;
        if (r3 == r6) goto L_0x001a;
    L_0x0013:
        r3 = android.support.v4.graphics.drawable.DrawableCompat.getLayoutDirection(r18);
        if (r3 != r5) goto L_0x0021;
    L_0x0019:
        goto L_0x0020;
    L_0x001a:
        r3 = android.support.v4.graphics.drawable.DrawableCompat.getLayoutDirection(r18);
        if (r3 != 0) goto L_0x0021;
    L_0x0020:
        r4 = 1;
    L_0x0021:
        r3 = r0.mArrowHeadLength;
        r3 = r3 * r3;
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r3 = r3 * r6;
        r7 = (double) r3;
        r7 = java.lang.Math.sqrt(r7);
        r3 = (float) r7;
        r7 = r0.mBarLength;
        r8 = r0.mProgress;
        r3 = lerp(r7, r3, r8);
        r7 = r0.mBarLength;
        r8 = r0.mArrowShaftLength;
        r9 = r0.mProgress;
        r7 = lerp(r7, r8, r9);
        r8 = r0.mMaxCutForBarSize;
        r9 = r0.mProgress;
        r10 = 0;
        r8 = lerp(r10, r8, r9);
        r8 = java.lang.Math.round(r8);
        r8 = (float) r8;
        r9 = ARROW_HEAD_ANGLE;
        r11 = r0.mProgress;
        r9 = lerp(r10, r9, r11);
        if (r4 == 0) goto L_0x005b;
    L_0x0059:
        r11 = 0;
        goto L_0x005d;
    L_0x005b:
        r11 = -1020002304; // 0xffffffffc3340000 float:-180.0 double:NaN;
    L_0x005d:
        r12 = 1127481344; // 0x43340000 float:180.0 double:5.570497984E-315;
        if (r4 == 0) goto L_0x0064;
    L_0x0061:
        r13 = 1127481344; // 0x43340000 float:180.0 double:5.570497984E-315;
        goto L_0x0065;
    L_0x0064:
        r13 = 0;
    L_0x0065:
        r14 = r0.mProgress;
        r11 = lerp(r11, r13, r14);
        r13 = (double) r3;
        r15 = r11;
        r10 = (double) r9;
        r16 = java.lang.Math.cos(r10);
        java.lang.Double.isNaN(r13);
        r16 = r16 * r13;
        r9 = r4;
        r3 = java.lang.Math.round(r16);
        r3 = (float) r3;
        r10 = java.lang.Math.sin(r10);
        java.lang.Double.isNaN(r13);
        r13 = r13 * r10;
        r10 = java.lang.Math.round(r13);
        r4 = (float) r10;
        r10 = r0.mPath;
        r10.rewind();
        r10 = r0.mBarGap;
        r11 = r0.mPaint;
        r11 = r11.getStrokeWidth();
        r10 = r10 + r11;
        r11 = r0.mMaxCutForBarSize;
        r11 = -r11;
        r13 = r0.mProgress;
        r10 = lerp(r10, r11, r13);
        r11 = -r7;
        r11 = r11 / r6;
        r13 = r0.mPath;
        r14 = r11 + r8;
        r5 = 0;
        r13.moveTo(r14, r5);
        r13 = r0.mPath;
        r8 = r8 * r6;
        r7 = r7 - r8;
        r13.rLineTo(r7, r5);
        r5 = r0.mPath;
        r5.moveTo(r11, r10);
        r5 = r0.mPath;
        r5.rLineTo(r3, r4);
        r5 = r0.mPath;
        r7 = -r10;
        r5.moveTo(r11, r7);
        r5 = r0.mPath;
        r4 = -r4;
        r5.rLineTo(r3, r4);
        r3 = r0.mPath;
        r3.close();
        r19.save();
        r3 = r0.mPaint;
        r3 = r3.getStrokeWidth();
        r4 = r2.height();
        r4 = (float) r4;
        r5 = 1077936128; // 0x40400000 float:3.0 double:5.325712093E-315;
        r5 = r5 * r3;
        r4 = r4 - r5;
        r5 = r0.mBarGap;
        r6 = r6 * r5;
        r4 = r4 - r6;
        r4 = (int) r4;
        r4 = r4 / 4;
        r4 = r4 * 2;
        r4 = (float) r4;
        r6 = 1069547520; // 0x3fc00000 float:1.5 double:5.28426686E-315;
        r3 = r3 * r6;
        r3 = r3 + r5;
        r4 = r4 + r3;
        r2 = r2.centerX();
        r2 = (float) r2;
        r1.translate(r2, r4);
        r2 = r0.mSpin;
        if (r2 == 0) goto L_0x010e;
    L_0x00ff:
        r2 = r0.mVerticalMirror;
        r2 = r2 ^ r9;
        if (r2 == 0) goto L_0x0106;
    L_0x0104:
        r5 = -1;
        goto L_0x0107;
    L_0x0106:
        r5 = 1;
    L_0x0107:
        r2 = (float) r5;
        r11 = r15 * r2;
        r1.rotate(r11);
        goto L_0x0113;
    L_0x010e:
        if (r9 == 0) goto L_0x0113;
    L_0x0110:
        r1.rotate(r12);
    L_0x0113:
        r2 = r0.mPath;
        r3 = r0.mPaint;
        r1.drawPath(r2, r3);
        r19.restore();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.graphics.drawable.DrawerArrowDrawable.draw(android.graphics.Canvas):void");
    }

    public float getArrowHeadLength() {
        return this.mArrowHeadLength;
    }

    public float getArrowShaftLength() {
        return this.mArrowShaftLength;
    }

    public float getBarLength() {
        return this.mBarLength;
    }

    public float getBarThickness() {
        return this.mPaint.getStrokeWidth();
    }

    public int getColor() {
        return this.mPaint.getColor();
    }

    public int getDirection() {
        return this.mDirection;
    }

    public float getGapSize() {
        return this.mBarGap;
    }

    public int getIntrinsicHeight() {
        return this.mSize;
    }

    public int getIntrinsicWidth() {
        return this.mSize;
    }

    public int getOpacity() {
        return -3;
    }

    public final Paint getPaint() {
        return this.mPaint;
    }

    public float getProgress() {
        return this.mProgress;
    }

    public boolean isSpinEnabled() {
        return this.mSpin;
    }

    public void setAlpha(int i) {
        if (i != this.mPaint.getAlpha()) {
            this.mPaint.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setArrowHeadLength(float f) {
        if (this.mArrowHeadLength != f) {
            this.mArrowHeadLength = f;
            invalidateSelf();
        }
    }

    public void setArrowShaftLength(float f) {
        if (this.mArrowShaftLength != f) {
            this.mArrowShaftLength = f;
            invalidateSelf();
        }
    }

    public void setBarLength(float f) {
        if (this.mBarLength != f) {
            this.mBarLength = f;
            invalidateSelf();
        }
    }

    public void setBarThickness(float f) {
        if (this.mPaint.getStrokeWidth() != f) {
            this.mPaint.setStrokeWidth(f);
            double d = (double) (f / 2.0f);
            double cos = Math.cos((double) ARROW_HEAD_ANGLE);
            Double.isNaN(d);
            this.mMaxCutForBarSize = (float) (d * cos);
            invalidateSelf();
        }
    }

    public void setColor(int i) {
        if (i != this.mPaint.getColor()) {
            this.mPaint.setColor(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setDirection(int i) {
        if (i != this.mDirection) {
            this.mDirection = i;
            invalidateSelf();
        }
    }

    public void setGapSize(float f) {
        if (f != this.mBarGap) {
            this.mBarGap = f;
            invalidateSelf();
        }
    }

    public void setProgress(float f) {
        if (this.mProgress != f) {
            this.mProgress = f;
            invalidateSelf();
        }
    }

    public void setSpinEnabled(boolean z) {
        if (this.mSpin != z) {
            this.mSpin = z;
            invalidateSelf();
        }
    }

    public void setVerticalMirror(boolean z) {
        if (this.mVerticalMirror != z) {
            this.mVerticalMirror = z;
            invalidateSelf();
        }
    }
}
