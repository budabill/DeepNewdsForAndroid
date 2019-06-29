package com.facebook.p029a.p030a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.facebook.AccessToken;
import com.facebook.C0560t;
import com.facebook.GraphRequest;
import com.facebook.p029a.p032b.C0382h;
import com.facebook.p029a.p032b.C0383i;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.Timer;
import java.util.concurrent.Callable;

/* renamed from: com.facebook.a.a.l */
public class C0371l {
    /* renamed from: a */
    private static final String f601a = "com.facebook.a.a.l";
    /* renamed from: b */
    private static C0371l f602b;
    /* renamed from: c */
    private final Handler f603c = new Handler(Looper.getMainLooper());
    /* renamed from: d */
    private WeakReference<Activity> f604d;
    /* renamed from: e */
    private Timer f605e;
    /* renamed from: f */
    private String f606f = null;

    /* renamed from: com.facebook.a.a.l$a */
    private static class C0370a implements Callable<String> {
        /* renamed from: a */
        private WeakReference<View> f600a;

        public C0370a(View view) {
            this.f600a = new WeakReference(view);
        }

        public String call() {
            View view = (View) this.f600a.get();
            if (!(view == null || view.getWidth() == 0)) {
                if (view.getHeight() != 0) {
                    Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.RGB_565);
                    view.draw(new Canvas(createBitmap));
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    createBitmap.compress(CompressFormat.JPEG, 10, byteArrayOutputStream);
                    return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                }
            }
            return "";
        }
    }

    public C0371l(Activity activity) {
        this.f604d = new WeakReference(activity);
        f602b = this;
    }

    /* renamed from: a */
    public static GraphRequest m648a(String str, AccessToken accessToken, String str2, String str3) {
        if (str == null) {
            return null;
        }
        GraphRequest a = GraphRequest.m513a(accessToken, String.format(Locale.US, "%s/app_indexing", new Object[]{str2}), null, null);
        Bundle i = a.m563i();
        if (i == null) {
            i = new Bundle();
        }
        i.putString("tree", str);
        i.putString("app_version", C0383i.m691c());
        i.putString("platform", "android");
        i.putString("request_type", str3);
        if (str3.equals("app_indexing")) {
            i.putString("device_session_id", C0382h.m682k());
        }
        a.m550a(i);
        a.m552a(new C0822k());
        return a;
    }

    /* renamed from: a */
    private void m653a(String str, String str2) {
        C0560t.m1258j().execute(new C0369j(this, str));
    }

    /* renamed from: b */
    public void m656b() {
        Activity activity = (Activity) this.f604d.get();
        if (activity != null) {
            String simpleName = activity.getClass().getSimpleName();
            C0560t.m1253e();
            C0560t.m1258j().execute(new C0368i(this, new C0367h(this, activity, simpleName)));
        }
    }

    /* renamed from: c */
    public void m657c() {
        if (((Activity) this.f604d.get()) != null) {
            Timer timer = this.f605e;
            if (timer != null) {
                try {
                    timer.cancel();
                    this.f605e = null;
                } catch (Throwable e) {
                    Log.e(f601a, "Error unscheduling indexing job", e);
                }
            }
        }
    }
}
