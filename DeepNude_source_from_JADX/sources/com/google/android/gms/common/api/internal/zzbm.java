package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.ArraySet;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Hide
public final class zzbm implements Callback {
    private static final Object sLock = new Object();
    public static final Status zzfzg = new Status(4, "Sign-out occurred while this API call was in progress.");
    private static final Status zzfzh = new Status(4, "The user must be signed in to make this API call.");
    private static zzbm zzfzj;
    private final Context mContext;
    private final Handler mHandler;
    private final GoogleApiAvailability zzftg;
    private final Map<zzh<?>, zzbo<?>> zzfwg = new ConcurrentHashMap(5, 0.75f, 1);
    private long zzfyf = 120000;
    private long zzfyg = 5000;
    private long zzfzi = 10000;
    private int zzfzk = -1;
    private final AtomicInteger zzfzl = new AtomicInteger(1);
    private final AtomicInteger zzfzm = new AtomicInteger(0);
    private zzah zzfzn = null;
    private final Set<zzh<?>> zzfzo = new ArraySet();
    private final Set<zzh<?>> zzfzp = new ArraySet();

    private zzbm(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.mContext = context;
        this.mHandler = new Handler(looper, this);
        this.zzftg = googleApiAvailability;
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(6));
    }

    public static zzbm zzajy() {
        zzbm zzbm;
        synchronized (sLock) {
            zzbq.checkNotNull(zzfzj, "Must guarantee manager is non-null before using getInstance");
            zzbm = zzfzj;
        }
        return zzbm;
    }

    public static void zzajz() {
        synchronized (sLock) {
            if (zzfzj != null) {
                zzbm zzbm = zzfzj;
                zzbm.zzfzm.incrementAndGet();
                zzbm.mHandler.sendMessageAtFrontOfQueue(zzbm.mHandler.obtainMessage(10));
            }
        }
    }

    private final void zzakb() {
        for (zzh remove : this.zzfzp) {
            ((zzbo) this.zzfwg.remove(remove)).signOut();
        }
        this.zzfzp.clear();
    }

    private final void zzb(GoogleApi<?> googleApi) {
        zzh zzahv = googleApi.zzahv();
        zzbo zzbo = (zzbo) this.zzfwg.get(zzahv);
        if (zzbo == null) {
            zzbo = new zzbo(this, googleApi);
            this.zzfwg.put(zzahv, zzbo);
        }
        if (zzbo.zzacc()) {
            this.zzfzp.add(zzahv);
        }
        zzbo.connect();
    }

    public static zzbm zzck(Context context) {
        zzbm zzbm;
        synchronized (sLock) {
            if (zzfzj == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                zzfzj = new zzbm(context.getApplicationContext(), handlerThread.getLooper(), GoogleApiAvailability.getInstance());
            }
            zzbm = zzfzj;
        }
        return zzbm;
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        long j = 300000;
        String str = "GoogleApiManager";
        zzbo zzbo;
        zzbo zzbo2;
        switch (i) {
            case 1:
                if (((Boolean) message.obj).booleanValue()) {
                    j = 10000;
                }
                this.zzfzi = j;
                this.mHandler.removeMessages(12);
                for (zzh zzh : this.zzfwg.keySet()) {
                    Handler handler = this.mHandler;
                    handler.sendMessageDelayed(handler.obtainMessage(12, zzh), this.zzfzi);
                }
                break;
            case 2:
                zzj zzj = (zzj) message.obj;
                for (zzh zzh2 : zzj.zzaii()) {
                    zzbo = (zzbo) this.zzfwg.get(zzh2);
                    if (zzbo == null) {
                        zzj.zza(zzh2, new ConnectionResult(13), null);
                        break;
                    } else if (zzbo.isConnected()) {
                        zzj.zza(zzh2, ConnectionResult.zzfqt, zzbo.zzaix().zzahp());
                    } else if (zzbo.zzakj() != null) {
                        zzj.zza(zzh2, zzbo.zzakj(), null);
                    } else {
                        zzbo.zza(zzj);
                    }
                }
                break;
            case 3:
                for (zzbo zzbo22 : this.zzfwg.values()) {
                    zzbo22.zzaki();
                    zzbo22.connect();
                }
                break;
            case 4:
            case 8:
            case 13:
                zzcp zzcp = (zzcp) message.obj;
                zzbo22 = (zzbo) this.zzfwg.get(zzcp.zzgba.zzahv());
                if (zzbo22 == null) {
                    zzb(zzcp.zzgba);
                    zzbo22 = (zzbo) this.zzfwg.get(zzcp.zzgba.zzahv());
                }
                if (zzbo22.zzacc() && this.zzfzm.get() != zzcp.zzgaz) {
                    zzcp.zzgay.zzs(zzfzg);
                    zzbo22.signOut();
                    break;
                }
                zzbo22.zza(zzcp.zzgay);
                break;
                break;
            case 5:
                StringBuilder stringBuilder;
                String errorMessage;
                StringBuilder stringBuilder2;
                i = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                for (zzbo zzbo3 : this.zzfwg.values()) {
                    if (zzbo3.getInstanceId() == i) {
                        if (zzbo3 != null) {
                            stringBuilder = new StringBuilder(76);
                            stringBuilder.append("Could not find API instance ");
                            stringBuilder.append(i);
                            stringBuilder.append(" while trying to fail enqueued calls.");
                            Log.wtf(str, stringBuilder.toString(), new Exception());
                            break;
                        }
                        str = this.zzftg.getErrorString(connectionResult.getErrorCode());
                        errorMessage = connectionResult.getErrorMessage();
                        stringBuilder2 = new StringBuilder((String.valueOf(str).length() + 69) + String.valueOf(errorMessage).length());
                        stringBuilder2.append("Error resolution was canceled by the user, original error message: ");
                        stringBuilder2.append(str);
                        stringBuilder2.append(": ");
                        stringBuilder2.append(errorMessage);
                        zzbo3.zzw(new Status(17, stringBuilder2.toString()));
                        break;
                    }
                }
                zzbo3 = null;
                if (zzbo3 != null) {
                    stringBuilder = new StringBuilder(76);
                    stringBuilder.append("Could not find API instance ");
                    stringBuilder.append(i);
                    stringBuilder.append(" while trying to fail enqueued calls.");
                    Log.wtf(str, stringBuilder.toString(), new Exception());
                } else {
                    str = this.zzftg.getErrorString(connectionResult.getErrorCode());
                    errorMessage = connectionResult.getErrorMessage();
                    stringBuilder2 = new StringBuilder((String.valueOf(str).length() + 69) + String.valueOf(errorMessage).length());
                    stringBuilder2.append("Error resolution was canceled by the user, original error message: ");
                    stringBuilder2.append(str);
                    stringBuilder2.append(": ");
                    stringBuilder2.append(errorMessage);
                    zzbo3.zzw(new Status(17, stringBuilder2.toString()));
                }
            case 6:
                if (this.mContext.getApplicationContext() instanceof Application) {
                    zzk.zza((Application) this.mContext.getApplicationContext());
                    zzk.zzaij().zza(new zzbn(this));
                    if (!zzk.zzaij().zzbi(true)) {
                        this.zzfzi = 300000;
                        break;
                    }
                }
                break;
            case 7:
                zzb((GoogleApi) message.obj);
                break;
            case 9:
                if (this.zzfwg.containsKey(message.obj)) {
                    ((zzbo) this.zzfwg.get(message.obj)).resume();
                    break;
                }
                break;
            case 10:
                zzakb();
                break;
            case 11:
                if (this.zzfwg.containsKey(message.obj)) {
                    ((zzbo) this.zzfwg.get(message.obj)).zzajr();
                    break;
                }
                break;
            case 12:
                if (this.zzfwg.containsKey(message.obj)) {
                    ((zzbo) this.zzfwg.get(message.obj)).zzakm();
                    break;
                }
                break;
            default:
                StringBuilder stringBuilder3 = new StringBuilder(31);
                stringBuilder3.append("Unknown message id: ");
                stringBuilder3.append(i);
                Log.w(str, stringBuilder3.toString());
                return false;
        }
        return true;
    }

    final PendingIntent zza(zzh<?> zzh, int i) {
        zzbo zzbo = (zzbo) this.zzfwg.get(zzh);
        if (zzbo == null) {
            return null;
        }
        zze zzakn = zzbo.zzakn();
        return zzakn == null ? null : PendingIntent.getActivity(this.mContext, i, zzakn.getSignInIntent(), 134217728);
    }

    public final <O extends ApiOptions> Task<Boolean> zza(GoogleApi<O> googleApi, zzck<?> zzck) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zza zzf = new zzf(zzck, taskCompletionSource);
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(13, new zzcp(zzf, this.zzfzm.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    public final <O extends ApiOptions> Task<Void> zza(GoogleApi<O> googleApi, zzcq<zzb, ?> zzcq, zzdo<zzb, ?> zzdo) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zza zzd = new zzd(new zzcr(zzcq, zzdo), taskCompletionSource);
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(8, new zzcp(zzd, this.zzfzm.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    public final Task<Map<zzh<?>, String>> zza(Iterable<? extends GoogleApi<?>> iterable) {
        zzj zzj = new zzj(iterable);
        for (GoogleApi googleApi : iterable) {
            zzbo zzbo = (zzbo) this.zzfwg.get(googleApi.zzahv());
            if (zzbo != null) {
                if (zzbo.isConnected()) {
                    zzj.zza(googleApi.zzahv(), ConnectionResult.zzfqt, zzbo.zzaix().zzahp());
                }
            }
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(2, zzj));
            return zzj.getTask();
        }
        return zzj.getTask();
    }

    public final void zza(ConnectionResult connectionResult, int i) {
        if (!zzc(connectionResult, i)) {
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(5, i, 0, connectionResult));
        }
    }

    public final void zza(GoogleApi<?> googleApi) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(7, googleApi));
    }

    public final <O extends ApiOptions, TResult> void zza(GoogleApi<O> googleApi, int i, zzde<zzb, TResult> zzde, TaskCompletionSource<TResult> taskCompletionSource, zzda zzda) {
        zza zze = new zze(i, zzde, taskCompletionSource, zzda);
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(4, new zzcp(zze, this.zzfzm.get(), googleApi)));
    }

    public final <O extends ApiOptions> void zza(GoogleApi<O> googleApi, int i, zzm<? extends Result, zzb> zzm) {
        zza zzc = new zzc(i, zzm);
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(4, new zzcp(zzc, this.zzfzm.get(), googleApi)));
    }

    public final void zza(zzah zzah) {
        synchronized (sLock) {
            if (this.zzfzn != zzah) {
                this.zzfzn = zzah;
                this.zzfzo.clear();
                this.zzfzo.addAll(zzah.zzajf());
            }
        }
    }

    final void zzaia() {
        this.zzfzm.incrementAndGet();
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(10));
    }

    public final void zzaih() {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final int zzaka() {
        return this.zzfzl.getAndIncrement();
    }

    final void zzb(zzah zzah) {
        synchronized (sLock) {
            if (this.zzfzn == zzah) {
                this.zzfzn = null;
                this.zzfzo.clear();
            }
        }
    }

    final boolean zzc(ConnectionResult connectionResult, int i) {
        return this.zzftg.zza(this.mContext, connectionResult, i);
    }
}
