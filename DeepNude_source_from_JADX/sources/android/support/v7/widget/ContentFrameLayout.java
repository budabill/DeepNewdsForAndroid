package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class ContentFrameLayout extends FrameLayout {
    private OnAttachListener mAttachListener;
    private final Rect mDecorPadding;
    private TypedValue mFixedHeightMajor;
    private TypedValue mFixedHeightMinor;
    private TypedValue mFixedWidthMajor;
    private TypedValue mFixedWidthMinor;
    private TypedValue mMinWidthMajor;
    private TypedValue mMinWidthMinor;

    public interface OnAttachListener {
        void onAttachedFromWindow();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDecorPadding = new Rect();
    }

    public void dispatchFitSystemWindows(Rect rect) {
        fitSystemWindows(rect);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.mFixedHeightMajor == null) {
            this.mFixedHeightMajor = new TypedValue();
        }
        return this.mFixedHeightMajor;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.mFixedHeightMinor == null) {
            this.mFixedHeightMinor = new TypedValue();
        }
        return this.mFixedHeightMinor;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.mFixedWidthMajor == null) {
            this.mFixedWidthMajor = new TypedValue();
        }
        return this.mFixedWidthMajor;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.mFixedWidthMinor == null) {
            this.mFixedWidthMinor = new TypedValue();
        }
        return this.mFixedWidthMinor;
    }

    public TypedValue getMinWidthMajor() {
        if (this.mMinWidthMajor == null) {
            this.mMinWidthMajor = new TypedValue();
        }
        return this.mMinWidthMajor;
    }

    public TypedValue getMinWidthMinor() {
        if (this.mMinWidthMinor == null) {
            this.mMinWidthMinor = new TypedValue();
        }
        return this.mMinWidthMinor;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        OnAttachListener onAttachListener = this.mAttachListener;
        if (onAttachListener != null) {
            onAttachListener.onAttachedFromWindow();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OnAttachListener onAttachListener = this.mAttachListener;
        if (onAttachListener != null) {
            onAttachListener.onDetachedFromWindow();
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        Rect rect;
        Object obj;
        TypedValue typedValue;
        float dimension;
        TypedValue typedValue2;
        int i5;
        float dimension2;
        int i6;
        Rect rect2;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        Object obj2 = 1;
        Object obj3 = displayMetrics.widthPixels < displayMetrics.heightPixels ? 1 : null;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            TypedValue typedValue3 = obj3 != null ? this.mFixedWidthMinor : this.mFixedWidthMajor;
            if (typedValue3 != null) {
                i3 = typedValue3.type;
                if (i3 != 0) {
                    float dimension3;
                    if (i3 == 5) {
                        dimension3 = typedValue3.getDimension(displayMetrics);
                    } else if (i3 == 6) {
                        i3 = displayMetrics.widthPixels;
                        dimension3 = typedValue3.getFraction((float) i3, (float) i3);
                    } else {
                        i4 = 0;
                        if (i4 > 0) {
                            rect = this.mDecorPadding;
                            i4 = MeasureSpec.makeMeasureSpec(Math.min(i4 - (rect.left + rect.right), MeasureSpec.getSize(i)), 1073741824);
                            obj = 1;
                            if (mode2 == Integer.MIN_VALUE) {
                                typedValue = obj3 != null ? this.mFixedHeightMajor : this.mFixedHeightMinor;
                                if (typedValue != null) {
                                    i3 = typedValue.type;
                                    if (i3 != 0) {
                                        if (i3 != 5) {
                                            dimension = typedValue.getDimension(displayMetrics);
                                        } else if (i3 == 6) {
                                            i3 = displayMetrics.heightPixels;
                                            dimension = typedValue.getFraction((float) i3, (float) i3);
                                        } else {
                                            mode2 = 0;
                                            if (mode2 > 0) {
                                                rect = this.mDecorPadding;
                                                i2 = MeasureSpec.makeMeasureSpec(Math.min(mode2 - (rect.top + rect.bottom), MeasureSpec.getSize(i2)), 1073741824);
                                            }
                                        }
                                        mode2 = (int) dimension;
                                        if (mode2 > 0) {
                                            rect = this.mDecorPadding;
                                            i2 = MeasureSpec.makeMeasureSpec(Math.min(mode2 - (rect.top + rect.bottom), MeasureSpec.getSize(i2)), 1073741824);
                                        }
                                    }
                                }
                            }
                            super.onMeasure(i4, i2);
                            mode2 = getMeasuredWidth();
                            i4 = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                            if (obj == null && mode == Integer.MIN_VALUE) {
                                typedValue2 = obj3 != null ? this.mMinWidthMinor : this.mMinWidthMajor;
                                if (typedValue2 != null) {
                                    i5 = typedValue2.type;
                                    if (i5 != 0) {
                                        if (i5 != 5) {
                                            dimension2 = typedValue2.getDimension(displayMetrics);
                                        } else if (i5 == 6) {
                                            i6 = displayMetrics.widthPixels;
                                            dimension2 = typedValue2.getFraction((float) i6, (float) i6);
                                        } else {
                                            i = 0;
                                            if (i > 0) {
                                                rect2 = this.mDecorPadding;
                                                i -= rect2.left + rect2.right;
                                            }
                                            if (mode2 < i) {
                                                i4 = MeasureSpec.makeMeasureSpec(i, 1073741824);
                                                if (obj2 != null) {
                                                    super.onMeasure(i4, i2);
                                                }
                                            }
                                        }
                                        i = (int) dimension2;
                                        if (i > 0) {
                                            rect2 = this.mDecorPadding;
                                            i -= rect2.left + rect2.right;
                                        }
                                        if (mode2 < i) {
                                            i4 = MeasureSpec.makeMeasureSpec(i, 1073741824);
                                            if (obj2 != null) {
                                                super.onMeasure(i4, i2);
                                            }
                                        }
                                    }
                                }
                            }
                            obj2 = null;
                            if (obj2 != null) {
                                super.onMeasure(i4, i2);
                            }
                        }
                    }
                    i4 = (int) dimension3;
                    if (i4 > 0) {
                        rect = this.mDecorPadding;
                        i4 = MeasureSpec.makeMeasureSpec(Math.min(i4 - (rect.left + rect.right), MeasureSpec.getSize(i)), 1073741824);
                        obj = 1;
                        if (mode2 == Integer.MIN_VALUE) {
                            if (obj3 != null) {
                            }
                            if (typedValue != null) {
                                i3 = typedValue.type;
                                if (i3 != 0) {
                                    if (i3 != 5) {
                                        dimension = typedValue.getDimension(displayMetrics);
                                    } else if (i3 == 6) {
                                        mode2 = 0;
                                        if (mode2 > 0) {
                                            rect = this.mDecorPadding;
                                            i2 = MeasureSpec.makeMeasureSpec(Math.min(mode2 - (rect.top + rect.bottom), MeasureSpec.getSize(i2)), 1073741824);
                                        }
                                    } else {
                                        i3 = displayMetrics.heightPixels;
                                        dimension = typedValue.getFraction((float) i3, (float) i3);
                                    }
                                    mode2 = (int) dimension;
                                    if (mode2 > 0) {
                                        rect = this.mDecorPadding;
                                        i2 = MeasureSpec.makeMeasureSpec(Math.min(mode2 - (rect.top + rect.bottom), MeasureSpec.getSize(i2)), 1073741824);
                                    }
                                }
                            }
                        }
                        super.onMeasure(i4, i2);
                        mode2 = getMeasuredWidth();
                        i4 = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                        if (obj3 != null) {
                        }
                        if (typedValue2 != null) {
                            i5 = typedValue2.type;
                            if (i5 != 0) {
                                if (i5 != 5) {
                                    dimension2 = typedValue2.getDimension(displayMetrics);
                                } else if (i5 == 6) {
                                    i = 0;
                                    if (i > 0) {
                                        rect2 = this.mDecorPadding;
                                        i -= rect2.left + rect2.right;
                                    }
                                    if (mode2 < i) {
                                        i4 = MeasureSpec.makeMeasureSpec(i, 1073741824);
                                        if (obj2 != null) {
                                            super.onMeasure(i4, i2);
                                        }
                                    }
                                } else {
                                    i6 = displayMetrics.widthPixels;
                                    dimension2 = typedValue2.getFraction((float) i6, (float) i6);
                                }
                                i = (int) dimension2;
                                if (i > 0) {
                                    rect2 = this.mDecorPadding;
                                    i -= rect2.left + rect2.right;
                                }
                                if (mode2 < i) {
                                    i4 = MeasureSpec.makeMeasureSpec(i, 1073741824);
                                    if (obj2 != null) {
                                        super.onMeasure(i4, i2);
                                    }
                                }
                            }
                        }
                        obj2 = null;
                        if (obj2 != null) {
                            super.onMeasure(i4, i2);
                        }
                    }
                }
            }
        }
        i4 = i;
        obj = null;
        if (mode2 == Integer.MIN_VALUE) {
            if (obj3 != null) {
            }
            if (typedValue != null) {
                i3 = typedValue.type;
                if (i3 != 0) {
                    if (i3 != 5) {
                        dimension = typedValue.getDimension(displayMetrics);
                    } else if (i3 == 6) {
                        i3 = displayMetrics.heightPixels;
                        dimension = typedValue.getFraction((float) i3, (float) i3);
                    } else {
                        mode2 = 0;
                        if (mode2 > 0) {
                            rect = this.mDecorPadding;
                            i2 = MeasureSpec.makeMeasureSpec(Math.min(mode2 - (rect.top + rect.bottom), MeasureSpec.getSize(i2)), 1073741824);
                        }
                    }
                    mode2 = (int) dimension;
                    if (mode2 > 0) {
                        rect = this.mDecorPadding;
                        i2 = MeasureSpec.makeMeasureSpec(Math.min(mode2 - (rect.top + rect.bottom), MeasureSpec.getSize(i2)), 1073741824);
                    }
                }
            }
        }
        super.onMeasure(i4, i2);
        mode2 = getMeasuredWidth();
        i4 = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
        if (obj3 != null) {
        }
        if (typedValue2 != null) {
            i5 = typedValue2.type;
            if (i5 != 0) {
                if (i5 != 5) {
                    dimension2 = typedValue2.getDimension(displayMetrics);
                } else if (i5 == 6) {
                    i6 = displayMetrics.widthPixels;
                    dimension2 = typedValue2.getFraction((float) i6, (float) i6);
                } else {
                    i = 0;
                    if (i > 0) {
                        rect2 = this.mDecorPadding;
                        i -= rect2.left + rect2.right;
                    }
                    if (mode2 < i) {
                        i4 = MeasureSpec.makeMeasureSpec(i, 1073741824);
                        if (obj2 != null) {
                            super.onMeasure(i4, i2);
                        }
                    }
                }
                i = (int) dimension2;
                if (i > 0) {
                    rect2 = this.mDecorPadding;
                    i -= rect2.left + rect2.right;
                }
                if (mode2 < i) {
                    i4 = MeasureSpec.makeMeasureSpec(i, 1073741824);
                    if (obj2 != null) {
                        super.onMeasure(i4, i2);
                    }
                }
            }
        }
        obj2 = null;
        if (obj2 != null) {
            super.onMeasure(i4, i2);
        }
    }

    public void setAttachListener(OnAttachListener onAttachListener) {
        this.mAttachListener = onAttachListener;
    }

    public void setDecorPadding(int i, int i2, int i3, int i4) {
        this.mDecorPadding.set(i, i2, i3, i4);
        if (ViewCompat.isLaidOut(this)) {
            requestLayout();
        }
    }
}
