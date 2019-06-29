package io.gonative.android;

import android.content.Context;
import android.os.Build;
import android.provider.Settings.Secure;
import android.util.Base64;

/* renamed from: io.gonative.android.d */
public class C0707d {
    /* renamed from: a */
    private static String m1917a(Context context, String str) {
        if (str == null) {
            return null;
        }
        CharSequence string;
        CharSequence charSequence = "%DEVICEID%";
        if (str.contains(charSequence)) {
            string = Secure.getString(context.getContentResolver(), "android_id");
            if (string == null) {
                string = "";
            }
            str = str.replace(charSequence, string);
        }
        string = "%DEVICENAME64%";
        if (str.contains(string)) {
            String str2 = Build.MANUFACTURER;
            String str3 = Build.MODEL;
            if (!str3.startsWith(str2)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str2);
                stringBuilder.append(" ");
                stringBuilder.append(str3);
                str3 = stringBuilder.toString();
            }
            str = str.replace(string, Base64.encodeToString(str3.getBytes("UTF-8"), 2));
        }
        return str;
    }

    /* renamed from: a */
    public static java.util.Map<java.lang.String, java.lang.String> m1918a(android.content.Context r8) {
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
        r0 = io.gonative.android.p038a.C0700a.m1851a(r8);
        r1 = r0.f1552x;
        r2 = 0;
        if (r1 != 0) goto L_0x000a;
    L_0x0009:
        return r2;
    L_0x000a:
        r1 = new java.util.HashMap;
        r1.<init>();
        r0 = r0.f1552x;
        r0 = r0.entrySet();
        r0 = r0.iterator();
    L_0x0019:
        r3 = r0.hasNext();
        if (r3 == 0) goto L_0x0049;
    L_0x001f:
        r3 = r0.next();
        r3 = (java.util.Map.Entry) r3;
        r4 = r3.getKey();
        r4 = (java.lang.String) r4;
        r3 = r3.getValue();	 Catch:{ UnsupportedEncodingException -> 0x0036 }
        r3 = (java.lang.String) r3;	 Catch:{ UnsupportedEncodingException -> 0x0036 }
        r3 = io.gonative.android.C0707d.m1917a(r8, r3);	 Catch:{ UnsupportedEncodingException -> 0x0036 }
        goto L_0x0037;
    L_0x0036:
        r3 = r2;
    L_0x0037:
        r5 = 1;
        r6 = 0;
        if (r4 == 0) goto L_0x003d;
    L_0x003b:
        r7 = 1;
        goto L_0x003e;
    L_0x003d:
        r7 = 0;
    L_0x003e:
        if (r3 == 0) goto L_0x0041;
    L_0x0040:
        goto L_0x0042;
    L_0x0041:
        r5 = 0;
    L_0x0042:
        r5 = r5 & r7;
        if (r5 == 0) goto L_0x0019;
    L_0x0045:
        r1.put(r4, r3);
        goto L_0x0019;
    L_0x0049:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.gonative.android.d.a(android.content.Context):java.util.Map<java.lang.String, java.lang.String>");
    }
}
