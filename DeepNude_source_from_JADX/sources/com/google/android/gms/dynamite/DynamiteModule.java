package com.google.android.gms.dynamite;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.zzf;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import java.lang.reflect.InvocationTargetException;

@Hide
public final class DynamiteModule {
    private static Boolean zzhdc;
    private static zzk zzhdd;
    private static zzm zzhde;
    private static String zzhdf;
    private static final ThreadLocal<zza> zzhdg = new ThreadLocal();
    private static final zzi zzhdh = new zza();
    public static final zzd zzhdi = new zzb();
    private static zzd zzhdj = new zzc();
    public static final zzd zzhdk = new zzd();
    public static final zzd zzhdl = new zze();
    public static final zzd zzhdm = new zzf();
    public static final zzd zzhdn = new zzg();
    private final Context zzhdo;

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    static class zza {
        public Cursor zzhdp;

        private zza() {
        }
    }

    public static class zzc extends Exception {
        private zzc(String str) {
            super(str);
        }

        private zzc(String str, Throwable th) {
            super(str, th);
        }
    }

    public interface zzd {
        zzj zza(Context context, String str, zzi zzi);
    }

    static class zzb implements zzi {
        private final int zzhdq;
        private final int zzhdr = 0;

        public zzb(int i, int i2) {
            this.zzhdq = i;
        }

        public final int zzc(Context context, String str, boolean z) {
            return 0;
        }

        public final int zzx(Context context, String str) {
            return this.zzhdq;
        }
    }

    private DynamiteModule(Context context) {
        zzbq.checkNotNull(context);
        this.zzhdo = context;
    }

    private static Context zza(Context context, String str, int i, Cursor cursor, zzm zzm) {
        try {
            return (Context) zzn.zzy(zzm.zza(zzn.zzz(context), str, i, zzn.zzz(cursor)));
        } catch (Exception e) {
            str = "Failed to load DynamiteLoader: ";
            String valueOf = String.valueOf(e.toString());
            Log.e("DynamiteModule", valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.dynamite.DynamiteModule zza(android.content.Context r10, com.google.android.gms.dynamite.DynamiteModule.zzd r11, java.lang.String r12) {
        /*
        r0 = ":";
        r1 = "DynamiteModule";
        r2 = zzhdg;
        r2 = r2.get();
        r2 = (com.google.android.gms.dynamite.DynamiteModule.zza) r2;
        r3 = new com.google.android.gms.dynamite.DynamiteModule$zza;
        r4 = 0;
        r3.<init>();
        r5 = zzhdg;
        r5.set(r3);
        r5 = zzhdh;	 Catch:{ all -> 0x011f }
        r5 = r11.zza(r10, r12, r5);	 Catch:{ all -> 0x011f }
        r6 = r5.zzhds;	 Catch:{ all -> 0x011f }
        r7 = r5.zzhdt;	 Catch:{ all -> 0x011f }
        r8 = java.lang.String.valueOf(r12);	 Catch:{ all -> 0x011f }
        r8 = r8.length();	 Catch:{ all -> 0x011f }
        r8 = r8 + 68;
        r9 = java.lang.String.valueOf(r12);	 Catch:{ all -> 0x011f }
        r9 = r9.length();	 Catch:{ all -> 0x011f }
        r8 = r8 + r9;
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x011f }
        r9.<init>(r8);	 Catch:{ all -> 0x011f }
        r8 = "Considering local module ";
        r9.append(r8);	 Catch:{ all -> 0x011f }
        r9.append(r12);	 Catch:{ all -> 0x011f }
        r9.append(r0);	 Catch:{ all -> 0x011f }
        r9.append(r6);	 Catch:{ all -> 0x011f }
        r6 = " and remote module ";
        r9.append(r6);	 Catch:{ all -> 0x011f }
        r9.append(r12);	 Catch:{ all -> 0x011f }
        r9.append(r0);	 Catch:{ all -> 0x011f }
        r9.append(r7);	 Catch:{ all -> 0x011f }
        r0 = r9.toString();	 Catch:{ all -> 0x011f }
        android.util.Log.i(r1, r0);	 Catch:{ all -> 0x011f }
        r0 = r5.zzhdu;	 Catch:{ all -> 0x011f }
        if (r0 == 0) goto L_0x00f5;
    L_0x0060:
        r0 = r5.zzhdu;	 Catch:{ all -> 0x011f }
        r6 = -1;
        if (r0 != r6) goto L_0x0069;
    L_0x0065:
        r0 = r5.zzhds;	 Catch:{ all -> 0x011f }
        if (r0 == 0) goto L_0x00f5;
    L_0x0069:
        r0 = r5.zzhdu;	 Catch:{ all -> 0x011f }
        r7 = 1;
        if (r0 != r7) goto L_0x0072;
    L_0x006e:
        r0 = r5.zzhdt;	 Catch:{ all -> 0x011f }
        if (r0 == 0) goto L_0x00f5;
    L_0x0072:
        r0 = r5.zzhdu;	 Catch:{ all -> 0x011f }
        if (r0 != r6) goto L_0x0087;
    L_0x0076:
        r10 = zzz(r10, r12);	 Catch:{ all -> 0x011f }
        r11 = r3.zzhdp;
        if (r11 == 0) goto L_0x0081;
    L_0x007e:
        r11.close();
    L_0x0081:
        r11 = zzhdg;
        r11.set(r2);
        return r10;
    L_0x0087:
        r0 = r5.zzhdu;	 Catch:{ all -> 0x011f }
        if (r0 != r7) goto L_0x00da;
    L_0x008b:
        r0 = r5.zzhdt;	 Catch:{ zzc -> 0x0096 }
        r10 = zza(r10, r12, r0);	 Catch:{ zzc -> 0x0096 }
        r11 = r3.zzhdp;
        if (r11 == 0) goto L_0x0081;
    L_0x0095:
        goto L_0x007e;
    L_0x0096:
        r0 = move-exception;
        r7 = "Failed to load remote module: ";
        r8 = r0.getMessage();	 Catch:{ all -> 0x011f }
        r8 = java.lang.String.valueOf(r8);	 Catch:{ all -> 0x011f }
        r9 = r8.length();	 Catch:{ all -> 0x011f }
        if (r9 == 0) goto L_0x00ac;
    L_0x00a7:
        r7 = r7.concat(r8);	 Catch:{ all -> 0x011f }
        goto L_0x00b2;
    L_0x00ac:
        r8 = new java.lang.String;	 Catch:{ all -> 0x011f }
        r8.<init>(r7);	 Catch:{ all -> 0x011f }
        r7 = r8;
    L_0x00b2:
        android.util.Log.w(r1, r7);	 Catch:{ all -> 0x011f }
        r1 = r5.zzhds;	 Catch:{ all -> 0x011f }
        if (r1 == 0) goto L_0x00d2;
    L_0x00b9:
        r1 = new com.google.android.gms.dynamite.DynamiteModule$zzb;	 Catch:{ all -> 0x011f }
        r5 = r5.zzhds;	 Catch:{ all -> 0x011f }
        r7 = 0;
        r1.<init>(r5, r7);	 Catch:{ all -> 0x011f }
        r11 = r11.zza(r10, r12, r1);	 Catch:{ all -> 0x011f }
        r11 = r11.zzhdu;	 Catch:{ all -> 0x011f }
        if (r11 != r6) goto L_0x00d2;
    L_0x00c9:
        r10 = zzz(r10, r12);	 Catch:{ all -> 0x011f }
        r11 = r3.zzhdp;
        if (r11 == 0) goto L_0x0081;
    L_0x00d1:
        goto L_0x007e;
    L_0x00d2:
        r10 = new com.google.android.gms.dynamite.DynamiteModule$zzc;	 Catch:{ all -> 0x011f }
        r11 = "Remote load failed. No local fallback found.";
        r10.<init>(r11, r0);	 Catch:{ all -> 0x011f }
        throw r10;	 Catch:{ all -> 0x011f }
    L_0x00da:
        r10 = new com.google.android.gms.dynamite.DynamiteModule$zzc;	 Catch:{ all -> 0x011f }
        r11 = r5.zzhdu;	 Catch:{ all -> 0x011f }
        r12 = 47;
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x011f }
        r0.<init>(r12);	 Catch:{ all -> 0x011f }
        r12 = "VersionPolicy returned invalid code:";
        r0.append(r12);	 Catch:{ all -> 0x011f }
        r0.append(r11);	 Catch:{ all -> 0x011f }
        r11 = r0.toString();	 Catch:{ all -> 0x011f }
        r10.<init>(r11);	 Catch:{ all -> 0x011f }
        throw r10;	 Catch:{ all -> 0x011f }
    L_0x00f5:
        r10 = new com.google.android.gms.dynamite.DynamiteModule$zzc;	 Catch:{ all -> 0x011f }
        r11 = r5.zzhds;	 Catch:{ all -> 0x011f }
        r12 = r5.zzhdt;	 Catch:{ all -> 0x011f }
        r0 = 91;
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x011f }
        r1.<init>(r0);	 Catch:{ all -> 0x011f }
        r0 = "No acceptable module found. Local version is ";
        r1.append(r0);	 Catch:{ all -> 0x011f }
        r1.append(r11);	 Catch:{ all -> 0x011f }
        r11 = " and remote version is ";
        r1.append(r11);	 Catch:{ all -> 0x011f }
        r1.append(r12);	 Catch:{ all -> 0x011f }
        r11 = ".";
        r1.append(r11);	 Catch:{ all -> 0x011f }
        r11 = r1.toString();	 Catch:{ all -> 0x011f }
        r10.<init>(r11);	 Catch:{ all -> 0x011f }
        throw r10;	 Catch:{ all -> 0x011f }
    L_0x011f:
        r10 = move-exception;
        r11 = r3.zzhdp;
        if (r11 == 0) goto L_0x0127;
    L_0x0124:
        r11.close();
    L_0x0127:
        r11 = zzhdg;
        r11.set(r2);
        goto L_0x012e;
    L_0x012d:
        throw r10;
    L_0x012e:
        goto L_0x012d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zza(android.content.Context, com.google.android.gms.dynamite.DynamiteModule$zzd, java.lang.String):com.google.android.gms.dynamite.DynamiteModule");
    }

    private static DynamiteModule zza(Context context, String str, int i) {
        synchronized (DynamiteModule.class) {
            Boolean bool = zzhdc;
        }
        if (bool != null) {
            return bool.booleanValue() ? zzc(context, str, i) : zzb(context, str, i);
        } else {
            throw new zzc("Failed to determine which loading route to use.");
        }
    }

    private static void zza(ClassLoader classLoader) {
        Throwable e;
        try {
            zzm zzm;
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzm = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                zzm = queryLocalInterface instanceof zzm ? (zzm) queryLocalInterface : new zzn(iBinder);
            }
            zzhde = zzm;
        } catch (ClassNotFoundException e2) {
            e = e2;
            throw new zzc("Failed to instantiate dynamite loader", e);
        } catch (IllegalAccessException e3) {
            e = e3;
            throw new zzc("Failed to instantiate dynamite loader", e);
        } catch (InstantiationException e4) {
            e = e4;
            throw new zzc("Failed to instantiate dynamite loader", e);
        } catch (InvocationTargetException e5) {
            e = e5;
            throw new zzc("Failed to instantiate dynamite loader", e);
        } catch (NoSuchMethodException e6) {
            e = e6;
            throw new zzc("Failed to instantiate dynamite loader", e);
        }
    }

    private static DynamiteModule zzb(Context context, String str, int i) {
        String str2 = "Failed to load remote module.";
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 51);
        stringBuilder.append("Selected remote version of ");
        stringBuilder.append(str);
        stringBuilder.append(", version >= ");
        stringBuilder.append(i);
        Log.i("DynamiteModule", stringBuilder.toString());
        zzk zzdh = zzdh(context);
        if (zzdh != null) {
            try {
                IObjectWrapper zza = zzdh.zza(zzn.zzz(context), str, i);
                if (zzn.zzy(zza) != null) {
                    return new DynamiteModule((Context) zzn.zzy(zza));
                }
                throw new zzc(str2);
            } catch (Throwable e) {
                throw new zzc(str2, e);
            }
        }
        throw new zzc("Failed to create IDynamiteLoader.");
    }

    public static int zzc(android.content.Context r8, java.lang.String r9, boolean r10) {
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
        r0 = com.google.android.gms.dynamite.DynamiteModule.class;
        monitor-enter(r0);
        r1 = zzhdc;	 Catch:{ all -> 0x00ea }
        if (r1 != 0) goto L_0x00b7;
    L_0x0007:
        r1 = r8.getApplicationContext();	 Catch:{ ClassNotFoundException -> 0x008e, IllegalAccessException -> 0x008c, NoSuchFieldException -> 0x008a }
        r1 = r1.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x008e, IllegalAccessException -> 0x008c, NoSuchFieldException -> 0x008a }
        r2 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class;	 Catch:{ ClassNotFoundException -> 0x008e, IllegalAccessException -> 0x008c, NoSuchFieldException -> 0x008a }
        r2 = r2.getName();	 Catch:{ ClassNotFoundException -> 0x008e, IllegalAccessException -> 0x008c, NoSuchFieldException -> 0x008a }
        r1 = r1.loadClass(r2);	 Catch:{ ClassNotFoundException -> 0x008e, IllegalAccessException -> 0x008c, NoSuchFieldException -> 0x008a }
        r2 = "sClassLoader";	 Catch:{ ClassNotFoundException -> 0x008e, IllegalAccessException -> 0x008c, NoSuchFieldException -> 0x008a }
        r2 = r1.getDeclaredField(r2);	 Catch:{ ClassNotFoundException -> 0x008e, IllegalAccessException -> 0x008c, NoSuchFieldException -> 0x008a }
        monitor-enter(r1);	 Catch:{ ClassNotFoundException -> 0x008e, IllegalAccessException -> 0x008c, NoSuchFieldException -> 0x008a }
        r3 = 0;
        r4 = r2.get(r3);	 Catch:{ all -> 0x0087 }
        r4 = (java.lang.ClassLoader) r4;	 Catch:{ all -> 0x0087 }
        if (r4 == 0) goto L_0x0038;	 Catch:{ all -> 0x0087 }
    L_0x0029:
        r2 = java.lang.ClassLoader.getSystemClassLoader();	 Catch:{ all -> 0x0087 }
        if (r4 != r2) goto L_0x0032;	 Catch:{ all -> 0x0087 }
    L_0x002f:
        r2 = java.lang.Boolean.FALSE;	 Catch:{ all -> 0x0087 }
        goto L_0x0084;
    L_0x0032:
        zza(r4);	 Catch:{ zzc -> 0x0035 }
    L_0x0035:
        r2 = java.lang.Boolean.TRUE;	 Catch:{ all -> 0x0087 }
        goto L_0x0084;	 Catch:{ all -> 0x0087 }
    L_0x0038:
        r4 = "com.google.android.gms";	 Catch:{ all -> 0x0087 }
        r5 = r8.getApplicationContext();	 Catch:{ all -> 0x0087 }
        r5 = r5.getPackageName();	 Catch:{ all -> 0x0087 }
        r4 = r4.equals(r5);	 Catch:{ all -> 0x0087 }
        if (r4 == 0) goto L_0x0050;	 Catch:{ all -> 0x0087 }
    L_0x0048:
        r4 = java.lang.ClassLoader.getSystemClassLoader();	 Catch:{ all -> 0x0087 }
        r2.set(r3, r4);	 Catch:{ all -> 0x0087 }
        goto L_0x002f;
    L_0x0050:
        r4 = zze(r8, r9, r10);	 Catch:{ zzc -> 0x007c }
        r5 = zzhdf;	 Catch:{ zzc -> 0x007c }
        if (r5 == 0) goto L_0x0079;	 Catch:{ zzc -> 0x007c }
    L_0x0058:
        r5 = zzhdf;	 Catch:{ zzc -> 0x007c }
        r5 = r5.isEmpty();	 Catch:{ zzc -> 0x007c }
        if (r5 == 0) goto L_0x0061;	 Catch:{ zzc -> 0x007c }
    L_0x0060:
        goto L_0x0079;	 Catch:{ zzc -> 0x007c }
    L_0x0061:
        r5 = new com.google.android.gms.dynamite.zzh;	 Catch:{ zzc -> 0x007c }
        r6 = zzhdf;	 Catch:{ zzc -> 0x007c }
        r7 = java.lang.ClassLoader.getSystemClassLoader();	 Catch:{ zzc -> 0x007c }
        r5.<init>(r6, r7);	 Catch:{ zzc -> 0x007c }
        zza(r5);	 Catch:{ zzc -> 0x007c }
        r2.set(r3, r5);	 Catch:{ zzc -> 0x007c }
        r5 = java.lang.Boolean.TRUE;	 Catch:{ zzc -> 0x007c }
        zzhdc = r5;	 Catch:{ zzc -> 0x007c }
        monitor-exit(r1);	 Catch:{ all -> 0x0087 }
        monitor-exit(r0);	 Catch:{ all -> 0x00ea }
        return r4;
    L_0x0079:
        monitor-exit(r1);	 Catch:{ all -> 0x0087 }
        monitor-exit(r0);	 Catch:{ all -> 0x00ea }
        return r4;
    L_0x007c:
        r4 = java.lang.ClassLoader.getSystemClassLoader();	 Catch:{ all -> 0x0087 }
        r2.set(r3, r4);	 Catch:{ all -> 0x0087 }
        goto L_0x002f;	 Catch:{ all -> 0x0087 }
    L_0x0084:
        monitor-exit(r1);	 Catch:{ all -> 0x0087 }
        r1 = r2;	 Catch:{ all -> 0x0087 }
        goto L_0x00b5;	 Catch:{ all -> 0x0087 }
    L_0x0087:
        r2 = move-exception;	 Catch:{ all -> 0x0087 }
        monitor-exit(r1);	 Catch:{ all -> 0x0087 }
        throw r2;	 Catch:{ ClassNotFoundException -> 0x008e, IllegalAccessException -> 0x008c, NoSuchFieldException -> 0x008a }
    L_0x008a:
        r1 = move-exception;
        goto L_0x008f;
    L_0x008c:
        r1 = move-exception;
        goto L_0x008f;
    L_0x008e:
        r1 = move-exception;
    L_0x008f:
        r2 = "DynamiteModule";	 Catch:{ all -> 0x00ea }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ all -> 0x00ea }
        r3 = java.lang.String.valueOf(r1);	 Catch:{ all -> 0x00ea }
        r3 = r3.length();	 Catch:{ all -> 0x00ea }
        r3 = r3 + 30;	 Catch:{ all -> 0x00ea }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ea }
        r4.<init>(r3);	 Catch:{ all -> 0x00ea }
        r3 = "Failed to load module via V2: ";	 Catch:{ all -> 0x00ea }
        r4.append(r3);	 Catch:{ all -> 0x00ea }
        r4.append(r1);	 Catch:{ all -> 0x00ea }
        r1 = r4.toString();	 Catch:{ all -> 0x00ea }
        android.util.Log.w(r2, r1);	 Catch:{ all -> 0x00ea }
        r1 = java.lang.Boolean.FALSE;	 Catch:{ all -> 0x00ea }
    L_0x00b5:
        zzhdc = r1;	 Catch:{ all -> 0x00ea }
    L_0x00b7:
        monitor-exit(r0);	 Catch:{ all -> 0x00ea }
        r0 = r1.booleanValue();
        if (r0 == 0) goto L_0x00e5;
    L_0x00be:
        r8 = zze(r8, r9, r10);	 Catch:{ zzc -> 0x00c3 }
        return r8;
    L_0x00c3:
        r8 = move-exception;
        r9 = "Failed to retrieve remote module version: ";
        r8 = r8.getMessage();
        r8 = java.lang.String.valueOf(r8);
        r10 = r8.length();
        if (r10 == 0) goto L_0x00d9;
    L_0x00d4:
        r8 = r9.concat(r8);
        goto L_0x00de;
    L_0x00d9:
        r8 = new java.lang.String;
        r8.<init>(r9);
    L_0x00de:
        r9 = "DynamiteModule";
        android.util.Log.w(r9, r8);
        r8 = 0;
        return r8;
    L_0x00e5:
        r8 = zzd(r8, r9, r10);
        return r8;
    L_0x00ea:
        r8 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00ea }
        goto L_0x00ee;
    L_0x00ed:
        throw r8;
    L_0x00ee:
        goto L_0x00ed;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzc(android.content.Context, java.lang.String, boolean):int");
    }

    private static DynamiteModule zzc(Context context, String str, int i) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 51);
        stringBuilder.append("Selected remote version of ");
        stringBuilder.append(str);
        stringBuilder.append(", version >= ");
        stringBuilder.append(i);
        Log.i("DynamiteModule", stringBuilder.toString());
        synchronized (DynamiteModule.class) {
            zzm zzm = zzhde;
        }
        if (zzm != null) {
            zza zza = (zza) zzhdg.get();
            if (zza == null || zza.zzhdp == null) {
                throw new zzc("No result cursor");
            }
            context = zza(context.getApplicationContext(), str, i, zza.zzhdp, zzm);
            if (context != null) {
                return new DynamiteModule(context);
            }
            throw new zzc("Failed to get module context");
        }
        throw new zzc("DynamiteLoaderV2 was not cached.");
    }

    private static int zzd(Context context, String str, boolean z) {
        zzk zzdh = zzdh(context);
        if (zzdh == null) {
            return 0;
        }
        try {
            return zzdh.zza(zzn.zzz(context), str, z);
        } catch (RemoteException e) {
            str = "Failed to retrieve remote module version: ";
            String valueOf = String.valueOf(e.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            return 0;
        }
    }

    private static zzk zzdh(Context context) {
        synchronized (DynamiteModule.class) {
            zzk zzk;
            if (zzhdd != null) {
                zzk = zzhdd;
                return zzk;
            } else if (zzf.zzahf().isGooglePlayServicesAvailable(context) != 0) {
                return null;
            } else {
                try {
                    IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                    if (iBinder == null) {
                        zzk = null;
                    } else {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                        zzk = queryLocalInterface instanceof zzk ? (zzk) queryLocalInterface : new zzl(iBinder);
                    }
                    if (zzk != null) {
                        zzhdd = zzk;
                        return zzk;
                    }
                } catch (Exception e) {
                    String str = "DynamiteModule";
                    String str2 = "Failed to load IDynamiteLoader from GmsCore: ";
                    String valueOf = String.valueOf(e.getMessage());
                    Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                }
            }
        }
        return null;
    }

    private static int zze(Context context, String str, boolean z) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            String str2 = z ? "api_force_staging" : "api";
            StringBuilder stringBuilder = new StringBuilder((str2.length() + 42) + String.valueOf(str).length());
            stringBuilder.append("content://com.google.android.gms.chimera/");
            stringBuilder.append(str2);
            stringBuilder.append("/");
            stringBuilder.append(str);
            Cursor query = contentResolver.query(Uri.parse(stringBuilder.toString()), null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int i = query.getInt(0);
                        if (i > 0) {
                            synchronized (DynamiteModule.class) {
                                zzhdf = query.getString(2);
                            }
                            zza zza = (zza) zzhdg.get();
                            if (zza != null && zza.zzhdp == null) {
                                zza.zzhdp = query;
                                query = null;
                            }
                        }
                        if (query != null) {
                            query.close();
                        }
                        return i;
                    }
                } catch (Throwable e) {
                    Throwable th2 = e;
                    cursor = query;
                    th = th2;
                } catch (Throwable e2) {
                    cursor2 = query;
                    th = e2;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
            Log.w("DynamiteModule", "Failed to retrieve remote module version.");
            throw new zzc("Failed to connect to dynamite module ContentResolver.");
        } catch (Exception e3) {
            th = e3;
            cursor = null;
            try {
                if (th instanceof zzc) {
                    throw th;
                }
                throw new zzc("V2 version check failed", th);
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public static int zzx(android.content.Context r5, java.lang.String r6) {
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
        r0 = "DynamiteModule";
        r1 = 0;
        r5 = r5.getApplicationContext();	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r5 = r5.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r2 = java.lang.String.valueOf(r6);	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r2 = r2.length();	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r2 = r2 + 61;	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r3 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r3.<init>(r2);	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r2 = "com.google.android.gms.dynamite.descriptors.";	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r3.append(r2);	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r3.append(r6);	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r2 = ".ModuleDescriptor";	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r3.append(r2);	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r2 = r3.toString();	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r5 = r5.loadClass(r2);	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r2 = "MODULE_ID";	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r2 = r5.getDeclaredField(r2);	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r3 = "MODULE_VERSION";	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r5 = r5.getDeclaredField(r3);	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r3 = 0;	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r4 = r2.get(r3);	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r4 = r4.equals(r6);	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        if (r4 != 0) goto L_0x0083;	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
    L_0x0046:
        r5 = r2.get(r3);	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r5 = java.lang.String.valueOf(r5);	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r2 = java.lang.String.valueOf(r5);	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r2 = r2.length();	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r2 = r2 + 51;	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r3 = java.lang.String.valueOf(r6);	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r3 = r3.length();	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r2 = r2 + r3;	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r3 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r3.<init>(r2);	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r2 = "Module descriptor id '";	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r3.append(r2);	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r3.append(r5);	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r5 = "' didn't match expected id '";	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r3.append(r5);	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r3.append(r6);	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r5 = "'";	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r3.append(r5);	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        r5 = r3.toString();	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        android.util.Log.e(r0, r5);	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        return r1;	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
    L_0x0083:
        r5 = r5.getInt(r3);	 Catch:{ ClassNotFoundException -> 0x00a7, Exception -> 0x0088 }
        return r5;
    L_0x0088:
        r5 = move-exception;
        r6 = "Failed to load module descriptor class: ";
        r5 = r5.getMessage();
        r5 = java.lang.String.valueOf(r5);
        r2 = r5.length();
        if (r2 == 0) goto L_0x009e;
    L_0x0099:
        r5 = r6.concat(r5);
        goto L_0x00a3;
    L_0x009e:
        r5 = new java.lang.String;
        r5.<init>(r6);
    L_0x00a3:
        android.util.Log.e(r0, r5);
        goto L_0x00ca;
    L_0x00a7:
        r5 = java.lang.String.valueOf(r6);
        r5 = r5.length();
        r5 = r5 + 45;
        r2 = new java.lang.StringBuilder;
        r2.<init>(r5);
        r5 = "Local module descriptor class for ";
        r2.append(r5);
        r2.append(r6);
        r5 = " not found.";
        r2.append(r5);
        r5 = r2.toString();
        android.util.Log.w(r0, r5);
    L_0x00ca:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzx(android.content.Context, java.lang.String):int");
    }

    public static int zzy(Context context, String str) {
        return zzc(context, str, false);
    }

    private static DynamiteModule zzz(Context context, String str) {
        str = String.valueOf(str);
        String str2 = "Selected local version of ";
        Log.i("DynamiteModule", str.length() != 0 ? str2.concat(str) : new String(str2));
        return new DynamiteModule(context.getApplicationContext());
    }

    public final Context zzarl() {
        return this.zzhdo;
    }

    public final IBinder zzhk(String str) {
        Throwable e;
        String str2;
        try {
            return (IBinder) this.zzhdo.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException e2) {
            e = e2;
            str2 = "Failed to instantiate module class: ";
            str = String.valueOf(str);
            throw new zzc(str.length() != 0 ? str2.concat(str) : new String(str2), e);
        } catch (InstantiationException e3) {
            e = e3;
            str2 = "Failed to instantiate module class: ";
            str = String.valueOf(str);
            if (str.length() != 0) {
            }
            throw new zzc(str.length() != 0 ? str2.concat(str) : new String(str2), e);
        } catch (IllegalAccessException e4) {
            e = e4;
            str2 = "Failed to instantiate module class: ";
            str = String.valueOf(str);
            if (str.length() != 0) {
            }
            throw new zzc(str.length() != 0 ? str2.concat(str) : new String(str2), e);
        }
    }
}
