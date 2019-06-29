package com.onesignal;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat.Builder;
import android.widget.RemoteViews;
import com.onesignal.C0872F.C0587a;
import com.onesignal.sa.C0650i;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.onesignal.s */
class C0641s {
    /* renamed from: a */
    private static Context f1310a;
    /* renamed from: b */
    private static String f1311b;
    /* renamed from: c */
    private static Resources f1312c;
    /* renamed from: d */
    private static Class<?> f1313d;
    /* renamed from: e */
    private static boolean f1314e;

    /* renamed from: com.onesignal.s$a */
    private static class C0640a {
        /* renamed from: a */
        Builder f1308a;
        /* renamed from: b */
        boolean f1309b;

        private C0640a() {
        }
    }

    /* renamed from: a */
    private static PendingIntent m1568a(int i, Intent intent) {
        return f1314e ? PendingIntent.getBroadcast(f1310a, i, intent, 134217728) : PendingIntent.getActivity(f1310a, i, intent, 134217728);
    }

    /* renamed from: a */
    private static Intent m1570a(int i, JSONObject jSONObject, String str) {
        return C0641s.m1595c(i).putExtra("onesignal_data", jSONObject.toString()).putExtra("summary", str);
    }

    /* renamed from: a */
    private static Bitmap m1571a() {
        return C0641s.m1572a(C0641s.m1591b("ic_onesignal_large_icon_default"));
    }

    /* renamed from: a */
    private static android.graphics.Bitmap m1572a(android.graphics.Bitmap r4) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        if (r4 != 0) goto L_0x0004;
    L_0x0002:
        r4 = 0;
        return r4;
    L_0x0004:
        r0 = f1312c;	 Catch:{ Throwable -> 0x003c }
        r1 = 17104902; // 0x1050006 float:2.442826E-38 double:8.4509445E-317;	 Catch:{ Throwable -> 0x003c }
        r0 = r0.getDimension(r1);	 Catch:{ Throwable -> 0x003c }
        r0 = (int) r0;	 Catch:{ Throwable -> 0x003c }
        r1 = f1312c;	 Catch:{ Throwable -> 0x003c }
        r2 = 17104901; // 0x1050005 float:2.4428256E-38 double:8.450944E-317;	 Catch:{ Throwable -> 0x003c }
        r1 = r1.getDimension(r2);	 Catch:{ Throwable -> 0x003c }
        r1 = (int) r1;	 Catch:{ Throwable -> 0x003c }
        r2 = r4.getHeight();	 Catch:{ Throwable -> 0x003c }
        r3 = r4.getWidth();	 Catch:{ Throwable -> 0x003c }
        if (r3 > r1) goto L_0x0024;	 Catch:{ Throwable -> 0x003c }
    L_0x0022:
        if (r2 <= r0) goto L_0x003c;	 Catch:{ Throwable -> 0x003c }
    L_0x0024:
        if (r2 <= r3) goto L_0x002e;	 Catch:{ Throwable -> 0x003c }
    L_0x0026:
        r1 = (float) r3;	 Catch:{ Throwable -> 0x003c }
        r2 = (float) r2;	 Catch:{ Throwable -> 0x003c }
        r1 = r1 / r2;	 Catch:{ Throwable -> 0x003c }
        r2 = (float) r0;	 Catch:{ Throwable -> 0x003c }
        r2 = r2 * r1;	 Catch:{ Throwable -> 0x003c }
        r1 = (int) r2;	 Catch:{ Throwable -> 0x003c }
        goto L_0x0037;	 Catch:{ Throwable -> 0x003c }
    L_0x002e:
        if (r3 <= r2) goto L_0x0037;	 Catch:{ Throwable -> 0x003c }
    L_0x0030:
        r0 = (float) r2;	 Catch:{ Throwable -> 0x003c }
        r2 = (float) r3;	 Catch:{ Throwable -> 0x003c }
        r0 = r0 / r2;	 Catch:{ Throwable -> 0x003c }
        r2 = (float) r1;	 Catch:{ Throwable -> 0x003c }
        r2 = r2 * r0;	 Catch:{ Throwable -> 0x003c }
        r0 = (int) r2;	 Catch:{ Throwable -> 0x003c }
    L_0x0037:
        r2 = 1;	 Catch:{ Throwable -> 0x003c }
        r4 = android.graphics.Bitmap.createScaledBitmap(r4, r1, r0, r2);	 Catch:{ Throwable -> 0x003c }
    L_0x003c:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.s.a(android.graphics.Bitmap):android.graphics.Bitmap");
    }

    /* renamed from: a */
    private static Bitmap m1573a(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (!trim.startsWith("http://")) {
            if (!trim.startsWith("https://")) {
                return C0641s.m1591b(str);
            }
        }
        return C0641s.m1596c(trim);
    }

    /* renamed from: a */
    private static java.lang.Integer m1575a(org.json.JSONObject r1, java.lang.String r2) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        if (r1 == 0) goto L_0x001c;
    L_0x0002:
        r0 = r1.has(r2);	 Catch:{ Throwable -> 0x001c }
        if (r0 == 0) goto L_0x001c;	 Catch:{ Throwable -> 0x001c }
    L_0x0008:
        r0 = new java.math.BigInteger;	 Catch:{ Throwable -> 0x001c }
        r1 = r1.optString(r2);	 Catch:{ Throwable -> 0x001c }
        r2 = 16;	 Catch:{ Throwable -> 0x001c }
        r0.<init>(r1, r2);	 Catch:{ Throwable -> 0x001c }
        r1 = r0.intValue();	 Catch:{ Throwable -> 0x001c }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Throwable -> 0x001c }
        return r1;
    L_0x001c:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.s.a(org.json.JSONObject, java.lang.String):java.lang.Integer");
    }

    /* renamed from: a */
    private static void m1576a(Context context) {
        Class cls;
        f1310a = context;
        f1311b = f1310a.getPackageName();
        f1312c = f1310a.getResources();
        PackageManager packageManager = f1310a.getPackageManager();
        Intent intent = new Intent(f1310a, NotificationOpenedReceiver.class);
        intent.setPackage(f1310a.getPackageName());
        if (packageManager.queryBroadcastReceivers(intent, 0).size() > 0) {
            f1314e = true;
            cls = NotificationOpenedReceiver.class;
        } else {
            cls = C0590H.class;
        }
        f1313d = cls;
    }

    /* renamed from: a */
    private static void m1578a(Builder builder) {
        builder.setOnlyAlertOnce(true).setDefaults(0).setSound(null).setVibrate(null).setTicker(null);
    }

    /* renamed from: a */
    private static void m1579a(RemoteViews remoteViews, JSONObject jSONObject, int i, String str, String str2) {
        int intValue;
        Integer a = C0641s.m1575a(jSONObject, str);
        if (a != null) {
            intValue = a.intValue();
        } else {
            intValue = f1312c.getIdentifier(str2, "color", f1311b);
            if (intValue != 0) {
                intValue = C0629h.m1520a(f1310a, intValue);
            } else {
                return;
            }
        }
        remoteViews.setTextColor(i, intValue);
    }

    /* renamed from: a */
    static void m1580a(C0588G c0588g) {
        C0641s.m1576a(c0588g.f1119a);
        if (!c0588g.f1121c && c0588g.f1122d) {
            Activity activity = C0624b.f1259b;
            if (activity != null) {
                C0641s.m1585a(c0588g.f1120b, activity, c0588g.m1314a().intValue());
                return;
            }
        }
        C0641s.m1603d(c0588g);
    }

    /* renamed from: a */
    private static void m1581a(C0588G c0588g, Builder builder) {
        C0587a c0587a = c0588g.f1130l;
        if (c0587a == null) {
            return;
        }
        if (c0587a.f1113a != null) {
            try {
                Field declaredField = Builder.class.getDeclaredField("mNotification");
                declaredField.setAccessible(true);
                Notification notification = (Notification) declaredField.get(builder);
                c0588g.f1128j = Integer.valueOf(notification.flags);
                c0588g.f1129k = notification.sound;
                builder.extend(c0588g.f1130l.f1113a);
                Notification notification2 = (Notification) declaredField.get(builder);
                Field declaredField2 = Builder.class.getDeclaredField("mContentText");
                declaredField2.setAccessible(true);
                CharSequence charSequence = (CharSequence) declaredField2.get(builder);
                Field declaredField3 = Builder.class.getDeclaredField("mContentTitle");
                declaredField3.setAccessible(true);
                CharSequence charSequence2 = (CharSequence) declaredField3.get(builder);
                c0588g.f1124f = charSequence;
                c0588g.f1125g = charSequence2;
                if (!c0588g.f1121c) {
                    c0588g.f1127i = Integer.valueOf(notification2.flags);
                    c0588g.f1126h = notification2.sound;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private static void m1582a(com.onesignal.C0588G r25, com.onesignal.C0641s.C0640a r26) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r1 = r25;
        r2 = r26;
        r0 = "message";
        r3 = "title";
        r4 = "is_summary";
        r5 = "full_data";
        r6 = "android_notification_id";
        r7 = r1.f1121c;
        r8 = r1.f1120b;
        r9 = 0;
        r10 = "grp";
        r10 = r8.optString(r10, r9);
        r11 = new java.util.Random;
        r11.<init>();
        r12 = r11.nextInt();
        r13 = 0;
        r14 = com.onesignal.C0641s.m1590b(r13);
        r15 = "summary";
        r14 = r14.putExtra(r15, r10);
        r12 = com.onesignal.C0641s.m1568a(r12, r14);
        r14 = f1310a;
        r14 = com.onesignal.va.m1748a(r14);
        r15 = r14.m1750a();	 Catch:{ all -> 0x02e1 }
        r9 = 5;
        r9 = new java.lang.String[r9];	 Catch:{ all -> 0x02de }
        r9[r13] = r6;	 Catch:{ all -> 0x02de }
        r13 = 1;	 Catch:{ all -> 0x02de }
        r9[r13] = r5;	 Catch:{ all -> 0x02de }
        r16 = 2;	 Catch:{ all -> 0x02de }
        r9[r16] = r4;	 Catch:{ all -> 0x02de }
        r16 = 3;	 Catch:{ all -> 0x02de }
        r9[r16] = r3;	 Catch:{ all -> 0x02de }
        r16 = 4;	 Catch:{ all -> 0x02de }
        r9[r16] = r0;	 Catch:{ all -> 0x02de }
        r23 = r8;	 Catch:{ all -> 0x02de }
        r8 = "group_id = ? AND dismissed = 0 AND opened = 0";	 Catch:{ all -> 0x02de }
        r2 = new java.lang.String[r13];	 Catch:{ all -> 0x02de }
        r16 = 0;	 Catch:{ all -> 0x02de }
        r2[r16] = r10;	 Catch:{ all -> 0x02de }
        if (r7 != 0) goto L_0x0081;	 Catch:{ all -> 0x02de }
    L_0x005b:
        r16 = r25.m1314a();	 Catch:{ all -> 0x02de }
        r13 = r16.intValue();	 Catch:{ all -> 0x02de }
        r24 = r12;	 Catch:{ all -> 0x02de }
        r12 = -1;	 Catch:{ all -> 0x02de }
        if (r13 == r12) goto L_0x0083;	 Catch:{ all -> 0x02de }
    L_0x0068:
        r12 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02de }
        r12.<init>();	 Catch:{ all -> 0x02de }
        r12.append(r8);	 Catch:{ all -> 0x02de }
        r8 = " AND android_notification_id <> ";	 Catch:{ all -> 0x02de }
        r12.append(r8);	 Catch:{ all -> 0x02de }
        r8 = r25.m1314a();	 Catch:{ all -> 0x02de }
        r12.append(r8);	 Catch:{ all -> 0x02de }
        r8 = r12.toString();	 Catch:{ all -> 0x02de }
        goto L_0x0083;	 Catch:{ all -> 0x02de }
    L_0x0081:
        r24 = r12;	 Catch:{ all -> 0x02de }
    L_0x0083:
        r18 = r8;	 Catch:{ all -> 0x02de }
        r16 = "notification";	 Catch:{ all -> 0x02de }
        r20 = 0;	 Catch:{ all -> 0x02de }
        r21 = 0;	 Catch:{ all -> 0x02de }
        r22 = "_id DESC";	 Catch:{ all -> 0x02de }
        r17 = r9;	 Catch:{ all -> 0x02de }
        r19 = r2;	 Catch:{ all -> 0x02de }
        r9 = r15.query(r16, r17, r18, r19, r20, r21, r22);	 Catch:{ all -> 0x02de }
        r2 = r9.moveToFirst();	 Catch:{ all -> 0x02e1 }
        r8 = " ";
        r12 = "";
        if (r2 == 0) goto L_0x0145;
    L_0x009f:
        r2 = new java.util.ArrayList;	 Catch:{ all -> 0x02e1 }
        r2.<init>();	 Catch:{ all -> 0x02e1 }
        r13 = 0;	 Catch:{ all -> 0x02e1 }
        r15 = 0;	 Catch:{ all -> 0x02e1 }
    L_0x00a6:
        r16 = r15;	 Catch:{ all -> 0x02e1 }
        r15 = r9.getColumnIndex(r4);	 Catch:{ all -> 0x02e1 }
        r15 = r9.getInt(r15);	 Catch:{ all -> 0x02e1 }
        r17 = r4;	 Catch:{ all -> 0x02e1 }
        r4 = 1;	 Catch:{ all -> 0x02e1 }
        if (r15 != r4) goto L_0x00c7;	 Catch:{ all -> 0x02e1 }
    L_0x00b5:
        r4 = r9.getColumnIndex(r6);	 Catch:{ all -> 0x02e1 }
        r4 = r9.getInt(r4);	 Catch:{ all -> 0x02e1 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ all -> 0x02e1 }
        r18 = r0;	 Catch:{ all -> 0x02e1 }
        r19 = r3;	 Catch:{ all -> 0x02e1 }
        r15 = r4;	 Catch:{ all -> 0x02e1 }
        goto L_0x0126;	 Catch:{ all -> 0x02e1 }
    L_0x00c7:
        r4 = r9.getColumnIndex(r3);	 Catch:{ all -> 0x02e1 }
        r4 = r9.getString(r4);	 Catch:{ all -> 0x02e1 }
        if (r4 != 0) goto L_0x00d3;	 Catch:{ all -> 0x02e1 }
    L_0x00d1:
        r4 = r12;	 Catch:{ all -> 0x02e1 }
        goto L_0x00e2;	 Catch:{ all -> 0x02e1 }
    L_0x00d3:
        r15 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02e1 }
        r15.<init>();	 Catch:{ all -> 0x02e1 }
        r15.append(r4);	 Catch:{ all -> 0x02e1 }
        r15.append(r8);	 Catch:{ all -> 0x02e1 }
        r4 = r15.toString();	 Catch:{ all -> 0x02e1 }
    L_0x00e2:
        r15 = r9.getColumnIndex(r0);	 Catch:{ all -> 0x02e1 }
        r15 = r9.getString(r15);	 Catch:{ all -> 0x02e1 }
        r18 = r0;	 Catch:{ all -> 0x02e1 }
        r0 = new android.text.SpannableString;	 Catch:{ all -> 0x02e1 }
        r19 = r3;	 Catch:{ all -> 0x02e1 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02e1 }
        r3.<init>();	 Catch:{ all -> 0x02e1 }
        r3.append(r4);	 Catch:{ all -> 0x02e1 }
        r3.append(r15);	 Catch:{ all -> 0x02e1 }
        r3 = r3.toString();	 Catch:{ all -> 0x02e1 }
        r0.<init>(r3);	 Catch:{ all -> 0x02e1 }
        r3 = r4.length();	 Catch:{ all -> 0x02e1 }
        if (r3 <= 0) goto L_0x0116;	 Catch:{ all -> 0x02e1 }
    L_0x0108:
        r3 = new android.text.style.StyleSpan;	 Catch:{ all -> 0x02e1 }
        r15 = 1;	 Catch:{ all -> 0x02e1 }
        r3.<init>(r15);	 Catch:{ all -> 0x02e1 }
        r4 = r4.length();	 Catch:{ all -> 0x02e1 }
        r15 = 0;	 Catch:{ all -> 0x02e1 }
        r0.setSpan(r3, r15, r4, r15);	 Catch:{ all -> 0x02e1 }
    L_0x0116:
        r2.add(r0);	 Catch:{ all -> 0x02e1 }
        if (r13 != 0) goto L_0x0124;	 Catch:{ all -> 0x02e1 }
    L_0x011b:
        r0 = r9.getColumnIndex(r5);	 Catch:{ all -> 0x02e1 }
        r0 = r9.getString(r0);	 Catch:{ all -> 0x02e1 }
        r13 = r0;	 Catch:{ all -> 0x02e1 }
    L_0x0124:
        r15 = r16;	 Catch:{ all -> 0x02e1 }
    L_0x0126:
        r0 = r9.moveToNext();	 Catch:{ all -> 0x02e1 }
        if (r0 != 0) goto L_0x013d;
    L_0x012c:
        if (r7 == 0) goto L_0x013a;
    L_0x012e:
        if (r13 == 0) goto L_0x013a;
    L_0x0130:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0136 }
        r0.<init>(r13);	 Catch:{ JSONException -> 0x0136 }
        goto L_0x0149;
    L_0x0136:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x02e1 }
    L_0x013a:
        r0 = r23;
        goto L_0x0149;
    L_0x013d:
        r4 = r17;
        r0 = r18;
        r3 = r19;
        goto L_0x00a6;
    L_0x0145:
        r0 = r23;
        r2 = 0;
        r15 = 0;
    L_0x0149:
        if (r9 == 0) goto L_0x0154;
    L_0x014b:
        r3 = r9.isClosed();
        if (r3 != 0) goto L_0x0154;
    L_0x0151:
        r9.close();
    L_0x0154:
        if (r15 != 0) goto L_0x0165;
    L_0x0156:
        r3 = r11.nextInt();
        r15 = java.lang.Integer.valueOf(r3);
        r3 = r15.intValue();
        com.onesignal.C0641s.m1584a(r14, r10, r3);
    L_0x0165:
        r3 = r11.nextInt();
        r4 = r15.intValue();
        r4 = com.onesignal.C0641s.m1570a(r4, r0, r10);
        r3 = com.onesignal.C0641s.m1568a(r3, r4);
        if (r2 == 0) goto L_0x02a0;
    L_0x0177:
        if (r7 == 0) goto L_0x0180;
    L_0x0179:
        r4 = r2.size();
        r5 = 1;
        if (r4 > r5) goto L_0x0188;
    L_0x0180:
        if (r7 != 0) goto L_0x02a0;
    L_0x0182:
        r4 = r2.size();
        if (r4 <= 0) goto L_0x02a0;
    L_0x0188:
        r4 = r2.size();
        r5 = r7 ^ 1;
        r4 = r4 + r5;
        r5 = "grp_msg";
        r9 = 0;
        r0 = r0.optString(r5, r9);
        if (r0 != 0) goto L_0x01aa;
    L_0x0198:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0.append(r4);
        r5 = " new messages";
        r0.append(r5);
        r0 = r0.toString();
        goto L_0x01bf;
    L_0x01aa:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r5.append(r12);
        r5.append(r4);
        r5 = r5.toString();
        r6 = "$[notif_count]";
        r0 = r0.replace(r6, r5);
    L_0x01bf:
        r5 = com.onesignal.C0641s.m1598c(r25);
        r5 = r5.f1308a;
        if (r7 == 0) goto L_0x01cb;
    L_0x01c7:
        com.onesignal.C0641s.m1578a(r5);
        goto L_0x01dd;
    L_0x01cb:
        r6 = r1.f1126h;
        if (r6 == 0) goto L_0x01d2;
    L_0x01cf:
        r5.setSound(r6);
    L_0x01d2:
        r6 = r1.f1127i;
        if (r6 == 0) goto L_0x01dd;
    L_0x01d6:
        r6 = r6.intValue();
        r5.setDefaults(r6);
    L_0x01dd:
        r3 = r5.setContentIntent(r3);
        r6 = r24;
        r3 = r3.setDeleteIntent(r6);
        r6 = f1310a;
        r6 = r6.getPackageManager();
        r11 = f1310a;
        r11 = r11.getApplicationInfo();
        r6 = r6.getApplicationLabel(r11);
        r3 = r3.setContentTitle(r6);
        r3 = r3.setContentText(r0);
        r3 = r3.setNumber(r4);
        r4 = com.onesignal.C0641s.m1588b();
        r3 = r3.setSmallIcon(r4);
        r4 = com.onesignal.C0641s.m1571a();
        r3 = r3.setLargeIcon(r4);
        r3 = r3.setOnlyAlertOnce(r7);
        r3 = r3.setGroup(r10);
        r4 = 1;
        r3.setGroupSummary(r4);
        r5.setGroupAlertBehavior(r4);	 Catch:{ Throwable -> 0x0222 }
    L_0x0222:
        if (r7 != 0) goto L_0x0227;
    L_0x0224:
        r5.setTicker(r0);
    L_0x0227:
        r3 = new android.support.v4.app.NotificationCompat$InboxStyle;
        r3.<init>();
        if (r7 != 0) goto L_0x0281;
    L_0x022e:
        r4 = r25.m1318d();
        if (r4 == 0) goto L_0x023c;
    L_0x0234:
        r4 = r25.m1318d();
        r9 = r4.toString();
    L_0x023c:
        if (r9 != 0) goto L_0x023f;
    L_0x023e:
        goto L_0x024e;
    L_0x023f:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r9);
        r4.append(r8);
        r12 = r4.toString();
    L_0x024e:
        r1 = r25.m1317c();
        r1 = r1.toString();
        r4 = new android.text.SpannableString;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r6.append(r12);
        r6.append(r1);
        r1 = r6.toString();
        r4.<init>(r1);
        r1 = r12.length();
        if (r1 <= 0) goto L_0x027e;
    L_0x0270:
        r1 = new android.text.style.StyleSpan;
        r6 = 1;
        r1.<init>(r6);
        r6 = r12.length();
        r7 = 0;
        r4.setSpan(r1, r7, r6, r7);
    L_0x027e:
        r3.addLine(r4);
    L_0x0281:
        r1 = r2.iterator();
    L_0x0285:
        r2 = r1.hasNext();
        if (r2 == 0) goto L_0x0295;
    L_0x028b:
        r2 = r1.next();
        r2 = (android.text.SpannableString) r2;
        r3.addLine(r2);
        goto L_0x0285;
    L_0x0295:
        r3.setBigContentTitle(r0);
        r5.setStyle(r3);
        r0 = r5.build();
        goto L_0x02d0;
    L_0x02a0:
        r6 = r24;
        r1 = r26;
        r2 = r1.f1308a;
        r4 = r2.mActions;
        r4.clear();
        r4 = r15.intValue();
        com.onesignal.C0641s.m1587a(r0, r2, r4, r10);
        r0 = r2.setContentIntent(r3);
        r0 = r0.setDeleteIntent(r6);
        r0 = r0.setOnlyAlertOnce(r7);
        r0 = r0.setGroup(r10);
        r3 = 1;
        r0.setGroupSummary(r3);
        r2.setGroupAlertBehavior(r3);	 Catch:{ Throwable -> 0x02c9 }
    L_0x02c9:
        r0 = r2.build();
        com.onesignal.C0641s.m1583a(r1, r0);
    L_0x02d0:
        r1 = f1310a;
        r1 = android.support.v4.app.NotificationManagerCompat.from(r1);
        r2 = r15.intValue();
        r1.notify(r2, r0);
        return;
    L_0x02de:
        r0 = move-exception;
        r9 = 0;
        goto L_0x02e2;
    L_0x02e1:
        r0 = move-exception;
    L_0x02e2:
        if (r9 == 0) goto L_0x02ed;
    L_0x02e4:
        r1 = r9.isClosed();
        if (r1 != 0) goto L_0x02ed;
    L_0x02ea:
        r9.close();
    L_0x02ed:
        goto L_0x02ef;
    L_0x02ee:
        throw r0;
    L_0x02ef:
        goto L_0x02ee;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.s.a(com.onesignal.G, com.onesignal.s$a):void");
    }

    /* renamed from: a */
    private static void m1583a(com.onesignal.C0641s.C0640a r3, android.app.Notification r4) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r3 = r3.f1309b;
        if (r3 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r3 = "android.app.MiuiNotification";
        r3 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x0034 }
        r3 = r3.newInstance();	 Catch:{ Throwable -> 0x0034 }
        r0 = r3.getClass();	 Catch:{ Throwable -> 0x0034 }
        r1 = "customizedIcon";	 Catch:{ Throwable -> 0x0034 }
        r0 = r0.getDeclaredField(r1);	 Catch:{ Throwable -> 0x0034 }
        r1 = 1;	 Catch:{ Throwable -> 0x0034 }
        r0.setAccessible(r1);	 Catch:{ Throwable -> 0x0034 }
        r2 = java.lang.Boolean.valueOf(r1);	 Catch:{ Throwable -> 0x0034 }
        r0.set(r3, r2);	 Catch:{ Throwable -> 0x0034 }
        r0 = r4.getClass();	 Catch:{ Throwable -> 0x0034 }
        r2 = "extraNotification";	 Catch:{ Throwable -> 0x0034 }
        r0 = r0.getField(r2);	 Catch:{ Throwable -> 0x0034 }
        r0.setAccessible(r1);	 Catch:{ Throwable -> 0x0034 }
        r0.set(r4, r3);	 Catch:{ Throwable -> 0x0034 }
    L_0x0034:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.s.a(com.onesignal.s$a, android.app.Notification):void");
    }

    /* renamed from: a */
    private static void m1584a(va vaVar, String str, int i) {
        Throwable th;
        String str2 = "Error closing transaction! ";
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase b = vaVar.m1751b();
            try {
                b.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("android_notification_id", Integer.valueOf(i));
                contentValues.put("group_id", str);
                contentValues.put("is_summary", Integer.valueOf(1));
                b.insertOrThrow("notification", null, contentValues);
                b.setTransactionSuccessful();
                if (b != null) {
                    try {
                        b.endTransaction();
                    } catch (Throwable th2) {
                        sa.m1657a(C0650i.ERROR, str2, th2);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                if (b != null) {
                    b.endTransaction();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            sa.m1657a(C0650i.ERROR, "Error adding summary notification record! ", th);
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    /* renamed from: a */
    private static void m1585a(JSONObject jSONObject, Activity activity, int i) {
        activity.runOnUiThread(new C0639r(activity, jSONObject, i));
    }

    /* renamed from: a */
    private static void m1586a(JSONObject jSONObject, Builder builder) {
        if (VERSION.SDK_INT >= 16) {
            JSONObject jSONObject2;
            Bitmap a;
            String optString = jSONObject.optString("bg_img", null);
            if (optString != null) {
                jSONObject2 = new JSONObject(optString);
                a = C0641s.m1573a(jSONObject2.optString("img", null));
            } else {
                a = null;
                jSONObject2 = a;
            }
            if (a == null) {
                a = C0641s.m1591b("onesignal_bgimage_default_image");
            }
            if (a != null) {
                Object string;
                RemoteViews remoteViews = new RemoteViews(f1310a.getPackageName(), Ta.onesignal_bgimage_notif_layout);
                remoteViews.setTextViewText(Sa.os_bgimage_notif_title, C0641s.m1605e(jSONObject));
                remoteViews.setTextViewText(Sa.os_bgimage_notif_body, jSONObject.optString("alert"));
                C0641s.m1579a(remoteViews, jSONObject2, Sa.os_bgimage_notif_title, "tc", "onesignal_bgimage_notif_title_color");
                C0641s.m1579a(remoteViews, jSONObject2, Sa.os_bgimage_notif_body, "bc", "onesignal_bgimage_notif_body_color");
                if (jSONObject2 != null) {
                    String str = "img_align";
                    if (jSONObject2.has(str)) {
                        string = jSONObject2.getString(str);
                        if ("right".equals(string)) {
                            remoteViews.setImageViewBitmap(Sa.os_bgimage_notif_bgimage, a);
                        } else {
                            remoteViews.setViewPadding(Sa.os_bgimage_notif_bgimage_align_layout, -5000, 0, 0, 0);
                            remoteViews.setImageViewBitmap(Sa.os_bgimage_notif_bgimage_right_aligned, a);
                            remoteViews.setViewVisibility(Sa.os_bgimage_notif_bgimage_right_aligned, 0);
                            remoteViews.setViewVisibility(Sa.os_bgimage_notif_bgimage, 2);
                        }
                        builder.setContent(remoteViews);
                        builder.setStyle(null);
                    }
                }
                int identifier = f1312c.getIdentifier("onesignal_bgimage_notif_image_align", "string", f1311b);
                string = identifier != 0 ? f1312c.getString(identifier) : null;
                if ("right".equals(string)) {
                    remoteViews.setImageViewBitmap(Sa.os_bgimage_notif_bgimage, a);
                } else {
                    remoteViews.setViewPadding(Sa.os_bgimage_notif_bgimage_align_layout, -5000, 0, 0, 0);
                    remoteViews.setImageViewBitmap(Sa.os_bgimage_notif_bgimage_right_aligned, a);
                    remoteViews.setViewVisibility(Sa.os_bgimage_notif_bgimage_right_aligned, 0);
                    remoteViews.setViewVisibility(Sa.os_bgimage_notif_bgimage, 2);
                }
                builder.setContent(remoteViews);
                builder.setStyle(null);
            }
        }
    }

    /* renamed from: a */
    private static void m1587a(JSONObject jSONObject, Builder builder, int i, String str) {
        String str2 = "icon";
        String str3 = "actionButtons";
        String str4 = "a";
        String str5 = "grp";
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("custom"));
            if (jSONObject2.has(str4)) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject(str4);
                if (jSONObject3.has(str3)) {
                    JSONArray jSONArray = jSONObject3.getJSONArray(str3);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        JSONObject jSONObject4 = new JSONObject(jSONObject.toString());
                        Intent c = C0641s.m1595c(i);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("");
                        stringBuilder.append(i2);
                        c.setAction(stringBuilder.toString());
                        c.putExtra("action_button", true);
                        jSONObject4.put("actionSelected", optJSONObject.optString("id"));
                        c.putExtra("onesignal_data", jSONObject4.toString());
                        if (str != null) {
                            c.putExtra("summary", str);
                        } else if (jSONObject.has(str5)) {
                            c.putExtra(str5, jSONObject.optString(str5));
                        }
                        builder.addAction(optJSONObject.has(str2) ? C0641s.m1604e(optJSONObject.optString(str2)) : 0, optJSONObject.optString("text"), C0641s.m1568a(i, c));
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    private static int m1588b() {
        int d = C0641s.m1601d("ic_stat_onesignal_default");
        if (d != 0) {
            return d;
        }
        d = C0641s.m1601d("corona_statusbar_icon_default");
        if (d != 0) {
            return d;
        }
        d = C0641s.m1601d("ic_os_notification_fallback_white_24dp");
        return d != 0 ? d : 17301598;
    }

    /* renamed from: b */
    private static Notification m1589b(C0588G c0588g, Builder builder) {
        int i = VERSION.SDK_INT;
        Object obj = (i <= 17 || i >= 24 || c0588g.f1121c) ? null : 1;
        if (obj != null) {
            Uri uri = c0588g.f1126h;
            if (!(uri == null || uri.equals(c0588g.f1129k))) {
                builder.setSound(null);
            }
        }
        Notification build = builder.build();
        if (obj != null) {
            builder.setSound(c0588g.f1126h);
        }
        return build;
    }

    /* renamed from: b */
    private static Intent m1590b(int i) {
        Intent putExtra = new Intent(f1310a, f1313d).putExtra("notificationId", i).putExtra("dismissed", true);
        return f1314e ? putExtra : putExtra.addFlags(402718720);
    }

    /* renamed from: b */
    private static android.graphics.Bitmap m1591b(java.lang.String r6) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r0 = 0;
        r1 = f1310a;	 Catch:{ Throwable -> 0x0010 }
        r1 = r1.getAssets();	 Catch:{ Throwable -> 0x0010 }
        r1 = r1.open(r6);	 Catch:{ Throwable -> 0x0010 }
        r1 = android.graphics.BitmapFactory.decodeStream(r1);	 Catch:{ Throwable -> 0x0010 }
        goto L_0x0011;
    L_0x0010:
        r1 = r0;
    L_0x0011:
        if (r1 == 0) goto L_0x0014;
    L_0x0013:
        return r1;
    L_0x0014:
        r2 = 5;
        r2 = new java.lang.String[r2];	 Catch:{ Throwable -> 0x0071 }
        r3 = 0;	 Catch:{ Throwable -> 0x0071 }
        r4 = ".png";	 Catch:{ Throwable -> 0x0071 }
        r2[r3] = r4;	 Catch:{ Throwable -> 0x0071 }
        r3 = 1;	 Catch:{ Throwable -> 0x0071 }
        r4 = ".webp";	 Catch:{ Throwable -> 0x0071 }
        r2[r3] = r4;	 Catch:{ Throwable -> 0x0071 }
        r3 = 2;	 Catch:{ Throwable -> 0x0071 }
        r4 = ".jpg";	 Catch:{ Throwable -> 0x0071 }
        r2[r3] = r4;	 Catch:{ Throwable -> 0x0071 }
        r3 = 3;	 Catch:{ Throwable -> 0x0071 }
        r4 = ".gif";	 Catch:{ Throwable -> 0x0071 }
        r2[r3] = r4;	 Catch:{ Throwable -> 0x0071 }
        r3 = 4;	 Catch:{ Throwable -> 0x0071 }
        r4 = ".bmp";	 Catch:{ Throwable -> 0x0071 }
        r2[r3] = r4;	 Catch:{ Throwable -> 0x0071 }
        r2 = java.util.Arrays.asList(r2);	 Catch:{ Throwable -> 0x0071 }
        r2 = r2.iterator();	 Catch:{ Throwable -> 0x0071 }
    L_0x0038:
        r3 = r2.hasNext();	 Catch:{ Throwable -> 0x0071 }
        if (r3 == 0) goto L_0x0064;	 Catch:{ Throwable -> 0x0071 }
    L_0x003e:
        r3 = r2.next();	 Catch:{ Throwable -> 0x0071 }
        r3 = (java.lang.String) r3;	 Catch:{ Throwable -> 0x0071 }
        r4 = f1310a;	 Catch:{ Throwable -> 0x0061 }
        r4 = r4.getAssets();	 Catch:{ Throwable -> 0x0061 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0061 }
        r5.<init>();	 Catch:{ Throwable -> 0x0061 }
        r5.append(r6);	 Catch:{ Throwable -> 0x0061 }
        r5.append(r3);	 Catch:{ Throwable -> 0x0061 }
        r3 = r5.toString();	 Catch:{ Throwable -> 0x0061 }
        r3 = r4.open(r3);	 Catch:{ Throwable -> 0x0061 }
        r1 = android.graphics.BitmapFactory.decodeStream(r3);	 Catch:{ Throwable -> 0x0061 }
    L_0x0061:
        if (r1 == 0) goto L_0x0038;
    L_0x0063:
        return r1;
    L_0x0064:
        r6 = com.onesignal.C0641s.m1604e(r6);	 Catch:{ Throwable -> 0x0071 }
        if (r6 == 0) goto L_0x0071;	 Catch:{ Throwable -> 0x0071 }
    L_0x006a:
        r1 = f1312c;	 Catch:{ Throwable -> 0x0071 }
        r6 = android.graphics.BitmapFactory.decodeResource(r1, r6);	 Catch:{ Throwable -> 0x0071 }
        return r6;
    L_0x0071:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.s.b(java.lang.String):android.graphics.Bitmap");
    }

    /* renamed from: b */
    private static java.math.BigInteger m1592b(org.json.JSONObject r4) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r0 = "bgac";
        r1 = 16;
        r2 = 0;
        r3 = r4.has(r0);	 Catch:{ Throwable -> 0x0015 }
        if (r3 == 0) goto L_0x0015;	 Catch:{ Throwable -> 0x0015 }
    L_0x000b:
        r3 = new java.math.BigInteger;	 Catch:{ Throwable -> 0x0015 }
        r4 = r4.optString(r0, r2);	 Catch:{ Throwable -> 0x0015 }
        r3.<init>(r4, r1);	 Catch:{ Throwable -> 0x0015 }
        return r3;
    L_0x0015:
        r4 = f1310a;	 Catch:{ Throwable -> 0x0025 }
        r0 = "com.onesignal.NotificationAccentColor.DEFAULT";	 Catch:{ Throwable -> 0x0025 }
        r4 = com.onesignal.aa.m1443a(r4, r0);	 Catch:{ Throwable -> 0x0025 }
        if (r4 == 0) goto L_0x0025;	 Catch:{ Throwable -> 0x0025 }
    L_0x001f:
        r0 = new java.math.BigInteger;	 Catch:{ Throwable -> 0x0025 }
        r0.<init>(r4, r1);	 Catch:{ Throwable -> 0x0025 }
        return r0;
    L_0x0025:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.s.b(org.json.JSONObject):java.math.BigInteger");
    }

    /* renamed from: b */
    private static void m1593b(Context context, JSONObject jSONObject, List<String> list, List<String> list2) {
        try {
            C0641s.m1599c(context, jSONObject, list, list2);
        } catch (Throwable th) {
            sa.m1657a(C0650i.ERROR, "Failed to parse JSON for custom buttons for alert dialog.", th);
        }
        if (list.size() == 0 || list.size() < 3) {
            list.add(aa.m1444a(context, "onesignal_in_app_alert_ok_button_text", "Ok"));
            list2.add("__DEFAULT__");
        }
    }

    /* renamed from: b */
    static void m1594b(C0588G c0588g) {
        C0641s.m1576a(c0588g.f1119a);
        C0641s.m1582a(c0588g, null);
    }

    /* renamed from: c */
    private static Intent m1595c(int i) {
        Intent putExtra = new Intent(f1310a, f1313d).putExtra("notificationId", i);
        return f1314e ? putExtra : putExtra.addFlags(603979776);
    }

    /* renamed from: c */
    private static Bitmap m1596c(String str) {
        try {
            return BitmapFactory.decodeStream(new URL(str).openConnection().getInputStream());
        } catch (Throwable th) {
            sa.m1657a(C0650i.WARN, "Could not download image!", th);
            return null;
        }
    }

    /* renamed from: c */
    private static Bitmap m1597c(JSONObject jSONObject) {
        Bitmap a = C0641s.m1573a(jSONObject.optString("licon"));
        if (a == null) {
            a = C0641s.m1591b("ic_onesignal_large_icon_default");
        }
        return a == null ? null : C0641s.m1572a(a);
    }

    /* renamed from: c */
    private static com.onesignal.C0641s.C0640a m1598c(com.onesignal.C0588G r12) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r0 = "vis";
        r1 = r12.f1120b;
        r2 = new com.onesignal.s$a;
        r3 = 0;
        r2.<init>();
        r4 = com.onesignal.C0586E.m1311a(r12);	 Catch:{ Throwable -> 0x0016 }
        r5 = new android.support.v4.app.NotificationCompat$Builder;	 Catch:{ Throwable -> 0x0016 }
        r6 = f1310a;	 Catch:{ Throwable -> 0x0016 }
        r5.<init>(r6, r4);	 Catch:{ Throwable -> 0x0016 }
        goto L_0x001d;
    L_0x0016:
        r5 = new android.support.v4.app.NotificationCompat$Builder;
        r4 = f1310a;
        r5.<init>(r4);
    L_0x001d:
        r4 = "alert";
        r4 = r1.optString(r4, r3);
        r6 = 1;
        r7 = r5.setAutoCancel(r6);
        r8 = com.onesignal.C0641s.m1602d(r1);
        r7 = r7.setSmallIcon(r8);
        r8 = new android.support.v4.app.NotificationCompat$BigTextStyle;
        r8.<init>();
        r8 = r8.bigText(r4);
        r7 = r7.setStyle(r8);
        r7 = r7.setContentText(r4);
        r7.setTicker(r4);
        r7 = android.os.Build.VERSION.SDK_INT;
        r8 = 24;
        if (r7 < r8) goto L_0x0058;
    L_0x004a:
        r7 = "title";
        r7 = r1.optString(r7);
        r8 = "";
        r7 = r7.equals(r8);
        if (r7 != 0) goto L_0x005f;
    L_0x0058:
        r7 = com.onesignal.C0641s.m1605e(r1);
        r5.setContentTitle(r7);
    L_0x005f:
        r7 = 0;
        r8 = f1310a;
        r8 = com.onesignal.sa.m1701e(r8);
        if (r8 == 0) goto L_0x0083;
    L_0x0068:
        r8 = "vib";
        r8 = r1.optInt(r8, r6);
        if (r8 != r6) goto L_0x0083;
    L_0x0070:
        r8 = "vib_pt";
        r8 = r1.has(r8);
        if (r8 == 0) goto L_0x0082;
    L_0x0078:
        r8 = com.onesignal.aa.m1449a(r1);
        if (r8 == 0) goto L_0x0083;
    L_0x007e:
        r5.setVibrate(r8);
        goto L_0x0083;
    L_0x0082:
        r7 = 2;
    L_0x0083:
        r8 = "ledc";
        r9 = r1.has(r8);
        if (r9 == 0) goto L_0x00aa;
    L_0x008b:
        r9 = "led";
        r9 = r1.optInt(r9, r6);
        if (r9 != r6) goto L_0x00aa;
    L_0x0093:
        r9 = new java.math.BigInteger;	 Catch:{ Throwable -> 0x00aa }
        r8 = r1.optString(r8);	 Catch:{ Throwable -> 0x00aa }
        r10 = 16;	 Catch:{ Throwable -> 0x00aa }
        r9.<init>(r8, r10);	 Catch:{ Throwable -> 0x00aa }
        r8 = r9.intValue();	 Catch:{ Throwable -> 0x00aa }
        r9 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;	 Catch:{ Throwable -> 0x00aa }
        r10 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;	 Catch:{ Throwable -> 0x00aa }
        r5.setLights(r8, r9, r10);	 Catch:{ Throwable -> 0x00aa }
        goto L_0x00ac;
    L_0x00aa:
        r7 = r7 | 4;
    L_0x00ac:
        r12 = r12.f1123e;
        if (r12 == 0) goto L_0x00bb;
    L_0x00b0:
        r8 = r12.longValue();	 Catch:{ Throwable -> 0x00bb }
        r10 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ Throwable -> 0x00bb }
        r8 = r8 * r10;	 Catch:{ Throwable -> 0x00bb }
        r5.setWhen(r8);	 Catch:{ Throwable -> 0x00bb }
    L_0x00bb:
        r12 = com.onesignal.C0641s.m1592b(r1);	 Catch:{ Throwable -> 0x00c8 }
        if (r12 == 0) goto L_0x00c8;	 Catch:{ Throwable -> 0x00c8 }
    L_0x00c1:
        r12 = r12.intValue();	 Catch:{ Throwable -> 0x00c8 }
        r5.setColor(r12);	 Catch:{ Throwable -> 0x00c8 }
    L_0x00c8:
        r12 = r1.has(r0);	 Catch:{ Throwable -> 0x00db }
        if (r12 == 0) goto L_0x00d7;	 Catch:{ Throwable -> 0x00db }
    L_0x00ce:
        r12 = r1.optString(r0);	 Catch:{ Throwable -> 0x00db }
        r12 = java.lang.Integer.parseInt(r12);	 Catch:{ Throwable -> 0x00db }
        goto L_0x00d8;	 Catch:{ Throwable -> 0x00db }
    L_0x00d7:
        r12 = 1;	 Catch:{ Throwable -> 0x00db }
    L_0x00d8:
        r5.setVisibility(r12);	 Catch:{ Throwable -> 0x00db }
    L_0x00db:
        r12 = com.onesignal.C0641s.m1597c(r1);
        if (r12 == 0) goto L_0x00e6;
    L_0x00e1:
        r2.f1309b = r6;
        r5.setLargeIcon(r12);
    L_0x00e6:
        r12 = "bicon";
        r12 = r1.optString(r12, r3);
        r12 = com.onesignal.C0641s.m1573a(r12);
        if (r12 == 0) goto L_0x0102;
    L_0x00f2:
        r0 = new android.support.v4.app.NotificationCompat$BigPictureStyle;
        r0.<init>();
        r12 = r0.bigPicture(r12);
        r12 = r12.setSummaryText(r4);
        r5.setStyle(r12);
    L_0x0102:
        r12 = com.onesignal.C0641s.m1606f(r1);
        if (r12 == 0) goto L_0x011c;
    L_0x0108:
        r12 = f1310a;
        r0 = "sound";
        r0 = r1.optString(r0, r3);
        r12 = com.onesignal.aa.m1451b(r12, r0);
        if (r12 == 0) goto L_0x011a;
    L_0x0116:
        r5.setSound(r12);
        goto L_0x011c;
    L_0x011a:
        r7 = r7 | 1;
    L_0x011c:
        r5.setDefaults(r7);
        r12 = 6;
        r0 = "pri";
        r12 = r1.optInt(r0, r12);
        r12 = com.onesignal.C0641s.m1600d(r12);
        r5.setPriority(r12);
        r2.f1308a = r5;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.s.c(com.onesignal.G):com.onesignal.s$a");
    }

    /* renamed from: c */
    private static void m1599c(Context context, JSONObject jSONObject, List<String> list, List<String> list2) {
        JSONObject jSONObject2 = new JSONObject(jSONObject.optString("custom"));
        String str = "a";
        if (jSONObject2.has(str)) {
            jSONObject2 = jSONObject2.getJSONObject(str);
            str = "actionButtons";
            if (jSONObject2.has(str)) {
                JSONArray optJSONArray = jSONObject2.optJSONArray(str);
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject3 = optJSONArray.getJSONObject(i);
                    list.add(jSONObject3.optString("text"));
                    list2.add(jSONObject3.optString("id"));
                }
            }
        }
    }

    /* renamed from: d */
    private static int m1600d(int i) {
        return i > 9 ? 2 : i > 7 ? 1 : i > 5 ? 0 : i > 3 ? -1 : -2;
    }

    /* renamed from: d */
    private static int m1601d(String str) {
        return f1312c.getIdentifier(str, "drawable", f1311b);
    }

    /* renamed from: d */
    private static int m1602d(JSONObject jSONObject) {
        int e = C0641s.m1604e(jSONObject.optString("sicon", null));
        return e != 0 ? e : C0641s.m1588b();
    }

    /* renamed from: d */
    private static void m1603d(com.onesignal.C0588G r10) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r0 = new java.util.Random;
        r0.<init>();
        r1 = r10.m1314a();
        r1 = r1.intValue();
        r2 = r10.f1120b;
        r3 = 0;
        r4 = "grp";
        r5 = r2.optString(r4, r3);
        r6 = com.onesignal.C0641s.m1598c(r10);
        r7 = r6.f1308a;
        com.onesignal.C0641s.m1587a(r2, r7, r1, r3);
        com.onesignal.C0641s.m1586a(r2, r7);	 Catch:{ Throwable -> 0x0023 }
        goto L_0x002b;
    L_0x0023:
        r3 = move-exception;
        r8 = com.onesignal.sa.C0650i.ERROR;
        r9 = "Could not set background notification image!";
        com.onesignal.sa.m1657a(r8, r9, r3);
    L_0x002b:
        com.onesignal.C0641s.m1581a(r10, r7);
        r3 = r10.f1121c;
        if (r3 == 0) goto L_0x0035;
    L_0x0032:
        com.onesignal.C0641s.m1578a(r7);
    L_0x0035:
        r3 = "onesignal_data";
        if (r5 == 0) goto L_0x0076;
    L_0x0039:
        r8 = r0.nextInt();
        r9 = com.onesignal.C0641s.m1595c(r1);
        r2 = r2.toString();
        r2 = r9.putExtra(r3, r2);
        r2 = r2.putExtra(r4, r5);
        r2 = com.onesignal.C0641s.m1568a(r8, r2);
        r7.setContentIntent(r2);
        r0 = r0.nextInt();
        r2 = com.onesignal.C0641s.m1590b(r1);
        r2 = r2.putExtra(r4, r5);
        r0 = com.onesignal.C0641s.m1568a(r0, r2);
        r7.setDeleteIntent(r0);
        r7.setGroup(r5);
        r0 = 1;
        r7.setGroupAlertBehavior(r0);	 Catch:{ Throwable -> 0x006e }
    L_0x006e:
        r0 = com.onesignal.C0641s.m1589b(r10, r7);
        com.onesignal.C0641s.m1582a(r10, r6);
        goto L_0x00a0;
    L_0x0076:
        r10 = r0.nextInt();
        r4 = com.onesignal.C0641s.m1595c(r1);
        r2 = r2.toString();
        r2 = r4.putExtra(r3, r2);
        r10 = com.onesignal.C0641s.m1568a(r10, r2);
        r7.setContentIntent(r10);
        r10 = r0.nextInt();
        r0 = com.onesignal.C0641s.m1590b(r1);
        r10 = com.onesignal.C0641s.m1568a(r10, r0);
        r7.setDeleteIntent(r10);
        r0 = r7.build();
    L_0x00a0:
        if (r5 == 0) goto L_0x00a8;
    L_0x00a2:
        r10 = android.os.Build.VERSION.SDK_INT;
        r2 = 17;
        if (r10 <= r2) goto L_0x00b4;
    L_0x00a8:
        com.onesignal.C0641s.m1583a(r6, r0);
        r10 = f1310a;
        r10 = android.support.v4.app.NotificationManagerCompat.from(r10);
        r10.notify(r1, r0);
    L_0x00b4:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.s.d(com.onesignal.G):void");
    }

    /* renamed from: e */
    private static int m1604e(java.lang.String r3) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r0 = 0;
        if (r3 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r3.trim();
        r2 = com.onesignal.aa.m1448a(r1);
        if (r2 != 0) goto L_0x000f;
    L_0x000e:
        return r0;
    L_0x000f:
        r1 = com.onesignal.C0641s.m1601d(r1);
        if (r1 == 0) goto L_0x0016;
    L_0x0015:
        return r1;
    L_0x0016:
        r1 = android.R.drawable.class;	 Catch:{ Throwable -> 0x0022 }
        r3 = r1.getField(r3);	 Catch:{ Throwable -> 0x0022 }
        r1 = 0;	 Catch:{ Throwable -> 0x0022 }
        r3 = r3.getInt(r1);	 Catch:{ Throwable -> 0x0022 }
        return r3;
    L_0x0022:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.s.e(java.lang.String):int");
    }

    /* renamed from: e */
    private static CharSequence m1605e(JSONObject jSONObject) {
        CharSequence optString = jSONObject.optString("title", null);
        return optString != null ? optString : f1310a.getPackageManager().getApplicationLabel(f1310a.getApplicationInfo());
    }

    /* renamed from: f */
    private static boolean m1606f(JSONObject jSONObject) {
        String optString = jSONObject.optString("sound", null);
        if (!"null".equals(optString)) {
            if (!"nil".equals(optString)) {
                return sa.m1696d(f1310a);
            }
        }
        return false;
    }
}
