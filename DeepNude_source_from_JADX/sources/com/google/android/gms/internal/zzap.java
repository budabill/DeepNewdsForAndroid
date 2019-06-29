package com.google.android.gms.internal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.TreeMap;

public final class zzap {
    static List<zzl> zza(Map<String, String> map) {
        List<zzl> arrayList = new ArrayList(map.size());
        for (Entry entry : map.entrySet()) {
            arrayList.add(new zzl((String) entry.getKey(), (String) entry.getValue()));
        }
        return arrayList;
    }

    static Map<String, String> zza(List<zzl> list) {
        Map<String, String> treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (zzl zzl : list) {
            treeMap.put(zzl.getName(), zzl.getValue());
        }
        return treeMap;
    }

    public static com.google.android.gms.internal.zzc zzb(com.google.android.gms.internal.zzp r21) {
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
        r0 = r21;
        r1 = java.lang.System.currentTimeMillis();
        r3 = r0.zzab;
        r4 = "Date";
        r4 = r3.get(r4);
        r4 = (java.lang.String) r4;
        if (r4 == 0) goto L_0x0017;
    L_0x0012:
        r7 = zzf(r4);
        goto L_0x0019;
    L_0x0017:
        r7 = 0;
    L_0x0019:
        r4 = "Cache-Control";
        r4 = r3.get(r4);
        r4 = (java.lang.String) r4;
        r10 = 0;
        if (r4 == 0) goto L_0x0089;
    L_0x0024:
        r11 = ",";
        r4 = r4.split(r11);
        r11 = 0;
        r13 = 0;
        r14 = 0;
    L_0x002f:
        r9 = r4.length;
        if (r10 >= r9) goto L_0x0085;
    L_0x0032:
        r9 = r4[r10];
        r9 = r9.trim();
        r5 = "no-cache";
        r5 = r9.equals(r5);
        if (r5 != 0) goto L_0x0083;
    L_0x0040:
        r5 = "no-store";
        r5 = r9.equals(r5);
        if (r5 == 0) goto L_0x0049;
    L_0x0048:
        goto L_0x0083;
    L_0x0049:
        r5 = "max-age=";
        r5 = r9.startsWith(r5);
        if (r5 == 0) goto L_0x005c;
    L_0x0051:
        r5 = 8;
        r5 = r9.substring(r5);	 Catch:{ Exception -> 0x0080 }
        r11 = java.lang.Long.parseLong(r5);	 Catch:{ Exception -> 0x0080 }
        goto L_0x0080;
    L_0x005c:
        r5 = "stale-while-revalidate=";
        r5 = r9.startsWith(r5);
        if (r5 == 0) goto L_0x006f;
    L_0x0064:
        r5 = 23;
        r5 = r9.substring(r5);	 Catch:{ Exception -> 0x0080 }
        r14 = java.lang.Long.parseLong(r5);	 Catch:{ Exception -> 0x0080 }
        goto L_0x0080;
    L_0x006f:
        r5 = "must-revalidate";
        r5 = r9.equals(r5);
        if (r5 != 0) goto L_0x007f;
    L_0x0077:
        r5 = "proxy-revalidate";
        r5 = r9.equals(r5);
        if (r5 == 0) goto L_0x0080;
    L_0x007f:
        r13 = 1;
    L_0x0080:
        r10 = r10 + 1;
        goto L_0x002f;
    L_0x0083:
        r0 = 0;
        return r0;
    L_0x0085:
        r10 = r13;
        r16 = 1;
        goto L_0x008f;
    L_0x0089:
        r11 = 0;
        r14 = 0;
        r16 = 0;
    L_0x008f:
        r4 = "Expires";
        r4 = r3.get(r4);
        r4 = (java.lang.String) r4;
        if (r4 == 0) goto L_0x009e;
    L_0x0099:
        r5 = zzf(r4);
        goto L_0x00a0;
    L_0x009e:
        r5 = 0;
    L_0x00a0:
        r4 = "Last-Modified";
        r4 = r3.get(r4);
        r4 = (java.lang.String) r4;
        if (r4 == 0) goto L_0x00b1;
    L_0x00aa:
        r17 = zzf(r4);
        r19 = r17;
        goto L_0x00b3;
    L_0x00b1:
        r19 = 0;
    L_0x00b3:
        r4 = "ETag";
        r4 = r3.get(r4);
        r4 = (java.lang.String) r4;
        if (r16 == 0) goto L_0x00cd;
    L_0x00bd:
        r5 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r11 = r11 * r5;
        r1 = r1 + r11;
        if (r10 == 0) goto L_0x00c5;
    L_0x00c4:
        goto L_0x00dc;
    L_0x00c5:
        java.lang.Long.signum(r14);
        r14 = r14 * r5;
        r14 = r14 + r1;
        r5 = r14;
        goto L_0x00dd;
    L_0x00cd:
        r9 = 0;
        r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));
        if (r11 <= 0) goto L_0x00db;
    L_0x00d3:
        r11 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r11 < 0) goto L_0x00db;
    L_0x00d7:
        r5 = r5 - r7;
        r5 = r5 + r1;
        r1 = r5;
        goto L_0x00dd;
    L_0x00db:
        r1 = r9;
    L_0x00dc:
        r5 = r1;
    L_0x00dd:
        r9 = new com.google.android.gms.internal.zzc;
        r9.<init>();
        r10 = r0.data;
        r9.data = r10;
        r9.zza = r4;
        r9.zze = r1;
        r9.zzd = r5;
        r9.zzb = r7;
        r1 = r19;
        r9.zzc = r1;
        r9.zzf = r3;
        r0 = r0.allHeaders;
        r9.zzg = r0;
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzap.zzb(com.google.android.gms.internal.zzp):com.google.android.gms.internal.zzc");
    }

    static String zzb(long j) {
        return zzo().format(new Date(j));
    }

    public static String zzb(Map<String, String> map) {
        String str = (String) map.get("Content-Type");
        if (str != null) {
            String[] split = str.split(";");
            for (int i = 1; i < split.length; i++) {
                String[] split2 = split[i].trim().split("=");
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return "ISO-8859-1";
    }

    private static long zzf(String str) {
        try {
            return zzo().parse(str).getTime();
        } catch (Throwable e) {
            zzaf.zza(e, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0;
        }
    }

    private static SimpleDateFormat zzo() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }
}
