package com.google.android.gms.common.api;

public class Response<T extends Result> {
    private T zzftm;

    protected Response(T t) {
        this.zzftm = t;
    }

    protected T getResult() {
        return this.zzftm;
    }

    public void setResult(T t) {
        this.zzftm = t;
    }
}
