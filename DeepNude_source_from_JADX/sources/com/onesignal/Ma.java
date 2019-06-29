package com.onesignal;

import android.content.Context;
import com.onesignal.La.C0596a;

class Ma implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f1147a;
    /* renamed from: b */
    final /* synthetic */ C0596a f1148b;
    /* renamed from: c */
    final /* synthetic */ Na f1149c;

    Ma(Na na, Context context, C0596a c0596a) {
        this.f1149c = na;
        this.f1147a = context;
        this.f1148b = c0596a;
    }

    public void run() {
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
        r0 = new com.amazon.device.messaging.ADM;
        r1 = r4.f1147a;
        r0.<init>(r1);
        r1 = r0.getRegistrationId();
        if (r1 != 0) goto L_0x0011;
    L_0x000d:
        r0.startRegister();
        goto L_0x002d;
    L_0x0011:
        r0 = com.onesignal.sa.C0650i.DEBUG;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "ADM Already registered with ID:";
        r2.append(r3);
        r2.append(r1);
        r2 = r2.toString();
        com.onesignal.sa.m1656a(r0, r2);
        r0 = r4.f1148b;
        r2 = 1;
        r0.mo1392a(r1, r2);
    L_0x002d:
        r0 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        java.lang.Thread.sleep(r0);	 Catch:{ InterruptedException -> 0x0032 }
    L_0x0032:
        r0 = com.onesignal.Na.f1827b;
        if (r0 != 0) goto L_0x0043;
    L_0x0038:
        r0 = com.onesignal.sa.C0650i.ERROR;
        r1 = "com.onesignal.ADMMessageHandler timed out, please check that your have the receiver, service, and your package name matches(NOTE: Case Sensitive) per the OneSignal instructions.";
        com.onesignal.sa.m1656a(r0, r1);
        r0 = 0;
        com.onesignal.Na.m2242a(r0);
    L_0x0043:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.Ma.run():void");
    }
}
