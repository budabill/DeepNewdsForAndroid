package com.google.android.gms.internal;

public final class zzfmt extends zzflm<zzfmt> implements Cloneable {
    private int zzpzp = -1;
    private int zzpzq = 0;

    private final com.google.android.gms.internal.zzfmt zzbo(com.google.android.gms.internal.zzflj r7) {
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
        r6 = this;
    L_0x0000:
        r0 = r7.zzcxx();
        if (r0 == 0) goto L_0x006f;
    L_0x0006:
        r1 = 8;
        if (r0 == r1) goto L_0x0040;
    L_0x000a:
        r1 = 16;
        if (r0 == r1) goto L_0x0015;
    L_0x000e:
        r0 = super.zza(r7, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x0014:
        return r6;
    L_0x0015:
        r1 = r7.getPosition();
        r2 = r7.zzcya();	 Catch:{ IllegalArgumentException -> 0x0068 }
        r3 = 100;	 Catch:{ IllegalArgumentException -> 0x0068 }
        if (r2 == r3) goto L_0x003d;	 Catch:{ IllegalArgumentException -> 0x0068 }
    L_0x0021:
        switch(r2) {
            case 0: goto L_0x003d;
            case 1: goto L_0x003d;
            case 2: goto L_0x003d;
            case 3: goto L_0x003d;
            case 4: goto L_0x003d;
            case 5: goto L_0x003d;
            case 6: goto L_0x003d;
            case 7: goto L_0x003d;
            case 8: goto L_0x003d;
            case 9: goto L_0x003d;
            case 10: goto L_0x003d;
            case 11: goto L_0x003d;
            case 12: goto L_0x003d;
            case 13: goto L_0x003d;
            case 14: goto L_0x003d;
            case 15: goto L_0x003d;
            case 16: goto L_0x003d;
            default: goto L_0x0024;
        };	 Catch:{ IllegalArgumentException -> 0x0068 }
    L_0x0024:
        r3 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x0068 }
        r4 = 45;	 Catch:{ IllegalArgumentException -> 0x0068 }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0068 }
        r5.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x0068 }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x0068 }
        r2 = " is not a valid enum MobileSubtype";	 Catch:{ IllegalArgumentException -> 0x0068 }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x0068 }
        r2 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x0068 }
        r3.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x0068 }
        throw r3;	 Catch:{ IllegalArgumentException -> 0x0068 }
    L_0x003d:
        r6.zzpzq = r2;	 Catch:{ IllegalArgumentException -> 0x0068 }
        goto L_0x0000;
    L_0x0040:
        r1 = r7.getPosition();
        r2 = r7.zzcya();	 Catch:{ IllegalArgumentException -> 0x0068 }
        switch(r2) {
            case -1: goto L_0x004e;
            case 0: goto L_0x004e;
            case 1: goto L_0x004e;
            case 2: goto L_0x004e;
            case 3: goto L_0x004e;
            case 4: goto L_0x004e;
            case 5: goto L_0x004e;
            case 6: goto L_0x004e;
            case 7: goto L_0x004e;
            case 8: goto L_0x004e;
            case 9: goto L_0x004e;
            case 10: goto L_0x004e;
            case 11: goto L_0x004e;
            case 12: goto L_0x004e;
            case 13: goto L_0x004e;
            case 14: goto L_0x004e;
            case 15: goto L_0x004e;
            case 16: goto L_0x004e;
            case 17: goto L_0x004e;
            default: goto L_0x004b;
        };	 Catch:{ IllegalArgumentException -> 0x0068 }
    L_0x004b:
        r3 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x0068 }
        goto L_0x0051;	 Catch:{ IllegalArgumentException -> 0x0068 }
    L_0x004e:
        r6.zzpzp = r2;	 Catch:{ IllegalArgumentException -> 0x0068 }
        goto L_0x0000;	 Catch:{ IllegalArgumentException -> 0x0068 }
    L_0x0051:
        r4 = 43;	 Catch:{ IllegalArgumentException -> 0x0068 }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0068 }
        r5.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x0068 }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x0068 }
        r2 = " is not a valid enum NetworkType";	 Catch:{ IllegalArgumentException -> 0x0068 }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x0068 }
        r2 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x0068 }
        r3.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x0068 }
        throw r3;	 Catch:{ IllegalArgumentException -> 0x0068 }
    L_0x0068:
        r7.zzmw(r1);
        r6.zza(r7, r0);
        goto L_0x0000;
    L_0x006f:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfmt.zzbo(com.google.android.gms.internal.zzflj):com.google.android.gms.internal.zzfmt");
    }

    private zzfmt zzddh() {
        try {
            return (zzfmt) super.zzdck();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final /* synthetic */ Object clone() {
        return zzddh();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfmt)) {
            return false;
        }
        zzfmt zzfmt = (zzfmt) obj;
        if (this.zzpzp != zzfmt.zzpzp || this.zzpzq != zzfmt.zzpzq) {
            return false;
        }
        zzflo zzflo = this.zzpvl;
        if (zzflo != null) {
            if (!zzflo.isEmpty()) {
                return this.zzpvl.equals(zzfmt.zzpvl);
            }
        }
        zzflo zzflo2 = zzfmt.zzpvl;
        if (zzflo2 != null) {
            if (!zzflo2.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = (((((zzfmt.class.getName().hashCode() + 527) * 31) + this.zzpzp) * 31) + this.zzpzq) * 31;
        zzflo zzflo = this.zzpvl;
        if (zzflo != null) {
            if (!zzflo.isEmpty()) {
                hashCode = this.zzpvl.hashCode();
                return hashCode2 + hashCode;
            }
        }
        hashCode = 0;
        return hashCode2 + hashCode;
    }

    public final /* synthetic */ zzfls zza(zzflj zzflj) {
        zzbo(zzflj);
        return this;
    }

    public final void zza(zzflk zzflk) {
        int i = this.zzpzp;
        if (i != -1) {
            zzflk.zzad(1, i);
        }
        i = this.zzpzq;
        if (i != 0) {
            zzflk.zzad(2, i);
        }
        super.zza(zzflk);
    }

    public final /* synthetic */ zzflm zzdck() {
        return (zzfmt) clone();
    }

    public final /* synthetic */ zzfls zzdcl() {
        return (zzfmt) clone();
    }

    protected final int zzq() {
        int zzq = super.zzq();
        int i = this.zzpzp;
        if (i != -1) {
            zzq += zzflk.zzag(1, i);
        }
        i = this.zzpzq;
        return i != 0 ? zzq + zzflk.zzag(2, i) : zzq;
    }
}
