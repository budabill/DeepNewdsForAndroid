package com.google.android.gms.internal;

public class zzfik {
    private static final zzfhm zzpns = zzfhm.zzczf();
    private zzfgs zzpqq;
    private volatile zzfjc zzpqr;
    private volatile zzfgs zzpqs;

    private com.google.android.gms.internal.zzfjc zzj(com.google.android.gms.internal.zzfjc r2) {
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
        r1 = this;
        r0 = r1.zzpqr;
        if (r0 != 0) goto L_0x001c;
    L_0x0004:
        monitor-enter(r1);
        r0 = r1.zzpqr;	 Catch:{ all -> 0x0019 }
        if (r0 == 0) goto L_0x000b;	 Catch:{ all -> 0x0019 }
    L_0x0009:
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        goto L_0x001c;
    L_0x000b:
        r1.zzpqr = r2;	 Catch:{ zzfie -> 0x0012 }
        r0 = com.google.android.gms.internal.zzfgs.zzpnw;	 Catch:{ zzfie -> 0x0012 }
        r1.zzpqs = r0;	 Catch:{ zzfie -> 0x0012 }
        goto L_0x0009;
    L_0x0012:
        r1.zzpqr = r2;	 Catch:{ all -> 0x0019 }
        r2 = com.google.android.gms.internal.zzfgs.zzpnw;	 Catch:{ all -> 0x0019 }
        r1.zzpqs = r2;	 Catch:{ all -> 0x0019 }
        goto L_0x0009;	 Catch:{ all -> 0x0019 }
    L_0x0019:
        r2 = move-exception;	 Catch:{ all -> 0x0019 }
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        throw r2;
    L_0x001c:
        r2 = r1.zzpqr;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfik.zzj(com.google.android.gms.internal.zzfjc):com.google.android.gms.internal.zzfjc");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfik)) {
            return false;
        }
        zzfik zzfik = (zzfik) obj;
        zzfje zzfje = this.zzpqr;
        zzfje zzfje2 = zzfik.zzpqr;
        return (zzfje == null && zzfje2 == null) ? toByteString().equals(zzfik.toByteString()) : (zzfje == null || zzfje2 == null) ? zzfje != null ? zzfje.equals(zzfik.zzj(zzfje.zzczu())) : zzj(zzfje2.zzczu()).equals(zzfje2) : zzfje.equals(zzfje2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzfgs toByteString() {
        if (this.zzpqs != null) {
            return this.zzpqs;
        }
        synchronized (this) {
            if (this.zzpqs != null) {
                zzfgs zzfgs = this.zzpqs;
                return zzfgs;
            }
            this.zzpqs = this.zzpqr == null ? zzfgs.zzpnw : this.zzpqr.toByteString();
            zzfgs = this.zzpqs;
            return zzfgs;
        }
    }

    public final int zzhs() {
        return this.zzpqs != null ? this.zzpqs.size() : this.zzpqr != null ? this.zzpqr.zzhs() : 0;
    }

    public final zzfjc zzk(zzfjc zzfjc) {
        zzfjc zzfjc2 = this.zzpqr;
        this.zzpqq = null;
        this.zzpqs = null;
        this.zzpqr = zzfjc;
        return zzfjc2;
    }
}
