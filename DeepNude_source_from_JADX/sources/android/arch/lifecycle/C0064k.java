package android.arch.lifecycle;

/* renamed from: android.arch.lifecycle.k */
class C0064k implements Runnable {
    /* renamed from: a */
    final /* synthetic */ LiveData f115a;

    C0064k(LiveData liveData) {
        this.f115a = liveData;
    }

    public void run() {
        Object access$100;
        synchronized (this.f115a.mDataLock) {
            access$100 = this.f115a.mPendingData;
            this.f115a.mPendingData = LiveData.NOT_SET;
        }
        this.f115a.setValue(access$100);
    }
}
