package android.arch.lifecycle;

/* renamed from: android.arch.lifecycle.d */
public abstract class C0058d {

    /* renamed from: android.arch.lifecycle.d$a */
    public enum C0056a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY
    }

    /* renamed from: android.arch.lifecycle.d$b */
    public enum C0057b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        /* renamed from: a */
        public boolean m94a(C0057b c0057b) {
            return compareTo(c0057b) >= 0;
        }
    }

    /* renamed from: a */
    public abstract C0057b mo14a();

    /* renamed from: a */
    public abstract void mo15a(C0059e c0059e);

    /* renamed from: b */
    public abstract void mo16b(C0059e c0059e);
}
