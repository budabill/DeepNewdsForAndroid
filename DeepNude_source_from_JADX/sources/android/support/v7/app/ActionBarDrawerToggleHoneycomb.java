package android.support.v7.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.widget.ImageView;
import java.lang.reflect.Method;

class ActionBarDrawerToggleHoneycomb {
    private static final String TAG = "ActionBarDrawerToggleHC";
    private static final int[] THEME_ATTRS = new int[]{16843531};

    static class SetIndicatorInfo {
        public Method setHomeActionContentDescription;
        public Method setHomeAsUpIndicator;
        public ImageView upIndicatorView;

        SetIndicatorInfo(android.app.Activity r6) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
            /*
            r5 = this;
            r5.<init>();
            r0 = 0;
            r1 = 1;
            r2 = android.app.ActionBar.class;	 Catch:{ NoSuchMethodException -> 0x0026 }
            r3 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodException -> 0x0026 }
            r4 = android.graphics.drawable.Drawable.class;	 Catch:{ NoSuchMethodException -> 0x0026 }
            r3[r0] = r4;	 Catch:{ NoSuchMethodException -> 0x0026 }
            r4 = "setHomeAsUpIndicator";
            r2 = r2.getDeclaredMethod(r4, r3);	 Catch:{ NoSuchMethodException -> 0x0026 }
            r5.setHomeAsUpIndicator = r2;	 Catch:{ NoSuchMethodException -> 0x0026 }
            r2 = android.app.ActionBar.class;	 Catch:{ NoSuchMethodException -> 0x0026 }
            r3 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodException -> 0x0026 }
            r4 = java.lang.Integer.TYPE;	 Catch:{ NoSuchMethodException -> 0x0026 }
            r3[r0] = r4;	 Catch:{ NoSuchMethodException -> 0x0026 }
            r4 = "setHomeActionContentDescription";
            r2 = r2.getDeclaredMethod(r4, r3);	 Catch:{ NoSuchMethodException -> 0x0026 }
            r5.setHomeActionContentDescription = r2;	 Catch:{ NoSuchMethodException -> 0x0026 }
            return;
            r2 = 16908332; // 0x102002c float:2.3877352E-38 double:8.353826E-317;
            r6 = r6.findViewById(r2);
            if (r6 != 0) goto L_0x0031;
        L_0x0030:
            return;
        L_0x0031:
            r6 = r6.getParent();
            r6 = (android.view.ViewGroup) r6;
            r3 = r6.getChildCount();
            r4 = 2;
            if (r3 == r4) goto L_0x003f;
        L_0x003e:
            return;
        L_0x003f:
            r0 = r6.getChildAt(r0);
            r6 = r6.getChildAt(r1);
            r1 = r0.getId();
            if (r1 != r2) goto L_0x004e;
        L_0x004d:
            goto L_0x004f;
        L_0x004e:
            r6 = r0;
            r0 = r6 instanceof android.widget.ImageView;
            if (r0 == 0) goto L_0x0058;
        L_0x0054:
            r6 = (android.widget.ImageView) r6;
            r5.upIndicatorView = r6;
        L_0x0058:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.ActionBarDrawerToggleHoneycomb.SetIndicatorInfo.<init>(android.app.Activity):void");
        }
    }

    private ActionBarDrawerToggleHoneycomb() {
    }

    public static Drawable getThemeUpIndicator(Activity activity) {
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(THEME_ATTRS);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    public static SetIndicatorInfo setActionBarDescription(SetIndicatorInfo setIndicatorInfo, Activity activity, int i) {
        if (setIndicatorInfo == null) {
            setIndicatorInfo = new SetIndicatorInfo(activity);
        }
        if (setIndicatorInfo.setHomeAsUpIndicator != null) {
            try {
                ActionBar actionBar = activity.getActionBar();
                setIndicatorInfo.setHomeActionContentDescription.invoke(actionBar, new Object[]{Integer.valueOf(i)});
                if (VERSION.SDK_INT <= 19) {
                    actionBar.setSubtitle(actionBar.getSubtitle());
                }
            } catch (Throwable e) {
                Log.w(TAG, "Couldn't set content description via JB-MR2 API", e);
            }
        }
        return setIndicatorInfo;
    }

    public static SetIndicatorInfo setActionBarUpIndicator(SetIndicatorInfo setIndicatorInfo, Activity activity, Drawable drawable, int i) {
        setIndicatorInfo = new SetIndicatorInfo(activity);
        Method method = setIndicatorInfo.setHomeAsUpIndicator;
        String str = TAG;
        if (method != null) {
            try {
                ActionBar actionBar = activity.getActionBar();
                setIndicatorInfo.setHomeAsUpIndicator.invoke(actionBar, new Object[]{drawable});
                setIndicatorInfo.setHomeActionContentDescription.invoke(actionBar, new Object[]{Integer.valueOf(i)});
            } catch (Throwable e) {
                Log.w(str, "Couldn't set home-as-up indicator via JB-MR2 API", e);
            }
        } else {
            ImageView imageView = setIndicatorInfo.upIndicatorView;
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
            } else {
                Log.w(str, "Couldn't set home-as-up indicator");
            }
        }
        return setIndicatorInfo;
    }
}
