package com.facebook.p029a;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.C0336G;
import com.facebook.C0506l;
import com.facebook.C0560t;
import com.facebook.internal.C0461G;
import com.facebook.internal.C0475Q;
import com.facebook.internal.C0476S;
import com.facebook.p029a.p032b.C0382h;
import com.facebook.p029a.p032b.C0389m;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;

/* renamed from: com.facebook.a.r */
public class C0422r {
    /* renamed from: a */
    private static final String f709a = "com.facebook.a.r";
    /* renamed from: b */
    private static ScheduledThreadPoolExecutor f710b;
    /* renamed from: c */
    private static C0421a f711c = C0421a.AUTO;
    /* renamed from: d */
    private static Object f712d = new Object();
    /* renamed from: e */
    private static String f713e;
    /* renamed from: f */
    private static boolean f714f;
    /* renamed from: g */
    private static String f715g;
    /* renamed from: h */
    private final String f716h;
    /* renamed from: i */
    private final C0403b f717i;

    /* renamed from: com.facebook.a.r$a */
    public enum C0421a {
        AUTO,
        EXPLICIT_ONLY
    }

    private C0422r(Context context, String str, AccessToken accessToken) {
        this(C0475Q.m993b(context), str, accessToken);
    }

    protected C0422r(String str, String str2, AccessToken accessToken) {
        C0403b c0403b;
        C0476S.m1023c();
        this.f716h = str;
        if (accessToken == null) {
            accessToken = AccessToken.m446c();
        }
        if (AccessToken.m447l() && (str2 == null || str2.equals(accessToken.m449b()))) {
            c0403b = new C0403b(accessToken);
        } else {
            if (str2 == null) {
                str2 = C0475Q.m999c(C0560t.m1252d());
            }
            c0403b = new C0403b(null, str2);
        }
        this.f717i = c0403b;
        C0422r.m803i();
    }

    /* renamed from: a */
    public static String m787a(Context context) {
        if (f713e == null) {
            synchronized (f712d) {
                if (f713e == null) {
                    f713e = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString("anonymousAppDeviceGUID", null);
                    if (f713e == null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("XZ");
                        stringBuilder.append(UUID.randomUUID().toString());
                        f713e = stringBuilder.toString();
                        context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putString("anonymousAppDeviceGUID", f713e).apply();
                    }
                }
            }
        }
        return f713e;
    }

    /* renamed from: a */
    static void m788a() {
        if (C0422r.m798d() != C0421a.EXPLICIT_ONLY) {
            C0416n.m775a(C0423s.EAGER_FLUSHING_EVENT);
        }
    }

    /* renamed from: a */
    public static void m789a(Application application, String str) {
        if (C0560t.m1264p()) {
            C0405d.m752c();
            C0431z.m823c();
            if (str == null) {
                str = C0560t.m1253e();
            }
            C0560t.m1249b(application, str);
            C0382h.m666a(application, str);
            return;
        }
        throw new C0506l("The Facebook sdk must be initialized before calling activateApp");
    }

    /* renamed from: a */
    public static void m790a(Context context, String str) {
        if (C0560t.m1254f()) {
            f710b.execute(new C0419p(new C0422r(context, str, null)));
        }
    }

    /* renamed from: a */
    private static void m791a(C0409f c0409f, C0403b c0403b) {
        C0416n.m774a(c0403b, c0409f);
        if (!c0409f.m758a() && !f714f) {
            if (c0409f.m760c().equals("fb_mobile_activate_app")) {
                f714f = true;
            } else {
                C0461G.m891a(C0336G.APP_EVENTS, "AppEvents", "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity's onResume() methodbefore logging other app events.");
            }
        }
    }

    /* renamed from: a */
    private static void m792a(String str) {
        C0461G.m891a(C0336G.DEVELOPER_ERRORS, "AppEvents", str);
    }

    /* renamed from: a */
    private void m793a(String str, Double d, Bundle bundle, boolean z, UUID uuid) {
        String str2 = "AppEvents";
        try {
            C0422r.m791a(new C0409f(this.f716h, str, d, bundle, z, uuid), r1.f717i);
        } catch (JSONException e) {
            C0461G.m892a(C0336G.APP_EVENTS, str2, "JSON encoding for app event failed: '%s'", e.toString());
        } catch (C0506l e2) {
            C0461G.m892a(C0336G.APP_EVENTS, str2, "Invalid app event: %s", e2.toString());
        }
    }

    /* renamed from: a */
    private void m794a(BigDecimal bigDecimal, Currency currency, Bundle bundle, boolean z) {
        if (bigDecimal == null) {
            C0422r.m792a("purchaseAmount cannot be null");
        } else if (currency == null) {
            C0422r.m792a("currency cannot be null");
        } else {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Bundle bundle2 = bundle;
            bundle2.putString("fb_currency", currency.getCurrencyCode());
            m793a("fb_mobile_purchase", Double.valueOf(bigDecimal.doubleValue()), bundle2, z, C0382h.m683l());
            C0422r.m788a();
        }
    }

    /* renamed from: b */
    public static C0422r m795b(Context context) {
        return new C0422r(context, null, null);
    }

    /* renamed from: b */
    public static C0422r m796b(Context context, String str) {
        return new C0422r(context, str, null);
    }

    /* renamed from: c */
    static Executor m797c() {
        if (f710b == null) {
            C0422r.m803i();
        }
        return f710b;
    }

    /* renamed from: d */
    public static C0421a m798d() {
        C0421a c0421a;
        synchronized (f712d) {
            c0421a = f711c;
        }
        return c0421a;
    }

    /* renamed from: e */
    static String m799e() {
        String str;
        synchronized (f712d) {
            str = f715g;
        }
        return str;
    }

    /* renamed from: f */
    public static String m800f() {
        return C0431z.m822b();
    }

    /* renamed from: g */
    public static String m801g() {
        return C0405d.m751b();
    }

    /* renamed from: h */
    public static void m802h() {
        C0416n.m782f();
    }

    /* renamed from: i */
    private static void m803i() {
        synchronized (f712d) {
            if (f710b != null) {
                return;
            }
            f710b = new ScheduledThreadPoolExecutor(1);
            f710b.scheduleAtFixedRate(new C0420q(), 0, 86400, TimeUnit.SECONDS);
        }
    }

    /* renamed from: a */
    public void m804a(String str, double d, Bundle bundle) {
        m793a(str, Double.valueOf(d), bundle, false, C0382h.m683l());
    }

    /* renamed from: a */
    public void m805a(String str, Bundle bundle) {
        m793a(str, null, bundle, false, C0382h.m683l());
    }

    /* renamed from: a */
    public void m806a(String str, Double d, Bundle bundle) {
        m793a(str, d, bundle, true, C0382h.m683l());
    }

    /* renamed from: a */
    protected void mo951a(String str, BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        m793a(str, Double.valueOf(bigDecimal.doubleValue()), bundle, true, C0382h.m683l());
    }

    /* renamed from: a */
    public void m808a(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        if (C0389m.m697a()) {
            Log.w(f709a, "You are logging purchase events while auto-logging of in-app purchase is enabled in the SDK. Make sure you don't log duplicate events");
        }
        m794a(bigDecimal, currency, bundle, false);
    }

    /* renamed from: b */
    public void m809b() {
        C0416n.m775a(C0423s.EXPLICIT);
    }

    /* renamed from: b */
    protected void mo952b(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        m794a(bigDecimal, currency, bundle, true);
    }
}
