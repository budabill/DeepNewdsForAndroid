package io.gonative.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.Log;
import io.gonative.android.p038a.C0700a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;

/* renamed from: io.gonative.android.p */
public class C0723p {
    /* renamed from: a */
    private static final String f1627a = "io.gonative.android.p";
    /* renamed from: b */
    private static String f1628b;

    /* renamed from: a */
    private static String m1948a(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        byte[] bArr = new byte[((int) randomAccessFile.length())];
        randomAccessFile.readFully(bArr);
        randomAccessFile.close();
        return new String(bArr);
    }

    /* renamed from: a */
    public static Map<String, Object> m1949a(Context context) {
        Map hashMap = new HashMap();
        hashMap.put("platform", "android");
        Object obj = C0700a.m1851a(context).f1537i;
        if (obj == null) {
            obj = "";
        }
        hashMap.put("publicKey", obj);
        String str = C0700a.m1851a(context).f1538j;
        if (str != null) {
            hashMap.put("deviceRegKey", str);
        }
        str = context.getPackageName();
        hashMap.put("appId", str);
        PackageManager packageManager = context.getPackageManager();
        int i = 0;
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            hashMap.put("appVersion", packageInfo.versionName);
            hashMap.put("appVersionCode", Integer.valueOf(packageInfo.versionCode));
        } catch (Throwable e) {
            Log.e(f1627a, e.getMessage(), e);
        }
        if ((context.getApplicationInfo().flags & 2) != 0) {
            i = 1;
        }
        if (i != 0) {
            obj = "debug";
        } else {
            obj = packageManager.getInstallerPackageName(str);
            if (obj == null) {
                obj = "adhoc";
            } else {
                if (!obj.equals("com.android.vending")) {
                    if (!obj.equals("com.google.market")) {
                        if (obj.equals("com.amazon.venezia")) {
                            obj = "amazon";
                        }
                    }
                }
                obj = "playstore";
            }
        }
        hashMap.put("distribution", obj);
        hashMap.put("language", Locale.getDefault().getLanguage());
        hashMap.put("os", "Android");
        hashMap.put("osVersion", VERSION.RELEASE);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Build.MANUFACTURER);
        stringBuilder.append(" ");
        stringBuilder.append(Build.MODEL);
        hashMap.put("model", stringBuilder.toString());
        hashMap.put("hardware", Build.FINGERPRINT);
        hashMap.put("timeZone", TimeZone.getDefault().getID());
        obj = null;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                obj = telephonyManager.getNetworkOperatorName();
            }
        } catch (Throwable e2) {
            Log.e(f1627a, "Error getting carrier name", e2);
        }
        if (obj != null) {
            hashMap.put("carrierName", obj);
        }
        hashMap.put("installationId", C0723p.m1950b(context));
        return hashMap;
    }

    /* renamed from: b */
    public static synchronized String m1950b(Context context) {
        String str;
        synchronized (C0723p.class) {
            if (f1628b == null) {
                File file = new File(context.getFilesDir(), "INSTALLATION");
                try {
                    if (!file.exists()) {
                        C0723p.m1951b(file);
                    }
                    f1628b = C0723p.m1948a(file);
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
            str = f1628b;
        }
        return str;
    }

    /* renamed from: b */
    private static void m1951b(File file) {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(UUID.randomUUID().toString().getBytes());
        fileOutputStream.close();
    }
}
