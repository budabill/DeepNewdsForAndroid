package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zzf;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzd<T extends IInterface> {
    @Hide
    private static String[] zzgfi = new String[]{"service_esmobile", "service_googleme"};
    private final Context mContext;
    final Handler mHandler;
    private final Object mLock;
    private final Looper zzalj;
    private final zzf zzfwk;
    private int zzgen;
    private long zzgeo;
    private long zzgep;
    private int zzgeq;
    private long zzger;
    private zzam zzges;
    private final zzag zzget;
    private final Object zzgeu;
    private zzay zzgev;
    protected zzj zzgew;
    private T zzgex;
    private final ArrayList<zzi<?>> zzgey;
    private zzl zzgez;
    private int zzgfa;
    private final zzf zzgfb;
    private final zzg zzgfc;
    private final int zzgfd;
    private final String zzgfe;
    private ConnectionResult zzgff;
    private boolean zzgfg;
    protected AtomicInteger zzgfh;

    protected zzd(Context context, Looper looper, int i, zzf zzf, zzg zzg, String str) {
        zzag zzcp = zzag.zzcp(context);
        zzf zzahf = zzf.zzahf();
        zzbq.checkNotNull(zzf);
        zzf zzf2 = zzf;
        zzbq.checkNotNull(zzg);
        this(context, looper, zzcp, zzahf, i, zzf2, zzg, null);
    }

    protected zzd(Context context, Looper looper, zzag zzag, zzf zzf, int i, zzf zzf2, zzg zzg, String str) {
        this.mLock = new Object();
        this.zzgeu = new Object();
        this.zzgey = new ArrayList();
        this.zzgfa = 1;
        this.zzgff = null;
        this.zzgfg = false;
        this.zzgfh = new AtomicInteger(0);
        zzbq.checkNotNull(context, "Context must not be null");
        this.mContext = context;
        zzbq.checkNotNull(looper, "Looper must not be null");
        this.zzalj = looper;
        zzbq.checkNotNull(zzag, "Supervisor must not be null");
        this.zzget = zzag;
        zzbq.checkNotNull(zzf, "API availability must not be null");
        this.zzfwk = zzf;
        this.mHandler = new zzh(this, looper);
        this.zzgfd = i;
        this.zzgfb = zzf2;
        this.zzgfc = zzg;
        this.zzgfe = str;
    }

    private final void zza(int i, T t) {
        zzbq.checkArgument((i == 4 ? 1 : null) == (t != null ? 1 : null));
        synchronized (this.mLock) {
            this.zzgfa = i;
            this.zzgex = t;
            zzb(i, t);
            if (i != 1) {
                if (i == 2 || i == 3) {
                    String zzamx;
                    String packageName;
                    if (!(this.zzgez == null || this.zzges == null)) {
                        zzamx = this.zzges.zzamx();
                        packageName = this.zzges.getPackageName();
                        StringBuilder stringBuilder = new StringBuilder((String.valueOf(zzamx).length() + 70) + String.valueOf(packageName).length());
                        stringBuilder.append("Calling connect() while still connected, missing disconnect() for ");
                        stringBuilder.append(zzamx);
                        stringBuilder.append(" on ");
                        stringBuilder.append(packageName);
                        Log.e("GmsClient", stringBuilder.toString());
                        this.zzget.zza(this.zzges.zzamx(), this.zzges.getPackageName(), this.zzges.zzamu(), this.zzgez, zzalr());
                        this.zzgfh.incrementAndGet();
                    }
                    this.zzgez = new zzl(this, this.zzgfh.get());
                    this.zzges = new zzam(zzalq(), zzhm(), false, 129);
                    if (!this.zzget.zza(new zzah(this.zzges.zzamx(), this.zzges.getPackageName(), this.zzges.zzamu()), this.zzgez, zzalr())) {
                        zzamx = this.zzges.zzamx();
                        packageName = this.zzges.getPackageName();
                        StringBuilder stringBuilder2 = new StringBuilder((String.valueOf(zzamx).length() + 34) + String.valueOf(packageName).length());
                        stringBuilder2.append("unable to connect to service: ");
                        stringBuilder2.append(zzamx);
                        stringBuilder2.append(" on ");
                        stringBuilder2.append(packageName);
                        Log.e("GmsClient", stringBuilder2.toString());
                        zza(16, null, this.zzgfh.get());
                    }
                } else if (i == 4) {
                    zza((IInterface) t);
                }
            } else if (this.zzgez != null) {
                this.zzget.zza(zzhm(), zzalq(), 129, this.zzgez, zzalr());
                this.zzgez = null;
            }
        }
    }

    private final boolean zza(int i, int i2, T t) {
        synchronized (this.mLock) {
            if (this.zzgfa != i) {
                return false;
            }
            zza(i2, (IInterface) t);
            return true;
        }
    }

    @Hide
    private final String zzalr() {
        String str = this.zzgfe;
        return str == null ? this.mContext.getClass().getName() : str;
    }

    @Hide
    private final boolean zzalt() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzgfa == 3;
        }
        return z;
    }

    private final boolean zzalz() {
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
        r2 = this;
        r0 = r2.zzgfg;
        r1 = 0;
        if (r0 == 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r0 = r2.zzhn();
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x0011;
    L_0x0010:
        return r1;
    L_0x0011:
        r0 = 0;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x0019;
    L_0x0018:
        return r1;
    L_0x0019:
        r0 = r2.zzhn();	 Catch:{ ClassNotFoundException -> 0x0022 }
        java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0022 }
        r0 = 1;
        return r0;
    L_0x0022:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzd.zzalz():boolean");
    }

    @Hide
    private final void zzce(int i) {
        if (zzalt()) {
            i = 5;
            this.zzgfg = true;
        } else {
            i = 4;
        }
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(i, this.zzgfh.get(), 16));
    }

    public void disconnect() {
        this.zzgfh.incrementAndGet();
        synchronized (this.zzgey) {
            int size = this.zzgey.size();
            for (int i = 0; i < size; i++) {
                ((zzi) this.zzgey.get(i)).removeListener();
            }
            this.zzgey.clear();
        }
        synchronized (this.zzgeu) {
            this.zzgev = null;
        }
        zza(1, null);
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        synchronized (this.mLock) {
            i = this.zzgfa;
            IInterface iInterface = this.zzgex;
        }
        synchronized (this.zzgeu) {
            IInterface iInterface2 = this.zzgev;
        }
        printWriter.append(str).append("mConnectState=");
        String str2 = i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "UNKNOWN" : "DISCONNECTING" : "CONNECTED" : "LOCAL_CONNECTING" : "REMOTE_CONNECTING" : "DISCONNECTED";
        printWriter.print(str2);
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.append("null");
        } else {
            printWriter.append(zzhn()).append("@").append(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (iInterface2 == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(iInterface2.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzgep > 0) {
            PrintWriter append = printWriter.append(str).append("lastConnectedTime=");
            long j = this.zzgep;
            String format = simpleDateFormat.format(new Date(j));
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(format).length() + 21);
            stringBuilder.append(j);
            stringBuilder.append(" ");
            stringBuilder.append(format);
            append.println(stringBuilder.toString());
        }
        if (this.zzgeo > 0) {
            printWriter.append(str).append("lastSuspendedCause=");
            i = this.zzgen;
            CharSequence valueOf = i != 1 ? i != 2 ? String.valueOf(i) : "CAUSE_NETWORK_LOST" : "CAUSE_SERVICE_DISCONNECTED";
            printWriter.append(valueOf);
            append = printWriter.append(" lastSuspendedTime=");
            long j2 = this.zzgeo;
            String format2 = simpleDateFormat.format(new Date(j2));
            StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(format2).length() + 21);
            stringBuilder2.append(j2);
            stringBuilder2.append(" ");
            stringBuilder2.append(format2);
            append.println(stringBuilder2.toString());
        }
        if (this.zzger > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(this.zzgeq));
            PrintWriter append2 = printWriter.append(" lastFailedTime=");
            long j3 = this.zzger;
            String format3 = simpleDateFormat.format(new Date(j3));
            StringBuilder stringBuilder3 = new StringBuilder(String.valueOf(format3).length() + 21);
            stringBuilder3.append(j3);
            stringBuilder3.append(" ");
            stringBuilder3.append(format3);
            append2.println(stringBuilder3.toString());
        }
    }

    public Account getAccount() {
        return null;
    }

    @Hide
    public final Context getContext() {
        return this.mContext;
    }

    @Hide
    public final Looper getLooper() {
        return this.zzalj;
    }

    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public final boolean isConnected() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzgfa == 4;
        }
        return z;
    }

    public final boolean isConnecting() {
        boolean z;
        synchronized (this.mLock) {
            if (this.zzgfa != 2) {
                if (this.zzgfa != 3) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    protected void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzgeq = connectionResult.getErrorCode();
        this.zzger = System.currentTimeMillis();
    }

    protected void onConnectionSuspended(int i) {
        this.zzgen = i;
        this.zzgeo = System.currentTimeMillis();
    }

    @Hide
    protected final void zza(int i, Bundle bundle, int i2) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(7, i2, -1, new zzo(this, i, null)));
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(1, i2, -1, new zzn(this, i, iBinder, bundle)));
    }

    protected void zza(T t) {
        this.zzgep = System.currentTimeMillis();
    }

    @Hide
    public final void zza(zzan zzan, Set<Scope> set) {
        Throwable e;
        Bundle zzabt = zzabt();
        zzz zzz = new zzz(this.zzgfd);
        zzz.zzggd = this.mContext.getPackageName();
        zzz.zzggg = zzabt;
        if (set != null) {
            zzz.zzggf = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (zzacc()) {
            zzz.zzggh = getAccount() != null ? getAccount() : new Account("<<default account>>", "com.google");
            if (zzan != null) {
                zzz.zzgge = zzan.asBinder();
            }
        } else if (zzalx()) {
            zzz.zzggh = getAccount();
        }
        zzz.zzggi = zzalu();
        try {
            synchronized (this.zzgeu) {
                if (this.zzgev != null) {
                    this.zzgev.zza(new zzk(this, this.zzgfh.get()), zzz);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (Throwable e2) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            zzcd(1);
        } catch (SecurityException e3) {
            throw e3;
        } catch (RemoteException e4) {
            e2 = e4;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            zza(8, null, null, this.zzgfh.get());
        } catch (RuntimeException e5) {
            e2 = e5;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            zza(8, null, null, this.zzgfh.get());
        }
    }

    public void zza(zzj zzj) {
        zzbq.checkNotNull(zzj, "Connection progress callbacks cannot be null.");
        this.zzgew = zzj;
        zza(2, null);
    }

    protected final void zza(zzj zzj, int i, PendingIntent pendingIntent) {
        zzbq.checkNotNull(zzj, "Connection progress callbacks cannot be null.");
        this.zzgew = zzj;
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(3, this.zzgfh.get(), i, pendingIntent));
    }

    public void zza(zzp zzp) {
        zzp.zzako();
    }

    @Hide
    protected Bundle zzabt() {
        return new Bundle();
    }

    public boolean zzacc() {
        return false;
    }

    public boolean zzacn() {
        return false;
    }

    public Bundle zzagp() {
        return null;
    }

    public boolean zzahn() {
        return true;
    }

    public final IBinder zzaho() {
        synchronized (this.zzgeu) {
            if (this.zzgev == null) {
                return null;
            }
            IBinder asBinder = this.zzgev.asBinder();
            return asBinder;
        }
    }

    @Hide
    public final String zzahp() {
        if (isConnected()) {
            zzam zzam = this.zzges;
            if (zzam != null) {
                return zzam.getPackageName();
            }
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    @Hide
    protected String zzalq() {
        return "com.google.android.gms";
    }

    public final void zzals() {
        int isGooglePlayServicesAvailable = this.zzfwk.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable != 0) {
            zza(1, null);
            zza(new zzm(this), isGooglePlayServicesAvailable, null);
            return;
        }
        zza(new zzm(this));
    }

    public zzc[] zzalu() {
        return new zzc[0];
    }

    @Hide
    protected final void zzalv() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    @Hide
    public final T zzalw() {
        T t;
        synchronized (this.mLock) {
            if (this.zzgfa != 5) {
                zzalv();
                zzbq.zza(this.zzgex != null, (Object) "Client is connected but service is null");
                t = this.zzgex;
            } else {
                throw new DeadObjectException();
            }
        }
        return t;
    }

    public boolean zzalx() {
        return false;
    }

    protected Set<Scope> zzaly() {
        return Collections.EMPTY_SET;
    }

    void zzb(int i, T t) {
    }

    @Hide
    public final void zzcd(int i) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(6, this.zzgfh.get(), i));
    }

    @Hide
    protected abstract T zzd(IBinder iBinder);

    @Hide
    protected abstract String zzhm();

    @Hide
    protected abstract String zzhn();
}
