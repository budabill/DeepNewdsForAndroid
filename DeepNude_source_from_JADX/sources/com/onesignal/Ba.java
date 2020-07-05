package com.onesignal;

import com.onesignal.sa.C0643b;
import org.json.JSONObject;

class ba implements Runnable {
    /* renamed from: a */
    final /* synthetic */ JSONObject f1262a;
    /* renamed from: b */
    final /* synthetic */ C0643b f1263b;

    ba(JSONObject jSONObject, C0643b c0643b) {
        this.f1262a = jSONObject;
        this.f1263b = c0643b;
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
        r7 = this;
        r0 = r7.f1262a;
        if (r0 != 0) goto L_0x0014;
    L_0x0004:
        r0 = r7.f1263b;
        if (r0 == 0) goto L_0x0013;
    L_0x0008:
        r1 = new com.onesignal.sa$n;
        r2 = -1;
        r3 = "Attempted to send null tags";
        r1.<init>(r2, r3);
        r0.m1607a(r1);
    L_0x0013:
        return;
    L_0x0014:
        r0 = 0;
        r0 = com.onesignal.Ha.m1336a(r0);
        r0 = r0.f1278b;
        r1 = new org.json.JSONObject;
        r1.<init>();
        r2 = r7.f1262a;
        r2 = r2.keys();
    L_0x0026:
        r3 = r2.hasNext();
        if (r3 == 0) goto L_0x0084;
    L_0x002c:
        r3 = r2.next();
        r3 = (java.lang.String) r3;
        r4 = r7.f1262a;	 Catch:{ Throwable -> 0x0082 }
        r4 = r4.opt(r3);	 Catch:{ Throwable -> 0x0082 }
        r5 = r4 instanceof org.json.JSONArray;	 Catch:{ Throwable -> 0x0082 }
        if (r5 != 0) goto L_0x0066;	 Catch:{ Throwable -> 0x0082 }
    L_0x003c:
        r5 = r4 instanceof org.json.JSONObject;	 Catch:{ Throwable -> 0x0082 }
        if (r5 == 0) goto L_0x0041;	 Catch:{ Throwable -> 0x0082 }
    L_0x0040:
        goto L_0x0066;	 Catch:{ Throwable -> 0x0082 }
    L_0x0041:
        r5 = r7.f1262a;	 Catch:{ Throwable -> 0x0082 }
        r5 = r5.isNull(r3);	 Catch:{ Throwable -> 0x0082 }
        r6 = "";
        if (r5 != 0) goto L_0x005a;
    L_0x004b:
        r5 = r6.equals(r4);	 Catch:{ Throwable -> 0x0082 }
        if (r5 == 0) goto L_0x0052;	 Catch:{ Throwable -> 0x0082 }
    L_0x0051:
        goto L_0x005a;	 Catch:{ Throwable -> 0x0082 }
    L_0x0052:
        r4 = r4.toString();	 Catch:{ Throwable -> 0x0082 }
        r1.put(r3, r4);	 Catch:{ Throwable -> 0x0082 }
        goto L_0x0026;	 Catch:{ Throwable -> 0x0082 }
    L_0x005a:
        if (r0 == 0) goto L_0x0026;	 Catch:{ Throwable -> 0x0082 }
    L_0x005c:
        r4 = r0.has(r3);	 Catch:{ Throwable -> 0x0082 }
        if (r4 == 0) goto L_0x0026;	 Catch:{ Throwable -> 0x0082 }
    L_0x0062:
        r1.put(r3, r6);	 Catch:{ Throwable -> 0x0082 }
        goto L_0x0026;	 Catch:{ Throwable -> 0x0082 }
    L_0x0066:
        r4 = com.onesignal.sa.C0650i.ERROR;	 Catch:{ Throwable -> 0x0082 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0082 }
        r5.<init>();	 Catch:{ Throwable -> 0x0082 }
        r6 = "Omitting key '";	 Catch:{ Throwable -> 0x0082 }
        r5.append(r6);	 Catch:{ Throwable -> 0x0082 }
        r5.append(r3);	 Catch:{ Throwable -> 0x0082 }
        r3 = "'! sendTags DO NOT supported nested values!";	 Catch:{ Throwable -> 0x0082 }
        r5.append(r3);	 Catch:{ Throwable -> 0x0082 }
        r3 = r5.toString();	 Catch:{ Throwable -> 0x0082 }
        com.onesignal.sa.m1656a(r4, r3);	 Catch:{ Throwable -> 0x0082 }
        goto L_0x0026;
        goto L_0x0026;
    L_0x0084:
        r2 = r1.toString();
        r3 = "{}";
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0096;
    L_0x0090:
        r0 = r7.f1263b;
        com.onesignal.Ha.m1339a(r1, r0);
        goto L_0x009d;
    L_0x0096:
        r1 = r7.f1263b;
        if (r1 == 0) goto L_0x009d;
    L_0x009a:
        r1.m1608a(r0);
    L_0x009d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.ba.run():void");
    }
}
