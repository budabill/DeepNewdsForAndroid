package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.zzccn;

@Hide
@DynamiteApi
public class FlagProviderImpl extends zzccn {
    private boolean zzarf = false;
    private SharedPreferences zzbkx;

    public boolean getBooleanFlagValue(String str, boolean z, int i) {
        return !this.zzarf ? z : zzb.zza(this.zzbkx, str, Boolean.valueOf(z)).booleanValue();
    }

    public int getIntFlagValue(String str, int i, int i2) {
        return !this.zzarf ? i : zzd.zza(this.zzbkx, str, Integer.valueOf(i)).intValue();
    }

    public long getLongFlagValue(String str, long j, int i) {
        return !this.zzarf ? j : zzf.zza(this.zzbkx, str, Long.valueOf(j)).longValue();
    }

    public String getStringFlagValue(String str, String str2, int i) {
        return !this.zzarf ? str2 : zzh.zza(this.zzbkx, str, str2);
    }

    public void init(com.google.android.gms.dynamic.IObjectWrapper r3) {
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
        r3 = com.google.android.gms.dynamic.zzn.zzy(r3);
        r3 = (android.content.Context) r3;
        r0 = r2.zzarf;
        if (r0 == 0) goto L_0x000b;
    L_0x000a:
        return;
    L_0x000b:
        r0 = "com.google.android.gms";	 Catch:{ NameNotFoundException -> 0x003c, Exception -> 0x001c }
        r1 = 0;	 Catch:{ NameNotFoundException -> 0x003c, Exception -> 0x001c }
        r3 = r3.createPackageContext(r0, r1);	 Catch:{ NameNotFoundException -> 0x003c, Exception -> 0x001c }
        r3 = com.google.android.gms.flags.impl.zzj.zzdk(r3);	 Catch:{ NameNotFoundException -> 0x003c, Exception -> 0x001c }
        r2.zzbkx = r3;	 Catch:{ NameNotFoundException -> 0x003c, Exception -> 0x001c }
        r3 = 1;	 Catch:{ NameNotFoundException -> 0x003c, Exception -> 0x001c }
        r2.zzarf = r3;	 Catch:{ NameNotFoundException -> 0x003c, Exception -> 0x001c }
        return;
    L_0x001c:
        r3 = move-exception;
        r0 = "Could not retrieve sdk flags, continuing with defaults: ";
        r3 = r3.getMessage();
        r3 = java.lang.String.valueOf(r3);
        r1 = r3.length();
        if (r1 == 0) goto L_0x0032;
    L_0x002d:
        r3 = r0.concat(r3);
        goto L_0x0037;
    L_0x0032:
        r3 = new java.lang.String;
        r3.<init>(r0);
    L_0x0037:
        r0 = "FlagProviderImpl";
        android.util.Log.w(r0, r3);
    L_0x003c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.flags.impl.FlagProviderImpl.init(com.google.android.gms.dynamic.IObjectWrapper):void");
    }
}
