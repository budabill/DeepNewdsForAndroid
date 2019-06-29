package com.facebook.p033b.p034a;

import android.annotation.TargetApi;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdManager.RegistrationListener;
import android.net.nsd.NsdServiceInfo;
import android.os.Build.VERSION;
import com.facebook.C0560t;
import com.facebook.internal.C0457C;
import com.facebook.internal.C0471N;
import com.facebook.internal.C0475Q;
import java.util.HashMap;

/* renamed from: com.facebook.b.a.b */
public class C0438b {
    /* renamed from: a */
    private static final String f755a = "com.facebook.b.a.b";
    /* renamed from: b */
    private static HashMap<String, RegistrationListener> f756b = new HashMap();

    /* renamed from: a */
    public static java.lang.String m834a() {
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
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = "device";	 Catch:{ JSONException -> 0x0013 }
        r2 = android.os.Build.DEVICE;	 Catch:{ JSONException -> 0x0013 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0013 }
        r1 = "model";	 Catch:{ JSONException -> 0x0013 }
        r2 = android.os.Build.MODEL;	 Catch:{ JSONException -> 0x0013 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0013 }
    L_0x0013:
        r0 = r0.toString();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.b.a.b.a():java.lang.String");
    }

    /* renamed from: a */
    public static void m835a(String str) {
        C0438b.m839d(str);
    }

    /* renamed from: b */
    public static android.graphics.Bitmap m836b(java.lang.String r15) {
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
        r5 = new java.util.EnumMap;
        r0 = p014c.p015a.p016a.C0293c.class;
        r5.<init>(r0);
        r0 = p014c.p015a.p016a.C0293c.MARGIN;
        r1 = 2;
        r1 = java.lang.Integer.valueOf(r1);
        r5.put(r0, r1);
        r6 = 0;
        r0 = new c.a.a.f;	 Catch:{ j -> 0x005a }
        r0.<init>();	 Catch:{ j -> 0x005a }
        r2 = p014c.p015a.p016a.C0278a.QR_CODE;	 Catch:{ j -> 0x005a }
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ j -> 0x005a }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ j -> 0x005a }
        r1 = r15;	 Catch:{ j -> 0x005a }
        r15 = r0.mo941a(r1, r2, r3, r4, r5);	 Catch:{ j -> 0x005a }
        r14 = r15.m219b();	 Catch:{ j -> 0x005a }
        r13 = r15.m221c();	 Catch:{ j -> 0x005a }
        r0 = r14 * r13;	 Catch:{ j -> 0x005a }
        r8 = new int[r0];	 Catch:{ j -> 0x005a }
        r0 = 0;	 Catch:{ j -> 0x005a }
        r1 = 0;	 Catch:{ j -> 0x005a }
    L_0x0030:
        if (r1 >= r14) goto L_0x004b;	 Catch:{ j -> 0x005a }
    L_0x0032:
        r2 = r1 * r13;	 Catch:{ j -> 0x005a }
        r3 = 0;	 Catch:{ j -> 0x005a }
    L_0x0035:
        if (r3 >= r13) goto L_0x0048;	 Catch:{ j -> 0x005a }
    L_0x0037:
        r4 = r2 + r3;	 Catch:{ j -> 0x005a }
        r5 = r15.m218a(r3, r1);	 Catch:{ j -> 0x005a }
        if (r5 == 0) goto L_0x0042;	 Catch:{ j -> 0x005a }
    L_0x003f:
        r5 = -16777216; // 0xffffffffff000000 float:-1.7014118E38 double:NaN;	 Catch:{ j -> 0x005a }
        goto L_0x0043;	 Catch:{ j -> 0x005a }
    L_0x0042:
        r5 = -1;	 Catch:{ j -> 0x005a }
    L_0x0043:
        r8[r4] = r5;	 Catch:{ j -> 0x005a }
        r3 = r3 + 1;	 Catch:{ j -> 0x005a }
        goto L_0x0035;	 Catch:{ j -> 0x005a }
    L_0x0048:
        r1 = r1 + 1;	 Catch:{ j -> 0x005a }
        goto L_0x0030;	 Catch:{ j -> 0x005a }
    L_0x004b:
        r15 = android.graphics.Bitmap.Config.ARGB_8888;	 Catch:{ j -> 0x005a }
        r15 = android.graphics.Bitmap.createBitmap(r13, r14, r15);	 Catch:{ j -> 0x005a }
        r9 = 0;
        r11 = 0;
        r12 = 0;
        r7 = r15;
        r10 = r13;
        r7.setPixels(r8, r9, r10, r11, r12, r13, r14);	 Catch:{ j -> 0x005b }
        goto L_0x005b;
    L_0x005a:
        r15 = r6;
    L_0x005b:
        return r15;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.b.a.b.b(java.lang.String):android.graphics.Bitmap");
    }

    /* renamed from: b */
    public static boolean m837b() {
        return VERSION.SDK_INT >= 16 && C0457C.m876b(C0560t.m1253e()).m1107j().contains(C0471N.Enabled);
    }

    /* renamed from: c */
    public static boolean m838c(String str) {
        return C0438b.m837b() ? C0438b.m840e(str) : false;
    }

    @TargetApi(16)
    /* renamed from: d */
    private static void m839d(String str) {
        RegistrationListener registrationListener = (RegistrationListener) f756b.get(str);
        if (registrationListener != null) {
            try {
                ((NsdManager) C0560t.m1252d().getSystemService("servicediscovery")).unregisterService(registrationListener);
            } catch (Exception e) {
                C0475Q.m983a(f755a, e);
            }
            f756b.remove(str);
        }
    }

    @TargetApi(16)
    /* renamed from: e */
    private static boolean m840e(String str) {
        if (f756b.containsKey(str)) {
            return true;
        }
        String replace = C0560t.m1262n().replace('.', '|');
        r2 = new Object[3];
        r2[1] = String.format("%s-%s", new Object[]{"android", replace});
        r2[2] = str;
        replace = String.format("%s_%s_%s", r2);
        NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
        nsdServiceInfo.setServiceType("_fb._tcp.");
        nsdServiceInfo.setServiceName(replace);
        nsdServiceInfo.setPort(80);
        NsdManager nsdManager = (NsdManager) C0560t.m1252d().getSystemService("servicediscovery");
        RegistrationListener c0437a = new C0437a(replace, str);
        f756b.put(str, c0437a);
        nsdManager.registerService(nsdServiceInfo, 1, c0437a);
        return true;
    }
}
