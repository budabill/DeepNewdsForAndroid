package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.Hide;
import java.util.concurrent.TimeUnit;

public abstract class PendingResult<R extends Result> {

    @Hide
    public interface zza {
        @Hide
        void zzr(Status status);
    }

    public abstract R await();

    public abstract R await(long j, TimeUnit timeUnit);

    public abstract void cancel();

    public abstract boolean isCanceled();

    public abstract void setResultCallback(ResultCallback<? super R> resultCallback);

    public abstract void setResultCallback(ResultCallback<? super R> resultCallback, long j, TimeUnit timeUnit);

    public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        throw new UnsupportedOperationException();
    }

    @Hide
    public void zza(zza zza) {
        throw new UnsupportedOperationException();
    }

    @Hide
    public Integer zzaid() {
        throw new UnsupportedOperationException();
    }
}
