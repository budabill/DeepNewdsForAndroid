package com.onesignal;

import android.content.Context;
import android.net.Uri;
import com.onesignal.C0872F.C0587a;
import java.util.Random;
import org.json.JSONObject;

/* renamed from: com.onesignal.G */
class C0588G {
    /* renamed from: a */
    Context f1119a;
    /* renamed from: b */
    JSONObject f1120b;
    /* renamed from: c */
    boolean f1121c;
    /* renamed from: d */
    boolean f1122d;
    /* renamed from: e */
    Long f1123e;
    /* renamed from: f */
    CharSequence f1124f;
    /* renamed from: g */
    CharSequence f1125g;
    /* renamed from: h */
    Uri f1126h;
    /* renamed from: i */
    Integer f1127i;
    /* renamed from: j */
    Integer f1128j;
    /* renamed from: k */
    Uri f1129k;
    /* renamed from: l */
    C0587a f1130l;

    C0588G(Context context) {
        this.f1119a = context;
    }

    /* renamed from: a */
    Integer m1314a() {
        if (this.f1130l == null) {
            this.f1130l = new C0587a();
        }
        C0587a c0587a = this.f1130l;
        if (c0587a.f1114b == null) {
            c0587a.f1114b = Integer.valueOf(new Random().nextInt());
        }
        return this.f1130l.f1114b;
    }

    /* renamed from: a */
    void m1315a(Integer num) {
        if (num != null) {
            C0587a c0587a = this.f1130l;
            if (c0587a == null || c0587a.f1114b == null) {
                if (this.f1130l == null) {
                    this.f1130l = new C0587a();
                }
                this.f1130l.f1114b = num;
            }
        }
    }

    /* renamed from: b */
    int m1316b() {
        C0587a c0587a = this.f1130l;
        if (c0587a != null) {
            Integer num = c0587a.f1114b;
            if (num != null) {
                return num.intValue();
            }
        }
        return -1;
    }

    /* renamed from: c */
    CharSequence m1317c() {
        CharSequence charSequence = this.f1124f;
        return charSequence != null ? charSequence : this.f1120b.optString("alert", null);
    }

    /* renamed from: d */
    CharSequence m1318d() {
        CharSequence charSequence = this.f1125g;
        return charSequence != null ? charSequence : this.f1120b.optString("title", null);
    }

    /* renamed from: e */
    boolean m1319e() {
        C0587a c0587a = this.f1130l;
        return (c0587a == null || c0587a.f1113a == null) ? false : true;
    }
}
