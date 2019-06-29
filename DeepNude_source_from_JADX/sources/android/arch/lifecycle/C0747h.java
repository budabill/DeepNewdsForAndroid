package android.arch.lifecycle;

import android.arch.lifecycle.C0058d.C0056a;
import android.arch.lifecycle.C0058d.C0057b;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import p000a.p001a.p002a.p004b.C0736a;

/* renamed from: android.arch.lifecycle.h */
public class C0747h extends C0058d {
    /* renamed from: a */
    private C0736a<C0059e, C0062a> f1711a = new C0736a();
    /* renamed from: b */
    private C0057b f1712b;
    /* renamed from: c */
    private final WeakReference<C0060f> f1713c;
    /* renamed from: d */
    private int f1714d = 0;
    /* renamed from: e */
    private boolean f1715e = false;
    /* renamed from: f */
    private boolean f1716f = false;
    /* renamed from: g */
    private ArrayList<C0057b> f1717g = new ArrayList();

    /* renamed from: android.arch.lifecycle.h$a */
    static class C0062a {
        /* renamed from: a */
        C0057b f111a;
        /* renamed from: b */
        GenericLifecycleObserver f112b;

        C0062a(C0059e c0059e, C0057b c0057b) {
            this.f112b = C0063j.m99a((Object) c0059e);
            this.f111a = c0057b;
        }

        /* renamed from: a */
        void m98a(C0060f c0060f, C0056a c0056a) {
            C0057b a = C0747h.m2038a(c0056a);
            this.f111a = C0747h.m2039a(this.f111a, a);
            this.f112b.mo1442a(c0060f, c0056a);
            this.f111a = a;
        }
    }

    public C0747h(C0060f c0060f) {
        this.f1713c = new WeakReference(c0060f);
        this.f1712b = C0057b.INITIALIZED;
    }

    /* renamed from: a */
    static C0057b m2038a(C0056a c0056a) {
        switch (C0061g.f109a[c0056a.ordinal()]) {
            case 1:
            case 2:
                return C0057b.CREATED;
            case 3:
            case 4:
                return C0057b.STARTED;
            case 5:
                return C0057b.RESUMED;
            case 6:
                return C0057b.DESTROYED;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected event value ");
                stringBuilder.append(c0056a);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    static C0057b m2039a(C0057b c0057b, C0057b c0057b2) {
        return (c0057b2 == null || c0057b2.compareTo(c0057b) >= 0) ? c0057b : c0057b2;
    }

    /* renamed from: a */
    private void m2040a(C0060f c0060f) {
        Iterator descendingIterator = this.f1711a.descendingIterator();
        while (descendingIterator.hasNext() && !this.f1716f) {
            Entry entry = (Entry) descendingIterator.next();
            C0062a c0062a = (C0062a) entry.getValue();
            while (c0062a.f111a.compareTo(this.f1712b) > 0 && !this.f1716f && this.f1711a.contains(entry.getKey())) {
                C0056a b = C0747h.m2041b(c0062a.f111a);
                m2048d(C0747h.m2038a(b));
                c0062a.m98a(c0060f, b);
                m2045c();
            }
        }
    }

    /* renamed from: b */
    private static C0056a m2041b(C0057b c0057b) {
        int i = C0061g.f110b[c0057b.ordinal()];
        if (i == 1) {
            throw new IllegalArgumentException();
        } else if (i == 2) {
            return C0056a.ON_DESTROY;
        } else {
            if (i == 3) {
                return C0056a.ON_STOP;
            }
            if (i == 4) {
                return C0056a.ON_PAUSE;
            }
            if (i != 5) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected state value ");
                stringBuilder.append(c0057b);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: b */
    private void m2042b(C0060f c0060f) {
        Iterator b = this.f1711a.m8b();
        while (b.hasNext() && !this.f1716f) {
            Entry entry = (Entry) b.next();
            C0062a c0062a = (C0062a) entry.getValue();
            while (c0062a.f111a.compareTo(this.f1712b) < 0 && !this.f1716f && this.f1711a.contains(entry.getKey())) {
                m2048d(c0062a.f111a);
                c0062a.m98a(c0060f, C0747h.m2049e(c0062a.f111a));
                m2045c();
            }
        }
    }

    /* renamed from: b */
    private boolean m2043b() {
        boolean z = true;
        if (this.f1711a.size() == 0) {
            return true;
        }
        C0057b c0057b = ((C0062a) this.f1711a.m7a().getValue()).f111a;
        C0057b c0057b2 = ((C0062a) this.f1711a.m10c().getValue()).f111a;
        if (c0057b != c0057b2 || this.f1712b != c0057b2) {
            z = false;
        }
        return z;
    }

    /* renamed from: c */
    private C0057b m2044c(C0059e c0059e) {
        Entry b = this.f1711a.m2013b(c0059e);
        C0057b c0057b = null;
        C0057b c0057b2 = b != null ? ((C0062a) b.getValue()).f111a : null;
        if (!this.f1717g.isEmpty()) {
            ArrayList arrayList = this.f1717g;
            c0057b = (C0057b) arrayList.get(arrayList.size() - 1);
        }
        return C0747h.m2039a(C0747h.m2039a(this.f1712b, c0057b2), c0057b);
    }

    /* renamed from: c */
    private void m2045c() {
        ArrayList arrayList = this.f1717g;
        arrayList.remove(arrayList.size() - 1);
    }

    /* renamed from: c */
    private void m2046c(C0057b c0057b) {
        if (this.f1712b != c0057b) {
            this.f1712b = c0057b;
            if (!this.f1715e) {
                if (this.f1714d == 0) {
                    this.f1715e = true;
                    m2047d();
                    this.f1715e = false;
                    return;
                }
            }
            this.f1716f = true;
        }
    }

    /* renamed from: d */
    private void m2047d() {
        C0060f c0060f = (C0060f) this.f1713c.get();
        if (c0060f == null) {
            Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (!m2043b()) {
            this.f1716f = false;
            if (this.f1712b.compareTo(((C0062a) this.f1711a.m7a().getValue()).f111a) < 0) {
                m2040a(c0060f);
            }
            Entry c = this.f1711a.m10c();
            if (!(this.f1716f || c == null || this.f1712b.compareTo(((C0062a) c.getValue()).f111a) <= 0)) {
                m2042b(c0060f);
            }
        }
        this.f1716f = false;
    }

    /* renamed from: d */
    private void m2048d(C0057b c0057b) {
        this.f1717g.add(c0057b);
    }

    /* renamed from: e */
    private static C0056a m2049e(C0057b c0057b) {
        int i = C0061g.f110b[c0057b.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return C0056a.ON_START;
            }
            if (i == 3) {
                return C0056a.ON_RESUME;
            }
            if (i == 4) {
                throw new IllegalArgumentException();
            } else if (i != 5) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected state value ");
                stringBuilder.append(c0057b);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return C0056a.ON_CREATE;
    }

    /* renamed from: a */
    public C0057b mo14a() {
        return this.f1712b;
    }

    /* renamed from: a */
    public void m2051a(C0057b c0057b) {
        m2046c(c0057b);
    }

    /* renamed from: a */
    public void mo15a(C0059e c0059e) {
        C0057b c0057b = this.f1712b;
        C0057b c0057b2 = C0057b.DESTROYED;
        if (c0057b != c0057b2) {
            c0057b2 = C0057b.INITIALIZED;
        }
        C0062a c0062a = new C0062a(c0059e, c0057b2);
        if (((C0062a) this.f1711a.mo5b(c0059e, c0062a)) == null) {
            C0060f c0060f = (C0060f) this.f1713c.get();
            if (c0060f != null) {
                Object obj;
                Enum c;
                if (this.f1714d == 0) {
                    if (!this.f1715e) {
                        obj = null;
                        c = m2044c(c0059e);
                        this.f1714d++;
                        while (c0062a.f111a.compareTo(c) < 0 && this.f1711a.contains(c0059e)) {
                            m2048d(c0062a.f111a);
                            c0062a.m98a(c0060f, C0747h.m2049e(c0062a.f111a));
                            m2045c();
                            c = m2044c(c0059e);
                        }
                        if (obj == null) {
                            m2047d();
                        }
                        this.f1714d--;
                    }
                }
                obj = 1;
                c = m2044c(c0059e);
                this.f1714d++;
                while (c0062a.f111a.compareTo(c) < 0) {
                    m2048d(c0062a.f111a);
                    c0062a.m98a(c0060f, C0747h.m2049e(c0062a.f111a));
                    m2045c();
                    c = m2044c(c0059e);
                }
                if (obj == null) {
                    m2047d();
                }
                this.f1714d--;
            }
        }
    }

    /* renamed from: b */
    public void m2053b(C0056a c0056a) {
        m2046c(C0747h.m2038a(c0056a));
    }

    /* renamed from: b */
    public void mo16b(C0059e c0059e) {
        this.f1711a.remove(c0059e);
    }
}
