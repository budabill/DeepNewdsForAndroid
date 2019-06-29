package com.facebook.p029a.p030a;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import com.facebook.C0506l;
import com.facebook.C0560t;
import com.facebook.p029a.p030a.p031a.C0349a;
import com.facebook.p029a.p030a.p031a.C0355f;
import com.facebook.p029a.p032b.C0383i;
import java.lang.ref.WeakReference;

/* renamed from: com.facebook.a.a.c */
public class C0359c {
    /* renamed from: a */
    private static final String f571a = "com.facebook.a.a.c";

    /* renamed from: com.facebook.a.a.c$a */
    public static class C0358a extends AccessibilityDelegate {
        /* renamed from: a */
        private C0349a f564a;
        /* renamed from: b */
        private WeakReference<View> f565b;
        /* renamed from: c */
        private WeakReference<View> f566c;
        /* renamed from: d */
        private int f567d;
        /* renamed from: e */
        private AccessibilityDelegate f568e;
        /* renamed from: f */
        private boolean f569f = false;
        /* renamed from: g */
        protected boolean f570g = false;

        public C0358a(C0349a c0349a, View view, View view2) {
            if (c0349a != null && view != null) {
                if (view2 != null) {
                    this.f568e = C0355f.m612d(view2);
                    this.f564a = c0349a;
                    this.f565b = new WeakReference(view2);
                    this.f566c = new WeakReference(view);
                    Enum c = c0349a.m590c();
                    int i = C0356a.f560a[c0349a.m590c().ordinal()];
                    if (i != 1) {
                        if (i == 2) {
                            i = 4;
                        } else if (i == 3) {
                            i = 16;
                        } else {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Unsupported action type: ");
                            stringBuilder.append(c.toString());
                            throw new C0506l(stringBuilder.toString());
                        }
                        this.f567d = i;
                    } else {
                        this.f567d = 1;
                    }
                    this.f569f = true;
                }
            }
        }

        /* renamed from: c */
        private void m623c() {
            String b = this.f564a.m589b();
            Bundle a = C0363e.m637a(this.f564a, (View) this.f566c.get(), (View) this.f565b.get());
            String str = "_valueToSum";
            if (a.containsKey(str)) {
                a.putDouble(str, C0383i.m687a(a.getString(str)));
            }
            a.putString("_is_fb_codeless", "1");
            C0560t.m1258j().execute(new C0357b(this, b, a));
        }

        /* renamed from: a */
        public boolean m624a() {
            return this.f570g;
        }

        /* renamed from: b */
        public boolean m625b() {
            return this.f569f;
        }

        public void sendAccessibilityEvent(View view, int i) {
            if (i == -1) {
                Log.e(C0359c.f571a, "Unsupported action type");
            }
            if (i == this.f567d) {
                AccessibilityDelegate accessibilityDelegate = this.f568e;
                if (!(accessibilityDelegate == null || (accessibilityDelegate instanceof C0358a))) {
                    accessibilityDelegate.sendAccessibilityEvent(view, i);
                }
                m623c();
            }
        }
    }

    /* renamed from: a */
    public static C0358a m626a(C0349a c0349a, View view, View view2) {
        return new C0358a(c0349a, view, view2);
    }
}
