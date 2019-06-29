package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;

@Hide
public final class zzcfy implements FusedLocationProviderApi {
    public final PendingResult<Status> flushLocations(GoogleApiClient googleApiClient) {
        return googleApiClient.zze(new zzcgd(this, googleApiClient));
    }

    public final android.location.Location getLastLocation(com.google.android.gms.common.api.GoogleApiClient r1) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r0 = this;
        r1 = com.google.android.gms.location.LocationServices.zzi(r1);
        r1 = r1.getLastLocation();	 Catch:{ Exception -> 0x0009 }
        return r1;
    L_0x0009:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcfy.getLastLocation(com.google.android.gms.common.api.GoogleApiClient):android.location.Location");
    }

    public final com.google.android.gms.location.LocationAvailability getLocationAvailability(com.google.android.gms.common.api.GoogleApiClient r1) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r0 = this;
        r1 = com.google.android.gms.location.LocationServices.zzi(r1);
        r1 = r1.zzaxb();	 Catch:{ Exception -> 0x0009 }
        return r1;
    L_0x0009:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcfy.getLocationAvailability(com.google.android.gms.common.api.GoogleApiClient):com.google.android.gms.location.LocationAvailability");
    }

    public final PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.zze(new zzcgi(this, googleApiClient, pendingIntent));
    }

    public final PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, LocationCallback locationCallback) {
        return googleApiClient.zze(new zzcga(this, googleApiClient, locationCallback));
    }

    public final PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, LocationListener locationListener) {
        return googleApiClient.zze(new zzcgh(this, googleApiClient, locationListener));
    }

    public final PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, PendingIntent pendingIntent) {
        return googleApiClient.zze(new zzcgg(this, googleApiClient, locationRequest, pendingIntent));
    }

    public final PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        return googleApiClient.zze(new zzcgf(this, googleApiClient, locationRequest, locationCallback, looper));
    }

    public final PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener) {
        zzbq.checkNotNull(Looper.myLooper(), "Calling thread must be a prepared Looper thread.");
        return googleApiClient.zze(new zzcfz(this, googleApiClient, locationRequest, locationListener));
    }

    public final PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener, Looper looper) {
        return googleApiClient.zze(new zzcge(this, googleApiClient, locationRequest, locationListener, looper));
    }

    public final PendingResult<Status> setMockLocation(GoogleApiClient googleApiClient, Location location) {
        return googleApiClient.zze(new zzcgc(this, googleApiClient, location));
    }

    public final PendingResult<Status> setMockMode(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.zze(new zzcgb(this, googleApiClient, z));
    }
}
