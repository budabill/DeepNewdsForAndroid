package com.facebook.login;

import android.os.Bundle;
import com.facebook.login.LoginClient.Result.C0509a;
import com.facebook.p029a.C0422r;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.facebook.login.y */
class C0527y {
    /* renamed from: a */
    private final C0422r f1010a;
    /* renamed from: b */
    private String f1011b;
    /* renamed from: c */
    private String f1012c;

    C0527y(android.content.Context r2, java.lang.String r3) {
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
        r1.<init>();
        r1.f1011b = r3;
        r3 = com.facebook.p029a.C0422r.m796b(r2, r3);
        r1.f1010a = r3;
        r2 = r2.getPackageManager();	 Catch:{ NameNotFoundException -> 0x001e }
        if (r2 == 0) goto L_0x001e;	 Catch:{ NameNotFoundException -> 0x001e }
    L_0x0011:
        r3 = "com.facebook.katana";	 Catch:{ NameNotFoundException -> 0x001e }
        r0 = 0;	 Catch:{ NameNotFoundException -> 0x001e }
        r2 = r2.getPackageInfo(r3, r0);	 Catch:{ NameNotFoundException -> 0x001e }
        if (r2 == 0) goto L_0x001e;	 Catch:{ NameNotFoundException -> 0x001e }
    L_0x001a:
        r2 = r2.versionName;	 Catch:{ NameNotFoundException -> 0x001e }
        r1.f1012c = r2;	 Catch:{ NameNotFoundException -> 0x001e }
    L_0x001e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.y.<init>(android.content.Context, java.lang.String):void");
    }

    /* renamed from: a */
    static Bundle m1189a(String str) {
        Bundle bundle = new Bundle();
        bundle.putLong("1_timestamp_ms", System.currentTimeMillis());
        bundle.putString("0_auth_logger_id", str);
        str = "";
        bundle.putString("3_method", str);
        bundle.putString("2_result", str);
        bundle.putString("5_error_message", str);
        bundle.putString("4_error_code", str);
        bundle.putString("6_extras", str);
        return bundle;
    }

    /* renamed from: a */
    public String m1190a() {
        return this.f1011b;
    }

    /* renamed from: a */
    public void m1191a(String str, String str2) {
        Bundle a = C0527y.m1189a(str);
        a.putString("3_method", str2);
        this.f1010a.m806a("fb_mobile_login_method_not_tried", null, a);
    }

    /* renamed from: a */
    public void m1192a(String str, String str2, String str3) {
        Bundle a = C0527y.m1189a("");
        a.putString("2_result", C0509a.ERROR.m1131a());
        a.putString("5_error_message", str2);
        a.putString("3_method", str3);
        this.f1010a.m806a(str, null, a);
    }

    /* renamed from: a */
    public void m1193a(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        Bundle a = C0527y.m1189a(str);
        if (str3 != null) {
            a.putString("2_result", str3);
        }
        if (str4 != null) {
            a.putString("5_error_message", str4);
        }
        if (str5 != null) {
            a.putString("4_error_code", str5);
        }
        if (!(map == null || map.isEmpty())) {
            a.putString("6_extras", new JSONObject(map).toString());
        }
        a.putString("3_method", str2);
        this.f1010a.m806a("fb_mobile_login_method_complete", null, a);
    }

    /* renamed from: b */
    public void m1194b(String str, String str2) {
        Bundle a = C0527y.m1189a(str);
        a.putString("3_method", str2);
        this.f1010a.m806a("fb_mobile_login_method_start", null, a);
    }
}
