package android.support.v4.database;

import android.database.CursorWindow;
import android.os.Build.VERSION;

public final class CursorWindowCompat {
    private CursorWindowCompat() {
    }

    public static CursorWindow create(String str, long j) {
        int i = VERSION.SDK_INT;
        return i >= 28 ? new CursorWindow(str, j) : i >= 15 ? new CursorWindow(str) : new CursorWindow(false);
    }
}
