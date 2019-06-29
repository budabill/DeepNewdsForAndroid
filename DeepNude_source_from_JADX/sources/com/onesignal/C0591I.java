package com.onesignal;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NotificationManagerCompat;
import com.onesignal.sa.C0650i;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.onesignal.I */
class C0591I {
    /* renamed from: a */
    static void m1353a(Context context, Intent intent) {
        if (C0591I.m1356a(intent)) {
            C0591I.m1359c(context, intent);
            C0591I.m1358b(context, intent);
        }
    }

    /* renamed from: a */
    private static void m1354a(Context context, Intent intent, SQLiteDatabase sQLiteDatabase) {
        String[] strArr;
        String str;
        if (intent.getStringExtra("summary") != null) {
            strArr = new String[]{intent.getStringExtra("summary")};
            str = "group_id = ?";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("android_notification_id = ");
            stringBuilder.append(intent.getIntExtra("notificationId", 0));
            str = stringBuilder.toString();
            strArr = null;
        }
        sQLiteDatabase.update("notification", C0591I.m1357b(intent), str, strArr);
        C0631j.m1523a(sQLiteDatabase, context);
    }

    /* renamed from: a */
    private static void m1355a(org.json.JSONArray r10, java.lang.String r11, android.database.sqlite.SQLiteDatabase r12) {
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
        r0 = 1;
        r3 = new java.lang.String[r0];
        r9 = "full_data";
        r1 = 0;
        r3[r1] = r9;
        r5 = new java.lang.String[r0];
        r5[r1] = r11;
        r2 = "notification";
        r4 = "group_id = ? AND dismissed = 0 AND opened = 0 AND is_summary = 0";
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r1 = r12;
        r12 = r1.query(r2, r3, r4, r5, r6, r7, r8);
        r1 = r12.getCount();
        if (r1 <= r0) goto L_0x004e;
    L_0x001e:
        r12.moveToFirst();
    L_0x0021:
        r0 = r12.getColumnIndex(r9);	 Catch:{ Throwable -> 0x0032 }
        r0 = r12.getString(r0);	 Catch:{ Throwable -> 0x0032 }
        r1 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0032 }
        r1.<init>(r0);	 Catch:{ Throwable -> 0x0032 }
        r10.put(r1);	 Catch:{ Throwable -> 0x0032 }
        goto L_0x0048;
    L_0x0032:
        r0 = com.onesignal.sa.C0650i.ERROR;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Could not parse JSON of sub notification in group: ";
        r1.append(r2);
        r1.append(r11);
        r1 = r1.toString();
        com.onesignal.sa.m1656a(r0, r1);
    L_0x0048:
        r0 = r12.moveToNext();
        if (r0 != 0) goto L_0x0021;
    L_0x004e:
        r12.close();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.I.a(org.json.JSONArray, java.lang.String, android.database.sqlite.SQLiteDatabase):void");
    }

    /* renamed from: a */
    private static boolean m1356a(Intent intent) {
        if (!(intent.hasExtra("onesignal_data") || intent.hasExtra("summary"))) {
            if (!intent.hasExtra("notificationId")) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private static ContentValues m1357b(Intent intent) {
        ContentValues contentValues = new ContentValues();
        String str = "dismissed";
        boolean booleanExtra = intent.getBooleanExtra(str, false);
        Integer valueOf = Integer.valueOf(1);
        if (booleanExtra) {
            contentValues.put(str, valueOf);
        } else {
            contentValues.put("opened", valueOf);
        }
        return contentValues;
    }

    /* renamed from: b */
    static void m1358b(Context context, Intent intent) {
        JSONArray b;
        String str = "notificationId";
        String str2 = "Error closing transaction! ";
        String str3 = "onesignal_data";
        String stringExtra = intent.getStringExtra("summary");
        boolean booleanExtra = intent.getBooleanExtra("dismissed", false);
        SQLiteDatabase sQLiteDatabase = null;
        if (!booleanExtra) {
            try {
                JSONObject jSONObject = new JSONObject(intent.getStringExtra(str3));
                jSONObject.put(str, intent.getIntExtra(str, 0));
                intent.putExtra(str3, jSONObject.toString());
                b = C0585D.m1302b(new JSONObject(intent.getStringExtra(str3)));
            } catch (Throwable th) {
                th.printStackTrace();
            }
            sQLiteDatabase = va.m1748a(context).m1751b();
            sQLiteDatabase.beginTransaction();
            if (!(booleanExtra || stringExtra == null)) {
                C0591I.m1355a(b, stringExtra, sQLiteDatabase);
            }
            C0591I.m1354a(context, intent, sQLiteDatabase);
            if (stringExtra == null) {
                str3 = intent.getStringExtra("grp");
                if (str3 != null) {
                    C0595L.m1390a(context, sQLiteDatabase, str3, booleanExtra);
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            if (!booleanExtra) {
                sa.m1652a(context, b, intent.getBooleanExtra("from_alert", false));
            }
        }
        b = sQLiteDatabase;
        try {
            sQLiteDatabase = va.m1748a(context).m1751b();
            sQLiteDatabase.beginTransaction();
            C0591I.m1355a(b, stringExtra, sQLiteDatabase);
            C0591I.m1354a(context, intent, sQLiteDatabase);
            if (stringExtra == null) {
                str3 = intent.getStringExtra("grp");
                if (str3 != null) {
                    C0595L.m1390a(context, sQLiteDatabase, str3, booleanExtra);
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        } catch (Throwable e) {
            try {
                sa.m1657a(C0650i.ERROR, "Error processing notification open or dismiss record! ", e);
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
            } catch (Throwable th2) {
                sa.m1657a(C0650i.ERROR, str2, th2);
            }
        } catch (Throwable e2) {
            sa.m1657a(C0650i.ERROR, str2, e2);
        }
        if (!booleanExtra) {
            sa.m1652a(context, b, intent.getBooleanExtra("from_alert", false));
        }
    }

    /* renamed from: c */
    private static void m1359c(Context context, Intent intent) {
        if (intent.getBooleanExtra("action_button", false)) {
            NotificationManagerCompat.from(context).cancel(intent.getIntExtra("notificationId", 0));
            context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        }
    }
}
