package com.onesignal;

import android.annotation.TargetApi;
import android.app.Activity;

@TargetApi(23)
/* renamed from: com.onesignal.g */
class C0628g {
    /* renamed from: a */
    static void m1519a(Activity activity, String[] strArr, int i) {
        if (activity instanceof C0630i) {
            ((C0630i) activity).validateRequestPermissionsRequestCode(i);
        }
        activity.requestPermissions(strArr, i);
    }
}
