package com.onesignal.shortcutbadger.impl;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.onesignal.p036a.C0617a;
import com.onesignal.p036a.C0618b;
import java.util.Arrays;
import java.util.List;

@Deprecated
public class XiaomiHomeBadger implements C0617a {
    /* renamed from: a */
    private ResolveInfo f1855a;

    @TargetApi(16)
    /* renamed from: a */
    private void m2349a(Context context, int i) {
        if (this.f1855a == null) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            this.f1855a = context.getPackageManager().resolveActivity(intent, 65536);
        }
        if (this.f1855a != null) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            Builder builder = new Builder(context);
            CharSequence charSequence = "";
            Notification build = builder.setContentTitle(charSequence).setContentText(charSequence).setSmallIcon(this.f1855a.getIconResource()).build();
            try {
                Object obj = build.getClass().getDeclaredField("extraNotification").get(build);
                obj.getClass().getDeclaredMethod("setMessageCount", new Class[]{Integer.TYPE}).invoke(obj, new Object[]{Integer.valueOf(i)});
                notificationManager.notify(0, build);
            } catch (Exception e) {
                throw new C0618b("not able to set badge", e);
            }
        }
    }

    /* renamed from: a */
    public List<String> mo1393a() {
        return Arrays.asList(new String[]{"com.miui.miuilite", "com.miui.home", "com.miui.miuihome", "com.miui.miuihome2", "com.miui.mihome", "com.miui.mihome2", "com.i.miui.launcher"});
    }

    /* renamed from: a */
    public void mo1394a(android.content.Context r5, android.content.ComponentName r6, int r7) {
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
        r4 = this;
        r0 = "";
        r1 = "android.app.MiuiNotification";
        r1 = java.lang.Class.forName(r1);	 Catch:{ Exception -> 0x0032 }
        r1 = r1.newInstance();	 Catch:{ Exception -> 0x0032 }
        r2 = r1.getClass();	 Catch:{ Exception -> 0x0032 }
        r3 = "messageCount";	 Catch:{ Exception -> 0x0032 }
        r2 = r2.getDeclaredField(r3);	 Catch:{ Exception -> 0x0032 }
        r3 = 1;	 Catch:{ Exception -> 0x0032 }
        r2.setAccessible(r3);	 Catch:{ Exception -> 0x0032 }
        if (r7 != 0) goto L_0x001e;
    L_0x001c:
        r3 = r0;
        goto L_0x0022;
    L_0x001e:
        r3 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x002a }
    L_0x0022:
        r3 = java.lang.String.valueOf(r3);	 Catch:{ Exception -> 0x002a }
        r2.set(r1, r3);	 Catch:{ Exception -> 0x002a }
        goto L_0x0074;
    L_0x002a:
        r3 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x0032 }
        r2.set(r1, r3);	 Catch:{ Exception -> 0x0032 }
        goto L_0x0074;
        r1 = new android.content.Intent;
        r2 = "android.intent.action.APPLICATION_MESSAGE_UPDATE";
        r1.<init>(r2);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r6.getPackageName();
        r2.append(r3);
        r3 = "/";
        r2.append(r3);
        r6 = r6.getClassName();
        r2.append(r6);
        r6 = r2.toString();
        r2 = "android.intent.extra.update_application_component_name";
        r1.putExtra(r2, r6);
        if (r7 != 0) goto L_0x005e;
    L_0x005d:
        goto L_0x0062;
    L_0x005e:
        r0 = java.lang.Integer.valueOf(r7);
    L_0x0062:
        r6 = java.lang.String.valueOf(r0);
        r0 = "android.intent.extra.update_application_message_text";
        r1.putExtra(r0, r6);
        r6 = com.onesignal.p036a.p037a.C0615a.m1436a(r5, r1);
        if (r6 == 0) goto L_0x0074;
    L_0x0071:
        r5.sendBroadcast(r1);
    L_0x0074:
        r6 = android.os.Build.MANUFACTURER;
        r0 = "Xiaomi";
        r6 = r6.equalsIgnoreCase(r0);
        if (r6 == 0) goto L_0x0081;
    L_0x007e:
        r4.m2349a(r5, r7);
    L_0x0081:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.shortcutbadger.impl.XiaomiHomeBadger.a(android.content.Context, android.content.ComponentName, int):void");
    }
}
