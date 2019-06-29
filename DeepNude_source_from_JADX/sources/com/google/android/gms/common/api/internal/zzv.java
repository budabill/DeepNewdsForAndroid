package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.zzf;
import com.google.android.gms.internal.zzcyj;
import com.google.android.gms.internal.zzcyk;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

final class zzv implements zzcc {
    private final Context mContext;
    private final Looper zzalj;
    private final zzba zzfvq;
    private final zzbi zzfvr;
    private final zzbi zzfvs;
    private final Map<zzc<?>, zzbi> zzfvt;
    private final Set<zzcu> zzfvu = Collections.newSetFromMap(new WeakHashMap());
    private final zze zzfvv;
    private Bundle zzfvw;
    private ConnectionResult zzfvx = null;
    private ConnectionResult zzfvy = null;
    private boolean zzfvz = false;
    private final Lock zzfwa;
    private int zzfwb = 0;

    private zzv(Context context, zzba zzba, Lock lock, Looper looper, zzf zzf, Map<zzc<?>, zze> map, Map<zzc<?>, zze> map2, zzr zzr, zza<? extends zzcyj, zzcyk> zza, zze zze, ArrayList<zzt> arrayList, ArrayList<zzt> arrayList2, Map<Api<?>, Boolean> map3, Map<Api<?>, Boolean> map4) {
        this.mContext = context;
        this.zzfvq = zzba;
        this.zzfwa = lock;
        this.zzalj = looper;
        this.zzfvv = zze;
        Context context2 = context;
        Lock lock2 = lock;
        Looper looper2 = looper;
        zzf zzf2 = zzf;
        zzbi zzbi = r3;
        zzbi zzbi2 = new zzbi(context2, this.zzfvq, lock2, looper2, zzf2, map2, null, map4, null, arrayList2, new zzx());
        this.zzfvr = zzbi;
        this.zzfvs = new zzbi(context2, this.zzfvq, lock2, looper2, zzf2, map, zzr, map3, zza, arrayList, new zzy());
        Object arrayMap = new ArrayMap();
        for (zzc put : map2.keySet()) {
            arrayMap.put(put, r0.zzfvr);
        }
        for (zzc put2 : map.keySet()) {
            arrayMap.put(put2, r0.zzfvs);
        }
        r0.zzfvt = Collections.unmodifiableMap(arrayMap);
    }

    public static zzv zza(Context context, zzba zzba, Lock lock, Looper looper, zzf zzf, Map<zzc<?>, zze> map, zzr zzr, Map<Api<?>, Boolean> map2, zza<? extends zzcyj, zzcyk> zza, ArrayList<zzt> arrayList) {
        Map<Api<?>, Boolean> map3 = map2;
        Map arrayMap = new ArrayMap();
        Map arrayMap2 = new ArrayMap();
        zze zze = null;
        for (Entry entry : map.entrySet()) {
            zze zze2 = (zze) entry.getValue();
            if (zze2.zzacn()) {
                zze = zze2;
            }
            if (zze2.zzacc()) {
                arrayMap.put((zzc) entry.getKey(), zze2);
            } else {
                arrayMap2.put((zzc) entry.getKey(), zze2);
            }
        }
        zzbq.zza(arrayMap.isEmpty() ^ 1, (Object) "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        Map arrayMap3 = new ArrayMap();
        Map arrayMap4 = new ArrayMap();
        for (Api api : map2.keySet()) {
            zzc zzahm = api.zzahm();
            if (arrayMap.containsKey(zzahm)) {
                arrayMap3.put(api, (Boolean) map3.get(api));
            } else if (arrayMap2.containsKey(zzahm)) {
                arrayMap4.put(api, (Boolean) map3.get(api));
            } else {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            zzt zzt = (zzt) obj;
            if (arrayMap3.containsKey(zzt.zzfop)) {
                arrayList2.add(zzt);
            } else if (arrayMap4.containsKey(zzt.zzfop)) {
                arrayList3.add(zzt);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            }
        }
        return new zzv(context, zzba, lock, looper, zzf, arrayMap, arrayMap2, zzr, zza, zze, arrayList2, arrayList3, arrayMap3, arrayMap4);
    }

    private final void zza(ConnectionResult connectionResult) {
        int i = this.zzfwb;
        if (i != 1) {
            if (i != 2) {
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                this.zzfwb = 0;
            }
            this.zzfvq.zzc(connectionResult);
        }
        zzaiu();
        this.zzfwb = 0;
    }

    private final void zzait() {
        ConnectionResult connectionResult;
        if (zzb(this.zzfvx)) {
            if (!zzb(this.zzfvy)) {
                if (!zzaiv()) {
                    connectionResult = this.zzfvy;
                    if (connectionResult != null) {
                        if (this.zzfwb == 1) {
                            zzaiu();
                            return;
                        }
                        zza(connectionResult);
                        this.zzfvr.disconnect();
                        return;
                    }
                }
            }
            int i = this.zzfwb;
            if (i != 1) {
                if (i != 2) {
                    Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                    this.zzfwb = 0;
                }
                this.zzfvq.zzk(this.zzfvw);
            }
            zzaiu();
            this.zzfwb = 0;
        } else if (this.zzfvx == null || !zzb(this.zzfvy)) {
            connectionResult = this.zzfvx;
            if (connectionResult != null) {
                ConnectionResult connectionResult2 = this.zzfvy;
                if (connectionResult2 != null) {
                    if (this.zzfvs.zzfzb < this.zzfvr.zzfzb) {
                        connectionResult = connectionResult2;
                    }
                    zza(connectionResult);
                }
            }
        } else {
            this.zzfvs.disconnect();
            zza(this.zzfvx);
        }
    }

    private final void zzaiu() {
        for (zzcu zzacm : this.zzfvu) {
            zzacm.zzacm();
        }
        this.zzfvu.clear();
    }

    private final boolean zzaiv() {
        ConnectionResult connectionResult = this.zzfvy;
        return connectionResult != null && connectionResult.getErrorCode() == 4;
    }

    private final PendingIntent zzaiw() {
        return this.zzfvv == null ? null : PendingIntent.getActivity(this.mContext, System.identityHashCode(this.zzfvq), this.zzfvv.getSignInIntent(), 134217728);
    }

    private static boolean zzb(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    private final void zze(int i, boolean z) {
        this.zzfvq.zzf(i, z);
        this.zzfvy = null;
        this.zzfvx = null;
    }

    private final boolean zzf(zzm<? extends Result, ? extends zzb> zzm) {
        zzc zzahm = zzm.zzahm();
        zzbq.checkArgument(this.zzfvt.containsKey(zzahm), "GoogleApiClient is not configured to use the API required for this call.");
        return ((zzbi) this.zzfvt.get(zzahm)).equals(this.zzfvs);
    }

    private final void zzj(Bundle bundle) {
        Bundle bundle2 = this.zzfvw;
        if (bundle2 == null) {
            this.zzfvw = bundle;
            return;
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    public final ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException();
    }

    public final ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public final void connect() {
        this.zzfwb = 2;
        this.zzfvz = false;
        this.zzfvy = null;
        this.zzfvx = null;
        this.zzfvr.connect();
        this.zzfvs.connect();
    }

    public final void disconnect() {
        this.zzfvy = null;
        this.zzfvx = null;
        this.zzfwb = 0;
        this.zzfvr.disconnect();
        this.zzfvs.disconnect();
        zzaiu();
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = ":";
        printWriter.append(str).append("authClient").println(str2);
        String str3 = "  ";
        this.zzfvs.dump(String.valueOf(str).concat(str3), fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(str2);
        this.zzfvr.dump(String.valueOf(str).concat(str3), fileDescriptor, printWriter, strArr);
    }

    public final ConnectionResult getConnectionResult(Api<?> api) {
        return ((zzbi) this.zzfvt.get(api.zzahm())).equals(this.zzfvs) ? zzaiv() ? new ConnectionResult(4, zzaiw()) : this.zzfvs.getConnectionResult(api) : this.zzfvr.getConnectionResult(api);
    }

    public final boolean isConnected() {
        this.zzfwa.lock();
        try {
            boolean z = true;
            if (this.zzfvr.isConnected()) {
                if (!(this.zzfvs.isConnected() || zzaiv())) {
                    if (this.zzfwb == 1) {
                    }
                }
                this.zzfwa.unlock();
                return z;
            }
            z = false;
            this.zzfwa.unlock();
            return z;
        } catch (Throwable th) {
            this.zzfwa.unlock();
        }
    }

    public final boolean isConnecting() {
        this.zzfwa.lock();
        try {
            boolean z = this.zzfwb == 2;
            this.zzfwa.unlock();
            return z;
        } catch (Throwable th) {
            this.zzfwa.unlock();
        }
    }

    public final boolean zza(zzcu zzcu) {
        this.zzfwa.lock();
        boolean z;
        try {
            if ((isConnecting() || isConnected()) && !this.zzfvs.isConnected()) {
                this.zzfvu.add(zzcu);
                z = true;
                if (this.zzfwb == 0) {
                    this.zzfwb = 1;
                }
                this.zzfvy = null;
                this.zzfvs.connect();
                return z;
            }
            this.zzfwa.unlock();
            return false;
        } finally {
            z = this.zzfwa;
            z.unlock();
        }
    }

    public final void zzaia() {
        this.zzfwa.lock();
        try {
            boolean isConnecting = isConnecting();
            this.zzfvs.disconnect();
            this.zzfvy = new ConnectionResult(4);
            if (isConnecting) {
                new Handler(this.zzalj).post(new zzw(this));
            } else {
                zzaiu();
            }
            this.zzfwa.unlock();
        } catch (Throwable th) {
            this.zzfwa.unlock();
        }
    }

    public final void zzais() {
        this.zzfvr.zzais();
        this.zzfvs.zzais();
    }

    public final <A extends zzb, R extends Result, T extends zzm<R, A>> T zzd(T t) {
        if (!zzf((zzm) t)) {
            return this.zzfvr.zzd(t);
        }
        if (!zzaiv()) {
            return this.zzfvs.zzd(t);
        }
        t.zzu(new Status(4, null, zzaiw()));
        return t;
    }

    public final <A extends zzb, T extends zzm<? extends Result, A>> T zze(T t) {
        if (!zzf((zzm) t)) {
            return this.zzfvr.zze(t);
        }
        if (!zzaiv()) {
            return this.zzfvs.zze(t);
        }
        t.zzu(new Status(4, null, zzaiw()));
        return t;
    }
}
