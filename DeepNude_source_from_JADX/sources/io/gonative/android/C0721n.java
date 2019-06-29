package io.gonative.android;

import android.content.Context;

/* renamed from: io.gonative.android.n */
public class C0721n {
    /* renamed from: a */
    private static final String f1622a = "io.gonative.android.n";
    /* renamed from: b */
    private Context f1623b;
    /* renamed from: c */
    private String f1624c;
    /* renamed from: d */
    private boolean f1625d = false;

    C0721n(Context context) {
        this.f1623b = context;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static boolean m1942a(java.lang.String r0, java.lang.String r1) {
        /*
        if (r0 != 0) goto L_0x0005;
    L_0x0002:
        if (r1 != 0) goto L_0x000b;
    L_0x0004:
        goto L_0x000d;
    L_0x0005:
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x000d;
    L_0x000b:
        r0 = 1;
        goto L_0x000e;
    L_0x000d:
        r0 = 0;
    L_0x000e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.gonative.android.n.a(java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: b */
    private static boolean m1943b(java.lang.String r4, java.lang.String r5) {
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
        r0 = 0;
        if (r4 == 0) goto L_0x0091;
    L_0x0003:
        if (r5 != 0) goto L_0x0007;
    L_0x0005:
        goto L_0x0091;
    L_0x0007:
        r1 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x0091 }
        r1.<init>(r4);	 Catch:{ MalformedURLException -> 0x0091 }
        r4 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x0091 }
        r4.<init>(r5);	 Catch:{ MalformedURLException -> 0x0091 }
        r5 = r1.getProtocol();	 Catch:{ MalformedURLException -> 0x0091 }
        r2 = r4.getProtocol();	 Catch:{ MalformedURLException -> 0x0091 }
        r5 = io.gonative.android.C0721n.m1942a(r5, r2);	 Catch:{ MalformedURLException -> 0x0091 }
        if (r5 == 0) goto L_0x0020;	 Catch:{ MalformedURLException -> 0x0091 }
    L_0x001f:
        return r0;	 Catch:{ MalformedURLException -> 0x0091 }
    L_0x0020:
        r5 = r1.getAuthority();	 Catch:{ MalformedURLException -> 0x0091 }
        r2 = r4.getAuthority();	 Catch:{ MalformedURLException -> 0x0091 }
        r5 = io.gonative.android.C0721n.m1942a(r5, r2);	 Catch:{ MalformedURLException -> 0x0091 }
        if (r5 == 0) goto L_0x002f;	 Catch:{ MalformedURLException -> 0x0091 }
    L_0x002e:
        return r0;	 Catch:{ MalformedURLException -> 0x0091 }
    L_0x002f:
        r5 = r1.getQuery();	 Catch:{ MalformedURLException -> 0x0091 }
        r2 = r4.getQuery();	 Catch:{ MalformedURLException -> 0x0091 }
        r5 = io.gonative.android.C0721n.m1942a(r5, r2);	 Catch:{ MalformedURLException -> 0x0091 }
        if (r5 == 0) goto L_0x003e;	 Catch:{ MalformedURLException -> 0x0091 }
    L_0x003d:
        return r0;	 Catch:{ MalformedURLException -> 0x0091 }
    L_0x003e:
        r5 = r1.getPath();	 Catch:{ MalformedURLException -> 0x0091 }
        r4 = r4.getPath();	 Catch:{ MalformedURLException -> 0x0091 }
        r1 = "";
        if (r5 != 0) goto L_0x004b;
    L_0x004a:
        r5 = r1;
    L_0x004b:
        if (r4 != 0) goto L_0x004e;
    L_0x004d:
        r4 = r1;
    L_0x004e:
        r1 = r4.length();	 Catch:{ MalformedURLException -> 0x0091 }
        r2 = r4.length();	 Catch:{ MalformedURLException -> 0x0091 }
        r1 = r1 - r2;	 Catch:{ MalformedURLException -> 0x0091 }
        r2 = 1;	 Catch:{ MalformedURLException -> 0x0091 }
        if (r1 > r2) goto L_0x0091;	 Catch:{ MalformedURLException -> 0x0091 }
    L_0x005a:
        r3 = -1;	 Catch:{ MalformedURLException -> 0x0091 }
        if (r1 >= r3) goto L_0x005e;	 Catch:{ MalformedURLException -> 0x0091 }
    L_0x005d:
        goto L_0x0091;	 Catch:{ MalformedURLException -> 0x0091 }
    L_0x005e:
        if (r1 != 0) goto L_0x0065;	 Catch:{ MalformedURLException -> 0x0091 }
    L_0x0060:
        r4 = r5.equals(r4);	 Catch:{ MalformedURLException -> 0x0091 }
        return r4;
    L_0x0065:
        r3 = "/";
        if (r1 != r2) goto L_0x007d;
    L_0x0069:
        r1 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x0091 }
        r1.<init>();	 Catch:{ MalformedURLException -> 0x0091 }
        r1.append(r5);	 Catch:{ MalformedURLException -> 0x0091 }
        r1.append(r3);	 Catch:{ MalformedURLException -> 0x0091 }
        r5 = r1.toString();	 Catch:{ MalformedURLException -> 0x0091 }
        r4 = r4.equals(r5);	 Catch:{ MalformedURLException -> 0x0091 }
        return r4;	 Catch:{ MalformedURLException -> 0x0091 }
    L_0x007d:
        r1 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x0091 }
        r1.<init>();	 Catch:{ MalformedURLException -> 0x0091 }
        r1.append(r4);	 Catch:{ MalformedURLException -> 0x0091 }
        r1.append(r3);	 Catch:{ MalformedURLException -> 0x0091 }
        r4 = r1.toString();	 Catch:{ MalformedURLException -> 0x0091 }
        r4 = r5.equals(r4);	 Catch:{ MalformedURLException -> 0x0091 }
        return r4;
    L_0x0091:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.gonative.android.n.b(java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: a */
    public android.webkit.WebResourceResponse m1944a(io.gonative.android.C0720m r18, java.lang.String r19, java.lang.String r20) {
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
        r17 = this;
        r1 = r17;
        r0 = r19;
        r2 = r20;
        r3 = android.os.Build.VERSION.SDK_INT;
        r4 = 0;
        r5 = 19;
        if (r3 != r5) goto L_0x000e;
    L_0x000d:
        return r4;
    L_0x000e:
        r3 = r1.f1623b;
        r3 = io.gonative.android.p038a.C0700a.m1851a(r3);
        r5 = r3.vb;
        if (r5 != 0) goto L_0x0023;
    L_0x0018:
        r5 = r3.f1552x;
        if (r5 == 0) goto L_0x0022;
    L_0x001c:
        r5 = r5.isEmpty();
        if (r5 == 0) goto L_0x0023;
    L_0x0022:
        return r4;
    L_0x0023:
        r5 = r1.f1625d;
        r6 = 1;
        if (r5 != 0) goto L_0x002c;
    L_0x0028:
        r1.f1624c = r0;
        r1.f1625d = r6;
    L_0x002c:
        r5 = r1.f1624c;
        r5 = io.gonative.android.C0721n.m1943b(r5, r0);
        if (r5 != 0) goto L_0x0035;
    L_0x0034:
        return r4;
    L_0x0035:
        r5 = new java.net.URL;	 Catch:{ Exception -> 0x0281, all -> 0x027d }
        r5.<init>(r0);	 Catch:{ Exception -> 0x0281, all -> 0x027d }
        r0 = r5.getProtocol();	 Catch:{ Exception -> 0x0281, all -> 0x027d }
        r7 = "http";	 Catch:{ Exception -> 0x0281, all -> 0x027d }
        r7 = r0.equalsIgnoreCase(r7);	 Catch:{ Exception -> 0x0281, all -> 0x027d }
        if (r7 != 0) goto L_0x005d;
    L_0x0046:
        r7 = "https";	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
        r0 = r0.equalsIgnoreCase(r7);	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
        if (r0 != 0) goto L_0x005d;
    L_0x004e:
        io.gonative.android.C0722o.m1946a(r4);
        io.gonative.android.C0722o.m1946a(r4);
        return r4;
    L_0x0055:
        r0 = move-exception;
        r10 = r4;
        goto L_0x0298;
    L_0x0059:
        r0 = move-exception;
        r5 = r4;
        goto L_0x0284;
    L_0x005d:
        r0 = r5.openConnection();	 Catch:{ Exception -> 0x0281, all -> 0x027d }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x0281, all -> 0x027d }
        r7 = 0;	 Catch:{ Exception -> 0x0281, all -> 0x027d }
        r0.setInstanceFollowRedirects(r7);	 Catch:{ Exception -> 0x0281, all -> 0x027d }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0281, all -> 0x027d }
        r5 = r3.m1893c(r5);	 Catch:{ Exception -> 0x0281, all -> 0x027d }
        r8 = "User-Agent";
        if (r5 == 0) goto L_0x0077;
    L_0x0073:
        r0.setRequestProperty(r8, r5);	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
        goto L_0x007c;
    L_0x0077:
        r5 = r3.f1541m;	 Catch:{ Exception -> 0x0281, all -> 0x027d }
        r0.setRequestProperty(r8, r5);	 Catch:{ Exception -> 0x0281, all -> 0x027d }
    L_0x007c:
        r5 = "Cache-Control";	 Catch:{ Exception -> 0x0281, all -> 0x027d }
        r8 = "no-cache";	 Catch:{ Exception -> 0x0281, all -> 0x027d }
        r0.setRequestProperty(r5, r8);	 Catch:{ Exception -> 0x0281, all -> 0x027d }
        if (r2 == 0) goto L_0x008a;
    L_0x0085:
        r5 = "Referer";	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
        r0.setRequestProperty(r5, r2);	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
    L_0x008a:
        r2 = r1.f1623b;	 Catch:{ Exception -> 0x0281, all -> 0x027d }
        r2 = io.gonative.android.C0707d.m1918a(r2);	 Catch:{ Exception -> 0x0281, all -> 0x027d }
        if (r2 == 0) goto L_0x00b6;
    L_0x0092:
        r2 = r2.entrySet();	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
        r2 = r2.iterator();	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
    L_0x009a:
        r5 = r2.hasNext();	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
        if (r5 == 0) goto L_0x00b6;	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
    L_0x00a0:
        r5 = r2.next();	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
        r5 = (java.util.Map.Entry) r5;	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
        r8 = r5.getKey();	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
        r8 = (java.lang.String) r8;	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
        r5 = r5.getValue();	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
        r0.setRequestProperty(r8, r5);	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
        goto L_0x009a;
    L_0x00b6:
        r0.connect();	 Catch:{ Exception -> 0x0281, all -> 0x027d }
        r2 = r0.getResponseCode();	 Catch:{ Exception -> 0x0281, all -> 0x027d }
        r5 = 301; // 0x12d float:4.22E-43 double:1.487E-321;
        r8 = "text/html";
        r9 = "UTF-8";
        if (r2 == r5) goto L_0x00d1;
    L_0x00c5:
        r5 = 302; // 0x12e float:4.23E-43 double:1.49E-321;
        if (r2 == r5) goto L_0x00d1;
    L_0x00c9:
        r5 = 303; // 0x12f float:4.25E-43 double:1.497E-321;
        if (r2 == r5) goto L_0x00d1;
    L_0x00cd:
        r5 = 307; // 0x133 float:4.3E-43 double:1.517E-321;
        if (r2 != r5) goto L_0x0108;
    L_0x00d1:
        r2 = "Location";	 Catch:{ Exception -> 0x0281, all -> 0x027d }
        r2 = r0.getHeaderField(r2);	 Catch:{ Exception -> 0x0281, all -> 0x027d }
        if (r2 == 0) goto L_0x0108;
    L_0x00d9:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
        r0.<init>();	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
        r3 = "<html><head><script>window.location=";	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
        r0.append(r3);	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
        r2 = io.gonative.android.C0726s.m1973b(r2);	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
        r0.append(r2);	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
        r2 = "</script></head><body></body></html>";	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
        r0.append(r2);	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
        r2 = new android.webkit.WebResourceResponse;	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
        r3 = new java.io.ByteArrayInputStream;	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
        r0 = r0.getBytes(r9);	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
        r3.<init>(r0);	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
        r2.<init>(r8, r9, r3);	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
        io.gonative.android.C0722o.m1946a(r4);
        io.gonative.android.C0722o.m1946a(r4);
        return r2;
    L_0x0108:
        r2 = r0.getContentType();	 Catch:{ Exception -> 0x0281, all -> 0x027d }
        if (r2 != 0) goto L_0x0134;
    L_0x010e:
        r2 = new java.io.BufferedInputStream;	 Catch:{ IOException -> 0x0118 }
        r5 = r0.getInputStream();	 Catch:{ IOException -> 0x0118 }
        r2.<init>(r5);	 Catch:{ IOException -> 0x0118 }
        goto L_0x0121;
    L_0x0118:
        r2 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
        r5 = r0.getErrorStream();	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
        r2.<init>(r5);	 Catch:{ Exception -> 0x0059, all -> 0x0055 }
    L_0x0121:
        r5 = java.net.HttpURLConnection.guessContentTypeFromStream(r2);	 Catch:{ Exception -> 0x012f, all -> 0x012b }
        r16 = r5;
        r5 = r2;
        r2 = r16;
        goto L_0x0135;
    L_0x012b:
        r0 = move-exception;
        r10 = r2;
        goto L_0x0298;
    L_0x012f:
        r0 = move-exception;
        r5 = r4;
        r4 = r2;
        goto L_0x0284;
    L_0x0134:
        r5 = r4;
    L_0x0135:
        if (r2 == 0) goto L_0x0275;
    L_0x0137:
        r2 = r2.startsWith(r8);	 Catch:{ Exception -> 0x0272, all -> 0x026e }
        if (r2 != 0) goto L_0x013f;	 Catch:{ Exception -> 0x0272, all -> 0x026e }
    L_0x013d:
        goto L_0x0275;	 Catch:{ Exception -> 0x0272, all -> 0x026e }
    L_0x013f:
        r2 = r0.getContentEncoding();	 Catch:{ Exception -> 0x0272, all -> 0x026e }
        if (r2 != 0) goto L_0x0146;
    L_0x0145:
        r2 = r9;
    L_0x0146:
        if (r5 != 0) goto L_0x0168;
    L_0x0148:
        r10 = new java.io.BufferedInputStream;	 Catch:{ IOException -> 0x015e }
        r11 = r0.getInputStream();	 Catch:{ IOException -> 0x015e }
        r10.<init>(r11);	 Catch:{ IOException -> 0x015e }
        goto L_0x0169;
    L_0x0152:
        r0 = move-exception;
        r10 = r5;
        goto L_0x0298;
    L_0x0156:
        r0 = move-exception;
        r16 = r5;
        r5 = r4;
        r4 = r16;
        goto L_0x0284;
    L_0x015e:
        r10 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x0156, all -> 0x0152 }
        r11 = r0.getErrorStream();	 Catch:{ Exception -> 0x0156, all -> 0x0152 }
        r10.<init>(r11);	 Catch:{ Exception -> 0x0156, all -> 0x0152 }
        goto L_0x0169;
    L_0x0168:
        r10 = r5;
    L_0x0169:
        r0 = r0.getContentLength();	 Catch:{ Exception -> 0x026b, all -> 0x0269 }
        if (r0 >= 0) goto L_0x0171;	 Catch:{ Exception -> 0x026b, all -> 0x0269 }
    L_0x016f:
        r0 = 10240; // 0x2800 float:1.4349E-41 double:5.059E-320;	 Catch:{ Exception -> 0x026b, all -> 0x0269 }
    L_0x0171:
        r5 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x026b, all -> 0x0269 }
        r5.<init>(r0);	 Catch:{ Exception -> 0x026b, all -> 0x0269 }
        io.gonative.android.C0722o.m1947a(r10, r5);	 Catch:{ Exception -> 0x0264, all -> 0x025e }
        r2 = r5.toString(r2);	 Catch:{ UnsupportedEncodingException -> 0x0184 }
        goto L_0x0188;
    L_0x017e:
        r0 = move-exception;
        goto L_0x0297;
    L_0x0181:
        r0 = move-exception;
        goto L_0x0267;
    L_0x0184:
        r2 = r5.toString(r9);	 Catch:{ Exception -> 0x0264, all -> 0x025e }
    L_0x0188:
        r11 = "</head>";	 Catch:{ Exception -> 0x0264, all -> 0x025e }
        r11 = r2.indexOf(r11);	 Catch:{ Exception -> 0x0264, all -> 0x025e }
        if (r11 < 0) goto L_0x023a;	 Catch:{ Exception -> 0x0264, all -> 0x025e }
    L_0x0190:
        r12 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0264, all -> 0x025e }
        r12.<init>(r0);	 Catch:{ Exception -> 0x0264, all -> 0x025e }
        r0 = r2.substring(r7, r11);	 Catch:{ Exception -> 0x0264, all -> 0x025e }
        r12.append(r0);	 Catch:{ Exception -> 0x0264, all -> 0x025e }
        r0 = r3.ha;	 Catch:{ Exception -> 0x0264, all -> 0x025e }
        if (r0 == 0) goto L_0x01af;
    L_0x01a0:
        r0 = "<style>";	 Catch:{ Exception -> 0x0181, all -> 0x017e }
        r12.append(r0);	 Catch:{ Exception -> 0x0181, all -> 0x017e }
        r0 = r3.ha;	 Catch:{ Exception -> 0x0181, all -> 0x017e }
        r12.append(r0);	 Catch:{ Exception -> 0x0181, all -> 0x017e }
        r0 = "</style>";	 Catch:{ Exception -> 0x0181, all -> 0x017e }
        r12.append(r0);	 Catch:{ Exception -> 0x0181, all -> 0x017e }
    L_0x01af:
        r0 = r3.oa;	 Catch:{ Exception -> 0x0264, all -> 0x025e }
        if (r0 == 0) goto L_0x01c6;
    L_0x01b3:
        r0 = "<meta name=\"viewport\" content=\"";	 Catch:{ Exception -> 0x0181, all -> 0x017e }
        r12.append(r0);	 Catch:{ Exception -> 0x0181, all -> 0x017e }
        r0 = r3.oa;	 Catch:{ Exception -> 0x0181, all -> 0x017e }
        r0 = android.text.TextUtils.htmlEncode(r0);	 Catch:{ Exception -> 0x0181, all -> 0x017e }
        r12.append(r0);	 Catch:{ Exception -> 0x0181, all -> 0x017e }
        r0 = "\" />";	 Catch:{ Exception -> 0x0181, all -> 0x017e }
        r12.append(r0);	 Catch:{ Exception -> 0x0181, all -> 0x017e }
    L_0x01c6:
        r13 = r3.ia;	 Catch:{ Exception -> 0x0264, all -> 0x025e }
        r0 = java.lang.Double.isNaN(r13);	 Catch:{ Exception -> 0x0264, all -> 0x025e }
        if (r0 != 0) goto L_0x022c;	 Catch:{ Exception -> 0x0264, all -> 0x025e }
    L_0x01ce:
        r0 = r3.ja;	 Catch:{ Exception -> 0x0264, all -> 0x025e }
        if (r0 == 0) goto L_0x01e8;
    L_0x01d2:
        r0 = java.util.Locale.US;	 Catch:{ Exception -> 0x0181, all -> 0x017e }
        r13 = "<meta name=\"viewport\" content=\"width=%f,maximum-scale=1.0\" />";	 Catch:{ Exception -> 0x0181, all -> 0x017e }
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0181, all -> 0x017e }
        r14 = r3.ia;	 Catch:{ Exception -> 0x0181, all -> 0x017e }
        r3 = java.lang.Double.valueOf(r14);	 Catch:{ Exception -> 0x0181, all -> 0x017e }
        r6[r7] = r3;	 Catch:{ Exception -> 0x0181, all -> 0x017e }
        r0 = java.lang.String.format(r0, r13, r6);	 Catch:{ Exception -> 0x0181, all -> 0x017e }
        r12.append(r0);	 Catch:{ Exception -> 0x0181, all -> 0x017e }
        goto L_0x022c;
    L_0x01e8:
        r0 = r18.getWidth();	 Catch:{ Exception -> 0x0264, all -> 0x025e }
        r0 = (float) r0;	 Catch:{ Exception -> 0x0264, all -> 0x025e }
        r13 = r1.f1623b;	 Catch:{ Exception -> 0x0264, all -> 0x025e }
        r13 = r13.getResources();	 Catch:{ Exception -> 0x0264, all -> 0x025e }
        r13 = r13.getDisplayMetrics();	 Catch:{ Exception -> 0x0264, all -> 0x025e }
        r13 = r13.density;	 Catch:{ Exception -> 0x0264, all -> 0x025e }
        r0 = r0 / r13;
        r13 = (double) r0;
        r19 = r5;
        r4 = r3.ia;	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
        java.lang.Double.isNaN(r13);
        r13 = r13 / r4;
        r0 = java.util.Locale.US;	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
        r3 = "<meta name=\"viewport\" content=\"width=%f,initial-scale=%f,minimum-scale=%f,maximum-scale=%f\" />";	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
        r15 = 4;	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
        r15 = new java.lang.Object[r15];	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
        r4 = java.lang.Double.valueOf(r4);	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
        r15[r7] = r4;	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
        r4 = java.lang.Double.valueOf(r13);	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
        r15[r6] = r4;	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
        r4 = 2;	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
        r5 = java.lang.Double.valueOf(r13);	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
        r15[r4] = r5;	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
        r4 = 3;	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
        r5 = java.lang.Double.valueOf(r13);	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
        r15[r4] = r5;	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
        r0 = java.lang.String.format(r0, r3, r15);	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
        r12.append(r0);	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
        goto L_0x022e;	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
    L_0x022c:
        r19 = r5;	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
    L_0x022e:
        r0 = r2.substring(r11);	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
        r12.append(r0);	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
        r2 = r12.toString();	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
        goto L_0x0243;	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
    L_0x023a:
        r19 = r5;	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
        r0 = f1622a;	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
        r3 = "could not find closing </head> tag";	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
        android.util.Log.d(r0, r3);	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
    L_0x0243:
        r0 = new android.webkit.WebResourceResponse;	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
        r3 = new java.io.ByteArrayInputStream;	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
        r2 = r2.getBytes(r9);	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
        r3.<init>(r2);	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
        r0.<init>(r8, r9, r3);	 Catch:{ Exception -> 0x025a, all -> 0x0258 }
        io.gonative.android.C0722o.m1946a(r10);
        io.gonative.android.C0722o.m1946a(r19);
        return r0;
    L_0x0258:
        r0 = move-exception;
        goto L_0x0261;
    L_0x025a:
        r0 = move-exception;
        r5 = r19;
        goto L_0x0267;
    L_0x025e:
        r0 = move-exception;
        r19 = r5;
    L_0x0261:
        r4 = r19;
        goto L_0x0298;
    L_0x0264:
        r0 = move-exception;
        r19 = r5;
    L_0x0267:
        r4 = r10;
        goto L_0x0284;
    L_0x0269:
        r0 = move-exception;
        goto L_0x0270;
    L_0x026b:
        r0 = move-exception;
        r4 = r10;
        goto L_0x0283;
    L_0x026e:
        r0 = move-exception;
        r10 = r5;
    L_0x0270:
        r4 = 0;
        goto L_0x0298;
    L_0x0272:
        r0 = move-exception;
        r4 = r5;
        goto L_0x0283;
    L_0x0275:
        io.gonative.android.C0722o.m1946a(r5);
        r2 = 0;
        io.gonative.android.C0722o.m1946a(r2);
        return r2;
    L_0x027d:
        r0 = move-exception;
        r4 = 0;
        r10 = 0;
        goto L_0x0298;
    L_0x0281:
        r0 = move-exception;
        r4 = 0;
    L_0x0283:
        r5 = 0;
    L_0x0284:
        r2 = f1622a;	 Catch:{ all -> 0x0295 }
        r3 = r0.toString();	 Catch:{ all -> 0x0295 }
        android.util.Log.e(r2, r3, r0);	 Catch:{ all -> 0x0295 }
        io.gonative.android.C0722o.m1946a(r4);
        io.gonative.android.C0722o.m1946a(r5);
        r2 = 0;
        return r2;
    L_0x0295:
        r0 = move-exception;
        r10 = r4;
    L_0x0297:
        r4 = r5;
    L_0x0298:
        io.gonative.android.C0722o.m1946a(r10);
        io.gonative.android.C0722o.m1946a(r4);
        goto L_0x02a0;
    L_0x029f:
        throw r0;
    L_0x02a0:
        goto L_0x029f;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.gonative.android.n.a(io.gonative.android.m, java.lang.String, java.lang.String):android.webkit.WebResourceResponse");
    }

    /* renamed from: a */
    public void m1945a(String str) {
        this.f1624c = str;
    }
}
