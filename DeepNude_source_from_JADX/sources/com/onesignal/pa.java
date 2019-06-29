package com.onesignal;

import android.app.AlertDialog.Builder;
import android.content.Context;
import com.onesignal.sa.C0650i;

class pa implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0650i f1301a;
    /* renamed from: b */
    final /* synthetic */ String f1302b;

    pa(C0650i c0650i, String str) {
        this.f1301a = c0650i;
        this.f1302b = str;
    }

    public void run() {
        Context context = C0624b.f1259b;
        if (context != null) {
            new Builder(context).setTitle(this.f1301a.toString()).setMessage(this.f1302b).show();
        }
    }
}
