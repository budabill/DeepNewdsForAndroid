package com.onesignal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.onesignal.sa.C0650i;

/* renamed from: com.onesignal.L */
class C0595L {
    /* renamed from: a */
    private static Integer m1389a(SQLiteDatabase sQLiteDatabase, String str) {
        Integer num;
        Throwable th;
        C0650i c0650i;
        StringBuilder stringBuilder;
        Throwable th2;
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            Cursor query = sQLiteDatabase2.query("notification", new String[]{"android_notification_id"}, "group_id = ? AND dismissed = 0 AND opened = 0 AND is_summary = 1", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    cursor = Integer.valueOf(query.getInt(query.getColumnIndex(r0)));
                    query.close();
                    if (!(query == null || query.isClosed())) {
                        query.close();
                    }
                    num = cursor;
                    return num;
                }
                query.close();
                if (!(query == null || query.isClosed())) {
                    query.close();
                }
                return null;
            } catch (Throwable th3) {
                th2 = th3;
                cursor = query;
                if (!(cursor == null || cursor.isClosed())) {
                    cursor.close();
                }
                throw th2;
            }
        } catch (Throwable th4) {
            th = th4;
            num = null;
            c0650i = C0650i.ERROR;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Error getting android notification id for summary notification group: ");
            stringBuilder.append(str);
            sa.m1657a(c0650i, stringBuilder.toString(), th);
            cursor.close();
            return num;
        }
    }

    /* renamed from: a */
    static void m1390a(Context context, SQLiteDatabase sQLiteDatabase, String str, boolean z) {
        try {
            Cursor b = C0595L.m1392b(context, sQLiteDatabase, str, z);
            if (b != null && !b.isClosed()) {
                b.close();
            }
        } catch (Throwable th) {
            sa.m1657a(C0650i.ERROR, "Error running updateSummaryNotificationAfterChildRemoved!", th);
        }
    }

    /* renamed from: a */
    private static void m1391a(Context context, String str) {
        String[] strArr = new String[]{str};
        Cursor cursor = null;
        try {
            cursor = va.m1748a(context).m1750a().query("notification", C0594K.f1145a, "group_id = ? AND dismissed = 0 AND opened = 0 AND is_summary = 0", strArr, null, null, null);
            C0594K.m1385a(context, cursor, 0);
            if (cursor == null || cursor.isClosed()) {
            }
        } catch (Throwable th) {
            sa.m1657a(C0650i.ERROR, "Error restoring notification records! ", th);
        } finally {
            if (!(cursor == null || cursor.isClosed())) {
                cursor.close();
            }
        }
    }

    /* renamed from: b */
    private static android.database.Cursor m1392b(android.content.Context r11, android.database.sqlite.SQLiteDatabase r12, java.lang.String r13, boolean r14) {
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
        r0 = 2;
        r3 = new java.lang.String[r0];
        r0 = 0;
        r1 = "android_notification_id";
        r3[r0] = r1;
        r9 = "created_time";
        r10 = 1;
        r3[r10] = r9;
        r5 = new java.lang.String[r10];
        r5[r0] = r13;
        r2 = "notification";
        r4 = "group_id = ? AND dismissed = 0 AND opened = 0 AND is_summary = 0";
        r6 = 0;
        r7 = 0;
        r8 = "_id DESC";
        r1 = r12;
        r0 = r1.query(r2, r3, r4, r5, r6, r7, r8);
        r1 = r0.getCount();
        if (r1 != 0) goto L_0x0066;
    L_0x0024:
        r0.close();
        r13 = com.onesignal.C0595L.m1389a(r12, r13);
        if (r13 != 0) goto L_0x002e;
    L_0x002d:
        return r0;
    L_0x002e:
        r1 = "notification";
        r11 = r11.getSystemService(r1);
        r11 = (android.app.NotificationManager) r11;
        r2 = r13.intValue();
        r11.cancel(r2);
        r11 = new android.content.ContentValues;
        r11.<init>();
        if (r14 == 0) goto L_0x0047;
    L_0x0044:
        r14 = "dismissed";
        goto L_0x0049;
    L_0x0047:
        r14 = "opened";
    L_0x0049:
        r2 = java.lang.Integer.valueOf(r10);
        r11.put(r14, r2);
        r14 = new java.lang.StringBuilder;
        r14.<init>();
        r2 = "android_notification_id = ";
        r14.append(r2);
        r14.append(r13);
        r13 = r14.toString();
        r14 = 0;
        r12.update(r1, r11, r13, r14);
        return r0;
    L_0x0066:
        if (r1 != r10) goto L_0x0076;
    L_0x0068:
        r0.close();
        r12 = com.onesignal.C0595L.m1389a(r12, r13);
        if (r12 != 0) goto L_0x0072;
    L_0x0071:
        return r0;
    L_0x0072:
        com.onesignal.C0595L.m1391a(r11, r13);
        return r0;
    L_0x0076:
        r0.moveToFirst();	 Catch:{ JSONException -> 0x00a7 }
        r14 = r0.getColumnIndex(r9);	 Catch:{ JSONException -> 0x00a7 }
        r1 = r0.getLong(r14);	 Catch:{ JSONException -> 0x00a7 }
        r14 = java.lang.Long.valueOf(r1);	 Catch:{ JSONException -> 0x00a7 }
        r0.close();	 Catch:{ JSONException -> 0x00a7 }
        r12 = com.onesignal.C0595L.m1389a(r12, r13);	 Catch:{ JSONException -> 0x00a7 }
        if (r12 != 0) goto L_0x008f;	 Catch:{ JSONException -> 0x00a7 }
    L_0x008e:
        return r0;	 Catch:{ JSONException -> 0x00a7 }
    L_0x008f:
        r12 = new com.onesignal.G;	 Catch:{ JSONException -> 0x00a7 }
        r12.<init>(r11);	 Catch:{ JSONException -> 0x00a7 }
        r12.f1121c = r10;	 Catch:{ JSONException -> 0x00a7 }
        r12.f1123e = r14;	 Catch:{ JSONException -> 0x00a7 }
        r11 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00a7 }
        r11.<init>();	 Catch:{ JSONException -> 0x00a7 }
        r14 = "grp";	 Catch:{ JSONException -> 0x00a7 }
        r11.put(r14, r13);	 Catch:{ JSONException -> 0x00a7 }
        r12.f1120b = r11;	 Catch:{ JSONException -> 0x00a7 }
        com.onesignal.C0641s.m1594b(r12);	 Catch:{ JSONException -> 0x00a7 }
    L_0x00a7:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.L.b(android.content.Context, android.database.sqlite.SQLiteDatabase, java.lang.String, boolean):android.database.Cursor");
    }
}
