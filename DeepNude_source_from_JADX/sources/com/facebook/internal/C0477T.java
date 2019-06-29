package com.facebook.internal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

/* renamed from: com.facebook.internal.T */
class C0477T implements OnCancelListener {
    /* renamed from: a */
    final /* synthetic */ C0485X f850a;

    C0477T(C0485X c0485x) {
        this.f850a = c0485x;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f850a.cancel();
    }
}
