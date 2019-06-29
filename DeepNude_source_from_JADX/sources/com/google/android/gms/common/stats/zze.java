package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.zzk;
import java.util.List;

public final class zze {
    private static boolean zzgji = false;
    private static zze zzgki = new zze();
    private static Boolean zzgkj;

    public static void zza(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list) {
        zza(context, str, 8, str2, str3, str4, i2, list, 0);
    }

    public static void zza(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list, long j) {
        int i3 = i;
        List list2 = list;
        if (zzgkj == null) {
            zzgkj = Boolean.valueOf(false);
        }
        if (zzgkj.booleanValue()) {
            String str5 = "WakeLockTracker";
            String valueOf;
            if (TextUtils.isEmpty(str)) {
                String str6 = "missing wakeLock key. ";
                valueOf = String.valueOf(str);
                Log.e(str5, valueOf.length() != 0 ? str6.concat(valueOf) : new String(str6));
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (7 == i3 || 8 == i3 || 10 == i3 || 11 == i3) {
                String str7 = "com.google.android.gms";
                if (list2 != null && list.size() == 1 && str7.equals(list2.get(0))) {
                    list2 = null;
                }
                List list3 = list2;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                int zzcy = zzk.zzcy(context);
                valueOf = context.getPackageName();
                WakeLockEvent wakeLockEvent = r1;
                String str8 = str5;
                WakeLockEvent wakeLockEvent2 = new WakeLockEvent(currentTimeMillis, i, str2, i2, list3, str, elapsedRealtime, zzcy, str3, str7.equals(valueOf) ? null : valueOf, zzk.zzcz(context), j, str4);
                try {
                    context.startService(new Intent().setComponent(zzb.zzgjn).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", wakeLockEvent));
                } catch (Throwable e) {
                    Log.wtf(str8, e);
                }
            }
        }
    }

    public static zze zzanp() {
        return zzgki;
    }
}
