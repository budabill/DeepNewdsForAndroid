package com.google.android.gms.gcm;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.iid.InstanceID;
import java.util.regex.Pattern;

public class GcmPubSub {
    private static GcmPubSub zzijn;
    private static final Pattern zzijp = Pattern.compile("/topics/[a-zA-Z0-9-_.~%]{1,900}");
    private InstanceID zzijo;

    private GcmPubSub(Context context) {
        this.zzijo = InstanceID.getInstance(context);
    }

    public static synchronized GcmPubSub getInstance(Context context) {
        GcmPubSub gcmPubSub;
        synchronized (GcmPubSub.class) {
            if (zzijn == null) {
                zzijn = new GcmPubSub(context);
            }
            gcmPubSub = zzijn;
        }
        return gcmPubSub;
    }

    public void subscribe(String str, String str2, Bundle bundle) {
        String str3;
        if (str != null) {
            if (!str.isEmpty()) {
                if (str2 != null) {
                    if (zzijp.matcher(str2).matches()) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putString("gcm.topic", str2);
                        this.zzijo.getToken(str, str2, bundle);
                        return;
                    }
                }
                str3 = "Invalid topic name: ";
                str2 = String.valueOf(str2);
                throw new IllegalArgumentException(str2.length() != 0 ? str3.concat(str2) : new String(str3));
            }
        }
        str3 = "Invalid appInstanceToken: ";
        str = String.valueOf(str);
        throw new IllegalArgumentException(str.length() != 0 ? str3.concat(str) : new String(str3));
    }

    public void unsubscribe(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", str2);
        this.zzijo.zza(str, str2, bundle);
    }
}
