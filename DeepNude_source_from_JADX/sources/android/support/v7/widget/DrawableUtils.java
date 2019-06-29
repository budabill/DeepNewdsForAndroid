package android.support.v7.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.WrappedDrawable;
import android.support.v7.graphics.drawable.DrawableWrapper;

public class DrawableUtils {
    public static final Rect INSETS_NONE = new Rect();
    private static final String TAG = "DrawableUtils";
    private static final String VECTOR_DRAWABLE_CLAZZ_NAME = "android.graphics.drawable.VectorDrawable";
    private static Class<?> sInsetsClazz;

    static {
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
        r0 = new android.graphics.Rect;
        r0.<init>();
        INSETS_NONE = r0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 18;
        if (r0 < r1) goto L_0x0015;
    L_0x000d:
        r0 = "android.graphics.Insets";
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0015 }
        sInsetsClazz = r0;	 Catch:{ ClassNotFoundException -> 0x0015 }
    L_0x0015:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.DrawableUtils.<clinit>():void");
    }

    private DrawableUtils() {
    }

    public static boolean canSafelyMutateDrawable(Drawable drawable) {
        if (VERSION.SDK_INT < 15 && (drawable instanceof InsetDrawable)) {
            return false;
        }
        if (VERSION.SDK_INT < 15 && (drawable instanceof GradientDrawable)) {
            return false;
        }
        if (VERSION.SDK_INT < 17 && (drawable instanceof LayerDrawable)) {
            return false;
        }
        if (drawable instanceof DrawableContainer) {
            ConstantState constantState = drawable.getConstantState();
            if (constantState instanceof DrawableContainerState) {
                for (Drawable canSafelyMutateDrawable : ((DrawableContainerState) constantState).getChildren()) {
                    if (!canSafelyMutateDrawable(canSafelyMutateDrawable)) {
                        return false;
                    }
                }
            }
        } else {
            if (drawable instanceof WrappedDrawable) {
                drawable = ((WrappedDrawable) drawable).getWrappedDrawable();
            } else if (drawable instanceof DrawableWrapper) {
                drawable = ((DrawableWrapper) drawable).getWrappedDrawable();
            } else if (drawable instanceof ScaleDrawable) {
                drawable = ((ScaleDrawable) drawable).getDrawable();
            }
            return canSafelyMutateDrawable(drawable);
        }
        return true;
    }

    static void fixDrawable(Drawable drawable) {
        if (VERSION.SDK_INT == 21) {
            if (VECTOR_DRAWABLE_CLAZZ_NAME.equals(drawable.getClass().getName())) {
                fixVectorDrawableTinting(drawable);
            }
        }
    }

    private static void fixVectorDrawableTinting(Drawable drawable) {
        int[] state = drawable.getState();
        if (state != null) {
            if (state.length != 0) {
                drawable.setState(ThemeUtils.EMPTY_STATE_SET);
                drawable.setState(state);
            }
        }
        drawable.setState(ThemeUtils.CHECKED_STATE_SET);
        drawable.setState(state);
    }

    public static android.graphics.Rect getOpticalBounds(android.graphics.drawable.Drawable r12) {
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
        r0 = sInsetsClazz;
        if (r0 == 0) goto L_0x0094;
    L_0x0004:
        r12 = android.support.v4.graphics.drawable.DrawableCompat.unwrap(r12);	 Catch:{ Exception -> 0x008d }
        r0 = r12.getClass();	 Catch:{ Exception -> 0x008d }
        r1 = "getOpticalInsets";	 Catch:{ Exception -> 0x008d }
        r2 = 0;	 Catch:{ Exception -> 0x008d }
        r3 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x008d }
        r0 = r0.getMethod(r1, r3);	 Catch:{ Exception -> 0x008d }
        r1 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x008d }
        r12 = r0.invoke(r12, r1);	 Catch:{ Exception -> 0x008d }
        if (r12 == 0) goto L_0x0094;	 Catch:{ Exception -> 0x008d }
    L_0x001d:
        r0 = new android.graphics.Rect;	 Catch:{ Exception -> 0x008d }
        r0.<init>();	 Catch:{ Exception -> 0x008d }
        r1 = sInsetsClazz;	 Catch:{ Exception -> 0x008d }
        r1 = r1.getFields();	 Catch:{ Exception -> 0x008d }
        r3 = r1.length;	 Catch:{ Exception -> 0x008d }
        r4 = 0;	 Catch:{ Exception -> 0x008d }
    L_0x002a:
        if (r4 >= r3) goto L_0x008c;	 Catch:{ Exception -> 0x008d }
    L_0x002c:
        r5 = r1[r4];	 Catch:{ Exception -> 0x008d }
        r6 = r5.getName();	 Catch:{ Exception -> 0x008d }
        r7 = -1;	 Catch:{ Exception -> 0x008d }
        r8 = r6.hashCode();	 Catch:{ Exception -> 0x008d }
        r9 = 3;	 Catch:{ Exception -> 0x008d }
        r10 = 2;	 Catch:{ Exception -> 0x008d }
        r11 = 1;	 Catch:{ Exception -> 0x008d }
        switch(r8) {
            case -1383228885: goto L_0x005c;
            case 115029: goto L_0x0052;
            case 3317767: goto L_0x0048;
            case 108511772: goto L_0x003e;
            default: goto L_0x003d;
        };	 Catch:{ Exception -> 0x008d }
    L_0x003d:
        goto L_0x0065;	 Catch:{ Exception -> 0x008d }
    L_0x003e:
        r8 = "right";	 Catch:{ Exception -> 0x008d }
        r6 = r6.equals(r8);	 Catch:{ Exception -> 0x008d }
        if (r6 == 0) goto L_0x0065;	 Catch:{ Exception -> 0x008d }
    L_0x0046:
        r7 = 2;	 Catch:{ Exception -> 0x008d }
        goto L_0x0065;	 Catch:{ Exception -> 0x008d }
    L_0x0048:
        r8 = "left";	 Catch:{ Exception -> 0x008d }
        r6 = r6.equals(r8);	 Catch:{ Exception -> 0x008d }
        if (r6 == 0) goto L_0x0065;	 Catch:{ Exception -> 0x008d }
    L_0x0050:
        r7 = 0;	 Catch:{ Exception -> 0x008d }
        goto L_0x0065;	 Catch:{ Exception -> 0x008d }
    L_0x0052:
        r8 = "top";	 Catch:{ Exception -> 0x008d }
        r6 = r6.equals(r8);	 Catch:{ Exception -> 0x008d }
        if (r6 == 0) goto L_0x0065;	 Catch:{ Exception -> 0x008d }
    L_0x005a:
        r7 = 1;	 Catch:{ Exception -> 0x008d }
        goto L_0x0065;	 Catch:{ Exception -> 0x008d }
    L_0x005c:
        r8 = "bottom";	 Catch:{ Exception -> 0x008d }
        r6 = r6.equals(r8);	 Catch:{ Exception -> 0x008d }
        if (r6 == 0) goto L_0x0065;	 Catch:{ Exception -> 0x008d }
    L_0x0064:
        r7 = 3;	 Catch:{ Exception -> 0x008d }
    L_0x0065:
        if (r7 == 0) goto L_0x0083;	 Catch:{ Exception -> 0x008d }
    L_0x0067:
        if (r7 == r11) goto L_0x007c;	 Catch:{ Exception -> 0x008d }
    L_0x0069:
        if (r7 == r10) goto L_0x0075;	 Catch:{ Exception -> 0x008d }
    L_0x006b:
        if (r7 == r9) goto L_0x006e;	 Catch:{ Exception -> 0x008d }
    L_0x006d:
        goto L_0x0089;	 Catch:{ Exception -> 0x008d }
    L_0x006e:
        r5 = r5.getInt(r12);	 Catch:{ Exception -> 0x008d }
        r0.bottom = r5;	 Catch:{ Exception -> 0x008d }
        goto L_0x0089;	 Catch:{ Exception -> 0x008d }
    L_0x0075:
        r5 = r5.getInt(r12);	 Catch:{ Exception -> 0x008d }
        r0.right = r5;	 Catch:{ Exception -> 0x008d }
        goto L_0x0089;	 Catch:{ Exception -> 0x008d }
    L_0x007c:
        r5 = r5.getInt(r12);	 Catch:{ Exception -> 0x008d }
        r0.top = r5;	 Catch:{ Exception -> 0x008d }
        goto L_0x0089;	 Catch:{ Exception -> 0x008d }
    L_0x0083:
        r5 = r5.getInt(r12);	 Catch:{ Exception -> 0x008d }
        r0.left = r5;	 Catch:{ Exception -> 0x008d }
    L_0x0089:
        r4 = r4 + 1;
        goto L_0x002a;
    L_0x008c:
        return r0;
    L_0x008d:
        r12 = "DrawableUtils";
        r0 = "Couldn't obtain the optical insets. Ignoring.";
        android.util.Log.e(r12, r0);
    L_0x0094:
        r12 = INSETS_NONE;
        return r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.DrawableUtils.getOpticalBounds(android.graphics.drawable.Drawable):android.graphics.Rect");
    }

    public static Mode parseTintMode(int i, Mode mode) {
        if (i == 3) {
            return Mode.SRC_OVER;
        }
        if (i == 5) {
            return Mode.SRC_IN;
        }
        if (i == 9) {
            return Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return Mode.ADD;
            default:
                return mode;
        }
    }
}
