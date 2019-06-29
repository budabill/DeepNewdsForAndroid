package android.support.v4.util;

import android.os.Build.VERSION;
import java.util.Arrays;
import java.util.Objects;

public class ObjectsCompat {
    private ObjectsCompat() {
    }

    public static boolean equals(Object obj, Object obj2) {
        if (VERSION.SDK_INT >= 19) {
            return Objects.equals(obj, obj2);
        }
        boolean z;
        if (obj != obj2) {
            if (obj == null || !obj.equals(obj2)) {
                z = false;
                return z;
            }
        }
        z = true;
        return z;
    }

    public static int hash(Object... objArr) {
        return VERSION.SDK_INT >= 19 ? Objects.hash(objArr) : Arrays.hashCode(objArr);
    }

    public static int hashCode(Object obj) {
        return obj != null ? obj.hashCode() : 0;
    }
}
