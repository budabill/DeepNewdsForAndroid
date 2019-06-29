package android.support.v4.graphics;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

public class PathParser {
    private static final String LOGTAG = "PathParser";

    private static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;

        ExtractFloatResult() {
        }
    }

    public static class PathDataNode {
        public float[] mParams;
        public char mType;

        PathDataNode(char c, float[] fArr) {
            this.mType = c;
            this.mParams = fArr;
        }

        PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            float[] fArr = pathDataNode.mParams;
            this.mParams = PathParser.copyOfRange(fArr, 0, fArr.length);
        }

        private static void addCommand(Path path, float[] fArr, char c, char c2, float[] fArr2) {
            int i;
            float f;
            Path path2 = path;
            char c3 = c2;
            float[] fArr3 = fArr2;
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[2];
            float f5 = fArr[3];
            float f6 = fArr[4];
            float f7 = fArr[5];
            switch (c3) {
                case 'A':
                case 'a':
                    i = 7;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path2.moveTo(f6, f7);
                    f2 = f6;
                    f4 = f2;
                    f3 = f7;
                    f5 = f3;
                    break;
            }
            i = 2;
            float f8 = f2;
            float f9 = f3;
            float f10 = f6;
            float f11 = f7;
            int i2 = 0;
            char c4 = c;
            while (i2 < fArr3.length) {
                int i3;
                int i4;
                int i5;
                if (c3 != 'A') {
                    int i6;
                    int i7;
                    if (c3 == 'C') {
                        i3 = i2;
                        i2 = i3 + 2;
                        i6 = i3 + 3;
                        i7 = i3 + 4;
                        int i8 = i3 + 5;
                        path.cubicTo(fArr3[i3 + 0], fArr3[i3 + 1], fArr3[i2], fArr3[i6], fArr3[i7], fArr3[i8]);
                        f8 = fArr3[i7];
                        f2 = fArr3[i8];
                        f3 = fArr3[i2];
                        f4 = fArr3[i6];
                        f9 = f2;
                        f5 = f4;
                        f4 = f3;
                    } else if (c3 == 'H') {
                        i3 = i2;
                        i2 = i3 + 0;
                        path2.lineTo(fArr3[i2], f9);
                        f8 = fArr3[i2];
                    } else if (c3 == 'Q') {
                        i3 = i2;
                        i2 = i3 + 0;
                        r1 = i3 + 1;
                        r3 = i3 + 2;
                        int i9 = i3 + 3;
                        path2.quadTo(fArr3[i2], fArr3[r1], fArr3[r3], fArr3[i9]);
                        f2 = fArr3[i2];
                        f3 = fArr3[r1];
                        f8 = fArr3[r3];
                        f9 = fArr3[i9];
                        f4 = f2;
                        f5 = f3;
                    } else if (c3 == 'V') {
                        i3 = i2;
                        i2 = i3 + 0;
                        path2.lineTo(f8, fArr3[i2]);
                        f9 = fArr3[i2];
                    } else if (c3 != 'a') {
                        int i10;
                        if (c3 == 'c') {
                            i4 = i2 + 2;
                            i5 = i2 + 3;
                            i10 = i2 + 4;
                            i3 = i2 + 5;
                            path.rCubicTo(fArr3[i2 + 0], fArr3[i2 + 1], fArr3[i4], fArr3[i5], fArr3[i10], fArr3[i3]);
                            f2 = fArr3[i4] + f8;
                            f3 = fArr3[i5] + f9;
                            f8 += fArr3[i10];
                            f4 = fArr3[i3];
                            f9 += f4;
                            f4 = f2;
                            f5 = f3;
                        } else if (c3 != 'h') {
                            int i11;
                            int i12;
                            if (c3 != 'q') {
                                if (c3 == 'v') {
                                    r0 = i2 + 0;
                                    path2.rLineTo(0.0f, fArr3[r0]);
                                    f2 = fArr3[r0];
                                } else if (c3 != 'L') {
                                    if (c3 == 'M') {
                                        r0 = i2 + 0;
                                        f8 = fArr3[r0];
                                        r1 = i2 + 1;
                                        f9 = fArr3[r1];
                                        if (i2 > 0) {
                                            path2.lineTo(fArr3[r0], fArr3[r1]);
                                        } else {
                                            path2.moveTo(fArr3[r0], fArr3[r1]);
                                        }
                                    } else if (c3 == 'S') {
                                        if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                            f8 = (f8 * 2.0f) - f4;
                                            f9 = (f9 * 2.0f) - f5;
                                        }
                                        f4 = f9;
                                        i6 = i2 + 0;
                                        i7 = i2 + 1;
                                        i4 = i2 + 2;
                                        i5 = i2 + 3;
                                        path.cubicTo(f8, f4, fArr3[i6], fArr3[i7], fArr3[i4], fArr3[i5]);
                                        f2 = fArr3[i6];
                                        f3 = fArr3[i7];
                                        f8 = fArr3[i4];
                                        f9 = fArr3[i5];
                                        f4 = f2;
                                        f5 = f3;
                                    } else if (c3 == 'T') {
                                        if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                            f8 = (f8 * 2.0f) - f4;
                                            f9 = (f9 * 2.0f) - f5;
                                        }
                                        r0 = i2 + 0;
                                        i11 = i2 + 1;
                                        path2.quadTo(f8, f9, fArr3[r0], fArr3[i11]);
                                        f2 = fArr3[r0];
                                        f3 = fArr3[i11];
                                        f5 = f9;
                                        f4 = f8;
                                        i3 = i2;
                                        f8 = f2;
                                        f9 = f3;
                                    } else if (c3 == 'l') {
                                        r0 = i2 + 0;
                                        i12 = i2 + 1;
                                        path2.rLineTo(fArr3[r0], fArr3[i12]);
                                        f8 += fArr3[r0];
                                        f2 = fArr3[i12];
                                    } else if (c3 == 'm') {
                                        r0 = i2 + 0;
                                        f8 += fArr3[r0];
                                        r1 = i2 + 1;
                                        f9 += fArr3[r1];
                                        if (i2 > 0) {
                                            path2.rLineTo(fArr3[r0], fArr3[r1]);
                                        } else {
                                            path2.rMoveTo(fArr3[r0], fArr3[r1]);
                                        }
                                    } else if (c3 == 's') {
                                        if (!(c4 == 'c' || c4 == 's' || c4 == 'C')) {
                                            if (c4 != 'S') {
                                                f3 = 0.0f;
                                                f4 = 0.0f;
                                                i4 = i2 + 0;
                                                i5 = i2 + 1;
                                                i10 = i2 + 2;
                                                i3 = i2 + 3;
                                                path.rCubicTo(f3, f4, fArr3[i4], fArr3[i5], fArr3[i10], fArr3[i3]);
                                                f2 = fArr3[i4] + f8;
                                                f3 = fArr3[i5] + f9;
                                                f8 += fArr3[i10];
                                                f4 = fArr3[i3];
                                            }
                                        }
                                        f2 = f8 - f4;
                                        f4 = f9 - f5;
                                        f3 = f2;
                                        i4 = i2 + 0;
                                        i5 = i2 + 1;
                                        i10 = i2 + 2;
                                        i3 = i2 + 3;
                                        path.rCubicTo(f3, f4, fArr3[i4], fArr3[i5], fArr3[i10], fArr3[i3]);
                                        f2 = fArr3[i4] + f8;
                                        f3 = fArr3[i5] + f9;
                                        f8 += fArr3[i10];
                                        f4 = fArr3[i3];
                                    } else if (c3 == 't') {
                                        if (!(c4 == 'q' || c4 == 't' || c4 == 'Q')) {
                                            if (c4 != 'T') {
                                                f2 = 0.0f;
                                                f6 = 0.0f;
                                                r1 = i2 + 0;
                                                r3 = i2 + 1;
                                                path2.rQuadTo(f6, f2, fArr3[r1], fArr3[r3]);
                                                f6 += f8;
                                                f2 += f9;
                                                f8 += fArr3[r1];
                                                f9 += fArr3[r3];
                                                f5 = f2;
                                                f4 = f6;
                                            }
                                        }
                                        f6 = f8 - f4;
                                        f2 = f9 - f5;
                                        r1 = i2 + 0;
                                        r3 = i2 + 1;
                                        path2.rQuadTo(f6, f2, fArr3[r1], fArr3[r3]);
                                        f6 += f8;
                                        f2 += f9;
                                        f8 += fArr3[r1];
                                        f9 += fArr3[r3];
                                        f5 = f2;
                                        f4 = f6;
                                    }
                                    f11 = f9;
                                    f10 = f8;
                                } else {
                                    r0 = i2 + 0;
                                    i12 = i2 + 1;
                                    path2.lineTo(fArr3[r0], fArr3[i12]);
                                    f8 = fArr3[r0];
                                    f9 = fArr3[i12];
                                }
                                f9 += f2;
                            } else {
                                r0 = i2 + 0;
                                i11 = i2 + 1;
                                i12 = i2 + 2;
                                int i13 = i2 + 3;
                                path2.rQuadTo(fArr3[r0], fArr3[i11], fArr3[i12], fArr3[i13]);
                                f2 = fArr3[r0] + f8;
                                f3 = fArr3[i11] + f9;
                                f8 += fArr3[i12];
                                f4 = fArr3[i13];
                            }
                            f9 += f4;
                            f4 = f2;
                            f5 = f3;
                        } else {
                            r0 = i2 + 0;
                            path2.rLineTo(fArr3[r0], 0.0f);
                            f8 += fArr3[r0];
                        }
                        i3 = i2;
                    } else {
                        i4 = i2 + 5;
                        f5 = fArr3[i4] + f8;
                        i5 = i2 + 6;
                        f6 = fArr3[i5] + f9;
                        f7 = fArr3[i2 + 0];
                        float f12 = fArr3[i2 + 1];
                        f = f9;
                        float f13 = f8;
                        i3 = i2;
                        drawArc(path, f8, f9, f5, f6, f7, f12, fArr3[i2 + 2], fArr3[i2 + 3] != 0.0f, fArr3[i2 + 4] != 0.0f);
                        f8 = f13 + fArr3[i4];
                        f9 = f + fArr3[i5];
                    }
                    i2 = i3 + i;
                    c4 = c2;
                    c3 = c4;
                } else {
                    i3 = i2;
                    i4 = i3 + 5;
                    i5 = i3 + 6;
                    drawArc(path, f8, f9, fArr3[i4], fArr3[i5], fArr3[i3 + 0], fArr3[i3 + 1], fArr3[i3 + 2], fArr3[i3 + 3] != 0.0f, fArr3[i3 + 4] != 0.0f);
                    f8 = fArr3[i4];
                    f9 = fArr3[i5];
                }
                f5 = f9;
                f4 = f8;
                i2 = i3 + i;
                c4 = c2;
                c3 = c4;
            }
            f = f9;
            fArr[0] = f8;
            fArr[1] = f;
            fArr[2] = f4;
            fArr[3] = f5;
            fArr[4] = f10;
            fArr[5] = f11;
        }

        private static void arcToBezier(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            double d10 = d3;
            int ceil = (int) Math.ceil(Math.abs((d9 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d7);
            double sin = Math.sin(d7);
            double cos2 = Math.cos(d8);
            double sin2 = Math.sin(d8);
            double d11 = -d10;
            double d12 = d11 * cos;
            double d13 = d4 * sin;
            double d14 = (d12 * sin2) - (d13 * cos2);
            d11 *= sin;
            double d15 = d4 * cos;
            sin2 = (sin2 * d11) + (cos2 * d15);
            cos2 = (double) ceil;
            Double.isNaN(cos2);
            cos2 = d9 / cos2;
            double d16 = d5;
            double d17 = d6;
            double d18 = sin2;
            double d19 = d14;
            int i = 0;
            d14 = d8;
            while (i < ceil) {
                double d20 = d14 + cos2;
                double sin3 = Math.sin(d20);
                double cos3 = Math.cos(d20);
                double d21 = (d + ((d10 * cos) * cos3)) - (d13 * sin3);
                d10 = (d2 + ((d10 * sin) * cos3)) + (d15 * sin3);
                double d22 = (d12 * sin3) - (d13 * cos3);
                sin3 = (sin3 * d11) + (cos3 * d15);
                d14 = d20 - d14;
                cos3 = Math.tan(d14 / 2.0d);
                d14 = (Math.sin(d14) * (Math.sqrt(((cos3 * 3.0d) * cos3) + 4.0d) - 1.0d)) / 3.0d;
                int i2 = ceil;
                double d23 = cos;
                double d24 = d16 + (d19 * d14);
                d7 = sin;
                double d25 = d17 + (d18 * d14);
                d4 = cos2;
                double d26 = d21 - (d14 * d22);
                int i3 = i2;
                d16 = d11;
                double d27 = d10 - (d14 * sin3);
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) d24, (float) d25, (float) d26, (float) d27, (float) d21, (float) d10);
                i++;
                cos2 = d4;
                ceil = i3;
                sin = d7;
                d17 = d10;
                d11 = d16;
                d14 = d20;
                d18 = sin3;
                d19 = d22;
                cos = d23;
                d10 = d3;
                d16 = d21;
                d21 = 4.0d;
            }
        }

        private static void drawArc(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            float f8 = f;
            float f9 = f3;
            float f10 = f5;
            float f11 = f6;
            boolean z3 = z2;
            double toRadians = Math.toRadians((double) f7);
            double cos = Math.cos(toRadians);
            double sin = Math.sin(toRadians);
            double d = (double) f8;
            Double.isNaN(d);
            double d2 = d * cos;
            double d3 = d;
            d = (double) f2;
            Double.isNaN(d);
            d2 += d * sin;
            double d4 = (double) f10;
            Double.isNaN(d4);
            d2 /= d4;
            double d5 = (double) (-f8);
            Double.isNaN(d5);
            d5 *= sin;
            Double.isNaN(d);
            d5 += d * cos;
            double d6 = d;
            d = (double) f11;
            Double.isNaN(d);
            d5 /= d;
            double d7 = (double) f9;
            Double.isNaN(d7);
            d7 *= cos;
            double d8 = d5;
            d5 = (double) f4;
            Double.isNaN(d5);
            d7 += d5 * sin;
            Double.isNaN(d4);
            d7 /= d4;
            double d9 = d4;
            d4 = (double) (-f9);
            Double.isNaN(d4);
            d4 *= sin;
            Double.isNaN(d5);
            d4 += d5 * cos;
            Double.isNaN(d);
            d4 /= d;
            d5 = d2 - d7;
            double d10 = d8 - d4;
            double d11 = (d2 + d7) / 2.0d;
            double d12 = (d8 + d4) / 2.0d;
            double d13 = sin;
            sin = (d5 * d5) + (d10 * d10);
            String str = PathParser.LOGTAG;
            if (sin == 0.0d) {
                Log.w(str, " Points are coincident");
                return;
            }
            double d14 = (1.0d / sin) - 0.25d;
            if (d14 < 0.0d) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Points are too far apart ");
                stringBuilder.append(sin);
                Log.w(str, stringBuilder.toString());
                f8 = (float) (Math.sqrt(sin) / 1.99999d);
                drawArc(path, f, f2, f3, f4, f10 * f8, f6 * f8, f7, z, z2);
                return;
            }
            sin = Math.sqrt(d14);
            d5 *= sin;
            sin *= d10;
            boolean z4 = z2;
            if (z == z4) {
                d11 -= sin;
                d12 += d5;
            } else {
                d11 += sin;
                d12 -= d5;
            }
            d8 = Math.atan2(d8 - d12, d2 - d11);
            double atan2 = Math.atan2(d4 - d12, d7 - d11) - d8;
            if (z4 != (atan2 >= 0.0d)) {
                atan2 = atan2 > 0.0d ? atan2 - 6.283185307179586d : atan2 + 6.283185307179586d;
            }
            Double.isNaN(d9);
            d11 *= d9;
            Double.isNaN(d);
            d12 *= d;
            arcToBezier(path, (d11 * cos) - (d12 * d13), (d11 * d13) + (d12 * cos), d9, d, d3, d6, toRadians, d8, atan2);
        }

        public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
            float[] fArr = new float[6];
            char c = 'm';
            for (int i = 0; i < pathDataNodeArr.length; i++) {
                addCommand(path, fArr, c, pathDataNodeArr[i].mType, pathDataNodeArr[i].mParams);
                c = pathDataNodeArr[i].mType;
            }
        }

        public void interpolatePathDataNode(PathDataNode pathDataNode, PathDataNode pathDataNode2, float f) {
            int i = 0;
            while (true) {
                float[] fArr = pathDataNode.mParams;
                if (i < fArr.length) {
                    this.mParams[i] = (fArr[i] * (1.0f - f)) + (pathDataNode2.mParams[i] * f);
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private PathParser() {
    }

    private static void addNode(ArrayList<PathDataNode> arrayList, char c, float[] fArr) {
        arrayList.add(new PathDataNode(c, fArr));
    }

    public static boolean canMorph(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr != null) {
            if (pathDataNodeArr2 != null) {
                if (pathDataNodeArr.length != pathDataNodeArr2.length) {
                    return false;
                }
                int i = 0;
                while (i < pathDataNodeArr.length) {
                    if (pathDataNodeArr[i].mType == pathDataNodeArr2[i].mType) {
                        if (pathDataNodeArr[i].mParams.length == pathDataNodeArr2[i].mParams.length) {
                            i++;
                        }
                    }
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    static float[] copyOfRange(float[] fArr, int i, int i2) {
        if (i <= i2) {
            int length = fArr.length;
            if (i < 0 || i > length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            i2 -= i;
            length = Math.min(i2, length - i);
            Object obj = new float[i2];
            System.arraycopy(fArr, i, obj, 0, length);
            return obj;
        }
        throw new IllegalArgumentException();
    }

    public static PathDataNode[] createNodesFromPathData(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            i = nextStart(str, i);
            String trim = str.substring(i2, i).trim();
            if (trim.length() > 0) {
                addNode(arrayList, trim.charAt(0), getFloats(trim));
            }
            i2 = i;
            i++;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            addNode(arrayList, str.charAt(i2), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[arrayList.size()]);
    }

    public static Path createPathFromPathData(String str) {
        Path path = new Path();
        PathDataNode[] createNodesFromPathData = createNodesFromPathData(str);
        if (createNodesFromPathData == null) {
            return null;
        }
        try {
            PathDataNode.nodesToPath(createNodesFromPathData, path);
            return path;
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error in parsing ");
            stringBuilder.append(str);
            throw new RuntimeException(stringBuilder.toString(), e);
        }
    }

    public static PathDataNode[] deepCopyNodes(PathDataNode[] pathDataNodeArr) {
        if (pathDataNodeArr == null) {
            return null;
        }
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            pathDataNodeArr2[i] = new PathDataNode(pathDataNodeArr[i]);
        }
        return pathDataNodeArr2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void extract(java.lang.String r8, int r9, android.support.v4.graphics.PathParser.ExtractFloatResult r10) {
        /*
        r0 = 0;
        r10.mEndWithNegOrDot = r0;
        r1 = r9;
        r2 = 0;
        r3 = 0;
        r4 = 0;
    L_0x0007:
        r5 = r8.length();
        if (r1 >= r5) goto L_0x003b;
    L_0x000d:
        r5 = r8.charAt(r1);
        r6 = 32;
        r7 = 1;
        if (r5 == r6) goto L_0x0033;
    L_0x0016:
        r6 = 69;
        if (r5 == r6) goto L_0x0031;
    L_0x001a:
        r6 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r5 == r6) goto L_0x0031;
    L_0x001e:
        switch(r5) {
            case 44: goto L_0x0033;
            case 45: goto L_0x002a;
            case 46: goto L_0x0022;
            default: goto L_0x0021;
        };
    L_0x0021:
        goto L_0x002f;
    L_0x0022:
        if (r3 != 0) goto L_0x0027;
    L_0x0024:
        r2 = 0;
        r3 = 1;
        goto L_0x0035;
    L_0x0027:
        r10.mEndWithNegOrDot = r7;
        goto L_0x0033;
    L_0x002a:
        if (r1 == r9) goto L_0x002f;
    L_0x002c:
        if (r2 != 0) goto L_0x002f;
    L_0x002e:
        goto L_0x0027;
    L_0x002f:
        r2 = 0;
        goto L_0x0035;
    L_0x0031:
        r2 = 1;
        goto L_0x0035;
    L_0x0033:
        r2 = 0;
        r4 = 1;
    L_0x0035:
        if (r4 == 0) goto L_0x0038;
    L_0x0037:
        goto L_0x003b;
    L_0x0038:
        r1 = r1 + 1;
        goto L_0x0007;
    L_0x003b:
        r10.mEndPosition = r1;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.PathParser.extract(java.lang.String, int, android.support.v4.graphics.PathParser$ExtractFloatResult):void");
    }

    private static float[] getFloats(String str) {
        if (str.charAt(0) != 'z') {
            if (str.charAt(0) != 'Z') {
                try {
                    float[] fArr = new float[str.length()];
                    ExtractFloatResult extractFloatResult = new ExtractFloatResult();
                    int length = str.length();
                    int i = 1;
                    int i2 = 0;
                    while (i < length) {
                        extract(str, i, extractFloatResult);
                        int i3 = extractFloatResult.mEndPosition;
                        if (i < i3) {
                            int i4 = i2 + 1;
                            fArr[i2] = Float.parseFloat(str.substring(i, i3));
                            i2 = i4;
                        }
                        i = extractFloatResult.mEndWithNegOrDot ? i3 : i3 + 1;
                    }
                    return copyOfRange(fArr, 0, i2);
                } catch (Throwable e) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("error in parsing \"");
                    stringBuilder.append(str);
                    stringBuilder.append("\"");
                    throw new RuntimeException(stringBuilder.toString(), e);
                }
            }
        }
        return new float[0];
    }

    private static int nextStart(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 65) * (charAt - 90) <= 0 || (charAt - 97) * (charAt - 122) <= 0) && charAt != 'e' && charAt != 'E') {
                return i;
            }
            i++;
        }
        return i;
    }

    public static void updateNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        for (int i = 0; i < pathDataNodeArr2.length; i++) {
            pathDataNodeArr[i].mType = pathDataNodeArr2[i].mType;
            for (int i2 = 0; i2 < pathDataNodeArr2[i].mParams.length; i2++) {
                pathDataNodeArr[i].mParams[i2] = pathDataNodeArr2[i].mParams[i2];
            }
        }
    }
}
