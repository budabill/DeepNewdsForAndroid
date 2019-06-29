package com.google.android.gms.iid;

import android.content.Intent;
import android.util.Log;

final class zze implements Runnable {
    private /* synthetic */ Intent val$intent;
    private /* synthetic */ zzd zziml;

    zze(zzd zzd, Intent intent) {
        this.zziml = zzd;
        this.val$intent = intent;
    }

    public final void run() {
        String action = this.val$intent.getAction();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(action).length() + 61);
        stringBuilder.append("Service took too long to process intent: ");
        stringBuilder.append(action);
        stringBuilder.append(" App may get closed.");
        Log.w("EnhancedIntentService", stringBuilder.toString());
        this.zziml.finish();
    }
}
