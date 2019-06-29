package com.onesignal;

import android.app.AlertDialog.Builder;
import android.content.Context;

/* renamed from: com.onesignal.w */
class C0660w implements Runnable {
    C0660w() {
    }

    public void run() {
        Context context = C0624b.f1259b;
        if (context == null) {
            return;
        }
        if (!sa.f1356H.f1318d) {
            CharSequence a = aa.m1444a(context, "onesignal_gms_missing_alert_text", "To receive push notifications please press 'Update' to enable 'Google Play services'.");
            CharSequence a2 = aa.m1444a(context, "onesignal_gms_missing_alert_button_update", "Update");
            CharSequence a3 = aa.m1444a(context, "onesignal_gms_missing_alert_button_skip", "Skip");
            new Builder(context).setMessage(a).setPositiveButton(a2, new C0659v(this, context)).setNegativeButton(a3, new C0658u(this)).setNeutralButton(aa.m1444a(context, "onesignal_gms_missing_alert_button_close", "Close"), null).create().show();
        }
    }
}
