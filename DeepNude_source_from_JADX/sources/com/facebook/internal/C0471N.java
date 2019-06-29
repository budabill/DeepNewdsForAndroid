package com.facebook.internal;

import java.util.EnumSet;
import java.util.Iterator;

/* renamed from: com.facebook.internal.N */
public enum C0471N {
    None(0),
    Enabled(1),
    RequireConfirm(2);
    
    /* renamed from: d */
    public static final EnumSet<C0471N> f837d = null;
    /* renamed from: f */
    private final long f839f;

    static {
        f837d = EnumSet.allOf(C0471N.class);
    }

    private C0471N(long j) {
        this.f839f = j;
    }

    /* renamed from: a */
    public static EnumSet<C0471N> m950a(long j) {
        EnumSet<C0471N> noneOf = EnumSet.noneOf(C0471N.class);
        Iterator it = f837d.iterator();
        while (it.hasNext()) {
            C0471N c0471n = (C0471N) it.next();
            if ((c0471n.m951a() & j) != 0) {
                noneOf.add(c0471n);
            }
        }
        return noneOf;
    }

    /* renamed from: a */
    public long m951a() {
        return this.f839f;
    }
}
