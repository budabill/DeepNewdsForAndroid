package com.google.android.gms.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

final class zzac extends BroadcastReceiver {
    private /* synthetic */ zzaa zzioa;

    zzac(zzaa zzaa) {
        this.zzioa = zzaa;
    }

    public final void onReceive(Context context, Intent intent) {
        String str = "InstanceID/Rpc";
        if (Log.isLoggable(str, 3)) {
            Log.d(str, "Received GSF callback via dynamic receiver");
        }
        this.zzioa.zzj(intent);
    }
}
