package p000a.p005b.p008c.p009a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: a.b.c.a.d */
public class C0891d extends C0743i implements C0031b {
    /* renamed from: b */
    private C0033a f1897b;
    /* renamed from: c */
    private Context f1898c;
    /* renamed from: d */
    private ArgbEvaluator f1899d;
    /* renamed from: e */
    private AnimatorListener f1900e;
    /* renamed from: f */
    ArrayList<Object> f1901f;
    /* renamed from: g */
    final Callback f1902g;

    /* renamed from: a.b.c.a.d$a */
    private static class C0033a extends ConstantState {
        /* renamed from: a */
        int f50a;
        /* renamed from: b */
        C0894k f51b;
        /* renamed from: c */
        AnimatorSet f52c;
        /* renamed from: d */
        ArrayList<Animator> f53d;
        /* renamed from: e */
        ArrayMap<Animator, String> f54e;

        public C0033a(Context context, C0033a c0033a, Callback callback, Resources resources) {
            if (c0033a != null) {
                this.f50a = c0033a.f50a;
                C0894k c0894k = c0033a.f51b;
                int i = 0;
                if (c0894k != null) {
                    ConstantState constantState = c0894k.getConstantState();
                    this.f51b = (C0894k) (resources != null ? constantState.newDrawable(resources) : constantState.newDrawable());
                    c0894k = this.f51b;
                    c0894k.mutate();
                    this.f51b = c0894k;
                    this.f51b.setCallback(callback);
                    this.f51b.setBounds(c0033a.f51b.getBounds());
                    this.f51b.m2419a(false);
                }
                ArrayList arrayList = c0033a.f53d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f53d = new ArrayList(size);
                    this.f54e = new ArrayMap(size);
                    while (i < size) {
                        Animator animator = (Animator) c0033a.f53d.get(i);
                        Animator clone = animator.clone();
                        String str = (String) c0033a.f54e.get(animator);
                        clone.setTarget(this.f51b.m2418a(str));
                        this.f53d.add(clone);
                        this.f54e.put(clone, str);
                        i++;
                    }
                    m33a();
                }
            }
        }

        /* renamed from: a */
        public void m33a() {
            if (this.f52c == null) {
                this.f52c = new AnimatorSet();
            }
            this.f52c.playTogether(this.f53d);
        }

        public int getChangingConfigurations() {
            return this.f50a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    /* renamed from: a.b.c.a.d$b */
    private static class C0034b extends ConstantState {
        /* renamed from: a */
        private final ConstantState f55a;

        public C0034b(ConstantState constantState) {
            this.f55a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f55a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f55a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            Drawable c0891d = new C0891d();
            c0891d.f1693a = this.f55a.newDrawable();
            c0891d.f1693a.setCallback(c0891d.f1902g);
            return c0891d;
        }

        public Drawable newDrawable(Resources resources) {
            Drawable c0891d = new C0891d();
            c0891d.f1693a = this.f55a.newDrawable(resources);
            c0891d.f1693a.setCallback(c0891d.f1902g);
            return c0891d;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            Drawable c0891d = new C0891d();
            c0891d.f1693a = this.f55a.newDrawable(resources, theme);
            c0891d.f1693a.setCallback(c0891d.f1902g);
            return c0891d;
        }
    }

    C0891d() {
        this(null, null, null);
    }

    private C0891d(Context context) {
        this(context, null, null);
    }

    private C0891d(Context context, C0033a c0033a, Resources resources) {
        this.f1899d = null;
        this.f1900e = null;
        this.f1901f = null;
        this.f1902g = new C0032c(this);
        this.f1898c = context;
        if (c0033a != null) {
            this.f1897b = c0033a;
        } else {
            this.f1897b = new C0033a(context, c0033a, this.f1902g, resources);
        }
    }

    /* renamed from: a */
    public static C0891d m2399a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        C0891d c0891d = new C0891d(context);
        c0891d.inflate(resources, xmlPullParser, attributeSet, theme);
        return c0891d;
    }

    /* renamed from: a */
    private void m2400a(Animator animator) {
        if (animator instanceof AnimatorSet) {
            List childAnimations = ((AnimatorSet) animator).getChildAnimations();
            if (childAnimations != null) {
                for (int i = 0; i < childAnimations.size(); i++) {
                    m2400a((Animator) childAnimations.get(i));
                }
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f1899d == null) {
                    this.f1899d = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f1899d);
            }
        }
    }

    /* renamed from: a */
    private void m2401a(String str, Animator animator) {
        animator.setTarget(this.f1897b.f51b.m2418a(str));
        if (VERSION.SDK_INT < 21) {
            m2400a(animator);
        }
        C0033a c0033a = this.f1897b;
        if (c0033a.f53d == null) {
            c0033a.f53d = new ArrayList();
            this.f1897b.f54e = new ArrayMap();
        }
        this.f1897b.f53d.add(animator);
        this.f1897b.f54e.put(animator, str);
    }

    public void applyTheme(Theme theme) {
        Drawable drawable = this.f1693a;
        if (drawable != null) {
            DrawableCompat.applyTheme(drawable, theme);
        }
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f1693a;
        return drawable != null ? DrawableCompat.canApplyTheme(drawable) : false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f1693a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f1897b.f51b.draw(canvas);
        if (this.f1897b.f52c.isStarted()) {
            invalidateSelf();
        }
    }

    public int getAlpha() {
        Drawable drawable = this.f1693a;
        return drawable != null ? DrawableCompat.getAlpha(drawable) : this.f1897b.f51b.getAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f1693a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f1897b.f50a;
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public ConstantState getConstantState() {
        Drawable drawable = this.f1693a;
        return (drawable == null || VERSION.SDK_INT < 24) ? null : new C0034b(drawable.getConstantState());
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f1693a;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f1897b.f51b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f1693a;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f1897b.f51b.getIntrinsicWidth();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.f1693a;
        return drawable != null ? drawable.getOpacity() : this.f1897b.f51b.getOpacity();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        Drawable drawable = this.f1693a;
        if (drawable != null) {
            DrawableCompat.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                TypedArray obtainAttributes;
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C0030a.f41e);
                    int resourceId = obtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        Drawable a = C0894k.m2412a(resources, resourceId, theme);
                        a.m2419a(false);
                        a.setCallback(this.f1902g);
                        Drawable drawable2 = this.f1897b.f51b;
                        if (drawable2 != null) {
                            drawable2.setCallback(null);
                        }
                        this.f1897b.f51b = a;
                    }
                } else if ("target".equals(name)) {
                    obtainAttributes = resources.obtainAttributes(attributeSet, C0030a.f42f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f1898c;
                        if (context != null) {
                            m2401a(string, C0037f.m39a(context, resourceId2));
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                } else {
                    continue;
                }
                obtainAttributes.recycle();
            }
            eventType = xmlPullParser.next();
        }
        this.f1897b.m33a();
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f1693a;
        return drawable != null ? DrawableCompat.isAutoMirrored(drawable) : this.f1897b.f51b.isAutoMirrored();
    }

    public boolean isRunning() {
        Drawable drawable = this.f1693a;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f1897b.f52c.isRunning();
    }

    public boolean isStateful() {
        Drawable drawable = this.f1693a;
        return drawable != null ? drawable.isStateful() : this.f1897b.f51b.isStateful();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        Drawable drawable = this.f1693a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1693a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f1897b.f51b.setBounds(rect);
        }
    }

    protected boolean onLevelChange(int i) {
        Drawable drawable = this.f1693a;
        return drawable != null ? drawable.setLevel(i) : this.f1897b.f51b.setLevel(i);
    }

    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f1693a;
        return drawable != null ? drawable.setState(iArr) : this.f1897b.f51b.setState(iArr);
    }

    public void setAlpha(int i) {
        Drawable drawable = this.f1693a;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.f1897b.f51b.setAlpha(i);
        }
    }

    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f1693a;
        if (drawable != null) {
            DrawableCompat.setAutoMirrored(drawable, z);
        } else {
            this.f1897b.f51b.setAutoMirrored(z);
        }
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f1693a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f1897b.f51b.setColorFilter(colorFilter);
        }
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i) {
        Drawable drawable = this.f1693a;
        if (drawable != null) {
            DrawableCompat.setTint(drawable, i);
        } else {
            this.f1897b.f51b.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f1693a;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
        } else {
            this.f1897b.f51b.setTintList(colorStateList);
        }
    }

    public void setTintMode(Mode mode) {
        Drawable drawable = this.f1693a;
        if (drawable != null) {
            DrawableCompat.setTintMode(drawable, mode);
        } else {
            this.f1897b.f51b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f1693a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.f1897b.f51b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public void start() {
        Drawable drawable = this.f1693a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (!this.f1897b.f52c.isStarted()) {
            this.f1897b.f52c.start();
            invalidateSelf();
        }
    }

    public void stop() {
        Drawable drawable = this.f1693a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f1897b.f52c.end();
        }
    }
}
