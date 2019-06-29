package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

class ActionBarBackgroundDrawable extends Drawable {
    final ActionBarContainer mContainer;

    public ActionBarBackgroundDrawable(ActionBarContainer actionBarContainer) {
        this.mContainer = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.mContainer;
        Drawable drawable;
        if (actionBarContainer.mIsSplit) {
            drawable = actionBarContainer.mSplitBackground;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        drawable = actionBarContainer.mBackground;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        actionBarContainer = this.mContainer;
        Drawable drawable2 = actionBarContainer.mStackedBackground;
        if (drawable2 != null && actionBarContainer.mIsStacked) {
            drawable2.draw(canvas);
        }
    }

    public int getOpacity() {
        return 0;
    }

    public void getOutline(Outline outline) {
        Drawable drawable;
        ActionBarContainer actionBarContainer = this.mContainer;
        if (actionBarContainer.mIsSplit) {
            drawable = actionBarContainer.mSplitBackground;
            if (drawable == null) {
                return;
            }
        } else {
            drawable = actionBarContainer.mBackground;
            if (drawable == null) {
                return;
            }
        }
        drawable.getOutline(outline);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
