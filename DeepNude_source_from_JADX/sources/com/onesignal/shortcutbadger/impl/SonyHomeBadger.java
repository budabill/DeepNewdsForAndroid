package com.onesignal.shortcutbadger.impl;

import android.content.AsyncQueryHandler;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import com.onesignal.p036a.C0617a;
import java.util.Arrays;
import java.util.List;

public class SonyHomeBadger implements C0617a {
    /* renamed from: a */
    private final Uri f1853a = Uri.parse("content://com.sonymobile.home.resourceprovider/badge");
    /* renamed from: b */
    private AsyncQueryHandler f1854b;

    /* renamed from: a */
    private ContentValues m2339a(int i, ComponentName componentName) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("badge_count", Integer.valueOf(i));
        contentValues.put("package_name", componentName.getPackageName());
        contentValues.put("activity_name", componentName.getClassName());
        return contentValues;
    }

    /* renamed from: a */
    private void m2340a(ContentValues contentValues) {
        this.f1854b.startInsert(0, null, this.f1853a, contentValues);
    }

    /* renamed from: a */
    private void m2341a(Context context, ContentValues contentValues) {
        context.getApplicationContext().getContentResolver().insert(this.f1853a, contentValues);
    }

    /* renamed from: a */
    private static boolean m2342a(Context context) {
        return context.getPackageManager().resolveContentProvider("com.sonymobile.home.resourceprovider", 0) != null;
    }

    /* renamed from: b */
    private static void m2343b(Context context, ComponentName componentName, int i) {
        Intent intent = new Intent("com.sonyericsson.home.action.UPDATE_BADGE");
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", componentName.getPackageName());
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", componentName.getClassName());
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", String.valueOf(i));
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", i > 0);
        context.sendBroadcast(intent);
    }

    /* renamed from: c */
    private void m2344c(Context context, ComponentName componentName, int i) {
        if (i >= 0) {
            ContentValues a = m2339a(i, componentName);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                if (this.f1854b == null) {
                    this.f1854b = new C0656b(this, context.getApplicationContext().getContentResolver());
                }
                m2340a(a);
            } else {
                m2341a(context, a);
            }
        }
    }

    /* renamed from: a */
    public List<String> mo1393a() {
        return Arrays.asList(new String[]{"com.sonyericsson.home", "com.sonymobile.home"});
    }

    /* renamed from: a */
    public void mo1394a(Context context, ComponentName componentName, int i) {
        if (m2342a(context)) {
            m2344c(context, componentName, i);
        } else {
            m2343b(context, componentName, i);
        }
    }
}
