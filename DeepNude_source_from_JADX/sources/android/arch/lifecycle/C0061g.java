package android.arch.lifecycle;

import android.arch.lifecycle.C0058d.C0056a;
import android.arch.lifecycle.C0058d.C0057b;

/* renamed from: android.arch.lifecycle.g */
/* synthetic */ class C0061g {
    /* renamed from: a */
    static final /* synthetic */ int[] f109a = new int[C0056a.values().length];
    /* renamed from: b */
    static final /* synthetic */ int[] f110b = new int[C0057b.values().length];

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
        r0 = android.arch.lifecycle.C0058d.C0057b.values();
        r0 = r0.length;
        r0 = new int[r0];
        f110b = r0;
        r0 = 1;
        r1 = f110b;	 Catch:{ NoSuchFieldError -> 0x0014 }
        r2 = android.arch.lifecycle.C0058d.C0057b.INITIALIZED;	 Catch:{ NoSuchFieldError -> 0x0014 }
        r2 = r2.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
        r1[r2] = r0;	 Catch:{ NoSuchFieldError -> 0x0014 }
    L_0x0014:
        r1 = 2;
        r2 = f110b;	 Catch:{ NoSuchFieldError -> 0x001f }
        r3 = android.arch.lifecycle.C0058d.C0057b.CREATED;	 Catch:{ NoSuchFieldError -> 0x001f }
        r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
        r2[r3] = r1;	 Catch:{ NoSuchFieldError -> 0x001f }
    L_0x001f:
        r2 = 3;
        r3 = f110b;	 Catch:{ NoSuchFieldError -> 0x002a }
        r4 = android.arch.lifecycle.C0058d.C0057b.STARTED;	 Catch:{ NoSuchFieldError -> 0x002a }
        r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
        r3[r4] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
    L_0x002a:
        r3 = 4;
        r4 = f110b;	 Catch:{ NoSuchFieldError -> 0x0035 }
        r5 = android.arch.lifecycle.C0058d.C0057b.RESUMED;	 Catch:{ NoSuchFieldError -> 0x0035 }
        r5 = r5.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
        r4[r5] = r3;	 Catch:{ NoSuchFieldError -> 0x0035 }
    L_0x0035:
        r4 = 5;
        r5 = f110b;	 Catch:{ NoSuchFieldError -> 0x0040 }
        r6 = android.arch.lifecycle.C0058d.C0057b.DESTROYED;	 Catch:{ NoSuchFieldError -> 0x0040 }
        r6 = r6.ordinal();	 Catch:{ NoSuchFieldError -> 0x0040 }
        r5[r6] = r4;	 Catch:{ NoSuchFieldError -> 0x0040 }
    L_0x0040:
        r5 = android.arch.lifecycle.C0058d.C0056a.values();
        r5 = r5.length;
        r5 = new int[r5];
        f109a = r5;
        r5 = f109a;	 Catch:{ NoSuchFieldError -> 0x0053 }
        r6 = android.arch.lifecycle.C0058d.C0056a.ON_CREATE;	 Catch:{ NoSuchFieldError -> 0x0053 }
        r6 = r6.ordinal();	 Catch:{ NoSuchFieldError -> 0x0053 }
        r5[r6] = r0;	 Catch:{ NoSuchFieldError -> 0x0053 }
    L_0x0053:
        r0 = f109a;	 Catch:{ NoSuchFieldError -> 0x005d }
        r5 = android.arch.lifecycle.C0058d.C0056a.ON_STOP;	 Catch:{ NoSuchFieldError -> 0x005d }
        r5 = r5.ordinal();	 Catch:{ NoSuchFieldError -> 0x005d }
        r0[r5] = r1;	 Catch:{ NoSuchFieldError -> 0x005d }
    L_0x005d:
        r0 = f109a;	 Catch:{ NoSuchFieldError -> 0x0067 }
        r1 = android.arch.lifecycle.C0058d.C0056a.ON_START;	 Catch:{ NoSuchFieldError -> 0x0067 }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0067 }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0067 }
    L_0x0067:
        r0 = f109a;	 Catch:{ NoSuchFieldError -> 0x0071 }
        r1 = android.arch.lifecycle.C0058d.C0056a.ON_PAUSE;	 Catch:{ NoSuchFieldError -> 0x0071 }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0071 }
        r0[r1] = r3;	 Catch:{ NoSuchFieldError -> 0x0071 }
    L_0x0071:
        r0 = f109a;	 Catch:{ NoSuchFieldError -> 0x007b }
        r1 = android.arch.lifecycle.C0058d.C0056a.ON_RESUME;	 Catch:{ NoSuchFieldError -> 0x007b }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x007b }
        r0[r1] = r4;	 Catch:{ NoSuchFieldError -> 0x007b }
    L_0x007b:
        r0 = f109a;	 Catch:{ NoSuchFieldError -> 0x0086 }
        r1 = android.arch.lifecycle.C0058d.C0056a.ON_DESTROY;	 Catch:{ NoSuchFieldError -> 0x0086 }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0086 }
        r2 = 6;	 Catch:{ NoSuchFieldError -> 0x0086 }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0086 }
    L_0x0086:
        r0 = f109a;	 Catch:{ NoSuchFieldError -> 0x0091 }
        r1 = android.arch.lifecycle.C0058d.C0056a.ON_ANY;	 Catch:{ NoSuchFieldError -> 0x0091 }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0091 }
        r2 = 7;	 Catch:{ NoSuchFieldError -> 0x0091 }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0091 }
    L_0x0091:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.arch.lifecycle.g.<clinit>():void");
    }
}
