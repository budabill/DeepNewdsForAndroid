package com.onesignal.shortcutbadger.impl;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.onesignal.p036a.C0617a;
import java.util.Collections;
import java.util.List;

public class ZukHomeBadger implements C0617a {
    /* renamed from: a */
    private final Uri f1856a = Uri.parse("content://com.android.badge/badge");

    /* renamed from: a */
    public List<String> mo1393a() {
        return Collections.singletonList("com.zui.launcher");
    }

    @TargetApi(11)
    /* renamed from: a */
    public void mo1394a(Context context, ComponentName componentName, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("app_badge_count", i);
        context.getContentResolver().call(this.f1856a, "setAppBadgeCount", null, bundle);
    }
}
