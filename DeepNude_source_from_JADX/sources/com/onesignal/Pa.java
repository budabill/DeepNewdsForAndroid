package com.onesignal;

import android.content.Context;
import com.onesignal.La.C0596a;
import com.onesignal.sa.C0650i;

abstract class Pa implements La {
    /* renamed from: a */
    private static int f1828a = 5;
    /* renamed from: b */
    private static int f1829b = 10000;
    /* renamed from: c */
    private C0596a f1830c;
    /* renamed from: d */
    private Thread f1831d;
    /* renamed from: e */
    private boolean f1832e;

    Pa() {
    }

    /* renamed from: a */
    private boolean m2247a(String str, int i) {
        C0650i c0650i;
        StringBuilder stringBuilder;
        String str2 = " Token";
        try {
            str = mo1747a(str);
            C0650i c0650i2 = C0650i.INFO;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Device registered, push token = ");
            stringBuilder2.append(str);
            sa.m1656a(c0650i2, stringBuilder2.toString());
            this.f1830c.mo1392a(str, 1);
            return true;
        } catch (Throwable e) {
            if ("SERVICE_NOT_AVAILABLE".equals(e.getMessage())) {
                if (i >= f1828a - 1) {
                    c0650i = C0650i.ERROR;
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("Retry count of ");
                    stringBuilder3.append(f1828a);
                    stringBuilder3.append(" exceed! Could not get a ");
                    stringBuilder3.append(mo1748c());
                    stringBuilder3.append(" Token.");
                    sa.m1657a(c0650i, stringBuilder3.toString(), e);
                } else {
                    C0650i c0650i3 = C0650i.INFO;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("'Google Play services' returned SERVICE_NOT_AVAILABLE error. Current retry count: ");
                    stringBuilder.append(i);
                    sa.m1657a(c0650i3, stringBuilder.toString(), e);
                    if (i == 2) {
                        this.f1830c.mo1392a(null, -9);
                        this.f1832e = true;
                        return true;
                    }
                }
                return false;
            }
            c0650i = C0650i.ERROR;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Error Getting ");
            stringBuilder.append(mo1748c());
            stringBuilder.append(str2);
            sa.m1657a(c0650i, stringBuilder.toString(), e);
            if (!this.f1832e) {
                this.f1830c.mo1392a(null, -11);
            }
            return true;
        } catch (Throwable e2) {
            c0650i = C0650i.ERROR;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown error getting ");
            stringBuilder.append(mo1748c());
            stringBuilder.append(str2);
            sa.m1657a(c0650i, stringBuilder.toString(), e2);
            this.f1830c.mo1392a(null, -12);
            return true;
        }
    }

    /* renamed from: a */
    private boolean m2248a(java.lang.String r3, com.onesignal.La.C0596a r4) {
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
        r0 = 0;
        r1 = 1;
        java.lang.Float.parseFloat(r3);	 Catch:{ Throwable -> 0x0007 }
        r3 = 1;
        goto L_0x0008;
    L_0x0007:
        r3 = 0;
    L_0x0008:
        if (r3 != 0) goto L_0x0017;
    L_0x000a:
        r3 = com.onesignal.sa.C0650i.ERROR;
        r1 = "Missing Google Project number!\nPlease enter a Google Project number / Sender ID on under App Settings > Android > Configuration on the OneSignal dashboard.";
        com.onesignal.sa.m1656a(r3, r1);
        r3 = 0;
        r1 = -6;
        r4.mo1392a(r3, r1);
        return r0;
    L_0x0017:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.Pa.a(java.lang.String, com.onesignal.La$a):boolean");
    }

    /* renamed from: b */
    private void m2250b(String str) {
        try {
            if (C0661x.m1755b()) {
                m2251c(str);
                return;
            }
            C0661x.m1752a();
            sa.m1656a(C0650i.ERROR, "'Google Play services' app not installed or disabled on the device.");
            this.f1830c.mo1392a(null, -7);
        } catch (Throwable th) {
            C0650i c0650i = C0650i.ERROR;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not register with ");
            stringBuilder.append(mo1748c());
            stringBuilder.append(" due to an issue with your AndroidManifest.xml or with 'Google Play services'.");
            sa.m1657a(c0650i, stringBuilder.toString(), th);
            this.f1830c.mo1392a(null, -8);
        }
    }

    /* renamed from: c */
    private synchronized void m2251c(String str) {
        if (this.f1831d == null || !this.f1831d.isAlive()) {
            this.f1831d = new Thread(new Oa(this, str));
            this.f1831d.start();
        }
    }

    /* renamed from: a */
    abstract String mo1747a(String str);

    /* renamed from: a */
    public void mo1363a(Context context, String str, C0596a c0596a) {
        this.f1830c = c0596a;
        if (m2248a(str, c0596a)) {
            m2250b(str);
        }
    }

    /* renamed from: c */
    abstract String mo1748c();
}
