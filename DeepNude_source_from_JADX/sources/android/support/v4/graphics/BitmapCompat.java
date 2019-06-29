package android.support.v4.graphics;

import android.graphics.Bitmap;
import android.os.Build.VERSION;

public final class BitmapCompat {
    private BitmapCompat() {
    }

    public static int getAllocationByteCount(Bitmap bitmap) {
        return VERSION.SDK_INT >= 19 ? bitmap.getAllocationByteCount() : bitmap.getByteCount();
    }

    public static boolean hasMipMap(Bitmap bitmap) {
        return VERSION.SDK_INT >= 18 ? bitmap.hasMipMap() : false;
    }

    public static void setHasMipMap(Bitmap bitmap, boolean z) {
        if (VERSION.SDK_INT >= 18) {
            bitmap.setHasMipMap(z);
        }
    }
}
