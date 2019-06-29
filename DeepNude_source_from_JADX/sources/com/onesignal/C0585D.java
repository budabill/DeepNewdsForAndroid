package com.onesignal;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.onesignal.C0606S.C0604a;
import com.onesignal.C0606S.C0605b;
import com.onesignal.C0872F.C0587a;
import com.onesignal.sa.C0650i;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.onesignal.D */
class C0585D {

    /* renamed from: com.onesignal.D$a */
    static class C0584a {
        /* renamed from: a */
        boolean f1102a;
        /* renamed from: b */
        boolean f1103b;
        /* renamed from: c */
        boolean f1104c;

        C0584a() {
        }

        /* renamed from: a */
        boolean m1288a() {
            if (this.f1102a && !this.f1103b) {
                if (!this.f1104c) {
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: a */
    static int m1289a(com.onesignal.C0588G r4) {
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
        r0 = com.onesignal.sa.m1737t();
        r1 = 1;
        r2 = 0;
        if (r0 == 0) goto L_0x0010;
    L_0x0008:
        r0 = com.onesignal.sa.m1619D();
        if (r0 == 0) goto L_0x0010;
    L_0x000e:
        r0 = 1;
        goto L_0x0011;
    L_0x0010:
        r0 = 0;
    L_0x0011:
        r4.f1122d = r0;
        com.onesignal.C0585D.m1304b(r4);
        r0 = r4.m1319e();
        if (r0 != 0) goto L_0x002d;
    L_0x001c:
        r0 = r4.f1120b;
        r3 = "alert";
        r0 = r0.optString(r3);
        r0 = com.onesignal.C0585D.m1301a(r0);
        if (r0 == 0) goto L_0x002b;
    L_0x002a:
        goto L_0x002d;
    L_0x002b:
        r0 = 0;
        goto L_0x002e;
    L_0x002d:
        r0 = 1;
    L_0x002e:
        if (r0 == 0) goto L_0x0033;
    L_0x0030:
        com.onesignal.C0641s.m1580a(r4);
    L_0x0033:
        r0 = r4.f1121c;
        if (r0 != 0) goto L_0x0057;
    L_0x0037:
        com.onesignal.C0585D.m1296a(r4, r2);
        r0 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0057 }
        r2 = r4.f1120b;	 Catch:{ Throwable -> 0x0057 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x0057 }
        r0.<init>(r2);	 Catch:{ Throwable -> 0x0057 }
        r2 = "notificationId";	 Catch:{ Throwable -> 0x0057 }
        r3 = r4.m1314a();	 Catch:{ Throwable -> 0x0057 }
        r0.put(r2, r3);	 Catch:{ Throwable -> 0x0057 }
        r0 = com.onesignal.C0585D.m1302b(r0);	 Catch:{ Throwable -> 0x0057 }
        r2 = r4.f1122d;	 Catch:{ Throwable -> 0x0057 }
        com.onesignal.sa.m1666a(r0, r1, r2);	 Catch:{ Throwable -> 0x0057 }
    L_0x0057:
        r4 = r4.m1314a();
        r4 = r4.intValue();
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.D.a(com.onesignal.G):int");
    }

    /* renamed from: a */
    static C0584a m1290a(Context context, Bundle bundle) {
        C0584a c0584a = new C0584a();
        if (sa.m1644a(bundle) == null) {
            return c0584a;
        }
        c0584a.f1102a = true;
        C0585D.m1307e(bundle);
        if (C0585D.m1299a(context, bundle, c0584a)) {
            return c0584a;
        }
        c0584a.f1104c = sa.m1668a(context, C0585D.m1303b(bundle));
        if (!(c0584a.f1104c || C0585D.m1301a(bundle.getString("alert")))) {
            C0585D.m1293a(context, bundle, true, -1);
            new Thread(new C0583C(bundle), "OS_PROC_BUNDLE").start();
        }
        return c0584a;
    }

    /* renamed from: a */
    static C0606S m1291a(JSONObject jSONObject) {
        C0606S c0606s = new C0606S();
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("custom"));
            c0606s.f1186a = jSONObject2.optString("i");
            c0606s.f1188c = jSONObject2.optString("ti");
            c0606s.f1187b = jSONObject2.optString("tn");
            c0606s.f1207v = jSONObject.toString();
            c0606s.f1191f = jSONObject2.optJSONObject("a");
            c0606s.f1196k = jSONObject2.optString("u", null);
            c0606s.f1190e = jSONObject.optString("alert", null);
            c0606s.f1189d = jSONObject.optString("title", null);
            c0606s.f1192g = jSONObject.optString("sicon", null);
            c0606s.f1194i = jSONObject.optString("bicon", null);
            c0606s.f1193h = jSONObject.optString("licon", null);
            c0606s.f1197l = jSONObject.optString("sound", null);
            c0606s.f1200o = jSONObject.optString("grp", null);
            c0606s.f1201p = jSONObject.optString("grp_msg", null);
            c0606s.f1195j = jSONObject.optString("bgac", null);
            c0606s.f1198m = jSONObject.optString("ledc", null);
            String optString = jSONObject.optString("vis", null);
            if (optString != null) {
                c0606s.f1199n = Integer.parseInt(optString);
            }
            c0606s.f1203r = jSONObject.optString("from", null);
            c0606s.f1206u = jSONObject.optInt("pri", 0);
            optString = jSONObject.optString("collapse_key", null);
            if (!"do_not_collapse".equals(optString)) {
                c0606s.f1205t = optString;
            }
            C0585D.m1297a(c0606s);
        } catch (Throwable th) {
            sa.m1657a(C0650i.ERROR, "Error assigning OSNotificationPayload values!", th);
        }
        try {
            C0585D.m1298a(c0606s, jSONObject);
        } catch (Throwable th2) {
            sa.m1657a(C0650i.ERROR, "Error assigning OSNotificationPayload.backgroundImageLayout values!", th2);
        }
        return c0606s;
    }

    /* renamed from: a */
    private static void m1293a(Context context, Bundle bundle, boolean z, int i) {
        C0588G c0588g = new C0588G(context);
        c0588g.f1120b = C0585D.m1303b(bundle);
        c0588g.f1130l = new C0587a();
        c0588g.f1130l.f1114b = Integer.valueOf(i);
        C0585D.m1296a(c0588g, z);
    }

    /* renamed from: a */
    static void m1294a(Context context, C0632k c0632k, C0587a c0587a) {
        String str = "android_notif_id";
        try {
            String string = c0632k.getString("json_payload");
            if (string == null) {
                C0650i c0650i = C0650i.ERROR;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("json_payload key is nonexistent from mBundle passed to ProcessFromGCMIntentService: ");
                stringBuilder.append(c0632k);
                sa.m1656a(c0650i, stringBuilder.toString());
                return;
            }
            C0588G c0588g = new C0588G(context);
            c0588g.f1121c = c0632k.getBoolean("restoring", false);
            c0588g.f1123e = c0632k.getLong("timestamp");
            c0588g.f1120b = new JSONObject(string);
            if (c0588g.f1121c || !sa.m1668a(context, c0588g.f1120b)) {
                if (c0632k.mo1386a(str)) {
                    if (c0587a == null) {
                        c0587a = new C0587a();
                    }
                    c0587a.f1114b = c0632k.getInt(str);
                }
                c0588g.f1130l = c0587a;
                C0585D.m1289a(c0588g);
                if (c0588g.f1121c) {
                    aa.m1445a(100);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    static void m1295a(SQLiteDatabase sQLiteDatabase) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("created_time < ");
        stringBuilder.append((System.currentTimeMillis() / 1000) - 604800);
        sQLiteDatabase.delete("notification", stringBuilder.toString(), null);
    }

    /* renamed from: a */
    static void m1296a(C0588G c0588g, boolean z) {
        Throwable th;
        C0650i c0650i;
        String str = "grp";
        String str2 = "collapse_key";
        String str3 = "Error closing transaction! ";
        Context context = c0588g.f1119a;
        JSONObject jSONObject = c0588g.f1120b;
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("custom"));
            SQLiteDatabase sQLiteDatabase = null;
            try {
                SQLiteDatabase b = va.m1748a(c0588g.f1119a).m1751b();
                try {
                    b.beginTransaction();
                    C0585D.m1295a(b);
                    String str4 = "notification";
                    int i = 1;
                    if (c0588g.m1316b() != -1) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("android_notification_id = ");
                        stringBuilder.append(c0588g.m1316b());
                        String stringBuilder2 = stringBuilder.toString();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("dismissed", Integer.valueOf(1));
                        b.update(str4, contentValues, stringBuilder2, null);
                        C0631j.m1523a(b, context);
                    }
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("notification_id", jSONObject2.optString("i"));
                    if (jSONObject.has(str)) {
                        contentValues2.put("group_id", jSONObject.optString(str));
                    }
                    if (jSONObject.has(str2) && !"do_not_collapse".equals(jSONObject.optString(str2))) {
                        contentValues2.put("collapse_id", jSONObject.optString(str2));
                    }
                    str = "opened";
                    if (!z) {
                        i = 0;
                    }
                    contentValues2.put(str, Integer.valueOf(i));
                    if (!z) {
                        contentValues2.put("android_notification_id", Integer.valueOf(c0588g.m1316b()));
                    }
                    if (c0588g.m1318d() != null) {
                        contentValues2.put("title", c0588g.m1318d().toString());
                    }
                    if (c0588g.m1317c() != null) {
                        contentValues2.put("message", c0588g.m1317c().toString());
                    }
                    contentValues2.put("full_data", jSONObject.toString());
                    b.insertOrThrow(str4, null, contentValues2);
                    if (!z) {
                        C0631j.m1523a(b, context);
                    }
                    b.setTransactionSuccessful();
                    if (b != null) {
                        try {
                            b.endTransaction();
                        } catch (Throwable th2) {
                            th = th2;
                            c0650i = C0650i.ERROR;
                            sa.m1657a(c0650i, str3, th);
                        }
                    }
                } catch (Exception e) {
                    th = e;
                    sQLiteDatabase = b;
                    try {
                        sa.m1657a(C0650i.ERROR, "Error saving notification record! ", th);
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                            } catch (Throwable th3) {
                                th = th3;
                                c0650i = C0650i.ERROR;
                                sa.m1657a(c0650i, str3, th);
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        b = sQLiteDatabase;
                        if (b != null) {
                            try {
                                b.endTransaction();
                            } catch (Throwable th5) {
                                sa.m1657a(C0650i.ERROR, str3, th5);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (b != null) {
                        b.endTransaction();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                th = e2;
                sa.m1657a(C0650i.ERROR, "Error saving notification record! ", th);
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    /* renamed from: a */
    private static void m1297a(C0606S c0606s) {
        JSONObject jSONObject = c0606s.f1191f;
        if (jSONObject != null) {
            String str = "actionButtons";
            if (jSONObject.has(str)) {
                JSONArray jSONArray = c0606s.f1191f.getJSONArray(str);
                c0606s.f1202q = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    C0604a c0604a = new C0604a();
                    c0604a.f1180a = jSONObject2.optString("id", null);
                    c0604a.f1181b = jSONObject2.optString("text", null);
                    c0604a.f1182c = jSONObject2.optString("icon", null);
                    c0606s.f1202q.add(c0604a);
                }
                c0606s.f1191f.remove("actionSelected");
                c0606s.f1191f.remove(str);
            }
        }
    }

    /* renamed from: a */
    private static void m1298a(C0606S c0606s, JSONObject jSONObject) {
        String optString = jSONObject.optString("bg_img", null);
        if (optString != null) {
            JSONObject jSONObject2 = new JSONObject(optString);
            c0606s.f1204s = new C0605b();
            c0606s.f1204s.f1183a = jSONObject2.optString("img");
            c0606s.f1204s.f1184b = jSONObject2.optString("tc");
            c0606s.f1204s.f1185c = jSONObject2.optString("bc");
        }
    }

    /* renamed from: a */
    private static boolean m1299a(Context context, Bundle bundle, C0584a c0584a) {
        Intent a = C0872F.m2228a(context);
        if (a == null) {
            return false;
        }
        a.putExtra("json_payload", C0585D.m1303b(bundle).toString());
        a.putExtra("timestamp", System.currentTimeMillis() / 1000);
        if (VERSION.SDK_INT >= 21) {
            JobIntentService.m1376a(context, a.getComponent(), 2071862121, a);
        } else {
            context.startService(a);
        }
        c0584a.f1103b = true;
        return true;
    }

    /* renamed from: a */
    private static boolean m1300a(Bundle bundle, String str) {
        String trim = bundle.getString(str, "").trim();
        if (!trim.startsWith("http://")) {
            if (!trim.startsWith("https://")) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    static boolean m1301a(String str) {
        Object obj = (str == null || "".equals(str)) ? null : 1;
        boolean t = sa.m1737t();
        boolean D = sa.m1619D();
        if (obj != null) {
            if (sa.m1738u() || t) {
                return true;
            }
            if (!D) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    static JSONArray m1302b(JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject);
        return jSONArray;
    }

    /* renamed from: b */
    static JSONObject m1303b(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            try {
                jSONObject.put(str, bundle.get(str));
            } catch (Throwable e) {
                C0650i c0650i = C0650i.ERROR;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("bundleAsJSONObject error for key: ");
                stringBuilder.append(str);
                sa.m1657a(c0650i, stringBuilder.toString(), e);
            }
        }
        return jSONObject;
    }

    /* renamed from: b */
    private static void m1304b(C0588G c0588g) {
        String str = "android_notification_id";
        if (!c0588g.f1121c) {
            String str2 = "collapse_key";
            if (c0588g.f1120b.has(str2)) {
                if (!"do_not_collapse".equals(c0588g.f1120b.optString(str2))) {
                    String optString = c0588g.f1120b.optString(str2);
                    Cursor cursor = null;
                    try {
                        cursor = va.m1748a(c0588g.f1119a).m1750a().query("notification", new String[]{str}, "collapse_id = ? AND dismissed = 0 AND opened = 0 ", new String[]{optString}, null, null, null);
                        if (cursor.moveToFirst()) {
                            c0588g.m1315a(Integer.valueOf(cursor.getInt(cursor.getColumnIndex(str))));
                        }
                        if (!(cursor == null || cursor.isClosed())) {
                        }
                    } catch (Throwable th) {
                        sa.m1657a(C0650i.ERROR, "Could not read DB to find existing collapse_key!", th);
                    } finally {
                        if (!(cursor == null || cursor.isClosed())) {
                            cursor.close();
                        }
                    }
                }
            }
        }
    }

    /* renamed from: c */
    static boolean m1305c(Bundle bundle) {
        if (!(C0585D.m1300a(bundle, "licon") || C0585D.m1300a(bundle, "bicon"))) {
            if (bundle.getString("bg_img", null) == null) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    private static JSONArray m1306d(Bundle bundle) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(C0585D.m1303b(bundle));
        return jSONArray;
    }

    /* renamed from: e */
    private static void m1307e(Bundle bundle) {
        String str = "n";
        String str2 = "custom";
        String str3 = "p";
        String str4 = "i";
        String str5 = "a";
        String str6 = "o";
        if (bundle.containsKey(str6)) {
            try {
                JSONObject jSONObject = new JSONObject(bundle.getString(str2));
                JSONObject jSONObject2 = jSONObject.has(str5) ? jSONObject.getJSONObject(str5) : new JSONObject();
                JSONArray jSONArray = new JSONArray(bundle.getString(str6));
                bundle.remove(str6);
                for (int i = 0; i < jSONArray.length(); i++) {
                    Object string;
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                    String string2 = jSONObject3.getString(str);
                    jSONObject3.remove(str);
                    if (jSONObject3.has(str4)) {
                        string = jSONObject3.getString(str4);
                        jSONObject3.remove(str4);
                    } else {
                        string = string2;
                    }
                    jSONObject3.put("id", string);
                    jSONObject3.put("text", string2);
                    if (jSONObject3.has(str3)) {
                        jSONObject3.put("icon", jSONObject3.getString(str3));
                        jSONObject3.remove(str3);
                    }
                }
                jSONObject2.put("actionButtons", jSONArray);
                jSONObject2.put("actionSelected", "__DEFAULT__");
                if (!jSONObject.has(str5)) {
                    jSONObject.put(str5, jSONObject2);
                }
                bundle.putString(str2, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
