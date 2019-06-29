package com.onesignal.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import com.onesignal.p036a.C0617a;
import com.onesignal.p036a.p037a.C0616b;
import java.util.Arrays;
import java.util.List;

public class SamsungHomeBadger implements C0617a {
    /* renamed from: a */
    private static final String[] f1851a = new String[]{"_id", "class"};
    /* renamed from: b */
    private DefaultBadger f1852b;

    public SamsungHomeBadger() {
        if (VERSION.SDK_INT >= 21) {
            this.f1852b = new DefaultBadger();
        }
    }

    /* renamed from: a */
    private ContentValues m2336a(ComponentName componentName, int i, boolean z) {
        ContentValues contentValues = new ContentValues();
        if (z) {
            contentValues.put("package", componentName.getPackageName());
            contentValues.put("class", componentName.getClassName());
        }
        contentValues.put("badgecount", Integer.valueOf(i));
        return contentValues;
    }

    /* renamed from: a */
    public List<String> mo1393a() {
        return Arrays.asList(new String[]{"com.sec.android.app.launcher", "com.sec.android.app.twlauncher"});
    }

    /* renamed from: a */
    public void mo1394a(Context context, ComponentName componentName, int i) {
        DefaultBadger defaultBadger = this.f1852b;
        if (defaultBadger == null || !defaultBadger.m2317a(context)) {
            Uri parse = Uri.parse("content://com.sec.badge/apps?notify=true");
            ContentResolver contentResolver = context.getContentResolver();
            try {
                ContentResolver contentResolver2 = contentResolver;
                Uri uri = parse;
                Cursor query = contentResolver2.query(uri, f1851a, "package=?", new String[]{componentName.getPackageName()}, null);
                if (query != null) {
                    String className = componentName.getClassName();
                    Object obj = null;
                    while (query.moveToNext()) {
                        int i2 = query.getInt(0);
                        contentResolver.update(parse, m2336a(componentName, i, false), "_id=?", new String[]{String.valueOf(i2)});
                        if (className.equals(query.getString(query.getColumnIndex("class")))) {
                            obj = 1;
                        }
                    }
                    if (obj == null) {
                        contentResolver.insert(parse, m2336a(componentName, i, true));
                    }
                }
                C0616b.m1437a(query);
            } catch (Throwable th) {
                C0616b.m1437a(null);
            }
        } else {
            this.f1852b.mo1394a(context, componentName, i);
        }
    }
}
