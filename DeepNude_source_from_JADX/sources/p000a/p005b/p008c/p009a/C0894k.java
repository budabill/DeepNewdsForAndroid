package p000a.p005b.p008c.p009a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.support.v4.content.res.ComplexColorCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.support.v4.graphics.PathParser.PathDataNode;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: a.b.c.a.k */
public class C0894k extends C0743i {
    /* renamed from: b */
    static final Mode f1916b = Mode.SRC_IN;
    /* renamed from: c */
    private C0043g f1917c;
    /* renamed from: d */
    private PorterDuffColorFilter f1918d;
    /* renamed from: e */
    private ColorFilter f1919e;
    /* renamed from: f */
    private boolean f1920f;
    /* renamed from: g */
    private boolean f1921g;
    /* renamed from: h */
    private ConstantState f1922h;
    /* renamed from: i */
    private final float[] f1923i;
    /* renamed from: j */
    private final Matrix f1924j;
    /* renamed from: k */
    private final Rect f1925k;

    /* renamed from: a.b.c.a.k$d */
    private static abstract class C0041d {
        private C0041d() {
        }

        /* renamed from: a */
        public boolean mo11a() {
            return false;
        }

        /* renamed from: a */
        public boolean mo12a(int[] iArr) {
            return false;
        }
    }

    /* renamed from: a.b.c.a.k$f */
    private static class C0042f {
        /* renamed from: a */
        private static final Matrix f60a = new Matrix();
        /* renamed from: b */
        private final Path f61b;
        /* renamed from: c */
        private final Path f62c;
        /* renamed from: d */
        private final Matrix f63d;
        /* renamed from: e */
        Paint f64e;
        /* renamed from: f */
        Paint f65f;
        /* renamed from: g */
        private PathMeasure f66g;
        /* renamed from: h */
        private int f67h;
        /* renamed from: i */
        final C0744c f68i;
        /* renamed from: j */
        float f69j;
        /* renamed from: k */
        float f70k;
        /* renamed from: l */
        float f71l;
        /* renamed from: m */
        float f72m;
        /* renamed from: n */
        int f73n;
        /* renamed from: o */
        String f74o;
        /* renamed from: p */
        Boolean f75p;
        /* renamed from: q */
        final ArrayMap<String, Object> f76q;

        public C0042f() {
            this.f63d = new Matrix();
            this.f69j = 0.0f;
            this.f70k = 0.0f;
            this.f71l = 0.0f;
            this.f72m = 0.0f;
            this.f73n = 255;
            this.f74o = null;
            this.f75p = null;
            this.f76q = new ArrayMap();
            this.f68i = new C0744c();
            this.f61b = new Path();
            this.f62c = new Path();
        }

        public C0042f(C0042f c0042f) {
            this.f63d = new Matrix();
            this.f69j = 0.0f;
            this.f70k = 0.0f;
            this.f71l = 0.0f;
            this.f72m = 0.0f;
            this.f73n = 255;
            this.f74o = null;
            this.f75p = null;
            this.f76q = new ArrayMap();
            this.f68i = new C0744c(c0042f.f68i, this.f76q);
            this.f61b = new Path(c0042f.f61b);
            this.f62c = new Path(c0042f.f62c);
            this.f69j = c0042f.f69j;
            this.f70k = c0042f.f70k;
            this.f71l = c0042f.f71l;
            this.f72m = c0042f.f72m;
            this.f67h = c0042f.f67h;
            this.f73n = c0042f.f73n;
            this.f74o = c0042f.f74o;
            String str = c0042f.f74o;
            if (str != null) {
                this.f76q.put(str, this);
            }
            this.f75p = c0042f.f75p;
        }

        /* renamed from: a */
        private static float m63a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        /* renamed from: a */
        private float m64a(Matrix matrix) {
            float[] fArr = new float[]{0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot((double) fArr[0], (double) fArr[1]);
            float hypot2 = (float) Math.hypot((double) fArr[2], (double) fArr[3]);
            float a = C0042f.m63a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max(hypot, hypot2);
            return max > 0.0f ? Math.abs(a) / max : 0.0f;
        }

        /* renamed from: a */
        private void m65a(C0744c c0744c, C0745e c0745e, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = ((float) i) / this.f71l;
            float f2 = ((float) i2) / this.f72m;
            float min = Math.min(f, f2);
            Matrix matrix = c0744c.f1694a;
            this.f63d.set(matrix);
            this.f63d.postScale(f, f2);
            float a = m64a(matrix);
            if (a != 0.0f) {
                c0745e.m2028a(this.f61b);
                Path path = this.f61b;
                this.f62c.reset();
                if (c0745e.mo1441b()) {
                    this.f62c.addPath(path, this.f63d);
                    canvas.clipPath(this.f62c);
                } else {
                    ComplexColorCompat complexColorCompat;
                    Paint paint;
                    Shader shader;
                    C0893b c0893b = (C0893b) c0745e;
                    if (!(c0893b.f1910k == 0.0f && c0893b.f1911l == 1.0f)) {
                        float f3 = c0893b.f1910k;
                        float f4 = c0893b.f1912m;
                        f3 = (f3 + f4) % 1.0f;
                        float f5 = (c0893b.f1911l + f4) % 1.0f;
                        if (this.f66g == null) {
                            this.f66g = new PathMeasure();
                        }
                        this.f66g.setPath(this.f61b, false);
                        float length = this.f66g.getLength();
                        f3 *= length;
                        f5 *= length;
                        path.reset();
                        if (f3 > f5) {
                            this.f66g.getSegment(f3, length, path, true);
                            this.f66g.getSegment(0.0f, f5, path, true);
                        } else {
                            this.f66g.getSegment(f3, f5, path, true);
                        }
                        path.rLineTo(0.0f, 0.0f);
                    }
                    this.f62c.addPath(path, this.f63d);
                    if (c0893b.f1906g.willDraw()) {
                        complexColorCompat = c0893b.f1906g;
                        if (this.f65f == null) {
                            this.f65f = new Paint(1);
                            this.f65f.setStyle(Style.FILL);
                        }
                        paint = this.f65f;
                        if (complexColorCompat.isGradient()) {
                            shader = complexColorCompat.getShader();
                            shader.setLocalMatrix(this.f63d);
                            paint.setShader(shader);
                            paint.setAlpha(Math.round(c0893b.f1909j * 255.0f));
                        } else {
                            paint.setColor(C0894k.m2411a(complexColorCompat.getColor(), c0893b.f1909j));
                        }
                        paint.setColorFilter(colorFilter);
                        this.f62c.setFillType(c0893b.f1908i == 0 ? FillType.WINDING : FillType.EVEN_ODD);
                        canvas.drawPath(this.f62c, paint);
                    }
                    if (c0893b.f1904e.willDraw()) {
                        complexColorCompat = c0893b.f1904e;
                        if (this.f64e == null) {
                            this.f64e = new Paint(1);
                            this.f64e.setStyle(Style.STROKE);
                        }
                        paint = this.f64e;
                        Join join = c0893b.f1914o;
                        if (join != null) {
                            paint.setStrokeJoin(join);
                        }
                        Cap cap = c0893b.f1913n;
                        if (cap != null) {
                            paint.setStrokeCap(cap);
                        }
                        paint.setStrokeMiter(c0893b.f1915p);
                        if (complexColorCompat.isGradient()) {
                            shader = complexColorCompat.getShader();
                            shader.setLocalMatrix(this.f63d);
                            paint.setShader(shader);
                            paint.setAlpha(Math.round(c0893b.f1907h * 255.0f));
                        } else {
                            paint.setColor(C0894k.m2411a(complexColorCompat.getColor(), c0893b.f1907h));
                        }
                        paint.setColorFilter(colorFilter);
                        paint.setStrokeWidth(c0893b.f1905f * (min * a));
                        canvas.drawPath(this.f62c, paint);
                    }
                }
            }
        }

        /* renamed from: a */
        private void m66a(C0744c c0744c, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            c0744c.f1694a.set(matrix);
            c0744c.f1694a.preConcat(c0744c.f1703j);
            canvas.save();
            for (int i3 = 0; i3 < c0744c.f1695b.size(); i3++) {
                C0041d c0041d = (C0041d) c0744c.f1695b.get(i3);
                if (c0041d instanceof C0744c) {
                    m66a((C0744c) c0041d, c0744c.f1694a, canvas, i, i2, colorFilter);
                } else if (c0041d instanceof C0745e) {
                    m65a(c0744c, (C0745e) c0041d, canvas, i, i2, colorFilter);
                }
            }
            canvas.restore();
        }

        /* renamed from: a */
        public void m67a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            m66a(this.f68i, f60a, canvas, i, i2, colorFilter);
        }

        /* renamed from: a */
        public boolean m68a() {
            if (this.f75p == null) {
                this.f75p = Boolean.valueOf(this.f68i.mo11a());
            }
            return this.f75p.booleanValue();
        }

        /* renamed from: a */
        public boolean m69a(int[] iArr) {
            return this.f68i.mo12a(iArr);
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public int getRootAlpha() {
            return this.f73n;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public void setRootAlpha(int i) {
            this.f73n = i;
        }
    }

    /* renamed from: a.b.c.a.k$g */
    private static class C0043g extends ConstantState {
        /* renamed from: a */
        int f77a;
        /* renamed from: b */
        C0042f f78b;
        /* renamed from: c */
        ColorStateList f79c;
        /* renamed from: d */
        Mode f80d;
        /* renamed from: e */
        boolean f81e;
        /* renamed from: f */
        Bitmap f82f;
        /* renamed from: g */
        ColorStateList f83g;
        /* renamed from: h */
        Mode f84h;
        /* renamed from: i */
        int f85i;
        /* renamed from: j */
        boolean f86j;
        /* renamed from: k */
        boolean f87k;
        /* renamed from: l */
        Paint f88l;

        public C0043g() {
            this.f79c = null;
            this.f80d = C0894k.f1916b;
            this.f78b = new C0042f();
        }

        public C0043g(C0043g c0043g) {
            this.f79c = null;
            this.f80d = C0894k.f1916b;
            if (c0043g != null) {
                this.f77a = c0043g.f77a;
                this.f78b = new C0042f(c0043g.f78b);
                Paint paint = c0043g.f78b.f65f;
                if (paint != null) {
                    this.f78b.f65f = new Paint(paint);
                }
                paint = c0043g.f78b.f64e;
                if (paint != null) {
                    this.f78b.f64e = new Paint(paint);
                }
                this.f79c = c0043g.f79c;
                this.f80d = c0043g.f80d;
                this.f81e = c0043g.f81e;
            }
        }

        /* renamed from: a */
        public Paint m70a(ColorFilter colorFilter) {
            if (!m76b() && colorFilter == null) {
                return null;
            }
            if (this.f88l == null) {
                this.f88l = new Paint();
                this.f88l.setFilterBitmap(true);
            }
            this.f88l.setAlpha(this.f78b.getRootAlpha());
            this.f88l.setColorFilter(colorFilter);
            return this.f88l;
        }

        /* renamed from: a */
        public void m71a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f82f, null, rect, m70a(colorFilter));
        }

        /* renamed from: a */
        public boolean m72a() {
            return !this.f87k && this.f83g == this.f79c && this.f84h == this.f80d && this.f86j == this.f81e && this.f85i == this.f78b.getRootAlpha();
        }

        /* renamed from: a */
        public boolean m73a(int i, int i2) {
            return i == this.f82f.getWidth() && i2 == this.f82f.getHeight();
        }

        /* renamed from: a */
        public boolean m74a(int[] iArr) {
            boolean a = this.f78b.m69a(iArr);
            this.f87k |= a;
            return a;
        }

        /* renamed from: b */
        public void m75b(int i, int i2) {
            if (this.f82f == null || !m73a(i, i2)) {
                this.f82f = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
                this.f87k = true;
            }
        }

        /* renamed from: b */
        public boolean m76b() {
            return this.f78b.getRootAlpha() < 255;
        }

        /* renamed from: c */
        public void m77c(int i, int i2) {
            this.f82f.eraseColor(0);
            this.f78b.m67a(new Canvas(this.f82f), i, i2, null);
        }

        /* renamed from: c */
        public boolean m78c() {
            return this.f78b.m68a();
        }

        /* renamed from: d */
        public void m79d() {
            this.f83g = this.f79c;
            this.f84h = this.f80d;
            this.f85i = this.f78b.getRootAlpha();
            this.f86j = this.f81e;
            this.f87k = false;
        }

        public int getChangingConfigurations() {
            return this.f77a;
        }

        public Drawable newDrawable() {
            return new C0894k(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0894k(this);
        }
    }

    /* renamed from: a.b.c.a.k$h */
    private static class C0044h extends ConstantState {
        /* renamed from: a */
        private final ConstantState f89a;

        public C0044h(ConstantState constantState) {
            this.f89a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f89a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f89a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            Drawable c0894k = new C0894k();
            c0894k.f1693a = (VectorDrawable) this.f89a.newDrawable();
            return c0894k;
        }

        public Drawable newDrawable(Resources resources) {
            Drawable c0894k = new C0894k();
            c0894k.f1693a = (VectorDrawable) this.f89a.newDrawable(resources);
            return c0894k;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            Drawable c0894k = new C0894k();
            c0894k.f1693a = (VectorDrawable) this.f89a.newDrawable(resources, theme);
            return c0894k;
        }
    }

    /* renamed from: a.b.c.a.k$c */
    private static class C0744c extends C0041d {
        /* renamed from: a */
        final Matrix f1694a = new Matrix();
        /* renamed from: b */
        final ArrayList<C0041d> f1695b = new ArrayList();
        /* renamed from: c */
        float f1696c = 0.0f;
        /* renamed from: d */
        private float f1697d = 0.0f;
        /* renamed from: e */
        private float f1698e = 0.0f;
        /* renamed from: f */
        private float f1699f = 1.0f;
        /* renamed from: g */
        private float f1700g = 1.0f;
        /* renamed from: h */
        private float f1701h = 0.0f;
        /* renamed from: i */
        private float f1702i = 0.0f;
        /* renamed from: j */
        final Matrix f1703j = new Matrix();
        /* renamed from: k */
        int f1704k;
        /* renamed from: l */
        private int[] f1705l;
        /* renamed from: m */
        private String f1706m = null;

        public C0744c() {
            super();
        }

        public C0744c(C0744c c0744c, ArrayMap<String, Object> arrayMap) {
            super();
            this.f1696c = c0744c.f1696c;
            this.f1697d = c0744c.f1697d;
            this.f1698e = c0744c.f1698e;
            this.f1699f = c0744c.f1699f;
            this.f1700g = c0744c.f1700g;
            this.f1701h = c0744c.f1701h;
            this.f1702i = c0744c.f1702i;
            this.f1705l = c0744c.f1705l;
            this.f1706m = c0744c.f1706m;
            this.f1704k = c0744c.f1704k;
            String str = this.f1706m;
            if (str != null) {
                arrayMap.put(str, this);
            }
            this.f1703j.set(c0744c.f1703j);
            ArrayList arrayList = c0744c.f1695b;
            for (int i = 0; i < arrayList.size(); i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof C0744c) {
                    this.f1695b.add(new C0744c((C0744c) obj, arrayMap));
                } else {
                    C0745e c0893b;
                    if (obj instanceof C0893b) {
                        c0893b = new C0893b((C0893b) obj);
                    } else if (obj instanceof C0892a) {
                        c0893b = new C0892a((C0892a) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f1695b.add(c0893b);
                    String str2 = c0893b.f1708b;
                    if (str2 != null) {
                        arrayMap.put(str2, c0893b);
                    }
                }
            }
        }

        /* renamed from: a */
        private void m2023a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f1705l = null;
            this.f1696c = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "rotation", 5, this.f1696c);
            this.f1697d = typedArray.getFloat(1, this.f1697d);
            this.f1698e = typedArray.getFloat(2, this.f1698e);
            this.f1699f = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "scaleX", 3, this.f1699f);
            this.f1700g = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "scaleY", 4, this.f1700g);
            this.f1701h = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateX", 6, this.f1701h);
            this.f1702i = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateY", 7, this.f1702i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f1706m = string;
            }
            m2024b();
        }

        /* renamed from: b */
        private void m2024b() {
            this.f1703j.reset();
            this.f1703j.postTranslate(-this.f1697d, -this.f1698e);
            this.f1703j.postScale(this.f1699f, this.f1700g);
            this.f1703j.postRotate(this.f1696c, 0.0f, 0.0f);
            this.f1703j.postTranslate(this.f1701h + this.f1697d, this.f1702i + this.f1698e);
        }

        /* renamed from: a */
        public void m2025a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C0030a.f38b);
            m2023a(obtainAttributes, xmlPullParser);
            obtainAttributes.recycle();
        }

        /* renamed from: a */
        public boolean mo11a() {
            for (int i = 0; i < this.f1695b.size(); i++) {
                if (((C0041d) this.f1695b.get(i)).mo11a()) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: a */
        public boolean mo12a(int[] iArr) {
            boolean z = false;
            for (int i = 0; i < this.f1695b.size(); i++) {
                z |= ((C0041d) this.f1695b.get(i)).mo12a(iArr);
            }
            return z;
        }

        public String getGroupName() {
            return this.f1706m;
        }

        public Matrix getLocalMatrix() {
            return this.f1703j;
        }

        public float getPivotX() {
            return this.f1697d;
        }

        public float getPivotY() {
            return this.f1698e;
        }

        public float getRotation() {
            return this.f1696c;
        }

        public float getScaleX() {
            return this.f1699f;
        }

        public float getScaleY() {
            return this.f1700g;
        }

        public float getTranslateX() {
            return this.f1701h;
        }

        public float getTranslateY() {
            return this.f1702i;
        }

        public void setPivotX(float f) {
            if (f != this.f1697d) {
                this.f1697d = f;
                m2024b();
            }
        }

        public void setPivotY(float f) {
            if (f != this.f1698e) {
                this.f1698e = f;
                m2024b();
            }
        }

        public void setRotation(float f) {
            if (f != this.f1696c) {
                this.f1696c = f;
                m2024b();
            }
        }

        public void setScaleX(float f) {
            if (f != this.f1699f) {
                this.f1699f = f;
                m2024b();
            }
        }

        public void setScaleY(float f) {
            if (f != this.f1700g) {
                this.f1700g = f;
                m2024b();
            }
        }

        public void setTranslateX(float f) {
            if (f != this.f1701h) {
                this.f1701h = f;
                m2024b();
            }
        }

        public void setTranslateY(float f) {
            if (f != this.f1702i) {
                this.f1702i = f;
                m2024b();
            }
        }
    }

    /* renamed from: a.b.c.a.k$e */
    private static abstract class C0745e extends C0041d {
        /* renamed from: a */
        protected PathDataNode[] f1707a = null;
        /* renamed from: b */
        String f1708b;
        /* renamed from: c */
        int f1709c;

        public C0745e() {
            super();
        }

        public C0745e(C0745e c0745e) {
            super();
            this.f1708b = c0745e.f1708b;
            this.f1709c = c0745e.f1709c;
            this.f1707a = PathParser.deepCopyNodes(c0745e.f1707a);
        }

        /* renamed from: a */
        public void m2028a(Path path) {
            path.reset();
            PathDataNode[] pathDataNodeArr = this.f1707a;
            if (pathDataNodeArr != null) {
                PathDataNode.nodesToPath(pathDataNodeArr, path);
            }
        }

        /* renamed from: b */
        public boolean mo1441b() {
            return false;
        }

        public PathDataNode[] getPathData() {
            return this.f1707a;
        }

        public String getPathName() {
            return this.f1708b;
        }

        public void setPathData(PathDataNode[] pathDataNodeArr) {
            if (PathParser.canMorph(this.f1707a, pathDataNodeArr)) {
                PathParser.updateNodes(this.f1707a, pathDataNodeArr);
            } else {
                this.f1707a = PathParser.deepCopyNodes(pathDataNodeArr);
            }
        }
    }

    /* renamed from: a.b.c.a.k$a */
    private static class C0892a extends C0745e {
        public C0892a(C0892a c0892a) {
            super(c0892a);
        }

        /* renamed from: a */
        private void m2402a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f1708b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f1707a = PathParser.createNodesFromPathData(string2);
            }
        }

        /* renamed from: a */
        public void m2403a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
                TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C0030a.f40d);
                m2402a(obtainAttributes);
                obtainAttributes.recycle();
            }
        }

        /* renamed from: b */
        public boolean mo1441b() {
            return true;
        }
    }

    /* renamed from: a.b.c.a.k$b */
    private static class C0893b extends C0745e {
        /* renamed from: d */
        private int[] f1903d;
        /* renamed from: e */
        ComplexColorCompat f1904e;
        /* renamed from: f */
        float f1905f = 0.0f;
        /* renamed from: g */
        ComplexColorCompat f1906g;
        /* renamed from: h */
        float f1907h = 1.0f;
        /* renamed from: i */
        int f1908i = 0;
        /* renamed from: j */
        float f1909j = 1.0f;
        /* renamed from: k */
        float f1910k = 0.0f;
        /* renamed from: l */
        float f1911l = 1.0f;
        /* renamed from: m */
        float f1912m = 0.0f;
        /* renamed from: n */
        Cap f1913n = Cap.BUTT;
        /* renamed from: o */
        Join f1914o = Join.MITER;
        /* renamed from: p */
        float f1915p = 4.0f;

        public C0893b(C0893b c0893b) {
            super(c0893b);
            this.f1903d = c0893b.f1903d;
            this.f1904e = c0893b.f1904e;
            this.f1905f = c0893b.f1905f;
            this.f1907h = c0893b.f1907h;
            this.f1906g = c0893b.f1906g;
            this.f1908i = c0893b.f1908i;
            this.f1909j = c0893b.f1909j;
            this.f1910k = c0893b.f1910k;
            this.f1911l = c0893b.f1911l;
            this.f1912m = c0893b.f1912m;
            this.f1913n = c0893b.f1913n;
            this.f1914o = c0893b.f1914o;
            this.f1915p = c0893b.f1915p;
        }

        /* renamed from: a */
        private Cap m2405a(int i, Cap cap) {
            return i != 0 ? i != 1 ? i != 2 ? cap : Cap.SQUARE : Cap.ROUND : Cap.BUTT;
        }

        /* renamed from: a */
        private Join m2406a(int i, Join join) {
            return i != 0 ? i != 1 ? i != 2 ? join : Join.BEVEL : Join.ROUND : Join.MITER;
        }

        /* renamed from: a */
        private void m2407a(TypedArray typedArray, XmlPullParser xmlPullParser, Theme theme) {
            this.f1903d = null;
            if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f1708b = string;
                }
                string = typedArray.getString(2);
                if (string != null) {
                    this.f1707a = PathParser.createNodesFromPathData(string);
                }
                Theme theme2 = theme;
                this.f1906g = TypedArrayUtils.getNamedComplexColor(typedArray, xmlPullParser, theme2, "fillColor", 1, 0);
                this.f1909j = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "fillAlpha", 12, this.f1909j);
                this.f1913n = m2405a(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f1913n);
                this.f1914o = m2406a(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f1914o);
                this.f1915p = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f1915p);
                this.f1904e = TypedArrayUtils.getNamedComplexColor(typedArray, xmlPullParser, theme2, "strokeColor", 3, 0);
                this.f1907h = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeAlpha", 11, this.f1907h);
                this.f1905f = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeWidth", 4, this.f1905f);
                this.f1911l = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathEnd", 6, this.f1911l);
                this.f1912m = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathOffset", 7, this.f1912m);
                this.f1910k = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathStart", 5, this.f1910k);
                this.f1908i = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "fillType", 13, this.f1908i);
            }
        }

        /* renamed from: a */
        public void m2408a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C0030a.f39c);
            m2407a(obtainAttributes, xmlPullParser, theme);
            obtainAttributes.recycle();
        }

        /* renamed from: a */
        public boolean mo11a() {
            if (!this.f1906g.isStateful()) {
                if (!this.f1904e.isStateful()) {
                    return false;
                }
            }
            return true;
        }

        /* renamed from: a */
        public boolean mo12a(int[] iArr) {
            return this.f1904e.onStateChanged(iArr) | this.f1906g.onStateChanged(iArr);
        }

        float getFillAlpha() {
            return this.f1909j;
        }

        int getFillColor() {
            return this.f1906g.getColor();
        }

        float getStrokeAlpha() {
            return this.f1907h;
        }

        int getStrokeColor() {
            return this.f1904e.getColor();
        }

        float getStrokeWidth() {
            return this.f1905f;
        }

        float getTrimPathEnd() {
            return this.f1911l;
        }

        float getTrimPathOffset() {
            return this.f1912m;
        }

        float getTrimPathStart() {
            return this.f1910k;
        }

        void setFillAlpha(float f) {
            this.f1909j = f;
        }

        void setFillColor(int i) {
            this.f1906g.setColor(i);
        }

        void setStrokeAlpha(float f) {
            this.f1907h = f;
        }

        void setStrokeColor(int i) {
            this.f1904e.setColor(i);
        }

        void setStrokeWidth(float f) {
            this.f1905f = f;
        }

        void setTrimPathEnd(float f) {
            this.f1911l = f;
        }

        void setTrimPathOffset(float f) {
            this.f1912m = f;
        }

        void setTrimPathStart(float f) {
            this.f1910k = f;
        }
    }

    C0894k() {
        this.f1921g = true;
        this.f1923i = new float[9];
        this.f1924j = new Matrix();
        this.f1925k = new Rect();
        this.f1917c = new C0043g();
    }

    C0894k(C0043g c0043g) {
        this.f1921g = true;
        this.f1923i = new float[9];
        this.f1924j = new Matrix();
        this.f1925k = new Rect();
        this.f1917c = c0043g;
        this.f1918d = m2417a(this.f1918d, c0043g.f79c, c0043g.f80d);
    }

    /* renamed from: a */
    static int m2411a(int i, float f) {
        return (i & ViewCompat.MEASURED_SIZE_MASK) | (((int) (((float) Color.alpha(i)) * f)) << 24);
    }

    /* renamed from: a */
    public static C0894k m2412a(Resources resources, int i, Theme theme) {
        Throwable e;
        String str = "parser error";
        String str2 = "VectorDrawableCompat";
        if (VERSION.SDK_INT >= 24) {
            C0743i c0894k = new C0894k();
            c0894k.f1693a = ResourcesCompat.getDrawable(resources, i, theme);
            c0894k.f1922h = new C0044h(c0894k.f1693a.getConstantState());
            return c0894k;
        }
        try {
            int next;
            XmlPullParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            while (true) {
                next = xml.next();
                if (next == 2 || next == 1) {
                    if (next == 2) {
                        return C0894k.createFromXmlInner(resources, xml, asAttributeSet, theme);
                    }
                    throw new XmlPullParserException("No start tag found");
                }
            }
            if (next == 2) {
                return C0894k.createFromXmlInner(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (XmlPullParserException e2) {
            e = e2;
            Log.e(str2, str, e);
            return null;
        } catch (IOException e3) {
            e = e3;
            Log.e(str2, str, e);
            return null;
        }
    }

    /* renamed from: a */
    private static Mode m2413a(int i, Mode mode) {
        if (i == 3) {
            return Mode.SRC_OVER;
        }
        if (i == 5) {
            return Mode.SRC_IN;
        }
        if (i == 9) {
            return Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return Mode.ADD;
            default:
                return mode;
        }
    }

    /* renamed from: a */
    private void m2414a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        C0043g c0043g = this.f1917c;
        C0042f c0042f = c0043g.f78b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(c0042f.f68i);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        Object obj = 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            String str = "group";
            if (eventType == 2) {
                C0745e c0893b;
                int i;
                String name = xmlPullParser.getName();
                C0744c c0744c = (C0744c) arrayDeque.peek();
                if ("path".equals(name)) {
                    c0893b = new C0893b();
                    c0893b.m2408a(resources, attributeSet, theme, xmlPullParser);
                    c0744c.f1695b.add(c0893b);
                    if (c0893b.getPathName() != null) {
                        c0042f.f76q.put(c0893b.getPathName(), c0893b);
                    }
                    obj = null;
                } else if ("clip-path".equals(name)) {
                    c0893b = new C0892a();
                    c0893b.m2403a(resources, attributeSet, theme, xmlPullParser);
                    c0744c.f1695b.add(c0893b);
                    if (c0893b.getPathName() != null) {
                        c0042f.f76q.put(c0893b.getPathName(), c0893b);
                    }
                } else if (str.equals(name)) {
                    C0744c c0744c2 = new C0744c();
                    c0744c2.m2025a(resources, attributeSet, theme, xmlPullParser);
                    c0744c.f1695b.add(c0744c2);
                    arrayDeque.push(c0744c2);
                    if (c0744c2.getGroupName() != null) {
                        c0042f.f76q.put(c0744c2.getGroupName(), c0744c2);
                    }
                    i = c0043g.f77a;
                    eventType = c0744c2.f1704k;
                    c0043g.f77a = eventType | i;
                }
                i = c0043g.f77a;
                eventType = c0893b.f1709c;
                c0043g.f77a = eventType | i;
            } else if (eventType == 3 && str.equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (obj != null) {
            throw new XmlPullParserException("no path defined");
        }
    }

    /* renamed from: a */
    private void m2415a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        C0043g c0043g = this.f1917c;
        C0042f c0042f = c0043g.f78b;
        c0043g.f80d = C0894k.m2413a(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "tintMode", 6, -1), Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            c0043g.f79c = colorStateList;
        }
        c0043g.f81e = TypedArrayUtils.getNamedBoolean(typedArray, xmlPullParser, "autoMirrored", 5, c0043g.f81e);
        c0042f.f71l = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "viewportWidth", 7, c0042f.f71l);
        c0042f.f72m = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "viewportHeight", 8, c0042f.f72m);
        StringBuilder stringBuilder;
        if (c0042f.f71l <= 0.0f) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(typedArray.getPositionDescription());
            stringBuilder.append("<vector> tag requires viewportWidth > 0");
            throw new XmlPullParserException(stringBuilder.toString());
        } else if (c0042f.f72m > 0.0f) {
            c0042f.f69j = typedArray.getDimension(3, c0042f.f69j);
            c0042f.f70k = typedArray.getDimension(2, c0042f.f70k);
            if (c0042f.f69j <= 0.0f) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(typedArray.getPositionDescription());
                stringBuilder.append("<vector> tag requires width > 0");
                throw new XmlPullParserException(stringBuilder.toString());
            } else if (c0042f.f70k > 0.0f) {
                c0042f.setAlpha(TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "alpha", 4, c0042f.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    c0042f.f74o = string;
                    c0042f.f76q.put(string, c0042f);
                }
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(typedArray.getPositionDescription());
                stringBuilder.append("<vector> tag requires height > 0");
                throw new XmlPullParserException(stringBuilder.toString());
            }
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(typedArray.getPositionDescription());
            stringBuilder.append("<vector> tag requires viewportHeight > 0");
            throw new XmlPullParserException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    private boolean m2416a() {
        return VERSION.SDK_INT >= 17 && isAutoMirrored() && DrawableCompat.getLayoutDirection(this) == 1;
    }

    public static C0894k createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        C0894k c0894k = new C0894k();
        c0894k.inflate(resources, xmlPullParser, attributeSet, theme);
        return c0894k;
    }

    /* renamed from: a */
    PorterDuffColorFilter m2417a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, Mode mode) {
        if (colorStateList != null) {
            if (mode != null) {
                return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            }
        }
        return null;
    }

    /* renamed from: a */
    Object m2418a(String str) {
        return this.f1917c.f78b.f76q.get(str);
    }

    /* renamed from: a */
    void m2419a(boolean z) {
        this.f1921g = z;
    }

    public /* bridge */ /* synthetic */ void applyTheme(Theme theme) {
        super.applyTheme(theme);
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f1693a;
        if (drawable != null) {
            DrawableCompat.canApplyTheme(drawable);
        }
        return false;
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
        copyBounds(this.f1925k);
        if (this.f1925k.width() > 0) {
            if (this.f1925k.height() > 0) {
                ColorFilter colorFilter = this.f1919e;
                if (colorFilter == null) {
                    colorFilter = this.f1918d;
                }
                canvas.getMatrix(this.f1924j);
                this.f1924j.getValues(this.f1923i);
                float abs = Math.abs(this.f1923i[0]);
                float abs2 = Math.abs(this.f1923i[4]);
                float abs3 = Math.abs(this.f1923i[1]);
                float abs4 = Math.abs(this.f1923i[3]);
                if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                    abs = 1.0f;
                    abs2 = 1.0f;
                }
                int height = (int) (((float) this.f1925k.height()) * abs2);
                int min = Math.min(2048, (int) (((float) this.f1925k.width()) * abs));
                height = Math.min(2048, height);
                if (min > 0) {
                    if (height > 0) {
                        int save = canvas.save();
                        Rect rect = this.f1925k;
                        canvas.translate((float) rect.left, (float) rect.top);
                        if (m2416a()) {
                            canvas.translate((float) this.f1925k.width(), 0.0f);
                            canvas.scale(-1.0f, 1.0f);
                        }
                        this.f1925k.offsetTo(0, 0);
                        this.f1917c.m75b(min, height);
                        if (!this.f1921g) {
                            this.f1917c.m77c(min, height);
                        } else if (!this.f1917c.m72a()) {
                            this.f1917c.m77c(min, height);
                            this.f1917c.m79d();
                        }
                        this.f1917c.m71a(canvas, colorFilter, this.f1925k);
                        canvas.restoreToCount(save);
                    }
                }
            }
        }
    }

    public int getAlpha() {
        Drawable drawable = this.f1693a;
        return drawable != null ? DrawableCompat.getAlpha(drawable) : this.f1917c.f78b.getRootAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f1693a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f1917c.getChangingConfigurations();
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public ConstantState getConstantState() {
        Drawable drawable = this.f1693a;
        if (drawable != null && VERSION.SDK_INT >= 24) {
            return new C0044h(drawable.getConstantState());
        }
        this.f1917c.f77a = getChangingConfigurations();
        return this.f1917c;
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f1693a;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f1917c.f78b.f70k;
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f1693a;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f1917c.f78b.f69j;
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.f1693a;
        return drawable != null ? drawable.getOpacity() : -3;
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
        Drawable drawable = this.f1693a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        Drawable drawable = this.f1693a;
        if (drawable != null) {
            DrawableCompat.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C0043g c0043g = this.f1917c;
        c0043g.f78b = new C0042f();
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C0030a.f37a);
        m2415a(obtainAttributes, xmlPullParser);
        obtainAttributes.recycle();
        c0043g.f77a = getChangingConfigurations();
        c0043g.f87k = true;
        m2414a(resources, xmlPullParser, attributeSet, theme);
        this.f1918d = m2417a(this.f1918d, c0043g.f79c, c0043g.f80d);
    }

    public void invalidateSelf() {
        Drawable drawable = this.f1693a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f1693a;
        return drawable != null ? DrawableCompat.isAutoMirrored(drawable) : this.f1917c.f81e;
    }

    public boolean isStateful() {
        Drawable drawable = this.f1693a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        boolean z;
        if (!super.isStateful()) {
            C0043g c0043g = this.f1917c;
            if (c0043g != null) {
                if (!c0043g.m78c()) {
                    ColorStateList colorStateList = this.f1917c.f79c;
                    if (colorStateList != null && colorStateList.isStateful()) {
                    }
                }
            }
            z = false;
            return z;
        }
        z = true;
        return z;
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        Drawable drawable = this.f1693a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f1920f && super.mutate() == this) {
            this.f1917c = new C0043g(this.f1917c);
            this.f1920f = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1693a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f1693a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        C0043g c0043g = this.f1917c;
        ColorStateList colorStateList = c0043g.f79c;
        if (colorStateList != null) {
            Mode mode = c0043g.f80d;
            if (mode != null) {
                this.f1918d = m2417a(this.f1918d, colorStateList, mode);
                invalidateSelf();
                z = true;
            }
        }
        if (c0043g.m78c() && c0043g.m74a(iArr)) {
            invalidateSelf();
            z = true;
        }
        return z;
    }

    public void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.f1693a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public void setAlpha(int i) {
        Drawable drawable = this.f1693a;
        if (drawable != null) {
            drawable.setAlpha(i);
            return;
        }
        if (this.f1917c.f78b.getRootAlpha() != i) {
            this.f1917c.f78b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f1693a;
        if (drawable != null) {
            DrawableCompat.setAutoMirrored(drawable, z);
        } else {
            this.f1917c.f81e = z;
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
            return;
        }
        this.f1919e = colorFilter;
        invalidateSelf();
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
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f1693a;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
            return;
        }
        C0043g c0043g = this.f1917c;
        if (c0043g.f79c != colorStateList) {
            c0043g.f79c = colorStateList;
            this.f1918d = m2417a(this.f1918d, colorStateList, c0043g.f80d);
            invalidateSelf();
        }
    }

    public void setTintMode(Mode mode) {
        Drawable drawable = this.f1693a;
        if (drawable != null) {
            DrawableCompat.setTintMode(drawable, mode);
            return;
        }
        C0043g c0043g = this.f1917c;
        if (c0043g.f80d != mode) {
            c0043g.f80d = mode;
            this.f1918d = m2417a(this.f1918d, c0043g.f79c, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f1693a;
        return drawable != null ? drawable.setVisible(z, z2) : super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f1693a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
