package com.onesignal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v4.app.NotificationCompat.Extender;
import java.util.List;

/* renamed from: com.onesignal.F */
public abstract class C0872F extends JobIntentService {

    /* renamed from: com.onesignal.F$a */
    public static class C0587a {
        /* renamed from: a */
        public Extender f1113a;
        /* renamed from: b */
        public Integer f1114b;
    }

    /* renamed from: a */
    static Intent m2228a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent().setAction("com.onesignal.NotificationExtender").setPackage(context.getPackageName());
        List queryIntentServices = packageManager.queryIntentServices(intent, 128);
        if (queryIntentServices.size() < 1) {
            return null;
        }
        intent.setComponent(new ComponentName(context, ((ResolveInfo) queryIntentServices.get(0)).serviceInfo.name));
        return intent;
    }
}
