package com.onesignal.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.onesignal.p036a.C0617a;
import com.onesignal.p036a.C0618b;
import com.onesignal.p036a.p037a.C0615a;
import java.util.Arrays;
import java.util.List;

@Deprecated
public class LGHomeBadger implements C0617a {
    /* renamed from: a */
    public List<String> mo1393a() {
        return Arrays.asList(new String[]{"com.lge.launcher", "com.lge.launcher2"});
    }

    /* renamed from: a */
    public void mo1394a(Context context, ComponentName componentName, int i) {
        Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        intent.putExtra("badge_count", i);
        intent.putExtra("badge_count_package_name", componentName.getPackageName());
        intent.putExtra("badge_count_class_name", componentName.getClassName());
        if (C0615a.m1436a(context, intent)) {
            context.sendBroadcast(intent);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unable to resolve intent: ");
        stringBuilder.append(intent.toString());
        throw new C0618b(stringBuilder.toString());
    }
}
