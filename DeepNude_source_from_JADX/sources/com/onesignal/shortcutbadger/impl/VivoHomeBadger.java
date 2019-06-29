package com.onesignal.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.onesignal.p036a.C0617a;
import java.util.Arrays;
import java.util.List;

public class VivoHomeBadger implements C0617a {
    /* renamed from: a */
    public List<String> mo1393a() {
        return Arrays.asList(new String[]{"com.vivo.launcher"});
    }

    /* renamed from: a */
    public void mo1394a(Context context, ComponentName componentName, int i) {
        Intent intent = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
        intent.putExtra("packageName", context.getPackageName());
        intent.putExtra("className", componentName.getClassName());
        intent.putExtra("notificationNum", i);
        context.sendBroadcast(intent);
    }
}
