package com.onesignal;

import com.onesignal.Ga.C0589a;
import java.util.ArrayList;

class _a extends C0589a {
    /* renamed from: a */
    final /* synthetic */ ArrayList f1833a;
    /* renamed from: b */
    final /* synthetic */ ab f1834b;

    _a(ab abVar, ArrayList arrayList) {
        this.f1834b = abVar;
        this.f1833a = arrayList;
    }

    /* renamed from: a */
    public void mo1370a(String str) {
        this.f1834b.f1251h.addAll(this.f1833a);
        String str2 = "GTPlayerPurchases";
        za.m1777b(str2, "purchaseTokens", this.f1834b.f1251h.toString());
        za.m1778b(str2, "ExistingPurchases", true);
        this.f1834b.f1252i = false;
        this.f1834b.f1253j = false;
    }
}
