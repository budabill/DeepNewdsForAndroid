package com.onesignal;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.onesignal.r */
class C0639r implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Activity f1305a;
    /* renamed from: b */
    final /* synthetic */ JSONObject f1306b;
    /* renamed from: c */
    final /* synthetic */ int f1307c;

    C0639r(Activity activity, JSONObject jSONObject, int i) {
        this.f1305a = activity;
        this.f1306b = jSONObject;
        this.f1307c = i;
    }

    public void run() {
        Builder builder = new Builder(this.f1305a);
        builder.setTitle(C0641s.m1605e(this.f1306b));
        builder.setMessage(this.f1306b.optString("alert"));
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        C0641s.m1593b(this.f1305a, this.f1306b, arrayList, arrayList2);
        Intent a = C0641s.m1595c(this.f1307c);
        a.putExtra("action_button", true);
        a.putExtra("from_alert", true);
        a.putExtra("onesignal_data", this.f1306b.toString());
        String str = "grp";
        if (this.f1306b.has(str)) {
            a.putExtra(str, this.f1306b.optString(str));
        }
        OnClickListener c0637p = new C0637p(this, arrayList2, a);
        builder.setOnCancelListener(new C0638q(this, a));
        for (int i = 0; i < arrayList.size(); i++) {
            if (i == 0) {
                builder.setNeutralButton((CharSequence) arrayList.get(i), c0637p);
            } else if (i == 1) {
                builder.setNegativeButton((CharSequence) arrayList.get(i), c0637p);
            } else if (i == 2) {
                builder.setPositiveButton((CharSequence) arrayList.get(i), c0637p);
            }
        }
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(false);
        create.show();
    }
}
