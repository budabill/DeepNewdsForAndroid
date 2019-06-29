package com.facebook.p029a.p030a;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.facebook.C0506l;
import com.facebook.C0560t;
import com.facebook.internal.C0457C;
import com.facebook.internal.C0458D;
import com.facebook.internal.C0503y;
import com.facebook.p029a.p030a.C0359c.C0358a;
import com.facebook.p029a.p030a.C0366g.C0365a;
import com.facebook.p029a.p030a.p031a.C0349a;
import com.facebook.p029a.p030a.p031a.C0350b;
import com.facebook.p029a.p030a.p031a.C0352c;
import com.facebook.p029a.p030a.p031a.C0355f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.facebook.a.a.e */
public class C0363e {
    /* renamed from: a */
    private static final String f580a = "com.facebook.a.a.e";
    /* renamed from: b */
    private final Handler f581b = new Handler(Looper.getMainLooper());
    /* renamed from: c */
    private Set<Activity> f582c = new HashSet();
    /* renamed from: d */
    private Set<C0362b> f583d = new HashSet();
    /* renamed from: e */
    private HashMap<String, String> f584e = new HashMap();

    /* renamed from: com.facebook.a.a.e$a */
    public static class C0361a {
        /* renamed from: a */
        private WeakReference<View> f573a;
        /* renamed from: b */
        private String f574b;

        public C0361a(View view, String str) {
            this.f573a = new WeakReference(view);
            this.f574b = str;
        }

        /* renamed from: a */
        public View m628a() {
            WeakReference weakReference = this.f573a;
            return weakReference == null ? null : (View) weakReference.get();
        }

        /* renamed from: b */
        public String m629b() {
            return this.f574b;
        }
    }

    /* renamed from: com.facebook.a.a.e$b */
    protected static class C0362b implements OnGlobalLayoutListener, OnScrollChangedListener, Runnable {
        /* renamed from: a */
        private WeakReference<View> f575a;
        /* renamed from: b */
        private List<C0349a> f576b;
        /* renamed from: c */
        private final Handler f577c;
        /* renamed from: d */
        private HashMap<String, String> f578d;
        /* renamed from: e */
        private final String f579e;

        public C0362b(View view, Handler handler, HashMap<String, String> hashMap, String str) {
            this.f575a = new WeakReference(view);
            this.f577c = handler;
            this.f578d = hashMap;
            this.f579e = str;
            this.f577c.postDelayed(this, 200);
        }

        /* renamed from: a */
        private static List<View> m630a(ViewGroup viewGroup) {
            List<View> arrayList = new ArrayList();
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    arrayList.add(childAt);
                }
            }
            return arrayList;
        }

        /* renamed from: a */
        public static List<C0361a> m631a(C0349a c0349a, View view, List<C0352c> list, int i, int i2, String str) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            str = ".";
            stringBuilder.append(str);
            stringBuilder.append(String.valueOf(i2));
            String stringBuilder2 = stringBuilder.toString();
            List<C0361a> arrayList = new ArrayList();
            if (view == null) {
                return arrayList;
            }
            Object c0361a;
            List a;
            int i3;
            if (i >= list.size()) {
                c0361a = new C0361a(view, stringBuilder2);
            } else {
                C0352c c0352c = (C0352c) list.get(i);
                if (c0352c.f547a.equals("..")) {
                    ViewParent parent = view.getParent();
                    if (parent instanceof ViewGroup) {
                        a = C0362b.m630a((ViewGroup) parent);
                        i2 = a.size();
                        for (i3 = 0; i3 < i2; i3++) {
                            arrayList.addAll(C0362b.m631a(c0349a, (View) a.get(i3), list, i + 1, i3, stringBuilder2));
                        }
                    }
                    return arrayList;
                } else if (c0352c.f547a.equals(str)) {
                    arrayList.add(new C0361a(view, stringBuilder2));
                    return arrayList;
                } else if (!C0362b.m635a(view, c0352c, i2)) {
                    return arrayList;
                } else {
                    if (i == list.size() - 1) {
                        c0361a = new C0361a(view, stringBuilder2);
                    }
                    if (view instanceof ViewGroup) {
                        a = C0362b.m630a((ViewGroup) view);
                        i2 = a.size();
                        for (i3 = 0; i3 < i2; i3++) {
                            arrayList.addAll(C0362b.m631a(c0349a, (View) a.get(i3), list, i + 1, i3, stringBuilder2));
                        }
                    }
                    return arrayList;
                }
            }
            arrayList.add(c0361a);
            if (view instanceof ViewGroup) {
                a = C0362b.m630a((ViewGroup) view);
                i2 = a.size();
                for (i3 = 0; i3 < i2; i3++) {
                    arrayList.addAll(C0362b.m631a(c0349a, (View) a.get(i3), list, i + 1, i3, stringBuilder2));
                }
            }
            return arrayList;
        }

        /* renamed from: a */
        private void m632a() {
            if (this.f576b != null && this.f575a.get() != null) {
                for (int i = 0; i < this.f576b.size(); i++) {
                    m636a((C0349a) this.f576b.get(i), (View) this.f575a.get());
                }
            }
        }

        /* renamed from: a */
        private void m633a(C0361a c0361a, View view, View view2, C0349a c0349a) {
            if (c0349a != null) {
                View a = c0361a.m628a();
                if (a != null) {
                    if (C0355f.m609a(a, view2)) {
                        String b = c0361a.m629b();
                        OnTouchListener e = C0355f.m613e(a);
                        Object obj = 1;
                        Object obj2 = e != null ? 1 : null;
                        Object obj3 = (obj2 == null || !(e instanceof C0365a)) ? null : 1;
                        if (obj3 == null || !((C0365a) e).m645a()) {
                            obj = null;
                        }
                        if (!this.f578d.containsKey(b) && (obj2 == null || obj3 == null || r1 == null)) {
                            a.setOnTouchListener(C0366g.m646a(c0349a, view, a));
                            this.f578d.put(b, c0349a.m589b());
                        }
                    }
                }
            }
        }

        /* renamed from: a */
        private void m634a(C0361a c0361a, View view, C0349a c0349a) {
            if (c0349a != null) {
                try {
                    View a = c0361a.m628a();
                    if (a != null) {
                        View a2 = C0355f.m604a(a);
                        if (a2 != null && C0355f.m609a(a, a2)) {
                            m633a(c0361a, view, a2, c0349a);
                        } else if (!a.getClass().getName().startsWith("com.facebook.react")) {
                            String b = c0361a.m629b();
                            AccessibilityDelegate d = C0355f.m612d(a);
                            Object obj = 1;
                            Object obj2 = d != null ? 1 : null;
                            Object obj3 = (obj2 == null || !(d instanceof C0358a)) ? null : 1;
                            if (obj3 == null || !((C0358a) d).m625b()) {
                                obj = null;
                            }
                            if (!this.f578d.containsKey(b) && (obj2 == null || obj3 == null || r2 == null)) {
                                a.setAccessibilityDelegate(C0359c.m626a(c0349a, view, a));
                                this.f578d.put(b, c0349a.m589b());
                            }
                        }
                    }
                } catch (Throwable e) {
                    Log.e(C0363e.f580a, "Failed to attach auto logging event listener.", e);
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        private static boolean m635a(android.view.View r4, com.facebook.p029a.p030a.p031a.C0352c r5, int r6) {
            /*
            r0 = r5.f548b;
            r1 = 0;
            r2 = -1;
            if (r0 == r2) goto L_0x0009;
        L_0x0006:
            if (r6 == r0) goto L_0x0009;
        L_0x0008:
            return r1;
        L_0x0009:
            r6 = r4.getClass();
            r6 = r6.getCanonicalName();
            r0 = r5.f547a;
            r6 = r6.equals(r0);
            r0 = 1;
            if (r6 != 0) goto L_0x0042;
        L_0x001a:
            r6 = r5.f547a;
            r2 = ".*android\\..*";
            r6 = r6.matches(r2);
            if (r6 == 0) goto L_0x0041;
        L_0x0024:
            r6 = r5.f547a;
            r2 = "\\.";
            r6 = r6.split(r2);
            r2 = r6.length;
            if (r2 <= 0) goto L_0x0041;
        L_0x002f:
            r2 = r6.length;
            r2 = r2 - r0;
            r6 = r6[r2];
            r2 = r4.getClass();
            r2 = r2.getSimpleName();
            r6 = r2.equals(r6);
            if (r6 != 0) goto L_0x0042;
        L_0x0041:
            return r1;
        L_0x0042:
            r6 = r5.f554h;
            r2 = com.facebook.p029a.p030a.p031a.C0352c.C0351a.ID;
            r2 = r2.m593a();
            r6 = r6 & r2;
            if (r6 <= 0) goto L_0x0056;
        L_0x004d:
            r6 = r5.f549c;
            r2 = r4.getId();
            if (r6 == r2) goto L_0x0056;
        L_0x0055:
            return r1;
        L_0x0056:
            r6 = r5.f554h;
            r2 = com.facebook.p029a.p030a.p031a.C0352c.C0351a.TEXT;
            r2 = r2.m593a();
            r6 = r6 & r2;
            if (r6 <= 0) goto L_0x006e;
        L_0x0061:
            r6 = r5.f550d;
            r2 = com.facebook.p029a.p030a.p031a.C0355f.m616h(r4);
            r6 = r6.equals(r2);
            if (r6 != 0) goto L_0x006e;
        L_0x006d:
            return r1;
        L_0x006e:
            r6 = r5.f554h;
            r2 = com.facebook.p029a.p030a.p031a.C0352c.C0351a.DESCRIPTION;
            r2 = r2.m593a();
            r6 = r6 & r2;
            r2 = "";
            if (r6 <= 0) goto L_0x0094;
        L_0x007b:
            r6 = r5.f552f;
            r3 = r4.getContentDescription();
            if (r3 != 0) goto L_0x0085;
        L_0x0083:
            r3 = r2;
            goto L_0x008d;
        L_0x0085:
            r3 = r4.getContentDescription();
            r3 = java.lang.String.valueOf(r3);
        L_0x008d:
            r6 = r6.equals(r3);
            if (r6 != 0) goto L_0x0094;
        L_0x0093:
            return r1;
        L_0x0094:
            r6 = r5.f554h;
            r3 = com.facebook.p029a.p030a.p031a.C0352c.C0351a.HINT;
            r3 = r3.m593a();
            r6 = r6 & r3;
            if (r6 <= 0) goto L_0x00ac;
        L_0x009f:
            r6 = r5.f553g;
            r3 = com.facebook.p029a.p030a.p031a.C0355f.m614f(r4);
            r6 = r6.equals(r3);
            if (r6 != 0) goto L_0x00ac;
        L_0x00ab:
            return r1;
        L_0x00ac:
            r6 = r5.f554h;
            r3 = com.facebook.p029a.p030a.p031a.C0352c.C0351a.TAG;
            r3 = r3.m593a();
            r6 = r6 & r3;
            if (r6 <= 0) goto L_0x00cf;
        L_0x00b7:
            r5 = r5.f551e;
            r6 = r4.getTag();
            if (r6 != 0) goto L_0x00c0;
        L_0x00bf:
            goto L_0x00c8;
        L_0x00c0:
            r4 = r4.getTag();
            r2 = java.lang.String.valueOf(r4);
        L_0x00c8:
            r4 = r5.equals(r2);
            if (r4 != 0) goto L_0x00cf;
        L_0x00ce:
            return r1;
        L_0x00cf:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.a.a.e.b.a(android.view.View, com.facebook.a.a.a.c, int):boolean");
        }

        /* renamed from: a */
        public void m636a(C0349a c0349a, View view) {
            if (c0349a != null) {
                if (view != null) {
                    if (TextUtils.isEmpty(c0349a.m588a()) || c0349a.m588a().equals(this.f579e)) {
                        List e = c0349a.m592e();
                        if (e.size() <= 25) {
                            for (C0361a a : C0362b.m631a(c0349a, view, e, 0, -1, this.f579e)) {
                                m634a(a, view, c0349a);
                            }
                        }
                    }
                }
            }
        }

        public void onGlobalLayout() {
            m632a();
        }

        public void onScrollChanged() {
            m632a();
        }

        public void run() {
            C0503y b = C0457C.m876b(C0560t.m1253e());
            if (b != null) {
                if (b.m1099b()) {
                    this.f576b = C0349a.m587a(b.m1103f());
                    if (this.f576b != null) {
                        View view = (View) this.f575a.get();
                        if (view != null) {
                            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                            if (viewTreeObserver.isAlive()) {
                                viewTreeObserver.addOnGlobalLayoutListener(this);
                                viewTreeObserver.addOnScrollChangedListener(this);
                            }
                            m632a();
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static Bundle m637a(C0349a c0349a, View view, View view2) {
        Bundle bundle = new Bundle();
        if (c0349a == null) {
            return bundle;
        }
        List<C0350b> d = c0349a.m591d();
        if (d != null) {
            for (C0350b c0350b : d) {
                String str = c0350b.f537b;
                if (str != null && str.length() > 0) {
                    bundle.putString(c0350b.f536a, c0350b.f537b);
                } else if (c0350b.f538c.size() > 0) {
                    List list;
                    int i;
                    int i2;
                    String simpleName;
                    C0349a c0349a2;
                    View view3;
                    if (c0350b.f539d.equals("relative")) {
                        list = c0350b.f538c;
                        i = 0;
                        i2 = -1;
                        simpleName = view2.getClass().getSimpleName();
                        c0349a2 = c0349a;
                        view3 = view2;
                    } else {
                        list = c0350b.f538c;
                        i = 0;
                        i2 = -1;
                        simpleName = view.getClass().getSimpleName();
                        c0349a2 = c0349a;
                        view3 = view;
                    }
                    for (C0361a c0361a : C0362b.m631a(r4, r5, r6, r7, r8, r9)) {
                        if (c0361a.m628a() != null) {
                            String h = C0355f.m616h(c0361a.m628a());
                            if (h.length() > 0) {
                                bundle.putString(c0350b.f536a, h);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return bundle;
    }

    /* renamed from: b */
    private void m640b() {
        for (Activity activity : this.f582c) {
            this.f583d.add(new C0362b(activity.getWindow().getDecorView().getRootView(), this.f581b, this.f584e, activity.getClass().getSimpleName()));
        }
    }

    /* renamed from: c */
    private void m641c() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            m640b();
        } else {
            this.f581b.post(new C0360d(this));
        }
    }

    /* renamed from: a */
    public void m642a(Activity activity) {
        if (!C0458D.m886b()) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                this.f582c.add(activity);
                this.f584e.clear();
                m641c();
                return;
            }
            throw new C0506l("Can't add activity to CodelessMatcher on non-UI thread");
        }
    }

    /* renamed from: b */
    public void m643b(Activity activity) {
        if (!C0458D.m886b()) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                this.f582c.remove(activity);
                this.f583d.clear();
                this.f584e.clear();
                return;
            }
            throw new C0506l("Can't remove activity from CodelessMatcher on non-UI thread");
        }
    }
}
