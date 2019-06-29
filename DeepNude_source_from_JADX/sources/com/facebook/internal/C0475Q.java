package com.facebook.internal;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.support.v4.app.NotificationCompat;
import android.support.v4.os.EnvironmentCompat;
import android.util.Log;
import android.view.autofill.AutofillManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.C0331D;
import com.facebook.C0332E;
import com.facebook.C0506l;
import com.facebook.C0560t;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.C0338b;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/* renamed from: com.facebook.internal.Q */
public final class C0475Q {
    /* renamed from: a */
    private static int f842a = 0;
    /* renamed from: b */
    private static long f843b = -1;
    /* renamed from: c */
    private static long f844c = -1;
    /* renamed from: d */
    private static long f845d = -1;
    /* renamed from: e */
    private static String f846e = "";
    /* renamed from: f */
    private static String f847f = "";
    /* renamed from: g */
    private static String f848g = "NoCarrier";

    /* renamed from: com.facebook.internal.Q$a */
    public interface C0473a {
        /* renamed from: a */
        void mo946a(C0506l c0506l);

        /* renamed from: a */
        void mo947a(JSONObject jSONObject);
    }

    /* renamed from: com.facebook.internal.Q$b */
    public static class C0474b {
        /* renamed from: a */
        List<String> f840a;
        /* renamed from: b */
        List<String> f841b;

        public C0474b(List<String> list, List<String> list2) {
            this.f840a = list;
            this.f841b = list2;
        }

        /* renamed from: a */
        public List<String> m954a() {
            return this.f841b;
        }

        /* renamed from: b */
        public List<String> m955b() {
            return this.f840a;
        }
    }

    /* renamed from: a */
    public static int m956a(InputStream inputStream, OutputStream outputStream) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                byte[] bArr = new byte[8192];
                int i = 0;
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                    i += read;
                }
                bufferedInputStream.close();
                if (inputStream != null) {
                    inputStream.close();
                }
                return i;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    private static long m957a(double d) {
        return Math.round(d / 1.073741824E9d);
    }

    /* renamed from: a */
    public static long m958a(Uri uri) {
        Cursor cursor = null;
        try {
            cursor = C0560t.m1252d().getContentResolver().query(uri, null, null, null, null);
            int columnIndex = cursor.getColumnIndex("_size");
            cursor.moveToFirst();
            long j = cursor.getLong(columnIndex);
            return j;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* renamed from: a */
    public static Uri m959a(String str, String str2, Bundle bundle) {
        Builder builder = new Builder();
        builder.scheme("https");
        builder.authority(str);
        builder.path(str2);
        if (bundle != null) {
            for (String str22 : bundle.keySet()) {
                Object obj = bundle.get(str22);
                if (obj instanceof String) {
                    builder.appendQueryParameter(str22, (String) obj);
                }
            }
        }
        return builder.build();
    }

    /* renamed from: a */
    public static C0474b m960a(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONObject("permissions").getJSONArray("data");
        List arrayList = new ArrayList(jSONArray.length());
        List arrayList2 = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            String optString = optJSONObject.optString("permission");
            if (optString != null) {
                if (!optString.equals("installed")) {
                    String optString2 = optJSONObject.optString(NotificationCompat.CATEGORY_STATUS);
                    if (optString2 != null) {
                        if (optString2.equals("granted")) {
                            arrayList.add(optString);
                        } else if (optString2.equals("declined")) {
                            arrayList2.add(optString);
                        }
                    }
                }
            }
        }
        return new C0474b(arrayList, arrayList2);
    }

    /* renamed from: a */
    public static java.lang.Object m961a(java.lang.Object r1, java.lang.reflect.Method r2, java.lang.Object... r3) {
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
        r1 = r2.invoke(r1, r3);	 Catch:{ IllegalAccessException -> 0x0006, IllegalAccessException -> 0x0006 }
        return r1;
    L_0x0006:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Q.a(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
    }

    /* renamed from: a */
    public static Object m962a(JSONObject jSONObject, String str, String str2) {
        Object opt = jSONObject.opt(str);
        if (opt != null && (opt instanceof String)) {
            opt = new JSONTokener((String) opt).nextValue();
        }
        if (opt == null || (opt instanceof JSONObject) || (opt instanceof JSONArray)) {
            return opt;
        }
        if (str2 != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt(str2, opt);
            return jSONObject2;
        }
        throw new C0506l("Got an unexpected non-JSON object.");
    }

    /* renamed from: a */
    public static String m963a(int i) {
        return new BigInteger(i * 5, new Random()).toString(32);
    }

    /* renamed from: a */
    public static String m964a(InputStream inputStream) {
        Throwable th;
        Closeable bufferedInputStream;
        Closeable inputStreamReader;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                inputStreamReader = new InputStreamReader(bufferedInputStream);
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    char[] cArr = new char[2048];
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (read != -1) {
                            stringBuilder.append(cArr, 0, read);
                        } else {
                            String stringBuilder2 = stringBuilder.toString();
                            C0475Q.m981a(bufferedInputStream);
                            C0475Q.m981a(inputStreamReader);
                            return stringBuilder2;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    C0475Q.m981a(bufferedInputStream);
                    C0475Q.m981a(inputStreamReader);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader = null;
                C0475Q.m981a(bufferedInputStream);
                C0475Q.m981a(inputStreamReader);
                throw th;
            }
        } catch (Throwable th32) {
            bufferedInputStream = null;
            th = th32;
            inputStreamReader = bufferedInputStream;
            C0475Q.m981a(bufferedInputStream);
            C0475Q.m981a(inputStreamReader);
            throw th;
        }
    }

    /* renamed from: a */
    private static java.lang.String m965a(java.lang.String r0, byte[] r1) {
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
        r0 = java.security.MessageDigest.getInstance(r0);	 Catch:{ NoSuchAlgorithmException -> 0x0009 }
        r0 = com.facebook.internal.C0475Q.m966a(r0, r1);
        return r0;
    L_0x0009:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Q.a(java.lang.String, byte[]):java.lang.String");
    }

    /* renamed from: a */
    private static String m966a(MessageDigest messageDigest, byte[] bArr) {
        messageDigest.update(bArr);
        byte[] digest = messageDigest.digest();
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : digest) {
            stringBuilder.append(Integer.toHexString((b >> 4) & 15));
            stringBuilder.append(Integer.toHexString((b >> 0) & 15));
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public static String m967a(byte[] bArr) {
        return C0475Q.m965a("SHA-1", bArr);
    }

    /* renamed from: a */
    public static java.lang.reflect.Method m968a(java.lang.Class<?> r0, java.lang.String r1, java.lang.Class<?>... r2) {
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
        r0 = r0.getMethod(r1, r2);	 Catch:{ NoSuchMethodException -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Q.a(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    /* renamed from: a */
    public static java.lang.reflect.Method m969a(java.lang.String r0, java.lang.String r1, java.lang.Class<?>... r2) {
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
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0009 }
        r0 = com.facebook.internal.C0475Q.m968a(r0, r1, r2);	 Catch:{ ClassNotFoundException -> 0x0009 }
        return r0;
    L_0x0009:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Q.a(java.lang.String, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    /* renamed from: a */
    public static java.util.Date m970a(android.os.Bundle r5, java.lang.String r6, java.util.Date r7) {
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
        if (r5 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r5 = r5.get(r6);
        r6 = r5 instanceof java.lang.Long;
        if (r6 == 0) goto L_0x0013;
    L_0x000c:
        r5 = (java.lang.Long) r5;
        r5 = r5.longValue();
        goto L_0x001d;
    L_0x0013:
        r6 = r5 instanceof java.lang.String;
        if (r6 == 0) goto L_0x003c;
    L_0x0017:
        r5 = (java.lang.String) r5;	 Catch:{ NumberFormatException -> 0x003c }
        r5 = java.lang.Long.parseLong(r5);	 Catch:{ NumberFormatException -> 0x003c }
    L_0x001d:
        r0 = 0;
        r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1));
        if (r2 != 0) goto L_0x002e;
    L_0x0023:
        r5 = new java.util.Date;
        r6 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r5.<init>(r6);
        return r5;
    L_0x002e:
        r0 = new java.util.Date;
        r1 = r7.getTime();
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r5 = r5 * r3;
        r1 = r1 + r5;
        r0.<init>(r1);
    L_0x003c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Q.a(android.os.Bundle, java.lang.String, java.util.Date):java.util.Date");
    }

    /* renamed from: a */
    public static List<String> m971a(JSONArray jSONArray) {
        List arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static <T> List<T> m972a(T... tArr) {
        List arrayList = new ArrayList();
        for (Object obj : tArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static java.util.Locale m973a() {
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
        r0 = com.facebook.C0560t.m1252d();	 Catch:{ Exception -> 0x000f }
        r0 = r0.getResources();	 Catch:{ Exception -> 0x000f }
        r0 = r0.getConfiguration();	 Catch:{ Exception -> 0x000f }
        r0 = r0.locale;	 Catch:{ Exception -> 0x000f }
        goto L_0x0013;
    L_0x000f:
        r0 = java.util.Locale.getDefault();
    L_0x0013:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Q.a():java.util.Locale");
    }

    /* renamed from: a */
    public static Map<String, String> m974a(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        Map<String, String> hashMap = new HashMap();
        for (int i = 0; i < readInt; i++) {
            hashMap.put(parcel.readString(), parcel.readString());
        }
        return hashMap;
    }

    /* renamed from: a */
    public static JSONObject m975a(String str) {
        JSONObject a = C0469L.m944a(str);
        if (a != null) {
            return a;
        }
        C0331D b = C0475Q.m1007e(str).m555b();
        return b.m486a() != null ? null : b.m487b();
    }

    /* renamed from: a */
    public static void m976a(Context context) {
        C0475Q.m977a(context, "facebook.com");
        C0475Q.m977a(context, ".facebook.com");
        C0475Q.m977a(context, "https://facebook.com");
        C0475Q.m977a(context, "https://.facebook.com");
    }

    /* renamed from: a */
    private static void m977a(Context context, String str) {
        CookieSyncManager.createInstance(context).sync();
        CookieManager instance = CookieManager.getInstance();
        String cookie = instance.getCookie(str);
        if (cookie != null) {
            for (String split : cookie.split(";")) {
                String[] split2 = split.split("=");
                if (split2.length > 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(split2[0].trim());
                    stringBuilder.append("=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
                    instance.setCookie(str, stringBuilder.toString());
                }
            }
            instance.removeExpiredCookie();
        }
    }

    /* renamed from: a */
    public static void m978a(Bundle bundle, String str, Uri uri) {
        if (uri != null) {
            C0475Q.m979a(bundle, str, uri.toString());
        }
    }

    /* renamed from: a */
    public static void m979a(Bundle bundle, String str, String str2) {
        if (!C0475Q.m998b(str2)) {
            bundle.putString(str, str2);
        }
    }

    /* renamed from: a */
    public static void m980a(Parcel parcel, Map<String, String> map) {
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Entry entry : map.entrySet()) {
            parcel.writeString((String) entry.getKey());
            parcel.writeString((String) entry.getValue());
        }
    }

    /* renamed from: a */
    public static void m981a(java.io.Closeable r0) {
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
        if (r0 == 0) goto L_0x0005;
    L_0x0002:
        r0.close();	 Catch:{ IOException -> 0x0005 }
    L_0x0005:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Q.a(java.io.Closeable):void");
    }

    /* renamed from: a */
    public static void m982a(String str, C0473a c0473a) {
        JSONObject a = C0469L.m944a(str);
        if (a != null) {
            c0473a.mo947a(a);
            return;
        }
        C0338b c0834o = new C0834O(c0473a, str);
        GraphRequest e = C0475Q.m1007e(str);
        e.m552a(c0834o);
        e.m556c();
    }

    /* renamed from: a */
    public static void m983a(String str, Exception exception) {
        if (C0560t.m1263o() && str != null && exception != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(exception.getClass().getSimpleName());
            stringBuilder.append(": ");
            stringBuilder.append(exception.getMessage());
            Log.d(str, stringBuilder.toString());
        }
    }

    /* renamed from: a */
    public static void m984a(String str, String str2) {
        if (C0560t.m1263o() && str != null && str2 != null) {
            Log.d(str, str2);
        }
    }

    /* renamed from: a */
    public static void m985a(String str, String str2, Throwable th) {
        if (C0560t.m1263o() && !C0475Q.m998b(str)) {
            Log.d(str, str2, th);
        }
    }

    /* renamed from: a */
    public static void m986a(URLConnection uRLConnection) {
        if (uRLConnection != null && (uRLConnection instanceof HttpURLConnection)) {
            ((HttpURLConnection) uRLConnection).disconnect();
        }
    }

    /* renamed from: a */
    public static void m987a(org.json.JSONObject r6, android.content.Context r7) {
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
        r0 = new org.json.JSONArray;
        r0.<init>();
        r1 = "a2";
        r0.put(r1);
        com.facebook.internal.C0475Q.m1013h(r7);
        r1 = r7.getPackageName();
        r2 = 0;
        r3 = -1;
        r4 = r7.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0020 }
        r4 = r4.getPackageInfo(r1, r2);	 Catch:{ NameNotFoundException -> 0x0020 }
        r3 = r4.versionCode;	 Catch:{ NameNotFoundException -> 0x0020 }
        r4 = r4.versionName;	 Catch:{ NameNotFoundException -> 0x0020 }
        goto L_0x0022;
    L_0x0020:
        r4 = "";
    L_0x0022:
        r0.put(r1);
        r0.put(r3);
        r0.put(r4);
        r1 = android.os.Build.VERSION.RELEASE;
        r0.put(r1);
        r1 = android.os.Build.MODEL;
        r0.put(r1);
        r1 = r7.getResources();	 Catch:{ Exception -> 0x0040 }
        r1 = r1.getConfiguration();	 Catch:{ Exception -> 0x0040 }
        r1 = r1.locale;	 Catch:{ Exception -> 0x0040 }
        goto L_0x0044;
    L_0x0040:
        r1 = java.util.Locale.getDefault();
    L_0x0044:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = r1.getLanguage();
        r3.append(r4);
        r4 = "_";
        r3.append(r4);
        r1 = r1.getCountry();
        r3.append(r1);
        r1 = r3.toString();
        r0.put(r1);
        r1 = f846e;
        r0.put(r1);
        r1 = f848g;
        r0.put(r1);
        r3 = 0;
        r1 = "window";	 Catch:{ Exception -> 0x008d }
        r7 = r7.getSystemService(r1);	 Catch:{ Exception -> 0x008d }
        r7 = (android.view.WindowManager) r7;	 Catch:{ Exception -> 0x008d }
        if (r7 == 0) goto L_0x008d;	 Catch:{ Exception -> 0x008d }
    L_0x0079:
        r7 = r7.getDefaultDisplay();	 Catch:{ Exception -> 0x008d }
        r1 = new android.util.DisplayMetrics;	 Catch:{ Exception -> 0x008d }
        r1.<init>();	 Catch:{ Exception -> 0x008d }
        r7.getMetrics(r1);	 Catch:{ Exception -> 0x008d }
        r7 = r1.widthPixels;	 Catch:{ Exception -> 0x008d }
        r5 = r1.heightPixels;	 Catch:{ Exception -> 0x008e }
        r1 = r1.density;	 Catch:{ Exception -> 0x008f }
        r3 = (double) r1;
        goto L_0x008f;
    L_0x008d:
        r7 = 0;
    L_0x008e:
        r5 = 0;
    L_0x008f:
        r0.put(r7);
        r0.put(r5);
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r1 = java.lang.Double.valueOf(r3);
        r7[r2] = r1;
        r1 = "%.2f";
        r7 = java.lang.String.format(r1, r7);
        r0.put(r7);
        r7 = com.facebook.internal.C0475Q.m1003d();
        r0.put(r7);
        r1 = f844c;
        r0.put(r1);
        r1 = f845d;
        r0.put(r1);
        r7 = f847f;
        r0.put(r7);
        r7 = r0.toString();
        r0 = "extinfo";
        r6.put(r0, r7);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Q.a(org.json.JSONObject, android.content.Context):void");
    }

    /* renamed from: a */
    public static void m988a(JSONObject jSONObject, C0489b c0489b, String str, boolean z) {
        if (!(c0489b == null || c0489b.m1074c() == null)) {
            jSONObject.put("attribution", c0489b.m1074c());
        }
        if (!(c0489b == null || c0489b.m1072a() == null)) {
            jSONObject.put("advertiser_id", c0489b.m1072a());
            jSONObject.put("advertiser_tracking_enabled", c0489b.m1075e() ^ 1);
        }
        if (!(c0489b == null || c0489b.m1073b() == null)) {
            jSONObject.put("installer_package", c0489b.m1073b());
        }
        jSONObject.put("anon_id", str);
        jSONObject.put("application_tracking_enabled", z ^ 1);
    }

    /* renamed from: a */
    public static boolean m989a(Bundle bundle, String str, Object obj) {
        if (obj == null) {
            bundle.remove(str);
        } else if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof boolean[]) {
            bundle.putBooleanArray(str, (boolean[]) obj);
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof double[]) {
            bundle.putDoubleArray(str, (double[]) obj);
        } else if (obj instanceof Integer) {
            bundle.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof int[]) {
            bundle.putIntArray(str, (int[]) obj);
        } else if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof long[]) {
            bundle.putLongArray(str, (long[]) obj);
        } else {
            String str2;
            if (obj instanceof String) {
                str2 = (String) obj;
            } else {
                if (!(obj instanceof JSONArray)) {
                    if (!(obj instanceof JSONObject)) {
                        return false;
                    }
                }
                str2 = obj.toString();
            }
            bundle.putString(str, str2);
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m990a(AccessToken accessToken) {
        return accessToken != null && accessToken.equals(AccessToken.m446c());
    }

    /* renamed from: a */
    public static <T> boolean m991a(T t, T t2) {
        if (t != null) {
            return t.equals(t2);
        }
        return t2 == null;
    }

    /* renamed from: a */
    public static <T> boolean m992a(Collection<T> collection) {
        if (collection != null) {
            if (collection.size() != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static String m993b(Context context) {
        return context == null ? "null" : context == context.getApplicationContext() ? EnvironmentCompat.MEDIA_UNKNOWN : context.getClass().getSimpleName();
    }

    /* renamed from: b */
    private static String m994b(String str, String str2) {
        return C0475Q.m965a(str, str2.getBytes());
    }

    /* renamed from: b */
    public static <T> Collection<T> m995b(T... tArr) {
        return Collections.unmodifiableCollection(Arrays.asList(tArr));
    }

    /* renamed from: b */
    private static boolean m996b() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    /* renamed from: b */
    public static boolean m997b(Uri uri) {
        if (uri != null) {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m998b(String str) {
        if (str != null) {
            if (str.length() != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    public static String m999c(Context context) {
        C0476S.m1016a((Object) context, "context");
        C0560t.m1250c(context);
        return C0560t.m1253e();
    }

    /* renamed from: c */
    public static String m1000c(String str) {
        return C0475Q.m994b("MD5", str);
    }

    /* renamed from: c */
    private static void m1001c() {
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
        r0 = com.facebook.internal.C0475Q.m996b();	 Catch:{ Exception -> 0x002a }
        if (r0 == 0) goto L_0x0021;	 Catch:{ Exception -> 0x002a }
    L_0x0006:
        r0 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ Exception -> 0x002a }
        r1 = new android.os.StatFs;	 Catch:{ Exception -> 0x002a }
        r0 = r0.getPath();	 Catch:{ Exception -> 0x002a }
        r1.<init>(r0);	 Catch:{ Exception -> 0x002a }
        r0 = r1.getAvailableBlocks();	 Catch:{ Exception -> 0x002a }
        r2 = (long) r0;	 Catch:{ Exception -> 0x002a }
        r0 = r1.getBlockSize();	 Catch:{ Exception -> 0x002a }
        r0 = (long) r0;	 Catch:{ Exception -> 0x002a }
        r2 = r2 * r0;	 Catch:{ Exception -> 0x002a }
        f845d = r2;	 Catch:{ Exception -> 0x002a }
    L_0x0021:
        r0 = f845d;	 Catch:{ Exception -> 0x002a }
        r0 = (double) r0;	 Catch:{ Exception -> 0x002a }
        r0 = com.facebook.internal.C0475Q.m957a(r0);	 Catch:{ Exception -> 0x002a }
        f845d = r0;	 Catch:{ Exception -> 0x002a }
    L_0x002a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Q.c():void");
    }

    /* renamed from: c */
    public static boolean m1002c(Uri uri) {
        if (uri != null) {
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    private static int m1003d() {
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
        r0 = f842a;
        if (r0 <= 0) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r0 = new java.io.File;	 Catch:{ Exception -> 0x001a }
        r1 = "/sys/devices/system/cpu/";	 Catch:{ Exception -> 0x001a }
        r0.<init>(r1);	 Catch:{ Exception -> 0x001a }
        r1 = new com.facebook.internal.P;	 Catch:{ Exception -> 0x001a }
        r1.<init>();	 Catch:{ Exception -> 0x001a }
        r0 = r0.listFiles(r1);	 Catch:{ Exception -> 0x001a }
        if (r0 == 0) goto L_0x001a;	 Catch:{ Exception -> 0x001a }
    L_0x0017:
        r0 = r0.length;	 Catch:{ Exception -> 0x001a }
        f842a = r0;	 Catch:{ Exception -> 0x001a }
    L_0x001a:
        r0 = f842a;
        if (r0 > 0) goto L_0x002d;
    L_0x001e:
        r0 = java.lang.Runtime.getRuntime();
        r0 = r0.availableProcessors();
        r1 = 1;
        r0 = java.lang.Math.max(r0, r1);
        f842a = r0;
    L_0x002d:
        r0 = f842a;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Q.d():int");
    }

    /* renamed from: d */
    public static Bundle m1004d(String str) {
        Bundle bundle = new Bundle();
        if (!C0475Q.m998b(str)) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                try {
                    String str2 = "UTF-8";
                    if (split2.length == 2) {
                        bundle.putString(URLDecoder.decode(split2[0], str2), URLDecoder.decode(split2[1], str2));
                    } else if (split2.length == 1) {
                        bundle.putString(URLDecoder.decode(split2[0], str2), "");
                    }
                } catch (Exception e) {
                    C0475Q.m983a("FacebookSDK", e);
                }
            }
        }
        return bundle;
    }

    /* renamed from: d */
    public static boolean m1005d(Context context) {
        boolean z = false;
        if (VERSION.SDK_INT < 26) {
            return false;
        }
        AutofillManager autofillManager = (AutofillManager) context.getSystemService(AutofillManager.class);
        if (autofillManager != null && autofillManager.isAutofillSupported() && autofillManager.isEnabled()) {
            z = true;
        }
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    public static boolean m1006d(android.net.Uri r2) {
        /*
        if (r2 == 0) goto L_0x0028;
    L_0x0002:
        r0 = r2.getScheme();
        r1 = "http";
        r0 = r1.equalsIgnoreCase(r0);
        if (r0 != 0) goto L_0x0026;
    L_0x000e:
        r0 = r2.getScheme();
        r1 = "https";
        r0 = r1.equalsIgnoreCase(r0);
        if (r0 != 0) goto L_0x0026;
    L_0x001a:
        r2 = r2.getScheme();
        r0 = "fbstaging";
        r2 = r0.equalsIgnoreCase(r2);
        if (r2 == 0) goto L_0x0028;
    L_0x0026:
        r2 = 1;
        goto L_0x0029;
    L_0x0028:
        r2 = 0;
    L_0x0029:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Q.d(android.net.Uri):boolean");
    }

    /* renamed from: e */
    private static GraphRequest m1007e(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,name,first_name,middle_name,last_name,link");
        bundle.putString("access_token", str);
        return new GraphRequest(null, "me", bundle, C0332E.GET, null);
    }

    /* renamed from: e */
    private static void m1008e() {
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
        r0 = java.util.TimeZone.getDefault();	 Catch:{ AssertionError -> 0x001a, AssertionError -> 0x001a }
        r1 = new java.util.Date;	 Catch:{ AssertionError -> 0x001a, AssertionError -> 0x001a }
        r1.<init>();	 Catch:{ AssertionError -> 0x001a, AssertionError -> 0x001a }
        r1 = r0.inDaylightTime(r1);	 Catch:{ AssertionError -> 0x001a, AssertionError -> 0x001a }
        r2 = 0;	 Catch:{ AssertionError -> 0x001a, AssertionError -> 0x001a }
        r1 = r0.getDisplayName(r1, r2);	 Catch:{ AssertionError -> 0x001a, AssertionError -> 0x001a }
        f846e = r1;	 Catch:{ AssertionError -> 0x001a, AssertionError -> 0x001a }
        r0 = r0.getID();	 Catch:{ AssertionError -> 0x001a, AssertionError -> 0x001a }
        f847f = r0;	 Catch:{ AssertionError -> 0x001a, AssertionError -> 0x001a }
    L_0x001a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Q.e():void");
    }

    /* renamed from: e */
    public static boolean m1009e(Context context) {
        if (VERSION.SDK_INT >= 27) {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.pc");
        }
        String str = Build.DEVICE;
        return str != null && str.matches(".+_cheets|cheets_.+");
    }

    /* renamed from: f */
    private static void m1010f() {
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
        r0 = com.facebook.internal.C0475Q.m996b();	 Catch:{ Exception -> 0x002a }
        if (r0 == 0) goto L_0x0021;	 Catch:{ Exception -> 0x002a }
    L_0x0006:
        r0 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ Exception -> 0x002a }
        r1 = new android.os.StatFs;	 Catch:{ Exception -> 0x002a }
        r0 = r0.getPath();	 Catch:{ Exception -> 0x002a }
        r1.<init>(r0);	 Catch:{ Exception -> 0x002a }
        r0 = r1.getBlockCount();	 Catch:{ Exception -> 0x002a }
        r2 = (long) r0;	 Catch:{ Exception -> 0x002a }
        r0 = r1.getBlockSize();	 Catch:{ Exception -> 0x002a }
        r0 = (long) r0;	 Catch:{ Exception -> 0x002a }
        r2 = r2 * r0;	 Catch:{ Exception -> 0x002a }
        f844c = r2;	 Catch:{ Exception -> 0x002a }
    L_0x0021:
        r0 = f844c;	 Catch:{ Exception -> 0x002a }
        r0 = (double) r0;	 Catch:{ Exception -> 0x002a }
        r0 = com.facebook.internal.C0475Q.m957a(r0);	 Catch:{ Exception -> 0x002a }
        f844c = r0;	 Catch:{ Exception -> 0x002a }
    L_0x002a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Q.f():void");
    }

    /* renamed from: f */
    public static boolean m1011f(Context context) {
        return C0475Q.m1005d(context);
    }

    /* renamed from: g */
    private static void m1012g(android.content.Context r2) {
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
        r0 = f848g;
        r1 = "NoCarrier";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0018;
    L_0x000a:
        r0 = "phone";	 Catch:{ Exception -> 0x0018 }
        r2 = r2.getSystemService(r0);	 Catch:{ Exception -> 0x0018 }
        r2 = (android.telephony.TelephonyManager) r2;	 Catch:{ Exception -> 0x0018 }
        r2 = r2.getNetworkOperatorName();	 Catch:{ Exception -> 0x0018 }
        f848g = r2;	 Catch:{ Exception -> 0x0018 }
    L_0x0018:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Q.g(android.content.Context):void");
    }

    /* renamed from: h */
    private static void m1013h(Context context) {
        if (f843b == -1 || System.currentTimeMillis() - f843b >= 1800000) {
            f843b = System.currentTimeMillis();
            C0475Q.m1008e();
            C0475Q.m1012g(context);
            C0475Q.m1010f();
            C0475Q.m1001c();
        }
    }
}
