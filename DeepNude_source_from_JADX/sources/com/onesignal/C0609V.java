package com.onesignal;

import org.json.JSONObject;

/* renamed from: com.onesignal.V */
public class C0609V implements Cloneable {
    /* renamed from: a */
    C0608U<Object, C0609V> f1215a = new C0608U("changed", false);
    /* renamed from: b */
    private boolean f1216b;

    C0609V(boolean z) {
        if (z) {
            this.f1216b = za.m1773a(za.f1415a, "ONESIGNAL_ACCEPTED_NOTIFICATION_LAST", false);
        } else {
            m1419c();
        }
    }

    /* renamed from: a */
    private void m1416a(boolean z) {
        Object obj = this.f1216b != z ? 1 : null;
        this.f1216b = z;
        if (obj != null) {
            this.f1215a.m1414c(this);
        }
    }

    /* renamed from: a */
    public boolean m1417a() {
        return this.f1216b;
    }

    /* renamed from: b */
    void m1418b() {
        za.m1778b(za.f1415a, "ONESIGNAL_ACCEPTED_NOTIFICATION_LAST", this.f1216b);
    }

    /* renamed from: c */
    void m1419c() {
        m1416a(aa.m1447a(sa.f1380f));
    }

    protected java.lang.Object clone() {
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
        r1 = this;
        r0 = super.clone();	 Catch:{ Throwable -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.V.clone():java.lang.Object");
    }

    /* renamed from: d */
    public JSONObject m1420d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("enabled", this.f1216b);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return m1420d().toString();
    }
}
