package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class zzaj implements zzm {
    private static boolean DEBUG = zzaf.DEBUG;
    @Deprecated
    private zzar zzbo;
    private final zzai zzbp;
    private zzak zzbq;

    public zzaj(zzai zzai) {
        this(zzai, new zzak(4096));
    }

    private zzaj(zzai zzai, zzak zzak) {
        this.zzbp = zzai;
        this.zzbo = zzai;
        this.zzbq = zzak;
    }

    @Deprecated
    public zzaj(zzar zzar) {
        this(zzar, new zzak(4096));
    }

    @Deprecated
    private zzaj(zzar zzar, zzak zzak) {
        this.zzbo = zzar;
        this.zzbp = new zzah(zzar);
        this.zzbq = zzak;
    }

    private static List<zzl> zza(List<zzl> list, zzc zzc) {
        Set treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            for (zzl name : list) {
                treeSet.add(name.getName());
            }
        }
        List<zzl> arrayList = new ArrayList(list);
        List list2 = zzc.zzg;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (zzl zzl : zzc.zzg) {
                    if (!treeSet.contains(zzl.getName())) {
                        arrayList.add(zzl);
                    }
                }
            }
        } else if (!zzc.zzf.isEmpty()) {
            for (Entry entry : zzc.zzf.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new zzl((String) entry.getKey(), (String) entry.getValue()));
                }
            }
        }
        return arrayList;
    }

    private static void zza(String str, zzr<?> zzr, zzae zzae) {
        zzab zzi = zzr.zzi();
        int zzh = zzr.zzh();
        try {
            zzi.zza(zzae);
            zzr.zzb(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(zzh)}));
        } catch (zzae zzae2) {
            zzr.zzb(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(zzh)}));
            throw zzae2;
        }
    }

    private final byte[] zza(java.io.InputStream r6, int r7) {
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
        r5 = this;
        r0 = new com.google.android.gms.internal.zzau;
        r1 = r5.zzbq;
        r0.<init>(r1, r7);
        r7 = "Error occurred when closing InputStream";
        r1 = 0;
        r2 = 0;
        if (r6 == 0) goto L_0x003a;
    L_0x000d:
        r3 = r5.zzbq;	 Catch:{ all -> 0x0038 }
        r4 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;	 Catch:{ all -> 0x0038 }
        r2 = r3.zzb(r4);	 Catch:{ all -> 0x0038 }
    L_0x0015:
        r3 = r6.read(r2);	 Catch:{ all -> 0x0038 }
        r4 = -1;	 Catch:{ all -> 0x0038 }
        if (r3 == r4) goto L_0x0020;	 Catch:{ all -> 0x0038 }
    L_0x001c:
        r0.write(r2, r1, r3);	 Catch:{ all -> 0x0038 }
        goto L_0x0015;	 Catch:{ all -> 0x0038 }
    L_0x0020:
        r3 = r0.toByteArray();	 Catch:{ all -> 0x0038 }
        if (r6 == 0) goto L_0x002f;
    L_0x0026:
        r6.close();	 Catch:{ IOException -> 0x002a }
        goto L_0x002f;
    L_0x002a:
        r6 = new java.lang.Object[r1];
        com.google.android.gms.internal.zzaf.zza(r7, r6);
    L_0x002f:
        r6 = r5.zzbq;
        r6.zza(r2);
        r0.close();
        return r3;
    L_0x0038:
        r3 = move-exception;
        goto L_0x0040;
    L_0x003a:
        r3 = new com.google.android.gms.internal.zzac;	 Catch:{ all -> 0x0038 }
        r3.<init>();	 Catch:{ all -> 0x0038 }
        throw r3;	 Catch:{ all -> 0x0038 }
    L_0x0040:
        if (r6 == 0) goto L_0x004b;
    L_0x0042:
        r6.close();	 Catch:{ IOException -> 0x0046 }
        goto L_0x004b;
    L_0x0046:
        r6 = new java.lang.Object[r1];
        com.google.android.gms.internal.zzaf.zza(r7, r6);
    L_0x004b:
        r6 = r5.zzbq;
        r6.zza(r2);
        r0.close();
        goto L_0x0055;
    L_0x0054:
        throw r3;
    L_0x0055:
        goto L_0x0054;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaj.zza(java.io.InputStream, int):byte[]");
    }

    public com.google.android.gms.internal.zzp zzc(com.google.android.gms.internal.zzr<?> r27) {
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
        r26 = this;
        r1 = r26;
        r2 = r27;
        r3 = android.os.SystemClock.elapsedRealtime();
    L_0x0008:
        r5 = java.util.Collections.emptyList();
        r6 = 1;
        r7 = 2;
        r8 = 0;
        r9 = 0;
        r0 = r27.zze();	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00fb }
        if (r0 != 0) goto L_0x001b;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00fb }
    L_0x0016:
        r0 = java.util.Collections.emptyMap();	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00fb }
        goto L_0x003f;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00fb }
    L_0x001b:
        r10 = new java.util.HashMap;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00fb }
        r10.<init>();	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00fb }
        r11 = r0.zza;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00fb }
        if (r11 == 0) goto L_0x002b;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00fb }
    L_0x0024:
        r11 = "If-None-Match";	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00fb }
        r12 = r0.zza;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00fb }
        r10.put(r11, r12);	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00fb }
    L_0x002b:
        r11 = r0.zzc;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00fb }
        r13 = 0;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00fb }
        r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1));	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00fb }
        if (r15 <= 0) goto L_0x003e;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00fb }
    L_0x0033:
        r11 = "If-Modified-Since";	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00fb }
        r12 = r0.zzc;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00fb }
        r0 = com.google.android.gms.internal.zzap.zzb(r12);	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00fb }
        r10.put(r11, r0);	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00fb }
    L_0x003e:
        r0 = r10;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00fb }
    L_0x003f:
        r10 = r1.zzbp;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00fb }
        r10 = r10.zza(r2, r0);	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00fb }
        r12 = r10.getStatusCode();	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r5 = r10.zzp();	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r0 = 304; // 0x130 float:4.26E-43 double:1.5E-321;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        if (r12 != r0) goto L_0x0085;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
    L_0x0051:
        r0 = r27.zze();	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        if (r0 != 0) goto L_0x006b;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
    L_0x0057:
        r0 = new com.google.android.gms.internal.zzp;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r14 = 304; // 0x130 float:4.26E-43 double:1.5E-321;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r15 = 0;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r16 = 1;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r11 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r17 = r11 - r3;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r13 = r0;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r19 = r5;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r13.<init>(r14, r15, r16, r17, r19);	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        return r0;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
    L_0x006b:
        r25 = zza(r5, r0);	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r11 = new com.google.android.gms.internal.zzp;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r20 = 304; // 0x130 float:4.26E-43 double:1.5E-321;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r0 = r0.data;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r22 = 1;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r12 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r23 = r12 - r3;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r19 = r11;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r21 = r0;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r19.<init>(r20, r21, r22, r23, r25);	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        return r11;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
    L_0x0085:
        r0 = r10.getContent();	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        if (r0 == 0) goto L_0x0094;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
    L_0x008b:
        r11 = r10.getContentLength();	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r0 = r1.zza(r0, r11);	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        goto L_0x0096;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
    L_0x0094:
        r0 = new byte[r9];	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
    L_0x0096:
        r8 = r0;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r13 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r13 = r13 - r3;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r0 = DEBUG;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        if (r0 != 0) goto L_0x00a6;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
    L_0x00a0:
        r15 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r0 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1));	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        if (r0 <= 0) goto L_0x00d8;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
    L_0x00a6:
        r0 = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]";	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r11 = 5;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r11 = new java.lang.Object[r11];	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r11[r9] = r2;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r13 = java.lang.Long.valueOf(r13);	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r11[r6] = r13;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        if (r8 == 0) goto L_0x00bb;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
    L_0x00b5:
        r13 = r8.length;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r13 = java.lang.Integer.valueOf(r13);	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        goto L_0x00bd;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
    L_0x00bb:
        r13 = "null";	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
    L_0x00bd:
        r11[r7] = r13;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r13 = 3;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r14 = java.lang.Integer.valueOf(r12);	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r11[r13] = r14;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r13 = 4;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r14 = r27.zzi();	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r14 = r14.zzc();	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r14 = java.lang.Integer.valueOf(r14);	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r11[r13] = r14;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        com.google.android.gms.internal.zzaf.zzb(r0, r11);	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
    L_0x00d8:
        r0 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        if (r12 < r0) goto L_0x00f0;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
    L_0x00dc:
        r0 = 299; // 0x12b float:4.19E-43 double:1.477E-321;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        if (r12 > r0) goto L_0x00f0;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
    L_0x00e0:
        r0 = new com.google.android.gms.internal.zzp;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r14 = 0;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r15 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r15 = r15 - r3;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r11 = r0;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r13 = r8;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r17 = r5;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r11.<init>(r12, r13, r14, r15, r17);	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        return r0;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
    L_0x00f0:
        r0 = new java.io.IOException;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        r0.<init>();	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
        throw r0;	 Catch:{ SocketTimeoutException -> 0x018c, MalformedURLException -> 0x016b, IOException -> 0x00f6 }
    L_0x00f6:
        r0 = move-exception;
        r17 = r5;
        r13 = r8;
        goto L_0x0100;
    L_0x00fb:
        r0 = move-exception;
        r17 = r5;
        r10 = r8;
        r13 = r10;
    L_0x0100:
        if (r10 == 0) goto L_0x0165;
    L_0x0102:
        r0 = r10.getStatusCode();
        r5 = new java.lang.Object[r7];
        r7 = java.lang.Integer.valueOf(r0);
        r5[r9] = r7;
        r7 = r27.getUrl();
        r5[r6] = r7;
        r6 = "Unexpected response code %d for %s";
        com.google.android.gms.internal.zzaf.zzc(r6, r5);
        if (r13 == 0) goto L_0x015d;
    L_0x011b:
        r5 = new com.google.android.gms.internal.zzp;
        r14 = 0;
        r6 = android.os.SystemClock.elapsedRealtime();
        r15 = r6 - r3;
        r11 = r5;
        r12 = r0;
        r11.<init>(r12, r13, r14, r15, r17);
        r6 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r0 == r6) goto L_0x0155;
    L_0x012d:
        r6 = 403; // 0x193 float:5.65E-43 double:1.99E-321;
        if (r0 != r6) goto L_0x0132;
    L_0x0131:
        goto L_0x0155;
    L_0x0132:
        r2 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r0 < r2) goto L_0x0141;
    L_0x0136:
        r2 = 499; // 0x1f3 float:6.99E-43 double:2.465E-321;
        if (r0 <= r2) goto L_0x013b;
    L_0x013a:
        goto L_0x0141;
    L_0x013b:
        r0 = new com.google.android.gms.internal.zzg;
        r0.<init>(r5);
        throw r0;
    L_0x0141:
        r2 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        if (r0 < r2) goto L_0x014f;
    L_0x0145:
        r2 = 599; // 0x257 float:8.4E-43 double:2.96E-321;
        if (r0 > r2) goto L_0x014f;
    L_0x0149:
        r0 = new com.google.android.gms.internal.zzac;
        r0.<init>(r5);
        throw r0;
    L_0x014f:
        r0 = new com.google.android.gms.internal.zzac;
        r0.<init>(r5);
        throw r0;
    L_0x0155:
        r0 = new com.google.android.gms.internal.zza;
        r0.<init>(r5);
        r5 = "auth";
        goto L_0x0193;
    L_0x015d:
        r0 = new com.google.android.gms.internal.zzo;
        r0.<init>();
        r5 = "network";
        goto L_0x0193;
    L_0x0165:
        r2 = new com.google.android.gms.internal.zzq;
        r2.<init>(r0);
        throw r2;
    L_0x016b:
        r0 = move-exception;
        r3 = new java.lang.RuntimeException;
        r4 = "Bad URL ";
        r2 = r27.getUrl();
        r2 = java.lang.String.valueOf(r2);
        r5 = r2.length();
        if (r5 == 0) goto L_0x0183;
    L_0x017e:
        r2 = r4.concat(r2);
        goto L_0x0188;
    L_0x0183:
        r2 = new java.lang.String;
        r2.<init>(r4);
    L_0x0188:
        r3.<init>(r2, r0);
        throw r3;
    L_0x018c:
        r0 = new com.google.android.gms.internal.zzad;
        r0.<init>();
        r5 = "socket";
    L_0x0193:
        zza(r5, r2, r0);
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaj.zzc(com.google.android.gms.internal.zzr):com.google.android.gms.internal.zzp");
    }
}
