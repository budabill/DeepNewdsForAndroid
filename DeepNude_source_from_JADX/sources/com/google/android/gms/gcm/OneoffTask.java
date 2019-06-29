package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class OneoffTask extends Task {
    public static final Creator<OneoffTask> CREATOR = new zzf();
    private final long zzikh;
    private final long zziki;

    public static class Builder extends com.google.android.gms.gcm.Task.Builder {
        private long zzikj = -1;
        private long zzikk = -1;

        public OneoffTask build() {
            checkConditions();
            return new OneoffTask();
        }

        protected void checkConditions() {
            super.checkConditions();
            long j = this.zzikj;
            if (j != -1) {
                long j2 = this.zzikk;
                if (j2 != -1) {
                    if (j >= j2) {
                        throw new IllegalArgumentException("Window start must be shorter than window end.");
                    }
                    return;
                }
            }
            throw new IllegalArgumentException("Must specify an execution window using setExecutionWindow.");
        }

        public Builder setExecutionWindow(long j, long j2) {
            this.zzikj = j;
            this.zzikk = j2;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.extras = bundle;
            return this;
        }

        public Builder setPersisted(boolean z) {
            this.isPersisted = z;
            return this;
        }

        public Builder setRequiredNetwork(int i) {
            this.requiredNetworkState = i;
            return this;
        }

        public Builder setRequiresCharging(boolean z) {
            this.requiresCharging = z;
            return this;
        }

        public Builder setService(Class<? extends GcmTaskService> cls) {
            this.gcmTaskService = cls.getName();
            return this;
        }

        public Builder setTag(String str) {
            this.tag = str;
            return this;
        }

        public Builder setUpdateCurrent(boolean z) {
            this.updateCurrent = z;
            return this;
        }
    }

    @Deprecated
    private OneoffTask(Parcel parcel) {
        super(parcel);
        this.zzikh = parcel.readLong();
        this.zziki = parcel.readLong();
    }

    private OneoffTask(Builder builder) {
        super((com.google.android.gms.gcm.Task.Builder) builder);
        this.zzikh = builder.zzikj;
        this.zziki = builder.zzikk;
    }

    public long getWindowEnd() {
        return this.zziki;
    }

    public long getWindowStart() {
        return this.zzikh;
    }

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putLong("window_start", this.zzikh);
        bundle.putLong("window_end", this.zziki);
    }

    public String toString() {
        String obj = super.toString();
        long windowStart = getWindowStart();
        long windowEnd = getWindowEnd();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(obj).length() + 64);
        stringBuilder.append(obj);
        stringBuilder.append(" windowStart=");
        stringBuilder.append(windowStart);
        stringBuilder.append(" windowEnd=");
        stringBuilder.append(windowEnd);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.zzikh);
        parcel.writeLong(this.zziki);
    }
}
