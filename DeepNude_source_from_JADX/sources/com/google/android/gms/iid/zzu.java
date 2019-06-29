package com.google.android.gms.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zzu<T> {
    final int what;
    final TaskCompletionSource<T> zzgyc = new TaskCompletionSource();
    final int zzino;
    final Bundle zzinp;

    zzu(int i, int i2, Bundle bundle) {
        this.zzino = i;
        this.what = i2;
        this.zzinp = bundle;
    }

    public String toString() {
        int i = this.what;
        int i2 = this.zzino;
        zzaww();
        StringBuilder stringBuilder = new StringBuilder(55);
        stringBuilder.append("Request { what=");
        stringBuilder.append(i);
        stringBuilder.append(" id=");
        stringBuilder.append(i2);
        stringBuilder.append(" oneWay=false}");
        return stringBuilder.toString();
    }

    abstract boolean zzaww();

    final void zzb(zzv zzv) {
        String str = "MessengerIpcClient";
        if (Log.isLoggable(str, 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(zzv);
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(valueOf).length() + 14) + String.valueOf(valueOf2).length());
            stringBuilder.append("Failing ");
            stringBuilder.append(valueOf);
            stringBuilder.append(" with ");
            stringBuilder.append(valueOf2);
            Log.d(str, stringBuilder.toString());
        }
        this.zzgyc.setException(zzv);
    }

    abstract void zzx(Bundle bundle);
}
