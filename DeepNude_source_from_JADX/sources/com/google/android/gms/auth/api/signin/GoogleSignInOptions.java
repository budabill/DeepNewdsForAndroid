package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.zzo;
import com.google.android.gms.auth.api.signin.internal.zzq;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class GoogleSignInOptions extends zzbgl implements Optional, ReflectedParcelable {
    public static final Creator<GoogleSignInOptions> CREATOR = new zze();
    public static final GoogleSignInOptions DEFAULT_GAMES_SIGN_IN = new Builder().requestScopes(SCOPE_GAMES_LITE, new Scope[0]).build();
    public static final GoogleSignInOptions DEFAULT_SIGN_IN = new Builder().requestId().requestProfile().build();
    @Hide
    public static final Scope SCOPE_GAMES = new Scope(Scopes.GAMES);
    @Hide
    public static final Scope SCOPE_GAMES_LITE = new Scope("https://www.googleapis.com/auth/games_lite");
    @Hide
    public static final Scope zzemx = new Scope(Scopes.PROFILE);
    @Hide
    public static final Scope zzemy = new Scope("email");
    @Hide
    public static final Scope zzemz = new Scope("openid");
    private static Comparator<Scope> zzeng = new zzd();
    private int versionCode;
    private Account zzeho;
    private boolean zzela;
    private String zzelb;
    private final ArrayList<Scope> zzena;
    private final boolean zzenb;
    private final boolean zzenc;
    private String zzend;
    private ArrayList<zzo> zzene;
    private Map<Integer, zzo> zzenf;

    public static final class Builder {
        private Account zzeho;
        private boolean zzela;
        private String zzelb;
        private boolean zzenb;
        private boolean zzenc;
        private String zzend;
        private Set<Scope> zzenh = new HashSet();
        private Map<Integer, zzo> zzeni = new HashMap();

        public Builder(GoogleSignInOptions googleSignInOptions) {
            zzbq.checkNotNull(googleSignInOptions);
            this.zzenh = new HashSet(googleSignInOptions.zzena);
            this.zzenb = googleSignInOptions.zzenb;
            this.zzenc = googleSignInOptions.zzenc;
            this.zzela = googleSignInOptions.zzela;
            this.zzelb = googleSignInOptions.zzelb;
            this.zzeho = googleSignInOptions.zzeho;
            this.zzend = googleSignInOptions.zzend;
            this.zzeni = GoogleSignInOptions.zzx(googleSignInOptions.zzene);
        }

        private final String zzfc(String str) {
            boolean z;
            zzbq.zzgv(str);
            String str2 = this.zzelb;
            if (str2 != null) {
                if (!str2.equals(str)) {
                    z = false;
                    zzbq.checkArgument(z, "two different server client ids provided");
                    return str;
                }
            }
            z = true;
            zzbq.checkArgument(z, "two different server client ids provided");
            return str;
        }

        public final Builder addExtension(GoogleSignInOptionsExtension googleSignInOptionsExtension) {
            if (this.zzeni.containsKey(Integer.valueOf(googleSignInOptionsExtension.getExtensionType()))) {
                throw new IllegalStateException("Only one extension per type may be added");
            }
            if (googleSignInOptionsExtension.getImpliedScopes() != null) {
                this.zzenh.addAll(googleSignInOptionsExtension.getImpliedScopes());
            }
            this.zzeni.put(Integer.valueOf(googleSignInOptionsExtension.getExtensionType()), new zzo(googleSignInOptionsExtension));
            return this;
        }

        public final GoogleSignInOptions build() {
            if (this.zzenh.contains(GoogleSignInOptions.SCOPE_GAMES) && this.zzenh.contains(GoogleSignInOptions.SCOPE_GAMES_LITE)) {
                this.zzenh.remove(GoogleSignInOptions.SCOPE_GAMES_LITE);
            }
            if (this.zzela && (this.zzeho == null || !this.zzenh.isEmpty())) {
                requestId();
            }
            return new GoogleSignInOptions(new ArrayList(this.zzenh), this.zzeho, this.zzela, this.zzenb, this.zzenc, this.zzelb, this.zzend, this.zzeni);
        }

        public final Builder requestEmail() {
            this.zzenh.add(GoogleSignInOptions.zzemy);
            return this;
        }

        public final Builder requestId() {
            this.zzenh.add(GoogleSignInOptions.zzemz);
            return this;
        }

        public final Builder requestIdToken(String str) {
            this.zzela = true;
            zzfc(str);
            this.zzelb = str;
            return this;
        }

        public final Builder requestProfile() {
            this.zzenh.add(GoogleSignInOptions.zzemx);
            return this;
        }

        public final Builder requestScopes(Scope scope, Scope... scopeArr) {
            this.zzenh.add(scope);
            this.zzenh.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public final Builder requestServerAuthCode(String str) {
            return requestServerAuthCode(str, false);
        }

        public final Builder requestServerAuthCode(String str, boolean z) {
            this.zzenb = true;
            zzfc(str);
            this.zzelb = str;
            this.zzenc = z;
            return this;
        }

        public final Builder setAccountName(String str) {
            zzbq.zzgv(str);
            this.zzeho = new Account(str, "com.google");
            return this;
        }

        public final Builder setHostedDomain(String str) {
            zzbq.zzgv(str);
            this.zzend = str;
            return this;
        }
    }

    GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, ArrayList<zzo> arrayList2) {
        this(i, (ArrayList) arrayList, account, z, z2, z3, str, str2, zzx(arrayList2));
    }

    private GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map<Integer, zzo> map) {
        this.versionCode = i;
        this.zzena = arrayList;
        this.zzeho = account;
        this.zzela = z;
        this.zzenb = z2;
        this.zzenc = z3;
        this.zzelb = str;
        this.zzend = str2;
        this.zzene = new ArrayList(map.values());
        this.zzenf = map;
    }

    private final JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.zzena, zzeng);
            ArrayList arrayList = this.zzena;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                jSONArray.put(((Scope) obj).zzaie());
            }
            jSONObject.put("scopes", jSONArray);
            if (this.zzeho != null) {
                jSONObject.put("accountName", this.zzeho.name);
            }
            jSONObject.put("idTokenRequested", this.zzela);
            jSONObject.put("forceCodeForRefreshToken", this.zzenc);
            jSONObject.put("serverAuthRequested", this.zzenb);
            if (!TextUtils.isEmpty(this.zzelb)) {
                jSONObject.put("serverClientId", this.zzelb);
            }
            if (!TextUtils.isEmpty(this.zzend)) {
                jSONObject.put("hostedDomain", this.zzend);
            }
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Hide
    public static GoogleSignInOptions zzfb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        Collection hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        Object optString = jSONObject.optString("accountName", null);
        return new GoogleSignInOptions(3, new ArrayList(hashSet), !TextUtils.isEmpty(optString) ? new Account(optString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null), jSONObject.optString("hostedDomain", null), new HashMap());
    }

    private static Map<Integer, zzo> zzx(List<zzo> list) {
        Map<Integer, zzo> hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (zzo zzo : list) {
            hashMap.put(Integer.valueOf(zzo.getType()), zzo);
        }
        return hashMap;
    }

    public boolean equals(java.lang.Object r4) {
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
        r0 = 0;
        if (r4 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r4 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r4;	 Catch:{ ClassCastException -> 0x0076 }
        r1 = r3.zzene;	 Catch:{ ClassCastException -> 0x0076 }
        r1 = r1.size();	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 > 0) goto L_0x0076;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x000e:
        r1 = r4.zzene;	 Catch:{ ClassCastException -> 0x0076 }
        r1 = r1.size();	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 <= 0) goto L_0x0017;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0016:
        goto L_0x0076;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0017:
        r1 = r3.zzena;	 Catch:{ ClassCastException -> 0x0076 }
        r1 = r1.size();	 Catch:{ ClassCastException -> 0x0076 }
        r2 = r4.zzaci();	 Catch:{ ClassCastException -> 0x0076 }
        r2 = r2.size();	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 != r2) goto L_0x0076;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0027:
        r1 = r3.zzena;	 Catch:{ ClassCastException -> 0x0076 }
        r2 = r4.zzaci();	 Catch:{ ClassCastException -> 0x0076 }
        r1 = r1.containsAll(r2);	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 != 0) goto L_0x0034;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0033:
        goto L_0x0076;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0034:
        r1 = r3.zzeho;	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 != 0) goto L_0x003d;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0038:
        r1 = r4.zzeho;	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 != 0) goto L_0x0076;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x003c:
        goto L_0x0047;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x003d:
        r1 = r3.zzeho;	 Catch:{ ClassCastException -> 0x0076 }
        r2 = r4.zzeho;	 Catch:{ ClassCastException -> 0x0076 }
        r1 = r1.equals(r2);	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 == 0) goto L_0x0076;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0047:
        r1 = r3.zzelb;	 Catch:{ ClassCastException -> 0x0076 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 == 0) goto L_0x0058;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x004f:
        r1 = r4.zzelb;	 Catch:{ ClassCastException -> 0x0076 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 == 0) goto L_0x0076;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0057:
        goto L_0x0062;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0058:
        r1 = r3.zzelb;	 Catch:{ ClassCastException -> 0x0076 }
        r2 = r4.zzelb;	 Catch:{ ClassCastException -> 0x0076 }
        r1 = r1.equals(r2);	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 == 0) goto L_0x0076;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0062:
        r1 = r3.zzenc;	 Catch:{ ClassCastException -> 0x0076 }
        r2 = r4.zzenc;	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 != r2) goto L_0x0076;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0068:
        r1 = r3.zzela;	 Catch:{ ClassCastException -> 0x0076 }
        r2 = r4.zzela;	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 != r2) goto L_0x0076;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x006e:
        r1 = r3.zzenb;	 Catch:{ ClassCastException -> 0x0076 }
        r4 = r4.zzenb;	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 != r4) goto L_0x0076;
    L_0x0074:
        r4 = 1;
        return r4;
    L_0x0076:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    @Hide
    public final Account getAccount() {
        return this.zzeho;
    }

    public Scope[] getScopeArray() {
        ArrayList arrayList = this.zzena;
        return (Scope[]) arrayList.toArray(new Scope[arrayList.size()]);
    }

    @Hide
    public final String getServerClientId() {
        return this.zzelb;
    }

    public int hashCode() {
        List arrayList = new ArrayList();
        ArrayList arrayList2 = this.zzena;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            arrayList.add(((Scope) obj).zzaie());
        }
        Collections.sort(arrayList);
        return new zzq().zzs(arrayList).zzs(this.zzeho).zzs(this.zzelb).zzav(this.zzenc).zzav(this.zzela).zzav(this.zzenb).zzacr();
    }

    @Hide
    public final boolean isIdTokenRequested() {
        return this.zzela;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.versionCode);
        zzbgo.zzc(parcel, 2, zzaci(), false);
        zzbgo.zza(parcel, 3, this.zzeho, i, false);
        zzbgo.zza(parcel, 4, this.zzela);
        zzbgo.zza(parcel, 5, this.zzenb);
        zzbgo.zza(parcel, 6, this.zzenc);
        zzbgo.zza(parcel, 7, this.zzelb, false);
        zzbgo.zza(parcel, 8, this.zzend, false);
        zzbgo.zzc(parcel, 9, this.zzene, false);
        zzbgo.zzai(parcel, zze);
    }

    @Hide
    public final ArrayList<Scope> zzaci() {
        return new ArrayList(this.zzena);
    }

    @Hide
    public final boolean zzacj() {
        return this.zzenb;
    }

    @Hide
    public final String zzack() {
        return toJsonObject().toString();
    }
}
