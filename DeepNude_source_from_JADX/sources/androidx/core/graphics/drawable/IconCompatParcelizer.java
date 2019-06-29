package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.support.v4.graphics.drawable.IconCompat;
import androidx.versionedparcelable.C0269b;

public class IconCompatParcelizer {
    public static IconCompat read(C0269b c0269b) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.mType = c0269b.m124a(iconCompat.mType, 1);
        iconCompat.mData = c0269b.m135a(iconCompat.mData, 2);
        iconCompat.mParcelable = c0269b.m125a(iconCompat.mParcelable, 3);
        iconCompat.mInt1 = c0269b.m124a(iconCompat.mInt1, 4);
        iconCompat.mInt2 = c0269b.m124a(iconCompat.mInt2, 5);
        iconCompat.mTintList = (ColorStateList) c0269b.m125a(iconCompat.mTintList, 6);
        iconCompat.mTintModeStr = c0269b.m127a(iconCompat.mTintModeStr, 7);
        iconCompat.onPostParceling();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, C0269b c0269b) {
        c0269b.m132a(true, true);
        iconCompat.onPreParceling(c0269b.m144c());
        c0269b.m138b(iconCompat.mType, 1);
        c0269b.m142b(iconCompat.mData, 2);
        c0269b.m139b(iconCompat.mParcelable, 3);
        c0269b.m138b(iconCompat.mInt1, 4);
        c0269b.m138b(iconCompat.mInt2, 5);
        c0269b.m139b(iconCompat.mTintList, 6);
        c0269b.m141b(iconCompat.mTintModeStr, 7);
    }
}
