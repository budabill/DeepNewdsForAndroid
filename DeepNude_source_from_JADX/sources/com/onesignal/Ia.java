package com.onesignal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.job.JobInfo.Builder;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat;
import com.onesignal.sa.C0650i;
import java.util.concurrent.atomic.AtomicBoolean;

class Ia {
    /* renamed from: a */
    private static Long f1133a = Long.valueOf(0);
    /* renamed from: b */
    private static AtomicBoolean f1134b = new AtomicBoolean();
    /* renamed from: c */
    private static Thread f1135c;

    /* renamed from: com.onesignal.Ia$c */
    static abstract class C0592c implements Runnable {
        C0592c() {
        }

        /* renamed from: a */
        protected abstract void mo1351a();

        public final void run() {
            synchronized (Ia.f1133a) {
                Ia.f1133a = Long.valueOf(0);
            }
            if (sa.m1616A() == null) {
                mo1351a();
                return;
            }
            sa.f1377c = sa.m1741x();
            Ha.m1347f();
            C0582B.m1273a(sa.f1380f, false, new Ja(this));
        }
    }

    /* renamed from: com.onesignal.Ia$a */
    static class C0873a extends C0592c {
        /* renamed from: a */
        Service f1822a;

        C0873a(Service service) {
            this.f1822a = service;
        }

        /* renamed from: a */
        protected void mo1351a() {
            sa.m1656a(C0650i.DEBUG, "LegacySyncRunnable:Stopped");
            this.f1822a.stopSelf();
        }
    }

    /* renamed from: com.onesignal.Ia$b */
    static class C0874b extends C0592c {
        /* renamed from: a */
        private JobService f1823a;
        /* renamed from: b */
        private JobParameters f1824b;

        C0874b(JobService jobService, JobParameters jobParameters) {
            this.f1823a = jobService;
            this.f1824b = jobParameters;
        }

        /* renamed from: a */
        protected void mo1351a() {
            sa.m1656a(C0650i.DEBUG, "LollipopSyncRunnable:JobFinished");
            this.f1823a.jobFinished(this.f1824b, false);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static void m1363a(android.content.Context r3) {
        /*
        r0 = f1133a;
        monitor-enter(r0);
        r1 = 0;
        r1 = java.lang.Long.valueOf(r1);	 Catch:{ all -> 0x0039 }
        f1133a = r1;	 Catch:{ all -> 0x0039 }
        r1 = com.onesignal.C0582B.m1275a(r3);	 Catch:{ all -> 0x0039 }
        if (r1 == 0) goto L_0x0013;
    L_0x0011:
        monitor-exit(r0);	 Catch:{ all -> 0x0039 }
        return;
    L_0x0013:
        r1 = m1374e();	 Catch:{ all -> 0x0039 }
        if (r1 == 0) goto L_0x0028;
    L_0x0019:
        r1 = "jobscheduler";
        r3 = r3.getSystemService(r1);	 Catch:{ all -> 0x0039 }
        r3 = (android.app.job.JobScheduler) r3;	 Catch:{ all -> 0x0039 }
        r1 = 2071862118; // 0x7b7e1b66 float:1.3193991E36 double:1.0236358954E-314;
        r3.cancel(r1);	 Catch:{ all -> 0x0039 }
        goto L_0x0037;
    L_0x0028:
        r1 = "alarm";
        r1 = r3.getSystemService(r1);	 Catch:{ all -> 0x0039 }
        r1 = (android.app.AlarmManager) r1;	 Catch:{ all -> 0x0039 }
        r3 = m1369c(r3);	 Catch:{ all -> 0x0039 }
        r1.cancel(r3);	 Catch:{ all -> 0x0039 }
    L_0x0037:
        monitor-exit(r0);	 Catch:{ all -> 0x0039 }
        return;
    L_0x0039:
        r3 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0039 }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.Ia.a(android.content.Context):void");
    }

    /* renamed from: a */
    static void m1364a(Context context, long j) {
        C0650i c0650i = C0650i.VERBOSE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("scheduleLocationUpdateTask:delayMs: ");
        stringBuilder.append(j);
        sa.m1656a(c0650i, stringBuilder.toString());
        m1373d(context, j);
    }

    /* renamed from: a */
    static void m1365a(Context context, C0592c c0592c) {
        sa.m1704f(context);
        f1135c = new Thread(c0592c, "OS_SYNCSRV_BG_SYNC");
        f1135c.start();
    }

    /* renamed from: b */
    static void m1366b(Context context) {
        sa.m1656a(C0650i.VERBOSE, "scheduleSyncTask:SYNC_AFTER_BG_DELAY_MS: 120000");
        m1373d(context, 120000);
    }

    /* renamed from: b */
    private static void m1367b(Context context, long j) {
        C0650i c0650i = C0650i.VERBOSE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("scheduleServiceSyncTask:atTime: ");
        stringBuilder.append(j);
        sa.m1656a(c0650i, stringBuilder.toString());
        ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(0, (System.currentTimeMillis() + j) + j, m1369c(context));
    }

    /* renamed from: b */
    static boolean m1368b() {
        Thread thread = f1135c;
        if (thread == null || !thread.isAlive()) {
            return false;
        }
        f1135c.interrupt();
        return true;
    }

    /* renamed from: c */
    private static PendingIntent m1369c(Context context) {
        return PendingIntent.getService(context, 2071862118, new Intent(context, SyncService.class), 134217728);
    }

    /* renamed from: c */
    static void m1370c() {
        if (!f1134b.get()) {
            synchronized (f1134b) {
                f1134b.set(true);
                m1372d();
                f1134b.set(false);
            }
        }
    }

    /* renamed from: c */
    private static void m1371c(Context context, long j) {
        C0650i c0650i = C0650i.VERBOSE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("scheduleSyncServiceAsJob:atTime: ");
        stringBuilder.append(j);
        sa.m1656a(c0650i, stringBuilder.toString());
        try {
            int schedule = ((JobScheduler) context.getSystemService("jobscheduler")).schedule(new Builder(2071862118, new ComponentName(context, SyncJobService.class)).setMinimumLatency(j).setRequiredNetworkType(1).setPersisted(true).build());
            C0650i c0650i2 = C0650i.INFO;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("scheduleSyncServiceAsJob:result: ");
            stringBuilder2.append(schedule);
            sa.m1656a(c0650i2, stringBuilder2.toString());
        } catch (Throwable e) {
            sa.m1657a(C0650i.ERROR, "scheduleSyncServiceAsJob called JobScheduler.jobScheduler which triggered an internal null Android error. Skipping job.", e);
        }
    }

    /* renamed from: d */
    private static void m1372d() {
        long a = sa.m1641a();
        if (a >= 60) {
            sa.m1648a(a, true);
        }
    }

    /* renamed from: d */
    private static void m1373d(Context context, long j) {
        synchronized (f1133a) {
            if (f1133a.longValue() == 0 || System.currentTimeMillis() + j <= f1133a.longValue()) {
                if (j < 5000) {
                    j = 5000;
                }
                if (m1374e()) {
                    m1371c(context, j);
                } else {
                    m1367b(context, j);
                }
                f1133a = Long.valueOf(System.currentTimeMillis() + j);
                return;
            }
        }
    }

    /* renamed from: e */
    private static boolean m1374e() {
        return VERSION.SDK_INT >= 21;
    }
}
