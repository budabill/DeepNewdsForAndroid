package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import com.google.android.gms.internal.zzbgp;
import com.google.android.gms.internal.zzbgq;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ActivityRecognitionResult extends zzbgl implements ReflectedParcelable {
    public static final Creator<ActivityRecognitionResult> CREATOR = new zzb();
    private Bundle extras;
    private List<DetectedActivity> zziqs;
    private long zziqt;
    private long zziqu;
    private int zziqv;

    public ActivityRecognitionResult(DetectedActivity detectedActivity, long j, long j2) {
        this(detectedActivity, j, j2, 0, null);
    }

    @Hide
    private ActivityRecognitionResult(DetectedActivity detectedActivity, long j, long j2, int i, Bundle bundle) {
        this(Collections.singletonList(detectedActivity), j, j2, 0, null);
    }

    public ActivityRecognitionResult(List<DetectedActivity> list, long j, long j2) {
        this((List) list, j, j2, 0, null);
    }

    @Hide
    public ActivityRecognitionResult(List<DetectedActivity> list, long j, long j2, int i, Bundle bundle) {
        boolean z = true;
        boolean z2 = list != null && list.size() > 0;
        zzbq.checkArgument(z2, "Must have at least 1 detected activity");
        if (j <= 0 || j2 <= 0) {
            z = false;
        }
        zzbq.checkArgument(z, "Must set times");
        this.zziqs = list;
        this.zziqt = j;
        this.zziqu = j2;
        this.zziqv = i;
        this.extras = bundle;
    }

    public static ActivityRecognitionResult extractResult(Intent intent) {
        ActivityRecognitionResult activityRecognitionResult;
        List zzk;
        if (hasResult(intent)) {
            zzbgp zzbgp = intent.getExtras().get("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
            if (zzbgp instanceof byte[]) {
                zzbgp = zzbgq.zza((byte[]) zzbgp, CREATOR);
            } else if (zzbgp instanceof ActivityRecognitionResult) {
            }
            activityRecognitionResult = (ActivityRecognitionResult) zzbgp;
            if (activityRecognitionResult != null) {
                return activityRecognitionResult;
            }
            zzk = zzk(intent);
            if (zzk != null) {
                if (zzk.isEmpty()) {
                    return (ActivityRecognitionResult) zzk.get(zzk.size() - 1);
                }
            }
            return null;
        }
        activityRecognitionResult = null;
        if (activityRecognitionResult != null) {
            return activityRecognitionResult;
        }
        zzk = zzk(intent);
        if (zzk != null) {
            if (zzk.isEmpty()) {
                return (ActivityRecognitionResult) zzk.get(zzk.size() - 1);
            }
        }
        return null;
    }

    public static boolean hasResult(Intent intent) {
        if (intent == null) {
            return false;
        }
        if (intent == null ? false : intent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT")) {
            return true;
        }
        List zzk = zzk(intent);
        return (zzk == null || zzk.isEmpty()) ? false : true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @com.google.android.gms.common.internal.Hide
    private static boolean zzc(android.os.Bundle r5, android.os.Bundle r6) {
        /*
        r0 = 1;
        if (r5 != 0) goto L_0x0006;
    L_0x0003:
        if (r6 != 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        r1 = 0;
        if (r5 != 0) goto L_0x000b;
    L_0x0009:
        if (r6 != 0) goto L_0x000f;
    L_0x000b:
        if (r5 == 0) goto L_0x0010;
    L_0x000d:
        if (r6 != 0) goto L_0x0010;
    L_0x000f:
        return r1;
    L_0x0010:
        r2 = r5.size();
        r3 = r6.size();
        if (r2 == r3) goto L_0x001b;
    L_0x001a:
        return r1;
    L_0x001b:
        r2 = r5.keySet();
        r2 = r2.iterator();
    L_0x0023:
        r3 = r2.hasNext();
        if (r3 == 0) goto L_0x0069;
    L_0x0029:
        r3 = r2.next();
        r3 = (java.lang.String) r3;
        r4 = r6.containsKey(r3);
        if (r4 != 0) goto L_0x0036;
    L_0x0035:
        return r1;
    L_0x0036:
        r4 = r5.get(r3);
        if (r4 != 0) goto L_0x0043;
    L_0x003c:
        r3 = r6.get(r3);
        if (r3 == 0) goto L_0x0023;
    L_0x0042:
        return r1;
    L_0x0043:
        r4 = r5.get(r3);
        r4 = r4 instanceof android.os.Bundle;
        if (r4 == 0) goto L_0x005a;
    L_0x004b:
        r4 = r5.getBundle(r3);
        r3 = r6.getBundle(r3);
        r3 = zzc(r4, r3);
        if (r3 != 0) goto L_0x0023;
    L_0x0059:
        return r1;
    L_0x005a:
        r4 = r5.get(r3);
        r3 = r6.get(r3);
        r3 = r4.equals(r3);
        if (r3 != 0) goto L_0x0023;
    L_0x0068:
        return r1;
    L_0x0069:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.location.ActivityRecognitionResult.zzc(android.os.Bundle, android.os.Bundle):boolean");
    }

    @Hide
    private static List<ActivityRecognitionResult> zzk(Intent intent) {
        String str = "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT_LIST";
        return !(intent == null ? false : intent.hasExtra(str)) ? null : zzbgq.zzb(intent, str, CREATOR);
    }

    @Hide
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (ActivityRecognitionResult.class == obj.getClass()) {
                ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult) obj;
                return this.zziqt == activityRecognitionResult.zziqt && this.zziqu == activityRecognitionResult.zziqu && this.zziqv == activityRecognitionResult.zziqv && zzbg.equal(this.zziqs, activityRecognitionResult.zziqs) && zzc(this.extras, activityRecognitionResult.extras);
            }
        }
    }

    public int getActivityConfidence(int i) {
        for (DetectedActivity detectedActivity : this.zziqs) {
            if (detectedActivity.getType() == i) {
                return detectedActivity.getConfidence();
            }
        }
        return 0;
    }

    public long getElapsedRealtimeMillis() {
        return this.zziqu;
    }

    public DetectedActivity getMostProbableActivity() {
        return (DetectedActivity) this.zziqs.get(0);
    }

    public List<DetectedActivity> getProbableActivities() {
        return this.zziqs;
    }

    public long getTime() {
        return this.zziqt;
    }

    @Hide
    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zziqt), Long.valueOf(this.zziqu), Integer.valueOf(this.zziqv), this.zziqs, this.extras});
    }

    public String toString() {
        String valueOf = String.valueOf(this.zziqs);
        long j = this.zziqt;
        long j2 = this.zziqu;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 124);
        stringBuilder.append("ActivityRecognitionResult [probableActivities=");
        stringBuilder.append(valueOf);
        stringBuilder.append(", timeMillis=");
        stringBuilder.append(j);
        stringBuilder.append(", elapsedRealtimeMillis=");
        stringBuilder.append(j2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        i = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.zziqs, false);
        zzbgo.zza(parcel, 2, this.zziqt);
        zzbgo.zza(parcel, 3, this.zziqu);
        zzbgo.zzc(parcel, 4, this.zziqv);
        zzbgo.zza(parcel, 5, this.extras, false);
        zzbgo.zzai(parcel, i);
    }
}
