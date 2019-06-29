package com.facebook.p029a.p032b;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import com.facebook.C0560t;
import com.facebook.internal.C0457C;
import com.facebook.internal.C0476S;
import com.facebook.internal.C0503y;
import com.facebook.p029a.C0422r;
import java.math.BigDecimal;
import java.util.Currency;
import org.json.JSONObject;

/* renamed from: com.facebook.a.b.m */
public class C0389m {
    /* renamed from: a */
    private static final String f640a = "com.facebook.a.b.m";
    /* renamed from: b */
    private static final C0824u f641b = new C0824u(C0560t.m1252d());

    /* renamed from: com.facebook.a.b.m$a */
    private static class C0388a {
        /* renamed from: a */
        BigDecimal f637a;
        /* renamed from: b */
        Currency f638b;
        /* renamed from: c */
        Bundle f639c;

        C0388a(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
            this.f637a = bigDecimal;
            this.f638b = currency;
            this.f639c = bundle;
        }
    }

    /* renamed from: a */
    public static void m694a(C0402z c0402z, String str, String str2) {
        if (C0389m.m697a()) {
            String str3;
            C0560t.m1253e();
            int i = C0387l.f636a[c0402z.ordinal()];
            if (i == 1) {
                str3 = "SubscriptionRestore";
            } else if (i == 2) {
                str3 = "SubscriptionCancel";
            } else if (i == 3) {
                str3 = "SubscriptionHeartbeat";
            } else if (i != 4) {
                if (i == 5) {
                    C0389m.m696a(str, str2);
                }
                return;
            } else {
                str3 = "SubscriptionExpire";
            }
            C0388a b = C0389m.m698b(str, str2);
            if (b != null) {
                f641b.mo951a(str3, b.f637a, b.f638b, b.f639c);
            }
        }
    }

    /* renamed from: a */
    public static void m695a(String str, long j) {
        Object d = C0560t.m1252d();
        String e = C0560t.m1253e();
        C0476S.m1016a(d, "context");
        C0503y a = C0457C.m871a(e, false);
        if (a != null && a.m1098a() && j > 0) {
            C0422r b = C0422r.m795b(d);
            Bundle bundle = new Bundle(1);
            bundle.putCharSequence("fb_aa_time_spent_view_name", str);
            b.m804a("fb_aa_time_spent_on_view", (double) j, bundle);
        }
    }

    /* renamed from: a */
    public static void m696a(String str, String str2) {
        if (C0389m.m697a()) {
            C0388a b = C0389m.m698b(str, str2);
            if (b != null) {
                f641b.mo952b(b.f637a, b.f638b, b.f639c);
            }
        }
    }

    /* renamed from: a */
    public static boolean m697a() {
        C0503y b = C0457C.m876b(C0560t.m1253e());
        return b != null && C0560t.m1254f() && b.m1104g();
    }

    /* renamed from: b */
    private static C0388a m698b(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject(str2);
            Bundle bundle = new Bundle(1);
            bundle.putCharSequence("fb_iap_product_id", jSONObject.getString("productId"));
            bundle.putCharSequence("fb_iap_purchase_time", jSONObject.getString("purchaseTime"));
            bundle.putCharSequence("fb_iap_purchase_token", jSONObject.getString("purchaseToken"));
            bundle.putCharSequence("fb_iap_package_name", jSONObject.optString("packageName"));
            bundle.putCharSequence("fb_iap_product_title", jSONObject2.optString("title"));
            bundle.putCharSequence("fb_iap_product_description", jSONObject2.optString("description"));
            Object optString = jSONObject2.optString("type");
            bundle.putCharSequence("fb_iap_product_type", optString);
            if (optString.equals("subs")) {
                bundle.putCharSequence("fb_iap_subs_auto_renewing", Boolean.toString(jSONObject.optBoolean("autoRenewing", false)));
                bundle.putCharSequence("fb_iap_subs_period", jSONObject2.optString("subscriptionPeriod"));
                bundle.putCharSequence("fb_free_trial_period", jSONObject2.optString("freeTrialPeriod"));
                CharSequence optString2 = jSONObject2.optString("introductoryPriceCycles");
                if (!optString2.isEmpty()) {
                    bundle.putCharSequence("fb_intro_price_amount_micros", jSONObject2.optString("introductoryPriceAmountMicros"));
                    bundle.putCharSequence("fb_intro_price_cycles", optString2);
                }
            }
            double d = (double) jSONObject2.getLong("price_amount_micros");
            Double.isNaN(d);
            return new C0388a(new BigDecimal(d / 1000000.0d), Currency.getInstance(jSONObject2.getString("price_currency_code")), bundle);
        } catch (Throwable e) {
            Log.e(f640a, "Error parsing in-app subscription data.", e);
            return null;
        }
    }

    /* renamed from: b */
    public static void m699b() {
        Object d = C0560t.m1252d();
        String e = C0560t.m1253e();
        boolean f = C0560t.m1254f();
        C0476S.m1016a(d, "context");
        if (!f) {
            return;
        }
        if (d instanceof Application) {
            C0422r.m789a((Application) d, e);
        } else {
            Log.w(f640a, "Automatic logging of basic events will not happen, because FacebookSdk.getApplicationContext() returns object that is not instance of android.app.Application. Make sure you call FacebookSdk.sdkInitialize() from Application class and pass application context.");
        }
    }
}
