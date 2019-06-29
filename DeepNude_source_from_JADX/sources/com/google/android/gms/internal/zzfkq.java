package com.google.android.gms.internal;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zzfkq {
    private static final Logger logger = Logger.getLogger(zzfkq.class.getName());
    private static final Unsafe zzmdw = zzdcf();
    private static final Class<?> zzpnt = zzfgo.zzcxn();
    private static final boolean zzpop = zzdcg();
    private static final boolean zzptd = zzp(Long.TYPE);
    private static final boolean zzpte = zzp(Integer.TYPE);
    private static final zzd zzptf;
    private static final boolean zzptg = zzdch();
    private static final long zzpth = ((long) zzn(byte[].class));
    private static final long zzpti = ((long) zzn(boolean[].class));
    private static final long zzptj = ((long) zzo(boolean[].class));
    private static final long zzptk = ((long) zzn(int[].class));
    private static final long zzptl = ((long) zzo(int[].class));
    private static final long zzptm = ((long) zzn(long[].class));
    private static final long zzptn = ((long) zzo(long[].class));
    private static final long zzpto = ((long) zzn(float[].class));
    private static final long zzptp = ((long) zzo(float[].class));
    private static final long zzptq = ((long) zzn(double[].class));
    private static final long zzptr = ((long) zzo(double[].class));
    private static final long zzpts = ((long) zzn(Object[].class));
    private static final long zzptt = ((long) zzo(Object[].class));
    private static final long zzptu;
    private static final boolean zzptv = (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);

    static abstract class zzd {
        Unsafe zzptw;

        zzd(Unsafe unsafe) {
            this.zzptw = unsafe;
        }

        public final int zza(Object obj, long j) {
            return this.zzptw.getInt(obj, j);
        }

        public abstract void zze(Object obj, long j, byte b);

        public abstract byte zzf(Object obj, long j);
    }

    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzfkq.zzptv) {
                zzfkq.zza(obj, j, b);
            } else {
                zzfkq.zzb(obj, j, b);
            }
        }

        public final byte zzf(Object obj, long j) {
            return zzfkq.zzptv ? zzfkq.zzb(obj, j) : zzfkq.zzc(obj, j);
        }
    }

    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzfkq.zzptv) {
                zzfkq.zza(obj, j, b);
            } else {
                zzfkq.zzb(obj, j, b);
            }
        }

        public final byte zzf(Object obj, long j) {
            return zzfkq.zzptv ? zzfkq.zzb(obj, j) : zzfkq.zzc(obj, j);
        }
    }

    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zze(Object obj, long j, byte b) {
            this.zzptw.putByte(obj, j, b);
        }

        public final byte zzf(Object obj, long j) {
            return this.zzptw.getByte(obj, j);
        }
    }

    static {
        Field zza;
        long objectFieldOffset;
        zzd zzd = null;
        if (zzmdw != null) {
            if (!zzfgo.zzcxm()) {
                zzd = new zzc(zzmdw);
            } else if (zzptd) {
                zzd = new zzb(zzmdw);
            } else if (zzpte) {
                zzd = new zza(zzmdw);
            }
        }
        zzptf = zzd;
        if (zzfgo.zzcxm()) {
            zza = zza(Buffer.class, "effectiveDirectAddress");
            if (zza != null) {
                if (zza != null) {
                    zzd = zzptf;
                    if (zzd == null) {
                        objectFieldOffset = zzd.zzptw.objectFieldOffset(zza);
                        zzptu = objectFieldOffset;
                    }
                }
                objectFieldOffset = -1;
                zzptu = objectFieldOffset;
                if (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN) {
                }
            }
        }
        zza = zza(Buffer.class, "address");
        if (zza != null) {
            zzd = zzptf;
            if (zzd == null) {
                objectFieldOffset = zzd.zzptw.objectFieldOffset(zza);
                zzptu = objectFieldOffset;
                if (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN) {
                }
            }
        }
        objectFieldOffset = -1;
        zzptu = objectFieldOffset;
        if (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN) {
        }
    }

    private zzfkq() {
    }

    static int zza(Object obj, long j) {
        return zzptf.zza(obj, j);
    }

    private static java.lang.reflect.Field zza(java.lang.Class<?> r0, java.lang.String r1) {
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
        r0 = r0.getDeclaredField(r1);	 Catch:{ Throwable -> 0x0009 }
        r1 = 1;	 Catch:{ Throwable -> 0x0009 }
        r0.setAccessible(r1);	 Catch:{ Throwable -> 0x0009 }
        goto L_0x000a;
    L_0x0009:
        r0 = 0;
    L_0x000a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfkq.zza(java.lang.Class, java.lang.String):java.lang.reflect.Field");
    }

    private static void zza(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = ((((int) j) ^ -1) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zza(obj, j2) & ((255 << i) ^ -1)));
    }

    private static void zza(Object obj, long j, int i) {
        zzptf.zzptw.putInt(obj, j, i);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zzptf.zze(bArr, zzpth + j, b);
    }

    private static byte zzb(Object obj, long j) {
        return (byte) (zza(obj, -4 & j) >>> ((int) (((j ^ -1) & 3) << 3)));
    }

    static byte zzb(byte[] bArr, long j) {
        return zzptf.zzf(bArr, zzpth + j);
    }

    private static void zzb(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zza(obj, j2) & ((255 << i) ^ -1)));
    }

    private static byte zzc(Object obj, long j) {
        return (byte) (zza(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    static boolean zzdcd() {
        return zzpop;
    }

    static boolean zzdce() {
        return zzptg;
    }

    private static sun.misc.Unsafe zzdcf() {
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
        r0 = new com.google.android.gms.internal.zzfkr;	 Catch:{ Throwable -> 0x000c }
        r0.<init>();	 Catch:{ Throwable -> 0x000c }
        r0 = java.security.AccessController.doPrivileged(r0);	 Catch:{ Throwable -> 0x000c }
        r0 = (sun.misc.Unsafe) r0;	 Catch:{ Throwable -> 0x000c }
        goto L_0x000d;
    L_0x000c:
        r0 = 0;
    L_0x000d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfkq.zzdcf():sun.misc.Unsafe");
    }

    private static boolean zzdcg() {
        Unsafe unsafe = zzmdw;
        if (unsafe == null) {
            return false;
        }
        try {
            Class cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls.getMethod("arrayIndexScale", new Class[]{Class.class});
            cls.getMethod("getInt", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});
            cls.getMethod("getObject", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});
            if (zzfgo.zzcxm()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});
            cls.getMethod("getBoolean", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});
            cls.getMethod("getFloat", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putFloat", new Class[]{Object.class, Long.TYPE, Float.TYPE});
            cls.getMethod("getDouble", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putDouble", new Class[]{Object.class, Long.TYPE, Double.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 71);
            stringBuilder.append("platform method missing - proto runtime falling back to safer methods: ");
            stringBuilder.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", stringBuilder.toString());
            return false;
        }
    }

    private static boolean zzdch() {
        String str = "copyMemory";
        String str2 = "getLong";
        Unsafe unsafe = zzmdw;
        if (unsafe == null) {
            return false;
        }
        try {
            Class cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod(str2, new Class[]{Object.class, Long.TYPE});
            if (zzfgo.zzcxm()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Long.TYPE});
            cls.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
            cls.getMethod("getInt", new Class[]{Long.TYPE});
            cls.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});
            cls.getMethod(str2, new Class[]{Long.TYPE});
            cls.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});
            cls.getMethod(str, new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
            cls.getMethod(str, new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger = logger;
            Level level = Level.WARNING;
            str = String.valueOf(th);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 71);
            stringBuilder.append("platform method missing - proto runtime falling back to safer methods: ");
            stringBuilder.append(str);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", stringBuilder.toString());
            return false;
        }
    }

    private static int zzn(Class<?> cls) {
        return zzpop ? zzptf.zzptw.arrayBaseOffset(cls) : -1;
    }

    private static int zzo(Class<?> cls) {
        return zzpop ? zzptf.zzptw.arrayIndexScale(cls) : -1;
    }

    private static boolean zzp(java.lang.Class<?> r9) {
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
        r0 = com.google.android.gms.internal.zzfgo.zzcxm();
        r1 = 0;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = zzpnt;	 Catch:{ Throwable -> 0x008b }
        r2 = "peekLong";	 Catch:{ Throwable -> 0x008b }
        r3 = 2;	 Catch:{ Throwable -> 0x008b }
        r4 = new java.lang.Class[r3];	 Catch:{ Throwable -> 0x008b }
        r4[r1] = r9;	 Catch:{ Throwable -> 0x008b }
        r5 = java.lang.Boolean.TYPE;	 Catch:{ Throwable -> 0x008b }
        r6 = 1;	 Catch:{ Throwable -> 0x008b }
        r4[r6] = r5;	 Catch:{ Throwable -> 0x008b }
        r0.getMethod(r2, r4);	 Catch:{ Throwable -> 0x008b }
        r2 = "pokeLong";	 Catch:{ Throwable -> 0x008b }
        r4 = 3;	 Catch:{ Throwable -> 0x008b }
        r5 = new java.lang.Class[r4];	 Catch:{ Throwable -> 0x008b }
        r5[r1] = r9;	 Catch:{ Throwable -> 0x008b }
        r7 = java.lang.Long.TYPE;	 Catch:{ Throwable -> 0x008b }
        r5[r6] = r7;	 Catch:{ Throwable -> 0x008b }
        r7 = java.lang.Boolean.TYPE;	 Catch:{ Throwable -> 0x008b }
        r5[r3] = r7;	 Catch:{ Throwable -> 0x008b }
        r0.getMethod(r2, r5);	 Catch:{ Throwable -> 0x008b }
        r2 = "pokeInt";	 Catch:{ Throwable -> 0x008b }
        r5 = new java.lang.Class[r4];	 Catch:{ Throwable -> 0x008b }
        r5[r1] = r9;	 Catch:{ Throwable -> 0x008b }
        r7 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x008b }
        r5[r6] = r7;	 Catch:{ Throwable -> 0x008b }
        r7 = java.lang.Boolean.TYPE;	 Catch:{ Throwable -> 0x008b }
        r5[r3] = r7;	 Catch:{ Throwable -> 0x008b }
        r0.getMethod(r2, r5);	 Catch:{ Throwable -> 0x008b }
        r2 = "peekInt";	 Catch:{ Throwable -> 0x008b }
        r5 = new java.lang.Class[r3];	 Catch:{ Throwable -> 0x008b }
        r5[r1] = r9;	 Catch:{ Throwable -> 0x008b }
        r7 = java.lang.Boolean.TYPE;	 Catch:{ Throwable -> 0x008b }
        r5[r6] = r7;	 Catch:{ Throwable -> 0x008b }
        r0.getMethod(r2, r5);	 Catch:{ Throwable -> 0x008b }
        r2 = "pokeByte";	 Catch:{ Throwable -> 0x008b }
        r5 = new java.lang.Class[r3];	 Catch:{ Throwable -> 0x008b }
        r5[r1] = r9;	 Catch:{ Throwable -> 0x008b }
        r7 = java.lang.Byte.TYPE;	 Catch:{ Throwable -> 0x008b }
        r5[r6] = r7;	 Catch:{ Throwable -> 0x008b }
        r0.getMethod(r2, r5);	 Catch:{ Throwable -> 0x008b }
        r2 = "peekByte";	 Catch:{ Throwable -> 0x008b }
        r5 = new java.lang.Class[r6];	 Catch:{ Throwable -> 0x008b }
        r5[r1] = r9;	 Catch:{ Throwable -> 0x008b }
        r0.getMethod(r2, r5);	 Catch:{ Throwable -> 0x008b }
        r2 = "pokeByteArray";	 Catch:{ Throwable -> 0x008b }
        r5 = 4;	 Catch:{ Throwable -> 0x008b }
        r7 = new java.lang.Class[r5];	 Catch:{ Throwable -> 0x008b }
        r7[r1] = r9;	 Catch:{ Throwable -> 0x008b }
        r8 = byte[].class;	 Catch:{ Throwable -> 0x008b }
        r7[r6] = r8;	 Catch:{ Throwable -> 0x008b }
        r8 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x008b }
        r7[r3] = r8;	 Catch:{ Throwable -> 0x008b }
        r8 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x008b }
        r7[r4] = r8;	 Catch:{ Throwable -> 0x008b }
        r0.getMethod(r2, r7);	 Catch:{ Throwable -> 0x008b }
        r2 = "peekByteArray";	 Catch:{ Throwable -> 0x008b }
        r5 = new java.lang.Class[r5];	 Catch:{ Throwable -> 0x008b }
        r5[r1] = r9;	 Catch:{ Throwable -> 0x008b }
        r9 = byte[].class;	 Catch:{ Throwable -> 0x008b }
        r5[r6] = r9;	 Catch:{ Throwable -> 0x008b }
        r9 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x008b }
        r5[r3] = r9;	 Catch:{ Throwable -> 0x008b }
        r9 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x008b }
        r5[r4] = r9;	 Catch:{ Throwable -> 0x008b }
        r0.getMethod(r2, r5);	 Catch:{ Throwable -> 0x008b }
        return r6;
    L_0x008b:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfkq.zzp(java.lang.Class):boolean");
    }
}
