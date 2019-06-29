package p014c.p015a.p016a.p023d;

import java.util.Map;
import p014c.p015a.p016a.C0278a;
import p014c.p015a.p016a.C0293c;
import p014c.p015a.p016a.p019b.C0283b;

/* renamed from: c.a.a.d.j */
public final class C0921j extends C0915r {
    /* renamed from: a */
    public C0283b mo941a(String str, C0278a c0278a, int i, int i2, Map<C0293c, ?> map) {
        if (c0278a == C0278a.EAN_13) {
            return super.mo941a(str, c0278a, i, i2, map);
        }
        StringBuilder stringBuilder = new StringBuilder("Can only encode EAN_13, but got ");
        stringBuilder.append(c0278a);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public boolean[] mo1603a(java.lang.String r10) {
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
        r9 = this;
        r0 = r10.length();
        r1 = 13;
        if (r0 != r1) goto L_0x0080;
    L_0x0008:
        r0 = p014c.p015a.p016a.p023d.C0914q.m2450a(r10);	 Catch:{ d -> 0x0078 }
        if (r0 == 0) goto L_0x0070;
    L_0x000e:
        r0 = 0;
        r1 = 1;
        r2 = r10.substring(r0, r1);
        r2 = java.lang.Integer.parseInt(r2);
        r3 = p014c.p015a.p016a.p023d.C0920i.f1980f;
        r2 = r3[r2];
        r3 = 95;
        r3 = new boolean[r3];
        r4 = p014c.p015a.p016a.p023d.C0914q.f1952a;
        r4 = p014c.p015a.p016a.p023d.C0809o.m2096a(r3, r0, r4, r1);
        r4 = r4 + r0;
        r5 = r4;
        r4 = 1;
    L_0x0029:
        r6 = 6;
        if (r4 > r6) goto L_0x0049;
    L_0x002c:
        r7 = r4 + 1;
        r8 = r10.substring(r4, r7);
        r8 = java.lang.Integer.parseInt(r8);
        r6 = r6 - r4;
        r4 = r2 >> r6;
        r4 = r4 & r1;
        if (r4 != r1) goto L_0x003e;
    L_0x003c:
        r8 = r8 + 10;
    L_0x003e:
        r4 = p014c.p015a.p016a.p023d.C0914q.f1956e;
        r4 = r4[r8];
        r4 = p014c.p015a.p016a.p023d.C0809o.m2096a(r3, r5, r4, r0);
        r5 = r5 + r4;
        r4 = r7;
        goto L_0x0029;
    L_0x0049:
        r2 = p014c.p015a.p016a.p023d.C0914q.f1953b;
        r0 = p014c.p015a.p016a.p023d.C0809o.m2096a(r3, r5, r2, r0);
        r5 = r5 + r0;
        r0 = 7;
    L_0x0051:
        r2 = 12;
        if (r0 > r2) goto L_0x006a;
    L_0x0055:
        r2 = r0 + 1;
        r0 = r10.substring(r0, r2);
        r0 = java.lang.Integer.parseInt(r0);
        r4 = p014c.p015a.p016a.p023d.C0914q.f1955d;
        r0 = r4[r0];
        r0 = p014c.p015a.p016a.p023d.C0809o.m2096a(r3, r5, r0, r1);
        r5 = r5 + r0;
        r0 = r2;
        goto L_0x0051;
    L_0x006a:
        r10 = p014c.p015a.p016a.p023d.C0914q.f1952a;
        p014c.p015a.p016a.p023d.C0809o.m2096a(r3, r5, r10, r1);
        return r3;
    L_0x0070:
        r10 = new java.lang.IllegalArgumentException;	 Catch:{ d -> 0x0078 }
        r0 = "Contents do not pass checksum";	 Catch:{ d -> 0x0078 }
        r10.<init>(r0);	 Catch:{ d -> 0x0078 }
        throw r10;	 Catch:{ d -> 0x0078 }
    L_0x0078:
        r10 = new java.lang.IllegalArgumentException;
        r0 = "Illegal contents";
        r10.<init>(r0);
        throw r10;
    L_0x0080:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r2 = "Requested contents should be 13 digits long, but got ";
        r1.<init>(r2);
        r10 = r10.length();
        r1.append(r10);
        r10 = r1.toString();
        r0.<init>(r10);
        goto L_0x0099;
    L_0x0098:
        throw r0;
    L_0x0099:
        goto L_0x0098;
        */
        throw new UnsupportedOperationException("Method not decompiled: c.a.a.d.j.a(java.lang.String):boolean[]");
    }
}
