package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.common.ConnectionResult;

@Hide
public final class zzn extends zze {
    private /* synthetic */ zzd zzgfk;
    private IBinder zzgfo;

    public zzn(zzd zzd, int i, IBinder iBinder, Bundle bundle) {
        this.zzgfk = zzd;
        super(zzd, i, bundle);
        this.zzgfo = iBinder;
    }

    protected final boolean zzama() {
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
        r6 = this;
        r0 = "GmsClient";
        r1 = 0;
        r2 = r6.zzgfo;	 Catch:{ RemoteException -> 0x0088 }
        r2 = r2.getInterfaceDescriptor();	 Catch:{ RemoteException -> 0x0088 }
        r3 = r6.zzgfk;
        r3 = r3.zzhn();
        r3 = r3.equals(r2);
        if (r3 != 0) goto L_0x004b;
    L_0x0015:
        r3 = r6.zzgfk;
        r3 = r3.zzhn();
        r4 = java.lang.String.valueOf(r3);
        r4 = r4.length();
        r4 = r4 + 34;
        r5 = java.lang.String.valueOf(r2);
        r5 = r5.length();
        r4 = r4 + r5;
        r5 = new java.lang.StringBuilder;
        r5.<init>(r4);
        r4 = "service descriptor mismatch: ";
        r5.append(r4);
        r5.append(r3);
        r3 = " vs. ";
        r5.append(r3);
        r5.append(r2);
        r2 = r5.toString();
        android.util.Log.e(r0, r2);
        return r1;
    L_0x004b:
        r0 = r6.zzgfk;
        r2 = r6.zzgfo;
        r0 = r0.zzd(r2);
        if (r0 == 0) goto L_0x0087;
    L_0x0055:
        r2 = r6.zzgfk;
        r3 = 2;
        r4 = 4;
        r2 = r2.zza(r3, r4, r0);
        if (r2 != 0) goto L_0x0068;
    L_0x005f:
        r2 = r6.zzgfk;
        r3 = 3;
        r0 = r2.zza(r3, r4, r0);
        if (r0 == 0) goto L_0x0087;
    L_0x0068:
        r0 = r6.zzgfk;
        r1 = 0;
        r0.zzgff = r1;
        r0 = r6.zzgfk;
        r0 = r0.zzagp();
        r1 = r6.zzgfk;
        r1 = r1.zzgfb;
        if (r1 == 0) goto L_0x0085;
    L_0x007c:
        r1 = r6.zzgfk;
        r1 = r1.zzgfb;
        r1.onConnected(r0);
    L_0x0085:
        r0 = 1;
        return r0;
    L_0x0087:
        return r1;
    L_0x0088:
        r2 = "service probably died";
        android.util.Log.w(r0, r2);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzn.zzama():boolean");
    }

    protected final void zzj(ConnectionResult connectionResult) {
        if (this.zzgfk.zzgfc != null) {
            this.zzgfk.zzgfc.onConnectionFailed(connectionResult);
        }
        this.zzgfk.onConnectionFailed(connectionResult);
    }
}
