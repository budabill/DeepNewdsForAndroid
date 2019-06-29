package com.facebook;

import android.util.Pair;
import com.facebook.C0330C.C0329a;
import com.facebook.GraphRequest.C0338b;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.facebook.y */
class C0561y implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ArrayList f1070a;
    /* renamed from: b */
    final /* synthetic */ C0330C f1071b;

    C0561y(ArrayList arrayList, C0330C c0330c) {
        this.f1070a = arrayList;
        this.f1071b = c0330c;
    }

    public void run() {
        Iterator it = this.f1070a.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((C0338b) pair.first).mo949a((C0331D) pair.second);
        }
        for (C0329a a : this.f1071b.m474g()) {
            a.mo953a(this.f1071b);
        }
    }
}
