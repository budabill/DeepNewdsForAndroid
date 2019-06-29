package com.facebook.p029a.p030a.p031a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.NestedScrollingChild;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import com.facebook.internal.C0475Q;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.a.a.a.f */
public class C0355f {
    /* renamed from: a */
    private static final String f557a = "com.facebook.a.a.a.f";
    /* renamed from: b */
    private static WeakReference<View> f558b = new WeakReference(null);
    /* renamed from: c */
    private static Method f559c = null;

    /* renamed from: a */
    public static View m604a(View view) {
        while (view != null) {
            if (!C0355f.m618j(view)) {
                ViewParent parent = view.getParent();
                if (parent == null || !(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            } else {
                return view;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static View m605a(float[] fArr, View view) {
        Exception e;
        C0355f.m608a();
        Method method = f559c;
        if (method != null) {
            if (view != null) {
                try {
                    View view2 = (View) method.invoke(null, new Object[]{fArr, view});
                    if (view2 != null && view2.getId() > 0) {
                        view2 = (View) view2.getParent();
                        if (view2 != null) {
                            return view2;
                        }
                    }
                } catch (IllegalAccessException e2) {
                    e = e2;
                    C0475Q.m983a(f557a, e);
                    return null;
                } catch (InvocationTargetException e3) {
                    e = e3;
                    C0475Q.m983a(f557a, e);
                    return null;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static JSONObject m606a(View view, JSONObject jSONObject) {
        try {
            Object h = C0355f.m616h(view);
            String f = C0355f.m614f(view);
            Object tag = view.getTag();
            CharSequence contentDescription = view.getContentDescription();
            jSONObject.put("classname", view.getClass().getCanonicalName());
            jSONObject.put("classtypebitmask", C0355f.m619k(view));
            jSONObject.put("id", view.getId());
            String str = "text";
            if (C0353d.m594a(view)) {
                h = "";
            }
            jSONObject.put(str, h);
            jSONObject.put("hint", f);
            if (tag != null) {
                jSONObject.put("tag", tag.toString());
            }
            if (contentDescription != null) {
                jSONObject.put("description", contentDescription.toString());
            }
            jSONObject.put("dimension", C0355f.m620l(view));
        } catch (Exception e) {
            C0475Q.m983a(f557a, e);
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static JSONObject m607a(View view, JSONObject jSONObject, float f) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                Typeface typeface = textView.getTypeface();
                if (typeface != null) {
                    jSONObject2.put("font_size", (double) textView.getTextSize());
                    jSONObject2.put("is_bold", typeface.isBold());
                    jSONObject2.put("is_italic", typeface.isItalic());
                    jSONObject.put("text_style", jSONObject2);
                }
            }
            if (view instanceof ImageView) {
                Drawable drawable = ((ImageView) view).getDrawable();
                if ((drawable instanceof BitmapDrawable) && ((float) view.getHeight()) / f <= 44.0f && ((float) view.getWidth()) / f <= 44.0f) {
                    Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                    jSONObject.put("icon_image", Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
                }
            }
        } catch (Exception e) {
            C0475Q.m983a(f557a, e);
        }
        return jSONObject;
    }

    /* renamed from: a */
    private static void m608a() {
        Exception e;
        if (f559c == null) {
            try {
                f559c = Class.forName("com.facebook.react.uimanager.TouchTargetHelper").getDeclaredMethod("findTouchTargetView", new Class[]{float[].class, ViewGroup.class});
                f559c.setAccessible(true);
            } catch (ClassNotFoundException e2) {
                e = e2;
                C0475Q.m983a(f557a, e);
            } catch (NoSuchMethodException e3) {
                e = e3;
                C0475Q.m983a(f557a, e);
            }
        }
    }

    /* renamed from: a */
    public static boolean m609a(View view, View view2) {
        if (!view.getClass().getName().equals("com.facebook.react.views.view.ReactViewGroup")) {
            return false;
        }
        view2 = C0355f.m605a(C0355f.m621m(view), view2);
        return view2 != null && view2.getId() == view.getId();
    }

    /* renamed from: b */
    public static List<View> m610b(View view) {
        List arrayList = new ArrayList();
        if (view != null && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                arrayList.add(viewGroup.getChildAt(i));
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public static JSONObject m611c(View view) {
        if (view.getClass().getName().equals("com.facebook.react.ReactRootView")) {
            f558b = new WeakReference(view);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            C0355f.m606a(view, jSONObject);
            JSONArray jSONArray = new JSONArray();
            List b = C0355f.m610b(view);
            for (int i = 0; i < b.size(); i++) {
                jSONArray.put(C0355f.m611c((View) b.get(i)));
            }
            jSONObject.put("childviews", jSONArray);
        } catch (Throwable e) {
            Log.e(f557a, "Failed to create JSONObject for view.", e);
        }
        return jSONObject;
    }

    /* renamed from: d */
    public static android.view.View.AccessibilityDelegate m612d(android.view.View r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r0 = 0;
        r1 = r5.getClass();	 Catch:{ NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017 }
        r2 = "getAccessibilityDelegate";	 Catch:{ NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017 }
        r3 = 0;	 Catch:{ NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017 }
        r4 = new java.lang.Class[r3];	 Catch:{ NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017 }
        r1 = r1.getMethod(r2, r4);	 Catch:{ NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017 }
        r2 = new java.lang.Object[r3];	 Catch:{ NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017 }
        r5 = r1.invoke(r5, r2);	 Catch:{ NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017 }
        r5 = (android.view.View.AccessibilityDelegate) r5;	 Catch:{ NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017, NoSuchMethodException -> 0x0017 }
        return r5;
    L_0x0017:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.a.a.a.f.d(android.view.View):android.view.View$AccessibilityDelegate");
    }

    /* renamed from: e */
    public static OnTouchListener m613e(View view) {
        Exception e;
        try {
            Field declaredField = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            Object obj = declaredField.get(view);
            if (obj == null) {
                return null;
            }
            OnTouchListener onTouchListener;
            declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnTouchListener");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                onTouchListener = (OnTouchListener) declaredField.get(obj);
            } else {
                onTouchListener = null;
            }
            return onTouchListener;
        } catch (NoSuchFieldException e2) {
            e = e2;
            C0475Q.m983a(f557a, e);
            return null;
        } catch (ClassNotFoundException e3) {
            e = e3;
            C0475Q.m983a(f557a, e);
            return null;
        } catch (IllegalAccessException e4) {
            e = e4;
            C0475Q.m983a(f557a, e);
            return null;
        }
    }

    /* renamed from: f */
    public static String m614f(View view) {
        Object hint = view instanceof TextView ? ((TextView) view).getHint() : view instanceof EditText ? ((EditText) view).getHint() : null;
        return hint == null ? "" : hint.toString();
    }

    /* renamed from: g */
    public static ViewGroup m615g(View view) {
        if (view == null) {
            return null;
        }
        ViewParent parent = view.getParent();
        return (parent == null || !(parent instanceof ViewGroup)) ? null : (ViewGroup) parent;
    }

    /* renamed from: h */
    public static String m616h(View view) {
        String str;
        Object obj = null;
        if (view instanceof TextView) {
            obj = ((TextView) view).getText();
            if (view instanceof Switch) {
                str = ((Switch) view).isChecked() ? "1" : "0";
            }
            return obj == null ? "" : obj.toString();
        } else {
            if (view instanceof Spinner) {
                Object selectedItem = ((Spinner) view).getSelectedItem();
                if (selectedItem != null) {
                    obj = selectedItem.toString();
                }
            } else {
                int i = 0;
                int year;
                int dayOfMonth;
                if (view instanceof DatePicker) {
                    DatePicker datePicker = (DatePicker) view;
                    year = datePicker.getYear();
                    int month = datePicker.getMonth();
                    dayOfMonth = datePicker.getDayOfMonth();
                    obj = String.format("%04d-%02d-%02d", new Object[]{Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(dayOfMonth)});
                } else if (view instanceof TimePicker) {
                    TimePicker timePicker = (TimePicker) view;
                    year = timePicker.getCurrentHour().intValue();
                    dayOfMonth = timePicker.getCurrentMinute().intValue();
                    obj = String.format("%02d:%02d", new Object[]{Integer.valueOf(year), Integer.valueOf(dayOfMonth)});
                } else if (view instanceof RadioGroup) {
                    RadioGroup radioGroup = (RadioGroup) view;
                    year = radioGroup.getCheckedRadioButtonId();
                    int childCount = radioGroup.getChildCount();
                    while (i < childCount) {
                        View childAt = radioGroup.getChildAt(i);
                        if (childAt.getId() == year && (childAt instanceof RadioButton)) {
                            str = ((RadioButton) childAt).getText();
                        } else {
                            i++;
                        }
                    }
                } else if (view instanceof RatingBar) {
                    obj = String.valueOf(((RatingBar) view).getRating());
                }
            }
            if (obj == null) {
            }
        }
        obj = str;
        if (obj == null) {
        }
    }

    /* renamed from: i */
    public static boolean m617i(View view) {
        boolean z = false;
        try {
            Field declaredField = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            Object obj = declaredField.get(view);
            if (obj == null) {
                return false;
            }
            OnClickListener onClickListener = null;
            Field declaredField2 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
            if (declaredField2 != null) {
                onClickListener = (OnClickListener) declaredField2.get(obj);
            }
            if (onClickListener != null) {
                z = true;
            }
            return z;
        } catch (Throwable e) {
            Log.e(f557a, "Failed to check if the view is clickable.", e);
            return false;
        }
    }

    /* renamed from: j */
    public static boolean m618j(View view) {
        return view.getClass().getName().equals("com.facebook.react.ReactRootView");
    }

    /* renamed from: k */
    private static int m619k(View view) {
        int i = view instanceof ImageView ? 2 : 0;
        if (C0355f.m617i(view)) {
            i |= 32;
        }
        if (C0355f.m622n(view)) {
            i |= 512;
        }
        if (view instanceof TextView) {
            i = (i | 1024) | 1;
            if (view instanceof Button) {
                i |= 4;
                if (view instanceof Switch) {
                    i |= 8192;
                } else if (view instanceof CheckBox) {
                    i |= 32768;
                }
            }
            return view instanceof EditText ? i | 2048 : i;
        } else {
            if (!(view instanceof Spinner)) {
                if (!(view instanceof DatePicker)) {
                    return view instanceof RatingBar ? i | 65536 : view instanceof RadioGroup ? i | 16384 : ((view instanceof ViewGroup) && C0355f.m609a(view, (View) f558b.get())) ? i | 64 : i;
                }
            }
            return i | 4096;
        }
    }

    /* renamed from: l */
    private static JSONObject m620l(View view) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("top", view.getTop());
            jSONObject.put("left", view.getLeft());
            jSONObject.put("width", view.getWidth());
            jSONObject.put("height", view.getHeight());
            jSONObject.put("scrollx", view.getScrollX());
            jSONObject.put("scrolly", view.getScrollY());
            jSONObject.put("visibility", view.getVisibility());
        } catch (Throwable e) {
            Log.e(f557a, "Failed to create JSONObject for dimension.", e);
        }
        return jSONObject;
    }

    /* renamed from: m */
    private static float[] m621m(View view) {
        float[] fArr = new float[2];
        r0 = new int[2];
        view.getLocationOnScreen(r0);
        fArr[0] = (float) r0[0];
        fArr[1] = (float) r0[1];
        return fArr;
    }

    /* renamed from: n */
    private static boolean m622n(View view) {
        ViewParent parent = view.getParent();
        return parent != null && ((parent instanceof AdapterView) || (parent instanceof NestedScrollingChild));
    }
}
