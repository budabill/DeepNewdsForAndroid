package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.facebook.C0451h;
import com.facebook.internal.C0470M;
import com.facebook.internal.C0475Q;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;

abstract class NativeAppLoginMethodHandler extends LoginMethodHandler {
    NativeAppLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }

    NativeAppLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    /* renamed from: a */
    private Result m2186a(Request request, Intent intent) {
        Bundle extras = intent.getExtras();
        String a = m2187a(extras);
        String str = "error_code";
        str = extras.get(str) != null ? extras.get(str).toString() : null;
        return "CONNECTION_FAILURE".equals(str) ? Result.m1135a(request, a, m2189b(extras), str) : Result.m1133a(request, a);
    }

    /* renamed from: a */
    private String m2187a(Bundle bundle) {
        String string = bundle.getString("error");
        return string == null ? bundle.getString("error_type") : string;
    }

    /* renamed from: b */
    private Result m2188b(Request request, Intent intent) {
        Bundle extras = intent.getExtras();
        String a = m2187a(extras);
        String str = "error_code";
        str = extras.get(str) != null ? extras.get(str).toString() : null;
        String b = m2189b(extras);
        String string = extras.getString("e2e");
        if (!C0475Q.m998b(string)) {
            m1180c(string);
        }
        if (a != null || str != null || b != null) {
            return C0470M.f832a.contains(a) ? null : C0470M.f833b.contains(a) ? Result.m1133a(request, null) : Result.m1135a(request, a, b, str);
        } else {
            try {
                request = Result.m1132a(request, LoginMethodHandler.m1170a(request.m1128h(), extras, C0451h.FACEBOOK_APPLICATION_WEB, request.m1120a()));
                return request;
            } catch (RuntimeException e) {
                return Result.m1134a(request, null, e.getMessage());
            }
        }
    }

    /* renamed from: b */
    private String m2189b(Bundle bundle) {
        String string = bundle.getString("error_message");
        return string == null ? bundle.getString("error_description") : string;
    }

    /* renamed from: a */
    boolean mo965a(int i, int i2, Intent intent) {
        Request i3 = this.f980b.m1164i();
        Result a = intent == null ? Result.m1133a(i3, "Operation canceled") : i2 == 0 ? m2186a(i3, intent) : i2 != -1 ? Result.m1134a(i3, "Unexpected resultCode from authorization.", null) : m2188b(i3, intent);
        if (a != null) {
            this.f980b.m1155b(a);
        } else {
            this.f980b.m1168m();
        }
        return true;
    }

    /* renamed from: a */
    protected boolean m2191a(android.content.Intent r3, int r4) {
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
        r0 = 0;
        if (r3 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r2.f980b;	 Catch:{ ActivityNotFoundException -> 0x000f }
        r1 = r1.m1162f();	 Catch:{ ActivityNotFoundException -> 0x000f }
        r1.startActivityForResult(r3, r4);	 Catch:{ ActivityNotFoundException -> 0x000f }
        r3 = 1;
        return r3;
    L_0x000f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.NativeAppLoginMethodHandler.a(android.content.Intent, int):boolean");
    }
}
