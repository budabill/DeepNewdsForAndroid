package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.zzf;
import com.google.android.gms.internal.zzcyj;
import com.google.android.gms.internal.zzcyk;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class zzbi implements zzcc, zzu {
    private final Context mContext;
    private zza<? extends zzcyj, zzcyk> zzfth;
    final zzba zzfvq;
    private final Lock zzfwa;
    private zzr zzfwf;
    private Map<Api<?>, Boolean> zzfwi;
    private final zzf zzfwk;
    final Map<zzc<?>, zze> zzfyj;
    private final Condition zzfyw;
    private final zzbk zzfyx;
    final Map<zzc<?>, ConnectionResult> zzfyy = new HashMap();
    private volatile zzbh zzfyz;
    private ConnectionResult zzfza = null;
    int zzfzb;
    final zzcd zzfzc;

    public zzbi(Context context, zzba zzba, Lock lock, Looper looper, zzf zzf, Map<zzc<?>, zze> map, zzr zzr, Map<Api<?>, Boolean> map2, zza<? extends zzcyj, zzcyk> zza, ArrayList<zzt> arrayList, zzcd zzcd) {
        this.mContext = context;
        this.zzfwa = lock;
        this.zzfwk = zzf;
        this.zzfyj = map;
        this.zzfwf = zzr;
        this.zzfwi = map2;
        this.zzfth = zza;
        this.zzfvq = zzba;
        this.zzfzc = zzcd;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((zzt) obj).zza(this);
        }
        this.zzfyx = new zzbk(this, looper);
        this.zzfyw = lock.newCondition();
        this.zzfyz = new zzaz(this);
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
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
        r0 = r3.zzfyw;	 Catch:{ InterruptedException -> 0x0010 }
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
        r0 = r3.zzfza;
        if (r0 == 0) goto L_0x002d;
    L_0x002c:
        return r0;
    L_0x002d:
        r0 = new com.google.android.gms.common.ConnectionResult;
        r2 = 13;
        r0.<init>(r2, r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzbi.blockingConnect():com.google.android.gms.common.ConnectionResult");
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
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
        r6 = r3.zzfyw;	 Catch:{ InterruptedException -> 0x0026 }
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
        r4 = r3.zzfza;
        if (r4 == 0) goto L_0x0043;
    L_0x0042:
        return r4;
    L_0x0043:
        r4 = new com.google.android.gms.common.ConnectionResult;
        r5 = 13;
        r4.<init>(r5, r0);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzbi.blockingConnect(long, java.util.concurrent.TimeUnit):com.google.android.gms.common.ConnectionResult");
    }

    public final void connect() {
        this.zzfyz.connect();
    }

    public final void disconnect() {
        if (this.zzfyz.disconnect()) {
            this.zzfyy.clear();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append(str).append("mState=").println(this.zzfyz);
        for (Api api : this.zzfwi.keySet()) {
            printWriter.append(str).append(api.getName()).println(":");
            ((zze) this.zzfyj.get(api.zzahm())).dump(concat, fileDescriptor, printWriter, strArr);
        }
    }

    public final ConnectionResult getConnectionResult(Api<?> api) {
        zzc zzahm = api.zzahm();
        if (this.zzfyj.containsKey(zzahm)) {
            if (((zze) this.zzfyj.get(zzahm)).isConnected()) {
                return ConnectionResult.zzfqt;
            }
            if (this.zzfyy.containsKey(zzahm)) {
                return (ConnectionResult) this.zzfyy.get(zzahm);
            }
        }
        return null;
    }

    public final boolean isConnected() {
        return this.zzfyz instanceof zzal;
    }

    public final boolean isConnecting() {
        return this.zzfyz instanceof zzao;
    }

    public final void onConnected(Bundle bundle) {
        this.zzfwa.lock();
        try {
            this.zzfyz.onConnected(bundle);
        } finally {
            this.zzfwa.unlock();
        }
    }

    public final void onConnectionSuspended(int i) {
        this.zzfwa.lock();
        try {
            this.zzfyz.onConnectionSuspended(i);
        } finally {
            this.zzfwa.unlock();
        }
    }

    public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
        this.zzfwa.lock();
        try {
            this.zzfyz.zza(connectionResult, api, z);
        } finally {
            this.zzfwa.unlock();
        }
    }

    final void zza(zzbj zzbj) {
        this.zzfyx.sendMessage(this.zzfyx.obtainMessage(1, zzbj));
    }

    public final boolean zza(zzcu zzcu) {
        return false;
    }

    public final void zzaia() {
    }

    public final void zzais() {
        if (isConnected()) {
            ((zzal) this.zzfyz).zzaji();
        }
    }

    final void zzajv() {
        this.zzfwa.lock();
        try {
            this.zzfyz = new zzao(this, this.zzfwf, this.zzfwi, this.zzfwk, this.zzfth, this.zzfwa, this.mContext);
            this.zzfyz.begin();
            this.zzfyw.signalAll();
        } finally {
            this.zzfwa.unlock();
        }
    }

    final void zzajw() {
        this.zzfwa.lock();
        try {
            this.zzfvq.zzajs();
            this.zzfyz = new zzal(this);
            this.zzfyz.begin();
            this.zzfyw.signalAll();
        } finally {
            this.zzfwa.unlock();
        }
    }

    final void zzb(RuntimeException runtimeException) {
        this.zzfyx.sendMessage(this.zzfyx.obtainMessage(2, runtimeException));
    }

    public final <A extends zzb, R extends Result, T extends zzm<R, A>> T zzd(T t) {
        t.zzaiq();
        return this.zzfyz.zzd(t);
    }

    public final <A extends zzb, T extends zzm<? extends Result, A>> T zze(T t) {
        t.zzaiq();
        return this.zzfyz.zze(t);
    }

    final void zzg(ConnectionResult connectionResult) {
        this.zzfwa.lock();
        try {
            this.zzfza = connectionResult;
            this.zzfyz = new zzaz(this);
            this.zzfyz.begin();
            this.zzfyw.signalAll();
        } finally {
            this.zzfwa.unlock();
        }
    }
}
