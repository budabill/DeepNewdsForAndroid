package p014c.p015a.p016a.p023d;

/* renamed from: c.a.a.d.b */
public final class C0905b extends C0809o {
    /* renamed from: a */
    private static final char[] f1936a = new char[]{'A', 'B', 'C', 'D'};
    /* renamed from: b */
    private static final char[] f1937b = new char[]{'T', 'N', '*', 'E'};
    /* renamed from: c */
    private static final char[] f1938c = new char[]{'/', ':', '+', '.'};
    /* renamed from: d */
    private static final char f1939d = f1936a[0];

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public boolean[] mo1603a(java.lang.String r11) {
        /*
        r10 = this;
        r0 = r11.length();
        r1 = 0;
        r2 = 1;
        r3 = 2;
        if (r0 >= r3) goto L_0x0020;
    L_0x0009:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
    L_0x000e:
        r3 = f1939d;
        r0.append(r3);
        r0.append(r11);
        r11 = f1939d;
        r0.append(r11);
        r11 = r0.toString();
        goto L_0x0087;
    L_0x0020:
        r0 = r11.charAt(r1);
        r0 = java.lang.Character.toUpperCase(r0);
        r3 = r11.length();
        r3 = r3 - r2;
        r3 = r11.charAt(r3);
        r3 = java.lang.Character.toUpperCase(r3);
        r4 = f1936a;
        r4 = p014c.p015a.p016a.p023d.C0904a.m2434a(r4, r0);
        r5 = f1936a;
        r5 = p014c.p015a.p016a.p023d.C0904a.m2434a(r5, r3);
        r6 = f1937b;
        r0 = p014c.p015a.p016a.p023d.C0904a.m2434a(r6, r0);
        r6 = f1937b;
        r3 = p014c.p015a.p016a.p023d.C0904a.m2434a(r6, r3);
        r6 = "Invalid start/end guards: ";
        if (r4 == 0) goto L_0x0066;
    L_0x0051:
        if (r5 == 0) goto L_0x0054;
    L_0x0053:
        goto L_0x0087;
    L_0x0054:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>(r6);
        r1.append(r11);
        r11 = r1.toString();
        r0.<init>(r11);
        throw r0;
    L_0x0066:
        if (r0 == 0) goto L_0x007d;
    L_0x0068:
        if (r3 == 0) goto L_0x006b;
    L_0x006a:
        goto L_0x0087;
    L_0x006b:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>(r6);
        r1.append(r11);
        r11 = r1.toString();
        r0.<init>(r11);
        throw r0;
    L_0x007d:
        if (r5 != 0) goto L_0x015c;
    L_0x007f:
        if (r3 != 0) goto L_0x015c;
    L_0x0081:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        goto L_0x000e;
    L_0x0087:
        r0 = 20;
        r0 = 1;
        r3 = 20;
    L_0x008c:
        r4 = r11.length();
        r4 = r4 - r2;
        if (r0 >= r4) goto L_0x00df;
    L_0x0093:
        r4 = r11.charAt(r0);
        r4 = java.lang.Character.isDigit(r4);
        if (r4 != 0) goto L_0x00da;
    L_0x009d:
        r4 = r11.charAt(r0);
        r5 = 45;
        if (r4 == r5) goto L_0x00da;
    L_0x00a5:
        r4 = r11.charAt(r0);
        r5 = 36;
        if (r4 != r5) goto L_0x00ae;
    L_0x00ad:
        goto L_0x00da;
    L_0x00ae:
        r4 = f1938c;
        r5 = r11.charAt(r0);
        r4 = p014c.p015a.p016a.p023d.C0904a.m2434a(r4, r5);
        if (r4 == 0) goto L_0x00bd;
    L_0x00ba:
        r3 = r3 + 10;
        goto L_0x00dc;
    L_0x00bd:
        r1 = new java.lang.IllegalArgumentException;
        r2 = new java.lang.StringBuilder;
        r3 = "Cannot encode : '";
        r2.<init>(r3);
        r11 = r11.charAt(r0);
        r2.append(r11);
        r11 = 39;
        r2.append(r11);
        r11 = r2.toString();
        r1.<init>(r11);
        throw r1;
    L_0x00da:
        r3 = r3 + 9;
    L_0x00dc:
        r0 = r0 + 1;
        goto L_0x008c;
    L_0x00df:
        r0 = r11.length();
        r0 = r0 - r2;
        r3 = r3 + r0;
        r0 = new boolean[r3];
        r3 = 0;
        r4 = 0;
    L_0x00e9:
        r5 = r11.length();
        if (r3 >= r5) goto L_0x015b;
    L_0x00ef:
        r5 = r11.charAt(r3);
        r5 = java.lang.Character.toUpperCase(r5);
        if (r3 == 0) goto L_0x0100;
    L_0x00f9:
        r6 = r11.length();
        r6 = r6 - r2;
        if (r3 != r6) goto L_0x011c;
    L_0x0100:
        r6 = 42;
        if (r5 == r6) goto L_0x011a;
    L_0x0104:
        r6 = 69;
        if (r5 == r6) goto L_0x0117;
    L_0x0108:
        r6 = 78;
        if (r5 == r6) goto L_0x0114;
    L_0x010c:
        r6 = 84;
        if (r5 == r6) goto L_0x0111;
    L_0x0110:
        goto L_0x011c;
    L_0x0111:
        r5 = 65;
        goto L_0x011c;
    L_0x0114:
        r5 = 66;
        goto L_0x011c;
    L_0x0117:
        r5 = 68;
        goto L_0x011c;
    L_0x011a:
        r5 = 67;
    L_0x011c:
        r6 = 0;
    L_0x011d:
        r7 = p014c.p015a.p016a.p023d.C0904a.f1933a;
        r8 = r7.length;
        if (r6 >= r8) goto L_0x012e;
    L_0x0122:
        r7 = r7[r6];
        if (r5 != r7) goto L_0x012b;
    L_0x0126:
        r5 = p014c.p015a.p016a.p023d.C0904a.f1934b;
        r5 = r5[r6];
        goto L_0x012f;
    L_0x012b:
        r6 = r6 + 1;
        goto L_0x011d;
    L_0x012e:
        r5 = 0;
    L_0x012f:
        r6 = r4;
        r4 = 0;
        r7 = 1;
    L_0x0132:
        r8 = 0;
    L_0x0133:
        r9 = 7;
        if (r4 >= r9) goto L_0x014c;
    L_0x0136:
        r0[r6] = r7;
        r6 = r6 + 1;
        r9 = 6 - r4;
        r9 = r5 >> r9;
        r9 = r9 & r2;
        if (r9 == 0) goto L_0x0147;
    L_0x0141:
        if (r8 != r2) goto L_0x0144;
    L_0x0143:
        goto L_0x0147;
    L_0x0144:
        r8 = r8 + 1;
        goto L_0x0133;
    L_0x0147:
        r7 = r7 ^ 1;
        r4 = r4 + 1;
        goto L_0x0132;
    L_0x014c:
        r4 = r11.length();
        r4 = r4 - r2;
        if (r3 >= r4) goto L_0x0157;
    L_0x0153:
        r0[r6] = r1;
        r6 = r6 + 1;
    L_0x0157:
        r4 = r6;
        r3 = r3 + 1;
        goto L_0x00e9;
    L_0x015b:
        return r0;
    L_0x015c:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>(r6);
        r1.append(r11);
        r11 = r1.toString();
        r0.<init>(r11);
        goto L_0x016f;
    L_0x016e:
        throw r0;
    L_0x016f:
        goto L_0x016e;
        */
        throw new UnsupportedOperationException("Method not decompiled: c.a.a.d.b.a(java.lang.String):boolean[]");
    }
}
