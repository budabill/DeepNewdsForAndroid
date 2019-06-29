package com.facebook.share.internal;

import com.facebook.GraphRequest.C0338b;

/* renamed from: com.facebook.share.internal.b */
class C0861b implements C0338b {
    /* renamed from: a */
    final /* synthetic */ DeviceShareDialogFragment f1806a;

    C0861b(DeviceShareDialogFragment deviceShareDialogFragment) {
        this.f1806a = deviceShareDialogFragment;
    }

    /* renamed from: a */
    public void mo949a(com.facebook.C0331D r5) {
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
        r0 = r5.m486a();
        if (r0 == 0) goto L_0x000c;
    L_0x0006:
        r5 = r4.f1806a;
        r5.m2540a(r0);
        return;
    L_0x000c:
        r5 = r5.m487b();
        r0 = new com.facebook.share.internal.DeviceShareDialogFragment$RequestState;
        r0.<init>();
        r1 = "user_code";	 Catch:{ JSONException -> 0x002d }
        r1 = r5.getString(r1);	 Catch:{ JSONException -> 0x002d }
        r0.m1224a(r1);	 Catch:{ JSONException -> 0x002d }
        r1 = "expires_in";	 Catch:{ JSONException -> 0x002d }
        r1 = r5.getLong(r1);	 Catch:{ JSONException -> 0x002d }
        r0.m1223a(r1);	 Catch:{ JSONException -> 0x002d }
        r5 = r4.f1806a;
        r5.m2541a(r0);
        return;
    L_0x002d:
        r5 = r4.f1806a;
        r0 = new com.facebook.FacebookRequestError;
        r1 = 0;
        r2 = "";
        r3 = "Malformed server response";
        r0.<init>(r1, r2, r3);
        r5.m2540a(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.b.a(com.facebook.D):void");
    }
}
