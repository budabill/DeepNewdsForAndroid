package com.facebook.p029a;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* renamed from: com.facebook.a.w */
class C0428w implements Serializable {
    private static final long serialVersionUID = 20160629001L;
    /* renamed from: a */
    private HashMap<C0403b, List<C0409f>> f733a = new HashMap();

    /* renamed from: com.facebook.a.w$a */
    static class C0427a implements Serializable {
        private static final long serialVersionUID = 20160629001L;
        /* renamed from: a */
        private final HashMap<C0403b, List<C0409f>> f732a;

        private C0427a(HashMap<C0403b, List<C0409f>> hashMap) {
            this.f732a = hashMap;
        }

        private Object readResolve() {
            return new C0428w(this.f732a);
        }
    }

    public C0428w(HashMap<C0403b, List<C0409f>> hashMap) {
        this.f733a.putAll(hashMap);
    }

    private Object writeReplace() {
        return new C0427a(this.f733a);
    }

    /* renamed from: a */
    public Set<C0403b> m811a() {
        return this.f733a.keySet();
    }

    /* renamed from: a */
    public void m812a(C0403b c0403b, List<C0409f> list) {
        if (this.f733a.containsKey(c0403b)) {
            ((List) this.f733a.get(c0403b)).addAll(list);
        } else {
            this.f733a.put(c0403b, list);
        }
    }

    /* renamed from: a */
    public boolean m813a(C0403b c0403b) {
        return this.f733a.containsKey(c0403b);
    }

    /* renamed from: b */
    public List<C0409f> m814b(C0403b c0403b) {
        return (List) this.f733a.get(c0403b);
    }
}
