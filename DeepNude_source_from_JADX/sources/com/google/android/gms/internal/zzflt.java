package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;

public final class zzflt {
    private static void zza(java.lang.String r11, java.lang.Object r12, java.lang.StringBuffer r13, java.lang.StringBuffer r14) {
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
        if (r12 == 0) goto L_0x015b;
    L_0x0002:
        r0 = r12 instanceof com.google.android.gms.internal.zzfls;
        r1 = 0;
        if (r0 == 0) goto L_0x0106;
    L_0x0007:
        r0 = r13.length();
        if (r11 == 0) goto L_0x0021;
    L_0x000d:
        r14.append(r13);
        r2 = zzub(r11);
        r14.append(r2);
        r2 = " <\n";
        r14.append(r2);
        r2 = "  ";
        r13.append(r2);
    L_0x0021:
        r2 = r12.getClass();
        r3 = r2.getFields();
        r4 = r3.length;
        r5 = 0;
    L_0x002b:
        if (r5 >= r4) goto L_0x0089;
    L_0x002d:
        r6 = r3[r5];
        r7 = r6.getModifiers();
        r8 = r6.getName();
        r9 = "cachedSize";
        r9 = r9.equals(r8);
        if (r9 != 0) goto L_0x0086;
    L_0x003f:
        r9 = r7 & 1;
        r10 = 1;
        if (r9 != r10) goto L_0x0086;
    L_0x0044:
        r7 = r7 & 8;
        r9 = 8;
        if (r7 == r9) goto L_0x0086;
    L_0x004a:
        r7 = "_";
        r9 = r8.startsWith(r7);
        if (r9 != 0) goto L_0x0086;
    L_0x0052:
        r7 = r8.endsWith(r7);
        if (r7 != 0) goto L_0x0086;
    L_0x0058:
        r7 = r6.getType();
        r6 = r6.get(r12);
        r9 = r7.isArray();
        if (r9 == 0) goto L_0x0083;
    L_0x0066:
        r7 = r7.getComponentType();
        r9 = java.lang.Byte.TYPE;
        if (r7 == r9) goto L_0x0083;
    L_0x006e:
        if (r6 != 0) goto L_0x0072;
    L_0x0070:
        r7 = 0;
        goto L_0x0076;
    L_0x0072:
        r7 = java.lang.reflect.Array.getLength(r6);
    L_0x0076:
        r9 = 0;
    L_0x0077:
        if (r9 >= r7) goto L_0x0086;
    L_0x0079:
        r10 = java.lang.reflect.Array.get(r6, r9);
        zza(r8, r10, r13, r14);
        r9 = r9 + 1;
        goto L_0x0077;
    L_0x0083:
        zza(r8, r6, r13, r14);
    L_0x0086:
        r5 = r5 + 1;
        goto L_0x002b;
    L_0x0089:
        r3 = r2.getMethods();
        r4 = r3.length;
        r5 = 0;
    L_0x008f:
        if (r5 >= r4) goto L_0x00f8;
    L_0x0091:
        r6 = r3[r5];
        r6 = r6.getName();
        r7 = "set";
        r7 = r6.startsWith(r7);
        if (r7 == 0) goto L_0x00f5;
    L_0x009f:
        r7 = 3;
        r6 = r6.substring(r7);
        r7 = "has";	 Catch:{ NoSuchMethodException -> 0x00f5 }
        r8 = java.lang.String.valueOf(r6);	 Catch:{ NoSuchMethodException -> 0x00f5 }
        r9 = r8.length();	 Catch:{ NoSuchMethodException -> 0x00f5 }
        if (r9 == 0) goto L_0x00b5;	 Catch:{ NoSuchMethodException -> 0x00f5 }
    L_0x00b0:
        r7 = r7.concat(r8);	 Catch:{ NoSuchMethodException -> 0x00f5 }
        goto L_0x00bb;	 Catch:{ NoSuchMethodException -> 0x00f5 }
    L_0x00b5:
        r8 = new java.lang.String;	 Catch:{ NoSuchMethodException -> 0x00f5 }
        r8.<init>(r7);	 Catch:{ NoSuchMethodException -> 0x00f5 }
        r7 = r8;	 Catch:{ NoSuchMethodException -> 0x00f5 }
    L_0x00bb:
        r8 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodException -> 0x00f5 }
        r7 = r2.getMethod(r7, r8);	 Catch:{ NoSuchMethodException -> 0x00f5 }
        r8 = new java.lang.Object[r1];
        r7 = r7.invoke(r12, r8);
        r7 = (java.lang.Boolean) r7;
        r7 = r7.booleanValue();
        if (r7 == 0) goto L_0x00f5;
    L_0x00cf:
        r7 = "get";	 Catch:{ NoSuchMethodException -> 0x00f5 }
        r8 = java.lang.String.valueOf(r6);	 Catch:{ NoSuchMethodException -> 0x00f5 }
        r9 = r8.length();	 Catch:{ NoSuchMethodException -> 0x00f5 }
        if (r9 == 0) goto L_0x00e0;	 Catch:{ NoSuchMethodException -> 0x00f5 }
    L_0x00db:
        r7 = r7.concat(r8);	 Catch:{ NoSuchMethodException -> 0x00f5 }
        goto L_0x00e6;	 Catch:{ NoSuchMethodException -> 0x00f5 }
    L_0x00e0:
        r8 = new java.lang.String;	 Catch:{ NoSuchMethodException -> 0x00f5 }
        r8.<init>(r7);	 Catch:{ NoSuchMethodException -> 0x00f5 }
        r7 = r8;	 Catch:{ NoSuchMethodException -> 0x00f5 }
    L_0x00e6:
        r8 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodException -> 0x00f5 }
        r7 = r2.getMethod(r7, r8);	 Catch:{ NoSuchMethodException -> 0x00f5 }
        r8 = new java.lang.Object[r1];
        r7 = r7.invoke(r12, r8);
        zza(r6, r7, r13, r14);
    L_0x00f5:
        r5 = r5 + 1;
        goto L_0x008f;
    L_0x00f8:
        if (r11 == 0) goto L_0x0105;
    L_0x00fa:
        r13.setLength(r0);
        r14.append(r13);
        r11 = ">\n";
        r14.append(r11);
    L_0x0105:
        return;
    L_0x0106:
        r11 = zzub(r11);
        r14.append(r13);
        r14.append(r11);
        r11 = ": ";
        r14.append(r11);
        r11 = r12 instanceof java.lang.String;
        if (r11 == 0) goto L_0x0149;
    L_0x0119:
        r12 = (java.lang.String) r12;
        r11 = "http";
        r11 = r12.startsWith(r11);
        if (r11 != 0) goto L_0x0139;
    L_0x0123:
        r11 = r12.length();
        r13 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r11 <= r13) goto L_0x0139;
    L_0x012b:
        r11 = r12.substring(r1, r13);
        r11 = java.lang.String.valueOf(r11);
        r12 = "[...]";
        r12 = r11.concat(r12);
    L_0x0139:
        r11 = zzha(r12);
        r12 = "\"";
        r14.append(r12);
        r14.append(r11);
        r14.append(r12);
        goto L_0x0156;
    L_0x0149:
        r11 = r12 instanceof byte[];
        if (r11 == 0) goto L_0x0153;
    L_0x014d:
        r12 = (byte[]) r12;
        zza(r12, r14);
        goto L_0x0156;
    L_0x0153:
        r14.append(r12);
    L_0x0156:
        r11 = "\n";
        r14.append(r11);
    L_0x015b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzflt.zza(java.lang.String, java.lang.Object, java.lang.StringBuffer, java.lang.StringBuffer):void");
    }

    private static void zza(byte[] bArr, StringBuffer stringBuffer) {
        if (bArr == null) {
            stringBuffer.append("\"\"");
            return;
        }
        stringBuffer.append('\"');
        for (byte b : bArr) {
            int i = b & 255;
            if (i != 92) {
                if (i != 34) {
                    if (i < 32 || i >= 127) {
                        stringBuffer.append(String.format("\\%03o", new Object[]{Integer.valueOf(i)}));
                    } else {
                        stringBuffer.append((char) i);
                    }
                }
            }
            stringBuffer.append('\\');
            stringBuffer.append((char) i);
        }
        stringBuffer.append('\"');
    }

    public static <T extends zzfls> String zzd(T t) {
        String valueOf;
        String str = "Error printing proto: ";
        if (t == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            zza(null, t, new StringBuffer(), stringBuffer);
            return stringBuffer.toString();
        } catch (IllegalAccessException e) {
            valueOf = String.valueOf(e.getMessage());
            return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
        } catch (InvocationTargetException e2) {
            valueOf = String.valueOf(e2.getMessage());
            return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
        }
    }

    private static String zzha(String str) {
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt < ' ' || charAt > '~' || charAt == '\"' || charAt == '\'') {
                stringBuilder.append(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
            } else {
                stringBuilder.append(charAt);
            }
        }
        return stringBuilder.toString();
    }

    private static String zzub(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (i != 0) {
                if (Character.isUpperCase(charAt)) {
                    stringBuffer.append('_');
                }
                stringBuffer.append(charAt);
            }
            charAt = Character.toLowerCase(charAt);
            stringBuffer.append(charAt);
        }
        return stringBuffer.toString();
    }
}
