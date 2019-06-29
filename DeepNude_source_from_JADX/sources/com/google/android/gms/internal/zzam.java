package com.google.android.gms.internal;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class zzam implements zzb {
    private final Map<String, zzan> zzbw;
    private long zzbx;
    private final File zzby;
    private final int zzbz;

    public zzam(File file) {
        this(file, 5242880);
    }

    private zzam(File file, int i) {
        this.zzbw = new LinkedHashMap(16, 0.75f, true);
        this.zzbx = 0;
        this.zzby = file;
        this.zzbz = 5242880;
    }

    private final synchronized void remove(String str) {
        boolean delete = zze(str).delete();
        removeEntry(str);
        if (!delete) {
            zzaf.zzb("Could not delete cache entry for key=%s, filename=%s", str, zzd(str));
        }
    }

    private final void removeEntry(String str) {
        zzan zzan = (zzan) this.zzbw.remove(str);
        if (zzan != null) {
            this.zzbx -= zzan.zzca;
        }
    }

    private static int zza(InputStream inputStream) {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    private static InputStream zza(File file) {
        return new FileInputStream(file);
    }

    static String zza(zzao zzao) {
        return new String(zza(zzao, zzc(zzao)), "UTF-8");
    }

    static void zza(OutputStream outputStream, int i) {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write(i >>> 24);
    }

    static void zza(OutputStream outputStream, long j) {
        outputStream.write((byte) ((int) j));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static void zza(OutputStream outputStream, String str) {
        byte[] bytes = str.getBytes("UTF-8");
        zza(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private final void zza(String str, zzan zzan) {
        if (this.zzbw.containsKey(str)) {
            this.zzbx += zzan.zzca - ((zzan) this.zzbw.get(str)).zzca;
        } else {
            this.zzbx += zzan.zzca;
        }
        this.zzbw.put(str, zzan);
    }

    private static byte[] zza(zzao zzao, long j) {
        long zzn = zzao.zzn();
        if (j >= 0 && j <= zzn) {
            int i = (int) j;
            if (((long) i) == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(zzao).readFully(bArr);
                return bArr;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(73);
        stringBuilder.append("streamToBytes length=");
        stringBuilder.append(j);
        stringBuilder.append(", maxLength=");
        stringBuilder.append(zzn);
        throw new IOException(stringBuilder.toString());
    }

    static int zzb(InputStream inputStream) {
        return (zza(inputStream) << 24) | (((zza(inputStream) | 0) | (zza(inputStream) << 8)) | (zza(inputStream) << 16));
    }

    static List<zzl> zzb(zzao zzao) {
        int zzb = zzb((InputStream) zzao);
        List<zzl> emptyList = zzb == 0 ? Collections.emptyList() : new ArrayList(zzb);
        for (int i = 0; i < zzb; i++) {
            emptyList.add(new zzl(zza(zzao).intern(), zza(zzao).intern()));
        }
        return emptyList;
    }

    static long zzc(InputStream inputStream) {
        return ((((((((((long) zza(inputStream)) & 255) | 0) | ((((long) zza(inputStream)) & 255) << 8)) | ((((long) zza(inputStream)) & 255) << 16)) | ((((long) zza(inputStream)) & 255) << 24)) | ((((long) zza(inputStream)) & 255) << 32)) | ((((long) zza(inputStream)) & 255) << 40)) | ((((long) zza(inputStream)) & 255) << 48)) | ((255 & ((long) zza(inputStream))) << 56);
    }

    private static String zzd(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        str = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return str.length() != 0 ? valueOf.concat(str) : new String(valueOf);
    }

    private final File zze(String str) {
        return new File(this.zzby, zzd(str));
    }

    public final synchronized void initialize() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r9 = this;
        monitor-enter(r9);
        r0 = r9.zzby;	 Catch:{ all -> 0x0061 }
        r0 = r0.exists();	 Catch:{ all -> 0x0061 }
        r1 = 0;	 Catch:{ all -> 0x0061 }
        if (r0 != 0) goto L_0x0024;	 Catch:{ all -> 0x0061 }
    L_0x000a:
        r0 = r9.zzby;	 Catch:{ all -> 0x0061 }
        r0 = r0.mkdirs();	 Catch:{ all -> 0x0061 }
        if (r0 != 0) goto L_0x0022;	 Catch:{ all -> 0x0061 }
    L_0x0012:
        r0 = "Unable to create cache dir %s";	 Catch:{ all -> 0x0061 }
        r2 = 1;	 Catch:{ all -> 0x0061 }
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0061 }
        r3 = r9.zzby;	 Catch:{ all -> 0x0061 }
        r3 = r3.getAbsolutePath();	 Catch:{ all -> 0x0061 }
        r2[r1] = r3;	 Catch:{ all -> 0x0061 }
        com.google.android.gms.internal.zzaf.zzc(r0, r2);	 Catch:{ all -> 0x0061 }
    L_0x0022:
        monitor-exit(r9);
        return;
    L_0x0024:
        r0 = r9.zzby;	 Catch:{ all -> 0x0061 }
        r0 = r0.listFiles();	 Catch:{ all -> 0x0061 }
        if (r0 != 0) goto L_0x002e;
    L_0x002c:
        monitor-exit(r9);
        return;
    L_0x002e:
        r2 = r0.length;	 Catch:{ all -> 0x0061 }
    L_0x002f:
        if (r1 >= r2) goto L_0x005f;	 Catch:{ all -> 0x0061 }
    L_0x0031:
        r3 = r0[r1];	 Catch:{ all -> 0x0061 }
        r4 = r3.length();	 Catch:{ IOException -> 0x0059 }
        r6 = new com.google.android.gms.internal.zzao;	 Catch:{ IOException -> 0x0059 }
        r7 = new java.io.BufferedInputStream;	 Catch:{ IOException -> 0x0059 }
        r8 = zza(r3);	 Catch:{ IOException -> 0x0059 }
        r7.<init>(r8);	 Catch:{ IOException -> 0x0059 }
        r6.<init>(r7, r4);	 Catch:{ IOException -> 0x0059 }
        r7 = com.google.android.gms.internal.zzan.zzc(r6);	 Catch:{ all -> 0x0054 }
        r7.zzca = r4;	 Catch:{ all -> 0x0054 }
        r4 = r7.key;	 Catch:{ all -> 0x0054 }
        r9.zza(r4, r7);	 Catch:{ all -> 0x0054 }
        r6.close();	 Catch:{ IOException -> 0x0059 }
        goto L_0x005c;	 Catch:{ IOException -> 0x0059 }
    L_0x0054:
        r4 = move-exception;	 Catch:{ IOException -> 0x0059 }
        r6.close();	 Catch:{ IOException -> 0x0059 }
        throw r4;	 Catch:{ IOException -> 0x0059 }
    L_0x0059:
        r3.delete();	 Catch:{ all -> 0x0061 }
    L_0x005c:
        r1 = r1 + 1;
        goto L_0x002f;
    L_0x005f:
        monitor-exit(r9);
        return;
    L_0x0061:
        r0 = move-exception;
        monitor-exit(r9);
        goto L_0x0065;
    L_0x0064:
        throw r0;
    L_0x0065:
        goto L_0x0064;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzam.initialize():void");
    }

    public final synchronized zzc zza(String str) {
        zzao zzao;
        zzan zzan = (zzan) this.zzbw.get(str);
        if (zzan == null) {
            return null;
        }
        File zze = zze(str);
        try {
            zzao = new zzao(new BufferedInputStream(zza(zze)), zze.length());
            if (TextUtils.equals(str, zzan.zzc(zzao).key)) {
                byte[] zza = zza(zzao, zzao.zzn());
                zzc zzc = new zzc();
                zzc.data = zza;
                zzc.zza = zzan.zza;
                zzc.zzb = zzan.zzb;
                zzc.zzc = zzan.zzc;
                zzc.zzd = zzan.zzd;
                zzc.zze = zzan.zze;
                zzc.zzf = zzap.zza(zzan.zzg);
                zzc.zzg = Collections.unmodifiableList(zzan.zzg);
                zzao.close();
                return zzc;
            }
            zzaf.zzb("%s: key=%s, found=%s", zze.getAbsolutePath(), str, zzan.zzc(zzao).key);
            removeEntry(str);
            zzao.close();
            return null;
        } catch (IOException e) {
            zzaf.zzb("%s: %s", zze.getAbsolutePath(), e.toString());
            remove(str);
            return null;
        } catch (Throwable th) {
            zzao.close();
        }
    }

    public final synchronized void zza(java.lang.String r20, com.google.android.gms.internal.zzc r21) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r19 = this;
        r1 = r19;
        r0 = r20;
        r2 = r21;
        monitor-enter(r19);
        r3 = r2.data;	 Catch:{ all -> 0x0112 }
        r3 = r3.length;	 Catch:{ all -> 0x0112 }
        r4 = r1.zzbx;	 Catch:{ all -> 0x0112 }
        r6 = (long) r3;	 Catch:{ all -> 0x0112 }
        r4 = r4 + r6;	 Catch:{ all -> 0x0112 }
        r3 = r1.zzbz;	 Catch:{ all -> 0x0112 }
        r8 = (long) r3;	 Catch:{ all -> 0x0112 }
        r10 = 0;	 Catch:{ all -> 0x0112 }
        r11 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));	 Catch:{ all -> 0x0112 }
        if (r11 < 0) goto L_0x00bd;	 Catch:{ all -> 0x0112 }
    L_0x0016:
        r4 = com.google.android.gms.internal.zzaf.DEBUG;	 Catch:{ all -> 0x0112 }
        if (r4 == 0) goto L_0x0021;	 Catch:{ all -> 0x0112 }
    L_0x001a:
        r4 = "Pruning old cache entries.";	 Catch:{ all -> 0x0112 }
        r5 = new java.lang.Object[r10];	 Catch:{ all -> 0x0112 }
        com.google.android.gms.internal.zzaf.zza(r4, r5);	 Catch:{ all -> 0x0112 }
    L_0x0021:
        r4 = r1.zzbx;	 Catch:{ all -> 0x0112 }
        r8 = android.os.SystemClock.elapsedRealtime();	 Catch:{ all -> 0x0112 }
        r11 = r1.zzbw;	 Catch:{ all -> 0x0112 }
        r11 = r11.entrySet();	 Catch:{ all -> 0x0112 }
        r11 = r11.iterator();	 Catch:{ all -> 0x0112 }
        r12 = 0;	 Catch:{ all -> 0x0112 }
    L_0x0032:
        r13 = r11.hasNext();	 Catch:{ all -> 0x0112 }
        r14 = 2;	 Catch:{ all -> 0x0112 }
        if (r13 == 0) goto L_0x0092;	 Catch:{ all -> 0x0112 }
    L_0x0039:
        r13 = r11.next();	 Catch:{ all -> 0x0112 }
        r13 = (java.util.Map.Entry) r13;	 Catch:{ all -> 0x0112 }
        r13 = r13.getValue();	 Catch:{ all -> 0x0112 }
        r13 = (com.google.android.gms.internal.zzan) r13;	 Catch:{ all -> 0x0112 }
        r15 = r13.key;	 Catch:{ all -> 0x0112 }
        r15 = r1.zze(r15);	 Catch:{ all -> 0x0112 }
        r15 = r15.delete();	 Catch:{ all -> 0x0112 }
        if (r15 == 0) goto L_0x005d;	 Catch:{ all -> 0x0112 }
    L_0x0051:
        r16 = r4;	 Catch:{ all -> 0x0112 }
        r3 = r1.zzbx;	 Catch:{ all -> 0x0112 }
        r18 = r11;	 Catch:{ all -> 0x0112 }
        r10 = r13.zzca;	 Catch:{ all -> 0x0112 }
        r3 = r3 - r10;	 Catch:{ all -> 0x0112 }
        r1.zzbx = r3;	 Catch:{ all -> 0x0112 }
        goto L_0x0076;	 Catch:{ all -> 0x0112 }
    L_0x005d:
        r16 = r4;	 Catch:{ all -> 0x0112 }
        r18 = r11;	 Catch:{ all -> 0x0112 }
        r3 = "Could not delete cache entry for key=%s, filename=%s";	 Catch:{ all -> 0x0112 }
        r4 = new java.lang.Object[r14];	 Catch:{ all -> 0x0112 }
        r10 = r13.key;	 Catch:{ all -> 0x0112 }
        r5 = 0;	 Catch:{ all -> 0x0112 }
        r4[r5] = r10;	 Catch:{ all -> 0x0112 }
        r10 = r13.key;	 Catch:{ all -> 0x0112 }
        r10 = zzd(r10);	 Catch:{ all -> 0x0112 }
        r11 = 1;	 Catch:{ all -> 0x0112 }
        r4[r11] = r10;	 Catch:{ all -> 0x0112 }
        com.google.android.gms.internal.zzaf.zzb(r3, r4);	 Catch:{ all -> 0x0112 }
    L_0x0076:
        r18.remove();	 Catch:{ all -> 0x0112 }
        r12 = r12 + 1;	 Catch:{ all -> 0x0112 }
        r3 = r1.zzbx;	 Catch:{ all -> 0x0112 }
        r3 = r3 + r6;	 Catch:{ all -> 0x0112 }
        r3 = (float) r3;	 Catch:{ all -> 0x0112 }
        r4 = r1.zzbz;	 Catch:{ all -> 0x0112 }
        r4 = (float) r4;	 Catch:{ all -> 0x0112 }
        r10 = 1063675494; // 0x3f666666 float:0.9 double:5.2552552E-315;	 Catch:{ all -> 0x0112 }
        r4 = r4 * r10;	 Catch:{ all -> 0x0112 }
        r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1));	 Catch:{ all -> 0x0112 }
        if (r3 >= 0) goto L_0x008c;	 Catch:{ all -> 0x0112 }
    L_0x008b:
        goto L_0x0094;	 Catch:{ all -> 0x0112 }
    L_0x008c:
        r4 = r16;	 Catch:{ all -> 0x0112 }
        r11 = r18;	 Catch:{ all -> 0x0112 }
        r10 = 0;	 Catch:{ all -> 0x0112 }
        goto L_0x0032;	 Catch:{ all -> 0x0112 }
    L_0x0092:
        r16 = r4;	 Catch:{ all -> 0x0112 }
    L_0x0094:
        r3 = com.google.android.gms.internal.zzaf.DEBUG;	 Catch:{ all -> 0x0112 }
        if (r3 == 0) goto L_0x00bd;	 Catch:{ all -> 0x0112 }
    L_0x0098:
        r3 = "pruned %d files, %d bytes, %d ms";	 Catch:{ all -> 0x0112 }
        r4 = 3;	 Catch:{ all -> 0x0112 }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0112 }
        r6 = java.lang.Integer.valueOf(r12);	 Catch:{ all -> 0x0112 }
        r5 = 0;	 Catch:{ all -> 0x0112 }
        r4[r5] = r6;	 Catch:{ all -> 0x0112 }
        r6 = r1.zzbx;	 Catch:{ all -> 0x0112 }
        r6 = r6 - r16;	 Catch:{ all -> 0x0112 }
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x0112 }
        r7 = 1;	 Catch:{ all -> 0x0112 }
        r4[r7] = r6;	 Catch:{ all -> 0x0112 }
        r6 = android.os.SystemClock.elapsedRealtime();	 Catch:{ all -> 0x0112 }
        r6 = r6 - r8;	 Catch:{ all -> 0x0112 }
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x0112 }
        r4[r14] = r6;	 Catch:{ all -> 0x0112 }
        com.google.android.gms.internal.zzaf.zza(r3, r4);	 Catch:{ all -> 0x0112 }
    L_0x00bd:
        r3 = r19.zze(r20);	 Catch:{ all -> 0x0112 }
        r4 = new java.io.BufferedOutputStream;	 Catch:{ IOException -> 0x00fb }
        r6 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x00fb }
        r6.<init>(r3);	 Catch:{ IOException -> 0x00fb }
        r4.<init>(r6);	 Catch:{ IOException -> 0x00fb }
        r6 = new com.google.android.gms.internal.zzan;	 Catch:{ IOException -> 0x00fb }
        r6.<init>(r0, r2);	 Catch:{ IOException -> 0x00fb }
        r7 = r6.zza(r4);	 Catch:{ IOException -> 0x00fb }
        if (r7 == 0) goto L_0x00e3;	 Catch:{ IOException -> 0x00fb }
    L_0x00d6:
        r2 = r2.data;	 Catch:{ IOException -> 0x00fb }
        r4.write(r2);	 Catch:{ IOException -> 0x00fb }
        r4.close();	 Catch:{ IOException -> 0x00fb }
        r1.zza(r0, r6);	 Catch:{ IOException -> 0x00fb }
        monitor-exit(r19);
        return;
    L_0x00e3:
        r4.close();	 Catch:{ IOException -> 0x00fb }
        r0 = "Failed to write header for %s";	 Catch:{ IOException -> 0x00fb }
        r2 = 1;	 Catch:{ IOException -> 0x00fb }
        r4 = new java.lang.Object[r2];	 Catch:{ IOException -> 0x00fb }
        r2 = r3.getAbsolutePath();	 Catch:{ IOException -> 0x00fb }
        r5 = 0;	 Catch:{ IOException -> 0x00fb }
        r4[r5] = r2;	 Catch:{ IOException -> 0x00fb }
        com.google.android.gms.internal.zzaf.zzb(r0, r4);	 Catch:{ IOException -> 0x00fb }
        r0 = new java.io.IOException;	 Catch:{ IOException -> 0x00fb }
        r0.<init>();	 Catch:{ IOException -> 0x00fb }
        throw r0;	 Catch:{ IOException -> 0x00fb }
    L_0x00fb:
        r0 = r3.delete();	 Catch:{ all -> 0x0112 }
        if (r0 != 0) goto L_0x0110;	 Catch:{ all -> 0x0112 }
    L_0x0101:
        r0 = "Could not clean up file %s";	 Catch:{ all -> 0x0112 }
        r2 = 1;	 Catch:{ all -> 0x0112 }
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0112 }
        r3 = r3.getAbsolutePath();	 Catch:{ all -> 0x0112 }
        r4 = 0;	 Catch:{ all -> 0x0112 }
        r2[r4] = r3;	 Catch:{ all -> 0x0112 }
        com.google.android.gms.internal.zzaf.zzb(r0, r2);	 Catch:{ all -> 0x0112 }
    L_0x0110:
        monitor-exit(r19);
        return;
    L_0x0112:
        r0 = move-exception;
        monitor-exit(r19);
        goto L_0x0116;
    L_0x0115:
        throw r0;
    L_0x0116:
        goto L_0x0115;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzam.zza(java.lang.String, com.google.android.gms.internal.zzc):void");
    }
}
