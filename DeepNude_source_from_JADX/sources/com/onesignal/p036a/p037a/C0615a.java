package com.onesignal.p036a.p037a;

import android.content.Context;
import android.content.Intent;
import java.util.List;

/* renamed from: com.onesignal.a.a.a */
public class C0615a {
    /* renamed from: a */
    public static boolean m1436a(Context context, Intent intent) {
        List queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        return queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0;
    }
}
