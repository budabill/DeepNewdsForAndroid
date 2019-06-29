package com.google.android.gms.internal;

public final class zzcci extends zzcce<Long> {
    public zzcci(int i, String str, Long l) {
        super(0, str, l);
    }

    private final java.lang.Long zzd(com.google.android.gms.internal.zzccm r5) {
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
        r0 = r4.getKey();	 Catch:{ RemoteException -> 0x001b }
        r1 = r4.zzje();	 Catch:{ RemoteException -> 0x001b }
        r1 = (java.lang.Long) r1;	 Catch:{ RemoteException -> 0x001b }
        r1 = r1.longValue();	 Catch:{ RemoteException -> 0x001b }
        r3 = r4.getSource();	 Catch:{ RemoteException -> 0x001b }
        r0 = r5.getLongFlagValue(r0, r1, r3);	 Catch:{ RemoteException -> 0x001b }
        r5 = java.lang.Long.valueOf(r0);	 Catch:{ RemoteException -> 0x001b }
        return r5;
    L_0x001b:
        r5 = r4.zzje();
        r5 = (java.lang.Long) r5;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcci.zzd(com.google.android.gms.internal.zzccm):java.lang.Long");
    }

    public final /* synthetic */ Object zza(zzccm zzccm) {
        return zzd(zzccm);
    }
}
