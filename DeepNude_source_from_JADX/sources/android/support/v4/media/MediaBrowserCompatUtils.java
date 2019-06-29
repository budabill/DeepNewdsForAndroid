package android.support.v4.media;

import android.os.Bundle;

public class MediaBrowserCompatUtils {
    private MediaBrowserCompatUtils() {
    }

    public static boolean areSameOptions(Bundle bundle, Bundle bundle2) {
        boolean z = true;
        if (bundle == bundle2) {
            return true;
        }
        String str = MediaBrowserCompat.EXTRA_PAGE_SIZE;
        String str2 = MediaBrowserCompat.EXTRA_PAGE;
        if (bundle == null) {
            if (bundle2.getInt(str2, -1) != -1 || bundle2.getInt(str, -1) != -1) {
                z = false;
            }
            return z;
        } else if (bundle2 == null) {
            if (bundle.getInt(str2, -1) != -1 || bundle.getInt(str, -1) != -1) {
                z = false;
            }
            return z;
        } else {
            if (bundle.getInt(str2, -1) != bundle2.getInt(str2, -1) || bundle.getInt(str, -1) != bundle2.getInt(str, -1)) {
                z = false;
            }
            return z;
        }
    }

    public static boolean hasDuplicatedItems(Bundle bundle, Bundle bundle2) {
        String str = MediaBrowserCompat.EXTRA_PAGE;
        int i = bundle == null ? -1 : bundle.getInt(str, -1);
        int i2 = bundle2 == null ? -1 : bundle2.getInt(str, -1);
        String str2 = MediaBrowserCompat.EXTRA_PAGE_SIZE;
        int i3 = bundle == null ? -1 : bundle.getInt(str2, -1);
        int i4 = bundle2 == null ? -1 : bundle2.getInt(str2, -1);
        int i5 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        if (i != -1) {
            if (i3 != -1) {
                i *= i3;
                i3 = (i3 + i) - 1;
                if (i2 != -1) {
                    if (i4 == -1) {
                        i2 *= i4;
                        i5 = (i4 + i2) - 1;
                        return i3 < i2 && i5 >= i;
                    }
                }
                i2 = 0;
                if (i3 < i2) {
                }
            }
        }
        i3 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        i = 0;
        if (i2 != -1) {
            if (i4 == -1) {
                i2 *= i4;
                i5 = (i4 + i2) - 1;
                if (i3 < i2) {
                }
            }
        }
        i2 = 0;
        if (i3 < i2) {
        }
    }
}
