package com.onesignal;

import java.lang.Thread.State;
import org.json.JSONObject;

class Ga {

    /* renamed from: com.onesignal.Ga$a */
    static class C0589a {
        C0589a() {
        }

        /* renamed from: a */
        void mo1382a(int i, String str, Throwable th) {
        }

        /* renamed from: a */
        void mo1370a(String str) {
        }
    }

    /* renamed from: a */
    private static int m1322a(int i) {
        return i + 5000;
    }

    /* renamed from: a */
    private static Thread m1323a(C0589a c0589a, int i, String str, Throwable th) {
        if (c0589a == null) {
            return null;
        }
        Thread thread = new Thread(new Fa(c0589a, i, str, th));
        thread.start();
        return thread;
    }

    /* renamed from: a */
    private static Thread m1324a(C0589a c0589a, String str) {
        if (c0589a == null) {
            return null;
        }
        Thread thread = new Thread(new Ea(c0589a, str));
        thread.start();
        return thread;
    }

    /* renamed from: a */
    static void m1325a(String str, C0589a c0589a) {
        new Thread(new Ca(str, c0589a)).start();
    }

    /* renamed from: a */
    static void m1327a(String str, JSONObject jSONObject, C0589a c0589a) {
        new Thread(new Ba(str, jSONObject, c0589a)).start();
    }

    /* renamed from: b */
    static void m1329b(String str, C0589a c0589a) {
        m1331c(str, null, null, c0589a, 60000);
    }

    /* renamed from: b */
    static void m1330b(String str, JSONObject jSONObject, C0589a c0589a) {
        m1331c(str, "POST", jSONObject, c0589a, 120000);
    }

    /* renamed from: c */
    private static void m1331c(String str, String str2, JSONObject jSONObject, C0589a c0589a, int i) {
        if (str2 == null || !sa.m1705f(null)) {
            Thread[] threadArr = new Thread[1];
            Thread thread = new Thread(new Da(threadArr, str, str2, jSONObject, c0589a, i), "OS_HTTPConnection");
            thread.start();
            try {
                thread.join((long) m1322a(i));
                if (thread.getState() != State.TERMINATED) {
                    thread.interrupt();
                }
                if (threadArr[0] != null) {
                    threadArr[0].join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    static void m1332c(String str, JSONObject jSONObject, C0589a c0589a) {
        new Thread(new Aa(str, jSONObject, c0589a)).start();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    private static java.lang.Thread m1333d(java.lang.String r9, java.lang.String r10, org.json.JSONObject r11, com.onesignal.Ga.C0589a r12, int r13) {
        /*
        r0 = "OneSignalRestClient: ";
        r1 = 0;
        r2 = -1;
        r3 = com.onesignal.sa.C0650i.DEBUG;	 Catch:{ Throwable -> 0x017f, all -> 0x017c }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x017f, all -> 0x017c }
        r4.<init>();	 Catch:{ Throwable -> 0x017f, all -> 0x017c }
        r5 = "OneSignalRestClient: Making request to: https://onesignal.com/api/v1/";
        r4.append(r5);	 Catch:{ Throwable -> 0x017f, all -> 0x017c }
        r4.append(r9);	 Catch:{ Throwable -> 0x017f, all -> 0x017c }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x017f, all -> 0x017c }
        com.onesignal.sa.m1656a(r3, r4);	 Catch:{ Throwable -> 0x017f, all -> 0x017c }
        r3 = new java.net.URL;	 Catch:{ Throwable -> 0x017f, all -> 0x017c }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x017f, all -> 0x017c }
        r4.<init>();	 Catch:{ Throwable -> 0x017f, all -> 0x017c }
        r5 = "https://onesignal.com/api/v1/";
        r4.append(r5);	 Catch:{ Throwable -> 0x017f, all -> 0x017c }
        r4.append(r9);	 Catch:{ Throwable -> 0x017f, all -> 0x017c }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x017f, all -> 0x017c }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x017f, all -> 0x017c }
        r3 = r3.openConnection();	 Catch:{ Throwable -> 0x017f, all -> 0x017c }
        r3 = (java.net.HttpURLConnection) r3;	 Catch:{ Throwable -> 0x017f, all -> 0x017c }
        r4 = 0;
        r3.setUseCaches(r4);	 Catch:{ Throwable -> 0x017a }
        r3.setConnectTimeout(r13);	 Catch:{ Throwable -> 0x017a }
        r3.setReadTimeout(r13);	 Catch:{ Throwable -> 0x017a }
        r13 = 1;
        if (r11 == 0) goto L_0x0046;
    L_0x0043:
        r3.setDoInput(r13);	 Catch:{ Throwable -> 0x017a }
    L_0x0046:
        if (r10 == 0) goto L_0x0055;
    L_0x0048:
        r4 = "Content-Type";
        r5 = "application/json; charset=UTF-8";
        r3.setRequestProperty(r4, r5);	 Catch:{ Throwable -> 0x017a }
        r3.setRequestMethod(r10);	 Catch:{ Throwable -> 0x017a }
        r3.setDoOutput(r13);	 Catch:{ Throwable -> 0x017a }
    L_0x0055:
        r13 = "UTF-8";
        if (r11 == 0) goto L_0x0088;
    L_0x0059:
        r11 = r11.toString();	 Catch:{ Throwable -> 0x017a }
        r4 = com.onesignal.sa.C0650i.DEBUG;	 Catch:{ Throwable -> 0x017a }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x017a }
        r5.<init>();	 Catch:{ Throwable -> 0x017a }
        r5.append(r0);	 Catch:{ Throwable -> 0x017a }
        r5.append(r10);	 Catch:{ Throwable -> 0x017a }
        r6 = " SEND JSON: ";
        r5.append(r6);	 Catch:{ Throwable -> 0x017a }
        r5.append(r11);	 Catch:{ Throwable -> 0x017a }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x017a }
        com.onesignal.sa.m1656a(r4, r5);	 Catch:{ Throwable -> 0x017a }
        r11 = r11.getBytes(r13);	 Catch:{ Throwable -> 0x017a }
        r4 = r11.length;	 Catch:{ Throwable -> 0x017a }
        r3.setFixedLengthStreamingMode(r4);	 Catch:{ Throwable -> 0x017a }
        r4 = r3.getOutputStream();	 Catch:{ Throwable -> 0x017a }
        r4.write(r11);	 Catch:{ Throwable -> 0x017a }
    L_0x0088:
        r2 = r3.getResponseCode();	 Catch:{ Throwable -> 0x017a }
        r11 = com.onesignal.sa.C0650i.VERBOSE;	 Catch:{ Throwable -> 0x017a }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x017a }
        r4.<init>();	 Catch:{ Throwable -> 0x017a }
        r5 = "OneSignalRestClient: After con.getResponseCode  to: https://onesignal.com/api/v1/";
        r4.append(r5);	 Catch:{ Throwable -> 0x017a }
        r4.append(r9);	 Catch:{ Throwable -> 0x017a }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x017a }
        com.onesignal.sa.m1656a(r11, r4);	 Catch:{ Throwable -> 0x017a }
        r11 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r4 = " RECEIVED JSON: ";
        r5 = "";
        r6 = "\\A";
        if (r2 != r11) goto L_0x00f9;
    L_0x00ac:
        r11 = com.onesignal.sa.C0650i.DEBUG;	 Catch:{ Throwable -> 0x017a }
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x017a }
        r7.<init>();	 Catch:{ Throwable -> 0x017a }
        r8 = "OneSignalRestClient: Successfully finished request to: https://onesignal.com/api/v1/";
        r7.append(r8);	 Catch:{ Throwable -> 0x017a }
        r7.append(r9);	 Catch:{ Throwable -> 0x017a }
        r9 = r7.toString();	 Catch:{ Throwable -> 0x017a }
        com.onesignal.sa.m1656a(r11, r9);	 Catch:{ Throwable -> 0x017a }
        r9 = r3.getInputStream();	 Catch:{ Throwable -> 0x017a }
        r11 = new java.util.Scanner;	 Catch:{ Throwable -> 0x017a }
        r11.<init>(r9, r13);	 Catch:{ Throwable -> 0x017a }
        r9 = r11.useDelimiter(r6);	 Catch:{ Throwable -> 0x017a }
        r9 = r9.hasNext();	 Catch:{ Throwable -> 0x017a }
        if (r9 == 0) goto L_0x00d9;
    L_0x00d5:
        r5 = r11.next();	 Catch:{ Throwable -> 0x017a }
    L_0x00d9:
        r11.close();	 Catch:{ Throwable -> 0x017a }
        r9 = com.onesignal.sa.C0650i.DEBUG;	 Catch:{ Throwable -> 0x017a }
        r11 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x017a }
        r11.<init>();	 Catch:{ Throwable -> 0x017a }
        r11.append(r10);	 Catch:{ Throwable -> 0x017a }
        r11.append(r4);	 Catch:{ Throwable -> 0x017a }
        r11.append(r5);	 Catch:{ Throwable -> 0x017a }
        r11 = r11.toString();	 Catch:{ Throwable -> 0x017a }
        com.onesignal.sa.m1656a(r9, r11);	 Catch:{ Throwable -> 0x017a }
        r9 = m1324a(r12, r5);	 Catch:{ Throwable -> 0x017a }
        goto L_0x0174;
    L_0x00f9:
        r11 = com.onesignal.sa.C0650i.DEBUG;	 Catch:{ Throwable -> 0x017a }
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x017a }
        r7.<init>();	 Catch:{ Throwable -> 0x017a }
        r8 = "OneSignalRestClient: Failed request to: https://onesignal.com/api/v1/";
        r7.append(r8);	 Catch:{ Throwable -> 0x017a }
        r7.append(r9);	 Catch:{ Throwable -> 0x017a }
        r9 = r7.toString();	 Catch:{ Throwable -> 0x017a }
        com.onesignal.sa.m1656a(r11, r9);	 Catch:{ Throwable -> 0x017a }
        r9 = r3.getErrorStream();	 Catch:{ Throwable -> 0x017a }
        if (r9 != 0) goto L_0x0119;
    L_0x0115:
        r9 = r3.getInputStream();	 Catch:{ Throwable -> 0x017a }
    L_0x0119:
        if (r9 == 0) goto L_0x014e;
    L_0x011b:
        r11 = new java.util.Scanner;	 Catch:{ Throwable -> 0x017a }
        r11.<init>(r9, r13);	 Catch:{ Throwable -> 0x017a }
        r9 = r11.useDelimiter(r6);	 Catch:{ Throwable -> 0x017a }
        r9 = r9.hasNext();	 Catch:{ Throwable -> 0x017a }
        if (r9 == 0) goto L_0x012f;
    L_0x012a:
        r9 = r11.next();	 Catch:{ Throwable -> 0x017a }
        goto L_0x0130;
    L_0x012f:
        r9 = r5;
    L_0x0130:
        r11.close();	 Catch:{ Throwable -> 0x017a }
        r11 = com.onesignal.sa.C0650i.WARN;	 Catch:{ Throwable -> 0x017a }
        r13 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x017a }
        r13.<init>();	 Catch:{ Throwable -> 0x017a }
        r13.append(r0);	 Catch:{ Throwable -> 0x017a }
        r13.append(r10);	 Catch:{ Throwable -> 0x017a }
        r13.append(r4);	 Catch:{ Throwable -> 0x017a }
        r13.append(r9);	 Catch:{ Throwable -> 0x017a }
        r13 = r13.toString();	 Catch:{ Throwable -> 0x017a }
        com.onesignal.sa.m1656a(r11, r13);	 Catch:{ Throwable -> 0x017a }
        goto L_0x0170;
    L_0x014e:
        r9 = com.onesignal.sa.C0650i.WARN;	 Catch:{ Throwable -> 0x017a }
        r11 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x017a }
        r11.<init>();	 Catch:{ Throwable -> 0x017a }
        r11.append(r0);	 Catch:{ Throwable -> 0x017a }
        r11.append(r10);	 Catch:{ Throwable -> 0x017a }
        r13 = " HTTP Code: ";
        r11.append(r13);	 Catch:{ Throwable -> 0x017a }
        r11.append(r2);	 Catch:{ Throwable -> 0x017a }
        r13 = " No response body!";
        r11.append(r13);	 Catch:{ Throwable -> 0x017a }
        r11 = r11.toString();	 Catch:{ Throwable -> 0x017a }
        com.onesignal.sa.m1656a(r9, r11);	 Catch:{ Throwable -> 0x017a }
        r9 = r1;
    L_0x0170:
        r9 = m1323a(r12, r2, r9, r1);	 Catch:{ Throwable -> 0x017a }
    L_0x0174:
        if (r3 == 0) goto L_0x01c9;
    L_0x0176:
        r3.disconnect();
        goto L_0x01c9;
    L_0x017a:
        r9 = move-exception;
        goto L_0x0181;
    L_0x017c:
        r9 = move-exception;
        r3 = r1;
        goto L_0x01cb;
    L_0x017f:
        r9 = move-exception;
        r3 = r1;
    L_0x0181:
        r11 = r9 instanceof java.net.ConnectException;	 Catch:{ all -> 0x01ca }
        if (r11 != 0) goto L_0x01a4;
    L_0x0185:
        r11 = r9 instanceof java.net.UnknownHostException;	 Catch:{ all -> 0x01ca }
        if (r11 == 0) goto L_0x018a;
    L_0x0189:
        goto L_0x01a4;
    L_0x018a:
        r11 = com.onesignal.sa.C0650i.WARN;	 Catch:{ all -> 0x01ca }
        r13 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01ca }
        r13.<init>();	 Catch:{ all -> 0x01ca }
        r13.append(r0);	 Catch:{ all -> 0x01ca }
        r13.append(r10);	 Catch:{ all -> 0x01ca }
        r10 = " Error thrown from network stack. ";
        r13.append(r10);	 Catch:{ all -> 0x01ca }
        r10 = r13.toString();	 Catch:{ all -> 0x01ca }
        com.onesignal.sa.m1657a(r11, r10, r9);	 Catch:{ all -> 0x01ca }
        goto L_0x01c2;
    L_0x01a4:
        r10 = com.onesignal.sa.C0650i.INFO;	 Catch:{ all -> 0x01ca }
        r11 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01ca }
        r11.<init>();	 Catch:{ all -> 0x01ca }
        r13 = "OneSignalRestClient: Could not send last request, device is offline. Throwable: ";
        r11.append(r13);	 Catch:{ all -> 0x01ca }
        r13 = r9.getClass();	 Catch:{ all -> 0x01ca }
        r13 = r13.getName();	 Catch:{ all -> 0x01ca }
        r11.append(r13);	 Catch:{ all -> 0x01ca }
        r11 = r11.toString();	 Catch:{ all -> 0x01ca }
        com.onesignal.sa.m1656a(r10, r11);	 Catch:{ all -> 0x01ca }
    L_0x01c2:
        r9 = m1323a(r12, r2, r1, r9);	 Catch:{ all -> 0x01ca }
        if (r3 == 0) goto L_0x01c9;
    L_0x01c8:
        goto L_0x0176;
    L_0x01c9:
        return r9;
    L_0x01ca:
        r9 = move-exception;
    L_0x01cb:
        if (r3 == 0) goto L_0x01d0;
    L_0x01cd:
        r3.disconnect();
    L_0x01d0:
        goto L_0x01d2;
    L_0x01d1:
        throw r9;
    L_0x01d2:
        goto L_0x01d1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.Ga.d(java.lang.String, java.lang.String, org.json.JSONObject, com.onesignal.Ga$a, int):java.lang.Thread");
    }

    /* renamed from: d */
    static void m1334d(String str, JSONObject jSONObject, C0589a c0589a) {
        m1331c(str, "PUT", jSONObject, c0589a, 120000);
    }
}
