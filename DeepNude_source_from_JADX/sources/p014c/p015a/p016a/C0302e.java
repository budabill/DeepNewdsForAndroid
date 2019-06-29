package p014c.p015a.p016a;

/* renamed from: c.a.a.e */
/* synthetic */ class C0302e {
    /* renamed from: a */
    static final /* synthetic */ int[] f301a = new int[C0278a.values().length];

    static {
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
        r0 = p014c.p015a.p016a.C0278a.values();
        r0 = r0.length;
        r0 = new int[r0];
        f301a = r0;
        r0 = f301a;	 Catch:{ NoSuchFieldError -> 0x0014 }
        r1 = p014c.p015a.p016a.C0278a.EAN_8;	 Catch:{ NoSuchFieldError -> 0x0014 }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
        r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
    L_0x0014:
        r0 = f301a;	 Catch:{ NoSuchFieldError -> 0x001f }
        r1 = p014c.p015a.p016a.C0278a.UPC_E;	 Catch:{ NoSuchFieldError -> 0x001f }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
        r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
    L_0x001f:
        r0 = f301a;	 Catch:{ NoSuchFieldError -> 0x002a }
        r1 = p014c.p015a.p016a.C0278a.EAN_13;	 Catch:{ NoSuchFieldError -> 0x002a }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
        r2 = 3;	 Catch:{ NoSuchFieldError -> 0x002a }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
    L_0x002a:
        r0 = f301a;	 Catch:{ NoSuchFieldError -> 0x0035 }
        r1 = p014c.p015a.p016a.C0278a.UPC_A;	 Catch:{ NoSuchFieldError -> 0x0035 }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
        r2 = 4;	 Catch:{ NoSuchFieldError -> 0x0035 }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0035 }
    L_0x0035:
        r0 = f301a;	 Catch:{ NoSuchFieldError -> 0x0040 }
        r1 = p014c.p015a.p016a.C0278a.QR_CODE;	 Catch:{ NoSuchFieldError -> 0x0040 }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0040 }
        r2 = 5;	 Catch:{ NoSuchFieldError -> 0x0040 }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0040 }
    L_0x0040:
        r0 = f301a;	 Catch:{ NoSuchFieldError -> 0x004b }
        r1 = p014c.p015a.p016a.C0278a.CODE_39;	 Catch:{ NoSuchFieldError -> 0x004b }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x004b }
        r2 = 6;	 Catch:{ NoSuchFieldError -> 0x004b }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x004b }
    L_0x004b:
        r0 = f301a;	 Catch:{ NoSuchFieldError -> 0x0056 }
        r1 = p014c.p015a.p016a.C0278a.CODE_93;	 Catch:{ NoSuchFieldError -> 0x0056 }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0056 }
        r2 = 7;	 Catch:{ NoSuchFieldError -> 0x0056 }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0056 }
    L_0x0056:
        r0 = f301a;	 Catch:{ NoSuchFieldError -> 0x0062 }
        r1 = p014c.p015a.p016a.C0278a.CODE_128;	 Catch:{ NoSuchFieldError -> 0x0062 }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0062 }
        r2 = 8;	 Catch:{ NoSuchFieldError -> 0x0062 }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0062 }
    L_0x0062:
        r0 = f301a;	 Catch:{ NoSuchFieldError -> 0x006e }
        r1 = p014c.p015a.p016a.C0278a.ITF;	 Catch:{ NoSuchFieldError -> 0x006e }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x006e }
        r2 = 9;	 Catch:{ NoSuchFieldError -> 0x006e }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x006e }
    L_0x006e:
        r0 = f301a;	 Catch:{ NoSuchFieldError -> 0x007a }
        r1 = p014c.p015a.p016a.C0278a.PDF_417;	 Catch:{ NoSuchFieldError -> 0x007a }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x007a }
        r2 = 10;	 Catch:{ NoSuchFieldError -> 0x007a }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x007a }
    L_0x007a:
        r0 = f301a;	 Catch:{ NoSuchFieldError -> 0x0086 }
        r1 = p014c.p015a.p016a.C0278a.CODABAR;	 Catch:{ NoSuchFieldError -> 0x0086 }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0086 }
        r2 = 11;	 Catch:{ NoSuchFieldError -> 0x0086 }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0086 }
    L_0x0086:
        r0 = f301a;	 Catch:{ NoSuchFieldError -> 0x0092 }
        r1 = p014c.p015a.p016a.C0278a.DATA_MATRIX;	 Catch:{ NoSuchFieldError -> 0x0092 }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0092 }
        r2 = 12;	 Catch:{ NoSuchFieldError -> 0x0092 }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0092 }
    L_0x0092:
        r0 = f301a;	 Catch:{ NoSuchFieldError -> 0x009e }
        r1 = p014c.p015a.p016a.C0278a.AZTEC;	 Catch:{ NoSuchFieldError -> 0x009e }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x009e }
        r2 = 13;	 Catch:{ NoSuchFieldError -> 0x009e }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x009e }
    L_0x009e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: c.a.a.e.<clinit>():void");
    }
}
