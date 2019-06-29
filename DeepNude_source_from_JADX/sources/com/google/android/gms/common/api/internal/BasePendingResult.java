package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzaq;
import com.google.android.gms.common.internal.zzbq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
@Hide
public abstract class BasePendingResult<R extends Result> extends PendingResult<R> {
    static final ThreadLocal<Boolean> zzfvb = new zzs();
    @KeepName
    private zzb mResultGuardian;
    private Status mStatus;
    private boolean zzam;
    private final CountDownLatch zzapc;
    private R zzftm;
    private final Object zzfvc;
    @Hide
    private zza<R> zzfvd;
    private WeakReference<GoogleApiClient> zzfve;
    private final ArrayList<com.google.android.gms.common.api.PendingResult.zza> zzfvf;
    private ResultCallback<? super R> zzfvg;
    private final AtomicReference<zzdn> zzfvh;
    private volatile boolean zzfvi;
    private boolean zzfvj;
    private zzaq zzfvk;
    private volatile zzdh<R> zzfvl;
    private boolean zzfvm;

    @Hide
    public static class zza<R extends Result> extends Handler {
        public zza() {
            this(Looper.getMainLooper());
        }

        public zza(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                Pair pair = (Pair) message.obj;
                ResultCallback resultCallback = (ResultCallback) pair.first;
                Result result = (Result) pair.second;
                try {
                    resultCallback.onResult(result);
                } catch (RuntimeException e) {
                    BasePendingResult.zzd(result);
                    throw e;
                }
            } else if (i != 2) {
                StringBuilder stringBuilder = new StringBuilder(45);
                stringBuilder.append("Don't know how to handle message: ");
                stringBuilder.append(i);
                Log.wtf("BasePendingResult", stringBuilder.toString(), new Exception());
            } else {
                ((BasePendingResult) message.obj).zzv(Status.zzftt);
            }
        }

        public final void zza(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }
    }

    final class zzb {
        private /* synthetic */ BasePendingResult zzfvn;

        private zzb(BasePendingResult basePendingResult) {
            this.zzfvn = basePendingResult;
        }

        protected final void finalize() {
            BasePendingResult.zzd(this.zzfvn.zzftm);
            super.finalize();
        }
    }

    @Deprecated
    BasePendingResult() {
        this.zzfvc = new Object();
        this.zzapc = new CountDownLatch(1);
        this.zzfvf = new ArrayList();
        this.zzfvh = new AtomicReference();
        this.zzfvm = false;
        this.zzfvd = new zza(Looper.getMainLooper());
        this.zzfve = new WeakReference(null);
    }

    @Deprecated
    protected BasePendingResult(Looper looper) {
        this.zzfvc = new Object();
        this.zzapc = new CountDownLatch(1);
        this.zzfvf = new ArrayList();
        this.zzfvh = new AtomicReference();
        this.zzfvm = false;
        this.zzfvd = new zza(looper);
        this.zzfve = new WeakReference(null);
    }

    protected BasePendingResult(GoogleApiClient googleApiClient) {
        this.zzfvc = new Object();
        this.zzapc = new CountDownLatch(1);
        this.zzfvf = new ArrayList();
        this.zzfvh = new AtomicReference();
        this.zzfvm = false;
        this.zzfvd = new zza(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
        this.zzfve = new WeakReference(googleApiClient);
    }

    private final R get() {
        R r;
        synchronized (this.zzfvc) {
            zzbq.zza(!this.zzfvi, (Object) "Result has already been consumed.");
            zzbq.zza(isReady(), (Object) "Result is not ready.");
            r = this.zzftm;
            this.zzftm = null;
            this.zzfvg = null;
            this.zzfvi = true;
        }
        zzdn zzdn = (zzdn) this.zzfvh.getAndSet(null);
        if (zzdn != null) {
            zzdn.zzc(this);
        }
        return r;
    }

    private final void zzc(R r) {
        this.zzftm = r;
        this.zzfvk = null;
        this.zzapc.countDown();
        this.mStatus = this.zzftm.getStatus();
        if (this.zzam) {
            this.zzfvg = null;
        } else if (this.zzfvg != null) {
            this.zzfvd.removeMessages(2);
            this.zzfvd.zza(this.zzfvg, get());
        } else if (this.zzftm instanceof Releasable) {
            this.mResultGuardian = new zzb();
        }
        ArrayList arrayList = this.zzfvf;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((com.google.android.gms.common.api.PendingResult.zza) obj).zzr(this.mStatus);
        }
        this.zzfvf.clear();
    }

    @Hide
    public static void zzd(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (Throwable e) {
                String valueOf = String.valueOf(result);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 18);
                stringBuilder.append("Unable to release ");
                stringBuilder.append(valueOf);
                Log.w("BasePendingResult", stringBuilder.toString(), e);
            }
        }
    }

    public final R await() {
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
        r0 = "await must not be called on the UI thread";
        com.google.android.gms.common.internal.zzbq.zzgw(r0);
        r0 = r3.zzfvi;
        r1 = 1;
        r0 = r0 ^ r1;
        r2 = "Result has already been consumed";
        com.google.android.gms.common.internal.zzbq.zza(r0, r2);
        r0 = r3.zzfvl;
        if (r0 != 0) goto L_0x0013;
    L_0x0012:
        goto L_0x0014;
    L_0x0013:
        r1 = 0;
    L_0x0014:
        r0 = "Cannot await if then() has been called.";
        com.google.android.gms.common.internal.zzbq.zza(r1, r0);
        r0 = r3.zzapc;	 Catch:{ InterruptedException -> 0x001f }
        r0.await();	 Catch:{ InterruptedException -> 0x001f }
        goto L_0x0024;
    L_0x001f:
        r0 = com.google.android.gms.common.api.Status.zzftr;
        r3.zzv(r0);
    L_0x0024:
        r0 = r3.isReady();
        r1 = "Result is not ready.";
        com.google.android.gms.common.internal.zzbq.zza(r0, r1);
        r0 = r3.get();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.await():R");
    }

    public final R await(long r4, java.util.concurrent.TimeUnit r6) {
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
        r0 = 0;
        r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r2 <= 0) goto L_0x000b;
    L_0x0006:
        r0 = "await must not be called on the UI thread when time is greater than zero.";
        com.google.android.gms.common.internal.zzbq.zzgw(r0);
    L_0x000b:
        r0 = r3.zzfvi;
        r1 = 1;
        r0 = r0 ^ r1;
        r2 = "Result has already been consumed.";
        com.google.android.gms.common.internal.zzbq.zza(r0, r2);
        r0 = r3.zzfvl;
        if (r0 != 0) goto L_0x0019;
    L_0x0018:
        goto L_0x001a;
    L_0x0019:
        r1 = 0;
    L_0x001a:
        r0 = "Cannot await if then() has been called.";
        com.google.android.gms.common.internal.zzbq.zza(r1, r0);
        r0 = r3.zzapc;	 Catch:{ InterruptedException -> 0x002d }
        r4 = r0.await(r4, r6);	 Catch:{ InterruptedException -> 0x002d }
        if (r4 != 0) goto L_0x0032;	 Catch:{ InterruptedException -> 0x002d }
    L_0x0027:
        r4 = com.google.android.gms.common.api.Status.zzftt;	 Catch:{ InterruptedException -> 0x002d }
        r3.zzv(r4);	 Catch:{ InterruptedException -> 0x002d }
        goto L_0x0032;
    L_0x002d:
        r4 = com.google.android.gms.common.api.Status.zzftr;
        r3.zzv(r4);
    L_0x0032:
        r4 = r3.isReady();
        r5 = "Result is not ready.";
        com.google.android.gms.common.internal.zzbq.zza(r4, r5);
        r4 = r3.get();
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.await(long, java.util.concurrent.TimeUnit):R");
    }

    public void cancel() {
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
        r0 = r2.zzfvc;
        monitor-enter(r0);
        r1 = r2.zzam;	 Catch:{ all -> 0x002a }
        if (r1 != 0) goto L_0x0028;	 Catch:{ all -> 0x002a }
    L_0x0007:
        r1 = r2.zzfvi;	 Catch:{ all -> 0x002a }
        if (r1 == 0) goto L_0x000c;	 Catch:{ all -> 0x002a }
    L_0x000b:
        goto L_0x0028;	 Catch:{ all -> 0x002a }
    L_0x000c:
        r1 = r2.zzfvk;	 Catch:{ all -> 0x002a }
        if (r1 == 0) goto L_0x0015;
    L_0x0010:
        r1 = r2.zzfvk;	 Catch:{ RemoteException -> 0x0015 }
        r1.cancel();	 Catch:{ RemoteException -> 0x0015 }
    L_0x0015:
        r1 = r2.zzftm;	 Catch:{ all -> 0x002a }
        zzd(r1);	 Catch:{ all -> 0x002a }
        r1 = 1;	 Catch:{ all -> 0x002a }
        r2.zzam = r1;	 Catch:{ all -> 0x002a }
        r1 = com.google.android.gms.common.api.Status.zzftu;	 Catch:{ all -> 0x002a }
        r1 = r2.zzb(r1);	 Catch:{ all -> 0x002a }
        r2.zzc(r1);	 Catch:{ all -> 0x002a }
        monitor-exit(r0);	 Catch:{ all -> 0x002a }
        return;	 Catch:{ all -> 0x002a }
    L_0x0028:
        monitor-exit(r0);	 Catch:{ all -> 0x002a }
        return;	 Catch:{ all -> 0x002a }
    L_0x002a:
        r1 = move-exception;	 Catch:{ all -> 0x002a }
        monitor-exit(r0);	 Catch:{ all -> 0x002a }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.cancel():void");
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.zzfvc) {
            z = this.zzam;
        }
        return z;
    }

    @Hide
    public final boolean isReady() {
        return this.zzapc.getCount() == 0;
    }

    @Hide
    public final void setResult(R r) {
        synchronized (this.zzfvc) {
            if (this.zzfvj || this.zzam) {
                zzd(r);
                return;
            }
            isReady();
            boolean z = true;
            zzbq.zza(!isReady(), (Object) "Results have already been set");
            if (this.zzfvi) {
                z = false;
            }
            zzbq.zza(z, (Object) "Result has already been consumed");
            zzc(r);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<? super R> r6) {
        /*
        r5 = this;
        r0 = r5.zzfvc;
        monitor-enter(r0);
        if (r6 != 0) goto L_0x000a;
    L_0x0005:
        r6 = 0;
        r5.zzfvg = r6;	 Catch:{ all -> 0x003f }
        monitor-exit(r0);	 Catch:{ all -> 0x003f }
        return;
    L_0x000a:
        r1 = r5.zzfvi;	 Catch:{ all -> 0x003f }
        r2 = 1;
        r3 = 0;
        if (r1 != 0) goto L_0x0012;
    L_0x0010:
        r1 = 1;
        goto L_0x0013;
    L_0x0012:
        r1 = 0;
    L_0x0013:
        r4 = "Result has already been consumed.";
        com.google.android.gms.common.internal.zzbq.zza(r1, r4);	 Catch:{ all -> 0x003f }
        r1 = r5.zzfvl;	 Catch:{ all -> 0x003f }
        if (r1 != 0) goto L_0x001d;
    L_0x001c:
        goto L_0x001e;
    L_0x001d:
        r2 = 0;
    L_0x001e:
        r1 = "Cannot set callbacks if then() has been called.";
        com.google.android.gms.common.internal.zzbq.zza(r2, r1);	 Catch:{ all -> 0x003f }
        r1 = r5.isCanceled();	 Catch:{ all -> 0x003f }
        if (r1 == 0) goto L_0x002b;
    L_0x0029:
        monitor-exit(r0);	 Catch:{ all -> 0x003f }
        return;
    L_0x002b:
        r1 = r5.isReady();	 Catch:{ all -> 0x003f }
        if (r1 == 0) goto L_0x003b;
    L_0x0031:
        r1 = r5.zzfvd;	 Catch:{ all -> 0x003f }
        r2 = r5.get();	 Catch:{ all -> 0x003f }
        r1.zza(r6, r2);	 Catch:{ all -> 0x003f }
        goto L_0x003d;
    L_0x003b:
        r5.zzfvg = r6;	 Catch:{ all -> 0x003f }
    L_0x003d:
        monitor-exit(r0);	 Catch:{ all -> 0x003f }
        return;
    L_0x003f:
        r6 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x003f }
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.setResultCallback(com.google.android.gms.common.api.ResultCallback):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<? super R> r6, long r7, java.util.concurrent.TimeUnit r9) {
        /*
        r5 = this;
        r0 = r5.zzfvc;
        monitor-enter(r0);
        if (r6 != 0) goto L_0x000a;
    L_0x0005:
        r6 = 0;
        r5.zzfvg = r6;	 Catch:{ all -> 0x004d }
        monitor-exit(r0);	 Catch:{ all -> 0x004d }
        return;
    L_0x000a:
        r1 = r5.zzfvi;	 Catch:{ all -> 0x004d }
        r2 = 1;
        r3 = 0;
        if (r1 != 0) goto L_0x0012;
    L_0x0010:
        r1 = 1;
        goto L_0x0013;
    L_0x0012:
        r1 = 0;
    L_0x0013:
        r4 = "Result has already been consumed.";
        com.google.android.gms.common.internal.zzbq.zza(r1, r4);	 Catch:{ all -> 0x004d }
        r1 = r5.zzfvl;	 Catch:{ all -> 0x004d }
        if (r1 != 0) goto L_0x001d;
    L_0x001c:
        goto L_0x001e;
    L_0x001d:
        r2 = 0;
    L_0x001e:
        r1 = "Cannot set callbacks if then() has been called.";
        com.google.android.gms.common.internal.zzbq.zza(r2, r1);	 Catch:{ all -> 0x004d }
        r1 = r5.isCanceled();	 Catch:{ all -> 0x004d }
        if (r1 == 0) goto L_0x002b;
    L_0x0029:
        monitor-exit(r0);	 Catch:{ all -> 0x004d }
        return;
    L_0x002b:
        r1 = r5.isReady();	 Catch:{ all -> 0x004d }
        if (r1 == 0) goto L_0x003b;
    L_0x0031:
        r7 = r5.zzfvd;	 Catch:{ all -> 0x004d }
        r8 = r5.get();	 Catch:{ all -> 0x004d }
        r7.zza(r6, r8);	 Catch:{ all -> 0x004d }
        goto L_0x004b;
    L_0x003b:
        r5.zzfvg = r6;	 Catch:{ all -> 0x004d }
        r6 = r5.zzfvd;	 Catch:{ all -> 0x004d }
        r7 = r9.toMillis(r7);	 Catch:{ all -> 0x004d }
        r9 = 2;
        r9 = r6.obtainMessage(r9, r5);	 Catch:{ all -> 0x004d }
        r6.sendMessageDelayed(r9, r7);	 Catch:{ all -> 0x004d }
    L_0x004b:
        monitor-exit(r0);	 Catch:{ all -> 0x004d }
        return;
    L_0x004d:
        r6 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x004d }
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.setResultCallback(com.google.android.gms.common.api.ResultCallback, long, java.util.concurrent.TimeUnit):void");
    }

    @Hide
    public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        TransformedResult<S> then;
        zzbq.zza(this.zzfvi ^ true, (Object) "Result has already been consumed.");
        synchronized (this.zzfvc) {
            boolean z = false;
            zzbq.zza(this.zzfvl == null, (Object) "Cannot call then() twice.");
            zzbq.zza(this.zzfvg == null, (Object) "Cannot call then() if callbacks are set.");
            if (!this.zzam) {
                z = true;
            }
            zzbq.zza(z, (Object) "Cannot call then() if result was canceled.");
            this.zzfvm = true;
            this.zzfvl = new zzdh(this.zzfve);
            then = this.zzfvl.then(resultTransform);
            if (isReady()) {
                this.zzfvd.zza(this.zzfvl, get());
            } else {
                this.zzfvg = this.zzfvl;
            }
        }
        return then;
    }

    @Hide
    public final void zza(com.google.android.gms.common.api.PendingResult.zza zza) {
        zzbq.checkArgument(zza != null, "Callback cannot be null.");
        synchronized (this.zzfvc) {
            if (isReady()) {
                zza.zzr(this.mStatus);
            } else {
                this.zzfvf.add(zza);
            }
        }
    }

    @Hide
    public final void zza(zzdn zzdn) {
        this.zzfvh.set(zzdn);
    }

    @Hide
    protected final void zza(zzaq zzaq) {
        synchronized (this.zzfvc) {
            this.zzfvk = zzaq;
        }
    }

    @Hide
    public final Integer zzaid() {
        return null;
    }

    @Hide
    public final boolean zzaip() {
        boolean isCanceled;
        synchronized (this.zzfvc) {
            if (((GoogleApiClient) this.zzfve.get()) == null || !this.zzfvm) {
                cancel();
            }
            isCanceled = isCanceled();
        }
        return isCanceled;
    }

    @Hide
    public final void zzaiq() {
        boolean z;
        if (!this.zzfvm) {
            if (!((Boolean) zzfvb.get()).booleanValue()) {
                z = false;
                this.zzfvm = z;
            }
        }
        z = true;
        this.zzfvm = z;
    }

    @Hide
    protected abstract R zzb(Status status);

    @Hide
    public final void zzv(Status status) {
        synchronized (this.zzfvc) {
            if (!isReady()) {
                setResult(zzb(status));
                this.zzfvj = true;
            }
        }
    }
}
