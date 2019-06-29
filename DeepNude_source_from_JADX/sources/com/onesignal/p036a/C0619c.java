package com.onesignal.p036a;

import android.content.ComponentName;
import android.content.Context;
import com.onesignal.shortcutbadger.impl.AdwHomeBadger;
import com.onesignal.shortcutbadger.impl.ApexHomeBadger;
import com.onesignal.shortcutbadger.impl.C0878a;
import com.onesignal.shortcutbadger.impl.EverythingMeHomeBadger;
import com.onesignal.shortcutbadger.impl.HuaweiHomeBadger;
import com.onesignal.shortcutbadger.impl.NewHtcHomeBadger;
import com.onesignal.shortcutbadger.impl.NovaHomeBadger;
import com.onesignal.shortcutbadger.impl.OPPOHomeBader;
import com.onesignal.shortcutbadger.impl.SamsungHomeBadger;
import com.onesignal.shortcutbadger.impl.SonyHomeBadger;
import com.onesignal.shortcutbadger.impl.VivoHomeBadger;
import com.onesignal.shortcutbadger.impl.ZukHomeBadger;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.onesignal.a.c */
public final class C0619c {
    /* renamed from: a */
    private static final List<Class<? extends C0617a>> f1240a = new LinkedList();
    /* renamed from: b */
    private static final Object f1241b = new Object();
    /* renamed from: c */
    private static C0617a f1242c;
    /* renamed from: d */
    private static ComponentName f1243d;

    static {
        f1240a.add(AdwHomeBadger.class);
        f1240a.add(ApexHomeBadger.class);
        f1240a.add(NewHtcHomeBadger.class);
        f1240a.add(NovaHomeBadger.class);
        f1240a.add(SonyHomeBadger.class);
        f1240a.add(C0878a.class);
        f1240a.add(HuaweiHomeBadger.class);
        f1240a.add(OPPOHomeBader.class);
        f1240a.add(SamsungHomeBadger.class);
        f1240a.add(ZukHomeBadger.class);
        f1240a.add(VivoHomeBadger.class);
        f1240a.add(EverythingMeHomeBadger.class);
    }

    /* renamed from: a */
    public static void m1441a(Context context, int i) {
        if (f1242c == null) {
            if (!C0619c.m1442a(context)) {
                throw new C0618b("No default launcher available");
            }
        }
        try {
            f1242c.mo1394a(context, f1243d, i);
        } catch (Exception e) {
            throw new C0618b("Unable to execute badge", e);
        }
    }

    /* renamed from: a */
    private static boolean m1442a(android.content.Context r3) {
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
        r0 = r3.getPackageManager();
        r1 = r3.getPackageName();
        r0 = r0.getLaunchIntentForPackage(r1);
        r1 = 0;
        if (r0 != 0) goto L_0x002a;
    L_0x000f:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = "Unable to find launch intent for package ";
        r0.append(r2);
        r3 = r3.getPackageName();
        r0.append(r3);
        r3 = r0.toString();
        r0 = "ShortcutBadger";
        android.util.Log.e(r0, r3);
        return r1;
    L_0x002a:
        r0 = r0.getComponent();
        f1243d = r0;
        r0 = new android.content.Intent;
        r2 = "android.intent.action.MAIN";
        r0.<init>(r2);
        r2 = "android.intent.category.HOME";
        r0.addCategory(r2);
        r3 = r3.getPackageManager();
        r2 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r3 = r3.resolveActivity(r0, r2);
        if (r3 == 0) goto L_0x00c5;
    L_0x0048:
        r0 = r3.activityInfo;
        r0 = r0.name;
        r0 = r0.toLowerCase();
        r2 = "resolver";
        r0 = r0.contains(r2);
        if (r0 == 0) goto L_0x005a;
    L_0x0058:
        goto L_0x00c5;
    L_0x005a:
        r3 = r3.activityInfo;
        r3 = r3.packageName;
        r0 = f1240a;
        r0 = r0.iterator();
    L_0x0064:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x0087;
    L_0x006a:
        r1 = r0.next();
        r1 = (java.lang.Class) r1;
        r2 = 0;
        r1 = r1.newInstance();	 Catch:{ Exception -> 0x0078 }
        r1 = (com.onesignal.p036a.C0617a) r1;	 Catch:{ Exception -> 0x0078 }
        goto L_0x0079;
    L_0x0078:
        r1 = r2;
    L_0x0079:
        if (r1 == 0) goto L_0x0064;
    L_0x007b:
        r2 = r1.mo1393a();
        r2 = r2.contains(r3);
        if (r2 == 0) goto L_0x0064;
    L_0x0085:
        f1242c = r1;
    L_0x0087:
        r3 = f1242c;
        if (r3 != 0) goto L_0x00c3;
    L_0x008b:
        r3 = android.os.Build.MANUFACTURER;
        r0 = "ZUK";
        r3 = r3.equalsIgnoreCase(r0);
        if (r3 == 0) goto L_0x009d;
    L_0x0095:
        r3 = new com.onesignal.shortcutbadger.impl.ZukHomeBadger;
        r3.<init>();
    L_0x009a:
        f1242c = r3;
        goto L_0x00c3;
    L_0x009d:
        r3 = android.os.Build.MANUFACTURER;
        r0 = "OPPO";
        r3 = r3.equalsIgnoreCase(r0);
        if (r3 == 0) goto L_0x00ad;
    L_0x00a7:
        r3 = new com.onesignal.shortcutbadger.impl.OPPOHomeBader;
        r3.<init>();
        goto L_0x009a;
    L_0x00ad:
        r3 = android.os.Build.MANUFACTURER;
        r0 = "VIVO";
        r3 = r3.equalsIgnoreCase(r0);
        if (r3 == 0) goto L_0x00bd;
    L_0x00b7:
        r3 = new com.onesignal.shortcutbadger.impl.VivoHomeBadger;
        r3.<init>();
        goto L_0x009a;
    L_0x00bd:
        r3 = new com.onesignal.shortcutbadger.impl.DefaultBadger;
        r3.<init>();
        goto L_0x009a;
    L_0x00c3:
        r3 = 1;
        return r3;
    L_0x00c5:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.a.c.a(android.content.Context):boolean");
    }
}
