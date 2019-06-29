package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Parcelable;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.zzs;
import com.google.android.gms.iid.zzaa;
import java.util.Collections;
import java.util.Map;

public class GcmNetworkManager {
    public static final int RESULT_FAILURE = 2;
    public static final int RESULT_RESCHEDULE = 1;
    public static final int RESULT_SUCCESS = 0;
    private static GcmNetworkManager zziji;
    private Context mContext;
    private final PendingIntent zzekd;
    private final Map<String, Map<String, Boolean>> zzijj = new ArrayMap();

    private GcmNetworkManager(Context context) {
        this.mContext = context;
        this.zzekd = PendingIntent.getBroadcast(this.mContext, 0, new Intent().setPackage("com.google.example.invalidpackage"), 0);
    }

    public static GcmNetworkManager getInstance(Context context) {
        GcmNetworkManager gcmNetworkManager;
        synchronized (GcmNetworkManager.class) {
            if (zziji == null) {
                zziji = new GcmNetworkManager(context.getApplicationContext());
            }
            gcmNetworkManager = zziji;
        }
        return gcmNetworkManager;
    }

    private final Intent zzawe() {
        String zzdr = zzaa.zzdr(this.mContext);
        int zzdn = zzdr != null ? GoogleCloudMessaging.zzdn(this.mContext) : -1;
        if (zzdr != null) {
            if (zzdn >= 5000000) {
                Intent intent = new Intent("com.google.android.gms.gcm.ACTION_SCHEDULE");
                intent.setPackage(zzdr);
                intent.putExtra("app", this.zzekd);
                intent.putExtra("source", 4);
                intent.putExtra("source_version", zzs.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                return intent;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(91);
        stringBuilder.append("Google Play Services is not available, dropping GcmNetworkManager request. code=");
        stringBuilder.append(zzdn);
        Log.e("GcmNetworkManager", stringBuilder.toString());
        return null;
    }

    static void zzid(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must provide a valid tag.");
        } else if (100 < str.length()) {
            throw new IllegalArgumentException("Tag is larger than max permissible tag length (100)");
        }
    }

    private final boolean zzie(String str) {
        zzbq.checkNotNull(str, "GcmTaskService must not be null.");
        PackageManager packageManager = this.mContext.getPackageManager();
        Object emptyList;
        if (packageManager == null) {
            emptyList = Collections.emptyList();
        } else {
            String str2 = GcmTaskService.SERVICE_ACTION_EXECUTE_TASK;
            emptyList = packageManager.queryIntentServices(str != null ? new Intent(str2).setClassName(this.mContext, str) : new Intent(str2).setPackage(this.mContext.getPackageName()), 0);
        }
        if (r0 == null ? true : r0.isEmpty()) {
            Log.e("GcmNetworkManager", String.valueOf(str).concat(" is not available. This may cause the task to be lost."));
            return true;
        }
        for (ResolveInfo resolveInfo : r0) {
            ServiceInfo serviceInfo = resolveInfo.serviceInfo;
            if (serviceInfo != null && serviceInfo.enabled) {
                return true;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 118);
        stringBuilder.append("The GcmTaskService class you provided ");
        stringBuilder.append(str);
        stringBuilder.append(" does not seem to support receiving com.google.android.gms.gcm.ACTION_TASK_READY");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void cancelAllTasks(Class<? extends GcmTaskService> cls) {
        Parcelable componentName = new ComponentName(this.mContext, cls);
        zzie(componentName.getClassName());
        Intent zzawe = zzawe();
        if (zzawe != null) {
            zzawe.putExtra("scheduler_action", "CANCEL_ALL");
            zzawe.putExtra("component", componentName);
            this.mContext.sendBroadcast(zzawe);
        }
    }

    public void cancelTask(String str, Class<? extends GcmTaskService> cls) {
        Parcelable componentName = new ComponentName(this.mContext, cls);
        zzid(str);
        zzie(componentName.getClassName());
        Intent zzawe = zzawe();
        if (zzawe != null) {
            zzawe.putExtra("scheduler_action", "CANCEL_TASK");
            zzawe.putExtra("tag", str);
            zzawe.putExtra("component", componentName);
            this.mContext.sendBroadcast(zzawe);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void schedule(com.google.android.gms.gcm.Task r5) {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r5.getServiceName();	 Catch:{ all -> 0x004c }
        r4.zzie(r0);	 Catch:{ all -> 0x004c }
        r0 = r4.zzawe();	 Catch:{ all -> 0x004c }
        if (r0 != 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r4);
        return;
    L_0x0010:
        r1 = r0.getExtras();	 Catch:{ all -> 0x004c }
        r2 = "scheduler_action";
        r3 = "SCHEDULE_TASK";
        r1.putString(r2, r3);	 Catch:{ all -> 0x004c }
        r5.toBundle(r1);	 Catch:{ all -> 0x004c }
        r0.putExtras(r1);	 Catch:{ all -> 0x004c }
        r1 = r4.mContext;	 Catch:{ all -> 0x004c }
        r1.sendBroadcast(r0);	 Catch:{ all -> 0x004c }
        r0 = r4.zzijj;	 Catch:{ all -> 0x004c }
        r1 = r5.getServiceName();	 Catch:{ all -> 0x004c }
        r0 = r0.get(r1);	 Catch:{ all -> 0x004c }
        r0 = (java.util.Map) r0;	 Catch:{ all -> 0x004c }
        if (r0 == 0) goto L_0x004a;
    L_0x0034:
        r1 = r5.getTag();	 Catch:{ all -> 0x004c }
        r1 = r0.containsKey(r1);	 Catch:{ all -> 0x004c }
        if (r1 == 0) goto L_0x004a;
    L_0x003e:
        r5 = r5.getTag();	 Catch:{ all -> 0x004c }
        r1 = 1;
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ all -> 0x004c }
        r0.put(r5, r1);	 Catch:{ all -> 0x004c }
    L_0x004a:
        monitor-exit(r4);
        return;
    L_0x004c:
        r5 = move-exception;
        monitor-exit(r4);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.gcm.GcmNetworkManager.schedule(com.google.android.gms.gcm.Task):void");
    }

    @Hide
    final synchronized boolean zzaa(String str, String str2) {
        Map map = (Map) this.zzijj.get(str2);
        if (map == null) {
            map = new ArrayMap();
            this.zzijj.put(str2, map);
        }
        return map.put(str, Boolean.valueOf(false)) == null;
    }

    @Hide
    final synchronized void zzab(String str, String str2) {
        Map map = (Map) this.zzijj.get(str2);
        if (map != null) {
            if ((map.remove(str) != null ? 1 : null) != null && map.isEmpty()) {
                this.zzijj.remove(str2);
            }
        }
    }

    @Hide
    final synchronized boolean zzac(String str, String str2) {
        Map map = (Map) this.zzijj.get(str2);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Hide
    final synchronized boolean zzif(String str) {
        return this.zzijj.containsKey(str);
    }
}
