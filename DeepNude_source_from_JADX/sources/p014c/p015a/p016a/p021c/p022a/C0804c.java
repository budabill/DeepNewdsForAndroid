package p014c.p015a.p016a.p021c.p022a;

/* renamed from: c.a.a.c.a.c */
class C0804c implements C0287g {
    C0804c() {
    }

    /* renamed from: a */
    private int m2079a(C0288h c0288h, StringBuilder stringBuilder, StringBuilder stringBuilder2, int i) {
        int length = stringBuilder.length();
        stringBuilder.delete(length - i, length);
        c0288h.f232f--;
        int a = mo1601a(c0288h.m246c(), stringBuilder2);
        c0288h.m254j();
        return a;
    }

    /* renamed from: a */
    private static String m2080a(CharSequence charSequence, int i) {
        char charAt = (char) (((((charSequence.charAt(i) * 1600) + (charSequence.charAt(i + 1) * 40)) + charSequence.charAt(i + 2)) + 1) % 256);
        return new String(new char[]{(char) (r0 / 256), charAt});
    }

    /* renamed from: b */
    static void m2081b(C0288h c0288h, StringBuilder stringBuilder) {
        c0288h.m243a(C0804c.m2080a((CharSequence) stringBuilder, 0));
        stringBuilder.delete(0, 3);
    }

    /* renamed from: a */
    public int mo1600a() {
        return 1;
    }

    /* renamed from: a */
    int mo1601a(char c, StringBuilder stringBuilder) {
        if (c == ' ') {
            c = '\u0003';
        } else {
            int i;
            if (c >= '0' && c <= '9') {
                i = (c - 48) + 4;
            } else if (c < 'A' || c > 'Z') {
                if (c < '\u0000' || c > '\u001f') {
                    if (c >= '!' && c <= '/') {
                        stringBuilder.append('\u0001');
                        i = c - 33;
                    } else if (c >= ':' && c <= '@') {
                        stringBuilder.append('\u0001');
                        i = (c - 58) + 15;
                    } else if (c >= '[' && c <= '_') {
                        stringBuilder.append('\u0001');
                        i = (c - 91) + 22;
                    } else if (c >= '`' && c <= '') {
                        stringBuilder.append('\u0002');
                        i = c - 96;
                    } else if (c >= '') {
                        stringBuilder.append("\u0001\u001e");
                        return mo1601a((char) (c - 128), stringBuilder) + 2;
                    } else {
                        StringBuilder stringBuilder2 = new StringBuilder("Illegal character: ");
                        stringBuilder2.append(c);
                        throw new IllegalArgumentException(stringBuilder2.toString());
                    }
                    c = (char) i;
                } else {
                    stringBuilder.append('\u0000');
                }
                stringBuilder.append(c);
                return 2;
            } else {
                i = (c - 65) + 14;
            }
            c = (char) i;
        }
        stringBuilder.append(c);
        return 1;
    }

    /* renamed from: a */
    public void mo942a(p014c.p015a.p016a.p021c.p022a.C0288h r9) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
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
        r8 = this;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
    L_0x0005:
        r1 = r9.m252h();
        if (r1 == 0) goto L_0x0078;
    L_0x000b:
        r1 = r9.m246c();
        r2 = r9.f232f;
        r3 = 1;
        r2 = r2 + r3;
        r9.f232f = r2;
        r1 = r8.mo1601a(r1, r0);
        r2 = r0.length();
        r4 = 3;
        r2 = r2 / r4;
        r2 = r2 << r3;
        r5 = r9.m238a();
        r5 = r5 + r2;
        r9.m247c(r5);
        r2 = r9.m251g();
        r2 = r2.m277a();
        r2 = r2 - r5;
        r5 = r9.m252h();
        if (r5 != 0) goto L_0x005a;
    L_0x0037:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = r0.length();
        r6 = r6 % r4;
        r7 = 2;
        if (r6 != r7) goto L_0x004c;
    L_0x0044:
        if (r2 < r7) goto L_0x0048;
    L_0x0046:
        if (r2 <= r7) goto L_0x004c;
    L_0x0048:
        r1 = r8.m2079a(r9, r0, r5, r1);
    L_0x004c:
        r6 = r0.length();
        r6 = r6 % r4;
        if (r6 != r3) goto L_0x0078;
    L_0x0053:
        if (r1 > r4) goto L_0x0057;
    L_0x0055:
        if (r2 != r3) goto L_0x0048;
    L_0x0057:
        if (r1 <= r4) goto L_0x0078;
    L_0x0059:
        goto L_0x0048;
    L_0x005a:
        r1 = r0.length();
        r1 = r1 % r4;
        if (r1 != 0) goto L_0x0005;
    L_0x0061:
        r1 = r9.m248d();
        r2 = r9.f232f;
        r3 = r8.mo1600a();
        r1 = p014c.p015a.p016a.p021c.p022a.C0290j.m261a(r1, r2, r3);
        r2 = r8.mo1600a();
        if (r1 == r2) goto L_0x0005;
    L_0x0075:
        r9.m245b(r1);
    L_0x0078:
        r8.mo1602a(r9, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: c.a.a.c.a.c.a(c.a.a.c.a.h):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    void mo1602a(p014c.p015a.p016a.p021c.p022a.C0288h r8, java.lang.StringBuilder r9) {
        /*
        r7 = this;
        r0 = r9.length();
        r1 = 3;
        r0 = r0 / r1;
        r2 = 1;
        r0 = r0 << r2;
        r3 = r9.length();
        r3 = r3 % r1;
        r4 = r8.m238a();
        r4 = r4 + r0;
        r8.m247c(r4);
        r0 = r8.m251g();
        r0 = r0.m277a();
        r0 = r0 - r4;
        r4 = 0;
        r5 = 254; // 0xfe float:3.56E-43 double:1.255E-321;
        r6 = 2;
        if (r3 != r6) goto L_0x003b;
    L_0x0024:
        r9.append(r4);
    L_0x0027:
        r0 = r9.length();
        if (r0 < r1) goto L_0x0031;
    L_0x002d:
        p014c.p015a.p016a.p021c.p022a.C0804c.m2081b(r8, r9);
        goto L_0x0027;
    L_0x0031:
        r9 = r8.m252h();
        if (r9 == 0) goto L_0x006d;
    L_0x0037:
        r8.m239a(r5);
        goto L_0x006d;
    L_0x003b:
        if (r0 != r2) goto L_0x0058;
    L_0x003d:
        if (r3 != r2) goto L_0x0058;
    L_0x003f:
        r0 = r9.length();
        if (r0 < r1) goto L_0x0049;
    L_0x0045:
        p014c.p015a.p016a.p021c.p022a.C0804c.m2081b(r8, r9);
        goto L_0x003f;
    L_0x0049:
        r9 = r8.m252h();
        if (r9 == 0) goto L_0x0052;
    L_0x004f:
        r8.m239a(r5);
    L_0x0052:
        r9 = r8.f232f;
        r9 = r9 - r2;
        r8.f232f = r9;
        goto L_0x006d;
    L_0x0058:
        if (r3 != 0) goto L_0x0071;
    L_0x005a:
        r2 = r9.length();
        if (r2 < r1) goto L_0x0064;
    L_0x0060:
        p014c.p015a.p016a.p021c.p022a.C0804c.m2081b(r8, r9);
        goto L_0x005a;
    L_0x0064:
        if (r0 > 0) goto L_0x0037;
    L_0x0066:
        r9 = r8.m252h();
        if (r9 == 0) goto L_0x006d;
    L_0x006c:
        goto L_0x0037;
    L_0x006d:
        r8.m245b(r4);
        return;
    L_0x0071:
        r8 = new java.lang.IllegalStateException;
        r9 = "Unexpected case. Please report!";
        r8.<init>(r9);
        goto L_0x007a;
    L_0x0079:
        throw r8;
    L_0x007a:
        goto L_0x0079;
        */
        throw new UnsupportedOperationException("Method not decompiled: c.a.a.c.a.c.a(c.a.a.c.a.h, java.lang.StringBuilder):void");
    }
}
