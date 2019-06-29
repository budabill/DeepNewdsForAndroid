package io.gonative.android;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;
import com.facebook.C0560t;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.onesignal.C0613Y;
import com.onesignal.C0614Z;
import com.onesignal.OSSubscriptionState;
import com.onesignal.sa;
import com.onesignal.sa.C0653l;
import io.gonative.android.p038a.C0700a;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GoNativeApplication extends Application {
    /* renamed from: a */
    private static final String f1445a = "GoNativeApplication";
    /* renamed from: b */
    private C0729u f1446b;
    /* renamed from: c */
    private C0695X f1447c;
    /* renamed from: d */
    private Aa f1448d;
    /* renamed from: e */
    private Message f1449e;
    /* renamed from: f */
    private boolean f1450f = false;
    /* renamed from: g */
    private int f1451g = 0;
    /* renamed from: h */
    private final ScheduledExecutorService f1452h = Executors.newScheduledThreadPool(1);

    /* renamed from: io.gonative.android.GoNativeApplication$1 */
    class C08821 implements C0613Y {
        /* renamed from: a */
        final /* synthetic */ GoNativeApplication f1863a;

        C08821(GoNativeApplication goNativeApplication) {
            this.f1863a = goNativeApplication;
        }

        public void onOSSubscriptionChanged(C0614Z c0614z) {
            OSSubscriptionState a = c0614z.m1434a();
            if (this.f1863a.f1447c != null) {
                this.f1863a.f1447c.m1845a(a.m1407c(), a.m1402a(), Boolean.valueOf(a.m1406b()));
            }
            if (a.m1406b()) {
                this.f1863a.f1450f = true;
            }
            LocalBroadcastManager.getInstance(this.f1863a).sendBroadcast(new Intent("io.gonative.android.onesignal.statuschanged"));
        }
    }

    /* renamed from: a */
    public C0729u m1811a() {
        return this.f1446b;
    }

    /* renamed from: a */
    public void m1812a(Message message) {
        this.f1449e = message;
    }

    /* renamed from: b */
    public C0695X m1813b() {
        return this.f1447c;
    }

    /* renamed from: c */
    public Aa m1814c() {
        return this.f1448d;
    }

    /* renamed from: d */
    public Message m1815d() {
        return this.f1449e;
    }

    public void onCreate() {
        super.onCreate();
        C0700a a = C0700a.m1851a((Context) this);
        if (a.f1533e != null) {
            Toast.makeText(this, "Invalid appConfig json", 1).show();
            Log.e(f1445a, "AppConfig error", a.f1533e);
        }
        if (a.Ka) {
            sa.m1724k(a.Na);
            sa.m1649a((Context) this, "REMOTE", a.La, new C0884P(this));
            sa.m1658a(C0653l.Notification);
        }
        if (a.Wa) {
            C0560t.m1244a(a.Xa);
        }
        this.f1446b = new C0729u(this);
        if (a.fb != null) {
            this.f1447c = new C0695X(this);
            this.f1447c.m1846a(a.fb);
        }
        if (a.Ka) {
            sa.m1654a(new C08821(this));
            this.f1452h.scheduleAtFixedRate(new C0717h(this), 2, 2, TimeUnit.SECONDS);
        }
        Ca.m1802a((Context) this);
        this.f1448d = new Aa();
        Iconify.with(new FontAwesomeModule());
    }
}
