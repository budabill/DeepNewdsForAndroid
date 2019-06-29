package p000a.p001a.p002a.p004b;

import java.util.HashMap;
import java.util.Map.Entry;
import p000a.p001a.p002a.p004b.C0006c.C0004c;

/* renamed from: a.a.a.b.a */
public class C0736a<K, V> extends C0006c<K, V> {
    /* renamed from: e */
    private HashMap<K, C0004c<K, V>> f1685e = new HashMap();

    /* renamed from: a */
    protected C0004c<K, V> mo4a(K k) {
        return (C0004c) this.f1685e.get(k);
    }

    /* renamed from: b */
    public V mo5b(K k, V v) {
        C0004c a = mo4a(k);
        if (a != null) {
            return a.f1b;
        }
        this.f1685e.put(k, m6a(k, v));
        return null;
    }

    /* renamed from: b */
    public Entry<K, V> m2013b(K k) {
        return contains(k) ? ((C0004c) this.f1685e.get(k)).f3d : null;
    }

    public boolean contains(K k) {
        return this.f1685e.containsKey(k);
    }

    public V remove(K k) {
        V remove = super.remove(k);
        this.f1685e.remove(k);
        return remove;
    }
}
