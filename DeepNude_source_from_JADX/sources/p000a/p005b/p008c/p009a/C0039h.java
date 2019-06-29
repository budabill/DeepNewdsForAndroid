package p000a.p005b.p008c.p009a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: a.b.c.a.h */
public class C0039h implements Interpolator {
    /* renamed from: a */
    private float[] f58a;
    /* renamed from: b */
    private float[] f59b;

    public C0039h(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    public C0039h(Resources resources, Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C0030a.f48l);
        m59a(obtainAttributes, xmlPullParser);
        obtainAttributes.recycle();
    }

    /* renamed from: a */
    private void m57a(float f, float f2) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f2, 1.0f, 1.0f);
        m60a(path);
    }

    /* renamed from: a */
    private void m58a(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        m60a(path);
    }

    /* renamed from: a */
    private void m59a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        String str = "pathData";
        if (TypedArrayUtils.hasAttribute(xmlPullParser, str)) {
            String namedString = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, str, 4);
            Path createPathFromPathData = PathParser.createPathFromPathData(namedString);
            if (createPathFromPathData != null) {
                m60a(createPathFromPathData);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("The path is null, which is created from ");
            stringBuilder.append(namedString);
            throw new InflateException(stringBuilder.toString());
        }
        str = "controlX1";
        if (TypedArrayUtils.hasAttribute(xmlPullParser, str)) {
            String str2 = "controlY1";
            if (TypedArrayUtils.hasAttribute(xmlPullParser, str2)) {
                float namedFloat = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, str, 0, 0.0f);
                float namedFloat2 = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, str2, 1, 0.0f);
                String str3 = "controlX2";
                boolean hasAttribute = TypedArrayUtils.hasAttribute(xmlPullParser, str3);
                String str4 = "controlY2";
                if (hasAttribute != TypedArrayUtils.hasAttribute(xmlPullParser, str4)) {
                    throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
                } else if (hasAttribute) {
                    m58a(namedFloat, namedFloat2, TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, str3, 2, 0.0f), TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, str4, 3, 0.0f));
                    return;
                } else {
                    m57a(namedFloat, namedFloat2);
                    return;
                }
            }
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
        throw new InflateException("pathInterpolator requires the controlX1 attribute");
    }

    /* renamed from: a */
    private void m60a(Path path) {
        int i = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min(3000, ((int) (length / 0.002f)) + 1);
        if (min > 0) {
            int i2;
            this.f58a = new float[min];
            this.f59b = new float[min];
            float[] fArr = new float[2];
            for (i2 = 0; i2 < min; i2++) {
                pathMeasure.getPosTan((((float) i2) * length) / ((float) (min - 1)), fArr, null);
                this.f58a[i2] = fArr[0];
                this.f59b[i2] = fArr[1];
            }
            if (((double) Math.abs(this.f58a[0])) <= 1.0E-5d && ((double) Math.abs(this.f59b[0])) <= 1.0E-5d) {
                int i3 = min - 1;
                if (((double) Math.abs(this.f58a[i3] - 1.0f)) <= 1.0E-5d && ((double) Math.abs(this.f59b[i3] - 1.0f)) <= 1.0E-5d) {
                    int i4 = 0;
                    float f = 0.0f;
                    while (i < min) {
                        fArr = this.f58a;
                        i2 = i4 + 1;
                        length = fArr[i4];
                        if (length >= f) {
                            fArr[i] = length;
                            i++;
                            f = length;
                            i4 = i2;
                        } else {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("The Path cannot loop back on itself, x :");
                            stringBuilder.append(length);
                            throw new IllegalArgumentException(stringBuilder.toString());
                        }
                    }
                    if (pathMeasure.nextContour()) {
                        throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                    }
                    return;
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("The Path must start at (0,0) and end at (1,1) start: ");
            stringBuilder2.append(this.f58a[0]);
            String str = ",";
            stringBuilder2.append(str);
            stringBuilder2.append(this.f59b[0]);
            stringBuilder2.append(" end:");
            min--;
            stringBuilder2.append(this.f58a[min]);
            stringBuilder2.append(str);
            stringBuilder2.append(this.f59b[min]);
            throw new IllegalArgumentException(stringBuilder2.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("The Path has a invalid length ");
        stringBuilder.append(length);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.f58a.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.f58a[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float[] fArr = this.f58a;
        float f2 = fArr[length] - fArr[i];
        if (f2 == 0.0f) {
            return this.f59b[i];
        }
        f = (f - fArr[i]) / f2;
        float[] fArr2 = this.f59b;
        float f3 = fArr2[i];
        return f3 + (f * (fArr2[length] - f3));
    }
}
