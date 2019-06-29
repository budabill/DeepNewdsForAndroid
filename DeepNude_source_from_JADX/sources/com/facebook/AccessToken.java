package com.facebook;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.facebook.internal.C0475Q;
import com.facebook.internal.C0476S;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class AccessToken implements Parcelable {
    public static final Creator<AccessToken> CREATOR = new C0432a();
    /* renamed from: a */
    private static final Date f397a = new Date(Long.MAX_VALUE);
    /* renamed from: b */
    private static final Date f398b = f397a;
    /* renamed from: c */
    private static final Date f399c = new Date();
    /* renamed from: d */
    private static final C0451h f400d = C0451h.FACEBOOK_APPLICATION_WEB;
    /* renamed from: e */
    private final Date f401e;
    /* renamed from: f */
    private final Set<String> f402f;
    /* renamed from: g */
    private final Set<String> f403g;
    /* renamed from: h */
    private final String f404h;
    /* renamed from: i */
    private final C0451h f405i;
    /* renamed from: j */
    private final Date f406j;
    /* renamed from: k */
    private final String f407k;
    /* renamed from: l */
    private final String f408l;
    /* renamed from: m */
    private final Date f409m;

    /* renamed from: com.facebook.AccessToken$a */
    public interface C0327a {
        /* renamed from: a */
        void m437a(AccessToken accessToken);

        /* renamed from: a */
        void m438a(C0506l c0506l);
    }

    AccessToken(Parcel parcel) {
        this.f401e = new Date(parcel.readLong());
        Collection arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        this.f402f = Collections.unmodifiableSet(new HashSet(arrayList));
        arrayList.clear();
        parcel.readStringList(arrayList);
        this.f403g = Collections.unmodifiableSet(new HashSet(arrayList));
        this.f404h = parcel.readString();
        this.f405i = C0451h.valueOf(parcel.readString());
        this.f406j = new Date(parcel.readLong());
        this.f407k = parcel.readString();
        this.f408l = parcel.readString();
        this.f409m = new Date(parcel.readLong());
    }

    public AccessToken(String str, String str2, String str3, Collection<String> collection, Collection<String> collection2, C0451h c0451h, Date date, Date date2, Date date3) {
        C0476S.m1017a(str, "accessToken");
        C0476S.m1017a(str2, "applicationId");
        C0476S.m1017a(str3, "userId");
        if (date == null) {
            date = f398b;
        }
        this.f401e = date;
        this.f402f = Collections.unmodifiableSet(collection != null ? new HashSet(collection) : new HashSet());
        this.f403g = Collections.unmodifiableSet(collection2 != null ? new HashSet(collection2) : new HashSet());
        this.f404h = str;
        if (c0451h == null) {
            c0451h = f400d;
        }
        this.f405i = c0451h;
        if (date2 == null) {
            date2 = f399c;
        }
        this.f406j = date2;
        this.f407k = str2;
        this.f408l = str3;
        if (date3 == null || date3.getTime() == 0) {
            date3 = f398b;
        }
        this.f409m = date3;
    }

    /* renamed from: a */
    static com.facebook.AccessToken m439a(android.os.Bundle r11) {
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
        r0 = "com.facebook.TokenCachingStrategy.Permissions";
        r5 = m442a(r11, r0);
        r0 = "com.facebook.TokenCachingStrategy.DeclinedPermissions";
        r6 = m442a(r11, r0);
        r0 = com.facebook.C0333F.m488a(r11);
        r1 = com.facebook.internal.C0475Q.m998b(r0);
        if (r1 == 0) goto L_0x001a;
    L_0x0016:
        r0 = com.facebook.C0560t.m1253e();
    L_0x001a:
        r3 = r0;
        r2 = com.facebook.C0333F.m492c(r11);
        r0 = com.facebook.internal.C0475Q.m975a(r2);
        r1 = "id";	 Catch:{ JSONException -> 0x0041 }
        r4 = r0.getString(r1);	 Catch:{ JSONException -> 0x0041 }
        r0 = new com.facebook.AccessToken;
        r7 = com.facebook.C0333F.m491b(r11);
        r1 = "com.facebook.TokenCachingStrategy.ExpirationDate";
        r8 = com.facebook.C0333F.m489a(r11, r1);
        r1 = "com.facebook.TokenCachingStrategy.LastRefreshDate";
        r9 = com.facebook.C0333F.m489a(r11, r1);
        r10 = 0;
        r1 = r0;
        r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10);
        return r0;
    L_0x0041:
        r11 = 0;
        return r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AccessToken.a(android.os.Bundle):com.facebook.AccessToken");
    }

    /* renamed from: a */
    static AccessToken m440a(AccessToken accessToken) {
        return new AccessToken(accessToken.f404h, accessToken.f407k, accessToken.m457k(), accessToken.m454h(), accessToken.m451e(), accessToken.f405i, new Date(), new Date(), accessToken.f409m);
    }

    /* renamed from: a */
    static AccessToken m441a(JSONObject jSONObject) {
        if (jSONObject.getInt("version") <= 1) {
            String string = jSONObject.getString("token");
            Date date = new Date(jSONObject.getLong("expires_at"));
            JSONArray jSONArray = jSONObject.getJSONArray("permissions");
            JSONArray jSONArray2 = jSONObject.getJSONArray("declined_permissions");
            Date date2 = new Date(jSONObject.getLong("last_refresh"));
            C0451h valueOf = C0451h.valueOf(jSONObject.getString("source"));
            return new AccessToken(string, jSONObject.getString("application_id"), jSONObject.getString("user_id"), C0475Q.m971a(jSONArray), C0475Q.m971a(jSONArray2), valueOf, date, date2, new Date(jSONObject.getLong("data_access_expiration_time")));
        }
        throw new C0506l("Unknown AccessToken serialization format.");
    }

    /* renamed from: a */
    static List<String> m442a(Bundle bundle, String str) {
        Collection stringArrayList = bundle.getStringArrayList(str);
        return stringArrayList == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(stringArrayList));
    }

    /* renamed from: a */
    static void m443a() {
        AccessToken c = C0450g.m858d().m865c();
        if (c != null) {
            m445b(m440a(c));
        }
    }

    /* renamed from: a */
    private void m444a(StringBuilder stringBuilder) {
        String str;
        stringBuilder.append(" permissions:");
        if (this.f402f == null) {
            str = "null";
        } else {
            stringBuilder.append("[");
            stringBuilder.append(TextUtils.join(", ", this.f402f));
            str = "]";
        }
        stringBuilder.append(str);
    }

    /* renamed from: b */
    public static void m445b(AccessToken accessToken) {
        C0450g.m858d().m863a(accessToken);
    }

    /* renamed from: c */
    public static AccessToken m446c() {
        return C0450g.m858d().m865c();
    }

    /* renamed from: l */
    public static boolean m447l() {
        AccessToken c = C0450g.m858d().m865c();
        return (c == null || c.m458m()) ? false : true;
    }

    /* renamed from: o */
    private String m448o() {
        return this.f404h == null ? "null" : C0560t.m1246a(C0336G.f466b) ? this.f404h : "ACCESS_TOKEN_REMOVED";
    }

    /* renamed from: b */
    public String m449b() {
        return this.f407k;
    }

    /* renamed from: d */
    public Date m450d() {
        return this.f409m;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public Set<String> m451e() {
        return this.f403g;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = 1;
        if (r4 != r5) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r5 instanceof com.facebook.AccessToken;
        r2 = 0;
        if (r1 != 0) goto L_0x000a;
    L_0x0009:
        return r2;
    L_0x000a:
        r5 = (com.facebook.AccessToken) r5;
        r1 = r4.f401e;
        r3 = r5.f401e;
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x006a;
    L_0x0016:
        r1 = r4.f402f;
        r3 = r5.f402f;
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x006a;
    L_0x0020:
        r1 = r4.f403g;
        r3 = r5.f403g;
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x006a;
    L_0x002a:
        r1 = r4.f404h;
        r3 = r5.f404h;
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x006a;
    L_0x0034:
        r1 = r4.f405i;
        r3 = r5.f405i;
        if (r1 != r3) goto L_0x006a;
    L_0x003a:
        r1 = r4.f406j;
        r3 = r5.f406j;
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x006a;
    L_0x0044:
        r1 = r4.f407k;
        if (r1 != 0) goto L_0x004d;
    L_0x0048:
        r1 = r5.f407k;
        if (r1 != 0) goto L_0x006a;
    L_0x004c:
        goto L_0x0055;
    L_0x004d:
        r3 = r5.f407k;
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x006a;
    L_0x0055:
        r1 = r4.f408l;
        r3 = r5.f408l;
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x006a;
    L_0x005f:
        r1 = r4.f409m;
        r5 = r5.f409m;
        r5 = r1.equals(r5);
        if (r5 == 0) goto L_0x006a;
    L_0x0069:
        goto L_0x006b;
    L_0x006a:
        r0 = 0;
    L_0x006b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AccessToken.equals(java.lang.Object):boolean");
    }

    /* renamed from: f */
    public Date m452f() {
        return this.f401e;
    }

    /* renamed from: g */
    public Date m453g() {
        return this.f406j;
    }

    /* renamed from: h */
    public Set<String> m454h() {
        return this.f402f;
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.f401e.hashCode()) * 31) + this.f402f.hashCode()) * 31) + this.f403g.hashCode()) * 31) + this.f404h.hashCode()) * 31) + this.f405i.hashCode()) * 31) + this.f406j.hashCode()) * 31;
        String str = this.f407k;
        return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f408l.hashCode()) * 31) + this.f409m.hashCode();
    }

    /* renamed from: i */
    public C0451h m455i() {
        return this.f405i;
    }

    /* renamed from: j */
    public String m456j() {
        return this.f404h;
    }

    /* renamed from: k */
    public String m457k() {
        return this.f408l;
    }

    /* renamed from: m */
    public boolean m458m() {
        return new Date().after(this.f401e);
    }

    /* renamed from: n */
    JSONObject m459n() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", 1);
        jSONObject.put("token", this.f404h);
        jSONObject.put("expires_at", this.f401e.getTime());
        jSONObject.put("permissions", new JSONArray(this.f402f));
        jSONObject.put("declined_permissions", new JSONArray(this.f403g));
        jSONObject.put("last_refresh", this.f406j.getTime());
        jSONObject.put("source", this.f405i.name());
        jSONObject.put("application_id", this.f407k);
        jSONObject.put("user_id", this.f408l);
        jSONObject.put("data_access_expiration_time", this.f409m.getTime());
        return jSONObject;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{AccessToken");
        stringBuilder.append(" token:");
        stringBuilder.append(m448o());
        m444a(stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f401e.getTime());
        parcel.writeStringList(new ArrayList(this.f402f));
        parcel.writeStringList(new ArrayList(this.f403g));
        parcel.writeString(this.f404h);
        parcel.writeString(this.f405i.name());
        parcel.writeLong(this.f406j.getTime());
        parcel.writeString(this.f407k);
        parcel.writeString(this.f408l);
        parcel.writeLong(this.f409m.getTime());
    }
}
