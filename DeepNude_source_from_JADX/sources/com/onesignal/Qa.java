package com.onesignal;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions.Builder;
import com.google.firebase.iid.FirebaseInstanceId;

class Qa extends Pa {
    /* renamed from: f */
    private FirebaseApp f1977f;

    Qa() {
    }

    /* renamed from: a */
    static void m2492a(android.content.Context r5) {
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
        r0 = "gcm_defaultSenderId";
        r1 = 0;
        r0 = com.onesignal.aa.m1444a(r5, r0, r1);
        r1 = 1;
        if (r0 != 0) goto L_0x000c;
    L_0x000a:
        r0 = 2;
        goto L_0x000d;
    L_0x000c:
        r0 = 1;
    L_0x000d:
        r2 = r5.getPackageManager();
        r3 = new android.content.ComponentName;	 Catch:{ NoClassDefFoundError -> 0x001b, NoClassDefFoundError -> 0x001b }
        r4 = com.google.firebase.iid.FirebaseInstanceIdService.class;	 Catch:{ NoClassDefFoundError -> 0x001b, NoClassDefFoundError -> 0x001b }
        r3.<init>(r5, r4);	 Catch:{ NoClassDefFoundError -> 0x001b, NoClassDefFoundError -> 0x001b }
        r2.setComponentEnabledSetting(r3, r0, r1);	 Catch:{ NoClassDefFoundError -> 0x001b, NoClassDefFoundError -> 0x001b }
    L_0x001b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.Qa.a(android.content.Context):void");
    }

    /* renamed from: d */
    private void m2493d(String str) {
        if (this.f1977f == null) {
            this.f1977f = FirebaseApp.initializeApp(sa.f1380f, new Builder().setGcmSenderId(str).setApplicationId("OMIT_ID").setApiKey("OMIT_KEY").build(), "ONESIGNAL_SDK_FCM_APP_NAME");
        }
    }

    /* renamed from: a */
    String mo1747a(String str) {
        m2493d(str);
        return FirebaseInstanceId.getInstance(this.f1977f).getToken(str, "FCM");
    }

    /* renamed from: c */
    String mo1748c() {
        return "FCM";
    }
}
