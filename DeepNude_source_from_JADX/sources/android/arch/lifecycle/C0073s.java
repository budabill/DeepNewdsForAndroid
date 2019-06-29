package android.arch.lifecycle;

import java.util.HashMap;

/* renamed from: android.arch.lifecycle.s */
public class C0073s {
    /* renamed from: a */
    private final HashMap<String, C0070q> f120a = new HashMap();

    /* renamed from: a */
    final C0070q m113a(String str) {
        return (C0070q) this.f120a.get(str);
    }

    /* renamed from: a */
    public final void m114a() {
        for (C0070q onCleared : this.f120a.values()) {
            onCleared.onCleared();
        }
        this.f120a.clear();
    }

    /* renamed from: a */
    final void m115a(String str, C0070q c0070q) {
        C0070q c0070q2 = (C0070q) this.f120a.put(str, c0070q);
        if (c0070q2 != null) {
            c0070q2.onCleared();
        }
    }
}
