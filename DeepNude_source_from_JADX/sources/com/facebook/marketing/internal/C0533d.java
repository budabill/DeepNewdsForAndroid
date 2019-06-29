package com.facebook.marketing.internal;

import android.util.Log;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import com.facebook.C0560t;
import com.facebook.p029a.p030a.C0359c.C0358a;
import com.facebook.p029a.p030a.p031a.C0355f;

/* renamed from: com.facebook.marketing.internal.d */
public class C0533d {
    /* renamed from: a */
    private static final String f1030a = "com.facebook.marketing.internal.d";

    /* renamed from: com.facebook.marketing.internal.d$a */
    public static class C0858a extends C0358a {
        /* renamed from: h */
        private AccessibilityDelegate f1803h;
        /* renamed from: i */
        private String f1804i;

        public C0858a(View view, String str) {
            if (view != null) {
                this.f1803h = C0355f.m612d(view);
                this.f1804i = str;
                this.f570g = true;
            }
        }

        public void sendAccessibilityEvent(View view, int i) {
            if (i == -1) {
                Log.e(C0533d.f1030a, "Unsupported action type");
            }
            AccessibilityDelegate accessibilityDelegate = this.f1803h;
            if (!(accessibilityDelegate == null || (accessibilityDelegate instanceof C0858a))) {
                accessibilityDelegate.sendAccessibilityEvent(view, i);
            }
            C0560t.m1258j().execute(new C0532c(this, view, this.f1804i));
        }
    }

    /* renamed from: a */
    public static C0858a m1207a(View view, String str) {
        return new C0858a(view, str);
    }
}
