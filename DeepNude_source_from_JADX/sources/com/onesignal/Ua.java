package com.onesignal;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import p000a.p005b.p007b.C0022h;
import p000a.p005b.p007b.C0025k;
import p000a.p005b.p007b.C0026l;

class ua {
    /* renamed from: a */
    private static boolean f1405a;

    /* renamed from: com.onesignal.ua$a */
    private static class C0879a extends C0025k {
        /* renamed from: a */
        private Context f1858a;
        /* renamed from: b */
        private String f1859b;

        C0879a(Context context, String str) {
            this.f1858a = context;
            this.f1859b = str;
        }

        /* renamed from: a */
        public void mo1397a(ComponentName componentName, C0022h c0022h) {
            if (c0022h != null) {
                c0022h.m18a(0);
                C0026l a = c0022h.m17a(new ta(this));
                if (a != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("https://onesignal.com/android_frame.html");
                    stringBuilder.append(this.f1859b);
                    a.m23a(Uri.parse(stringBuilder.toString()), null, null);
                }
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: a */
    static void m1747a(android.content.Context r2, java.lang.String r3, java.lang.String r4, java.lang.String r5) {
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
        r0 = f1405a;
        if (r0 == 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = com.onesignal.sa.f1364P;
        if (r0 == 0) goto L_0x000a;
    L_0x0009:
        return;
    L_0x000a:
        if (r4 != 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r0 = "a.b.b.k";
        java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x006e }
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "?app_id=";
        r0.append(r1);
        r0.append(r3);
        r3 = "&user_id=";
        r0.append(r3);
        r0.append(r4);
        r3 = r0.toString();
        if (r5 == 0) goto L_0x0041;
    L_0x002d:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r3);
        r3 = "&ad_id=";
        r4.append(r3);
        r4.append(r5);
        r3 = r4.toString();
    L_0x0041:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r3);
        r3 = "&cbs_id=";
        r4.append(r3);
        r3 = new java.util.Random;
        r3.<init>();
        r5 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r3 = r3.nextInt(r5);
        r4.append(r3);
        r3 = r4.toString();
        r4 = new com.onesignal.ua$a;
        r4.<init>(r2, r3);
        r3 = "com.android.chrome";
        r2 = p000a.p005b.p007b.C0022h.m16a(r2, r3, r4);
        f1405a = r2;
    L_0x006e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.ua.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void");
    }
}
