package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzbz;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.zzf;
import com.google.android.gms.internal.zzcyj;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class zzbo<O extends ApiOptions> implements ConnectionCallbacks, OnConnectionFailedListener, zzu {
    private final zzh<O> zzfsn;
    private final zze zzfwd;
    private boolean zzfye;
    final /* synthetic */ zzbm zzfzq;
    private final Queue<zza> zzfzr = new LinkedList();
    private final zzb zzfzs;
    private final zzae zzfzt;
    private final Set<zzj> zzfzu = new HashSet();
    private final Map<zzck<?>, zzcr> zzfzv = new HashMap();
    private final int zzfzw;
    private final zzcv zzfzx;
    private int zzfzy = -1;
    private ConnectionResult zzfzz = null;

    public zzbo(zzbm zzbm, GoogleApi<O> googleApi) {
        this.zzfzq = zzbm;
        this.zzfwd = googleApi.zza(zzbm.mHandler.getLooper(), this);
        zzb zzb = this.zzfwd;
        if (zzb instanceof zzbz) {
            zzbz.zzanb();
            throw null;
        }
        this.zzfzs = zzb;
        this.zzfsn = googleApi.zzahv();
        this.zzfzt = new zzae();
        this.zzfzw = googleApi.getInstanceId();
        if (this.zzfwd.zzacc()) {
            this.zzfzx = googleApi.zza(zzbm.mContext, zzbm.mHandler);
        } else {
            this.zzfzx = null;
        }
    }

    private final void zzake() {
        this.zzfzy = -1;
        this.zzfzq.zzfzk = -1;
    }

    private final void zzakf() {
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
        r4 = this;
        r4.zzaki();
        r0 = com.google.android.gms.common.ConnectionResult.zzfqt;
        r4.zzi(r0);
        r4.zzakk();
        r0 = r4.zzfzv;
        r0 = r0.values();
        r0 = r0.iterator();
    L_0x0015:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x0039;
    L_0x001b:
        r1 = r0.next();
        r1 = (com.google.android.gms.common.api.internal.zzcr) r1;
        r1 = r1.zzfty;	 Catch:{ DeadObjectException -> 0x0030, RemoteException -> 0x002e }
        r2 = r4.zzfzs;	 Catch:{ DeadObjectException -> 0x0030, RemoteException -> 0x002e }
        r3 = new com.google.android.gms.tasks.TaskCompletionSource;	 Catch:{ DeadObjectException -> 0x0030, RemoteException -> 0x002e }
        r3.<init>();	 Catch:{ DeadObjectException -> 0x0030, RemoteException -> 0x002e }
        r1.zzb(r2, r3);	 Catch:{ DeadObjectException -> 0x0030, RemoteException -> 0x002e }
        goto L_0x0015;
        goto L_0x0015;
    L_0x0030:
        r0 = 1;
        r4.onConnectionSuspended(r0);
        r0 = r4.zzfwd;
        r0.disconnect();
    L_0x0039:
        r0 = r4.zzfwd;
        r0 = r0.isConnected();
        if (r0 == 0) goto L_0x0055;
    L_0x0041:
        r0 = r4.zzfzr;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x0055;
    L_0x0049:
        r0 = r4.zzfzr;
        r0 = r0.remove();
        r0 = (com.google.android.gms.common.api.internal.zza) r0;
        r4.zzb(r0);
        goto L_0x0039;
    L_0x0055:
        r4.zzakl();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzbo.zzakf():void");
    }

    private final void zzakg() {
        zzaki();
        this.zzfye = true;
        this.zzfzt.zzaje();
        this.zzfzq.mHandler.sendMessageDelayed(Message.obtain(this.zzfzq.mHandler, 9, this.zzfsn), this.zzfzq.zzfyg);
        this.zzfzq.mHandler.sendMessageDelayed(Message.obtain(this.zzfzq.mHandler, 11, this.zzfsn), this.zzfzq.zzfyf);
        zzake();
    }

    private final void zzakk() {
        if (this.zzfye) {
            this.zzfzq.mHandler.removeMessages(11, this.zzfsn);
            this.zzfzq.mHandler.removeMessages(9, this.zzfsn);
            this.zzfye = false;
        }
    }

    private final void zzakl() {
        this.zzfzq.mHandler.removeMessages(12, this.zzfsn);
        this.zzfzq.mHandler.sendMessageDelayed(this.zzfzq.mHandler.obtainMessage(12, this.zzfsn), this.zzfzq.zzfzi);
    }

    private final void zzb(com.google.android.gms.common.api.internal.zza r3) {
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
        r2 = this;
        r0 = r2.zzfzt;
        r1 = r2.zzacc();
        r3.zza(r0, r1);
        r3.zza(r2);	 Catch:{ DeadObjectException -> 0x000d }
        return;
    L_0x000d:
        r3 = 1;
        r2.onConnectionSuspended(r3);
        r3 = r2.zzfwd;
        r3.disconnect();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzbo.zzb(com.google.android.gms.common.api.internal.zza):void");
    }

    private final void zzi(ConnectionResult connectionResult) {
        for (zzj zzj : this.zzfzu) {
            String str = null;
            if (connectionResult == ConnectionResult.zzfqt) {
                str = this.zzfwd.zzahp();
            }
            zzj.zza(this.zzfsn, connectionResult, str);
        }
        this.zzfzu.clear();
    }

    public final void connect() {
        zzbq.zza(this.zzfzq.mHandler);
        if (!this.zzfwd.isConnected()) {
            if (!this.zzfwd.isConnecting()) {
                if (this.zzfwd.zzahn()) {
                    this.zzfwd.zzahq();
                    if (this.zzfzq.zzfzk != 0) {
                        this.zzfzq.zzftg;
                        int zzc = zzf.zzc(this.zzfzq.mContext, this.zzfwd.zzahq());
                        this.zzfwd.zzahq();
                        this.zzfzq.zzfzk = zzc;
                        if (zzc != 0) {
                            onConnectionFailed(new ConnectionResult(zzc, null));
                            return;
                        }
                    }
                }
                zzj zzbu = new zzbu(this.zzfzq, this.zzfwd, this.zzfsn);
                if (this.zzfwd.zzacc()) {
                    this.zzfzx.zza((zzcy) zzbu);
                }
                this.zzfwd.zza(zzbu);
            }
        }
    }

    public final int getInstanceId() {
        return this.zzfzw;
    }

    final boolean isConnected() {
        return this.zzfwd.isConnected();
    }

    public final void onConnected(Bundle bundle) {
        if (Looper.myLooper() == this.zzfzq.mHandler.getLooper()) {
            zzakf();
        } else {
            this.zzfzq.mHandler.post(new zzbp(this));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onConnectionFailed(com.google.android.gms.common.ConnectionResult r5) {
        /*
        r4 = this;
        r0 = r4.zzfzq;
        r0 = r0.mHandler;
        com.google.android.gms.common.internal.zzbq.zza(r0);
        r0 = r4.zzfzx;
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        r0.zzakz();
    L_0x0010:
        r4.zzaki();
        r4.zzake();
        r4.zzi(r5);
        r0 = r5.getErrorCode();
        r1 = 4;
        if (r0 != r1) goto L_0x0028;
    L_0x0020:
        r5 = com.google.android.gms.common.api.internal.zzbm.zzfzh;
        r4.zzw(r5);
        return;
    L_0x0028:
        r0 = r4.zzfzr;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x0033;
    L_0x0030:
        r4.zzfzz = r5;
        return;
    L_0x0033:
        r0 = com.google.android.gms.common.api.internal.zzbm.sLock;
        monitor-enter(r0);
        r1 = r4.zzfzq;	 Catch:{ all -> 0x00c4 }
        r1 = r1.zzfzn;	 Catch:{ all -> 0x00c4 }
        if (r1 == 0) goto L_0x005b;
    L_0x0040:
        r1 = r4.zzfzq;	 Catch:{ all -> 0x00c4 }
        r1 = r1.zzfzo;	 Catch:{ all -> 0x00c4 }
        r2 = r4.zzfsn;	 Catch:{ all -> 0x00c4 }
        r1 = r1.contains(r2);	 Catch:{ all -> 0x00c4 }
        if (r1 == 0) goto L_0x005b;
    L_0x004e:
        r1 = r4.zzfzq;	 Catch:{ all -> 0x00c4 }
        r1 = r1.zzfzn;	 Catch:{ all -> 0x00c4 }
        r2 = r4.zzfzw;	 Catch:{ all -> 0x00c4 }
        r1.zzb(r5, r2);	 Catch:{ all -> 0x00c4 }
        monitor-exit(r0);	 Catch:{ all -> 0x00c4 }
        return;
    L_0x005b:
        monitor-exit(r0);	 Catch:{ all -> 0x00c4 }
        r0 = r4.zzfzq;
        r1 = r4.zzfzw;
        r0 = r0.zzc(r5, r1);
        if (r0 != 0) goto L_0x00c3;
    L_0x0066:
        r5 = r5.getErrorCode();
        r0 = 18;
        if (r5 != r0) goto L_0x0071;
    L_0x006e:
        r5 = 1;
        r4.zzfye = r5;
    L_0x0071:
        r5 = r4.zzfye;
        if (r5 == 0) goto L_0x0093;
    L_0x0075:
        r5 = r4.zzfzq;
        r5 = r5.mHandler;
        r0 = r4.zzfzq;
        r0 = r0.mHandler;
        r1 = 9;
        r2 = r4.zzfsn;
        r0 = android.os.Message.obtain(r0, r1, r2);
        r1 = r4.zzfzq;
        r1 = r1.zzfyg;
        r5.sendMessageDelayed(r0, r1);
        return;
    L_0x0093:
        r5 = new com.google.android.gms.common.api.Status;
        r0 = 17;
        r1 = r4.zzfsn;
        r1 = r1.zzaig();
        r2 = java.lang.String.valueOf(r1);
        r2 = r2.length();
        r2 = r2 + 38;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "API: ";
        r3.append(r2);
        r3.append(r1);
        r1 = " is not available on this device.";
        r3.append(r1);
        r1 = r3.toString();
        r5.<init>(r0, r1);
        r4.zzw(r5);
    L_0x00c3:
        return;
    L_0x00c4:
        r5 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00c4 }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzbo.onConnectionFailed(com.google.android.gms.common.ConnectionResult):void");
    }

    public final void onConnectionSuspended(int i) {
        if (Looper.myLooper() == this.zzfzq.mHandler.getLooper()) {
            zzakg();
        } else {
            this.zzfzq.mHandler.post(new zzbq(this));
        }
    }

    public final void resume() {
        zzbq.zza(this.zzfzq.mHandler);
        if (this.zzfye) {
            connect();
        }
    }

    public final void signOut() {
        zzbq.zza(this.zzfzq.mHandler);
        zzw(zzbm.zzfzg);
        this.zzfzt.zzajd();
        for (zzck zzf : (zzck[]) this.zzfzv.keySet().toArray(new zzck[this.zzfzv.size()])) {
            zza(new zzf(zzf, new TaskCompletionSource()));
        }
        zzi(new ConnectionResult(4));
        if (this.zzfwd.isConnected()) {
            this.zzfwd.zza(new zzbs(this));
        }
    }

    public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
        if (Looper.myLooper() == this.zzfzq.mHandler.getLooper()) {
            onConnectionFailed(connectionResult);
        } else {
            this.zzfzq.mHandler.post(new zzbr(this, connectionResult));
        }
    }

    public final void zza(zza zza) {
        zzbq.zza(this.zzfzq.mHandler);
        if (this.zzfwd.isConnected()) {
            zzb(zza);
            zzakl();
            return;
        }
        this.zzfzr.add(zza);
        ConnectionResult connectionResult = this.zzfzz;
        if (connectionResult == null || !connectionResult.hasResolution()) {
            connect();
        } else {
            onConnectionFailed(this.zzfzz);
        }
    }

    public final void zza(zzj zzj) {
        zzbq.zza(this.zzfzq.mHandler);
        this.zzfzu.add(zzj);
    }

    public final boolean zzacc() {
        return this.zzfwd.zzacc();
    }

    public final zze zzaix() {
        return this.zzfwd;
    }

    public final void zzajr() {
        zzbq.zza(this.zzfzq.mHandler);
        if (this.zzfye) {
            zzakk();
            zzw(this.zzfzq.zzftg.isGooglePlayServicesAvailable(this.zzfzq.mContext) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
            this.zzfwd.disconnect();
        }
    }

    public final Map<zzck<?>, zzcr> zzakh() {
        return this.zzfzv;
    }

    public final void zzaki() {
        zzbq.zza(this.zzfzq.mHandler);
        this.zzfzz = null;
    }

    public final ConnectionResult zzakj() {
        zzbq.zza(this.zzfzq.mHandler);
        return this.zzfzz;
    }

    public final void zzakm() {
        zzbq.zza(this.zzfzq.mHandler);
        if (this.zzfwd.isConnected() && this.zzfzv.size() == 0) {
            if (this.zzfzt.zzajc()) {
                zzakl();
                return;
            }
            this.zzfwd.disconnect();
        }
    }

    final zzcyj zzakn() {
        zzcv zzcv = this.zzfzx;
        return zzcv == null ? null : zzcv.zzakn();
    }

    public final void zzh(ConnectionResult connectionResult) {
        zzbq.zza(this.zzfzq.mHandler);
        this.zzfwd.disconnect();
        onConnectionFailed(connectionResult);
    }

    public final void zzw(Status status) {
        zzbq.zza(this.zzfzq.mHandler);
        for (zza zzs : this.zzfzr) {
            zzs.zzs(status);
        }
        this.zzfzr.clear();
    }
}
