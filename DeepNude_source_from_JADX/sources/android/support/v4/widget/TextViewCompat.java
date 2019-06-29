package android.support.v4.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build.VERSION;
import android.support.v4.text.PrecomputedTextCompat;
import android.support.v4.text.PrecomputedTextCompat.Params;
import android.support.v4.text.PrecomputedTextCompat.Params.Builder;
import android.support.v4.util.Preconditions;
import android.text.Editable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class TextViewCompat {
    public static final int AUTO_SIZE_TEXT_TYPE_NONE = 0;
    public static final int AUTO_SIZE_TEXT_TYPE_UNIFORM = 1;
    private static final int LINES = 1;
    private static final String LOG_TAG = "TextViewCompat";
    private static Field sMaxModeField;
    private static boolean sMaxModeFieldFetched;
    private static Field sMaximumField;
    private static boolean sMaximumFieldFetched;
    private static Field sMinModeField;
    private static boolean sMinModeFieldFetched;
    private static Field sMinimumField;
    private static boolean sMinimumFieldFetched;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AutoSizeTextType {
    }

    private static class OreoCallback implements Callback {
        private static final int MENU_ITEM_ORDER_PROCESS_TEXT_INTENT_ACTIONS_START = 100;
        private final Callback mCallback;
        private boolean mCanUseMenuBuilderReferences;
        private boolean mInitializedMenuBuilderReferences = false;
        private Class mMenuBuilderClass;
        private Method mMenuBuilderRemoveItemAtMethod;
        private final TextView mTextView;

        OreoCallback(Callback callback, TextView textView) {
            this.mCallback = callback;
            this.mTextView = textView;
        }

        private Intent createProcessTextIntent() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        private Intent createProcessTextIntentForResolveInfo(ResolveInfo resolveInfo, TextView textView) {
            return createProcessTextIntent().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", isEditable(textView) ^ 1).setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        }

        private List<ResolveInfo> getSupportedActivities(Context context, PackageManager packageManager) {
            List<ResolveInfo> arrayList = new ArrayList();
            if (!(context instanceof Activity)) {
                return arrayList;
            }
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(createProcessTextIntent(), 0)) {
                if (isSupportedActivity(resolveInfo, context)) {
                    arrayList.add(resolveInfo);
                }
            }
            return arrayList;
        }

        private boolean isEditable(TextView textView) {
            return (textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled();
        }

        private boolean isSupportedActivity(ResolveInfo resolveInfo, Context context) {
            boolean z = true;
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            if (!resolveInfo.activityInfo.exported) {
                return false;
            }
            String str = resolveInfo.activityInfo.permission;
            if (str != null) {
                if (context.checkSelfPermission(str) != 0) {
                    z = false;
                }
            }
            return z;
        }

        private void recomputeProcessTextMenuItems(android.view.Menu r9) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
            /*
            r8 = this;
            r0 = r8.mTextView;
            r0 = r0.getContext();
            r1 = r0.getPackageManager();
            r2 = r8.mInitializedMenuBuilderReferences;
            r3 = "removeItemAt";
            r4 = 0;
            r5 = 1;
            if (r2 != 0) goto L_0x0034;
        L_0x0012:
            r8.mInitializedMenuBuilderReferences = r5;
            r2 = "com.android.internal.view.menu.MenuBuilder";
            r2 = java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x002d, ClassNotFoundException -> 0x002d }
            r8.mMenuBuilderClass = r2;	 Catch:{ ClassNotFoundException -> 0x002d, ClassNotFoundException -> 0x002d }
            r2 = r8.mMenuBuilderClass;	 Catch:{ ClassNotFoundException -> 0x002d, ClassNotFoundException -> 0x002d }
            r6 = new java.lang.Class[r5];	 Catch:{ ClassNotFoundException -> 0x002d, ClassNotFoundException -> 0x002d }
            r7 = java.lang.Integer.TYPE;	 Catch:{ ClassNotFoundException -> 0x002d, ClassNotFoundException -> 0x002d }
            r6[r4] = r7;	 Catch:{ ClassNotFoundException -> 0x002d, ClassNotFoundException -> 0x002d }
            r2 = r2.getDeclaredMethod(r3, r6);	 Catch:{ ClassNotFoundException -> 0x002d, ClassNotFoundException -> 0x002d }
            r8.mMenuBuilderRemoveItemAtMethod = r2;	 Catch:{ ClassNotFoundException -> 0x002d, ClassNotFoundException -> 0x002d }
            r8.mCanUseMenuBuilderReferences = r5;	 Catch:{ ClassNotFoundException -> 0x002d, ClassNotFoundException -> 0x002d }
            goto L_0x0034;
        L_0x002d:
            r2 = 0;
            r8.mMenuBuilderClass = r2;
            r8.mMenuBuilderRemoveItemAtMethod = r2;
            r8.mCanUseMenuBuilderReferences = r4;
        L_0x0034:
            r2 = r8.mCanUseMenuBuilderReferences;	 Catch:{ NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab }
            if (r2 == 0) goto L_0x0043;	 Catch:{ NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab }
        L_0x0038:
            r2 = r8.mMenuBuilderClass;	 Catch:{ NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab }
            r2 = r2.isInstance(r9);	 Catch:{ NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab }
            if (r2 == 0) goto L_0x0043;	 Catch:{ NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab }
        L_0x0040:
            r2 = r8.mMenuBuilderRemoveItemAtMethod;	 Catch:{ NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab }
            goto L_0x0051;	 Catch:{ NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab }
        L_0x0043:
            r2 = r9.getClass();	 Catch:{ NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab }
            r6 = new java.lang.Class[r5];	 Catch:{ NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab }
            r7 = java.lang.Integer.TYPE;	 Catch:{ NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab }
            r6[r4] = r7;	 Catch:{ NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab }
            r2 = r2.getDeclaredMethod(r3, r6);	 Catch:{ NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab }
        L_0x0051:
            r3 = r9.size();	 Catch:{ NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab }
            r3 = r3 - r5;	 Catch:{ NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab }
        L_0x0056:
            if (r3 < 0) goto L_0x0080;	 Catch:{ NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab }
        L_0x0058:
            r6 = r9.getItem(r3);	 Catch:{ NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab }
            r7 = r6.getIntent();	 Catch:{ NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab }
            if (r7 == 0) goto L_0x007d;	 Catch:{ NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab }
        L_0x0062:
            r7 = "android.intent.action.PROCESS_TEXT";	 Catch:{ NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab }
            r6 = r6.getIntent();	 Catch:{ NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab }
            r6 = r6.getAction();	 Catch:{ NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab }
            r6 = r7.equals(r6);	 Catch:{ NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab }
            if (r6 == 0) goto L_0x007d;	 Catch:{ NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab }
        L_0x0072:
            r6 = new java.lang.Object[r5];	 Catch:{ NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab }
            r7 = java.lang.Integer.valueOf(r3);	 Catch:{ NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab }
            r6[r4] = r7;	 Catch:{ NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab }
            r2.invoke(r9, r6);	 Catch:{ NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab, NoSuchMethodException -> 0x00ab }
        L_0x007d:
            r3 = r3 + -1;
            goto L_0x0056;
        L_0x0080:
            r0 = r8.getSupportedActivities(r0, r1);
            r2 = 0;
        L_0x0085:
            r3 = r0.size();
            if (r2 >= r3) goto L_0x00ab;
        L_0x008b:
            r3 = r0.get(r2);
            r3 = (android.content.pm.ResolveInfo) r3;
            r6 = r2 + 100;
            r7 = r3.loadLabel(r1);
            r6 = r9.add(r4, r4, r6, r7);
            r7 = r8.mTextView;
            r3 = r8.createProcessTextIntentForResolveInfo(r3, r7);
            r3 = r6.setIntent(r3);
            r3.setShowAsAction(r5);
            r2 = r2 + 1;
            goto L_0x0085;
        L_0x00ab:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.TextViewCompat.OreoCallback.recomputeProcessTextMenuItems(android.view.Menu):void");
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.mCallback.onActionItemClicked(actionMode, menuItem);
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.mCallback.onCreateActionMode(actionMode, menu);
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.mCallback.onDestroyActionMode(actionMode);
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            recomputeProcessTextMenuItems(menu);
            return this.mCallback.onPrepareActionMode(actionMode, menu);
        }
    }

    private TextViewCompat() {
    }

    public static int getAutoSizeMaxTextSize(TextView textView) {
        return VERSION.SDK_INT >= 27 ? textView.getAutoSizeMaxTextSize() : textView instanceof AutoSizeableTextView ? ((AutoSizeableTextView) textView).getAutoSizeMaxTextSize() : -1;
    }

    public static int getAutoSizeMinTextSize(TextView textView) {
        return VERSION.SDK_INT >= 27 ? textView.getAutoSizeMinTextSize() : textView instanceof AutoSizeableTextView ? ((AutoSizeableTextView) textView).getAutoSizeMinTextSize() : -1;
    }

    public static int getAutoSizeStepGranularity(TextView textView) {
        return VERSION.SDK_INT >= 27 ? textView.getAutoSizeStepGranularity() : textView instanceof AutoSizeableTextView ? ((AutoSizeableTextView) textView).getAutoSizeStepGranularity() : -1;
    }

    public static int[] getAutoSizeTextAvailableSizes(TextView textView) {
        return VERSION.SDK_INT >= 27 ? textView.getAutoSizeTextAvailableSizes() : textView instanceof AutoSizeableTextView ? ((AutoSizeableTextView) textView).getAutoSizeTextAvailableSizes() : new int[0];
    }

    public static int getAutoSizeTextType(TextView textView) {
        return VERSION.SDK_INT >= 27 ? textView.getAutoSizeTextType() : textView instanceof AutoSizeableTextView ? ((AutoSizeableTextView) textView).getAutoSizeTextType() : 0;
    }

    public static Drawable[] getCompoundDrawablesRelative(TextView textView) {
        int i = VERSION.SDK_INT;
        if (i >= 18) {
            return textView.getCompoundDrawablesRelative();
        }
        if (i < 17) {
            return textView.getCompoundDrawables();
        }
        Object obj = 1;
        if (textView.getLayoutDirection() != 1) {
            obj = null;
        }
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        if (obj != null) {
            Drawable drawable = compoundDrawables[2];
            Drawable drawable2 = compoundDrawables[0];
            compoundDrawables[0] = drawable;
            compoundDrawables[2] = drawable2;
        }
        return compoundDrawables;
    }

    public static int getFirstBaselineToTopHeight(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    public static int getLastBaselineToBottomHeight(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    public static int getMaxLines(TextView textView) {
        if (VERSION.SDK_INT >= 16) {
            return textView.getMaxLines();
        }
        if (!sMaxModeFieldFetched) {
            sMaxModeField = retrieveField("mMaxMode");
            sMaxModeFieldFetched = true;
        }
        Field field = sMaxModeField;
        if (field != null && retrieveIntFromField(field, textView) == 1) {
            if (!sMaximumFieldFetched) {
                sMaximumField = retrieveField("mMaximum");
                sMaximumFieldFetched = true;
            }
            field = sMaximumField;
            if (field != null) {
                return retrieveIntFromField(field, textView);
            }
        }
        return -1;
    }

    public static int getMinLines(TextView textView) {
        if (VERSION.SDK_INT >= 16) {
            return textView.getMinLines();
        }
        if (!sMinModeFieldFetched) {
            sMinModeField = retrieveField("mMinMode");
            sMinModeFieldFetched = true;
        }
        Field field = sMinModeField;
        if (field != null && retrieveIntFromField(field, textView) == 1) {
            if (!sMinimumFieldFetched) {
                sMinimumField = retrieveField("mMinimum");
                sMinimumFieldFetched = true;
            }
            field = sMinimumField;
            if (field != null) {
                return retrieveIntFromField(field, textView);
            }
        }
        return -1;
    }

    private static int getTextDirection(TextDirectionHeuristic textDirectionHeuristic) {
        return (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL || textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) ? 1 : textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR ? 2 : textDirectionHeuristic == TextDirectionHeuristics.LTR ? 3 : textDirectionHeuristic == TextDirectionHeuristics.RTL ? 4 : textDirectionHeuristic == TextDirectionHeuristics.LOCALE ? 5 : textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR ? 6 : textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL ? 7 : 1;
    }

    private static TextDirectionHeuristic getTextDirectionHeuristic(TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        int i = 0;
        if (VERSION.SDK_INT < 28 || (textView.getInputType() & 15) != 3) {
            if (textView.getLayoutDirection() == 1) {
                i = 1;
            }
            switch (textView.getTextDirection()) {
                case 2:
                    return TextDirectionHeuristics.ANYRTL_LTR;
                case 3:
                    return TextDirectionHeuristics.LTR;
                case 4:
                    return TextDirectionHeuristics.RTL;
                case 5:
                    return TextDirectionHeuristics.LOCALE;
                case 6:
                    return TextDirectionHeuristics.FIRSTSTRONG_LTR;
                case 7:
                    return TextDirectionHeuristics.FIRSTSTRONG_RTL;
                default:
                    return i != 0 ? TextDirectionHeuristics.FIRSTSTRONG_RTL : TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
        }
        byte directionality = Character.getDirectionality(DecimalFormatSymbols.getInstance(textView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
        if (directionality != (byte) 1) {
            if (directionality != (byte) 2) {
                return TextDirectionHeuristics.LTR;
            }
        }
        return TextDirectionHeuristics.RTL;
    }

    public static Params getTextMetricsParams(TextView textView) {
        if (VERSION.SDK_INT >= 28) {
            return new Params(textView.getTextMetricsParams());
        }
        Builder builder = new Builder(new TextPaint(textView.getPaint()));
        if (VERSION.SDK_INT >= 23) {
            builder.setBreakStrategy(textView.getBreakStrategy());
            builder.setHyphenationFrequency(textView.getHyphenationFrequency());
        }
        if (VERSION.SDK_INT >= 18) {
            builder.setTextDirection(getTextDirectionHeuristic(textView));
        }
        return builder.build();
    }

    private static java.lang.reflect.Field retrieveField(java.lang.String r3) {
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
        r0 = 0;
        r1 = android.widget.TextView.class;	 Catch:{ NoSuchFieldException -> 0x000c }
        r0 = r1.getDeclaredField(r3);	 Catch:{ NoSuchFieldException -> 0x000c }
        r1 = 1;	 Catch:{ NoSuchFieldException -> 0x000c }
        r0.setAccessible(r1);	 Catch:{ NoSuchFieldException -> 0x000c }
        goto L_0x0027;
    L_0x000c:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Could not retrieve ";
        r1.append(r2);
        r1.append(r3);
        r3 = " field.";
        r1.append(r3);
        r3 = r1.toString();
        r1 = "TextViewCompat";
        android.util.Log.e(r1, r3);
    L_0x0027:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.TextViewCompat.retrieveField(java.lang.String):java.lang.reflect.Field");
    }

    private static int retrieveIntFromField(java.lang.reflect.Field r1, android.widget.TextView r2) {
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
        r1 = r1.getInt(r2);	 Catch:{ IllegalAccessException -> 0x0005 }
        return r1;
    L_0x0005:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r0 = "Could not retrieve value of ";
        r2.append(r0);
        r1 = r1.getName();
        r2.append(r1);
        r1 = " field.";
        r2.append(r1);
        r1 = r2.toString();
        r2 = "TextViewCompat";
        android.util.Log.d(r2, r1);
        r1 = -1;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.TextViewCompat.retrieveIntFromField(java.lang.reflect.Field, android.widget.TextView):int");
    }

    public static void setAutoSizeTextTypeUniformWithConfiguration(TextView textView, int i, int i2, int i3, int i4) {
        if (VERSION.SDK_INT >= 27) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        } else if (textView instanceof AutoSizeableTextView) {
            ((AutoSizeableTextView) textView).setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        }
    }

    public static void setAutoSizeTextTypeUniformWithPresetSizes(TextView textView, int[] iArr, int i) {
        if (VERSION.SDK_INT >= 27) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        } else if (textView instanceof AutoSizeableTextView) {
            ((AutoSizeableTextView) textView).setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        }
    }

    public static void setAutoSizeTextTypeWithDefaults(TextView textView, int i) {
        if (VERSION.SDK_INT >= 27) {
            textView.setAutoSizeTextTypeWithDefaults(i);
        } else if (textView instanceof AutoSizeableTextView) {
            ((AutoSizeableTextView) textView).setAutoSizeTextTypeWithDefaults(i);
        }
    }

    public static void setCompoundDrawablesRelative(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        int i = VERSION.SDK_INT;
        if (i >= 18) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else if (i >= 17) {
            Object obj = 1;
            if (textView.getLayoutDirection() != 1) {
                obj = null;
            }
            Drawable drawable5 = obj != null ? drawable3 : drawable;
            if (obj == null) {
                drawable = drawable3;
            }
            textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
        } else {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView textView, int i, int i2, int i3, int i4) {
        int i5 = VERSION.SDK_INT;
        if (i5 >= 18) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
        } else if (i5 >= 17) {
            Object obj = 1;
            if (textView.getLayoutDirection() != 1) {
                obj = null;
            }
            i5 = obj != null ? i3 : i;
            if (obj == null) {
                i = i3;
            }
            textView.setCompoundDrawablesWithIntrinsicBounds(i5, i2, i, i4);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
        }
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        int i = VERSION.SDK_INT;
        if (i >= 18) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else if (i >= 17) {
            Object obj = 1;
            if (textView.getLayoutDirection() != 1) {
                obj = null;
            }
            Drawable drawable5 = obj != null ? drawable3 : drawable;
            if (obj == null) {
                drawable = drawable3;
            }
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable5, drawable2, drawable, drawable4);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }

    public static void setCustomSelectionActionModeCallback(TextView textView, Callback callback) {
        textView.setCustomSelectionActionModeCallback(wrapCustomSelectionActionModeCallback(textView, callback));
    }

    public static void setFirstBaselineToTopHeight(TextView textView, int i) {
        Preconditions.checkArgumentNonnegative(i);
        if (VERSION.SDK_INT >= 28) {
            textView.setFirstBaselineToTopHeight(i);
            return;
        }
        int i2;
        FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (VERSION.SDK_INT >= 16) {
            if (!textView.getIncludeFontPadding()) {
                i2 = fontMetricsInt.ascent;
                if (i > Math.abs(i2)) {
                    textView.setPadding(textView.getPaddingLeft(), i - (-i2), textView.getPaddingRight(), textView.getPaddingBottom());
                }
            }
        }
        i2 = fontMetricsInt.top;
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), i - (-i2), textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void setLastBaselineToBottomHeight(TextView textView, int i) {
        int i2;
        Preconditions.checkArgumentNonnegative(i);
        FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (VERSION.SDK_INT >= 16) {
            if (!textView.getIncludeFontPadding()) {
                i2 = fontMetricsInt.descent;
                if (i > Math.abs(i2)) {
                    textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i - i2);
                }
            }
        }
        i2 = fontMetricsInt.bottom;
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i - i2);
        }
    }

    public static void setLineHeight(TextView textView, int i) {
        Preconditions.checkArgumentNonnegative(i);
        int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
        if (i != fontMetricsInt) {
            textView.setLineSpacing((float) (i - fontMetricsInt), 1.0f);
        }
    }

    public static void setPrecomputedText(TextView textView, PrecomputedTextCompat precomputedTextCompat) {
        CharSequence precomputedText;
        if (VERSION.SDK_INT >= 28) {
            precomputedText = precomputedTextCompat.getPrecomputedText();
        } else if (!getTextMetricsParams(textView).equals(precomputedTextCompat.getParams())) {
            throw new IllegalArgumentException("Given text can not be applied to TextView.");
        }
        textView.setText(precomputedText);
    }

    public static void setTextAppearance(TextView textView, int i) {
        if (VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i);
        } else {
            textView.setTextAppearance(textView.getContext(), i);
        }
    }

    public static void setTextMetricsParams(TextView textView, Params params) {
        if (VERSION.SDK_INT >= 18) {
            textView.setTextDirection(getTextDirection(params.getTextDirection()));
        }
        if (VERSION.SDK_INT < 23) {
            float textScaleX = params.getTextPaint().getTextScaleX();
            textView.getPaint().set(params.getTextPaint());
            if (textScaleX == textView.getTextScaleX()) {
                textView.setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            textView.setTextScaleX(textScaleX);
            return;
        }
        textView.getPaint().set(params.getTextPaint());
        textView.setBreakStrategy(params.getBreakStrategy());
        textView.setHyphenationFrequency(params.getHyphenationFrequency());
    }

    public static Callback wrapCustomSelectionActionModeCallback(TextView textView, Callback callback) {
        int i = VERSION.SDK_INT;
        if (i >= 26 && i <= 27) {
            if (!(callback instanceof OreoCallback)) {
                return new OreoCallback(callback, textView);
            }
        }
        return callback;
    }
}
