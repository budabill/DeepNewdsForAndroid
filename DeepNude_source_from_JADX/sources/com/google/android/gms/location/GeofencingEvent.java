package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import com.google.android.gms.internal.zzchp;
import java.util.ArrayList;
import java.util.List;

public class GeofencingEvent {
    private final int mErrorCode;
    private final int zzirw;
    private final List<Geofence> zzirx;
    private final Location zziry;

    private GeofencingEvent(int i, int i2, List<Geofence> list, Location location) {
        this.mErrorCode = i;
        this.zzirw = i2;
        this.zzirx = list;
        this.zziry = location;
    }

    public static GeofencingEvent fromIntent(Intent intent) {
        List list = null;
        if (intent == null) {
            return null;
        }
        int i = -1;
        int intExtra = intent.getIntExtra("gms_error_code", -1);
        int intExtra2 = intent.getIntExtra("com.google.android.location.intent.extra.transition", -1);
        if (intExtra2 != -1 && (intExtra2 == 1 || intExtra2 == 2 || intExtra2 == 4)) {
            i = intExtra2;
        }
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
        if (arrayList != null) {
            list = new ArrayList(arrayList.size());
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                list.add(zzchp.zzq((byte[]) obj));
            }
        }
        return new GeofencingEvent(intExtra, i, list, (Location) intent.getParcelableExtra("com.google.android.location.intent.extra.triggering_location"));
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public int getGeofenceTransition() {
        return this.zzirw;
    }

    public List<Geofence> getTriggeringGeofences() {
        return this.zzirx;
    }

    public Location getTriggeringLocation() {
        return this.zziry;
    }

    public boolean hasError() {
        return this.mErrorCode != -1;
    }
}
