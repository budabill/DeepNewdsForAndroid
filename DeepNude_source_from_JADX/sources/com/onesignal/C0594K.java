package com.onesignal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat;
import com.onesignal.sa.C0650i;

/* renamed from: com.onesignal.K */
class C0594K {
    /* renamed from: a */
    static final String[] f1145a = new String[]{"android_notification_id", "full_data", "created_time"};
    /* renamed from: b */
    public static boolean f1146b;

    /* renamed from: a */
    private static Intent m1383a(Intent intent, Cursor cursor) {
        int i = cursor.getInt(cursor.getColumnIndex("android_notification_id"));
        String string = cursor.getString(cursor.getColumnIndex("full_data"));
        intent.putExtra("json_payload", string).putExtra("android_notif_id", i).putExtra("restoring", true).putExtra("timestamp", Long.valueOf(cursor.getLong(cursor.getColumnIndex("created_time"))));
        return intent;
    }

    /* renamed from: a */
    static void m1384a(Context context) {
        new Thread(new C0593J(context), "OS_RESTORE_NOTIFS").start();
    }

    /* renamed from: a */
    static void m1385a(Context context, Cursor cursor, int i) {
        if (cursor.moveToFirst()) {
            Object obj = C0872F.m2228a(context) != null ? 1 : null;
            do {
                Intent a;
                ComponentName component;
                int i2;
                if (obj != null) {
                    a = C0872F.m2228a(context);
                    C0594K.m1383a(a, cursor);
                    component = a.getComponent();
                    i2 = 2071862121;
                } else {
                    a = new Intent();
                    C0594K.m1383a(a, cursor);
                    component = new ComponentName(context, RestoreJobService.class);
                    i2 = 2071862122;
                }
                JobIntentService.m1376a(context, component, i2, a);
                if (i > 0) {
                    aa.m1445a(i);
                }
            } while (cursor.moveToNext());
        }
    }

    /* renamed from: a */
    private static void m1386a(android.content.Context r4, java.lang.StringBuilder r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 23;
        if (r0 >= r1) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = "notification";
        r4 = r4.getSystemService(r0);
        r4 = (android.app.NotificationManager) r4;
        if (r4 != 0) goto L_0x0012;
    L_0x0011:
        return;
    L_0x0012:
        r4 = r4.getActiveNotifications();	 Catch:{ Throwable -> 0x0046 }
        r0 = r4.length;	 Catch:{ Throwable -> 0x0046 }
        if (r0 != 0) goto L_0x001a;	 Catch:{ Throwable -> 0x0046 }
    L_0x0019:
        return;	 Catch:{ Throwable -> 0x0046 }
    L_0x001a:
        r0 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x0046 }
        r0.<init>();	 Catch:{ Throwable -> 0x0046 }
        r1 = r4.length;	 Catch:{ Throwable -> 0x0046 }
        r2 = 0;	 Catch:{ Throwable -> 0x0046 }
    L_0x0021:
        if (r2 >= r1) goto L_0x0033;	 Catch:{ Throwable -> 0x0046 }
    L_0x0023:
        r3 = r4[r2];	 Catch:{ Throwable -> 0x0046 }
        r3 = r3.getId();	 Catch:{ Throwable -> 0x0046 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Throwable -> 0x0046 }
        r0.add(r3);	 Catch:{ Throwable -> 0x0046 }
        r2 = r2 + 1;	 Catch:{ Throwable -> 0x0046 }
        goto L_0x0021;	 Catch:{ Throwable -> 0x0046 }
    L_0x0033:
        r4 = " AND android_notification_id NOT IN (";	 Catch:{ Throwable -> 0x0046 }
        r5.append(r4);	 Catch:{ Throwable -> 0x0046 }
        r4 = ",";	 Catch:{ Throwable -> 0x0046 }
        r4 = android.text.TextUtils.join(r4, r0);	 Catch:{ Throwable -> 0x0046 }
        r5.append(r4);	 Catch:{ Throwable -> 0x0046 }
        r4 = ")";	 Catch:{ Throwable -> 0x0046 }
        r5.append(r4);	 Catch:{ Throwable -> 0x0046 }
    L_0x0046:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.K.a(android.content.Context, java.lang.StringBuilder):void");
    }

    /* renamed from: b */
    public static void m1387b(Context context) {
        SQLiteDatabase b;
        Throwable th;
        long currentTimeMillis;
        StringBuilder stringBuilder;
        String str;
        StringBuilder stringBuilder2;
        C0650i c0650i;
        StringBuilder stringBuilder3;
        Throwable th2;
        String str2 = "Error closing transaction! ";
        if (!f1146b) {
            f1146b = true;
            sa.m1656a(C0650i.INFO, "restoring notifications");
            va a = va.m1748a(context);
            Cursor cursor = null;
            try {
                b = a.m1751b();
                try {
                    b.beginTransaction();
                    C0585D.m1295a(b);
                    b.setTransactionSuccessful();
                    if (b != null) {
                        try {
                            b.endTransaction();
                        } catch (Throwable th3) {
                            sa.m1657a(C0650i.ERROR, str2, th3);
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        sa.m1657a(C0650i.ERROR, "Error deleting old notification records! ", th);
                        if (b != null) {
                            b.endTransaction();
                        }
                        currentTimeMillis = (System.currentTimeMillis() / 1000) - 604800;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("created_time > ");
                        stringBuilder.append(currentTimeMillis);
                        stringBuilder.append(" AND ");
                        stringBuilder.append("dismissed");
                        str = " = 0 AND ";
                        stringBuilder.append(str);
                        stringBuilder.append("opened");
                        stringBuilder.append(str);
                        stringBuilder.append("is_summary");
                        stringBuilder.append(" = 0");
                        stringBuilder2 = new StringBuilder(stringBuilder.toString());
                        C0594K.m1386a(context, stringBuilder2);
                        c0650i = C0650i.INFO;
                        stringBuilder3 = new StringBuilder();
                        stringBuilder3.append("Querying DB for notfs to restore: ");
                        stringBuilder3.append(stringBuilder2.toString());
                        sa.m1656a(c0650i, stringBuilder3.toString());
                        cursor = a.m1750a().query("notification", f1145a, stringBuilder2.toString(), null, null, null, "_id ASC");
                        C0594K.m1385a(context, cursor, 100);
                    } catch (Throwable th5) {
                        th2 = th5;
                        if (b != null) {
                            try {
                                b.endTransaction();
                            } catch (Throwable th6) {
                                sa.m1657a(C0650i.ERROR, str2, th6);
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th7) {
                th2 = th7;
                b = null;
                if (b != null) {
                    b.endTransaction();
                }
                throw th2;
            }
            currentTimeMillis = (System.currentTimeMillis() / 1000) - 604800;
            stringBuilder = new StringBuilder();
            stringBuilder.append("created_time > ");
            stringBuilder.append(currentTimeMillis);
            stringBuilder.append(" AND ");
            stringBuilder.append("dismissed");
            str = " = 0 AND ";
            stringBuilder.append(str);
            stringBuilder.append("opened");
            stringBuilder.append(str);
            stringBuilder.append("is_summary");
            stringBuilder.append(" = 0");
            stringBuilder2 = new StringBuilder(stringBuilder.toString());
            C0594K.m1386a(context, stringBuilder2);
            c0650i = C0650i.INFO;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Querying DB for notfs to restore: ");
            stringBuilder3.append(stringBuilder2.toString());
            sa.m1656a(c0650i, stringBuilder3.toString());
            try {
                cursor = a.m1750a().query("notification", f1145a, stringBuilder2.toString(), null, null, null, "_id ASC");
                C0594K.m1385a(context, cursor, 100);
                if (!(cursor == null || cursor.isClosed())) {
                }
            } catch (Throwable th22) {
                sa.m1657a(C0650i.ERROR, "Error restoring notification records! ", th22);
            } finally {
                if (!(cursor == null || cursor.isClosed())) {
                    cursor.close();
                }
            }
        }
    }

    /* renamed from: c */
    static void m1388c(Context context) {
        if (VERSION.SDK_INT >= 26) {
            sa.m1656a(C0650i.INFO, "scheduleRestoreKickoffJob");
            ((JobScheduler) context.getSystemService("jobscheduler")).schedule(new Builder(2071862120, new ComponentName(context, RestoreKickoffJobService.class)).setOverrideDeadline(15000).setMinimumLatency(15000).build());
            return;
        }
        sa.m1656a(C0650i.INFO, "scheduleRestoreKickoffAlarmTask");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context.getPackageName(), NotificationRestoreService.class.getName()));
        long currentTimeMillis = System.currentTimeMillis() + 15000;
        ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(1, currentTimeMillis, PendingIntent.getService(context, 2071862120, intent, 268435456));
    }
}
