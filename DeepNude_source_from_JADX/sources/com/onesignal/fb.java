package com.onesignal;

class fb extends cb {
    fb(String str, boolean z) {
        super(str, z);
    }

    /* renamed from: e */
    private int m2271e() {
        int optInt = this.f1269e.optInt("subscribableStatus", 1);
        return optInt < -2 ? optInt : !this.f1269e.optBoolean("androidPermission", true) ? 0 : !this.f1269e.optBoolean("userSubscribePref", true) ? -2 : 1;
    }

    /* renamed from: a */
    protected void mo1371a() {
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
        r0 = r3.f1270f;	 Catch:{ JSONException -> 0x000b }
        r1 = "notification_types";	 Catch:{ JSONException -> 0x000b }
        r2 = r3.m2271e();	 Catch:{ JSONException -> 0x000b }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x000b }
    L_0x000b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.fb.a():void");
    }

    /* renamed from: b */
    cb mo1372b(String str) {
        return new fb(str, false);
    }

    /* renamed from: b */
    boolean mo1373b() {
        return m2271e() > 0;
    }
}
