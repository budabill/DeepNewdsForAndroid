package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

@Hide
final class zzh extends Handler {
    private /* synthetic */ zzd zzgfk;

    public zzh(zzd zzd, Looper looper) {
        this.zzgfk = zzd;
        super(looper);
    }

    private static void zza(Message message) {
        zzi zzi = (zzi) message.obj;
        zzi.zzamb();
        zzi.unregister();
    }

    private static boolean zzb(Message message) {
        int i = message.what;
        if (!(i == 2 || i == 1)) {
            if (i != 7) {
                return false;
            }
        }
        return true;
    }

    public final void handleMessage(Message message) {
        if (this.zzgfk.zzgfh.get() != message.arg1) {
            if (zzb(message)) {
                zza(message);
            }
            return;
        }
        int i = message.what;
        if ((i == 1 || i == 7 || i == 4 || i == 5) && !this.zzgfk.isConnecting()) {
            zza(message);
            return;
        }
        i = message.what;
        PendingIntent pendingIntent = null;
        ConnectionResult zzd;
        if (i == 4) {
            this.zzgfk.zzgff = new ConnectionResult(message.arg2);
            if (!this.zzgfk.zzalz() || this.zzgfk.zzgfg) {
                zzd = this.zzgfk.zzgff != null ? this.zzgfk.zzgff : new ConnectionResult(8);
                this.zzgfk.zzgew.zzf(zzd);
                this.zzgfk.onConnectionFailed(zzd);
                return;
            }
            this.zzgfk.zza(3, null);
        } else if (i == 5) {
            zzd = this.zzgfk.zzgff != null ? this.zzgfk.zzgff : new ConnectionResult(8);
            this.zzgfk.zzgew.zzf(zzd);
            this.zzgfk.onConnectionFailed(zzd);
        } else if (i == 3) {
            Object obj = message.obj;
            if (obj instanceof PendingIntent) {
                pendingIntent = (PendingIntent) obj;
            }
            ConnectionResult connectionResult = new ConnectionResult(message.arg2, pendingIntent);
            this.zzgfk.zzgew.zzf(connectionResult);
            this.zzgfk.onConnectionFailed(connectionResult);
        } else if (i == 6) {
            this.zzgfk.zza(5, null);
            if (this.zzgfk.zzgfb != null) {
                this.zzgfk.zzgfb.onConnectionSuspended(message.arg2);
            }
            this.zzgfk.onConnectionSuspended(message.arg2);
            this.zzgfk.zza(5, 1, null);
        } else if (i == 2 && !this.zzgfk.isConnected()) {
            zza(message);
        } else if (zzb(message)) {
            ((zzi) message.obj).zzamc();
        } else {
            int i2 = message.what;
            StringBuilder stringBuilder = new StringBuilder(45);
            stringBuilder.append("Don't know how to handle message: ");
            stringBuilder.append(i2);
            Log.wtf("GmsClient", stringBuilder.toString(), new Exception());
        }
    }
}
