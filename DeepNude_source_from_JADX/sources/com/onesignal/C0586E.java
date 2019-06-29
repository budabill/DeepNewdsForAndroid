package com.onesignal;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import com.onesignal.sa.C0650i;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.onesignal.E */
class C0586E {
    /* renamed from: a */
    private static int m1308a(int i) {
        return i > 9 ? 5 : i > 7 ? 4 : i > 5 ? 3 : i > 3 ? 2 : i > 1 ? 1 : 0;
    }

    /* renamed from: a */
    private static String m1309a(NotificationManager notificationManager) {
        String str = "fcm_fallback_notification_channel";
        NotificationChannel notificationChannel = new NotificationChannel(str, "Miscellaneous", 3);
        notificationChannel.enableLights(true);
        notificationChannel.enableVibration(true);
        notificationManager.createNotificationChannel(notificationChannel);
        return str;
    }

    /* renamed from: a */
    private static String m1310a(Context context, NotificationManager notificationManager, JSONObject jSONObject) {
        JSONObject jSONObject2;
        NotificationChannel notificationChannel;
        String str;
        String optString;
        boolean z;
        long[] a;
        Uri b;
        Object opt = jSONObject.opt("chnl");
        JSONObject jSONObject3 = opt instanceof String ? new JSONObject((String) opt) : (JSONObject) opt;
        String str2 = "fcm_fallback_notification_channel";
        String optString2 = jSONObject3.optString("id", str2);
        if (!optString2.equals("miscellaneous")) {
            str2 = optString2;
        }
        optString2 = "langs";
        if (jSONObject3.has(optString2)) {
            jSONObject2 = jSONObject3.getJSONObject(optString2);
            String c = aa.m1453c();
            if (jSONObject2.has(c)) {
                jSONObject2 = jSONObject2.optJSONObject(c);
                notificationChannel = new NotificationChannel(str2, jSONObject2.optString("nm", "Miscellaneous"), C0586E.m1308a(jSONObject.optInt("pri", 6)));
                notificationChannel.setDescription(jSONObject2.optString("dscr", null));
                str = "grp_id";
                if (jSONObject3.has(str)) {
                    optString = jSONObject3.optString(str);
                    notificationManager.createNotificationChannelGroup(new NotificationChannelGroup(optString, jSONObject2.optString("grp_nm")));
                    notificationChannel.setGroup(optString);
                }
                optString = "ledc";
                if (jSONObject.has(optString)) {
                    notificationChannel.setLightColor(new BigInteger(jSONObject.optString(optString), 16).intValue());
                }
                z = true;
                notificationChannel.enableLights(jSONObject.optInt("led", 1) != 1);
                if (jSONObject.has("vib_pt")) {
                    a = aa.m1449a(jSONObject);
                    if (a != null) {
                        notificationChannel.setVibrationPattern(a);
                    }
                }
                notificationChannel.enableVibration(jSONObject.optInt("vib", 1) != 1);
                optString2 = "sound";
                if (jSONObject.has(optString2)) {
                    optString2 = jSONObject.optString(optString2, null);
                    b = aa.m1451b(context, optString2);
                    if (b == null) {
                        notificationChannel.setSound(b, null);
                    } else if ("null".equals(optString2) || "nil".equals(optString2)) {
                        notificationChannel.setSound(null, null);
                    }
                }
                notificationChannel.setLockscreenVisibility(jSONObject.optInt("vis", 0));
                notificationChannel.setShowBadge(jSONObject.optInt("bdg", 1) != 1);
                if (jSONObject.optInt("bdnd", 0) == 1) {
                    z = false;
                }
                notificationChannel.setBypassDnd(z);
                notificationManager.createNotificationChannel(notificationChannel);
                return str2;
            }
        }
        jSONObject2 = jSONObject3;
        notificationChannel = new NotificationChannel(str2, jSONObject2.optString("nm", "Miscellaneous"), C0586E.m1308a(jSONObject.optInt("pri", 6)));
        notificationChannel.setDescription(jSONObject2.optString("dscr", null));
        str = "grp_id";
        if (jSONObject3.has(str)) {
            optString = jSONObject3.optString(str);
            notificationManager.createNotificationChannelGroup(new NotificationChannelGroup(optString, jSONObject2.optString("grp_nm")));
            notificationChannel.setGroup(optString);
        }
        optString = "ledc";
        if (jSONObject.has(optString)) {
            notificationChannel.setLightColor(new BigInteger(jSONObject.optString(optString), 16).intValue());
        }
        z = true;
        if (jSONObject.optInt("led", 1) != 1) {
        }
        notificationChannel.enableLights(jSONObject.optInt("led", 1) != 1);
        if (jSONObject.has("vib_pt")) {
            a = aa.m1449a(jSONObject);
            if (a != null) {
                notificationChannel.setVibrationPattern(a);
            }
        }
        if (jSONObject.optInt("vib", 1) != 1) {
        }
        notificationChannel.enableVibration(jSONObject.optInt("vib", 1) != 1);
        optString2 = "sound";
        if (jSONObject.has(optString2)) {
            optString2 = jSONObject.optString(optString2, null);
            b = aa.m1451b(context, optString2);
            if (b == null) {
                notificationChannel.setSound(null, null);
            } else {
                notificationChannel.setSound(b, null);
            }
        }
        notificationChannel.setLockscreenVisibility(jSONObject.optInt("vis", 0));
        if (jSONObject.optInt("bdg", 1) != 1) {
        }
        notificationChannel.setShowBadge(jSONObject.optInt("bdg", 1) != 1);
        if (jSONObject.optInt("bdnd", 0) == 1) {
            z = false;
        }
        notificationChannel.setBypassDnd(z);
        notificationManager.createNotificationChannel(notificationChannel);
        return str2;
    }

    /* renamed from: a */
    static String m1311a(C0588G c0588g) {
        String str = "fcm_fallback_notification_channel";
        if (VERSION.SDK_INT < 26) {
            return str;
        }
        Context context = c0588g.f1119a;
        JSONObject jSONObject = c0588g.f1120b;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (c0588g.f1121c) {
            return C0586E.m1313b(notificationManager);
        }
        String str2 = "oth_chnl";
        if (jSONObject.has(str2)) {
            str2 = jSONObject.optString(str2);
            if (notificationManager.getNotificationChannel(str2) != null) {
                return str2;
            }
        }
        if (!jSONObject.has("chnl")) {
            return C0586E.m1309a(notificationManager);
        }
        try {
            return C0586E.m1310a(context, notificationManager, jSONObject);
        } catch (Throwable e) {
            sa.m1657a(C0650i.ERROR, "Could not create notification channel due to JSON payload error!", e);
            return str;
        }
    }

    /* renamed from: a */
    static void m1312a(Context context, JSONObject jSONObject) {
        if (VERSION.SDK_INT >= 26) {
            String str = "chnl_lst";
            if (jSONObject.has(str)) {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                Set hashSet = new HashSet();
                JSONArray optJSONArray = jSONObject.optJSONArray(str);
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    try {
                        hashSet.add(C0586E.m1310a(context, notificationManager, optJSONArray.getJSONObject(i)));
                    } catch (Throwable e) {
                        sa.m1657a(C0650i.ERROR, "Could not create notification channel due to JSON payload error!", e);
                    }
                }
                for (NotificationChannel id : notificationManager.getNotificationChannels()) {
                    String id2 = id.getId();
                    if (id2.startsWith("OS_") && !hashSet.contains(id2)) {
                        notificationManager.deleteNotificationChannel(id2);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private static String m1313b(NotificationManager notificationManager) {
        String str = "restored_OS_notifications";
        notificationManager.createNotificationChannel(new NotificationChannel(str, "Restored", 2));
        return str;
    }
}
