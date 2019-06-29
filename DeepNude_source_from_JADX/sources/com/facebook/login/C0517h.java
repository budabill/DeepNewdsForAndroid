package com.facebook.login;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.internal.C0475Q.C0474b;
import java.util.Date;

/* renamed from: com.facebook.login.h */
class C0517h implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ String f990a;
    /* renamed from: b */
    final /* synthetic */ C0474b f991b;
    /* renamed from: c */
    final /* synthetic */ String f992c;
    /* renamed from: d */
    final /* synthetic */ Date f993d;
    /* renamed from: e */
    final /* synthetic */ Date f994e;
    /* renamed from: f */
    final /* synthetic */ DeviceAuthDialog f995f;

    C0517h(DeviceAuthDialog deviceAuthDialog, String str, C0474b c0474b, String str2, Date date, Date date2) {
        this.f995f = deviceAuthDialog;
        this.f990a = str;
        this.f991b = c0474b;
        this.f992c = str2;
        this.f993d = date;
        this.f994e = date2;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f995f.m2518a(this.f990a, this.f991b, this.f992c, this.f993d, this.f994e);
    }
}
