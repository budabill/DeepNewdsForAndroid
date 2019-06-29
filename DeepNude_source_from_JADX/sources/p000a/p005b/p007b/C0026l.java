package p000a.p005b.p007b;

import android.content.ComponentName;
import android.os.IBinder;

/* renamed from: a.b.b.l */
public final class C0026l {
    /* renamed from: a */
    private final Object f33a = new Object();
    /* renamed from: b */
    private final C0028n f34b;
    /* renamed from: c */
    private final C0027m f35c;
    /* renamed from: d */
    private final ComponentName f36d;

    C0026l(C0028n c0028n, C0027m c0027m, ComponentName componentName) {
        this.f34b = c0028n;
        this.f35c = c0027m;
        this.f36d = componentName;
    }

    /* renamed from: a */
    IBinder m22a() {
        return this.f35c.asBinder();
    }

    /* renamed from: a */
    public boolean m23a(android.net.Uri r3, android.os.Bundle r4, java.util.List<android.os.Bundle> r5) {
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
        r2 = this;
        r0 = r2.f34b;	 Catch:{ RemoteException -> 0x0009 }
        r1 = r2.f35c;	 Catch:{ RemoteException -> 0x0009 }
        r3 = r0.mo10a(r1, r3, r4, r5);	 Catch:{ RemoteException -> 0x0009 }
        return r3;
    L_0x0009:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.b.l.a(android.net.Uri, android.os.Bundle, java.util.List):boolean");
    }

    /* renamed from: b */
    ComponentName m24b() {
        return this.f36d;
    }
}
