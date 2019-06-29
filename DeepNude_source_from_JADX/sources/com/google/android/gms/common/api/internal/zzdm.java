package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.google.android.gms.common.api.zze;
import java.lang.ref.WeakReference;

final class zzdm implements DeathRecipient, zzdn {
    private final WeakReference<BasePendingResult<?>> zzgbv;
    private final WeakReference<zze> zzgbw;
    private final WeakReference<IBinder> zzgbx;

    private zzdm(BasePendingResult<?> basePendingResult, zze zze, IBinder iBinder) {
        this.zzgbw = new WeakReference(zze);
        this.zzgbv = new WeakReference(basePendingResult);
        this.zzgbx = new WeakReference(iBinder);
    }

    private final void zzale() {
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
        r0 = r2.zzgbv;
        r0 = r0.get();
        r0 = (com.google.android.gms.common.api.internal.BasePendingResult) r0;
        r1 = r2.zzgbw;
        r1 = r1.get();
        r1 = (com.google.android.gms.common.api.zze) r1;
        if (r1 == 0) goto L_0x001f;
    L_0x0012:
        if (r0 == 0) goto L_0x001f;
    L_0x0014:
        r0 = r0.zzaid();
        r0 = r0.intValue();
        r1.remove(r0);
    L_0x001f:
        r0 = r2.zzgbx;
        r0 = r0.get();
        r0 = (android.os.IBinder) r0;
        if (r0 == 0) goto L_0x002d;
    L_0x0029:
        r1 = 0;
        r0.unlinkToDeath(r2, r1);	 Catch:{ NoSuchElementException -> 0x002d }
    L_0x002d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzdm.zzale():void");
    }

    public final void binderDied() {
        zzale();
    }

    public final void zzc(BasePendingResult<?> basePendingResult) {
        zzale();
    }
}
