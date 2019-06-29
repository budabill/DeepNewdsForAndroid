package com.onesignal;

import android.app.Activity;
import android.content.Intent;
import com.onesignal.C0624b.C0621a;

class Ka implements C0621a {
    Ka() {
    }

    /* renamed from: a */
    public void mo1362a(Activity activity) {
        if (!activity.getClass().equals(PermissionsActivity.class)) {
            Intent intent = new Intent(activity, PermissionsActivity.class);
            intent.setFlags(131072);
            activity.startActivity(intent);
        }
    }
}
