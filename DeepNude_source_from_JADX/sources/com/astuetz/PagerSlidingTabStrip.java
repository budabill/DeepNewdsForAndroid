package com.astuetz;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import io.gonative.android.C0692W;
import io.gonative.android.azzpro.R;
import java.util.Locale;

public class PagerSlidingTabStrip extends HorizontalScrollView {
    /* renamed from: a */
    private static final int[] f353a = new int[]{16842901, 16842904, 16842966, 16842968, 16842806};
    /* renamed from: A */
    private int f354A;
    /* renamed from: B */
    private int f355B;
    /* renamed from: C */
    private boolean f356C;
    /* renamed from: D */
    private boolean f357D;
    /* renamed from: E */
    private boolean f358E;
    /* renamed from: F */
    private Typeface f359F;
    /* renamed from: G */
    private int f360G;
    /* renamed from: H */
    private int f361H;
    /* renamed from: I */
    private int f362I;
    /* renamed from: J */
    private int f363J;
    /* renamed from: K */
    private int f364K;
    /* renamed from: L */
    private Locale f365L;
    /* renamed from: M */
    private boolean f366M;
    /* renamed from: N */
    private OnGlobalLayoutListener f367N;
    /* renamed from: b */
    private C0320b f368b;
    /* renamed from: c */
    private final C0321d f369c;
    /* renamed from: d */
    private LayoutParams f370d;
    /* renamed from: e */
    private LayoutParams f371e;
    /* renamed from: f */
    private final C0815c f372f;
    /* renamed from: g */
    public OnPageChangeListener f373g;
    /* renamed from: h */
    private LinearLayout f374h;
    /* renamed from: i */
    private ViewPager f375i;
    /* renamed from: j */
    private int f376j;
    /* renamed from: k */
    private int f377k;
    /* renamed from: l */
    private float f378l;
    /* renamed from: m */
    private Paint f379m;
    /* renamed from: n */
    private Paint f380n;
    /* renamed from: o */
    private int f381o;
    /* renamed from: p */
    private int f382p;
    /* renamed from: q */
    private int f383q;
    /* renamed from: r */
    private int f384r;
    /* renamed from: s */
    private int f385s;
    /* renamed from: t */
    private int f386t;
    /* renamed from: u */
    private int f387u;
    /* renamed from: v */
    private int f388v;
    /* renamed from: w */
    private int f389w;
    /* renamed from: x */
    private ColorStateList f390x;
    /* renamed from: y */
    private float f391y;
    /* renamed from: z */
    private float f392z;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C0325d();
        /* renamed from: a */
        int f350a;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f350a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f350a);
        }
    }

    /* renamed from: com.astuetz.PagerSlidingTabStrip$a */
    public interface C0319a {
        /* renamed from: a */
        View m404a(ViewGroup viewGroup, int i);
    }

    /* renamed from: com.astuetz.PagerSlidingTabStrip$b */
    public interface C0320b {
        /* renamed from: a */
        void mo1412a(int i);
    }

    /* renamed from: com.astuetz.PagerSlidingTabStrip$d */
    private class C0321d extends DataSetObserver {
        /* renamed from: a */
        private boolean f351a;
        /* renamed from: b */
        final /* synthetic */ PagerSlidingTabStrip f352b;

        private C0321d(PagerSlidingTabStrip pagerSlidingTabStrip) {
            this.f352b = pagerSlidingTabStrip;
            this.f351a = false;
        }

        /* renamed from: a */
        public void m406a(boolean z) {
            this.f351a = z;
        }

        /* renamed from: a */
        public boolean m407a() {
            return this.f351a;
        }

        public void onChanged() {
            this.f352b.m436b();
        }
    }

    /* renamed from: com.astuetz.PagerSlidingTabStrip$c */
    private class C0815c implements OnPageChangeListener {
        /* renamed from: a */
        final /* synthetic */ PagerSlidingTabStrip f1732a;

        private C0815c(PagerSlidingTabStrip pagerSlidingTabStrip) {
            this.f1732a = pagerSlidingTabStrip;
        }

        public void onPageScrollStateChanged(int i) {
            this.f1732a.m424c();
            if (i == 0) {
                PagerSlidingTabStrip pagerSlidingTabStrip = this.f1732a;
                pagerSlidingTabStrip.m411a(pagerSlidingTabStrip.f375i.getCurrentItem(), 0);
            }
            this.f1732a.m420b(this.f1732a.f374h.getChildAt(this.f1732a.f375i.getCurrentItem()));
            if (this.f1732a.f375i.getCurrentItem() - 1 >= 0) {
                this.f1732a.m413a(this.f1732a.f374h.getChildAt(this.f1732a.f375i.getCurrentItem() - 1));
            }
            if (this.f1732a.f375i.getCurrentItem() + 1 <= this.f1732a.f375i.getAdapter().getCount() - 1) {
                this.f1732a.m413a(this.f1732a.f374h.getChildAt(this.f1732a.f375i.getCurrentItem() + 1));
            }
            OnPageChangeListener onPageChangeListener = this.f1732a.f373g;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i);
            }
        }

        public void onPageScrolled(int i, float f, int i2) {
            this.f1732a.f377k = i;
            this.f1732a.f378l = f;
            this.f1732a.m411a(i, this.f1732a.f376j > 0 ? (int) (((float) this.f1732a.f374h.getChildAt(i).getWidth()) * f) : 0);
            this.f1732a.invalidate();
            OnPageChangeListener onPageChangeListener = this.f1732a.f373g;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i, f, i2);
            }
        }

        public void onPageSelected(int i) {
            this.f1732a.m419b(i);
            OnPageChangeListener onPageChangeListener = this.f1732a.f373g;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageSelected(i);
            }
        }
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        super(context, attributeSet, i);
        this.f369c = new C0321d();
        this.f372f = new C0815c();
        this.f377k = 0;
        this.f378l = 0.0f;
        this.f382p = 2;
        this.f383q = 0;
        this.f385s = 0;
        this.f386t = 0;
        this.f388v = 12;
        this.f389w = 14;
        this.f390x = null;
        this.f391y = 0.5f;
        this.f392z = 1.0f;
        this.f354A = 0;
        this.f355B = 0;
        this.f356C = false;
        this.f357D = true;
        this.f358E = false;
        this.f359F = null;
        this.f360G = 1;
        this.f361H = 1;
        this.f363J = 0;
        this.f364K = R.drawable.background_tab;
        this.f366M = false;
        this.f367N = new C0324c(this);
        setFillViewport(true);
        setWillNotDraw(false);
        this.f374h = new LinearLayout(context2);
        this.f374h.setOrientation(0);
        this.f374h.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.f374h);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f362I = (int) TypedValue.applyDimension(1, (float) this.f362I, displayMetrics);
        this.f382p = (int) TypedValue.applyDimension(1, (float) this.f382p, displayMetrics);
        this.f383q = (int) TypedValue.applyDimension(1, (float) this.f383q, displayMetrics);
        this.f386t = (int) TypedValue.applyDimension(1, (float) this.f386t, displayMetrics);
        this.f388v = (int) TypedValue.applyDimension(1, (float) this.f388v, displayMetrics);
        this.f385s = (int) TypedValue.applyDimension(1, (float) this.f385s, displayMetrics);
        this.f389w = (int) TypedValue.applyDimension(2, (float) this.f389w, displayMetrics);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet2, f353a);
        this.f389w = obtainStyledAttributes.getDimensionPixelSize(0, this.f389w);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(1);
        int color = obtainStyledAttributes.getColor(4, 17170443);
        TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet2, C0692W.PagerSlidingTabStrip);
        color = obtainStyledAttributes2.getColor(3, color);
        obtainStyledAttributes2.recycle();
        if (colorStateList == null) {
            colorStateList = m410a(color);
        }
        r0.f390x = colorStateList;
        r0.f384r = color;
        r0.f387u = color;
        r0.f381o = color;
        r0.f354A = obtainStyledAttributes.getDimensionPixelSize(2, r0.f354A);
        r0.f355B = obtainStyledAttributes.getDimensionPixelSize(3, r0.f355B);
        obtainStyledAttributes.recycle();
        int i2 = r0.f355B;
        int i3 = r0.f354A;
        if (i2 < i3) {
            r0.f355B = i3;
        }
        i2 = r0.f354A;
        i3 = r0.f355B;
        if (i2 < i3) {
            r0.f354A = i3;
        }
        TypedArray obtainStyledAttributes3 = context2.obtainStyledAttributes(attributeSet2, C0692W.PagerSlidingTabStrip);
        r0.f381o = obtainStyledAttributes3.getColor(4, r0.f381o);
        r0.f384r = obtainStyledAttributes3.getColor(16, r0.f384r);
        r0.f387u = obtainStyledAttributes3.getColor(0, r0.f387u);
        r0.f385s = obtainStyledAttributes3.getDimensionPixelSize(2, r0.f385s);
        r0.f382p = obtainStyledAttributes3.getDimensionPixelSize(5, r0.f382p);
        r0.f383q = obtainStyledAttributes3.getDimensionPixelSize(17, r0.f383q);
        r0.f386t = obtainStyledAttributes3.getDimensionPixelSize(1, r0.f386t);
        r0.f388v = obtainStyledAttributes3.getDimensionPixelSize(10, r0.f388v);
        r0.f364K = obtainStyledAttributes3.getResourceId(9, r0.f364K);
        r0.f356C = obtainStyledAttributes3.getBoolean(8, r0.f356C);
        r0.f362I = obtainStyledAttributes3.getDimensionPixelSize(7, r0.f362I);
        r0.f357D = obtainStyledAttributes3.getBoolean(11, r0.f357D);
        r0.f358E = obtainStyledAttributes3.getBoolean(6, r0.f358E);
        r0.f360G = obtainStyledAttributes3.getInt(15, 1);
        r0.f361H = obtainStyledAttributes3.getInt(14, 1);
        r0.f391y = obtainStyledAttributes3.getFloat(12, 0.5f);
        r0.f392z = obtainStyledAttributes3.getFloat(13, 1.0f);
        obtainStyledAttributes3.recycle();
        r0.f379m = new Paint();
        r0.f379m.setAntiAlias(true);
        r0.f379m.setStyle(Style.FILL);
        r0.f380n = new Paint();
        r0.f380n.setAntiAlias(true);
        r0.f380n.setStrokeWidth((float) r0.f385s);
        r0.f370d = new LayoutParams(-2, -1);
        r0.f371e = new LayoutParams(0, -1, 1.0f);
        if (r0.f365L == null) {
            r0.f365L = getResources().getConfiguration().locale;
        }
    }

    /* renamed from: a */
    private ColorStateList m410a(int i) {
        return new ColorStateList(new int[][]{new int[0]}, new int[]{i});
    }

    /* renamed from: a */
    private void m411a(int i, int i2) {
        if (this.f376j != 0) {
            int left = this.f374h.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.f362I;
                Pair indicatorCoordinates = getIndicatorCoordinates();
                left = (int) (((float) left) + ((((Float) indicatorCoordinates.second).floatValue() - ((Float) indicatorCoordinates.first).floatValue()) / 2.0f));
            }
            if (left != this.f363J) {
                this.f363J = left;
                scrollTo(left, 0);
            }
        }
    }

    /* renamed from: a */
    private void m412a(int i, CharSequence charSequence, View view) {
        TextView textView = (TextView) view.findViewById(R.id.tab_title);
        if (textView != null) {
            if (charSequence != null) {
                textView.setText(charSequence);
            }
            ViewCompat.setAlpha(textView, this.f375i.getCurrentItem() == i ? this.f392z : this.f391y);
        }
        view.setFocusable(true);
        view.setOnClickListener(new C0323b(this, i));
        view.setPadding(this.f388v, view.getPaddingTop(), this.f388v, view.getPaddingBottom());
        this.f374h.addView(view, i, this.f356C ? this.f371e : this.f370d);
    }

    /* renamed from: a */
    private void m413a(View view) {
        TextView textView = (TextView) view.findViewById(R.id.tab_title);
        if (textView != null) {
            textView.setTypeface(this.f359F, this.f360G);
            ViewCompat.setAlpha(textView, this.f391y);
        }
    }

    /* renamed from: b */
    private void m419b(int i) {
        int i2 = 0;
        while (i2 < this.f376j) {
            View childAt = this.f374h.getChildAt(i2);
            childAt.setSelected(i2 == i);
            if (i2 == i) {
                m420b(childAt);
            } else {
                m413a(childAt);
            }
            i2++;
        }
    }

    /* renamed from: b */
    private void m420b(View view) {
        if (this.f366M) {
            m413a(view);
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.tab_title);
        if (textView != null) {
            textView.setTypeface(this.f359F, this.f361H);
            ViewCompat.setAlpha(textView, this.f392z);
        }
    }

    /* renamed from: c */
    private void m424c() {
        this.f366M = false;
        m427d();
        invalidate();
    }

    /* renamed from: d */
    private void m427d() {
        int i = 0;
        while (i < this.f376j) {
            View childAt = this.f374h.getChildAt(i);
            childAt.setBackgroundResource(this.f364K);
            TextView textView = (TextView) childAt.findViewById(R.id.tab_title);
            if (textView != null) {
                textView.setTextSize(0, (float) this.f389w);
                Object obj = (this.f366M || this.f375i.getCurrentItem() != i) ? null : 1;
                textView.setTypeface(this.f359F, obj != null ? this.f361H : this.f360G);
                ColorStateList colorStateList = this.f390x;
                if (colorStateList != null) {
                    textView.setTextColor(colorStateList);
                }
                if (this.f357D) {
                    if (VERSION.SDK_INT >= 14) {
                        textView.setAllCaps(true);
                    } else {
                        textView.setText(textView.getText().toString().toUpperCase(this.f365L));
                    }
                }
            }
            i++;
        }
    }

    private Pair<Float, Float> getIndicatorCoordinates() {
        View childAt = this.f374h.getChildAt(this.f377k);
        float left = (float) childAt.getLeft();
        float right = (float) childAt.getRight();
        if (this.f378l > 0.0f) {
            int i = this.f377k;
            if (i < this.f376j - 1) {
                View childAt2 = this.f374h.getChildAt(i + 1);
                float left2 = (float) childAt2.getLeft();
                float right2 = (float) childAt2.getRight();
                float f = this.f378l;
                left = (left2 * f) + ((1.0f - f) * left);
                right = (right2 * f) + ((1.0f - f) * right);
            }
        }
        return new Pair(Float.valueOf(left), Float.valueOf(right));
    }

    /* renamed from: a */
    public void m435a() {
        this.f366M = true;
        m427d();
        View childAt = this.f374h.getChildAt(this.f375i.getCurrentItem());
        if (childAt != null) {
            m413a(childAt);
        }
        invalidate();
    }

    /* renamed from: b */
    public void m436b() {
        this.f374h.removeAllViews();
        this.f376j = this.f375i.getAdapter().getCount();
        int i = 0;
        while (i < this.f376j) {
            m412a(i, this.f375i.getAdapter().getPageTitle(i), this.f375i.getAdapter() instanceof C0319a ? ((C0319a) this.f375i.getAdapter()).m404a(this, i) : LayoutInflater.from(getContext()).inflate(R.layout.tab, this, false));
            i++;
        }
        m427d();
        getViewTreeObserver().addOnGlobalLayoutListener(new C0322a(this));
    }

    public int getDividerColor() {
        return this.f387u;
    }

    public int getDividerPadding() {
        return this.f386t;
    }

    public int getDividerWidth() {
        return this.f385s;
    }

    public int getIndicatorColor() {
        return this.f381o;
    }

    public int getIndicatorHeight() {
        return this.f382p;
    }

    public int getScrollOffset() {
        return this.f362I;
    }

    public boolean getShouldExpand() {
        return this.f356C;
    }

    public int getTabBackground() {
        return this.f364K;
    }

    public int getTabPaddingLeftRight() {
        return this.f388v;
    }

    public ColorStateList getTextColor() {
        return this.f390x;
    }

    public int getTextSize() {
        return this.f389w;
    }

    public int getUnderlineColor() {
        return this.f384r;
    }

    public int getUnderlineHeight() {
        return this.f383q;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f375i != null && !this.f369c.m407a()) {
            this.f375i.getAdapter().registerDataSetObserver(this.f369c);
            this.f369c.m406a(true);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f375i != null && this.f369c.m407a()) {
            this.f375i.getAdapter().unregisterDataSetObserver(this.f369c);
            this.f369c.m406a(false);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode()) {
            if (this.f376j != 0) {
                int height = getHeight();
                if (!this.f366M) {
                    this.f379m.setColor(this.f381o);
                    Pair indicatorCoordinates = getIndicatorCoordinates();
                    canvas.drawRect(((Float) indicatorCoordinates.first).floatValue() + ((float) this.f354A), (float) (height - this.f382p), ((Float) indicatorCoordinates.second).floatValue() + ((float) this.f355B), (float) height, this.f379m);
                }
                this.f379m.setColor(this.f384r);
                canvas.drawRect((float) this.f354A, (float) (height - this.f383q), (float) (this.f374h.getWidth() + this.f355B), (float) height, this.f379m);
                int i = this.f385s;
                if (i != 0) {
                    this.f380n.setStrokeWidth((float) i);
                    this.f380n.setColor(this.f387u);
                    for (i = 0; i < this.f376j - 1; i++) {
                        View childAt = this.f374h.getChildAt(i);
                        canvas.drawLine((float) childAt.getRight(), (float) this.f386t, (float) childAt.getRight(), (float) (height - this.f386t), this.f380n);
                    }
                }
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f358E && this.f374h.getChildCount() > 0) {
            int width = (getWidth() / 2) - (this.f374h.getChildAt(0).getMeasuredWidth() / 2);
            this.f355B = width;
            this.f354A = width;
        }
        if (this.f358E || this.f354A > 0 || this.f355B > 0) {
            this.f374h.setMinimumWidth(this.f358E ? getWidth() : (getWidth() - this.f354A) - this.f355B);
            setClipToPadding(false);
        }
        setPadding(this.f354A, getPaddingTop(), this.f355B, getPaddingBottom());
        if (this.f362I == 0) {
            this.f362I = (getWidth() / 2) - this.f354A;
        }
        ViewPager viewPager = this.f375i;
        if (viewPager != null) {
            this.f377k = viewPager.getCurrentItem();
        }
        this.f378l = 0.0f;
        m411a(this.f377k, 0);
        m419b(this.f377k);
        super.onLayout(z, i, i2, i3, i4);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f377k = savedState.f350a;
        if (this.f377k != 0 && this.f374h.getChildCount() > 0) {
            m413a(this.f374h.getChildAt(0));
            m420b(this.f374h.getChildAt(this.f377k));
        }
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f350a = this.f377k;
        return savedState;
    }

    public void setAllCaps(boolean z) {
        this.f357D = z;
    }

    public void setDividerColor(int i) {
        this.f387u = i;
        invalidate();
    }

    public void setDividerColorResource(int i) {
        this.f387u = getResources().getColor(i);
        invalidate();
    }

    public void setDividerPadding(int i) {
        this.f386t = i;
        invalidate();
    }

    public void setDividerWidth(int i) {
        this.f385s = i;
        invalidate();
    }

    public void setIndicatorColor(int i) {
        this.f381o = i;
        invalidate();
    }

    public void setIndicatorColorResource(int i) {
        this.f381o = getResources().getColor(i);
        invalidate();
    }

    public void setIndicatorHeight(int i) {
        this.f382p = i;
        invalidate();
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.f373g = onPageChangeListener;
    }

    public void setScrollOffset(int i) {
        this.f362I = i;
        invalidate();
    }

    public void setShouldExpand(boolean z) {
        this.f356C = z;
        if (this.f375i != null) {
            requestLayout();
        }
    }

    public void setTabBackground(int i) {
        this.f364K = i;
    }

    public void setTabClickListener(C0320b c0320b) {
        this.f368b = c0320b;
    }

    public void setTabPaddingLeftRight(int i) {
        this.f388v = i;
        m427d();
    }

    public void setTextColor(int i) {
        setTextColor(m410a(i));
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f390x = colorStateList;
        m427d();
    }

    public void setTextColorResource(int i) {
        setTextColor(getResources().getColor(i));
    }

    public void setTextColorStateListResource(int i) {
        setTextColor(getResources().getColorStateList(i));
    }

    public void setTextSize(int i) {
        this.f389w = i;
        m427d();
    }

    public void setUnderlineColor(int i) {
        this.f384r = i;
        invalidate();
    }

    public void setUnderlineColorResource(int i) {
        this.f384r = getResources().getColor(i);
        invalidate();
    }

    public void setUnderlineHeight(int i) {
        this.f383q = i;
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.f375i = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.f372f);
            viewPager.getAdapter().registerDataSetObserver(this.f369c);
            this.f369c.m406a(true);
            m436b();
            return;
        }
        throw new IllegalStateException("ViewPager does not have adapter instance.");
    }
}
