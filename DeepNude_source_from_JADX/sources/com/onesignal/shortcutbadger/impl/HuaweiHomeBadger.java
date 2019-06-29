package com.onesignal.shortcutbadger.impl;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.onesignal.p036a.C0617a;
import java.util.Arrays;
import java.util.List;

public class HuaweiHomeBadger implements C0617a {
    /* renamed from: a */
    public List<String> mo1393a() {
        return Arrays.asList(new String[]{"com.huawei.android.launcher"});
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void mo1394a(Context context, ComponentName componentName, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("package", context.getPackageName());
        bundle.putString("class", componentName.getClassName());
        bundle.putInt("badgenumber", i);
        context.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", null, bundle);
    }
}
