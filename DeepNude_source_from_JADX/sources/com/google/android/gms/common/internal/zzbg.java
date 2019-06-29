package com.google.android.gms.common.internal;

@Hide
public final class zzbg {
    public static boolean equal(Object obj, Object obj2) {
        if (obj != obj2) {
            if (obj == null || !obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    public static zzbi zzx(Object obj) {
        return new zzbi(obj);
    }
}
