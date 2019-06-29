package com.google.android.gms.internal;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzfjn {
    private static final zzfjn zzprm = new zzfjn();
    private final zzfjw zzprn;
    private final ConcurrentMap<Class<?>, zzfjv<?>> zzpro = new ConcurrentHashMap();

    private zzfjn() {
        String[] strArr = new String[]{"com.google.protobuf.AndroidProto3SchemaFactory"};
        zzfjw zzfjw = null;
        for (int i = 0; i <= 0; i++) {
            zzfjw = zzua(strArr[0]);
            if (zzfjw != null) {
                break;
            }
        }
        if (zzfjw == null) {
            zzfjw = new zzfiq();
        }
        this.zzprn = zzfjw;
    }

    public static zzfjn zzdbf() {
        return zzprm;
    }

    private static com.google.android.gms.internal.zzfjw zzua(java.lang.String r2) {
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
        r2 = java.lang.Class.forName(r2);	 Catch:{ Throwable -> 0x0014 }
        r0 = 0;	 Catch:{ Throwable -> 0x0014 }
        r1 = new java.lang.Class[r0];	 Catch:{ Throwable -> 0x0014 }
        r2 = r2.getConstructor(r1);	 Catch:{ Throwable -> 0x0014 }
        r0 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x0014 }
        r2 = r2.newInstance(r0);	 Catch:{ Throwable -> 0x0014 }
        r2 = (com.google.android.gms.internal.zzfjw) r2;	 Catch:{ Throwable -> 0x0014 }
        return r2;
    L_0x0014:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfjn.zzua(java.lang.String):com.google.android.gms.internal.zzfjw");
    }

    public final <T> zzfjv<T> zzl(Class<T> cls) {
        String str = "messageType";
        zzfhz.zzc(cls, str);
        zzfjv<T> zzfjv = (zzfjv) this.zzpro.get(cls);
        if (zzfjv != null) {
            return zzfjv;
        }
        zzfjv = this.zzprn.zzk(cls);
        zzfhz.zzc(cls, str);
        zzfhz.zzc(zzfjv, "schema");
        zzfjv<T> zzfjv2 = (zzfjv) this.zzpro.putIfAbsent(cls, zzfjv);
        return zzfjv2 != null ? zzfjv2 : zzfjv;
    }
}
