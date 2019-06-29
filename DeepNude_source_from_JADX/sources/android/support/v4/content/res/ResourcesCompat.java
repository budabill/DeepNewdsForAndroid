package android.support.v4.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.res.FontResourcesParserCompat.FamilyResourceEntry;
import android.support.v4.graphics.TypefaceCompat;
import android.support.v4.util.Preconditions;
import android.util.Log;
import android.util.TypedValue;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public final class ResourcesCompat {
    private static final String TAG = "ResourcesCompat";

    public static abstract class FontCallback {
        public final void callbackFailAsync(final int i, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() {
                public void run() {
                    FontCallback.this.onFontRetrievalFailed(i);
                }
            });
        }

        public final void callbackSuccessAsync(final Typeface typeface, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() {
                public void run() {
                    FontCallback.this.onFontRetrieved(typeface);
                }
            });
        }

        public abstract void onFontRetrievalFailed(int i);

        public abstract void onFontRetrieved(Typeface typeface);
    }

    private ResourcesCompat() {
    }

    public static int getColor(Resources resources, int i, Theme theme) {
        return VERSION.SDK_INT >= 23 ? resources.getColor(i, theme) : resources.getColor(i);
    }

    public static ColorStateList getColorStateList(Resources resources, int i, Theme theme) {
        return VERSION.SDK_INT >= 23 ? resources.getColorStateList(i, theme) : resources.getColorStateList(i);
    }

    public static Drawable getDrawable(Resources resources, int i, Theme theme) {
        return VERSION.SDK_INT >= 21 ? resources.getDrawable(i, theme) : resources.getDrawable(i);
    }

    public static Drawable getDrawableForDensity(Resources resources, int i, int i2, Theme theme) {
        int i3 = VERSION.SDK_INT;
        return i3 >= 21 ? resources.getDrawableForDensity(i, i2, theme) : i3 >= 15 ? resources.getDrawableForDensity(i, i2) : resources.getDrawable(i);
    }

    public static Typeface getFont(Context context, int i) {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i, new TypedValue(), 0, null, null, false);
    }

    public static Typeface getFont(Context context, int i, TypedValue typedValue, int i2, FontCallback fontCallback) {
        return context.isRestricted() ? null : loadFont(context, i, typedValue, i2, fontCallback, null, true);
    }

    public static void getFont(Context context, int i, FontCallback fontCallback, Handler handler) {
        Preconditions.checkNotNull(fontCallback);
        if (context.isRestricted()) {
            fontCallback.callbackFailAsync(-4, handler);
            return;
        }
        loadFont(context, i, new TypedValue(), 0, fontCallback, handler, false);
    }

    private static Typeface loadFont(Context context, int i, TypedValue typedValue, int i2, FontCallback fontCallback, Handler handler, boolean z) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface loadFont = loadFont(context, resources, typedValue, i, i2, fontCallback, handler, z);
        if (loadFont == null) {
            if (fontCallback == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Font resource ID #0x");
                stringBuilder.append(Integer.toHexString(i));
                stringBuilder.append(" could not be retrieved.");
                throw new NotFoundException(stringBuilder.toString());
            }
        }
        return loadFont;
    }

    private static Typeface loadFont(Context context, Resources resources, TypedValue typedValue, int i, int i2, FontCallback fontCallback, Handler handler, boolean z) {
        Throwable e;
        StringBuilder stringBuilder;
        String str;
        Resources resources2 = resources;
        TypedValue typedValue2 = typedValue;
        int i3 = i;
        int i4 = i2;
        FontCallback fontCallback2 = fontCallback;
        Handler handler2 = handler;
        String str2 = TAG;
        CharSequence charSequence = typedValue2.string;
        if (charSequence != null) {
            String charSequence2 = charSequence.toString();
            if (charSequence2.startsWith("res/")) {
                Typeface findFromCache = TypefaceCompat.findFromCache(resources2, i3, i4);
                if (findFromCache != null) {
                    if (fontCallback2 != null) {
                        fontCallback2.callbackSuccessAsync(findFromCache, handler2);
                    }
                    return findFromCache;
                }
                try {
                    if (charSequence2.toLowerCase().endsWith(".xml")) {
                        FamilyResourceEntry parse = FontResourcesParserCompat.parse(resources2.getXml(i3), resources2);
                        if (parse != null) {
                            return TypefaceCompat.createFromResourcesFamilyXml(context, parse, resources, i, i2, fontCallback, handler, z);
                        }
                        Log.e(str2, "Failed to find font-family tag");
                        if (fontCallback2 != null) {
                            fontCallback2.callbackFailAsync(-3, handler2);
                        }
                        return null;
                    }
                    Context context2 = context;
                    Typeface createFromResourcesFontFile = TypefaceCompat.createFromResourcesFontFile(context, resources2, i3, charSequence2, i4);
                    if (fontCallback2 != null) {
                        if (createFromResourcesFontFile != null) {
                            fontCallback2.callbackSuccessAsync(createFromResourcesFontFile, handler2);
                        } else {
                            fontCallback2.callbackFailAsync(-3, handler2);
                        }
                    }
                    return createFromResourcesFontFile;
                } catch (XmlPullParserException e2) {
                    e = e2;
                    stringBuilder = new StringBuilder();
                    str = "Failed to parse xml resource ";
                    stringBuilder.append(str);
                    stringBuilder.append(charSequence2);
                    Log.e(str2, stringBuilder.toString(), e);
                    if (fontCallback2 != null) {
                        fontCallback2.callbackFailAsync(-3, handler2);
                    }
                    return null;
                } catch (IOException e3) {
                    e = e3;
                    stringBuilder = new StringBuilder();
                    str = "Failed to read xml resource ";
                    stringBuilder.append(str);
                    stringBuilder.append(charSequence2);
                    Log.e(str2, stringBuilder.toString(), e);
                    if (fontCallback2 != null) {
                        fontCallback2.callbackFailAsync(-3, handler2);
                    }
                    return null;
                }
            }
            if (fontCallback2 != null) {
                fontCallback2.callbackFailAsync(-3, handler2);
            }
            return null;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Resource \"");
        stringBuilder2.append(resources2.getResourceName(i3));
        stringBuilder2.append("\" (");
        stringBuilder2.append(Integer.toHexString(i));
        stringBuilder2.append(") is not a Font: ");
        stringBuilder2.append(typedValue2);
        throw new NotFoundException(stringBuilder2.toString());
    }
}
