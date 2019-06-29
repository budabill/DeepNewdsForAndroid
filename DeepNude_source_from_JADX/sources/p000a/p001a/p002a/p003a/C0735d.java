package p000a.p001a.p002a.p003a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: a.a.a.a.d */
public class C0735d extends C0002e {
    /* renamed from: a */
    private final Object f1682a = new Object();
    /* renamed from: b */
    private ExecutorService f1683b = Executors.newFixedThreadPool(2);
    /* renamed from: c */
    private volatile Handler f1684c;

    /* renamed from: a */
    public void mo1a(Runnable runnable) {
        this.f1683b.execute(runnable);
    }

    /* renamed from: a */
    public boolean mo2a() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* renamed from: b */
    public void mo3b(Runnable runnable) {
        if (this.f1684c == null) {
            synchronized (this.f1682a) {
                if (this.f1684c == null) {
                    this.f1684c = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.f1684c.post(runnable);
    }
}
