package com.onesignal.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.onesignal.p036a.C0617a;
import com.onesignal.p036a.C0618b;
import com.onesignal.p036a.p037a.C0615a;
import java.util.Arrays;
import java.util.List;

public class NewHtcHomeBadger implements C0617a {
    /* renamed from: a */
    public List<String> mo1393a() {
        return Arrays.asList(new String[]{"com.htc.launcher"});
    }

    /* renamed from: a */
    public void mo1394a(Context context, ComponentName componentName, int i) {
        Intent intent = new Intent("com.htc.launcher.action.SET_NOTIFICATION");
        intent.putExtra("com.htc.launcher.extra.COMPONENT", componentName.flattenToShortString());
        intent.putExtra("com.htc.launcher.extra.COUNT", i);
        Intent intent2 = new Intent("com.htc.launcher.action.UPDATE_SHORTCUT");
        intent2.putExtra("packagename", componentName.getPackageName());
        intent2.putExtra("count", i);
        if (!C0615a.m1436a(context, intent)) {
            if (!C0615a.m1436a(context, intent2)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unable to resolve intent: ");
                stringBuilder.append(intent2.toString());
                throw new C0618b(stringBuilder.toString());
            }
        }
        context.sendBroadcast(intent);
        context.sendBroadcast(intent2);
    }
}
