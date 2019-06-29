package com.google.android.gms.internal;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.SSLSocketFactory;

public final class zzas extends zzai {
    private final zzat zzcg;
    private final SSLSocketFactory zzch;

    public zzas() {
        this(null);
    }

    private zzas(zzat zzat) {
        this(null, null);
    }

    private zzas(zzat zzat, SSLSocketFactory sSLSocketFactory) {
        this.zzcg = null;
        this.zzch = null;
    }

    private static java.io.InputStream zza(java.net.HttpURLConnection r0) {
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
        r0 = r0.getInputStream();	 Catch:{ IOException -> 0x0005 }
        goto L_0x0009;
    L_0x0005:
        r0 = r0.getErrorStream();
    L_0x0009:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzas.zza(java.net.HttpURLConnection):java.io.InputStream");
    }

    private static void zza(HttpURLConnection httpURLConnection, zzr<?> zzr) {
        byte[] zzf = zzr.zzf();
        if (zzf != null) {
            httpURLConnection.setDoOutput(true);
            String str = "application/x-www-form-urlencoded; charset=";
            String str2 = "UTF-8";
            httpURLConnection.addRequestProperty("Content-Type", str2.length() != 0 ? str.concat(str2) : new String(str));
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(zzf);
            dataOutputStream.close();
        }
    }

    private static List<zzl> zzc(Map<String, List<String>> map) {
        List<zzl> arrayList = new ArrayList(map.size());
        for (Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                for (String zzl : (List) entry.getValue()) {
                    arrayList.add(new zzl((String) entry.getKey(), zzl));
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.zzaq zza(com.google.android.gms.internal.zzr<?> r7, java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
        r6 = this;
        r0 = r7.getUrl();
        r1 = new java.util.HashMap;
        r1.<init>();
        r2 = r7.getHeaders();
        r1.putAll(r2);
        r1.putAll(r8);
        r8 = r6.zzcg;
        if (r8 == 0) goto L_0x003a;
    L_0x0017:
        r8 = r8.zzg(r0);
        if (r8 != 0) goto L_0x003b;
    L_0x001d:
        r7 = new java.io.IOException;
        r8 = "URL blocked by rewriter: ";
        r0 = java.lang.String.valueOf(r0);
        r1 = r0.length();
        if (r1 == 0) goto L_0x0030;
    L_0x002b:
        r8 = r8.concat(r0);
        goto L_0x0036;
    L_0x0030:
        r0 = new java.lang.String;
        r0.<init>(r8);
        r8 = r0;
    L_0x0036:
        r7.<init>(r8);
        throw r7;
    L_0x003a:
        r8 = r0;
    L_0x003b:
        r0 = new java.net.URL;
        r0.<init>(r8);
        r8 = r0.openConnection();
        r8 = (java.net.HttpURLConnection) r8;
        r2 = java.net.HttpURLConnection.getFollowRedirects();
        r8.setInstanceFollowRedirects(r2);
        r2 = r7.zzh();
        r8.setConnectTimeout(r2);
        r8.setReadTimeout(r2);
        r2 = 0;
        r8.setUseCaches(r2);
        r3 = 1;
        r8.setDoInput(r3);
        r0 = r0.getProtocol();
        r4 = "https";
        r4.equals(r0);
        r0 = r1.keySet();
        r0 = r0.iterator();
    L_0x0070:
        r4 = r0.hasNext();
        if (r4 == 0) goto L_0x0086;
    L_0x0076:
        r4 = r0.next();
        r4 = (java.lang.String) r4;
        r5 = r1.get(r4);
        r5 = (java.lang.String) r5;
        r8.addRequestProperty(r4, r5);
        goto L_0x0070;
    L_0x0086:
        r0 = r7.getMethod();
        switch(r0) {
            case -1: goto L_0x00b5;
            case 0: goto L_0x00b0;
            case 1: goto L_0x00a7;
            case 2: goto L_0x00a4;
            case 3: goto L_0x00a1;
            case 4: goto L_0x009e;
            case 5: goto L_0x009b;
            case 6: goto L_0x0098;
            case 7: goto L_0x0095;
            default: goto L_0x008d;
        };
    L_0x008d:
        r7 = new java.lang.IllegalStateException;
        r8 = "Unknown method type.";
        r7.<init>(r8);
        throw r7;
    L_0x0095:
        r0 = "PATCH";
        goto L_0x00a9;
    L_0x0098:
        r0 = "TRACE";
        goto L_0x00b2;
    L_0x009b:
        r0 = "OPTIONS";
        goto L_0x00b2;
    L_0x009e:
        r0 = "HEAD";
        goto L_0x00b2;
    L_0x00a1:
        r0 = "DELETE";
        goto L_0x00b2;
    L_0x00a4:
        r0 = "PUT";
        goto L_0x00a9;
    L_0x00a7:
        r0 = "POST";
    L_0x00a9:
        r8.setRequestMethod(r0);
        zza(r8, r7);
        goto L_0x00b5;
    L_0x00b0:
        r0 = "GET";
    L_0x00b2:
        r8.setRequestMethod(r0);
    L_0x00b5:
        r0 = r8.getResponseCode();
        r1 = -1;
        if (r0 == r1) goto L_0x00fa;
    L_0x00bc:
        r7 = r7.getMethod();
        r1 = 4;
        if (r7 == r1) goto L_0x00d4;
    L_0x00c3:
        r7 = 100;
        if (r7 > r0) goto L_0x00cb;
    L_0x00c7:
        r7 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 < r7) goto L_0x00d4;
    L_0x00cb:
        r7 = 204; // 0xcc float:2.86E-43 double:1.01E-321;
        if (r0 == r7) goto L_0x00d4;
    L_0x00cf:
        r7 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        if (r0 == r7) goto L_0x00d4;
    L_0x00d3:
        r2 = 1;
    L_0x00d4:
        if (r2 != 0) goto L_0x00e4;
    L_0x00d6:
        r7 = new com.google.android.gms.internal.zzaq;
        r8 = r8.getHeaderFields();
        r8 = zzc(r8);
        r7.<init>(r0, r8);
        return r7;
    L_0x00e4:
        r7 = new com.google.android.gms.internal.zzaq;
        r1 = r8.getHeaderFields();
        r1 = zzc(r1);
        r2 = r8.getContentLength();
        r8 = zza(r8);
        r7.<init>(r0, r1, r2, r8);
        return r7;
    L_0x00fa:
        r7 = new java.io.IOException;
        r8 = "Could not retrieve response code from HttpUrlConnection.";
        r7.<init>(r8);
        goto L_0x0103;
    L_0x0102:
        throw r7;
    L_0x0103:
        goto L_0x0102;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzas.zza(com.google.android.gms.internal.zzr, java.util.Map):com.google.android.gms.internal.zzaq");
    }
}
