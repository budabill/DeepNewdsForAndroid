package io.gonative.android;

import android.widget.Spinner;

/* renamed from: io.gonative.android.T */
class C0688T implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0691V f1471a;

    C0688T(C0691V c0691v) {
        this.f1471a = c0691v;
    }

    public void run() {
        Spinner c;
        int i;
        if (this.f1471a.f1479f < this.f1471a.f1477d.size()) {
            this.f1471a.f1481h.setSelection(this.f1471a.f1479f);
        }
        if (this.f1471a.f1476c == null || this.f1471a.f1476c.length() <= 0) {
            c = this.f1471a.f1481h;
            i = 8;
        } else {
            c = this.f1471a.f1481h;
            i = 0;
        }
        c.setVisibility(i);
        this.f1471a.m1826b().notifyDataSetChanged();
    }
}
