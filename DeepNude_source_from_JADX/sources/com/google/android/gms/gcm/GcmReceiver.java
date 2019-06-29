package com.google.android.gms.gcm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.iid.zzh;

public class GcmReceiver extends WakefulBroadcastReceiver {
    private static boolean zzijq = false;
    private static zzh zzijr;
    private static zzh zzijs;

    private final void doStartService(Context context, Intent intent) {
        String str;
        ComponentName startWakefulService;
        if (isOrderedBroadcast()) {
            setResultCode(500);
        }
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        String str2 = "GcmReceiver";
        if (resolveService != null) {
            ServiceInfo serviceInfo = resolveService.serviceInfo;
            if (serviceInfo != null) {
                String valueOf;
                if (context.getPackageName().equals(serviceInfo.packageName)) {
                    if (serviceInfo.name != null) {
                        str = serviceInfo.name;
                        if (str.startsWith(".")) {
                            valueOf = String.valueOf(context.getPackageName());
                            str = String.valueOf(str);
                            str = str.length() != 0 ? valueOf.concat(str) : new String(valueOf);
                        }
                        if (Log.isLoggable(str2, 3)) {
                            valueOf = "Restricting intent to a specific service: ";
                            String valueOf2 = String.valueOf(str);
                            Log.d(str2, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
                        }
                        intent.setClassName(context.getPackageName(), str);
                        if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                            startWakefulService = WakefulBroadcastReceiver.startWakefulService(context, intent);
                        } else {
                            startWakefulService = context.startService(intent);
                            Log.d(str2, "Missing wake lock permission, service start may be delayed");
                        }
                        if (startWakefulService != null) {
                            Log.e(str2, "Error while delivering the message: ServiceIntent not found.");
                            if (isOrderedBroadcast()) {
                                setResultCode(404);
                            }
                        } else if (isOrderedBroadcast()) {
                            setResultCode(-1);
                        }
                    }
                }
                valueOf = serviceInfo.packageName;
                str = serviceInfo.name;
                StringBuilder stringBuilder = new StringBuilder((String.valueOf(valueOf).length() + 94) + String.valueOf(str).length());
                stringBuilder.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
                stringBuilder.append(valueOf);
                stringBuilder.append("/");
                stringBuilder.append(str);
                str = stringBuilder.toString();
                Log.e(str2, str);
                if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                    startWakefulService = context.startService(intent);
                    Log.d(str2, "Missing wake lock permission, service start may be delayed");
                } else {
                    startWakefulService = WakefulBroadcastReceiver.startWakefulService(context, intent);
                }
                if (startWakefulService != null) {
                    Log.e(str2, "Error while delivering the message: ServiceIntent not found.");
                    if (isOrderedBroadcast()) {
                        setResultCode(404);
                    }
                } else if (isOrderedBroadcast()) {
                    setResultCode(-1);
                }
            }
        }
        str = "Failed to resolve target intent service, skipping classname enforcement";
        Log.e(str2, str);
        try {
            if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                startWakefulService = WakefulBroadcastReceiver.startWakefulService(context, intent);
            } else {
                startWakefulService = context.startService(intent);
                Log.d(str2, "Missing wake lock permission, service start may be delayed");
            }
            if (startWakefulService != null) {
                Log.e(str2, "Error while delivering the message: ServiceIntent not found.");
                if (isOrderedBroadcast()) {
                    setResultCode(404);
                }
            } else if (isOrderedBroadcast()) {
                setResultCode(-1);
            }
        } catch (Throwable e) {
            Log.e(str2, "Error while delivering the message to the serviceIntent", e);
            if (isOrderedBroadcast()) {
                setResultCode(401);
            }
        }
    }

    private final synchronized zzh zzaa(Context context, String str) {
        if ("com.google.android.c2dm.intent.RECEIVE".equals(str)) {
            if (zzijs == null) {
                zzijs = new zzh(context, str);
            }
            return zzijs;
        }
        if (zzijr == null) {
            zzijr = new zzh(context, str);
        }
        return zzijr;
    }

    public void onReceive(Context context, Intent intent) {
        String str = "GcmReceiver";
        if (Log.isLoggable(str, 3)) {
            Log.d(str, "received new intent");
        }
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        if (VERSION.SDK_INT <= 18) {
            intent.removeCategory(context.getPackageName());
        }
        if ("google.com/iid".equals(intent.getStringExtra("from"))) {
            intent.setAction("com.google.android.gms.iid.InstanceID");
        }
        str = "gcm.rawData64";
        String stringExtra = intent.getStringExtra(str);
        int i = 0;
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra(str);
        }
        if (zzs.isAtLeastO() && context.getApplicationInfo().targetSdkVersion > 25) {
            i = 1;
        }
        if (i != 0) {
            if (isOrderedBroadcast()) {
                setResultCode(-1);
            }
            zzaa(context, intent.getAction()).zza(intent, goAsync());
            return;
        }
        boolean equals = "com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction());
        doStartService(context, intent);
        if (isOrderedBroadcast() && getResultCode() == 0) {
            setResultCode(-1);
        }
    }
}
