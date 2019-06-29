package p014c.p015a.p016a.p026f.p028b;

/* renamed from: c.a.a.f.b.e */
final class C0312e {
    /* renamed from: a */
    static int m369a(C0309b c0309b) {
        return C0312e.m370a(c0309b, true) + C0312e.m370a(c0309b, false);
    }

    /* renamed from: a */
    private static int m370a(C0309b c0309b, boolean z) {
        int b = z ? c0309b.m345b() : c0309b.m346c();
        int c = z ? c0309b.m346c() : c0309b.m345b();
        byte[][] a = c0309b.m344a();
        int i = 0;
        int i2 = 0;
        while (i < b) {
            int i3 = i2;
            i2 = 0;
            int i4 = 0;
            byte b2 = (byte) -1;
            while (i2 < c) {
                byte b3 = z ? a[i][i2] : a[i2][i];
                if (b3 == b2) {
                    i4++;
                } else {
                    if (i4 >= 5) {
                        i3 += (i4 - 5) + 3;
                    }
                    i4 = 1;
                    b2 = b3;
                }
                i2++;
            }
            if (i4 >= 5) {
                i3 += (i4 - 5) + 3;
            }
            i2 = i3;
            i++;
        }
        return i2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static boolean m371a(int r1, int r2, int r3) {
        /*
        r0 = 1;
        switch(r1) {
            case 0: goto L_0x003e;
            case 1: goto L_0x003f;
            case 2: goto L_0x003b;
            case 3: goto L_0x0037;
            case 4: goto L_0x0032;
            case 5: goto L_0x002a;
            case 6: goto L_0x0021;
            case 7: goto L_0x0018;
            default: goto L_0x0004;
        };
    L_0x0004:
        r2 = new java.lang.IllegalArgumentException;
        r3 = new java.lang.StringBuilder;
        r0 = "Invalid mask pattern: ";
        r3.<init>(r0);
        r3.append(r1);
        r1 = r3.toString();
        r2.<init>(r1);
        throw r2;
    L_0x0018:
        r1 = r3 * r2;
        r1 = r1 % 3;
        r3 = r3 + r2;
        r2 = r3 & 1;
        r1 = r1 + r2;
        goto L_0x0028;
    L_0x0021:
        r3 = r3 * r2;
        r1 = r3 & 1;
        r3 = r3 % 3;
        r1 = r1 + r3;
    L_0x0028:
        r1 = r1 & r0;
        goto L_0x0041;
    L_0x002a:
        r3 = r3 * r2;
        r1 = r3 & 1;
        r3 = r3 % 3;
        r1 = r1 + r3;
        goto L_0x0041;
    L_0x0032:
        r3 = r3 / 2;
        r2 = r2 / 3;
        goto L_0x003e;
    L_0x0037:
        r3 = r3 + r2;
        r1 = r3 % 3;
        goto L_0x0041;
    L_0x003b:
        r1 = r2 % 3;
        goto L_0x0041;
    L_0x003e:
        r3 = r3 + r2;
    L_0x003f:
        r1 = r3 & 1;
    L_0x0041:
        if (r1 != 0) goto L_0x0044;
    L_0x0043:
        return r0;
    L_0x0044:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: c.a.a.f.b.e.a(int, int, int):boolean");
    }

    /* renamed from: a */
    private static boolean m372a(byte[] bArr, int i, int i2) {
        i2 = Math.min(i2, bArr.length);
        for (i = Math.max(i, 0); i < i2; i++) {
            if (bArr[i] == (byte) 1) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m373a(byte[][] bArr, int i, int i2, int i3) {
        i3 = Math.min(i3, bArr.length);
        for (i2 = Math.max(i2, 0); i2 < i3; i2++) {
            if (bArr[i2][i] == (byte) 1) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    static int m374b(C0309b c0309b) {
        byte[][] a = c0309b.m344a();
        int c = c0309b.m346c();
        int b = c0309b.m345b();
        int i = 0;
        int i2 = 0;
        while (i < b - 1) {
            int i3 = i2;
            i2 = 0;
            while (i2 < c - 1) {
                byte b2 = a[i][i2];
                int i4 = i2 + 1;
                if (b2 == a[i][i4]) {
                    int i5 = i + 1;
                    if (b2 == a[i5][i2] && b2 == a[i5][i4]) {
                        i3++;
                    }
                }
                i2 = i4;
            }
            i++;
            i2 = i3;
        }
        return i2 * 3;
    }

    /* renamed from: c */
    static int m375c(C0309b c0309b) {
        byte[][] a = c0309b.m344a();
        int c = c0309b.m346c();
        int b = c0309b.m345b();
        int i = 0;
        int i2 = 0;
        while (i < b) {
            int i3 = i2;
            i2 = 0;
            while (i2 < c) {
                byte[] bArr = a[i];
                int i4 = i2 + 6;
                if (i4 < c && bArr[i2] == (byte) 1 && bArr[i2 + 1] == (byte) 0 && bArr[i2 + 2] == (byte) 1 && bArr[i2 + 3] == (byte) 1 && bArr[i2 + 4] == (byte) 1 && bArr[i2 + 5] == (byte) 0 && bArr[i4] == (byte) 1 && (C0312e.m372a(bArr, i2 - 4, i2) || C0312e.m372a(bArr, i2 + 7, i2 + 11))) {
                    i3++;
                }
                int i5 = i + 6;
                if (i5 < b && a[i][i2] == (byte) 1 && a[i + 1][i2] == (byte) 0 && a[i + 2][i2] == (byte) 1 && a[i + 3][i2] == (byte) 1 && a[i + 4][i2] == (byte) 1 && a[i + 5][i2] == (byte) 0 && a[i5][i2] == (byte) 1 && (C0312e.m373a(a, i2, i - 4, i) || C0312e.m373a(a, i2, i + 7, i + 11))) {
                    i3++;
                }
                i2++;
            }
            i++;
            i2 = i3;
        }
        return i2 * 40;
    }

    /* renamed from: d */
    static int m376d(C0309b c0309b) {
        byte[][] a = c0309b.m344a();
        int c = c0309b.m346c();
        int b = c0309b.m345b();
        int i = 0;
        int i2 = 0;
        while (i < b) {
            byte[] bArr = a[i];
            int i3 = i2;
            for (i2 = 0; i2 < c; i2++) {
                if (bArr[i2] == (byte) 1) {
                    i3++;
                }
            }
            i++;
            i2 = i3;
        }
        int b2 = c0309b.m345b() * c0309b.m346c();
        return ((Math.abs((i2 << 1) - b2) * 10) / b2) * 10;
    }
}
