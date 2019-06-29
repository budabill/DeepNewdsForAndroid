package com.onesignal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;

/* renamed from: com.onesignal.q */
class C0638q implements OnCancelListener {
    /* renamed from: a */
    final /* synthetic */ Intent f1303a;
    /* renamed from: b */
    final /* synthetic */ C0639r f1304b;

    C0638q(C0639r c0639r, Intent intent) {
        this.f1304b = c0639r;
        this.f1303a = intent;
    }

    public void onCancel(DialogInterface dialogInterface) {
        C0591I.m1358b(this.f1304b.f1305a, this.f1303a);
    }
}
