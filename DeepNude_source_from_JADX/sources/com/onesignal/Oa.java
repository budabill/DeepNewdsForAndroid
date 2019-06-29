package com.onesignal;

class Oa implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f1168a;
    /* renamed from: b */
    final /* synthetic */ Pa f1169b;

    Oa(Pa pa, String str) {
        this.f1169b = pa;
        this.f1168a = str;
    }

    public void run() {
        int i = 0;
        while (i < Pa.f1828a && !this.f1169b.m2247a(this.f1168a, i)) {
            i++;
            aa.m1445a(Pa.f1829b * i);
        }
    }
}
