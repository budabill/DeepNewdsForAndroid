package io.gonative.android;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import io.gonative.android.C0713f.C0711c;

/* renamed from: io.gonative.android.g */
class C0716g implements OnCancelListener {
    /* renamed from: a */
    final /* synthetic */ C0711c f1603a;

    C0716g(C0711c c0711c) {
        this.f1603a = c0711c;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f1603a.cancel(true);
    }
}
