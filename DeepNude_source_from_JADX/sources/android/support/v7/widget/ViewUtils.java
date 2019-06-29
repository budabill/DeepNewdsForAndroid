package android.support.v7.widget;

import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Method;

public class ViewUtils {
    private static final String TAG = "ViewUtils";
    private static Method sComputeFitSystemWindowsMethod;

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
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 18;
        if (r0 < r1) goto L_0x0032;
    L_0x0006:
        r0 = android.view.View.class;	 Catch:{ NoSuchMethodException -> 0x002b }
        r1 = "computeFitSystemWindows";	 Catch:{ NoSuchMethodException -> 0x002b }
        r2 = 2;	 Catch:{ NoSuchMethodException -> 0x002b }
        r2 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x002b }
        r3 = 0;	 Catch:{ NoSuchMethodException -> 0x002b }
        r4 = android.graphics.Rect.class;	 Catch:{ NoSuchMethodException -> 0x002b }
        r2[r3] = r4;	 Catch:{ NoSuchMethodException -> 0x002b }
        r3 = android.graphics.Rect.class;	 Catch:{ NoSuchMethodException -> 0x002b }
        r4 = 1;	 Catch:{ NoSuchMethodException -> 0x002b }
        r2[r4] = r3;	 Catch:{ NoSuchMethodException -> 0x002b }
        r0 = r0.getDeclaredMethod(r1, r2);	 Catch:{ NoSuchMethodException -> 0x002b }
        sComputeFitSystemWindowsMethod = r0;	 Catch:{ NoSuchMethodException -> 0x002b }
        r0 = sComputeFitSystemWindowsMethod;	 Catch:{ NoSuchMethodException -> 0x002b }
        r0 = r0.isAccessible();	 Catch:{ NoSuchMethodException -> 0x002b }
        if (r0 != 0) goto L_0x0032;	 Catch:{ NoSuchMethodException -> 0x002b }
    L_0x0025:
        r0 = sComputeFitSystemWindowsMethod;	 Catch:{ NoSuchMethodException -> 0x002b }
        r0.setAccessible(r4);	 Catch:{ NoSuchMethodException -> 0x002b }
        goto L_0x0032;
    L_0x002b:
        r0 = "ViewUtils";
        r1 = "Could not find method computeFitSystemWindows. Oh well.";
        android.util.Log.d(r0, r1);
    L_0x0032:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ViewUtils.<clinit>():void");
    }

    private ViewUtils() {
    }

    public static void computeFitSystemWindows(View view, Rect rect, Rect rect2) {
        Method method = sComputeFitSystemWindowsMethod;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{rect, rect2});
            } catch (Throwable e) {
                Log.d(TAG, "Could not invoke computeFitSystemWindows", e);
            }
        }
    }

    public static boolean isLayoutRtl(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }

    public static void makeOptionalFitsSystemWindows(android.view.View r6) {
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
        r0 = "Could not invoke makeOptionalFitsSystemWindows";
        r1 = "ViewUtils";
        r2 = android.os.Build.VERSION.SDK_INT;
        r3 = 16;
        if (r2 < r3) goto L_0x0033;
    L_0x000a:
        r2 = r6.getClass();	 Catch:{ NoSuchMethodException -> 0x002e, InvocationTargetException -> 0x0029, IllegalAccessException -> 0x0027 }
        r3 = "makeOptionalFitsSystemWindows";	 Catch:{ NoSuchMethodException -> 0x002e, InvocationTargetException -> 0x0029, IllegalAccessException -> 0x0027 }
        r4 = 0;	 Catch:{ NoSuchMethodException -> 0x002e, InvocationTargetException -> 0x0029, IllegalAccessException -> 0x0027 }
        r5 = new java.lang.Class[r4];	 Catch:{ NoSuchMethodException -> 0x002e, InvocationTargetException -> 0x0029, IllegalAccessException -> 0x0027 }
        r2 = r2.getMethod(r3, r5);	 Catch:{ NoSuchMethodException -> 0x002e, InvocationTargetException -> 0x0029, IllegalAccessException -> 0x0027 }
        r3 = r2.isAccessible();	 Catch:{ NoSuchMethodException -> 0x002e, InvocationTargetException -> 0x0029, IllegalAccessException -> 0x0027 }
        if (r3 != 0) goto L_0x0021;	 Catch:{ NoSuchMethodException -> 0x002e, InvocationTargetException -> 0x0029, IllegalAccessException -> 0x0027 }
    L_0x001d:
        r3 = 1;	 Catch:{ NoSuchMethodException -> 0x002e, InvocationTargetException -> 0x0029, IllegalAccessException -> 0x0027 }
        r2.setAccessible(r3);	 Catch:{ NoSuchMethodException -> 0x002e, InvocationTargetException -> 0x0029, IllegalAccessException -> 0x0027 }
    L_0x0021:
        r3 = new java.lang.Object[r4];	 Catch:{ NoSuchMethodException -> 0x002e, InvocationTargetException -> 0x0029, IllegalAccessException -> 0x0027 }
        r2.invoke(r6, r3);	 Catch:{ NoSuchMethodException -> 0x002e, InvocationTargetException -> 0x0029, IllegalAccessException -> 0x0027 }
        goto L_0x0033;
    L_0x0027:
        r6 = move-exception;
        goto L_0x002a;
    L_0x0029:
        r6 = move-exception;
    L_0x002a:
        android.util.Log.d(r1, r0, r6);
        goto L_0x0033;
    L_0x002e:
        r6 = "Could not find method makeOptionalFitsSystemWindows. Oh well...";
        android.util.Log.d(r1, r6);
    L_0x0033:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ViewUtils.makeOptionalFitsSystemWindows(android.view.View):void");
    }
}
