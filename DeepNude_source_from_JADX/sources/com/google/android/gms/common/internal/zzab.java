package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.zzc;
import java.util.Set;

public abstract class zzab<T extends IInterface> extends zzd<T> implements zze, zzaf {
    private final Account zzeho;
    private final Set<Scope> zzenh;
    private final zzr zzfwf;

    protected zzab(Context context, Looper looper, int i, zzr zzr, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        zzag zzcp = zzag.zzcp(context);
        GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        zzbq.checkNotNull(connectionCallbacks);
        ConnectionCallbacks connectionCallbacks2 = connectionCallbacks;
        zzbq.checkNotNull(onConnectionFailedListener);
        this(context, looper, zzcp, instance, i, zzr, connectionCallbacks2, onConnectionFailedListener);
    }

    private zzab(Context context, Looper looper, zzag zzag, GoogleApiAvailability googleApiAvailability, int i, zzr zzr, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        zzab zzab = this;
        ConnectionCallbacks connectionCallbacks2 = connectionCallbacks;
        OnConnectionFailedListener onConnectionFailedListener2 = onConnectionFailedListener;
        super(context, looper, zzag, googleApiAvailability, i, connectionCallbacks2 == null ? null : new zzac(connectionCallbacks2), onConnectionFailedListener2 == null ? null : new zzad(onConnectionFailedListener2), zzr.zzamj());
        zzab.zzfwf = zzr;
        zzab.zzeho = zzr.getAccount();
        Set zzamg = zzr.zzamg();
        Set<Scope> zzb = zzb(zzamg);
        for (Scope contains : zzb) {
            if (!zzamg.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        zzab.zzenh = zzb;
    }

    public final Account getAccount() {
        return this.zzeho;
    }

    public final int zzahq() {
        return -1;
    }

    public zzc[] zzalu() {
        return new zzc[0];
    }

    protected final Set<Scope> zzaly() {
        return this.zzenh;
    }

    protected final zzr zzamr() {
        return this.zzfwf;
    }

    @Hide
    protected Set<Scope> zzb(Set<Scope> set) {
        return set;
    }
}
