package com.onesignal;

import android.content.Context;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.PurchasingService;
import com.onesignal.sa.C0650i;
import java.lang.reflect.Field;

class Wa {
    /* renamed from: a */
    private Context f1222a;
    /* renamed from: b */
    private boolean f1223b = false;
    /* renamed from: c */
    private C0611a f1224c;
    /* renamed from: d */
    private Object f1225d;
    /* renamed from: e */
    private Field f1226e;

    /* renamed from: com.onesignal.Wa$a */
    private class C0611a implements PurchasingListener {
        /* renamed from: a */
        PurchasingListener f1220a;
        /* renamed from: b */
        final /* synthetic */ Wa f1221b;

        private C0611a(Wa wa) {
            this.f1221b = wa;
        }
    }

    Wa(Context context) {
        this.f1222a = context;
        try {
            Class cls = Class.forName("com.amazon.device.iap.internal.d");
            this.f1225d = cls.getMethod("d", new Class[0]).invoke(null, new Object[0]);
            this.f1226e = cls.getDeclaredField("f");
            this.f1226e.setAccessible(true);
            this.f1224c = new C0611a();
            this.f1224c.f1220a = (PurchasingListener) this.f1226e.get(this.f1225d);
            this.f1223b = true;
            m1422b();
        } catch (Throwable th) {
            sa.m1657a(C0650i.ERROR, "Error adding Amazon IAP listener.", th);
        }
    }

    /* renamed from: b */
    private void m1422b() {
        PurchasingService.registerListener(this.f1222a, this.f1224c);
    }

    /* renamed from: a */
    void m1423a() {
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
        r2 = this;
        r0 = r2.f1223b;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = r2.f1226e;	 Catch:{ Throwable -> 0x001a }
        r1 = r2.f1225d;	 Catch:{ Throwable -> 0x001a }
        r0 = r0.get(r1);	 Catch:{ Throwable -> 0x001a }
        r0 = (com.amazon.device.iap.PurchasingListener) r0;	 Catch:{ Throwable -> 0x001a }
        r1 = r2.f1224c;	 Catch:{ Throwable -> 0x001a }
        if (r0 == r1) goto L_0x001a;	 Catch:{ Throwable -> 0x001a }
    L_0x0013:
        r1 = r2.f1224c;	 Catch:{ Throwable -> 0x001a }
        r1.f1220a = r0;	 Catch:{ Throwable -> 0x001a }
        r2.m1422b();	 Catch:{ Throwable -> 0x001a }
    L_0x001a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.Wa.a():void");
    }
}
