package com.onesignal.shortcutbadger.impl;

import com.onesignal.p036a.C0617a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

public class OPPOHomeBader implements C0617a {
    /* renamed from: a */
    private static int f1850a = -1;

    /* renamed from: a */
    private java.lang.Class m2328a(java.lang.String r1) {
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
        r0 = this;
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0005 }
        goto L_0x0006;
    L_0x0005:
        r1 = 0;
    L_0x0006:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.shortcutbadger.impl.OPPOHomeBader.a(java.lang.String):java.lang.Class");
    }

    /* renamed from: a */
    private Object m2329a(Class cls, String str, Class[] clsArr, Object[] objArr) {
        Object obj = null;
        if (!(cls == null || m2331a((Object) str))) {
            Method a = m2330a(cls, str, clsArr);
            if (a != null) {
                a.setAccessible(true);
                try {
                    obj = a.invoke(null, objArr);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return obj;
    }

    /* renamed from: a */
    private java.lang.reflect.Method m2330a(java.lang.Class r3, java.lang.String r4, java.lang.Class[] r5) {
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
        r2 = this;
        r0 = 0;
        if (r3 == 0) goto L_0x0028;
    L_0x0003:
        r1 = r2.m2331a(r4);
        if (r1 == 0) goto L_0x000a;
    L_0x0009:
        goto L_0x0028;
    L_0x000a:
        r3.getMethods();	 Catch:{ Exception -> 0x0015 }
        r3.getDeclaredMethods();	 Catch:{ Exception -> 0x0015 }
        r3 = r3.getDeclaredMethod(r4, r5);	 Catch:{ Exception -> 0x0015 }
        return r3;
    L_0x0015:
        r3 = r3.getMethod(r4, r5);	 Catch:{ Exception -> 0x001a }
        return r3;
    L_0x001a:
        r1 = r3.getSuperclass();
        if (r1 == 0) goto L_0x0028;
    L_0x0020:
        r3 = r3.getSuperclass();
        r0 = r2.m2330a(r3, r4, r5);
    L_0x0028:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.shortcutbadger.impl.OPPOHomeBader.a(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    /* renamed from: a */
    private boolean m2331a(Object obj) {
        if (!(obj == null || obj.toString().equals(""))) {
            if (!obj.toString().trim().equals("null")) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private int m2332b() {
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
        r0 = f1850a;
        if (r0 < 0) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r0 = "com.color.os.ColorBuild";	 Catch:{ Exception -> 0x0019 }
        r0 = r3.m2328a(r0);	 Catch:{ Exception -> 0x0019 }
        r1 = "getColorOSVERSION";	 Catch:{ Exception -> 0x0019 }
        r2 = 0;	 Catch:{ Exception -> 0x0019 }
        r0 = r3.m2329a(r0, r1, r2, r2);	 Catch:{ Exception -> 0x0019 }
        r0 = (java.lang.Integer) r0;	 Catch:{ Exception -> 0x0019 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x0019 }
        goto L_0x001a;
    L_0x0019:
        r0 = 0;
    L_0x001a:
        if (r0 != 0) goto L_0x0040;
    L_0x001c:
        r1 = "ro.build.version.opporom";	 Catch:{ Exception -> 0x0040 }
        r1 = r3.m2333b(r1);	 Catch:{ Exception -> 0x0040 }
        r2 = "V1.4";	 Catch:{ Exception -> 0x0040 }
        r2 = r1.startsWith(r2);	 Catch:{ Exception -> 0x0040 }
        if (r2 == 0) goto L_0x002c;	 Catch:{ Exception -> 0x0040 }
    L_0x002a:
        r0 = 3;	 Catch:{ Exception -> 0x0040 }
        return r0;	 Catch:{ Exception -> 0x0040 }
    L_0x002c:
        r2 = "V2.0";	 Catch:{ Exception -> 0x0040 }
        r2 = r1.startsWith(r2);	 Catch:{ Exception -> 0x0040 }
        if (r2 == 0) goto L_0x0036;	 Catch:{ Exception -> 0x0040 }
    L_0x0034:
        r0 = 4;	 Catch:{ Exception -> 0x0040 }
        return r0;	 Catch:{ Exception -> 0x0040 }
    L_0x0036:
        r2 = "V2.1";	 Catch:{ Exception -> 0x0040 }
        r1 = r1.startsWith(r2);	 Catch:{ Exception -> 0x0040 }
        if (r1 == 0) goto L_0x0040;
    L_0x003e:
        r0 = 5;
        return r0;
    L_0x0040:
        f1850a = r0;
        r0 = f1850a;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.shortcutbadger.impl.OPPOHomeBader.b():int");
    }

    /* renamed from: b */
    private java.lang.String m2333b(java.lang.String r5) {
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
        r0 = 0;
        r1 = java.lang.Runtime.getRuntime();	 Catch:{ IOException -> 0x003d, all -> 0x0038 }
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x003d, all -> 0x0038 }
        r2.<init>();	 Catch:{ IOException -> 0x003d, all -> 0x0038 }
        r3 = "getprop ";	 Catch:{ IOException -> 0x003d, all -> 0x0038 }
        r2.append(r3);	 Catch:{ IOException -> 0x003d, all -> 0x0038 }
        r2.append(r5);	 Catch:{ IOException -> 0x003d, all -> 0x0038 }
        r5 = r2.toString();	 Catch:{ IOException -> 0x003d, all -> 0x0038 }
        r5 = r1.exec(r5);	 Catch:{ IOException -> 0x003d, all -> 0x0038 }
        r1 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x003d, all -> 0x0038 }
        r2 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x003d, all -> 0x0038 }
        r5 = r5.getInputStream();	 Catch:{ IOException -> 0x003d, all -> 0x0038 }
        r2.<init>(r5);	 Catch:{ IOException -> 0x003d, all -> 0x0038 }
        r5 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;	 Catch:{ IOException -> 0x003d, all -> 0x0038 }
        r1.<init>(r2, r5);	 Catch:{ IOException -> 0x003d, all -> 0x0038 }
        r5 = r1.readLine();	 Catch:{ IOException -> 0x003e, all -> 0x0035 }
        r1.close();	 Catch:{ IOException -> 0x003e, all -> 0x0035 }
        com.onesignal.p036a.p037a.C0616b.m1438a(r1);
        return r5;
    L_0x0035:
        r5 = move-exception;
        r0 = r1;
        goto L_0x0039;
    L_0x0038:
        r5 = move-exception;
    L_0x0039:
        com.onesignal.p036a.p037a.C0616b.m1438a(r0);
        throw r5;
    L_0x003d:
        r1 = r0;
    L_0x003e:
        com.onesignal.p036a.p037a.C0616b.m1438a(r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.shortcutbadger.impl.OPPOHomeBader.b(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public List<String> mo1393a() {
        return Collections.singletonList("com.oppo.launcher");
    }

    @android.annotation.TargetApi(11)
    /* renamed from: a */
    public void mo1394a(android.content.Context r4, android.content.ComponentName r5, int r6) {
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
        if (r6 != 0) goto L_0x0003;
    L_0x0002:
        r6 = -1;
    L_0x0003:
        r0 = new android.content.Intent;
        r1 = "com.oppo.unsettledevent";
        r0.<init>(r1);
        r5 = r5.getPackageName();
        r1 = "pakeageName";
        r0.putExtra(r1, r5);
        r5 = "number";
        r0.putExtra(r5, r6);
        r5 = "upgradeNumber";
        r0.putExtra(r5, r6);
        r5 = com.onesignal.p036a.p037a.C0615a.m1436a(r4, r0);
        if (r5 == 0) goto L_0x0027;
    L_0x0023:
        r4.sendBroadcast(r0);
        goto L_0x0064;
    L_0x0027:
        r5 = r3.m2332b();
        r1 = 6;
        if (r5 != r1) goto L_0x0064;
    L_0x002e:
        r5 = new android.os.Bundle;	 Catch:{ Throwable -> 0x0049 }
        r5.<init>();	 Catch:{ Throwable -> 0x0049 }
        r1 = "app_badge_count";	 Catch:{ Throwable -> 0x0049 }
        r5.putInt(r1, r6);	 Catch:{ Throwable -> 0x0049 }
        r4 = r4.getContentResolver();	 Catch:{ Throwable -> 0x0049 }
        r6 = "content://com.android.badge/badge";	 Catch:{ Throwable -> 0x0049 }
        r6 = android.net.Uri.parse(r6);	 Catch:{ Throwable -> 0x0049 }
        r1 = "setAppBadgeCount";	 Catch:{ Throwable -> 0x0049 }
        r2 = 0;	 Catch:{ Throwable -> 0x0049 }
        r4.call(r6, r1, r2, r5);	 Catch:{ Throwable -> 0x0049 }
        goto L_0x0064;
    L_0x0049:
        r4 = new com.onesignal.a.b;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "unable to resolve intent: ";
        r5.append(r6);
        r6 = r0.toString();
        r5.append(r6);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0064:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.shortcutbadger.impl.OPPOHomeBader.a(android.content.Context, android.content.ComponentName, int):void");
    }
}
