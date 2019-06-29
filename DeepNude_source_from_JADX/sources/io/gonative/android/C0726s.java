package io.gonative.android;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.webkit.URLUtil;
import io.gonative.android.p038a.C0700a;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: io.gonative.android.s */
public class C0726s {
    /* renamed from: a */
    private static final String f1643a = "io.gonative.android.s";

    /* renamed from: a */
    public static android.os.Bundle m1963a(org.json.JSONObject r5) {
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
        if (r5 != 0) goto L_0x0004;
    L_0x0002:
        r5 = 0;
        return r5;
    L_0x0004:
        r0 = new android.os.Bundle;
        r0.<init>();
        r1 = r5.keys();
    L_0x000d:
        r2 = r1.hasNext();
        if (r2 == 0) goto L_0x0053;
    L_0x0013:
        r2 = r1.next();
        r2 = (java.lang.String) r2;
        r3 = r5.get(r2);	 Catch:{ JSONException -> 0x0051 }
        r4 = r3 instanceof java.lang.String;	 Catch:{ JSONException -> 0x0051 }
        if (r4 == 0) goto L_0x0027;	 Catch:{ JSONException -> 0x0051 }
    L_0x0021:
        r3 = (java.lang.String) r3;	 Catch:{ JSONException -> 0x0051 }
        r0.putString(r2, r3);	 Catch:{ JSONException -> 0x0051 }
        goto L_0x000d;	 Catch:{ JSONException -> 0x0051 }
    L_0x0027:
        r4 = r3 instanceof java.lang.Double;	 Catch:{ JSONException -> 0x0051 }
        if (r4 == 0) goto L_0x0035;	 Catch:{ JSONException -> 0x0051 }
    L_0x002b:
        r3 = (java.lang.Double) r3;	 Catch:{ JSONException -> 0x0051 }
        r3 = r3.doubleValue();	 Catch:{ JSONException -> 0x0051 }
        r0.putDouble(r2, r3);	 Catch:{ JSONException -> 0x0051 }
        goto L_0x000d;	 Catch:{ JSONException -> 0x0051 }
    L_0x0035:
        r4 = r3 instanceof java.lang.Boolean;	 Catch:{ JSONException -> 0x0051 }
        if (r4 == 0) goto L_0x0043;	 Catch:{ JSONException -> 0x0051 }
    L_0x0039:
        r3 = (java.lang.Boolean) r3;	 Catch:{ JSONException -> 0x0051 }
        r3 = r3.booleanValue();	 Catch:{ JSONException -> 0x0051 }
        r0.putBoolean(r2, r3);	 Catch:{ JSONException -> 0x0051 }
        goto L_0x000d;	 Catch:{ JSONException -> 0x0051 }
    L_0x0043:
        r4 = r3 instanceof java.lang.Integer;	 Catch:{ JSONException -> 0x0051 }
        if (r4 == 0) goto L_0x000d;	 Catch:{ JSONException -> 0x0051 }
    L_0x0047:
        r3 = (java.lang.Integer) r3;	 Catch:{ JSONException -> 0x0051 }
        r3 = r3.intValue();	 Catch:{ JSONException -> 0x0051 }
        r0.putInt(r2, r3);	 Catch:{ JSONException -> 0x0051 }
        goto L_0x000d;
        goto L_0x000d;
    L_0x0053:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.gonative.android.s.a(org.json.JSONObject):android.os.Bundle");
    }

    /* renamed from: a */
    public static String m1964a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] split = str.split("\\s+");
        for (int i = 0; i < split.length; i++) {
            String str2 = split[i];
            if (str2.length() > 0) {
                stringBuilder.append(Character.toUpperCase(str2.charAt(0)));
                if (str2.length() > 1) {
                    stringBuilder.append(str2.substring(1));
                }
            }
            if (i < split.length - 1) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public static String m1965a(String str, String str2, String str3) {
        if (str2 != null && str2.toLowerCase().startsWith("inline;")) {
            try {
                Matcher matcher = Pattern.compile("inline;\\s*filename\\s*=\\s*(\"?)([^\"]*)\\1\\s*$", 2).matcher(str2);
                if (matcher.find()) {
                    return matcher.group(2);
                }
            } catch (Throwable e) {
                Log.e(f1643a, "Error parsing content-disposition inline", e);
            }
        }
        return URLUtil.guessFileName(str, str2, str3);
    }

    /* renamed from: a */
    public static String m1966a(String str, JSONObject jSONObject) {
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("function gonative_do_callback(functionName, jsonString) { \n    if (typeof window[functionName] !== 'function') return; \n \n    try { \n        var data = JSON.parse(jsonString); \n        var callbackFunction = window[functionName]; \n        callbackFunction(data); \n    } catch (ignored) { \n \n    } \n} \ngonative_do_callback('");
        stringBuilder.append(str);
        stringBuilder.append("', ");
        stringBuilder.append(C0726s.m1973b(jSONObject2));
        stringBuilder.append(");");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public static String m1967a(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(date);
    }

    /* renamed from: a */
    public static String m1968a(JSONObject jSONObject, String str) {
        return jSONObject != null ? str == null ? null : jSONObject.isNull(str) ? null : jSONObject.optString(str, null) : null;
    }

    /* renamed from: a */
    public static List<Pattern> m1969a(Object obj) {
        List<Pattern> linkedList = new LinkedList();
        String str = "Error parsing regex: ";
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            for (int i = 0; i < jSONArray.length(); i++) {
                String str2 = null;
                if (!jSONArray.isNull(i)) {
                    str2 = jSONArray.optString(i, null);
                }
                if (str2 != null) {
                    try {
                        linkedList.add(Pattern.compile(str2));
                    } catch (Throwable e) {
                        String str3 = f1643a;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append(str2);
                        Log.e(str3, stringBuilder.toString(), e);
                    }
                }
            }
        } else if (obj instanceof String) {
            String str4 = (String) obj;
            try {
                linkedList.add(Pattern.compile(str4));
            } catch (Throwable e2) {
                String str5 = f1643a;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str);
                stringBuilder2.append(str4);
                Log.e(str5, stringBuilder2.toString(), e2);
            }
        }
        return linkedList;
    }

    /* renamed from: a */
    public static boolean m1970a(String str, Context context) {
        C0700a a = C0700a.m1851a(context);
        List list = a.f1554z;
        if (list != null) {
            if (!list.isEmpty()) {
                boolean z = false;
                for (Pattern matcher : a.f1554z) {
                    if (matcher.matcher(str).matches()) {
                        z = true;
                        break;
                    }
                }
                return z;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m1971a(java.lang.String r8, java.lang.String r9) {
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
        r0 = "www.";
        r1 = 0;
        r8 = android.net.Uri.parse(r8);	 Catch:{ Exception -> 0x0081 }
        r9 = android.net.Uri.parse(r9);	 Catch:{ Exception -> 0x0081 }
        r2 = r8.getPath();	 Catch:{ Exception -> 0x0081 }
        r3 = r9.getPath();	 Catch:{ Exception -> 0x0081 }
        r4 = r2.length();	 Catch:{ Exception -> 0x0081 }
        r5 = "//";
        r6 = 1;
        r7 = 2;
        if (r4 < r7) goto L_0x002f;
    L_0x001d:
        r4 = r2.substring(r1, r7);	 Catch:{ Exception -> 0x0081 }
        r4 = r4.equals(r5);	 Catch:{ Exception -> 0x0081 }
        if (r4 == 0) goto L_0x002f;	 Catch:{ Exception -> 0x0081 }
    L_0x0027:
        r4 = r2.length();	 Catch:{ Exception -> 0x0081 }
        r2 = r2.substring(r6, r4);	 Catch:{ Exception -> 0x0081 }
    L_0x002f:
        r4 = r3.length();	 Catch:{ Exception -> 0x0081 }
        if (r4 < r7) goto L_0x0047;	 Catch:{ Exception -> 0x0081 }
    L_0x0035:
        r4 = r3.substring(r1, r7);	 Catch:{ Exception -> 0x0081 }
        r4 = r4.equals(r5);	 Catch:{ Exception -> 0x0081 }
        if (r4 == 0) goto L_0x0047;	 Catch:{ Exception -> 0x0081 }
    L_0x003f:
        r4 = r3.length();	 Catch:{ Exception -> 0x0081 }
        r3 = r3.substring(r6, r4);	 Catch:{ Exception -> 0x0081 }
    L_0x0047:
        r4 = r2.isEmpty();	 Catch:{ Exception -> 0x0081 }
        r5 = "/";
        if (r4 == 0) goto L_0x0050;
    L_0x004f:
        r2 = r5;
    L_0x0050:
        r4 = r3.isEmpty();	 Catch:{ Exception -> 0x0081 }
        if (r4 == 0) goto L_0x0057;	 Catch:{ Exception -> 0x0081 }
    L_0x0056:
        r3 = r5;	 Catch:{ Exception -> 0x0081 }
    L_0x0057:
        r8 = r8.getHost();	 Catch:{ Exception -> 0x0081 }
        r9 = r9.getHost();	 Catch:{ Exception -> 0x0081 }
        r4 = r8.startsWith(r0);	 Catch:{ Exception -> 0x0081 }
        r5 = 4;	 Catch:{ Exception -> 0x0081 }
        if (r4 == 0) goto L_0x006a;	 Catch:{ Exception -> 0x0081 }
    L_0x0066:
        r8 = r8.substring(r5);	 Catch:{ Exception -> 0x0081 }
    L_0x006a:
        r0 = r9.startsWith(r0);	 Catch:{ Exception -> 0x0081 }
        if (r0 == 0) goto L_0x0074;	 Catch:{ Exception -> 0x0081 }
    L_0x0070:
        r9 = r9.substring(r5);	 Catch:{ Exception -> 0x0081 }
    L_0x0074:
        r8 = r8.equals(r9);	 Catch:{ Exception -> 0x0081 }
        if (r8 == 0) goto L_0x0081;	 Catch:{ Exception -> 0x0081 }
    L_0x007a:
        r8 = r2.equals(r3);	 Catch:{ Exception -> 0x0081 }
        if (r8 == 0) goto L_0x0081;
    L_0x0080:
        r1 = 1;
    L_0x0081:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.gonative.android.s.a(java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: a */
    public static boolean m1972a(String str, Collection<Pattern> collection) {
        if (!(str == null || collection == null)) {
            if (!collection.isEmpty()) {
                for (Pattern matcher : collection) {
                    if (matcher.matcher(str).matches()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    public static String m1973b(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("decodeURIComponent(\"");
        stringBuilder.append(C0726s.m1975d(str));
        stringBuilder.append("\")");
        return stringBuilder.toString();
    }

    /* renamed from: c */
    public static Integer m1974c(String str) {
        if (str == null) {
            return null;
        }
        String str2 = "#";
        if (!str.startsWith(str2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str2);
            stringBuilder.append(str);
            str = stringBuilder.toString();
        }
        try {
            str = Integer.valueOf(Color.parseColor(str));
            return str;
        } catch (Throwable e) {
            String str3 = f1643a;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Bad color string:");
            stringBuilder2.append(str);
            Log.e(str3, stringBuilder2.toString(), e);
            return null;
        }
    }

    /* renamed from: d */
    private static String m1975d(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replace("+", " ");
        } catch (Throwable e) {
            Log.e(f1643a, e.getMessage(), e);
            return null;
        }
    }
}
