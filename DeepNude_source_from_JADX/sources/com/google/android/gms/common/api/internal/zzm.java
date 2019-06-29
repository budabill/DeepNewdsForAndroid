package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzbz;

public abstract class zzm<R extends Result, A extends zzb> extends BasePendingResult<R> implements zzn<R> {
    private final Api<?> zzfop;
    private final zzc<A> zzfus;

    @Deprecated
    protected zzm(zzc<A> zzc, GoogleApiClient googleApiClient) {
        zzbq.checkNotNull(googleApiClient, "GoogleApiClient must not be null");
        super(googleApiClient);
        zzbq.checkNotNull(zzc);
        this.zzfus = zzc;
        this.zzfop = null;
    }

    protected zzm(Api<?> api, GoogleApiClient googleApiClient) {
        zzbq.checkNotNull(googleApiClient, "GoogleApiClient must not be null");
        super(googleApiClient);
        zzbq.checkNotNull(api, "Api must not be null");
        this.zzfus = api.zzahm();
        this.zzfop = api;
    }

    private final void zzc(RemoteException remoteException) {
        zzu(new Status(8, remoteException.getLocalizedMessage(), null));
    }

    @Hide
    public /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((Result) obj);
    }

    @Hide
    protected abstract void zza(A a);

    @Hide
    public final zzc<A> zzahm() {
        return this.zzfus;
    }

    @Hide
    public final Api<?> zzaht() {
        return this.zzfop;
    }

    @Hide
    public final void zzb(A a) {
        if (a instanceof zzbz) {
            zzbz.zzanb();
            throw null;
        }
        try {
            zza(a);
        } catch (RemoteException e) {
            zzc(e);
            throw e;
        } catch (RemoteException e2) {
            zzc(e2);
        }
    }

    @Hide
    public final void zzu(Status status) {
        zzbq.checkArgument(status.isSuccess() ^ 1, "Failed result must not be success");
        setResult(zzb(status));
    }
}
