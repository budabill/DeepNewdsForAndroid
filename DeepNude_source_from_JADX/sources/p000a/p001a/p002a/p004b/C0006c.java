package p000a.p001a.p002a.p004b;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

/* renamed from: a.a.a.b.c */
public class C0006c<K, V> implements Iterable<Entry<K, V>> {
    /* renamed from: a */
    private C0004c<K, V> f4a;
    /* renamed from: b */
    private C0004c<K, V> f5b;
    /* renamed from: c */
    private WeakHashMap<C0005f<K, V>, Boolean> f6c = new WeakHashMap();
    /* renamed from: d */
    private int f7d = 0;

    /* renamed from: a.a.a.b.c$c */
    static class C0004c<K, V> implements Entry<K, V> {
        /* renamed from: a */
        final K f0a;
        /* renamed from: b */
        final V f1b;
        /* renamed from: c */
        C0004c<K, V> f2c;
        /* renamed from: d */
        C0004c<K, V> f3d;

        C0004c(K k, V v) {
            this.f0a = k;
            this.f1b = v;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0004c)) {
                return false;
            }
            C0004c c0004c = (C0004c) obj;
            if (!this.f0a.equals(c0004c.f0a) || !this.f1b.equals(c0004c.f1b)) {
                z = false;
            }
            return z;
        }

        public K getKey() {
            return this.f0a;
        }

        public V getValue() {
            return this.f1b;
        }

        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f0a);
            stringBuilder.append("=");
            stringBuilder.append(this.f1b);
            return stringBuilder.toString();
        }
    }

    /* renamed from: a.a.a.b.c$f */
    interface C0005f<K, V> {
        /* renamed from: a */
        void mo7a(C0004c<K, V> c0004c);
    }

    /* renamed from: a.a.a.b.c$d */
    private class C0737d implements Iterator<Entry<K, V>>, C0005f<K, V> {
        /* renamed from: a */
        private C0004c<K, V> f1686a;
        /* renamed from: b */
        private boolean f1687b;
        /* renamed from: c */
        final /* synthetic */ C0006c f1688c;

        private C0737d(C0006c c0006c) {
            this.f1688c = c0006c;
            this.f1687b = true;
        }

        /* renamed from: a */
        public void mo7a(C0004c<K, V> c0004c) {
            C0004c<K, V> c0004c2 = this.f1686a;
            if (c0004c == c0004c2) {
                this.f1686a = c0004c2.f3d;
                this.f1687b = this.f1686a == null;
            }
        }

        public boolean hasNext() {
            boolean z = true;
            if (this.f1687b) {
                if (this.f1688c.f4a == null) {
                    z = false;
                }
                return z;
            }
            C0004c c0004c = this.f1686a;
            if (c0004c == null || c0004c.f2c == null) {
                z = false;
            }
            return z;
        }

        public Entry<K, V> next() {
            C0004c a;
            if (this.f1687b) {
                this.f1687b = false;
                a = this.f1688c.f4a;
            } else {
                a = this.f1686a;
                a = a != null ? a.f2c : null;
            }
            this.f1686a = a;
            return this.f1686a;
        }
    }

    /* renamed from: a.a.a.b.c$e */
    private static abstract class C0738e<K, V> implements Iterator<Entry<K, V>>, C0005f<K, V> {
        /* renamed from: a */
        C0004c<K, V> f1689a;
        /* renamed from: b */
        C0004c<K, V> f1690b;

        C0738e(C0004c<K, V> c0004c, C0004c<K, V> c0004c2) {
            this.f1689a = c0004c2;
            this.f1690b = c0004c;
        }

        /* renamed from: a */
        private C0004c<K, V> m2015a() {
            C0004c c0004c = this.f1690b;
            C0004c c0004c2 = this.f1689a;
            if (c0004c != c0004c2) {
                if (c0004c2 != null) {
                    return mo1418c(c0004c);
                }
            }
            return null;
        }

        /* renamed from: a */
        public void mo7a(C0004c<K, V> c0004c) {
            if (this.f1689a == c0004c && c0004c == this.f1690b) {
                this.f1690b = null;
                this.f1689a = null;
            }
            C0004c<K, V> c0004c2 = this.f1689a;
            if (c0004c2 == c0004c) {
                this.f1689a = mo1417b(c0004c2);
            }
            if (this.f1690b == c0004c) {
                this.f1690b = m2015a();
            }
        }

        /* renamed from: b */
        abstract C0004c<K, V> mo1417b(C0004c<K, V> c0004c);

        /* renamed from: c */
        abstract C0004c<K, V> mo1418c(C0004c<K, V> c0004c);

        public boolean hasNext() {
            return this.f1690b != null;
        }

        public Entry<K, V> next() {
            Entry entry = this.f1690b;
            this.f1690b = m2015a();
            return entry;
        }
    }

    /* renamed from: a.a.a.b.c$a */
    static class C0888a<K, V> extends C0738e<K, V> {
        C0888a(C0004c<K, V> c0004c, C0004c<K, V> c0004c2) {
            super(c0004c, c0004c2);
        }

        /* renamed from: b */
        C0004c<K, V> mo1417b(C0004c<K, V> c0004c) {
            return c0004c.f3d;
        }

        /* renamed from: c */
        C0004c<K, V> mo1418c(C0004c<K, V> c0004c) {
            return c0004c.f2c;
        }
    }

    /* renamed from: a.a.a.b.c$b */
    private static class C0889b<K, V> extends C0738e<K, V> {
        C0889b(C0004c<K, V> c0004c, C0004c<K, V> c0004c2) {
            super(c0004c, c0004c2);
        }

        /* renamed from: b */
        C0004c<K, V> mo1417b(C0004c<K, V> c0004c) {
            return c0004c.f2c;
        }

        /* renamed from: c */
        C0004c<K, V> mo1418c(C0004c<K, V> c0004c) {
            return c0004c.f3d;
        }
    }

    /* renamed from: a */
    protected C0004c<K, V> mo4a(K k) {
        C0004c<K, V> c0004c = this.f4a;
        while (c0004c != null) {
            if (c0004c.f0a.equals(k)) {
                break;
            }
            c0004c = c0004c.f2c;
        }
        return c0004c;
    }

    /* renamed from: a */
    protected C0004c<K, V> m6a(K k, V v) {
        C0004c<K, V> c0004c = new C0004c(k, v);
        this.f7d++;
        C0004c c0004c2 = this.f5b;
        if (c0004c2 == null) {
            this.f4a = c0004c;
            this.f5b = this.f4a;
            return c0004c;
        }
        c0004c2.f2c = c0004c;
        c0004c.f3d = c0004c2;
        this.f5b = c0004c;
        return c0004c;
    }

    /* renamed from: a */
    public Entry<K, V> m7a() {
        return this.f4a;
    }

    /* renamed from: b */
    public C0737d m8b() {
        C0737d c0737d = new C0737d();
        this.f6c.put(c0737d, Boolean.valueOf(false));
        return c0737d;
    }

    /* renamed from: b */
    public V mo5b(K k, V v) {
        C0004c a = mo4a((Object) k);
        if (a != null) {
            return a.f1b;
        }
        m6a(k, v);
        return null;
    }

    /* renamed from: c */
    public Entry<K, V> m10c() {
        return this.f5b;
    }

    public Iterator<Entry<K, V>> descendingIterator() {
        Iterator c0889b = new C0889b(this.f5b, this.f4a);
        this.f6c.put(c0889b, Boolean.valueOf(false));
        return c0889b;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0006c)) {
            return false;
        }
        C0006c c0006c = (C0006c) obj;
        if (size() != c0006c.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = c0006c.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Entry entry = (Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        if (it.hasNext() || it2.hasNext()) {
            z = false;
        }
        return z;
    }

    public Iterator<Entry<K, V>> iterator() {
        Iterator c0888a = new C0888a(this.f4a, this.f5b);
        this.f6c.put(c0888a, Boolean.valueOf(false));
        return c0888a;
    }

    public V remove(K k) {
        C0004c a = mo4a((Object) k);
        if (a == null) {
            return null;
        }
        this.f7d--;
        if (!this.f6c.isEmpty()) {
            for (C0005f a2 : this.f6c.keySet()) {
                a2.mo7a(a);
            }
        }
        C0004c c0004c = a.f3d;
        if (c0004c != null) {
            c0004c.f2c = a.f2c;
        } else {
            this.f4a = a.f2c;
        }
        c0004c = a.f2c;
        if (c0004c != null) {
            c0004c.f3d = a.f3d;
        } else {
            this.f5b = a.f3d;
        }
        a.f2c = null;
        a.f3d = null;
        return a.f1b;
    }

    public int size() {
        return this.f7d;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            stringBuilder.append(((Entry) it.next()).toString());
            if (it.hasNext()) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
