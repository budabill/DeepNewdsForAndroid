package com.google.android.gms.gcm;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.iid.zzb;
import java.util.Iterator;

public class GcmListenerService extends zzb {
    static void zzr(Bundle bundle) {
        Iterator it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str != null && str.startsWith("google.c.")) {
                it.remove();
            }
        }
    }

    @Hide
    public void handleIntent(Intent intent) {
        String str = "GcmListenerService";
        String str2;
        if ("com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            str2 = "message_type";
            String stringExtra = intent.getStringExtra(str2);
            String str3 = GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE;
            if (stringExtra == null) {
                stringExtra = str3;
            }
            int i = -1;
            Object obj = null;
            switch (stringExtra.hashCode()) {
                case -2062414158:
                    if (stringExtra.equals(GoogleCloudMessaging.MESSAGE_TYPE_DELETED)) {
                        i = 1;
                        break;
                    }
                    break;
                case 102161:
                    if (stringExtra.equals(str3)) {
                        i = 0;
                        break;
                    }
                    break;
                case 814694033:
                    if (stringExtra.equals(GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR)) {
                        i = 3;
                        break;
                    }
                    break;
                case 814800675:
                    if (stringExtra.equals(GoogleCloudMessaging.MESSAGE_TYPE_SEND_EVENT)) {
                        i = 2;
                        break;
                    }
                    break;
                default:
                    break;
            }
            if (i == 0) {
                Bundle extras = intent.getExtras();
                extras.remove(str2);
                extras.remove("android.support.content.wakelockid");
                if ("1".equals(zza.zzd(extras, "gcm.n.e")) || zza.zzd(extras, "gcm.n.icon") != null) {
                    obj = 1;
                }
                if (obj != null) {
                    if (zza.zzdm(this)) {
                        zza.zzs(extras);
                    } else {
                        zza.zzdl(this).zzt(extras);
                        return;
                    }
                }
                str2 = "from";
                str = extras.getString(str2);
                extras.remove(str2);
                zzr(extras);
                onMessageReceived(str, extras);
                return;
            } else if (i != 1) {
                str2 = "google.message_id";
                if (i == 2) {
                    onMessageSent(intent.getStringExtra(str2));
                    return;
                } else if (i != 3) {
                    String str4 = "Received message with unknown type: ";
                    str2 = String.valueOf(stringExtra);
                    Log.w(str, str2.length() != 0 ? str4.concat(str2) : new String(str4));
                    return;
                } else {
                    str2 = intent.getStringExtra(str2);
                    if (str2 == null) {
                        str2 = intent.getStringExtra("message_id");
                    }
                    onSendError(str2, intent.getStringExtra("error"));
                    return;
                }
            } else {
                onDeletedMessages();
                return;
            }
        }
        str2 = "Unknown intent action: ";
        str4 = String.valueOf(intent.getAction());
        Log.w(str, str4.length() != 0 ? str2.concat(str4) : new String(str2));
    }

    public void onDeletedMessages() {
    }

    public void onMessageReceived(String str, Bundle bundle) {
    }

    public void onMessageSent(String str) {
    }

    public void onSendError(String str, String str2) {
    }
}
