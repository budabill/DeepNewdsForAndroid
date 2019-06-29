package com.google.android.gms.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzfhm {
    private static volatile boolean zzpou = false;
    private static final Class<?> zzpov = zzcze();
    static final zzfhm zzpow = new zzfhm(true);
    private final Map<Object, Object> zzpox;

    zzfhm() {
        this.zzpox = new HashMap();
    }

    private zzfhm(boolean z) {
        this.zzpox = Collections.emptyMap();
    }

    private static java.lang.Class<?> zzcze() {
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
        r0 = "com.google.protobuf.Extension";
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0007 }
        return r0;
    L_0x0007:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfhm.zzcze():java.lang.Class<?>");
    }

    public static zzfhm zzczf() {
        return zzfhl.zzczd();
    }
}
