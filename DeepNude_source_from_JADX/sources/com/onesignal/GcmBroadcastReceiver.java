package com.onesignal;

import android.annotation.TargetApi;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.onesignal.C0585D.C0584a;
import java.util.Random;

public class GcmBroadcastReceiver extends WakefulBroadcastReceiver {
    /* renamed from: a */
    private static C0584a m2229a(Context context, Intent intent, Bundle bundle) {
        if (!m2234a(intent)) {
            return null;
        }
        C0584a a = C0585D.m1290a(context, bundle);
        if (a.m1288a()) {
            return a;
        }
        m2233a(context, bundle);
        return a;
    }

    /* renamed from: a */
    private static C0632k m2230a(Bundle bundle, C0632k c0632k) {
        c0632k.putString("json_payload", C0585D.m1303b(bundle).toString());
        c0632k.mo1385a("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
        return c0632k;
    }

    /* renamed from: a */
    private void m2231a() {
        if (isOrderedBroadcast()) {
            abortBroadcast();
        }
    }

    /* renamed from: a */
    private void m2232a(int i) {
        if (isOrderedBroadcast()) {
            setResultCode(i);
        }
    }

    /* renamed from: a */
    private static void m2233a(Context context, Bundle bundle) {
        if (C0585D.m1305c(bundle)) {
            if ((Integer.parseInt(bundle.getString("pri", "0")) > 9 ? 1 : null) != null || VERSION.SDK_INT < 26) {
                try {
                    m2236c(context, bundle);
                } catch (IllegalStateException e) {
                    if (VERSION.SDK_INT < 21) {
                        throw e;
                    }
                }
                return;
            }
            m2235b(context, bundle);
            return;
        }
        C0632k a = C0633m.m1529a();
        m2230a(bundle, a);
        C0585D.m1294a(context, a, null);
    }

    /* renamed from: a */
    private static boolean m2234a(Intent intent) {
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            return false;
        }
        String stringExtra = intent.getStringExtra("message_type");
        return stringExtra == null || GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE.equals(stringExtra);
    }

    @TargetApi(21)
    /* renamed from: b */
    private static void m2235b(Context context, Bundle bundle) {
        C0632k a = C0633m.m1529a();
        m2230a(bundle, a);
        ((JobScheduler) context.getSystemService("jobscheduler")).schedule(new Builder(new Random().nextInt(), new ComponentName(context.getPackageName(), GcmIntentJobService.class.getName())).setOverrideDeadline(0).setExtras((PersistableBundle) a.mo1384a()).build());
    }

    /* renamed from: c */
    private static void m2236c(Context context, Bundle bundle) {
        ComponentName componentName = new ComponentName(context.getPackageName(), GcmIntentService.class.getName());
        C0632k c0876l = new C0876l();
        m2230a(bundle, c0876l);
        WakefulBroadcastReceiver.startWakefulService(context, new Intent().replaceExtras((Bundle) c0876l.mo1384a()).setComponent(componentName));
    }

    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            if (!"google.com/iid".equals(extras.getString("from"))) {
                C0584a a = m2229a(context, intent, extras);
                if (a == null) {
                    m2232a(-1);
                    return;
                }
                if (!a.f1104c) {
                    if (!a.f1103b) {
                        if (a.f1102a && sa.m1680b(context)) {
                            m2231a();
                            return;
                        } else {
                            m2232a(-1);
                            return;
                        }
                    }
                }
                m2231a();
            }
        }
    }
}
