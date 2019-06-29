package com.google.android.gms.iid;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.ReflectedParcelable;

@Hide
public class MessengerCompat implements ReflectedParcelable {
    public static final Creator<MessengerCompat> CREATOR = new zzl();
    private Messenger zzinb;
    private zzi zzinc;

    public MessengerCompat(IBinder iBinder) {
        if (VERSION.SDK_INT >= 21) {
            this.zzinb = new Messenger(iBinder);
            return;
        }
        zzi zzi;
        if (iBinder == null) {
            zzi = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.iid.IMessengerCompat");
            zzi = queryLocalInterface instanceof zzi ? (zzi) queryLocalInterface : new zzk(iBinder);
        }
        this.zzinc = zzi;
    }

    private final IBinder getBinder() {
        Messenger messenger = this.zzinb;
        return messenger != null ? messenger.getBinder() : this.zzinc.asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(java.lang.Object r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r2 = this;
        r0 = 0;
        if (r3 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r2.getBinder();	 Catch:{ ClassCastException -> 0x0013 }
        r3 = (com.google.android.gms.iid.MessengerCompat) r3;	 Catch:{ ClassCastException -> 0x0013 }
        r3 = r3.getBinder();	 Catch:{ ClassCastException -> 0x0013 }
        r3 = r1.equals(r3);	 Catch:{ ClassCastException -> 0x0013 }
        return r3;
    L_0x0013:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.MessengerCompat.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        return getBinder().hashCode();
    }

    public final void send(Message message) {
        Messenger messenger = this.zzinb;
        if (messenger != null) {
            messenger.send(message);
        } else {
            this.zzinc.send(message);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        Messenger messenger = this.zzinb;
        parcel.writeStrongBinder(messenger != null ? messenger.getBinder() : this.zzinc.asBinder());
    }
}
