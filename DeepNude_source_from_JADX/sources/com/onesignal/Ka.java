package com.onesignal;

class ka implements Runnable {
    ka() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r16 = this;
        r0 = "android_notification_id";
        r1 = "Error closing transaction! ";
        r2 = com.onesignal.sa.f1380f;
        r3 = "notification";
        r2 = r2.getSystemService(r3);
        r2 = (android.app.NotificationManager) r2;
        r4 = com.onesignal.sa.f1380f;
        r4 = com.onesignal.va.m1748a(r4);
        r5 = 0;
        r6 = r4.m1750a();	 Catch:{ Throwable -> 0x00aa }
        r14 = 1;
        r8 = new java.lang.String[r14];	 Catch:{ Throwable -> 0x00aa }
        r15 = 0;
        r8[r15] = r0;	 Catch:{ Throwable -> 0x00aa }
        r7 = "notification";
        r9 = "dismissed = 0 AND opened = 0";
        r10 = 0;
        r11 = 0;
        r12 = 0;
        r13 = 0;
        r6 = r6.query(r7, r8, r9, r10, r11, r12, r13);	 Catch:{ Throwable -> 0x00aa }
        r7 = r6.moveToFirst();	 Catch:{ Throwable -> 0x00a4, all -> 0x00a2 }
        if (r7 == 0) goto L_0x0042;
    L_0x0031:
        r7 = r6.getColumnIndex(r0);	 Catch:{ Throwable -> 0x00a4, all -> 0x00a2 }
        r7 = r6.getInt(r7);	 Catch:{ Throwable -> 0x00a4, all -> 0x00a2 }
        r2.cancel(r7);	 Catch:{ Throwable -> 0x00a4, all -> 0x00a2 }
        r7 = r6.moveToNext();	 Catch:{ Throwable -> 0x00a4, all -> 0x00a2 }
        if (r7 != 0) goto L_0x0031;
    L_0x0042:
        r2 = r4.m1751b();	 Catch:{ Throwable -> 0x0076 }
        r2.beginTransaction();	 Catch:{ Throwable -> 0x0070, all -> 0x006d }
        r0 = "opened = 0";
        r4 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x0070, all -> 0x006d }
        r4.<init>();	 Catch:{ Throwable -> 0x0070, all -> 0x006d }
        r7 = "dismissed";
        r8 = java.lang.Integer.valueOf(r14);	 Catch:{ Throwable -> 0x0070, all -> 0x006d }
        r4.put(r7, r8);	 Catch:{ Throwable -> 0x0070, all -> 0x006d }
        r2.update(r3, r4, r0, r5);	 Catch:{ Throwable -> 0x0070, all -> 0x006d }
        r2.setTransactionSuccessful();	 Catch:{ Throwable -> 0x0070, all -> 0x006d }
        if (r2 == 0) goto L_0x0089;
    L_0x0061:
        r2.endTransaction();	 Catch:{ Throwable -> 0x0065, all -> 0x00a2 }
        goto L_0x0089;
    L_0x0065:
        r0 = move-exception;
        r2 = r0;
        r0 = com.onesignal.sa.C0650i.ERROR;	 Catch:{ Throwable -> 0x00a4, all -> 0x00a2 }
    L_0x0069:
        com.onesignal.sa.m1657a(r0, r1, r2);	 Catch:{ Throwable -> 0x00a4, all -> 0x00a2 }
        goto L_0x0089;
    L_0x006d:
        r0 = move-exception;
        r5 = r2;
        goto L_0x0074;
    L_0x0070:
        r0 = move-exception;
        r5 = r2;
        goto L_0x0077;
    L_0x0073:
        r0 = move-exception;
    L_0x0074:
        r2 = r0;
        goto L_0x0094;
    L_0x0076:
        r0 = move-exception;
    L_0x0077:
        r2 = com.onesignal.sa.C0650i.ERROR;	 Catch:{ all -> 0x0073 }
        r3 = "Error marking all notifications as dismissed! ";
        com.onesignal.sa.m1657a(r2, r3, r0);	 Catch:{ all -> 0x0073 }
        if (r5 == 0) goto L_0x0089;
    L_0x0080:
        r5.endTransaction();	 Catch:{ Throwable -> 0x0084, all -> 0x00a2 }
        goto L_0x0089;
    L_0x0084:
        r0 = move-exception;
        r2 = r0;
        r0 = com.onesignal.sa.C0650i.ERROR;	 Catch:{ Throwable -> 0x00a4, all -> 0x00a2 }
        goto L_0x0069;
    L_0x0089:
        r0 = com.onesignal.sa.f1380f;	 Catch:{ Throwable -> 0x00a4, all -> 0x00a2 }
        com.onesignal.C0631j.m1522a(r15, r0);	 Catch:{ Throwable -> 0x00a4, all -> 0x00a2 }
        if (r6 == 0) goto L_0x00b7;
    L_0x0090:
        r6.close();
        goto L_0x00b7;
    L_0x0094:
        if (r5 == 0) goto L_0x00a1;
    L_0x0096:
        r5.endTransaction();	 Catch:{ Throwable -> 0x009a, all -> 0x00a2 }
        goto L_0x00a1;
    L_0x009a:
        r0 = move-exception;
        r3 = r0;
        r0 = com.onesignal.sa.C0650i.ERROR;	 Catch:{ Throwable -> 0x00a4, all -> 0x00a2 }
        com.onesignal.sa.m1657a(r0, r1, r3);	 Catch:{ Throwable -> 0x00a4, all -> 0x00a2 }
    L_0x00a1:
        throw r2;	 Catch:{ Throwable -> 0x00a4, all -> 0x00a2 }
    L_0x00a2:
        r0 = move-exception;
        goto L_0x00b8;
    L_0x00a4:
        r0 = move-exception;
        r5 = r6;
        goto L_0x00ab;
    L_0x00a7:
        r0 = move-exception;
        r6 = r5;
        goto L_0x00b8;
    L_0x00aa:
        r0 = move-exception;
    L_0x00ab:
        r1 = com.onesignal.sa.C0650i.ERROR;	 Catch:{ all -> 0x00a7 }
        r2 = "Error canceling all notifications! ";
        com.onesignal.sa.m1657a(r1, r2, r0);	 Catch:{ all -> 0x00a7 }
        if (r5 == 0) goto L_0x00b7;
    L_0x00b4:
        r5.close();
    L_0x00b7:
        return;
    L_0x00b8:
        if (r6 == 0) goto L_0x00bd;
    L_0x00ba:
        r6.close();
    L_0x00bd:
        goto L_0x00bf;
    L_0x00be:
        throw r0;
    L_0x00bf:
        goto L_0x00be;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.ka.run():void");
    }
}
