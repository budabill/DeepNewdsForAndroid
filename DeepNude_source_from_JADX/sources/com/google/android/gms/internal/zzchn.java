package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.location.zzu;
import com.google.android.gms.location.zzv;
import com.google.android.gms.location.zzx;
import com.google.android.gms.location.zzy;

@Hide
public final class zzchn extends zzbgl {
    public static final Creator<zzchn> CREATOR = new zzcho();
    private PendingIntent zzekd;
    private int zzitp;
    private zzcgr zzits;
    private zzchl zziur;
    private zzx zzius;
    private zzu zziut;

    zzchn(int i, zzchl zzchl, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2, IBinder iBinder3) {
        this.zzitp = i;
        this.zziur = zzchl;
        zzcgr zzcgr = null;
        this.zzius = iBinder == null ? null : zzy.zzbf(iBinder);
        this.zzekd = pendingIntent;
        this.zziut = iBinder2 == null ? null : zzv.zzbe(iBinder2);
        if (iBinder3 != null) {
            if (iBinder3 != null) {
                IInterface queryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
                zzcgr = queryLocalInterface instanceof zzcgr ? (zzcgr) queryLocalInterface : new zzcgt(iBinder3);
            }
        }
        this.zzits = zzcgr;
    }

    public static zzchn zza(zzu zzu, zzcgr zzcgr) {
        return new zzchn(2, null, null, null, zzu.asBinder(), zzcgr != null ? zzcgr.asBinder() : null);
    }

    public static zzchn zza(zzx zzx, zzcgr zzcgr) {
        return new zzchn(2, null, zzx.asBinder(), null, null, zzcgr != null ? zzcgr.asBinder() : null);
    }

    @Hide
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.zzitp);
        zzbgo.zza(parcel, 2, this.zziur, i, false);
        IInterface iInterface = this.zzius;
        IBinder iBinder = null;
        zzbgo.zza(parcel, 3, iInterface == null ? null : iInterface.asBinder(), false);
        zzbgo.zza(parcel, 4, this.zzekd, i, false);
        iInterface = this.zziut;
        zzbgo.zza(parcel, 5, iInterface == null ? null : iInterface.asBinder(), false);
        iInterface = this.zzits;
        if (iInterface != null) {
            iBinder = iInterface.asBinder();
        }
        zzbgo.zza(parcel, 6, iBinder, false);
        zzbgo.zzai(parcel, zze);
    }
}
