package com.onesignal;

import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import java.util.List;

/* renamed from: com.onesignal.p */
class C0637p implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ List f1298a;
    /* renamed from: b */
    final /* synthetic */ Intent f1299b;
    /* renamed from: c */
    final /* synthetic */ C0639r f1300c;

    C0637p(C0639r c0639r, List list, Intent intent) {
        this.f1300c = c0639r;
        this.f1298a = list;
        this.f1299b = intent;
    }

    public void onClick(android.content.DialogInterface r3, int r4) {
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
        r4 = r4 + 3;
        r3 = r2.f1298a;
        r3 = r3.size();
        r0 = 1;
        if (r3 <= r0) goto L_0x0038;
    L_0x000b:
        r3 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0041 }
        r0 = r2.f1300c;	 Catch:{ Throwable -> 0x0041 }
        r0 = r0.f1306b;	 Catch:{ Throwable -> 0x0041 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x0041 }
        r3.<init>(r0);	 Catch:{ Throwable -> 0x0041 }
        r0 = "actionSelected";	 Catch:{ Throwable -> 0x0041 }
        r1 = r2.f1298a;	 Catch:{ Throwable -> 0x0041 }
        r4 = r1.get(r4);	 Catch:{ Throwable -> 0x0041 }
        r3.put(r0, r4);	 Catch:{ Throwable -> 0x0041 }
        r4 = r2.f1299b;	 Catch:{ Throwable -> 0x0041 }
        r0 = "onesignal_data";	 Catch:{ Throwable -> 0x0041 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x0041 }
        r4.putExtra(r0, r3);	 Catch:{ Throwable -> 0x0041 }
        r3 = r2.f1300c;	 Catch:{ Throwable -> 0x0041 }
        r3 = r3.f1305a;	 Catch:{ Throwable -> 0x0041 }
        r4 = r2.f1299b;	 Catch:{ Throwable -> 0x0041 }
        com.onesignal.C0591I.m1358b(r3, r4);	 Catch:{ Throwable -> 0x0041 }
        goto L_0x0041;
    L_0x0038:
        r3 = r2.f1300c;
        r3 = r3.f1305a;
        r4 = r2.f1299b;
        com.onesignal.C0591I.m1358b(r3, r4);
    L_0x0041:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.p.onClick(android.content.DialogInterface, int):void");
    }
}
