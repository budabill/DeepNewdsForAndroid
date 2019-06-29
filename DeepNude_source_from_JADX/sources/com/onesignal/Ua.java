package com.onesignal;

import java.io.File;

class Ua {
    /* renamed from: a */
    static boolean m1415a() {
        for (String str : new String[]{"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"}) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("su");
            if (new File(stringBuilder.toString()).exists()) {
                return true;
            }
        }
        return false;
    }
}
