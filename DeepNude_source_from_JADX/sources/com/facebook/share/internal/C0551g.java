package com.facebook.share.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.Pair;
import com.facebook.AccessToken;
import com.facebook.C0332E;
import com.facebook.C0506l;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.C0338b;
import com.facebook.GraphRequest.ParcelableResourceWithMimeType;
import com.facebook.internal.C0475Q;
import com.facebook.share.model.ShareOpenGraphContent;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.share.internal.g */
public final class C0551g {
    /* renamed from: a */
    public static Pair<String, String> m1231a(String str) {
        Object substring;
        Object substring2;
        int indexOf = str.indexOf(58);
        if (indexOf != -1) {
            int i = indexOf + 1;
            if (str.length() > i) {
                substring = str.substring(0, indexOf);
                substring2 = str.substring(i);
                return new Pair(substring, substring2);
            }
        }
        substring = null;
        return new Pair(substring, substring2);
    }

    /* renamed from: a */
    public static GraphRequest m1232a(AccessToken accessToken, Uri uri, C0338b c0338b) {
        if (C0475Q.m1002c(uri)) {
            return C0551g.m1233a(accessToken, new File(uri.getPath()), c0338b);
        }
        if (C0475Q.m997b(uri)) {
            Parcelable parcelableResourceWithMimeType = new ParcelableResourceWithMimeType((Parcelable) uri, "image/png");
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("file", parcelableResourceWithMimeType);
            return new GraphRequest(accessToken, "me/staging_resources", bundle, C0332E.POST, c0338b);
        }
        throw new C0506l("The image Uri must be either a file:// or content:// Uri");
    }

    /* renamed from: a */
    public static GraphRequest m1233a(AccessToken accessToken, File file, C0338b c0338b) {
        Parcelable parcelableResourceWithMimeType = new ParcelableResourceWithMimeType(ParcelFileDescriptor.open(file, 268435456), "image/png");
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("file", parcelableResourceWithMimeType);
        return new GraphRequest(accessToken, "me/staging_resources", bundle, C0332E.POST, c0338b);
    }

    /* renamed from: a */
    public static JSONArray m1234a(JSONArray jSONArray, boolean z) {
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONArray) {
                obj = C0551g.m1234a((JSONArray) obj, z);
            } else if (obj instanceof JSONObject) {
                obj = C0551g.m1236a((JSONObject) obj, z);
            }
            jSONArray2.put(obj);
        }
        return jSONArray2;
    }

    /* renamed from: a */
    public static JSONObject m1235a(ShareOpenGraphContent shareOpenGraphContent) {
        return C0550e.m1229a(shareOpenGraphContent.m2487c(), new C0862f());
    }

    /* renamed from: a */
    public static org.json.JSONObject m1236a(org.json.JSONObject r9, boolean r10) {
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
        if (r9 != 0) goto L_0x0004;
    L_0x0002:
        r9 = 0;
        return r9;
    L_0x0004:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0080 }
        r0.<init>();	 Catch:{ JSONException -> 0x0080 }
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0080 }
        r1.<init>();	 Catch:{ JSONException -> 0x0080 }
        r2 = r9.names();	 Catch:{ JSONException -> 0x0080 }
        r3 = 0;	 Catch:{ JSONException -> 0x0080 }
    L_0x0013:
        r4 = r2.length();	 Catch:{ JSONException -> 0x0080 }
        if (r3 >= r4) goto L_0x0074;	 Catch:{ JSONException -> 0x0080 }
    L_0x0019:
        r4 = r2.getString(r3);	 Catch:{ JSONException -> 0x0080 }
        r5 = r9.get(r4);	 Catch:{ JSONException -> 0x0080 }
        r6 = r5 instanceof org.json.JSONObject;	 Catch:{ JSONException -> 0x0080 }
        r7 = 1;	 Catch:{ JSONException -> 0x0080 }
        if (r6 == 0) goto L_0x002d;	 Catch:{ JSONException -> 0x0080 }
    L_0x0026:
        r5 = (org.json.JSONObject) r5;	 Catch:{ JSONException -> 0x0080 }
        r5 = com.facebook.share.internal.C0551g.m1236a(r5, r7);	 Catch:{ JSONException -> 0x0080 }
        goto L_0x0037;	 Catch:{ JSONException -> 0x0080 }
    L_0x002d:
        r6 = r5 instanceof org.json.JSONArray;	 Catch:{ JSONException -> 0x0080 }
        if (r6 == 0) goto L_0x0037;	 Catch:{ JSONException -> 0x0080 }
    L_0x0031:
        r5 = (org.json.JSONArray) r5;	 Catch:{ JSONException -> 0x0080 }
        r5 = com.facebook.share.internal.C0551g.m1234a(r5, r7);	 Catch:{ JSONException -> 0x0080 }
    L_0x0037:
        r6 = com.facebook.share.internal.C0551g.m1231a(r4);	 Catch:{ JSONException -> 0x0080 }
        r7 = r6.first;	 Catch:{ JSONException -> 0x0080 }
        r7 = (java.lang.String) r7;	 Catch:{ JSONException -> 0x0080 }
        r6 = r6.second;	 Catch:{ JSONException -> 0x0080 }
        r6 = (java.lang.String) r6;	 Catch:{ JSONException -> 0x0080 }
        if (r10 == 0) goto L_0x0066;	 Catch:{ JSONException -> 0x0080 }
    L_0x0045:
        if (r7 == 0) goto L_0x0053;	 Catch:{ JSONException -> 0x0080 }
    L_0x0047:
        r8 = "fbsdk";	 Catch:{ JSONException -> 0x0080 }
        r8 = r7.equals(r8);	 Catch:{ JSONException -> 0x0080 }
        if (r8 == 0) goto L_0x0053;	 Catch:{ JSONException -> 0x0080 }
    L_0x004f:
        r0.put(r4, r5);	 Catch:{ JSONException -> 0x0080 }
        goto L_0x0071;	 Catch:{ JSONException -> 0x0080 }
    L_0x0053:
        if (r7 == 0) goto L_0x0062;	 Catch:{ JSONException -> 0x0080 }
    L_0x0055:
        r4 = "og";	 Catch:{ JSONException -> 0x0080 }
        r4 = r7.equals(r4);	 Catch:{ JSONException -> 0x0080 }
        if (r4 == 0) goto L_0x005e;	 Catch:{ JSONException -> 0x0080 }
    L_0x005d:
        goto L_0x0062;	 Catch:{ JSONException -> 0x0080 }
    L_0x005e:
        r1.put(r6, r5);	 Catch:{ JSONException -> 0x0080 }
        goto L_0x0071;	 Catch:{ JSONException -> 0x0080 }
    L_0x0062:
        r0.put(r6, r5);	 Catch:{ JSONException -> 0x0080 }
        goto L_0x0071;	 Catch:{ JSONException -> 0x0080 }
    L_0x0066:
        if (r7 == 0) goto L_0x0062;	 Catch:{ JSONException -> 0x0080 }
    L_0x0068:
        r8 = "fb";	 Catch:{ JSONException -> 0x0080 }
        r7 = r7.equals(r8);	 Catch:{ JSONException -> 0x0080 }
        if (r7 == 0) goto L_0x0062;	 Catch:{ JSONException -> 0x0080 }
    L_0x0070:
        goto L_0x004f;	 Catch:{ JSONException -> 0x0080 }
    L_0x0071:
        r3 = r3 + 1;	 Catch:{ JSONException -> 0x0080 }
        goto L_0x0013;	 Catch:{ JSONException -> 0x0080 }
    L_0x0074:
        r9 = r1.length();	 Catch:{ JSONException -> 0x0080 }
        if (r9 <= 0) goto L_0x007f;	 Catch:{ JSONException -> 0x0080 }
    L_0x007a:
        r9 = "data";	 Catch:{ JSONException -> 0x0080 }
        r0.put(r9, r1);	 Catch:{ JSONException -> 0x0080 }
    L_0x007f:
        return r0;
    L_0x0080:
        r9 = new com.facebook.l;
        r10 = "Failed to create json object from share content";
        r9.<init>(r10);
        goto L_0x0089;
    L_0x0088:
        throw r9;
    L_0x0089:
        goto L_0x0088;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.g.a(org.json.JSONObject, boolean):org.json.JSONObject");
    }
}
