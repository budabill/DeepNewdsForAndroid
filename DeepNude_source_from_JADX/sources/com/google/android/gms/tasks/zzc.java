package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zzc<TResult, TContinuationResult> implements OnFailureListener, OnSuccessListener<TContinuationResult>, zzm<TResult> {
    private final Executor zzkou;
    private final Continuation<TResult, Task<TContinuationResult>> zzldw;
    private final zzp<TContinuationResult> zzldx;

    public zzc(Executor executor, Continuation<TResult, Task<TContinuationResult>> continuation, zzp<TContinuationResult> zzp) {
        this.zzkou = executor;
        this.zzldw = continuation;
        this.zzldx = zzp;
    }

    public final void cancel() {
        throw new UnsupportedOperationException();
    }

    public final void onComplete(Task<TResult> task) {
        this.zzkou.execute(new zzd(this, task));
    }

    public final void onFailure(Exception exception) {
        this.zzldx.setException(exception);
    }

    public final void onSuccess(TContinuationResult tContinuationResult) {
        this.zzldx.setResult(tContinuationResult);
    }
}
