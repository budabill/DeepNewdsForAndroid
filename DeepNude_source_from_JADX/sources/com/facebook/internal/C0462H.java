package com.facebook.internal;

import com.facebook.internal.C0465I.C0463e;

/* renamed from: com.facebook.internal.H */
class C0462H implements Runnable {
    C0462H() {
    }

    public void run() {
        try {
            for (C0463e a : C0465I.f816b) {
                a.m903a(true);
            }
        } finally {
            C0465I.f819e.set(false);
        }
    }
}
