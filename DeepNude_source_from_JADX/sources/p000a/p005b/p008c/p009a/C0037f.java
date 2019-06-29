package p000a.p005b.p008c.p009a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build.VERSION;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.support.v4.graphics.PathParser.PathDataNode;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: a.b.c.a.f */
public class C0037f {

    /* renamed from: a.b.c.a.f$a */
    private static class C0036a implements TypeEvaluator<PathDataNode[]> {
        /* renamed from: a */
        private PathDataNode[] f56a;

        C0036a() {
        }

        /* renamed from: a */
        public PathDataNode[] m36a(float f, PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
            if (PathParser.canMorph(pathDataNodeArr, pathDataNodeArr2)) {
                PathDataNode[] pathDataNodeArr3 = this.f56a;
                if (pathDataNodeArr3 == null || !PathParser.canMorph(pathDataNodeArr3, pathDataNodeArr)) {
                    this.f56a = PathParser.deepCopyNodes(pathDataNodeArr);
                }
                for (int i = 0; i < pathDataNodeArr.length; i++) {
                    this.f56a[i].interpolatePathDataNode(pathDataNodeArr[i], pathDataNodeArr2[i], f);
                }
                return this.f56a;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }

        public /* bridge */ /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
            return m36a(f, (PathDataNode[]) obj, (PathDataNode[]) obj2);
        }
    }

    /* renamed from: a */
    private static int m37a(Resources resources, Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C0030a.f46j);
        int i = 0;
        TypedValue peekNamedValue = TypedArrayUtils.peekNamedValue(obtainAttributes, xmlPullParser, "value", 0);
        if ((peekNamedValue != null ? 1 : null) != null && C0037f.m54a(peekNamedValue.type)) {
            i = 3;
        }
        obtainAttributes.recycle();
        return i;
    }

    /* renamed from: a */
    private static int m38a(TypedArray typedArray, int i, int i2) {
        TypedValue peekValue = typedArray.peekValue(i);
        Object obj = 1;
        Object obj2 = peekValue != null ? 1 : null;
        i = obj2 != null ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i2);
        if (peekValue2 == null) {
            obj = null;
        }
        return ((obj2 == null || !C0037f.m54a(i)) && (obj == null || !C0037f.m54a(obj != null ? peekValue2.type : 0))) ? 0 : 3;
    }

    /* renamed from: a */
    public static Animator m39a(Context context, int i) {
        return VERSION.SDK_INT >= 24 ? AnimatorInflater.loadAnimator(context, i) : C0037f.m40a(context, context.getResources(), context.getTheme(), i);
    }

    /* renamed from: a */
    public static Animator m40a(Context context, Resources resources, Theme theme, int i) {
        return C0037f.m41a(context, resources, theme, i, 1.0f);
    }

    /* renamed from: a */
    public static Animator m41a(Context context, Resources resources, Theme theme, int i, float f) {
        StringBuilder stringBuilder;
        NotFoundException notFoundException;
        String str = "Can't load animation resource ID #0x";
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = resources.getAnimation(i);
            Animator a = C0037f.m42a(context, resources, theme, (XmlPullParser) xmlResourceParser, f);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            return a;
        } catch (Throwable e) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(Integer.toHexString(i));
            notFoundException = new NotFoundException(stringBuilder.toString());
            notFoundException.initCause(e);
            throw notFoundException;
        } catch (Throwable e2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(Integer.toHexString(i));
            notFoundException = new NotFoundException(stringBuilder.toString());
            notFoundException.initCause(e2);
            throw notFoundException;
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    /* renamed from: a */
    private static Animator m42a(Context context, Resources resources, Theme theme, XmlPullParser xmlPullParser, float f) {
        return C0037f.m43a(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f);
    }

    /* renamed from: a */
    private static Animator m43a(Context context, Resources resources, Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i, float f) {
        Resources resources2 = resources;
        Theme theme2 = theme;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        AnimatorSet animatorSet2 = animatorSet;
        int depth = xmlPullParser.getDepth();
        Animator animator = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            int i2 = 0;
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    Context context2;
                    String name = xmlPullParser.getName();
                    if (name.equals("objectAnimator")) {
                        animator = C0037f.m46a(context, resources, theme, attributeSet, f, xmlPullParser);
                    } else if (name.equals("animator")) {
                        animator = C0037f.m49a(context, resources, theme, attributeSet, null, f, xmlPullParser);
                    } else {
                        if (name.equals("set")) {
                            Animator animatorSet3 = new AnimatorSet();
                            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources2, theme2, attributeSet, C0030a.f44h);
                            TypedArray typedArray = obtainAttributes;
                            C0037f.m43a(context, resources, theme, xmlPullParser, attributeSet, animatorSet3, TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser2, "ordering", 0, 0), f);
                            typedArray.recycle();
                            context2 = context;
                            animator = animatorSet3;
                        } else if (name.equals("propertyValuesHolder")) {
                            PropertyValuesHolder[] a = C0037f.m55a(context, resources2, theme2, xmlPullParser2, Xml.asAttributeSet(xmlPullParser));
                            if (!(a == null || animator == null || !(animator instanceof ValueAnimator))) {
                                ((ValueAnimator) animator).setValues(a);
                            }
                            i2 = 1;
                        } else {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Unknown animator name: ");
                            stringBuilder.append(xmlPullParser.getName());
                            throw new RuntimeException(stringBuilder.toString());
                        }
                        if (animatorSet2 != null && r14 == 0) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(animator);
                        }
                    }
                    context2 = context;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(animator);
                }
            }
        }
        if (!(animatorSet2 == null || arrayList == null)) {
            Animator[] animatorArr = new Animator[arrayList.size()];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                int i3 = i2 + 1;
                animatorArr[i2] = (Animator) it.next();
                i2 = i3;
            }
            if (i == 0) {
                animatorSet2.playTogether(animatorArr);
            } else {
                animatorSet2.playSequentially(animatorArr);
            }
        }
        return animator;
    }

    /* renamed from: a */
    private static Keyframe m44a(Keyframe keyframe, float f) {
        return keyframe.getType() == Float.TYPE ? Keyframe.ofFloat(f) : keyframe.getType() == Integer.TYPE ? Keyframe.ofInt(f) : Keyframe.ofObject(f);
    }

    /* renamed from: a */
    private static Keyframe m45a(Context context, Resources resources, Theme theme, AttributeSet attributeSet, int i, XmlPullParser xmlPullParser) {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C0030a.f46j);
        float namedFloat = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "fraction", 3, -1.0f);
        String str = "value";
        TypedValue peekNamedValue = TypedArrayUtils.peekNamedValue(obtainAttributes, xmlPullParser, str, 0);
        Object obj = peekNamedValue != null ? 1 : null;
        if (i == 4) {
            i = (obj == null || !C0037f.m54a(peekNamedValue.type)) ? 0 : 3;
        }
        Keyframe ofInt = obj != null ? i != 0 ? (i == 1 || i == 3) ? Keyframe.ofInt(namedFloat, TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, str, 0, 0)) : null : Keyframe.ofFloat(namedFloat, TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, str, 0, 0.0f)) : i == 0 ? Keyframe.ofFloat(namedFloat) : Keyframe.ofInt(namedFloat);
        int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainAttributes, xmlPullParser, "interpolator", 1, 0);
        if (namedResourceId > 0) {
            ofInt.setInterpolator(C0035e.m34a(context, namedResourceId));
        }
        obtainAttributes.recycle();
        return ofInt;
    }

    /* renamed from: a */
    private static ObjectAnimator m46a(Context context, Resources resources, Theme theme, AttributeSet attributeSet, float f, XmlPullParser xmlPullParser) {
        ValueAnimator objectAnimator = new ObjectAnimator();
        C0037f.m49a(context, resources, theme, attributeSet, objectAnimator, f, xmlPullParser);
        return objectAnimator;
    }

    /* renamed from: a */
    private static PropertyValuesHolder m47a(Context context, Resources resources, Theme theme, XmlPullParser xmlPullParser, String str, int i) {
        int size;
        int i2;
        Keyframe[] keyframeArr;
        PropertyValuesHolder propertyValuesHolder = null;
        int i3 = i;
        ArrayList arrayList = null;
        while (true) {
            Keyframe keyframe;
            Keyframe keyframe2;
            float fraction;
            float fraction2;
            int i4;
            int i5;
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                if (arrayList != null) {
                    size = arrayList.size();
                    if (size > 0) {
                        i2 = 0;
                        keyframe = (Keyframe) arrayList.get(0);
                        keyframe2 = (Keyframe) arrayList.get(size - 1);
                        fraction = keyframe2.getFraction();
                        if (fraction < 1.0f) {
                            if (fraction >= 0.0f) {
                                keyframe2.setFraction(1.0f);
                            } else {
                                arrayList.add(arrayList.size(), C0037f.m44a(keyframe2, 1.0f));
                                size++;
                            }
                        }
                        fraction2 = keyframe.getFraction();
                        if (fraction2 != 0.0f) {
                            if (fraction2 >= 0.0f) {
                                keyframe.setFraction(0.0f);
                            } else {
                                arrayList.add(0, C0037f.m44a(keyframe, 0.0f));
                                size++;
                            }
                        }
                        keyframeArr = new Keyframe[size];
                        arrayList.toArray(keyframeArr);
                        while (i2 < size) {
                            keyframe2 = keyframeArr[i2];
                            if (keyframe2.getFraction() >= 0.0f) {
                                if (i2 != 0) {
                                    keyframe2.setFraction(0.0f);
                                } else {
                                    i = size - 1;
                                    if (i2 != i) {
                                        keyframe2.setFraction(1.0f);
                                    } else {
                                        i4 = i2;
                                        for (i5 = i2 + 1; i5 < i; i5++) {
                                            if (keyframeArr[i5].getFraction() >= 0.0f) {
                                                break;
                                            }
                                            i4 = i5;
                                        }
                                        C0037f.m53a(keyframeArr, keyframeArr[i4 + 1].getFraction() - keyframeArr[i2 - 1].getFraction(), i2, i4);
                                    }
                                }
                            }
                            i2++;
                        }
                        propertyValuesHolder = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
                        if (i3 == 3) {
                            propertyValuesHolder.setEvaluator(C0038g.m56a());
                        }
                    }
                }
            } else if (xmlPullParser.getName().equals("keyframe")) {
                if (i3 == 4) {
                    i3 = C0037f.m37a(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                }
                Keyframe a = C0037f.m45a(context, resources, theme, Xml.asAttributeSet(xmlPullParser), i3, xmlPullParser);
                if (a != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(a);
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null) {
            size = arrayList.size();
            if (size > 0) {
                i2 = 0;
                keyframe = (Keyframe) arrayList.get(0);
                keyframe2 = (Keyframe) arrayList.get(size - 1);
                fraction = keyframe2.getFraction();
                if (fraction < 1.0f) {
                    if (fraction >= 0.0f) {
                        arrayList.add(arrayList.size(), C0037f.m44a(keyframe2, 1.0f));
                        size++;
                    } else {
                        keyframe2.setFraction(1.0f);
                    }
                }
                fraction2 = keyframe.getFraction();
                if (fraction2 != 0.0f) {
                    if (fraction2 >= 0.0f) {
                        arrayList.add(0, C0037f.m44a(keyframe, 0.0f));
                        size++;
                    } else {
                        keyframe.setFraction(0.0f);
                    }
                }
                keyframeArr = new Keyframe[size];
                arrayList.toArray(keyframeArr);
                while (i2 < size) {
                    keyframe2 = keyframeArr[i2];
                    if (keyframe2.getFraction() >= 0.0f) {
                        if (i2 != 0) {
                            i = size - 1;
                            if (i2 != i) {
                                i4 = i2;
                                for (i5 = i2 + 1; i5 < i; i5++) {
                                    if (keyframeArr[i5].getFraction() >= 0.0f) {
                                        break;
                                    }
                                    i4 = i5;
                                }
                                C0037f.m53a(keyframeArr, keyframeArr[i4 + 1].getFraction() - keyframeArr[i2 - 1].getFraction(), i2, i4);
                            } else {
                                keyframe2.setFraction(1.0f);
                            }
                        } else {
                            keyframe2.setFraction(0.0f);
                        }
                    }
                    i2++;
                }
                propertyValuesHolder = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
                if (i3 == 3) {
                    propertyValuesHolder.setEvaluator(C0038g.m56a());
                }
            }
        }
        return propertyValuesHolder;
    }

    /* renamed from: a */
    private static PropertyValuesHolder m48a(TypedArray typedArray, int i, int i2, int i3, String str) {
        TypedValue peekValue = typedArray.peekValue(i2);
        Object obj = peekValue != null ? 1 : null;
        int i4 = obj != null ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i3);
        Object obj2 = peekValue2 != null ? 1 : null;
        int i5 = obj2 != null ? peekValue2.type : 0;
        if (i == 4) {
            i = ((obj == null || !C0037f.m54a(i4)) && (obj2 == null || !C0037f.m54a(i5))) ? 0 : 3;
        }
        Object obj3 = i == 0 ? 1 : null;
        PropertyValuesHolder propertyValuesHolder = null;
        PropertyValuesHolder ofObject;
        if (i == 2) {
            String string = typedArray.getString(i2);
            String string2 = typedArray.getString(i3);
            PathDataNode[] createNodesFromPathData = PathParser.createNodesFromPathData(string);
            PathDataNode[] createNodesFromPathData2 = PathParser.createNodesFromPathData(string2);
            if (createNodesFromPathData == null && createNodesFromPathData2 == null) {
                return null;
            }
            if (createNodesFromPathData != null) {
                TypeEvaluator c0036a = new C0036a();
                if (createNodesFromPathData2 == null) {
                    ofObject = PropertyValuesHolder.ofObject(str, c0036a, new Object[]{createNodesFromPathData});
                } else if (PathParser.canMorph(createNodesFromPathData, createNodesFromPathData2)) {
                    ofObject = PropertyValuesHolder.ofObject(str, c0036a, new Object[]{createNodesFromPathData, createNodesFromPathData2});
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(" Can't morph from ");
                    stringBuilder.append(string);
                    stringBuilder.append(" to ");
                    stringBuilder.append(string2);
                    throw new InflateException(stringBuilder.toString());
                }
                return ofObject;
            } else if (createNodesFromPathData2 == null) {
                return null;
            } else {
                return PropertyValuesHolder.ofObject(str, new C0036a(), new Object[]{createNodesFromPathData2});
            }
        }
        TypeEvaluator a = i == 3 ? C0038g.m56a() : null;
        if (obj3 != null) {
            float dimension;
            if (obj != null) {
                float dimension2 = i4 == 5 ? typedArray.getDimension(i2, 0.0f) : typedArray.getFloat(i2, 0.0f);
                if (obj2 != null) {
                    dimension = i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f);
                    ofObject = PropertyValuesHolder.ofFloat(str, new float[]{dimension2, dimension});
                } else {
                    ofObject = PropertyValuesHolder.ofFloat(str, new float[]{dimension2});
                }
            } else {
                dimension = i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f);
                ofObject = PropertyValuesHolder.ofFloat(str, new float[]{dimension});
            }
            propertyValuesHolder = ofObject;
        } else if (obj != null) {
            i2 = i4 == 5 ? (int) typedArray.getDimension(i2, 0.0f) : C0037f.m54a(i4) ? typedArray.getColor(i2, 0) : typedArray.getInt(i2, 0);
            if (obj2 != null) {
                r11 = i5 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : C0037f.m54a(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0);
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, new int[]{i2, r11});
            } else {
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, new int[]{i2});
            }
        } else if (obj2 != null) {
            r11 = i5 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : C0037f.m54a(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0);
            propertyValuesHolder = PropertyValuesHolder.ofInt(str, new int[]{r11});
        }
        if (propertyValuesHolder == null || a == null) {
            return propertyValuesHolder;
        }
        propertyValuesHolder.setEvaluator(a);
        return propertyValuesHolder;
    }

    /* renamed from: a */
    private static ValueAnimator m49a(Context context, Resources resources, Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f, XmlPullParser xmlPullParser) {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C0030a.f43g);
        TypedArray obtainAttributes2 = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C0030a.f47k);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        C0037f.m51a(valueAnimator, obtainAttributes, obtainAttributes2, f, xmlPullParser);
        int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainAttributes, xmlPullParser, "interpolator", 0, 0);
        if (namedResourceId > 0) {
            valueAnimator.setInterpolator(C0035e.m34a(context, namedResourceId));
        }
        obtainAttributes.recycle();
        if (obtainAttributes2 != null) {
            obtainAttributes2.recycle();
        }
        return valueAnimator;
    }

    /* renamed from: a */
    private static void m50a(ValueAnimator valueAnimator, TypedArray typedArray, int i, float f, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String namedString = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "pathData", 1);
        if (namedString != null) {
            String namedString2 = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "propertyXName", 2);
            String namedString3 = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "propertyYName", 3);
            if (i != 2) {
            }
            if (namedString2 == null) {
                if (namedString3 == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(typedArray.getPositionDescription());
                    stringBuilder.append(" propertyXName or propertyYName is needed for PathData");
                    throw new InflateException(stringBuilder.toString());
                }
            }
            C0037f.m52a(PathParser.createPathFromPathData(namedString), objectAnimator, f * 0.5f, namedString2, namedString3);
            return;
        }
        objectAnimator.setPropertyName(TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "propertyName", 0));
    }

    /* renamed from: a */
    private static void m51a(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f, XmlPullParser xmlPullParser) {
        long namedInt = (long) TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "duration", 1, 300);
        long namedInt2 = (long) TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "startOffset", 2, 0);
        int namedInt3 = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "valueType", 7, 4);
        if (TypedArrayUtils.hasAttribute(xmlPullParser, "valueFrom") && TypedArrayUtils.hasAttribute(xmlPullParser, "valueTo")) {
            if (namedInt3 == 4) {
                namedInt3 = C0037f.m38a(typedArray, 5, 6);
            }
            if (C0037f.m48a(typedArray, namedInt3, 5, 6, "") != null) {
                valueAnimator.setValues(new PropertyValuesHolder[]{C0037f.m48a(typedArray, namedInt3, 5, 6, "")});
            }
        }
        valueAnimator.setDuration(namedInt);
        valueAnimator.setStartDelay(namedInt2);
        valueAnimator.setRepeatCount(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            C0037f.m50a(valueAnimator, typedArray2, namedInt3, f, xmlPullParser);
        }
    }

    /* renamed from: a */
    private static void m52a(Path path, ObjectAnimator objectAnimator, float f, String str, String str2) {
        Path path2 = path;
        ObjectAnimator objectAnimator2 = objectAnimator;
        String str3 = str;
        String str4 = str2;
        PathMeasure pathMeasure = new PathMeasure(path2, false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(0.0f));
        float f2 = 0.0f;
        do {
            f2 += pathMeasure.getLength();
            arrayList.add(Float.valueOf(f2));
        } while (pathMeasure.nextContour());
        pathMeasure = new PathMeasure(path2, false);
        int min = Math.min(100, ((int) (f2 / f)) + 1);
        float[] fArr = new float[min];
        float[] fArr2 = new float[min];
        float[] fArr3 = new float[2];
        f2 /= (float) (min - 1);
        int i = 0;
        float f3 = 0.0f;
        int i2 = 0;
        while (true) {
            float[] fArr4 = null;
            if (i >= min) {
                break;
            }
            pathMeasure.getPosTan(f3 - ((Float) arrayList.get(i2)).floatValue(), fArr3, null);
            fArr[i] = fArr3[0];
            fArr2[i] = fArr3[1];
            f3 += f2;
            int i3 = i2 + 1;
            if (i3 < arrayList.size() && f3 > ((Float) arrayList.get(i3)).floatValue()) {
                pathMeasure.nextContour();
                i2 = i3;
            }
            i++;
        }
        PropertyValuesHolder ofFloat = str3 != null ? PropertyValuesHolder.ofFloat(str3, fArr) : null;
        if (str4 != null) {
            fArr4 = PropertyValuesHolder.ofFloat(str4, fArr2);
        }
        if (ofFloat == null) {
            objectAnimator2.setValues(new PropertyValuesHolder[]{fArr4});
        } else if (fArr4 == null) {
            objectAnimator2.setValues(new PropertyValuesHolder[]{ofFloat});
        } else {
            objectAnimator2.setValues(new PropertyValuesHolder[]{ofFloat, fArr4});
        }
    }

    /* renamed from: a */
    private static void m53a(Keyframe[] keyframeArr, float f, int i, int i2) {
        f /= (float) ((i2 - i) + 2);
        while (i <= i2) {
            keyframeArr[i].setFraction(keyframeArr[i - 1].getFraction() + f);
            i++;
        }
    }

    /* renamed from: a */
    private static boolean m54a(int i) {
        return i >= 28 && i <= 31;
    }

    /* renamed from: a */
    private static PropertyValuesHolder[] m55a(Context context, Resources resources, Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        PropertyValuesHolder[] propertyValuesHolderArr = null;
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            int i = 0;
            if (eventType != 3 && eventType != 1) {
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C0030a.f45i);
                        String namedString = TypedArrayUtils.getNamedString(obtainAttributes, xmlPullParser2, "propertyName", 3);
                        int namedInt = TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser2, "valueType", 2, 4);
                        int i2 = namedInt;
                        Object a = C0037f.m47a(context, resources, theme, xmlPullParser, namedString, namedInt);
                        if (a == null) {
                            a = C0037f.m48a(obtainAttributes, i2, 0, 1, namedString);
                        }
                        if (a != null) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(a);
                        }
                        obtainAttributes.recycle();
                    } else {
                        Resources resources2 = resources;
                        Theme theme2 = theme;
                        AttributeSet attributeSet2 = attributeSet;
                    }
                }
                xmlPullParser.next();
            } else if (arrayList != null) {
                eventType = arrayList.size();
                propertyValuesHolderArr = new PropertyValuesHolder[eventType];
                while (i < eventType) {
                    propertyValuesHolderArr[i] = (PropertyValuesHolder) arrayList.get(i);
                    i++;
                }
            }
        }
        if (arrayList != null) {
            eventType = arrayList.size();
            propertyValuesHolderArr = new PropertyValuesHolder[eventType];
            while (i < eventType) {
                propertyValuesHolderArr[i] = (PropertyValuesHolder) arrayList.get(i);
                i++;
            }
        }
        return propertyValuesHolderArr;
    }
}
