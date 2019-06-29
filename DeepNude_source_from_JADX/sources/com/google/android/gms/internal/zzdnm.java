package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class zzdnm {
    private static Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    private static Uri zzlxf = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    private static Pattern zzlxg = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    private static Pattern zzlxh = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final AtomicBoolean zzlxi = new AtomicBoolean();
    private static HashMap<String, String> zzlxj;
    private static HashMap<String, Boolean> zzlxk = new HashMap();
    private static HashMap<String, Integer> zzlxl = new HashMap();
    private static HashMap<String, Long> zzlxm = new HashMap();
    private static HashMap<String, Float> zzlxn = new HashMap();
    private static Object zzlxo;
    private static boolean zzlxp;
    private static String[] zzlxq = new String[0];

    public static long getLong(android.content.ContentResolver r4, java.lang.String r5, long r6) {
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
        r6 = zzb(r4);
        r7 = zzlxm;
        r0 = 0;
        r2 = java.lang.Long.valueOf(r0);
        r7 = zza(r7, r5, r2);
        r7 = (java.lang.Long) r7;
        if (r7 == 0) goto L_0x0019;
    L_0x0014:
        r4 = r7.longValue();
        return r4;
    L_0x0019:
        r2 = 0;
        r4 = zza(r4, r5, r2);
        if (r4 != 0) goto L_0x0021;
    L_0x0020:
        goto L_0x002a;
    L_0x0021:
        r2 = java.lang.Long.parseLong(r4);	 Catch:{ NumberFormatException -> 0x002a }
        r7 = java.lang.Long.valueOf(r2);	 Catch:{ NumberFormatException -> 0x002a }
        r0 = r2;
    L_0x002a:
        r4 = zzlxm;
        zza(r6, r4, r5, r7);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdnm.getLong(android.content.ContentResolver, java.lang.String, long):long");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> T zza(java.util.HashMap<java.lang.String, T> r2, java.lang.String r3, T r4) {
        /*
        r0 = com.google.android.gms.internal.zzdnm.class;
        monitor-enter(r0);
        r1 = r2.containsKey(r3);	 Catch:{ all -> 0x0016 }
        if (r1 == 0) goto L_0x0013;
    L_0x0009:
        r2 = r2.get(r3);	 Catch:{ all -> 0x0016 }
        if (r2 == 0) goto L_0x0010;
    L_0x000f:
        goto L_0x0011;
    L_0x0010:
        r2 = r4;
    L_0x0011:
        monitor-exit(r0);	 Catch:{ all -> 0x0016 }
        return r2;
    L_0x0013:
        monitor-exit(r0);	 Catch:{ all -> 0x0016 }
        r2 = 0;
        return r2;
    L_0x0016:
        r2 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0016 }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdnm.zza(java.util.HashMap, java.lang.String, java.lang.Object):T");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String zza(android.content.ContentResolver r13, java.lang.String r14, java.lang.String r15) {
        /*
        r15 = com.google.android.gms.internal.zzdnm.class;
        monitor-enter(r15);
        zza(r13);	 Catch:{ all -> 0x00a5 }
        r0 = zzlxo;	 Catch:{ all -> 0x00a5 }
        r1 = zzlxj;	 Catch:{ all -> 0x00a5 }
        r1 = r1.containsKey(r14);	 Catch:{ all -> 0x00a5 }
        r2 = 0;
        if (r1 == 0) goto L_0x001f;
    L_0x0011:
        r13 = zzlxj;	 Catch:{ all -> 0x00a5 }
        r13 = r13.get(r14);	 Catch:{ all -> 0x00a5 }
        r13 = (java.lang.String) r13;	 Catch:{ all -> 0x00a5 }
        if (r13 == 0) goto L_0x001c;
    L_0x001b:
        goto L_0x001d;
    L_0x001c:
        r13 = r2;
    L_0x001d:
        monitor-exit(r15);	 Catch:{ all -> 0x00a5 }
        return r13;
    L_0x001f:
        r1 = zzlxq;	 Catch:{ all -> 0x00a5 }
        r3 = r1.length;	 Catch:{ all -> 0x00a5 }
        r4 = 0;
        r5 = 0;
    L_0x0024:
        r6 = 1;
        if (r5 >= r3) goto L_0x0063;
    L_0x0027:
        r7 = r1[r5];	 Catch:{ all -> 0x00a5 }
        r7 = r14.startsWith(r7);	 Catch:{ all -> 0x00a5 }
        if (r7 == 0) goto L_0x0060;
    L_0x002f:
        r0 = zzlxp;	 Catch:{ all -> 0x00a5 }
        if (r0 == 0) goto L_0x003b;
    L_0x0033:
        r0 = zzlxj;	 Catch:{ all -> 0x00a5 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x00a5 }
        if (r0 == 0) goto L_0x005e;
    L_0x003b:
        r0 = zzlxq;	 Catch:{ all -> 0x00a5 }
        r1 = zzlxj;	 Catch:{ all -> 0x00a5 }
        r13 = zza(r13, r0);	 Catch:{ all -> 0x00a5 }
        r1.putAll(r13);	 Catch:{ all -> 0x00a5 }
        zzlxp = r6;	 Catch:{ all -> 0x00a5 }
        r13 = zzlxj;	 Catch:{ all -> 0x00a5 }
        r13 = r13.containsKey(r14);	 Catch:{ all -> 0x00a5 }
        if (r13 == 0) goto L_0x005e;
    L_0x0050:
        r13 = zzlxj;	 Catch:{ all -> 0x00a5 }
        r13 = r13.get(r14);	 Catch:{ all -> 0x00a5 }
        r13 = (java.lang.String) r13;	 Catch:{ all -> 0x00a5 }
        if (r13 == 0) goto L_0x005b;
    L_0x005a:
        goto L_0x005c;
    L_0x005b:
        r13 = r2;
    L_0x005c:
        monitor-exit(r15);	 Catch:{ all -> 0x00a5 }
        return r13;
    L_0x005e:
        monitor-exit(r15);	 Catch:{ all -> 0x00a5 }
        return r2;
    L_0x0060:
        r5 = r5 + 1;
        goto L_0x0024;
    L_0x0063:
        monitor-exit(r15);	 Catch:{ all -> 0x00a5 }
        r8 = CONTENT_URI;
        r9 = 0;
        r10 = 0;
        r11 = new java.lang.String[r6];
        r11[r4] = r14;
        r12 = 0;
        r7 = r13;
        r13 = r7.query(r8, r9, r10, r11, r12);
        if (r13 == 0) goto L_0x0095;
    L_0x0074:
        r15 = r13.moveToFirst();	 Catch:{ all -> 0x009e }
        if (r15 != 0) goto L_0x007b;
    L_0x007a:
        goto L_0x0095;
    L_0x007b:
        r15 = r13.getString(r6);	 Catch:{ all -> 0x009e }
        if (r15 == 0) goto L_0x0088;
    L_0x0081:
        r1 = r15.equals(r2);	 Catch:{ all -> 0x009e }
        if (r1 == 0) goto L_0x0088;
    L_0x0087:
        r15 = r2;
    L_0x0088:
        zza(r0, r14, r15);	 Catch:{ all -> 0x009e }
        if (r15 == 0) goto L_0x008e;
    L_0x008d:
        goto L_0x008f;
    L_0x008e:
        r15 = r2;
    L_0x008f:
        if (r13 == 0) goto L_0x0094;
    L_0x0091:
        r13.close();
    L_0x0094:
        return r15;
    L_0x0095:
        zza(r0, r14, r2);	 Catch:{ all -> 0x009e }
        if (r13 == 0) goto L_0x009d;
    L_0x009a:
        r13.close();
    L_0x009d:
        return r2;
    L_0x009e:
        r14 = move-exception;
        if (r13 == 0) goto L_0x00a4;
    L_0x00a1:
        r13.close();
    L_0x00a4:
        throw r14;
    L_0x00a5:
        r13 = move-exception;
        monitor-exit(r15);	 Catch:{ all -> 0x00a5 }
        goto L_0x00a9;
    L_0x00a8:
        throw r13;
    L_0x00a9:
        goto L_0x00a8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdnm.zza(android.content.ContentResolver, java.lang.String, java.lang.String):java.lang.String");
    }

    private static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(zzlxf, null, null, strArr, null);
        Map<String, String> treeMap = new TreeMap();
        if (query == null) {
            return treeMap;
        }
        while (query.moveToNext()) {
            try {
                treeMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return treeMap;
    }

    private static void zza(ContentResolver contentResolver) {
        if (zzlxj == null) {
            zzlxi.set(false);
            zzlxj = new HashMap();
            zzlxo = new Object();
            zzlxp = false;
            contentResolver.registerContentObserver(CONTENT_URI, true, new zzdnn(null));
            return;
        }
        if (zzlxi.getAndSet(false)) {
            zzlxj.clear();
            zzlxk.clear();
            zzlxl.clear();
            zzlxm.clear();
            zzlxn.clear();
            zzlxo = new Object();
            zzlxp = false;
        }
    }

    private static void zza(Object obj, String str, String str2) {
        synchronized (zzdnm.class) {
            if (obj == zzlxo) {
                zzlxj.put(str, str2);
            }
        }
    }

    private static <T> void zza(Object obj, HashMap<String, T> hashMap, String str, T t) {
        synchronized (zzdnm.class) {
            if (obj == zzlxo) {
                hashMap.put(str, t);
                zzlxj.remove(str);
            }
        }
    }

    public static boolean zza(ContentResolver contentResolver, String str, boolean z) {
        Object zzb = zzb(contentResolver);
        Object obj = (Boolean) zza(zzlxk, str, Boolean.valueOf(z));
        if (obj != null) {
            return obj.booleanValue();
        }
        Object zza = zza(contentResolver, str, null);
        if (zza != null) {
            if (!zza.equals("")) {
                if (zzlxg.matcher(zza).matches()) {
                    obj = Boolean.valueOf(true);
                    z = true;
                } else if (zzlxh.matcher(zza).matches()) {
                    obj = Boolean.valueOf(false);
                    z = false;
                } else {
                    StringBuilder stringBuilder = new StringBuilder("attempt to read gservices key ");
                    stringBuilder.append(str);
                    stringBuilder.append(" (value \"");
                    stringBuilder.append(zza);
                    stringBuilder.append("\") as boolean");
                    Log.w("Gservices", stringBuilder.toString());
                }
            }
        }
        zza(zzb, zzlxk, str, obj);
        return z;
    }

    private static Object zzb(ContentResolver contentResolver) {
        Object obj;
        synchronized (zzdnm.class) {
            zza(contentResolver);
            obj = zzlxo;
        }
        return obj;
    }
}
