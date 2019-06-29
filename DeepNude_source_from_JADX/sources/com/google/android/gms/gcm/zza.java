package com.google.android.gms.gcm;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.C0562R;
import com.google.android.gms.common.util.zzs;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class zza {
    static zza zzijk;
    private final Context mContext;
    private String zzijl;
    private final AtomicInteger zzijm = new AtomicInteger((int) SystemClock.elapsedRealtime());

    private zza(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private final android.os.Bundle zzawf() {
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
        r3 = this;
        r0 = r3.mContext;	 Catch:{ NameNotFoundException -> 0x0013 }
        r0 = r0.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0013 }
        r1 = r3.mContext;	 Catch:{ NameNotFoundException -> 0x0013 }
        r1 = r1.getPackageName();	 Catch:{ NameNotFoundException -> 0x0013 }
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ NameNotFoundException -> 0x0013 }
        r0 = r0.getApplicationInfo(r1, r2);	 Catch:{ NameNotFoundException -> 0x0013 }
        goto L_0x0014;
    L_0x0013:
        r0 = 0;
    L_0x0014:
        if (r0 == 0) goto L_0x001d;
    L_0x0016:
        r1 = r0.metaData;
        if (r1 == 0) goto L_0x001d;
    L_0x001a:
        r0 = r0.metaData;
        return r0;
    L_0x001d:
        r0 = android.os.Bundle.EMPTY;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.gcm.zza.zzawf():android.os.Bundle");
    }

    static String zzd(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    static synchronized zza zzdl(Context context) {
        zza zza;
        synchronized (zza.class) {
            if (zzijk == null) {
                zzijk = new zza(context);
            }
            zza = zzijk;
        }
        return zza;
    }

    static boolean zzdm(Context context) {
        if (((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        int myPid = Process.myPid();
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    if (runningAppProcessInfo.importance == 100) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final java.lang.String zze(android.os.Bundle r14, java.lang.String r15) {
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
        r13 = this;
        r0 = ": ";
        r1 = zzd(r14, r15);
        r2 = android.text.TextUtils.isEmpty(r1);
        if (r2 != 0) goto L_0x000d;
    L_0x000c:
        return r1;
    L_0x000d:
        r1 = java.lang.String.valueOf(r15);
        r2 = "_loc_key";
        r3 = r2.length();
        if (r3 == 0) goto L_0x001e;
    L_0x0019:
        r1 = r1.concat(r2);
        goto L_0x0024;
    L_0x001e:
        r3 = new java.lang.String;
        r3.<init>(r1);
        r1 = r3;
    L_0x0024:
        r1 = zzd(r14, r1);
        r3 = android.text.TextUtils.isEmpty(r1);
        r4 = 0;
        if (r3 == 0) goto L_0x0030;
    L_0x002f:
        return r4;
    L_0x0030:
        r3 = r13.mContext;
        r3 = r3.getResources();
        r5 = r13.mContext;
        r5 = r5.getPackageName();
        r6 = "string";
        r5 = r3.getIdentifier(r1, r6, r5);
        r6 = " Default value will be used.";
        r7 = 6;
        r8 = "GcmNotification";
        if (r5 != 0) goto L_0x0090;
    L_0x0049:
        r14 = java.lang.String.valueOf(r15);
        r15 = r2.length();
        if (r15 == 0) goto L_0x0058;
    L_0x0053:
        r14 = r14.concat(r2);
        goto L_0x005e;
    L_0x0058:
        r15 = new java.lang.String;
        r15.<init>(r14);
        r14 = r15;
    L_0x005e:
        r14 = r14.substring(r7);
        r15 = java.lang.String.valueOf(r14);
        r15 = r15.length();
        r15 = r15 + 49;
        r0 = java.lang.String.valueOf(r1);
        r0 = r0.length();
        r15 = r15 + r0;
        r0 = new java.lang.StringBuilder;
        r0.<init>(r15);
        r0.append(r14);
        r14 = " resource not found: ";
        r0.append(r14);
        r0.append(r1);
        r0.append(r6);
        r14 = r0.toString();
        android.util.Log.w(r8, r14);
        return r4;
    L_0x0090:
        r2 = java.lang.String.valueOf(r15);
        r9 = "_loc_args";
        r10 = r9.length();
        if (r10 == 0) goto L_0x00a1;
    L_0x009c:
        r2 = r2.concat(r9);
        goto L_0x00a7;
    L_0x00a1:
        r10 = new java.lang.String;
        r10.<init>(r2);
        r2 = r10;
    L_0x00a7:
        r14 = zzd(r14, r2);
        r2 = android.text.TextUtils.isEmpty(r14);
        if (r2 == 0) goto L_0x00b6;
    L_0x00b1:
        r14 = r3.getString(r5);
        return r14;
    L_0x00b6:
        r2 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x0105, MissingFormatArgumentException -> 0x00d3 }
        r2.<init>(r14);	 Catch:{ JSONException -> 0x0105, MissingFormatArgumentException -> 0x00d3 }
        r10 = r2.length();	 Catch:{ JSONException -> 0x0105, MissingFormatArgumentException -> 0x00d3 }
        r10 = new java.lang.String[r10];	 Catch:{ JSONException -> 0x0105, MissingFormatArgumentException -> 0x00d3 }
        r11 = 0;	 Catch:{ JSONException -> 0x0105, MissingFormatArgumentException -> 0x00d3 }
    L_0x00c2:
        r12 = r10.length;	 Catch:{ JSONException -> 0x0105, MissingFormatArgumentException -> 0x00d3 }
        if (r11 >= r12) goto L_0x00ce;	 Catch:{ JSONException -> 0x0105, MissingFormatArgumentException -> 0x00d3 }
    L_0x00c5:
        r12 = r2.opt(r11);	 Catch:{ JSONException -> 0x0105, MissingFormatArgumentException -> 0x00d3 }
        r10[r11] = r12;	 Catch:{ JSONException -> 0x0105, MissingFormatArgumentException -> 0x00d3 }
        r11 = r11 + 1;	 Catch:{ JSONException -> 0x0105, MissingFormatArgumentException -> 0x00d3 }
        goto L_0x00c2;	 Catch:{ JSONException -> 0x0105, MissingFormatArgumentException -> 0x00d3 }
    L_0x00ce:
        r14 = r3.getString(r5, r10);	 Catch:{ JSONException -> 0x0105, MissingFormatArgumentException -> 0x00d3 }
        return r14;
    L_0x00d3:
        r15 = move-exception;
        r2 = java.lang.String.valueOf(r1);
        r2 = r2.length();
        r2 = r2 + 58;
        r3 = java.lang.String.valueOf(r14);
        r3 = r3.length();
        r2 = r2 + r3;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "Missing format argument for ";
        r3.append(r2);
        r3.append(r1);
        r3.append(r0);
        r3.append(r14);
        r3.append(r6);
        r14 = r3.toString();
        android.util.Log.w(r8, r14, r15);
        goto L_0x0151;
        r15 = java.lang.String.valueOf(r15);
        r1 = r9.length();
        if (r1 == 0) goto L_0x0115;
    L_0x0110:
        r15 = r15.concat(r9);
        goto L_0x011b;
    L_0x0115:
        r1 = new java.lang.String;
        r1.<init>(r15);
        r15 = r1;
    L_0x011b:
        r15 = r15.substring(r7);
        r1 = java.lang.String.valueOf(r15);
        r1 = r1.length();
        r1 = r1 + 41;
        r2 = java.lang.String.valueOf(r14);
        r2 = r2.length();
        r1 = r1 + r2;
        r2 = new java.lang.StringBuilder;
        r2.<init>(r1);
        r1 = "Malformed ";
        r2.append(r1);
        r2.append(r15);
        r2.append(r0);
        r2.append(r14);
        r14 = "  Default value will be used.";
        r2.append(r14);
        r14 = r2.toString();
        android.util.Log.w(r8, r14);
    L_0x0151:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.gcm.zza.zze(android.os.Bundle, java.lang.String):java.lang.String");
    }

    static void zzs(Bundle bundle) {
        String str;
        Bundle bundle2 = new Bundle();
        Iterator it = bundle.keySet().iterator();
        while (it.hasNext()) {
            str = (String) it.next();
            String string = bundle.getString(str);
            CharSequence charSequence = "gcm.notification.";
            Object obj = "gcm.n.";
            if (str.startsWith(charSequence)) {
                str = str.replace(charSequence, obj);
            }
            if (str.startsWith(obj)) {
                if (!"gcm.n.e".equals(str)) {
                    bundle2.putString(str.substring(6), string);
                }
                it.remove();
            }
        }
        String str2 = "sound2";
        str = bundle2.getString(str2);
        if (str != null) {
            bundle2.remove(str2);
            bundle2.putString("sound", str);
        }
        if (!bundle2.isEmpty()) {
            bundle.putBundle("notification", bundle2);
        }
    }

    private final PendingIntent zzu(Bundle bundle) {
        Intent launchIntentForPackage;
        Object zzd = zzd(bundle, "gcm.n.click_action");
        if (TextUtils.isEmpty(zzd)) {
            launchIntentForPackage = this.mContext.getPackageManager().getLaunchIntentForPackage(this.mContext.getPackageName());
            if (launchIntentForPackage == null) {
                Log.w("GcmNotification", "No activity found to launch app");
                return null;
            }
        }
        launchIntentForPackage = new Intent(zzd);
        launchIntentForPackage.setPackage(this.mContext.getPackageName());
        launchIntentForPackage.setFlags(268435456);
        Bundle bundle2 = new Bundle(bundle);
        GcmListenerService.zzr(bundle2);
        launchIntentForPackage.putExtras(bundle2);
        for (String str : bundle2.keySet()) {
            if (str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
                launchIntentForPackage.removeExtra(str);
            }
        }
        return PendingIntent.getActivity(this.mContext, this.zzijm.getAndIncrement(), launchIntentForPackage, 1073741824);
    }

    final boolean zzt(Bundle bundle) {
        int identifier;
        Object zzd;
        String zzd2;
        String str;
        Uri parse;
        PendingIntent zzu;
        Builder smallIcon;
        Notification build;
        String zzd3;
        NotificationManager notificationManager;
        CharSequence zze = zze(bundle, "gcm.n.title");
        if (TextUtils.isEmpty(zze)) {
            zze = this.mContext.getApplicationInfo().loadLabel(this.mContext.getPackageManager());
        }
        CharSequence zze2 = zze(bundle, "gcm.n.body");
        String zzd4 = zzd(bundle, "gcm.n.icon");
        String str2 = "GcmNotification";
        if (!TextUtils.isEmpty(zzd4)) {
            Resources resources = this.mContext.getResources();
            identifier = resources.getIdentifier(zzd4, "drawable", this.mContext.getPackageName());
            if (identifier == 0) {
                identifier = resources.getIdentifier(zzd4, "mipmap", this.mContext.getPackageName());
                if (identifier == 0) {
                    StringBuilder stringBuilder = new StringBuilder(String.valueOf(zzd4).length() + 57);
                    stringBuilder.append("Icon resource ");
                    stringBuilder.append(zzd4);
                    stringBuilder.append(" not found. Notification will use app icon.");
                    Log.w(str2, stringBuilder.toString());
                }
            }
            zzd = zzd(bundle, "gcm.n.color");
            zzd2 = zzd(bundle, "gcm.n.sound2");
            str = null;
            if (TextUtils.isEmpty(zzd2)) {
                if (!"default".equals(zzd2)) {
                    if (this.mContext.getResources().getIdentifier(zzd2, "raw", this.mContext.getPackageName()) != 0) {
                        String packageName = this.mContext.getPackageName();
                        StringBuilder stringBuilder2 = new StringBuilder((String.valueOf(packageName).length() + 24) + String.valueOf(zzd2).length());
                        stringBuilder2.append("android.resource://");
                        stringBuilder2.append(packageName);
                        stringBuilder2.append("/raw/");
                        stringBuilder2.append(zzd2);
                        parse = Uri.parse(stringBuilder2.toString());
                    }
                }
                parse = RingtoneManager.getDefaultUri(2);
            } else {
                parse = null;
            }
            zzu = zzu(bundle);
            if (zzs.isAtLeastO() || this.mContext.getApplicationInfo().targetSdkVersion <= 25) {
                smallIcon = new Builder(this.mContext).setAutoCancel(true).setSmallIcon(identifier);
                if (!TextUtils.isEmpty(zze)) {
                    smallIcon.setContentTitle(zze);
                }
                if (!TextUtils.isEmpty(zze2)) {
                    smallIcon.setContentText(zze2);
                }
                if (!TextUtils.isEmpty(zzd)) {
                    smallIcon.setColor(Color.parseColor(zzd));
                }
                if (parse != null) {
                    smallIcon.setSound(parse);
                }
                if (zzu != null) {
                    smallIcon.setContentIntent(zzu);
                }
                build = smallIcon.build();
            } else {
                String zzd5 = zzd(bundle, "gcm.n.android_channel_id");
                if (zzs.isAtLeastO()) {
                    NotificationManager notificationManager2 = (NotificationManager) this.mContext.getSystemService(NotificationManager.class);
                    if (!TextUtils.isEmpty(zzd5)) {
                        if (notificationManager2.getNotificationChannel(zzd5) != null) {
                            str = zzd5;
                        } else {
                            StringBuilder stringBuilder3 = new StringBuilder(String.valueOf(zzd5).length() + 122);
                            stringBuilder3.append("Notification Channel requested (");
                            stringBuilder3.append(zzd5);
                            stringBuilder3.append(") has not been created by the app. Manifest configuration, or default, value will be used.");
                            Log.w(str2, stringBuilder3.toString());
                        }
                    }
                    zzd5 = this.zzijl;
                    if (zzd5 == null) {
                        this.zzijl = zzawf().getString("com.google.android.gms.gcm.default_notification_channel_id");
                        if (TextUtils.isEmpty(this.zzijl)) {
                            zzd5 = "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.";
                            Log.w(str2, zzd5);
                            zzd5 = "fcm_fallback_notification_channel";
                            if (notificationManager2.getNotificationChannel(zzd5) == null) {
                                notificationManager2.createNotificationChannel(new NotificationChannel(zzd5, this.mContext.getString(C0562R.string.gcm_fallback_notification_channel_label), 3));
                            }
                            this.zzijl = zzd5;
                        } else if (notificationManager2.getNotificationChannel(this.zzijl) == null) {
                            zzd5 = "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.";
                            Log.w(str2, zzd5);
                            zzd5 = "fcm_fallback_notification_channel";
                            if (notificationManager2.getNotificationChannel(zzd5) == null) {
                                notificationManager2.createNotificationChannel(new NotificationChannel(zzd5, this.mContext.getString(C0562R.string.gcm_fallback_notification_channel_label), 3));
                            }
                            this.zzijl = zzd5;
                        }
                        str = this.zzijl;
                    }
                    str = zzd5;
                }
                Notification.Builder smallIcon2 = new Notification.Builder(this.mContext).setAutoCancel(true).setSmallIcon(identifier);
                if (!TextUtils.isEmpty(zze)) {
                    smallIcon2.setContentTitle(zze);
                }
                if (!TextUtils.isEmpty(zze2)) {
                    smallIcon2.setContentText(zze2);
                    smallIcon2.setStyle(new BigTextStyle().bigText(zze2));
                }
                if (!TextUtils.isEmpty(zzd)) {
                    smallIcon2.setColor(Color.parseColor(zzd));
                }
                if (parse != null) {
                    smallIcon2.setSound(parse);
                }
                if (zzu != null) {
                    smallIcon2.setContentIntent(zzu);
                }
                if (str != null) {
                    smallIcon2.setChannelId(str);
                }
                build = smallIcon2.build();
            }
            zzd3 = zzd(bundle, "gcm.n.tag");
            if (Log.isLoggable(str2, 3)) {
                Log.d(str2, "Showing notification");
            }
            notificationManager = (NotificationManager) this.mContext.getSystemService("notification");
            if (TextUtils.isEmpty(zzd3)) {
                long uptimeMillis = SystemClock.uptimeMillis();
                StringBuilder stringBuilder4 = new StringBuilder(37);
                stringBuilder4.append("GCM-Notification:");
                stringBuilder4.append(uptimeMillis);
                zzd3 = stringBuilder4.toString();
            }
            notificationManager.notify(zzd3, 0, build);
            return true;
        }
        int i = this.mContext.getApplicationInfo().icon;
        identifier = i == 0 ? 17301651 : i;
        zzd = zzd(bundle, "gcm.n.color");
        zzd2 = zzd(bundle, "gcm.n.sound2");
        str = null;
        if (TextUtils.isEmpty(zzd2)) {
            if ("default".equals(zzd2)) {
                if (this.mContext.getResources().getIdentifier(zzd2, "raw", this.mContext.getPackageName()) != 0) {
                    String packageName2 = this.mContext.getPackageName();
                    StringBuilder stringBuilder22 = new StringBuilder((String.valueOf(packageName2).length() + 24) + String.valueOf(zzd2).length());
                    stringBuilder22.append("android.resource://");
                    stringBuilder22.append(packageName2);
                    stringBuilder22.append("/raw/");
                    stringBuilder22.append(zzd2);
                    parse = Uri.parse(stringBuilder22.toString());
                }
            }
            parse = RingtoneManager.getDefaultUri(2);
        } else {
            parse = null;
        }
        zzu = zzu(bundle);
        if (zzs.isAtLeastO()) {
        }
        smallIcon = new Builder(this.mContext).setAutoCancel(true).setSmallIcon(identifier);
        if (TextUtils.isEmpty(zze)) {
            smallIcon.setContentTitle(zze);
        }
        if (TextUtils.isEmpty(zze2)) {
            smallIcon.setContentText(zze2);
        }
        if (TextUtils.isEmpty(zzd)) {
            smallIcon.setColor(Color.parseColor(zzd));
        }
        if (parse != null) {
            smallIcon.setSound(parse);
        }
        if (zzu != null) {
            smallIcon.setContentIntent(zzu);
        }
        build = smallIcon.build();
        zzd3 = zzd(bundle, "gcm.n.tag");
        if (Log.isLoggable(str2, 3)) {
            Log.d(str2, "Showing notification");
        }
        notificationManager = (NotificationManager) this.mContext.getSystemService("notification");
        if (TextUtils.isEmpty(zzd3)) {
            long uptimeMillis2 = SystemClock.uptimeMillis();
            StringBuilder stringBuilder42 = new StringBuilder(37);
            stringBuilder42.append("GCM-Notification:");
            stringBuilder42.append(uptimeMillis2);
            zzd3 = stringBuilder42.toString();
        }
        notificationManager.notify(zzd3, 0, build);
        return true;
    }
}
