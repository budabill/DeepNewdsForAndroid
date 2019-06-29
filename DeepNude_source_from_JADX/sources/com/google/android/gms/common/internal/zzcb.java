package com.google.android.gms.common.internal;

@Hide
public final class zzcb {
    public static java.lang.String zza(java.lang.String r2, java.lang.String r3, android.content.Context r4, android.util.AttributeSet r5, boolean r6, boolean r7, java.lang.String r8) {
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
        if (r5 != 0) goto L_0x0004;
    L_0x0002:
        r2 = 0;
        goto L_0x0008;
    L_0x0004:
        r2 = r5.getAttributeValue(r2, r3);
    L_0x0008:
        if (r2 == 0) goto L_0x00bb;
    L_0x000a:
        r5 = "@string/";
        r5 = r2.startsWith(r5);
        if (r5 == 0) goto L_0x00bb;
    L_0x0012:
        r5 = 8;
        r6 = r2.substring(r5);
        r7 = r4.getPackageName();
        r0 = new android.util.TypedValue;
        r0.<init>();
        r4 = r4.getResources();	 Catch:{ NotFoundException -> 0x0050 }
        r1 = java.lang.String.valueOf(r7);	 Catch:{ NotFoundException -> 0x0050 }
        r1 = r1.length();	 Catch:{ NotFoundException -> 0x0050 }
        r1 = r1 + r5;	 Catch:{ NotFoundException -> 0x0050 }
        r5 = java.lang.String.valueOf(r6);	 Catch:{ NotFoundException -> 0x0050 }
        r5 = r5.length();	 Catch:{ NotFoundException -> 0x0050 }
        r1 = r1 + r5;	 Catch:{ NotFoundException -> 0x0050 }
        r5 = new java.lang.StringBuilder;	 Catch:{ NotFoundException -> 0x0050 }
        r5.<init>(r1);	 Catch:{ NotFoundException -> 0x0050 }
        r5.append(r7);	 Catch:{ NotFoundException -> 0x0050 }
        r7 = ":string/";	 Catch:{ NotFoundException -> 0x0050 }
        r5.append(r7);	 Catch:{ NotFoundException -> 0x0050 }
        r5.append(r6);	 Catch:{ NotFoundException -> 0x0050 }
        r5 = r5.toString();	 Catch:{ NotFoundException -> 0x0050 }
        r6 = 1;	 Catch:{ NotFoundException -> 0x0050 }
        r4.getValue(r5, r0, r6);	 Catch:{ NotFoundException -> 0x0050 }
        goto L_0x007f;
    L_0x0050:
        r4 = java.lang.String.valueOf(r3);
        r4 = r4.length();
        r4 = r4 + 30;
        r5 = java.lang.String.valueOf(r2);
        r5 = r5.length();
        r4 = r4 + r5;
        r5 = new java.lang.StringBuilder;
        r5.<init>(r4);
        r4 = "Could not find resource for ";
        r5.append(r4);
        r5.append(r3);
        r4 = ": ";
        r5.append(r4);
        r5.append(r2);
        r4 = r5.toString();
        android.util.Log.w(r8, r4);
    L_0x007f:
        r4 = r0.string;
        if (r4 == 0) goto L_0x0088;
    L_0x0083:
        r2 = r4.toString();
        goto L_0x00bb;
    L_0x0088:
        r4 = java.lang.String.valueOf(r0);
        r5 = java.lang.String.valueOf(r3);
        r5 = r5.length();
        r5 = r5 + 28;
        r6 = java.lang.String.valueOf(r4);
        r6 = r6.length();
        r5 = r5 + r6;
        r6 = new java.lang.StringBuilder;
        r6.<init>(r5);
        r5 = "Resource ";
        r6.append(r5);
        r6.append(r3);
        r3 = " was not a string: ";
        r6.append(r3);
        r6.append(r4);
        r3 = r6.toString();
        android.util.Log.w(r8, r3);
    L_0x00bb:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzcb.zza(java.lang.String, java.lang.String, android.content.Context, android.util.AttributeSet, boolean, boolean, java.lang.String):java.lang.String");
    }
}
