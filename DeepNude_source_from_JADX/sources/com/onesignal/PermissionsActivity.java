package com.onesignal;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.onesignal.C0624b.C0621a;

public class PermissionsActivity extends Activity {
    /* renamed from: a */
    static boolean f1175a;
    /* renamed from: b */
    static boolean f1176b;
    /* renamed from: c */
    private static C0621a f1177c;

    /* renamed from: a */
    static void m1410a() {
        if (!f1175a) {
            if (!f1176b) {
                f1177c = new Ka();
                C0624b.m1498b(f1177c);
            }
        }
    }

    /* renamed from: b */
    private void m1411b() {
        if (VERSION.SDK_INT < 23) {
            finish();
            return;
        }
        if (!f1175a) {
            f1175a = true;
            C0627f.m1518a(this, new String[]{C0582B.f1088c}, 2);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null || !bundle.getBoolean("android:hasCurrentPermissionsRequest", false)) {
            m1411b();
        } else {
            f1175a = true;
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (sa.f1386l) {
            m1411b();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        f1176b = true;
        f1175a = false;
        if (i == 2) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                C0582B.m1282e();
            } else {
                C0582B.m1284g();
            }
        }
        C0624b.m1495a(f1177c);
        finish();
    }
}
