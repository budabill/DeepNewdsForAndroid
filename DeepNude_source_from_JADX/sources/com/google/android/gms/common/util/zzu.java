package com.google.android.gms.common.util;

import android.os.Process;

public final class zzu {
    private static String zzglf;
    private static final int zzglg = Process.myPid();

    public static String zzany() {
        if (zzglf == null) {
            zzglf = zzci(zzglg);
        }
        return zzglf;
    }

    private static java.lang.String zzci(int r6) {
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
        r0 = 0;
        if (r6 > 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = android.os.StrictMode.allowThreadDiskReads();	 Catch:{ IOException -> 0x0043, all -> 0x003e }
        r2 = new java.io.BufferedReader;	 Catch:{ all -> 0x0039 }
        r3 = new java.io.FileReader;	 Catch:{ all -> 0x0039 }
        r4 = 25;	 Catch:{ all -> 0x0039 }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0039 }
        r5.<init>(r4);	 Catch:{ all -> 0x0039 }
        r4 = "/proc/";	 Catch:{ all -> 0x0039 }
        r5.append(r4);	 Catch:{ all -> 0x0039 }
        r5.append(r6);	 Catch:{ all -> 0x0039 }
        r6 = "/cmdline";	 Catch:{ all -> 0x0039 }
        r5.append(r6);	 Catch:{ all -> 0x0039 }
        r6 = r5.toString();	 Catch:{ all -> 0x0039 }
        r3.<init>(r6);	 Catch:{ all -> 0x0039 }
        r2.<init>(r3);	 Catch:{ all -> 0x0039 }
        android.os.StrictMode.setThreadPolicy(r1);	 Catch:{ IOException -> 0x0044, all -> 0x0036 }
        r6 = r2.readLine();	 Catch:{ IOException -> 0x0044, all -> 0x0036 }
        r0 = r6.trim();	 Catch:{ IOException -> 0x0044, all -> 0x0036 }
        goto L_0x0044;
    L_0x0036:
        r6 = move-exception;
        r0 = r2;
        goto L_0x003f;
    L_0x0039:
        r6 = move-exception;
        android.os.StrictMode.setThreadPolicy(r1);	 Catch:{ IOException -> 0x0043, all -> 0x003e }
        throw r6;	 Catch:{ IOException -> 0x0043, all -> 0x003e }
    L_0x003e:
        r6 = move-exception;
    L_0x003f:
        com.google.android.gms.common.util.zzp.closeQuietly(r0);
        throw r6;
    L_0x0043:
        r2 = r0;
    L_0x0044:
        com.google.android.gms.common.util.zzp.closeQuietly(r2);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.zzu.zzci(int):java.lang.String");
    }
}
