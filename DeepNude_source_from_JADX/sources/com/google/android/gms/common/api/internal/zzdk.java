package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class zzdk {
    public static final Status zzgbq = new Status(8, "The connection to Google Play services was lost");
    private static final BasePendingResult<?>[] zzgbr = new BasePendingResult[0];
    private final Map<zzc<?>, zze> zzfyj;
    final Set<BasePendingResult<?>> zzgbs = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    private final zzdn zzgbt = new zzdl(this);

    public zzdk(Map<zzc<?>, zze> map) {
        this.zzfyj = map;
    }

    public final void release() {
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
        r8 = this;
        r0 = r8.zzgbs;
        r1 = zzgbr;
        r0 = r0.toArray(r1);
        r0 = (com.google.android.gms.common.api.internal.BasePendingResult[]) r0;
        r1 = r0.length;
        r2 = 0;
        r3 = 0;
    L_0x000d:
        if (r3 >= r1) goto L_0x0075;
    L_0x000f:
        r4 = r0[r3];
        r5 = 0;
        r4.zza(r5);
        r6 = r4.zzaid();
        if (r6 != 0) goto L_0x0027;
    L_0x001b:
        r5 = r4.zzaip();
        if (r5 == 0) goto L_0x0072;
    L_0x0021:
        r5 = r8.zzgbs;
        r5.remove(r4);
        goto L_0x0072;
    L_0x0027:
        r4.setResultCallback(r5);
        r6 = r8.zzfyj;
        r7 = r4;
        r7 = (com.google.android.gms.common.api.internal.zzm) r7;
        r7 = r7.zzahm();
        r6 = r6.get(r7);
        r6 = (com.google.android.gms.common.api.Api.zze) r6;
        r6 = r6.zzaho();
        r7 = r4.isReady();
        if (r7 == 0) goto L_0x004c;
    L_0x0043:
        r7 = new com.google.android.gms.common.api.internal.zzdm;
        r7.<init>(r4, r5, r6, r5);
        r4.zza(r7);
        goto L_0x0021;
    L_0x004c:
        if (r6 == 0) goto L_0x0060;
    L_0x004e:
        r7 = r6.isBinderAlive();
        if (r7 == 0) goto L_0x0060;
    L_0x0054:
        r7 = new com.google.android.gms.common.api.internal.zzdm;
        r7.<init>(r4, r5, r6, r5);
        r4.zza(r7);
        r6.linkToDeath(r7, r2);	 Catch:{ RemoteException -> 0x0063 }
        goto L_0x0021;
    L_0x0060:
        r4.zza(r5);
    L_0x0063:
        r4.cancel();
        r6 = r4.zzaid();
        r6 = r6.intValue();
        r5.remove(r6);
        goto L_0x0021;
    L_0x0072:
        r3 = r3 + 1;
        goto L_0x000d;
    L_0x0075:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzdk.release():void");
    }

    public final void zzald() {
        for (BasePendingResult zzv : (BasePendingResult[]) this.zzgbs.toArray(zzgbr)) {
            zzv.zzv(zzgbq);
        }
    }

    final void zzb(BasePendingResult<? extends Result> basePendingResult) {
        this.zzgbs.add(basePendingResult);
        basePendingResult.zza(this.zzgbt);
    }
}
