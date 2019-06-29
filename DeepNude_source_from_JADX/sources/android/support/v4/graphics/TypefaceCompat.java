package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.support.v4.provider.FontsContractCompat.FontInfo;
import android.support.v4.util.LruCache;

public class TypefaceCompat {
    private static final String TAG = "TypefaceCompat";
    private static final LruCache<String, Typeface> sTypefaceCache = new LruCache(16);
    private static final TypefaceCompatBaseImpl sTypefaceCompatImpl;

    static {
        int i = VERSION.SDK_INT;
        TypefaceCompatBaseImpl typefaceCompatApi28Impl = i >= 28 ? new TypefaceCompatApi28Impl() : i >= 26 ? new TypefaceCompatApi26Impl() : (i < 24 || !TypefaceCompatApi24Impl.isUsable()) ? VERSION.SDK_INT >= 21 ? new TypefaceCompatApi21Impl() : new TypefaceCompatBaseImpl() : new TypefaceCompatApi24Impl();
        sTypefaceCompatImpl = typefaceCompatApi28Impl;
    }

    private TypefaceCompat() {
    }

    public static Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontInfo[] fontInfoArr, int i) {
        return sTypefaceCompatImpl.createFromFontInfo(context, cancellationSignal, fontInfoArr, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Typeface createFromResourcesFamilyXml(android.content.Context r7, android.support.v4.content.res.FontResourcesParserCompat.FamilyResourceEntry r8, android.content.res.Resources r9, int r10, int r11, android.support.v4.content.res.ResourcesCompat.FontCallback r12, android.os.Handler r13, boolean r14) {
        /*
        r1 = r8 instanceof android.support.v4.content.res.FontResourcesParserCompat.ProviderResourceEntry;
        if (r1 == 0) goto L_0x002c;
    L_0x0004:
        r0 = r8;
        r0 = (android.support.v4.content.res.FontResourcesParserCompat.ProviderResourceEntry) r0;
        r1 = 1;
        r4 = 0;
        if (r14 == 0) goto L_0x0012;
    L_0x000b:
        r5 = r0.getFetchStrategy();
        if (r5 != 0) goto L_0x0015;
    L_0x0011:
        goto L_0x0014;
    L_0x0012:
        if (r12 != 0) goto L_0x0015;
    L_0x0014:
        r4 = 1;
    L_0x0015:
        if (r14 == 0) goto L_0x001d;
    L_0x0017:
        r1 = r0.getTimeout();
        r5 = r1;
        goto L_0x001f;
    L_0x001d:
        r1 = -1;
        r5 = -1;
    L_0x001f:
        r1 = r0.getRequest();
        r0 = r7;
        r2 = r12;
        r3 = r13;
        r6 = r11;
        r0 = android.support.v4.provider.FontsContractCompat.getFontSync(r0, r1, r2, r3, r4, r5, r6);
        goto L_0x0041;
    L_0x002c:
        r1 = sTypefaceCompatImpl;
        r0 = r8;
        r0 = (android.support.v4.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry) r0;
        r0 = r1.createFromFontFamilyFilesResourceEntry(r7, r0, r9, r11);
        if (r12 == 0) goto L_0x0041;
    L_0x0037:
        if (r0 == 0) goto L_0x003d;
    L_0x0039:
        r12.callbackSuccessAsync(r0, r13);
        goto L_0x0041;
    L_0x003d:
        r1 = -3;
        r12.callbackFailAsync(r1, r13);
    L_0x0041:
        if (r0 == 0) goto L_0x004c;
    L_0x0043:
        r1 = sTypefaceCache;
        r2 = createResourceUid(r9, r10, r11);
        r1.put(r2, r0);
    L_0x004c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompat.createFromResourcesFamilyXml(android.content.Context, android.support.v4.content.res.FontResourcesParserCompat$FamilyResourceEntry, android.content.res.Resources, int, int, android.support.v4.content.res.ResourcesCompat$FontCallback, android.os.Handler, boolean):android.graphics.Typeface");
    }

    public static Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        Typeface createFromResourcesFontFile = sTypefaceCompatImpl.createFromResourcesFontFile(context, resources, i, str, i2);
        if (createFromResourcesFontFile != null) {
            sTypefaceCache.put(createResourceUid(resources, i, i2), createFromResourcesFontFile);
        }
        return createFromResourcesFontFile;
    }

    private static String createResourceUid(Resources resources, int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(resources.getResourcePackageName(i));
        String str = "-";
        stringBuilder.append(str);
        stringBuilder.append(i);
        stringBuilder.append(str);
        stringBuilder.append(i2);
        return stringBuilder.toString();
    }

    public static Typeface findFromCache(Resources resources, int i, int i2) {
        return (Typeface) sTypefaceCache.get(createResourceUid(resources, i, i2));
    }
}
