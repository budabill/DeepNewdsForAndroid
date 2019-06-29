package com.onesignal.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.onesignal.p036a.C0617a;
import java.util.Arrays;
import java.util.List;

public class NovaHomeBadger implements C0617a {
    /* renamed from: a */
    public List<String> mo1393a() {
        return Arrays.asList(new String[]{"com.teslacoilsw.launcher"});
    }

    /* renamed from: a */
    public void mo1394a(Context context, ComponentName componentName, int i) {
        ContentValues contentValues = new ContentValues();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(componentName.getPackageName());
        stringBuilder.append("/");
        stringBuilder.append(componentName.getClassName());
        contentValues.put("tag", stringBuilder.toString());
        contentValues.put("count", Integer.valueOf(i));
        context.getContentResolver().insert(Uri.parse("content://com.teslacoilsw.notifier/unread_count"), contentValues);
    }
}
