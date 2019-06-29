package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import java.util.Arrays;
import java.util.Comparator;

public class DetectedActivity extends zzbgl {
    public static final Creator<DetectedActivity> CREATOR = new zzi();
    public static final int IN_VEHICLE = 0;
    public static final int ON_BICYCLE = 1;
    public static final int ON_FOOT = 2;
    public static final int RUNNING = 8;
    public static final int STILL = 3;
    public static final int TILTING = 5;
    public static final int UNKNOWN = 4;
    public static final int WALKING = 7;
    @Hide
    private static Comparator<DetectedActivity> zzirc = new zzh();
    @Hide
    private static int[] zzird = new int[]{9, 10};
    @Hide
    private static int[] zzire = new int[]{0, 1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 16, 17};
    @Hide
    private static int[] zzirf = new int[]{0, 1, 2, 3, 7, 8, 16, 17};
    private int zzhia;
    private int zzirg;

    public DetectedActivity(int i, int i2) {
        this.zzhia = i;
        this.zzirg = i2;
    }

    @Hide
    public static void zzei(int i) {
        Object obj = null;
        for (int i2 : zzirf) {
            if (i2 == i) {
                obj = 1;
            }
        }
        if (obj == null) {
            StringBuilder stringBuilder = new StringBuilder(81);
            stringBuilder.append(i);
            stringBuilder.append(" is not a valid DetectedActivity supported by Activity Transition API.");
            Log.w("DetectedActivity", stringBuilder.toString());
        }
    }

    @Hide
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (DetectedActivity.class == obj.getClass()) {
                DetectedActivity detectedActivity = (DetectedActivity) obj;
                return this.zzhia == detectedActivity.zzhia && this.zzirg == detectedActivity.zzirg;
            }
        }
    }

    public int getConfidence() {
        return this.zzirg;
    }

    public int getType() {
        int i = this.zzhia;
        return i > 17 ? 4 : i;
    }

    @Hide
    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzhia), Integer.valueOf(this.zzirg)});
    }

    public String toString() {
        int type = getType();
        String num = type != 0 ? type != 1 ? type != 2 ? type != 3 ? type != 4 ? type != 5 ? type != 7 ? type != 8 ? type != 16 ? type != 17 ? Integer.toString(type) : "IN_RAIL_VEHICLE" : "IN_ROAD_VEHICLE" : "RUNNING" : "WALKING" : "TILTING" : "UNKNOWN" : "STILL" : "ON_FOOT" : "ON_BICYCLE" : "IN_VEHICLE";
        int i = this.zzirg;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(num).length() + 48);
        stringBuilder.append("DetectedActivity [type=");
        stringBuilder.append(num);
        stringBuilder.append(", confidence=");
        stringBuilder.append(i);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        i = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.zzhia);
        zzbgo.zzc(parcel, 2, this.zzirg);
        zzbgo.zzai(parcel, i);
    }
}
