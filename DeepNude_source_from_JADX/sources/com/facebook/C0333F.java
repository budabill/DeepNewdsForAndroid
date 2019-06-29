package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.internal.C0461G;
import com.facebook.internal.C0475Q;
import com.facebook.internal.C0476S;
import java.util.Date;
import org.json.JSONException;

/* renamed from: com.facebook.F */
final class C0333F {
    /* renamed from: a */
    private static final String f441a = "F";
    /* renamed from: b */
    private String f442b;
    /* renamed from: c */
    private SharedPreferences f443c;

    public C0333F(Context context) {
        this(context, null);
    }

    public C0333F(Context context, String str) {
        C0476S.m1016a((Object) context, "context");
        if (C0475Q.m998b(str)) {
            str = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY";
        }
        this.f442b = str;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        this.f443c = context.getSharedPreferences(this.f442b, 0);
    }

    /* renamed from: a */
    public static String m488a(Bundle bundle) {
        C0476S.m1016a((Object) bundle, "bundle");
        return bundle.getString("com.facebook.TokenCachingStrategy.ApplicationId");
    }

    /* renamed from: a */
    static Date m489a(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        long j = bundle.getLong(str, Long.MIN_VALUE);
        return j == Long.MIN_VALUE ? null : new Date(j);
    }

    /* renamed from: a */
    private void m490a(java.lang.String r8, android.os.Bundle r9) {
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
        r7 = this;
        r0 = r7.f443c;
        r1 = "{}";
        r0 = r0.getString(r8, r1);
        r1 = new org.json.JSONObject;
        r1.<init>(r0);
        r0 = "valueType";
        r0 = r1.getString(r0);
        r2 = "bool";
        r2 = r0.equals(r2);
        r3 = "value";
        if (r2 == 0) goto L_0x0026;
    L_0x001d:
        r0 = r1.getBoolean(r3);
        r9.putBoolean(r8, r0);
        goto L_0x022f;
    L_0x0026:
        r2 = "bool[]";
        r2 = r0.equals(r2);
        r4 = 0;
        if (r2 == 0) goto L_0x004a;
    L_0x002f:
        r0 = r1.getJSONArray(r3);
        r1 = r0.length();
        r1 = new boolean[r1];
    L_0x0039:
        r2 = r1.length;
        if (r4 >= r2) goto L_0x0045;
    L_0x003c:
        r2 = r0.getBoolean(r4);
        r1[r4] = r2;
        r4 = r4 + 1;
        goto L_0x0039;
    L_0x0045:
        r9.putBooleanArray(r8, r1);
        goto L_0x022f;
    L_0x004a:
        r2 = "byte";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x005c;
    L_0x0052:
        r0 = r1.getInt(r3);
        r0 = (byte) r0;
        r9.putByte(r8, r0);
        goto L_0x022f;
    L_0x005c:
        r2 = "byte[]";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x0080;
    L_0x0064:
        r0 = r1.getJSONArray(r3);
        r1 = r0.length();
        r1 = new byte[r1];
    L_0x006e:
        r2 = r1.length;
        if (r4 >= r2) goto L_0x007b;
    L_0x0071:
        r2 = r0.getInt(r4);
        r2 = (byte) r2;
        r1[r4] = r2;
        r4 = r4 + 1;
        goto L_0x006e;
    L_0x007b:
        r9.putByteArray(r8, r1);
        goto L_0x022f;
    L_0x0080:
        r2 = "short";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x0092;
    L_0x0088:
        r0 = r1.getInt(r3);
        r0 = (short) r0;
        r9.putShort(r8, r0);
        goto L_0x022f;
    L_0x0092:
        r2 = "short[]";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x00b6;
    L_0x009a:
        r0 = r1.getJSONArray(r3);
        r1 = r0.length();
        r1 = new short[r1];
    L_0x00a4:
        r2 = r1.length;
        if (r4 >= r2) goto L_0x00b1;
    L_0x00a7:
        r2 = r0.getInt(r4);
        r2 = (short) r2;
        r1[r4] = r2;
        r4 = r4 + 1;
        goto L_0x00a4;
    L_0x00b1:
        r9.putShortArray(r8, r1);
        goto L_0x022f;
    L_0x00b6:
        r2 = "int";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x00c7;
    L_0x00be:
        r0 = r1.getInt(r3);
        r9.putInt(r8, r0);
        goto L_0x022f;
    L_0x00c7:
        r2 = "int[]";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x00ea;
    L_0x00cf:
        r0 = r1.getJSONArray(r3);
        r1 = r0.length();
        r1 = new int[r1];
    L_0x00d9:
        r2 = r1.length;
        if (r4 >= r2) goto L_0x00e5;
    L_0x00dc:
        r2 = r0.getInt(r4);
        r1[r4] = r2;
        r4 = r4 + 1;
        goto L_0x00d9;
    L_0x00e5:
        r9.putIntArray(r8, r1);
        goto L_0x022f;
    L_0x00ea:
        r2 = "long";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x00fb;
    L_0x00f2:
        r0 = r1.getLong(r3);
        r9.putLong(r8, r0);
        goto L_0x022f;
    L_0x00fb:
        r2 = "long[]";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x011e;
    L_0x0103:
        r0 = r1.getJSONArray(r3);
        r1 = r0.length();
        r1 = new long[r1];
    L_0x010d:
        r2 = r1.length;
        if (r4 >= r2) goto L_0x0119;
    L_0x0110:
        r2 = r0.getLong(r4);
        r1[r4] = r2;
        r4 = r4 + 1;
        goto L_0x010d;
    L_0x0119:
        r9.putLongArray(r8, r1);
        goto L_0x022f;
    L_0x011e:
        r2 = "float";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x0130;
    L_0x0126:
        r0 = r1.getDouble(r3);
        r0 = (float) r0;
        r9.putFloat(r8, r0);
        goto L_0x022f;
    L_0x0130:
        r2 = "float[]";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x0154;
    L_0x0138:
        r0 = r1.getJSONArray(r3);
        r1 = r0.length();
        r1 = new float[r1];
    L_0x0142:
        r2 = r1.length;
        if (r4 >= r2) goto L_0x014f;
    L_0x0145:
        r2 = r0.getDouble(r4);
        r2 = (float) r2;
        r1[r4] = r2;
        r4 = r4 + 1;
        goto L_0x0142;
    L_0x014f:
        r9.putFloatArray(r8, r1);
        goto L_0x022f;
    L_0x0154:
        r2 = "double";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x0165;
    L_0x015c:
        r0 = r1.getDouble(r3);
        r9.putDouble(r8, r0);
        goto L_0x022f;
    L_0x0165:
        r2 = "double[]";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x0188;
    L_0x016d:
        r0 = r1.getJSONArray(r3);
        r1 = r0.length();
        r1 = new double[r1];
    L_0x0177:
        r2 = r1.length;
        if (r4 >= r2) goto L_0x0183;
    L_0x017a:
        r2 = r0.getDouble(r4);
        r1[r4] = r2;
        r4 = r4 + 1;
        goto L_0x0177;
    L_0x0183:
        r9.putDoubleArray(r8, r1);
        goto L_0x022f;
    L_0x0188:
        r2 = "char";
        r2 = r0.equals(r2);
        r5 = 1;
        if (r2 == 0) goto L_0x01a6;
    L_0x0191:
        r0 = r1.getString(r3);
        if (r0 == 0) goto L_0x022f;
    L_0x0197:
        r1 = r0.length();
        if (r1 != r5) goto L_0x022f;
    L_0x019d:
        r0 = r0.charAt(r4);
        r9.putChar(r8, r0);
        goto L_0x022f;
    L_0x01a6:
        r2 = "char[]";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x01d5;
    L_0x01ae:
        r0 = r1.getJSONArray(r3);
        r1 = r0.length();
        r1 = new char[r1];
        r2 = 0;
    L_0x01b9:
        r3 = r1.length;
        if (r2 >= r3) goto L_0x01d1;
    L_0x01bc:
        r3 = r0.getString(r2);
        if (r3 == 0) goto L_0x01ce;
    L_0x01c2:
        r6 = r3.length();
        if (r6 != r5) goto L_0x01ce;
    L_0x01c8:
        r3 = r3.charAt(r4);
        r1[r2] = r3;
    L_0x01ce:
        r2 = r2 + 1;
        goto L_0x01b9;
    L_0x01d1:
        r9.putCharArray(r8, r1);
        goto L_0x022f;
    L_0x01d5:
        r2 = "string";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x01e5;
    L_0x01dd:
        r0 = r1.getString(r3);
        r9.putString(r8, r0);
        goto L_0x022f;
    L_0x01e5:
        r2 = "stringList";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x0212;
    L_0x01ed:
        r0 = r1.getJSONArray(r3);
        r1 = r0.length();
        r2 = new java.util.ArrayList;
        r2.<init>(r1);
    L_0x01fa:
        if (r4 >= r1) goto L_0x020e;
    L_0x01fc:
        r3 = r0.get(r4);
        r5 = org.json.JSONObject.NULL;
        if (r3 != r5) goto L_0x0206;
    L_0x0204:
        r3 = 0;
        goto L_0x0208;
    L_0x0206:
        r3 = (java.lang.String) r3;
    L_0x0208:
        r2.add(r4, r3);
        r4 = r4 + 1;
        goto L_0x01fa;
    L_0x020e:
        r9.putStringArrayList(r8, r2);
        goto L_0x022f;
    L_0x0212:
        r2 = "enum";
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x022f;
    L_0x021a:
        r0 = "enumType";	 Catch:{ ClassNotFoundException -> 0x022f, ClassNotFoundException -> 0x022f }
        r0 = r1.getString(r0);	 Catch:{ ClassNotFoundException -> 0x022f, ClassNotFoundException -> 0x022f }
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x022f, ClassNotFoundException -> 0x022f }
        r1 = r1.getString(r3);	 Catch:{ ClassNotFoundException -> 0x022f, ClassNotFoundException -> 0x022f }
        r0 = java.lang.Enum.valueOf(r0, r1);	 Catch:{ ClassNotFoundException -> 0x022f, ClassNotFoundException -> 0x022f }
        r9.putSerializable(r8, r0);	 Catch:{ ClassNotFoundException -> 0x022f, ClassNotFoundException -> 0x022f }
    L_0x022f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.F.a(java.lang.String, android.os.Bundle):void");
    }

    /* renamed from: b */
    public static C0451h m491b(Bundle bundle) {
        C0476S.m1016a((Object) bundle, "bundle");
        String str = "com.facebook.TokenCachingStrategy.AccessTokenSource";
        if (bundle.containsKey(str)) {
            return (C0451h) bundle.getSerializable(str);
        }
        return bundle.getBoolean("com.facebook.TokenCachingStrategy.IsSSO") ? C0451h.FACEBOOK_APPLICATION_WEB : C0451h.WEB_VIEW;
    }

    /* renamed from: c */
    public static String m492c(Bundle bundle) {
        C0476S.m1016a((Object) bundle, "bundle");
        return bundle.getString("com.facebook.TokenCachingStrategy.Token");
    }

    /* renamed from: d */
    public static boolean m493d(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        String string = bundle.getString("com.facebook.TokenCachingStrategy.Token");
        if (string != null) {
            if (string.length() != 0) {
                return bundle.getLong("com.facebook.TokenCachingStrategy.ExpirationDate", 0) != 0;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void m494a() {
        this.f443c.edit().clear().apply();
    }

    /* renamed from: b */
    public Bundle m495b() {
        Bundle bundle = new Bundle();
        for (String str : this.f443c.getAll().keySet()) {
            try {
                m490a(str, bundle);
            } catch (JSONException e) {
                C0336G c0336g = C0336G.CACHE;
                String str2 = f441a;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error reading cached value for key: '");
                stringBuilder.append(str);
                stringBuilder.append("' -- ");
                stringBuilder.append(e);
                C0461G.m889a(c0336g, 5, str2, stringBuilder.toString());
                return null;
            }
        }
        return bundle;
    }
}
