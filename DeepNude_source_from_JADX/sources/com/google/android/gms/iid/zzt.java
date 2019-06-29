package com.google.android.gms.iid;

import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

final class zzt {
    final Messenger zzinb;
    final MessengerCompat zzinn;

    zzt(IBinder iBinder) {
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if ("android.os.IMessenger".equals(interfaceDescriptor)) {
            this.zzinb = new Messenger(iBinder);
            this.zzinn = null;
        } else if ("com.google.android.gms.iid.IMessengerCompat".equals(interfaceDescriptor)) {
            this.zzinn = new MessengerCompat(iBinder);
            this.zzinb = null;
        } else {
            String str = "Invalid interface descriptor: ";
            interfaceDescriptor = String.valueOf(interfaceDescriptor);
            Log.w("MessengerIpcClient", interfaceDescriptor.length() != 0 ? str.concat(interfaceDescriptor) : new String(str));
            throw new RemoteException();
        }
    }
}
