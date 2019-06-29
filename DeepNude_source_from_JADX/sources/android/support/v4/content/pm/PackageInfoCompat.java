package android.support.v4.content.pm;

import android.content.pm.PackageInfo;
import android.os.Build.VERSION;

public final class PackageInfoCompat {
    private PackageInfoCompat() {
    }

    public static long getLongVersionCode(PackageInfo packageInfo) {
        return VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : (long) packageInfo.versionCode;
    }
}
