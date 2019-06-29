package com.facebook.p029a;

import com.facebook.internal.C0457C;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.facebook.a.q */
class C0420q implements Runnable {
    C0420q() {
    }

    public void run() {
        Set<String> hashSet = new HashSet();
        for (C0403b b : C0416n.m781e()) {
            hashSet.add(b.m749b());
        }
        for (String a : hashSet) {
            C0457C.m871a(a, true);
        }
    }
}
