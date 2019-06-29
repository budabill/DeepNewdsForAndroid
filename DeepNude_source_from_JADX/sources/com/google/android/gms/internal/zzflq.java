package com.google.android.gms.internal;

import java.nio.charset.Charset;
import java.util.Arrays;

public final class zzflq {
    private static Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    protected static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final Object zzpvt = new Object();

    public static boolean equals(double[] dArr, double[] dArr2) {
        if (dArr != null) {
            if (dArr.length != 0) {
                return Arrays.equals(dArr, dArr2);
            }
        }
        if (dArr2 != null) {
            if (dArr2.length != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(float[] fArr, float[] fArr2) {
        if (fArr != null) {
            if (fArr.length != 0) {
                return Arrays.equals(fArr, fArr2);
            }
        }
        if (fArr2 != null) {
            if (fArr2.length != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(int[] iArr, int[] iArr2) {
        if (iArr != null) {
            if (iArr.length != 0) {
                return Arrays.equals(iArr, iArr2);
            }
        }
        if (iArr2 != null) {
            if (iArr2.length != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(long[] jArr, long[] jArr2) {
        if (jArr != null) {
            if (jArr.length != 0) {
                return Arrays.equals(jArr, jArr2);
            }
        }
        if (jArr2 != null) {
            if (jArr2.length != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(Object[] objArr, Object[] objArr2) {
        int length = objArr == null ? 0 : objArr.length;
        int length2 = objArr2 == null ? 0 : objArr2.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= length || objArr[i] != null) {
                while (i2 < length2 && objArr2[i2] == null) {
                    i2++;
                }
                Object obj = i >= length ? 1 : null;
                Object obj2 = i2 >= length2 ? 1 : null;
                if (obj != null && obj2 != null) {
                    return true;
                }
                if (obj != obj2 || !objArr[i].equals(objArr2[i2])) {
                    return false;
                }
                i++;
                i2++;
            } else {
                i++;
            }
        }
    }

    public static boolean equals(boolean[] zArr, boolean[] zArr2) {
        if (zArr != null) {
            if (zArr.length != 0) {
                return Arrays.equals(zArr, zArr2);
            }
        }
        if (zArr2 != null) {
            if (zArr2.length != 0) {
                return false;
            }
        }
        return true;
    }

    public static int hashCode(double[] dArr) {
        if (dArr != null) {
            if (dArr.length != 0) {
                return Arrays.hashCode(dArr);
            }
        }
        return 0;
    }

    public static int hashCode(float[] fArr) {
        if (fArr != null) {
            if (fArr.length != 0) {
                return Arrays.hashCode(fArr);
            }
        }
        return 0;
    }

    public static int hashCode(int[] iArr) {
        if (iArr != null) {
            if (iArr.length != 0) {
                return Arrays.hashCode(iArr);
            }
        }
        return 0;
    }

    public static int hashCode(long[] jArr) {
        if (jArr != null) {
            if (jArr.length != 0) {
                return Arrays.hashCode(jArr);
            }
        }
        return 0;
    }

    public static int hashCode(Object[] objArr) {
        int length = objArr == null ? 0 : objArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            Object obj = objArr[i2];
            if (obj != null) {
                i = (i * 31) + obj.hashCode();
            }
        }
        return i;
    }

    public static int hashCode(boolean[] zArr) {
        if (zArr != null) {
            if (zArr.length != 0) {
                return Arrays.hashCode(zArr);
            }
        }
        return 0;
    }

    public static void zza(zzflm zzflm, zzflm zzflm2) {
        zzflo zzflo = zzflm.zzpvl;
        if (zzflo != null) {
            zzflm2.zzpvl = (zzflo) zzflo.clone();
        }
    }

    public static boolean zza(byte[][] bArr, byte[][] bArr2) {
        int length = bArr == null ? 0 : bArr.length;
        int length2 = bArr2 == null ? 0 : bArr2.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= length || bArr[i] != null) {
                while (i2 < length2 && bArr2[i2] == null) {
                    i2++;
                }
                Object obj = i >= length ? 1 : null;
                Object obj2 = i2 >= length2 ? 1 : null;
                if (obj != null && obj2 != null) {
                    return true;
                }
                if (obj != obj2 || !Arrays.equals(bArr[i], bArr2[i2])) {
                    return false;
                }
                i++;
                i2++;
            } else {
                i++;
            }
        }
    }

    public static int zzd(byte[][] bArr) {
        int length = bArr == null ? 0 : bArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            byte[] bArr2 = bArr[i2];
            if (bArr2 != null) {
                i = (i * 31) + Arrays.hashCode(bArr2);
            }
        }
        return i;
    }
}
