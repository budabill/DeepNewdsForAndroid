package com.facebook;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.internal.C0475Q;
import com.facebook.internal.C0476S;
import org.json.JSONObject;

public final class Profile implements Parcelable {
    public static final Creator<Profile> CREATOR = new C0340I();
    /* renamed from: a */
    private static final String f507a = "Profile";
    /* renamed from: b */
    private final String f508b;
    /* renamed from: c */
    private final String f509c;
    /* renamed from: d */
    private final String f510d;
    /* renamed from: e */
    private final String f511e;
    /* renamed from: f */
    private final String f512f;
    /* renamed from: g */
    private final Uri f513g;

    private Profile(Parcel parcel) {
        this.f508b = parcel.readString();
        this.f509c = parcel.readString();
        this.f510d = parcel.readString();
        this.f511e = parcel.readString();
        this.f512f = parcel.readString();
        String readString = parcel.readString();
        this.f513g = readString == null ? null : Uri.parse(readString);
    }

    public Profile(String str, String str2, String str3, String str4, String str5, Uri uri) {
        C0476S.m1017a(str, "id");
        this.f508b = str;
        this.f509c = str2;
        this.f510d = str3;
        this.f511e = str4;
        this.f512f = str5;
        this.f513g = uri;
    }

    Profile(JSONObject jSONObject) {
        Uri uri = null;
        this.f508b = jSONObject.optString("id", null);
        this.f509c = jSONObject.optString("first_name", null);
        this.f510d = jSONObject.optString("middle_name", null);
        this.f511e = jSONObject.optString("last_name", null);
        this.f512f = jSONObject.optString("name", null);
        String optString = jSONObject.optString("link_uri", null);
        if (optString != null) {
            uri = Uri.parse(optString);
        }
        this.f513g = uri;
    }

    /* renamed from: a */
    public static void m579a(Profile profile) {
        C0342K.m573b().m575a(profile);
    }

    /* renamed from: b */
    public static void m580b() {
        AccessToken c = AccessToken.m446c();
        if (AccessToken.m447l()) {
            C0475Q.m982a(c.m456j(), new C0819H());
        } else {
            m579a(null);
        }
    }

    /* renamed from: c */
    public static Profile m581c() {
        return C0342K.m573b().m574a();
    }

    /* renamed from: d */
    org.json.JSONObject m582d() {
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
        r3 = this;
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = "id";	 Catch:{ JSONException -> 0x0038 }
        r2 = r3.f508b;	 Catch:{ JSONException -> 0x0038 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0038 }
        r1 = "first_name";	 Catch:{ JSONException -> 0x0038 }
        r2 = r3.f509c;	 Catch:{ JSONException -> 0x0038 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0038 }
        r1 = "middle_name";	 Catch:{ JSONException -> 0x0038 }
        r2 = r3.f510d;	 Catch:{ JSONException -> 0x0038 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0038 }
        r1 = "last_name";	 Catch:{ JSONException -> 0x0038 }
        r2 = r3.f511e;	 Catch:{ JSONException -> 0x0038 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0038 }
        r1 = "name";	 Catch:{ JSONException -> 0x0038 }
        r2 = r3.f512f;	 Catch:{ JSONException -> 0x0038 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0038 }
        r1 = r3.f513g;	 Catch:{ JSONException -> 0x0038 }
        if (r1 == 0) goto L_0x0039;	 Catch:{ JSONException -> 0x0038 }
    L_0x002c:
        r1 = "link_uri";	 Catch:{ JSONException -> 0x0038 }
        r2 = r3.f513g;	 Catch:{ JSONException -> 0x0038 }
        r2 = r2.toString();	 Catch:{ JSONException -> 0x0038 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0038 }
        goto L_0x0039;
    L_0x0038:
        r0 = 0;
    L_0x0039:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.Profile.d():org.json.JSONObject");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Profile)) {
            return false;
        }
        Profile profile = (Profile) obj;
        if (this.f508b.equals(profile.f508b) && this.f509c == null) {
            if (profile.f509c == null) {
                return z;
            }
        } else if (this.f509c.equals(profile.f509c) && this.f510d == null) {
            if (profile.f510d == null) {
                return z;
            }
        } else if (this.f510d.equals(profile.f510d) && this.f511e == null) {
            if (profile.f511e == null) {
                return z;
            }
        } else if (this.f511e.equals(profile.f511e) && this.f512f == null) {
            if (profile.f512f == null) {
                return z;
            }
        } else if (!this.f512f.equals(profile.f512f) || this.f513g != null) {
            z = this.f513g.equals(profile.f513g);
            return z;
        } else if (profile.f513g == null) {
            return z;
        }
        z = false;
        return z;
    }

    public int hashCode() {
        int hashCode = 527 + this.f508b.hashCode();
        String str = this.f509c;
        if (str != null) {
            hashCode = (hashCode * 31) + str.hashCode();
        }
        str = this.f510d;
        if (str != null) {
            hashCode = (hashCode * 31) + str.hashCode();
        }
        str = this.f511e;
        if (str != null) {
            hashCode = (hashCode * 31) + str.hashCode();
        }
        str = this.f512f;
        if (str != null) {
            hashCode = (hashCode * 31) + str.hashCode();
        }
        Uri uri = this.f513g;
        return uri != null ? (hashCode * 31) + uri.hashCode() : hashCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f508b);
        parcel.writeString(this.f509c);
        parcel.writeString(this.f510d);
        parcel.writeString(this.f511e);
        parcel.writeString(this.f512f);
        Uri uri = this.f513g;
        parcel.writeString(uri == null ? null : uri.toString());
    }
}
