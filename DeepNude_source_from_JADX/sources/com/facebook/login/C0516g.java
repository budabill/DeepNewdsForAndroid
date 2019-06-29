package com.facebook.login;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.facebook.login.g */
class C0516g implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ DeviceAuthDialog f989a;

    C0516g(DeviceAuthDialog deviceAuthDialog) {
        this.f989a = deviceAuthDialog;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f989a.f1996i.setContentView(this.f989a.m2536b(false));
        DeviceAuthDialog deviceAuthDialog = this.f989a;
        deviceAuthDialog.m2535a(deviceAuthDialog.f1999l);
    }
}
