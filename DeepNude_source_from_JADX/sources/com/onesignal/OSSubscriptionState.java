package com.onesignal;

import org.json.JSONObject;

public class OSSubscriptionState implements Cloneable {
    /* renamed from: a */
    C0608U<Object, OSSubscriptionState> f1163a = new C0608U("changed", false);
    /* renamed from: b */
    private boolean f1164b;
    /* renamed from: c */
    private boolean f1165c;
    /* renamed from: d */
    private String f1166d;
    /* renamed from: e */
    private String f1167e;

    OSSubscriptionState(boolean z, boolean z2) {
        if (z) {
            this.f1165c = za.m1773a(za.f1415a, "ONESIGNAL_SUBSCRIPTION_LAST", false);
            this.f1166d = za.m1770a(za.f1415a, "ONESIGNAL_PLAYER_ID_LAST", null);
            this.f1167e = za.m1770a(za.f1415a, "ONESIGNAL_PUSH_TOKEN_LAST", null);
            this.f1164b = za.m1773a(za.f1415a, "ONESIGNAL_PERMISSION_ACCEPTED_LAST", false);
            return;
        }
        this.f1165c = Ha.m1346e();
        this.f1166d = sa.m1616A();
        this.f1167e = Ha.m1343c();
        this.f1164b = z2;
    }

    /* renamed from: a */
    private void m1401a(boolean z) {
        boolean b = m1406b();
        this.f1164b = z;
        if (b != m1406b()) {
            this.f1163a.m1414c(this);
        }
    }

    /* renamed from: a */
    public String m1402a() {
        return this.f1167e;
    }

    /* renamed from: a */
    void m1403a(String str) {
        if (str != null) {
            int equals = str.equals(this.f1167e) ^ 1;
            this.f1167e = str;
            if (equals != 0) {
                this.f1163a.m1414c(this);
            }
        }
    }

    /* renamed from: a */
    boolean m1404a(OSSubscriptionState oSSubscriptionState) {
        if (this.f1165c == oSSubscriptionState.f1165c) {
            String str = this.f1166d;
            Object obj = "";
            if (str == null) {
                str = obj;
            }
            Object obj2 = oSSubscriptionState.f1166d;
            if (obj2 == null) {
                obj2 = obj;
            }
            if (str.equals(obj2)) {
                str = this.f1167e;
                if (str == null) {
                    str = obj;
                }
                String str2 = oSSubscriptionState.f1167e;
                if (str2 != null) {
                    obj = str2;
                }
                if (str.equals(obj)) {
                    if (this.f1164b == oSSubscriptionState.f1164b) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /* renamed from: b */
    void m1405b(String str) {
        int equals = str.equals(this.f1166d) ^ 1;
        this.f1166d = str;
        if (equals != 0) {
            this.f1163a.m1414c(this);
        }
    }

    /* renamed from: b */
    public boolean m1406b() {
        return this.f1166d != null && this.f1167e != null && this.f1165c && this.f1164b;
    }

    /* renamed from: c */
    public String m1407c() {
        return this.f1166d;
    }

    void changed(C0609V c0609v) {
        m1401a(c0609v.m1417a());
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
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.OSSubscriptionState.clone():java.lang.Object");
    }

    /* renamed from: d */
    void m1408d() {
        za.m1778b(za.f1415a, "ONESIGNAL_SUBSCRIPTION_LAST", this.f1165c);
        za.m1777b(za.f1415a, "ONESIGNAL_PLAYER_ID_LAST", this.f1166d);
        za.m1777b(za.f1415a, "ONESIGNAL_PUSH_TOKEN_LAST", this.f1167e);
        za.m1778b(za.f1415a, "ONESIGNAL_PERMISSION_ACCEPTED_LAST", this.f1164b);
    }

    /* renamed from: e */
    public JSONObject m1409e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", this.f1166d != null ? this.f1166d : JSONObject.NULL);
            jSONObject.put("pushToken", this.f1167e != null ? this.f1167e : JSONObject.NULL);
            jSONObject.put("userSubscriptionSetting", this.f1165c);
            jSONObject.put("subscribed", m1406b());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return m1409e().toString();
    }
}
