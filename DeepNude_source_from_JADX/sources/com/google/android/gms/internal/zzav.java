package com.google.android.gms.internal;

public class zzav extends zzr<String> {
    private final Object mLock = new Object();
    private zzz<String> zzci;

    public zzav(int i, String str, zzz<String> zzz, zzy zzy) {
        super(i, str, zzy);
        this.zzci = zzz;
    }

    protected final com.google.android.gms.internal.zzx<java.lang.String> zza(com.google.android.gms.internal.zzp r4) {
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
        r0 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x000e }
        r1 = r4.data;	 Catch:{ UnsupportedEncodingException -> 0x000e }
        r2 = r4.zzab;	 Catch:{ UnsupportedEncodingException -> 0x000e }
        r2 = com.google.android.gms.internal.zzap.zzb(r2);	 Catch:{ UnsupportedEncodingException -> 0x000e }
        r0.<init>(r1, r2);	 Catch:{ UnsupportedEncodingException -> 0x000e }
        goto L_0x0015;
    L_0x000e:
        r0 = new java.lang.String;
        r1 = r4.data;
        r0.<init>(r1);
    L_0x0015:
        r4 = com.google.android.gms.internal.zzap.zzb(r4);
        r4 = com.google.android.gms.internal.zzx.zza(r0, r4);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzav.zza(com.google.android.gms.internal.zzp):com.google.android.gms.internal.zzx<java.lang.String>");
    }

    protected /* synthetic */ void zza(Object obj) {
        zzh((String) obj);
    }

    protected void zzh(String str) {
        synchronized (this.mLock) {
            zzz zzz = this.zzci;
        }
        if (zzz != null) {
            zzz.zzb(str);
        }
    }
}
