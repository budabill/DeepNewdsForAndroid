package com.onesignal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.onesignal.sa.C0650i;

/* renamed from: com.onesignal.j */
class C0631j {
    /* renamed from: a */
    private static int f1274a = -1;

    /* renamed from: a */
    static void m1522a(int r1, android.content.Context r2) {
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
        r0 = com.onesignal.C0631j.m1524a(r2);
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        com.onesignal.p036a.C0619c.m1441a(r2, r1);	 Catch:{ Throwable -> 0x000a }
    L_0x000a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.j.a(int, android.content.Context):void");
    }

    /* renamed from: a */
    static void m1523a(SQLiteDatabase sQLiteDatabase, Context context) {
        if (C0631j.m1525b(context)) {
            Cursor query = sQLiteDatabase.query("notification", null, "dismissed = 0 AND opened = 0 AND is_summary = 0 ", null, null, null, null);
            C0631j.m1522a(query.getCount(), context);
            query.close();
        }
    }

    /* renamed from: a */
    private static boolean m1524a(Context context) {
        int i = f1274a;
        boolean z = false;
        if (i != -1) {
            if (i == 1) {
                z = true;
            }
            return z;
        }
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                f1274a = "DISABLE".equals(bundle.getString("com.onesignal.BadgeCount")) ? 0 : 1;
            } else {
                f1274a = 1;
            }
        } catch (Throwable th) {
            f1274a = 0;
            sa.m1657a(C0650i.ERROR, "Error reading meta-data tag 'com.onesignal.BadgeCount'. Disabling badge setting.", th);
        }
        if (f1274a == 1) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    private static boolean m1525b(Context context) {
        return C0631j.m1524a(context) && aa.m1447a(context);
    }
}
