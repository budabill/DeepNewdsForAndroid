package com.facebook.internal;

import com.facebook.C0331D;
import com.facebook.C0506l;
import com.facebook.C0857m;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest.C0338b;
import com.facebook.internal.C0485X.C0484d;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* renamed from: com.facebook.internal.Y */
class C0835Y implements C0338b {
    /* renamed from: a */
    final /* synthetic */ String[] f1770a;
    /* renamed from: b */
    final /* synthetic */ int f1771b;
    /* renamed from: c */
    final /* synthetic */ CountDownLatch f1772c;
    /* renamed from: d */
    final /* synthetic */ C0484d f1773d;

    C0835Y(C0484d c0484d, String[] strArr, int i, CountDownLatch countDownLatch) {
        this.f1773d = c0484d;
        this.f1770a = strArr;
        this.f1771b = i;
        this.f1772c = countDownLatch;
    }

    /* renamed from: a */
    public void mo949a(C0331D c0331d) {
        try {
            FacebookRequestError a = c0331d.m486a();
            String str = "Error staging photo.";
            if (a != null) {
                String c = a.m500c();
                if (c == null) {
                    c = str;
                }
                throw new C0857m(c0331d, c);
            }
            JSONObject b = c0331d.m487b();
            if (b != null) {
                String optString = b.optString("uri");
                if (optString != null) {
                    this.f1770a[this.f1771b] = optString;
                    this.f1772c.countDown();
                    return;
                }
                throw new C0506l(str);
            }
            throw new C0506l(str);
        } catch (Exception e) {
            this.f1773d.f864c[this.f1771b] = e;
        }
    }
}
