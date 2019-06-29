package p014c.p015a.p016a.p017a.p018a;

import p014c.p015a.p016a.p019b.C0282a;
import p014c.p015a.p016a.p019b.C0283b;
import p014c.p015a.p016a.p019b.p020a.C0279a;
import p014c.p015a.p016a.p019b.p020a.C0281c;

/* renamed from: c.a.a.a.a.c */
public final class C0273c {
    /* renamed from: a */
    private static final int[] f132a = new int[]{4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    /* renamed from: a */
    private static int m157a(int i, boolean z) {
        return ((z ? 88 : 112) + (i << 4)) * i;
    }

    /* renamed from: a */
    public static C0272a m158a(byte[] bArr, int i, int i2) {
        boolean z;
        int abs;
        int i3;
        int i4;
        int a;
        int a2;
        int i5;
        C0282a a3 = new C0275e(bArr).m172a();
        int i6 = 11;
        int a4 = ((a3.m206a() * i) / 100) + 11;
        int a5 = a3.m206a() + a4;
        int i7 = 32;
        int i8 = 0;
        int i9 = 1;
        if (i2 != 0) {
            z = i2 < 0;
            abs = Math.abs(i2);
            if (z) {
                i7 = 4;
            }
            if (abs <= i7) {
                i7 = C0273c.m157a(abs, z);
                i3 = f132a[abs];
                i4 = i7 - (i7 % i3);
                a3 = C0273c.m160a(a3, i3);
                a = a3.m206a() + a4;
                String str = "Data to large for user specified layer";
                if (a > i4) {
                    throw new IllegalArgumentException(str);
                } else if (z) {
                    if (a3.m206a() > (i3 << 6)) {
                        throw new IllegalArgumentException(str);
                    }
                }
            } else {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", new Object[]{Integer.valueOf(i2)}));
            }
        }
        C0282a c0282a = null;
        abs = 0;
        i3 = 0;
        while (abs <= 32) {
            boolean z2 = abs <= 3;
            int i10 = z2 ? abs + 1 : abs;
            a2 = C0273c.m157a(i10, z2);
            if (a5 <= a2) {
                int[] iArr = f132a;
                if (i3 != iArr[i10]) {
                    i3 = iArr[i10];
                    c0282a = C0273c.m160a(a3, i3);
                }
                i5 = a2 - (a2 % i3);
                if (!z2 || c0282a.m206a() <= (i3 << 6)) {
                    if (c0282a.m206a() + a4 <= i5) {
                        a3 = c0282a;
                        z = z2;
                        abs = i10;
                        i7 = a2;
                    }
                }
            }
            abs++;
            i8 = 0;
            i9 = 1;
        }
        throw new IllegalArgumentException("Data too large for an Aztec code");
        C0282a b = C0273c.m165b(a3, i7, i3);
        int a6 = a3.m206a() / i3;
        C0282a a7 = C0273c.m161a(z, abs, a6);
        if (!z) {
            i6 = 14;
        }
        i6 += abs << 2;
        int[] iArr2 = new int[i6];
        i4 = 2;
        if (z) {
            for (a = 0; a < iArr2.length; a++) {
                iArr2[a] = a;
            }
            a = i6;
        } else {
            i10 = i6 / 2;
            a = (i6 + 1) + (((i10 - 1) / 15) * 2);
            a2 = a / 2;
            for (i5 = 0; i5 < i10; i5++) {
                int i11 = (i5 / 15) + i5;
                iArr2[(i10 - i5) - i9] = (a2 - i11) - 1;
                iArr2[i10 + i5] = (i11 + a2) + i9;
            }
        }
        C0283b c0283b = new C0283b(a);
        a2 = 0;
        i5 = 0;
        while (a2 < abs) {
            i11 = ((abs - a2) << i4) + (z ? 9 : 12);
            int i12 = 0;
            while (i12 < i11) {
                int i13 = i12 << 1;
                for (i4 = 
/*
Method generation error in method: c.a.a.a.a.c.a(byte[], int, int):c.a.a.a.a.a, dex: classes.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r9_10 'i4' int) = (r9_9 'i4' int), (r9_22 'i4' int) binds: {(r9_9 'i4' int)=B:63:0x010f, (r9_22 'i4' int)=B:80:0x0184} in method: c.a.a.a.a.c.a(byte[], int, int):c.a.a.a.a.a, dex: classes.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:184)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:219)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:219)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:187)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:320)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:257)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:220)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:110)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:75)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:12)
	at jadx.core.ProcessClass.process(ProcessClass.java:40)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:537)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:509)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 26 more

*/

                /* renamed from: a */
                private static C0279a m159a(int i) {
                    if (i == 4) {
                        return C0279a.f167d;
                    }
                    if (i == 6) {
                        return C0279a.f166c;
                    }
                    if (i == 8) {
                        return C0279a.f170g;
                    }
                    if (i == 10) {
                        return C0279a.f165b;
                    }
                    if (i == 12) {
                        return C0279a.f164a;
                    }
                    StringBuilder stringBuilder = new StringBuilder("Unsupported word size ");
                    stringBuilder.append(i);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }

                /* renamed from: a */
                static C0282a m160a(C0282a c0282a, int i) {
                    C0282a c0282a2 = new C0282a();
                    int a = c0282a.m206a();
                    int i2 = (1 << i) - 2;
                    int i3 = 0;
                    while (i3 < a) {
                        int i4;
                        int i5 = 0;
                        for (i4 = 0; i4 < i; i4++) {
                            int i6 = i3 + i4;
                            if (i6 >= a || c0282a.m211a(i6)) {
                                i5 |= 1 << ((i - 1) - i4);
                            }
                        }
                        i4 = i5 & i2;
                        if (i4 != i2) {
                            if (i4 == 0) {
                                i4 = i5 | 1;
                            } else {
                                c0282a2.m207a(i5, i);
                                i3 += i;
                            }
                        }
                        c0282a2.m207a(i4, i);
                        i3--;
                        i3 += i;
                    }
                    return c0282a2;
                }

                /* renamed from: a */
                static C0282a m161a(boolean z, int i, int i2) {
                    int i3;
                    C0282a c0282a = new C0282a();
                    if (z) {
                        c0282a.m207a(i - 1, 2);
                        c0282a.m207a(i2 - 1, 6);
                        i3 = 28;
                    } else {
                        c0282a.m207a(i - 1, 5);
                        c0282a.m207a(i2 - 1, 11);
                        i3 = 40;
                    }
                    return C0273c.m165b(c0282a, i3, 4);
                }

                /* renamed from: a */
                private static void m162a(C0283b c0283b, int i, int i2) {
                    int i3;
                    int i4;
                    for (i3 = 0; i3 < i2; i3 += 2) {
                        i4 = i - i3;
                        int i5 = i4;
                        while (true) {
                            int i6 = i + i3;
                            if (i5 > i6) {
                                break;
                            }
                            c0283b.m220b(i5, i4);
                            c0283b.m220b(i5, i6);
                            c0283b.m220b(i4, i5);
                            c0283b.m220b(i6, i5);
                            i5++;
                        }
                    }
                    i3 = i - i2;
                    c0283b.m220b(i3, i3);
                    i4 = i3 + 1;
                    c0283b.m220b(i4, i3);
                    c0283b.m220b(i3, i4);
                    i += i2;
                    c0283b.m220b(i, i3);
                    c0283b.m220b(i, i4);
                    c0283b.m220b(i, i - 1);
                }

                /* renamed from: a */
                private static void m163a(C0283b c0283b, boolean z, int i, C0282a c0282a) {
                    i /= 2;
                    int i2 = 0;
                    int i3;
                    if (z) {
                        while (i2 < 7) {
                            i3 = (i - 3) + i2;
                            if (c0282a.m211a(i2)) {
                                c0283b.m220b(i3, i - 5);
                            }
                            if (c0282a.m211a(i2 + 7)) {
                                c0283b.m220b(i + 5, i3);
                            }
                            if (c0282a.m211a(20 - i2)) {
                                c0283b.m220b(i3, i + 5);
                            }
                            if (c0282a.m211a(27 - i2)) {
                                c0283b.m220b(i - 5, i3);
                            }
                            i2++;
                        }
                        return;
                    }
                    while (i2 < 10) {
                        i3 = ((i - 5) + i2) + (i2 / 5);
                        if (c0282a.m211a(i2)) {
                            c0283b.m220b(i3, i - 7);
                        }
                        if (c0282a.m211a(i2 + 10)) {
                            c0283b.m220b(i + 7, i3);
                        }
                        if (c0282a.m211a(29 - i2)) {
                            c0283b.m220b(i3, i + 7);
                        }
                        if (c0282a.m211a(39 - i2)) {
                            c0283b.m220b(i - 7, i3);
                        }
                        i2++;
                    }
                }

                /* renamed from: a */
                private static int[] m164a(C0282a c0282a, int i, int i2) {
                    int[] iArr = new int[i2];
                    int a = c0282a.m206a() / i;
                    for (int i3 = 0; i3 < a; i3++) {
                        int i4 = 0;
                        for (int i5 = 0; i5 < i; i5++) {
                            i4 |= c0282a.m211a((i3 * i) + i5) ? 1 << ((i - i5) - 1) : 0;
                        }
                        iArr[i3] = i4;
                    }
                    return iArr;
                }

                /* renamed from: b */
                private static C0282a m165b(C0282a c0282a, int i, int i2) {
                    int a = c0282a.m206a() / i2;
                    C0281c c0281c = new C0281c(C0273c.m159a(i2));
                    int i3 = i / i2;
                    int[] a2 = C0273c.m164a(c0282a, i2, i3);
                    c0281c.m203a(a2, i3 - a);
                    i %= i2;
                    C0282a c0282a2 = new C0282a();
                    int i4 = 0;
                    c0282a2.m207a(0, i);
                    i = a2.length;
                    while (i4 < i) {
                        c0282a2.m207a(a2[i4], i2);
                        i4++;
                    }
                    return c0282a2;
                }
            }
