package android.support.v4.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ComplexColorCompat {
    private static final String LOG_TAG = "ComplexColorCompat";
    private int mColor;
    private final ColorStateList mColorStateList;
    private final Shader mShader;

    private ComplexColorCompat(Shader shader, ColorStateList colorStateList, int i) {
        this.mShader = shader;
        this.mColorStateList = colorStateList;
        this.mColor = i;
    }

    private static ComplexColorCompat createFromXml(Resources resources, int i, Theme theme) {
        int hashCode;
        XmlPullParser xml = resources.getXml(i);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        while (true) {
            int next = xml.next();
            String name;
            Object obj;
            if (next == 2 || next == 1) {
                if (next != 2) {
                    name = xml.getName();
                    obj = -1;
                    hashCode = name.hashCode();
                    if (hashCode == 89650992) {
                        if (hashCode != 1191572447) {
                            if (name.equals("selector")) {
                                obj = null;
                            }
                        }
                    } else if (name.equals("gradient")) {
                        obj = 1;
                    }
                    if (obj != null) {
                        return from(ColorStateListInflaterCompat.createFromXmlInner(resources, xml, asAttributeSet, theme));
                    }
                    if (obj == 1) {
                        return from(GradientColorInflaterCompat.createFromXmlInner(resources, xml, asAttributeSet, theme));
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(xml.getPositionDescription());
                    stringBuilder.append(": unsupported complex color tag ");
                    stringBuilder.append(name);
                    throw new XmlPullParserException(stringBuilder.toString());
                }
                throw new XmlPullParserException("No start tag found");
            }
        }
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        name = xml.getName();
        obj = -1;
        hashCode = name.hashCode();
        if (hashCode == 89650992) {
            if (name.equals("gradient")) {
                obj = 1;
            }
        } else if (hashCode != 1191572447) {
            if (name.equals("selector")) {
                obj = null;
            }
        }
        if (obj != null) {
            return from(ColorStateListInflaterCompat.createFromXmlInner(resources, xml, asAttributeSet, theme));
        }
        if (obj == 1) {
            return from(GradientColorInflaterCompat.createFromXmlInner(resources, xml, asAttributeSet, theme));
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(xml.getPositionDescription());
        stringBuilder2.append(": unsupported complex color tag ");
        stringBuilder2.append(name);
        throw new XmlPullParserException(stringBuilder2.toString());
    }

    static ComplexColorCompat from(int i) {
        return new ComplexColorCompat(null, null, i);
    }

    static ComplexColorCompat from(ColorStateList colorStateList) {
        return new ComplexColorCompat(null, colorStateList, colorStateList.getDefaultColor());
    }

    static ComplexColorCompat from(Shader shader) {
        return new ComplexColorCompat(shader, null, 0);
    }

    public static ComplexColorCompat inflate(Resources resources, int i, Theme theme) {
        try {
            return createFromXml(resources, i, theme);
        } catch (Throwable e) {
            Log.e(LOG_TAG, "Failed to inflate ComplexColor.", e);
            return null;
        }
    }

    public int getColor() {
        return this.mColor;
    }

    public Shader getShader() {
        return this.mShader;
    }

    public boolean isGradient() {
        return this.mShader != null;
    }

    public boolean isStateful() {
        if (this.mShader == null) {
            ColorStateList colorStateList = this.mColorStateList;
            if (colorStateList != null && colorStateList.isStateful()) {
                return true;
            }
        }
        return false;
    }

    public boolean onStateChanged(int[] iArr) {
        if (isStateful()) {
            ColorStateList colorStateList = this.mColorStateList;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.mColor) {
                this.mColor = colorForState;
                return true;
            }
        }
        return false;
    }

    public void setColor(int i) {
        this.mColor = i;
    }

    public boolean willDraw() {
        if (!isGradient()) {
            if (this.mColor == 0) {
                return false;
            }
        }
        return true;
    }
}
