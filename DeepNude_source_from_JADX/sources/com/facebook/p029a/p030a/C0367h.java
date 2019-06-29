package com.facebook.p029a.p030a;

import android.app.Activity;
import java.util.TimerTask;

/* renamed from: com.facebook.a.a.h */
class C0367h extends TimerTask {
    /* renamed from: a */
    final /* synthetic */ Activity f593a;
    /* renamed from: b */
    final /* synthetic */ String f594b;
    /* renamed from: c */
    final /* synthetic */ C0371l f595c;

    C0367h(C0371l c0371l, Activity activity, String str) {
        this.f595c = c0371l;
        this.f593a = activity;
        this.f594b = str;
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
        r6 = this;
        r0 = r6.f593a;	 Catch:{ Exception -> 0x0082 }
        r0 = r0.getWindow();	 Catch:{ Exception -> 0x0082 }
        r0 = r0.getDecorView();	 Catch:{ Exception -> 0x0082 }
        r0 = r0.getRootView();	 Catch:{ Exception -> 0x0082 }
        r1 = com.facebook.p029a.p032b.C0382h.m684m();	 Catch:{ Exception -> 0x0082 }
        if (r1 != 0) goto L_0x0015;	 Catch:{ Exception -> 0x0082 }
    L_0x0014:
        return;	 Catch:{ Exception -> 0x0082 }
    L_0x0015:
        r1 = com.facebook.internal.C0458D.m886b();	 Catch:{ Exception -> 0x0082 }
        if (r1 == 0) goto L_0x001f;	 Catch:{ Exception -> 0x0082 }
    L_0x001b:
        com.facebook.p029a.p030a.p031a.C0354e.m601a();	 Catch:{ Exception -> 0x0082 }
        return;	 Catch:{ Exception -> 0x0082 }
    L_0x001f:
        r1 = new java.util.concurrent.FutureTask;	 Catch:{ Exception -> 0x0082 }
        r2 = new com.facebook.a.a.l$a;	 Catch:{ Exception -> 0x0082 }
        r2.<init>(r0);	 Catch:{ Exception -> 0x0082 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0082 }
        r2 = r6.f595c;	 Catch:{ Exception -> 0x0082 }
        r2 = r2.f603c;	 Catch:{ Exception -> 0x0082 }
        r2.post(r1);	 Catch:{ Exception -> 0x0082 }
        r2 = "";	 Catch:{ Exception -> 0x0082 }
        r3 = 1;
        r5 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ Exception -> 0x003f }
        r1 = r1.get(r3, r5);	 Catch:{ Exception -> 0x003f }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x003f }
        goto L_0x004a;
    L_0x003f:
        r1 = move-exception;
        r3 = com.facebook.p029a.p030a.C0371l.f601a;	 Catch:{ Exception -> 0x0082 }
        r4 = "Failed to take screenshot.";	 Catch:{ Exception -> 0x0082 }
        android.util.Log.e(r3, r4, r1);	 Catch:{ Exception -> 0x0082 }
        r1 = r2;	 Catch:{ Exception -> 0x0082 }
    L_0x004a:
        r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0082 }
        r2.<init>();	 Catch:{ Exception -> 0x0082 }
        r3 = "screenname";	 Catch:{ JSONException -> 0x006d }
        r4 = r6.f594b;	 Catch:{ JSONException -> 0x006d }
        r2.put(r3, r4);	 Catch:{ JSONException -> 0x006d }
        r3 = "screenshot";	 Catch:{ JSONException -> 0x006d }
        r2.put(r3, r1);	 Catch:{ JSONException -> 0x006d }
        r1 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x006d }
        r1.<init>();	 Catch:{ JSONException -> 0x006d }
        r0 = com.facebook.p029a.p030a.p031a.C0355f.m611c(r0);	 Catch:{ JSONException -> 0x006d }
        r1.put(r0);	 Catch:{ JSONException -> 0x006d }
        r0 = "view";	 Catch:{ JSONException -> 0x006d }
        r2.put(r0, r1);	 Catch:{ JSONException -> 0x006d }
        goto L_0x0076;
    L_0x006d:
        r0 = com.facebook.p029a.p030a.C0371l.f601a;	 Catch:{ Exception -> 0x0082 }
        r1 = "Failed to create JSONObject";	 Catch:{ Exception -> 0x0082 }
        android.util.Log.e(r0, r1);	 Catch:{ Exception -> 0x0082 }
    L_0x0076:
        r0 = r2.toString();	 Catch:{ Exception -> 0x0082 }
        r1 = r6.f595c;	 Catch:{ Exception -> 0x0082 }
        r2 = r6.f594b;	 Catch:{ Exception -> 0x0082 }
        r1.m653a(r0, r2);	 Catch:{ Exception -> 0x0082 }
        goto L_0x008c;
    L_0x0082:
        r0 = move-exception;
        r1 = com.facebook.p029a.p030a.C0371l.f601a;
        r2 = "UI Component tree indexing failure!";
        android.util.Log.e(r1, r2, r0);
    L_0x008c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.a.a.h.run():void");
    }
}
