package com.facebook.p029a.p030a;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.C0560t;
import com.facebook.p029a.p030a.p031a.C0349a;
import com.facebook.p029a.p030a.p031a.C0355f;
import com.facebook.p029a.p032b.C0383i;
import java.lang.ref.WeakReference;

/* renamed from: com.facebook.a.a.g */
public class C0366g {

    /* renamed from: com.facebook.a.a.g$a */
    public static class C0365a implements OnTouchListener {
        /* renamed from: a */
        private C0349a f588a;
        /* renamed from: b */
        private WeakReference<View> f589b;
        /* renamed from: c */
        private WeakReference<View> f590c;
        /* renamed from: d */
        private OnTouchListener f591d;
        /* renamed from: e */
        private boolean f592e = false;

        public C0365a(C0349a c0349a, View view, View view2) {
            if (c0349a != null && view != null) {
                if (view2 != null) {
                    this.f591d = C0355f.m613e(view2);
                    this.f588a = c0349a;
                    this.f589b = new WeakReference(view2);
                    this.f590c = new WeakReference(view);
                    this.f592e = true;
                }
            }
        }

        /* renamed from: b */
        private void m644b() {
            C0349a c0349a = this.f588a;
            if (c0349a != null) {
                String b = c0349a.m589b();
                Bundle a = C0363e.m637a(this.f588a, (View) this.f590c.get(), (View) this.f589b.get());
                String str = "_valueToSum";
                if (a.containsKey(str)) {
                    a.putDouble(str, C0383i.m687a(a.getString(str)));
                }
                a.putString("_is_fb_codeless", "1");
                C0560t.m1258j().execute(new C0364f(this, b, a));
            }
        }

        /* renamed from: a */
        public boolean m645a() {
            return this.f592e;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                m644b();
            }
            OnTouchListener onTouchListener = this.f591d;
            return onTouchListener != null && onTouchListener.onTouch(view, motionEvent);
        }
    }

    /* renamed from: a */
    public static C0365a m646a(C0349a c0349a, View view, View view2) {
        return new C0365a(c0349a, view, view2);
    }
}
