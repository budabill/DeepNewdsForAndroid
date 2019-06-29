package com.onesignal;

import org.json.JSONObject;

/* renamed from: com.onesignal.N */
public class C0598N implements Cloneable {
    /* renamed from: a */
    C0608U<Object, C0598N> f1150a = new C0608U("changed", false);
    /* renamed from: b */
    private String f1151b;
    /* renamed from: c */
    private String f1152c;

    C0598N(boolean z) {
        String a;
        if (z) {
            this.f1151b = za.m1770a(za.f1415a, "PREFS_ONESIGNAL_EMAIL_ID_LAST", null);
            a = za.m1770a(za.f1415a, "PREFS_ONESIGNAL_EMAIL_ADDRESS_LAST", null);
        } else {
            this.f1151b = sa.m1736s();
            a = Ha.m1335a().m1557b();
        }
        this.f1152c = a;
    }

    /* renamed from: a */
    void m1395a(String str) {
        int equals = str.equals(this.f1151b) ^ 1;
        this.f1151b = str;
        if (equals != 0) {
            this.f1150a.m1414c(this);
        }
    }

    /* renamed from: a */
    public boolean m1396a() {
        return (this.f1151b == null || this.f1152c == null) ? false : true;
    }

    /* renamed from: b */
    public JSONObject m1397b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("emailUserId", this.f1151b != null ? this.f1151b : JSONObject.NULL);
            jSONObject.put("emailAddress", this.f1152c != null ? this.f1152c : JSONObject.NULL);
            jSONObject.put("subscribed", m1396a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
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
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.N.clone():java.lang.Object");
    }

    public String toString() {
        return m1397b().toString();
    }
}
