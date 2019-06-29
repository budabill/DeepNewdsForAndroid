package com.google.android.gms.internal;

import java.util.List;

final class zzfjf {
    static String zza(zzfjc zzfjc, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("# ");
        stringBuilder.append(str);
        zza(zzfjc, stringBuilder, 0);
        return stringBuilder.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.zzfjc r13, java.lang.StringBuilder r14, int r15) {
        /*
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = new java.util.HashMap;
        r1.<init>();
        r2 = new java.util.TreeSet;
        r2.<init>();
        r3 = r13.getClass();
        r3 = r3.getDeclaredMethods();
        r4 = r3.length;
        r5 = 0;
        r6 = 0;
    L_0x001a:
        r7 = "get";
        if (r6 >= r4) goto L_0x0049;
    L_0x001e:
        r8 = r3[r6];
        r9 = r8.getName();
        r1.put(r9, r8);
        r9 = r8.getParameterTypes();
        r9 = r9.length;
        if (r9 != 0) goto L_0x0046;
    L_0x002e:
        r9 = r8.getName();
        r0.put(r9, r8);
        r9 = r8.getName();
        r7 = r9.startsWith(r7);
        if (r7 == 0) goto L_0x0046;
    L_0x003f:
        r7 = r8.getName();
        r2.add(r7);
    L_0x0046:
        r6 = r6 + 1;
        goto L_0x001a;
    L_0x0049:
        r2 = r2.iterator();
    L_0x004d:
        r3 = r2.hasNext();
        if (r3 == 0) goto L_0x0212;
    L_0x0053:
        r3 = r2.next();
        r3 = (java.lang.String) r3;
        r4 = "";
        r3 = r3.replaceFirst(r7, r4);
        r6 = "List";
        r6 = r3.endsWith(r6);
        r8 = 1;
        if (r6 == 0) goto L_0x00d2;
    L_0x0068:
        r6 = "OrBuilderList";
        r6 = r3.endsWith(r6);
        if (r6 != 0) goto L_0x00d2;
    L_0x0070:
        r6 = r3.substring(r5, r8);
        r6 = r6.toLowerCase();
        r6 = java.lang.String.valueOf(r6);
        r9 = r3.length();
        r9 = r9 + -4;
        r9 = r3.substring(r8, r9);
        r9 = java.lang.String.valueOf(r9);
        r10 = r9.length();
        if (r10 == 0) goto L_0x0095;
    L_0x0090:
        r6 = r6.concat(r9);
        goto L_0x009b;
    L_0x0095:
        r9 = new java.lang.String;
        r9.<init>(r6);
        r6 = r9;
    L_0x009b:
        r9 = java.lang.String.valueOf(r3);
        r10 = r9.length();
        if (r10 == 0) goto L_0x00aa;
    L_0x00a5:
        r9 = r7.concat(r9);
        goto L_0x00af;
    L_0x00aa:
        r9 = new java.lang.String;
        r9.<init>(r7);
    L_0x00af:
        r9 = r0.get(r9);
        r9 = (java.lang.reflect.Method) r9;
        if (r9 == 0) goto L_0x00d2;
    L_0x00b7:
        r10 = r9.getReturnType();
        r11 = java.util.List.class;
        r10 = r10.equals(r11);
        if (r10 == 0) goto L_0x00d2;
    L_0x00c3:
        r3 = zztz(r6);
        r4 = new java.lang.Object[r5];
        r4 = com.google.android.gms.internal.zzfhu.zza(r9, r13, r4);
        zzb(r14, r15, r3, r4);
        goto L_0x004d;
    L_0x00d2:
        r6 = "set";
        r9 = java.lang.String.valueOf(r3);
        r10 = r9.length();
        if (r10 == 0) goto L_0x00e3;
    L_0x00de:
        r6 = r6.concat(r9);
        goto L_0x00e9;
    L_0x00e3:
        r9 = new java.lang.String;
        r9.<init>(r6);
        r6 = r9;
    L_0x00e9:
        r6 = r1.get(r6);
        r6 = (java.lang.reflect.Method) r6;
        if (r6 == 0) goto L_0x004d;
    L_0x00f1:
        r6 = "Bytes";
        r6 = r3.endsWith(r6);
        if (r6 == 0) goto L_0x011d;
    L_0x00f9:
        r6 = r3.length();
        r6 = r6 + -5;
        r6 = r3.substring(r5, r6);
        r6 = java.lang.String.valueOf(r6);
        r9 = r6.length();
        if (r9 == 0) goto L_0x0112;
    L_0x010d:
        r6 = r7.concat(r6);
        goto L_0x0117;
    L_0x0112:
        r6 = new java.lang.String;
        r6.<init>(r7);
    L_0x0117:
        r6 = r0.containsKey(r6);
        if (r6 != 0) goto L_0x004d;
    L_0x011d:
        r6 = r3.substring(r5, r8);
        r6 = r6.toLowerCase();
        r6 = java.lang.String.valueOf(r6);
        r9 = r3.substring(r8);
        r9 = java.lang.String.valueOf(r9);
        r10 = r9.length();
        if (r10 == 0) goto L_0x013c;
    L_0x0137:
        r6 = r6.concat(r9);
        goto L_0x0142;
    L_0x013c:
        r9 = new java.lang.String;
        r9.<init>(r6);
        r6 = r9;
    L_0x0142:
        r9 = java.lang.String.valueOf(r3);
        r10 = r9.length();
        if (r10 == 0) goto L_0x0151;
    L_0x014c:
        r9 = r7.concat(r9);
        goto L_0x0156;
    L_0x0151:
        r9 = new java.lang.String;
        r9.<init>(r7);
    L_0x0156:
        r9 = r0.get(r9);
        r9 = (java.lang.reflect.Method) r9;
        r10 = "has";
        r3 = java.lang.String.valueOf(r3);
        r11 = r3.length();
        if (r11 == 0) goto L_0x016d;
    L_0x0168:
        r3 = r10.concat(r3);
        goto L_0x0172;
    L_0x016d:
        r3 = new java.lang.String;
        r3.<init>(r10);
    L_0x0172:
        r3 = r0.get(r3);
        r3 = (java.lang.reflect.Method) r3;
        if (r9 == 0) goto L_0x004d;
    L_0x017a:
        r10 = new java.lang.Object[r5];
        r9 = com.google.android.gms.internal.zzfhu.zza(r9, r13, r10);
        if (r3 != 0) goto L_0x01fb;
    L_0x0182:
        r3 = r9 instanceof java.lang.Boolean;
        if (r3 == 0) goto L_0x0194;
    L_0x0186:
        r3 = r9;
        r3 = (java.lang.Boolean) r3;
        r3 = r3.booleanValue();
        if (r3 != 0) goto L_0x0192;
    L_0x018f:
        r3 = 1;
        goto L_0x01f5;
    L_0x0192:
        r3 = 0;
        goto L_0x01f5;
    L_0x0194:
        r3 = r9 instanceof java.lang.Integer;
        if (r3 == 0) goto L_0x01a2;
    L_0x0198:
        r3 = r9;
        r3 = (java.lang.Integer) r3;
        r3 = r3.intValue();
        if (r3 != 0) goto L_0x0192;
    L_0x01a1:
        goto L_0x018f;
    L_0x01a2:
        r3 = r9 instanceof java.lang.Float;
        if (r3 == 0) goto L_0x01b3;
    L_0x01a6:
        r3 = r9;
        r3 = (java.lang.Float) r3;
        r3 = r3.floatValue();
        r4 = 0;
        r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1));
        if (r3 != 0) goto L_0x0192;
    L_0x01b2:
        goto L_0x018f;
    L_0x01b3:
        r3 = r9 instanceof java.lang.Double;
        if (r3 == 0) goto L_0x01c5;
    L_0x01b7:
        r3 = r9;
        r3 = (java.lang.Double) r3;
        r3 = r3.doubleValue();
        r10 = 0;
        r12 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1));
        if (r12 != 0) goto L_0x0192;
    L_0x01c4:
        goto L_0x018f;
    L_0x01c5:
        r3 = r9 instanceof java.lang.String;
        if (r3 == 0) goto L_0x01ce;
    L_0x01c9:
        r3 = r9.equals(r4);
        goto L_0x01f5;
    L_0x01ce:
        r3 = r9 instanceof com.google.android.gms.internal.zzfgs;
        if (r3 == 0) goto L_0x01d9;
    L_0x01d2:
        r3 = com.google.android.gms.internal.zzfgs.zzpnw;
        r3 = r9.equals(r3);
        goto L_0x01f5;
    L_0x01d9:
        r3 = r9 instanceof com.google.android.gms.internal.zzfjc;
        if (r3 == 0) goto L_0x01e7;
    L_0x01dd:
        r3 = r9;
        r3 = (com.google.android.gms.internal.zzfjc) r3;
        r3 = r3.zzczu();
        if (r9 != r3) goto L_0x0192;
    L_0x01e6:
        goto L_0x018f;
    L_0x01e7:
        r3 = r9 instanceof java.lang.Enum;
        if (r3 == 0) goto L_0x0192;
    L_0x01eb:
        r3 = r9;
        r3 = (java.lang.Enum) r3;
        r3 = r3.ordinal();
        if (r3 != 0) goto L_0x0192;
    L_0x01f4:
        goto L_0x018f;
    L_0x01f5:
        if (r3 != 0) goto L_0x01f9;
    L_0x01f7:
        r3 = 1;
        goto L_0x0207;
    L_0x01f9:
        r3 = 0;
        goto L_0x0207;
    L_0x01fb:
        r4 = new java.lang.Object[r5];
        r3 = com.google.android.gms.internal.zzfhu.zza(r3, r13, r4);
        r3 = (java.lang.Boolean) r3;
        r3 = r3.booleanValue();
    L_0x0207:
        if (r3 == 0) goto L_0x004d;
    L_0x0209:
        r3 = zztz(r6);
        zzb(r14, r15, r3, r9);
        goto L_0x004d;
    L_0x0212:
        r0 = r13 instanceof com.google.android.gms.internal.zzfhu.zzd;
        if (r0 == 0) goto L_0x0235;
    L_0x0216:
        r0 = r13;
        r0 = (com.google.android.gms.internal.zzfhu.zzd) r0;
        r0 = r0.zzppp;
        r0 = r0.iterator();
        r1 = r0.hasNext();
        if (r1 != 0) goto L_0x0226;
    L_0x0225:
        goto L_0x0235;
    L_0x0226:
        r13 = r0.next();
        r13 = (java.util.Map.Entry) r13;
        r13.getKey();
        r13 = new java.lang.NoSuchMethodError;
        r13.<init>();
        throw r13;
    L_0x0235:
        r13 = (com.google.android.gms.internal.zzfhu) r13;
        r13 = r13.zzpph;
        if (r13 == 0) goto L_0x023e;
    L_0x023b:
        r13.zzd(r14, r15);
    L_0x023e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfjf.zza(com.google.android.gms.internal.zzfjc, java.lang.StringBuilder, int):void");
    }

    static final void zzb(StringBuilder stringBuilder, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object zzb : (List) obj) {
                zzb(stringBuilder, i, str, zzb);
            }
            return;
        }
        stringBuilder.append('\n');
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append(' ');
        }
        stringBuilder.append(str);
        String str2 = ": \"";
        if (obj instanceof String) {
            stringBuilder.append(str2);
            stringBuilder.append(zzfkh.zzbd(zzfgs.zztv((String) obj)));
            stringBuilder.append('\"');
        } else if (obj instanceof zzfgs) {
            stringBuilder.append(str2);
            stringBuilder.append(zzfkh.zzbd((zzfgs) obj));
            stringBuilder.append('\"');
        } else if (obj instanceof zzfhu) {
            stringBuilder.append(" {");
            zza((zzfhu) obj, stringBuilder, i + 2);
            stringBuilder.append("\n");
            for (int i3 = 0; i3 < i; i3++) {
                stringBuilder.append(' ');
            }
            stringBuilder.append("}");
        } else {
            stringBuilder.append(": ");
            stringBuilder.append(obj.toString());
        }
    }

    private static final String zztz(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                stringBuilder.append("_");
            }
            stringBuilder.append(Character.toLowerCase(charAt));
        }
        return stringBuilder.toString();
    }
}
