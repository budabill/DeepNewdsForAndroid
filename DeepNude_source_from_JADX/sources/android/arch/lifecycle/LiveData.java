package android.arch.lifecycle;

import android.arch.lifecycle.C0058d.C0056a;
import android.arch.lifecycle.C0058d.C0057b;
import java.util.Iterator;
import java.util.Map.Entry;
import p000a.p001a.p002a.p003a.C0734c;
import p000a.p001a.p002a.p004b.C0006c;

public abstract class LiveData<T> {
    private static final Object NOT_SET = new Object();
    static final int START_VERSION = -1;
    private int mActiveCount = 0;
    private volatile Object mData;
    private final Object mDataLock = new Object();
    private boolean mDispatchInvalidated;
    private boolean mDispatchingValue;
    private C0006c<C0066n<T>, C0050b> mObservers = new C0006c();
    private volatile Object mPendingData;
    private final Runnable mPostValueRunnable;
    private int mVersion;

    /* renamed from: android.arch.lifecycle.LiveData$b */
    private abstract class C0050b {
        /* renamed from: a */
        final C0066n<T> f91a;
        /* renamed from: b */
        boolean f92b;
        /* renamed from: c */
        int f93c = -1;
        /* renamed from: d */
        final /* synthetic */ LiveData f94d;

        C0050b(LiveData liveData, C0066n<T> c0066n) {
            this.f94d = liveData;
            this.f91a = c0066n;
        }

        /* renamed from: a */
        void mo1443a() {
        }

        /* renamed from: a */
        void m82a(boolean z) {
            if (z != this.f92b) {
                this.f92b = z;
                int i = 1;
                Object obj = this.f94d.mActiveCount == 0 ? 1 : null;
                LiveData liveData = this.f94d;
                int access$300 = liveData.mActiveCount;
                if (!this.f92b) {
                    i = -1;
                }
                liveData.mActiveCount = access$300 + i;
                if (obj != null && this.f92b) {
                    this.f94d.onActive();
                }
                if (this.f94d.mActiveCount == 0 && !this.f92b) {
                    this.f94d.onInactive();
                }
                if (this.f92b) {
                    this.f94d.dispatchingValue(this);
                }
            }
        }

        /* renamed from: a */
        boolean mo1444a(C0060f c0060f) {
            return false;
        }

        /* renamed from: b */
        abstract boolean mo13b();
    }

    /* renamed from: android.arch.lifecycle.LiveData$a */
    private class C0746a extends C0050b {
        /* renamed from: e */
        final /* synthetic */ LiveData f1710e;

        C0746a(LiveData liveData, C0066n<T> c0066n) {
            this.f1710e = liveData;
            super(liveData, c0066n);
        }

        /* renamed from: b */
        boolean mo13b() {
            return true;
        }
    }

    class LifecycleBoundObserver extends C0050b implements GenericLifecycleObserver {
        /* renamed from: e */
        final C0060f f1928e;
        /* renamed from: f */
        final /* synthetic */ LiveData f1929f;

        LifecycleBoundObserver(LiveData liveData, C0060f c0060f, C0066n<T> c0066n) {
            this.f1929f = liveData;
            super(liveData, c0066n);
            this.f1928e = c0060f;
        }

        /* renamed from: a */
        void mo1443a() {
            this.f1928e.getLifecycle().mo16b(this);
        }

        /* renamed from: a */
        public void mo1442a(C0060f c0060f, C0056a c0056a) {
            if (this.f1928e.getLifecycle().mo14a() == C0057b.DESTROYED) {
                this.f1929f.removeObserver(this.f91a);
            } else {
                m82a(mo13b());
            }
        }

        /* renamed from: a */
        boolean mo1444a(C0060f c0060f) {
            return this.f1928e == c0060f;
        }

        /* renamed from: b */
        boolean mo13b() {
            return this.f1928e.getLifecycle().mo14a().m94a(C0057b.STARTED);
        }
    }

    public LiveData() {
        Object obj = NOT_SET;
        this.mData = obj;
        this.mPendingData = obj;
        this.mVersion = -1;
        this.mPostValueRunnable = new C0064k(this);
    }

    private static void assertMainThread(String str) {
        if (!C0734c.m2004b().mo2a()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot invoke ");
            stringBuilder.append(str);
            stringBuilder.append(" on a background");
            stringBuilder.append(" thread");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    private void considerNotify(C0050b c0050b) {
        if (!c0050b.f92b) {
            return;
        }
        if (c0050b.mo13b()) {
            int i = c0050b.f93c;
            int i2 = this.mVersion;
            if (i < i2) {
                c0050b.f93c = i2;
                c0050b.f91a.onChanged(this.mData);
                return;
            }
            return;
        }
        c0050b.m82a(false);
    }

    private void dispatchingValue(C0050b c0050b) {
        if (this.mDispatchingValue) {
            this.mDispatchInvalidated = true;
            return;
        }
        this.mDispatchingValue = true;
        do {
            this.mDispatchInvalidated = false;
            C0050b c0050b2;
            if (c0050b2 == null) {
                Iterator b = this.mObservers.m8b();
                while (b.hasNext()) {
                    considerNotify((C0050b) ((Entry) b.next()).getValue());
                    if (this.mDispatchInvalidated) {
                        break;
                    }
                }
            }
            considerNotify(c0050b2);
            c0050b2 = null;
        } while (this.mDispatchInvalidated);
        this.mDispatchingValue = false;
    }

    public T getValue() {
        T t = this.mData;
        return t != NOT_SET ? t : null;
    }

    int getVersion() {
        return this.mVersion;
    }

    public boolean hasActiveObservers() {
        return this.mActiveCount > 0;
    }

    public boolean hasObservers() {
        return this.mObservers.size() > 0;
    }

    public void observe(C0060f c0060f, C0066n<T> c0066n) {
        if (c0060f.getLifecycle().mo14a() != C0057b.DESTROYED) {
            C0059e lifecycleBoundObserver = new LifecycleBoundObserver(this, c0060f, c0066n);
            C0050b c0050b = (C0050b) this.mObservers.mo5b(c0066n, lifecycleBoundObserver);
            if (c0050b != null) {
                if (!c0050b.mo1444a(c0060f)) {
                    throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
                }
            }
            if (c0050b == null) {
                c0060f.getLifecycle().mo15a(lifecycleBoundObserver);
            }
        }
    }

    public void observeForever(C0066n<T> c0066n) {
        C0050b c0746a = new C0746a(this, c0066n);
        C0050b c0050b = (C0050b) this.mObservers.mo5b(c0066n, c0746a);
        if (c0050b != null) {
            if (c0050b instanceof LifecycleBoundObserver) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            }
        }
        if (c0050b == null) {
            c0746a.m82a(true);
        }
    }

    protected void onActive() {
    }

    protected void onInactive() {
    }

    protected void postValue(T t) {
        synchronized (this.mDataLock) {
            Object obj = this.mPendingData == NOT_SET ? 1 : null;
            this.mPendingData = t;
        }
        if (obj != null) {
            C0734c.m2004b().mo3b(this.mPostValueRunnable);
        }
    }

    public void removeObserver(C0066n<T> c0066n) {
        assertMainThread("removeObserver");
        C0050b c0050b = (C0050b) this.mObservers.remove(c0066n);
        if (c0050b != null) {
            c0050b.mo1443a();
            c0050b.m82a(false);
        }
    }

    public void removeObservers(C0060f c0060f) {
        assertMainThread("removeObservers");
        Iterator it = this.mObservers.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (((C0050b) entry.getValue()).mo1444a(c0060f)) {
                removeObserver((C0066n) entry.getKey());
            }
        }
    }

    protected void setValue(T t) {
        assertMainThread("setValue");
        this.mVersion++;
        this.mData = t;
        dispatchingValue(null);
    }
}
