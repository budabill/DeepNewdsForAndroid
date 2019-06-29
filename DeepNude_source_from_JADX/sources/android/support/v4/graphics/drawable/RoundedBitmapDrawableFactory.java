package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.graphics.BitmapCompat;
import android.support.v4.view.GravityCompat;
import android.util.Log;
import java.io.InputStream;

public final class RoundedBitmapDrawableFactory {
    private static final String TAG = "RoundedBitmapDrawableFa";

    private static class DefaultRoundedBitmapDrawable extends RoundedBitmapDrawable {
        DefaultRoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        void gravityCompatApply(int i, int i2, int i3, Rect rect, Rect rect2) {
            GravityCompat.apply(i, i2, i3, rect, rect2, 0);
        }

        public boolean hasMipMap() {
            Bitmap bitmap = this.mBitmap;
            return bitmap != null && BitmapCompat.hasMipMap(bitmap);
        }

        public void setMipMap(boolean z) {
            Bitmap bitmap = this.mBitmap;
            if (bitmap != null) {
                BitmapCompat.setHasMipMap(bitmap, z);
                invalidateSelf();
            }
        }
    }

    private RoundedBitmapDrawableFactory() {
    }

    public static RoundedBitmapDrawable create(Resources resources, Bitmap bitmap) {
        return VERSION.SDK_INT >= 21 ? new RoundedBitmapDrawable21(resources, bitmap) : new DefaultRoundedBitmapDrawable(resources, bitmap);
    }

    public static RoundedBitmapDrawable create(Resources resources, InputStream inputStream) {
        RoundedBitmapDrawable create = create(resources, BitmapFactory.decodeStream(inputStream));
        if (create.getBitmap() == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("RoundedBitmapDrawable cannot decode ");
            stringBuilder.append(inputStream);
            Log.w(TAG, stringBuilder.toString());
        }
        return create;
    }

    public static RoundedBitmapDrawable create(Resources resources, String str) {
        RoundedBitmapDrawable create = create(resources, BitmapFactory.decodeFile(str));
        if (create.getBitmap() == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("RoundedBitmapDrawable cannot decode ");
            stringBuilder.append(str);
            Log.w(TAG, stringBuilder.toString());
        }
        return create;
    }
}
