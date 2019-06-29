package com.google.android.gms.internal;

public final class zzcch extends zzcce<Integer> {
    public zzcch(int i, String str, Integer num) {
        super(0, str, num);
    }

    private final java.lang.Integer zzc(com.google.android.gms.internal.zzccm r4) {
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
        r0 = r3.getKey();	 Catch:{ RemoteException -> 0x001b }
        r1 = r3.zzje();	 Catch:{ RemoteException -> 0x001b }
        r1 = (java.lang.Integer) r1;	 Catch:{ RemoteException -> 0x001b }
        r1 = r1.intValue();	 Catch:{ RemoteException -> 0x001b }
        r2 = r3.getSource();	 Catch:{ RemoteException -> 0x001b }
        r4 = r4.getIntFlagValue(r0, r1, r2);	 Catch:{ RemoteException -> 0x001b }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ RemoteException -> 0x001b }
        return r4;
    L_0x001b:
        r4 = r3.zzje();
        r4 = (java.lang.Integer) r4;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcch.zzc(com.google.android.gms.internal.zzccm):java.lang.Integer");
    }

    public final /* synthetic */ Object zza(zzccm zzccm) {
        return zzc(zzccm);
    }
}
