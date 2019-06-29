package android.support.v4.content.res;

import android.content.res.Resources;
import android.os.Build.VERSION;

public final class ConfigurationHelper {
    private ConfigurationHelper() {
    }

    public static int getDensityDpi(Resources resources) {
        return VERSION.SDK_INT >= 17 ? resources.getConfiguration().densityDpi : resources.getDisplayMetrics().densityDpi;
    }
}
