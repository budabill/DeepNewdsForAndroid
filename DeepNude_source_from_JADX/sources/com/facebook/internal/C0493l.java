package com.facebook.internal;

import com.facebook.C0560t;

/* renamed from: com.facebook.internal.l */
public enum C0493l {
    Login(0),
    Share(1),
    Message(2),
    Like(3),
    GameRequest(4),
    AppGroupCreate(5),
    AppGroupJoin(6),
    AppInvite(7),
    DeviceShare(8);
    
    /* renamed from: k */
    private final int f903k;

    private C0493l(int i) {
        this.f903k = i;
    }

    /* renamed from: a */
    public int m1081a() {
        return C0560t.m1255g() + this.f903k;
    }
}
