package android.support.v4.graphics.drawable;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.util.Preconditions;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

public class IconCompat extends CustomVersionedParcelable {
    private static final float ADAPTIVE_ICON_INSET_FACTOR = 0.25f;
    private static final int AMBIENT_SHADOW_ALPHA = 30;
    private static final float BLUR_FACTOR = 0.010416667f;
    static final Mode DEFAULT_TINT_MODE = Mode.SRC_IN;
    private static final float DEFAULT_VIEW_PORT_SCALE = 0.6666667f;
    private static final String EXTRA_INT1 = "int1";
    private static final String EXTRA_INT2 = "int2";
    private static final String EXTRA_OBJ = "obj";
    private static final String EXTRA_TINT_LIST = "tint_list";
    private static final String EXTRA_TINT_MODE = "tint_mode";
    private static final String EXTRA_TYPE = "type";
    private static final float ICON_DIAMETER_FACTOR = 0.9166667f;
    private static final int KEY_SHADOW_ALPHA = 61;
    private static final float KEY_SHADOW_OFFSET_FACTOR = 0.020833334f;
    private static final String TAG = "IconCompat";
    public static final int TYPE_UNKNOWN = -1;
    public byte[] mData;
    public int mInt1;
    public int mInt2;
    Object mObj1;
    public Parcelable mParcelable;
    public ColorStateList mTintList = null;
    Mode mTintMode = DEFAULT_TINT_MODE;
    public String mTintModeStr;
    public int mType;

    @Retention(RetentionPolicy.SOURCE)
    public @interface IconType {
    }

    private IconCompat(int i) {
        this.mType = i;
    }

    public static IconCompat createFromBundle(Bundle bundle) {
        Object string;
        int i = bundle.getInt(EXTRA_TYPE);
        IconCompat iconCompat = new IconCompat(i);
        iconCompat.mInt1 = bundle.getInt(EXTRA_INT1);
        iconCompat.mInt2 = bundle.getInt(EXTRA_INT2);
        String str = EXTRA_TINT_LIST;
        if (bundle.containsKey(str)) {
            iconCompat.mTintList = (ColorStateList) bundle.getParcelable(str);
        }
        str = EXTRA_TINT_MODE;
        if (bundle.containsKey(str)) {
            iconCompat.mTintMode = Mode.valueOf(bundle.getString(str));
        }
        String str2 = EXTRA_OBJ;
        if (!(i == -1 || i == 1)) {
            if (i != 2) {
                if (i == 3) {
                    iconCompat.mObj1 = bundle.getByteArray(str2);
                    return iconCompat;
                } else if (i != 4) {
                    if (i != 5) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unknown type ");
                        stringBuilder.append(i);
                        Log.w(TAG, stringBuilder.toString());
                        return null;
                    }
                }
            }
            string = bundle.getString(str2);
            iconCompat.mObj1 = string;
            return iconCompat;
        }
        string = bundle.getParcelable(str2);
        iconCompat.mObj1 = string;
        return iconCompat;
    }

    public static android.support.v4.graphics.drawable.IconCompat createFromIcon(android.content.Context r2, android.graphics.drawable.Icon r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        android.support.v4.util.Preconditions.checkNotNull(r3);
        r0 = getType(r3);
        r1 = 2;
        if (r0 == r1) goto L_0x001f;
    L_0x000a:
        r2 = 4;
        if (r0 == r2) goto L_0x0016;
    L_0x000d:
        r2 = new android.support.v4.graphics.drawable.IconCompat;
        r0 = -1;
        r2.<init>(r0);
        r2.mObj1 = r3;
        return r2;
    L_0x0016:
        r2 = getUri(r3);
        r2 = createWithContentUri(r2);
        return r2;
    L_0x001f:
        r0 = getResPackage(r3);
        r2 = getResources(r2, r0);	 Catch:{ NotFoundException -> 0x0030 }
        r3 = getResId(r3);	 Catch:{ NotFoundException -> 0x0030 }
        r2 = createWithResource(r2, r0, r3);	 Catch:{ NotFoundException -> 0x0030 }
        return r2;
    L_0x0030:
        r2 = new java.lang.IllegalArgumentException;
        r3 = "Icon resource cannot be found";
        r2.<init>(r3);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.drawable.IconCompat.createFromIcon(android.content.Context, android.graphics.drawable.Icon):android.support.v4.graphics.drawable.IconCompat");
    }

    public static IconCompat createFromIcon(Icon icon) {
        Preconditions.checkNotNull(icon);
        int type = getType(icon);
        if (type == 2) {
            return createWithResource(null, getResPackage(icon), getResId(icon));
        }
        if (type == 4) {
            return createWithContentUri(getUri(icon));
        }
        IconCompat iconCompat = new IconCompat(-1);
        iconCompat.mObj1 = icon;
        return iconCompat;
    }

    static Bitmap createLegacyIconFromAdaptiveIcon(Bitmap bitmap, boolean z) {
        int min = (int) (((float) Math.min(bitmap.getWidth(), bitmap.getHeight())) * DEFAULT_VIEW_PORT_SCALE);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f = (float) min;
        float f2 = 0.5f * f;
        float f3 = ICON_DIAMETER_FACTOR * f2;
        if (z) {
            float f4 = BLUR_FACTOR * f;
            paint.setColor(0);
            paint.setShadowLayer(f4, 0.0f, f * KEY_SHADOW_OFFSET_FACTOR, 1023410176);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.setShadowLayer(f4, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        TileMode tileMode = TileMode.CLAMP;
        Shader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((float) ((-(bitmap.getWidth() - min)) / 2), (float) ((-(bitmap.getHeight() - min)) / 2));
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f2, f2, f3, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public static IconCompat createWithAdaptiveBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            IconCompat iconCompat = new IconCompat(5);
            iconCompat.mObj1 = bitmap;
            return iconCompat;
        }
        throw new IllegalArgumentException("Bitmap must not be null.");
    }

    public static IconCompat createWithBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            IconCompat iconCompat = new IconCompat(1);
            iconCompat.mObj1 = bitmap;
            return iconCompat;
        }
        throw new IllegalArgumentException("Bitmap must not be null.");
    }

    public static IconCompat createWithContentUri(Uri uri) {
        if (uri != null) {
            return createWithContentUri(uri.toString());
        }
        throw new IllegalArgumentException("Uri must not be null.");
    }

    public static IconCompat createWithContentUri(String str) {
        if (str != null) {
            IconCompat iconCompat = new IconCompat(4);
            iconCompat.mObj1 = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Uri must not be null.");
    }

    public static IconCompat createWithData(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            IconCompat iconCompat = new IconCompat(3);
            iconCompat.mObj1 = bArr;
            iconCompat.mInt1 = i;
            iconCompat.mInt2 = i2;
            return iconCompat;
        }
        throw new IllegalArgumentException("Data must not be null.");
    }

    public static IconCompat createWithResource(Context context, int i) {
        if (context != null) {
            return createWithResource(context.getResources(), context.getPackageName(), i);
        }
        throw new IllegalArgumentException("Context must not be null.");
    }

    public static android.support.v4.graphics.drawable.IconCompat createWithResource(android.content.res.Resources r2, java.lang.String r3, int r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        if (r3 == 0) goto L_0x0028;
    L_0x0002:
        if (r4 == 0) goto L_0x0020;
    L_0x0004:
        r0 = new android.support.v4.graphics.drawable.IconCompat;
        r1 = 2;
        r0.<init>(r1);
        r0.mInt1 = r4;
        if (r2 == 0) goto L_0x001d;
    L_0x000e:
        r2 = r2.getResourceName(r4);	 Catch:{ NotFoundException -> 0x0015 }
        r0.mObj1 = r2;	 Catch:{ NotFoundException -> 0x0015 }
        goto L_0x001f;
    L_0x0015:
        r2 = new java.lang.IllegalArgumentException;
        r3 = "Icon resource cannot be found";
        r2.<init>(r3);
        throw r2;
    L_0x001d:
        r0.mObj1 = r3;
    L_0x001f:
        return r0;
    L_0x0020:
        r2 = new java.lang.IllegalArgumentException;
        r3 = "Drawable resource ID must not be 0";
        r2.<init>(r3);
        throw r2;
    L_0x0028:
        r2 = new java.lang.IllegalArgumentException;
        r3 = "Package must not be null.";
        r2.<init>(r3);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.drawable.IconCompat.createWithResource(android.content.res.Resources, java.lang.String, int):android.support.v4.graphics.drawable.IconCompat");
    }

    private static int getResId(Icon icon) {
        String str = "Unable to get icon resource";
        String str2 = TAG;
        if (VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (Throwable e) {
            Log.e(str2, str, e);
            return 0;
        } catch (Throwable e2) {
            Log.e(str2, str, e2);
            return 0;
        } catch (Throwable e22) {
            Log.e(str2, str, e22);
            return 0;
        }
    }

    private static String getResPackage(Icon icon) {
        String str = "Unable to get icon package";
        String str2 = TAG;
        if (VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (Throwable e) {
            Log.e(str2, str, e);
            return null;
        } catch (Throwable e2) {
            Log.e(str2, str, e2);
            return null;
        } catch (Throwable e22) {
            Log.e(str2, str, e22);
            return null;
        }
    }

    private static Resources getResources(Context context, String str) {
        if ("android".equals(str)) {
            return Resources.getSystem();
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 8192);
            return applicationInfo != null ? packageManager.getResourcesForApplication(applicationInfo) : null;
        } catch (Throwable e) {
            Log.e(TAG, String.format("Unable to find pkg=%s for icon", new Object[]{str}), e);
            return null;
        }
    }

    private static int getType(Icon icon) {
        Object intValue;
        Throwable e;
        StringBuilder stringBuilder;
        String str = "Unable to get icon type ";
        String str2 = TAG;
        if (VERSION.SDK_INT >= 28) {
            return icon.getType();
        }
        try {
            intValue = ((Integer) icon.getClass().getMethod("getType", new Class[0]).invoke(icon, new Object[0])).intValue();
            return intValue;
        } catch (IllegalAccessException e2) {
            e = e2;
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(intValue);
            Log.e(str2, stringBuilder.toString(), e);
            return -1;
        } catch (InvocationTargetException e3) {
            e = e3;
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(intValue);
            Log.e(str2, stringBuilder.toString(), e);
            return -1;
        } catch (NoSuchMethodException e4) {
            e = e4;
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(intValue);
            Log.e(str2, stringBuilder.toString(), e);
            return -1;
        }
    }

    private static Uri getUri(Icon icon) {
        String str = "Unable to get icon uri";
        String str2 = TAG;
        if (VERSION.SDK_INT >= 28) {
            return icon.getUri();
        }
        try {
            return (Uri) icon.getClass().getMethod("getUri", new Class[0]).invoke(icon, new Object[0]);
        } catch (Throwable e) {
            Log.e(str2, str, e);
            return null;
        } catch (Throwable e2) {
            Log.e(str2, str, e2);
            return null;
        } catch (Throwable e22) {
            Log.e(str2, str, e22);
            return null;
        }
    }

    private Drawable loadDrawableInner(Context context) {
        Throwable e;
        StringBuilder stringBuilder;
        String str;
        int i = this.mType;
        if (i == 1) {
            return new BitmapDrawable(context.getResources(), (Bitmap) this.mObj1);
        }
        String str2 = TAG;
        if (i == 2) {
            String resPackage = getResPackage();
            if (TextUtils.isEmpty(resPackage)) {
                resPackage = context.getPackageName();
            }
            try {
                return ResourcesCompat.getDrawable(getResources(context, resPackage), this.mInt1, context.getTheme());
            } catch (Throwable e2) {
                Log.e(str2, String.format("Unable to load resource 0x%08x from pkg=%s", new Object[]{Integer.valueOf(this.mInt1), this.mObj1}), e2);
            }
        } else if (i == 3) {
            return new BitmapDrawable(context.getResources(), BitmapFactory.decodeByteArray((byte[]) this.mObj1, this.mInt1, this.mInt2));
        } else {
            if (i == 4) {
                InputStream fileInputStream;
                Object parse = Uri.parse((String) this.mObj1);
                String scheme = parse.getScheme();
                if (!"content".equals(scheme)) {
                    if (!"file".equals(scheme)) {
                        try {
                            fileInputStream = new FileInputStream(new File((String) this.mObj1));
                        } catch (FileNotFoundException e3) {
                            e = e3;
                            stringBuilder = new StringBuilder();
                            str = "Unable to load image from path: ";
                            stringBuilder.append(str);
                            stringBuilder.append(parse);
                            Log.w(str2, stringBuilder.toString(), e);
                            fileInputStream = null;
                            if (fileInputStream != null) {
                                return new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(fileInputStream));
                            }
                            return null;
                        }
                        if (fileInputStream != null) {
                            return new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(fileInputStream));
                        }
                    }
                }
                try {
                    fileInputStream = context.getContentResolver().openInputStream(parse);
                } catch (Exception e4) {
                    e = e4;
                    stringBuilder = new StringBuilder();
                    str = "Unable to load image from URI: ";
                    stringBuilder.append(str);
                    stringBuilder.append(parse);
                    Log.w(str2, stringBuilder.toString(), e);
                    fileInputStream = null;
                    if (fileInputStream != null) {
                        return new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(fileInputStream));
                    }
                    return null;
                }
                if (fileInputStream != null) {
                    return new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(fileInputStream));
                }
            } else if (i == 5) {
                return new BitmapDrawable(context.getResources(), createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, false));
            }
        }
        return null;
    }

    private static String typeToString(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "UNKNOWN" : "BITMAP_MASKABLE" : "URI" : "DATA" : "RESOURCE" : "BITMAP";
    }

    public void addToShortcutIntent(Intent intent, Drawable drawable, Context context) {
        Parcelable parcelable;
        checkResource(context);
        int i = this.mType;
        if (i == 1) {
            parcelable = (Bitmap) this.mObj1;
            if (drawable != null) {
                parcelable = parcelable.copy(parcelable.getConfig(), true);
            }
        } else if (i == 2) {
            try {
                context = context.createPackageContext(getResPackage(), 0);
                if (drawable == null) {
                    intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(context, this.mInt1));
                    return;
                }
                Drawable drawable2 = ContextCompat.getDrawable(context, this.mInt1);
                if (drawable2.getIntrinsicWidth() > 0) {
                    if (drawable2.getIntrinsicHeight() > 0) {
                        parcelable = Bitmap.createBitmap(drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight(), Config.ARGB_8888);
                        drawable2.setBounds(0, 0, parcelable.getWidth(), parcelable.getHeight());
                        drawable2.draw(new Canvas(parcelable));
                    }
                }
                int launcherLargeIconSize = ((ActivityManager) context.getSystemService("activity")).getLauncherLargeIconSize();
                parcelable = Bitmap.createBitmap(launcherLargeIconSize, launcherLargeIconSize, Config.ARGB_8888);
                drawable2.setBounds(0, 0, parcelable.getWidth(), parcelable.getHeight());
                drawable2.draw(new Canvas(parcelable));
            } catch (Throwable e) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Can't find package ");
                stringBuilder.append(this.mObj1);
                throw new IllegalArgumentException(stringBuilder.toString(), e);
            }
        } else if (i == 5) {
            parcelable = createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, true);
        } else {
            throw new IllegalArgumentException("Icon type not supported for intent shortcuts");
        }
        if (drawable != null) {
            i = parcelable.getWidth();
            int height = parcelable.getHeight();
            drawable.setBounds(i / 2, height / 2, i, height);
            drawable.draw(new Canvas(parcelable));
        }
        intent.putExtra("android.intent.extra.shortcut.ICON", parcelable);
    }

    public void checkResource(Context context) {
        if (this.mType == 2) {
            String str = (String) this.mObj1;
            String str2 = ":";
            if (str.contains(str2)) {
                String str3 = str.split(str2, -1)[1];
                String str4 = "/";
                String str5 = str3.split(str4, -1)[0];
                str3 = str3.split(str4, -1)[1];
                str = str.split(str2, -1)[0];
                int identifier = getResources(context, str).getIdentifier(str3, str5, str);
                if (this.mInt1 != identifier) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Id has changed for ");
                    stringBuilder.append(str);
                    stringBuilder.append(str4);
                    stringBuilder.append(str3);
                    Log.i(TAG, stringBuilder.toString());
                    this.mInt1 = identifier;
                }
            }
        }
    }

    public int getResId() {
        if (this.mType == -1 && VERSION.SDK_INT >= 23) {
            return getResId((Icon) this.mObj1);
        }
        if (this.mType == 2) {
            return this.mInt1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("called getResId() on ");
        stringBuilder.append(this);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public String getResPackage() {
        if (this.mType == -1 && VERSION.SDK_INT >= 23) {
            return getResPackage((Icon) this.mObj1);
        }
        if (this.mType == 2) {
            return ((String) this.mObj1).split(":", -1)[0];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("called getResPackage() on ");
        stringBuilder.append(this);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public int getType() {
        return (this.mType != -1 || VERSION.SDK_INT < 23) ? this.mType : getType((Icon) this.mObj1);
    }

    public Uri getUri() {
        return (this.mType != -1 || VERSION.SDK_INT < 23) ? Uri.parse((String) this.mObj1) : getUri((Icon) this.mObj1);
    }

    public Drawable loadDrawable(Context context) {
        checkResource(context);
        if (VERSION.SDK_INT >= 23) {
            return toIcon().loadDrawable(context);
        }
        Drawable loadDrawableInner = loadDrawableInner(context);
        if (!(loadDrawableInner == null || (this.mTintList == null && this.mTintMode == DEFAULT_TINT_MODE))) {
            loadDrawableInner.mutate();
            DrawableCompat.setTintList(loadDrawableInner, this.mTintList);
            DrawableCompat.setTintMode(loadDrawableInner, this.mTintMode);
        }
        return loadDrawableInner;
    }

    public void onPostParceling() {
        Object obj;
        this.mTintMode = Mode.valueOf(this.mTintModeStr);
        int i = this.mType;
        if (i != -1) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this.mObj1 = this.mData;
                        return;
                    } else if (i != 4) {
                        if (i != 5) {
                            return;
                        }
                    }
                }
                this.mObj1 = new String(this.mData, Charset.forName("UTF-16"));
                return;
            }
            obj = this.mParcelable;
            if (obj == null) {
                obj = this.mData;
                this.mObj1 = obj;
                this.mType = 3;
                this.mInt1 = 0;
                this.mInt2 = obj.length;
                return;
            }
        } else {
            obj = this.mParcelable;
            if (obj == null) {
                throw new IllegalArgumentException("Invalid icon");
            }
        }
        this.mObj1 = obj;
    }

    public void onPreParceling(boolean z) {
        this.mTintModeStr = this.mTintMode.name();
        int i = this.mType;
        if (i != -1) {
            if (i != 1) {
                String str = "UTF-16";
                if (i == 2) {
                    this.mData = ((String) this.mObj1).getBytes(Charset.forName(str));
                    return;
                } else if (i == 3) {
                    this.mData = (byte[]) this.mObj1;
                    return;
                } else if (i == 4) {
                    this.mData = this.mObj1.toString().getBytes(Charset.forName(str));
                    return;
                } else if (i != 5) {
                    return;
                }
            }
            if (z) {
                Bitmap bitmap = (Bitmap) this.mObj1;
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(CompressFormat.PNG, 90, byteArrayOutputStream);
                this.mData = byteArrayOutputStream.toByteArray();
                return;
            }
        } else if (z) {
            throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
        }
        this.mParcelable = (Parcelable) this.mObj1;
    }

    public IconCompat setTint(int i) {
        return setTintList(ColorStateList.valueOf(i));
    }

    public IconCompat setTintList(ColorStateList colorStateList) {
        this.mTintList = colorStateList;
        return this;
    }

    public IconCompat setTintMode(Mode mode) {
        this.mTintMode = mode;
        return this;
    }

    public Bundle toBundle() {
        Parcelable parcelable;
        Mode mode;
        Bundle bundle = new Bundle();
        int i = this.mType;
        String str = EXTRA_OBJ;
        if (i != -1) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        bundle.putByteArray(str, (byte[]) this.mObj1);
                        bundle.putInt(EXTRA_TYPE, this.mType);
                        bundle.putInt(EXTRA_INT1, this.mInt1);
                        bundle.putInt(EXTRA_INT2, this.mInt2);
                        parcelable = this.mTintList;
                        if (parcelable != null) {
                            bundle.putParcelable(EXTRA_TINT_LIST, parcelable);
                        }
                        mode = this.mTintMode;
                        if (mode != DEFAULT_TINT_MODE) {
                            bundle.putString(EXTRA_TINT_MODE, mode.name());
                        }
                        return bundle;
                    } else if (i != 4) {
                        if (i != 5) {
                            throw new IllegalArgumentException("Invalid icon");
                        }
                    }
                }
                bundle.putString(str, (String) this.mObj1);
                bundle.putInt(EXTRA_TYPE, this.mType);
                bundle.putInt(EXTRA_INT1, this.mInt1);
                bundle.putInt(EXTRA_INT2, this.mInt2);
                parcelable = this.mTintList;
                if (parcelable != null) {
                    bundle.putParcelable(EXTRA_TINT_LIST, parcelable);
                }
                mode = this.mTintMode;
                if (mode != DEFAULT_TINT_MODE) {
                    bundle.putString(EXTRA_TINT_MODE, mode.name());
                }
                return bundle;
            }
            parcelable = (Bitmap) this.mObj1;
        } else {
            parcelable = (Parcelable) this.mObj1;
        }
        bundle.putParcelable(str, parcelable);
        bundle.putInt(EXTRA_TYPE, this.mType);
        bundle.putInt(EXTRA_INT1, this.mInt1);
        bundle.putInt(EXTRA_INT2, this.mInt2);
        parcelable = this.mTintList;
        if (parcelable != null) {
            bundle.putParcelable(EXTRA_TINT_LIST, parcelable);
        }
        mode = this.mTintMode;
        if (mode != DEFAULT_TINT_MODE) {
            bundle.putString(EXTRA_TINT_MODE, mode.name());
        }
        return bundle;
    }

    public Icon toIcon() {
        int i = this.mType;
        if (i == -1) {
            return (Icon) this.mObj1;
        }
        Icon createWithResource;
        Bitmap createLegacyIconFromAdaptiveIcon;
        ColorStateList colorStateList;
        Mode mode;
        if (i != 1) {
            if (i == 2) {
                createWithResource = Icon.createWithResource(getResPackage(), this.mInt1);
            } else if (i == 3) {
                createWithResource = Icon.createWithData((byte[]) this.mObj1, this.mInt1, this.mInt2);
            } else if (i == 4) {
                createWithResource = Icon.createWithContentUri((String) this.mObj1);
            } else if (i != 5) {
                throw new IllegalArgumentException("Unknown type");
            } else if (VERSION.SDK_INT >= 26) {
                createWithResource = Icon.createWithAdaptiveBitmap((Bitmap) this.mObj1);
            } else {
                createLegacyIconFromAdaptiveIcon = createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, false);
            }
            colorStateList = this.mTintList;
            if (colorStateList != null) {
                createWithResource.setTintList(colorStateList);
            }
            mode = this.mTintMode;
            if (mode != DEFAULT_TINT_MODE) {
                createWithResource.setTintMode(mode);
            }
            return createWithResource;
        }
        createLegacyIconFromAdaptiveIcon = (Bitmap) this.mObj1;
        createWithResource = Icon.createWithBitmap(createLegacyIconFromAdaptiveIcon);
        colorStateList = this.mTintList;
        if (colorStateList != null) {
            createWithResource.setTintList(colorStateList);
        }
        mode = this.mTintMode;
        if (mode != DEFAULT_TINT_MODE) {
            createWithResource.setTintMode(mode);
        }
        return createWithResource;
    }

    public String toString() {
        if (this.mType == -1) {
            return String.valueOf(this.mObj1);
        }
        StringBuilder stringBuilder = new StringBuilder("Icon(typ=");
        stringBuilder.append(typeToString(this.mType));
        int i = this.mType;
        if (i != 1) {
            if (i == 2) {
                stringBuilder.append(" pkg=");
                stringBuilder.append(getResPackage());
                stringBuilder.append(" id=");
                stringBuilder.append(String.format("0x%08x", new Object[]{Integer.valueOf(getResId())}));
            } else if (i == 3) {
                stringBuilder.append(" len=");
                stringBuilder.append(this.mInt1);
                if (this.mInt2 != 0) {
                    stringBuilder.append(" off=");
                    i = this.mInt2;
                    stringBuilder.append(i);
                }
            } else if (i == 4) {
                stringBuilder.append(" uri=");
                stringBuilder.append(this.mObj1);
            } else if (i != 5) {
            }
            if (this.mTintList != null) {
                stringBuilder.append(" tint=");
                stringBuilder.append(this.mTintList);
            }
            if (this.mTintMode != DEFAULT_TINT_MODE) {
                stringBuilder.append(" mode=");
                stringBuilder.append(this.mTintMode);
            }
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
        stringBuilder.append(" size=");
        stringBuilder.append(((Bitmap) this.mObj1).getWidth());
        stringBuilder.append("x");
        i = ((Bitmap) this.mObj1).getHeight();
        stringBuilder.append(i);
        if (this.mTintList != null) {
            stringBuilder.append(" tint=");
            stringBuilder.append(this.mTintList);
        }
        if (this.mTintMode != DEFAULT_TINT_MODE) {
            stringBuilder.append(" mode=");
            stringBuilder.append(this.mTintMode);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
