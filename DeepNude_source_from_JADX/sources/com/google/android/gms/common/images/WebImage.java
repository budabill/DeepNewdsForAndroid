package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import java.util.Arrays;
import java.util.Locale;
import org.json.JSONObject;

public final class WebImage extends zzbgl {
    public static final Creator<WebImage> CREATOR = new zze();
    private final int zzalt;
    private final int zzalu;
    private int zzehz;
    private final Uri zzfgr;

    WebImage(int i, Uri uri, int i2, int i3) {
        this.zzehz = i;
        this.zzfgr = uri;
        this.zzalt = i2;
        this.zzalu = i3;
    }

    public WebImage(Uri uri) {
        this(uri, 0, 0);
    }

    public WebImage(Uri uri, int i, int i2) {
        this(1, uri, i, i2);
        if (uri == null) {
            throw new IllegalArgumentException("url cannot be null");
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    @Hide
    public WebImage(JSONObject jSONObject) {
        this(zzx(jSONObject), jSONObject.optInt("width", 0), jSONObject.optInt("height", 0));
    }

    private static android.net.Uri zzx(org.json.JSONObject r2) {
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
        r0 = "url";
        r1 = r2.has(r0);
        if (r1 == 0) goto L_0x0011;
    L_0x0008:
        r2 = r2.getString(r0);	 Catch:{ JSONException -> 0x0011 }
        r2 = android.net.Uri.parse(r2);	 Catch:{ JSONException -> 0x0011 }
        goto L_0x0012;
    L_0x0011:
        r2 = 0;
    L_0x0012:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.images.WebImage.zzx(org.json.JSONObject):android.net.Uri");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (obj instanceof WebImage) {
                WebImage webImage = (WebImage) obj;
                return zzbg.equal(this.zzfgr, webImage.zzfgr) && this.zzalt == webImage.zzalt && this.zzalu == webImage.zzalu;
            }
        }
    }

    public final int getHeight() {
        return this.zzalu;
    }

    public final Uri getUrl() {
        return this.zzfgr;
    }

    public final int getWidth() {
        return this.zzalt;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzfgr, Integer.valueOf(this.zzalt), Integer.valueOf(this.zzalu)});
    }

    @com.google.android.gms.common.internal.Hide
    public final org.json.JSONObject toJson() {
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
        r1 = "url";	 Catch:{ JSONException -> 0x001e }
        r2 = r3.zzfgr;	 Catch:{ JSONException -> 0x001e }
        r2 = r2.toString();	 Catch:{ JSONException -> 0x001e }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x001e }
        r1 = "width";	 Catch:{ JSONException -> 0x001e }
        r2 = r3.zzalt;	 Catch:{ JSONException -> 0x001e }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x001e }
        r1 = "height";	 Catch:{ JSONException -> 0x001e }
        r2 = r3.zzalu;	 Catch:{ JSONException -> 0x001e }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x001e }
    L_0x001e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.images.WebImage.toJson():org.json.JSONObject");
    }

    public final String toString() {
        return String.format(Locale.US, "Image %dx%d %s", new Object[]{Integer.valueOf(this.zzalt), Integer.valueOf(this.zzalu), this.zzfgr.toString()});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.zzehz);
        zzbgo.zza(parcel, 2, getUrl(), i, false);
        zzbgo.zzc(parcel, 3, getWidth());
        zzbgo.zzc(parcel, 4, getHeight());
        zzbgo.zzai(parcel, zze);
    }
}
