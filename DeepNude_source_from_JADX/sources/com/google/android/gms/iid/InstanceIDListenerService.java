package com.google.android.gms.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;

public class InstanceIDListenerService extends zzb {
    @Hide
    static void zza(Context context, zzaf zzaf) {
        zzaf.zzawz();
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.putExtra("CMD", "RST");
        intent.setClassName(context, "com.google.android.gms.gcm.GcmReceiver");
        context.sendBroadcast(intent);
    }

    @Hide
    public void handleIntent(Intent intent) {
        if ("com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
            Bundle bundle = null;
            String str = "subtype";
            String stringExtra = intent.getStringExtra(str);
            if (stringExtra != null) {
                bundle = new Bundle();
                bundle.putString(str, stringExtra);
            }
            InstanceID instance = InstanceID.getInstance(this, bundle);
            String stringExtra2 = intent.getStringExtra("CMD");
            String str2 = "InstanceID";
            if (Log.isLoggable(str2, 3)) {
                StringBuilder stringBuilder = new StringBuilder((String.valueOf(stringExtra).length() + 34) + String.valueOf(stringExtra2).length());
                stringBuilder.append("Service command. subtype:");
                stringBuilder.append(stringExtra);
                stringBuilder.append(" command:");
                stringBuilder.append(stringExtra2);
                Log.d(str2, stringBuilder.toString());
            }
            if ("RST".equals(stringExtra2)) {
                instance.zzawq();
            } else {
                if ("RST_FULL".equals(stringExtra2)) {
                    if (!InstanceID.zzawr().isEmpty()) {
                        InstanceID.zzawr().zzawz();
                    }
                } else if ("SYNC".equals(stringExtra2)) {
                    InstanceID.zzawr().zzih(String.valueOf(stringExtra).concat("|T|"));
                    onTokenRefresh();
                }
                return;
            }
            onTokenRefresh();
        }
    }

    public void onTokenRefresh() {
    }
}
