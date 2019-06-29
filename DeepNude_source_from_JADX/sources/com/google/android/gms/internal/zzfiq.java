package com.google.android.gms.internal;

import com.google.android.gms.internal.zzfhu.zzg;

final class zzfiq implements zzfjw {
    private static final zzfjb zzpqx = new zzfir();
    private final zzfjb zzpqw;

    public zzfiq() {
        this(new zzfis(zzfht.zzczp(), zzdas()));
    }

    private zzfiq(zzfjb zzfjb) {
        zzfhz.zzc(zzfjb, "messageInfoFactory");
        this.zzpqw = zzfjb;
    }

    private static boolean zza(zzfja zzfja) {
        return zzfja.zzdaz() == zzg.zzpqc;
    }

    private static com.google.android.gms.internal.zzfjb zzdas() {
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
        r0 = "com.google.protobuf.DescriptorMessageInfoFactory";
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x0019 }
        r1 = "getInstance";	 Catch:{ Exception -> 0x0019 }
        r2 = 0;	 Catch:{ Exception -> 0x0019 }
        r3 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x0019 }
        r0 = r0.getDeclaredMethod(r1, r3);	 Catch:{ Exception -> 0x0019 }
        r1 = 0;	 Catch:{ Exception -> 0x0019 }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0019 }
        r0 = r0.invoke(r1, r2);	 Catch:{ Exception -> 0x0019 }
        r0 = (com.google.android.gms.internal.zzfjb) r0;	 Catch:{ Exception -> 0x0019 }
        return r0;
    L_0x0019:
        r0 = zzpqx;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfiq.zzdas():com.google.android.gms.internal.zzfjb");
    }

    public final <T> zzfjv<T> zzk(Class<T> cls) {
        zzfjx.zzm(cls);
        zzfja zzj = this.zzpqw.zzj(cls);
        if (zzj.zzdba()) {
            zzfkn zzdbm;
            zzfhn zzczh;
            if (zzfhu.class.isAssignableFrom(cls)) {
                zzdbm = zzfjx.zzdbm();
                zzczh = zzfhp.zzczh();
            } else {
                zzdbm = zzfjx.zzdbk();
                zzczh = zzfhp.zzczi();
            }
            return zzfjh.zza(cls, zzdbm, zzczh, zzj.zzdbb());
        } else if (zzfhu.class.isAssignableFrom(cls)) {
            if (zza(zzj)) {
                zzfjg.zza(cls, zzj, zzfjk.zzdbd(), zzfim.zzdar(), zzfjx.zzdbm(), zzfhp.zzczh(), zzfiz.zzdax());
                throw null;
            }
            zzfjg.zza(cls, zzj, zzfjk.zzdbd(), zzfim.zzdar(), zzfjx.zzdbm(), null, zzfiz.zzdax());
            throw null;
        } else if (zza(zzj)) {
            zzfjg.zza(cls, zzj, zzfjk.zzdbc(), zzfim.zzdaq(), zzfjx.zzdbk(), zzfhp.zzczi(), zzfiz.zzdaw());
            throw null;
        } else {
            zzfjg.zza(cls, zzj, zzfjk.zzdbc(), zzfim.zzdaq(), zzfjx.zzdbl(), null, zzfiz.zzdaw());
            throw null;
        }
    }
}
