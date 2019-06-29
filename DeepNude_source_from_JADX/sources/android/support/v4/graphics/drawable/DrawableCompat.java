package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

public final class DrawableCompat {
    private static final String TAG = "DrawableCompat";
    private static Method sGetLayoutDirectionMethod;
    private static boolean sGetLayoutDirectionMethodFetched;
    private static Method sSetLayoutDirectionMethod;
    private static boolean sSetLayoutDirectionMethodFetched;

    private DrawableCompat() {
    }

    public static void applyTheme(Drawable drawable, Theme theme) {
        if (VERSION.SDK_INT >= 21) {
            drawable.applyTheme(theme);
        }
    }

    public static boolean canApplyTheme(Drawable drawable) {
        return VERSION.SDK_INT >= 21 ? drawable.canApplyTheme() : false;
    }

    public static void clearColorFilter(Drawable drawable) {
        int i = VERSION.SDK_INT;
        if (i < 23 && i >= 21) {
            drawable.clearColorFilter();
            if (drawable instanceof InsetDrawable) {
                drawable = ((InsetDrawable) drawable).getDrawable();
            } else if (drawable instanceof WrappedDrawable) {
                drawable = ((WrappedDrawable) drawable).getWrappedDrawable();
            } else if (drawable instanceof DrawableContainer) {
                DrawableContainerState drawableContainerState = (DrawableContainerState) ((DrawableContainer) drawable).getConstantState();
                if (drawableContainerState != null) {
                    int childCount = drawableContainerState.getChildCount();
                    for (i = 0; i < childCount; i++) {
                        Drawable child = drawableContainerState.getChild(i);
                        if (child != null) {
                            clearColorFilter(child);
                        }
                    }
                    return;
                }
                return;
            } else {
                return;
            }
            clearColorFilter(drawable);
            return;
        }
        drawable.clearColorFilter();
    }

    public static int getAlpha(Drawable drawable) {
        return VERSION.SDK_INT >= 19 ? drawable.getAlpha() : 0;
    }

    public static ColorFilter getColorFilter(Drawable drawable) {
        return VERSION.SDK_INT >= 21 ? drawable.getColorFilter() : null;
    }

    public static int getLayoutDirection(Drawable drawable) {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            return drawable.getLayoutDirection();
        }
        if (i >= 17) {
            boolean z = sGetLayoutDirectionMethodFetched;
            String str = TAG;
            if (!z) {
                try {
                    sGetLayoutDirectionMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                    sGetLayoutDirectionMethod.setAccessible(true);
                } catch (Throwable e) {
                    Log.i(str, "Failed to retrieve getLayoutDirection() method", e);
                }
                sGetLayoutDirectionMethodFetched = true;
            }
            Method method = sGetLayoutDirectionMethod;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(drawable, new Object[0])).intValue();
                } catch (Throwable e2) {
                    Log.i(str, "Failed to invoke getLayoutDirection() via reflection", e2);
                    sGetLayoutDirectionMethod = null;
                }
            }
        }
        return 0;
    }

    public static void inflate(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (VERSION.SDK_INT >= 21) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        } else {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        }
    }

    public static boolean isAutoMirrored(Drawable drawable) {
        return VERSION.SDK_INT >= 19 ? drawable.isAutoMirrored() : false;
    }

    @Deprecated
    public static void jumpToCurrentState(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void setAutoMirrored(Drawable drawable, boolean z) {
        if (VERSION.SDK_INT >= 19) {
            drawable.setAutoMirrored(z);
        }
    }

    public static void setHotspot(Drawable drawable, float f, float f2) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setHotspot(f, f2);
        }
    }

    public static void setHotspotBounds(Drawable drawable, int i, int i2, int i3, int i4) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setHotspotBounds(i, i2, i3, i4);
        }
    }

    public static boolean setLayoutDirection(Drawable drawable, int i) {
        int i2 = VERSION.SDK_INT;
        if (i2 >= 23) {
            return drawable.setLayoutDirection(i);
        }
        if (i2 >= 17) {
            boolean z = sSetLayoutDirectionMethodFetched;
            String str = TAG;
            if (!z) {
                try {
                    sSetLayoutDirectionMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                    sSetLayoutDirectionMethod.setAccessible(true);
                } catch (Throwable e) {
                    Log.i(str, "Failed to retrieve setLayoutDirection(int) method", e);
                }
                sSetLayoutDirectionMethodFetched = true;
            }
            Method method = sSetLayoutDirectionMethod;
            if (method != null) {
                try {
                    method.invoke(drawable, new Object[]{Integer.valueOf(i)});
                    return true;
                } catch (Throwable e2) {
                    Log.i(str, "Failed to invoke setLayoutDirection(int) via reflection", e2);
                    sSetLayoutDirectionMethod = null;
                }
            }
        }
        return false;
    }

    public static void setTint(Drawable drawable, int i) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setTint(i);
        } else if (drawable instanceof TintAwareDrawable) {
            ((TintAwareDrawable) drawable).setTint(i);
        }
    }

    public static void setTintList(Drawable drawable, ColorStateList colorStateList) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setTintList(colorStateList);
        } else if (drawable instanceof TintAwareDrawable) {
            ((TintAwareDrawable) drawable).setTintList(colorStateList);
        }
    }

    public static void setTintMode(Drawable drawable, Mode mode) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setTintMode(mode);
        } else if (drawable instanceof TintAwareDrawable) {
            ((TintAwareDrawable) drawable).setTintMode(mode);
        }
    }

    public static <T extends Drawable> T unwrap(Drawable drawable) {
        return drawable instanceof WrappedDrawable ? ((WrappedDrawable) drawable).getWrappedDrawable() : drawable;
    }

    public static Drawable wrap(Drawable drawable) {
        int i = VERSION.SDK_INT;
        return i >= 23 ? drawable : i >= 21 ? !(drawable instanceof TintAwareDrawable) ? new WrappedDrawableApi21(drawable) : drawable : !(drawable instanceof TintAwareDrawable) ? new WrappedDrawableApi14(drawable) : drawable;
    }
}
