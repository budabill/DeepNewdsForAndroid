package io.gonative.android;

import android.widget.Spinner;

/* renamed from: io.gonative.android.Z */
class C0697Z implements Runnable {
    /* renamed from: a */
    final /* synthetic */ aa f1497a;

    C0697Z(aa aaVar) {
        this.f1497a = aaVar;
    }

    public void run() {
        Spinner c;
        int i;
        if (this.f1497a.f1564d > -1) {
            this.f1497a.f1566f.setSelection(this.f1497a.f1564d);
        }
        if (this.f1497a.f1562b.size() > 0) {
            c = this.f1497a.f1566f;
            i = 0;
        } else {
            c = this.f1497a.f1566f;
            i = 8;
        }
        c.setVisibility(i);
        this.f1497a.f1565e.notifyDataSetChanged();
    }
}
