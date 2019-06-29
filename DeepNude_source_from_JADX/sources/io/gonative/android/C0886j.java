package io.gonative.android;

import android.webkit.PermissionRequest;
import io.gonative.android.MainActivity.C0678c;
import java.util.ArrayList;

/* renamed from: io.gonative.android.j */
class C0886j implements C0678c {
    /* renamed from: a */
    final /* synthetic */ PermissionRequest f1878a;
    /* renamed from: b */
    final /* synthetic */ C0718k f1879b;

    C0886j(C0718k c0718k, PermissionRequest permissionRequest) {
        this.f1879b = c0718k;
        this.f1878a = permissionRequest;
    }

    /* renamed from: a */
    public void mo1411a(String[] strArr, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] == 0) {
                Object obj;
                if (strArr[i].equals("android.permission.RECORD_AUDIO")) {
                    obj = "android.webkit.resource.AUDIO_CAPTURE";
                } else if (strArr[i].equals("android.permission.CAMERA")) {
                    obj = "android.webkit.resource.VIDEO_CAPTURE";
                }
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            this.f1878a.deny();
            return;
        }
        this.f1878a.grant((String[]) arrayList.toArray(new String[arrayList.size()]));
    }
}
