package com.facebook.marketing.internal;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.C0506l;
import com.facebook.C0560t;
import com.facebook.internal.C0475Q;
import com.facebook.p029a.p030a.C0359c.C0358a;
import com.facebook.p029a.p030a.p031a.C0355f;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.marketing.internal.b */
public class C0531b {
    /* renamed from: a */
    private static final String f1022a = "com.facebook.marketing.internal.b";
    /* renamed from: b */
    private final Handler f1023b = new Handler(Looper.getMainLooper());
    /* renamed from: c */
    private Set<Activity> f1024c = new HashSet();
    /* renamed from: d */
    private Set<C0530a> f1025d = new HashSet();
    /* renamed from: e */
    private HashSet<String> f1026e = new HashSet();

    /* renamed from: com.facebook.marketing.internal.b$a */
    protected static class C0530a implements OnGlobalLayoutListener, OnScrollChangedListener, Runnable {
        /* renamed from: a */
        public static volatile Set<String> f1015a = new HashSet();
        /* renamed from: b */
        private static volatile float f1016b = -1.0f;
        /* renamed from: c */
        private WeakReference<View> f1017c;
        /* renamed from: d */
        private final Handler f1018d;
        /* renamed from: e */
        private final String f1019e;
        /* renamed from: f */
        private HashSet<String> f1020f;
        /* renamed from: g */
        private HashMap<String, WeakReference<View>> f1021g = new HashMap();

        public C0530a(View view, String str, HashSet<String> hashSet, Handler handler) {
            this.f1017c = new WeakReference(view);
            this.f1018d = handler;
            this.f1019e = str;
            this.f1020f = hashSet;
            if (f1016b < 0.0f) {
                f1016b = view.getContext().getResources().getDisplayMetrics().density;
            }
            this.f1018d.postDelayed(this, 200);
        }

        /* renamed from: a */
        private void m1197a() {
            View view = (View) this.f1017c.get();
            if (view != null) {
                m1200a(view);
            }
        }

        /* renamed from: a */
        private void m1198a(View view, String str) {
            if (view != null) {
                try {
                    AccessibilityDelegate d = C0355f.m612d(view);
                    Object obj = 1;
                    Object obj2 = d != null ? 1 : null;
                    Object obj3 = (obj2 == null || !(d instanceof C0358a)) ? null : 1;
                    if (obj3 == null || !((C0358a) d).m624a()) {
                        obj = null;
                    }
                    if (!this.f1020f.contains(str) && (obj2 == null || obj3 == null || r1 == null)) {
                        view.setAccessibilityDelegate(C0533d.m1207a(view, str));
                        this.f1020f.add(str);
                    }
                } catch (Throwable e) {
                    Log.e(C0531b.f1022a, "Failed to attach auto logging event listener.", e);
                }
            }
        }

        /* renamed from: a */
        public JSONObject m1199a(View view, int i, String str, boolean z) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(".");
            stringBuilder.append(String.valueOf(i));
            String stringBuilder2 = stringBuilder.toString();
            if (view == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                boolean i2 = C0355f.m617i(view);
                if (i2) {
                    this.f1021g.put(stringBuilder2, new WeakReference(view));
                }
                if ((view instanceof TextView) || (view instanceof ImageView)) {
                    if (!z) {
                        if (i2) {
                        }
                    }
                    if (f1015a.contains(stringBuilder2)) {
                        return null;
                    }
                    f1015a.add(stringBuilder2);
                    C0355f.m606a(view, jSONObject);
                    C0355f.m607a(view, jSONObject, f1016b);
                    return jSONObject;
                }
                JSONArray jSONArray = new JSONArray();
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    int childCount = viewGroup.getChildCount();
                    for (int i3 = 0; i3 < childCount; i3++) {
                        boolean z2;
                        JSONObject a;
                        View childAt = viewGroup.getChildAt(i3);
                        if (!z) {
                            if (!i2) {
                                z2 = false;
                                a = m1199a(childAt, i3, stringBuilder2, z2);
                                if (a != null) {
                                    jSONArray.put(a);
                                }
                            }
                        }
                        z2 = true;
                        a = m1199a(childAt, i3, stringBuilder2, z2);
                        if (a != null) {
                            jSONArray.put(a);
                        }
                    }
                }
                if (jSONArray.length() > 0) {
                    C0355f.m606a(view, jSONObject);
                    jSONObject.put("childviews", jSONArray);
                    return jSONObject;
                }
            } catch (Exception e) {
                C0475Q.m983a(C0531b.f1022a, e);
            }
            return null;
        }

        /* renamed from: a */
        public void m1200a(View view) {
            JSONObject a = m1199a(view, -1, this.f1019e, false);
            if (a != null) {
                C0535f.m1213a(a, this.f1019e);
            }
            for (Entry entry : this.f1021g.entrySet()) {
                m1198a((View) ((WeakReference) entry.getValue()).get(), (String) entry.getKey());
            }
        }

        public void onGlobalLayout() {
            m1197a();
        }

        public void onScrollChanged() {
            m1197a();
        }

        public void run() {
            C0537i a = C0539k.m1216a(C0560t.m1253e());
            if (a == null) {
                return;
            }
            if (a.m1215a()) {
                m1197a();
            }
        }
    }

    /* renamed from: b */
    private void m1203b() {
        for (Activity activity : this.f1024c) {
            this.f1025d.add(new C0530a(activity.getWindow().getDecorView().getRootView(), activity.getClass().getSimpleName(), this.f1026e, this.f1023b));
        }
    }

    /* renamed from: c */
    private void m1204c() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            m1203b();
        } else {
            this.f1023b.post(new C0529a(this));
        }
    }

    /* renamed from: a */
    public void m1205a(Activity activity) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.f1024c.add(activity);
            this.f1026e.clear();
            m1204c();
            return;
        }
        throw new C0506l("Can't add activity to ButtonIndexer on non-UI thread");
    }

    /* renamed from: b */
    public void m1206b(Activity activity) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.f1024c.remove(activity);
            this.f1025d.clear();
            this.f1026e.clear();
            return;
        }
        throw new C0506l("Can't remove activity from ButtonIndexer on non-UI thread");
    }
}
