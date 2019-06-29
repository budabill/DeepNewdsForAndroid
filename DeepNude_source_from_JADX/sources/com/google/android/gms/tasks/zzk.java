package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zzk<TResult, TContinuationResult> implements OnFailureListener, OnSuccessListener<TContinuationResult>, zzm<TResult> {
    private final Executor zzkou;
    private final zzp<TContinuationResult> zzldx;
    private final SuccessContinuation<TResult, TContinuationResult> zzleh;

    public zzk(Executor executor, SuccessContinuation<TResult, TContinuationResult> successContinuation, zzp<TContinuationResult> zzp) {
        this.zzkou = executor;
        this.zzleh = successContinuation;
        this.zzldx = zzp;
    }

    public final void cancel() {
        throw new UnsupportedOperationException();
    }

    public final void onComplete(Task<TResult> task) {
        this.zzkou.execute(new zzl(this, task));
    }

    public final void onFailure(Exception exception) {
        this.zzldx.setException(exception);
    }

    public final void onSuccess(TContinuationResult tContinuationResult) {
        this.zzldx.setResult(tContinuationResult);
    }
}
