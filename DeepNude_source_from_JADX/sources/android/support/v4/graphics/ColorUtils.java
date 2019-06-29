package android.support.v4.graphics;

import android.graphics.Color;
import android.support.v4.view.ViewCompat;
import java.util.Objects;

public final class ColorUtils {
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;
    private static final ThreadLocal<double[]> TEMP_ARRAY = new ThreadLocal();
    private static final double XYZ_EPSILON = 0.008856d;
    private static final double XYZ_KAPPA = 903.3d;
    private static final double XYZ_WHITE_REFERENCE_X = 95.047d;
    private static final double XYZ_WHITE_REFERENCE_Y = 100.0d;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883d;

    private ColorUtils() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int HSLToColor(float[] r6) {
        /*
        r0 = 0;
        r1 = r6[r0];
        r2 = 1;
        r2 = r6[r2];
        r3 = 2;
        r6 = r6[r3];
        r3 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r4 = r6 * r3;
        r5 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r4 = r4 - r5;
        r4 = java.lang.Math.abs(r4);
        r4 = r5 - r4;
        r4 = r4 * r2;
        r2 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r2 = r2 * r4;
        r6 = r6 - r2;
        r2 = 1114636288; // 0x42700000 float:60.0 double:5.507034975E-315;
        r2 = r1 / r2;
        r2 = r2 % r3;
        r2 = r2 - r5;
        r2 = java.lang.Math.abs(r2);
        r5 = r5 - r2;
        r5 = r5 * r4;
        r1 = (int) r1;
        r1 = r1 / 60;
        r2 = 1132396544; // 0x437f0000 float:255.0 double:5.5947823E-315;
        switch(r1) {
            case 0: goto L_0x008b;
            case 1: goto L_0x007c;
            case 2: goto L_0x0067;
            case 3: goto L_0x0052;
            case 4: goto L_0x0044;
            case 5: goto L_0x0036;
            case 6: goto L_0x0036;
            default: goto L_0x0032;
        };
    L_0x0032:
        r6 = 0;
        r1 = 0;
        r3 = 0;
        goto L_0x009f;
    L_0x0036:
        r4 = r4 + r6;
        r4 = r4 * r2;
        r1 = java.lang.Math.round(r4);
        r3 = r6 * r2;
        r3 = java.lang.Math.round(r3);
        goto L_0x0074;
    L_0x0044:
        r5 = r5 + r6;
        r5 = r5 * r2;
        r1 = java.lang.Math.round(r5);
        r3 = r6 * r2;
        r3 = java.lang.Math.round(r3);
        goto L_0x005f;
    L_0x0052:
        r1 = r6 * r2;
        r1 = java.lang.Math.round(r1);
        r5 = r5 + r6;
        r5 = r5 * r2;
        r3 = java.lang.Math.round(r5);
    L_0x005f:
        r4 = r4 + r6;
        r4 = r4 * r2;
        r6 = java.lang.Math.round(r4);
        goto L_0x009f;
    L_0x0067:
        r1 = r6 * r2;
        r1 = java.lang.Math.round(r1);
        r4 = r4 + r6;
        r4 = r4 * r2;
        r3 = java.lang.Math.round(r4);
    L_0x0074:
        r5 = r5 + r6;
        r5 = r5 * r2;
        r6 = java.lang.Math.round(r5);
        goto L_0x009f;
    L_0x007c:
        r5 = r5 + r6;
        r5 = r5 * r2;
        r1 = java.lang.Math.round(r5);
        r4 = r4 + r6;
        r4 = r4 * r2;
        r3 = java.lang.Math.round(r4);
        goto L_0x0099;
    L_0x008b:
        r4 = r4 + r6;
        r4 = r4 * r2;
        r1 = java.lang.Math.round(r4);
        r5 = r5 + r6;
        r5 = r5 * r2;
        r3 = java.lang.Math.round(r5);
    L_0x0099:
        r6 = r6 * r2;
        r6 = java.lang.Math.round(r6);
    L_0x009f:
        r2 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r1 = constrain(r1, r0, r2);
        r3 = constrain(r3, r0, r2);
        r6 = constrain(r6, r0, r2);
        r6 = android.graphics.Color.rgb(r1, r3, r6);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.ColorUtils.HSLToColor(float[]):int");
    }

    public static int LABToColor(double d, double d2, double d3) {
        double[] tempDouble3Array = getTempDouble3Array();
        LABToXYZ(d, d2, d3, tempDouble3Array);
        return XYZToColor(tempDouble3Array[0], tempDouble3Array[1], tempDouble3Array[2]);
    }

    public static void LABToXYZ(double d, double d2, double d3, double[] dArr) {
        double d4 = (d + 16.0d) / 116.0d;
        double d5 = (d2 / 500.0d) + d4;
        double d6 = d4 - (d3 / 200.0d);
        double pow = Math.pow(d5, 3.0d);
        if (pow <= XYZ_EPSILON) {
            pow = ((d5 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        d4 = d > 7.9996247999999985d ? Math.pow(d4, 3.0d) : d / XYZ_KAPPA;
        d5 = Math.pow(d6, 3.0d);
        if (d5 <= XYZ_EPSILON) {
            d5 = ((d6 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        dArr[0] = pow * XYZ_WHITE_REFERENCE_X;
        dArr[1] = d4 * XYZ_WHITE_REFERENCE_Y;
        dArr[2] = d5 * XYZ_WHITE_REFERENCE_Z;
    }

    public static void RGBToHSL(int i, int i2, int i3, float[] fArr) {
        float f = ((float) i) / 255.0f;
        float f2 = ((float) i2) / 255.0f;
        float f3 = ((float) i3) / 255.0f;
        float max = Math.max(f, Math.max(f2, f3));
        float min = Math.min(f, Math.min(f2, f3));
        float f4 = max - min;
        float f5 = (max + min) / 2.0f;
        if (max == min) {
            f = 0.0f;
            f2 = 0.0f;
        } else {
            f = max == f ? ((f2 - f3) / f4) % 6.0f : max == f2 ? ((f3 - f) / f4) + 2.0f : ((f - f2) / f4) + 4.0f;
            f2 = f4 / (1.0f - Math.abs((2.0f * f5) - 1.0f));
        }
        f = (f * 60.0f) % 360.0f;
        if (f < 0.0f) {
            f += 360.0f;
        }
        fArr[0] = constrain(f, 0.0f, 360.0f);
        fArr[1] = constrain(f2, 0.0f, 1.0f);
        fArr[2] = constrain(f5, 0.0f, 1.0f);
    }

    public static void RGBToLAB(int i, int i2, int i3, double[] dArr) {
        RGBToXYZ(i, i2, i3, dArr);
        XYZToLAB(dArr[0], dArr[1], dArr[2], dArr);
    }

    public static void RGBToXYZ(int i, int i2, int i3, double[] dArr) {
        double[] dArr2 = dArr;
        if (dArr2.length == 3) {
            double d = (double) i;
            Double.isNaN(d);
            d /= 255.0d;
            double pow = d < 0.04045d ? d / 12.92d : Math.pow((d + 0.055d) / 1.055d, 2.4d);
            d = (double) i2;
            Double.isNaN(d);
            d /= 255.0d;
            double pow2 = d < 0.04045d ? d / 12.92d : Math.pow((d + 0.055d) / 1.055d, 2.4d);
            d = (double) i3;
            Double.isNaN(d);
            d /= 255.0d;
            d = d < 0.04045d ? d / 12.92d : Math.pow((d + 0.055d) / 1.055d, 2.4d);
            dArr2[0] = (((0.4124d * pow) + (0.3576d * pow2)) + (0.1805d * d)) * XYZ_WHITE_REFERENCE_Y;
            dArr2[1] = (((0.2126d * pow) + (0.7152d * pow2)) + (0.0722d * d)) * XYZ_WHITE_REFERENCE_Y;
            dArr2[2] = (((pow * 0.0193d) + (pow2 * 0.1192d)) + (d * 0.9505d)) * XYZ_WHITE_REFERENCE_Y;
            return;
        }
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    public static int XYZToColor(double d, double d2, double d3) {
        double d4 = (((3.2406d * d) + (-1.5372d * d2)) + (-0.4986d * d3)) / XYZ_WHITE_REFERENCE_Y;
        double d5 = (((-0.9689d * d) + (1.8758d * d2)) + (0.0415d * d3)) / XYZ_WHITE_REFERENCE_Y;
        double d6 = (((0.0557d * d) + (-0.204d * d2)) + (1.057d * d3)) / XYZ_WHITE_REFERENCE_Y;
        return Color.rgb(constrain((int) Math.round((d4 > 0.0031308d ? (Math.pow(d4, 0.4166666666666667d) * 1.055d) - 0.055d : d4 * 12.92d) * 255.0d), 0, 255), constrain((int) Math.round((d5 > 0.0031308d ? (Math.pow(d5, 0.4166666666666667d) * 1.055d) - 0.055d : d5 * 12.92d) * 255.0d), 0, 255), constrain((int) Math.round((d6 > 0.0031308d ? (Math.pow(d6, 0.4166666666666667d) * 1.055d) - 0.055d : d6 * 12.92d) * 255.0d), 0, 255));
    }

    public static void XYZToLAB(double d, double d2, double d3, double[] dArr) {
        if (dArr.length == 3) {
            d = pivotXyzComponent(d / XYZ_WHITE_REFERENCE_X);
            d2 = pivotXyzComponent(d2 / XYZ_WHITE_REFERENCE_Y);
            d3 = pivotXyzComponent(d3 / XYZ_WHITE_REFERENCE_Z);
            dArr[0] = Math.max(0.0d, (116.0d * d2) - 16.0d);
            dArr[1] = (d - d2) * 500.0d;
            dArr[2] = (d2 - d3) * 200.0d;
            return;
        }
        throw new IllegalArgumentException("outLab must have a length of 3.");
    }

    public static int blendARGB(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((((float) Color.alpha(i)) * f2) + (((float) Color.alpha(i2)) * f)), (int) ((((float) Color.red(i)) * f2) + (((float) Color.red(i2)) * f)), (int) ((((float) Color.green(i)) * f2) + (((float) Color.green(i2)) * f)), (int) ((((float) Color.blue(i)) * f2) + (((float) Color.blue(i2)) * f)));
    }

    public static void blendHSL(float[] fArr, float[] fArr2, float f, float[] fArr3) {
        if (fArr3.length == 3) {
            float f2 = 1.0f - f;
            fArr3[0] = circularInterpolate(fArr[0], fArr2[0], f);
            fArr3[1] = (fArr[1] * f2) + (fArr2[1] * f);
            fArr3[2] = (fArr[2] * f2) + (fArr2[2] * f);
            return;
        }
        throw new IllegalArgumentException("result must have a length of 3.");
    }

    public static void blendLAB(double[] dArr, double[] dArr2, double d, double[] dArr3) {
        if (dArr3.length == 3) {
            double d2 = 1.0d - d;
            dArr3[0] = (dArr[0] * d2) + (dArr2[0] * d);
            dArr3[1] = (dArr[1] * d2) + (dArr2[1] * d);
            dArr3[2] = (dArr[2] * d2) + (dArr2[2] * d);
            return;
        }
        throw new IllegalArgumentException("outResult must have a length of 3.");
    }

    public static double calculateContrast(int i, int i2) {
        if (Color.alpha(i2) == 255) {
            if (Color.alpha(i) < 255) {
                i = compositeColors(i, i2);
            }
            double calculateLuminance = calculateLuminance(i) + 0.05d;
            double calculateLuminance2 = calculateLuminance(i2) + 0.05d;
            return Math.max(calculateLuminance, calculateLuminance2) / Math.min(calculateLuminance, calculateLuminance2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("background can not be translucent: #");
        stringBuilder.append(Integer.toHexString(i2));
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static double calculateLuminance(int i) {
        double[] tempDouble3Array = getTempDouble3Array();
        colorToXYZ(i, tempDouble3Array);
        return tempDouble3Array[1] / XYZ_WHITE_REFERENCE_Y;
    }

    public static int calculateMinimumAlpha(int i, int i2, float f) {
        int i3 = 255;
        if (Color.alpha(i2) == 255) {
            double d = (double) f;
            if (calculateContrast(setAlphaComponent(i, 255), i2) < d) {
                return -1;
            }
            int i4 = 0;
            for (int i5 = 0; i5 <= 10 && i3 - i4 > 1; i5++) {
                int i6 = (i4 + i3) / 2;
                if (calculateContrast(setAlphaComponent(i, i6), i2) < d) {
                    i4 = i6;
                } else {
                    i3 = i6;
                }
            }
            return i3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("background can not be translucent: #");
        stringBuilder.append(Integer.toHexString(i2));
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    static float circularInterpolate(float f, float f2, float f3) {
        if (Math.abs(f2 - f) > 180.0f) {
            if (f2 > f) {
                f += 360.0f;
            } else {
                f2 += 360.0f;
            }
        }
        return (f + ((f2 - f) * f3)) % 360.0f;
    }

    public static void colorToHSL(int i, float[] fArr) {
        RGBToHSL(Color.red(i), Color.green(i), Color.blue(i), fArr);
    }

    public static void colorToLAB(int i, double[] dArr) {
        RGBToLAB(Color.red(i), Color.green(i), Color.blue(i), dArr);
    }

    public static void colorToXYZ(int i, double[] dArr) {
        RGBToXYZ(Color.red(i), Color.green(i), Color.blue(i), dArr);
    }

    private static int compositeAlpha(int i, int i2) {
        return 255 - (((255 - i2) * (255 - i)) / 255);
    }

    public static int compositeColors(int i, int i2) {
        int alpha = Color.alpha(i2);
        int alpha2 = Color.alpha(i);
        int compositeAlpha = compositeAlpha(alpha2, alpha);
        return Color.argb(compositeAlpha, compositeComponent(Color.red(i), alpha2, Color.red(i2), alpha, compositeAlpha), compositeComponent(Color.green(i), alpha2, Color.green(i2), alpha, compositeAlpha), compositeComponent(Color.blue(i), alpha2, Color.blue(i2), alpha, compositeAlpha));
    }

    public static Color compositeColors(Color color, Color color2) {
        if (Objects.equals(color.getModel(), color2.getModel())) {
            if (!Objects.equals(color2.getColorSpace(), color.getColorSpace())) {
                color = color.convert(color2.getColorSpace());
            }
            float[] components = color.getComponents();
            float[] components2 = color2.getComponents();
            float alpha = color.alpha();
            float alpha2 = color2.alpha() * (1.0f - alpha);
            int componentCount = color2.getComponentCount() - 1;
            components2[componentCount] = alpha + alpha2;
            if (components2[componentCount] > 0.0f) {
                alpha /= components2[componentCount];
                alpha2 /= components2[componentCount];
            }
            for (int i = 0; i < componentCount; i++) {
                components2[i] = (components[i] * alpha) + (components2[i] * alpha2);
            }
            return Color.valueOf(components2, color2.getColorSpace());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Color models must match (");
        stringBuilder.append(color.getModel());
        stringBuilder.append(" vs. ");
        stringBuilder.append(color2.getModel());
        stringBuilder.append(")");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private static int compositeComponent(int i, int i2, int i3, int i4, int i5) {
        return i5 == 0 ? 0 : (((i * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }

    private static float constrain(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    private static int constrain(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public static double distanceEuclidean(double[] dArr, double[] dArr2) {
        return Math.sqrt((Math.pow(dArr[0] - dArr2[0], 2.0d) + Math.pow(dArr[1] - dArr2[1], 2.0d)) + Math.pow(dArr[2] - dArr2[2], 2.0d));
    }

    private static double[] getTempDouble3Array() {
        double[] dArr = (double[]) TEMP_ARRAY.get();
        if (dArr != null) {
            return dArr;
        }
        Object obj = new double[3];
        TEMP_ARRAY.set(obj);
        return obj;
    }

    private static double pivotXyzComponent(double d) {
        return d > XYZ_EPSILON ? Math.pow(d, 0.3333333333333333d) : ((d * XYZ_KAPPA) + 16.0d) / 116.0d;
    }

    public static int setAlphaComponent(int i, int i2) {
        if (i2 >= 0 && i2 <= 255) {
            return (i & ViewCompat.MEASURED_SIZE_MASK) | (i2 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}
