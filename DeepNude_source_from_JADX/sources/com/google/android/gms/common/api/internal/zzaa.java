package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.zzf;
import com.google.android.gms.internal.zzbic;
import com.google.android.gms.internal.zzcyj;
import com.google.android.gms.internal.zzcyk;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class zzaa implements zzcc {
    private final Looper zzalj;
    private final zzbm zzfsq;
    private final Lock zzfwa;
    private final zzr zzfwf;
    private final Map<zzc<?>, zzz<?>> zzfwg = new HashMap();
    private final Map<zzc<?>, zzz<?>> zzfwh = new HashMap();
    private final Map<Api<?>, Boolean> zzfwi;
    private final zzba zzfwj;
    private final zzf zzfwk;
    private final Condition zzfwl;
    private final boolean zzfwm;
    private final boolean zzfwn;
    private final Queue<zzm<?, ?>> zzfwo = new LinkedList();
    private boolean zzfwp;
    private Map<zzh<?>, ConnectionResult> zzfwq;
    private Map<zzh<?>, ConnectionResult> zzfwr;
    private zzad zzfws;
    private ConnectionResult zzfwt;

    public zzaa(Context context, Lock lock, Looper looper, zzf zzf, Map<zzc<?>, zze> map, zzr zzr, Map<Api<?>, Boolean> map2, zza<? extends zzcyj, zzcyk> zza, ArrayList<zzt> arrayList, zzba zzba, boolean z) {
        this.zzfwa = lock;
        this.zzalj = looper;
        this.zzfwl = lock.newCondition();
        this.zzfwk = zzf;
        this.zzfwj = zzba;
        this.zzfwi = map2;
        this.zzfwf = zzr;
        this.zzfwm = z;
        Map hashMap = new HashMap();
        for (Api api : map2.keySet()) {
            hashMap.put(api.zzahm(), api);
        }
        Map hashMap2 = new HashMap();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            zzt zzt = (zzt) obj;
            hashMap2.put(zzt.zzfop, zzt);
        }
        boolean z2 = true;
        Object obj2 = null;
        Object obj3 = 1;
        Object obj4 = null;
        for (Entry entry : map.entrySet()) {
            Object obj5;
            Object obj6;
            Object obj7;
            Api api2 = (Api) hashMap.get(entry.getKey());
            zze zze = (zze) entry.getValue();
            if (zze.zzahn()) {
                if (((Boolean) r0.zzfwi.get(api2)).booleanValue()) {
                    obj5 = obj3;
                    obj6 = obj4;
                } else {
                    obj5 = obj3;
                    obj6 = 1;
                }
                obj7 = 1;
            } else {
                obj7 = obj2;
                obj6 = obj4;
                obj5 = null;
            }
            zzz zzz = r1;
            zzz zzz2 = new zzz(context, api2, looper, zze, (zzt) hashMap2.get(api2), zzr, zza);
            r0.zzfwg.put((zzc) entry.getKey(), zzz);
            if (zze.zzacc()) {
                r0.zzfwh.put((zzc) entry.getKey(), zzz);
            }
            obj4 = obj6;
            obj3 = obj5;
            obj2 = obj7;
        }
        if (obj2 == null || obj3 != null || obj4 != null) {
            z2 = false;
        }
        r0.zzfwn = z2;
        r0.zzfsq = zzbm.zzajy();
    }

    private final boolean zza(zzz<?> zzz, ConnectionResult connectionResult) {
        return !connectionResult.isSuccess() && !connectionResult.hasResolution() && ((Boolean) this.zzfwi.get(zzz.zzaht())).booleanValue() && zzz.zzaix().zzahn() && this.zzfwk.isUserResolvableError(connectionResult.getErrorCode());
    }

    private final boolean zzaiy() {
        this.zzfwa.lock();
        try {
            if (this.zzfwp) {
                if (this.zzfwm) {
                    for (zzc zzb : this.zzfwh.keySet()) {
                        ConnectionResult zzb2 = zzb(zzb);
                        if (zzb2 != null) {
                            if (!zzb2.isSuccess()) {
                            }
                        }
                    }
                    this.zzfwa.unlock();
                    return true;
                }
            }
            this.zzfwa.unlock();
            return false;
        } catch (Throwable th) {
            this.zzfwa.unlock();
        }
    }

    private final void zzaiz() {
        zzba zzba;
        Set emptySet;
        zzr zzr = this.zzfwf;
        if (zzr == null) {
            zzba = this.zzfwj;
            emptySet = Collections.emptySet();
        } else {
            emptySet = new HashSet(zzr.zzamf());
            Map zzamh = this.zzfwf.zzamh();
            for (Api api : zzamh.keySet()) {
                ConnectionResult connectionResult = getConnectionResult(api);
                if (connectionResult != null && connectionResult.isSuccess()) {
                    emptySet.addAll(((zzt) zzamh.get(api)).zzenh);
                }
            }
            zzba = this.zzfwj;
        }
        zzba.zzfyk = emptySet;
    }

    private final void zzaja() {
        while (!this.zzfwo.isEmpty()) {
            zze((zzm) this.zzfwo.remove());
        }
        this.zzfwj.zzk(null);
    }

    private final ConnectionResult zzajb() {
        ConnectionResult connectionResult = null;
        ConnectionResult connectionResult2 = null;
        int i = 0;
        int i2 = 0;
        for (zzz zzz : this.zzfwg.values()) {
            Api zzaht = zzz.zzaht();
            ConnectionResult connectionResult3 = (ConnectionResult) this.zzfwq.get(zzz.zzahv());
            if (!connectionResult3.isSuccess() && (!((Boolean) this.zzfwi.get(zzaht)).booleanValue() || connectionResult3.hasResolution() || this.zzfwk.isUserResolvableError(connectionResult3.getErrorCode()))) {
                int priority;
                if (connectionResult3.getErrorCode() == 4 && this.zzfwm) {
                    priority = zzaht.zzahk().getPriority();
                    if (connectionResult2 == null || i2 > priority) {
                        connectionResult2 = connectionResult3;
                        i2 = priority;
                    }
                } else {
                    priority = zzaht.zzahk().getPriority();
                    if (connectionResult == null || i > priority) {
                        connectionResult = connectionResult3;
                        i = priority;
                    }
                }
            }
        }
        return (connectionResult == null || connectionResult2 == null || i <= i2) ? connectionResult : connectionResult2;
    }

    private final ConnectionResult zzb(zzc<?> zzc) {
        this.zzfwa.lock();
        try {
            zzz zzz = (zzz) this.zzfwg.get(zzc);
            if (this.zzfwq == null || zzz == null) {
                this.zzfwa.unlock();
                return null;
            }
            ConnectionResult connectionResult = (ConnectionResult) this.zzfwq.get(zzz.zzahv());
            return connectionResult;
        } finally {
            this.zzfwa.unlock();
        }
    }

    private final <T extends zzm<? extends Result, ? extends zzb>> boolean zzg(T t) {
        zzc zzahm = t.zzahm();
        ConnectionResult zzb = zzb(zzahm);
        if (zzb == null || zzb.getErrorCode() != 4) {
            return false;
        }
        t.zzu(new Status(4, null, this.zzfsq.zza(((zzz) this.zzfwg.get(zzahm)).zzahv(), System.identityHashCode(this.zzfwj))));
        return true;
    }

    public final com.google.android.gms.common.ConnectionResult blockingConnect() {
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
        r3.connect();
    L_0x0003:
        r0 = r3.isConnecting();
        r1 = 0;
        if (r0 == 0) goto L_0x001f;
    L_0x000a:
        r0 = r3.zzfwl;	 Catch:{ InterruptedException -> 0x0010 }
        r0.await();	 Catch:{ InterruptedException -> 0x0010 }
        goto L_0x0003;
    L_0x0010:
        r0 = java.lang.Thread.currentThread();
        r0.interrupt();
        r0 = new com.google.android.gms.common.ConnectionResult;
        r2 = 15;
        r0.<init>(r2, r1);
        return r0;
    L_0x001f:
        r0 = r3.isConnected();
        if (r0 == 0) goto L_0x0028;
    L_0x0025:
        r0 = com.google.android.gms.common.ConnectionResult.zzfqt;
        return r0;
    L_0x0028:
        r0 = r3.zzfwt;
        if (r0 == 0) goto L_0x002d;
    L_0x002c:
        return r0;
    L_0x002d:
        r0 = new com.google.android.gms.common.ConnectionResult;
        r2 = 13;
        r0.<init>(r2, r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzaa.blockingConnect():com.google.android.gms.common.ConnectionResult");
    }

    public final com.google.android.gms.common.ConnectionResult blockingConnect(long r4, java.util.concurrent.TimeUnit r6) {
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
        r3.connect();
        r4 = r6.toNanos(r4);
    L_0x0007:
        r6 = r3.isConnecting();
        r0 = 0;
        if (r6 == 0) goto L_0x0035;
    L_0x000e:
        r1 = 0;
        r6 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1));
        if (r6 > 0) goto L_0x001f;
    L_0x0014:
        r3.disconnect();	 Catch:{ InterruptedException -> 0x0026 }
        r4 = new com.google.android.gms.common.ConnectionResult;	 Catch:{ InterruptedException -> 0x0026 }
        r5 = 14;	 Catch:{ InterruptedException -> 0x0026 }
        r4.<init>(r5, r0);	 Catch:{ InterruptedException -> 0x0026 }
        return r4;	 Catch:{ InterruptedException -> 0x0026 }
    L_0x001f:
        r6 = r3.zzfwl;	 Catch:{ InterruptedException -> 0x0026 }
        r4 = r6.awaitNanos(r4);	 Catch:{ InterruptedException -> 0x0026 }
        goto L_0x0007;
    L_0x0026:
        r4 = java.lang.Thread.currentThread();
        r4.interrupt();
        r4 = new com.google.android.gms.common.ConnectionResult;
        r5 = 15;
        r4.<init>(r5, r0);
        return r4;
    L_0x0035:
        r4 = r3.isConnected();
        if (r4 == 0) goto L_0x003e;
    L_0x003b:
        r4 = com.google.android.gms.common.ConnectionResult.zzfqt;
        return r4;
    L_0x003e:
        r4 = r3.zzfwt;
        if (r4 == 0) goto L_0x0043;
    L_0x0042:
        return r4;
    L_0x0043:
        r4 = new com.google.android.gms.common.ConnectionResult;
        r5 = 13;
        r4.<init>(r5, r0);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzaa.blockingConnect(long, java.util.concurrent.TimeUnit):com.google.android.gms.common.ConnectionResult");
    }

    public final void connect() {
        this.zzfwa.lock();
        try {
            if (!this.zzfwp) {
                this.zzfwp = true;
                this.zzfwq = null;
                this.zzfwr = null;
                this.zzfws = null;
                this.zzfwt = null;
                this.zzfsq.zzaih();
                this.zzfsq.zza(this.zzfwg.values()).addOnCompleteListener(new zzbic(this.zzalj), new zzac());
            }
            this.zzfwa.unlock();
        } catch (Throwable th) {
            this.zzfwa.unlock();
        }
    }

    public final void disconnect() {
        this.zzfwa.lock();
        try {
            this.zzfwp = false;
            this.zzfwq = null;
            this.zzfwr = null;
            if (this.zzfws != null) {
                this.zzfws.cancel();
                this.zzfws = null;
            }
            this.zzfwt = null;
            while (!this.zzfwo.isEmpty()) {
                zzm zzm = (zzm) this.zzfwo.remove();
                zzm.zza(null);
                zzm.cancel();
            }
            this.zzfwl.signalAll();
        } finally {
            this.zzfwa.unlock();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public final ConnectionResult getConnectionResult(Api<?> api) {
        return zzb(api.zzahm());
    }

    public final boolean isConnected() {
        this.zzfwa.lock();
        try {
            boolean z = this.zzfwq != null && this.zzfwt == null;
            this.zzfwa.unlock();
            return z;
        } catch (Throwable th) {
            this.zzfwa.unlock();
        }
    }

    public final boolean isConnecting() {
        this.zzfwa.lock();
        try {
            boolean z = this.zzfwq == null && this.zzfwp;
            this.zzfwa.unlock();
            return z;
        } catch (Throwable th) {
            this.zzfwa.unlock();
        }
    }

    public final boolean zza(zzcu zzcu) {
        this.zzfwa.lock();
        try {
            if (!this.zzfwp || zzaiy()) {
                this.zzfwa.unlock();
                return false;
            }
            this.zzfsq.zzaih();
            this.zzfws = new zzad(this, zzcu);
            this.zzfsq.zza(this.zzfwh.values()).addOnCompleteListener(new zzbic(this.zzalj), this.zzfws);
            return true;
        } finally {
            this.zzfwa.unlock();
        }
    }

    public final void zzaia() {
        this.zzfwa.lock();
        try {
            this.zzfsq.zzaia();
            if (this.zzfws != null) {
                this.zzfws.cancel();
                this.zzfws = null;
            }
            if (this.zzfwr == null) {
                this.zzfwr = new ArrayMap(this.zzfwh.size());
            }
            ConnectionResult connectionResult = new ConnectionResult(4);
            for (zzz zzahv : this.zzfwh.values()) {
                this.zzfwr.put(zzahv.zzahv(), connectionResult);
            }
            if (this.zzfwq != null) {
                this.zzfwq.putAll(this.zzfwr);
            }
            this.zzfwa.unlock();
        } catch (Throwable th) {
            this.zzfwa.unlock();
        }
    }

    public final void zzais() {
    }

    public final <A extends zzb, R extends Result, T extends zzm<R, A>> T zzd(T t) {
        if (this.zzfwm && zzg((zzm) t)) {
            return t;
        }
        if (isConnected()) {
            this.zzfwj.zzfyp.zzb(t);
            return ((zzz) this.zzfwg.get(t.zzahm())).zza((zzm) t);
        }
        this.zzfwo.add(t);
        return t;
    }

    public final <A extends zzb, T extends zzm<? extends Result, A>> T zze(T t) {
        zzc zzahm = t.zzahm();
        if (this.zzfwm && zzg((zzm) t)) {
            return t;
        }
        this.zzfwj.zzfyp.zzb(t);
        return ((zzz) this.zzfwg.get(zzahm)).zzb((zzm) t);
    }
}
