package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;

public final class zzal implements zzbh {
    private final zzbi zzfxd;
    private boolean zzfxe = false;

    public zzal(zzbi zzbi) {
        this.zzfxd = zzbi;
    }

    public final void begin() {
    }

    public final void connect() {
        if (this.zzfxe) {
            this.zzfxe = false;
            this.zzfxd.zza(new zzan(this, this));
        }
    }

    public final boolean disconnect() {
        if (this.zzfxe) {
            return false;
        }
        if (this.zzfxd.zzfvq.zzajt()) {
            this.zzfxe = true;
            for (zzdh zzalb : this.zzfxd.zzfvq.zzfyo) {
                zzalb.zzalb();
            }
            return false;
        }
        this.zzfxd.zzg(null);
        return true;
    }

    public final void onConnected(Bundle bundle) {
    }

    public final void onConnectionSuspended(int i) {
        this.zzfxd.zzg(null);
        this.zzfxd.zzfzc.zzf(i, this.zzfxe);
    }

    public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }

    final void zzaji() {
        if (this.zzfxe) {
            this.zzfxe = false;
            this.zzfxd.zzfvq.zzfyp.release();
            disconnect();
        }
    }

    public final <A extends zzb, R extends Result, T extends zzm<R, A>> T zzd(T t) {
        return zze(t);
    }

    public final <A extends com.google.android.gms.common.api.Api.zzb, T extends com.google.android.gms.common.api.internal.zzm<? extends com.google.android.gms.common.api.Result, A>> T zze(T r4) {
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
        r3 = this;
        r0 = r3.zzfxd;	 Catch:{ DeadObjectException -> 0x004a }
        r0 = r0.zzfvq;	 Catch:{ DeadObjectException -> 0x004a }
        r0 = r0.zzfyp;	 Catch:{ DeadObjectException -> 0x004a }
        r0.zzb(r4);	 Catch:{ DeadObjectException -> 0x004a }
        r0 = r3.zzfxd;	 Catch:{ DeadObjectException -> 0x004a }
        r0 = r0.zzfvq;	 Catch:{ DeadObjectException -> 0x004a }
        r1 = r4.zzahm();	 Catch:{ DeadObjectException -> 0x004a }
        r0 = r0.zzfyj;	 Catch:{ DeadObjectException -> 0x004a }
        r0 = r0.get(r1);	 Catch:{ DeadObjectException -> 0x004a }
        r0 = (com.google.android.gms.common.api.Api.zze) r0;	 Catch:{ DeadObjectException -> 0x004a }
        r1 = "Appropriate Api was not requested.";	 Catch:{ DeadObjectException -> 0x004a }
        com.google.android.gms.common.internal.zzbq.checkNotNull(r0, r1);	 Catch:{ DeadObjectException -> 0x004a }
        r1 = r0.isConnected();	 Catch:{ DeadObjectException -> 0x004a }
        if (r1 != 0) goto L_0x003d;	 Catch:{ DeadObjectException -> 0x004a }
    L_0x0024:
        r1 = r3.zzfxd;	 Catch:{ DeadObjectException -> 0x004a }
        r1 = r1.zzfyy;	 Catch:{ DeadObjectException -> 0x004a }
        r2 = r4.zzahm();	 Catch:{ DeadObjectException -> 0x004a }
        r1 = r1.containsKey(r2);	 Catch:{ DeadObjectException -> 0x004a }
        if (r1 == 0) goto L_0x003d;	 Catch:{ DeadObjectException -> 0x004a }
    L_0x0032:
        r0 = new com.google.android.gms.common.api.Status;	 Catch:{ DeadObjectException -> 0x004a }
        r1 = 17;	 Catch:{ DeadObjectException -> 0x004a }
        r0.<init>(r1);	 Catch:{ DeadObjectException -> 0x004a }
        r4.zzu(r0);	 Catch:{ DeadObjectException -> 0x004a }
        goto L_0x0054;	 Catch:{ DeadObjectException -> 0x004a }
    L_0x003d:
        r1 = r0 instanceof com.google.android.gms.common.internal.zzbz;	 Catch:{ DeadObjectException -> 0x004a }
        if (r1 != 0) goto L_0x0045;	 Catch:{ DeadObjectException -> 0x004a }
    L_0x0041:
        r4.zzb(r0);	 Catch:{ DeadObjectException -> 0x004a }
        goto L_0x0054;	 Catch:{ DeadObjectException -> 0x004a }
    L_0x0045:
        com.google.android.gms.common.internal.zzbz.zzanb();	 Catch:{ DeadObjectException -> 0x004a }
        r4 = 0;
        throw r4;
    L_0x004a:
        r0 = r3.zzfxd;
        r1 = new com.google.android.gms.common.api.internal.zzam;
        r1.<init>(r3, r3);
        r0.zza(r1);
    L_0x0054:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzal.zze(com.google.android.gms.common.api.internal.zzm):T");
    }
}
