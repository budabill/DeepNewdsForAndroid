package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

class CardViewApi17Impl extends CardViewBaseImpl {

    /* renamed from: android.support.v7.widget.CardViewApi17Impl$1 */
    class C07921 implements RoundRectHelper {
        C07921() {
        }

        public void drawRoundRect(Canvas canvas, RectF rectF, float f, Paint paint) {
            canvas.drawRoundRect(rectF, f, f, paint);
        }
    }

    CardViewApi17Impl() {
    }

    public void initStatic() {
        RoundRectDrawableWithShadow.sRoundRectHelper = new C07921();
    }
}
