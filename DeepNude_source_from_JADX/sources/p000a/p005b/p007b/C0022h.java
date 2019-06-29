package p000a.p005b.p007b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* renamed from: a.b.b.h */
public class C0022h {
    /* renamed from: a */
    private final C0028n f24a;
    /* renamed from: b */
    private final ComponentName f25b;

    C0022h(C0028n c0028n, ComponentName componentName) {
        this.f24a = c0028n;
        this.f25b = componentName;
    }

    /* renamed from: a */
    public static boolean m16a(Context context, String str, C0025k c0025k) {
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, c0025k, 33);
    }

    /* renamed from: a */
    public p000a.p005b.p007b.C0026l m17a(p000a.p005b.p007b.C0016a r4) {
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
        r3 = this;
        r0 = new a.b.b.g;
        r0.<init>(r3, r4);
        r4 = 0;
        r1 = r3.f24a;	 Catch:{ RemoteException -> 0x0018 }
        r1 = r1.mo9a(r0);	 Catch:{ RemoteException -> 0x0018 }
        if (r1 != 0) goto L_0x000f;
    L_0x000e:
        return r4;
    L_0x000f:
        r4 = new a.b.b.l;
        r1 = r3.f24a;
        r2 = r3.f25b;
        r4.<init>(r1, r0, r2);
    L_0x0018:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.b.h.a(a.b.b.a):a.b.b.l");
    }

    /* renamed from: a */
    public boolean m18a(long r2) {
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
        r1 = this;
        r0 = r1.f24a;	 Catch:{ RemoteException -> 0x0007 }
        r2 = r0.mo8a(r2);	 Catch:{ RemoteException -> 0x0007 }
        return r2;
    L_0x0007:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.b.h.a(long):boolean");
    }
}
