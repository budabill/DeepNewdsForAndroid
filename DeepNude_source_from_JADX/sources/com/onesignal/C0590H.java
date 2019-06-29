package com.onesignal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/* renamed from: com.onesignal.H */
public class C0590H extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0591I.m1353a(this, getIntent());
        finish();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C0591I.m1353a(this, getIntent());
        finish();
    }
}
