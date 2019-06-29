package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzm;
import com.google.android.gms.common.internal.zzr;

public final class zzcyt extends zzab<zzcyr> implements zzcyj {
    private final zzr zzfwf;
    private Integer zzgft;
    private final boolean zzklw;
    private final Bundle zzklx;

    private zzcyt(Context context, Looper looper, boolean z, zzr zzr, Bundle bundle, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, zzr, connectionCallbacks, onConnectionFailedListener);
        this.zzklw = true;
        this.zzfwf = zzr;
        this.zzklx = bundle;
        this.zzgft = zzr.zzamm();
    }

    public zzcyt(Context context, Looper looper, boolean z, zzr zzr, zzcyk zzcyk, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, true, zzr, zza(zzr), connectionCallbacks, onConnectionFailedListener);
    }

    public static Bundle zza(zzr zzr) {
        zzcyk zzaml = zzr.zzaml();
        Integer zzamm = zzr.zzamm();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", zzr.getAccount());
        if (zzamm != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", zzamm.intValue());
        }
        if (zzaml != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", zzaml.zzbeu());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", zzaml.isIdTokenRequested());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", zzaml.getServerClientId());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", zzaml.zzbev());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", zzaml.zzbew());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", zzaml.zzbex());
            if (zzaml.zzbey() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", zzaml.zzbey().longValue());
            }
            if (zzaml.zzbez() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", zzaml.zzbez().longValue());
            }
        }
        return bundle;
    }

    public final void connect() {
        zza(new zzm(this));
    }

    public final void zza(com.google.android.gms.common.internal.zzan r3, boolean r4) {
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
        r2 = this;
        r0 = r2.zzalw();	 Catch:{ RemoteException -> 0x0010 }
        r0 = (com.google.android.gms.internal.zzcyr) r0;	 Catch:{ RemoteException -> 0x0010 }
        r1 = r2.zzgft;	 Catch:{ RemoteException -> 0x0010 }
        r1 = r1.intValue();	 Catch:{ RemoteException -> 0x0010 }
        r0.zza(r3, r1, r4);	 Catch:{ RemoteException -> 0x0010 }
        return;
    L_0x0010:
        r3 = "SignInClientImpl";
        r4 = "Remote service probably died when saveDefaultAccount is called";
        android.util.Log.w(r3, r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcyt.zza(com.google.android.gms.common.internal.zzan, boolean):void");
    }

    public final void zza(com.google.android.gms.internal.zzcyp r5) {
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
        r4 = this;
        r0 = "Expecting a valid ISignInCallbacks";
        com.google.android.gms.common.internal.zzbq.checkNotNull(r5, r0);
        r0 = r4.zzfwf;	 Catch:{ RemoteException -> 0x003c }
        r0 = r0.zzamd();	 Catch:{ RemoteException -> 0x003c }
        r1 = 0;	 Catch:{ RemoteException -> 0x003c }
        r2 = "<<default account>>";	 Catch:{ RemoteException -> 0x003c }
        r3 = r0.name;	 Catch:{ RemoteException -> 0x003c }
        r2 = r2.equals(r3);	 Catch:{ RemoteException -> 0x003c }
        if (r2 == 0) goto L_0x0022;	 Catch:{ RemoteException -> 0x003c }
    L_0x0016:
        r1 = r4.getContext();	 Catch:{ RemoteException -> 0x003c }
        r1 = com.google.android.gms.auth.api.signin.internal.zzaa.zzbs(r1);	 Catch:{ RemoteException -> 0x003c }
        r1 = r1.zzacx();	 Catch:{ RemoteException -> 0x003c }
    L_0x0022:
        r2 = new com.google.android.gms.common.internal.zzbr;	 Catch:{ RemoteException -> 0x003c }
        r3 = r4.zzgft;	 Catch:{ RemoteException -> 0x003c }
        r3 = r3.intValue();	 Catch:{ RemoteException -> 0x003c }
        r2.<init>(r0, r3, r1);	 Catch:{ RemoteException -> 0x003c }
        r0 = r4.zzalw();	 Catch:{ RemoteException -> 0x003c }
        r0 = (com.google.android.gms.internal.zzcyr) r0;	 Catch:{ RemoteException -> 0x003c }
        r1 = new com.google.android.gms.internal.zzcyu;	 Catch:{ RemoteException -> 0x003c }
        r1.<init>(r2);	 Catch:{ RemoteException -> 0x003c }
        r0.zza(r1, r5);	 Catch:{ RemoteException -> 0x003c }
        return;
    L_0x003c:
        r0 = move-exception;
        r1 = "SignInClientImpl";
        r2 = "Remote service probably died when signIn is called";
        android.util.Log.w(r1, r2);
        r2 = new com.google.android.gms.internal.zzcyw;	 Catch:{ RemoteException -> 0x004f }
        r3 = 8;	 Catch:{ RemoteException -> 0x004f }
        r2.<init>(r3);	 Catch:{ RemoteException -> 0x004f }
        r5.zzb(r2);	 Catch:{ RemoteException -> 0x004f }
        return;
    L_0x004f:
        r5 = "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.";
        android.util.Log.wtf(r1, r5, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcyt.zza(com.google.android.gms.internal.zzcyp):void");
    }

    protected final Bundle zzabt() {
        if (!getContext().getPackageName().equals(this.zzfwf.zzami())) {
            this.zzklx.putString("com.google.android.gms.signin.internal.realClientPackageName", this.zzfwf.zzami());
        }
        return this.zzklx;
    }

    public final boolean zzacc() {
        return this.zzklw;
    }

    public final void zzbet() {
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
        r2 = this;
        r0 = r2.zzalw();	 Catch:{ RemoteException -> 0x0010 }
        r0 = (com.google.android.gms.internal.zzcyr) r0;	 Catch:{ RemoteException -> 0x0010 }
        r1 = r2.zzgft;	 Catch:{ RemoteException -> 0x0010 }
        r1 = r1.intValue();	 Catch:{ RemoteException -> 0x0010 }
        r0.zzev(r1);	 Catch:{ RemoteException -> 0x0010 }
        return;
    L_0x0010:
        r0 = "SignInClientImpl";
        r1 = "Remote service probably died when clearAccountFromSessionStore is called";
        android.util.Log.w(r0, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcyt.zzbet():void");
    }

    protected final /* synthetic */ IInterface zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return queryLocalInterface instanceof zzcyr ? (zzcyr) queryLocalInterface : new zzcys(iBinder);
    }

    protected final String zzhm() {
        return "com.google.android.gms.signin.service.START";
    }

    protected final String zzhn() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }
}
