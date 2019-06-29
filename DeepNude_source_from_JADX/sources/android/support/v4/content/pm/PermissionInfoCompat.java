package android.support.v4.content.pm;

import android.annotation.SuppressLint;
import android.content.pm.PermissionInfo;
import android.os.Build.VERSION;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class PermissionInfoCompat {

    @Retention(RetentionPolicy.SOURCE)
    public @interface Protection {
    }

    @SuppressLint({"UniqueConstants"})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ProtectionFlags {
    }

    private PermissionInfoCompat() {
    }

    @SuppressLint({"WrongConstant"})
    public static int getProtection(PermissionInfo permissionInfo) {
        return VERSION.SDK_INT >= 28 ? permissionInfo.getProtection() : permissionInfo.protectionLevel & 15;
    }

    @SuppressLint({"WrongConstant"})
    public static int getProtectionFlags(PermissionInfo permissionInfo) {
        return VERSION.SDK_INT >= 28 ? permissionInfo.getProtectionFlags() : permissionInfo.protectionLevel & -16;
    }
}
