package android.support.v4.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p000a.p005b.p006a.C0007a;
import p000a.p005b.p006a.C0015i;

public final class ColorStateListInflaterCompat {
    private static final int DEFAULT_COLOR = -65536;

    private ColorStateListInflaterCompat() {
    }

    public static ColorStateList createFromXml(Resources resources, XmlPullParser xmlPullParser, Theme theme) {
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 2 || next == 1) {
                if (next == 2) {
                    return createFromXmlInner(resources, xmlPullParser, asAttributeSet, theme);
                }
                throw new XmlPullParserException("No start tag found");
            }
        }
        if (next == 2) {
            return createFromXmlInner(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return inflate(resources, xmlPullParser, attributeSet, theme);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(xmlPullParser.getPositionDescription());
        stringBuilder.append(": invalid color state list tag ");
        stringBuilder.append(name);
        throw new XmlPullParserException(stringBuilder.toString());
    }

    private static ColorStateList inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        AttributeSet attributeSet2 = attributeSet;
        int i = 1;
        int depth = xmlPullParser.getDepth() + 1;
        Object obj = new int[20][];
        Object obj2 = new int[obj.length];
        int i2 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i) {
                break;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                break;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals("item")) {
                    int i3;
                    int[] iArr;
                    int i4;
                    int i5;
                    int attributeNameResource;
                    Object trimStateSet;
                    TypedArray obtainAttributes = obtainAttributes(resources, theme, attributeSet2, C0015i.ColorStateListItem);
                    int color = obtainAttributes.getColor(C0015i.ColorStateListItem_android_color, -65281);
                    float f = 1.0f;
                    if (obtainAttributes.hasValue(C0015i.ColorStateListItem_android_alpha)) {
                        i3 = C0015i.ColorStateListItem_android_alpha;
                    } else {
                        if (obtainAttributes.hasValue(C0015i.ColorStateListItem_alpha)) {
                            i3 = C0015i.ColorStateListItem_alpha;
                        }
                        obtainAttributes.recycle();
                        next = attributeSet.getAttributeCount();
                        iArr = new int[next];
                        i4 = 0;
                        for (i5 = 0; i5 < next; i5++) {
                            attributeNameResource = attributeSet2.getAttributeNameResource(i5);
                            if (!(attributeNameResource == 16843173 || attributeNameResource == 16843551 || attributeNameResource == C0007a.alpha)) {
                                i = i4 + 1;
                                if (attributeSet2.getAttributeBooleanValue(i5, false)) {
                                    attributeNameResource = -attributeNameResource;
                                }
                                iArr[i4] = attributeNameResource;
                                i4 = i;
                            }
                        }
                        trimStateSet = StateSet.trimStateSet(iArr, i4);
                        next = modulateColorAlpha(color, f);
                        if (i2 != 0) {
                            color = trimStateSet.length;
                        }
                        obj2 = GrowingArrayUtils.append((int[]) obj2, i2, next);
                        obj = (int[][]) GrowingArrayUtils.append((Object[]) obj, i2, trimStateSet);
                        i2++;
                        i = 1;
                    }
                    f = obtainAttributes.getFloat(i3, 1.0f);
                    obtainAttributes.recycle();
                    next = attributeSet.getAttributeCount();
                    iArr = new int[next];
                    i4 = 0;
                    for (i5 = 0; i5 < next; i5++) {
                        attributeNameResource = attributeSet2.getAttributeNameResource(i5);
                        i = i4 + 1;
                        if (attributeSet2.getAttributeBooleanValue(i5, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr[i4] = attributeNameResource;
                        i4 = i;
                    }
                    trimStateSet = StateSet.trimStateSet(iArr, i4);
                    next = modulateColorAlpha(color, f);
                    if (i2 != 0) {
                        color = trimStateSet.length;
                    }
                    obj2 = GrowingArrayUtils.append((int[]) obj2, i2, next);
                    obj = (int[][]) GrowingArrayUtils.append((Object[]) obj, i2, trimStateSet);
                    i2++;
                    i = 1;
                }
            }
            Resources resources2 = resources;
            Theme theme2 = theme;
            i = 1;
        }
        Object obj3 = new int[i2];
        Object obj4 = new int[i2][];
        System.arraycopy(obj2, 0, obj3, 0, i2);
        System.arraycopy(obj, 0, obj4, 0, i2);
        return new ColorStateList(obj4, obj3);
    }

    private static int modulateColorAlpha(int i, float f) {
        return (i & ViewCompat.MEASURED_SIZE_MASK) | (Math.round(((float) Color.alpha(i)) * f) << 24);
    }

    private static TypedArray obtainAttributes(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
