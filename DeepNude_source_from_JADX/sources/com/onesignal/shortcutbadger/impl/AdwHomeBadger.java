package com.onesignal.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.onesignal.p036a.C0617a;
import com.onesignal.p036a.C0618b;
import com.onesignal.p036a.p037a.C0615a;
import java.util.Arrays;
import java.util.List;

public class AdwHomeBadger implements C0617a {
    /* renamed from: a */
    public List<String> mo1393a() {
        return Arrays.asList(new String[]{"org.adw.launcher", "org.adwfreak.launcher"});
    }

    /* renamed from: a */
    public void mo1394a(Context context, ComponentName componentName, int i) {
        Intent intent = new Intent("org.adw.launcher.counter.SEND");
        intent.putExtra("PNAME", componentName.getPackageName());
        intent.putExtra("CNAME", componentName.getClassName());
        intent.putExtra("COUNT", i);
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
